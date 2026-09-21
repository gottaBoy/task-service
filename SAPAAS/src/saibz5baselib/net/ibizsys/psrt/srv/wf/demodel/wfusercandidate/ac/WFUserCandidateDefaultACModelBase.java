/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.wf.demodel.wfusercandidate.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="9f2a5bbda357d70344cb5debd7d05c71", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="WFUSERCANDIDATEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="WFUSERCANDIDATENAME", format="")})})
public abstract class WFUserCandidateDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public WFUserCandidateDefaultACModelBase() {
        this.initAnnotation(WFUserCandidateDefaultACModelBase.class);
    }
}

