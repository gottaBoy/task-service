/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.model.valuerule.IPSSysValueRule
 */
package net.ibizsys.model.valuerule;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.entity.PSSysValueRule;
import net.ibizsys.model.valuerule.IPSSysValueRule;

public interface IPSSysValueRuleRuntime
extends IPSSysValueRule {
    public void init(IPSModelStorageContext var1, IPSSystem var2, PSSysValueRule var3) throws Exception;
}

