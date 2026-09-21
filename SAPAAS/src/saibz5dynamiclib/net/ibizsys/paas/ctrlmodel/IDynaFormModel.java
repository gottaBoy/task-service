/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.ctrlmodel.IDynaCtrlModel
 *  net.ibizsys.paas.ctrlmodel.IFormModel
 */
package net.ibizsys.paas.ctrlmodel;

import java.util.Iterator;
import net.ibizsys.paas.core.IDynaModelJsonExporter;
import net.ibizsys.paas.core.IDynaModelJsonLoader;
import net.ibizsys.paas.ctrlmodel.IDynaCtrlModel;
import net.ibizsys.paas.ctrlmodel.IFormModel;
import net.ibizsys.paas.ctrlmodel.form.IDynaFormDetailModel;
import net.ibizsys.paas.ctrlmodel.form.IDynaFormPageModel;

public interface IDynaFormModel
extends IFormModel,
IDynaCtrlModel,
IDynaModelJsonExporter,
IDynaModelJsonLoader {
    public static final String ATTR_PAGES = "pages";
    public static final String ATTR_LAYOUTMODE = "layoutmode";
    public static final String ATTR_FORMSTYLE = "formstyle";
    public static final String ATTR_FORMFUNCMODE = "formfuncmode";
    public static final String ATTR_HIDDENS = "hiddens";

    public Iterator<IDynaFormPageModel> getPageModels();

    public IDynaFormDetailModel createDynaFormDetailModel(String var1) throws Exception;

    public IFormModel getSourceFormModel();

    public String getLayoutMode();

    public String getFormFuncMode();

    public String getFormStyle();
}

