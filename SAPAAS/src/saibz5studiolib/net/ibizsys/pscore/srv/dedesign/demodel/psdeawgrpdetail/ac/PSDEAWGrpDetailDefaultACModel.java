/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeawgrpdetail.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="e571913087501e200f08941aa4c47609", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEAWGRPDETAILID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEAWGRPDETAILNAME", format="")})})
public class PSDEAWGrpDetailDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEAWGrpDetailDefaultACModel() {
        this.initAnnotation(PSDEAWGrpDetailDefaultACModel.class);
    }
}

