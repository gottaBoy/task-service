/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.wf.demodel.wfstepdata.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="095ff4eab83529a1b8f093180a7ef3fa", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="WFSTEPDATAID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="WFSTEPDATANAME", format="")})})
public abstract class WFStepDataDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public WFStepDataDefaultACModelBase() {
        this.initAnnotation(WFStepDataDefaultACModelBase.class);
    }
}

