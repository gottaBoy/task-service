package net.ibizsys.paas.web.jquery.render;

import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.ctrlhandler.CtrlRenderBase;
import net.ibizsys.paas.ctrlhandler.IChartRender;
import net.ibizsys.paas.ctrlmodel.IChartModel;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.web.MDAjaxActionResult;

/**
 * JQuery Echarts 图表绘制器基类
 * 
 * @author Administrator
 *
 */
public class ChartEchartsRender extends CtrlRenderBase implements IChartRender {

	@Override
	public void fillDEDataSetFetchContext(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {

	}

	@Override
	public String getFetchQuickSearch() {
		return null;
	}
	
	@Override
	public void fillFetchResult(IChartModel iChartModel, MDAjaxActionResult fetchResult, IDataTable dt) throws Exception {
		iChartModel.fillFetchResult(fetchResult, dt);
	}

}
