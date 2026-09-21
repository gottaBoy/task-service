/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Layout;

import SA.SRFDA.PS.Core.Control.Layout.IPSFlexLayoutPos;
import SA.SRFDA.PS.Core.Control.Layout.PSLayoutPosImplBase;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelImplementMeta(implement="IPSLayoutPos", typevalues={"FLEX", "SIMPLEFLEX"})
public class PSFlexLayoutPosImpl
extends PSLayoutPosImplBase
implements IPSFlexLayoutPos {
    private int nFlexGrow = -1;
    private int nFlexBasis = -1;
    private int nFlexShrink = 1;

    @Override
    protected void onInit() throws Exception {
        if (!this.getPSLayoutData().isFLEXGROWNull()) {
            this.nFlexGrow = this.getPSLayoutData().getFLEXGROW();
        }
        if (!this.getPSLayoutData().isFLEXSHRINKNull()) {
            this.nFlexShrink = this.getPSLayoutData().getFLEXSHRINK();
        }
        if (!this.getPSLayoutData().isFLEXBASISNull()) {
            this.nFlexBasis = this.getPSLayoutData().getFLEXBASIS();
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="Flex\u5ef6\u4f38", group="\u4f4d\u7f6e", fields={"FLEXGROW"}, ignoresetvalues="-1")
    public int getGrow() {
        return this.nFlexGrow;
    }

    @Override
    @PSModelRTMeta(description="Flex\u4f38\u7f29\u503c", group="\u4f4d\u7f6e", fields={"FLEXSHRINK"}, ignoredumpvalues="1", ignoresetvalues="1")
    public int getShrink() {
        return this.nFlexShrink;
    }

    @Override
    @PSModelRTMeta(description="Flex\u4f38\u7f29\u57fa\u51c6\u503c", group="\u4f4d\u7f6e", fields={"FLEXBASIS"}, ignoredumpvalues="-1", ignoresetvalues="-1")
    public int getBasis() {
        return this.nFlexBasis;
    }
}

