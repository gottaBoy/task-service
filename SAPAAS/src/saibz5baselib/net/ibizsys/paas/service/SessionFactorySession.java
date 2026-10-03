package net.ibizsys.paas.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;

/**
 * 会话工厂会话
 * 
 * @author lionlau
 *
 */
public class SessionFactorySession {
	private static final Log log = LogFactory.getLog(SessionFactorySession.class);
	private int nRef = 0;
	private HashMap<SessionFactory, Session> sessionMap = new HashMap<SessionFactory, Session>();
	private HashMap<IEntity, IEntity> lastEntityMap = new HashMap<IEntity, IEntity>();
	private HashMap<IEntity, SessionFactory> lastEntitySessionFactoryMap = new HashMap<IEntity, SessionFactory>();
	
	private final static SimpleEntity EMTPYENTITY = new SimpleEntity();
	private HashMap<SessionFactory, ArrayList<ISFSAction>> sfsActionListMap = new HashMap<SessionFactory, ArrayList<ISFSAction>>();
	
	public SessionFactorySession() {

	}

	/**
	 * 获取数据对象操作之前的数据
	 * 
	 * @param curEntity
	 * @return
	 */
	public synchronized IEntity getLastEntity(IEntity curEntity) {
		IEntity iEntity = lastEntityMap.get(curEntity);
		if (iEntity != null && iEntity != EMTPYENTITY) return iEntity;
		return null;
	}

	/**
	 * 设置对象操作之前的数据
	 * 
	 * @param curEntity
	 * @param lastEntity
	 */
	public synchronized void setLastEntity(IEntity curEntity, IEntity lastEntity) {
		setLastEntity(curEntity,  lastEntity,null);
	}
	
	
	/**
	 * 设置对象操作之前的数据
	 * 
	 * @param curEntity
	 * @param lastEntity
	 * @param sessionFactory 会话工厂
	 */
	public synchronized void setLastEntity(IEntity curEntity, IEntity lastEntity,SessionFactory sessionFactory) {
		if (lastEntity == null) {
			lastEntityMap.put(curEntity, EMTPYENTITY);
			
		} else{
			lastEntityMap.put(curEntity, lastEntity);
		}
		lastEntitySessionFactoryMap.put(curEntity, sessionFactory);
	}
	
	
	/**
	 * 重置指定数据对象最后的数据对象
	 * @param curEntity
	 */
	public synchronized void resetLastEntity(IEntity curEntity) {
		lastEntityMap.remove(curEntity);
		lastEntitySessionFactoryMap.remove(curEntity);
	}

	/**
	 * 增加会话引用
	 * 
	 * @return
	 */
	public synchronized int addRef() {
		nRef++;
		return nRef;
	}

	/**
	 * 提交当前会话
	 */
	public synchronized void commit() {
		commit(null);
	}

	
	/**
	 * 获取当前会话引用计数
	 * 
	 * @return
	 */
	public synchronized int getRef() {
		return nRef;
	}
	
	
	/**
	 * 提交当前会话
	 */
	public synchronized void commit(SessionFactory sessionFactory) {
		if (sessionFactory == null) {
			for (Session session : sessionMap.values()) {
				if (session.getTransaction() != null && session.getTransaction().isActive()) {
					session.getTransaction().commit();
				}
			}
			//清空最后一次的数据
			lastEntityMap.clear();
			lastEntitySessionFactoryMap.clear();
			
			ArrayList<ArrayList<ISFSAction>> sfsActionListList = new ArrayList<ArrayList<ISFSAction>>();
			sfsActionListList.addAll(sfsActionListMap.values());
			sfsActionListMap.clear();
			
			for (ArrayList<ISFSAction> list : sfsActionListList) {
				for(ISFSAction iSFSAction:list){
					iSFSAction.commit();
				}
				list.clear();
			}
		} else {
			Session session = sessionMap.get(sessionFactory);
			if (session != null) {
				if (session.getTransaction() != null && session.getTransaction().isActive()) {
					session.getTransaction().commit();
				}
			}

			ArrayList<IEntity> removeEntityList = new ArrayList<IEntity>();
			for(Entry<IEntity, SessionFactory> entry:lastEntitySessionFactoryMap.entrySet()){
				if(entry.getValue() == sessionFactory){
					removeEntityList.add(entry.getKey());
				}
			}
			for(IEntity iEntity:removeEntityList){
				resetLastEntity(iEntity);
			}
			
			
			ArrayList<ISFSAction> list = sfsActionListMap.remove(sessionFactory);
			if(list!=null){
				for(ISFSAction iSFSAction:list){
					iSFSAction.commit();
				}
				list.clear();
			}
		}
	}

