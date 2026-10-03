package net.ibizsys.paas.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.IWebContext;

/**
 * 应用注销视图控制器基类
 * 
 * @author Administrator
 *
 */
public abstract class AppLogoutViewControllerBase extends AppUtilViewControllerBase {

	private static final Log log = LogFactory.getLog(AppLogoutViewControllerBase.class);

	/**
	 * 视图后台请求：注销
	 */
	public final static String VIEWACTION_LOGOUT = "logout";
	
	

	public AppLogoutViewControllerBase() throws Exception {
		super();
	}

	
	@Override
	protected AjaxActionResult onViewAjaxAction(String strAction) throws Exception {
		if(StringHelper.compare(strAction, VIEWACTION_LOGOUT, true) == 0) {
			return onLogout();
		}
		return super.onViewAjaxAction(strAction);
	}

	/**
	 * 注销当前用户
	 * 
	 * @return
	 * @throws Exception
	 */
	protected void logoutUser(IWebContext iWebContext) throws Exception {
		iWebContext.logout(true);
	}
	
	
	protected AjaxActionResult onLogout()throws Exception{
		AjaxActionResult ajaxActionResult = new AjaxActionResult();
		
		logoutUser(this.getWebContext());
		
		return ajaxActionResult;
	}

	
}
