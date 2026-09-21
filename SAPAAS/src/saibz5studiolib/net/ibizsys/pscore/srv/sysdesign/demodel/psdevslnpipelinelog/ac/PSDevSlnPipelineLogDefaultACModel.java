/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevslnpipelinelog.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="ed4db7fbe704d5f59a233a3fd4f5349b", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEVSLNPIPELINELOGID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEVSLNPIPELINELOGNAME", format="")})})
public class PSDevSlnPipelineLogDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDevSlnPipelineLogDefaultACModel() {
        this.initAnnotation(PSDevSlnPipelineLogDefaultACModel.class);
    }
}

