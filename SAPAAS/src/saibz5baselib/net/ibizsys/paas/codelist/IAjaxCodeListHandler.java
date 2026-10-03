package net.ibizsys.paas.codelist;

import net.ibizsys.paas.ajax.IAjaxHandler;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.IAjaxActionContext;

/**
 * 代码表后台处理对象
 * 
 * @author Administrator
 *
 */
public interface IAjaxCodeListHandler extends IAjaxHandler {

	/**
	 * 获取代码表
	 * 
	 * @return
	 */
	ICodeList getCodeList();

	/**
	 * 处理
	 * 
	 * @param iCodeList 代码表
	 * @param iAjaxActionContext 请求上下文
	 * @return
	 * @throws Exception
	 */
	AjaxActionResult process(ICodeList iCodeList, IAjaxActionContext iAjaxActionContext) throws Exception;

}
