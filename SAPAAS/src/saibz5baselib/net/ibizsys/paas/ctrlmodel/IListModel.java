package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.control.list.IList;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.web.MDAjaxActionResult;

/**
 * 数据列表部件模型接口
 * 
 * @author lionlau
 *
 */
public interface IListModel extends ICtrlModel, IList {
	/**
	 * 填充结果数据对象
	 * 
	 * @param fetchResult
	 * @param dt
	 * @throws Exception
	 */
	void fillFetchResult(MDAjaxActionResult fetchResult, IDataTable dt) throws Exception;

	/**
	 * 获取分页大小
	 * 
	 * @return
	 */
	int getPageSize();
}
