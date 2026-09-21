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

import net.ibizsys.paas.service.SessionFactorySession;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class SessionFactoryManager {
    private static final Log log = LogFactory.getLog(SessionFactoryManager.class);
    static ThreadLocal<SessionFactorySession> sessionFactorySession = new ThreadLocal();

    public static int releaseAndAddRef(boolean bCommit) {
        SessionFactoryManager.releaseRef(bCommit);
        return SessionFactoryManager.addRef();
    }

    public static int addRef() {
        SessionFactorySession currentSession = sessionFactorySession.get();
        if (currentSession == null) {
            currentSession = new SessionFactorySession();
            sessionFactorySession.set(currentSession);
        }
        return currentSession.addRef();
    }

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

    public static Session getCurrentSession(SessionFactory sessionFactory) throws Exception {
        SessionFactorySession currentSession = sessionFactorySession.get();
        if (currentSession == null) {
            throw new Exception(StringHelper.format("\u65e0\u6548\u5f53\u524d\u4f1a\u8bdd"));
        }
        return currentSession.getCurrentSession(sessionFactory);
    }

    public static SessionFactorySession getCurrentSFS(SessionFactory sessionFactory) throws Exception {
        SessionFactorySession currentSession = sessionFactorySession.get();
        if (currentSession == null) {
            throw new Exception(StringHelper.format("\u65e0\u6548\u5f53\u524d\u4f1a\u8bdd"));
        }
        return currentSession;
    }

    public static SessionFactorySession getCurrentSFS() throws Exception {
        SessionFactorySession currentSession = sessionFactorySession.get();
        if (currentSession == null) {
            throw new Exception(StringHelper.format("\u65e0\u6548\u5f53\u524d\u4f1a\u8bdd"));
        }
        return currentSession;
    }

    public static void commit() throws Exception {
        SessionFactoryManager.commit(null);
    }

    public static void commit(SessionFactory sessionFactory) throws Exception {
        SessionFactorySession currentSession = sessionFactorySession.get();
        if (currentSession == null) {
            throw new Exception(StringHelper.format("\u65e0\u6548\u5f53\u524d\u4f1a\u8bdd"));
        }
        currentSession.commit(sessionFactory);
    }

    public static void rollback(SessionFactory sessionFactory) throws Exception {
        SessionFactorySession currentSession = sessionFactorySession.get();
        if (currentSession == null) {
            return;
        }
        currentSession.rollback(sessionFactory);
    }

    public static Transaction getCurrentTransaction(SessionFactory sessionFactory) throws Exception {
        SessionFactorySession currentSession = sessionFactorySession.get();
        if (currentSession == null) {
            throw new Exception(StringHelper.format("\u65e0\u6548\u5f53\u524d\u4f1a\u8bdd"));
        }
        return currentSession.getCurrentTransaction(sessionFactory);
    }

    public static void enter() {
        SessionFactoryManager.enter(true);
    }

    public static void enter(boolean bCommit) {
        SessionFactorySession currentSession = sessionFactorySession.get();
        if (currentSession == null) {
            return;
        }
        if (currentSession.getRef() > 0) {
            log.error((Object)StringHelper.format("\u8fdb\u5165\u4f1a\u8bdd\u5de5\u5382\uff0c\u5b58\u5728\u4e0a\u6b21\u672a\u63d0\u4ea4\u4f1a\u8bdd[%1$s]", currentSession.getRef()));
            while (SessionFactoryManager.releaseRef(bCommit) > 0) {
            }
        }
    }

    public static void leave() {
        SessionFactoryManager.leave(true);
    }

    public static void leave(boolean bCommit) {
        SessionFactorySession currentSession = sessionFactorySession.get();
        if (currentSession == null) {
            return;
        }
        if (currentSession.getRef() > 0) {
            log.error((Object)StringHelper.format("\u79bb\u5f00\u4f1a\u8bdd\u5de5\u5382\uff0c\u5b58\u5728\u672a\u63d0\u4ea4\u4f1a\u8bdd[%1$s]", currentSession.getRef()));
            while (SessionFactoryManager.releaseRef(bCommit) > 0) {
            }
        }
    }
}

