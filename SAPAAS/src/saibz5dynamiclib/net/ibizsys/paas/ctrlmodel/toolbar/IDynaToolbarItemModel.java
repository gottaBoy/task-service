/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDynaModel
 */
package net.ibizsys.paas.ctrlmodel.toolbar;

import net.ibizsys.paas.core.IDynaModel;
import net.ibizsys.paas.core.IDynaModelJsonExporter;
import net.ibizsys.paas.core.IDynaModelJsonLoader;
import net.ibizsys.paas.ctrlmodel.IDynaToolbarModel;

public interface IDynaToolbarItemModel
extends IDynaModel,
IDynaModelJsonExporter,
IDynaModelJsonLoader {
    public static final String ITEMTYPE_UIACTION = "UIACTION";
    public static final String ITEMTYPE_SEPARATOR = "SEPARATOR";
    public static final String ITEMTYPE_ITEMS = "ITEMS";
    public static final String ITEMTYPE_RAWITEM = "RAWITEM";
    public static final String SHOWMODE_ICONANDSHORTWORD = "ICONANDSHORTWORD";
    public static final String SHOWMODE_ICON = "ICON";
    public static final String SHOWMODE_SHORTWORD = "SHORTWORD";
    public static final String ATTR_CAPTION = "caption";
    public static final String ATTR_TOOLTIP = "tooltip";
    public static final String ATTR_ICONCLS = "iconcls";
    public static final String ATTR_ICONPATH = "iconpath";
    public static final String ATTR_UIACTION = "uiaction";
    public static final String ATTR_UIACTIONPARAM = "uiactionparam";

    public void init(IDynaToolbarModel var1, IDynaToolbarItemModel var2, Object var3) throws Exception;

    public String getItemType();

    public IDynaToolbarModel getDynaToolbarModel();

    public IDynaToolbarItemModel getParentModel();
}

