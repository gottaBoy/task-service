/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.bdscheme.demodel.pssysbdtable.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="24b2bf55c5aa6853ff623f5b218eff84", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSBDTABLEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSBDTABLENAME", format="")})})
public class PSSysBDTableDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysBDTableDefaultACModel() {
        this.initAnnotation(PSSysBDTableDefaultACModel.class);
    }
}

