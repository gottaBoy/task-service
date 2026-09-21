/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeawgroup.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="fd7f8efbe95d76957e970aad39c29259", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEAWGROUPID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEAWGROUPNAME", format="")})})
public class PSDEAWGroupDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEAWGroupDefaultACModel() {
        this.initAnnotation(PSDEAWGroupDefaultACModel.class);
    }
}

