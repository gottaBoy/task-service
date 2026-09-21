/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.controller.IDynaViewControllerInst;
import net.ibizsys.paas.core.IDynaModel;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;

public interface IDynaCtrlModel
extends ICtrlModel,
IDynaModel {
    public static final String ATTR_ITEMS = "items";
    public static final String ATTR_CAPTION = "caption";
    public static final String ATTR_TOOPTIP = "tooltip";
    public static final String ATTR_ICONPATH = "iconpath";
    public static final String ATTR_ICONCLS = "iconcls";
    public static final String ATTR_TITLE = "title";
    public static final String ATTR_WIDTH = "width";
    public static final String ATTR_HEIGHT = "height";
    public static final String ATTR_COLXS = "colxs";
    public static final String ATTR_COLSM = "colsm";
    public static final String ATTR_COLMD = "colmd";
    public static final String ATTR_COLLG = "collg";
    public static final String ATTR_COLXSOFFSET = "colxsoffset";
    public static final String ATTR_COLSMOFFSET = "colsmoffset";
    public static final String ATTR_COLMDOFFSET = "colmdoffset";
    public static final String ATTR_COLLGOFFSET = "collgoffset";

    public void init(IDynaViewControllerInst var1, Object var2) throws Exception;

    public IDynaViewControllerInst getDynaViewControllerInst();

    public boolean isEnableDynaCtrl();
}

