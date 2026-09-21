/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.bdscheme.demodel.pssysbdtablede.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="a4ee4d26d40c1cc142a464a6a3a1edee", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSBDTABLEDEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSBDTABLEDENAME", format="")})})
public class PSSysBDTableDEDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysBDTableDEDefaultACModel() {
        this.initAnnotation(PSSysBDTableDEDefaultACModel.class);
    }
}

