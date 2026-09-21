/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.app.view;

import net.ibizsys.model.app.view.IPSAppDEView;
import net.ibizsys.model.app.view.IPSAppDataRelationView;

public interface IPSAppDEIndexView
extends IPSAppDEView,
IPSAppDataRelationView {
    public static final String VIEWPARAM_UI_SHOWDATAINFOBAR = "UI.SHOWDATAINFOBAR";

    public boolean isShowDataInfoBar();
}

