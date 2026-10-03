package net.ibizsys.paas.web.jquery;

import net.ibizsys.paas.appmodel.IAppViewModel;
import net.ibizsys.paas.controller.IRedirectViewController;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.WebUtility;
import net.ibizsys.paas.web.VCPage;
import net.sf.json.JSONObject;

/**
 * JQuery 重定向视图控制器页面
 * 
 * @author Administrator
 *
 */
public class RedirectVCPage extends VCPage {

	@Override
	protected void onInit() throws Exception {
		super.onInit();

		String strKeyValue = this.getWebContext().getParamValue("srfkey");
		if (StringHelper.isNullOrEmpty(strKeyValue)) {
			strKeyValue = this.getWebContext().getParamValue("srfkeys");
		}

		if (StringHelper.isNullOrEmpty(strKeyValue)) {
			throw new Exception(StringHelper.format("没有指定视图数据主键"));
		}

		IRedirectViewController iRedirectViewController = (IRedirectViewController) this.getViewController();
		IAppViewModel iAppViewModel = iRedirectViewController.getRDAppViewModel(strKeyValue);
		JSONObject rdview = this.getApplicationModel().getAppPFHelper().getAppViewJSONObject(iAppViewModel);

		String strViewUrl = rdview.optString("viewurl");
		if (strViewUrl.charAt(0) == '/') {
			strViewUrl = ".." + strViewUrl;
		}

		strViewUrl = WebUtility.appendURLSeperator(strViewUrl);
		strViewUrl += this.getWebContext().getQueryString();
		this.getResponse().sendRedirect(strViewUrl);

	}

}
