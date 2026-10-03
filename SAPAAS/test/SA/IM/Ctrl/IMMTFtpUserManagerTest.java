package SA.IM.Ctrl;

import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import junit.framework.TestCase;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.ftplet.Authentication;
import org.apache.ftpserver.ftplet.AuthenticationFailedException;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.User;
import org.apache.ftpserver.listener.ListenerFactory;
import org.apache.ftpserver.usermanager.ClearTextPasswordEncryptor;
import org.apache.ftpserver.usermanager.Md5PasswordEncryptor;
import org.apache.ftpserver.usermanager.PasswordEncryptor;
import org.apache.ftpserver.usermanager.UsernamePasswordAuthentication;
import org.apache.ftpserver.usermanager.impl.BaseUser;

public class IMMTFtpUserManagerTest extends TestCase {
    private final TestUserManager manager = new TestUserManager();

    public void testConfiguredPasswordMatches() throws Exception {
        manager.user = user("alice", "secret", true);
        assertSame(manager.user, manager.authenticate(login("alice", "secret")));
    }

    public void testEncryptedPasswordMatches() throws Exception {
        PasswordEncryptor encryptor = new Md5PasswordEncryptor();
        TestUserManager encryptedManager = new TestUserManager(encryptor);
        encryptedManager.user = user("alice", encryptor.encrypt("secret"), true);
        assertSame(encryptedManager.user, encryptedManager.authenticate(login("alice", "secret")));
    }

    public void testWrongPasswordIsRejected() throws Exception {
        manager.user = user("alice", "secret", true);
        assertRejected(login("alice", "wrong"));
    }

    public void testEmptyStoredPasswordIsRejected() throws Exception {
        manager.user = user("alice", "", true);
        assertRejected(login("alice", ""));
    }

    public void testMissingStoredPasswordIsRejected() throws Exception {
        manager.user = user("alice", null, true);
        assertRejected(login("alice", "secret"));
    }

    public void testEmptySubmittedPasswordIsRejected() throws Exception {
        manager.user = user("alice", "secret", true);
        assertRejected(login("alice", ""));
        assertRejected(login("alice", null));
    }

    public void testDisabledUserIsRejected() throws Exception {
        manager.user = user("alice", "secret", false);
        assertRejected(login("alice", "secret"));
    }

    public void testUnconfiguredUserIsRejected() throws Exception {
        assertRejected(login("alice", "secret"));
    }

    public void testSynthesizedUserWithEmptyPasswordIsRejected() throws Exception {
        IMMTFtpUserManager unconfigured = new IMMTFtpUserManager("", new ClearTextPasswordEncryptor());
        try {
            unconfigured.authenticate(login("alice", ""));
            fail("Synthesized users must not authenticate with an empty password");
        } catch (AuthenticationFailedException expected) {
            // No credentials were provisioned.
        }
    }

    public void testUnsupportedAuthenticationIsRejected() throws Exception {
        assertRejected(new Authentication() { });
    }

    public void testLookupFailureIsRejected() throws Exception {
        manager.failLookup = true;
        assertRejected(login("alice", "secret"));
    }

    public void testProvisionedFileIdAndPasswordRotation() throws Exception {
        Path temp = Files.createTempDirectory("im-ftp-test");
        Path root = Files.createDirectory(temp.resolve("ftp"));
        Path credentials = temp.resolve("credentials.properties");
        try {
            writeCredentials(credentials, "FILE-ID_1", "first-secret");
            IMMTFtpUserManager configured = IMMTFtpUserManager.fromCredentialsFile(credentials);
            configured.setRootFolder(root.toString());
            User user = configured.authenticate(login("FILE-ID_1", "first-secret"));
            assertEquals(root.resolve("FILE-ID_1").toString() + java.io.File.separator, user.getHomeDirectory());
            assertEquals(1, configured.getAllUserNames().length);
            assertTrue(configured.doesExist("FILE-ID_1"));
            assertFalse(configured.doesExist("unknown"));
            assertRejected(configured, login("FILE-ID_1", "wrong"));
            writeCredentials(credentials, "FILE-ID_1", "second-secret");
            assertRejected(configured, login("FILE-ID_1", "first-secret"));
            assertNotNull(configured.authenticate(login("FILE-ID_1", "second-secret")));
        } finally {
            Files.deleteIfExists(credentials);
            Files.deleteIfExists(root.resolve("FILE-ID_1"));
            Files.deleteIfExists(root);
            Files.deleteIfExists(temp);
        }
    }

