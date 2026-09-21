/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.WizardPanel;

import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.PSAjaxControlParamImpl;
import SA.SRFDA.PS.Core.Control.WizardPanel.IPSWizardPanelParam;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSWizardPanelParamImpl
extends PSAjaxControlParamImpl
implements IPSWizardPanelParam {
    private static final Log log = LogFactory.getLog(PSWizardPanelParamImpl.class);
    private Boolean bShowStepBar = null;
    private Boolean bShowActionBar = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (!this.psDEViewCtrl.isCTRLPARAM6Null()) {
            this.setShowStepBar(this.psDEViewCtrl.getCTRLPARAM6());
        }
        if (!this.psDEViewCtrl.isCTRLPARAM5Null()) {
            this.setShowActionBar(this.psDEViewCtrl.getCTRLPARAM5());
        }
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSWizardPanelParam) {
            IPSWizardPanelParam iPSWizardPanelParam = (IPSWizardPanelParam)iPSControlParam;
            if (iPSWizardPanelParam.isShowStepBar() != null) {
                this.setShowStepBar(iPSWizardPanelParam.isShowStepBar());
            }
            if (iPSWizardPanelParam.isShowActionBar() != null) {
                this.setShowActionBar(iPSWizardPanelParam.isShowActionBar());
            }
        }
    }

    @Override
    public Boolean isShowStepBar() {
        if (this.bShowStepBar == null) {
            return null;
        }
        return this.bShowStepBar;
    }

    public void setShowStepBar(Boolean bShowStepBar) {
        this.bShowStepBar = bShowStepBar;
    }

    @Override
    public Boolean isShowActionBar() {
        if (this.bShowActionBar == null) {
            return null;
        }
        return this.bShowActionBar;
    }

    public void setShowActionBar(Boolean bShowActionBar) {
        this.bShowActionBar = bShowActionBar;
    }
}

