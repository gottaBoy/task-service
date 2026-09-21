/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.chart.IPSChart
 *  net.ibizsys.model.control.chart.IPSDEChart
 *  net.ibizsys.model.control.chart.IPSDEChartObject
 */
package net.ibizsys.model.control.chart;

import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.control.chart.IPSChart;
import net.ibizsys.model.control.chart.IPSDEChart;
import net.ibizsys.model.control.chart.IPSDEChartObject;

public abstract class PSDEChartObjectImpl
extends PSObjectImpl
implements IPSDEChartObject {
    private IPSDEChart iPSDEChart = null;

    public IPSChart getPSChart() {
        return this.getPSDEChart();
    }

    public IPSDEChart getPSDEChart() {
        return this.iPSDEChart;
    }

    @Override
    public String getPSSysModelInstId() {
        return ((IPSModelObjectRuntime)this.getPSDEChart().getPSDataEntity()).getPSSysModelInstId();
    }

    protected void setPSDEChart(IPSDEChart iPSDEChart) {
        this.iPSDEChart = iPSDEChart;
    }
}

