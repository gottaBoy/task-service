/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.control.form;

import java.util.Iterator;
import net.ibizsys.paas.control.IControl;
import net.ibizsys.paas.control.form.IFormItem;

public interface IForm
extends IControl {
    public static final String FORMTYPE_EDITFORM = "EDITFORM";
    public static final String FORMTYPE_SEARCHFORM = "SEARCHFORM";
    public static final String DETAILTYPE_FORMPAGE = "FORMPAGE";
    public static final String DETAILTYPE_TABPANEL = "TABPANEL";
    public static final String DETAILTYPE_TABPAGE = "TABPAGE";
    public static final String DETAILTYPE_DATAGRID = "DATAGRID";
    public static final String DETAILTYPE_FORMITEM = "FORMITEM";
    public static final String DETAILTYPE_USERCONTROL = "USERCONTROL";
    public static final String DETAILTYPE_FORMPART = "FORMPART";
    public static final String DETAILTYPE_GROUPPANEL = "GROUPPANEL";
    public static final String DETAILTYPE_DRUIPART = "DRUIPART";

    public Iterator<IFormItem> getFormItems();

    public IFormItem getFormItem(String var1, boolean var2) throws Exception;
}

