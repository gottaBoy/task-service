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

/**
 * JQuery Echarts3 图表绘制器基类
 * 
 * @author Administrator
 *
 */
public class ChartEcharts3Render extends CtrlRenderBase implements IChartRender {

	@Override
	public void fillDEDataSetFetchContext(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {

	}

	@Override
	public String getFetchQuickSearch() {
		return null;
	}

	@Override
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

	/**
	 * 获取饼图结果
	 * 
	 * @param iChartModel
	 * @param iChartSeriesModel
	 * @param fetchResult
	 * @param dt
	 * @return
	 * @throws Exception
	 */
	protected JSONObject getPieChartOption(IChartModel iChartModel, IChartSeriesModel iChartSeriesModel, MDAjaxActionResult fetchResult, IDataTable dt) throws Exception {
		JSONObject opt = new JSONObject();
		// x,y
		ArrayList<String> catList = new ArrayList<String>();
		ArrayList<Double> valueList = new ArrayList<Double>();
		ArrayList<JSONObject> dataList = new ArrayList<JSONObject>();
		int nRows = dt.getCachedRowCount();
		for (int i = 0; i < nRows; i++) {
			IDataRow iDataRow = dt.getCachedRow(i);
			String strCat = DataObject.getStringValue(iDataRow.get(iChartSeriesModel.getCatalogField()), null);
			if (strCat == null) continue;

			Double fValue = DataObject.getDoubleValue(iDataRow.get(iChartSeriesModel.getValueField()));
			if (fValue == null) continue;

			catList.add(strCat);
			valueList.add(fValue);
			JSONObject item = new JSONObject();
			item.put("name", JSONObjectHelper.stripQuotes(strCat));
			item.put("value", fValue);
			dataList.add(item);
		}

		JSONObject legend = new JSONObject();
		legend.put("data", catList.toArray());
		opt.put("legend", legend);

		JSONObject tooltip = new JSONObject();

		ArrayList<JSONObject> seriesList = new ArrayList<JSONObject>();
		if (StringHelper.compare(iChartSeriesModel.getSeriesType(), IChartSeriesModel.SERIESTYPE_PIE, true) == 0) {
			JSONObject series = new JSONObject();
			series.put("type", "pie");
			series.put("data", dataList.toArray());
			tooltip.put("trigger", "item");
			tooltip.put("formatter", "{a} <br/>{b} : {c} ({d}%)");
			seriesList.add(series);
		}

		if (seriesList.size() == 1) {
			opt.put("series", seriesList.get(0));
		} else {
			opt.put("series", seriesList.toArray());
		}

		opt.put("tooltip",tooltip);
		return opt;
	}

	/**
	 * 获取线图结果对象
	 * 
	 * @param iChartModel
	 * @param iChartSeriesModel
	 * @param fetchResult
	 * @param dt
	 * @return
	 * @throws Exception
	 */
	protected JSONObject getLineChartOption(IChartModel iChartModel, IChartSeriesModel iChartSeriesModel, MDAjaxActionResult fetchResult, IDataTable dt) throws Exception {
		JSONObject opt = new JSONObject();

		String strSeriesField = iChartSeriesModel.getSeriesField();

		// x,y
		ArrayList<String> catList = new ArrayList<String>();
		ArrayList<Double> valueList = new ArrayList<Double>();
		ArrayList<JSONObject> dataList = new ArrayList<JSONObject>();
		int nRows = dt.getCachedRowCount();
		for (int i = 0; i < nRows; i++) {
			IDataRow iDataRow = dt.getCachedRow(i);
			String strCat = DataObject.getStringValue(iDataRow.get(iChartSeriesModel.getCatalogField()), null);
			if (strCat == null) continue;

			Double fValue = DataObject.getDoubleValue(iDataRow.get(iChartSeriesModel.getValueField()));
			if (fValue == null) continue;

			catList.add(strCat);
			valueList.add(fValue);
			JSONObject item = new JSONObject();
			item.put("name", strCat);
			item.put("value", fValue);
			dataList.add(item);
		}

		JSONObject legend = new JSONObject();
		legend.put("data", catList.toArray());
		opt.put("legend", legend);

		JSONObject tooltip = new JSONObject();

		ArrayList<JSONObject> seriesList = new ArrayList<JSONObject>();
		if (StringHelper.compare(iChartSeriesModel.getSeriesType(), IChartSeriesModel.SERIESTYPE_PIE, true) == 0) {
			JSONObject series = new JSONObject();
			series.put("type", "pie");
			series.put("data", dataList.toArray());
			tooltip.put("trigger", "item");
			tooltip.put("formatter", "{a} <br/>{b} : {c} ({d}%)");
			seriesList.add(series);
		}

		if (seriesList.size() == 1) {
			opt.put("series", seriesList.get(0));
		} else {
			opt.put("series", seriesList.toArray());
		}

		opt.put("tooltip", tooltip);
		return opt;
	}
}
