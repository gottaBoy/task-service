package net.ibizsys.psuac.web;

import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.HttpServletBase;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.psrt.srv.common.entity.LoginAccount;
import net.ibizsys.psrt.srv.common.entity.OrgUser;
import net.ibizsys.psrt.srv.common.service.LoginAccountService;
import net.ibizsys.psrt.srv.common.service.OrgUserService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 登录处理Servlet处理基类
 * @author Administrator
 *
 */
public class LoginServletBase extends HttpServletBase {
	private static final Log log = LogFactory.getLog(LoginPageBase.class);

	
	/**
	 * 登录用户名称
	 * @param strUserName
	 * @return
	 * @throws Exception
	 */
	protected CallResult loginUserName(String strUserName)throws Exception
	{
		CallResult callResult = new CallResult();
		try
		{
			//根据账户查找登录账户
			LoginAccountService loginAccountService = (LoginAccountService)ServiceGlobal.getService(LoginAccountService.class);
			LoginAccount loginAccount = new LoginAccount();
			loginAccount.setLoginAccountName(strUserName.toLowerCase());
			if(loginAccountService.select(loginAccount, true))
			{
				WebContext.fillByLoginAccount(this.getWebContext(), loginAccount);
			}
				
			//根据账户查找登录账户
			OrgUserService orgUserService = (OrgUserService)ServiceGlobal.getService(OrgUserService.class);
			OrgUser orgUser = new OrgUser();
			orgUser.setOrgUserId(loginAccount.getUserId());
			if(orgUserService.get(orgUser, true))
			{
				WebContext.fillByOrgUser(this.getWebContext(), orgUser);
			}
			this.getWebContext().login(strUserName);
			
		}
		catch(Exception ex)
		{
			log.error(StringHelper.format("登录用户发生异常，%1$s",ex.getMessage()),ex);
			callResult.setRetCode(Errors.INTERNALERROR);
			callResult.setErrorInfo(ex.getMessage());
		}
		return callResult;
	}
}
