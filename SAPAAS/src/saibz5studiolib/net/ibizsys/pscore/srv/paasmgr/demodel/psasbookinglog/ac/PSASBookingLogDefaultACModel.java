/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.psasbookinglog.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="0b7c119bd5ac2332380d23d98037b28b", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSASBOOKINGLOGID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSASBOOKINGLOGNAME", format="")})})
public class PSASBookingLogDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSASBookingLogDefaultACModel() {
        this.initAnnotation(PSASBookingLogDefaultACModel.class);
    }
}

