/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.view;

import net.ibizsys.paas.control.IControl;
import net.ibizsys.paas.core.IApplication;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.IModelBase;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.IAjaxActionContext;

public interface IView
extends IModelBase {
    public static final String PREDEFINEDVIEWTYPE_PICKUPVIEW = "PICKUPVIEW";
    public static final String PREDEFINEDVIEWTYPE_EDITVIEW = "EDITVIEW";
    public static final String PREDEFINEDVIEWTYPE_INDEXDEPICKUPVIEW = "INDEXDEPICKUPVIEW";
    public static final String PREDEFINEDVIEWTYPE_FORMPICKUPVIEW = "FORMPICKUPVIEW";
    public static final String PREDEFINEDVIEWTYPE_MPICKUPVIEW = "MPICKUPVIEW";
    public static final String PREDEFINEDVIEWTYPE_MDATAVIEW = "MDATAVIEW";
    public static final String PREDEFINEDVIEWTYPE_WFEDITVIEW = "WFEDITVIEW";
    public static final String PREDEFINEDVIEWTYPE_WFMDATAVIEW = "WFMDATAVIEW";
    public static final String PREDEFINEDVIEWTYPE_REDIRECTVIEW = "REDIRECTVIEW";
    public static final String PREDEFINEDVIEWTYPE_MOBPICKUPVIEW = "MOBPICKUPVIEW";
    public static final String PREDEFINEDVIEWTYPE_MOBEDITVIEW = "MOBEDITVIEW";
    public static final String PREDEFINEDVIEWTYPE_MOBINDEXDEPICKUPVIEW = "MOBINDEXDEPICKUPVIEW";
    public static final String PREDEFINEDVIEWTYPE_MOBFORMPICKUPVIEW = "MOBFORMPICKUPVIEW";
    public static final String PREDEFINEDVIEWTYPE_MOBMPICKUPVIEW = "MOBMPICKUPVIEW";
    public static final String PREDEFINEDVIEWTYPE_MOBMDATAVIEW = "MOBMDATAVIEW";
    public static final String PREDEFINEDVIEWTYPE_MOBWFEDITVIEW = "MOBWFEDITVIEW";
    public static final String PREDEFINEDVIEWTYPE_MOBWFMDATAVIEW = "MOBWFMDATAVIEW";
    public static final String PREDEFINEDVIEWTYPE_MOBREDIRECTVIEW = "MOBREDIRECTVIEW";
    public static final String VIEWCTRLTYPE_TOOLBAR = "TOOLBAR";
    public static final String VIEWCTRLTYPE_GRID = "GRID";
    public static final String VIEWCTRLTYPE_FORM = "FORM";
    public static final String VIEWCTRLTYPE_SEARCHFORM = "SEARCHFORM";
    public static final String VIEWCTRLTYPE_DRBAR = "DRBAR";
    public static final String VIEWCTRLTYPE_VIEWPANEL = "VIEWPANEL";
    public static final String VIEWCTRLTYPE_PICKUPVIEWPANEL = "PICKUPVIEWPANEL";
    public static final String VIEWCTRLTYPE_DATAVIEW = "DATAVIEW";
    public static final String VIEWCTRLTYPE_DRTAB = "DRTAB";
    public static final String VIEWCTRLTYPE_MOBMDCTRL = "MOBMDCTRL";
    public static final String OPENMODE_INDEXVIEWTAB = "INDEXVIEWTAB";
    public static final String OPENMODE_POPUP = "POPUP";
    public static final String OPENMODE_POPUPMODAL = "POPUPMODAL";

    public IApplication getApplication();

    public String getViewType();

    public IControl getControl(String var1) throws Exception;

    public IDataEntity getDataEntity();

    @Deprecated
    public AjaxActionResult process(IAjaxActionContext var1) throws Exception;
}

