package net.ibizsys.paas.web.util.echarts;

import java.util.ArrayList;

import net.ibizsys.paas.ctrlmodel.IChartSeriesModel;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;

/**
 * ECharts 仪表盘序列对象
 * 
 * @author Administrator
 *
 */
public class EChartsGaugeSeries extends EChartsSeries {
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.util.echarts.EChartsSeries#onFillSeriesJO(net.sf.json.JSONObject, java.util.ArrayList)
	 */
	@Override
	protected void onFillSeriesJO(JSONObject series, ArrayList<String> globalCatalogNameList) throws Exception {
		ArrayList<Double> dataList = new ArrayList<Double>();
		for (String strCatalogName : globalCatalogNameList) {
			EChartsPoint echartsPoint = this.getEChartsPoint(strCatalogName);
			if (echartsPoint != null) {
				dataList.add(echartsPoint.getValue());
			}
		}
		series.put("data", dataList.toArray());
	}
}
