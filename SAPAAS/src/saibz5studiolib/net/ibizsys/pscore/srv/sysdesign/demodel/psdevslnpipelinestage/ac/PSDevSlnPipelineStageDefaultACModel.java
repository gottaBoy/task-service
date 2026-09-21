/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevslnpipelinestage.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="012f1f736b9f6f25bb8d6c6f81fa21ea", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEVSLNPIPELINESTAGEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEVSLNPIPELINESTAGENAME", format="")})})
public class PSDevSlnPipelineStageDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDevSlnPipelineStageDefaultACModel() {
        this.initAnnotation(PSDevSlnPipelineStageDefaultACModel.class);
    }
}

