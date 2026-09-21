/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.cache;

public interface IDataCacheSupporter {
    public static final String CACHESCOPE_GLOBAL = "GLOBAL";
    public static final String CACHESCOPE_ORG = "ORG";
    public static final String CACHESCOPE_USER = "USER";

    public boolean isEnableCache();

    public String getCacheScope();

    public int getCacheTimeout();

    public String getCacheUniStateId();

    public String getCacheUniStateDELogicId();

    public String getCacheHookState();
}

