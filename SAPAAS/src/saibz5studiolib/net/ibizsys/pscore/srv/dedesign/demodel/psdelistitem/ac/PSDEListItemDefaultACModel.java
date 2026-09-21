/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdelistitem.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="6bd0fb04c84d7b9a0cd3618c6101fd05", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDELISTITEMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDELISTITEMNAME", format="")})})
public class PSDEListItemDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEListItemDefaultACModel() {
        this.initAnnotation(PSDEListItemDefaultACModel.class);
    }
}

