/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.core.IModelBase3;
import net.ibizsys.paas.core.valuerule.IDEFValueRule;

public interface IDEFValueRuleModel
extends IDEFValueRule,
IModelBase3 {
    public void test(IActionContext var1) throws Exception;
}

