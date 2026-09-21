/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.psdsbooking.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="80b5cdc58dc7470ac4cf8d44ee1c5a05", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDSBOOKINGID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDSBOOKINGNAME", format="")})})
public class PSDSBookingDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDSBookingDefaultACModel() {
        this.initAnnotation(PSDSBookingDefaultACModel.class);
    }
}

