/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.wf.demodel.wfaction.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="50811730d38a8bd964a31a05331bc214", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="WFACTIONID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="WFACTIONNAME", format="")})})
public abstract class WFActionDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public WFActionDefaultACModelBase() {
        this.initAnnotation(WFActionDefaultACModelBase.class);
    }
}

