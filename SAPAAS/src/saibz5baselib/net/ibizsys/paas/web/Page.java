package net.ibizsys.paas.web;

import java.io.Writer;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

import net.ibizsys.paas.appmodel.AppModelGlobal;
import net.ibizsys.paas.appmodel.IApplicationModel;
import net.ibizsys.paas.db.DataSetCache;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.security.AccessUserModes;
import net.ibizsys.paas.security.RemoteLoginGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.ObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.WebUtility;
import net.ibizsys.psrt.srv.common.entity.LoginLog;

/**
 * 页面对象
 * 
 * @author lionlau
 * 
 */
public class Page {
	private static final Log log = LogFactory.getLog(Page.class);
	private boolean bNoCache = true;
	private ThreadLocal<SessionFactory> sessionFactory = new ThreadLocal<SessionFactory>();
	private ThreadLocal<PageContext> pageContext = new ThreadLocal<PageContext>();
	private IDataEntityModel iDataEntityModel = null;
	private ThreadLocal<Boolean> bInitResult = new ThreadLocal<Boolean>();
	private static ThreadLocal<Page> curPage = new ThreadLocal<Page>();
	
	/**
	 * 视图访问用户模式
	 */
	private int nAccessUserMode = AccessUserModes.ALLUSER;

	/**
	 * 视图访问标识
	 */
	private String strAccessKey = null;

	public Page() {

	}

	/**
	 * 初始化页面对象
	 * 
	 * @param context
	 */
	final public boolean init(PageContext context) throws Exception {
		
		pageContext.set(context);
		bInitResult.set(true);
		curPage.set(this);
		SessionFactoryManager.enter();
		if (isNoCache()) {
			this.getResponse().addHeader("cache-control", "no-cache");
			this.getResponse().addHeader("expires", "thu, 01 jan 1970 00:00:01 gmt");
		}

		IWebContext iWebContext = this.createWebContext(this.getRequest(), this.getResponse());
		WebContext.setCurrent(iWebContext);
		if (!this.testUserAccess()) {
			resetCurrent();
			return false;
		}

		// 20161007添加，为页面对象提供默认应用程序过滤能力
		IApplicationModel iApplicationModel = this.getApplicationModel();
		if (iApplicationModel != null) {
			if (iApplicationModel.doFilter(this, this.getRequest(), this.getResponse())) {
				resetCurrent();
				return getInitResult();
			}
		}
		// 20161007添加结束

		try {
			DataSetCache.enableCurrent();
			this.onInit();
		} catch (Exception ex) {
			resetCurrent();
			throw ex;
		}
		return getInitResult();
	}

	/**
	 * 重置当前页面变量
	 */
	protected void resetCurrent() {
		this.setSessionFactory(null);
		WebContext.setCurrent(null);
		DataSetCache.resetCurrent();
		pageContext.set(null);
		SessionFactoryManager.leave();
	}

	/**
	 * 建立网络访问上下文
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	protected IWebContext createWebContext(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		IApplicationModel iApplicationModel = this.getApplicationModel();
		if(iApplicationModel!=null)
			return iApplicationModel.createWebContext(null, request, response);
		else{
			if (StringHelper.isNullOrEmpty(WebConfig.getCurrent().getWebContextObj())) {
				IWebContext iWebContext = new WebContext();
				iWebContext.init(request, response, request.getSession().getServletContext());
				doRemoteLogin(iWebContext);
				return iWebContext;
			} else {
				IWebContext iWebContext = (IWebContext) ObjectHelper.create(WebConfig.getCurrent().getWebContextObj());
				iWebContext.init(request, response, request.getSession().getServletContext());
				doRemoteLogin(iWebContext);
				return iWebContext;
			}
		}
	}

	/**
	 * 执行远程登录处理
	 * 
	 * @param iWebContext
	 * @throws Exception
	 */
	protected void doRemoteLogin(IWebContext iWebContext) throws Exception {
		if (!StringHelper.isNullOrEmpty(iWebContext.getCurUserId())) return;

		String strLoginKey = WebContext.getLoginKey(iWebContext);
		if (StringHelper.isNullOrEmpty(strLoginKey)) {
			return;
		}

		LoginLog loginLog = RemoteLoginGlobal.getLoginLog(strLoginKey);
		if (loginLog == null) {
			return;
		}

		iWebContext.remoteLogin(loginLog);
	}

