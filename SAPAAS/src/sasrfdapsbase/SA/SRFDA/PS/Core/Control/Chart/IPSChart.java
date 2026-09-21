/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.chart.IChart
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartAngleAxis;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartAxes;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartCoordinateSystem;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartDataGrid;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartDataItem;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartDataSet;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartDataSetGroup;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartGrid;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartLegend;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartParallel;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartParallelAxis;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartPolar;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartRadar;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartRadiusAxis;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeries;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSingle;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSingleAxis;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartTitle;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartVisualMap;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartXAxis;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartYAxis;
import SA.SRFDA.PS.Core.Control.IPSControlNavigatable;
import SA.SRFDA.PS.Core.Control.IPSMDAjaxControl;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import java.util.Iterator;
import net.ibizsys.paas.control.chart.IChart;

@PSModelInterfaceMeta(title="\u56fe\u8868\u90e8\u4ef6\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3")
public interface IPSChart
extends IPSMDAjaxControl,
IPSControlNavigatable,
IChart {
    public static final String COORDINATESYSTEM_XY = "XY";
    public static final String COORDINATESYSTEM_POLAR = "POLAR";
    public static final String COORDINATESYSTEM_RADAR = "RADAR";
    public static final String COORDINATESYSTEM_PARALLEL = "PARALLEL";
    public static final String COORDINATESYSTEM_SINGLE = "SINGLE";
    public static final String COORDINATESYSTEM_CALENDAR = "CALENDAR";
    public static final String COORDINATESYSTEM_MAP = "MAP";
    public static final String COORDINATESYSTEM_NONE = "NONE";
    public static final String ECHARTSTYPE_CARTESIAN2D = "cartesian2d";
    public static final String ECHARTSTYPE_GEO = "geo";
    public static final String ECHARTSTYPE_CALENDAR = "calendar";

    public String getChartTheme();

    public IPSChartTitle getPSChartTitle();

    public IPSChartLegend getPSChartLegend();

    public IPSChartDataGrid getPSChartDataGrid();

    public Iterator<? extends IPSChartAxes> getPSChartAxeses();

    public Iterator<? extends IPSChartSeries> getPSChartSerieses();

    public IPSLanguageRes getEmptyTextPSLanguageRes();

    public String getEmptyText();

    public String getCoordinateSystem();

    public Iterator<? extends IPSChartDataSet> getPSChartDataSets();

    public Iterator<? extends IPSChartXAxis> getPSChartXAxises();

    public Iterator<? extends IPSChartYAxis> getPSChartYAxises();

    public Iterator<? extends IPSChartGrid> getPSChartGrids();

    public Iterator<? extends IPSChartRadar> getPSChartRadars();

    public Iterator<? extends IPSChartAngleAxis> getPSChartAngleAxises();

    public Iterator<? extends IPSChartRadiusAxis> getPSChartRadiusAxises();

    public Iterator<? extends IPSChartParallelAxis> getPSChartParallelAxises();

    public Iterator<? extends IPSChartSingleAxis> getPSChartSingleAxises();

    public Iterator<? extends IPSChartParallel> getPSChartParallels();

    public Iterator<? extends IPSChartSingle> getPSChartSingles();

    public Iterator<? extends IPSChartDataItem> getPSChartDataItems();

    public Iterator<? extends IPSChartVisualMap> getPSChartVisualMaps();

    public Iterator<? extends IPSChartPolar> getPSChartPolars();

    public Iterator<? extends IPSChartCoordinateSystem> getPSChartCoordinateSystems();

    public Iterator<? extends IPSChartDataSetGroup> getPSChartDataSetGroups();
}

