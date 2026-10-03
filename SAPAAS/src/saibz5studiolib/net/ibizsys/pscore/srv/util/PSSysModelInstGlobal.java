/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.db.IDBDialect
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.exception.ErrorException
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
import java.util.Map;
import java.util.Properties;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.db.IDBDialect;
import net.ibizsys.paas.exception.ErrorException;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.ObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSDBType;
import net.ibizsys.pscore.srv.config.service.PSDBTypeService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst;
import net.ibizsys.pscore.srv.paasmgr.service.PSDBServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService;
import net.ibizsys.pscore.srv.util.modelinst.PSDBServerSessionFactoryImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PSSysModelInstGlobal {
    private static final Log log = LogFactory.getLog(PSSysModelInstGlobal.class);
    protected static HashMap<String, SessionFactory> sessionFactoryMap = new HashMap();
    protected static HashMap<String, Configuration> sessionFactoryConfigurationMap = new HashMap();
    protected static HashMap<String, PSDBType> psDBTypeMap = new HashMap();
    protected static HashMap<String, Long> sessionFactoryLastActiveMap = new HashMap();
    protected static HashMap<String, PSSysModelInst> sessionFactoryPSSysModelInstMap = new HashMap();
    private static ThreadLocal<String> threadPSSysModelInstId = new ThreadLocal();
    public static final Long ALWAYSACTIVE = new Long(Long.MAX_VALUE);
    private static boolean bEnableProxyMode = false;
    private static String strPSSvrDomainId = null;

    public static String getCurrent() {
        return threadPSSysModelInstId.get();
    }

    public static void setCurrent(String string) {
        threadPSSysModelInstId.set(string);
    }

    public static void setEnableProxyMode(boolean bl) {
        bEnableProxyMode = bl;
    }

    public static boolean isEnableProxyMode() {
        return bEnableProxyMode;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static SessionFactory getSessionFactory(String string) throws Exception {
        if (StringHelper.isNullOrEmpty((String)string)) {
            return null;
        }
        SessionFactory sessionFactory = null;
        synchronized (sessionFactoryMap) {
            sessionFactory = sessionFactoryMap.get(string);
            if (sessionFactory != null) {
                if (sessionFactoryLastActiveMap.get(string) != ALWAYSACTIVE) {
                    sessionFactoryLastActiveMap.put(string, System.currentTimeMillis());
                }
                return sessionFactory;
            }
        }
        PSSysModelInst modelInst = sessionFactoryPSSysModelInstMap.get(string);
        if (modelInst == null) {
            modelInst = new PSSysModelInst();
            modelInst.setPSSysModelInstId(string);
            PSSysModelInstService pSSysModelInstService = (PSSysModelInstService)ServiceGlobal.getService(PSSysModelInstService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            pSSysModelInstService.get(modelInst);
            if (!StringHelper.isNullOrEmpty((String)PSSysModelInstGlobal.getCurrentPSSvrDomainId()) && !StringHelper.isNullOrEmpty((String)modelInst.getPSSvrDomainId()) && StringHelper.compare((String)modelInst.getPSSvrDomainId(), (String)PSSysModelInstGlobal.getCurrentPSSvrDomainId(), (boolean)false) != 0) {
                throw new ErrorException(2, StringHelper.format((String)"\u65e0\u6cd5\u8bbf\u95ee\u8de8\u670d\u52a1\u57df\u6a21\u578b\u4ed3\u5e93"));
            }
            sessionFactoryPSSysModelInstMap.put(string, modelInst);
        }
        return PSSysModelInstGlobal.getSessionFactory(modelInst);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static SessionFactory getSessionFactory(String string, boolean bl) throws Exception {
        if (!bl) {
            return PSSysModelInstGlobal.getSessionFactory(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            return null;
        }
        SessionFactory sessionFactory = null;
        synchronized (sessionFactoryMap) {
            sessionFactory = sessionFactoryMap.get(string);
            if (sessionFactory != null) {
                if (sessionFactoryLastActiveMap.get(string) != ALWAYSACTIVE) {
                    sessionFactoryLastActiveMap.put(string, System.currentTimeMillis());
                }
                return sessionFactory;
            }
        }
        PSSysModelInst modelInst = new PSSysModelInst();
        modelInst.setPSSysModelInstId(string);
        PSSysModelInstService pSSysModelInstService = (PSSysModelInstService)ServiceGlobal.getService(PSSysModelInstService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        pSSysModelInstService.get(modelInst);
        if (!StringHelper.isNullOrEmpty((String)PSSysModelInstGlobal.getCurrentPSSvrDomainId()) && !StringHelper.isNullOrEmpty((String)modelInst.getPSSvrDomainId()) && StringHelper.compare((String)modelInst.getPSSvrDomainId(), (String)PSSysModelInstGlobal.getCurrentPSSvrDomainId(), (boolean)false) != 0) {
            throw new ErrorException(2, StringHelper.format((String)"\u65e0\u6cd5\u8bbf\u95ee\u8de8\u670d\u52a1\u57df\u6a21\u578b\u4ed3\u5e93"));
        }
        if (StringHelper.compare((String)modelInst.getInstState(), (String)"30", (boolean)true) != 0) {
            throw new Exception("\u6a21\u578b\u5e93\u72b6\u6001\u4e0d\u6b63\u786e");
        }
        sessionFactoryPSSysModelInstMap.put(string, modelInst);
        return PSSysModelInstGlobal.getSessionFactory(modelInst);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static SessionFactory getSessionFactory(PSSysModelInst pSSysModelInst) throws Exception {
        SessionFactory factory;
        synchronized (sessionFactoryMap) {
            factory = sessionFactoryMap.get(pSSysModelInst.getPSSysModelInstId());
            if (factory != null) {
                if (sessionFactoryLastActiveMap.get(pSSysModelInst.getPSSysModelInstId()) != ALWAYSACTIVE) {
                    sessionFactoryLastActiveMap.put(pSSysModelInst.getPSSysModelInstId(), System.currentTimeMillis());
                }
                return factory;
            }
        }
        if (!StringHelper.isNullOrEmpty((String)PSSysModelInstGlobal.getCurrentPSSvrDomainId()) && !StringHelper.isNullOrEmpty((String)pSSysModelInst.getPSSvrDomainId()) && StringHelper.compare((String)pSSysModelInst.getPSSvrDomainId(), (String)PSSysModelInstGlobal.getCurrentPSSvrDomainId(), (boolean)false) != 0) {
            throw new ErrorException(2, StringHelper.format((String)"\u65e0\u6cd5\u8bbf\u95ee\u8de8\u670d\u52a1\u57df\u6a21\u578b\u4ed3\u5e93"));
        }
        if (PSSysModelInstGlobal.isEnableProxyMode() && StringHelper.compare((String)pSSysModelInst.getDBType(), (String)"MYSQL5", (boolean)true) == 0 && !StringHelper.isNullOrEmpty((String)pSSysModelInst.getPSDBServerId()) && (factory = PSSysModelInstGlobal.getRawDBServerSessionFactory(pSSysModelInst.getPSDBServerId())) instanceof PSDBServerSessionFactoryImpl) {
            ((PSDBServerSessionFactoryImpl)factory).setPSSysModelInst(pSSysModelInst);
            return factory;
        }
        PSDBType dbType;
        synchronized (psDBTypeMap) {
            dbType = psDBTypeMap.get(pSSysModelInst.getDBType());
        }
        if (dbType == null) {
            dbType = new PSDBType();
            dbType.setPSDBTypeId(pSSysModelInst.getDBType());
            PSDBTypeService service = (PSDBTypeService)ServiceGlobal.getService(PSDBTypeService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            service.get(dbType);
            synchronized (psDBTypeMap) {
                PSDBType cached = psDBTypeMap.get(pSSysModelInst.getDBType());
                if (cached != null) {
                    dbType = cached;
                } else {
                    psDBTypeMap.put(pSSysModelInst.getDBType(), dbType);
                }
            }
        }
        Configuration configuration;
        boolean createdConfiguration = false;
        synchronized (sessionFactoryConfigurationMap) {
            configuration = sessionFactoryConfigurationMap.get(pSSysModelInst.getPSSysModelInstId());
            if (configuration == null) {
                Properties properties = new Properties();
                properties.put("hibernate.show_sql", "true");
                properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
                properties.put("jdbc.driverClassName", dbType.getJdbcDriverName());
                properties.put("jdbc.url", pSSysModelInst.getConnStr());
                properties.put("jdbc.user", pSSysModelInst.getUserName());
                properties.put("jdbc.pass", pSSysModelInst.getPassWD());
                String string = "1";
                String string2 = "20";
                String string3 = "1";
                if (pSSysModelInst.getInitPoolSize() != null) {
                    string = Integer.toString(pSSysModelInst.getInitPoolSize());
                }
                if (pSSysModelInst.getMaxPoolSize() != null) {
                    string2 = Integer.toString(pSSysModelInst.getMaxPoolSize());
                }
                if (pSSysModelInst.getMinPoolSize() != null) {
                    string3 = Integer.toString(pSSysModelInst.getMinPoolSize());
                }
                properties.put("jdbc.initialPoolSize", string);
                properties.put("jdbc.maxPoolSize", string2);
                properties.put("jdbc.minPoolSize", string3);
                properties.put("jdbc.maxIdleTime", "60");
                properties.put("jdbc.maxStatements", "50");
                properties.put("jdbc.maxStatements", "0");
                properties.put("hibernate.connection.driver_class", dbType.getJdbcDriverName());
                properties.put("hibernate.connection.url", pSSysModelInst.getConnStr());
                properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
                properties.put("hibernate.connection.username", pSSysModelInst.getUserName());
                properties.put("hibernate.connection.password", pSSysModelInst.getPassWD());
                properties.put("hibernate.c3p0.min_size", string3);
                properties.put("hibernate.c3p0.max_size", string2);
                properties.put("hibernate.c3p0.timeout", "120");
                properties.put("hibernate.c3p0.max_statements", "0");
                properties.put("hibernate.c3p0.preferredTestQuery", "select 1");
                properties.put("hibernate.c3p0.idle_test_period", "90");
                properties.put("hibernate.show_sql", "true");
                properties.put("hibernate.hbm2ddl.auto", "create-drop");
                configuration = new Configuration();
                configuration.setProperties(properties);
                sessionFactoryConfigurationMap.put(pSSysModelInst.getPSSysModelInstId(), configuration);
                createdConfiguration = true;
            }
        }
        synchronized (sessionFactoryMap) {
            factory = sessionFactoryMap.get(pSSysModelInst.getPSSysModelInstId());
            if (factory != null) {
                if (sessionFactoryLastActiveMap.get(pSSysModelInst.getPSSysModelInstId()) != ALWAYSACTIVE) {
                    sessionFactoryLastActiveMap.put(pSSysModelInst.getPSSysModelInstId(), System.currentTimeMillis());
                }
                return factory;
            }
        }
        if (!createdConfiguration) {
            for (int i = 0; i < 20; ++i) {
                Thread.sleep(100L);
                synchronized (sessionFactoryMap) {
                    factory = sessionFactoryMap.get(pSSysModelInst.getPSSysModelInstId());
                    if (factory != null) {
                        if (sessionFactoryLastActiveMap.get(pSSysModelInst.getPSSysModelInstId()) != ALWAYSACTIVE) {
                            sessionFactoryLastActiveMap.put(pSSysModelInst.getPSSysModelInstId(), System.currentTimeMillis());
                        }
                        return factory;
                    }
                }
            }
            throw new Exception("\u65e0\u6cd5\u6253\u5f00\u7cfb\u7edf\u6a21\u578b\u4ed3\u5e93\uff0c\u53ef\u80fd\u6b63\u5728\u52a0\u8f7d\u4e2d\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
        }
        factory = configuration.buildSessionFactory();
        SessionFactory redundantFactory = null;
        synchronized (sessionFactoryMap) {
            if (sessionFactoryLastActiveMap.get(pSSysModelInst.getPSSysModelInstId()) != ALWAYSACTIVE) {
                sessionFactoryLastActiveMap.put(pSSysModelInst.getPSSysModelInstId(), System.currentTimeMillis());
            }
            SessionFactory cached = sessionFactoryMap.get(pSSysModelInst.getPSSysModelInstId());
            if (cached != null) {
                redundantFactory = factory;
                factory = cached;
            } else {
                sessionFactoryMap.put(pSSysModelInst.getPSSysModelInstId(), factory);
                sessionFactoryPSSysModelInstMap.put(pSSysModelInst.getPSSysModelInstId(), pSSysModelInst);
                DAOGlobal.registerDBDialect(factory, (IDBDialect)ObjectHelper.create(dbType.getJdbcDialect()));
                log.debug((Object)StringHelper.format((String)"\u6302\u63a5\u7cfb\u7edf\u6a21\u578b\u5e93[%1$s]\u4f1a\u8bdd\u5de5\u5382\uff0c\u5f53\u524d\u6570\u91cf[%2$s]", (Object)pSSysModelInst.getPSSysModelInstId(), (Object)sessionFactoryMap.size()));
            }
        }
        synchronized (sessionFactoryConfigurationMap) {
            sessionFactoryConfigurationMap.remove(pSSysModelInst.getPSSysModelInstId());
        }
        if (redundantFactory != null) {
            redundantFactory.close();
        }
        return factory;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void resetSessionFactory(String string) throws Exception {
        SessionFactory sessionFactory = null;
        HashMap<String, SessionFactory> hashMap = sessionFactoryMap;
        synchronized (hashMap) {
            sessionFactory = sessionFactoryMap.remove(string);
            sessionFactoryLastActiveMap.remove(string);
            sessionFactoryPSSysModelInstMap.remove(string);
        }
        if (sessionFactory != null) {
            synchronized (sessionFactoryConfigurationMap) {
                sessionFactoryConfigurationMap.remove(string);
            }
            DAOGlobal.unregisterDBDialect((SessionFactory)sessionFactory);
            ServiceGlobal.resetServices((SessionFactory)sessionFactory);
            sessionFactory.close();
            log.debug((Object)StringHelper.format((String)"\u79fb\u9664\u7cfb\u7edf\u6a21\u578b\u5e93[%1$s]\u4f1a\u8bdd\u5de5\u5382\uff0c\u5f53\u524d\u6570\u91cf[%2$s]", (Object)string, (Object)sessionFactoryMap.size()));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void resetAllSessionFactory() throws Exception {
        ArrayList<SessionFactory> arrayList = new ArrayList<SessionFactory>();
        Object object = sessionFactoryConfigurationMap;
        synchronized (object) {
            sessionFactoryConfigurationMap.clear();
        }
        object = sessionFactoryMap;
        synchronized (object) {
            arrayList.addAll(sessionFactoryMap.values());
            sessionFactoryMap.clear();
            sessionFactoryLastActiveMap.clear();
            sessionFactoryPSSysModelInstMap.clear();
        }
        for (SessionFactory sessionFactory : arrayList) {
            try {
                DAOGlobal.unregisterDBDialect((SessionFactory)sessionFactory);
                ServiceGlobal.resetServices((SessionFactory)sessionFactory);
                sessionFactory.close();
            }
            catch (Exception exception) {
                log.error((Object)StringHelper.format((String)"\u91ca\u653e\u4f1a\u8bdd\u5de5\u5382\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
            }
        }
    }

    public static int getSessionFactoryCount() {
        return sessionFactoryMap.size();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void remove(long l) {
        long l2 = System.currentTimeMillis();
        HashMap<String, Long> hashMap = new HashMap<String, Long>();
        HashMap<String, SessionFactory> hashMap2 = sessionFactoryMap;
        synchronized (hashMap2) {
            for (Map.Entry<String, Long> entry : sessionFactoryLastActiveMap.entrySet()) {
                if (entry.getValue() == ALWAYSACTIVE || entry.getValue() == null || entry.getValue() + l >= l2) continue;
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry.getValue() == null || (Long)entry.getValue() + l >= l2) continue;
            try {
                PSSysModelInstGlobal.resetSessionFactory((String)entry.getKey());
            }
            catch (Exception exception) {
                log.error((Object)exception);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void active(String string) {
        HashMap<String, SessionFactory> hashMap = sessionFactoryMap;
        synchronized (hashMap) {
            if (sessionFactoryLastActiveMap.get(string) != ALWAYSACTIVE) {
                sessionFactoryLastActiveMap.put(string, System.currentTimeMillis());
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void activeAlways(String string) {
        HashMap<String, SessionFactory> hashMap = sessionFactoryMap;
        synchronized (hashMap) {
            sessionFactoryLastActiveMap.put(string, ALWAYSACTIVE);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static PSSysModelInst getPSSysModelInst(String string) {
        HashMap<String, SessionFactory> hashMap = sessionFactoryMap;
        synchronized (hashMap) {
            return sessionFactoryPSSysModelInstMap.get(string);
        }
    }

    public static SessionFactory getDBServerSessionFactory(String string) throws Exception {
        PSDBServerSessionFactoryImpl pSDBServerSessionFactoryImpl = (PSDBServerSessionFactoryImpl)PSSysModelInstGlobal.getRawDBServerSessionFactory(string);
        PSSysModelInst pSSysModelInst = new PSSysModelInst();
        pSSysModelInst.setDBName("SRFNODB");
        pSSysModelInst.setPSSysModelInstId("SRFNODB");
        pSSysModelInst.setPSSysModelInstName("SRFNODB");
        pSDBServerSessionFactoryImpl.setPSSysModelInst(pSSysModelInst);
        return pSDBServerSessionFactoryImpl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static SessionFactory getRawDBServerSessionFactory(String string) throws Exception {
        String string3 = StringHelper.format((String)"DBSERVER_%1$s", (Object)string);
        SessionFactory factory;
        synchronized (sessionFactoryMap) {
            factory = sessionFactoryMap.get(string3);
            if (factory != null) {
                if (sessionFactoryLastActiveMap.get(string3) != ALWAYSACTIVE) {
                    sessionFactoryLastActiveMap.put(string3, System.currentTimeMillis());
                }
                return factory;
            }
        }
        PSDBServer dbServer = new PSDBServer();
        dbServer.setPSDBServerId(string);
        PSDBServerService service = (PSDBServerService)ServiceGlobal.getService(PSDBServerService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        if (!service.get(dbServer, true)) {
            return null;
        }
        if (StringHelper.isNullOrEmpty((String)dbServer.getDBUrl()) || StringHelper.isNullOrEmpty((String)dbServer.getDBUserName()) || StringHelper.isNullOrEmpty((String)dbServer.getDBPasswd())) {
            return null;
        }
        if (!StringHelper.isNullOrEmpty((String)PSSysModelInstGlobal.getCurrentPSSvrDomainId()) && !StringHelper.isNullOrEmpty((String)dbServer.getPSSvrDomainId()) && StringHelper.compare((String)dbServer.getPSSvrDomainId(), (String)PSSysModelInstGlobal.getCurrentPSSvrDomainId(), (boolean)false) != 0) {
            throw new ErrorException(2, StringHelper.format((String)"\u65e0\u6cd5\u8bbf\u95ee\u8de8\u670d\u52a1\u57df\u6a21\u578b\u4ed3\u5e93"));
        }
        PSDBType dbType;
        synchronized (psDBTypeMap) {
            dbType = psDBTypeMap.get(dbServer.getDBType());
        }
        if (dbType == null) {
            dbType = new PSDBType();
            dbType.setPSDBTypeId(dbServer.getDBType());
            PSDBTypeService typeService = (PSDBTypeService)ServiceGlobal.getService(PSDBTypeService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            typeService.get(dbType);
            synchronized (psDBTypeMap) {
                PSDBType cached = psDBTypeMap.get(dbServer.getDBType());
                if (cached != null) {
                    dbType = cached;
                } else {
                    psDBTypeMap.put(dbServer.getDBType(), dbType);
                }
            }
        }
        Configuration configuration;
        boolean createdConfiguration = false;
        synchronized (sessionFactoryConfigurationMap) {
            configuration = sessionFactoryConfigurationMap.get(string3);
            if (configuration == null) {
                Properties properties = new Properties();
                properties.put("hibernate.show_sql", "true");
                properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
                properties.put("jdbc.driverClassName", dbType.getJdbcDriverName());
                properties.put("jdbc.url", StringHelper.format((String)dbServer.getDBUrl(), (Object)""));
                properties.put("jdbc.user", dbServer.getDBUserName());
                properties.put("jdbc.pass", dbServer.getDBPasswd());
                String string2 = "1";
                String string4 = "150";
                String string5 = "10";
                properties.put("jdbc.initialPoolSize", string2);
                properties.put("jdbc.maxPoolSize", string4);
                properties.put("jdbc.minPoolSize", string5);
                properties.put("jdbc.maxIdleTime", "60");
                properties.put("jdbc.maxStatements", "50");
                properties.put("jdbc.maxStatements", "0");
                properties.put("hibernate.connection.driver_class", dbType.getJdbcDriverName());
                properties.put("hibernate.connection.url", StringHelper.format((String)dbServer.getDBUrl(), (Object)""));
                properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
                properties.put("hibernate.connection.username", dbServer.getDBUserName());
                properties.put("hibernate.connection.password", dbServer.getDBPasswd());
                properties.put("hibernate.c3p0.min_size", string5);
                properties.put("hibernate.c3p0.max_size", string4);
                properties.put("hibernate.c3p0.timeout", "120");
                properties.put("hibernate.c3p0.max_statements", "0");
                properties.put("hibernate.c3p0.preferredTestQuery", "select 1");
                properties.put("hibernate.c3p0.idle_test_period", "30");
                properties.put("hibernate.c3p0.testConnectionOnCheckout", "false");
                properties.put("hibernate.c3p0.testConnectionOnCheckin", "true");
                properties.put("hibernate.c3p0.idleConnectionTestPeriod", "30");
                properties.put("hibernate.show_sql", "true");
                properties.put("hibernate.hbm2ddl.auto", "create-drop");
                configuration = new Configuration();
                configuration.setProperties(properties);
                sessionFactoryConfigurationMap.put(string3, configuration);
                createdConfiguration = true;
            }
        }
        synchronized (sessionFactoryMap) {
            factory = sessionFactoryMap.get(string3);
            if (factory != null) {
                if (sessionFactoryLastActiveMap.get(string3) != ALWAYSACTIVE) {
                    sessionFactoryLastActiveMap.put(string3, System.currentTimeMillis());
                }
                return factory;
            }
        }
        if (!createdConfiguration) {
            for (int i = 0; i < 100; ++i) {
                Thread.sleep(100L);
                synchronized (sessionFactoryMap) {
                    factory = sessionFactoryMap.get(string3);
                    if (factory != null) {
                        if (sessionFactoryLastActiveMap.get(string3) != ALWAYSACTIVE) {
                            sessionFactoryLastActiveMap.put(string3, System.currentTimeMillis());
                        }
                        return factory;
                    }
                }
            }
            throw new Exception("\u65e0\u6cd5\u6253\u5f00\u7cfb\u7edf\u6a21\u578b\u4ed3\u5e93\uff0c\u53ef\u80fd\u6b63\u5728\u52a0\u8f7d\u4e2d\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
        }
        factory = new PSDBServerSessionFactoryImpl(dbServer, configuration.buildSessionFactory());
        SessionFactory redundantFactory = null;
        synchronized (sessionFactoryMap) {
            if (sessionFactoryLastActiveMap.get(string3) != ALWAYSACTIVE) {
                sessionFactoryLastActiveMap.put(string3, System.currentTimeMillis());
            }
            SessionFactory cached = sessionFactoryMap.get(string3);
            if (cached != null) {
                redundantFactory = factory;
                factory = cached;
            } else {
                sessionFactoryMap.put(string3, factory);
                sessionFactoryLastActiveMap.put(string3, ALWAYSACTIVE);
                DAOGlobal.registerDBDialect(factory, (IDBDialect)ObjectHelper.create(dbType.getJdbcDialect()));
                log.debug((Object)StringHelper.format((String)"\u6302\u63a5\u7cfb\u7edf\u6a21\u578b\u5e93[%1$s]\u4f1a\u8bdd\u5de5\u5382\uff0c\u5f53\u524d\u6570\u91cf[%2$s]", (Object)string3, (Object)sessionFactoryMap.size()));
            }
        }
        synchronized (sessionFactoryConfigurationMap) {
            sessionFactoryConfigurationMap.remove(string3);
        }
        if (redundantFactory != null) {
            redundantFactory.close();
        }
        return factory;
    }

    public static void setCurrentPSSvrDomainId(String string) {
        strPSSvrDomainId = string;
    }

    public static String getCurrentPSSvrDomainId() {
        return strPSSvrDomainId;
    }
}
