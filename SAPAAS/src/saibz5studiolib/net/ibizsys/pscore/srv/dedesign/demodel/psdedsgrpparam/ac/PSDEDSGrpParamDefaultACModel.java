/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdedsgrpparam.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="daf9d930ca6e3b9822541aa318b1e5ba", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEDSGRPPARAMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEDSGRPPARAMNAME", format="")})})
public class PSDEDSGrpParamDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEDSGrpParamDefaultACModel() {
        this.initAnnotation(PSDEDSGrpParamDefaultACModel.class);
    }
}

