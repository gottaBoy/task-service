/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.wf.demodel.wfstep.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="aa16d05a90245cec51dc8a2fb7f63fdb", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="WFSTEPID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="WFSTEPNAME", format="")})})
public abstract class WFStepDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public WFStepDefaultACModelBase() {
        this.initAnnotation(WFStepDefaultACModelBase.class);
    }
}

