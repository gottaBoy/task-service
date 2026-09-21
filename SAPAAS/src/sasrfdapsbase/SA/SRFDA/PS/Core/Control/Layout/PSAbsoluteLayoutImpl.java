/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Layout;

import SA.SRFDA.PS.Core.Control.Layout.IPSAbsoluteLayout;
import SA.SRFDA.PS.Core.Control.Layout.IPSLayoutPos;
import SA.SRFDA.PS.Core.Control.Layout.PSAbsoluteLayoutPosImpl;
import SA.SRFDA.PS.Core.Control.Layout.PSLayoutImplBase;
import SA.SRFDA.PS.Core.PSModelRTMeta;

public class PSAbsoluteLayoutImpl
extends PSLayoutImplBase
implements IPSAbsoluteLayout {
    @Override
    @PSModelRTMeta(description="\u5e03\u5c40\u6a21\u5f0f", group="\u4f4d\u7f6e")
    public String getLayout() {
        return "ABSOLUTE";
    }

    @Override
    protected IPSLayoutPos createPSLayoutPos() throws Exception {
        return new PSAbsoluteLayoutPosImpl();
    }
}

