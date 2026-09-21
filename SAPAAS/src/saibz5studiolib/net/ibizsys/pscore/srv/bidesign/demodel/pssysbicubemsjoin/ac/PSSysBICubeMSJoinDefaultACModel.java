/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.bidesign.demodel.pssysbicubemsjoin.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="4a9e360311eb391ace98daa921085662", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSBICUBEMSJOINID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSBICUBEMSJOINNAME", format="")})})
public class PSSysBICubeMSJoinDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysBICubeMSJoinDefaultACModel() {
        this.initAnnotation(PSSysBICubeMSJoinDefaultACModel.class);
    }
}

