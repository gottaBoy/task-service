/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdemainstate.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="0e8c0d9cad63c1e84d0ae26a8ce55aae", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEMAINSTATEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEMAINSTATENAME", format="")})})
public class PSDEMainStateDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEMainStateDefaultACModel() {
        this.initAnnotation(PSDEMainStateDefaultACModel.class);
    }
}

