/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.ctrlmodel;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.control.chart.IChartDataItem;
import net.ibizsys.paas.ctrlmodel.CtrlModelBase;
import net.ibizsys.paas.ctrlmodel.IChartAxisModel;
import net.ibizsys.paas.ctrlmodel.IChartModel;
import net.ibizsys.paas.ctrlmodel.IChartSeriesModel;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.sf.json.JSONObject;

public abstract class ChartModelBase
extends CtrlModelBase
implements IChartModel {
    private ArrayList<IChartDataItem> chartDataItemList = new ArrayList();
    private ArrayList<IChartAxisModel> chartAxisModelList = new ArrayList();
    private ArrayList<IChartSeriesModel> chartSeriesModelList = new ArrayList();

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.prepareChartAxisModels();
        this.prepareChartSeriesModels();
        this.prepareChartDataItemModels();
    }

    @Override
    public String getControlType() {
        return "CHART";
    }

    protected void prepareChartSeriesModels() throws Exception {
    }

    protected void prepareChartAxisModels() throws Exception {
    }

    protected void prepareChartDataItemModels() throws Exception {
    }

    protected void registerChartAxisModel(IChartAxisModel iChartAxisModel) {
        this.chartAxisModelList.add(iChartAxisModel);
    }

    protected void registerChartSeriesModel(IChartSeriesModel iChartSeriesModel) {
        this.chartSeriesModelList.add(iChartSeriesModel);
    }

    protected void registerChartDataItem(IChartDataItem iChartDataItem) {
        this.chartDataItemList.add(iChartDataItem);
    }

    @Override
    public Iterator<IChartDataItem> getChartDataItems() {
        return this.chartDataItemList.iterator();
    }

    @Override
    public void fillFetchResult(MDAjaxActionResult fetchResult, IDataTable dt) throws Exception {
        if (dt.getCachedRowCount() == -1) {
            IDataRow iDataRow;
            while ((iDataRow = dt.next()) != null) {
                JSONObject jo = new JSONObject();
                for (IChartDataItem iChartDataItem : this.chartDataItemList) {
                    Object objValue = this.getChartDataItemValue(iChartDataItem, iDataRow);
                    JSONObjectHelper.put(jo, iChartDataItem.getName(), objValue);
                }
                fetchResult.getRows().add(jo);
            }
        } else {
            int nRows = dt.getCachedRowCount();
            int i = 0;
            while (i < nRows) {
                IDataRow iDataRow = dt.getCachedRow(i);
                JSONObject jo = new JSONObject();
                for (IChartDataItem iChartDataItem : this.chartDataItemList) {
                    Object objValue = this.getChartDataItemValue(iChartDataItem, iDataRow);
                    JSONObjectHelper.put(jo, iChartDataItem.getName(), objValue);
                }
                fetchResult.getRows().add(jo);
                ++i;
            }
        }
    }

    protected Object getChartDataItemValue(IChartDataItem iChartDataItem, IDataRow iDataRow) throws Exception {
        return iChartDataItem.getValue(this.getViewController().getWebContext(), iDataRow);
    }

    @Override
    public Iterator<IChartAxisModel> getChartAxisModels() {
        return this.chartAxisModelList.iterator();
    }

    @Override
    public Iterator<IChartSeriesModel> getChartSeriesModels() {
        return this.chartSeriesModelList.iterator();
    }
}

