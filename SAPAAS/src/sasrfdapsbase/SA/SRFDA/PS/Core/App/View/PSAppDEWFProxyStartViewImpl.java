/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEWFProxyStartView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.PSAppDEViewImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DEWFPROXYSTARTVIEW"})
public class PSAppDEWFProxyStartViewImpl
extends PSAppDEViewImpl
implements IPSAppDEWFProxyStartView {
    public static final String VIEWPARAM_LOGIC_RESULTVIEW = "LOGIC.RESULTVIEW";
    private IPSAppView resultPSAppView = null;

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u6d41\u7a0b")
    public boolean isEnableWF() {
        return this.getPSDEWF() != null;
    }

    @Override
    protected void onPreparePSAppViewRefs() throws Exception {
        super.onPreparePSAppViewRefs();
        this.resultPSAppView = this.getRefPSAppView("RESULT", true);
    }

    @Override
    protected void onPreparePSAppViewParams() throws Exception {
        if (this.getResultPSAppView() != null) {
            this.registerPSAppViewParam(VIEWPARAM_LOGIC_RESULTVIEW, this.getResultPSAppView().getId(), "\u7ed3\u679c\u89c6\u56fe\u6807\u8bc6");
        }
        super.onPreparePSAppViewParams();
    }

    public IPSAppView getResultPSAppView() {
        return this.resultPSAppView;
    }
}

