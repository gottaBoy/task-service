package net.ibizsys.paas.web.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.HttpServletBase;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.SDAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.psrt.srv.common.entity.LoginAccount;
import net.ibizsys.psrt.srv.common.entity.OrgUser;
import net.ibizsys.psrt.srv.common.service.LoginAccountService;
import net.ibizsys.psrt.srv.common.service.OrgUserService;
import net.sf.json.JSONObject;

/**
 * 远程登录Servlet处理对象
 * 
 * @author Administrator
 *
 */
public class LoginServlet extends HttpServletBase {

	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(LoginServlet.class);

	private static final String ACTION_GETCURUSERINFO = "getcuruserinfo";
	
	@Override
	protected AjaxActionResult onProcessAction() throws Exception {
		String strAction = WebContext.getAction(this.getWebContext());
		if(StringHelper.compare(strAction, ACTION_GETCURUSERINFO, true) == 0){
			return this.getCurUserInfo(this.getWebContext());
		}else{
			return doLogin(this.getWebContext());
		}
	}
	
	/**
	 * 用户登录操作
	 * @param webContext
	 * @return
	 */
	protected AjaxActionResult doLogin(IWebContext webContext){
		AjaxActionResult ajaxActionResult = new AjaxActionResult();

		String strLoginName = this.getWebContext().getPostValue("loginname");
		String strPassword = this.getWebContext().getPostValue("pwd");

		if (!StringHelper.isNullOrEmpty(strLoginName)) strLoginName = strLoginName.trim();
		if (!StringHelper.isNullOrEmpty(strPassword)) strPassword = strPassword.trim();
		if (StringHelper.isNullOrEmpty(strLoginName)) {
			ajaxActionResult.setRetCode(Errors.INPUTERROR);
			ajaxActionResult.setErrorInfo("登录帐户不能为空");
			return ajaxActionResult;
		}

		if (StringHelper.isNullOrEmpty(strPassword)) {
			ajaxActionResult.setRetCode(Errors.INPUTERROR);
			ajaxActionResult.setErrorInfo("登录密码不能为空");
			return ajaxActionResult;
		}

		try {
			LoginAccountService loginAccountService = (LoginAccountService) ServiceGlobal.getService(LoginAccountService.class);
			LoginAccount loginAccount = new LoginAccount();
			loginAccount.setLoginAccountName(strLoginName.toLowerCase());
			if (!loginAccountService.select(loginAccount, true)) {
				ajaxActionResult.setRetCode(Errors.INVALIDDATA);
				ajaxActionResult.setErrorInfo("登录帐户或密码不正确");
				return ajaxActionResult;
			}

			String strPassword2 = KeyValueHelper.genUniqueId(strLoginName.toLowerCase(), strPassword);
			if (StringHelper.compare(strPassword2, loginAccount.getPwd(), false) != 0) {
				ajaxActionResult.setRetCode(Errors.INVALIDDATA);
				ajaxActionResult.setErrorInfo("登录帐户或密码不正确");
				return ajaxActionResult;
			}

			// 登录成功
			this.getWebContext().logout(true);

			net.ibizsys.paas.web.WebContext.fillByLoginAccount(this.getWebContext(), loginAccount);

			// 尝试获取组织用户
			OrgUser orgUser = new OrgUser();
			orgUser.setOrgUserId(loginAccount.getUserId());
			OrgUserService orgUserService = (OrgUserService) ServiceGlobal.getService(OrgUserService.class);
			if (orgUserService.get(orgUser, true)) {
				net.ibizsys.paas.web.WebContext.fillByOrgUser(this.getWebContext(), orgUser);
			}

			this.getWebContext().login(strLoginName);
			return ajaxActionResult;

		} catch (Exception ex) {
			ajaxActionResult.setRetCode(Errors.INTERNALERROR);
			ajaxActionResult.setErrorInfo(ex.getMessage());
			log.error(ex);
			return ajaxActionResult;
		}
	}
	
	/**
	 * 获取当前登录用户信息
	 * @param webContext
	 * @return
	 */
	protected AjaxActionResult getCurUserInfo(IWebContext webContext){
		SDAjaxActionResult sdAjaxActionResult = new SDAjaxActionResult();

		if (!StringHelper.isNullOrEmpty(webContext.getCurUserId())) {
			JSONObject data = sdAjaxActionResult.getData(true);
			data.put("userid", JSONObjectHelper.stripQuotes(webContext.getCurUserId(),true));
			data.put("username", JSONObjectHelper.stripQuotes(webContext.getCurUserName(),true));
			data.put("loginname", JSONObjectHelper.stripQuotes(webContext.getCurLoginName(),true));
			data.put("localization", JSONObjectHelper.stripQuotes(webContext.getLocalization(),true));
			data.put("curusericonpath", JSONObjectHelper.stripQuotes(webContext.getCurUserIconPath(),true));
			data.put("orgid", JSONObjectHelper.stripQuotes(webContext.getCurOrgId(),true));
			data.put("orgname", JSONObjectHelper.stripQuotes(webContext.getCurOrgName(),true));
			data.put("orgsectorid", JSONObjectHelper.stripQuotes(webContext.getCurOrgSectorId(),true));
			data.put("orgsectorname", JSONObjectHelper.stripQuotes(webContext.getCurOrgSectorName(),true));
			data.put("orgsectorbc", JSONObjectHelper.stripQuotes(webContext.getCurOrgSectorBC(),true));
		}else{
			sdAjaxActionResult.setRetCode(Errors.INVALIDDATA);
			sdAjaxActionResult.setErrorInfo("无用户身份信息！");
		}
		return sdAjaxActionResult;
	}

}
