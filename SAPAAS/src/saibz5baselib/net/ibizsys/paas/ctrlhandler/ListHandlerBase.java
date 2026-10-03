package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.ctrlmodel.IListModel;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.web.MDAjaxActionResult;

/**
 * 列表模型后台处理对象
 * 
 * @author lionlau
 *
 */
public abstract class ListHandlerBase extends MDCtrlHandlerBase {
	/**
	 * 获取列表模型
	 * 
	 * @return
	 */
	protected abstract IListModel getListModel();

	@Override
	protected void onInit() throws Exception {
		if (this.getListModel().getPageSize() > 0) {
			this.setDefaultPageSize(this.getListModel().getPageSize());
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
		return getListModel();
	}

	/**
	 * 填充数据获取结果
	 * 
	 * @param fetchResult
	 * @param dt
	 * @throws Exception
	 */
	@Override
	protected void fillFetchResult(MDAjaxActionResult fetchResult, IDataTable dt) throws Exception {
		getListModel().fillFetchResult(fetchResult, dt);
	}
}
