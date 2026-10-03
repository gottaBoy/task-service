package net.ibizsys.paas.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import net.ibizsys.paas.util.StringHelper;

/**
 * 会话工厂管理对象
 * 
 * @author lionlau
 *
 */
public class SessionFactoryManager {

	private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(SessionFactoryManager.class);
	static ThreadLocal<SessionFactorySession> sessionFactorySession = new ThreadLocal<SessionFactorySession>();

	/**
	 * 提交并开始事物
	 * 
	 * @param bCommit
	 * @return
	 */
	public static int releaseAndAddRef(boolean bCommit) {
		releaseRef(bCommit);
		return addRef();
	}

	/**
	 * 增加引用
	 * 
	 * @return
	 */
	public static int addRef() {
		SessionFactorySession currentSession = sessionFactorySession.get();
		if (currentSession == null) {
			currentSession = new SessionFactorySession();
			sessionFactorySession.set(currentSession);
		}
		return currentSession.addRef();
	}

	/**
	 * 释放
	 * 
	 * @param bCommit 提交还是回滚
	 * @return
	 */
	public static int releaseRef(boolean bCommit) {
		SessionFactorySession currentSession = sessionFactorySession.get();
		if (currentSession == null) {
			return 0;
		}

		int nValue = currentSession.releaseRef(bCommit);
		if (nValue == 0) {
			sessionFactorySession.set(null);
		}
		return nValue;
	}

	/**
	 * 获取当前的会话
	 * 
	 * @param sessionFactory
	 * @return
	 * @throws Exception
	 */
	public static Session getCurrentSession(SessionFactory sessionFactory) throws Exception {
		SessionFactorySession currentSession = sessionFactorySession.get();
		if (currentSession == null) {
			throw new Exception(StringHelper.format("无效当前会话"));
		}

		return currentSession.getCurrentSession(sessionFactory);
	}

	/**
	 * 获取当前的会话
	 * 
	 * @param sessionFactory，会话工程，目前该参数没有启用
	 * @return
	 * @throws Exception
	 */
	public static SessionFactorySession getCurrentSFS(SessionFactory sessionFactory) throws Exception {
		SessionFactorySession currentSession = sessionFactorySession.get();
		if (currentSession == null) {
			throw new Exception(StringHelper.format("无效当前会话"));
		}
		return currentSession;
	}
	
	
	/**
	 * 获取当前的会话
	 * 
	 * @return
	 * @throws Exception
	 */
	public static SessionFactorySession getCurrentSFS() throws Exception {
		SessionFactorySession currentSession = sessionFactorySession.get();
		if (currentSession == null) {
			throw new Exception(StringHelper.format("无效当前会话"));
		}
		return currentSession;
	}

	/**
	 * 提交当前的会话，并不减少计数
	 * 
	 * @param sessionFactory
	 * @return
	 * @throws Exception
	 */
	public static void commit() throws Exception {
		commit(null);
	}

	/**
	 * 提交当前的会话
	 * 
	 * @param sessionFactory
	 * @return
	 * @throws Exception
	 */
	public static void commit(SessionFactory sessionFactory) throws Exception {
		SessionFactorySession currentSession = sessionFactorySession.get();
		if (currentSession == null) {
			throw new Exception(StringHelper.format("无效当前会话"));
		}
		currentSession.commit(sessionFactory);
	}
	
	/**
	 * 回滚当前的会话
	 * 
	 * @param sessionFactory
	 * @return
	 * @throws Exception
	 */
	public static void rollback(SessionFactory sessionFactory) throws Exception {
		SessionFactorySession currentSession = sessionFactorySession.get();
		if (currentSession == null) {
			return;
		}
		currentSession.rollback(sessionFactory);
	}
	

	/**
	 * 打开事务
	 * 
	 * @param sessionFactory
	 * @return
	 * @throws Exception
	 */
	public static Transaction getCurrentTransaction(SessionFactory sessionFactory) throws Exception {
		SessionFactorySession currentSession = sessionFactorySession.get();
		if (currentSession == null) {
			throw new Exception(StringHelper.format("无效当前会话"));
		}

		return currentSession.getCurrentTransaction(sessionFactory);
	}
	
	
	/**
	 * 进入会话工厂管理对象
	 * @throws Exception
	 */
	public static void enter() {
		enter(true);
	}
	
	/**
	 * 进入会话工厂管理对象
	 * @param bCommit
	 * @throws Exception
	 */
	public static void enter(boolean bCommit){
		SessionFactorySession currentSession = sessionFactorySession.get();
		if(currentSession == null)
			return;
		if(currentSession.getRef()>0){
			log.error(StringHelper.format("进入会话工厂，存在上次未提交会话[%1$s]",currentSession.getRef()));
			while(releaseRef(bCommit)>0){
				
			}
		}
	}
	
	/**
	 * 离开会话工厂管理对象
	 * @param bCommit
	 * @throws Exception
	 */
	public static void leave(){
		leave(true);
	}
	
	/**
	 * 离开会话工厂管理对象
	 * @param bCommit
	 * @throws Exception
	 */
	public static void leave(boolean bCommit){
		SessionFactorySession currentSession = sessionFactorySession.get();
		if(currentSession == null)
			return;
		if(currentSession.getRef()>0){
			log.error(StringHelper.format("离开会话工厂，存在未提交会话[%1$s]",currentSession.getRef()));
			while(releaseRef(bCommit)>0){
				
			}
		}
	}
}
