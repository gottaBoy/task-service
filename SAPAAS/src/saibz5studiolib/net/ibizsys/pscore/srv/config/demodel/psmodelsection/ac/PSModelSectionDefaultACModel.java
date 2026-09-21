/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psmodelsection.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="9546d270b852549955bee343f716ab5d", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSMODELSECTIONID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSMODELSECTIONNAME", format="")})})
public class PSModelSectionDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSModelSectionDefaultACModel() {
        this.initAnnotation(PSModelSectionDefaultACModel.class);
    }
}

