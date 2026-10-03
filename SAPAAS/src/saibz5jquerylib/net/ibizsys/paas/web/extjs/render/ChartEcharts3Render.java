package net.ibizsys.paas.web.extjs.render;

import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.ctrlhandler.CtrlRenderBase;
import net.ibizsys.paas.ctrlhandler.IChartRender;
import net.ibizsys.paas.ctrlmodel.IChartModel;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.util.echarts.EChartsOption;
import net.sf.json.JSONObject;

/**
 * Echarts3 图表绘制器
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
		EChartsOption echartsOption = EChartsOption.createEChartsOption(iChartModel);
		echartsOption.loadDataTable(dt);

		JSONObject opt = echartsOption.getOptionJO();
		if (opt != null) {
			fetchResult.setData(opt);
			return;
		}
		iChartModel.fillFetchResult(fetchResult, dt);
	}

}
