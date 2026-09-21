/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Layout;

import SA.SRFDA.PS.Core.Control.Layout.PSFlexLayoutImpl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelIgnoreMeta
public class PSSimpleFlexLayoutImpl
extends PSFlexLayoutImpl {
    @Override
    @PSModelRTMeta(description="\u5e03\u5c40\u6a21\u5f0f")
    public String getLayout() {
        return "SIMPLEFLEX";
    }
}

