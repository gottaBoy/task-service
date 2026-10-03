package net.ibizsys.paas.web;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.sysmodel.BackendServiceMgr;
import net.ibizsys.paas.util.GlobalContext;
import net.ibizsys.paas.util.IGlobalContext;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.SystemRTHelper;
import net.ibizsys.paas.util.WebUtility;

/**
 * Http 过滤器
 * 
 * @author Administrator
 */
public class WebFilter implements Filter {
	
	/**
	 * 安装的数据库模型清单
	 */
	public final static String ATTR_INSTALLDBMODELS = "INSTALLDBMODELS";
	
	class GlobalContext2 extends GlobalContext {
		public GlobalContext2(ServletContext servletContext) {
			this.servletContext = servletContext;

		}

		public void setCurrent(IGlobalContext iGlobalContext) {
			GlobalContext.globalContext = iGlobalContext;
		}

		// /**
		// * 设置动态模型存储对象
		// * @param iDynamicModelStorage
		// */
		// public void setDynamicModelStorage(IDynamicModelStorage iDynamicModelStorage)
		// {
		// this.iDynamicModelStorage = iDynamicModelStorage;
		// }

		public void init() throws Exception {
			this.onInit();
		}
	}

	protected FilterConfig filterConfig;

	protected boolean bEncrypt = true;

	protected String strRootPath = "";

	private static Log log = LogFactory.getLog(WebFilter.class);

	private WebConfig webConfig = null;

	private boolean bAuthFilter = false;

	private String strAuthPath = "";

	protected HashMap<String, Integer> unauthpathMap = new HashMap<String, Integer>();

	public final static String RESPONSE_REDIRECT = "SRF_RESPONSE_REDIRECT";

	/**
	 * 服务器名称
	 */
	protected String strServerName = "";

	protected HashMap<String, String> authPathMap = new HashMap<String, String>();