    public void testRealFtpLoginAndUpload() throws Exception {
        Path temp = Files.createTempDirectory("im-ftp-test");
        Path root = Files.createDirectory(temp.resolve("ftp"));
        Path credentials = temp.resolve("credentials.properties");
        String previous = System.getProperty("ibiz.im.ftp.credentials.file");
        FtpServer server = null;
        FTPClient client = new FTPClient();
        try {
            writeCredentials(credentials, "FILE-ID_1", "secret");
            System.setProperty("ibiz.im.ftp.credentials.file", credentials.toString());
            IMMTFtpUserManager configured = IMMTFtpUserManager.fromConfiguredCredentials();
            configured.setRootFolder(root.toString());
            ServerSocket reservation = new ServerSocket(0);
            int port = reservation.getLocalPort();
            reservation.close();
            ListenerFactory listener = new ListenerFactory();
            listener.setPort(port);
            FtpServerFactory factory = new FtpServerFactory();
            factory.addListener("default", listener.createListener());
            factory.setUserManager(configured);
            server = factory.createServer();
            server.start();

            client.connect("127.0.0.1", port);
            assertFalse(client.login("unknown", "secret"));
            assertFalse(client.login("FILE-ID_1", "wrong"));
            assertTrue(client.login("FILE-ID_1", "secret"));
            assertTrue(client.storeFile("upload.txt", new ByteArrayInputStream("payload".getBytes("US-ASCII"))));
            assertEquals("payload", new String(Files.readAllBytes(root.resolve("FILE-ID_1/upload.txt")), "US-ASCII"));
            client.logout();
            client.disconnect();
            client.connect("127.0.0.1", port);
            String uploadPassword = configured.issueUploadPassword("DYNAMIC_1");
            assertFalse(client.login("DYNAMIC_1", "secret"));
            assertTrue(client.login("DYNAMIC_1", uploadPassword));
            assertFalse(client.storeFile("../FILE-ID_1/escape.txt",
                    new ByteArrayInputStream("outside".getBytes("US-ASCII"))));
            assertTrue(client.storeFile("dynamic.txt", new ByteArrayInputStream("dynamic".getBytes("US-ASCII"))));
            assertEquals("dynamic", new String(Files.readAllBytes(root.resolve("DYNAMIC_1/dynamic.txt")), "US-ASCII"));
            configured.revokeUploadPassword("DYNAMIC_1");
            client.logout();
            client.disconnect();
            client.connect("127.0.0.1", port);
            assertFalse(client.login("DYNAMIC_1", uploadPassword));
        } finally {
            if (client.isConnected()) {
                client.disconnect();
            }
            if (server != null) {
                server.stop();
            }
            if (previous == null) {
                System.clearProperty("ibiz.im.ftp.credentials.file");
            } else {
                System.setProperty("ibiz.im.ftp.credentials.file", previous);
            }
            Files.deleteIfExists(root.resolve("FILE-ID_1/upload.txt"));
            Files.deleteIfExists(root.resolve("FILE-ID_1/escape.txt"));
            Files.deleteIfExists(root.resolve("FILE-ID_1"));
            Files.deleteIfExists(root.resolve("DYNAMIC_1/dynamic.txt"));
            Files.deleteIfExists(root.resolve("DYNAMIC_1"));
            Files.deleteIfExists(temp.resolve("credentials.properties.lock"));
            Files.deleteIfExists(credentials);
            Files.deleteIfExists(root);
            Files.deleteIfExists(temp);
        }
    }

    public void testTraversalAndUnknownUsersCannotLoginOrGetHome() throws Exception {
        Path temp = Files.createTempDirectory("im-ftp-test");
        Path root = Files.createDirectory(temp.resolve("ftp"));
        Path credentials = temp.resolve("credentials.properties");
        try {
            writeCredentials(credentials, "FILE-ID_1", "secret");
            IMMTFtpUserManager configured = IMMTFtpUserManager.fromCredentialsFile(credentials);
            configured.setRootFolder(root.toString());
            String[] forbidden = {"../credentials.properties", "..", "/etc/passwd", "a/b", "a\\b", ".", ""};
            for (String name : forbidden) {
                assertNull(configured.getUserByName(name));
                assertFalse(configured.doesExist(name));
                assertRejected(configured, login(name, "secret"));
            }
            assertNull(configured.getUserByName("unknown"));
            assertRejected(configured, login("unknown", "secret"));
        } finally {
            Files.deleteIfExists(credentials);
            Files.deleteIfExists(root);
            Files.deleteIfExists(temp);
        }
    }

