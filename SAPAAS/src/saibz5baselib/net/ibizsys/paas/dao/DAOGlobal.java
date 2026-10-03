package net.ibizsys.paas.dao;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

import net.ibizsys.paas.db.IDBDialect;
import net.ibizsys.paas.sysmodel.ISystemRuntime;
import net.ibizsys.paas.util.StringHelper;

/**
 * DAO全局存储对象
 * 
 * @author lionlau
 *
 */
public class DAOGlobal {
	private static final Log log = LogFactory.getLog(DAOGlobal.class);
	private static HashMap<String, IDAO> daoMap = new HashMap<String, IDAO>();
	private static HashMap<SessionFactory, HashMap<String, IDAO>> sessionFactoryDAOMap = new HashMap<SessionFactory, HashMap<String, IDAO>>();
	private static HashMap<SessionFactory, IDBDialect> dbDialectMap = new HashMap<SessionFactory, IDBDialect>();

	/**
	 * 注册全局DAO对象
	 * 
	 * @param strDAOClsType
	 * @param iDAO
	 */
	public static void registerDAO(String strDAOClsType, IDAO iDAO) {
		if (!daoMap.containsKey(strDAOClsType)) {
			daoMap.put(strDAOClsType, iDAO);
			log.debug(StringHelper.format("注册DAO对象[%1$s]，当前数量[%2$s]",strDAOClsType,daoMap.size()));
		}
	}

	/**
	 * 获取全局DAO对象
	 * 
	 * @param cls
	 * @return
	 * @throws Exception
	 */
	public static IDAO getDAO(Class cls) throws Exception {
		return getDAO(cls.getCanonicalName());
	}

	/**
	 * 获取全局DAO对象
	 * 
	 * @param strDAOClsType
	 * @return
	 * @throws Exception
	 */
	public static IDAO getDAO(String strDAOClsType) throws Exception {
		IDAO iDAO = daoMap.get(strDAOClsType);
		if (iDAO == null) throw new Exception(StringHelper.format("无法获取指定DAO对象[%1$s]", strDAOClsType));
		return iDAO;
	}

	/**
	 * 注册DAO对象
	 * 
	 * @param strDAOClsType
	 * @param iDAO
	 */
	public static void registerDAO(String strDAOClsType, String strDSLink, IDAO iDAO) {
		if (StringHelper.isNullOrEmpty(strDSLink))
			registerDAO(strDAOClsType, iDAO);
		else {
			String strFullKeyId = StringHelper.format("%1$s|%2$s", strDAOClsType, strDSLink);
			registerDAO(strFullKeyId, iDAO);
		}
	}

	/**
	 * 获取DAO对象
	 * 
	 * @param strDAOClsType
	 * @return
	 * @throws Exception
	 */
	public static IDAO getDAO(Class cls, String strDSLink) throws Exception {
		if (StringHelper.isNullOrEmpty(strDSLink))
			return getDAO(cls.getCanonicalName());
		else {
			return getDAO(cls.getCanonicalName(), strDSLink);
		}
	}

	/**
	 * 获取DAO对象
	 * 
	 * @param strDAOClsType
	 * @return
	 * @throws Exception
	 */
	public static IDAO getDAO(String strDAOClsType, String strDSLink) throws Exception {
		if (StringHelper.isNullOrEmpty(strDSLink))
			return getDAO(strDAOClsType);
		else {
			String strFullKeyId = StringHelper.format("%1$s|%2$s", strDAOClsType, strDSLink);
			return getDAO(strFullKeyId);
		}
	}

	public static IDAO getDAO(Class cls, SessionFactory sessionFactory) throws Exception {
		return getDAO(cls.getCanonicalName(), sessionFactory);
	}

