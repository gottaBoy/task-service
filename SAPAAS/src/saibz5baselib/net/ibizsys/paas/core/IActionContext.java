package net.ibizsys.paas.core;

import org.hibernate.SessionFactory;

import net.ibizsys.paas.web.IWebContext;

/**
 * 操作上下文对象
 * 
 * @author lionlau
 *
 */
public interface IActionContext {
	/**
	 * 获取网页上下文对象
	 * 
	 * @return
	 */
	IWebContext getWebContext();

	/**
	 * 获取会话对象
	 * 
	 * @return
	 */
	SessionFactory getSessionFactory();

	/**
	 * 获取参数
	 * 
	 * @param strParamName
	 * @return
	 * @throws Exception
	 */
	Object getParam(String strParamName);

	/**
	 * 设置参数
	 * 
	 * @param strParamName
	 * @param objValue
	 */
	void setParam(String strParamName, Object objValue);

	/**
	 * 获取当前操作者标识
	 * 
	 * @return
	 */
	String getOperator();

	/**
	 * 获取当前操作者名称
	 * 
	 * @return
	 */
	String getOperatorName();

	/**
	 * 获取远端地址
	 * 
	 * @return
	 */
	String getRemoteAddr();
}
