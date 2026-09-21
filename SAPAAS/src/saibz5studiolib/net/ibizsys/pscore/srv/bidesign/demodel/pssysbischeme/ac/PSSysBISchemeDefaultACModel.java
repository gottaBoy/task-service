/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.bidesign.demodel.pssysbischeme.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="c4e165d812d56be515743f0da2af1a65", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSBISCHEMEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSBISCHEMENAME", format="")})})
public class PSSysBISchemeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysBISchemeDefaultACModel() {
        this.initAnnotation(PSSysBISchemeDefaultACModel.class);
    }
}

