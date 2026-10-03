package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.control.drctrl.IDRCtrlItem;
import net.ibizsys.paas.web.MDAjaxActionResult;

/**
 * 数据关系部件模型接口
 * 
 * @author lionlau
 *
 */
public interface IDRCtrlModel extends ICtrlModel {

	/**
	 * 填充数据获取结果
	 * 
	 * @param fetchResult
	 * @param dt
	 * @throws Exception
	 */
	void fillFetchResult(MDAjaxActionResult fetchResult) throws Exception;

	/**
	 * 获取关系项集合
	 * 
	 * @return
	 */
	java.util.Iterator<IDRCtrlItem> getDRCtrlItems();

	/**
	 * 判断关系项是否启用
	 * 
	 * @param iDRCtrlItem
	 * @return
	 * @throws Exception
	 */
	boolean testDRCtrlItemEnabled(IDRCtrlItem iDRCtrlItem) throws Exception;
}
