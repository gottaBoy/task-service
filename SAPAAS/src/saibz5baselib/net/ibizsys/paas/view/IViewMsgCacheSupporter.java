/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.view;

public interface IViewMsgCacheSupporter {
    public static final String CACHESCOPE_GLOBAL = "GLOBAL";
    public static final String CACHESCOPE_ORG = "ORG";
    public static final String CACHESCOPE_USER = "USER";

    public boolean isEnableCache();

    public String getCacheScope();

    public int getCacheTimeout();

    public String getCacheTagField();

    public String getCacheTag2Field();
}

