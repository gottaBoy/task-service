/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeserviceapi.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="146993e9da43058b23bca788aaf1a6e9", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDESERVICEAPIID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDESERVICEAPINAME", format="")})})
public class PSDEServiceAPIDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEServiceAPIDefaultACModel() {
        this.initAnnotation(PSDEServiceAPIDefaultACModel.class);
    }
}

