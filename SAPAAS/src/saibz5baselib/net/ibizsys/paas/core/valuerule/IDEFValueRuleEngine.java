/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core.valuerule;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.core.valuerule.IDEFValueRule;
import net.ibizsys.paas.util.IGlobalContext;

public interface IDEFValueRuleEngine {
    public void init(IGlobalContext var1, IDEFValueRule var2) throws Exception;

    public boolean testCondition(IActionContext var1) throws Exception;

    public void close();
}

