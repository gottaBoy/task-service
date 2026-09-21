/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEMobDataViewExplorerView;
import SA.SRFDA.PS.Core.App.View.PSAppDEDataViewExplorerViewImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DEMOBDATAVIEWEXPVIEW"})
public class PSAppDEMobDataViewExplorerViewImpl
extends PSAppDEDataViewExplorerViewImpl
implements IPSAppDEMobDataViewExplorerView {
    private boolean isEnablePullDownRefresh = false;

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
    public boolean isMobileView() {
        return true;
    }
}

