/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.def.demodel.psv3migratede.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="29fda5b9896b8599b84ea8257ca90d56", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSV3MIGRATEDEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSV3MIGRATEDENAME", format="")})})
public class PSV3MigrateDEDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSV3MigrateDEDefaultACModel() {
        this.initAnnotation(PSV3MigrateDEDefaultACModel.class);
    }
}

