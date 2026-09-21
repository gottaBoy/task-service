/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.dashboard.IDashboard
 */
package SA.SRFDA.PS.Core.Control.Dashboard;

import SA.SRFDA.PS.Core.App.Util.IPSAppDynaDashboardUtil;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBPortletPart;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDashboardContainer;
import SA.SRFDA.PS.Core.Control.IPSAjaxControl;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.Layout.IPSLayoutContainer;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import java.util.Iterator;
import net.ibizsys.paas.control.dashboard.IDashboard;

@PSModelInterfaceMeta(title="\u6570\u636e\u770b\u677f\u90e8\u4ef6\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3")
public interface IPSDashboard
extends IPSAjaxControl,
IPSControlContainer,
IDashboard,
IPSDashboardContainer,
IPSLayoutContainer {
    @Override
    public Iterator<IPSDBPortletPart> getPSPortlets();

    public Iterator<IPSDBPortletPart> getAllPSPortlets();

    public boolean isEnableCustomized();

    public IPSAppDynaDashboardUtil getPSAppDynaDashboardUtil();

    public int getCustomizeMode();

    public String getDashboardStyle();

    public boolean isShowDashboardNavBar();

    public String getNavBarPos();

    public String getNavBarStyle();

    public double getNavBarWidth();

    public double getNavbarHeight();

    public IPSSysCss getNavBarPSSysCss();
}

