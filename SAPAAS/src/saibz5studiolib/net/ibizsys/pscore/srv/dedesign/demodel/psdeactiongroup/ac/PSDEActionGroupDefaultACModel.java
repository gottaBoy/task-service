/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeactiongroup.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="90f0ce2d4ddc488c40068af13e211a7a", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEACTIONGROUPID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEACTIONGROUPNAME", format="")})})
public class PSDEActionGroupDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEActionGroupDefaultACModel() {
        this.initAnnotation(PSDEActionGroupDefaultACModel.class);
    }
}

