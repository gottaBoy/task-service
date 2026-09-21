/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.datasyncin.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="3621f160a6392fc07fea086d691daa0d", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="DATASYNCINID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="DATASYNCINNAME", format="")})})
public abstract class DataSyncInDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public DataSyncInDefaultACModelBase() {
        this.initAnnotation(DataSyncInDefaultACModelBase.class);
    }
}

