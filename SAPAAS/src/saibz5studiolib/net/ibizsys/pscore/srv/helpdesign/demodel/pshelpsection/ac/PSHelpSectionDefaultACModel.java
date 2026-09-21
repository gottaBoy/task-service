/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.helpdesign.demodel.pshelpsection.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="73cfdaec02431ecf63f661d78861b18d", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSHELPSECTIONID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSHELPSECTIONNAME", format="")})})
public class PSHelpSectionDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSHelpSectionDefaultACModel() {
        this.initAnnotation(PSHelpSectionDefaultACModel.class);
    }
}

