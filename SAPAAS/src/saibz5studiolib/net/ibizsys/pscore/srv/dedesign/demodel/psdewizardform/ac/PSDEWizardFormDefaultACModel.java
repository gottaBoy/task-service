/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdewizardform.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="e70a1ccaa49d382ed6d7bfc0f66cfc7b", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEWIZARDFORMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEWIZARDFORMNAME", format="")})})
public class PSDEWizardFormDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEWizardFormDefaultACModel() {
        this.initAnnotation(PSDEWizardFormDefaultACModel.class);
    }
}

