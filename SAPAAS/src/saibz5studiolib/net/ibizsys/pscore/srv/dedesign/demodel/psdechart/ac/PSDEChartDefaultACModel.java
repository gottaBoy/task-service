/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdechart.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="8b7478d1c070a5cfb14d51e4f7f8a205", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDECHARTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDECHARTNAME", format="")})})
public class PSDEChartDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEChartDefaultACModel() {
        this.initAnnotation(PSDEChartDefaultACModel.class);
    }
}

