/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.chart.IPSChartDataItem
 *  net.ibizsys.model.control.chart.IPSDEChart
 *  net.ibizsys.model.control.chart.IPSDEChartAxes
 *  net.ibizsys.model.control.chart.IPSDEChartSeries
 *  net.ibizsys.paas.control.chart.IChart
 *  net.ibizsys.paas.control.chart.IChartDataItem
 *  net.ibizsys.paas.ctrlmodel.ChartAxisModel
 *  net.ibizsys.paas.ctrlmodel.ChartDataItemModel
 *  net.ibizsys.paas.ctrlmodel.ChartModelBase
 *  net.ibizsys.paas.ctrlmodel.ChartSeriesModel
 *  net.ibizsys.paas.ctrlmodel.IChartAxisModel
 *  net.ibizsys.paas.ctrlmodel.IChartSeriesModel
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.ssdyna.ctrlmodel;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.chart.IPSChartDataItem;
import net.ibizsys.model.control.chart.IPSDEChart;
import net.ibizsys.model.control.chart.IPSDEChartAxes;
import net.ibizsys.model.control.chart.IPSDEChartSeries;
import net.ibizsys.paas.control.chart.IChart;
import net.ibizsys.paas.control.chart.IChartDataItem;
import net.ibizsys.paas.ctrlmodel.ChartAxisModel;
import net.ibizsys.paas.ctrlmodel.ChartDataItemModel;
import net.ibizsys.paas.ctrlmodel.ChartModelBase;
import net.ibizsys.paas.ctrlmodel.ChartSeriesModel;
import net.ibizsys.paas.ctrlmodel.IChartAxisModel;
import net.ibizsys.paas.ctrlmodel.IChartSeriesModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.ssdyna.ctrlmodel.DynaCtrlModelBase;
import net.ibizsys.ssdyna.ctrlmodel.IDynaCtrlModel;
import net.ibizsys.ssdyna.view.IDynaViewModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DynaChartModel
extends ChartModelBase
implements IDynaCtrlModel {
    private static final Log log = LogFactory.getLog(DynaChartModel.class);
    private IPSControl iPSControl = null;

    @Override
    public void init(IDynaViewModel iDynaViewModel, IPSControl iPSControl) throws Exception {
        this.iPSControl = iPSControl;
        this.init(iDynaViewModel);
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
                return ((IDynaViewModel)this.getViewController()).getDynaSysModel().getDynaDEModel(this.getPSControl().getPSDataEntity().getId());
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
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
        Iterator psDEChartAxeses = this.getPSDEChart().getPSDEChartAxeses();
        if (psDEChartAxeses != null) {
            while (psDEChartAxeses.hasNext()) {
                IPSDEChartAxes iPSDEChartAxes = (IPSDEChartAxes)psDEChartAxeses.next();
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
        Iterator psDEChartSerieses = this.getPSDEChart().getPSDEChartSerieses();
        if (psDEChartSerieses != null) {
            while (psDEChartSerieses.hasNext()) {
                IPSDEChartSeries iPSDEChartSeries = (IPSDEChartSeries)psDEChartSerieses.next();
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

    @Override
    public ObjectNode toJsonObject(ObjectNode objectNode) throws Exception {
        if (objectNode == null) {
            objectNode = JsonNodeHelper.createObjectNode();
        }
        this.onFillJsonObject(objectNode);
        return objectNode;
    }

    protected void onFillJsonObject(ObjectNode objectNode) throws Exception {
        if (this.getPSControl() != null) {
            DynaCtrlModelBase.toJsonObject(objectNode, this.getPSControl());
        }
    }

    @Override
    public boolean isDynaCtrl() {
        if (this.getPSControl() != null) {
            return this.getPSControl().isDynamicCtrl();
        }
        return false;
    }
}

