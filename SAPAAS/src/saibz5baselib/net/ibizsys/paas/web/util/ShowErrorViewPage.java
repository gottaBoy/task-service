package net.ibizsys.paas.web.util;

import net.ibizsys.paas.web.Page;

/**
 * 显示错误页面
 * 
 * @author Administrator
 *
 */
public class ShowErrorViewPage extends Page {
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.Page#onInit()
	 */
	@Override
	protected void onInit() throws Exception {
		super.onInit();
		String strErrorMsg = getWebContext().getParamValue("ERRORMSG");
		this.getPageContext().setAttribute("ERRORMSG", strErrorMsg);

	}

	/**
	 * 获取错误信息
	 * 
	 * @return
	 */
	public String getErrorMsg() {
		Object objErrorMsg = this.getPageContext().getAttribute("ERRORMSG");
		if (objErrorMsg == null) return null;
		return (String) objErrorMsg;
	}
}
