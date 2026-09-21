/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psvarsamplevalue.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="VALUE", id="C6E1B159-3019-4FE9-948D-5A336F1107F3", dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSVARSAMPLEVALUEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="VALUE", format="")})})
public class PSVarSampleValueValueACModel
extends DEACModelBase {
    public static final String NAME = "VALUE";

    public PSVarSampleValueValueACModel() {
        this.initAnnotation(PSVarSampleValueValueACModel.class);
        this.setMinorSortField("ORDERVALUE");
        this.setMinorSortDir("ASC");
    }
}

