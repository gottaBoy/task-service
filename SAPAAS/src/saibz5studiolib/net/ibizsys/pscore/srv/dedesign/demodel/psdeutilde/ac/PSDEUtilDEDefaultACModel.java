/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeutilde.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="5156581a7f0fbabae6686e1a3a09bea6", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEUTILDEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEUTILDENAME", format="")})})
public class PSDEUtilDEDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEUtilDEDefaultACModel() {
        this.initAnnotation(PSDEUtilDEDefaultACModel.class);
    }
}

