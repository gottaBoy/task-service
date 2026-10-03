package net.ibizsys.psuac.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jasig.cas.client.validation.Assertion;

/**
 * 登录处理Servlet
 * 
 * @author Administrator
 *
 */
public class LoginServlet extends LoginServletBase {

	private static final Log log = LogFactory.getLog(LoginPage.class);
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strRedirectURL = "";
		try
		{
			IWebContext iWebContext = this.createWebContext(request, response);
			WebContext.setCurrent(iWebContext);

			Assertion assertion = null;
			Object objCAS = request.getAttribute(AuthenticationFilter.CONST_CAS_ASSERTION);
			if (objCAS == null)
				objCAS = this.getWebContext().getSessionValue(AuthenticationFilter.CONST_CAS_ASSERTION);
			if (objCAS != null && (objCAS instanceof Assertion))
			{
				assertion = (Assertion) objCAS;
			}
			if (assertion == null)
			{
				response.sendRedirect(this.getWebContext().getParamValue("RU"));
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
				response.sendRedirect(strRedirectURL);
			}
			else
			{
				response.sendRedirect(this.getWebContext().getParamValue("RU"));
			}
			return;
		}
		catch (Exception ex)
		{
			log.error(ex);
		}
	}

}
