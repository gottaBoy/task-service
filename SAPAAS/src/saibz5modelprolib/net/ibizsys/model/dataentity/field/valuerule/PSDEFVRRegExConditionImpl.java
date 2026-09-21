/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.field.valuerule.IPSDEFVRRegExCondition
 */
package net.ibizsys.model.dataentity.field.valuerule;

import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFVRRegExCondition;
import net.ibizsys.model.dataentity.field.valuerule.PSDEFVRSingleConditionImpl;

public class PSDEFVRRegExConditionImpl
extends PSDEFVRSingleConditionImpl
implements IPSDEFVRRegExCondition {
    @PSModelRTMeta(description="\u6b63\u5219\u5f0f")
    public String getRegExCode() {
        return this.psDEFValueRuleCond.getCONDVALUE();
    }
}

