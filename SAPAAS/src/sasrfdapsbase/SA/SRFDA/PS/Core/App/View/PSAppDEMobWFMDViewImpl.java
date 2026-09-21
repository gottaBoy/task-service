/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEMobWFMDView;
import SA.SRFDA.PS.Core.App.View.IPSAppDEWFActionView;
import SA.SRFDA.PS.Core.App.View.PSAppDEMobMDViewImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DEMOBWFMDVIEW"})
public class PSAppDEMobWFMDViewImpl
extends PSAppDEMobMDViewImpl
implements IPSAppDEWFActionView,
IPSAppDEMobWFMDView {
    @Override
    protected void onInit() throws Exception {
        if (!this.psViewBase.isWFVIEWPARAMNull()) {
            this.setWFIAMode(this.psViewBase.getWFVIEWPARAM());
        }
        this.setWFStepValue(this.psViewBase.getWFVIEWPARAM3());
        super.onInit();
    }

    @Override
    public boolean isEnableWF() {
        return this.getPSDEWF() != null;
    }
}

