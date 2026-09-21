/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Chart.IPSChart;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartAxes;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartCoordinateSystem;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartDataSet;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeriesEncode;
import SA.SRFDA.PS.Core.Control.IPSControlItemNavigatable;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;

@PSModelInterfaceMeta(title="\u56fe\u8868\u6570\u636e\u5e8f\u5217\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3", extend="IPSDEChartSeries", model="PSDEChartSeries")
public interface IPSChartSeries
extends IPSModelObject,
IPSControlItemNavigatable {
    public static final String SERIESTYPE_AREA = "area";
    public static final String SERIESTYPE_BAR = "bar";
    public static final String SERIESTYPE_BAR3D = "bar3d";
    public static final String SERIESTYPE_CANDLESTICK = "candlestick";
    public static final String SERIESTYPE_GAUGE = "gauge";
    public static final String SERIESTYPE_LINE = "line";
    public static final String SERIESTYPE_PIE = "pie";
    public static final String SERIESTYPE_PIE3D = "pie3d";
    public static final String SERIESTYPE_RADAR = "radar";
    public static final String SERIESTYPE_SCATTER = "scatter";
    public static final String SERIESTYPE_COLUMN = "column";
    public static final String SERIESTYPE_FUNNEL = "funnel";
    public static final String SERIESTYPE_MAP = "map";
    public static final String SERIESTYPE_CUSTOM = "custom";
    public static final String ECHARTSTYPE_BAR = "bar";
    public static final String ECHARTSTYPE_CANDLESTICK = "candlestick";
    public static final String ECHARTSTYPE_GAUGE = "gauge";
    public static final String ECHARTSTYPE_LINE = "line";
    public static final String ECHARTSTYPE_PIE = "pie";
    public static final String ECHARTSTYPE_RADAR = "radar";
    public static final String ECHARTSTYPE_SCATTER = "scatter";
    public static final String ECHARTSTYPE_FUNNEL = "funnel";
    public static final String ECHARTSTYPE_MAP = "map";
    public static final String ECHARTSTYPE_CUSTOM = "custom";
    public static final String SERIESLAYOUTBY_COLUMN = "column";
    public static final String SERIESLAYOUTBY_ROW = "row";
    public static final String GROUPMODE_CODELIST = "CODELIST";

    public String getCaption();

    public IPSLanguageRes getCapPSLanguageRes();

    public String getCapLanResTag();

    public String getSeriesType();

    public IPSChart getPSChart();

    public String getSeriesField();

    public String getCatalogField();

    public String getValueField();

    public String getIdField();

    public String getValue2Field();

    public String getValue3Field();

    public String getValue4Field();

    public String getValue5Field();

    public String getValue6Field();

    public String getExtValueField();

    public String getExtValue2Field();

    public String getExtValue3Field();

    public String getExtValue4Field();

    public IPSChartAxes getXPSChartAxes();

    public IPSChartAxes getYPSChartAxes();

    public String getTimeGroupMode();

    public IPSCodeList getSeriesPSCodeList();

    public IPSCodeList getCatalogPSCodeList();

    public String getEChartsType();

    public IPSChartCoordinateSystem getPSChartCoordinateSystem();

    public IPSSysPFPlugin getPSSysPFPlugin();

    public boolean isEnableChartDataSet();

    public IPSChartDataSet getPSChartDataSet();

    public IPSPFXCodeObject getRender();

    public String getSeriesLayoutBy();

    public IPSChartSeriesEncode getPSChartSeriesEncode();

    public String getGroupMode();

    public String getBaseOptionJOString();

    public String getDataField();

    public String getTagField();
}

