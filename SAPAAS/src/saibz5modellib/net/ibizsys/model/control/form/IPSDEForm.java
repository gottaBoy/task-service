/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.form.IForm
 */
package net.ibizsys.model.control.form;

import java.util.Iterator;
import net.ibizsys.model.control.IPSAjaxControl;
import net.ibizsys.model.control.form.IPSDEFormDRUIPart;
import net.ibizsys.model.control.form.IPSDEFormDetail;
import net.ibizsys.model.control.form.IPSDEFormItem;
import net.ibizsys.model.control.form.IPSDEFormItemUpdate;
import net.ibizsys.model.control.form.IPSDEFormItemVR;
import net.ibizsys.model.control.form.IPSDEFormPage;
import net.ibizsys.paas.control.form.IForm;

public interface IPSDEForm
extends IPSAjaxControl,
IForm {
    public static final String FORMFUNCMODE_WFACTION = "WFACTION";
    public static final String FORMFUNCMODE_WIZARDFORM = "WIZARDFORM";
    public static final String FORMSTYLE_SEARCHBAR = "SEARCHBAR";
    public static final String FORMSTYLE_SEARCHBAR2 = "SEARCHBAR2";
    public static final String FORMSTYLE_MOBSEARCHBAR = "MOBSEARCHBAR";
    public static final String FORMSTYLE_MOBSEARCHBAR2 = "MOBSEARCHBAR2";

    public Iterator<IPSDEFormPage> getPSDEFormPages();

    public int getPSDEFormPageCount();

    public IPSDEFormPage getPSDEFormPage(int var1) throws Exception;

    public Iterator<IPSDEFormItem> getPSDEFormItems();

    public Iterator<IPSDEFormDetail> getPSDEFormDetails();

    public IPSDEFormItem getPSDEFormItem(String var1) throws Exception;

    public int getDefaultLabelWidth();

    public boolean isNoTabHeader();

    public double getFormWidth();

    public Iterator<IPSDEFormDRUIPart> getPSDEFormDRUIParts();

    public Iterator<IPSDEFormItemUpdate> getPSDEFormItemUpdates();

    public IPSDEFormItemUpdate getPSDEFormItemUpdate(String var1) throws Exception;

    public int getFirstLabelColSpan();

    public int getLabelColSpan();

    public int getCtrlColSpan();

    public String getLayoutMode();

    public String getFormFuncMode();

    public Iterator<IPSDEFormItemVR> getPSDEFormItemVRs();

    public IPSDEFormItemVR getPSDEFormItemVR(String var1) throws Exception;

    public String getFormStyle();
}

