/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdedrgroup.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="5dd1c4fbae2929da7b0403202b222b02", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEDRGROUPID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEDRGROUPNAME", format="")})})
public class PSDEDRGroupDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEDRGroupDefaultACModel() {
        this.initAnnotation(PSDEDRGroupDefaultACModel.class);
    }
}

