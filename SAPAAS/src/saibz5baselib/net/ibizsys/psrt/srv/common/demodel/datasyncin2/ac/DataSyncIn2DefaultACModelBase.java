/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.datasyncin2.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="04c87ff6cdac6dd390613dbc44f3c51d", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="DATASYNCIN2ID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="DATASYNCIN2NAME", format="")})})
public abstract class DataSyncIn2DefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public DataSyncIn2DefaultACModelBase() {
        this.initAnnotation(DataSyncIn2DefaultACModelBase.class);
    }
}

