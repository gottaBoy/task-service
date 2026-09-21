/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.bidesign.demodel.pssysbiaggtable.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="c974500a9849dbd407077e7fcf77ae11", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSBIAGGTABLEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSBIAGGTABLENAME", format="")})})
public class PSSysBIAggTableDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysBIAggTableDefaultACModel() {
        this.initAnnotation(PSSysBIAggTableDefaultACModel.class);
    }
}

