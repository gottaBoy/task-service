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
import SA.SRFDA.PS.Data.PSMobAppPackServer;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSMobAppPackServer
extends IPSObject,
IPSRemoteResObject,
IPSDCResObject {
    public static final String CFG_MAPS_TYPE = "maps.type";
    public static final String CFG_MAPS_UPLOADMODE = "maps.uploadmode";
    public static final String CFG_MAPS_HTTP = "maps.http";
    public static final String CFG_MAPS_HTTPS = "maps.https";
    public static final String CFG_MAPS_REMOTE = "maps.remote";
    public static final String CFG_MAPS_UPLOADPATH = "maps.unloadpath";
    public static final String UPLOADMODE_SSH = "SSH";
    public static final String UPLOADMODE_SFTP = "SFTP";
    public static final String UPLOADMODE_FTP = "FTP";

    public void init(ISRFDAGlobalHelper var1, PSMobAppPackServer var2) throws Exception;

    public String getSSHIPAddr();

    public int getSSHPort();

    public String getSSHUserName();

    public String getSSHPassword();

    public String getUploadMode();

    public String getUploadPath();
}

