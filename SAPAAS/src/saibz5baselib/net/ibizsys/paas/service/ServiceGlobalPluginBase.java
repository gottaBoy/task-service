package net.ibizsys.paas.service;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

import net.ibizsys.paas.sysmodel.ISystemRuntime;
import net.ibizsys.paas.util.StringHelper;

/**
 * 服务对象全局存储插件实现基类
 * @author Administrator
 *
 */
public abstract class ServiceGlobalPluginBase implements IServiceGlobalPlugin{
	
	private static final Log log = LogFactory.getLog(ServiceGlobal.class);
	private HashMap<String, IService> serviceMap = new HashMap<String, IService>();
	private HashMap<SessionFactory, HashMap<String, IService>> sessionFactoryServiceMap = new HashMap<SessionFactory, HashMap<String, IService>>();
	
	/**
	 * 注册服务对象
	 * 
	 * @param strServiceClsType
	 * @param iService
	 */
	public void registerService(String strServiceClsType, IService iService) {
		if (!serviceMap.containsKey(strServiceClsType)) {
			serviceMap.put(strServiceClsType, iService);
			log.debug(StringHelper.format("注册服务对象[%1$s]，当前数量[%2$s]",strServiceClsType,serviceMap.size()));
		}
	}

	/**
	 * 获取服务对象
	 * 
	 * @param strServiceClsType
	 * @return
	 * @throws Exception
	 */
	public IService getService(Class cls) throws Exception {
		return getService(cls.getCanonicalName());
	}

	/**
	 * 获取服务对象
	 * 
	 * @param strServiceClsType
	 * @return
	 * @throws Exception
	 */
	public IService getService(String strServiceClsType) throws Exception {
		IService iService = serviceMap.get(strServiceClsType);
		if (iService == null) throw new Exception(StringHelper.format("无法获取指定服务对象[%1$s]", strServiceClsType));
		return iService;
	}

	/**
	 * 注册服务对象
	 * 
	 * @param strServiceClsType
	 * @param strDSLink
	 * @param iService
	 */
	public void registerService(String strServiceClsType, String strDSLink, IService iService) {
		if (StringHelper.isNullOrEmpty(strDSLink))
			registerService(strServiceClsType, iService);
		else {
			String strFullKeyId = StringHelper.format("%1$s|%2$s", strServiceClsType, strDSLink);
			registerService(strFullKeyId, iService);
		}
	}

	/**
	 * 获取服务对象
	 * 
	 * @param cls
	 * @param strDSLink
	 * @return
	 * @throws Exception
	 */
	public IService getService(Class cls, String strDSLink) throws Exception {
		if (StringHelper.isNullOrEmpty(strDSLink))
			return getService(cls.getCanonicalName());
		else {
			return getService(cls.getCanonicalName(), strDSLink);
		}
	}

	/**
	 * 获取服务对象
	 * 
	 * @param strServiceClsType
	 * @param strDSLink
	 * @return
	 * @throws Exception
	 */
	public IService getService(String strServiceClsType, String strDSLink) throws Exception {
		if (StringHelper.isNullOrEmpty(strDSLink))
			return getService(strServiceClsType);
		else {
			String strFullKeyId = StringHelper.format("%1$s|%2$s", strServiceClsType, strDSLink);
			return getService(strFullKeyId);
		}
	}

	/**
	 * 获取服务对象
	 * 
	 * @param cls
	 * @param sessionFactory
	 * @return
	 * @throws Exception
	 */
	public IService getService(Class cls, SessionFactory sessionFactory) throws Exception {
		return getService(cls.getCanonicalName(), sessionFactory);
	}


	/**
	 * 获取服务对象
	 * 
	 * @param strServiceClsType
	 * @param sessionFactory
	 * @return
	 * @throws Exception
	 */
	public IService getService(String strServiceClsType, SessionFactory sessionFactory) throws Exception {

		if (sessionFactory == null) {
			return getService(strServiceClsType);
		}
		//获取原始对象
		IService iService = serviceMap.get(strServiceClsType);
		if (iService == null){
			throw new Exception(StringHelper.format("无法获取指定服务对象[%1$s]", strServiceClsType));
		}
		
		sessionFactory =  ((ISystemRuntime)iService.getSystemModel()).getRealSessionFactory(iService.getDEModel(), sessionFactory);
		if(sessionFactory == null)
			return iService;
		
		HashMap<String, IService> sessionServiceMap = null;
		synchronized (sessionFactoryServiceMap) {
			sessionServiceMap = sessionFactoryServiceMap.get(sessionFactory);
			if(sessionServiceMap == null){
				sessionServiceMap = new HashMap<String, IService>();
				sessionFactoryServiceMap.put(sessionFactory, sessionServiceMap);
				if(log.isDebugEnabled()){
					log.debug(StringHelper.format("注册[%1$s]服务对象映射，当前数量[%2$s]",sessionFactory.toString(),sessionFactoryServiceMap.size()));
				}
			}
		}
		

		synchronized(sessionServiceMap){
			IService sessionService = sessionServiceMap.get(strServiceClsType);
			if (sessionService != null){
				return sessionService;
			}
			
			// 建立新对象
			sessionService = iService.getClass().newInstance();
			sessionService.setSessionFactory(sessionFactory);
			sessionServiceMap.put(strServiceClsType, sessionService);
			if(log.isDebugEnabled()){
				log.debug(StringHelper.format("注册[%1$s]服务对象[%2$s]，当前数量[%3$s]",sessionFactory.toString(),strServiceClsType,sessionServiceMap.size()));
			}
			return sessionService;
		}
	}
	
	
	/**
	 * 重置会话工厂的相关服务对象
	 * @param sessionFactory
	 * @return
	 * @throws Exception
	 */
	public  void resetServices(SessionFactory sessionFactory) throws Exception {
		if (sessionFactory == null) {
			return;
		}

		HashMap<String, IService> sessionServiceMap = null;
		synchronized (sessionFactoryServiceMap) {
			sessionServiceMap = sessionFactoryServiceMap.remove(sessionFactory);
			
		}
		if(sessionServiceMap!=null){
			log.debug(StringHelper.format("注销[%1$s]服务对象映射，当前数量[%2$s]",sessionFactory.toString(),sessionFactoryServiceMap.size()));
		}
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.service.IServiceGlobalPlugin#resetServiceCache(org.hibernate.SessionFactory)
	 */
	@Override
	public void resetServiceCache(SessionFactory sessionFactory) throws Exception {
		if (sessionFactory == null) {
			for(IService iService:serviceMap.values()){
				iService.resetCache();
			}
		}
		else{
			HashMap<String, IService> sessionServiceMap = null;
			synchronized (sessionFactoryServiceMap) {
				sessionServiceMap = sessionFactoryServiceMap.get(sessionFactory);
			}
			if(sessionServiceMap!=null){
				for(IService iService:sessionServiceMap.values()){
					iService.resetCache();
				}
			}
		}
	}
	
	
	

}
