package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.web.AjaxActionResult;

/**
 * 部件操作处理对象接口，用于处理特定的操作
 * @author Administrator
 *
 */
public interface ICtrlActionHandler {

	/**
	 * 初始化
	 * @param iCtrlHandler
	 * @throws Exception
	 */
	void init(ICtrlHandler iCtrlHandler)throws Exception;
	
	
	
	/**
	 * 处理请求
	 * @param strAction
	 * @return
	 * @throws Exception
	 */
	AjaxActionResult processAction(String strAction) throws Exception;
	
	

}
