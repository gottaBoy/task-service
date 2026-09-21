/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.PSAppDERedirectViewImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DEWFPROXYDATAREDIRECTVIEW"})
public class PSAppDEWFProxyDataRedirectViewImpl
extends PSAppDERedirectViewImpl {
    @Override
    public boolean isEnableWorkflow() {
        return true;
    }

    @Override
    public boolean isRedirectView() {
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u6d41\u7a0b")
    public boolean isEnableWF() {
        return true;
    }
}

