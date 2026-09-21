/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcsyncdata.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="fb4fd65b1a8e3922f411cad369026422", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCSYNCDATAID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCSYNCDATANAME", format="")})})
public class PSDCSyncDataDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCSyncDataDefaultACModel() {
        this.initAnnotation(PSDCSyncDataDefaultACModel.class);
    }
}