    public void testSymlinkOutOfRootIsRejected() throws Exception {
        Path temp = Files.createTempDirectory("im-ftp-test");
        Path root = Files.createDirectory(temp.resolve("ftp"));
        Path outside = Files.createDirectory(temp.resolve("outside"));
        Path credentials = temp.resolve("credentials.properties");
        Path link = root.resolve("FILE-ID_1");
        try {
            writeCredentials(credentials, "FILE-ID_1", "secret");
            Files.createSymbolicLink(link, outside);
            IMMTFtpUserManager configured = IMMTFtpUserManager.fromCredentialsFile(credentials);
            configured.setRootFolder(root.toString());
            assertNull(configured.getUserByName("FILE-ID_1"));
            assertRejected(configured, login("FILE-ID_1", "secret"));
            Files.delete(link);
            Files.createSymbolicLink(link, Files.createDirectory(root.resolve("another-user")));
            assertNull(configured.getUserByName("FILE-ID_1"));
            assertRejected(configured, login("FILE-ID_1", "secret"));
        } finally {
            Files.deleteIfExists(link);
            Files.deleteIfExists(root.resolve("another-user"));
            Files.deleteIfExists(credentials);
            Files.deleteIfExists(outside);
            Files.deleteIfExists(root);
            Files.deleteIfExists(temp);
        }
    }

    public void testMissingOrInsecureCredentialsFailClosed() throws Exception {
        Path temp = Files.createTempDirectory("im-ftp-test");
        Path root = Files.createDirectory(temp.resolve("ftp"));
        Path credentials = temp.resolve("credentials.properties");
        try {
            try {
                IMMTFtpUserManager.fromCredentialsFile(credentials);
                fail("A missing credentials file must fail");
            } catch (FtpException expected) {
                // No fallback to generated empty-password users.
            }
            writeCredentials(credentials, "FILE-ID_1", "secret");
            IMMTFtpUserManager configured = IMMTFtpUserManager.fromCredentialsFile(credentials);
            configured.setRootFolder(root.toString());
            Properties bad = new Properties();
            bad.setProperty("FILE-ID_1", "secret");
            writeProperties(credentials, bad);
            assertRejected(configured, login("FILE-ID_1", "secret"));
            bad.clear();
            bad.setProperty("../outside", encoded("secret"));
            writeProperties(credentials, bad);
            assertRejected(configured, login("FILE-ID_1", "secret"));
            writeCredentials(credentials, "FILE-ID_1", "secret");
            Files.setPosixFilePermissions(credentials, PosixFilePermissions.fromString("rw-r--r--"));
            assertRejected(configured, login("FILE-ID_1", "secret"));
        } finally {
            Files.deleteIfExists(credentials);
            Files.deleteIfExists(root);
            Files.deleteIfExists(temp);
        }
    }

    public void testMissingConfigurationAndInvalidRootFailClosed() throws Exception {
        String previous = System.getProperty("ibiz.im.ftp.credentials.file");
        try {
            System.setProperty("ibiz.im.ftp.credentials.file", "/nonexistent/ftp-credentials.properties");
            try {
                IMMTFtpUserManager.fromConfiguredCredentials();
                fail("Missing configured file must fail at startup");
            } catch (IllegalStateException expected) {
                // An FTP server cannot be started without a credential source.
            }
            try {
                manager.setRootFolder("");
                fail("Empty FTP root must not be accepted");
            } catch (IllegalArgumentException expected) {
                // Root directory must be explicitly configured.
            }
        } finally {
            if (previous == null) {
                System.clearProperty("ibiz.im.ftp.credentials.file");
            } else {
                System.setProperty("ibiz.im.ftp.credentials.file", previous);
            }
        }
    }

    public void testHashUsesIndependentSalt() throws Exception {
        String first = IMMTFtpUserManager.hashPassword("secret");
        String second = IMMTFtpUserManager.hashPassword("secret");
        assertFalse(first.equals(second));
        assertTrue(first.startsWith("PBKDF2WithHmacSHA256:210000:"));
        try {
            IMMTFtpUserManager.hashPassword("");
            fail("Empty credentials must not be generated");
        } catch (IllegalArgumentException expected) {
            // Passwords must be non-empty.
        }
    }

