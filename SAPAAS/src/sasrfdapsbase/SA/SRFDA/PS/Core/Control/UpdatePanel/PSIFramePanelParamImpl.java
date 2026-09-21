/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.UpdatePanel;

import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.PSControlParamImpl;
import SA.SRFDA.PS.Core.Control.UpdatePanel.IPSIFramePanelParam;
import SA.SRFDA.PS.Core.Control.UpdatePanel.IPSUpdatePanelParam;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public class PSIFramePanelParamImpl
extends PSControlParamImpl
implements IPSIFramePanelParam {
    private Integer nTimer = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (!this.psDEViewCtrl.isCTRLPARAM7Null() && this.psDEViewCtrl.getCTRLPARAM7() > 0) {
            this.nTimer = this.psDEViewCtrl.getCTRLPARAM7();
        }
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSUpdatePanelParam) {
            IPSIFramePanelParam iPSDEViewBarParam = (IPSIFramePanelParam)iPSControlParam;
            if (this.getTimer() == null) {
                this.setTimer(iPSDEViewBarParam.getTimer());
            }
        }
    }

    @Override
    public Integer getTimer() {
        return this.nTimer;
    }

    protected void setTimer(Integer nTimer) {
        this.nTimer = nTimer;
    }
}

