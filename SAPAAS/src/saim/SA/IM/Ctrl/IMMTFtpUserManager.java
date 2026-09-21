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
import SA.SRFramework.Utility.StringHelper;
import java.io.File;
import java.util.ArrayList;
import org.apache.ftpserver.ftplet.Authentication;
import org.apache.ftpserver.ftplet.AuthenticationFailedException;
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

    public IMMTFtpUserManager(String adminName, PasswordEncryptor passwordEncrypto) {
        super(adminName, passwordEncrypto);
    }

    public User authenticate(Authentication authentication) throws AuthenticationFailedException {
        if (authentication instanceof UsernamePasswordAuthentication) {
            UsernamePasswordAuthentication usernamePasswordAuthentication = (UsernamePasswordAuthentication)authentication;
            try {
                return this.getUserByName(usernamePasswordAuthentication.getUsername());
            }
            catch (FtpException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void delete(String arg0) throws FtpException {
    }

    public boolean doesExist(String arg0) throws FtpException {
        return true;
    }

    public String[] getAllUserNames() throws FtpException {
        return null;
    }

    public User getUserByName(String arg0) throws FtpException {
        IMMTFtpUser imMTFtpUser = new IMMTFtpUser();
        imMTFtpUser.setName(arg0);
        imMTFtpUser.setPassword("");
        String strFolder = StringHelper.Format((String)"%1$s%2$s%3$s", (Object)this.getRootFolder(), (Object)arg0, (Object)File.separator);
        imMTFtpUser.setHomeDirectory(strFolder);
        ArrayList<Object> authorities = new ArrayList<Object>();
        authorities.add(new ConcurrentLoginPermission(100, 10000));
        authorities.add(new TransferRatePermission(1000000, 1000000));
        authorities.add(new WritePermission());
        imMTFtpUser.setAuthorities(authorities);
        return imMTFtpUser;
    }

    public void save(User arg0) throws FtpException {
    }

    public void setRootFolder(String strFtpRootFolder) {
        this.strFtpRootFolder = strFtpRootFolder;
    }

    public String getRootFolder() {
        return this.strFtpRootFolder;
    }
}

