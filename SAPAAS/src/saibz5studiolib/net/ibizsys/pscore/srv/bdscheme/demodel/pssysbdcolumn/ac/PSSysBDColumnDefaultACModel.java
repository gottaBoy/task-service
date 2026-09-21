/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.bdscheme.demodel.pssysbdcolumn.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="c47c3efac9994743adb88d059a04a37b", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSBDCOLUMNID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSBDCOLUMNNAME", format="")})})
public class PSSysBDColumnDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysBDColumnDefaultACModel() {
        this.initAnnotation(PSSysBDColumnDefaultACModel.class);
    }
}

