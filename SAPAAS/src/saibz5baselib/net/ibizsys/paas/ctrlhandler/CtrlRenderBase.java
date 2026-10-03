package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.web.AjaxActionResult;
import net.sf.json.JSONObject;

/**
 * 部件绘制器基类
 * 
 * @author Administrator
 *
 */
public abstract class CtrlRenderBase implements ICtrlRender {
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.ICtrlRender#filteAjaxActionResult(net.ibizsys.paas.web.AjaxActionResult, net.sf.json.JSONObject)
	 */
	@Override
	public void filteAjaxActionResult(AjaxActionResult ajaxActionResult, JSONObject jo) {

	}

}
