/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEMobRedirectView;
import SA.SRFDA.PS.Core.App.View.PSAppDERedirectViewImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DEMOBREDIRECTVIEW"})
public class PSAppDEMobRedirectViewImpl
extends PSAppDERedirectViewImpl
implements IPSAppDEMobRedirectView {
    private boolean isEnablePullDownRefresh = false;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public boolean isEnablePullDownRefresh() {
        return this.isEnablePullDownRefresh;
    }

    @Override
    public boolean isMobileView() {
        return true;
    }
}

