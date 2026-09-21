/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.datasyncout2.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="1cecb3d95febd748a2daf8e9c86a8ec5", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="DATASYNCOUT2ID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="DATASYNCOUT2NAME", format="")})})
public abstract class DataSyncOut2DefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public DataSyncOut2DefaultACModelBase() {
        this.initAnnotation(DataSyncOut2DefaultACModelBase.class);
    }
}

