/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdechartaxes.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="3d72284bb25534026ee7a62f173be187", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDECHARTAXESID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDECHARTAXESNAME", format="")})})
public class PSDEChartAxesDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEChartAxesDefaultACModel() {
        this.initAnnotation(PSDEChartAxesDefaultACModel.class);
    }
}

