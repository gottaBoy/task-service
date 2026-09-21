/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.unisys.demodel.psusdcmoduleinstfunc.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="7a2b217dfcfc9550bfc5a1b7391d8288", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSUSDCMODULEINSTFUNCID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSUSDCMODULEINSTFUNCNAME", format="")})})
public class PSUSDCModuleInstFuncDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSUSDCModuleInstFuncDefaultACModel() {
        this.initAnnotation(PSUSDCModuleInstFuncDefaultACModel.class);
    }
}

