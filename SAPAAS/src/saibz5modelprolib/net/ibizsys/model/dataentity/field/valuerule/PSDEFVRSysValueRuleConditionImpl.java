/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.field.valuerule.IPSDEFVRSysValueRuleCondition
 *  net.ibizsys.model.valuerule.IPSSysValueRule
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.dataentity.field.valuerule;

import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFVRSysValueRuleCondition;
import net.ibizsys.model.dataentity.field.valuerule.PSDEFVRSingleConditionImpl;
import net.ibizsys.model.valuerule.IPSSysValueRule;
import net.ibizsys.paas.util.StringHelper;

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

    @PSModelRTMeta(description="\u7cfb\u7edf\u503c\u89c4\u5219\u5bf9\u8c61")
    public IPSSysValueRule getPSSysValueRule() {
        return this.iPSSysValueRule;
    }

    @Override
    @PSModelRTMeta(description="\u89c4\u5219\u4fe1\u606f")
    public String getRuleInfo() {
        if (StringHelper.isNullOrEmpty((String)super.getRuleInfo())) {
            return this.getPSSysValueRule().getRuleInfo();
        }
        return super.getRuleInfo();
    }
}

