/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.ftpserver.usermanager.impl.BaseUser
 */
package SA.IM.Ctrl;

import java.io.File;
import org.apache.ftpserver.usermanager.impl.BaseUser;

public class IMMTFtpUser
extends BaseUser {
    protected String strName = "";
    protected String strFtpRootFolder = "";

    public boolean getEnabled() {
        return true;
    }

    public String getHomeDirectory() {
        String strFolder = this.strFtpRootFolder;
        File file = new File(strFolder);
        if (!file.exists()) {
            file.mkdirs();
        }
        return strFolder;
    }

    public int getMaxIdleTime() {
        return 0;
    }

    public void setHomeDirectory(String strFtpRootFolder) {
        this.strFtpRootFolder = strFtpRootFolder;
    }
}

