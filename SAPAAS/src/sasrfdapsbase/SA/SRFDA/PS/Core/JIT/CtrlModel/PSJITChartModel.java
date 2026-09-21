/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.chart.IChart
 *  net.ibizsys.paas.control.chart.IChartDataItem
 *  net.ibizsys.paas.controller.IViewController
 *  net.ibizsys.paas.ctrlmodel.ChartAxisModel
 *  net.ibizsys.paas.ctrlmodel.ChartDataItemModel
 *  net.ibizsys.paas.ctrlmodel.ChartModelBase
 *  net.ibizsys.paas.ctrlmodel.ChartSeriesModel
 *  net.ibizsys.paas.ctrlmodel.IChartAxisModel
 *  net.ibizsys.paas.ctrlmodel.IChartSeriesModel
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.JIT.CtrlModel;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartDataItem;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChart;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartAxes;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartSeries;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.JIT.CtrlModel.IPSJITCtrlModel;
import java.util.Iterator;
import net.ibizsys.paas.control.chart.IChart;
import net.ibizsys.paas.control.chart.IChartDataItem;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.ctrlmodel.ChartAxisModel;
import net.ibizsys.paas.ctrlmodel.ChartDataItemModel;
import net.ibizsys.paas.ctrlmodel.ChartModelBase;
import net.ibizsys.paas.ctrlmodel.ChartSeriesModel;
import net.ibizsys.paas.ctrlmodel.IChartAxisModel;
import net.ibizsys.paas.ctrlmodel.IChartSeriesModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.StringHelper;

public class PSJITChartModel
extends ChartModelBase
implements IPSJITCtrlModel {
    private IPSControl iPSControl = null;

    @Override
    public void init(IViewController iViewController, IPSControl iPSControl) throws Exception {
        this.iPSControl = iPSControl;
        this.init(iViewController);
    }

    @Override
    public IPSControl getPSControl() {
        return this.iPSControl;
    }

    public IPSDEChart getPSDEChart() {
        return (IPSDEChart)this.getPSControl();
    }

    public IDataEntityModel getDEModel() {
        try {
            if (this.getPSControl().getPSDataEntity() != null) {
                return this.getViewController().getSystemModel().getDataEntityModel(this.getPSControl().getPSDataEntity().getName());
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return super.getDEModel();
    }

    protected void prepareChartDataItemModels() throws Exception {
        super.prepareChartDataItemModels();
        if (this.getPSDEChart().getChartDataItems() != null) {
            Iterator chartDataItems = this.getPSDEChart().getChartDataItems();
            while (chartDataItems.hasNext()) {
                IPSChartDataItem iPSChartDataItem = (IPSChartDataItem)chartDataItems.next();
                ChartDataItemModel chartDataItem = new ChartDataItemModel();
                if (!StringHelper.isNullOrEmpty((String)iPSChartDataItem.getName())) {
                    chartDataItem.setName(iPSChartDataItem.getName());
                }
                chartDataItem.setDataType(iPSChartDataItem.getDataType());
                if (!StringHelper.isNullOrEmpty((String)iPSChartDataItem.getFormat())) {
                    chartDataItem.setFormat(iPSChartDataItem.getFormat());
                }
                chartDataItem.init((IChart)this);
                this.registerChartDataItem((IChartDataItem)chartDataItem);
            }
        }
    }

    protected void prepareChartAxisModels() throws Exception {
        super.prepareChartAxisModels();
        Iterator<IPSDEChartAxes> psDEChartAxeses = this.getPSDEChart().getPSDEChartAxeses();
        if (psDEChartAxeses != null) {
            while (psDEChartAxeses.hasNext()) {
                IPSDEChartAxes iPSDEChartAxes = psDEChartAxeses.next();
                ChartAxisModel chartAxisModel = new ChartAxisModel();
                if (!StringHelper.isNullOrEmpty((String)iPSDEChartAxes.getName())) {
                    chartAxisModel.setName(iPSDEChartAxes.getName());
                }
                if (!StringHelper.isNullOrEmpty((String)iPSDEChartAxes.getCaption())) {
                    chartAxisModel.setCaption(iPSDEChartAxes.getCaption());
                }
                if (!StringHelper.isNullOrEmpty((String)iPSDEChartAxes.getAxesType())) {
                    chartAxisModel.setAxisType(iPSDEChartAxes.getAxesType());
                }
                if (!StringHelper.isNullOrEmpty((String)iPSDEChartAxes.getAxesPos())) {
                    chartAxisModel.setAxisPos(iPSDEChartAxes.getAxesPos());
                }
                chartAxisModel.init((IChart)this);
                this.registerChartAxisModel((IChartAxisModel)chartAxisModel);
            }
        }
    }

    protected void prepareChartSeriesModels() throws Exception {
        super.prepareChartSeriesModels();
        Iterator<IPSDEChartSeries> psDEChartSerieses = this.getPSDEChart().getPSDEChartSerieses();
        if (psDEChartSerieses != null) {
            while (psDEChartSerieses.hasNext()) {
                IPSDEChartSeries iPSDEChartSeries = psDEChartSerieses.next();
                ChartSeriesModel chartSeriesModel = new ChartSeriesModel();
                if (!StringHelper.isNullOrEmpty((String)iPSDEChartSeries.getName())) {
                    chartSeriesModel.setName(iPSDEChartSeries.getName());
                }
                if (!StringHelper.isNullOrEmpty((String)iPSDEChartSeries.getCaption())) {
                    chartSeriesModel.setCaption(iPSDEChartSeries.getCaption());
                }
                if (!StringHelper.isNullOrEmpty((String)iPSDEChartSeries.getSeriesType())) {
                    chartSeriesModel.setSeriesType(iPSDEChartSeries.getSeriesType());
                }
                if (!StringHelper.isNullOrEmpty((String)iPSDEChartSeries.getSeriesField())) {
                    chartSeriesModel.setSeriesField(iPSDEChartSeries.getSeriesField());
                }
                if (!StringHelper.isNullOrEmpty((String)iPSDEChartSeries.getCatalogField())) {
                    chartSeriesModel.setCatalogField(iPSDEChartSeries.getCatalogField());
                }
                if (!StringHelper.isNullOrEmpty((String)iPSDEChartSeries.getValueField())) {
                    chartSeriesModel.setValueField(iPSDEChartSeries.getValueField());
                }
                if (!StringHelper.isNullOrEmpty((String)iPSDEChartSeries.getValue2Field())) {
                    chartSeriesModel.setValue2Field(iPSDEChartSeries.getValue2Field());
                }
                if (!StringHelper.isNullOrEmpty((String)iPSDEChartSeries.getTimeGroupMode())) {
                    chartSeriesModel.setTimeGroupMode(iPSDEChartSeries.getTimeGroupMode());
                }
                chartSeriesModel.init((IChart)this);
                this.registerChartSeriesModel((IChartSeriesModel)chartSeriesModel);
            }
        }
    }
}