	/**
	 * 初始化页面
	 * 
	 * @throws Exception
	 */
	protected void onInit() throws Exception {

	}

	/**
	 * 获取网页流输出对象
	 * 
	 * @return
	 */
	final public Writer getWriter() {
		return getPageContext().getOut();
	}

	/**
	 * 获取网页请求对象
	 * 
	 * @return
	 */
	final public HttpServletRequest getRequest() {
		return (HttpServletRequest) getPageContext().getRequest();
	}

	/**
	 * 获取网页响应对象
	 * 
	 * @return
	 */
	final public HttpServletResponse getResponse() {
		return (HttpServletResponse) getPageContext().getResponse();
	}

	/**
	 * 获取页面是否启用缓存
	 * 
	 * @return
	 */
	public boolean isNoCache() {
		return this.bNoCache;
	}

	/**
	 * 设置页面是否启用缓存
	 * 
	 * @param bNoCache
	 */
	protected void setNoCache(boolean bNoCache) {
		this.bNoCache = bNoCache;
	}

	/**
	 * 获取当前网络请求上下文对象
	 * 
	 * @return
	 */
	public IWebContext getWebContext() {
		return WebContext.getCurrent();
	}

	/**
	 * 获取当前页面上下文对象
	 * 
	 * @return
	 */
	final public PageContext getPageContext() {
		return this.pageContext.get();
	}

	/**
	 * 设置会话工厂
	 * 
	 * @param sessionFactory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory.set(sessionFactory);
	}

	/**
	 * 获取会话工厂
	 * 
	 * @return
	 */
	public SessionFactory getSessionFactory() {
		return this.sessionFactory.get();
	}

	/**
	 * 是否为嵌入模式（内容嵌入）
	 * 
	 * @return
	 */
	public boolean isEmbed() {
		return !StringHelper.isNullOrEmpty(getContainerId());
	}

	/**
	 * 是否为嵌入模式（IFrame嵌入）
	 * 
	 * @return
	 */
	public boolean isIFChild() {
		if (StringHelper.compare(this.getWebContext().getParamValue(WebContext.PARAM_IFCHILD), "TRUE", true) == 0) return true;
		return false;
	}

	/**
	 * 获取容器编号
	 * 
	 * @return
	 */
	public String getContainerId() {
		return WebContext.getContainerId();
	}

	/**
	 * 输出容器编号（如果有容器编号，则附加"_"）
	 * 
	 * @return
	 */
	public String getCId() {
		if (StringHelper.isNullOrEmpty(getContainerId())) {
			return "";
		} else {
			return StringHelper.format("%1$s_", this.getContainerId());
		}
	}

	/**
	 * 输出容器层级
	 * 
	 * @return
	 */
	public String getCLevel() {
		String strContainerLevel = WebContext.getContainerLevel();
		if (StringHelper.isNullOrEmpty(strContainerLevel)) {
			return "";
		} else {
			return strContainerLevel;
		}
	}

	/**
	 * 判断用户是否允许访问当前页面
	 * 
	 * @return
	 * @throws Exception
	 */
	protected boolean testUserAccess() throws Exception {
		String strPersonId = this.getWebContext().getCurUserId();
		if (StringHelper.isNullOrEmpty(strPersonId)) {
			// 匿名用户
			if ((this.getAccessUserMode() & AccessUserModes.ANONYMOUS) > 0) {
				return true;
			}
			// 要求登录
			String strPath = this.getRequest().getRequestURL().toString() + "?" + this.getRequest().getQueryString();
			HashMap<String, String> urlParamMap = new HashMap<String, String>();
			urlParamMap.put("RU", strPath);
			sendRedirect(IApplicationModel.UTILPAGE_LOGIN, urlParamMap);
			return false;
		} else {
			if(this.getWebContext().isCurUserPasswordExpired()){
				//要求修改密码
				String strPath = this.getRequest().getRequestURL().toString() + "?" + this.getRequest().getQueryString();
				HashMap<String, String> urlParamMap = new HashMap<String, String>();
				urlParamMap.put("RU", strPath);
				sendRedirect(IApplicationModel.UTILPAGE_PASSWORDEXPIRED, urlParamMap);
				return false;
			}
			
			// 匿名用户
			if ((this.getAccessUserMode() & AccessUserModes.LOGINUSER) > 0) {
				return true;
			}

			if ((this.getAccessUserMode() & AccessUserModes.LOGINUSERWITHKEY) > 0) {
				if (this.getWebContext().getUserPrivilegeMgr().test(this.getWebContext(), this.getAccessKey())) return true;
			}
		}

		sendRedirect(IApplicationModel.UTILPAGE_ACCESSDENY, null);
		return false;
	}

