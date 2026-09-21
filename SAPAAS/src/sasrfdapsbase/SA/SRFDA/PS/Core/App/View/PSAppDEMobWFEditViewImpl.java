/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEMobWFEditView;
import SA.SRFDA.PS.Core.App.View.PSAppDEWFEditViewImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DEMOBWFEDITVIEW", "DEMOBWFEDITVIEW3"})
public class PSAppDEMobWFEditViewImpl
extends PSAppDEWFEditViewImpl
implements IPSAppDEMobWFEditView {
    private boolean isEnablePullDownRefresh = false;

    @Override
    protected void onInit() throws Exception {
        if (!this.psViewBase.isVIEWPARAM9Null()) {
            this.isEnablePullDownRefresh = this.psViewBase.getVIEWPARAM9() == 1;
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u4e0b\u62c9\u5237\u65b0")
    public boolean isEnablePullDownRefresh() {
        return this.isEnablePullDownRefresh;
    }

    @Override
    public boolean isMobileView() {
        return true;
    }
}

