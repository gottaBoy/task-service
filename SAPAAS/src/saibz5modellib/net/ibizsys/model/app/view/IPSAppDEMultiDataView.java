/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.app.view;

import net.ibizsys.model.app.view.IPSAppDESearchView;
import net.ibizsys.model.app.view.IPSAppDEXDataView;
import net.ibizsys.model.control.IPSControlMDataContainer;

public interface IPSAppDEMultiDataView
extends IPSAppDEXDataView,
IPSAppDESearchView,
IPSControlMDataContainer {
    public static final String VIEWPARAM_UI_ENABLEQUICKSEARCH = "UI.ENABLEQUICKSEARCH";
    public static final String VIEWPARAM_UI_ENABLESEARCH = "UI.ENABLESEARCH";
    public static final String VIEWREFMODE_NEWDATA = "NEWDATA";
    public static final String VIEWREFMODE_EDITDATA = "EDITDATA";
    public static final String VIEWREFMODE_EDITDATAX = "EDITDATAX";
    public static final String VIEWREFMODE_NEWDATAWIZARD = "NEWDATAWIZARD";
    public static final String VIEWREFMODE_MPICKUPVIEW = "MPICKUPVIEW";
}

