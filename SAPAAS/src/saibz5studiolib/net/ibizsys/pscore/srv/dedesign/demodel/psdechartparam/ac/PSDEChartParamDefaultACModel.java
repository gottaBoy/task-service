/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdechartparam.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="277fb9e091797f156695eb62b1154e31", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDECHARTPARAMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDECHARTPARAMNAME", format="")})})
public class PSDEChartParamDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEChartParamDefaultACModel() {
        this.initAnnotation(PSDEChartParamDefaultACModel.class);
    }
}

