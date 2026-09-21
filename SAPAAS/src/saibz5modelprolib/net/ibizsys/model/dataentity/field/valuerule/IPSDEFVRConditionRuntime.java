/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.field.valuerule.IPSDEFVRCondition
 *  net.ibizsys.model.dataentity.field.valuerule.IPSDEFVRGroupCondition
 *  net.ibizsys.model.dataentity.field.valuerule.IPSDEFValueRule
 */
package net.ibizsys.model.dataentity.field.valuerule;

import java.util.ArrayList;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFVRCondition;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFVRGroupCondition;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFValueRule;
import net.ibizsys.model.entity.PSDEFValueRuleCond;

public interface IPSDEFVRConditionRuntime
extends IPSDEFVRCondition {
    public void init(IPSModelStorageContext var1, IPSDEFValueRule var2, IPSDEFVRGroupCondition var3, PSDEFValueRuleCond var4) throws Exception;

    public void fillRelatedPSDEFields(ArrayList<String> var1);
}

