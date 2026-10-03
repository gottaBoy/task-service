package net.ibizsys.paas.core;

import java.util.HashMap;

import org.hibernate.SessionFactory;

import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;

/**
 * 操作上下文对象
 * 
 * @author Administrator
 *
 */
public class ActionContext implements IActionContext {
	private static ThreadLocal<IActionContext> actionContext = new ThreadLocal<IActionContext>();

	protected IWebContext iWebContext = null;
	protected SessionFactory sessionFactory = null;
	protected HashMap<String, Object> paramMap = new HashMap<String, Object>();
	protected String strOperator = null;
	protected String strOperatorName = null;
	protected String strRemoteAddr = null;

	public ActionContext(IWebContext iWebContext) {
		this.iWebContext = iWebContext;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IActionContext#getWebContext()
	 */
	@Override
	public IWebContext getWebContext() {
		if (this.iWebContext == null) return WebContext.getCurrent();
		return this.iWebContext;
	}
	
	/**
	 * 设置网络访问上下文
	 * @param iWebContext
	 */
	public void setWebContext(IWebContext iWebContext){
		this.iWebContext = iWebContext;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IActionContext#getSessionFactory()
	 */
	@Override
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * 设置会话工厂
	 * 
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IActionContext#getParam(java.lang.String)
	 */
	@Override
	public Object getParam(String strParamName) {
		return paramMap.get(strParamName.toUpperCase());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IActionContext#setParam(java.lang.String, java.lang.Object)
	 */
	public void setParam(String strParamName, Object objValue) {
		if (objValue != null) {
			paramMap.put(strParamName.toUpperCase(), objValue);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IActionContext#getOperator()
	 */
	@Override
	public String getOperator() {
		if (StringHelper.isNullOrEmpty(this.strOperator) && this.getWebContext() != null) return this.getWebContext().getCurUserId();
		return this.strOperator;
	}

	/**
	 * 设置操作者
	 * 
	 * @param strOperator
	 */
	public void setOperator(String strOperator) {
		this.strOperator = strOperator;
	}

	@Override
	public String getOperatorName() {
		if (StringHelper.isNullOrEmpty(this.strOperatorName) && this.getWebContext() != null) return this.getWebContext().getCurUserName();
		return this.strOperatorName;
	}

	/**
	 * 设置操作者名称
	 * 
	 * @param strOperatorName
	 */
	public void setOperatorName(String strOperatorName) {
		this.strOperatorName = strOperatorName;
	}

	@Override
	public String getRemoteAddr() {
		if (StringHelper.isNullOrEmpty(this.strRemoteAddr) && this.getWebContext() != null) return this.getWebContext().getRemoteAddr();
		return this.strRemoteAddr;
	}

	/**
	 * 设置远端地址
	 * 
	 * @param strRemoteAddr
	 */
	public void setRemoteAddr(String strRemoteAddr) {
		this.strRemoteAddr = strRemoteAddr;
	}

	/**
	 * 获取上下文对象
	 * 
	 * @return
	 */
	public static IActionContext getCurrent() {
		return actionContext.get();
	}

	/**
	 * 设置上下文对象
	 * 
	 * @param value
	 */
	public static void setCurrent(IActionContext value) {
		actionContext.set(value);
	}

}