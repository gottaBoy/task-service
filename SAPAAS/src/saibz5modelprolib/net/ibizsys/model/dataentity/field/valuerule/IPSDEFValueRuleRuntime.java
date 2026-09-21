/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.field.IPSDEField
 *  net.ibizsys.model.dataentity.field.valuerule.IPSDEFValueRule
 */
package net.ibizsys.model.dataentity.field.valuerule;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFValueRule;
import net.ibizsys.model.entity.PSDEFValueRule;

public interface IPSDEFValueRuleRuntime
extends IPSDEFValueRule {
    public void init(IPSModelStorageContext var1, IPSDEField var2, PSDEFValueRule var3) throws Exception;
}

