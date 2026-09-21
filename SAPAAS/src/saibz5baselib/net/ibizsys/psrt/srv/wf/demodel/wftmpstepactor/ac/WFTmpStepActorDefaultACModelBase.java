/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.wf.demodel.wftmpstepactor.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="0e976da1c2895bf2e955f90554c10b15", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="WFTMPSTEPACTORID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="WFTMPSTEPACTORNAME", format="")})})
public abstract class WFTmpStepActorDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public WFTmpStepActorDefaultACModelBase() {
        this.initAnnotation(WFTmpStepActorDefaultACModelBase.class);
    }
}

