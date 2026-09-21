/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.IControlCustomizable
 *  net.ibizsys.paas.control.menu.AppMenuRootItem
 *  net.ibizsys.paas.control.menu.IAppMenu
 */
package SA.SRFDA.PS.Core.Control.Menu;

import SA.SRFDA.PS.Core.App.AppMenu.IPSAppMenuModel;
import SA.SRFDA.PS.Core.App.Control.IPSAppCounterRef;
import SA.SRFDA.PS.Core.App.Func.IPSAppFunc;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounter;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounterRef;
import SA.SRFDA.PS.Core.Control.IPSAjaxControl;
import SA.SRFDA.PS.Core.Control.Layout.IPSLayoutContainer;
import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenuItem;
import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenuLogic;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import java.util.Iterator;
import net.ibizsys.paas.control.IControlCustomizable;
import net.ibizsys.paas.control.menu.AppMenuRootItem;
import net.ibizsys.paas.control.menu.IAppMenu;

@PSModelInterfaceMeta(title="\u5e94\u7528\u83dc\u5355\u90e8\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSAppMenu")
public interface IPSAppMenu
extends IPSAjaxControl,
IAppMenu,
IPSAppMenuModel,
IControlCustomizable,
IPSLayoutContainer {
    public static final String APPMENUSTYLE_ICONVIEW = "ICONVIEW";
    public static final String APPMENUSTYLE_LISTVIEW = "LISTVIEW";
    public static final String APPMENUSTYLE_SWIPERVIEW = "SWIPERVIEW";
    public static final String APPMENUSTYLE_USER = "USER";
    public static final String APPMENUSTYLE_USER2 = "USER2";

    @Override
    public Iterator<IPSAppMenuItem> getPSAppMenuItems() throws Exception;

    @Override
    public AppMenuRootItem getRootItem();

    @Override
    public Iterator<IPSAppFunc> getPSAppFuncs();

    @Override
    public IPSSysCounter getPSSysCounter();

    public Iterator<IPSAppMenuItem> getAllPSAppMenuItems() throws Exception;

    public String getLayoutMode();

    public String getAppMenuStyle();

    public IPSSysCounterRef getPSSysCounterRef();

    public IPSAppCounterRef getPSAppCounterRef();

    public Iterator<? extends IPSAppMenuLogic> getPSAppMenuLogics();

    public boolean isEnableCustomized();
}

