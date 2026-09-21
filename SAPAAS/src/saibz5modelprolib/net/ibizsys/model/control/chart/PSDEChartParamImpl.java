/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControlParam
 *  net.ibizsys.model.control.chart.IPSDEChartParam
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.control.chart;

import net.ibizsys.model.control.IPSControlParam;
import net.ibizsys.model.control.PSMDAjaxControlParamImpl;
import net.ibizsys.model.control.chart.IPSDEChartParam;
import net.ibizsys.paas.util.StringHelper;

public class PSDEChartParamImpl
extends PSMDAjaxControlParamImpl
implements IPSDEChartParam {
    private String strPSDEChartId = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.setPSDEChartId(this.psDEViewCtrl.getPSDECHARTID());
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        IPSDEChartParam iPSDEChartParam;
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSDEChartParam && !StringHelper.isNullOrEmpty((String)(iPSDEChartParam = (IPSDEChartParam)iPSControlParam).getPSDEChartId())) {
            this.setPSDEChartId(iPSDEChartParam.getPSDEChartId());
        }
    }

    public String getPSDEChartId() {
        return this.strPSDEChartId;
    }

    public void setPSDEChartId(String strPSDEChartId) {
        this.strPSDEChartId = strPSDEChartId;
    }
}

