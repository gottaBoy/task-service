/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psuwasyncaction.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="4c28347ded690926d7cec04026978e55", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSUWASYNCACTIONID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSUWASYNCACTIONNAME", format="")})})
public class PSUWAsyncActionDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSUWAsyncActionDefaultACModel() {
        this.initAnnotation(PSUWAsyncActionDefaultACModel.class);
    }
}

