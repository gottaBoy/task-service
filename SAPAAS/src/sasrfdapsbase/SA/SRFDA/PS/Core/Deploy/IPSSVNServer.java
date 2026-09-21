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
import SA.SRFDA.PS.Data.PSSVNServer;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSSVNServer
extends IPSObject,
IPSRemoteResObject,
IPSDCResObject {
    public static final String CFG_VS_TYPE = "vs.type";
    public static final String CFG_VS_UPLOADMODE = "vs.uploadmode";
    public static final String CFG_VS_HTTP = "vs.http";
    public static final String CFG_VS_HTTPS = "vs.https";
    public static final String CFG_VS_REMOTE = "vs.remote";
    public static final String CFG_VS_PATH = "vs.path";
    public static final String CFG_VS_GITPATH = "vs.gitpath";
    public static final String CFG_VS_GITUSER = "vs.gituser";
    public static final String CFG_VS_GITPASS = "vs.gitpass";
    public static final String CFG_VS_GITADMINUSER = "vs.gitadminuser";
    public static final String CFG_VS_GITADMINPASS = "vs.gitadminpass";
    public static final String CFG_VS_GITTOKEN = "vs.gittoken";
    public static final String CFG_VS_USERTAG = "vs.usertag";
    public static final String CFG_VS_USERTAG2 = "vs.usertag2";
    public static final String CFG_VS_USERTAG3 = "vs.usertag3";
    public static final String CFG_VS_USERTAG4 = "vs.usertag4";
    public static final String UPLOADMODE_SSH = "SSH";
    public static final String UPLOADMODE_SFTP = "SFTP";
    public static final String UPLOADMODE_FTP = "FTP";

    public void init(ISRFDAGlobalHelper var1, PSSVNServer var2) throws Exception;

    public String getVSType();

    public boolean isRemoteDeploy();

    public String getGitPath();

    public String getGitUserName();

    public String getGitPassword();

    public String getGitAdminUser();

    public String getGitAdminPass();

    public String getGitToken();
}

