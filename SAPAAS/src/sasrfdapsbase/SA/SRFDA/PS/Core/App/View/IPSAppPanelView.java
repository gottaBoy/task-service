/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppMobView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanel;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u5e94\u7528\u9762\u677f\u89c6\u56fe\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"APPPANELVIEW"}, model="PSAppPanelView")
public interface IPSAppPanelView
extends IPSAppView,
IPSAppMobView {
    public IPSPanel getPSPanel();
}

