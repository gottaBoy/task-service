/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.wfdesign.demodel.psworkflow.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="fadd435d8dffe9e9b4b89f13fe092ba5", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSWORKFLOWID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSWORKFLOWNAME", format="")})})
public class PSWorkflowDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSWorkflowDefaultACModel() {
        this.initAnnotation(PSWorkflowDefaultACModel.class);
    }
}

