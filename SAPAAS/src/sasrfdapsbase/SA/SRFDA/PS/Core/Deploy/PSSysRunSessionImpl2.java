/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDeployCenter;
import SA.SRFDA.PS.Core.Deploy.IPSDevSlnSysWSGit;
import SA.SRFDA.PS.Core.Deploy.IPSWorkshopServer;
import SA.SRFDA.PS.Core.Deploy.PSSysRunSessionImpl;
import SA.SRFDA.PS.Core.DynaModel.IPSDynaModel;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubPkg;
import SA.SRFDA.PS.Core.Pub.IPSSysSFUserCode;
import SA.SRFDA.PS.Core.SF.IPSSF;
import SA.SRFDA.PS.Core.SF.IPSSFPkgVer;
import SA.SRFDA.PS.Core.SF.IPSSFStyle;
import SA.SRFDA.PS.Core.SF.IPSSFStyleParam;
import SA.SRFDA.PS.Core.SF.IPSSFStyleVer;
import SA.SRFDA.PS.Data.PSSFStyleParam;
import SA.SRFDA.PS.Data.PSSysRunSession;
import SA.SRFDA.PS.Data.PSSysSFPub;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

public class PSSysRunSessionImpl2
extends PSSysRunSessionImpl
implements IPSSysSFPub,
IPSSFStyleParam {
    private IPSSysSFPub iPSSysSFPub = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysSFPub iPSSysSFPub, PSSysRunSession psSysRunSession) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.iPSSysSFPub = iPSSysSFPub;
        this.init(iDAGlobalHelper, this.iPSSysSFPub.getPSSystem(), psSysRunSession);
    }

    @Override
    public String getId() {
        return this.iPSSysSFPub.getId();
    }

    @Override
    @PSModelRTMeta(description="\u540d\u79f0")
    public String getName() {
        return this.iPSSysSFPub.getName();
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysSFPub psSysSFPub) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public String getSFStyle() {
        return this.iPSSysSFPub.getSFStyle();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u5305\u540d")
    public String getPKGCodeName() {
        return this.iPSSysSFPub.getPKGCodeName();
    }

    @Override
    @PSModelRTMeta(description="\u57fa\u7c7b\u4ee3\u7801\u5305\u540d")
    public String getBaseClassPKGCodeName() {
        return this.iPSSysSFPub.getBaseClassPKGCodeName();
    }

    @Override
    @PSModelRTMeta(description="\u751f\u4ea7\u76ee\u6807\u6587\u4ef6", debugmode=true)
    public String getDestFile() {
        return this.iPSSysSFPub.getDestFile();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.iPSSysSFPub.getCodeName();
    }

    @Override
    public IPSSFStyle getPSSFStyle() {
        return this.iPSSysSFPub.getPSSFStyle();
    }

    @Override
    public IPSSFStyleVer getPSSFStyleVer() {
        return this.iPSSysSFPub.getPSSFStyleVer();
    }

    @Override
    public String getSFPubVersion() {
        return this.iPSSysSFPub.getSFPubVersion();
    }

    @Override
    public Iterator<IPSSysSFUserCode> getPSSysSFUserCodes() {
        return this.iPSSysSFPub.getPSSysSFUserCodes();
    }

    @Override
    public String getSrvFolder() {
        return this.iPSSysSFPub.getSrvFolder();
    }

    @Override
    public IPSSysSFUserCode getPSSysSFUserCode(String strPSSysSFUserCodeId, boolean bTryMode) throws Exception {
        return this.iPSSysSFPub.getPSSysSFUserCode(strPSSysSFUserCodeId, bTryMode);
    }

    @Override
    public Iterator<IPSSysSFPubPkg> getPSSysSFPubPkgs() {
        return this.iPSSysSFPub.getPSSysSFPubPkgs();
    }

    @Override
    @PSModelRTMeta(description="\u7ec4\u4ef6\u5305\u96c6\u5408")
    public Iterator<IPSSFPkgVer> getPSSFPkgVers() {
        return this.iPSSysSFPub.getPSSFPkgVers();
    }

    @Override
    public String getModelType() {
        return "PSSYSSFPUB";
    }

    @Override
    public IPSSysSFPub getPSSysSFPub() {
        return super.getPSSysSFPub();
    }

    @Override
    @PSModelRTMeta(description="\u662f\u5426\u4f7f\u7528\u5de5\u7a0b\u670d\u52a1\u5668", debugmode=true)
    public boolean isUseWorkshopServer() {
        return this.iPSSysSFPub.isUseWorkshopServer();
    }

    @Override
    @PSModelRTMeta(description="\u8fdc\u7a0b\u6253\u5305", debugmode=true)
    public boolean isRemotePack() {
        return this.iPSSysSFPub.isRemotePack();
    }

    @Override
    @PSModelRTMeta(description="\u8fdc\u7a0b\u90e8\u7f72", debugmode=true)
    public boolean isRemoteDeploy() {
        return this.iPSSysSFPub.isRemoteDeploy();
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u7f72\u4e2d\u5fc3", debugmode=true)
    public IPSDeployCenter getPSDeployCenter() {
        return this.iPSSysSFPub.getPSDeployCenter();
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u7a0b\u670d\u52a1\u5668", debugmode=true)
    public IPSWorkshopServer getPSWorkshopServer() {
        return this.iPSSysSFPub.getPSWorkshopServer();
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u7a0b\u670d\u52a1\u5668Git\u914d\u7f6e", debugmode=true)
    public IPSDevSlnSysWSGit getPSDevSlnSysWSGit() {
        return this.iPSSysSFPub.getPSDevSlnSysWSGit();
    }

    @Override
    public IPSSFStyleParam getPSSFStyleParam() {
        return this.iPSSysSFPub.getPSSFStyleParam();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u540e\u53f0\u670d\u52a1")
    public boolean getDefaultFlag() {
        return this.iPSSysSFPub.getDefaultFlag();
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u51fa\u5b50\u7cfb\u7edf\u7ec4\u4ef6\u5305")
    public boolean isSubSysPackage() {
        return this.iPSSysSFPub.isSubSysPackage();
    }

    @Override
    @PSModelRTMeta(description="\u7ec4\u4ef6\u7248\u672c")
    public String getVersionString() {
        return this.iPSSysSFPub.getVersionString();
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u7cfb\u7edf\u540e\u53f0\u670d\u52a1\u4f53\u7cfb", hideempty=true)
    public IPSSysSFPub getMainPSSysSFPub() {
        return this.iPSSysSFPub.getMainPSSysSFPub();
    }

    @Override
    @PSModelRTMeta(description="\u6210\u5458\u7cfb\u7edf\u540e\u53f0\u670d\u52a1\u4f53\u7cfb", hideempty=true)
    public Iterator<IPSSysSFPub> getPartPSSysSFPubs() throws Exception {
        return this.iPSSysSFPub.getPartPSSysSFPubs();
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u540e\u53f0\u670d\u52a1\u4f53\u7cfb")
    public boolean isMainPSSysSFPub() {
        return this.iPSSysSFPub.isMainPSSysSFPub();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u6a21\u578b\u5bf9\u8c61", hideempty=true)
    public IPSDynaModel getPSDynaModel() {
        return this.iPSSysSFPub.getPSDynaModel();
    }

    @Override
    @PSModelRTMeta(description="\u6587\u6863\u53d1\u5e03\u6a21\u5f0f")
    public boolean isDocMode() {
        return this.iPSSysSFPub.isDocMode();
    }

    @Override
    @PSModelRTMeta(description="\u8fd0\u884c\u4ee3\u7801\u53d1\u5e03\u6a21\u5f0f")
    public boolean isCodeMode() {
        return this.iPSSysSFPub.isCodeMode();
    }

    @Override
    @PSModelRTMeta(description="\u6d4b\u8bd5\u4ee3\u7801\u53d1\u5e03\u6a21\u5f0f")
    public boolean isTestCodeMode() {
        return this.iPSSysSFPub.isTestCodeMode();
    }

    @Override
    @PSModelRTMeta(description="\u53d1\u5e03\u5185\u5bb9\u7c7b\u578b", codelist="SysSFPubContentType")
    public String getContentType() {
        return this.iPSSysSFPub.getContentType();
    }

    @Override
    protected IPSModelObject getProxyPSModelObject() {
        return this.iPSSysSFPub;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u5168\u5c40\u4e8b\u52a1")
    public boolean isEnableGlobalTransaction() {
        return this.iPSSysSFPub.isEnableGlobalTransaction();
    }

    @Override
    public boolean isPubModel() {
        return this.iPSSysSFPub.isPubModel();
    }

    @Override
    public boolean isEnableModelRT() {
        return this.iPSSysSFPub.isEnableModelRT();
    }

    @Override
    public String getModelFolder() {
        return this.iPSSysSFPub.getModelFolder();
    }

    @Override
    public String getGroovySourceFolder() {
        return this.iPSSysSFPub.getGroovySourceFolder();
    }

    @Override
    public String getScriptEngine() {
        return this.iPSSysSFPub.getScriptEngine();
    }

    @Override
    public int getPubCodeLevel() {
        return this.iPSSysSFPub.getPubCodeLevel();
    }

    @Override
    public boolean isPubGenCodeModel() {
        return this.iPSSysSFPub.isPubGenCodeModel();
    }

    @Override
    public boolean isPubModelMemo() {
        return this.iPSSysSFPub.isPubModelMemo();
    }

    @Override
    public boolean isPubSFPluginCodeFile() {
        return this.iPSSysSFPub.isPubSFPluginCodeFile();
    }

    @Override
    public String getAPICodeNameMode() {
        return this.iPSSysSFPub.getAPICodeNameMode();
    }

    @Override
    public IPSSF getPSSF() {
        if (this.iPSSysSFPub.getPSSFStyleParam() != null) {
            return this.iPSSysSFPub.getPSSFStyleParam().getPSSF();
        }
        return null;
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSF iPSSF, PSSFStyleParam psSFStyleParam) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public String getStyleParam(String strParamName, String strDefault) {
        if (this.iPSSysSFPub.getPSSFStyleParam() != null) {
            return this.iPSSysSFPub.getPSSFStyleParam().getStyleParam(strParamName, strDefault);
        }
        return strDefault;
    }

    @Override
    public int getStyleParam(String strParamName, int nDefault) {
        if (this.iPSSysSFPub.getPSSFStyleParam() != null) {
            return this.iPSSysSFPub.getPSSFStyleParam().getStyleParam(strParamName, nDefault);
        }
        return nDefault;
    }

    @Override
    public boolean containsStyleParam(String strParamName) {
        if (this.iPSSysSFPub.getPSSFStyleParam() != null) {
            return this.iPSSysSFPub.getPSSFStyleParam().containsStyleParam(strParamName);
        }
        return false;
    }
}

