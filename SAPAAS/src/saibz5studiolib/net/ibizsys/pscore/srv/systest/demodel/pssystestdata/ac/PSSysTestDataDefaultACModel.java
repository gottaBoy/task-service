/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.systest.demodel.pssystestdata.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="9bd2e8d8e9a6df759cd2f488c2a4c90c", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSTESTDATAID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSTESTDATANAME", format="")})})
public class PSSysTestDataDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysTestDataDefaultACModel() {
        this.initAnnotation(PSSysTestDataDefaultACModel.class);
    }
}