	/**
	 * 获取DAO对象
	 * 
	 * @param strDAOClsType
	 * @return
	 * @throws Exception
	 */
	public static IDAO getDAO(String strDAOClsType, SessionFactory sessionFactory) throws Exception {
		if (sessionFactory == null) {
			return getDAO(strDAOClsType);
		}
		
		//获取原始对象
		IDAO iDAO = daoMap.get(strDAOClsType);
		if (iDAO == null){
			throw new Exception(StringHelper.format("无法获取指定DAO对象[%1$s]", strDAOClsType));
		}
		
		sessionFactory =  ((ISystemRuntime)iDAO.getSystemModel()).getRealSessionFactory(iDAO.getDEModel(), sessionFactory);
		if(sessionFactory == null)
			return iDAO;
		
		HashMap<String, IDAO> sessionDAOMap = null;
		synchronized (sessionFactoryDAOMap) {
			sessionDAOMap = sessionFactoryDAOMap.get(sessionFactory);
			if(sessionDAOMap == null){
				sessionDAOMap = new HashMap<String, IDAO>();
				sessionFactoryDAOMap.put(sessionFactory, sessionDAOMap);
				if(log.isDebugEnabled()){
					log.debug(StringHelper.format("注册[%1$s]DAO对象映射，当前数量[%2$s]",sessionFactory.toString(),sessionFactoryDAOMap.size()));
				}
			}
		}
				

		synchronized(sessionDAOMap){
			IDAO sessionDAO = sessionDAOMap.get(strDAOClsType);
			if (sessionDAO != null){
				return sessionDAO;
			}
			
			// 建立新对象
			sessionDAO = iDAO.getClass().newInstance();
			sessionDAO.setSessionFactory(sessionFactory);
			sessionDAO.setDBDialect(dbDialectMap.get(sessionFactory));
			sessionDAOMap.put(strDAOClsType, sessionDAO);
			if(log.isDebugEnabled()){
				log.debug(StringHelper.format("注册[%1$s]DAO对象[%2$s]，当前数量[%3$s]",sessionFactory.toString(),strDAOClsType,sessionDAOMap.size()));
			}
			return sessionDAO;
		}
//				
//
//		String strFullKeyId = StringHelper.format("%1$s|%2$s", strDAOClsType, sessionFactory.toString());
//		synchronized (daoMap) {
//			IDAO iDAO = daoMap.get(strFullKeyId);
//			if (iDAO != null) return iDAO;
//
//			iDAO = daoMap.get(strDAOClsType);
//			if (iDAO == null) throw new Exception(StringHelper.format("无法获取指定DAO[%1$s]", strDAOClsType));
//
//			// 建立新对象
//			IDAO newDAO = iDAO.getClass().newInstance();
//			newDAO.setSessionFactory(sessionFactory);
//			newDAO.setDBDialect(dbDialectMap.get(sessionFactory));
//
//			daoMap.put(strFullKeyId, newDAO);
//			return newDAO;
//		}
	}

	/**
	 * 注册数据库适配
	 * 
	 * @param sessionFactory
	 * @param iDBDialect
	 */
	public static void registerDBDialect(SessionFactory sessionFactory, IDBDialect iDBDialect) {
		synchronized (daoMap) {
			dbDialectMap.put(sessionFactory, iDBDialect);
		}
	}

	/**
	 * 注销数据库适配，也包括相关的DAO映射
	 * 
	 * @param sessionFactory
	 */
	public static void unregisterDBDialect(SessionFactory sessionFactory) {
		if(sessionFactory == null)
			return;
		
		synchronized (daoMap) {
			dbDialectMap.remove(sessionFactory);
		}

		
		HashMap<String, IDAO> sessionDAOMap = null;
		synchronized (sessionFactoryDAOMap) {
			sessionDAOMap = sessionFactoryDAOMap.remove(sessionFactory);
			
		}
		if(sessionDAOMap!=null){
			log.debug(StringHelper.format("注销[%1$s]DAO对象映射，当前数量[%2$s]",sessionFactory.toString(),sessionFactoryDAOMap.size()));
		}
		
	}

}
