/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdedqcode.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="9f7cdcccafbef63d8a8a19959249edf6", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEDQCODEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEDQCODENAME", format="")})})
public class PSDEDQCodeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEDQCodeDefaultACModel() {
        this.initAnnotation(PSDEDQCodeDefaultACModel.class);
    }
}

