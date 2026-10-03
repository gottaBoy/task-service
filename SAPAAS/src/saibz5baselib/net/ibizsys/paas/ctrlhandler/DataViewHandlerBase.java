package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.ctrlmodel.IDataViewModel;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.web.MDAjaxActionResult;

/**
 * 数据视图处理对象基类
 * 
 * @author lionlau
 *
 */
public abstract class DataViewHandlerBase extends MDCtrlHandlerBase {
	/**
	 * 获取当前的数据视图模型
	 * 
	 * @return
	 */
	protected abstract IDataViewModel getDataViewModel();

	@Override
	protected void onInit() throws Exception {
		if (this.getDataViewModel().getPageSize() > 0) {
			this.setDefaultPageSize(this.getDataViewModel().getPageSize());
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
		return getDataViewModel();
	}

	/**
	 * 填充数据获取结果
	 * 
	 * @param fetchResult 请求结果
	 * @param dt
	 * @throws Exception
	 */
	protected void fillFetchResult(MDAjaxActionResult fetchResult, IDataTable dt) throws Exception {
		getDataViewModel().fillFetchResult(fetchResult, dt);
	}
}
