/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Layout;

import SA.SRFDA.PS.Core.Control.Layout.IPSFlexLayout;
import SA.SRFDA.PS.Core.Control.Layout.IPSLayoutPos;
import SA.SRFDA.PS.Core.Control.Layout.PSFlexLayoutPosImpl;
import SA.SRFDA.PS.Core.Control.Layout.PSLayoutImplBase;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelImplementMeta(implement="IPSLayout", typevalues={"FLEX", "SIMPLEFLEX"})
public class PSFlexLayoutImpl
extends PSLayoutImplBase
implements IPSFlexLayout {
    private String strFlexDir = "";
    private String strFlexAlign = "";
    private String strFlexVAlign = "";

    @Override
    protected void onInit() throws Exception {
        this.strFlexDir = this.getPSLayoutData().getFLEXDIR();
        this.strFlexAlign = this.getPSLayoutData().getFLEXALIGN();
        this.strFlexVAlign = this.getPSLayoutData().getFLEXVALIGN();
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u5e03\u5c40\u6a21\u5f0f")
    public String getLayout() {
        return "FLEX";
    }

    @Override
    protected IPSLayoutPos createPSLayoutPos() throws Exception {
        return new PSFlexLayoutPosImpl();
    }

    @Override
    @PSModelRTMeta(description="Flex\u5e03\u5c40\u65b9\u5411", codelist="FlexLayoutDir", group="\u4f4d\u7f6e", fields={"FLEXDIR"})
    public String getDir() {
        return this.strFlexDir;
    }

    @Override
    @PSModelRTMeta(description="Flex\u6a2a\u8f74\u5bf9\u9f50\u65b9\u5411", codelist="FlexAlign", group="\u4f4d\u7f6e", fields={"FLEXALIGN"})
    public String getAlign() {
        return this.strFlexAlign;
    }

    @Override
    @PSModelRTMeta(description="Flex\u7eb5\u8f74\u5bf9\u9f50\u65b9\u5411", codelist="FlexVAlign", group="\u4f4d\u7f6e", fields={"FLEXVALIGN"})
    public String getVAlign() {
        return this.strFlexVAlign;
    }
}

