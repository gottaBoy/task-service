/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.paas.dao;

import java.util.HashMap;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.db.IDBDialect;
import net.ibizsys.paas.sysmodel.ISystemRuntime;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class DAOGlobal {
    private static final Log log = LogFactory.getLog(DAOGlobal.class);
    private static HashMap<String, IDAO> daoMap = new HashMap();
    private static HashMap<SessionFactory, HashMap<String, IDAO>> sessionFactoryDAOMap = new HashMap();
    private static HashMap<SessionFactory, IDBDialect> dbDialectMap = new HashMap();

    public static void registerDAO(String strDAOClsType, IDAO iDAO) {
        if (!daoMap.containsKey(strDAOClsType)) {
            daoMap.put(strDAOClsType, iDAO);
            log.debug((Object)StringHelper.format("\u6ce8\u518cDAO\u5bf9\u8c61[%1$s]\uff0c\u5f53\u524d\u6570\u91cf[%2$s]", strDAOClsType, daoMap.size()));
        }
    }

    public static IDAO getDAO(Class cls) throws Exception {
        return DAOGlobal.getDAO(cls.getCanonicalName());
    }

    public static IDAO getDAO(String strDAOClsType) throws Exception {
        IDAO iDAO = daoMap.get(strDAOClsType);
        if (iDAO == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9aDAO\u5bf9\u8c61[%1$s]", strDAOClsType));
        }
        return iDAO;
    }

    public static void registerDAO(String strDAOClsType, String strDSLink, IDAO iDAO) {
        if (StringHelper.isNullOrEmpty(strDSLink)) {
            DAOGlobal.registerDAO(strDAOClsType, iDAO);
        } else {
            String strFullKeyId = StringHelper.format("%1$s|%2$s", strDAOClsType, strDSLink);
            DAOGlobal.registerDAO(strFullKeyId, iDAO);
        }
    }

    public static IDAO getDAO(Class cls, String strDSLink) throws Exception {
        if (StringHelper.isNullOrEmpty(strDSLink)) {
            return DAOGlobal.getDAO(cls.getCanonicalName());
        }
        return DAOGlobal.getDAO(cls.getCanonicalName(), strDSLink);
    }

    public static IDAO getDAO(String strDAOClsType, String strDSLink) throws Exception {
        if (StringHelper.isNullOrEmpty(strDSLink)) {
            return DAOGlobal.getDAO(strDAOClsType);
        }
        String strFullKeyId = StringHelper.format("%1$s|%2$s", strDAOClsType, strDSLink);
        return DAOGlobal.getDAO(strFullKeyId);
    }

    public static IDAO getDAO(Class cls, SessionFactory sessionFactory) throws Exception {
        return DAOGlobal.getDAO(cls.getCanonicalName(), sessionFactory);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static IDAO getDAO(String strDAOClsType, SessionFactory sessionFactory) throws Exception {
        if (sessionFactory == null) {
            return DAOGlobal.getDAO(strDAOClsType);
        }
        IDAO iDAO = daoMap.get(strDAOClsType);
        if (iDAO == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9aDAO\u5bf9\u8c61[%1$s]", strDAOClsType));
        }
        sessionFactory = ((ISystemRuntime)iDAO.getSystemModel()).getRealSessionFactory(iDAO.getDEModel(), sessionFactory);
        if (sessionFactory == null) {
            return iDAO;
        }
        HashMap<String, IDAO<Object>> sessionDAOMap = null;
        HashMap<Object, Object> hashMap = sessionFactoryDAOMap;
        synchronized (hashMap) {
            sessionDAOMap = sessionFactoryDAOMap.get(sessionFactory);
            if (sessionDAOMap == null) {
                sessionDAOMap = new HashMap();
                sessionFactoryDAOMap.put(sessionFactory, sessionDAOMap);
                if (log.isDebugEnabled()) {
                    log.debug((Object)StringHelper.format("\u6ce8\u518c[%1$s]DAO\u5bf9\u8c61\u6620\u5c04\uff0c\u5f53\u524d\u6570\u91cf[%2$s]", sessionFactory.toString(), sessionFactoryDAOMap.size()));
                }
            }
        }
        hashMap = sessionDAOMap;
        synchronized (hashMap) {
            IDAO sessionDAO = sessionDAOMap.get(strDAOClsType);
            if (sessionDAO != null) {
                return sessionDAO;
            }
            sessionDAO = (IDAO)iDAO.getClass().newInstance();
            sessionDAO.setSessionFactory(sessionFactory);
            sessionDAO.setDBDialect(dbDialectMap.get(sessionFactory));
            sessionDAOMap.put(strDAOClsType, sessionDAO);
            if (log.isDebugEnabled()) {
                log.debug((Object)StringHelper.format("\u6ce8\u518c[%1$s]DAO\u5bf9\u8c61[%2$s]\uff0c\u5f53\u524d\u6570\u91cf[%3$s]", sessionFactory.toString(), strDAOClsType, sessionDAOMap.size()));
            }
            return sessionDAO;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void registerDBDialect(SessionFactory sessionFactory, IDBDialect iDBDialect) {
        HashMap<String, IDAO> hashMap = daoMap;
        synchronized (hashMap) {
            dbDialectMap.put(sessionFactory, iDBDialect);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void unregisterDBDialect(SessionFactory sessionFactory) {
        if (sessionFactory == null) {
            return;
        }
        HashMap<String, IDAO> hashMap = daoMap;
        synchronized (hashMap) {
            dbDialectMap.remove(sessionFactory);
        }
        HashMap<String, IDAO> sessionDAOMap = null;
        HashMap<SessionFactory, HashMap<String, IDAO>> hashMap2 = sessionFactoryDAOMap;
        synchronized (hashMap2) {
            sessionDAOMap = sessionFactoryDAOMap.remove(sessionFactory);
        }
        if (sessionDAOMap != null) {
            log.debug((Object)StringHelper.format("\u6ce8\u9500[%1$s]DAO\u5bf9\u8c61\u6620\u5c04\uff0c\u5f53\u524d\u6570\u91cf[%2$s]", sessionFactory.toString(), sessionFactoryDAOMap.size()));
        }
    }
}

