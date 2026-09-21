/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.bdscheme.demodel.pssysbdmodule.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="7f3eeb95963d0e11abe51993d5f2e5f9", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSBDMODULEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSBDMODULENAME", format="")})})
public class PSSysBDModuleDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysBDModuleDefaultACModel() {
        this.initAnnotation(PSSysBDModuleDefaultACModel.class);
    }
}

