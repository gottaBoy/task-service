/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.chart.IPSChart
 *  net.ibizsys.model.control.dashboard.IPSDBChartPortlet
 */
package net.ibizsys.model.control.dashboard;

import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.chart.IPSChart;
import net.ibizsys.model.control.chart.PSDEChartParamImpl;
import net.ibizsys.model.control.dashboard.IPSDBChartPortlet;
import net.ibizsys.model.control.dashboard.PSDBSysPortletPartImpl;
import net.ibizsys.model.res.IPSSysDEChartPortlet;

public class PSDBChartPortletPartImpl
extends PSDBSysPortletPartImpl
implements IPSDBChartPortlet {
    public static final String CHARTNAME = "_chart";
    private IPSChart iPSChart = null;

    @Override
    protected void onInit() throws Exception {
        IPSSysDEChartPortlet iPSSysDEChartPortlet = (IPSSysDEChartPortlet)this.iPSSysPortlet;
        PSDEChartParamImpl psDEChartParamImpl = new PSDEChartParamImpl();
        psDEChartParamImpl.setPSDEChartId(iPSSysDEChartPortlet.getPSDEChartId());
        psDEChartParamImpl.setPSDEDataSetId(iPSSysDEChartPortlet.getPSDEDataSetId());
        psDEChartParamImpl.setActiveDataPSDELogicId(iPSSysDEChartPortlet.getActiveDataPSDELogicId());
        if (iPSSysDEChartPortlet.getHeight() > 0) {
            psDEChartParamImpl.setHeight(Double.valueOf(iPSSysDEChartPortlet.getHeight()));
        }
        this.iPSChart = (IPSChart)this.registerPSControl(String.valueOf(this.getName()) + CHARTNAME, "CHART", psDEChartParamImpl);
        super.onInit();
    }

    public IPSChart getPSChart() {
        return this.iPSChart;
    }

    @Override
    public IPSControl getContentPSControl() {
        return this.getPSChart();
    }
}

