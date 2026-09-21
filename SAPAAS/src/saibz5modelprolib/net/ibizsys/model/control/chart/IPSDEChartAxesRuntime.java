/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.chart.IPSDEChart
 *  net.ibizsys.model.control.chart.IPSDEChartAxes
 */
package net.ibizsys.model.control.chart;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.control.chart.IPSDEChart;
import net.ibizsys.model.control.chart.IPSDEChartAxes;
import net.ibizsys.model.entity.PSDEChartAxes;

public interface IPSDEChartAxesRuntime
extends IPSDEChartAxes {
    public void init(IPSModelStorageContext var1, IPSDEChart var2, PSDEChartAxes var3) throws Exception;
}

