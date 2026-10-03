package net.ibizsys.paas.controller;

import net.ibizsys.paas.appmodel.IApplicationRuntime;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.WebUtility;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.WebContext;

/**
 * Html视图控制器对象
 * 
 * @author Administrator
 *
 */
public abstract class HtmlViewControllerBase extends ViewControllerBase {
	
	/**
	 * Html路径
	 */
	public final static String VIEWPARAM_UI_HTMLURL = "UI.HTMLURL";
	
	/**
	 * Html路径配置键值
	 */
	public final static String VIEWPARAM_UI_HTMLURLKEY = "UI.HTMLURLKEY";
	
	public HtmlViewControllerBase() throws Exception {
		super();
	}

	
	@Override
	protected AjaxActionResult onLoadViewModel() throws Exception {

		AjaxActionResult ajaxActionResult =  super.onLoadViewModel();
		if(ajaxActionResult.isError()) {
			return ajaxActionResult;
		}
		//
		String strKey = WebContext.getKey(this.getWebContext());
		if(StringHelper.isNullOrEmpty(strKey)) {
			strKey = WebContext.getKeys(this.getWebContext());
		}
		if(strKey == null) {
			strKey = "";
		}
		
		String strHtmlUrl = (String)this.getAttribute(VIEWPARAM_UI_HTMLURL);
		String strHtmlUrlKey = (String)this.getAttribute(VIEWPARAM_UI_HTMLURLKEY);
		if(!StringHelper.isNullOrEmpty(strHtmlUrlKey)) {
			String strHtmlUrl2 = ((IApplicationRuntime)this.getAppModel()).getHtmlUrl(strHtmlUrlKey);
			if(!StringHelper.isNullOrEmpty(strHtmlUrl2)) {
				strHtmlUrl = strHtmlUrl2;
			}
		}
		if(!StringHelper.isNullOrEmpty(strHtmlUrl)) {
			strHtmlUrl = strHtmlUrl.replace("__SRFKEY__", WebUtility.encodeURLParamValue(strKey));
		}
		//下发路径
		ajaxActionResult.setExtAttr("viewurl", strHtmlUrl);
		return ajaxActionResult;
	}
}
