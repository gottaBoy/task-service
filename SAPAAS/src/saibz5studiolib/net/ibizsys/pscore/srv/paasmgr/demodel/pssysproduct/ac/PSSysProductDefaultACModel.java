/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.pssysproduct.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="8fcce2e0ed0072c98326bd0e24323710", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSPRODUCTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSPRODUCTNAME", format="")})})
public class PSSysProductDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysProductDefaultACModel() {
        this.initAnnotation(PSSysProductDefaultACModel.class);
    }
}

