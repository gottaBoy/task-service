/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DEField;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DEField.IPSDEFGroupDetail;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.ValueRule.IPSSysValueRule;
import SA.SRFDA.PS.Data.PSDEFGroupDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Properties;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSDEFGroupDetailImpl
extends PSObjectImpl
implements IPSDEFGroupDetail {
    private static final Log log = LogFactory.getLog(PSDEFGroupDetailImpl.class);
    private IPSDEFGroup iPSDEFGroup = null;
    private PSDEFGroupDetail psDEFGroupDetail = null;
    private IPSDEField iPSDEField = null;
    private int nOrderValue = 99999;
    private String strCodeName = null;
    private String strServiceCodeName = null;
    private boolean bAllowEmpty = true;
    private IPSCodeList iPSCodeList = null;
    private int nStringLength = -1;
    private int nMinStringLength = -1;
    private int nPrecision = 0;
    private String strMinValue = null;
    private String strMaxValue = null;
    private String strJsonFormat = null;
    private IPSSysValueRule iPSSysValueRule = null;
    private int nUserInputMode = 0;
    private IPSLanguageRes lnPSLanguageRes = null;
    private Properties searchModes = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEFGroup iPSDEFGroup, PSDEFGroupDetail psDEFGroupDetail) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEFGroup = iPSDEFGroup;
            this.psDEFGroupDetail = psDEFGroupDetail;
            this.setId(this.psDEFGroupDetail.getPSDEFGROUPDETAILID());
            this.setName(this.psDEFGroupDetail.getPSDEFGROUPDETAILNAME());
            this.setPSObjectData(this.psDEFGroupDetail);
            if (!StringHelper.isNullOrEmpty((String)psDEFGroupDetail.getPSDEFID()) && iPSDEFGroup.getPSDataEntity() != null) {
                this.iPSDEField = iPSDEFGroup.getPSDataEntity().getPSDEField(psDEFGroupDetail.getPSDEFID());
            }
            if (this.getPSDEField() == null) {
                throw new Exception("\u5b9e\u4f53\u5c5e\u6027\u65e0\u6548");
            }
            this.strCodeName = psDEFGroupDetail.getCODENAME();
            this.strServiceCodeName = psDEFGroupDetail.getSERVICECODENAME();
            if (StringHelper.isNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = this.getPSDEField().getCodeName();
                if (StringHelper.isNullOrEmpty((String)this.strServiceCodeName)) {
                    this.strServiceCodeName = this.getPSDEField().getServiceCodeName();
                }
            } else if (StringHelper.isNullOrEmpty((String)this.strServiceCodeName)) {
                this.strServiceCodeName = this.getPSDEField().getPSDataEntity().getAPICodeName(null, this.strCodeName, null);
            }
            this.nOrderValue = !this.psDEFGroupDetail.isORDERVALUENull() ? this.psDEFGroupDetail.getORDERVALUE() : this.getPSDEField().getOrderValue();
            this.bAllowEmpty = !this.psDEFGroupDetail.isALLOWEMPTYNull() ? this.psDEFGroupDetail.getALLOWEMPTY() : this.getPSDEField().isAllowEmpty();
            this.iPSCodeList = !StringHelper.isNullOrEmpty((String)this.psDEFGroupDetail.getPSCODELISTID()) ? this.getPSDEField().getPSDataEntity().getPSSystem().getPSCodeList(this.psDEFGroupDetail.getPSCODELISTID()) : this.getPSDEField().getPSCodeList();
            this.nStringLength = !this.psDEFGroupDetail.isSTRLENGTHNull() ? this.psDEFGroupDetail.getSTRLENGTH() : this.getPSDEField().getStringLength();
            this.nMinStringLength = !this.psDEFGroupDetail.isMINSTRLENGTHNull() ? this.psDEFGroupDetail.getMINSTRLENGTH() : this.getPSDEField().getMinStringLength();
            this.nPrecision = !this.psDEFGroupDetail.isPRECISION2Null() ? this.psDEFGroupDetail.getPRECISION2() : this.getPSDEField().getPrecision();
            this.strMinValue = !StringHelper.isNullOrEmpty((String)this.psDEFGroupDetail.getMINVALUE()) ? this.psDEFGroupDetail.getMINVALUE() : this.getPSDEField().getMinValueString();
            this.strMaxValue = !StringHelper.isNullOrEmpty((String)this.psDEFGroupDetail.getMAXVALUE()) ? this.psDEFGroupDetail.getMAXVALUE() : this.getPSDEField().getMaxValueString();
            this.strJsonFormat = !StringHelper.isNullOrEmpty((String)this.psDEFGroupDetail.getJSONFORMAT()) ? this.psDEFGroupDetail.getJSONFORMAT() : this.getPSDEField().getJsonFormat();
            if (!StringHelper.isNullOrEmpty((String)this.psDEFGroupDetail.getPSSYSVALUERULEID())) {
                this.iPSSysValueRule = this.getPSDEField().getPSDataEntity().getPSSystem().getPSSysValueRule(this.psDEFGroupDetail.getPSSYSVALUERULEID());
            } else if (!StringHelper.isNullOrEmpty((String)this.getPSDEField().getPSSysValueRuleId())) {
                this.iPSSysValueRule = this.getPSDEField().getPSDataEntity().getPSSystem().getPSSysValueRule(this.getPSDEField().getPSSysValueRuleId());
            }
            this.nUserInputMode = this.getPSDEField().getUserInputMode();
            if (this.psDEFGroupDetail.getMODIFYUSERINPUT()) {
                this.nUserInputMode = this.psDEFGroupDetail.getENABLEUSERINPUT();
            }
            this.lnPSLanguageRes = !StringHelper.isNullOrEmpty((String)this.psDEFGroupDetail.getLNPSLANRESID()) ? this.getPSDEField().getPSDataEntity().getPSSystem().getPSLanguageRes(this.psDEFGroupDetail.getLNPSLANRESID()) : this.getPSDEField().getLNPSLanguageRes();
            if (!StringHelper.isNullOrEmpty((String)this.psDEFGroupDetail.getSEARCHMODES())) {
                this.searchModes = PropertiesHelper.load((String)this.psDEFGroupDetail.getSEARCHMODES());
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
    public IPSDEFGroup getPSDEFGroup() {
        return this.iPSDEFGroup;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSDataEntity", fields={"PSDEFID"})
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
    @PSModelRTMeta(description="\u6392\u5e8f\u503c", ignoredumpvalues="99999", fields={"ORDERVALUE"})
    public int getOrderValue() {
        return this.nOrderValue;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f02", hideempty2=true)
    public String getCodeName2() {
        return this.psDEFGroupDetail.getCODENAME2();
    }

    @Override
    @PSModelRTMeta(description="\u5141\u8bb8\u7a7a\u8f93\u5165", ignoredumpvalues="true", fields={"ALLOWEMPTY"})
    public boolean isAllowEmpty() {
        return this.bAllowEmpty;
    }

    @Override
    @PSModelRTMeta(description="\u5b57\u7b26\u4e32\u957f\u5ea6", ignoredumpvalues="0;-1", fields={"STRLENGTH"})
    public int getStringLength() {
        return this.nStringLength;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u4ee3\u7801\u8868", dumpref=true, fields={"PSCODELISTID"})
    public IPSCodeList getPSCodeList() throws Exception {
        return this.iPSCodeList;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u503c\u89c4\u5219", fields={"PSSYSVALUERULEID"})
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
        return this.getPSDEField().getLogicName();
    }

    @Override
    public String getMemo() {
        if (StringHelper.isNullOrEmpty((String)super.getMemo())) {
            return this.getPSDEField().getMemo();
        }
        return super.getMemo();
    }

    @Override
    public String getDefaultValueType() {
        if (!StringHelper.isNullOrEmpty((String)this.psDEFGroupDetail.getDVT()) || !StringHelper.isNullOrEmpty((String)this.psDEFGroupDetail.getDEFAULTVALUE())) {
            return this.psDEFGroupDetail.getDVT();
        }
        return this.getPSDEField().getDefaultValueType();
    }

    @Override
    public String getDefaultValue() {
        if (!StringHelper.isNullOrEmpty((String)this.psDEFGroupDetail.getDVT()) || !StringHelper.isNullOrEmpty((String)this.psDEFGroupDetail.getDEFAULTVALUE())) {
            return this.psDEFGroupDetail.getDEFAULTVALUE();
        }
        return this.getPSDEField().getDefaultValue();
    }

    @Override
    @PSModelRTMeta(description="\u6210\u5458\u53c2\u6570", hideempty2=true, fields={"DETAILPARAM"})
    public String getDetailParam() {
        return this.psDEFGroupDetail.getDETAILPARAM();
    }

    @Override
    @PSModelRTMeta(description="\u6210\u5458\u53c2\u65702", hideempty2=true, fields={"DETAILPARAM2"})
    public String getDetailParam2() {
        return this.psDEFGroupDetail.getDETAILPARAM2();
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5c0f\u5b57\u7b26\u4e32\u957f\u5ea6", ignoredumpvalues="0;-1", fields={"MINSTRLENGTH"})
    public int getMinStringLength() {
        return this.nMinStringLength;
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5927\u503c\uff08\u5b57\u7b26\u4e32\uff09", fields={"MAXVALUE"})
    public String getMaxValueString() {
        return this.strMaxValue;
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5c0f\u503c\uff08\u5b57\u7b26\u4e32\uff09", fields={"MINVALUE"})
    public String getMinValueString() {
        return this.strMinValue;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u7cbe\u5ea6", ignoredumpvalues="0", fields={"PRECISION"})
    public int getPrecision() {
        return this.nPrecision;
    }

    @Override
    @PSModelRTMeta(description="Json\u683c\u5f0f\u5316", fields={"JSONFORMAT"}, dump=false)
    public String getJsonFormat() {
        return this.strJsonFormat;
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getLNPSLanguageRes() {
        return this.lnPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u641c\u7d22\u6a21\u5f0f", dump=false)
    public Properties getSearchModes() {
        return this.searchModes;
    }
}

