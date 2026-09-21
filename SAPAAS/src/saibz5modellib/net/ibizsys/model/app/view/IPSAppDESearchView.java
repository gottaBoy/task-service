/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.app.view;

import net.ibizsys.model.app.view.IPSAppDEView;

public interface IPSAppDESearchView
extends IPSAppDEView {
    public static final String CONTROL_SEARCHFORM = "searchform";

    public boolean isEnableQuickSearch();

    public boolean isEnableSearch();

    public boolean isLoadDefault();
}

