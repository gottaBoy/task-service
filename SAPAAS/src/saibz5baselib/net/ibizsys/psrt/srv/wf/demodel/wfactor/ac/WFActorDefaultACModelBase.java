/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.wf.demodel.wfactor.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="a532b2dae4eeecca638c9a8e1b7e3fa7", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="WFACTORID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="WFACTORNAME", format="")})})
public abstract class WFActorDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public WFActorDefaultACModelBase() {
        this.initAnnotation(WFActorDefaultACModelBase.class);
    }
}

