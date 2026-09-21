/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.bidesign.demodel.pssysbiaggcolumn.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="3ab329ec3a0d71b854e52eac14e8e33d", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSBIAGGCOLUMNID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSBIAGGCOLUMNNAME", format="")})})
public class PSSysBIAggColumnDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysBIAggColumnDefaultACModel() {
        this.initAnnotation(PSSysBIAggColumnDefaultACModel.class);
    }
}

