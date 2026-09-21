/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dynasys.demodel.psdynawfver.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="5fb18207e4a59e26053e637df824234a", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDYNAWFVERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDYNAWFVERNAME", format="")})})
public class PSDynaWFVerDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDynaWFVerDefaultACModel() {
        this.initAnnotation(PSDynaWFVerDefaultACModel.class);
    }
}

