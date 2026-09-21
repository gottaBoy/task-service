/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.List;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.IPSControlItem;
import SA.SRFDA.PS.Core.Control.List.IPSList;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;

@PSModelInterfaceMeta(title="\u5217\u8868\u90e8\u4ef6\u9879\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEListItem")
public interface IPSListItem
extends IPSModelObject,
IPSControlItem {
    public static final String CLCONVERTMODE_FRONT = "FRONT";
    public static final String CLCONVERTMODE_BACKEND = "BACKEND";
    public static final String ITEMTYPE_TEXTITEM = "TEXTITEM";
    public static final String ITEMTYPE_ACTIONITEM = "ACTIONITEM";
    public static final String ITEMTYPE_DATAITEM = "DATAITEM";
    public static final String ALIGN_LEFT = "LEFT";
    public static final String ALIGN_CENTER = "CENTER";
    public static final String ALIGN_RIGHT = "RIGHT";

    public String getCaption();

    public IPSLanguageRes getCapPSLanguageRes();

    public String getItemType();

    public int getItemPos();

    public IPSList getPSList();

    public String[] getFields();

    public boolean isEnableSort();

    public IPSCodeList getPSCodeList();

    public IPSSysPFPlugin getRenderPSSysPFPlugin();

    public String getWidthString();

    public boolean isHiddenDataItem();

    public String getAlign();

    public String getCLConvertMode();

    public boolean isEnableItemPriv();

    public String getItemPrivId();

    public String getGroupItem();

    public boolean isCustomCode();

    public String getScriptCode();
}

