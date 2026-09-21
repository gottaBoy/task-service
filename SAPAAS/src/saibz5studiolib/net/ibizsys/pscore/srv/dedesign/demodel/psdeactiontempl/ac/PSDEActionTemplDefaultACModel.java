/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeactiontempl.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="6d2e180f1b20f1288ee0f012ab213e4b", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEACTIONTEMPLID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEACTIONTEMPLNAME", format="")})})
public class PSDEActionTemplDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEActionTemplDefaultACModel() {
        this.initAnnotation(PSDEActionTemplDefaultACModel.class);
    }
}

