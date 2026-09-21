/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEWFProxyResultView;
import SA.SRFDA.PS.Core.App.View.PSAppDEViewImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DEWFPROXYRESULTVIEW"})
public class PSAppDEWFProxyResultViewImpl
extends PSAppDEViewImpl
implements IPSAppDEWFProxyResultView {
    @Override
    @PSModelRTMeta(description="\u542f\u7528\u6d41\u7a0b")
    public boolean isEnableWF() {
        return this.getPSDEWF() != null;
    }
}

