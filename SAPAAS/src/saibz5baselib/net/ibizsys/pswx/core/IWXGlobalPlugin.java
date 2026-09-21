/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pswx.core;

import net.ibizsys.pswx.core.IWXAccountModel;

public interface IWXGlobalPlugin {
    public void registerWXAccountModel(String var1, IWXAccountModel var2);

    public IWXAccountModel getWXAccountModel(Class<?> var1) throws Exception;

    public IWXAccountModel getWXAccountModel(String var1) throws Exception;
}

