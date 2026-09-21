/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.tssdtasktype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="43332c6488824ab95b327d64b4f23a1b", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="TSSDTASKTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="TSSDTASKTYPENAME", format="")})})
public abstract class TSSDTaskTypeDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public TSSDTaskTypeDefaultACModelBase() {
        this.initAnnotation(TSSDTaskTypeDefaultACModelBase.class);
    }
}

