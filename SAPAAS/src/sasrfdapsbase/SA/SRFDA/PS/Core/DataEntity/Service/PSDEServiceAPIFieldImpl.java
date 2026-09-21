/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Service;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.DEField.IPSDEFGroupDetail;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPI;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIField;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.ValueRule.IPSSysValueRule;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEServiceAPIFieldImpl
extends PSObjectImpl
implements IPSDEServiceAPIField {
    private static final Log log = LogFactory.getLog(PSDEServiceAPIFieldImpl.class);
    private IPSDEServiceAPI iPSDEServiceAPI = null;
    private IPSDEField iPSDEField = null;
    private IPSDEFGroupDetail iPSDEFGroupDetail = null;
    private IPSSysValueRule iPSSysValueRule = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEServiceAPI iPSDEServiceAPI, Object objDEField) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEServiceAPI = iPSDEServiceAPI;
            if (objDEField instanceof IPSDEFGroupDetail) {
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
            if (this.iPSDEFGroupDetail != null) {
                this.iPSSysValueRule = this.iPSDEFGroupDetail.getPSSysValueRule();
            } else if (!StringHelper.isNullOrEmpty((String)this.getPSDEField().getPSSysValueRuleId())) {
                this.iPSSysValueRule = this.getPSDEServiceAPI().getPSSysServiceAPI().getPSSystem().getPSSysValueRule(this.getPSDEField().getPSSysValueRuleId());
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
    public IPSDEServiceAPI getPSDEServiceAPI() {
        return this.iPSDEServiceAPI;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5c5e\u6027")
    public IPSDEField getPSDEField() {
        return this.iPSDEField;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDEServiceAPI().getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSDESERVICEAPIFIELD";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSDEServiceAPI().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEServiceAPI().getPSDataEntity().getPSSystem());
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDEServiceAPI().getModelId(), (Object)this.getName());
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        try {
            return this.getPSDEServiceAPI().getPSSysServiceAPI().getAPICodeName(null, this.calcCodeName(), null);
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return this.calcCodeName();
        }
    }

    protected String calcCodeName() {
        if (this.iPSDEFGroupDetail != null) {
            return this.iPSDEFGroupDetail.getServiceCodeName();
        }
        return this.getPSDEField().getServiceCodeName();
    }

    @Override
    @PSModelRTMeta(description="\u6392\u5e8f\u503c")
    public int getOrderValue() {
        if (this.iPSDEFGroupDetail != null) {
            return this.iPSDEFGroupDetail.getOrderValue();
        }
        return this.getPSDEField().getOrderValue();
    }

    @Override
    @PSModelRTMeta(description="\u5141\u8bb8\u7a7a\u8f93\u5165")
    public boolean isAllowEmpty() {
        if (this.iPSDEFGroupDetail != null) {
            return this.iPSDEFGroupDetail.isAllowEmpty();
        }
        return this.getPSDEField().isAllowEmpty();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u4ee3\u7801\u8868")
    public IPSCodeList getPSCodeList() throws Exception {
        if (this.iPSDEFGroupDetail != null) {
            return this.iPSDEFGroupDetail.getPSCodeList();
        }
        return this.getPSDEField().getPSCodeList();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u503c\u89c4\u5219")
    public IPSSysValueRule getPSSysValueRule() throws Exception {
        return this.iPSSysValueRule;
    }

    @Override
    public boolean isEnableUserInsert() {
        if (this.iPSDEFGroupDetail != null) {
            return this.iPSDEFGroupDetail.isEnableUserInsert();
        }
        try {
            if (this.getPSDEServiceAPI().getPSSysServiceAPI().isCoreLevel()) {
                return this.getPSDEField().isEnableCreate();
            }
            if (this.getPSDEServiceAPI().getPSSysServiceAPI().isUserLevel()) {
                return this.getPSDEField().isEnableUICreate();
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        return this.getPSDEField().isEnableUserInsert();
    }

    @Override
    public boolean isEnableUserUpdate() {
        if (this.iPSDEFGroupDetail != null) {
            return this.iPSDEFGroupDetail.isEnableUserUpdate();
        }
        try {
            if (this.getPSDEServiceAPI().getPSSysServiceAPI().isCoreLevel()) {
                return this.getPSDEField().isEnableModify();
            }
            if (this.getPSDEServiceAPI().getPSSysServiceAPI().isUserLevel()) {
                return this.getPSDEField().isEnableUIModify();
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        return this.getPSDEField().isEnableUserUpdate();
    }

    @Override
    public boolean testUserInput(int nUserInput) {
        if (this.iPSDEFGroupDetail != null) {
            return this.iPSDEFGroupDetail.testUserInput(nUserInput);
        }
        return this.getPSDEField().testUserInput(nUserInput);
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f02", hideempty2=true)
    public String getCodeName2() {
        if (this.iPSDEFGroupDetail != null) {
            return this.iPSDEFGroupDetail.getCodeName2();
        }
        return this.getPSDEField().getCodeName();
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u6807\u8bb0", hideempty2=true)
    public String getUserTag() {
        if (this.iPSDEFGroupDetail != null) {
            return this.iPSDEFGroupDetail.getUserTag();
        }
        return this.getPSDEField().getUserTag();
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u6807\u8bb02", hideempty2=true)
    public String getUserTag2() {
        if (this.iPSDEFGroupDetail != null) {
            return this.iPSDEFGroupDetail.getUserTag2();
        }
        return this.getPSDEField().getUserTag2();
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u6807\u8bb03", hideempty2=true)
    public String getUserTag3() {
        if (this.iPSDEFGroupDetail != null) {
            return this.iPSDEFGroupDetail.getUserTag3();
        }
        return this.getPSDEField().getUserTag3();
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u6807\u8bb04", hideempty2=true)
    public String getUserTag4() {
        if (this.iPSDEFGroupDetail != null) {
            return this.iPSDEFGroupDetail.getUserTag4();
        }
        return this.getPSDEField().getUserTag4();
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u6a21\u578b\u5206\u7c7b", hideempty2=true)
    public String getUserCat() {
        if (this.iPSDEFGroupDetail != null) {
            return this.iPSDEFGroupDetail.getUserCat();
        }
        return this.getPSDEField().getUserCat();
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u952e\u5c5e\u6027")
    public boolean isKeyField() {
        return this.getPSDEField().isKeyDEField();
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u4fe1\u606f\u5c5e\u6027")
    public boolean isMajorField() {
        return this.getPSDEField().isMajorDEField();
    }

    @Override
    @PSModelRTMeta(description="\u6807\u51c6\u6570\u636e\u7c7b\u578b", codelist="StdDataType")
    public int getStdDataType() {
        return this.getPSDEField().getStdDataType();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u5efa\u7acb")
    public boolean isEnableCreate() {
        return this.isEnableUserInsert();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u4fee\u6539")
    public boolean isEnableModify() {
        return this.isEnableUserUpdate();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0")
    public String getLogicName() {
        if (this.iPSDEFGroupDetail != null) {
            return this.iPSDEFGroupDetail.getLogicName();
        }
        return this.getPSDEField().getLogicName();
    }

    @Override
    @PSModelRTMeta(description="\u5b57\u7b26\u4e32\u957f\u5ea6", ignoredumpvalues="0;-1")
    public int getStringLength() {
        if (this.iPSDEFGroupDetail != null) {
            return this.iPSDEFGroupDetail.getStringLength();
        }
        return this.getPSDEField().getStringLength();
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5c0f\u5b57\u7b26\u4e32\u957f\u5ea6", ignoredumpvalues="0;-1")
    public int getMinStringLength() {
        if (this.iPSDEFGroupDetail != null) {
            return this.iPSDEFGroupDetail.getMinStringLength();
        }
        return this.getPSDEField().getMinStringLength();
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5927\u503c\uff08\u5b57\u7b26\u4e32\uff09")
    public String getMaxValueString() {
        if (this.iPSDEFGroupDetail != null) {
            return this.iPSDEFGroupDetail.getMaxValueString();
        }
        return this.getPSDEField().getMaxValueString();
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5c0f\u503c\uff08\u5b57\u7b26\u4e32\uff09")
    public String getMinValueString() {
        if (this.iPSDEFGroupDetail != null) {
            return this.iPSDEFGroupDetail.getMinValueString();
        }
        return this.getPSDEField().getMinValueString();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u7cbe\u5ea6", ignoredumpvalues="0")
    public int getPrecision() {
        if (this.iPSDEFGroupDetail != null) {
            return this.iPSDEFGroupDetail.getPrecision();
        }
        return this.getPSDEField().getPrecision();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getLNPSLanguageRes() {
        if (this.iPSDEFGroupDetail != null) {
            return this.iPSDEFGroupDetail.getLNPSLanguageRes();
        }
        return this.getPSDEField().getLNPSLanguageRes();
    }

    @Override
    protected String onGetDynaModelFolder() {
        return null;
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        return this.getPSDEServiceAPI();
    }
}

