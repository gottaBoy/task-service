/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.list;

import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.control.list.IPSList;
import net.ibizsys.model.core.IPSModelObject;

public interface IPSListItem
extends IPSModelObject {
    public static final String CLCONVERTMODE_FRONT = "FRONT";
    public static final String CLCONVERTMODE_BACKEND = "BACKEND";
    public static final String ITEMTYPE_TEXTITEM = "TEXTITEM";
    public static final String ITEMTYPE_ACTIONITEM = "ACTIONITEM";
    public static final String ITEMTYPE_DATAITEM = "DATAITEM";
    public static final String ALIGN_LEFT = "LEFT";
    public static final String ALIGN_CENTER = "CENTER";
    public static final String ALIGN_RIGHT = "RIGHT";

    public String getCaption();

    public String getItemType();

    public int getItemPos();

    public IPSList getPSList();

    public String[] getFields();

    public boolean isEnableSort();

    public IPSCodeList getPSCodeList();

    public String getWidthString();

    public boolean isHiddenDataItem();

    public String getAlign();

    public String getCLConvertMode();

    public boolean isEnableItemPriv();

    public String getItemPrivId();
}

