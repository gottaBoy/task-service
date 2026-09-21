/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdesampledata.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="40a3971040f5d965fb9a1fcf8549b71b", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDESAMPLEDATAID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDESAMPLEDATANAME", format="")})})
public class PSDESampleDataDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDESampleDataDefaultACModel() {
        this.initAnnotation(PSDESampleDataDefaultACModel.class);
    }
}

