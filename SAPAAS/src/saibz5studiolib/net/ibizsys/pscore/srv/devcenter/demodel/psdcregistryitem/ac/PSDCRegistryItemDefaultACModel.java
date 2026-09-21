/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="403a0496a3355c1e591b12285bc3da0f", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCREGISTRYITEMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCREGISTRYITEMNAME", format="")})})
public class PSDCRegistryItemDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCRegistryItemDefaultACModel() {
        this.initAnnotation(PSDCRegistryItemDefaultACModel.class);
    }
}

