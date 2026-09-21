/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.db.IDBDialect
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.ObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.hibernate.cfg.Configuration
 */
package net.ibizsys.pscore.srv.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.db.IDBDialect;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.ObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.config.entity.PSDBType;
import net.ibizsys.pscore.srv.config.entity.PSDBTypeBase;
import net.ibizsys.pscore.srv.config.service.PSDBTypeService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBServerBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSDBServerService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PSDBServerGlobal {
    private static final Log log = LogFactory.getLog(PSDBServerGlobal.class);
    protected static HashMap<String, SessionFactory> sessionFactoryMap = new HashMap();
    protected static HashMap<String, Configuration> sessionFactoryConfigurationMap = new HashMap();
    protected static HashMap<String, PSDBType> psDBTypeMap = new HashMap();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static SessionFactory getSessionFactory(String string) throws Exception {
        if (StringHelper.isNullOrEmpty((String)string)) {
            return null;
        }
        SessionFactory sessionFactory = null;
        Serializable serializable = sessionFactoryMap;
        synchronized (serializable) {
            sessionFactory = sessionFactoryMap.get(string);
            if (sessionFactory != null) {
                return sessionFactory;
            }
        }
        serializable = new PSDBServer();
        ((PSDBServerBase)serializable).setPSDBServerId(string);
        PSDBServerService pSDBServerService = (PSDBServerService)ServiceGlobal.getService(PSDBServerService.class);
        pSDBServerService.get((IEntity)serializable);
        return PSDBServerGlobal.getSessionFactory((PSDBServer)serializable);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static SessionFactory getSessionFactory(PSDBServer pSDBServer) throws Exception {
        Map<Object, Object> map;
        SessionFactory sessionFactory;
        SessionFactory sessionFactory2 = null;
        Serializable serializable = sessionFactoryMap;
        synchronized (serializable) {
            sessionFactory2 = sessionFactoryMap.get(pSDBServer.getPSDBServerId());
            if (sessionFactory2 != null) {
                return sessionFactory2;
            }
        }
        serializable = null;
        IService iService = psDBTypeMap;
        synchronized (iService) {
            serializable = psDBTypeMap.get(pSDBServer.getDBType());
        }
        if (serializable == null) {
            serializable = new PSDBType();
            ((PSDBTypeBase)serializable).setPSDBTypeId(pSDBServer.getDBType());
            iService = ServiceGlobal.getService(PSDBTypeService.class);
            iService.get((IEntity)serializable);
            HashMap<String, PSDBType> hashMap = psDBTypeMap;
            synchronized (hashMap) {
                sessionFactory = psDBTypeMap.get(pSDBServer.getDBType());
                if (sessionFactory != null) {
                    serializable = sessionFactory;
                } else {
                    psDBTypeMap.put(pSDBServer.getDBType(), (PSDBType)serializable);
                }
            }
        }
        iService = null;
        boolean bl = false;
        sessionFactory = sessionFactoryConfigurationMap;
        synchronized (sessionFactory) {
            iService = sessionFactoryConfigurationMap.get(pSDBServer.getPSDBServerId());
            if (iService == null) {
                map = new Properties();
                ((Properties)map).put("hibernate.show_sql", "true");
                ((Properties)map).put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
                ((Properties)map).put("jdbc.driverClassName", ((PSDBTypeBase)serializable).getJdbcDriverName());
                ((Properties)map).put("jdbc.url", StringHelper.format((String)pSDBServer.getDBUrl(), (Object)"mysql"));
                ((Properties)map).put("jdbc.user", pSDBServer.getDBUserName());
                ((Properties)map).put("jdbc.pass", pSDBServer.getDBPasswd());
                ((Properties)map).put("jdbc.initialPoolSize", "2");
                ((Properties)map).put("jdbc.maxPoolSize", "20");
                ((Properties)map).put("jdbc.minPoolSize", "2");
                ((Properties)map).put("jdbc.maxIdleTime", "60");
                ((Properties)map).put("jdbc.maxStatements", "50");
                ((Properties)map).put("jdbc.maxStatements", "0");
                ((Properties)map).put("hibernate.connection.driver_class", ((PSDBTypeBase)serializable).getJdbcDriverName());
                ((Properties)map).put("hibernate.connection.url", StringHelper.format((String)pSDBServer.getDBUrl(), (Object)"mysql"));
                ((Properties)map).put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
                ((Properties)map).put("hibernate.connection.username", pSDBServer.getDBUserName());
                ((Properties)map).put("hibernate.connection.password", pSDBServer.getDBPasswd());
                ((Properties)map).put("hibernate.c3p0.min_size", "2");
                ((Properties)map).put("hibernate.c3p0.max_size", "20");
                ((Properties)map).put("hibernate.c3p0.timeout", "120");
                ((Properties)map).put("hibernate.c3p0.max_statements", "0");
                ((Properties)map).put("hibernate.c3p0.preferredTestQuery", "select 1");
                ((Properties)map).put("hibernate.c3p0.idle_test_period", "90");
                ((Properties)map).put("hibernate.show_sql", "true");
                ((Properties)map).put("hibernate.hbm2ddl.auto", "create-drop");
                iService = new Configuration();
                iService.setProperties(map);
                sessionFactoryConfigurationMap.put(pSDBServer.getPSDBServerId(), (Configuration)iService);
                bl = true;
            }
        }
        sessionFactory = sessionFactoryMap;
        synchronized (sessionFactory) {
            sessionFactory2 = sessionFactoryMap.get(pSDBServer.getPSDBServerId());
            if (sessionFactory2 != null) {
                return sessionFactory2;
            }
        }
        if (!bl) {
            throw new Exception("\u65e0\u6cd5\u6253\u5f00\u6a21\u578b\u8fde\u63a5");
        }
        sessionFactory2 = iService.buildSessionFactory();
        sessionFactory = null;
        map = sessionFactoryMap;
        synchronized (map) {
            SessionFactory sessionFactory3 = sessionFactoryMap.get(pSDBServer.getPSDBServerId());
            if (sessionFactory3 != null) {
                sessionFactory = sessionFactory2;
                sessionFactory2 = sessionFactory3;
            } else {
                sessionFactoryMap.put(pSDBServer.getPSDBServerId(), sessionFactory2);
                DAOGlobal.registerDBDialect((SessionFactory)sessionFactory2, (IDBDialect)((IDBDialect)ObjectHelper.create((String)((PSDBTypeBase)serializable).getJdbcDialect())));
            }
        }
        map = sessionFactoryConfigurationMap;
        synchronized (map) {
            sessionFactoryConfigurationMap.remove(pSDBServer.getPSDBServerId());
        }
        if (sessionFactory != null) {
            sessionFactory.close();
        }
        return sessionFactory2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void resetSessionFactory(String string) throws Exception {
        SessionFactory sessionFactory = null;
        HashMap<String, SessionFactory> hashMap = sessionFactoryMap;
        synchronized (hashMap) {
            sessionFactory = sessionFactoryMap.remove(string);
        }
        if (sessionFactory != null) {
            DAOGlobal.unregisterDBDialect((SessionFactory)sessionFactory);
            sessionFactory.close();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void resetAllSessionFactory() throws Exception {
        ArrayList<SessionFactory> arrayList = new ArrayList<SessionFactory>();
        HashMap<String, SessionFactory> hashMap = sessionFactoryMap;
        synchronized (hashMap) {
            arrayList.addAll(sessionFactoryMap.values());
        }
        for (SessionFactory sessionFactory : arrayList) {
            try {
                DAOGlobal.unregisterDBDialect((SessionFactory)sessionFactory);
                sessionFactory.close();
            }
            catch (Exception exception) {
                log.error((Object)StringHelper.format((String)"\u91ca\u653e\u4f1a\u8bdd\u5de5\u5382\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
            }
        }
    }
}

