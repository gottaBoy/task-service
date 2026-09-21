/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.Control.IPSAppCounterRef;
import SA.SRFDA.PS.Core.App.Func.IPSAppFunc;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounterRef;
import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenu;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import java.util.Iterator;

@PSModelExtendMeta(title="\u5e94\u7528\u9996\u9875\u89c6\u56fe\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"APPINDEXVIEW"}, model="PSAppIndexView")
public interface IPSAppIndexView
extends IPSAppView {
    public static final int APPSWITCHMODE_NONE = 0;
    public static final int APPSWITCHMODE_DEFAULT = 1;

    @Override
    public Iterator<IPSAppFunc> getPSAppFuncs();

    public IPSAppMenu getPSAppMenu();

    public IPSAppMenu getLeftSidePSAppMenu();

    public IPSAppMenu getRightSidePSAppMenu();

    public IPSAppMenu getTopSidePSAppMenu();

    public IPSAppMenu getBottomSidePSAppMenu();

    public boolean isDefaultPage();

    public String getAppIconPath();

    public String getAppIconPath2();

    public IPSSysCounterRef getPortalPSSysCounterRef();

    public IPSAppCounterRef getPortalPSAppCounterRef();

    @Override
    public String getMainMenuAlign();

    public IPSAppView getDefPSAppView();

    public boolean isBlankMode();

    public boolean isEnableAppSwitch();

    public int getAppSwitchMode();

    public String getHeaderInfo();

    public String getBottomInfo();
}

