/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDCResObject;
import SA.SRFDA.PS.Core.Deploy.IPSRemoteResObject;
import SA.SRFDA.PS.Core.Deploy.IPSSVNServer;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSWorkshopServer;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSWorkshopServer
extends IPSObject,
IPSRemoteResObject,
IPSDCResObject {
    public static final String CFG_WS_TYPE = "ws.type";
    public static final String CFG_WS_UPLOADMODE = "ws.uploadmode";
    public static final String CFG_WS_HTTP = "ws.http";
    public static final String CFG_WS_HTTPS = "ws.https";
    public static final String CFG_WS_REMOTE = "ws.remote";
    public static final String CFG_WS_UPLOADPATH = "ws.unloadpath";
    public static final String CFG_WS_WORKSHOP = "ws.workshop";
    public static final String CFG_WS_GITPATH = "ws.gitpath";
    public static final String CFG_WS_GITUSER = "ws.gituser";
    public static final String CFG_WS_GITPASS = "ws.gitpass";
    public static final String CFG_WS_GITSERVER = "ws.gitserver";
    public static final String UPLOADMODE_SSH = "SSH";
    public static final String UPLOADMODE_SFTP = "SFTP";
    public static final String UPLOADMODE_FTP = "FTP";

    public void init(ISRFDAGlobalHelper var1, PSWorkshopServer var2) throws Exception;

    public String getSSHIPAddr();

    public int getSSHPort();

    public String getLocalSSHIPAddr();

    public int getLocalSSHPort();

    public String getSSHUserName();

    public String getSSHPassword();

    public String getUploadMode();

    public String getUploadPath();

    public String getWorkshopPath();

    public String getGitPath();

    public String getGitServerId();

    public String getGitServerCfgFilePath();

    public IPSSVNServer getPSSVNServer();
}

