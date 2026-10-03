package net.ibizsys.paas.web.util.echarts;

import java.util.ArrayList;

import net.ibizsys.paas.ctrlmodel.IChartSeriesModel;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;

/**
 * ECharts K线图序列对象
 * 
 * @author Administrator
 *
 */
public class EChartsCandlestickSeries extends EChartsSeries {
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.util.echarts.EChartsSeries#onFillSeriesJO(net.sf.json.JSONObject, java.util.ArrayList)
	 */
	@Override
	protected void onFillSeriesJO(JSONObject series, ArrayList<String> globalCatalogNameList) throws Exception {
		ArrayList<Object> dataList = new ArrayList<Object>();
		for (String strCatalogName : globalCatalogNameList) {
			ArrayList<Double> dataList2 = new ArrayList<Double>();
			EChartsPoint echartsPoint = this.getEChartsPoint(strCatalogName);
			if (echartsPoint != null) {
				if(echartsPoint.getValue() != null)
					dataList2.add(echartsPoint.getValue());
				if(echartsPoint.getValue2() != null)
					dataList2.add(echartsPoint.getValue2());
				if(echartsPoint.getValue3() != null)
					dataList2.add(echartsPoint.getValue3());
				if(echartsPoint.getValue4() != null)
					dataList2.add(echartsPoint.getValue4());
			}
			dataList.add(dataList2.toArray());
		}
		series.put("data", dataList);
		
	}
}
