/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdechartlogic.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="2e1df01951c758756d36d6afcd4f8863", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDECHARTLOGICID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDECHARTLOGICNAME", format="")})})
public class PSDEChartLogicDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEChartLogicDefaultACModel() {
        this.initAnnotation(PSDEChartLogicDefaultACModel.class);
    }
}

