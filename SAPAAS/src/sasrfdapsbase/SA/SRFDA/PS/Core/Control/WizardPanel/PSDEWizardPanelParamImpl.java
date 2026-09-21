/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control.WizardPanel;

import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.WizardPanel.IPSDEWizardPanelParam;
import SA.SRFDA.PS.Core.Control.WizardPanel.PSWizardPanelParamImpl;
import net.ibizsys.paas.util.StringHelper;

public class PSDEWizardPanelParamImpl
extends PSWizardPanelParamImpl
implements IPSDEWizardPanelParam {
    private String strPSDEWizardId = "";

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.strPSDEWizardId = this.psDEViewCtrl.getPSDEWIZARDID();
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSDEWizardPanelParam) {
            IPSDEWizardPanelParam iPSDEWizardPanelParam = (IPSDEWizardPanelParam)iPSControlParam;
            if (StringHelper.isNullOrEmpty((String)this.getPSDEWizardId())) {
                this.setPSDEWizardId(iPSDEWizardPanelParam.getPSDEWizardId());
            }
        }
    }

    @Override
    public String getPSDEWizardId() {
        return this.strPSDEWizardId;
    }

    protected void setPSDEWizardId(String strPSDEWizardId) {
        this.strPSDEWizardId = strPSDEWizardId;
    }
}

