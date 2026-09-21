/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psuwdemainstate.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="d12b9fa6ddc62753c2d5c69e3bbc278f", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSUWDEMAINSTATEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSUWDEMAINSTATENAME", format="")})})
public class PSUWDEMainStateDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSUWDEMainStateDefaultACModel() {
        this.initAnnotation(PSUWDEMainStateDefaultACModel.class);
    }
}

