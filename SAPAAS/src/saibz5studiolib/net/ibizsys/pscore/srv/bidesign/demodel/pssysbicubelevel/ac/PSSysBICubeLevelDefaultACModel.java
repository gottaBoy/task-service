/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.bidesign.demodel.pssysbicubelevel.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="7e76a259a16ec827168d713a387bf192", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSBICUBELEVELID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSBICUBELEVELNAME", format="")})})
public class PSSysBICubeLevelDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysBICubeLevelDefaultACModel() {
        this.initAnnotation(PSSysBICubeLevelDefaultACModel.class);
    }
}

