/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.sysmodel.ICodeItemModel
 */
package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.core.IDynaModelJsonLoader;
import net.ibizsys.paas.sysmodel.ICodeItemModel;
import net.ibizsys.paas.sysmodel.IDynaCodeListModel;

public interface IDynaCodeItemModel
extends ICodeItemModel,
IDynaModelJsonLoader {
    public static final String ATTR_ITEMS = "items";
    public static final String ATTR_VALUE = "value";
    public static final String ATTR_TEXT = "text";
    public static final String ATTR_REALTEXT = "realtext";
    public static final String ATTR_PARENTVALUE = "parentvalue";
    public static final String ATTR_ICONCLS = "iconcls";
    public static final String ATTR_ICONCLSX = "iconclsx";
    public static final String ATTR_ICONPATH = "iconpath";
    public static final String ATTR_ICONPATHX = "iconpathx";
    public static final String ATTR_DISABLESELECT = "disableselect";
    public static final String ATTR_USERDATA = "userdata";
    public static final String ATTR_USERDATA2 = "userdata2";

    public void init(IDynaCodeListModel var1, IDynaCodeItemModel var2, Object var3) throws Exception;

    public IDynaCodeListModel getDynaCodeListModel();

    public IDynaCodeItemModel getParentModel();
}

