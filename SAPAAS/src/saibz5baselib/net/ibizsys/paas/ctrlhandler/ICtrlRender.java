package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.web.AjaxActionResult;
import net.sf.json.JSONObject;

/**
 * 控件绘制器接口
 * 
 * @author Administrator
 *
 */
public interface ICtrlRender {
	
	/**
	 * 过滤异步操作结果
	 * 
	 * @param ajaxActionResult
	 * @param jo
	 * @throws Exception
	 */
	void filteAjaxActionResult(AjaxActionResult ajaxActionResult, JSONObject jo);

}
