/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssubapp.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="6f7a0e8f92848460fb01df38a8c3a6f0", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSUBAPPID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSUBAPPNAME", format="")})})
public class PSSubAppDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSubAppDefaultACModel() {
        this.initAnnotation(PSSubAppDefaultACModel.class);
    }
}

