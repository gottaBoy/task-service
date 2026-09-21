/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.service.IServicePlugin;

public interface ISystemServicePlugin
extends IServicePlugin {
    public void registerServicePlugin(String var1, IServicePlugin var2) throws Exception;
}

