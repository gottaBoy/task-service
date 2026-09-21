/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdedscode.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="4b5a12b9de34719042ca40a326b153bd", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEDSCODEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEDSCODENAME", format="")})})
public class PSDEDSCodeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEDSCodeDefaultACModel() {
        this.initAnnotation(PSDEDSCodeDefaultACModel.class);
    }
}

