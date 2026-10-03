package net.ibizsys.paas.web;

import net.ibizsys.paas.core.ActionContext;
import net.ibizsys.paas.util.StringHelper;

/**
 * Http 异步请求操作上下文对象
 * 
 * @author lionlau
 *
 */
public class AjaxActionContext extends ActionContext implements IAjaxActionContext {
	protected AjaxActionResult ajaxActionResult = new AjaxActionResult();

	public AjaxActionContext(IWebContext iWebContext) {
		super(iWebContext);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IAjaxActionContext#getCtrlId()
	 */
	@Override
	public String getCtrlId() {
		return getRequestParam("SRFCTRLID");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IAjaxActionContext#getAction()
	 */
	@Override
	public String getAction() {
		return getRequestParam("SRFACTION");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IAjaxActionContext#getRequestParam(java.lang.String)
	 */
	@Override
	public String getRequestParam(String strParam) {
		String strValue = getWebContext().getPostValue(strParam.toLowerCase());
		if (strValue == null) strValue = getWebContext().getParamValue(strParam);
		if (StringHelper.isNullOrEmpty(strValue)) return null;
		return strValue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IAjaxActionContext#setCurAjaxActionResult(net.ibizsys.paas.web.AjaxActionResult)
	 */
	@Override
	public void setCurAjaxActionResult(AjaxActionResult ajaxActionResult) {
		this.ajaxActionResult = ajaxActionResult;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.IAjaxActionContext#getCurAjaxActionResult()
	 */
	@Override
	public AjaxActionResult getCurAjaxActionResult() {
		return this.ajaxActionResult;
	}

}
