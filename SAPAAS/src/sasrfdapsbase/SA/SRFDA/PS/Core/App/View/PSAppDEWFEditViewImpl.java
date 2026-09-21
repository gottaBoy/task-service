/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEWFEditView;
import SA.SRFDA.PS.Core.App.View.PSAppDEEditViewImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DEWFEDITVIEW", "DEWFEDITVIEW2", "DEWFEDITVIEW3", "DEWFEDITVIEW9"})
public class PSAppDEWFEditViewImpl
extends PSAppDEEditViewImpl
implements IPSAppDEWFEditView {
    @Override
    protected void onInit() throws Exception {
        if (!this.psViewBase.isWFVIEWPARAMNull()) {
            this.setWFIAMode(this.psViewBase.getWFVIEWPARAM());
        }
        this.setWFStepValue(this.psViewBase.getWFVIEWPARAM3());
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u6d41\u7a0b")
    public boolean isEnableWF() {
        return this.getPSDEWF() != null;
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u4ea4\u4e92\u6a21\u5f0f", fields={"WFVIEWPARAM"})
    public boolean isWFIAMode() {
        return super.isWFIAMode();
    }

    @Override
    @PSModelRTMeta(description="\u7ed1\u5b9a\u6d41\u7a0b\u6b65\u9aa4\u503c", hideempty2=true, fields={"WFVIEWPARAM3"})
    public String getWFStepValue() {
        return super.getWFStepValue();
    }
}

