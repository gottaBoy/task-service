/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.psasbooking.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="8639eec6b989087e9d47f549cbf48c68", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSASBOOKINGID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSASBOOKINGNAME", format="")})})
public class PSASBookingDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSASBookingDefaultACModel() {
        this.initAnnotation(PSASBookingDefaultACModel.class);
    }
}

