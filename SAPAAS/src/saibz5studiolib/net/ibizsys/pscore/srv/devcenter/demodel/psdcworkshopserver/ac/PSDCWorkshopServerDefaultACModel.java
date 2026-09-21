/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcworkshopserver.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="64d3837898dc8cc13e7ad677419744ed", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCWORKSHOPSERVERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCWORKSHOPSERVERNAME", format="")})})
public class PSDCWorkshopServerDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCWorkshopServerDefaultACModel() {
        this.initAnnotation(PSDCWorkshopServerDefaultACModel.class);
    }
}

