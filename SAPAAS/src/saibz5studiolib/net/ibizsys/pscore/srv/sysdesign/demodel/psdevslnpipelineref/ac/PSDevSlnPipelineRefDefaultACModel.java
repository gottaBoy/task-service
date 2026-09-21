/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevslnpipelineref.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="e33f31999f53262da44ad23afb38ae99", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEVSLNPIPELINEREFID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEVSLNPIPELINEREFNAME", format="")})})
public class PSDevSlnPipelineRefDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDevSlnPipelineRefDefaultACModel() {
        this.initAnnotation(PSDevSlnPipelineRefDefaultACModel.class);
    }
}

