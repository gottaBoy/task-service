/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dynasys.demodel.psdynadeform.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="48f41c0c07e3c6ef8d88be2e5d3bd708", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDYNADEFORMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDYNADEFORMNAME", format="")})})
public class PSDynaDEFormDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDynaDEFormDefaultACModel() {
        this.initAnnotation(PSDynaDEFormDefaultACModel.class);
    }
}

