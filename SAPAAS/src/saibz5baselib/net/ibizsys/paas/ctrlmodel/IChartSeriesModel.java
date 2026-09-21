/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.core.IModelBase;

public interface IChartSeriesModel
extends IModelBase {
    public static final String SERIESTYPE_AREA = "area";
    public static final String SERIESTYPE_BAR = "bar";
    public static final String SERIESTYPE_BAR3D = "bar3d";
    public static final String SERIESTYPE_COLUMN = "column";
    public static final String SERIESTYPE_CANDLESTICK = "candlestick";
    public static final String SERIESTYPE_GAUGE = "gauge";
    public static final String SERIESTYPE_LINE = "line";
    public static final String SERIESTYPE_PIE = "pie";
    public static final String SERIESTYPE_PIE3D = "pie3d";
    public static final String SERIESTYPE_RADAR = "radar";
    public static final String SERIESTYPE_SCATTER = "scatter";
    public static final String TIMEGROUP_YEAR = "YEAR";
    public static final String TIMEGROUP_QUARTER = "QUARTER";
    public static final String TIMEGROUP_MONTH = "MONTH";
    public static final String TIMEGROUP_YEARWEEK = "YEARWEEK";
    public static final String TIMEGROUP_DAY = "DAY";

    public String getCaption();

    public String getSeriesType();

    public String getCatalogField();

    public String getCatalogFieldCodeListId();

    public String getValueField();

    public String getValue2Field();

    public String getValue3Field();

    public String getValue4Field();

    public String getSeriesField();

    public String getSeriesFieldCodeListId();

    public String getTimeGroupMode();
}

