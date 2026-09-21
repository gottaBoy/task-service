/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pswx.core;

import java.util.Iterator;
import net.ibizsys.paas.core.IModelBase;
import net.ibizsys.pswx.core.IWXAccount;
import net.ibizsys.pswx.core.IWXEntApp;
import net.ibizsys.pswx.core.IWXMenuItem;

public interface IWXMenu
extends IModelBase {
    public IWXAccount getWXAccount();

    public IWXEntApp getWXEntApp();

    public Iterator<IWXMenuItem> getWXMenuItems();
}

