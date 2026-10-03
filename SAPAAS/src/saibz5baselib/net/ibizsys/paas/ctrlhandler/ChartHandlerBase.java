package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlmodel.IChartModel;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.web.MDAjaxActionResult;

/**
 * 图表模型后台处理对象
 * 
 * @author lionlau
 *
 */
public abstract class ChartHandlerBase extends MDCtrlHandlerBase {
	/**
	 * 获取图表模型
	 * 
	 * @return
	 */
	protected abstract IChartModel getChartModel();

	@Override
	protected void onInit() throws Exception {
		if (this.getDefaultPageSize() < 0) {
			// 默认分页大小为10000
			this.setDefaultPageSize(10000);
		}
		super.onInit();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.ICtrlHandler#getCtrlModel()
	 */
	@Override
	public ICtrlModel getCtrlModel() {
		return getChartModel();
	}

	/**
	 * 填充数据获取结果
	 * 
	 * @param fetchResult 查询结果
	 * @param dt 数据
	 * @throws Exception
	 */
	@Override
	protected void fillFetchResult(MDAjaxActionResult fetchResult, IDataTable dt) throws Exception {
		ICtrlRender iCtrlRender = this.getCtrlRender();
		if (iCtrlRender != null) {
			((IChartRender) iCtrlRender).fillFetchResult(getChartModel(), fetchResult, dt);
			return;
		}
		getChartModel().fillFetchResult(fetchResult, dt);
	}
}
