package net.ibizsys.paas.web.jquery;

import net.ibizsys.paas.appmodel.IAppViewModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.WebUtility;
import net.ibizsys.paas.web.AjaxActionResult;
import net.sf.json.JSONObject;

/**
 * JQuery 工作流重定向页面
 * 
 * @author Administrator
 *
 */
public class WFRedirectPage extends net.ibizsys.pswf.web.util.WFRedirectPage {

	@Override
	protected void sendBackAppViewModel(IAppViewModel iAppViewModel) throws Exception {
		JSONObject rdview = this.getApplicationModel().getAppPFHelper().getAppViewJSONObject(iAppViewModel);
		if (StringHelper.compare(this.getRequest().getMethod(), "POST", true) == 0) {
			AjaxActionResult ajaxActionResult = new AjaxActionResult();
			ajaxActionResult.setExtAttr("rdview", rdview);
			this.getWriter().write(ajaxActionResult.toJSONString());
			return;
		}

		String strViewUrl = rdview.optString("viewurl");
		if (strViewUrl.charAt(0) == '/') {
			strViewUrl = "../jsp" + strViewUrl;
		}

		strViewUrl = WebUtility.appendURLSeperator(strViewUrl);
		strViewUrl += this.getWebContext().getQueryString();
		this.getResponse().sendRedirect(strViewUrl);
		return;
	}
}
