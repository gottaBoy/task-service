/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.wf.demodel.wfuiwizard.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="6ad51695d5686e6ed1738d36b5a6b1a2", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="WFUIWIZARDID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="WFUIWIZARDNAME", format="")})})
public abstract class WFUIWizardDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public WFUIWizardDefaultACModelBase() {
        this.initAnnotation(WFUIWizardDefaultACModelBase.class);
    }
}

