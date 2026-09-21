/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartAngleAxis;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartCoordinateSystem;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartDataItem;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartDataSet;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartDataSetGroup;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartGrid;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartParallel;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartParallelAxis;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartPolar;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartRadar;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartRadiusAxis;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSingle;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSingleAxis;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartVisualMap;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartXAxis;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartYAxis;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import java.util.Iterator;

@PSModelInterfaceMeta(title="ECharts\u56fe\u8868\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSECharts {
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

    public Iterator<? extends IPSChartDataSet> getPSChartDataSets();

    public Iterator<? extends IPSChartDataItem> getPSChartDataItems();

    public Iterator<? extends IPSChartVisualMap> getPSChartVisualMaps();

    public Iterator<? extends IPSChartPolar> getPSChartPolars();

    public Iterator<? extends IPSChartCoordinateSystem> getPSChartCoordinateSystems();

    public Iterator<? extends IPSChartDataSetGroup> getPSChartDataSetGroups();

    public String getBaseOptionJOString();
}

