/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.control.menu.IAppMenuItem
 */
package SA.SRFDA.PS.Core.Control.Menu;

import SA.SRFDA.PS.Core.App.AppMenu.IPSAppMenuModel;
import SA.SRFDA.PS.Core.App.Func.IPSAppFunc;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.IPSNavigateParamContainer;
import SA.SRFDA.PS.Core.Control.Layout.IPSLayoutContainer;
import SA.SRFDA.PS.Core.Control.Layout.IPSLayoutItem;
import SA.SRFDA.PS.Core.Control.Menu.IPSMenuItem;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Data.PSAppMenuItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.control.menu.IAppMenuItem;

@PSModelInterfaceMeta(title="\u5e94\u7528\u83dc\u5355\u9879\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typefield="itemType", implement="PSAppMenuItemImpl", model="PSAppMenuItem")
public interface IPSAppMenuItem
extends IPSMenuItem,
IAppMenuItem,
IPSLayoutContainer,
IPSLayoutItem,
IPSNavigateParamContainer {
    public static final String ITEMTYPE_SEPERATOR = "SEPERATOR";
    public static final String ITEMTYPE_USERITEM = "USERITEM";
    public static final String ITEMTYPE_APPMENUREF = "APPMENUREF";
    public static final String ITEMTYPE_MENUITEM = "MENUITEM";
    public static final String ITEMTYPE_RAWITEM = "RAWITEM";
    public static final int STATE_NEW = 1;
    public static final int STATE_HOT = 2;

    public void init(ISRFDAGlobalHelper var1, IPSAppMenuModel var2, IPSAppMenuItem var3, PSAppMenuItem var4) throws Exception;

    public Iterator<IPSAppMenuItem> getPSAppMenuItems();

    public void fillRelatedPSAppViews(ArrayList<IPSAppView> var1) throws Exception;

    public IPSAppFunc getPSAppFunc();

    public void fillRelatedPSAppFuncs(ArrayList<IPSAppFunc> var1);

    public boolean isOpenDefault();

    public boolean isDisableClose();

    public boolean isHideSideBar();

    @Override
    public String getTooltip();

    public IPSSysImage getPSSysImage();

    public IPSSysCss getPSSysCss();

    public boolean isValid();

    @Override
    public String getCounterId();

    public IPSPFXCodeObject getRender();

    public IPSSysPFPlugin getPSSysPFPlugin();

    public String getLayoutMode();

    public String getInformTag();

    public String getInformTag2();

    public int getTitleBarCloseMode();

    public String getData();

    public boolean isSeperator();

    public int getAppMenuItemState();

    public String getDynaClass();

    public String getCssStyle();

    public String getItemStyle();

    public String getPredefinedType();

    public String getPredefinedTypeParam();

    public boolean isSpanMode();
}

