/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.pswsbookinglog.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="aeac1f755bb20de6c8d4898cfd3ae318", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSWSBOOKINGLOGID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSWSBOOKINGLOGNAME", format="")})})
public class PSWSBookingLogDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSWSBookingLogDefaultACModel() {
        this.initAnnotation(PSWSBookingLogDefaultACModel.class);
    }
}

