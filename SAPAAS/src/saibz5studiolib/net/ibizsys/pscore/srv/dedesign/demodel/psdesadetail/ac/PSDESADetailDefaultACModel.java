/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdesadetail.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="142e39c111de4ea574fb05cfffb9c277", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDESADETAILID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDESADETAILNAME", format="")})})
public class PSDESADetailDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDESADetailDefaultACModel() {
        this.initAnnotation(PSDESADetailDefaultACModel.class);
    }
}

