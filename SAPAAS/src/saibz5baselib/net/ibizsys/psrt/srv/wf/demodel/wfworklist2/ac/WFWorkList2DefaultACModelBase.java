/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.wf.demodel.wfworklist2.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="e888ed9d1cfcb38ac15cceaa4130b162", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="WFWORKLISTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="WFWORKLISTNAME", format="")})})
public abstract class WFWorkList2DefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public WFWorkList2DefaultACModelBase() {
        this.initAnnotation(WFWorkList2DefaultACModelBase.class);
    }
}

