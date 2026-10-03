package net.ibizsys.paas.web.util;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.security.RemoteLoginGlobal;
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
import net.ibizsys.psrt.srv.common.entity.LoginLog;
import net.ibizsys.psrt.srv.common.entity.OrgUser;
import net.ibizsys.psrt.srv.common.service.LoginAccountService;
import net.ibizsys.psrt.srv.common.service.LoginLogService;
import net.ibizsys.psrt.srv.common.service.OrgUserService;
import net.sf.json.JSONObject;

/**
 * 远程登录
 * 
 * @author Administrator
 * 
 */
public class RemoteLoginServlet extends HttpServletBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Log log = LogFactory.getLog(RemoteLoginServlet.class);

	private HashMap<String, Integer> loginFaildMap = new HashMap<String, Integer>();
	private HashMap<String, Long> loginFaildTimeMap = new HashMap<String, Long>();

	/**
	 * 获取指定账户及地址登录失败次数
	 * 
	 * @param 登录名称
	 * @param 远程登录地址
	 * @return
	 */
	protected int getLoginFailedCount(String strLoginName, String strRemoteAddr) {
		synchronized (loginFaildMap) {
			Integer nCount = loginFaildMap.get(strRemoteAddr);
			if (nCount == null) return 0;

			if (nCount >= 3) {
				long nLastTime = loginFaildTimeMap.get(strRemoteAddr);
				if (System.currentTimeMillis() - nLastTime >= 60000) {
					loginFaildTimeMap.remove(strRemoteAddr);
					loginFaildMap.remove(strRemoteAddr);
					return 0;
				}
			}

			return nCount;
		}
	}

	/**
	 * 增加登录失败次数
	 * 
	 * @param 登录名称
	 * @param 远程登录地址
	 * @return 当前失败次数
	 */
	protected int addLoginFailedCount(String strLoginName, String strRemoteAddr) {
		synchronized (loginFaildMap) {
			Integer nCount = loginFaildMap.get(strRemoteAddr);
			if (nCount == null) nCount = 0;
			nCount += 1;
			loginFaildMap.put(strRemoteAddr, nCount);
			loginFaildTimeMap.put(strRemoteAddr, System.currentTimeMillis());
			return nCount;
		}
	}

	/**
	 * 重置登录失败次数
	 * 
	 * @return
	 */
	protected void resetLoginFailedCount(String strLoginName, String strRemoteAddr) {
		synchronized (loginFaildMap) {
			loginFaildMap.remove(strRemoteAddr);
			loginFaildTimeMap.remove(strRemoteAddr);

		}
	}

	@Override
	protected AjaxActionResult onProcessAction() throws Exception {
		SDAjaxActionResult ajaxActionResult = new SDAjaxActionResult();

		String strLoginName = this.getWebContext().getPostOrParamValue("username");
		String strPassword = this.getWebContext().getPostOrParamValue("password");
		String strRemoteAddr = this.getWebContext().getRemoteAddr();

		try {
			int nFailedCount = getLoginFailedCount(strLoginName, strRemoteAddr);
			if (nFailedCount >= 3) {
				ajaxActionResult.setRetCode(Errors.ACCESSDENY);
				ajaxActionResult.setErrorInfo("登录失败次数超过3次，临时限制登录60秒");
				return ajaxActionResult;
			}

			if (StringHelper.isNullOrEmpty(strLoginName)) {
				ajaxActionResult.setRetCode(Errors.INPUTERROR);
				ajaxActionResult.setErrorInfo("登录帐户或密码不正确，清重新输入");
				return ajaxActionResult;
			}

			LoginAccountService loginAccountService = (LoginAccountService) ServiceGlobal.getService(LoginAccountService.class);
			LoginAccount loginAccount = new LoginAccount();
			loginAccount.setLoginAccountName(strLoginName.toLowerCase());
			if (!loginAccountService.select(loginAccount, true)) {
				ajaxActionResult.setRetCode(Errors.INPUTERROR);
				ajaxActionResult.setErrorInfo("登录帐户或密码不正确，清重新输入");
				addLoginFailedCount(strLoginName, strRemoteAddr);
				return ajaxActionResult;
			}

			String strPassword2 = KeyValueHelper.genUniqueId(strLoginName.toLowerCase(), strPassword);
			if (StringHelper.compare(strPassword2, loginAccount.getPwd(), false) != 0) {
				ajaxActionResult.setRetCode(Errors.INPUTERROR);
				ajaxActionResult.setErrorInfo("登录帐户或密码不正确，清重新输入");
				addLoginFailedCount(strLoginName, strRemoteAddr);
				return ajaxActionResult;
			}

			resetLoginFailedCount(strLoginName, strRemoteAddr);

			LoginLog loginLog = new LoginLog();
			loginLog.setIpAddress(strRemoteAddr);
			loginLog.setLoginAccountId(loginAccount.getLoginAccountId());
			loginLog.setLoginAccountName(loginAccount.getLoginAccountName());
			loginLog.setLoginLogName(loginAccount.getLoginAccountName());
			loginLog.setLoginTime(new java.sql.Timestamp(System.currentTimeMillis()));
			loginLog.setIpAddress(strRemoteAddr);
			loginLog.setUserAgent(this.getWebContext().getUserAgent());

			LoginLogService loginLogService = (LoginLogService) ServiceGlobal.getService(LoginLogService.class);
			loginLogService.create(loginLog);

			loginLog.set("userid", loginAccount.getUserId());
			loginLog.set("username", loginAccount.getUserName());

			JSONObject data = ajaxActionResult.getData(true);
			data.put("loginkey", JSONObjectHelper.stripQuotes(loginLog.getLoginLogId(),true));
			data.put("userid", JSONObjectHelper.stripQuotes(loginAccount.getUserId(),true));
			data.put("username", JSONObjectHelper.stripQuotes(loginAccount.getUserName(),true));
			data.put("usermode", "");
			data.put("loginname", JSONObjectHelper.stripQuotes(strLoginName,true));
			data.put("language",JSONObjectHelper.stripQuotes( loginAccount.getLanguage(),true));

			if (DataObject.getBoolValue(loginAccount.getSuperUser(), false)) {
				loginLog.set(IWebContext.SUPERUSER, "1");
			} else {
				loginLog.set(IWebContext.SUPERUSER, "0");
			}

			if (DataObject.getBoolValue(loginAccount.getOrgAdmin(), false)) {
				loginLog.set(IWebContext.ORGADMIN, "1");
			} else {
				loginLog.set(IWebContext.ORGADMIN, "0");
			}

			RemoteLoginGlobal.setUserLoginLog(loginAccount.getUserId(), loginLog);

			WebContext.fillByLoginAccount(this.getWebContext(), loginAccount);

			//根据账户查找登录账户
			OrgUserService orgUserService = (OrgUserService)ServiceGlobal.getService(OrgUserService.class);
			OrgUser orgUser = new OrgUser();
			orgUser.setOrgUserId(loginAccount.getUserId());
			if(orgUserService.get(orgUser, true))
			{
				WebContext.fillByOrgUser(this.getWebContext(), orgUser);
			}
			this.getWebContext().login(strLoginName);
			
			return ajaxActionResult;

		} catch (Exception ex) {
			log.error(StringHelper.format("处理远程登录发生异常，%1$s", ex.getMessage()), ex);
			ajaxActionResult.setRetCode(Errors.INTERNALERROR);
			ajaxActionResult.setErrorInfo("系统内部发生错误");
			return ajaxActionResult;
		}

	}
	
	
	

}
