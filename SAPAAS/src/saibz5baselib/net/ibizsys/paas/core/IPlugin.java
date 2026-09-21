/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

public interface IPlugin {
    public static final int ACTIONPOS_ENTER = 0;
    public static final int ACTIONPOS_BEFOREBEFORE = 30;
    public static final int ACTIONPOS_AFTERBEFORE = 31;
    public static final int ACTIONPOS_ACTION = 40;
    public static final int ACTIONPOS_ACTION2 = 45;
    public static final int ACTIONPOS_ACTION3 = 50;
    public static final int ACTIONPOS_BEFOREAFTER = 60;
    public static final int ACTIONPOS_AFTERAFTER = 61;
    public static final int ACTIONPOS_LEAVE = 99;

    public void init(String var1) throws Exception;

    public void setPrevPlugin(IPlugin var1);
}

