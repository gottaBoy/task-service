/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DEField;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEFGridColumn;
import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DEField.IPSDEFGroupDetail;
import SA.SRFDA.PS.Core.DEField.IPSDEFUIMode;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.ValueRule.IPSSysValueRule;
import SA.SRFDA.PS.Data.PSDEGridColumn;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Properties;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSDEFGroupDetailImpl4
extends PSObjectImpl
implements IPSDEFGroupDetail {
    private static final Log log = LogFactory.getLog(PSDEFGroupDetailImpl4.class);
    private IPSDEFGroup iPSDEFGroup = null;
    private PSDEGridColumn psDEGridColumn = null;
    private IPSDEField iPSDEField = null;
    private int nOrderValue = 1000;
    private String strCodeName = null;
    private String strServiceCodeName = null;
    private boolean bAllowEmpty = true;
    private IPSCodeList iPSCodeList = null;
    private IPSSysValueRule iPSSysValueRule = null;
    private int nUserInputMode = 0;
    private IPSDEFGridColumn iPSDEFGridColumn = null;
    private IPSDEFGroupDetail pickupTextPSDEFGroupDetail = null;
    private IPSLanguageRes lnPSLanguageRes = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEFGroup iPSDEFGroup, PSDEGridColumn psDEGridColumn) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEFGroup = iPSDEFGroup;
            this.psDEGridColumn = psDEGridColumn;
            this.setId(this.psDEGridColumn.getPSDEGRIDCOLID());
            this.setName(this.psDEGridColumn.getPSDEGRIDCOLNAME());
            this.setPSObjectData(this.psDEGridColumn);
            if (!StringHelper.isNullOrEmpty((String)psDEGridColumn.getPSDEFID()) && iPSDEFGroup.getPSDataEntity() != null) {
                this.iPSDEField = iPSDEFGroup.getPSDataEntity().getPSDEField(psDEGridColumn.getPSDEFID());
            }
            if (this.getPSDEField() == null) {
                throw new Exception("\u5b9e\u4f53\u5c5e\u6027\u65e0\u6548");
            }
            IPSDEFUIMode iPSDEFUIMode = null;
            iPSDEFUIMode = StringHelper.isNullOrEmpty((String)this.psDEGridColumn.getPSDEFUIMODEID()) ? this.getPSDEField().getPSDEFUIMode("DEFAULT") : this.getPSDEField().getPSDEFUIMode(this.psDEGridColumn.getPSDEFUIMODEID());
            this.iPSDEFGridColumn = iPSDEFUIMode.getPSDEFGridColumn();
            this.strCodeName = this.getPSDEField().getCodeName();
            this.strServiceCodeName = this.getPSDEField().getServiceCodeName();
            this.nOrderValue = this.getPSDEField().getOrderValue();
            this.bAllowEmpty = !this.psDEGridColumn.isALLOWEMPTYNull() ? this.psDEGridColumn.getALLOWEMPTY() : this.iPSDEFGridColumn.isAllowEmpty();
            if (!StringHelper.isNullOrEmpty((String)this.psDEGridColumn.getPSCODELISTID())) {
                this.iPSCodeList = this.getPSDEField().getPSDataEntity().getPSSystem().getPSCodeList(this.psDEGridColumn.getPSCODELISTID());
            } else if (!StringHelper.isNullOrEmpty((String)this.iPSDEFGridColumn.getPSCodeListId())) {
                this.iPSCodeList = this.getPSDEField().getPSDataEntity().getPSSystem().getPSCodeList(this.iPSDEFGridColumn.getPSCodeListId());
            }
            this.lnPSLanguageRes = !StringHelper.isNullOrEmpty((String)this.psDEGridColumn.getCAPPSLANRESID()) ? this.getPSDEField().getPSDataEntity().getPSSystem().getPSLanguageRes(this.psDEGridColumn.getCAPPSLANRESID()) : this.iPSDEFGridColumn.getCapPSLanguageRes();
            if (!StringHelper.isNullOrEmpty((String)this.getPSDEField().getPSSysValueRuleId())) {
                this.iPSSysValueRule = this.getPSDEField().getPSDataEntity().getPSSystem().getPSSysValueRule(this.getPSDEField().getPSSysValueRuleId());
            }
            this.nUserInputMode = this.getPSDEField().getUserInputMode();
            this.nUserInputMode = !this.psDEGridColumn.isENABLECONDNull() ? this.psDEGridColumn.getENABLECOND() : this.iPSDEFGridColumn.getEnableCond();
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
    public IPSDEFGroup getPSDEFGroup() {
        return this.iPSDEFGroup;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSDataEntity")
    public IPSDEField getPSDEField() {
        return this.iPSDEField;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDEFGroup().getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSDEFGROUPDETAIL";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSDEFGroup().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEFGroup().getPSDataEntity().getPSSystem());
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDEFGroup().getModelId(), (Object)super.getModelId());
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    public String getServiceCodeName() {
        return this.strServiceCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u6392\u5e8f\u503c")
    public int getOrderValue() {
        return this.nOrderValue;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f02", hideempty2=true)
    public String getCodeName2() {
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u5141\u8bb8\u7a7a\u8f93\u5165", ignoredumpvalues="true")
    public boolean isAllowEmpty() {
        return this.bAllowEmpty;
    }

    @Override
    @PSModelRTMeta(description="\u5b57\u7b26\u4e32\u957f\u5ea6", ignoredumpvalues="0;-1")
    public int getStringLength() {
        return this.getPSDEField().getStringLength();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u4ee3\u7801\u8868")
    public IPSCodeList getPSCodeList() throws Exception {
        return this.iPSCodeList;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u503c\u89c4\u5219")
    public IPSSysValueRule getPSSysValueRule() throws Exception {
        return this.iPSSysValueRule;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u7528\u6237\u8f93\u5165")
    public boolean isEnableUserInsert() {
        return (this.getUserInputMode() & 1) > 0;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u7528\u6237\u66f4\u65b0")
    public boolean isEnableUserUpdate() {
        return (this.getUserInputMode() & 2) > 0;
    }

    @Override
    public boolean testUserInput(int nUserInput) {
        return (this.getUserInputMode() & nUserInput) == nUserInput;
    }

    @Override
    public int getUserInputMode() {
        return this.nUserInputMode;
    }

    @Override
    @PSModelRTMeta(description="\u4e2d\u6587\u540d\u79f0")
    public String getLogicName() {
        String strCaption = this.psDEGridColumn.getCAPTION();
        if (!StringHelper.isNullOrEmpty((String)strCaption)) {
            return strCaption;
        }
        if (this.getPickupTextPSDEFGroupDetail() != null && !StringHelper.isNullOrEmpty((String)(strCaption = this.getPickupTextPSDEFGroupDetail().getLogicName()))) {
            return strCaption;
        }
        if (this.iPSDEFGridColumn != null && !StringHelper.isNullOrEmpty((String)(strCaption = this.iPSDEFGridColumn.getCaption("")))) {
            return strCaption;
        }
        return this.getPSDEField().getLogicName();
    }

    @Override
    public String getMemo() {
        String strMemo = this.psDEGridColumn.getMEMO();
        if (!StringHelper.isNullOrEmpty((String)strMemo)) {
            return strMemo;
        }
        if (this.getPickupTextPSDEFGroupDetail() != null && !StringHelper.isNullOrEmpty((String)(strMemo = this.getPickupTextPSDEFGroupDetail().getMemo()))) {
            return strMemo;
        }
        if (this.iPSDEFGridColumn != null && !StringHelper.isNullOrEmpty((String)(strMemo = this.iPSDEFGridColumn.getMemo()))) {
            return strMemo;
        }
        return this.getPSDEField().getMemo();
    }

    @Override
    public String getDefaultValueType() {
        String strDVT = this.psDEGridColumn.getCREATEDVT();
        if (!StringHelper.isNullOrEmpty((String)strDVT)) {
            return strDVT;
        }
        return this.getPSDEField().getDefaultValueType();
    }

    @Override
    public String getDefaultValue() {
        String strDVT = this.psDEGridColumn.getCREATEDVT();
        if (!StringHelper.isNullOrEmpty((String)strDVT)) {
            return this.psDEGridColumn.getCREATEDV();
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDEGridColumn.getCREATEDV())) {
            return this.psDEGridColumn.getCREATEDV();
        }
        return this.getPSDEField().getDefaultValue();
    }

    public void setPickupTextPSDEFGroupDetail(IPSDEFGroupDetail pickupTextPSDEFGroupDetail) {
        this.pickupTextPSDEFGroupDetail = pickupTextPSDEFGroupDetail;
    }

    public IPSDEFGroupDetail getPickupTextPSDEFGroupDetail() {
        return this.pickupTextPSDEFGroupDetail;
    }

    @Override
    public String getDetailParam() {
        return "";
    }

    @Override
    public String getDetailParam2() {
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5c0f\u5b57\u7b26\u4e32\u957f\u5ea6", ignoredumpvalues="0;-1")
    public int getMinStringLength() {
        return this.getPSDEField().getMinStringLength();
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5927\u503c\uff08\u5b57\u7b26\u4e32\uff09")
    public String getMaxValueString() {
        return this.getPSDEField().getMaxValueString();
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5c0f\u503c\uff08\u5b57\u7b26\u4e32\uff09")
    public String getMinValueString() {
        return this.getPSDEField().getMinValueString();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u7cbe\u5ea6", ignoredumpvalues="0")
    public int getPrecision() {
        return this.getPSDEField().getPrecision();
    }

    @Override
    @PSModelRTMeta(description="Json\u683c\u5f0f\u5316", dump=false)
    public String getJsonFormat() {
        return this.getPSDEField().getJsonFormat();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getLNPSLanguageRes() {
        return this.lnPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u641c\u7d22\u6a21\u5f0f", dump=false)
    public Properties getSearchModes() {
        return null;
    }
}

