/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.app.view;

import net.ibizsys.model.app.view.IPSAppDEMultiDataView;
import net.ibizsys.model.app.view.IPSAppDEWFView;

public interface IPSAppDEGridView
extends IPSAppDEMultiDataView,
IPSAppDEWFView {
    public static final String CONTROL_GRID = "grid";

    public boolean isEnableRowEdit();

    public boolean isDbClickEditData();

    public int getGridRowActiveMode();

    public boolean isRowEditDefault();
}

