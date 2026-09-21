/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.cache;

public interface ICacheItem {
    public Object getData();

    public long getExpiredTime();

    public String getUniqueTag();

    public Object getState();
}