    public void testDynamicCredentialIsFileScopedAndRevoked() throws Exception {
        Path temp = Files.createTempDirectory("im-ftp-test");
        Path root = Files.createDirectory(temp.resolve("ftp"));
        Path credentials = temp.resolve("credentials.properties");
        Path lock = temp.resolve("credentials.properties.lock");
        try {
            writeCredentials(credentials, "STATIC", "static-secret");
            IMMTFtpUserManager issuer = IMMTFtpUserManager.fromCredentialsFile(credentials);
            IMMTFtpUserManager ftp = IMMTFtpUserManager.fromCredentialsFile(credentials);
            ftp.setRootFolder(root.toString());
            String password = issuer.issueUploadPassword("UPLOAD_1");
            assertFalse(new String(Files.readAllBytes(credentials), "ISO-8859-1").contains(password));
            assertNotNull(ftp.authenticate(login("UPLOAD_1", password)));
            assertRejected(ftp, login("STATIC", password));
            assertRejected(ftp, login("UPLOAD_2", password));
            assertEquals(2, ftp.getAllUserNames().length);
            try {
                issuer.issueUploadPassword("UPLOAD_1");
                fail("A file ID must never replace an existing password");
            } catch (FtpException expected) {
                // Preserve a previously issued credential.
            }
            issuer.revokeUploadPassword("UPLOAD_1");
            assertRejected(ftp, login("UPLOAD_1", password));
            assertEquals(1, ftp.getAllUserNames().length);
            assertNotNull(ftp.authenticate(login("STATIC", "static-secret")));
            issuer.revokeUploadPassword("STATIC");
            assertNotNull(ftp.authenticate(login("STATIC", "static-secret")));
            assertEquals("rw-------", PosixFilePermissions.toString(Files.getPosixFilePermissions(credentials)));
        } finally {
            Files.deleteIfExists(lock);
            Files.deleteIfExists(credentials);
            Files.deleteIfExists(root);
            Files.deleteIfExists(temp);
        }
    }

    public void testExpiredDynamicCredentialCannotAuthenticate() throws Exception {
        Path temp = Files.createTempDirectory("im-ftp-test");
        Path root = Files.createDirectory(temp.resolve("ftp"));
        Path credentials = temp.resolve("credentials.properties");
        try {
            Properties users = new Properties();
            users.setProperty("EXPIRED", encoded("secret") + "|1");
            writeProperties(credentials, users);
            IMMTFtpUserManager ftp = IMMTFtpUserManager.fromCredentialsFile(credentials);
            ftp.setRootFolder(root.toString());
            assertRejected(ftp, login("EXPIRED", "secret"));
            assertFalse(ftp.doesExist("EXPIRED"));
            assertEquals(0, ftp.getAllUserNames().length);
            users.setProperty("BROKEN", encoded("secret") + "|not-a-timestamp");
            writeProperties(credentials, users);
            assertRejected(ftp, login("EXPIRED", "secret"));
        } finally {
            Files.deleteIfExists(credentials);
            Files.deleteIfExists(root);
            Files.deleteIfExists(temp);
        }
    }

    public void testDynamicProvisioningRejectsUnsafeIdsAndWritableParent() throws Exception {
        Path temp = Files.createTempDirectory("im-ftp-test");
        Path credentials = temp.resolve("credentials.properties");
        Path lock = temp.resolve("credentials.properties.lock");
        try {
            writeCredentials(credentials, "STATIC", "secret");
            IMMTFtpUserManager issuer = IMMTFtpUserManager.fromCredentialsFile(credentials);
            for (String fileId : new String[] {"../other", "a/b", ".", ""}) {
                try {
                    issuer.issueUploadPassword(fileId);
                    fail("Unsafe FTP file ID must not be provisioned: " + fileId);
                } catch (FtpException expected) {
                    // Never create accounts outside the designated FTP root.
                }
            }
            Files.setPosixFilePermissions(temp, PosixFilePermissions.fromString("rwxrwxrwx"));
            try {
                issuer.issueUploadPassword("VALID_1");
                fail("A writable parent could replace the credential store");
            } catch (FtpException expected) {
                // Writes must fail before any password is returned.
            }
            Files.setPosixFilePermissions(temp, PosixFilePermissions.fromString("rwx------"));
            assertFalse(issuer.doesExist("VALID_1"));
        } finally {
            Files.setPosixFilePermissions(temp, PosixFilePermissions.fromString("rwx------"));
            Files.deleteIfExists(lock);
            Files.deleteIfExists(credentials);
            Files.deleteIfExists(temp);
        }
    }

