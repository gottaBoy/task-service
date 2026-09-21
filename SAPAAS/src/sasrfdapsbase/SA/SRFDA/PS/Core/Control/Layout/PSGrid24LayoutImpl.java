/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Layout;

import SA.SRFDA.PS.Core.Control.Layout.IPSLayoutPos;
import SA.SRFDA.PS.Core.Control.Layout.PSGrid12LayoutImpl;
import SA.SRFDA.PS.Core.Control.Layout.PSGridLayoutPosImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelImplementMeta(implement="IPSLayout", typevalues={"TABLE_24COL"})
public class PSGrid24LayoutImpl
extends PSGrid12LayoutImpl {
    @Override
    @PSModelRTMeta(description="\u542f\u752812\u5217\u8f6c24\u5217\u5e03\u5c40", ignoredumpvalues="false", group="\u4f4d\u7f6e")
    public boolean isEnableCol12ToCol24() {
        if (this.getPSControl() != null) {
            return this.getPSControl().isEnableCol12ToCol24();
        }
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u5e03\u5c40\u6a21\u5f0f", group="\u4f4d\u7f6e")
    public String getLayout() {
        return "TABLE_24COL";
    }

    @Override
    @PSModelRTMeta(description="\u5217\u6570\u91cf", group="\u4f4d\u7f6e", staticcode="24")
    public int getColumnCount() {
        return 24;
    }

    @Override
    protected IPSLayoutPos createPSLayoutPos() throws Exception {
        return new PSGridLayoutPosImpl();
    }
}

