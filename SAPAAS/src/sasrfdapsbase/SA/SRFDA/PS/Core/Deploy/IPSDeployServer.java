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
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDeployServer;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSDeployServer
extends IPSObject,
IPSRemoteResObject,
IPSDCResObject {
    public static final String CFG_DEPS_TYPE = "deps.type";
    public static final String CFG_DEPS_UPLOADMODE = "deps.uploadmode";
    public static final String CFG_DEPS_HTTP = "deps.http";
    public static final String CFG_DEPS_HTTPS = "deps.https";
    public static final String CFG_DEPS_REMOTE = "deps.remote";
    public static final String CFG_DEPS_UPLOADPATH = "deps.unloadpath";
    public static final String CFG_DEPS_WORKSHOP = "deps.workshop";
    public static final String UPLOADMODE_SSH = "SSH";
    public static final String UPLOADMODE_SFTP = "SFTP";
    public static final String UPLOADMODE_FTP = "FTP";

    public void init(ISRFDAGlobalHelper var1, PSDeployServer var2) throws Exception;

    public String getSSHIPAddr();

    public int getSSHPort();

    public String getLocalSSHIPAddr();

    public int getLocalSSHPort();

    public String getSSHUserName();

    public String getSSHPassword();

    public String getUploadMode();

    public String getUploadPath();

    public String getWorkshopPath();
}

