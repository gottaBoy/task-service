/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.wf.demodel.wfassistwork.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="80bc47afe28e23ebfb7aea12fdbc1acd", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="WFASSISTWORKID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="WFASSISTWORKNAME", format="")})})
public abstract class WFAssistWorkDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public WFAssistWorkDefaultACModelBase() {
        this.initAnnotation(WFAssistWorkDefaultACModelBase.class);
    }
}

