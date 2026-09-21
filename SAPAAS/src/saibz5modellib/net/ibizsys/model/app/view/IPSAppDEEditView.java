/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.app.view;

import net.ibizsys.model.app.view.IPSAppDEView;
import net.ibizsys.model.app.view.IPSAppDEXDataView;
import net.ibizsys.model.app.view.IPSAppDataRelationView;

public interface IPSAppDEEditView
extends IPSAppDEView,
IPSAppDataRelationView,
IPSAppDEXDataView {
    public static final String VIEWPARAM_UI_SHOWDATAINFOBAR = "UI.SHOWDATAINFOBAR";

    public boolean isShowDataInfoBar();

    public boolean isHideEditForm();
}

