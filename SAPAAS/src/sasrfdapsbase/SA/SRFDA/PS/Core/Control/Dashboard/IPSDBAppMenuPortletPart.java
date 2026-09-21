/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Dashboard;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBPortletPart;
import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenu;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;

@PSModelInterfaceMeta(title="\u5e94\u7528\u83dc\u5355\u95e8\u6237\u90e8\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSDBAppMenuPortletPart
extends IPSDBPortletPart {
    public IPSAppMenu getPSAppMenu();

    @Deprecated
    public IPSSysPFPlugin getAMSysPFPlugin();

    public IPSSysPFPlugin getAMPSSysPFPlugin();

    public String getAMListStyle();

    public IPSAppView getPSAppFuncPickupView();
}

