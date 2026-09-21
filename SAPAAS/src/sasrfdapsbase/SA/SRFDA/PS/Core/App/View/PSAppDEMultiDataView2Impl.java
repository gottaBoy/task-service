/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEMultiDataView2;
import SA.SRFDA.PS.Core.App.View.PSAppDEMultiDataViewImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DEMDCUSTOMVIEW"})
public class PSAppDEMultiDataView2Impl
extends PSAppDEMultiDataViewImpl
implements IPSAppDEMultiDataView2 {
    private int nMDCtrlActiveMode = 2;
    private boolean bEnableDbClickActiveData = true;

    @Override
    protected void onInit() throws Exception {
        if (!this.psViewBase.isVIEWPARAM6Null()) {
            this.bEnableDbClickActiveData = false;
            this.nMDCtrlActiveMode = this.psViewBase.GetParamIntValue("VIEWPARAM6", 0);
            if (this.nMDCtrlActiveMode == 1) {
                this.nMDCtrlActiveMode = 2;
                this.bEnableDbClickActiveData = true;
            } else if (this.nMDCtrlActiveMode == 2) {
                this.nMDCtrlActiveMode = 1;
            }
        } else {
            this.nMDCtrlActiveMode = this.getPSAppView().getPSApplication().getPSApplicationUI().getGridRowActiveMode();
            this.bEnableDbClickActiveData = this.nMDCtrlActiveMode == 2;
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u591a\u6570\u636e\u90e8\u4ef6\u6fc0\u6d3b\u6a21\u5f0f", codelist="GridRowActiveMode", fields={"VIEWPARAM6"})
    public int getMDCtrlActiveMode() {
        return this.nMDCtrlActiveMode;
    }

    @Override
    public boolean isDbClickEditData() {
        return this.bEnableDbClickActiveData;
    }
}

