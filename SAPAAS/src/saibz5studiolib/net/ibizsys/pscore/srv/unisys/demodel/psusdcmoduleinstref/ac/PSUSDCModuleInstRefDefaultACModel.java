/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.unisys.demodel.psusdcmoduleinstref.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="5b7db84191e03223a277aeb414cd1b2b", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSUSDCMODULEINSTREFID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSUSDCMODULEINSTREFNAME", format="")})})
public class PSUSDCModuleInstRefDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSUSDCModuleInstRefDefaultACModel() {
        this.initAnnotation(PSUSDCModuleInstRefDefaultACModel.class);
    }
}

