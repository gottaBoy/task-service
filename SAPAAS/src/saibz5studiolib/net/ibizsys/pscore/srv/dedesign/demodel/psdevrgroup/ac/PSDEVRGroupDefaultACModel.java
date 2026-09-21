/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdevrgroup.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="5faea0e791413a5f7b13a2bbfbd5f452", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEVRGROUPID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEVRGROUPNAME", format="")})})
public class PSDEVRGroupDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEVRGroupDefaultACModel() {
        this.initAnnotation(PSDEVRGroupDefaultACModel.class);
    }
}

