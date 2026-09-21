/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.chart;

import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.control.chart.IPSChart;
import net.ibizsys.model.control.chart.IPSChartAxes;
import net.ibizsys.model.core.IPSModelObject;

public interface IPSChartSeries
extends IPSModelObject {
    public String getCaption();

    public String getCapLanResTag();

    public String getSeriesType();

    public IPSChart getPSChart();

    public String getSeriesField();

    public String getCatalogField();

    public String getValueField();

    public String getValue2Field();

    public String getValue3Field();

    public String getValue4Field();

    public String getValue5Field();

    public String getValue6Field();

    public IPSChartAxes getXPSChartAxes();

    public IPSChartAxes getYPSChartAxes();

    public String getTimeGroupMode();

    public IPSCodeList getSeriesPSCodeList();

    public IPSCodeList getCatalogPSCodeList();
}

