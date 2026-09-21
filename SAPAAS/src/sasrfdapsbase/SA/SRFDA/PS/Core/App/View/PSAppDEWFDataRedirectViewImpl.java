/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEWFDataRedirectView;
import SA.SRFDA.PS.Core.App.View.PSAppDERedirectViewImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DEWFDATAREDIRECTVIEW"})
public class PSAppDEWFDataRedirectViewImpl
extends PSAppDERedirectViewImpl
implements IPSAppDEWFDataRedirectView {
    @Override
    @PSModelRTMeta(description="\u652f\u6301\u6d41\u7a0b")
    public boolean isEnableWF() {
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u4ea4\u4e92\u6a21\u5f0f")
    public boolean isWFIAMode() {
        return super.isWFIAMode();
    }

    @Override
    @PSModelRTMeta(description="\u7ed1\u5b9a\u6d41\u7a0b\u6b65\u9aa4\u503c", hideempty2=true)
    public String getWFStepValue() {
        return super.getWFStepValue();
    }
}