    public void testConcurrentIssuersDoNotLoseCredentials() throws Exception {
        Path temp = Files.createTempDirectory("im-ftp-test");
        Path root = Files.createDirectory(temp.resolve("ftp"));
        Path credentials = temp.resolve("credentials.properties");
        Path lock = temp.resolve("credentials.properties.lock");
        try {
            writeCredentials(credentials, "STATIC", "secret");
            final IMMTFtpUserManager first = IMMTFtpUserManager.fromCredentialsFile(credentials);
            final IMMTFtpUserManager second = IMMTFtpUserManager.fromCredentialsFile(credentials);
            final AtomicReference<Throwable> failure = new AtomicReference<Throwable>();
            final String[] passwords = new String[2];
            final CountDownLatch start = new CountDownLatch(1);
            Thread one = new Thread(new Runnable() {
                public void run() {
                    try {
                        start.await();
                        passwords[0] = first.issueUploadPassword("UPLOAD_1");
                    } catch (Throwable e) {
                        failure.set(e);
                    }
                }
            });
            Thread two = new Thread(new Runnable() {
                public void run() {
                    try {
                        start.await();
                        passwords[1] = second.issueUploadPassword("UPLOAD_2");
                    } catch (Throwable e) {
                        failure.set(e);
                    }
                }
            });
            one.start();
            two.start();
            start.countDown();
            one.join();
            two.join();
            if (failure.get() != null) {
                throw new AssertionError(failure.get());
            }
            IMMTFtpUserManager ftp = IMMTFtpUserManager.fromCredentialsFile(credentials);
            ftp.setRootFolder(root.toString());
            assertNotNull(ftp.authenticate(login("UPLOAD_1", passwords[0])));
            assertNotNull(ftp.authenticate(login("UPLOAD_2", passwords[1])));
            assertEquals(3, ftp.getAllUserNames().length);
        } finally {
            Files.deleteIfExists(lock);
            Files.deleteIfExists(credentials);
            Files.deleteIfExists(root);
            Files.deleteIfExists(temp);
        }
    }

    private static void writeCredentials(Path file, String name, String password) throws Exception {
        Properties properties = new Properties();
        properties.setProperty(name, encoded(password));
        writeProperties(file, properties);
    }

    private static void writeProperties(Path file, Properties properties) throws Exception {
        OutputStream out = Files.newOutputStream(file);
        try {
            properties.store(out, null);
        } finally {
            out.close();
        }
        Files.setPosixFilePermissions(file, PosixFilePermissions.fromString("rw-------"));
    }

    private static String encoded(String password) throws Exception {
        return IMMTFtpUserManager.hashPassword(password);
    }

    private static UsernamePasswordAuthentication login(String name, String password) {
        return new UsernamePasswordAuthentication(name, password);
    }

    private static BaseUser user(String name, String password, boolean enabled) {
        BaseUser user = new BaseUser();
        user.setName(name);
        user.setPassword(password);
        user.setEnabled(enabled);
        return user;
    }

    private void assertRejected(Authentication authentication) throws Exception {
        assertRejected(manager, authentication);
    }

    private static void assertRejected(IMMTFtpUserManager target, Authentication authentication) throws Exception {
        try {
            target.authenticate(authentication);
            fail("Expected FTP authentication to fail");
        } catch (AuthenticationFailedException expected) {
            // Authentication failures must not return a user.
        }
    }

    private static final class TestUserManager extends IMMTFtpUserManager {
        private User user;
        private boolean failLookup;

        private TestUserManager() {
            this(new ClearTextPasswordEncryptor());
        }

        private TestUserManager(PasswordEncryptor encryptor) {
            super("", encryptor);
        }

        @Override
        public User getUserByName(String name) throws FtpException {
            if (failLookup) {
                throw new FtpException("User lookup failed");
            }
            return user;
        }
    }
}
