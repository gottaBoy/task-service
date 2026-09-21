/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import net.ibizsys.paas.db.IDatabase;

public interface ISystemRuntime {
    public IDatabase getDatabase() throws Exception;

    public IDatabase getDatabase(String var1) throws Exception;

    public String getSystemSetting(String var1, String var2);
}

