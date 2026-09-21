/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.chart;

import net.ibizsys.model.control.chart.IPSChartSeries;
import net.ibizsys.model.control.chart.IPSDEChart;
import net.ibizsys.model.control.chart.IPSDEChartAxes;

public interface IPSDEChartSeries
extends IPSChartSeries {
    public IPSDEChart getPSDEChart();

    public IPSDEChartAxes getXPSDEChartAxes();

    public IPSDEChartAxes getYPSDEChartAxes();
}

