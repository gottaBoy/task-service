/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.WizardPanel;

import SA.SRFDA.PS.Core.Control.WizardPanel.IPSDEStateWizardPanel;
import SA.SRFDA.PS.Core.Control.WizardPanel.PSDEWizardPanelImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;

@PSModelImplementMeta(implement="IPSControl", typevalues={"STATEWIZARDPANEL"})
public class PSDEStateWizardPanelImpl
extends PSDEWizardPanelImpl
implements IPSDEStateWizardPanel {
    @Override
    protected String onGetControlType() {
        return "STATEWIZARDPANEL";
    }

    @Override
    public String getModelType() {
        return "PSDESTATEWIZARDPANEL";
    }

    @Override
    public boolean isShowActionBar() {
        return false;
    }
}

