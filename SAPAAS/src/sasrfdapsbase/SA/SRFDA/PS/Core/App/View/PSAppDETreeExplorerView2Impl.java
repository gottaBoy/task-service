/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.PSAppDETreeExplorerViewImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DETREEEXPVIEW2"})
public class PSAppDETreeExplorerView2Impl
extends PSAppDETreeExplorerViewImpl {
    @Override
    @PSModelRTMeta(description="IFrame\u6a21\u5f0f")
    public boolean isIFrameMode() {
        return true;
    }
}

