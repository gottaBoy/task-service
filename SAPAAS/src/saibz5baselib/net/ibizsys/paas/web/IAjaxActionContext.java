package net.ibizsys.paas.web;

import net.ibizsys.paas.core.IActionContext;

/**
 * 异步操作上下文对象
 * 
 * @author Administrator
 *
 */
public interface IAjaxActionContext extends IActionContext {
	/**
	 * 设置当前的操作结果
	 * 
	 * @param ajaxActionResult
	 */
	void setCurAjaxActionResult(AjaxActionResult ajaxActionResult);

	/**
	 * 获取当前的操作结果
	 * 
	 * @return
	 */
	AjaxActionResult getCurAjaxActionResult();

	/**
	 * 获取控件编号
	 * 
	 * @return
	 */
	String getCtrlId();

	/**
	 * 获取操作
	 * 
	 * @return
	 */
	String getAction();

	/**
	 * 获取请求参数
	 * 
	 * @param strParam
	 * @return
	 */
	String getRequestParam(String strParam);
}
