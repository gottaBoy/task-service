/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.cache;

import net.ibizsys.paas.cache.ICacheItem;

public interface ICacheManager {
    public static final int CACHESCOPE_NONE = 0;
    public static final int CACHESCOPE_GLOBAL = 1;
    public static final int CACHESCOPE_ORG = 2;
    public static final int CACHESCOPE_USER = 3;
    public static final int CACHESCOPE_APP = 4;

    public Object getData(String var1, Object var2) throws Exception;

    public ICacheItem updateData(String var1, Object var2, Object var3) throws Exception;

    public ICacheItem updateData(String var1, Object var2, Object var3, long var4) throws Exception;

    public ICacheItem removeData(String var1) throws Exception;

    public ICacheItem getCacheItem(String var1);

    public void removeAll();
}

