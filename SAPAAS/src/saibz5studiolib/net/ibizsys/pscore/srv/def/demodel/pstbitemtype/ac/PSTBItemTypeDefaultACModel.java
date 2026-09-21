/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.def.demodel.pstbitemtype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="e8c143a94bb5dea925ce380237713d1c", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSTBITEMTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSTBITEMTYPENAME", format="")})})
public class PSTBItemTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSTBItemTypeDefaultACModel() {
        this.initAnnotation(PSTBItemTypeDefaultACModel.class);
    }
}

