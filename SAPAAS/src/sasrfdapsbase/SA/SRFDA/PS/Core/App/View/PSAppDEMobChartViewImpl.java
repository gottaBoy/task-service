/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEMobChartView;
import SA.SRFDA.PS.Core.App.View.PSAppDEChartViewImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DEMOBCHARTVIEW", "DEMOBCHARTVIEW9"})
public class PSAppDEMobChartViewImpl
extends PSAppDEChartViewImpl
implements IPSAppDEMobChartView {
    private boolean isEnablePullDownRefresh = false;

    @Override
    protected void onInit() throws Exception {
        if (!this.psViewBase.isVIEWPARAM9Null()) {
            this.isEnablePullDownRefresh = this.psViewBase.getVIEWPARAM9() == 1;
        }
        super.onInit();
    }

    @Override
    public boolean isMobileView() {
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u4e0b\u62c9\u5237\u65b0", fields={"VIEWPARAM9"})
    public boolean isEnablePullDownRefresh() {
        return this.isEnablePullDownRefresh;
    }
}

