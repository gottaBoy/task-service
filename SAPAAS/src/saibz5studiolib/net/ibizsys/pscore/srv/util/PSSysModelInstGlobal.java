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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.db.IDBDialect;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.exception.ErrorException;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.ObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSDBType;
import net.ibizsys.pscore.srv.config.entity.PSDBTypeBase;
import net.ibizsys.pscore.srv.config.service.PSDBTypeService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBServerBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInstBase;
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
        Serializable serializable = sessionFactoryMap;
        synchronized (serializable) {
            sessionFactory = sessionFactoryMap.get(string);
            if (sessionFactory != null) {
                if (sessionFactoryLastActiveMap.get(string) != ALWAYSACTIVE) {
                    sessionFactoryLastActiveMap.put(string, System.currentTimeMillis());
                }
                return sessionFactory;
            }
        }
        serializable = sessionFactoryPSSysModelInstMap.get(string);
        if (serializable == null) {
            serializable = new PSSysModelInst();
            ((PSSysModelInstBase)serializable).setPSSysModelInstId(string);
            PSSysModelInstService pSSysModelInstService = (PSSysModelInstService)ServiceGlobal.getService(PSSysModelInstService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            pSSysModelInstService.get((IEntity)serializable);
            if (!StringHelper.isNullOrEmpty((String)PSSysModelInstGlobal.getCurrentPSSvrDomainId()) && !StringHelper.isNullOrEmpty((String)((PSSysModelInstBase)serializable).getPSSvrDomainId()) && StringHelper.compare((String)((PSSysModelInstBase)serializable).getPSSvrDomainId(), (String)PSSysModelInstGlobal.getCurrentPSSvrDomainId(), (boolean)false) != 0) {
                throw new ErrorException(2, StringHelper.format((String)"\u65e0\u6cd5\u8bbf\u95ee\u8de8\u670d\u52a1\u57df\u6a21\u578b\u4ed3\u5e93"));
            }
            sessionFactoryPSSysModelInstMap.put(string, (PSSysModelInst)serializable);
        }
        return PSSysModelInstGlobal.getSessionFactory(serializable);
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
        Serializable serializable = sessionFactoryMap;
        synchronized (serializable) {
            sessionFactory = sessionFactoryMap.get(string);
            if (sessionFactory != null) {
                if (sessionFactoryLastActiveMap.get(string) != ALWAYSACTIVE) {
                    sessionFactoryLastActiveMap.put(string, System.currentTimeMillis());
                }
                return sessionFactory;
            }
        }
        serializable = new PSSysModelInst();
        ((PSSysModelInstBase)serializable).setPSSysModelInstId(string);
        PSSysModelInstService pSSysModelInstService = (PSSysModelInstService)ServiceGlobal.getService(PSSysModelInstService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        pSSysModelInstService.get((IEntity)serializable);
        if (!StringHelper.isNullOrEmpty((String)PSSysModelInstGlobal.getCurrentPSSvrDomainId()) && !StringHelper.isNullOrEmpty((String)((PSSysModelInstBase)serializable).getPSSvrDomainId()) && StringHelper.compare((String)((PSSysModelInstBase)serializable).getPSSvrDomainId(), (String)PSSysModelInstGlobal.getCurrentPSSvrDomainId(), (boolean)false) != 0) {
            throw new ErrorException(2, StringHelper.format((String)"\u65e0\u6cd5\u8bbf\u95ee\u8de8\u670d\u52a1\u57df\u6a21\u578b\u4ed3\u5e93"));
        }
        if (StringHelper.compare((String)((PSSysModelInstBase)serializable).getInstState(), (String)"30", (boolean)true) != 0) {
            throw new Exception("\u6a21\u578b\u5e93\u72b6\u6001\u4e0d\u6b63\u786e");
        }
        sessionFactoryPSSysModelInstMap.put(string, (PSSysModelInst)serializable);
        return PSSysModelInstGlobal.getSessionFactory((PSSysModelInst)serializable);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static SessionFactory getSessionFactory(PSSysModelInst pSSysModelInst) throws Exception {
        String string;
        Map<Object, Object> map;
        SessionFactory sessionFactory;
        Object object = null;
        Serializable serializable = sessionFactoryMap;
        synchronized (serializable) {
            object = sessionFactoryMap.get(pSSysModelInst.getPSSysModelInstId());
            if (object != null) {
                if (sessionFactoryLastActiveMap.get(pSSysModelInst.getPSSysModelInstId()) != ALWAYSACTIVE) {
                    sessionFactoryLastActiveMap.put(pSSysModelInst.getPSSysModelInstId(), System.currentTimeMillis());
                }
                return object;
            }
        }
        if (!StringHelper.isNullOrEmpty((String)PSSysModelInstGlobal.getCurrentPSSvrDomainId()) && !StringHelper.isNullOrEmpty((String)pSSysModelInst.getPSSvrDomainId()) && StringHelper.compare((String)pSSysModelInst.getPSSvrDomainId(), (String)PSSysModelInstGlobal.getCurrentPSSvrDomainId(), (boolean)false) != 0) {
            throw new ErrorException(2, StringHelper.format((String)"\u65e0\u6cd5\u8bbf\u95ee\u8de8\u670d\u52a1\u57df\u6a21\u578b\u4ed3\u5e93"));
        }
        if (PSSysModelInstGlobal.isEnableProxyMode() && StringHelper.compare((String)pSSysModelInst.getDBType(), (String)"MYSQL5", (boolean)true) == 0 && !StringHelper.isNullOrEmpty((String)pSSysModelInst.getPSDBServerId()) && (object = PSSysModelInstGlobal.getRawDBServerSessionFactory(pSSysModelInst.getPSDBServerId())) != null && object instanceof PSDBServerSessionFactoryImpl) {
            ((PSDBServerSessionFactoryImpl)object).setPSSysModelInst(pSSysModelInst);
            return object;
        }
        serializable = null;
        IService iService = psDBTypeMap;
        synchronized (iService) {
            serializable = psDBTypeMap.get(pSSysModelInst.getDBType());
        }
        if (serializable == null) {
            serializable = new PSDBType();
            ((PSDBTypeBase)serializable).setPSDBTypeId(pSSysModelInst.getDBType());
            iService = ServiceGlobal.getService(PSDBTypeService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            iService.get((IEntity)serializable);
            HashMap<String, PSDBType> hashMap = psDBTypeMap;
            synchronized (hashMap) {
                sessionFactory = psDBTypeMap.get(pSSysModelInst.getDBType());
                if (sessionFactory != null) {
                    serializable = sessionFactory;
                } else {
                    psDBTypeMap.put(pSSysModelInst.getDBType(), (PSDBType)serializable);
                }
            }
        }
        iService = null;
        boolean bl = false;
        sessionFactory = sessionFactoryConfigurationMap;
        synchronized (sessionFactory) {
            iService = sessionFactoryConfigurationMap.get(pSSysModelInst.getPSSysModelInstId());
            if (iService == null) {
                map = new Properties();
                ((Properties)map).put("hibernate.show_sql", "true");
                ((Properties)map).put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
                ((Properties)map).put("jdbc.driverClassName", ((PSDBTypeBase)serializable).getJdbcDriverName());
                ((Properties)map).put("jdbc.url", pSSysModelInst.getConnStr());
                ((Properties)map).put("jdbc.user", pSSysModelInst.getUserName());
                ((Properties)map).put("jdbc.pass", pSSysModelInst.getPassWD());
                string = "1";
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
                ((Properties)map).put("jdbc.initialPoolSize", string);
                ((Properties)map).put("jdbc.maxPoolSize", string2);
                ((Properties)map).put("jdbc.minPoolSize", string3);
                ((Properties)map).put("jdbc.maxIdleTime", "60");
                ((Properties)map).put("jdbc.maxStatements", "50");
                ((Properties)map).put("jdbc.maxStatements", "0");
                ((Properties)map).put("hibernate.connection.driver_class", ((PSDBTypeBase)serializable).getJdbcDriverName());
                ((Properties)map).put("hibernate.connection.url", pSSysModelInst.getConnStr());
                ((Properties)map).put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
                ((Properties)map).put("hibernate.connection.username", pSSysModelInst.getUserName());
                ((Properties)map).put("hibernate.connection.password", pSSysModelInst.getPassWD());
                ((Properties)map).put("hibernate.c3p0.min_size", string3);
                ((Properties)map).put("hibernate.c3p0.max_size", string2);
                ((Properties)map).put("hibernate.c3p0.timeout", "120");
                ((Properties)map).put("hibernate.c3p0.max_statements", "0");
                ((Properties)map).put("hibernate.c3p0.preferredTestQuery", "select 1");
                ((Properties)map).put("hibernate.c3p0.idle_test_period", "90");
                ((Properties)map).put("hibernate.show_sql", "true");
                ((Properties)map).put("hibernate.hbm2ddl.auto", "create-drop");
                iService = new Configuration();
                iService.setProperties(map);
                sessionFactoryConfigurationMap.put(pSSysModelInst.getPSSysModelInstId(), (Configuration)iService);
                bl = true;
            }
        }
        sessionFactory = sessionFactoryMap;
        synchronized (sessionFactory) {
            object = sessionFactoryMap.get(pSSysModelInst.getPSSysModelInstId());
            if (object != null) {
                if (sessionFactoryLastActiveMap.get(pSSysModelInst.getPSSysModelInstId()) != ALWAYSACTIVE) {
                    sessionFactoryLastActiveMap.put(pSSysModelInst.getPSSysModelInstId(), System.currentTimeMillis());
                }
                return object;
            }
        }
        if (!bl) {
            for (int i = 0; i < 20; ++i) {
                Thread.sleep(100L);
                map = sessionFactoryMap;
                synchronized (map) {
                    object = sessionFactoryMap.get(pSSysModelInst.getPSSysModelInstId());
                    if (object != null) {
                        if (sessionFactoryLastActiveMap.get(pSSysModelInst.getPSSysModelInstId()) != ALWAYSACTIVE) {
                            sessionFactoryLastActiveMap.put(pSSysModelInst.getPSSysModelInstId(), System.currentTimeMillis());
                        }
                        return object;
                    }
                    continue;
                }
            }
            throw new Exception("\u65e0\u6cd5\u6253\u5f00\u7cfb\u7edf\u6a21\u578b\u4ed3\u5e93\uff0c\u53ef\u80fd\u6b63\u5728\u52a0\u8f7d\u4e2d\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
        }
        object = iService.buildSessionFactory();
        sessionFactory = null;
        map = sessionFactoryMap;
        synchronized (map) {
            if (sessionFactoryLastActiveMap.get(pSSysModelInst.getPSSysModelInstId()) != ALWAYSACTIVE) {
                sessionFactoryLastActiveMap.put(pSSysModelInst.getPSSysModelInstId(), System.currentTimeMillis());
            }
            if ((string = sessionFactoryMap.get(pSSysModelInst.getPSSysModelInstId())) != null) {
                sessionFactory = object;
                object = string;
            } else {
                sessionFactoryMap.put(pSSysModelInst.getPSSysModelInstId(), (SessionFactory)object);
                sessionFactoryPSSysModelInstMap.put(pSSysModelInst.getPSSysModelInstId(), pSSysModelInst);
                DAOGlobal.registerDBDialect((SessionFactory)object, (IDBDialect)((IDBDialect)ObjectHelper.create((String)((PSDBTypeBase)serializable).getJdbcDialect())));
                log.debug((Object)StringHelper.format((String)"\u6302\u63a5\u7cfb\u7edf\u6a21\u578b\u5e93[%1$s]\u4f1a\u8bdd\u5de5\u5382\uff0c\u5f53\u524d\u6570\u91cf[%2$s]", (Object)pSSysModelInst.getPSSysModelInstId(), (Object)sessionFactoryMap.size()));
            }
        }
        map = sessionFactoryConfigurationMap;
        synchronized (map) {
            sessionFactoryConfigurationMap.remove(pSSysModelInst.getPSSysModelInstId());
        }
        if (sessionFactory != null) {
            sessionFactory.close();
        }
        return object;
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
            hashMap = sessionFactoryConfigurationMap;
            synchronized (hashMap) {
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
        String string2;
        Map<Object, Object> map;
        Object object;
        String string3 = StringHelper.format((String)"DBSERVER_%1$s", (Object)string);
        Object object2 = null;
        Serializable serializable = sessionFactoryMap;
        synchronized (serializable) {
            object2 = sessionFactoryMap.get(string3);
            if (object2 != null) {
                if (sessionFactoryLastActiveMap.get(string3) != ALWAYSACTIVE) {
                    sessionFactoryLastActiveMap.put(string3, System.currentTimeMillis());
                }
                return object2;
            }
        }
        serializable = new PSDBServer();
        ((PSDBServerBase)serializable).setPSDBServerId(string);
        IService iService = ServiceGlobal.getService(PSDBServerService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        if (!iService.get((IEntity)serializable, true)) {
            return null;
        }
        if (StringHelper.isNullOrEmpty((String)((PSDBServerBase)serializable).getDBUrl()) || StringHelper.isNullOrEmpty((String)((PSDBServerBase)serializable).getDBUserName()) || StringHelper.isNullOrEmpty((String)((PSDBServerBase)serializable).getDBPasswd())) {
            return null;
        }
        if (!StringHelper.isNullOrEmpty((String)PSSysModelInstGlobal.getCurrentPSSvrDomainId()) && !StringHelper.isNullOrEmpty((String)((PSDBServerBase)serializable).getPSSvrDomainId()) && StringHelper.compare((String)((PSDBServerBase)serializable).getPSSvrDomainId(), (String)PSSysModelInstGlobal.getCurrentPSSvrDomainId(), (boolean)false) != 0) {
            throw new ErrorException(2, StringHelper.format((String)"\u65e0\u6cd5\u8bbf\u95ee\u8de8\u670d\u52a1\u57df\u6a21\u578b\u4ed3\u5e93"));
        }
        Serializable serializable2 = null;
        IService iService2 = psDBTypeMap;
        synchronized (iService2) {
            serializable2 = psDBTypeMap.get(((PSDBServerBase)serializable).getDBType());
        }
        if (serializable2 == null) {
            serializable2 = new PSDBType();
            ((PSDBTypeBase)serializable2).setPSDBTypeId(((PSDBServerBase)serializable).getDBType());
            iService2 = ServiceGlobal.getService(PSDBTypeService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            iService2.get((IEntity)serializable2);
            HashMap<String, PSDBType> hashMap = psDBTypeMap;
            synchronized (hashMap) {
                object = psDBTypeMap.get(((PSDBServerBase)serializable).getDBType());
                if (object != null) {
                    serializable2 = object;
                } else {
                    psDBTypeMap.put(((PSDBServerBase)serializable).getDBType(), (PSDBType)serializable2);
                }
            }
        }
        iService2 = null;
        boolean bl = false;
        object = sessionFactoryConfigurationMap;
        synchronized (object) {
            iService2 = sessionFactoryConfigurationMap.get(string3);
            if (iService2 == null) {
                map = new Properties();
                ((Properties)map).put("hibernate.show_sql", "true");
                ((Properties)map).put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
                ((Properties)map).put("jdbc.driverClassName", ((PSDBTypeBase)serializable2).getJdbcDriverName());
                ((Properties)map).put("jdbc.url", StringHelper.format((String)((PSDBServerBase)serializable).getDBUrl(), (Object)""));
                ((Properties)map).put("jdbc.user", ((PSDBServerBase)serializable).getDBUserName());
                ((Properties)map).put("jdbc.pass", ((PSDBServerBase)serializable).getDBPasswd());
                string2 = "1";
                String string4 = "150";
                String string5 = "10";
                ((Properties)map).put("jdbc.initialPoolSize", string2);
                ((Properties)map).put("jdbc.maxPoolSize", string4);
                ((Properties)map).put("jdbc.minPoolSize", string5);
                ((Properties)map).put("jdbc.maxIdleTime", "60");
                ((Properties)map).put("jdbc.maxStatements", "50");
                ((Properties)map).put("jdbc.maxStatements", "0");
                ((Properties)map).put("hibernate.connection.driver_class", ((PSDBTypeBase)serializable2).getJdbcDriverName());
                ((Properties)map).put("hibernate.connection.url", StringHelper.format((String)((PSDBServerBase)serializable).getDBUrl(), (Object)""));
                ((Properties)map).put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
                ((Properties)map).put("hibernate.connection.username", ((PSDBServerBase)serializable).getDBUserName());
                ((Properties)map).put("hibernate.connection.password", ((PSDBServerBase)serializable).getDBPasswd());
                ((Properties)map).put("hibernate.c3p0.min_size", string5);
                ((Properties)map).put("hibernate.c3p0.max_size", string4);
                ((Properties)map).put("hibernate.c3p0.timeout", "120");
                ((Properties)map).put("hibernate.c3p0.max_statements", "0");
                ((Properties)map).put("hibernate.c3p0.preferredTestQuery", "select 1");
                ((Properties)map).put("hibernate.c3p0.idle_test_period", "30");
                ((Properties)map).put("hibernate.c3p0.testConnectionOnCheckout", "false");
                ((Properties)map).put("hibernate.c3p0.testConnectionOnCheckin", "true");
                ((Properties)map).put("hibernate.c3p0.idleConnectionTestPeriod", "30");
                ((Properties)map).put("hibernate.show_sql", "true");
                ((Properties)map).put("hibernate.hbm2ddl.auto", "create-drop");
                iService2 = new Configuration();
                iService2.setProperties(map);
                sessionFactoryConfigurationMap.put(string3, (Configuration)iService2);
                bl = true;
            }
        }
        object = sessionFactoryMap;
        synchronized (object) {
            object2 = sessionFactoryMap.get(string3);
            if (object2 != null) {
                if (sessionFactoryLastActiveMap.get(string3) != ALWAYSACTIVE) {
                    sessionFactoryLastActiveMap.put(string3, System.currentTimeMillis());
                }
                return object2;
            }
        }
        if (!bl) {
            for (int i = 0; i < 100; ++i) {
                Thread.sleep(100L);
                map = sessionFactoryMap;
                synchronized (map) {
                    object2 = sessionFactoryMap.get(string3);
                    if (object2 != null) {
                        if (sessionFactoryLastActiveMap.get(string3) != ALWAYSACTIVE) {
                            sessionFactoryLastActiveMap.put(string3, System.currentTimeMillis());
                        }
                        return object2;
                    }
                    continue;
                }
            }
            throw new Exception("\u65e0\u6cd5\u6253\u5f00\u7cfb\u7edf\u6a21\u578b\u4ed3\u5e93\uff0c\u53ef\u80fd\u6b63\u5728\u52a0\u8f7d\u4e2d\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
        }
        object2 = iService2.buildSessionFactory();
        object = new PSDBServerSessionFactoryImpl((PSDBServer)serializable, (SessionFactory)object2);
        object2 = object;
        object = null;
        map = sessionFactoryMap;
        synchronized (map) {
            if (sessionFactoryLastActiveMap.get(string3) != ALWAYSACTIVE) {
                sessionFactoryLastActiveMap.put(string3, System.currentTimeMillis());
            }
            if ((string2 = sessionFactoryMap.get(string3)) != null) {
                object = object2;
                object2 = string2;
            } else {
                sessionFactoryMap.put(string3, (SessionFactory)object2);
                sessionFactoryLastActiveMap.put(string3, ALWAYSACTIVE);
                DAOGlobal.registerDBDialect((SessionFactory)object2, (IDBDialect)((IDBDialect)ObjectHelper.create((String)((PSDBTypeBase)serializable2).getJdbcDialect())));
                log.debug((Object)StringHelper.format((String)"\u6302\u63a5\u7cfb\u7edf\u6a21\u578b\u5e93[%1$s]\u4f1a\u8bdd\u5de5\u5382\uff0c\u5f53\u524d\u6570\u91cf[%2$s]", (Object)string3, (Object)sessionFactoryMap.size()));
            }
        }
        map = sessionFactoryConfigurationMap;
        synchronized (map) {
            sessionFactoryConfigurationMap.remove(string3);
        }
        if (object != null) {
            object.close();
        }
        return object2;
    }

    public static void setCurrentPSSvrDomainId(String string) {
        strPSSvrDomainId = string;
    }

    public static String getCurrentPSSvrDomainId() {
        return strPSSvrDomainId;
    }
}

