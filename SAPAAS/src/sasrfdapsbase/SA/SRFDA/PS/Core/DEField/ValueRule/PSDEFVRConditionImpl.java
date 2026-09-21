/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DEField.ValueRule;

import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFVRCondition;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFVRGroupCondition;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFValueRule;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Data.PSDEFValueRuleCond;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFVRConditionImpl
extends PSObjectImpl
implements IPSDEFVRCondition {
    private static final Log log = LogFactory.getLog(PSDEFVRConditionImpl.class);
    private IPSDEFValueRule iPSDEFValueRule = null;
    private IPSDEFVRGroupCondition iPSDEFVRGroupCondition = null;
    protected PSDEFValueRuleCond psDEFValueRuleCond = null;
    private String strRuleInfo = "";
    private boolean bNotMode = false;
    private boolean bTryMode = false;
    private boolean bKeyCond = false;
    private IPSLanguageRes ruleInfoPSLanguageRes = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEFValueRule iPSDEFValueRule, IPSDEFVRGroupCondition iPSDEFVRGroupCondition, PSDEFValueRuleCond psDEFValueRuleCond) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEFValueRule = iPSDEFValueRule;
            this.iPSDEFVRGroupCondition = iPSDEFVRGroupCondition;
            this.psDEFValueRuleCond = psDEFValueRuleCond;
            this.setId(this.psDEFValueRuleCond.getPSDEFVRCONDID());
            this.setName(this.psDEFValueRuleCond.getPSDEFVRCONDNAME());
            this.setPSObjectData(this.psDEFValueRuleCond);
            this.strRuleInfo = this.psDEFValueRuleCond.getRULEINFO();
            if (!this.psDEFValueRuleCond.isGROUPNOTFLAGNull()) {
                this.bNotMode = this.psDEFValueRuleCond.getGROUPNOTFLAG();
            }
            if (!this.psDEFValueRuleCond.isKEYCONDFLAGNull()) {
                this.bKeyCond = this.psDEFValueRuleCond.getKEYCONDFLAG();
            }
            this.onInit();
            this.calcRuleInfo();
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
        if (!StringHelper.isNullOrEmpty((String)this.psDEFValueRuleCond.getRIPSLANRESID())) {
            this.ruleInfoPSLanguageRes = this.iPSDEFValueRule.getPSDataEntity().getPSSystem().getPSLanguageRes(this.psDEFValueRuleCond.getRIPSLANRESID());
        }
        super.onInit();
    }

    @Override
    public IPSDEFValueRule getPSDEFValueRule() {
        return this.iPSDEFValueRule;
    }

    @Override
    public IPSDEFVRGroupCondition getPSDEFVRGroupCondition() {
        return this.iPSDEFVRGroupCondition;
    }

    @Override
    @PSModelRTMeta(description="\u6761\u4ef6\u9879\u7c7b\u578b", codelist="DEFVRType", fields={"CONDTYPE"})
    public String getCondType() {
        return this.psDEFValueRuleCond.getCONDTYPE();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEFValueRule.getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u89c4\u5219\u4fe1\u606f", fields={"RULEINFO"})
    public String getRuleInfo() {
        return this.strRuleInfo;
    }

    protected void setRuleInfo(String strRuleInfo) {
        this.strRuleInfo = strRuleInfo;
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u53d6\u53cd", ignoredumpvalues="false", fields={"GROUPNOTFLAG"})
    public boolean isNotMode() {
        return this.bNotMode;
    }

    @Override
    @PSModelRTMeta(description="\u68c0\u67e5\u5931\u8d25\u5ffd\u7565", dump=false, fields={"KEYCONDFLAG"})
    public boolean isTryMode() {
        return this.bTryMode && !this.isKeyCond();
    }

    public void setTryMode(boolean bTryMode) {
        this.bTryMode = bTryMode;
    }

    protected void calcRuleInfo() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.strRuleInfo)) {
            return;
        }
        this.setRuleInfo(this.onCalcRuleInfo());
    }

    protected String onCalcRuleInfo() throws Exception {
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u5173\u952e\u6761\u4ef6", ignoredumpvalues="false", fields={"KEYCONDFLAG"})
    public boolean isKeyCond() {
        return this.bKeyCond;
    }

    @Override
    public String getModelType() {
        return "PSDEFVRCOND";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSDEFValueRule().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEFValueRule().getPSDEField().getPSDataEntity().getPSSystem());
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDEFValueRule().getModelId(), (Object)super.getModelId());
    }

    public String getCondOp() {
        return null;
    }

    @Override
    public void fillRelatedPSDEFields(ArrayList<String> relatedPSDEFieldList) {
    }

    @Override
    @PSModelRTMeta(description="\u6761\u4ef6\u6807\u8bb0", hideempty2=true, fields={"CONDTAG"})
    public String getCondTag() {
        return this.psDEFValueRuleCond.getCONDTAG();
    }

    @Override
    @PSModelRTMeta(description="\u6761\u4ef6\u6807\u8bb02", hideempty2=true, fields={"CONDTAG2"})
    public String getCondTag2() {
        return this.psDEFValueRuleCond.getCONDTAG2();
    }

    @Override
    public String getModelRefId() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u89c4\u5219\u4fe1\u606f\u8bed\u8a00\u8d44\u6e90\u6807\u8bb0")
    public String getRuleInfoLanResTag() {
        if (this.getRuleInfoPSLanguageRes() == null) {
            return null;
        }
        return this.getRuleInfoPSLanguageRes().getLanResTag();
    }

    @Override
    @PSModelRTMeta(description="\u89c4\u5219\u4fe1\u606f\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61")
    public IPSLanguageRes getRuleInfoPSLanguageRes() {
        return this.ruleInfoPSLanguageRes;
    }
}

