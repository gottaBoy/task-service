/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.Inflector
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDELogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDELogicParam;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicParam;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.Res.IPSSysTranslator;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Data.PSDELogicParam;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Properties;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.Inflector;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDELogicParamImpl
extends PSObjectImpl
implements IPSDELogicParam,
IPSAppDELogicParam {
    private static final Log log = LogFactory.getLog(PSDELogicParamImpl.class);
    protected IPSDELogic iPSDELogic;
    protected PSDELogicParam psDELogicParam;
    protected IPSDataEntity paramPSDataEntity = null;
    private boolean bDefaultParam = false;
    private boolean bSessionParam = false;
    private boolean bEnvParam = false;
    private boolean bLastParam = false;
    private boolean bEntityParam = false;
    private boolean bEntityListParam = false;
    private boolean bEntityMapParam = false;
    private boolean bFilterParam = false;
    private boolean bLastReturnParam = false;
    private boolean bEntityPageParam = false;
    private boolean bFileParam = false;
    private boolean bFileListParam = false;
    private boolean bSimpleParam = false;
    private boolean bSimpleListParam = false;
    private boolean bAppContextParam = false;
    private boolean bWebContextParam = false;
    private boolean bWebResponseParam = false;
    private boolean bAppGlobalParam = false;
    private boolean bOriginEntity = false;
    private String strFileType = null;
    private String strFileUrl = null;
    private boolean bChatCompletionRequestParam = false;
    private boolean bChatCompletionResultParam = false;
    private int nStdDataType = 0;
    private String strDefaultValue = null;
    private boolean bCloneParam = false;
    private IPSAppDELogic iPSAppDELogic = null;
    private IPSAppDataEntity paramPSAppDataEntity;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSSFXCodeObject iPSSFXCodeObject = null;
    private Properties params = null;
    private IPSSysTranslator iPSSysTranslator = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDELogic iPSDELogic, PSDELogicParam psDELogicParam) throws Exception {
        try {
            IPSAppDELogic iPSAppDELogic;
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDELogic = iPSDELogic;
            this.psDELogicParam = psDELogicParam;
            this.setId(this.psDELogicParam.getPSDELOGICPARAMID());
            this.setName(this.psDELogicParam.getLOGICNAME());
            this.setPSObjectData(this.psDELogicParam);
            if (iPSDELogic instanceof IPSAppDELogic && (iPSAppDELogic = (IPSAppDELogic)iPSDELogic).getPSAppDataEntity() != null) {
                this.iPSAppDELogic = iPSAppDELogic;
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDELogicParam.getPARAMS())) {
                this.params = PropertiesHelper.load((String)this.psDELogicParam.getPARAMS());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDELogicParam.getPARAMPSDEID())) {
                this.paramPSDataEntity = StringHelper.compare((String)this.psDELogicParam.getPARAMPSDEID(), (String)this.iPSDELogic.getPSDataEntity().getId(), (boolean)false) == 0 ? this.iPSDELogic.getPSDataEntity() : this.iPSDELogic.getPSDataEntity().getPSSystem().getPSDataEntity2(this.psDELogicParam.getPARAMPSDEID());
                if (this.getPSAppDELogic() != null && this.getParamPSDataEntity() != null) {
                    this.paramPSAppDataEntity = this.getPSAppDELogic().getPSAppDataEntity().getPSApplication().getPSAppDataEntity(this.getParamPSDataEntity(), true);
                }
            }
            if (!psDELogicParam.isDEFAULTPARAMNull()) {
                this.bDefaultParam = psDELogicParam.getDEFAULTPARAM();
            }
            if (this.isDefault() && this.getParamPSDataEntity() == null && StringHelper.compare((String)iPSDELogic.getLogicType(), (String)"DELOGIC", (boolean)true) == 0) {
                this.paramPSDataEntity = this.iPSDELogic.getPSDataEntity();
            }
            if (!this.psDELogicParam.isGLOBALPARAMNull()) {
                switch (this.psDELogicParam.getGLOBALPARAM()) {
                    case 0: {
                        this.bEntityParam = true;
                        break;
                    }
                    case 2: {
                        this.bEnvParam = true;
                        break;
                    }
                    case 1: {
                        this.bSessionParam = true;
                        break;
                    }
                    case 3: {
                        this.bLastParam = true;
                        break;
                    }
                    case 5: {
                        this.bFilterParam = true;
                        break;
                    }
                    case 6: {
                        this.bEntityListParam = true;
                        break;
                    }
                    case 12: {
                        this.bEntityMapParam = true;
                        break;
                    }
                    case 4: {
                        this.bLastReturnParam = true;
                        break;
                    }
                    case 7: {
                        this.bEntityPageParam = true;
                        break;
                    }
                    case 8: {
                        this.bFileParam = true;
                        break;
                    }
                    case 9: {
                        this.bFileListParam = true;
                        break;
                    }
                    case 10: {
                        this.bSimpleParam = true;
                        break;
                    }
                    case 11: {
                        this.bSimpleListParam = true;
                        break;
                    }
                    case 24: {
                        this.bAppContextParam = true;
                        break;
                    }
                    case 31: {
                        this.bWebContextParam = true;
                        break;
                    }
                    case 32: {
                        this.bWebResponseParam = true;
                        break;
                    }
                    case 27: {
                        this.bAppGlobalParam = true;
                        break;
                    }
                    case 13: {
                        this.bChatCompletionRequestParam = true;
                        break;
                    }
                    case 14: {
                        this.bChatCompletionResultParam = true;
                    }
                }
            } else {
                this.bEntityParam = true;
            }
            if ((this.isSimpleParam() || this.isSimpleListParam()) && !this.psDELogicParam.isSTDDATATYPENull()) {
                this.nStdDataType = this.psDELogicParam.getSTDDATATYPE();
            }
            if (this.isSimpleParam() && !StringHelper.isNullOrEmpty((String)this.psDELogicParam.getDEFAULTVALUE())) {
                this.strDefaultValue = this.psDELogicParam.getDEFAULTVALUE();
            }
            if (this.isAppContextParam() && !this.psDELogicParam.isCLONEPARAMFLAGNull()) {
                this.bCloneParam = this.psDELogicParam.getCLONEPARAMFLAG();
            }
            if (this.isFileParam()) {
                this.strFileType = this.psDELogicParam.getFILETYPE();
                if (StringHelper.isNullOrEmpty((String)this.strFileType)) {
                    this.strFileType = "TEMP";
                }
                this.strFileUrl = this.psDELogicParam.getFILEURL();
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.psDELogicParam.getPSSYSTRANSLATORID())) {
            this.iPSSysTranslator = this.getPSDELogic().getPSDataEntity().getPSSystem().getPSSysTranslator(this.psDELogicParam.getPSSYSTRANSLATORID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDELogicParam.getPSSYSSFPLUGINID())) {
            this.iPSSysSFPlugin = this.getPSDELogic().getPSDataEntity().getPSSystem().getPSSysSFPlugin(this.psDELogicParam.getPSSYSSFPLUGINID());
        }
        if (this.getPSSysSFPlugin() != null) {
            String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSDELogic().getPSDataEntity().getPSSystem().getPSSFId());
            IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSDELogic().getPSDataEntity().getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
            if (iPSSysSFPluginTempl != null) {
                this.iPSSFXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
            }
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psDELogicParam.getPSDELOGICPARAMNAME();
    }

    @Override
    @PSModelRTMeta(description="\u53c2\u6570\u5b9e\u4f53\u5bf9\u8c61", dumpref=true, ignorepf=true, fields={"PARAMPSDEID"})
    public IPSDataEntity getParamPSDataEntity() throws Exception {
        return this.paramPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u903b\u8f91\u5bf9\u8c61", outputdoc="false")
    public IPSDELogic getPSDELogic() {
        return this.iPSDELogic;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDELogic().getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u53c2\u6570", ignoredumpvalues="false", group="\u57fa\u672c", order=125, fields={"DEFAULTPARAM"})
    public boolean isDefault() {
        return this.bDefaultParam;
    }

    @Override
    @PSModelRTMeta(description="\u64cd\u4f5c\u4f1a\u8bdd\u53d8\u91cf", ignoredumpvalues="false")
    public boolean isSessionParam() {
        return this.bSessionParam;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u73af\u5883\u53d8\u91cf", ignoredumpvalues="false")
    public boolean isEnvParam() {
        return this.bEnvParam;
    }

    @Override
    @PSModelRTMeta(description="\u6700\u540e\u6570\u636e\u53d8\u91cf", ignoredumpvalues="false")
    public boolean isLastParam() {
        return this.bLastParam;
    }

    @Override
    public String getModelType() {
        if (this.getPSAppDELogic() != null) {
            return "PSAPPDELOGICPARAM";
        }
        return "PSDELOGICPARAM";
    }

    @Override
    public String getModelId() {
        if (this.getPSAppDELogic() != null) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSAppDELogic().getModelId(), (Object)super.getModelId());
        }
        return super.getModelId();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDELogic().getPSDataEntity().getPSSystem());
    }

    @Override
    public IPSAppDELogic getPSAppDELogic() {
        return this.iPSAppDELogic;
    }

    @Override
    @PSModelRTMeta(description="\u53c2\u6570\u5e94\u7528\u5b9e\u4f53\u5bf9\u8c61", hideempty=true, dumpref=true)
    public IPSAppDataEntity getParamPSAppDataEntity() throws Exception {
        return this.paramPSAppDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u53c2\u6570\u6807\u8bb0", fields={"PARAMTAG"})
    public String getParamTag() {
        return this.psDELogicParam.getPARAMTAG();
    }

    @Override
    @PSModelRTMeta(description="\u53c2\u6570\u6807\u8bb02", fields={"PARAMTAG2"})
    public String getParamTag2() {
        return this.psDELogicParam.getPARAMTAG2();
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        if (this.getPSDELogic() != null) {
            return this.getPSDELogic();
        }
        return super.onGetParentModel();
    }

    @Override
    protected String onGetMOSFolder() {
        if (this.getPSDELogic() != null) {
            return String.format("%1$s/%2$s", this.getPSDELogic().getMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase();
    }

    @Override
    protected String onGetRTMOSFolder() {
        if (this.getPSDELogic() != null) {
            return String.format("%1$s/%2$s", this.getPSDELogic().getRTMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5bf9\u8c61\u53d8\u91cf", ignoredumpvalues="false")
    public boolean isEntityParam() {
        return this.bEntityParam;
    }

    @Override
    @PSModelRTMeta(description="\u8fc7\u6ee4\u5668\u5bf9\u8c61\u53d8\u91cf", ignoredumpvalues="false")
    public boolean isFilterParam() {
        return this.bFilterParam;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5bf9\u8c61\u5217\u8868\u53d8\u91cf", ignoredumpvalues="false")
    public boolean isEntityListParam() {
        return this.bEntityListParam;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5bf9\u8c61\u5b57\u5178\u53d8\u91cf", ignoredumpvalues="false")
    public boolean isEntityMapParam() {
        return this.bEntityMapParam;
    }

    @Override
    @PSModelRTMeta(description="\u4e0a\u4e00\u6b21\u8c03\u7528\u8fd4\u56de\u53d8\u91cf", ignoredumpvalues="false")
    public boolean isLastReturnParam() {
        return this.bLastReturnParam;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u9875\u67e5\u8be2\u7ed3\u679c\u53d8\u91cf", ignoredumpvalues="false")
    public boolean isEntityPageParam() {
        return this.bEntityPageParam;
    }

    @Override
    @PSModelRTMeta(description="\u6587\u4ef6\u5bf9\u8c61\u5217\u8868\u53d8\u91cf", ignoredumpvalues="false")
    public boolean isFileListParam() {
        return this.bFileListParam;
    }

    @Override
    @PSModelRTMeta(description="\u6587\u4ef6\u5bf9\u8c61\u53d8\u91cf", ignoredumpvalues="false")
    public boolean isFileParam() {
        return this.bFileParam;
    }

    @Override
    @PSModelRTMeta(description="\u7b80\u5355\u6570\u636e\u5217\u8868\u53d8\u91cf", ignoredumpvalues="false")
    public boolean isSimpleListParam() {
        return this.bSimpleListParam;
    }

    @Override
    @PSModelRTMeta(description="\u7b80\u5355\u6570\u636e\u53d8\u91cf", ignoredumpvalues="false")
    public boolean isSimpleParam() {
        return this.bSimpleParam;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u4e0a\u4e0b\u6587\u53d8\u91cf", ignoredumpvalues="false")
    public boolean isAppContextParam() {
        return this.bAppContextParam;
    }

    @Override
    @PSModelRTMeta(description="Web\u4e0a\u4e0b\u6587\u53d8\u91cf", ignoredumpvalues="false")
    public boolean isWebContextParam() {
        return this.bWebContextParam;
    }

    @Override
    @PSModelRTMeta(description="Web\u53cd\u9988\u53d8\u91cf", ignoredumpvalues="false")
    public boolean isWebResponseParam() {
        return this.bWebResponseParam;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5168\u5c40\u53d8\u91cf", ignoredumpvalues="false")
    public boolean isAppGlobalParam() {
        return this.bAppGlobalParam;
    }

    @Override
    @PSModelRTMeta(description="AI\u4ea4\u8c08\u8bf7\u6c42\u53d8\u91cf", ignorepf=true, ignoredumpvalues="false")
    public boolean isChatCompletionRequestParam() {
        return this.bChatCompletionRequestParam;
    }

    @Override
    @PSModelRTMeta(description="AI\u4ea4\u8c08\u7ed3\u679c\u53d8\u91cf", ignorepf=true, ignoredumpvalues="false")
    public boolean isChatCompletionResultParam() {
        return this.bChatCompletionResultParam;
    }

    @Override
    @PSModelRTMeta(description="\u7b80\u5355\u6570\u636e\u7c7b\u578b", codelist="StdDataType", ignoredumpvalues="0", fields={"STDDATATYPE"})
    public int getStdDataType() {
        return this.nStdDataType;
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0", hideempty2=true, fields={"LOGICNAME"})
    public String getLogicName() {
        return this.psDELogicParam.getLOGICNAME();
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u6269\u5c55\u63d2\u4ef6", hideempty=true, ignorepf=true)
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u7ed8\u5236\u5668", hideempty=true)
    public IPSSFXCodeObject getRender() {
        return this.iPSSFXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u503c\u7c7b\u578b", hideempty2=true)
    public String getDefaultValueType() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u503c", hideempty2=true, fields={"DEFAULTVALUE"})
    public String getDefaultValue() {
        return this.strDefaultValue;
    }

    @Override
    @PSModelRTMeta(description="\u514b\u9686\u4f20\u5165\u53c2\u6570", ignoredumpvalues="false", fields={"CLONEPARAMFLAG"})
    public boolean isCloneParam() {
        return this.bCloneParam;
    }

    @Override
    @PSModelRTMeta(description="\u539f\u59cb\u6570\u636e\u5bf9\u8c61", ignoredumpvalues="false")
    public boolean isOriginEntity() {
        return this.bOriginEntity;
    }

    @Override
    @PSModelRTMeta(description="\u6587\u4ef6\u7c7b\u578b", hideempty=true, codelist="DELogicParamFileType", fields={"FILETYPE"})
    public String getFileType() {
        return this.strFileType;
    }

    @Override
    @PSModelRTMeta(description="\u6587\u4ef6\u8def\u5f84", hideempty2=true, fields={"FILEURL"})
    public String getFileUrl() {
        return this.strFileUrl;
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u53c2\u6570", hideempty=true, fields={"PARAMS"})
    public Properties getParams() {
        return this.params;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u8f6c\u6362\u5668\u5bf9\u8c61", dumpref=true, ignorepf=true, fields={"PSSYSTRANSLATORID"})
    public IPSSysTranslator getPSSysTranslator() {
        return this.iPSSysTranslator;
    }
}

