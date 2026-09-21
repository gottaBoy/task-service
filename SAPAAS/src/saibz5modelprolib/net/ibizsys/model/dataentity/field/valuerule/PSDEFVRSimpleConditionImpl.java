/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.field.valuerule.IPSDEFVRSimpleCondition
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.dataentity.field.valuerule;

import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFVRSimpleCondition;
import net.ibizsys.model.dataentity.field.valuerule.PSDEFVRSingleConditionImpl;
import net.ibizsys.paas.util.StringHelper;

public class PSDEFVRSimpleConditionImpl
extends PSDEFVRSingleConditionImpl
implements IPSDEFVRSimpleCondition {
    private String strParamType = null;
    private String strParamValue = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (!StringHelper.isNullOrEmpty((String)this.psDEFValueRuleCond.getPARAMTYPE())) {
            this.strParamType = this.psDEFValueRuleCond.getPARAMTYPE();
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDEFValueRuleCond.getCONDVALUE())) {
            this.strParamValue = this.psDEFValueRuleCond.getCONDVALUE();
        }
    }

    public String getPSDBValueOPId() {
        return this.psDEFValueRuleCond.getPSDBVALUEOPID();
    }

    @PSModelRTMeta(description="\u53c2\u6570\u7c7b\u578b", codelist="DEFVRParamType")
    public String getParamType() {
        return this.strParamType;
    }

    @PSModelRTMeta(description="\u53c2\u6570\u503c")
    public String getParamValue() {
        return this.strParamValue;
    }
}

