/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.core.IPSModelObject
 *  net.ibizsys.model.dataentity.field.valuerule.IPSDEFValueRule
 */
package net.ibizsys.model.dataentity.field.valuerule;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFValueRule;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFValueRuleType;
import net.ibizsys.model.entity.PSDEFValueRule;
import net.ibizsys.model.entity.PSDEFValueRuleTypeDetail;

public interface IPSDEFValueRuleTypeDetail
extends IPSModelObject {
    public void init(IPSModelStorageContext var1, IPSDEFValueRuleType var2, PSDEFValueRuleTypeDetail var3) throws Exception;

    public IPSDEFValueRule createPSDEFValueRule(PSDEFValueRule var1) throws Exception;
}

