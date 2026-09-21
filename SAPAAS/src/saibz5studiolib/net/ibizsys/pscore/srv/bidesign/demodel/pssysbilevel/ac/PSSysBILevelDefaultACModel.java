/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.bidesign.demodel.pssysbilevel.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="7bf72556db075e2bd49a06e10de31319", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSBILEVELID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSBILEVELNAME", format="")})})
public class PSSysBILevelDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysBILevelDefaultACModel() {
        this.initAnnotation(PSSysBILevelDefaultACModel.class);
        this.setMinorSortField("ORDERVALUE");
        this.setMinorSortDir("ASC");
    }
}

