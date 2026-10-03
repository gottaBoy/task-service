package net.ibizsys.paas.api;

import org.hibernate.SessionFactory;

import net.ibizsys.paas.sysmodel.ISystemModel;

/**
 * Rest 控制器接口对象
 * @author Administrator
 *
 */
public interface IRestController {
	
	/**
	 * 获取Rest控制器标识
	 * 
	 * @return
	 */
	String getId();
	
	
	/**
	 * 获取系统模型
	 * 
	 * @return
	 */
	ISystemModel getSystemModel();
	
	
	/**
	 * 设置会话工厂
	 * 
	 * @param sessionFactory
	 */
	void setSessionFactory(SessionFactory sessionFactory);

	/**
	 * 获取会话工厂
	 * 
	 * @return
	 */
	SessionFactory getSessionFactory();
}
