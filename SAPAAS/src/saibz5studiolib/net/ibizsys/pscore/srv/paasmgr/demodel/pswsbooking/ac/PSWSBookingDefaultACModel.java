/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.pswsbooking.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="90be38420926a8ac233a671bd94b701a", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSWSBOOKINGID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSWSBOOKINGNAME", format="")})})
public class PSWSBookingDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSWSBookingDefaultACModel() {
        this.initAnnotation(PSWSBookingDefaultACModel.class);
    }
}

