/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDCResObject;
import SA.SRFDA.PS.Core.Deploy.IPSRegistryRepo;
import SA.SRFDA.PS.Core.Deploy.IPSRemoteResObject;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDeployCenter;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSDeployCenter
extends IPSObject,
IPSRemoteResObject,
IPSDCResObject {
    public static final String CFG_DEPS_TYPE = "deps.type";
    public static final String CFG_DEPS_CITYPE = "deps.citype";
    public static final String CFG_DEPS_CDTYPE = "deps.cdtype";
    public static final String CFG_DEPS_UPLOADMODE = "deps.uploadmode";
    public static final String CFG_DEPS_HTTP = "deps.http";
    public static final String CFG_DEPS_HTTPS = "deps.https";
    public static final String CFG_DEPS_REMOTE = "deps.remote";
    public static final String CFG_DEPS_UPLOADPATH = "deps.unloadpath";
    public static final String CFG_DEPS_WORKSHOP = "deps.workshop";
    public static final String CFG_DEPS_APIURL = "deps.apiurl";
    public static final String CFG_DEPS_APITOKEN = "deps.apitoken";
    public static final String UPLOADMODE_SSH = "SSH";
    public static final String UPLOADMODE_SFTP = "SFTP";
    public static final String UPLOADMODE_FTP = "FTP";
    public static final String CITYPE_JENKINS = "JENKINS";
    public static final String CITYPE_GITLABRUNNER = "GITLABRUNNER";
    public static final String CDTYPE_DEFAULT = "DEFAULT";
    public static final String CDTYPE_SWARM = "SWARM";
    public static final String CDTYPE_K8S = "K8S";

    public void init(ISRFDAGlobalHelper var1, PSDeployCenter var2) throws Exception;

    public String getSSHIPAddr();

    public int getSSHPort();

    public String getLocalSSHIPAddr();

    public int getLocalSSHPort();

    public String getSSHUserName();

    public String getSSHPassword();

    public String getUploadMode();

    public String getUploadPath();

    public String getWorkshopPath();

    public String getDeployCenterType();

    public String getCIType();

    public String getCDType();

    public String getAPIUrl();

    public String getAPIToken();

    public IPSRegistryRepo getPSRegistryRepo();

    public String getPSRegistryRepoId();
}

