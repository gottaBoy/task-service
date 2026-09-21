/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.field.valuerule.IPSDEFVRValueRange3Condition
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.dataentity.field.valuerule;

import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFVRValueRange3Condition;
import net.ibizsys.model.dataentity.field.valuerule.PSDEFVRSingleConditionImpl;
import net.ibizsys.paas.util.StringHelper;

public class PSDEFVRValueRange3ConditionImpl
extends PSDEFVRSingleConditionImpl
implements IPSDEFVRValueRange3Condition {
    private String strSeparator = ";";
    private String strValues = null;
    private String[] values = null;

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.psDEFValueRuleCond.getPARAM())) {
            this.strSeparator = this.psDEFValueRuleCond.getPARAM();
        }
        this.strValues = this.psDEFValueRuleCond.getCONDVALUE();
        if (!StringHelper.isNullOrEmpty((String)this.strValues)) {
            this.values = StringHelper.split((String)this.strValues, (String)this.getSeparator());
        }
        super.onInit();
    }

    @PSModelRTMeta(description="\u503c\u96c6\u5408")
    public String[] getValueRanges() {
        return this.values;
    }

    @PSModelRTMeta(description="\u503c\u5206\u9694\u7b26")
    public String getSeparator() {
        return this.strSeparator;
    }

    public String getValues() {
        return this.strValues;
    }
}

