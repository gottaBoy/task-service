/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.tssdpolicyowner.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="f19ecba385e1fe480789956e5f638b78", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="TSSDPOLICYOWNERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="TSSDPOLICYOWNERNAME", format="")})})
public abstract class TSSDPolicyOwnerDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public TSSDPolicyOwnerDefaultACModelBase() {
        this.initAnnotation(TSSDPolicyOwnerDefaultACModelBase.class);
    }
}

