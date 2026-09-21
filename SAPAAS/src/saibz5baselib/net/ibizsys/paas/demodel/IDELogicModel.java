/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.core.IDELogic;
import net.ibizsys.paas.core.IModelBase3;

public interface IDELogicModel<ET>
extends IDELogic,
IModelBase3 {
    public static final String ENVPARAMKEYSTATE = "SRFKEYSTATE";

    public void execute(IActionContext var1) throws Exception;
}

