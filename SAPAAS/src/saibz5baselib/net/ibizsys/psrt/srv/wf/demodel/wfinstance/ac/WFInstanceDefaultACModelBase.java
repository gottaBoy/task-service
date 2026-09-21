/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.wf.demodel.wfinstance.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="0211d06b901d7948d2394149b7d0d96e", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="WFINSTANCEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="WFINSTANCENAME", format="")})})
public abstract class WFInstanceDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public WFInstanceDefaultACModelBase() {
        this.initAnnotation(WFInstanceDefaultACModelBase.class);
    }
}

