/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.chart;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.model.control.chart.IPSChart;
import net.ibizsys.model.control.chart.IPSChartGrid;
import net.ibizsys.model.control.chart.IPSDEChartAxes;
import net.ibizsys.model.control.chart.IPSDEChartLegend;
import net.ibizsys.model.control.chart.IPSDEChartSeries;
import net.ibizsys.model.control.chart.IPSDEChartTitle;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.logic.IPSDELogic;

public interface IPSDEChart
extends IPSChart {
    public IPSDEChartTitle getPSDEChartTitle();

    public IPSDEChartLegend getPSDEChartLegend();

    public IPSDEDataSet getPSDEDataSet();

    public IPSDELogic getActiveDataPSDELogic();

    @Override
    public Iterator<IPSChartGrid> getPSChartGrids();

    public Iterator<IPSDEChartAxes> getPSDEChartAxeses();

    public Iterator<IPSDEChartSeries> getPSDEChartSerieses();

    public ArrayList<IPSDEChartAxes> getPSDEChartAxesesByPos(String var1);

    public IPSDEChartAxes getPSDEChartAxes(String var1) throws Exception;
}

