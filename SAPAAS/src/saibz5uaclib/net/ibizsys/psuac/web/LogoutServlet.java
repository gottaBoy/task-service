package net.ibizsys.psuac.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.WebUtility;
import net.ibizsys.paas.web.HttpServletBase;
import net.ibizsys.paas.web.IWebContext;

/**
 * 注销调用的Servlet
 * 
 * @author Administrator
 *
 */
public class LogoutServlet extends HttpServletBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Log log = LogFactory.getLog(LogoutServlet.class);

	/**
	 * 统一认证注销地址
	 */
	public final static String PARAM_LOGOUTURL = "LOGOUTURL";
	
	/**
	 * 统一认证注销地址2，有返回地址
	 */
	public final static String PARAM_LOGOUTURLWITHRU = "LOGOUTURLWITHRU";
	
	/**
	 * 当前服务器地址
	 */
	public final static String PARAM_SERVERNAME = "SERVERNAME";

	private String strLogoutUrl = null;

	private String strLogoutUrlWithRU = null;
	
	private String strServerName = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		this.strServerName = config.getInitParameter(PARAM_SERVERNAME);
		this.strLogoutUrl = config.getInitParameter(PARAM_LOGOUTURL);
		if (StringHelper.isNullOrEmpty(this.strLogoutUrl)) {
			log.warn(StringHelper.format("没有定义统一认证登出地址，只能完成本地注销"));
		}
		this.strLogoutUrlWithRU = config.getInitParameter(PARAM_LOGOUTURLWITHRU);
		if (StringHelper.isNullOrEmpty(this.strLogoutUrlWithRU)) {
			log.warn(StringHelper.format("没有定义统一认证登出地址（支持返回）"));
			this.strLogoutUrlWithRU = this.strLogoutUrl;
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.addTimeOutHeaders(response);

		try {
			IWebContext iWebContext = this.createWebContext(request, response);
			String strRU = iWebContext.getParamValue("RU");
			if(!StringHelper.isNullOrEmpty(strRU)){
				if(strRU.toLowerCase().indexOf("http") !=0){
					//转化路径
					if(strRU.indexOf("/")!=0){
						String path = strRU;
						String servletPath = request.getServletPath();
						String pathInfo = request.getPathInfo();
				        String requestPath = null;
						
				        if (pathInfo == null) {
				            requestPath = servletPath;
				        } else {
				            requestPath = servletPath + pathInfo;
				        }

				        int pos = requestPath.lastIndexOf('/');
				        String relative = null;
				        if (pos >= 0) {
			                relative = requestPath.substring(0, pos + 1) + path;
			            } else {
			                relative = requestPath + path;
			            }
				        
				        strRU = relative;
					}
					String strFile1 = new File( this.getServletContext().getRealPath("/")).getCanonicalPath();
					String strFile2 = this.getServletContext().getRealPath(strRU);
					strFile2 = new File(strFile2).getCanonicalPath();
					strFile2 = strFile2.substring(strFile1.length());
					strFile2 = strFile2.replace("\\", "/");
					strRU = this.strServerName + request.getContextPath()+strFile2;
				}
			}
			logoutUser(iWebContext);
			if(StringHelper.isNullOrEmpty(strRU)){
				response.sendRedirect(strLogoutUrl);
			}
			else{
				response.sendRedirect(this.strLogoutUrlWithRU + WebUtility.encodeURLParamValue(strRU));
			}
			return;

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
		}
	}

	
	/**
	 * 注销当前用户
	 * @return
	 * @throws Exception
	 */
	protected void logoutUser(IWebContext iWebContext )throws Exception
	{
		iWebContext.logout(true);
	}
	

}
