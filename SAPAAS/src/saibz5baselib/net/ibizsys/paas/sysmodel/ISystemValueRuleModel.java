/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.core.IValueRule;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.sysmodel.ISystemModel;

public interface ISystemValueRuleModel
extends IValueRule {
    public void init(ISystemModel var1) throws Exception;

    public ISystemModel getSystemModel();

    public String getUniqueTag();

    public boolean check(IEntity var1, String var2, boolean var3, Object var4, String var5, boolean var6) throws Exception;
}

