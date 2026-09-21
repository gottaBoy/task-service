/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSetFetchContext
 *  net.ibizsys.paas.ctrlhandler.CtrlRenderBase
 *  net.ibizsys.paas.ctrlhandler.IChartRender
 *  net.ibizsys.paas.ctrlmodel.IChartModel
 *  net.ibizsys.paas.ctrlmodel.IChartSeriesModel
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.db.IDataRow
 *  net.ibizsys.paas.db.IDataTable
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.MDAjaxActionResult
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.web.jquery.render;

import java.util.ArrayList;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.ctrlhandler.CtrlRenderBase;
import net.ibizsys.paas.ctrlhandler.IChartRender;
import net.ibizsys.paas.ctrlmodel.IChartModel;
import net.ibizsys.paas.ctrlmodel.IChartSeriesModel;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.util.echarts.ECharts3Option;
import net.sf.json.JSONObject;

public class ChartEcharts3Render
extends CtrlRenderBase
implements IChartRender {
    public void fillDEDataSetFetchContext(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
    }

    public String getFetchQuickSearch() {
        return null;
    }

    public void fillFetchResult(IChartModel iChartModel, MDAjaxActionResult fetchResult, IDataTable dt) throws Exception {
        ECharts3Option echartsOption = ECharts3Option.createEChartsOption(iChartModel);
        echartsOption.loadDataTable(dt);
        JSONObject opt = echartsOption.getOptionJO();
        if (opt != null) {
            fetchResult.setData(opt);
            return;
        }
        iChartModel.fillFetchResult(fetchResult, dt);
    }

    protected JSONObject getPieChartOption(IChartModel iChartModel, IChartSeriesModel iChartSeriesModel, MDAjaxActionResult fetchResult, IDataTable dt) throws Exception {
        JSONObject opt = new JSONObject();
        ArrayList<String> catList = new ArrayList<String>();
        ArrayList<Double> valueList = new ArrayList<Double>();
        ArrayList<JSONObject> dataList = new ArrayList<JSONObject>();
        int nRows = dt.getCachedRowCount();
        int i = 0;
        while (i < nRows) {
            Double fValue;
            IDataRow iDataRow = dt.getCachedRow(i);
            String strCat = DataObject.getStringValue((Object)iDataRow.get(iChartSeriesModel.getCatalogField()), null);
            if (strCat != null && (fValue = DataObject.getDoubleValue((Object)iDataRow.get(iChartSeriesModel.getValueField()))) != null) {
                catList.add(strCat);
                valueList.add(fValue);
                JSONObject item = new JSONObject();
                item.put("name", JSONObjectHelper.stripQuotes((String)strCat));
                item.put("value", (Object)fValue);
                dataList.add(item);
            }
            ++i;
        }
        JSONObject legend = new JSONObject();
        legend.put("data", (Object)catList.toArray());
        opt.put("legend", (Object)legend);
        JSONObject tooltip = new JSONObject();
        ArrayList<JSONObject> seriesList = new ArrayList<JSONObject>();
        if (StringHelper.compare((String)iChartSeriesModel.getSeriesType(), (String)"pie", (boolean)true) == 0) {
            JSONObject series = new JSONObject();
            series.put("type", (Object)"pie");
            series.put("data", (Object)dataList.toArray());
            tooltip.put("trigger", (Object)"item");
            tooltip.put("formatter", (Object)"{a} <br/>{b} : {c} ({d}%)");
            seriesList.add(series);
        }
        if (seriesList.size() == 1) {
            opt.put("series", seriesList.get(0));
        } else {
            opt.put("series", (Object)seriesList.toArray());
        }
        opt.put("tooltip", (Object)tooltip);
        return opt;
    }

    protected JSONObject getLineChartOption(IChartModel iChartModel, IChartSeriesModel iChartSeriesModel, MDAjaxActionResult fetchResult, IDataTable dt) throws Exception {
        JSONObject opt = new JSONObject();
        String strSeriesField = iChartSeriesModel.getSeriesField();
        ArrayList<String> catList = new ArrayList<String>();
        ArrayList<Double> valueList = new ArrayList<Double>();
        ArrayList<JSONObject> dataList = new ArrayList<JSONObject>();
        int nRows = dt.getCachedRowCount();
        int i = 0;
        while (i < nRows) {
            Double fValue;
            IDataRow iDataRow = dt.getCachedRow(i);
            String strCat = DataObject.getStringValue((Object)iDataRow.get(iChartSeriesModel.getCatalogField()), null);
            if (strCat != null && (fValue = DataObject.getDoubleValue((Object)iDataRow.get(iChartSeriesModel.getValueField()))) != null) {
                catList.add(strCat);
                valueList.add(fValue);
                JSONObject item = new JSONObject();
                item.put("name", (Object)strCat);
                item.put("value", (Object)fValue);
                dataList.add(item);
            }
            ++i;
        }
        JSONObject legend = new JSONObject();
        legend.put("data", (Object)catList.toArray());
        opt.put("legend", (Object)legend);
        JSONObject tooltip = new JSONObject();
        ArrayList<JSONObject> seriesList = new ArrayList<JSONObject>();
        if (StringHelper.compare((String)iChartSeriesModel.getSeriesType(), (String)"pie", (boolean)true) == 0) {
            JSONObject series = new JSONObject();
            series.put("type", (Object)"pie");
            series.put("data", (Object)dataList.toArray());
            tooltip.put("trigger", (Object)"item");
            tooltip.put("formatter", (Object)"{a} <br/>{b} : {c} ({d}%)");
            seriesList.add(series);
        }
        if (seriesList.size() == 1) {
            opt.put("series", seriesList.get(0));
        } else {
            opt.put("series", (Object)seriesList.toArray());
        }
        opt.put("tooltip", (Object)tooltip);
        return opt;
    }
}

