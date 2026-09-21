/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.psregistryitem.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="5d3237a31de363b2bbc1fa060d9bebaf", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSREGISTRYITEMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSREGISTRYITEMNAME", format="")})})
public class PSRegistryItemDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSRegistryItemDefaultACModel() {
        this.initAnnotation(PSRegistryItemDefaultACModel.class);
    }
}

