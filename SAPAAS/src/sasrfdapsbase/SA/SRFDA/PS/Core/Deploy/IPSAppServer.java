/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDCResObject;
import SA.SRFDA.PS.Core.Deploy.IPSRemoteResObject;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Data.PSAppServer;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSAppServer
extends IPSObject,
IPSRemoteResObject,
IPSDCResObject {
    public static final String CFG_AS_TYPE = "as.type";
    public static final String CFG_AS_UPLOADMODE = "as.uploadmode";
    public static final String CFG_AS_HTTP = "as.http";
    public static final String CFG_AS_HTTPS = "as.https";
    public static final String CFG_AS_REMOTE = "as.remote";
    public static final String CFG_AS_PATH = "as.path";
    public static final String UPLOADMODE_SSH = "SSH";
    public static final String UPLOADMODE_SFTP = "SFTP";
    public static final String UPLOADMODE_FTP = "FTP";

    public void init(ISRFDAGlobalHelper var1, PSAppServer var2) throws Exception;

    public String getASType();

    public String getAppFolder();

    public String getSSHIPAddr();

    public int getSSHPort();

    public String getSSHUserName();

    public String getSSHPassword();

    public boolean isRemoteDeploy();

    public String getUploadMode();

    public int getHttpPort();

    public int getHttpsPort();

    public boolean isTimeShareRes();
}

