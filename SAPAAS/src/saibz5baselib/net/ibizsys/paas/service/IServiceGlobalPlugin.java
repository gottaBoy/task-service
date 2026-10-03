package net.ibizsys.paas.service;

import org.hibernate.SessionFactory;

/**
 * 服务对象全局存储插件
 * 
 * @author Administrator
 *
 */
public interface IServiceGlobalPlugin {
	/**
	 * 注册服务对象
	 * 
	 * @param strServiceClsType
	 * @param iService
	 */
	void registerService(String strServiceClsType, IService iService);

	/**
	 * 获取服务对象
	 * 
	 * @param strServiceClsType
	 * @return
	 * @throws Exception
	 */
	IService getService(Class cls) throws Exception;

	/**
	 * 获取服务对象
	 * 
	 * @param strServiceClsType
	 * @return
	 * @throws Exception
	 */
	IService getService(String strServiceClsType) throws Exception;

	/**
	 * 注册服务对象
	 * 
	 * @param strServiceClsType
	 * @param strDSLink
	 * @param iService
	 */
	void registerService(String strServiceClsType, String strDSLink, IService iService);

	/**
	 * 获取服务对象
	 * 
	 * @param cls
	 * @param strDSLink
	 * @return
	 * @throws Exception
	 */
	IService getService(Class cls, String strDSLink) throws Exception;

	/**
	 * 获取服务对象
	 * 
	 * @param strServiceClsType
	 * @param strDSLink
	 * @return
	 * @throws Exception
	 */
	IService getService(String strServiceClsType, String strDSLink) throws Exception;

	/**
	 * 获取服务对象
	 * 
	 * @param cls
	 * @param sessionFactory
	 * @return
	 * @throws Exception
	 */
	IService getService(Class cls, SessionFactory sessionFactory) throws Exception;

	/**
	 * 获取服务对象
	 * 
	 * @param strServiceClsType
	 * @param sessionFactory
	 * @return
	 * @throws Exception
	 */
	IService getService(String strServiceClsType, SessionFactory sessionFactory) throws Exception;

	/**
	 * 重置会话工厂的相关服务对象
	 * 
	 * @param sessionFactory
	 * @return
	 * @throws Exception
	 */
	void resetServices(SessionFactory sessionFactory) throws Exception;

	/**
	 * 重置会话工厂的服务对象缓存
	 * 
	 * @param sessionFactory
	 * @return
	 * @throws Exception
	 */
	void resetServiceCache(SessionFactory sessionFactory) throws Exception;

}
