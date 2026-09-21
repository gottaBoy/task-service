/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdedritem.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="3927d3a895b62b6ca04a31136f6f093f", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEDRITEMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEDRITEMNAME", format="")})})
public class PSDEDRItemDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEDRItemDefaultACModel() {
        this.initAnnotation(PSDEDRItemDefaultACModel.class);
    }
}

