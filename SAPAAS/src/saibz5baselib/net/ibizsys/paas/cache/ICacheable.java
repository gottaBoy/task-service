/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.cache;

public interface ICacheable {
    public boolean isEnableCache();

    public int getCacheScope();

    public int getCacheTimeout();

    public String getUniStateId();

    public Object getUniStateKeyValue();

    public String getUniStateField();
}

