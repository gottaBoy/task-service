/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pswx.core;

import net.ibizsys.paas.core.IModelBase;
import net.ibizsys.pswx.core.IWXEntApp;
import net.ibizsys.pswx.core.IWXMenu;

public interface IWXAccount
extends IModelBase {
    public IWXMenu getDefaultWXMenu();

    public IWXEntApp getWXEntApp(String var1) throws Exception;

    public Object getRuntimeId();

    public void setRuntimeId(Object var1);
}

