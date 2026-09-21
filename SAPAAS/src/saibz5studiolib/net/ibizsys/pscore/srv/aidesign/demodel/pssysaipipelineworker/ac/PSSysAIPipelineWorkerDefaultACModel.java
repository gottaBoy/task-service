/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.aidesign.demodel.pssysaipipelineworker.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="4189b0cffef453439e6e074a67888eff", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSAIPIPELINEWORKERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSAIPIPELINEWORKERNAME", format="")})})
public class PSSysAIPipelineWorkerDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysAIPipelineWorkerDefaultACModel() {
        this.initAnnotation(PSSysAIPipelineWorkerDefaultACModel.class);
    }
}

