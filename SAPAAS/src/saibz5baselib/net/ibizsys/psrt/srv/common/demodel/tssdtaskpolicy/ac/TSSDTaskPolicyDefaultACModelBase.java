/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.tssdtaskpolicy.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="7fbddaf527849efd537411955e65800d", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="TSSDTASKPOLICYID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="TSSDTASKPOLICYNAME", format="")})})
public abstract class TSSDTaskPolicyDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public TSSDTaskPolicyDefaultACModelBase() {
        this.initAnnotation(TSSDTaskPolicyDefaultACModelBase.class);
    }
}

