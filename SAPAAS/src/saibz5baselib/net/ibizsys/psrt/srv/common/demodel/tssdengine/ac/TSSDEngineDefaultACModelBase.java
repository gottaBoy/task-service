/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.tssdengine.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="e4da63c72c04866163e5a74ca984d13f", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="TSSDENGINEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="TSSDENGINENAME", format="")})})
public abstract class TSSDEngineDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public TSSDEngineDefaultACModelBase() {
        this.initAnnotation(TSSDEngineDefaultACModelBase.class);
    }
}

