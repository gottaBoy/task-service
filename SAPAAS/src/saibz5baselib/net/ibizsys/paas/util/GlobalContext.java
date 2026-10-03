package net.ibizsys.paas.util;

import javax.servlet.ServletContext;

/**
 * 上下文对象辅助类
 * 
 * @author LionLau
 *
 */
public class GlobalContext implements IGlobalContext {
	protected ServletContext servletContext = null;

	protected static IGlobalContext globalContext = null;

	// protected IDynamicModelStorage iDynamicModelStorage = null;

	/**
	 * 获取 ServletContext 对象
	 * 
	 * @return
	 */
	public ServletContext getServletContext() {
		return this.servletContext;
	}

	public static IGlobalContext getCurrent() {
		return globalContext;
	}

	/**
	 * 初始化触发
	 * 
	 * @throws Exception
	 */
	protected void onInit() throws Exception {
		// strModelPath = getServletContext().getRealPath("/")+"WEB-INF"+File.separator +"model" +File.separator;
		//
		// modelStorageImpl.init(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.util.IGlobalContext#getValue(java.lang.String)
	 */
	@Override
	public Object getValue(String strKey) {
		return servletContext.getAttribute(strKey);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.util.IGlobalContext#setValue(java.lang.String, java.lang.Object)
	 */
	@Override
	public void setValue(String strKey, Object objValue) {
		if (objValue == null)
			servletContext.removeAttribute(strKey);
		else
			servletContext.setAttribute(strKey, objValue);
	}

	// @Override
	// public IDynamicModelStorage getDynamicModelStorage()
	// {
	// return iDynamicModelStorage;
	// }
	//
	//

}
