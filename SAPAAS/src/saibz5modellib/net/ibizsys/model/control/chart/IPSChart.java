/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.chart.IChart
 */
package net.ibizsys.model.control.chart;

import java.util.Iterator;
import net.ibizsys.model.control.IPSAjaxControl;
import net.ibizsys.model.control.chart.IPSChartAxes;
import net.ibizsys.model.control.chart.IPSChartDataItem;
import net.ibizsys.model.control.chart.IPSChartGrid;
import net.ibizsys.model.control.chart.IPSChartLegend;
import net.ibizsys.model.control.chart.IPSChartPolar;
import net.ibizsys.model.control.chart.IPSChartSeries;
import net.ibizsys.model.control.chart.IPSChartTitle;
import net.ibizsys.model.control.chart.IPSChartVisualMap;
import net.ibizsys.paas.control.chart.IChart;

public interface IPSChart
extends IPSAjaxControl,
IChart {
    public static final String COORDINATESYSTEM_XY = "XY";
    public static final String COORDINATESYSTEM_POLAR = "POLAR";
    public static final String COORDINATESYSTEM_RADAR = "RADAR";
    public static final String COORDINATESYSTEM_PARALLEL = "PARALLEL";
    public static final String COORDINATESYSTEM_SINGLE = "SINGLE";
    public static final String COORDINATESYSTEM_CALENDAR = "CALENDAR";
    public static final String COORDINATESYSTEM_MAP = "MAP";
    public static final String COORDINATESYSTEM_NONE = "NONE";

    public String getChartTheme();

    public IPSChartTitle getPSChartTitle();

    public IPSChartLegend getPSChartLegend();

    public Iterator<IPSChartAxes> getPSChartAxeses();

    public Iterator<IPSChartSeries> getPSChartSerieses();

    public Iterator<IPSChartDataItem> getPSChartDataItems();

    public Iterator<IPSChartVisualMap> getPSChartVisualMaps();

    public Iterator<IPSChartGrid> getPSChartGrids();

    public Iterator<IPSChartPolar> getPSChartPolars();

    public String getEmptyText();

    public String getCoordinateSystem();
}

