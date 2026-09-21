/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlhandler.ICounterHandler;

public interface ICounterGlobalPlugin {
    public void registerCounterHandler(String var1, ICounterHandler var2);

    public ICounterHandler getCounterHandler(Class var1) throws Exception;

    public ICounterHandler getCounterHandler(String var1) throws Exception;
}

