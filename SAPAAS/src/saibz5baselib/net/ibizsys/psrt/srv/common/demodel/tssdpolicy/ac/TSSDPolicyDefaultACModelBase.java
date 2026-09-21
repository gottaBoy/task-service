/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.tssdpolicy.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="0af0cc46519139106341b4cbfe9b89e7", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="TSSDPOLICYID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="TSSDPOLICYNAME", format="")})})
public abstract class TSSDPolicyDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public TSSDPolicyDefaultACModelBase() {
        this.initAnnotation(TSSDPolicyDefaultACModelBase.class);
    }
}

