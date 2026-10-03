/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.ftpserver.ftplet.Authentication
 *  org.apache.ftpserver.ftplet.AuthenticationFailedException
 *  org.apache.ftpserver.ftplet.FtpException
 *  org.apache.ftpserver.ftplet.User
 *  org.apache.ftpserver.usermanager.PasswordEncryptor
 *  org.apache.ftpserver.usermanager.UsernamePasswordAuthentication
 *  org.apache.ftpserver.usermanager.impl.AbstractUserManager
 *  org.apache.ftpserver.usermanager.impl.ConcurrentLoginPermission
 *  org.apache.ftpserver.usermanager.impl.TransferRatePermission
 *  org.apache.ftpserver.usermanager.impl.WritePermission
 */
package SA.IM.Ctrl;

import SA.IM.Ctrl.IMMTFtpUser;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.Channels;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import org.apache.commons.codec.binary.Base64;
import org.apache.ftpserver.ftplet.Authentication;
import org.apache.ftpserver.ftplet.AuthenticationFailedException;
import org.apache.ftpserver.ftplet.Authority;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.User;
import org.apache.ftpserver.usermanager.PasswordEncryptor;
import org.apache.ftpserver.usermanager.UsernamePasswordAuthentication;
import org.apache.ftpserver.usermanager.impl.AbstractUserManager;
import org.apache.ftpserver.usermanager.impl.ConcurrentLoginPermission;
import org.apache.ftpserver.usermanager.impl.TransferRatePermission;
import org.apache.ftpserver.usermanager.impl.WritePermission;

