package net.ibizsys.paas.web.util;

import net.ibizsys.paas.appmodel.IApplicationModel;
import net.ibizsys.paas.util.StringHelper;

/**
 * 登出处理页面
 * 
 * @author Administrator
 *
 */
public class LogoutPage extends net.ibizsys.paas.web.Page {

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.Page#onInit()
	 */
	@Override
	protected void onInit() throws Exception {
		super.onInit();

		String strRetUrl = getWebContext().getParamValue("RU");
		// 执行登出
		this.getWebContext().logout(true);
		if (StringHelper.isNullOrEmpty(strRetUrl)) {
			strRetUrl = this.getApplicationModel().getUtilPageUrl(IApplicationModel.UTILPAGE_LOGIN);
			strRetUrl = mapRealPageUrl(strRetUrl);
		}
		this.getResponse().sendRedirect(strRetUrl);
	}

	@Override
	protected String mapRealPageUrl(String strPageUrl) throws Exception {
		if (strPageUrl.charAt(0) == '/') {
			return ".." + strPageUrl;
		}
		return strPageUrl;
	}

}
