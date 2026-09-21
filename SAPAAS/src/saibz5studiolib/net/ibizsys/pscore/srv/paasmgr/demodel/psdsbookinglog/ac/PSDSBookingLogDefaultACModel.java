/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.psdsbookinglog.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="6eb6bf1d84287bb4579a70ce4713f0a9", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDSBOOKINGLOGID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDSBOOKINGLOGNAME", format="")})})
public class PSDSBookingLogDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDSBookingLogDefaultACModel() {
        this.initAnnotation(PSDSBookingLogDefaultACModel.class);
    }
}

