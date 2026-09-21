/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control;

import net.ibizsys.model.control.IPSControlXDataContainer;

public interface IPSControlMDataContainer
extends IPSControlXDataContainer {
    public static final String NEWDATAMODE_NORMAL = "NORMAL";
    public static final String NEWDATAMODE_WIZARD = "WIZARD";
    public static final String NEWDATAMODE_MULTIFORM = "MULTIFORM";
    public static final String NEWDATAMODE_ENABATADD = "ENABATADD";
    public static final String NEWDATAMODE_BATADDONLY = "BATADDONLY";
    public static final String NEWDATAMODE_INDEXDE = "INDEXDE";
    public static final String EDITDATAMODE_NORMAL = "NORMAL";
    public static final String EDITDATAMODE_MULTIFORM = "MULTIFORM";
    public static final String EDITDATAMODE_INDEXDE = "INDEXDE";

    public String getNewDataMode();

    public String getEditDataMode();

    @Override
    public boolean isLoadDefault();

    public boolean isEnableBatchAdd();

    public boolean isBatchAddOnly();

    public boolean isPickupMode();

    public boolean isEnableViewData();

    public boolean isEnableImport();

    public boolean isEnableExport();

    public boolean isEnableFilter();

    public boolean isEnableQuickSearch();

    public boolean isEnableSearch();

    public boolean isEnableQuickCreate();
}

