/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeprint.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="4b95902c0577ca2f11507881d511e211", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEPRINTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEPRINTNAME", format="")})})
public class PSDEPrintDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEPrintDefaultACModel() {
        this.initAnnotation(PSDEPrintDefaultACModel.class);
    }
}

