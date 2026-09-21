/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.chart.IChartDataItem
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChart;
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
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChart;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartDataSet;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartDataSetRuntime;
import SA.SRFDA.PS.Core.Control.Chart.IPSEChartsObjectRuntime;
import SA.SRFDA.PS.Core.Control.Chart.IPSEChartsRuntime;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartDataSetGroupImpl;
import SA.SRFDA.PS.Core.Control.IPSControlAction;
import SA.SRFDA.PS.Core.Control.PSMDAjaxControlContainerImpl2;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.control.chart.IChartDataItem;
import net.ibizsys.paas.util.StringHelper;

public class PSChartImpl
extends PSMDAjaxControlContainerImpl2
implements IPSChart,
IPSEChartsRuntime {
    private ArrayList<IPSChartDataItem> psChartDataItemList = new ArrayList();
    private ArrayList<IChartDataItem> chartDataItemList = new ArrayList();
    private ArrayList<IPSChartGrid> psChartGridList = new ArrayList();
    private ArrayList<IPSChartPolar> psChartPolarList = new ArrayList();
    private ArrayList<IPSChartVisualMap> psChartVisualMapList = new ArrayList();
    private ArrayList<IPSChartXAxis> psChartXAxisList = new ArrayList();
    private ArrayList<IPSChartYAxis> psChartYAxisList = new ArrayList();
    private ArrayList<IPSChartRadar> psChartRadarList = new ArrayList();
    private ArrayList<IPSChartAngleAxis> psChartAngleAxisList = new ArrayList();
    private ArrayList<IPSChartRadiusAxis> psChartRadiusAxisList = new ArrayList();
    private ArrayList<IPSChartParallel> psChartParallelList = new ArrayList();
    private ArrayList<IPSChartParallelAxis> psChartParallelAxisList = new ArrayList();
    private ArrayList<IPSChartSingle> psChartSingleList = new ArrayList();
    private ArrayList<IPSChartSingleAxis> psChartSingleAxisList = new ArrayList();
    private ArrayList<IPSChartDataSet> psChartDataSetList = new ArrayList();
    private ArrayList<PSDEChartDataSetGroupImpl> psChartDataSetGroupList = new ArrayList();

    protected void addPSChartDataItem(IPSChartDataItem iPSChartDataItem) throws Exception {
        this.psChartDataItemList.add(iPSChartDataItem);
        this.chartDataItemList.add(iPSChartDataItem);
    }

    protected void addPSChartVisualMap(IPSChartVisualMap iPSChartVisualMap) throws Exception {
        this.psChartVisualMapList.add(iPSChartVisualMap);
    }

    @Override
    public Iterator<? extends IPSChartDataItem> getPSChartDataItems() {
        if (this.psChartDataItemList.size() == 0) {
            return null;
        }
        return this.psChartDataItemList.iterator();
    }

    public Iterator<IChartDataItem> getChartDataItems() {
        if (this.chartDataItemList.size() == 0) {
            return null;
        }
        return this.chartDataItemList.iterator();
    }

    @Override
    public Iterator<? extends IPSChartVisualMap> getPSChartVisualMaps() {
        if (this.psChartVisualMapList.size() == 0) {
            return null;
        }
        return this.psChartVisualMapList.iterator();
    }

    @Override
    @PSModelRTMeta(description="xAxis\u96c6\u5408", child=true)
    public Iterator<? extends IPSChartXAxis> getPSChartXAxises() {
        if (this.psChartXAxisList == null || this.psChartXAxisList.size() == 0) {
            return null;
        }
        return this.psChartXAxisList.iterator();
    }

    @Override
    public void registerPSChartXAxis(IPSChartXAxis iPSChartXAxis) {
        int nIndex = this.psChartXAxisList.size();
        if (iPSChartXAxis instanceof IPSEChartsObjectRuntime) {
            ((IPSEChartsObjectRuntime)((Object)iPSChartXAxis)).setIndex(nIndex);
        }
        this.psChartXAxisList.add(iPSChartXAxis);
    }

    @Override
    @PSModelRTMeta(description="yAxis\u96c6\u5408", child=true)
    public Iterator<? extends IPSChartYAxis> getPSChartYAxises() {
        if (this.psChartYAxisList == null || this.psChartYAxisList.size() == 0) {
            return null;
        }
        return this.psChartYAxisList.iterator();
    }

    @Override
    public void registerPSChartYAxis(IPSChartYAxis iPSChartYAxis) {
        int nIndex = this.psChartYAxisList.size();
        if (iPSChartYAxis instanceof IPSEChartsObjectRuntime) {
            ((IPSEChartsObjectRuntime)((Object)iPSChartYAxis)).setIndex(nIndex);
        }
        this.psChartYAxisList.add(iPSChartYAxis);
    }

    @Override
    @PSModelRTMeta(description="\u76f4\u89d2\u5750\u6807\u8868\u683c\u96c6\u5408", child=true)
    public Iterator<? extends IPSChartGrid> getPSChartGrids() {
        if (this.psChartGridList.size() == 0) {
            return null;
        }
        return this.psChartGridList.iterator();
    }

    @Override
    public synchronized void registerPSChartGrid(IPSChartGrid iPSChartGrid) {
        int nIndex = this.psChartGridList.size();
        if (iPSChartGrid instanceof IPSEChartsObjectRuntime) {
            ((IPSEChartsObjectRuntime)((Object)iPSChartGrid)).setIndex(nIndex);
        }
        this.psChartGridList.add(iPSChartGrid);
    }

    @Override
    @PSModelRTMeta(description="\u96f7\u8fbe\u90e8\u4ef6\u96c6\u5408", child=true)
    public Iterator<? extends IPSChartRadar> getPSChartRadars() {
        if (this.psChartRadarList.size() == 0) {
            return null;
        }
        return this.psChartRadarList.iterator();
    }

    @Override
    public synchronized void registerPSChartRadar(IPSChartRadar iPSChartRadar) {
        int nIndex = this.psChartRadarList.size();
        if (iPSChartRadar instanceof IPSEChartsObjectRuntime) {
            ((IPSEChartsObjectRuntime)((Object)iPSChartRadar)).setIndex(nIndex);
        }
        this.psChartRadarList.add(iPSChartRadar);
    }

    @Override
    @PSModelRTMeta(description="\u6781\u5750\u6807\u90e8\u4ef6\u96c6\u5408", child=true)
    public Iterator<? extends IPSChartPolar> getPSChartPolars() {
        if (this.psChartPolarList.size() == 0) {
            return null;
        }
        return this.psChartPolarList.iterator();
    }

    @Override
    public synchronized void registerPSChartPolar(IPSChartPolar iPSChartPolar) {
        int nIndex = this.psChartPolarList.size();
        if (iPSChartPolar instanceof IPSEChartsObjectRuntime) {
            ((IPSEChartsObjectRuntime)((Object)iPSChartPolar)).setIndex(nIndex);
        }
        this.psChartPolarList.add(iPSChartPolar);
    }

    @Override
    @PSModelRTMeta(description="angleAxis\u96c6\u5408", child=true)
    public Iterator<? extends IPSChartAngleAxis> getPSChartAngleAxises() {
        if (this.psChartAngleAxisList == null || this.psChartAngleAxisList.size() == 0) {
            return null;
        }
        return this.psChartAngleAxisList.iterator();
    }

    @Override
    public void registerPSChartAngleAxis(IPSChartAngleAxis iPSChartAngleAxis) {
        int nIndex = this.psChartAngleAxisList.size();
        if (iPSChartAngleAxis instanceof IPSEChartsObjectRuntime) {
            ((IPSEChartsObjectRuntime)((Object)iPSChartAngleAxis)).setIndex(nIndex);
        }
        this.psChartAngleAxisList.add(iPSChartAngleAxis);
    }

    @Override
    @PSModelRTMeta(description="radiusAxis\u96c6\u5408", child=true)
    public Iterator<? extends IPSChartRadiusAxis> getPSChartRadiusAxises() {
        if (this.psChartRadiusAxisList == null || this.psChartRadiusAxisList.size() == 0) {
            return null;
        }
        return this.psChartRadiusAxisList.iterator();
    }

    @Override
    public void registerPSChartRadiusAxis(IPSChartRadiusAxis iPSChartRadiusAxis) {
        int nIndex = this.psChartRadiusAxisList.size();
        if (iPSChartRadiusAxis instanceof IPSEChartsObjectRuntime) {
            ((IPSEChartsObjectRuntime)((Object)iPSChartRadiusAxis)).setIndex(nIndex);
        }
        this.psChartRadiusAxisList.add(iPSChartRadiusAxis);
    }

    @Override
    @PSModelRTMeta(description="\u5e73\u884c\u5750\u6807\u90e8\u4ef6\u96c6\u5408", child=true)
    public Iterator<? extends IPSChartParallel> getPSChartParallels() {
        if (this.psChartParallelList.size() == 0) {
            return null;
        }
        return this.psChartParallelList.iterator();
    }

    @Override
    public synchronized void registerPSChartParallel(IPSChartParallel iPSChartParallel) {
        int nIndex = this.psChartParallelList.size();
        if (iPSChartParallel instanceof IPSEChartsObjectRuntime) {
            ((IPSEChartsObjectRuntime)((Object)iPSChartParallel)).setIndex(nIndex);
        }
        this.psChartParallelList.add(iPSChartParallel);
    }

    @Override
    @PSModelRTMeta(description="paralleAxis\u96c6\u5408", child=true)
    public Iterator<? extends IPSChartParallelAxis> getPSChartParallelAxises() {
        if (this.psChartParallelAxisList == null || this.psChartParallelAxisList.size() == 0) {
            return null;
        }
        return this.psChartParallelAxisList.iterator();
    }

    @Override
    public void registerPSChartParallelAxis(IPSChartParallelAxis iPSChartParallelAxis) {
        int nIndex = this.psChartParallelAxisList.size();
        if (iPSChartParallelAxis instanceof IPSEChartsObjectRuntime) {
            ((IPSEChartsObjectRuntime)((Object)iPSChartParallelAxis)).setIndex(nIndex);
        }
        this.psChartParallelAxisList.add(iPSChartParallelAxis);
    }

    @Override
    @PSModelRTMeta(description="\u5355\u4e00\u5750\u6807\u90e8\u4ef6\u96c6\u5408", child=true)
    public Iterator<? extends IPSChartSingle> getPSChartSingles() {
        if (this.psChartSingleList.size() == 0) {
            return null;
        }
        return this.psChartSingleList.iterator();
    }

    @Override
    public synchronized void registerPSChartSingle(IPSChartSingle iPSChartSingle) {
        int nIndex = this.psChartSingleList.size();
        if (iPSChartSingle instanceof IPSEChartsObjectRuntime) {
            ((IPSEChartsObjectRuntime)((Object)iPSChartSingle)).setIndex(nIndex);
        }
        this.psChartSingleList.add(iPSChartSingle);
    }

    @Override
    @PSModelRTMeta(description="singleAxis\u96c6\u5408", child=true)
    public Iterator<? extends IPSChartSingleAxis> getPSChartSingleAxises() {
        if (this.psChartSingleAxisList == null || this.psChartSingleAxisList.size() == 0) {
            return null;
        }
        return this.psChartSingleAxisList.iterator();
    }

    @Override
    public void registerPSChartSingleAxis(IPSChartSingleAxis iPSChartSingleAxis) {
        int nIndex = this.psChartSingleAxisList.size();
        if (iPSChartSingleAxis instanceof IPSEChartsObjectRuntime) {
            ((IPSEChartsObjectRuntime)((Object)iPSChartSingleAxis)).setIndex(nIndex);
        }
        this.psChartSingleAxisList.add(iPSChartSingleAxis);
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u96c6\u96c6\u5408", child=true)
    public Iterator<? extends IPSChartDataSet> getPSChartDataSets() {
        if (this.psChartDataSetList.size() == 0) {
            return null;
        }
        return this.psChartDataSetList.iterator();
    }

    @Override
    public synchronized void registerPSChartDataSet(IPSChartDataSet iPSChartDataSet) throws Exception {
        PSDEChartDataSetGroupImpl psDEChartDataSetGroupImpl2;
        int nIndex = this.psChartDataSetList.size();
        if (iPSChartDataSet instanceof IPSEChartsObjectRuntime) {
            ((IPSEChartsObjectRuntime)((Object)iPSChartDataSet)).setIndex(nIndex);
        }
        this.psChartDataSetList.add(iPSChartDataSet);
        for (PSDEChartDataSetGroupImpl psDEChartDataSetGroupImpl2 : this.psChartDataSetGroupList) {
            if (StringHelper.compare((String)psDEChartDataSetGroupImpl2.getPSDEDataSet().getId(), (String)iPSChartDataSet.getPSDEDataSet().getId(), (boolean)false) != 0) continue;
            psDEChartDataSetGroupImpl2.registerPSDEChartDataSet((IPSDEChartDataSet)iPSChartDataSet);
            ((IPSDEChartDataSetRuntime)((Object)iPSChartDataSet)).setPSDEChartDataSetGroup(psDEChartDataSetGroupImpl2);
            return;
        }
        psDEChartDataSetGroupImpl2 = new PSDEChartDataSetGroupImpl();
        psDEChartDataSetGroupImpl2.init(this.getDAGlobalHelper(), (IPSDEChart)((Object)this), iPSChartDataSet.getPSDEDataSet());
        this.psChartDataSetGroupList.add(psDEChartDataSetGroupImpl2);
        psDEChartDataSetGroupImpl2.registerPSDEChartDataSet((IPSDEChartDataSet)iPSChartDataSet);
        ((IPSDEChartDataSetRuntime)((Object)iPSChartDataSet)).setPSDEChartDataSetGroup(psDEChartDataSetGroupImpl2);
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u96c6\u5206\u7ec4\u96c6\u5408", child=true)
    public Iterator<? extends IPSChartDataSetGroup> getPSChartDataSetGroups() {
        if (this.psChartDataSetGroupList.size() == 0) {
            return null;
        }
        return this.psChartDataSetGroupList.iterator();
    }

    @Override
    protected boolean onGetReadOnly() {
        return true;
    }

    @Override
    public IPSControlAction getGetPSControlAction() {
        return null;
    }

    @Override
    public Iterator<? extends IPSChartCoordinateSystem> getPSChartCoordinateSystems() {
        return null;
    }

    @Override
    public String getChartTheme() {
        return null;
    }

    @Override
    public IPSChartTitle getPSChartTitle() {
        return null;
    }

    @Override
    public IPSChartLegend getPSChartLegend() {
        return null;
    }

    @Override
    public IPSChartDataGrid getPSChartDataGrid() {
        return null;
    }

    @Override
    public Iterator<? extends IPSChartAxes> getPSChartAxeses() {
        return null;
    }

    @Override
    public Iterator<? extends IPSChartSeries> getPSChartSerieses() {
        return null;
    }

    @Override
    public IPSLanguageRes getEmptyTextPSLanguageRes() {
        return null;
    }

    @Override
    public String getEmptyText() {
        return null;
    }

    @Override
    public String getCoordinateSystem() {
        return null;
    }
}

