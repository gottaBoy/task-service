/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.datasyncout.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="c8381accf6c7621d57757a4955ddb504", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="DATASYNCOUTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="DATASYNCOUTNAME", format="")})})
public abstract class DataSyncOutDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public DataSyncOutDefaultACModelBase() {
        this.initAnnotation(DataSyncOutDefaultACModelBase.class);
    }
}

