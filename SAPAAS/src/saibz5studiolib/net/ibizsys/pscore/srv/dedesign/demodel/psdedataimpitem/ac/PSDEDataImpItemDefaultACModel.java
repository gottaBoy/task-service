/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdedataimpitem.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="aff931b6fe11dbbbd14bdf1e850a1138", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEDATAIMPITEMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEDATAIMPITEMNAME", format="")})})
public class PSDEDataImpItemDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEDataImpItemDefaultACModel() {
        this.initAnnotation(PSDEDataImpItemDefaultACModel.class);
    }
}

