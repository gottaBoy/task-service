/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.tssdtask.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="f8d12641ce30b874fa6c58f749b0bb73", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="TSSDTASKID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="TSSDTASKNAME", format="")})})
public abstract class TSSDTaskDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public TSSDTaskDefaultACModelBase() {
        this.initAnnotation(TSSDTaskDefaultACModelBase.class);
    }
}

