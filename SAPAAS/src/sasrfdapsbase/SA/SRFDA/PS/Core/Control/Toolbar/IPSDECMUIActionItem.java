/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Toolbar;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSDEUIActionItem;
import SA.SRFDA.PS.Core.App.View.IPSWFUIActionItem;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEContextMenuItem;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u4e0a\u4e0b\u6587\u754c\u9762\u884c\u4e3a\u83dc\u5355\u9879\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", implement="PSDETBUIActionItemImpl", model="PSDETBItem")
@PSModelExtendMeta(extend="IPSDEContextMenuItem", typevalue={"DEUIACTION"})
public interface IPSDECMUIActionItem
extends IPSDEContextMenuItem,
IPSDEUIActionItem,
IPSWFUIActionItem {
    public static final String GROUPEXTRACTMODE_ITEM = "ITEM";
    public static final String GROUPEXTRACTMODE_ITEMS = "ITEMS";

    public Iterator<IPSDEContextMenuItem> getPSDEContextMenuItems() throws Exception;

    public IPSAppView getFrontPSAppView() throws Exception;

    public boolean isEnableToggleMode();

    public boolean isHiddenItem();

    public String getGroupExtractMode();

    public int getActionLevel();

    @Override
    public String getUIActionTarget();

    @Override
    public IPSUIAction getPSUIAction();
}