	public WebFilter() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig config) {
		// 输出版本信息
		this.filterConfig = config;
		webConfig = createWebConfig();

		// 计算配置路径
		strRootPath = webConfig.getAttribute("APPPATH", "");
		if (StringHelper.isNullOrEmpty(strRootPath)) strRootPath = filterConfig.getServletContext().getRealPath("/");

		if (!StringHelper.isNullOrEmpty(strRootPath)) {
			char ch = strRootPath.charAt(strRootPath.length() - 1);
			if (ch != File.separatorChar) {
				strRootPath += File.separator;
			}
		}

		try {
			LocalSessionStorage.getCurrent(this.filterConfig.getServletContext());

			GlobalContext2 globalContext2 = new GlobalContext2(this.filterConfig.getServletContext());
			globalContext2.setCurrent(globalContext2);
			globalContext2.init();

			this.prepareAuthFilter();

			String strInstallDBModels = this.filterConfig.getInitParameter(ATTR_INSTALLDBMODELS);
			if(!StringHelper.isNullOrEmpty(strInstallDBModels)){
				SystemRTHelper.installDBModel(strInstallDBModels, false);
			}
			
			//安装动态系统
			SystemRTHelper.installDynaSys();
			 
		} catch (Exception e) {
			log.equals(e);
			e.printStackTrace();
		}

		outputVersionInfo();

		// 启动后台服务
		startBackendService();

		// 执行外部初始化
		onInit();
	}
	
	/**
	 * 建立Web配置对象
	 * @return
	 * @throws Exception
	 */
	protected WebConfig createWebConfig(){
		return new WebConfig(this.filterConfig);
	}

	/**
	 * 启动后台服务对象
	 */
	protected void startBackendService() {
		String strServiceContainerId = webConfig.getServiceContainer();
		if (StringHelper.isNullOrEmpty(strServiceContainerId)) return;
		log.info(StringHelper.format("初始化后台服务容器[%1$s]", strServiceContainerId));
		try {
			BackendServiceMgr backendServiceMgr = BackendServiceMgr.createInstance(strServiceContainerId);
		} catch (Exception ex) {
			log.error(StringHelper.format("初始化后台服务容器[%1$s]发生异常，%2$s", strServiceContainerId, ex.getMessage()), ex);
		}
	}

	/**
	 * 输出相关包版本信息
	 */
	protected void outputVersionInfo() {
		log.info(String.format("SA iBizSys Runtime [%1$s]", net.ibizsys.paas.Version.toVersionString()));
		// log.info(String.format("SA iBizsys WF Runtime [%1$s]", net.ibizsys.paas.common.Version.outputInfo()));
	}

	/**
	 * 初始化
	 */
	protected void onInit() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		onDestroy();

		log.info("WebFilter destroy");
		this.filterConfig = null;
	}

	/**
	 * 卸载
	 */
	protected void onDestroy() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	final public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest curRequest = (HttpServletRequest) request;
		HttpServletResponse curResponse = (HttpServletResponse) response;
		String strRequestURL = curRequest.getRequestURL().toString();
		int nPos = strRequestURL.lastIndexOf(".jsp"); // 最后一个/
		if (nPos != -1) {
			if (nPos == strRequestURL.length() - 4) {
				if (!doPageFilter(curRequest, curResponse)) return;

			}
		}
		filterChain.doFilter(request, response);
	}

	/**
	 * 进行页面过滤
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 * @throws ServletException
	 */
	protected boolean doPageFilter(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// 界面页面检查
		if (this.bAuthFilter) {
			if (request.getSession().getAttribute(IWebContext.PERSONID) == null) {
				String strCurPath = request.getRequestURL().toString();
				String strContextPath = request.getContextPath();
				String strServerName2 = request.getServerName();
				int nStartPos = strCurPath.indexOf(strServerName2);
				if (nStartPos != -1) {
					nStartPos = nStartPos + strServerName2.length();
				} else
					nStartPos = 0;

				int nContextPathPos = strCurPath.indexOf(strContextPath, nStartPos);
				if (nContextPathPos != -1) {
					strCurPath = strCurPath.substring(nContextPathPos + strContextPath.length());
				}

				if (!unauthpathMap.containsKey(strCurPath)) {
					// 进行重定向处理
					try {
						request.setAttribute(RESPONSE_REDIRECT, 1);

						boolean bDirectLogin = false;
						int nPos = strCurPath.lastIndexOf("backend.jsp"); // 最后一个
						if (nPos != -1) {
							// 后台页面
							String strActionType = request.getParameter("srfactiontype");
							if (StringHelper.isNullOrEmpty(strActionType)) {
								strActionType = request.getParameter("actiontype");
							}
							if (!StringHelper.isNullOrEmpty(strActionType)) {
								nPos = strCurPath.lastIndexOf("modelbackend.jsp");
								if (nPos == -1) {
									if (StringHelper.compare(strActionType, "formaction", true) == 0) {
										response.sendRedirect("../uacclient/uaclogin_formaction.jsp");
										return false;
									}

									if (StringHelper.compare(strActionType, "gridaction", true) == 0) {
										response.sendRedirect("../uacclient/uaclogin_gridaction.jsp");
										return false;
									}

									response.sendRedirect("../uacclient/uaclogin_backendaction.jsp");
									return false;
								} else {

									if (StringHelper.compare(strActionType, "formaction", true) == 0) {
										response.sendRedirect("../uacclient/uaclogin_formaction2.jsp");
										return false;
									}

									if (StringHelper.compare(strActionType, "gridaction", true) == 0) {
										response.sendRedirect("../uacclient/uaclogin_gridaction2.jsp");
										return false;
									}

									response.sendRedirect("../uacclient/uaclogin_backendaction2.jsp");
									return false;
								}
							}
						} else {
							nPos = strCurPath.lastIndexOf("/uacclient/uaclogin_popup.jsp"); // 最后一个/
							if (nPos != -1) {
								bDirectLogin = true;
							}
						}

						String strRequestUrl = "";
						if (StringHelper.isNullOrEmpty(strServerName)) {
							strRequestUrl = request.getRequestURL().toString();
						} else {
							// 合成当前的路径
							strRequestUrl = strServerName + strContextPath + strCurPath;
						}

						String strQueryString = request.getQueryString();
						String strParams = "";
						if (StringHelper.isNullOrEmpty(strQueryString)) {
							// 修改主机头
							strParams = WebUtility.encodeURLParamValue(strRequestUrl) + (bDirectLogin ? "&DIRECT=TRUE" : "");
						} else
							strParams = WebUtility.encodeURLParamValue(strRequestUrl + "?" + request.getQueryString()) + (bDirectLogin ? "&DIRECT=TRUE" : "");

						String strAuthPath = authPathMap.get(request.getServerName().toUpperCase());
						if (StringHelper.isNullOrEmpty(strAuthPath)) strAuthPath = this.strAuthPath;
						response.sendRedirect(strAuthPath + strParams);
					} catch (IOException e) {
						e.printStackTrace();
					}
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * 准备过滤配置器
	 */
	private void prepareAuthFilter() throws Exception {
		// 判断是否加载
		String strAuthFilter = this.filterConfig.getInitParameter("AUTHFILTER");
		if (!StringHelper.isNullOrEmpty(strAuthFilter)) {
			this.bAuthFilter = (StringHelper.compare(strAuthFilter, "TRUE", true) == 0);
			this.strAuthPath = this.filterConfig.getInitParameter("AUTHPATH");
			if (StringHelper.isNullOrEmpty(strAuthPath)) {
				this.bAuthFilter = false;
				log.warn("没有指定认证路径，不启用认证过滤");
			}
		}

		if (this.bAuthFilter) {
			unauthpathMap.put("/srfapp/remotecall.jsp", 1);
			unauthpathMap.put("/commonex/accessdeny_major.jsp", 1);
			unauthpathMap.put("/commonex/accessdeny_minor.jsp", 1);
			unauthpathMap.put("/commonex/showerror.jsp", 1);
			unauthpathMap.put("/uacclient/uaclogin2.jsp", 1);
			unauthpathMap.put("/uacclient/uaclogin.jsp", 1);
			unauthpathMap.put("/uacclient/uaclogin3.jsp", 1);
			unauthpathMap.put("/uacclient/uaclogin4.jsp", 1);
			unauthpathMap.put("/uacclient/uacremotelogin.jsp", 1);
			unauthpathMap.put("/uacclient/uaclogout.jsp", 1);
			unauthpathMap.put("/uacclient/uaclogin_formaction.jsp", 1);
			unauthpathMap.put("/uacclient/uaclogin_gridaction.jsp", 1);
			unauthpathMap.put("/uacclient/uaclogin_pagemodel.jsp", 1);
			unauthpathMap.put("/uacclient/uaclogin_formaction2.jsp", 1);
			unauthpathMap.put("/uacclient/uaclogin_gridaction2.jsp", 1);
			unauthpathMap.put(strAuthPath, 1);

			if ((this.strAuthPath.indexOf("http") != 0) && (this.strAuthPath.indexOf("..") != 0)) {
				this.strAuthPath = ".." + this.strAuthPath;
				this.strAuthPath = WebUtility.appendURLSeperator(this.strAuthPath);
				this.strAuthPath += "RU=";
			}

			String strAuthServer = this.filterConfig.getInitParameter("AUTHSERVER");
			if (!StringHelper.isNullOrEmpty(strAuthServer)) {
				strAuthServer = strAuthServer.toUpperCase();
				String[] authServers = strAuthServer.split("[|]");
				for (String strAuthServerItem : authServers) {
					String strAuthPath = this.filterConfig.getInitParameter("AUTHPATH_" + strAuthServerItem.replace(".", "_"));
					if (StringHelper.isNullOrEmpty(strAuthPath)) {
						continue;
					} else {
						if ((strAuthPath.indexOf("http") != 0) && (strAuthPath.indexOf("..") != 0)) {
							strAuthPath = ".." + strAuthPath;
							strAuthPath = WebUtility.appendURLSeperator(strAuthPath);
							strAuthPath += "RU=";
						}
						authPathMap.put(strAuthServerItem, strAuthPath);
					}
				}
			}
		}
	}
}
