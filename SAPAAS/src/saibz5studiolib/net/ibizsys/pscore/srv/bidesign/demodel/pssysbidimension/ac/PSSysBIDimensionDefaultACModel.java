/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.bidesign.demodel.pssysbidimension.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="ef31acc777247b6a8fed78b3dc72165b", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSBIDIMENSIONID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSBIDIMENSIONNAME", format="")})})
public class PSSysBIDimensionDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysBIDimensionDefaultACModel() {
        this.initAnnotation(PSSysBIDimensionDefaultACModel.class);
    }
}

