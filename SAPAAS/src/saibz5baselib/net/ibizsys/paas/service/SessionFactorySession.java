/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.Session
 *  org.hibernate.SessionFactory
 *  org.hibernate.Transaction
 */
package net.ibizsys.paas.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.service.ISFSAction;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class SessionFactorySession {
    private static final Log log = LogFactory.getLog(SessionFactorySession.class);
    private int nRef = 0;
    private HashMap<SessionFactory, Session> sessionMap = new HashMap();
    private HashMap<IEntity, IEntity> lastEntityMap = new HashMap();
    private HashMap<IEntity, SessionFactory> lastEntitySessionFactoryMap = new HashMap();
    private static final SimpleEntity EMTPYENTITY = new SimpleEntity();
    private HashMap<SessionFactory, ArrayList<ISFSAction>> sfsActionListMap = new HashMap();

    public synchronized IEntity getLastEntity(IEntity curEntity) {
        IEntity iEntity = this.lastEntityMap.get(curEntity);
        if (iEntity != null && iEntity != EMTPYENTITY) {
            return iEntity;
        }
        return null;
    }

    public synchronized void setLastEntity(IEntity curEntity, IEntity lastEntity) {
        this.setLastEntity(curEntity, lastEntity, null);
    }

    public synchronized void setLastEntity(IEntity curEntity, IEntity lastEntity, SessionFactory sessionFactory) {
        if (lastEntity == null) {
            this.lastEntityMap.put(curEntity, EMTPYENTITY);
        } else {
            this.lastEntityMap.put(curEntity, lastEntity);
        }
        this.lastEntitySessionFactoryMap.put(curEntity, sessionFactory);
    }

    public synchronized void resetLastEntity(IEntity curEntity) {
        this.lastEntityMap.remove(curEntity);
        this.lastEntitySessionFactoryMap.remove(curEntity);
    }

    public synchronized int addRef() {
        ++this.nRef;
        return this.nRef;
    }

    public synchronized void commit() {
        this.commit(null);
    }

    public synchronized int getRef() {
        return this.nRef;
    }

    public synchronized void commit(SessionFactory sessionFactory) {
        if (sessionFactory == null) {
            for (Session session : this.sessionMap.values()) {
                if (session.getTransaction() == null || !session.getTransaction().isActive()) continue;
                session.getTransaction().commit();
            }
            this.lastEntityMap.clear();
            this.lastEntitySessionFactoryMap.clear();
            ArrayList<ArrayList<ISFSAction>> sfsActionListList = new ArrayList<ArrayList<ISFSAction>>();
            sfsActionListList.addAll(this.sfsActionListMap.values());
            this.sfsActionListMap.clear();
            for (ArrayList arrayList : sfsActionListList) {
                for (ISFSAction iSFSAction : arrayList) {
                    iSFSAction.commit();
                }
                arrayList.clear();
            }
        } else {
            Session session = this.sessionMap.get(sessionFactory);
            if (session != null && session.getTransaction() != null && session.getTransaction().isActive()) {
                session.getTransaction().commit();
            }
            ArrayList<IEntity> arrayList = new ArrayList<IEntity>();
            for (Map.Entry<IEntity, SessionFactory> entry : this.lastEntitySessionFactoryMap.entrySet()) {
                if (entry.getValue() != sessionFactory) continue;
                arrayList.add(entry.getKey());
            }
            for (IEntity iEntity : arrayList) {
                this.resetLastEntity(iEntity);
            }
            ArrayList<ISFSAction> list = this.sfsActionListMap.remove(sessionFactory);
            if (list != null) {
                for (ISFSAction iSFSAction : list) {
                    iSFSAction.commit();
                }
                list.clear();
            }
        }
    }

    public synchronized void rollback(SessionFactory sessionFactory) {
        if (sessionFactory == null) {
            for (Session session : this.sessionMap.values()) {
                if (session.getTransaction() == null || !session.getTransaction().isActive()) continue;
                session.getTransaction().rollback();
            }
            this.lastEntityMap.clear();
            this.lastEntitySessionFactoryMap.clear();
            ArrayList<ArrayList<ISFSAction>> sfsActionListList = new ArrayList<ArrayList<ISFSAction>>();
            sfsActionListList.addAll(this.sfsActionListMap.values());
            this.sfsActionListMap.clear();
            for (ArrayList arrayList : sfsActionListList) {
                for (ISFSAction iSFSAction : arrayList) {
                    iSFSAction.rollback();
                }
                arrayList.clear();
            }
        } else {
            Session session = this.sessionMap.get(sessionFactory);
            if (session != null && session.getTransaction() != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            ArrayList<IEntity> arrayList = new ArrayList<IEntity>();
            for (Map.Entry<IEntity, SessionFactory> entry : this.lastEntitySessionFactoryMap.entrySet()) {
                if (entry.getValue() != sessionFactory) continue;
                arrayList.add(entry.getKey());
            }
            for (IEntity iEntity : arrayList) {
                this.resetLastEntity(iEntity);
            }
            ArrayList<ISFSAction> list = this.sfsActionListMap.remove(sessionFactory);
            if (list != null) {
                for (ISFSAction iSFSAction : list) {
                    iSFSAction.rollback();
                }
                list.clear();
            }
        }
    }

    public synchronized int releaseRef(boolean bCommit) {
        --this.nRef;
        if (this.nRef == 0) {
            for (Session session : this.sessionMap.values()) {
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
                }
                catch (Exception ex) {
                    log.error((Object)ex.getMessage(), (Throwable)ex);
                }
            }
            this.sessionMap.clear();
            this.lastEntityMap.clear();
            this.lastEntitySessionFactoryMap.clear();
            ArrayList<ArrayList<ISFSAction>> sfsActionListList = new ArrayList<ArrayList<ISFSAction>>();
            sfsActionListList.addAll(this.sfsActionListMap.values());
            this.sfsActionListMap.clear();
            for (ArrayList arrayList : sfsActionListList) {
                for (ISFSAction iSFSAction : arrayList) {
                    if (bCommit) {
                        iSFSAction.commit();
                        continue;
                    }
                    iSFSAction.rollback();
                }
                arrayList.clear();
            }
            this.sfsActionListMap.clear();
        }
        return this.nRef;
    }

    public synchronized Session getCurrentSession(SessionFactory sessionFactory) throws Exception {
        if (sessionFactory == null) {
            throw new Exception("\u4f20\u5165\u4f1a\u8bdd\u5de5\u5382\u5bf9\u8c61\u65e0\u6548");
        }
        if (this.sessionMap.containsKey(sessionFactory)) {
            return this.sessionMap.get(sessionFactory);
        }
        Session session = sessionFactory.openSession();
        this.sessionMap.put(sessionFactory, session);
        return session;
    }

    public synchronized Transaction getCurrentTransaction(SessionFactory sessionFactory) throws Exception {
        Session session = this.getCurrentSession(sessionFactory);
        if (session.getTransaction() == null || !session.getTransaction().isActive()) {
            Transaction transaction = session.beginTransaction();
        }
        return session.getTransaction();
    }

    public synchronized void registerSFSAction(SessionFactory sessionFactory, ISFSAction iSFSAction) throws Exception {
        ArrayList<ISFSAction> sfsActionList = this.sfsActionListMap.get(sessionFactory);
        if (sfsActionList == null) {
            sfsActionList = new ArrayList();
            this.sfsActionListMap.put(sessionFactory, sfsActionList);
        }
        sfsActionList.add(iSFSAction);
    }
}

