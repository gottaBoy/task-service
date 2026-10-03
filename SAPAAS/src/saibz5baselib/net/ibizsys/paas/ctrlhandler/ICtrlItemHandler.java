package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.web.AjaxActionResult;

/**
 * 部件成员处理对象接口
 * 
 * @author lionlau
 *
 */
public interface ICtrlItemHandler {
	
	/**
	 * 处理
	 * 
	 * @param strAction
	 * @return
	 * @throws Exception
	 */
	AjaxActionResult processAction(String strAction) throws Exception;
}
