/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.def.demodel.psv3migrate.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="4766665d695784b0e9cfa21bfbffe351", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSV3MIGRATEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSV3MIGRATENAME", format="")})})
public class PSV3MigrateDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSV3MigrateDefaultACModel() {
        this.initAnnotation(PSV3MigrateDefaultACModel.class);
    }
}

