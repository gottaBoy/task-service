/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.unisys.demodel.psusdcmodule.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="33f17ebb2f45c31a72e67657a1ee66e8", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSUSDCMODULEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSUSDCMODULENAME", format="")})})
public class PSUSDCModuleDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSUSDCModuleDefaultACModel() {
        this.initAnnotation(PSUSDCModuleDefaultACModel.class);
    }
}

