package net.ibizsys.psuac.web;

import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jasig.cas.client.validation.Assertion;

/**
 * 登录页面
 * 
 * @author Administrator
 * 
 */
public class LoginPage extends LoginPageBase
{
	private static final Log log = LogFactory.getLog(LoginPage.class);
	protected String strRedirectURL = "";
	
	public LoginPage()
	{
		
	}
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.web.Page#onInit()
	 */
	@Override
	protected void onInit() throws Exception
	{
		super.onInit();
		
		try
		{
			Assertion assertion = null;
			Object objCAS = this.getRequest().getAttribute(AuthenticationFilter.CONST_CAS_ASSERTION);
			if (objCAS == null)
				objCAS = this.getWebContext().getSessionValue(AuthenticationFilter.CONST_CAS_ASSERTION);
			if (objCAS != null && (objCAS instanceof Assertion))
			{
				assertion = (Assertion) objCAS;
			}
			if (assertion == null)
			{
				this.getResponse().sendRedirect(this.getWebContext().getParamValue("RU"));
				return;
			}

			String strLoginName = assertion.getPrincipal().getName();
			CallResult callResult = loginUserName(strLoginName);
			if(callResult.isError())
			{
				//登录出现错误
				strRedirectURL = "#"; //this.getWebContext().getWebExConfig().GetValue("SRFUAC","ERRORPATH","");
				String strErrorInfo = callResult.getErrorInfo();
				if(StringHelper.isNullOrEmpty(strErrorInfo))
					strErrorInfo = "用户登录帐户不存在，无法登入系统";
				strRedirectURL += WebContext.encodeURLParamValue(strErrorInfo);
			}
			
			if(!StringHelper.isNullOrEmpty(strRedirectURL))
			{
				this.getResponse().sendRedirect(strRedirectURL);
			}
			else
			{
				this.getResponse().sendRedirect(this.getWebContext().getParamValue("RU"));
			}
			return;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
