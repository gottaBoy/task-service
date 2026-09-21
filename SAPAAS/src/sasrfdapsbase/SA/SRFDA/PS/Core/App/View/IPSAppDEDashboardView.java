/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDESearchView;
import SA.SRFDA.PS.Core.App.View.IPSAppDESearchView2;
import SA.SRFDA.PS.Core.App.View.IPSAppDESearchView3;
import SA.SRFDA.PS.Core.App.View.IPSAppDEView;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u5e94\u7528\u5b9e\u4f53\u6570\u636e\u770b\u677f\u89c6\u56fe\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"DEPORTALVIEW", "DEPORTALVIEW9"}, model="PSDEViewBase")
public interface IPSAppDEDashboardView
extends IPSAppDEView,
IPSAppDESearchView,
IPSAppDESearchView2,
IPSAppDESearchView3 {
    public boolean isShowDataInfoBar();

    public String getMarkOpenDataMode();
}

