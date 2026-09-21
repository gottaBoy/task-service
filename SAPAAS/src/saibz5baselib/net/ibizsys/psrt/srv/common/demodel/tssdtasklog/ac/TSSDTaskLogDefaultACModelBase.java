/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.tssdtasklog.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="5d9604bc9220d47f935650303d154680", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="TSSDTASKLOGID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="TSSDTASKLOGNAME", format="")})})
public abstract class TSSDTaskLogDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public TSSDTaskLogDefaultACModelBase() {
        this.initAnnotation(TSSDTaskLogDefaultACModelBase.class);
    }
}

