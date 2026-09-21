/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.ctrlmodel.CtrlModelBase;
import net.ibizsys.paas.ctrlmodel.IWizardPanelModel;

public abstract class WizardPanelModelBase
extends CtrlModelBase
implements IWizardPanelModel {
    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public String getControlType() {
        return "WIZARDPANEL";
    }
}

