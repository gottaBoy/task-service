package net.ibizsys.paas.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

import net.ibizsys.paas.controller.ViewController;
import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.ctrlhandler.CtrlHandler;
import net.ibizsys.paas.exception.ErrorException;
import net.ibizsys.paas.security.RemoteLoginGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.ObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.common.entity.LoginLog;

/**
 * HttpServlet 基类
 * 
 * @author Administrator
 *
 */
public abstract class HttpServletBase extends HttpServlet {
	
	
	private static final Log log = LogFactory.getLog(HttpServletBase.class);
	private ThreadLocal<SessionFactory> sessionFactory = new ThreadLocal<SessionFactory>();

	public HttpServletBase() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.addTimeOutHeaders(response);
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=UTF-8");

		try {
			SessionFactoryManager.enter();
			IWebContext iWebContext = this.createWebContext(request, response);
			WebContext.setCurrent(iWebContext);

			AjaxActionResult ajaxActionResult = processAction();
			response.getWriter().print(ajaxActionResult.toJSONString());
			response.getWriter().flush();
			response.getWriter().close();
			resetCurrent();
			return;

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);

			resetCurrent();

			AjaxActionResult ajaxActionResult = new AjaxActionResult();
			ajaxActionResult.setRetCode(Errors.INTERNALERROR);
			ajaxActionResult.setErrorInfo(ex.getMessage());
			if (ex instanceof ErrorException) {
				ErrorException errorException = (ErrorException) ex;
				ajaxActionResult.setRetCode(errorException.getErrorCode());
			}

			response.getWriter().print(ajaxActionResult.toJSONString());
			response.getWriter().flush();
			response.getWriter().close();
		}
	}

	/**
	 * 重置当前变量
	 */
	protected void resetCurrent() {
		this.setSessionFactory(null);
		WebContext.setCurrent(null);
		ViewController.setCurrent(null);
		CtrlHandler.setCurrent(null);
		SessionFactoryManager.leave();
	}

	/**
	 * 处理请求
	 * 
	 * @param strAction
	 * @return
	 * @throws Exception
	 */
	public AjaxActionResult processAction() throws Exception {
		AjaxActionResult ajaxActionResult = onProcessAction();

		return ajaxActionResult;
	}

	/**
	 * 处理请求触发
	 * 
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onProcessAction() throws Exception {
		throw new Exception("没有实现");
	}

	/**
	 * 为反馈对象添加超时头内容
	 * 
	 * @param response
	 */
	protected void addTimeOutHeaders(HttpServletResponse response) {
		response.setDateHeader("Expires", System.currentTimeMillis());
	}

	/**
	 * 获取上下文对象
	 * 
	 * @return
	 */
	public IWebContext getWebContext() {
		return WebContext.getCurrent();
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
	 * 建立网络访问上下文
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	protected IWebContext createWebContext(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
}
