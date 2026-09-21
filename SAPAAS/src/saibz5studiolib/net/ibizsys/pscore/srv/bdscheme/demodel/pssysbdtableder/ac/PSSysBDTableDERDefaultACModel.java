/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.bdscheme.demodel.pssysbdtableder.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="01f69c2c36276937f4c621bb4503b17f", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSBDTABLEDERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSBDTABLEDERNAME", format="")})})
public class PSSysBDTableDERDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysBDTableDERDefaultACModel() {
        this.initAnnotation(PSSysBDTableDERDefaultACModel.class);
    }
}

