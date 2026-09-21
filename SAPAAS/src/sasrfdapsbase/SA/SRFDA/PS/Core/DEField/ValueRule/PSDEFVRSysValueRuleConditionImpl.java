/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DEField.ValueRule;

import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFVRSysValueRuleCondition;
import SA.SRFDA.PS.Core.DEField.ValueRule.PSDEFVRSingleConditionImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.ValueRule.IPSSysValueRule;
import net.ibizsys.paas.util.StringHelper;

@PSModelImplementMeta(implement="IPSDEFVRCondition", typevalues={"SYSVALUERULE"})
public class PSDEFVRSysValueRuleConditionImpl
extends PSDEFVRSingleConditionImpl
implements IPSDEFVRSysValueRuleCondition {
    private IPSSysValueRule iPSSysValueRule = null;

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.psDEFValueRuleCond.getPSSYSVALUERULEID())) {
            this.iPSSysValueRule = this.getPSDEFValueRule().getPSDEField().getPSDataEntity().getPSSystem().getPSSysValueRule(this.psDEFValueRuleCond.getPSSYSVALUERULEID());
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u503c\u89c4\u5219\u5bf9\u8c61", child=true, fields={"PSSYSVALUERULEID"})
    public IPSSysValueRule getPSSysValueRule() {
        return this.iPSSysValueRule;
    }

    @Override
    @PSModelRTMeta(description="\u89c4\u5219\u4fe1\u606f", fields={"RULEINFO"}, doc="\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u7cfb\u7edf\u503c\u89c4\u5219\u7684\u89c4\u5219\u4fe1\u606f")
    public String getRuleInfo() {
        if (StringHelper.isNullOrEmpty((String)super.getRuleInfo())) {
            return this.getPSSysValueRule().getRuleInfo();
        }
        return super.getRuleInfo();
    }
}

