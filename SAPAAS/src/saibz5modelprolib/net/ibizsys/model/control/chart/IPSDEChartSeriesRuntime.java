/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.chart.IPSDEChart
 *  net.ibizsys.model.control.chart.IPSDEChartSeries
 */
package net.ibizsys.model.control.chart;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.control.chart.IPSDEChart;
import net.ibizsys.model.control.chart.IPSDEChartSeries;
import net.ibizsys.model.entity.PSDEChartSeries;

public interface IPSDEChartSeriesRuntime
extends IPSDEChartSeries {
    public void init(IPSModelStorageContext var1, IPSDEChart var2, PSDEChartSeries var3) throws Exception;
}

