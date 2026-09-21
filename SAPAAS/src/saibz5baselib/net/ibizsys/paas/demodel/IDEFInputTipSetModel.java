/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDEFInputTip;
import net.ibizsys.paas.core.IDEFInputTipSet;
import net.ibizsys.paas.core.IModelBase3;
import net.ibizsys.paas.sysmodel.ISystemModel;

public interface IDEFInputTipSetModel
extends IDEFInputTipSet,
IModelBase3 {
    public void init(ISystemModel var1) throws Exception;

    public void prepareDEFInputTips() throws Exception;

    public void resetAll();

    public IDEFInputTip getDEFInputTip(String var1) throws Exception;

    public IDEFInputTip getDEFInputTip(String var1, boolean var2) throws Exception;
}

