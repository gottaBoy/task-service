/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.wf.demodel.wfstepactor.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="3860c42c755f4097c4dfe7d806b185bc", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="WFSTEPACTORID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="WFSTEPACTORNAME", format="")})})
public abstract class WFStepActorDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public WFStepActorDefaultACModelBase() {
        this.initAnnotation(WFStepActorDefaultACModelBase.class);
    }
}