	/**
	 * 设置页面的实体模型对象
	 * 
	 * @param iDataEntityModel
	 */
	protected void setDEModel(IDataEntityModel iDataEntityModel) {
		this.iDataEntityModel = iDataEntityModel;
	}

	/**
	 * 获取页面的实体模型对象
	 * 
	 * @return
	 */
	public IDataEntityModel getDEModel() {
		return this.iDataEntityModel;
	}

	/**
	 * 获取本地化语言
	 * 
	 * @return
	 */
	public String getLocalization() {
		return WebContext.getCurrent().getLocalization();
	}

	/**
	 * 获取视图的访问用户模式
	 * 
	 * @return
	 */
	public int getAccessUserMode() {
		return this.nAccessUserMode;
	}

	/**
	 * 设置访问用户模式
	 * 
	 * @param nAccessUserMode
	 */
	public void setAccessUserMode(int nAccessUserMode) {
		this.nAccessUserMode = nAccessUserMode;
	}

	/**
	 * 获取视图的访问标识
	 * 
	 * @return
	 */
	public String getAccessKey() {
		return this.strAccessKey;
	}

	/**
	 * 设置视图的访问标识
	 * 
	 * @return
	 */
	public void setAccessKey(String strAccessKey) {
		this.strAccessKey = strAccessKey;
	}

	/**
	 * 发送重定向视图命令
	 * 
	 * @param strPageType
	 * @param urlParamMap
	 * @throws Exception
	 */
	protected void sendRedirect(String strPageType, HashMap<String, String> urlParamMap) throws Exception {
		IApplicationModel appModel = getApplicationModel();
		String strPageUrl = appModel.getUtilPageUrl(strPageType);
		strPageUrl = mapRealPageUrl(strPageUrl);
		if (urlParamMap != null) {
			String strQueryString = WebUtility.getQueryString(urlParamMap);
			strPageUrl = WebUtility.appendURLSeperator(strPageUrl);
			strPageUrl += strQueryString;
		}
		this.getResponse().sendRedirect(strPageUrl);
	}

	/**
	 * 映射传入页面路径的实际路径
	 * 
	 * @param strPageUrl
	 * @return
	 * @throws Exception
	 */
	protected String mapRealPageUrl(String strPageUrl) throws Exception {
		return strPageUrl;
	}

	/**
	 * 获取当前应用程序
	 * 
	 * @return
	 * @throws Exception
	 */
	protected IApplicationModel getApplicationModel() throws Exception {
		return (IApplicationModel) AppModelGlobal.getDefaultApplication();
	}
	
	/**
	 * 设置初始化结果
	 * @param bRet
	 */
	public void setInitResult (boolean bRet){
		this.bInitResult.set(bRet);
	}
	
	
	/**
	 * 获取初始化结果
	 */
	public boolean getInitResult (){
		return this.bInitResult.get();
	}
	
	
	/**
	 * 页面结束
	 */
	public void end(){
		resetCurrent();
	}
	
	
	/**
	 * 获取当前页面
	 * @return
	 */
	public static Page getCurrent(){
		return curPage.get();
	}
	
	
	/**
	 * 是否显示界面操作
	 * @param strActionPrivTag 界面操作需要的权限标识
	 * @return
	 */
	public boolean isShowAction(String strActionPrivTag)throws Exception{
		return true;
	}
	
	/**
	 * 获取页面请求参数，并进行防止跨站脚本攻击（XSS）处理
	 * @param request
	 * @param strParamName
	 * @return
	 */
	public static String getRequest(HttpServletRequest request, String strParamName){
		String strValue = request.getParameter(strParamName);
		if(!StringHelper.isNullOrEmpty(strValue))
			strValue = StringEscapeUtils.escapeJava(strValue);
		return strValue;
	}
}
