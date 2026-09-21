/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

public interface IDEDataRange {
    public static final int ORG_CURRENT = 1;
    public static final int ORG_PARENT = 2;
    public static final int ORG_CHILD = 4;
    public static final int ORG_NULL = 8;
    public static final int SECTOR_CURRENT = 1;
    public static final int SECTOR_PARENT = 2;
    public static final int SECTOR_CHILD = 4;
    public static final int SECTOR_NULL = 8;

    public boolean isEnableOrgDR();

    public boolean isEnableSecDR();

    public boolean isEnableSecBC();

    public long getOrgDR();

    public long getSecDR();

    public String getSecBC();

    public boolean isEnableUserDR();

    public String getUserDRAction();

    public String getCustomDRMode();

    public String getCustomDRMode2();

    public String getCustomDRModeParam();

    public String getCustomDRMode2Param();
}

