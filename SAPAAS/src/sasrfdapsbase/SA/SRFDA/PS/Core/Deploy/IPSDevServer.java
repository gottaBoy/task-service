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
import SA.SRFDA.PS.Data.PSDevServer;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSDevServer
extends IPSObject,
IPSRemoteResObject,
IPSDCResObject {
    public static final String CFG_DS_TYPE = "ds.type";
    public static final String CFG_DS_UPLOADMODE = "ds.uploadmode";
    public static final String CFG_DS_REMOTE = "ds.remote";
    public static final String CFG_DS_PATH = "ds.path";
    public static final String UPLOADMODE_SSH = "SSH";
    public static final String UPLOADMODE_SFTP = "SFTP";
    public static final String UPLOADMODE_FTP = "FTP";

    public void init(ISRFDAGlobalHelper var1, PSDevServer var2) throws Exception;

    public String getDSType();

    public String getSSHIPAddr();

    public int getSSHPort();

    public String getSSHUserName();

    public String getSSHPassword();

    public String getUploadMode();

    public boolean isTimeShareRes();
}

