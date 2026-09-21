/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.chart.IPSChart
 *  net.ibizsys.model.control.chart.IPSChartAxes
 *  net.ibizsys.model.control.chart.IPSChartDataItem
 *  net.ibizsys.model.control.chart.IPSChartGrid
 *  net.ibizsys.model.control.chart.IPSChartPolar
 *  net.ibizsys.model.control.chart.IPSChartSeries
 *  net.ibizsys.model.control.chart.IPSChartVisualMap
 *  net.ibizsys.paas.control.chart.IChartDataItem
 */
package net.ibizsys.model.control.chart;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.model.control.PSAjaxControlImpl;
import net.ibizsys.model.control.chart.IPSChart;
import net.ibizsys.model.control.chart.IPSChartAxes;
import net.ibizsys.model.control.chart.IPSChartDataItem;
import net.ibizsys.model.control.chart.IPSChartGrid;
import net.ibizsys.model.control.chart.IPSChartPolar;
import net.ibizsys.model.control.chart.IPSChartSeries;
import net.ibizsys.model.control.chart.IPSChartVisualMap;
import net.ibizsys.paas.control.chart.IChartDataItem;

public abstract class PSChartImpl
extends PSAjaxControlImpl
implements IPSChart {
    private ArrayList<IPSChartAxes> psChartAxesList = new ArrayList();
    private ArrayList<IPSChartSeries> psChartSeriesList = new ArrayList();
    private ArrayList<IPSChartDataItem> psChartDataItemList = new ArrayList();
    private ArrayList<IChartDataItem> chartDataItemList = new ArrayList();
    private ArrayList<IPSChartGrid> psChartGridList = new ArrayList();
    private ArrayList<IPSChartPolar> psChartPolarList = new ArrayList();
    private ArrayList<IPSChartVisualMap> psChartVisualMapList = new ArrayList();

    protected void addPSChartDataItem(IPSChartDataItem iPSChartDataItem) throws Exception {
        this.psChartDataItemList.add(iPSChartDataItem);
        this.chartDataItemList.add((IChartDataItem)iPSChartDataItem);
    }

    protected void addPSChartAxes(IPSChartAxes iPSChartAxes) throws Exception {
        this.psChartAxesList.add(iPSChartAxes);
    }

    protected void addPSChartSeries(IPSChartSeries iPSChartSeries) throws Exception {
        this.psChartSeriesList.add(iPSChartSeries);
    }

    protected void addPSChartGrid(IPSChartGrid iPSChartGrid) throws Exception {
        this.psChartGridList.add(iPSChartGrid);
    }

    protected void addPSChartPolar(IPSChartPolar iPSChartPolar) throws Exception {
        this.psChartPolarList.add(iPSChartPolar);
    }

    protected void addPSChartVisualMap(IPSChartVisualMap iPSChartVisualMap) throws Exception {
        this.psChartVisualMapList.add(iPSChartVisualMap);
    }

    public Iterator<IPSChartAxes> getPSChartAxeses() {
        if (this.psChartAxesList.size() == 0) {
            return null;
        }
        return this.psChartAxesList.iterator();
    }

    public Iterator<IPSChartSeries> getPSChartSerieses() {
        if (this.psChartSeriesList.size() == 0) {
            return null;
        }
        return this.psChartSeriesList.iterator();
    }

    public Iterator<IPSChartDataItem> getPSChartDataItems() {
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

    public Iterator<IPSChartVisualMap> getPSChartVisualMaps() {
        if (this.psChartVisualMapList.size() == 0) {
            return null;
        }
        return this.psChartVisualMapList.iterator();
    }

    public Iterator<IPSChartGrid> getPSChartGrids() {
        if (this.psChartGridList.size() == 0) {
            return null;
        }
        return this.psChartGridList.iterator();
    }

    public Iterator<IPSChartPolar> getPSChartPolars() {
        if (this.psChartPolarList.size() == 0) {
            return null;
        }
        return this.psChartPolarList.iterator();
    }
}

