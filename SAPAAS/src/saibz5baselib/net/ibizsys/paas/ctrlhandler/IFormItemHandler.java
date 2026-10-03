package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlmodel.IFormModel;

/**
 * 表单项处理对象接口
 * 
 * @author Administrator
 *
 */
public interface IFormItemHandler extends ICtrlItemHandler {
	/**
	 * 表单项获取数据
	 */
	final static String ACTION_ITEMFETCH = "itemfetch";

	/**
	 * 初始化
	 * 
	 * @param iFormModel
	 * @param iCtrlHandler
	 * @throws Exception
	 */
	void init(IFormModel iFormModel, ICtrlHandler iCtrlHandler) throws Exception;
}
