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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.db.IDBDialect;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.ObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.config.entity.PSDBType;
import net.ibizsys.pscore.srv.config.service.PSDBTypeService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBServer;
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
        synchronized (sessionFactoryMap) {
            SessionFactory sessionFactory = sessionFactoryMap.get(string);
            if (sessionFactory != null) {
                return sessionFactory;
            }
        }
        PSDBServer pSDBServer = new PSDBServer();
        pSDBServer.setPSDBServerId(string);
        PSDBServerService pSDBServerService = (PSDBServerService)ServiceGlobal.getService(PSDBServerService.class);
        pSDBServerService.get(pSDBServer);
        return PSDBServerGlobal.getSessionFactory(pSDBServer);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static SessionFactory getSessionFactory(PSDBServer pSDBServer) throws Exception {
        SessionFactory sessionFactory = null;
        SessionFactory sessionFactory2 = null;
        synchronized (sessionFactoryMap) {
            sessionFactory2 = sessionFactoryMap.get(pSDBServer.getPSDBServerId());
            if (sessionFactory2 != null) {
                return sessionFactory2;
            }
        }
        PSDBType psDBType;
        synchronized (psDBTypeMap) {
            psDBType = psDBTypeMap.get(pSDBServer.getDBType());
        }
        if (psDBType == null) {
            psDBType = new PSDBType();
            psDBType.setPSDBTypeId(pSDBServer.getDBType());
            PSDBTypeService psDBTypeService = (PSDBTypeService)ServiceGlobal.getService(PSDBTypeService.class);
            psDBTypeService.get(psDBType);
            synchronized (psDBTypeMap) {
                PSDBType cachedDBType = psDBTypeMap.get(pSDBServer.getDBType());
                if (cachedDBType != null) {
                    psDBType = cachedDBType;
                } else {
                    psDBTypeMap.put(pSDBServer.getDBType(), psDBType);
                }
            }
        }
        Configuration configuration;
        boolean bl = false;
        synchronized (sessionFactoryConfigurationMap) {
            configuration = sessionFactoryConfigurationMap.get(pSDBServer.getPSDBServerId());
            if (configuration == null) {
                Properties properties = new Properties();
                properties.put("hibernate.show_sql", "true");
                properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
                properties.put("jdbc.driverClassName", psDBType.getJdbcDriverName());
                properties.put("jdbc.url", StringHelper.format((String)pSDBServer.getDBUrl(), (Object)"mysql"));
                properties.put("jdbc.user", pSDBServer.getDBUserName());
                properties.put("jdbc.pass", pSDBServer.getDBPasswd());
                properties.put("jdbc.initialPoolSize", "2");
                properties.put("jdbc.maxPoolSize", "20");
                properties.put("jdbc.minPoolSize", "2");
                properties.put("jdbc.maxIdleTime", "60");
                properties.put("jdbc.maxStatements", "50");
                properties.put("jdbc.maxStatements", "0");
                properties.put("hibernate.connection.driver_class", psDBType.getJdbcDriverName());
                properties.put("hibernate.connection.url", StringHelper.format((String)pSDBServer.getDBUrl(), (Object)"mysql"));
                properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
                properties.put("hibernate.connection.username", pSDBServer.getDBUserName());
                properties.put("hibernate.connection.password", pSDBServer.getDBPasswd());
                properties.put("hibernate.c3p0.min_size", "2");
                properties.put("hibernate.c3p0.max_size", "20");
                properties.put("hibernate.c3p0.timeout", "120");
                properties.put("hibernate.c3p0.max_statements", "0");
                properties.put("hibernate.c3p0.preferredTestQuery", "select 1");
                properties.put("hibernate.c3p0.idle_test_period", "90");
                properties.put("hibernate.show_sql", "true");
                properties.put("hibernate.hbm2ddl.auto", "create-drop");
                configuration = new Configuration();
                configuration.setProperties(properties);
                sessionFactoryConfigurationMap.put(pSDBServer.getPSDBServerId(), configuration);
                bl = true;
            }
        }
        synchronized (sessionFactoryMap) {
            sessionFactory2 = sessionFactoryMap.get(pSDBServer.getPSDBServerId());
            if (sessionFactory2 != null) {
                return sessionFactory2;
            }
        }
        if (!bl) {
            throw new Exception("\u65e0\u6cd5\u6253\u5f00\u6a21\u578b\u8fde\u63a5");
        }
        sessionFactory2 = configuration.buildSessionFactory();
        synchronized (sessionFactoryMap) {
            SessionFactory sessionFactory3 = sessionFactoryMap.get(pSDBServer.getPSDBServerId());
            if (sessionFactory3 != null) {
                sessionFactory = sessionFactory2;
                sessionFactory2 = sessionFactory3;
            } else {
                sessionFactoryMap.put(pSDBServer.getPSDBServerId(), sessionFactory2);
                DAOGlobal.registerDBDialect((SessionFactory)sessionFactory2, (IDBDialect)((IDBDialect)ObjectHelper.create((String)psDBType.getJdbcDialect())));
            }
        }
        synchronized (sessionFactoryConfigurationMap) {
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

