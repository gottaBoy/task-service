/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.unisys.demodel.psusdcapppolicy.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="4cb9b8b6c38d5b0e00ae3fb2fe852261", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSUSDCAPPPOLICYID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSUSDCAPPPOLICYNAME", format="")})})
public class PSUSDCAppPolicyDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSUSDCAppPolicyDefaultACModel() {
        this.initAnnotation(PSUSDCAppPolicyDefaultACModel.class);
    }
}

