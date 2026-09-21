/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeawitem.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="0a18a734c634ca4d9fad65ef4a13995d", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEAWITEMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEAWITEMNAME", format="")})})
public class PSDEAWItemDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEAWItemDefaultACModel() {
        this.initAnnotation(PSDEAWItemDefaultACModel.class);
    }
}

