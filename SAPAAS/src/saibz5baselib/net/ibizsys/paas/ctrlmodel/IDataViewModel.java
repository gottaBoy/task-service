package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.control.dataview.IDataView;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.web.MDAjaxActionResult;

/**
 * 数据视图部件模型对象接口
 * 
 * @author Administrator
 *
 */
public interface IDataViewModel extends ICtrlModel, IDataView {
	/**
	 * 获取默认分页大小
	 * 
	 * @return
	 */
	int getPageSize();

	/**
	 * 填充数据获取返回结果
	 * 
	 * @param fetchResult
	 * @param dt
	 * @throws Exception
	 */
	void fillFetchResult(MDAjaxActionResult fetchResult, IDataTable dt) throws Exception;
}
