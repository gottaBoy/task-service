/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.psworkshopserver.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="eaa194bb15a72e744442fca324234b90", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSWORKSHOPSERVERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSWORKSHOPSERVERNAME", format="")})})
public class PSWorkshopServerDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSWorkshopServerDefaultACModel() {
        this.initAnnotation(PSWorkshopServerDefaultACModel.class);
    }
}

