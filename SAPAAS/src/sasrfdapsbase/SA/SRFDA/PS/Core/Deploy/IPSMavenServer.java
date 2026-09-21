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
import SA.SRFDA.PS.Data.PSMavenServer;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSMavenServer
extends IPSObject,
IPSRemoteResObject,
IPSDCResObject {
    public static final String CFG_MS_TYPE = "ms.type";
    public static final String CFG_MS_UPLOADMODE = "ms.uploadmode";
    public static final String CFG_MS_HTTP = "ms.http";
    public static final String CFG_MS_HTTPS = "ms.https";
    public static final String CFG_MS_REMOTE = "ms.remote";
    public static final String CFG_MS_PATH = "ms.path";
    public static final String UPLOADMODE_SSH = "SSH";
    public static final String UPLOADMODE_SFTP = "SFTP";
    public static final String UPLOADMODE_FTP = "FTP";

    public void init(ISRFDAGlobalHelper var1, PSMavenServer var2) throws Exception;

    public String getMSType();

    public boolean isRemoteDeploy();

    public String getAPIPath();
}

