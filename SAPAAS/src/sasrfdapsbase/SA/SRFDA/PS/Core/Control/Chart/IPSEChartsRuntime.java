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
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import java.util.Iterator;

@PSModelIgnoreMeta
public interface IPSEChartsRuntime {
    public Iterator<? extends IPSChartXAxis> getPSChartXAxises();

    public void registerPSChartXAxis(IPSChartXAxis var1);

    public Iterator<? extends IPSChartYAxis> getPSChartYAxises();

    public void registerPSChartYAxis(IPSChartYAxis var1);

    public Iterator<? extends IPSChartGrid> getPSChartGrids();

    public void registerPSChartGrid(IPSChartGrid var1);

    public Iterator<? extends IPSChartRadar> getPSChartRadars();

    public void registerPSChartRadar(IPSChartRadar var1);

    public void registerPSChartPolar(IPSChartPolar var1);

    public Iterator<? extends IPSChartAngleAxis> getPSChartAngleAxises();

    public void registerPSChartAngleAxis(IPSChartAngleAxis var1);

    public Iterator<? extends IPSChartRadiusAxis> getPSChartRadiusAxises();

    public void registerPSChartRadiusAxis(IPSChartRadiusAxis var1);

    public Iterator<? extends IPSChartParallelAxis> getPSChartParallelAxises();

    public void registerPSChartParallelAxis(IPSChartParallelAxis var1);

    public Iterator<? extends IPSChartSingleAxis> getPSChartSingleAxises();

    public void registerPSChartSingleAxis(IPSChartSingleAxis var1);

    public void registerPSChartParallel(IPSChartParallel var1);

    public Iterator<? extends IPSChartParallel> getPSChartParallels();

    public void registerPSChartSingle(IPSChartSingle var1);

    public Iterator<? extends IPSChartSingle> getPSChartSingles();

    public void registerPSChartDataSet(IPSChartDataSet var1) throws Exception;

    public Iterator<? extends IPSChartDataSet> getPSChartDataSets();

    public Iterator<? extends IPSChartDataItem> getPSChartDataItems();

    public Iterator<? extends IPSChartVisualMap> getPSChartVisualMaps();

    public Iterator<? extends IPSChartPolar> getPSChartPolars();

    public Iterator<? extends IPSChartCoordinateSystem> getPSChartCoordinateSystems();

    public Iterator<? extends IPSChartDataSetGroup> getPSChartDataSetGroups();
}

