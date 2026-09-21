/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.ctrlmodel.toolbar;

import net.ibizsys.paas.ctrlmodel.toolbar.IDynaToolbarItemModel;
import net.ibizsys.paas.view.IDynaUIActionModel;
import net.sf.json.JSONObject;

public interface IDynaToolbarUIActionItemModel
extends IDynaToolbarItemModel {
    public static final String SHOWMODE_ICONANDSHORTWORD = "ICONANDSHORTWORD";
    public static final String SHOWMODE_ICON = "ICON";
    public static final String SHOWMODE_SHORTWORD = "SHORTWORD";
    public static final String GROUPEXTRACTMODE_ITEM = "ITEM";
    public static final String GROUPEXTRACTMODE_ITEMS = "ITEMS";

    public String getShowMode();

    public boolean isEnableToggleMode();

    public boolean isHiddenItem();

    public int getNoPrivDisplayMode();

    public IDynaUIActionModel getUIActionModel();

    public JSONObject getUIActionParam();

    public String getCaption();

    public String getCapLanResTag();

    public String getTooltip();

    public String getTooltipLanResTag();
}

