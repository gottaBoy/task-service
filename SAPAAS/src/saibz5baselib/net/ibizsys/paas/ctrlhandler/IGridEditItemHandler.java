package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlmodel.IGridModel;

/**
 * 表格项处理对象接口
 * 
 * @author Administrator
 *
 */
public interface IGridEditItemHandler extends ICtrlItemHandler {
	
	/**
	 * 表格项获取数据
	 */
	final static String ACTION_ITEMFETCH = "itemfetch";

	/**
	 * 初始化
	 * 
	 * @param iGridModel
	 * @param iCtrlHandler
	 * @throws Exception
	 */
	void init(IGridModel iGridModel, ICtrlHandler iCtrlHandler) throws Exception;
}