	/**
	 * 回滚当前会话
	 */
	public synchronized void rollback(SessionFactory sessionFactory) {
		if (sessionFactory == null) {
			for (Session session : sessionMap.values()) {
				if (session.getTransaction() != null && session.getTransaction().isActive()) {
					session.getTransaction().rollback();
				}
			}
			
			//清空最后一次的数据
			lastEntityMap.clear();
			lastEntitySessionFactoryMap.clear();
			ArrayList<ArrayList<ISFSAction>> sfsActionListList = new ArrayList<ArrayList<ISFSAction>>();
			sfsActionListList.addAll(sfsActionListMap.values());
			sfsActionListMap.clear();
			
			for (ArrayList<ISFSAction> list : sfsActionListList) {
				for(ISFSAction iSFSAction:list){
					iSFSAction.rollback();
				}
				list.clear();
			}
		} else {
			Session session = sessionMap.get(sessionFactory);
			if (session != null) {
				if (session.getTransaction() != null && session.getTransaction().isActive()) {
					session.getTransaction().rollback();
				}
			}
			
//			//清空最后一次的数据，此处有BUG，要按照SessionFactory区分
//			lastEntityMap.clear();
			
			ArrayList<IEntity> removeEntityList = new ArrayList<IEntity>();
			for(Entry<IEntity, SessionFactory> entry:lastEntitySessionFactoryMap.entrySet()){
				if(entry.getValue() == sessionFactory){
					removeEntityList.add(entry.getKey());
				}
			}
			for(IEntity iEntity:removeEntityList){
				resetLastEntity(iEntity);
			}
			
			ArrayList<ISFSAction> list = sfsActionListMap.remove(sessionFactory);
			if(list!=null){
				for(ISFSAction iSFSAction:list){
					iSFSAction.rollback();
				}
				list.clear();
			}
		}
	}
	
	
	/**
	 * 释放引用
	 * 
	 * @param bCommit 是否提交
	 * @return
	 * @throws Exception
	 */
	public synchronized int releaseRef(boolean bCommit) {
		nRef--;
		if (nRef == 0) {
			for (Session session : sessionMap.values()) {
				try {
					if (session.getTransaction() != null && session.getTransaction().isActive()) {
						if (bCommit) {
							session.getTransaction().commit();
						} else {
							session.getTransaction().rollback();
						}
					}
					session.clear();
					session.close();
				} catch (Exception ex) {
					log.error(ex.getMessage(), ex);
				}
			}
			sessionMap.clear();
			
			//清空最后一次的数据
			lastEntityMap.clear();
			lastEntitySessionFactoryMap.clear();
			ArrayList<ArrayList<ISFSAction>> sfsActionListList = new ArrayList<ArrayList<ISFSAction>>();
			sfsActionListList.addAll(sfsActionListMap.values());
			sfsActionListMap.clear();
			
			for (ArrayList<ISFSAction> list : sfsActionListList) {
				for(ISFSAction iSFSAction:list){
					if (bCommit) {
						iSFSAction.commit();
					}
					else{
						iSFSAction.rollback();
					}
				}
				list.clear();
			}
			sfsActionListMap.clear();
			
		}
		return nRef;
	}

	/**
	 * 获取当前会话
	 * 
	 * @param sessionFactory
	 * @return
	 * @throws Exception
	 */
	public synchronized Session getCurrentSession(SessionFactory sessionFactory) throws Exception {
		if(sessionFactory == null){
			throw new Exception("传入会话工厂对象无效");
		}
		
		if (sessionMap.containsKey(sessionFactory)) {
			return sessionMap.get(sessionFactory);
		}

		Session session = sessionFactory.openSession();
		sessionMap.put(sessionFactory, session);
		return session;
	}

	/**
	 * 获取当前会话工厂事务
	 * 
	 * @param sessionFactory
	 * @return
	 * @throws Exception
	 */
	public synchronized Transaction getCurrentTransaction(SessionFactory sessionFactory) throws Exception {
		Session session = getCurrentSession(sessionFactory);
		if (session.getTransaction() == null || !session.getTransaction().isActive()) {
			org.hibernate.Transaction curTransaction = session.beginTransaction();
		}
		return session.getTransaction();
	}

	
	
	/**
	 * 注册会话工厂会话行为
	 * @param sessionFactory
	 * @param iSFSAction
	 * @throws Exception
	 */
	public synchronized void registerSFSAction(SessionFactory sessionFactory,ISFSAction iSFSAction) throws Exception {
		
		ArrayList<ISFSAction> sfsActionList =sfsActionListMap.get(sessionFactory);
		if(sfsActionList == null)
		{
			sfsActionList = new ArrayList<ISFSAction>();
			sfsActionListMap.put(sessionFactory, sfsActionList);
		}
		sfsActionList.add(iSFSAction);
		
	}
}
