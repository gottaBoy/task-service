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

@DEACMode(name="CURSFEXCEPTION", id="A8730B23-6994-4D33-9A77-771FECC60883", dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSUAWIZARDID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSUAWIZARDNAME", format="")})})
public class PSDEUAWizardCurSFExceptionACModel
extends DEACModelBase {
    public static final String NAME = "CURSFEXCEPTION";

    public PSDEUAWizardCurSFExceptionACModel() {
        this.initAnnotation(PSDEUAWizardCurSFExceptionACModel.class);
    }
}

