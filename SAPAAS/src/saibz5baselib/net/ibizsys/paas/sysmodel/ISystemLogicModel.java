/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.core.ISystemLogic;
import net.ibizsys.paas.sysmodel.ISystemModel;

public interface ISystemLogicModel
extends ISystemLogic {
    public void init(ISystemModel var1) throws Exception;

    public ISystemModel getSystemModel();

    public String getUniqueTag();

    public void execute(IActionContext var1, Object var2) throws Exception;
}

