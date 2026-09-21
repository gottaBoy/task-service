/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdevserverlease.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="a3cc29fd34567b13520123adaf48e800", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEVSERVERLEASEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEVSERVERLEASENAME", format="")})})
public class PSDevServerLeaseDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDevServerLeaseDefaultACModel() {
        this.initAnnotation(PSDevServerLeaseDefaultACModel.class);
    }
}

