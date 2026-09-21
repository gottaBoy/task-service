/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.core.IPSModelObject
 *  net.ibizsys.model.dataentity.field.valuerule.IPSDEFVRCondition
 *  net.ibizsys.model.dataentity.field.valuerule.IPSDEFValueRule
 */
package net.ibizsys.model.dataentity.field.valuerule;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFVRCondition;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFValueRule;
import net.ibizsys.model.entity.PSDEFValueRule;
import net.ibizsys.model.entity.PSDEFValueRuleCond;
import net.ibizsys.model.entity.PSDEFValueRuleType;

public interface IPSDEFValueRuleType
extends IPSModelObject {
    public void init(IPSModelStorageContext var1, PSDEFValueRuleType var2) throws Exception;

    public IPSDEFValueRule createPSDEFValueRule(PSDEFValueRule var1) throws Exception;

    public IPSDEFVRCondition createPSDEFVRCondition(PSDEFValueRuleCond var1) throws Exception;
}

