/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.pssvrprovider.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="512b83f905f2ade72cd563224baef481", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSVRPROVIDERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSVRPROVIDERNAME", format="")})})
public class PSSvrProviderDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSvrProviderDefaultACModel() {
        this.initAnnotation(PSSvrProviderDefaultACModel.class);
    }
}

