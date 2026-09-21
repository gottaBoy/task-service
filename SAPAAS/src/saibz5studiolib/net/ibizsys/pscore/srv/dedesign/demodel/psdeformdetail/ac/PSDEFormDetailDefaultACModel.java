/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeformdetail.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="b8e3b42cac55cdfb2dc0a059d518d0b8", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEFORMDETAILID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEFORMDETAILNAME", format="")})})
public class PSDEFormDetailDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEFormDetailDefaultACModel() {
        this.initAnnotation(PSDEFormDetailDefaultACModel.class);
    }
}

