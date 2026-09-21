/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dynasys.demodel.psdynacodelist.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="73a8f7ea421610f8f13c50b776527b17", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDYNACODELISTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDYNACODELISTNAME", format="")})})
public class PSDynaCodeListDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDynaCodeListDefaultACModel() {
        this.initAnnotation(PSDynaCodeListDefaultACModel.class);
    }
}

