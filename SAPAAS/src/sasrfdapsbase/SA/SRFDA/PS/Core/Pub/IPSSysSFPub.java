/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Deploy.IPSDeployCenter;
import SA.SRFDA.PS.Core.Deploy.IPSDevSlnSysWSGit;
import SA.SRFDA.PS.Core.Deploy.IPSWorkshopServer;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubPkg;
import SA.SRFDA.PS.Core.Pub.IPSSysSFUserCode;
import SA.SRFDA.PS.Core.SF.IPSSFPkgVer;
import SA.SRFDA.PS.Core.SF.IPSSFStyle;
import SA.SRFDA.PS.Core.SF.IPSSFStyleParam;
import SA.SRFDA.PS.Core.SF.IPSSFStyleVer;
import SA.SRFDA.PS.Data.PSSysSFPub;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelPFIgnoreMeta
public interface IPSSysSFPub
extends IPSSystemObject {
    public static final String CONTENTTYPE_CODE = "CODE";
    public static final String CONTENTTYPE_DOC = "DOC";
    public static final String CONTENTTYPE_TESTCODE = "TESTCODE";
    public static final String DYNAMODELMODE_NONE = "NONE";
    public static final String DYNAMODELMODE_PUB = "PUB";
    public static final String DYNAMODELMODE_RUNTIME = "RUNTIME";
    public static final String DYNAMODELMODE_GENCODE = "GENCODE";
    public static final int PUBCODELEVEL_NONE = 0;
    public static final int PUBCODELEVEL_LOW = 10;
    public static final int PUBCODELEVEL_NORMAL = 20;
    public static final int PUBCODELEVEL_HIGH = 30;

    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSysSFPub var3) throws Exception;

    public String getSFStyle();

    public String getPKGCodeName();

    public String getBaseClassPKGCodeName();

    public String getDestFile();

    @Override
    public String getCodeName();

    public IPSSFStyle getPSSFStyle();

    public IPSSFStyleVer getPSSFStyleVer();

    public IPSSFStyleParam getPSSFStyleParam();

    public String getSFPubVersion();

    public Iterator<IPSSysSFUserCode> getPSSysSFUserCodes();

    public IPSSysSFUserCode getPSSysSFUserCode(String var1, boolean var2) throws Exception;

    public String getSrvFolder();

    public Iterator<IPSSysSFPubPkg> getPSSysSFPubPkgs();

    public Iterator<IPSSFPkgVer> getPSSFPkgVers();

    public boolean isUseWorkshopServer();

    public boolean isRemotePack();

    public boolean isRemoteDeploy();

    public boolean getDefaultFlag();

    public boolean isSubSysPackage();

    public String getVersionString();

    public IPSDeployCenter getPSDeployCenter();

    public IPSWorkshopServer getPSWorkshopServer();

    public IPSDevSlnSysWSGit getPSDevSlnSysWSGit();

    public IPSSysSFPub getMainPSSysSFPub();

    public Iterator<IPSSysSFPub> getPartPSSysSFPubs() throws Exception;

    public boolean isMainPSSysSFPub();

    public boolean isDocMode();

    public boolean isCodeMode();

    public boolean isTestCodeMode();

    public String getContentType();

    public boolean isEnableGlobalTransaction();

    public boolean isPubModel();

    public boolean isEnableModelRT();

    public boolean isPubGenCodeModel();

    public String getModelFolder();

    public int getPubCodeLevel();

    public String getGroovySourceFolder();

    public String getScriptEngine();

    public boolean isPubModelMemo();

    public String getAPICodeNameMode();

    public boolean isPubSFPluginCodeFile();
}

