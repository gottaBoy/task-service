/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEMobMDView;
import SA.SRFDA.PS.Core.App.View.PSAppDEMultiDataViewImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DEMOBMDVIEW", "DEMOBMDVIEW9"})
public class PSAppDEMobMDViewImpl
extends PSAppDEMultiDataViewImpl
implements IPSAppDEMobMDView {
    private boolean isEnablePullDownRefresh = false;

    @Override
    public boolean isMobileView() {
        return true;
    }

    @Override
    protected void onInit() throws Exception {
        if (!this.psViewBase.isVIEWPARAM9Null()) {
            this.isEnablePullDownRefresh = this.psViewBase.getVIEWPARAM9() == 1;
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u4e0b\u62c9\u5237\u65b0", fields={"VIEWPARAM9"})
    public boolean isEnablePullDownRefresh() {
        return this.isEnablePullDownRefresh;
    }

    @Override
    protected String onGetXDataControlName() {
        return "mdctrl";
    }
}

