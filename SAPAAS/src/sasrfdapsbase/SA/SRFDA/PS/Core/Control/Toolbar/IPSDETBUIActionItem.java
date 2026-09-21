/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Toolbar;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSDEUIActionItem;
import SA.SRFDA.PS.Core.App.View.IPSWFUIActionItem;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEToolbarItem;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import java.util.Iterator;

@PSModelExtendMeta(title="\u5b9e\u4f53\u5de5\u5177\u680f\u754c\u9762\u884c\u4e3a\u9879\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3,", extend="IPSDEToolbarItem", typevalue={"DEUIACTION"}, model="PSDETBItem")
public interface IPSDETBUIActionItem
extends IPSDEToolbarItem,
IPSDEUIActionItem,
IPSWFUIActionItem {
    public static final String GROUPEXTRACTMODE_ITEM = "ITEM";
    public static final String GROUPEXTRACTMODE_ITEMS = "ITEMS";
    public static final String GROUPEXTRACTMODE_ITEMX = "ITEMX";
    public static final String GROUPEXTRACTMODE_AUTO = "AUTO";
    public static final int ACTIONLEVEL_LOW = 50;
    public static final int ACTIONLEVEL_NORMAL = 100;
    public static final int ACTIONLEVEL_HIGH = 200;
    public static final int ACTIONLEVEL_CRITICAL = 250;

    public Iterator<IPSDEToolbarItem> getPSDEToolbarItems() throws Exception;

    public IPSAppView getFrontPSAppView() throws Exception;

    public boolean isEnableToggleMode();

    public boolean isHiddenItem();

    public int getNoPrivDisplayMode();

    public String getGroupExtractMode();

    public int getActionLevel();

    @Override
    public String getUIActionTarget();

    @Override
    public IPSUIAction getPSUIAction();

    public String getButtonStyle();

    public String getBorderStyle();
}

