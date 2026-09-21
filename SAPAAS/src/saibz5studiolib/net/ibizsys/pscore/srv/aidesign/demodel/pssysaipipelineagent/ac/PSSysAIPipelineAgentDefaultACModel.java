/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.aidesign.demodel.pssysaipipelineagent.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="08e566c012819d658646fcfc4e47a27e", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSAIPIPELINEAGENTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSAIPIPELINEAGENTNAME", format="")})})
public class PSSysAIPipelineAgentDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysAIPipelineAgentDefaultACModel() {
        this.initAnnotation(PSSysAIPipelineAgentDefaultACModel.class);
    }
}

