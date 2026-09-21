/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.Inflector
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEFLogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEFUIMode;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDELogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.DataEntity.PSAppDEFUIModeGlobalModel;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.ValueRule.IPSAppValueRule;
import SA.SRFDA.PS.Core.DEField.IPSDEFGroupDetail;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIField;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemRuntime;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.ValueRule.IPSSysValueRule;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.Inflector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppDEFieldImpl2
extends PSObjectImpl
implements IPSAppDEField {
    private static final Log log = LogFactory.getLog(PSAppDEFieldImpl2.class);
    private static final ArrayList<IPSAppDEFLogic> emptyPSAppDEFLogicList = new ArrayList();
    private IPSAppDataEntity iPSAppDataEntity = null;
    private IPSDEField iPSDEField = null;
    private IPSDEFGroupDetail iPSDEFGroupDetail = null;
    private IPSDEServiceAPIField iPSDEServiceAPIField = null;
    private IPSDEServiceAPIField refPSDEServiceAPIField = null;
    private ArrayList<IPSAppDEFLogic> psAppDEFLogicList = null;
    private String strDefaultValue = "";
    private boolean bDataTypeField = false;
    private IPSAppValueRule iPSAppValueRule = null;
    protected PSAppDEFUIModeGlobalModel psAppDEFUIModeGlobalModel = new PSAppDEFUIModeGlobalModel();

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppDataEntity iPSAppDataEntity, Object objDEField) throws Exception {
        try {
            String strPSSysValueRuleId;
            IPSSystemRuntime iPSSystemRuntime;
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSAppDataEntity = iPSAppDataEntity;
            if (objDEField instanceof IPSDEServiceAPIField) {
                this.iPSDEServiceAPIField = (IPSDEServiceAPIField)objDEField;
                this.iPSDEField = this.iPSDEServiceAPIField.getPSDEField();
                this.refPSDEServiceAPIField = this.iPSDEServiceAPIField;
            } else if (objDEField instanceof IPSDEFGroupDetail) {
                this.iPSDEFGroupDetail = (IPSDEFGroupDetail)objDEField;
                this.iPSDEField = this.iPSDEFGroupDetail.getPSDEField();
            } else if (objDEField instanceof IPSDEField) {
                this.iPSDEField = (IPSDEField)objDEField;
            }
            if (this.getPSDEField() == null) {
                throw new Exception("\u5b9e\u4f53\u5c5e\u6027\u65e0\u6548");
            }
            this.setId(this.getPSDEField().getId());
            this.setName(this.getPSDEField().getName());
            this.setAutoModel(true);
            if (this.refPSDEServiceAPIField == null && this.getPSAppDataEntity().getPSDEServiceAPI() != null) {
                this.refPSDEServiceAPIField = this.getPSAppDataEntity().getPSDEServiceAPI().getPSDEServiceAPIField(this.getName(), true);
            }
            if (this.getPSDEField().getPSDataEntity().getDataTypePSDEField() != null && StringHelper.compare((String)this.getPSDEField().getId(), (String)this.getPSDEField().getPSDataEntity().getDataTypePSDEField().getId(), (boolean)false) == 0) {
                this.bDataTypeField = true;
            }
            if (this.isDataTypeField() && this.getPSSystem() instanceof IPSSystemRuntime && (iPSSystemRuntime = (IPSSystemRuntime)((Object)this.getPSSystem())).getDynaInstMode() == 2 && this.getPSDEField().getPSCodeList() != null && this.getPSDEField().getPSCodeList().isModuleInstCodeList() && StringHelper.compare((String)iPSSystemRuntime.getDynaInstTag(), (String)this.getPSDEField().getPSCodeList().getDynaInstTag(), (boolean)false) == 0) {
                this.strDefaultValue = iPSSystemRuntime.getDynaInstTag2();
            }
            if (!StringHelper.isNullOrEmpty((String)(strPSSysValueRuleId = this.getPSSysValueRuleId()))) {
                this.iPSAppValueRule = this.getPSApplication().getPSAppValueRule(strPSSysValueRuleId);
            }
            if (this.getLNPSLanguageRes() != null) {
                this.getPSApplication().getPSLanguageRes(this.getLNPSLanguageRes().getId());
            }
            if (this.getQSPHPSLanguageRes() != null) {
                this.getPSApplication().getPSLanguageRes(this.getQSPHPSLanguageRes().getId());
            }
            this.psAppDEFUIModeGlobalModel.Init(this.getDAGlobalHelper(), this);
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
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53", outputdoc="false")
    public IPSAppDataEntity getPSAppDataEntity() {
        return this.iPSAppDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5c5e\u6027", group="\u57fa\u672c", order=132)
    public IPSDEField getPSDEField() {
        return this.iPSDEField;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSAppDataEntity().getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSAPPDEFIELD";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSAppDataEntity().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSAppDataEntity().getPSApplication().getPSSystem());
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSAppDataEntity().getModelId(), (Object)this.getName());
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        if (this.iPSDEServiceAPIField != null) {
            return this.iPSDEServiceAPIField.getCodeName();
        }
        if (this.iPSDEFGroupDetail != null) {
            return this.iPSDEFGroupDetail.getCodeName();
        }
        return this.getPSDEField().getCodeName();
    }

    @Override
    @PSModelRTMeta(description="\u6392\u5e8f\u503c", dump=false)
    public int getOrderValue() {
        if (this.iPSDEServiceAPIField != null) {
            return this.iPSDEServiceAPIField.getOrderValue();
        }
        if (this.iPSDEFGroupDetail != null) {
            return this.iPSDEFGroupDetail.getOrderValue();
        }
        return this.getPSDEField().getOrderValue();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f02", hideempty2=true, dump=false)
    public String getCodeName2() {
        return this.onGetCodeName2();
    }

    protected String onGetCodeName2() {
        if (this.iPSDEServiceAPIField != null) {
            return this.iPSDEServiceAPIField.getCodeName2();
        }
        if (this.iPSDEFGroupDetail != null) {
            return this.iPSDEFGroupDetail.getCodeName2();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u6807\u8bb0", hideempty2=true)
    public String getUserTag() {
        if (this.iPSDEServiceAPIField != null) {
            return this.iPSDEServiceAPIField.getUserTag();
        }
        if (this.iPSDEFGroupDetail != null) {
            return this.iPSDEFGroupDetail.getUserTag();
        }
        return this.getPSDEField().getUserTag();
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u6807\u8bb02", hideempty2=true)
    public String getUserTag2() {
        if (this.iPSDEServiceAPIField != null) {
            return this.iPSDEServiceAPIField.getUserTag2();
        }
        if (this.iPSDEFGroupDetail != null) {
            return this.iPSDEFGroupDetail.getUserTag2();
        }
        return this.getPSDEField().getUserTag2();
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u6807\u8bb03", hideempty2=true)
    public String getUserTag3() {
        if (this.iPSDEServiceAPIField != null) {
            return this.iPSDEServiceAPIField.getUserTag3();
        }
        if (this.iPSDEFGroupDetail != null) {
            return this.iPSDEFGroupDetail.getUserTag3();
        }
        return this.getPSDEField().getUserTag3();
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u6807\u8bb04", hideempty2=true)
    public String getUserTag4() {
        if (this.iPSDEServiceAPIField != null) {
            return this.iPSDEServiceAPIField.getUserTag4();
        }
        if (this.iPSDEFGroupDetail != null) {
            return this.iPSDEFGroupDetail.getUserTag4();
        }
        return this.getPSDEField().getUserTag4();
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u6a21\u578b\u5206\u7c7b", hideempty2=true)
    public String getUserCat() {
        if (this.iPSDEServiceAPIField != null) {
            return this.iPSDEServiceAPIField.getUserCat();
        }
        if (this.iPSDEFGroupDetail != null) {
            return this.iPSDEFGroupDetail.getUserCat();
        }
        return this.getPSDEField().getUserCat();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\u5c5e\u6027", hideempty=true)
    public IPSDEServiceAPIField getPSDEServiceAPIField() {
        return this.refPSDEServiceAPIField;
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u952e\u5c5e\u6027", ignoredumpvalues="false", ignorert=3)
    public boolean isKeyField() {
        if (this.iPSDEServiceAPIField != null) {
            return this.iPSDEServiceAPIField.isKeyField();
        }
        return this.iPSDEField.isKeyDEField();
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u4fe1\u606f\u5c5e\u6027", ignoredumpvalues="false", ignorert=3)
    public boolean isMajorField() {
        if (this.iPSDEServiceAPIField != null) {
            return this.iPSDEServiceAPIField.isMajorField();
        }
        return this.iPSDEField.isMajorDEField();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u7c7b\u578b\u5c5e\u6027", ignoredumpvalues="false", ignorert=3)
    public boolean isDataTypeField() {
        return this.bDataTypeField;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u51c6\u6570\u636e\u7c7b\u578b", codelist="StdDataType", group="\u57fa\u672c", order=131)
    public int getStdDataType() {
        if (this.iPSDEServiceAPIField != null) {
            return this.iPSDEServiceAPIField.getStdDataType();
        }
        return this.iPSDEField.getStdDataType();
    }

    public IPSApplication getPSApplication() {
        return this.getPSAppDataEntity().getPSApplication();
    }

    public IPSSystem getPSSystem() {
        return this.getPSApplication().getPSSystem();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u5feb\u901f\u641c\u7d22", ignoredumpvalues="false")
    public boolean isEnableQuickSearch() {
        return this.getPSDEField().isEnableQuickSearch();
    }

    @Override
    @PSModelRTMeta(description="\u503c\u683c\u5f0f\u5316")
    public String getValueFormat() {
        if (this.getPSApplication().isUseServiceApi()) {
            return this.getPSDEField().getJSFormat();
        }
        return this.getPSDEField().getValueFormat();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027\u903b\u8f91\u96c6\u5408", outputdoc="false")
    public synchronized Iterator<IPSAppDEFLogic> getAllPSAppDEFLogics() throws Exception {
        if (this.psAppDEFLogicList == null) {
            ArrayList<IPSAppDEFLogic> psAppDEFLogicList = new ArrayList<IPSAppDEFLogic>();
            Iterator<IPSAppDELogic> psAppDELogics = this.getPSAppDataEntity().getAllPSAppDELogics();
            if (psAppDELogics != null) {
                while (psAppDELogics.hasNext()) {
                    IPSAppDEFLogic iPSAppDEFLogic;
                    IPSAppDELogic iPSAppDELogic = psAppDELogics.next();
                    if (!(iPSAppDELogic instanceof IPSAppDEFLogic) || (iPSAppDEFLogic = (IPSAppDEFLogic)iPSAppDELogic).getPSAppDEField() == null || StringHelper.compare((String)iPSAppDEFLogic.getPSAppDEField().getId(), (String)this.getId(), (boolean)false) != 0) continue;
                    psAppDEFLogicList.add(iPSAppDEFLogic);
                }
            }
            if (this.psAppDEFLogicList == null) {
                this.psAppDEFLogicList = psAppDEFLogicList.size() != 0 ? psAppDEFLogicList : emptyPSAppDEFLogicList;
            }
        }
        return this.psAppDEFLogicList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u503c\u903b\u8f91", dumpref=true, from="IPSAppDataEntity", from_method="getPSAppDELogic", origin="IPSAppDEFLogic", group="\u903b\u8f91", order=210)
    public IPSAppDEFLogic getDefaultValuePSAppDEFLogic() throws Exception {
        return this.getPSAppDEFLogicByMode("DEFAULT");
    }

    @Override
    @PSModelRTMeta(description="\u503c\u53d8\u66f4\u903b\u8f91", dumpref=true, from="IPSAppDataEntity", from_method="getPSAppDELogic", origin="IPSAppDEFLogic", order=211)
    public IPSAppDEFLogic getOnChangePSAppDEFLogic() throws Exception {
        return this.getPSAppDEFLogicByMode("ONCHANGE");
    }

    @Override
    @PSModelRTMeta(description="\u503c\u8ba1\u7b97\u903b\u8f91", dumpref=true, from="IPSAppDataEntity", from_method="getPSAppDELogic", origin="IPSAppDEFLogic", order=212)
    public IPSAppDEFLogic getComputePSAppDEFLogic() throws Exception {
        return this.getPSAppDEFLogicByMode("COMPUTE");
    }

    protected IPSAppDEFLogic getPSAppDEFLogicByMode(String strMode) throws Exception {
        Iterator<IPSAppDEFLogic> psAppDEFLogics = this.getAllPSAppDEFLogics();
        if (psAppDEFLogics != null) {
            while (psAppDEFLogics.hasNext()) {
                IPSAppDEFLogic iPSAppDEFLogic = psAppDEFLogics.next();
                if (!iPSAppDEFLogic.isEnableFront() || StringHelper.compare((String)iPSAppDEFLogic.getDEFLogicMode(), (String)strMode, (boolean)false) != 0) continue;
                return iPSAppDEFLogic;
            }
        }
        return null;
    }

    @Override
    protected void onFillModelRefNode(ObjectNode objectNode, String strModelRefType) throws Exception {
        PSAppDEFieldImpl2.putJsonProperty(objectNode, "name", this.getName());
        PSAppDEFieldImpl2.putJsonProperty(objectNode, "codeName", this.getCodeName());
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0")
    public String getLogicName() {
        if (this.iPSDEServiceAPIField != null) {
            return this.iPSDEServiceAPIField.getLogicName();
        }
        if (this.iPSDEFGroupDetail != null) {
            return this.iPSDEFGroupDetail.getLogicName();
        }
        return this.getPSDEField().getLogicName();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u503c\u7c7b\u578b", codelist="DEFDefaultValueType")
    public String getDefaultValueType() {
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u503c")
    public String getDefaultValue() {
        return this.strDefaultValue;
    }

    public String getPSSysValueRuleId() throws Exception {
        if (this.iPSDEServiceAPIField != null) {
            if (this.iPSDEServiceAPIField.getPSSysValueRule() != null) {
                return this.iPSDEServiceAPIField.getPSSysValueRule().getId();
            }
            return "";
        }
        if (this.iPSDEFGroupDetail != null) {
            if (this.iPSDEFGroupDetail.getPSSysValueRule() != null) {
                return this.iPSDEFGroupDetail.getPSSysValueRule().getId();
            }
            return "";
        }
        return this.getPSDEField().getPSSysValueRuleId();
    }

    @Override
    @PSModelRTMeta(description="\u5b57\u7b26\u4e32\u957f\u5ea6", ignoredumpvalues="0;-1")
    public int getStringLength() {
        if (this.iPSDEServiceAPIField != null) {
            return this.iPSDEServiceAPIField.getStringLength();
        }
        if (this.iPSDEFGroupDetail != null) {
            return this.iPSDEFGroupDetail.getStringLength();
        }
        return this.getPSDEField().getStringLength();
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5c0f\u5b57\u7b26\u4e32\u957f\u5ea6", ignoredumpvalues="0;-1")
    public int getMinStringLength() {
        if (this.iPSDEServiceAPIField != null) {
            return this.iPSDEServiceAPIField.getMinStringLength();
        }
        if (this.iPSDEFGroupDetail != null) {
            return this.iPSDEFGroupDetail.getMinStringLength();
        }
        return this.getPSDEField().getMinStringLength();
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5927\u503c\uff08\u5b57\u7b26\u4e32\uff09")
    public String getMaxValueString() {
        if (this.iPSDEServiceAPIField != null) {
            return this.iPSDEServiceAPIField.getMaxValueString();
        }
        if (this.iPSDEFGroupDetail != null) {
            return this.iPSDEFGroupDetail.getMaxValueString();
        }
        return this.getPSDEField().getMaxValueString();
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5c0f\u503c\uff08\u5b57\u7b26\u4e32\uff09")
    public String getMinValueString() {
        if (this.iPSDEServiceAPIField != null) {
            return this.iPSDEServiceAPIField.getMinValueString();
        }
        if (this.iPSDEFGroupDetail != null) {
            return this.iPSDEFGroupDetail.getMinValueString();
        }
        return this.getPSDEField().getMinValueString();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u7cbe\u5ea6", ignoredumpvalues="0")
    public int getPrecision() {
        if (this.iPSDEServiceAPIField != null) {
            return this.iPSDEServiceAPIField.getPrecision();
        }
        if (this.iPSDEFGroupDetail != null) {
            return this.iPSDEFGroupDetail.getPrecision();
        }
        return this.getPSDEField().getPrecision();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u503c\u89c4\u5219")
    public IPSSysValueRule getPSSysValueRule() throws Exception {
        return this.iPSAppValueRule;
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getLNPSLanguageRes() {
        if (this.iPSDEServiceAPIField != null) {
            return this.iPSDEServiceAPIField.getLNPSLanguageRes();
        }
        if (this.iPSDEFGroupDetail != null) {
            return this.iPSDEFGroupDetail.getLNPSLanguageRes();
        }
        return this.getPSDEField().getLNPSLanguageRes();
    }

    @Override
    @PSModelRTMeta(description="\u4ec5\u652f\u6301\u524d\u7aef", ignoredumpvalues="false", ignorert=3)
    public boolean isEnableFrontOnly() {
        return this.getPSDEServiceAPIField() == null;
    }

    @Override
    protected String onGetMOSFilePath() {
        return null;
    }

    @Override
    protected String onGetRTMOSFolder() {
        if (this.getPSAppDataEntity() != null) {
            return String.format("%1$s/%2$s", this.getPSAppDataEntity().getRTMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase();
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        return this.getPSAppDataEntity();
    }

    @Override
    public IPSAppDEFUIMode getPSAppDEFUIMode(String strPSAppDEFUIModeId) throws Exception {
        return (IPSAppDEFUIMode)this.psAppDEFUIModeGlobalModel.FindModelHelper(strPSAppDEFUIModeId);
    }

    @Override
    public IPSAppDEFUIMode getPSAppDEFUIMode(String strPSAppDEFUIModeId, boolean bTryMode) throws Exception {
        return (IPSAppDEFUIMode)this.psAppDEFUIModeGlobalModel.FindModelHelper(strPSAppDEFUIModeId, bTryMode);
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u96c6\u5408", child=true, dynamodelmode=8, outputdoc="false")
    public Iterator<IPSAppDEFUIMode> getAllPSAppDEFUIModes() throws Exception {
        return this.psAppDEFUIModeGlobalModel.getAllModelHelpers();
    }

    @Override
    @PSModelRTMeta(description="\u5feb\u901f\u641c\u7d22\u5360\u4f4d\u63d0\u793a\u4fe1\u606f", doc="\u901a\u8fc7\u5b9e\u4f53\u5c5e\u6027\u7684\u9ed8\u8ba4\u641c\u7d22\u6a21\u5f0f{@link net.ibizsys.model.dataentity.defield.IPSDEField#getDefaultPSDEFSearchMode()}\u8ba1\u7b97")
    public String getQuickSearchPlaceHolder() {
        if (!this.isEnableQuickSearch()) {
            return null;
        }
        if (this.getPSDEField().getDefaultPSDEFSearchMode() != null) {
            return this.getPSDEField().getDefaultPSDEFSearchMode().getPlaceHolder();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5feb\u901f\u641c\u7d22\u5360\u4f4d\u63d0\u793a\u4fe1\u606f\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getQSPHPSLanguageRes() {
        if (!this.isEnableQuickSearch()) {
            return null;
        }
        if (this.getPSDEField().getDefaultPSDEFSearchMode() != null) {
            return this.getPSDEField().getDefaultPSDEFSearchMode().getPHPSLanguageRes();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u9884\u7f6e\u4e1a\u52a1\u7c7b\u578b", codelist="PredefinedFieldType", ignoredumpvalues="NONE")
    public String getPredefinedType() {
        return this.getPSDEField().getPredefinedType();
    }
}

