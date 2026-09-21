/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT2", id="74468AF7-8F68-4F6A-88CB-F56EE1B7C56B", dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSUAWIZARDID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSUAWIZARDNAME", format="")}), @DataItem(name="logicname", dataitemparams={@DataItemParam(name="WIZARDPARAM4", format="%1$s")})})
public class PSDEUAWizardDefault2ACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT2";

    public PSDEUAWizardDefault2ACModel() {
        this.initAnnotation(PSDEUAWizardDefault2ACModel.class);
    }
}