public class IMMTFtpUserManager
extends AbstractUserManager {
    protected String strFtpRootFolder = "";
    private final Path credentialsFile;
    private static final long UPLOAD_CREDENTIAL_LIFETIME_MILLIS = 60L * 60L * 1000L;
    private static final SecureRandom RANDOM = new SecureRandom();

    public IMMTFtpUserManager(String adminName, PasswordEncryptor passwordEncrypto) {
        this(adminName, passwordEncrypto, null);
    }

    private IMMTFtpUserManager(String adminName, PasswordEncryptor passwordEncrypto, Path credentialsFile) {
        super(adminName, passwordEncrypto);
        this.credentialsFile = credentialsFile;
    }

    // Supply -Dibiz.im.ftp.credentials.file=/path/to/credentials.properties (or the
    // IBIZ_IM_FTP_CREDENTIALS_FILE environment variable). Keys are file IDs;
    // values are PBKDF2WithHmacSHA256:iterations:base64(salt):base64(hash).
    public static IMMTFtpUserManager fromConfiguredCredentials() {
        String name = System.getProperty("ibiz.im.ftp.credentials.file");
        if (name == null || name.trim().isEmpty()) {
            name = System.getenv("IBIZ_IM_FTP_CREDENTIALS_FILE");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalStateException("FTP credentials file is not configured");
        }
        IMMTFtpUserManager manager = new IMMTFtpUserManager("", new Pbkdf2PasswordEncryptor(), Paths.get(name));
        try {
            manager.loadCredentials();
        } catch (FtpException e) {
            throw new IllegalStateException("FTP credentials file is unavailable or insecure", e);
        }
        return manager;
    }

    static IMMTFtpUserManager fromCredentialsFile(Path file) throws FtpException {
        IMMTFtpUserManager manager = new IMMTFtpUserManager("", new Pbkdf2PasswordEncryptor(), file);
        manager.loadCredentials();
        return manager;
    }

    public static String hashPassword(String password) {
        return new Pbkdf2PasswordEncryptor().encrypt(password);
    }

    public static String issueConfiguredUploadPassword(String fileId) throws FtpException {
        return fromConfiguredCredentials().issueUploadPassword(fileId);
    }

    public static void revokeConfiguredUploadPassword(String fileId) throws FtpException {
        fromConfiguredCredentials().revokeUploadPassword(fileId);
    }

    String issueUploadPassword(String fileId) throws FtpException {
        if (!isSafeName(fileId) || this.credentialsFile == null) {
            throw new FtpException("Invalid FTP upload file ID or credentials configuration");
        }
        byte[] bytes = new byte[32];
        RANDOM.nextBytes(bytes);
        String password = Base64.encodeBase64URLSafeString(bytes);
        final String encoded = hashPassword(password);
        final long expiresAt = System.currentTimeMillis() + UPLOAD_CREDENTIAL_LIFETIME_MILLIS;
        updateCredentials(fileId, encoded + "|" + expiresAt, false);
        return password;
    }

    void revokeUploadPassword(String fileId) throws FtpException {
        if (!isSafeName(fileId) || this.credentialsFile == null) {
            throw new FtpException("Invalid FTP upload file ID or credentials configuration");
        }
        updateCredentials(fileId, null, true);
    }

    public User authenticate(Authentication authentication) throws AuthenticationFailedException {
        if (authentication instanceof UsernamePasswordAuthentication) {
            UsernamePasswordAuthentication usernamePasswordAuthentication = (UsernamePasswordAuthentication)authentication;
            try {
                User user = this.getUserByName(usernamePasswordAuthentication.getUsername());
                String storedPassword = user == null ? null : user.getPassword();
                String suppliedPassword = usernamePasswordAuthentication.getPassword();
                if (user != null && user.getEnabled() && storedPassword != null && !storedPassword.isEmpty()
                        && suppliedPassword != null && !suppliedPassword.isEmpty()
                        && this.getPasswordEncryptor().matches(suppliedPassword, storedPassword)) {
                    return user;
                }
            }
            catch (FtpException e) {
                throw new AuthenticationFailedException("FTP user lookup failed", e);
            }
            catch (RuntimeException e) {
                throw new AuthenticationFailedException("Invalid FTP credentials", e);
            }
        }
        throw new AuthenticationFailedException("Invalid FTP credentials");
    }

    public void delete(String arg0) throws FtpException {
        throw new FtpException("FTP credentials are read-only");
    }

    public boolean doesExist(String arg0) throws FtpException {
        return this.getUserByName(arg0) != null;
    }

    public String[] getAllUserNames() throws FtpException {
        Properties users = this.loadCredentials();
        ArrayList<String> active = new ArrayList<String>();
        for (String name : users.stringPropertyNames()) {
            if (activeHash(users.getProperty(name)) != null) {
                active.add(name);
            }
        }
        return active.toArray(new String[active.size()]);
    }

    public User getUserByName(String name) throws FtpException {
        if (!isSafeName(name) || this.strFtpRootFolder.isEmpty()) {
            return null;
        }
        String storedPassword = activeHash(this.loadCredentials().getProperty(name));
        if (storedPassword == null) {
            return null;
        }
        File root = new File(this.strFtpRootFolder);
        File folder = new File(root, name);
        try {
            // Do not allow a file ID to alias another account's home directory.
            if (Files.isSymbolicLink(folder.toPath())
                    || !folder.getCanonicalFile().getParentFile().equals(root.getCanonicalFile())
                    || (folder.exists() && !folder.isDirectory())) {
                return null;
            }
        } catch (IOException e) {
            throw new FtpException("FTP home directory lookup failed", e);
        }
        IMMTFtpUser imMTFtpUser = new IMMTFtpUser();
        imMTFtpUser.setName(name);
        imMTFtpUser.setPassword(storedPassword);
        imMTFtpUser.setHomeDirectory(folder.getAbsolutePath() + File.separator);
        ArrayList<Authority> authorities = new ArrayList<Authority>();
        authorities.add(new ConcurrentLoginPermission(100, 10000));
        authorities.add(new TransferRatePermission(1000000, 1000000));
        authorities.add(new WritePermission());
        imMTFtpUser.setAuthorities(authorities);
        return imMTFtpUser;
    }

    public void save(User arg0) throws FtpException {
        throw new FtpException("FTP credentials are read-only");
    }

    public void setRootFolder(String strFtpRootFolder) {
        if (strFtpRootFolder == null || strFtpRootFolder.trim().isEmpty()) {
            throw new IllegalArgumentException("FTP root directory is not configured");
        }
        try {
            File root = new File(strFtpRootFolder).getCanonicalFile();
            if (!root.isDirectory()) {
                throw new IllegalArgumentException("FTP root directory does not exist");
            }
            this.strFtpRootFolder = root.getPath();
        } catch (IOException e) {
            throw new IllegalArgumentException("Invalid FTP root directory", e);
        }
    }

    public String getRootFolder() {
        return this.strFtpRootFolder;
    }

    private static boolean isSafeName(String name) {
        return name != null && name.length() > 0 && name.length() <= 128
                && name.matches("[A-Za-z0-9_-]+");
    }

    private static String activeHash(String value) {
        if (value == null) {
            return null;
        }
        int separator = value.indexOf('|');
        if (separator < 0) {
            return value;
        }
        long expiration = Long.parseLong(value.substring(separator + 1));
        return System.currentTimeMillis() < expiration ? value.substring(0, separator) : null;
    }

    private static boolean isValidCredential(String value) {
        if (value == null) {
            return false;
        }
        int separator = value.indexOf('|');
        if (separator < 0) {
            return Pbkdf2PasswordEncryptor.isValid(value);
        }
        try {
            long expiration = Long.parseLong(value.substring(separator + 1));
            return expiration > 0 && Pbkdf2PasswordEncryptor.isValid(value.substring(0, separator));
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void updateCredentials(String fileId, String value, boolean revoke) throws FtpException {
        synchronized (IMMTFtpUserManager.class) {
            updateCredentialsLocked(fileId, value, revoke);
        }
    }

    private void updateCredentialsLocked(String fileId, String value, boolean revoke) throws FtpException {
        Path path = this.credentialsFile.toAbsolutePath().normalize();
        Path parent = path.getParent();
        Path lockPath = parent.resolve(path.getFileName().toString() + ".lock");
        Path temporary = null;
        try {
            if (!Files.isDirectory(parent, LinkOption.NOFOLLOW_LINKS)) {
                throw new FtpException("FTP credentials parent is not a directory");
            }
            ensurePrivateDirectory(parent);
            try {
                Files.createFile(lockPath, PosixFilePermissions.asFileAttribute(
                        PosixFilePermissions.fromString("rw-------")));
            } catch (FileAlreadyExistsException ignored) {
                // Reuse the stable lock inode across writers and processes.
            }
            checkPrivateFile(lockPath);
            FileChannel channel = FileChannel.open(lockPath, StandardOpenOption.WRITE, LinkOption.NOFOLLOW_LINKS);
            try {
                FileLock lock = channel.lock();
                try {
                    Properties users = loadCredentials();
                    String previous = users.getProperty(fileId);
                    if (!revoke && previous != null) {
                        throw new FtpException("FTP file ID already has credentials");
                    }
                    if (revoke && (previous == null || previous.indexOf('|') < 0)) {
                        return;
                    }
                    if (revoke) {
                        users.remove(fileId);
                    } else {
                        users.setProperty(fileId, value);
                    }
                    for (String name : new HashSet<String>(users.stringPropertyNames())) {
                        String stored = users.getProperty(name);
                        if (stored.indexOf('|') >= 0 && activeHash(stored) == null) {
                            users.remove(name);
                        }
                    }
                    temporary = Files.createTempFile(parent, ".im-ftp-", ".tmp",
                            PosixFilePermissions.asFileAttribute(PosixFilePermissions.fromString("rw-------")));
                    FileChannel output = FileChannel.open(temporary, StandardOpenOption.WRITE, LinkOption.NOFOLLOW_LINKS);
                    try {
                        OutputStream out = Channels.newOutputStream(output);
                        users.store(out, null);
                        out.flush();
                        output.force(true);
                    } finally {
                        output.close();
                    }
                    if (Files.size(temporary) > 1048576L) {
                        throw new FtpException("FTP credentials file is too large");
                    }
                    try {
                        Files.move(temporary, path, StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
                    } catch (AtomicMoveNotSupportedException e) {
                        throw new FtpException("Atomic FTP credentials update is unavailable", e);
                    }
                    temporary = null;
                } finally {
                    lock.release();
                }
            } finally {
                channel.close();
            }
        } catch (IOException e) {
            throw new FtpException("FTP credentials update failed", e);
        } finally {
            if (temporary != null) {
                try {
                    Files.deleteIfExists(temporary);
                } catch (IOException ignored) {
                    // The upload credential was never published.
                }
            }
        }
    }

    private static void ensurePrivateDirectory(Path parent) throws IOException, FtpException {
        try {
            Set<PosixFilePermission> permissions = Files.getPosixFilePermissions(parent, LinkOption.NOFOLLOW_LINKS);
            if (permissions.contains(PosixFilePermission.GROUP_WRITE)
                    || permissions.contains(PosixFilePermission.OTHERS_WRITE)) {
                throw new FtpException("FTP credentials parent directory is writable by another user");
            }
        } catch (UnsupportedOperationException ignored) {
            // Non-POSIX platforms control directory access through ACLs.
        }
    }

    private static void checkPrivateFile(Path path) throws IOException, FtpException {
        if (!Files.isRegularFile(path, LinkOption.NOFOLLOW_LINKS)) {
            throw new FtpException("FTP credentials lock is not a regular file");
        }
        try {
            Set<PosixFilePermission> permissions = Files.getPosixFilePermissions(path, LinkOption.NOFOLLOW_LINKS);
            if (permissions.contains(PosixFilePermission.GROUP_WRITE)
                    || permissions.contains(PosixFilePermission.OTHERS_WRITE)) {
                throw new FtpException("FTP credentials lock permissions are too broad");
            }
        } catch (UnsupportedOperationException ignored) {
            // Non-POSIX platforms control file access through ACLs.
        }
    }

    private Properties loadCredentials() throws FtpException {
        Properties users = new Properties();
        if (this.credentialsFile == null) {
            return users;
        }
        try {
            if (!Files.isRegularFile(this.credentialsFile, LinkOption.NOFOLLOW_LINKS)
                    || Files.size(this.credentialsFile) > 1048576L) {
                throw new FtpException("FTP credentials file is not a regular file or is too large");
            }
            try {
                Set<PosixFilePermission> permissions = Files.getPosixFilePermissions(this.credentialsFile);
                if (permissions.contains(PosixFilePermission.OTHERS_READ)
                        || permissions.contains(PosixFilePermission.OTHERS_WRITE)
                        || permissions.contains(PosixFilePermission.GROUP_WRITE)) {
                    throw new FtpException("FTP credentials file permissions are too broad");
                }
            } catch (UnsupportedOperationException ignored) {
                // Non-POSIX platforms control file access through their own ACLs.
            }
            InputStream in = Files.newInputStream(this.credentialsFile, LinkOption.NOFOLLOW_LINKS);
            try {
                users.load(in);
            } finally {
                in.close();
            }
            for (String name : users.stringPropertyNames()) {
                if (!isSafeName(name) || !isValidCredential(users.getProperty(name))) {
                    throw new FtpException("FTP credentials file contains an invalid user or hash");
                }
            }
        } catch (IOException e) {
            throw new FtpException("FTP credentials file cannot be read", e);
        }
        return users;
    }

    private static final class Pbkdf2PasswordEncryptor implements PasswordEncryptor {
        private static final String ALGORITHM = "PBKDF2WithHmacSHA256";

        public String encrypt(String password) {
            if (password == null || password.isEmpty()) {
                throw new IllegalArgumentException("FTP password must not be empty");
            }
            byte[] salt = new byte[16];
            new SecureRandom().nextBytes(salt);
            PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 210000, 256);
            try {
                byte[] hash = SecretKeyFactory.getInstance(ALGORITHM).generateSecret(spec).getEncoded();
                return ALGORITHM + ":210000:" + Base64.encodeBase64String(salt)
                        + ":" + Base64.encodeBase64String(hash);
            } catch (GeneralSecurityException e) {
                throw new IllegalStateException("FTP password hashing is unavailable", e);
            } finally {
                spec.clearPassword();
            }
        }

        static boolean isValid(String encoded) {
            if (encoded == null) {
                return false;
            }
            String[] parts = encoded.split(":", -1);
            if (parts.length != 4 || !ALGORITHM.equals(parts[0])) {
                return false;
            }
            try {
                int iterations = Integer.parseInt(parts[1]);
                byte[] salt = Base64.decodeBase64(parts[2]);
                byte[] hash = Base64.decodeBase64(parts[3]);
                return iterations >= 210000 && iterations <= 1000000
                        && salt.length >= 16 && hash.length >= 32 && hash.length <= 64
                        && Base64.isBase64(parts[2]) && Base64.isBase64(parts[3]);
            } catch (NumberFormatException e) {
                return false;
            }
        }

        public boolean matches(String password, String encoded) {
            if (password == null || password.isEmpty() || !isValid(encoded)) {
                return false;
            }
            String[] parts = encoded.split(":", -1);
            byte[] expected = Base64.decodeBase64(parts[3]);
            PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), Base64.decodeBase64(parts[2]),
                    Integer.parseInt(parts[1]), expected.length * 8);
            try {
                byte[] actual = SecretKeyFactory.getInstance(ALGORITHM).generateSecret(spec).getEncoded();
                return MessageDigest.isEqual(actual, expected);
            } catch (GeneralSecurityException e) {
                return false;
            } finally {
                spec.clearPassword();
            }
        }
    }
}
