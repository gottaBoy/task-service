package net.ibizsys.paas.web.util.echarts;

import java.util.ArrayList;

import net.ibizsys.paas.ctrlmodel.IChartAxisModel;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;

/**
 * ECharts XY 左右轴对象
 * 
 * @author Administrator
 *
 */
public class EChartsXYAxis extends EChartsAxis {

	public EChartsXYAxis(IChartAxisModel iChartAxisModel) throws Exception {
		super(iChartAxisModel);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.util.echarts.EChartsAxis#onFillAxisJO(net.sf.json.JSONObject, java.util.ArrayList)
	 */
	@Override
	protected void onFillAxisJO(JSONObject jo, ArrayList<String> globalCatalogNameList) throws Exception {
		if (!StringHelper.isNullOrEmpty(this.getChartAxisModel().getAxisPos())) {
			jo.put("position", this.getChartAxisModel().getAxisPos());
		}

		if (StringHelper.compare(this.getChartAxisModel().getAxisType(), IChartAxisModel.AXISTYPE_NUMERIC, true) == 0) {
			jo.put("type", "value");
		} else if (StringHelper.compare(this.getChartAxisModel().getAxisType(), IChartAxisModel.AXISTYPE_CATEGORY, true) == 0) {
			jo.put("type", "category");
			jo.put("data", globalCatalogNameList.toArray());
		} else
			jo.put("type", "value");
	}
}
