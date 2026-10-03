package net.ibizsys.paas.web.util.echarts;

import java.util.ArrayList;

import net.sf.json.JSONObject;

/**
 * ECharts 饼图序列
 * 
 * @author Administrator
 *
 */
public class EChartsPieSeries extends EChartsSeries {
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.util.echarts.EChartsSeries#onFillSeriesJO(net.sf.json.JSONObject, java.util.ArrayList)
	 */
	@Override
	protected void onFillSeriesJO(JSONObject series, ArrayList<String> globalCatalogNameList) throws Exception {
		ArrayList<JSONObject> dataList = new ArrayList<JSONObject>();
		for (String strCatalogName : this.getCatalogList()) {
			EChartsPoint echartsPoint = this.getEChartsPoint(strCatalogName);
			if (echartsPoint != null) {
				JSONObject item = new JSONObject();
				item.put("name", strCatalogName);
				item.put("value", echartsPoint.getValue());
				dataList.add(item);
			}
		}
		series.put("data", dataList.toArray());
	}
}
