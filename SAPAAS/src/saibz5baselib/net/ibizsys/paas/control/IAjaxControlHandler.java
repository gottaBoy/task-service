package net.ibizsys.paas.control;

import net.ibizsys.paas.ajax.IAjaxHandler;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.IAjaxActionContext;

/**
 * 异步控件处理对象接口
 * 
 * @author lionlau
 *
 */
public interface IAjaxControlHandler extends IAjaxHandler {

	/**
	 * 获取异步部件
	 * 
	 * @return
	 */
	IAjaxControl getAjaxControl();

	/**
	 * 处理
	 * 
	 * @param iControl
	 * @param iAjaxActionContext
	 * @return
	 * @throws Exception
	 */
	AjaxActionResult process(IControl iControl, IAjaxActionContext iAjaxActionContext) throws Exception;

}
