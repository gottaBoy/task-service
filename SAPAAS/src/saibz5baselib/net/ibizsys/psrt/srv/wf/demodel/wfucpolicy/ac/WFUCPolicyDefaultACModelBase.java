/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.wf.demodel.wfucpolicy.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="fa6ff2a161c8371f494e170dde6ddb53", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="WFUCPOLICYID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="WFUCPOLICYNAME", format="")})})
public abstract class WFUCPolicyDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public WFUCPolicyDefaultACModelBase() {
        this.initAnnotation(WFUCPolicyDefaultACModelBase.class);
    }
}

