/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.wf.demodel.wfworkflow.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="0166e9c016bf57201ba996cba3a67a45", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="WFWORKFLOWID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="WFWORKFLOWNAME", format="")})})
public abstract class WFWorkflowDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public WFWorkflowDefaultACModelBase() {
        this.initAnnotation(WFWorkflowDefaultACModelBase.class);
    }
}

