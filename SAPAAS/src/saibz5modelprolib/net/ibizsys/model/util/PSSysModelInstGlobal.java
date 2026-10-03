/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.db.IDBDialect
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.ObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.hibernate.cfg.Configuration
 */
package net.ibizsys.model.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import net.ibizsys.model.PSModelQueryHelperFactory;
import net.ibizsys.model.entity.PSDBType;
import net.ibizsys.model.entity.PSSysModelInst;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.db.IDBDialect;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.ObjectHelper;
import net.ibizsys.paas.util.StringHelper;
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

    public static String getCurrent() {
        return threadPSSysModelInstId.get();
    }

    public static void setCurrent(String strPSSysModelInstId) {
        threadPSSysModelInstId.set(strPSSysModelInstId);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static SessionFactory getSessionFactory(String strPSSysModelInstId) throws Exception {
        if (StringHelper.isNullOrEmpty((String)strPSSysModelInstId)) {
            return null;
        }
        SessionFactory sessionFactory = null;
        HashMap<String, SessionFactory> hashMap = sessionFactoryMap;
        synchronized (hashMap) {
            sessionFactory = sessionFactoryMap.get(strPSSysModelInstId);
            if (sessionFactory != null) {
                if (sessionFactoryLastActiveMap.get(strPSSysModelInstId) != ALWAYSACTIVE) {
                    sessionFactoryLastActiveMap.put(strPSSysModelInstId, System.currentTimeMillis());
                }
                return sessionFactory;
            }
        }
        PSSysModelInst psSysModelInst = new PSSysModelInst();
        CallResult callResult = PSModelQueryHelperFactory.getInstance().getPSSysModelInst(strPSSysModelInstId, psSysModelInst);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u6a21\u578b\u5e93\u5b9e\u4f8b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return PSSysModelInstGlobal.getSessionFactory(psSysModelInst);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static SessionFactory getSessionFactory(PSSysModelInst psSysModelInst) throws Exception {
        HashMap<String, SessionFactory> hashMap;
        Object psDBType2;
        SessionFactory sessionFactory = null;
        HashMap<String, SessionFactory> hashMap2 = sessionFactoryMap;
        synchronized (hashMap2) {
            sessionFactory = sessionFactoryMap.get(psSysModelInst.getPSSYSMODELINSTID());
            if (sessionFactory != null) {
                if (sessionFactoryLastActiveMap.get(psSysModelInst.getPSSYSMODELINSTID()) != ALWAYSACTIVE) {
                    sessionFactoryLastActiveMap.put(psSysModelInst.getPSSYSMODELINSTID(), System.currentTimeMillis());
                }
                return sessionFactory;
            }
        }
        Object psDBType = null;
        HashMap<String, PSDBType> hashMap3 = psDBTypeMap;
        synchronized (hashMap3) {
            psDBType = psDBTypeMap.get(psSysModelInst.getDBTYPE());
        }
        if (psDBType == null) {
            psDBType = new PSDBType();
            CallResult callResult = PSModelQueryHelperFactory.getInstance().getPSDBType(psSysModelInst.getDBTYPE(), (PSDBType)((Object)psDBType));
            if (callResult.isError()) {
                throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u6570\u636e\u5e93\u7c7b\u578b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            HashMap<String, PSDBType> hashMap4 = psDBTypeMap;
            synchronized (hashMap4) {
                psDBType2 = psDBTypeMap.get(psSysModelInst.getDBTYPE());
                if (psDBType2 != null) {
                    psDBType = psDBType2;
                } else {
                    psDBTypeMap.put(psSysModelInst.getDBTYPE(), (PSDBType)((Object)psDBType));
                }
            }
        }
        Configuration cfg = null;
        boolean bCreateCfg = false;
        psDBType2 = sessionFactoryConfigurationMap;
        synchronized (psDBType2) {
            cfg = sessionFactoryConfigurationMap.get(psSysModelInst.getPSSYSMODELINSTID());
            if (cfg == null) {
                Properties hibernateProperties = new Properties();
                hibernateProperties.put("hibernate.show_sql", "true");
                hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
                hibernateProperties.put("jdbc.driverClassName", ((PSDBType)((Object)psDBType)).getJDBCDRIVERNAME());
                hibernateProperties.put("jdbc.url", psSysModelInst.getCONNSTR());
                hibernateProperties.put("jdbc.user", psSysModelInst.getUSERNAME());
                hibernateProperties.put("jdbc.pass", psSysModelInst.getPASSWD());
                String nInitSize = "1";
                String nMaxSize = "20";
                String nMinSize = "1";
                hibernateProperties.put("jdbc.initialPoolSize", nInitSize);
                hibernateProperties.put("jdbc.maxPoolSize", nMaxSize);
                hibernateProperties.put("jdbc.minPoolSize", nMinSize);
                hibernateProperties.put("jdbc.maxIdleTime", "60");
                hibernateProperties.put("jdbc.maxStatements", "50");
                hibernateProperties.put("jdbc.maxStatements", "0");
                hibernateProperties.put("hibernate.connection.driver_class", "org.gjt.mm.mysql.Driver");
                hibernateProperties.put("hibernate.connection.url", psSysModelInst.getCONNSTR());
                hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
                hibernateProperties.put("hibernate.connection.username", psSysModelInst.getUSERNAME());
                hibernateProperties.put("hibernate.connection.password", psSysModelInst.getPASSWD());
                hibernateProperties.put("hibernate.c3p0.min_size", nMinSize);
                hibernateProperties.put("hibernate.c3p0.max_size", nMaxSize);
                hibernateProperties.put("hibernate.c3p0.timeout", "120");
                hibernateProperties.put("hibernate.c3p0.max_statements", "0");
                hibernateProperties.put("hibernate.c3p0.preferredTestQuery", "select 1");
                hibernateProperties.put("hibernate.c3p0.idle_test_period", "90");
                hibernateProperties.put("hibernate.show_sql", "true");
                hibernateProperties.put("hibernate.hbm2ddl.auto", "create-drop");
                cfg = new Configuration();
                cfg.setProperties(hibernateProperties);
                sessionFactoryConfigurationMap.put(psSysModelInst.getPSSYSMODELINSTID(), cfg);
                bCreateCfg = true;
            }
        }
        psDBType2 = sessionFactoryMap;
        synchronized (psDBType2) {
            sessionFactory = sessionFactoryMap.get(psSysModelInst.getPSSYSMODELINSTID());
            if (sessionFactory != null) {
                if (sessionFactoryLastActiveMap.get(psSysModelInst.getPSSYSMODELINSTID()) != ALWAYSACTIVE) {
                    sessionFactoryLastActiveMap.put(psSysModelInst.getPSSYSMODELINSTID(), System.currentTimeMillis());
                }
                return sessionFactory;
            }
        }
        if (!bCreateCfg) {
            int i = 0;
            while (i < 20) {
                Thread.sleep(100L);
                hashMap = sessionFactoryMap;
                synchronized (hashMap) {
                    sessionFactory = sessionFactoryMap.get(psSysModelInst.getPSSYSMODELINSTID());
                    if (sessionFactory != null) {
                        if (sessionFactoryLastActiveMap.get(psSysModelInst.getPSSYSMODELINSTID()) != ALWAYSACTIVE) {
                            sessionFactoryLastActiveMap.put(psSysModelInst.getPSSYSMODELINSTID(), System.currentTimeMillis());
                        }
                        return sessionFactory;
                    }
                }
                ++i;
            }
            throw new Exception("\u65e0\u6cd5\u6253\u5f00\u7cfb\u7edf\u6a21\u578b\u4ed3\u5e93\uff0c\u53ef\u80fd\u6b63\u5728\u52a0\u8f7d\u4e2d\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
        }
        sessionFactory = cfg.buildSessionFactory();
        SessionFactory closeSessionFactory = null;
        hashMap = sessionFactoryMap;
        synchronized (hashMap) {
            SessionFactory sessionFactory2;
            if (sessionFactoryLastActiveMap.get(psSysModelInst.getPSSYSMODELINSTID()) != ALWAYSACTIVE) {
                sessionFactoryLastActiveMap.put(psSysModelInst.getPSSYSMODELINSTID(), System.currentTimeMillis());
            }
            if ((sessionFactory2 = sessionFactoryMap.get(psSysModelInst.getPSSYSMODELINSTID())) != null) {
                closeSessionFactory = sessionFactory;
                sessionFactory = sessionFactory2;
            } else {
                sessionFactoryMap.put(psSysModelInst.getPSSYSMODELINSTID(), sessionFactory);
                sessionFactoryPSSysModelInstMap.put(psSysModelInst.getPSSYSMODELINSTID(), psSysModelInst);
                DAOGlobal.registerDBDialect((SessionFactory)sessionFactory, (IDBDialect)((IDBDialect)ObjectHelper.create((String)((PSDBType)((Object)psDBType)).getJDBCDIALECT())));
                log.debug((Object)StringHelper.format((String)"\u6302\u63a5\u7cfb\u7edf\u6a21\u578b\u5e93[%1$s]\u4f1a\u8bdd\u5de5\u5382\uff0c\u5f53\u524d\u6570\u91cf[%2$s]", (Object)psSysModelInst.getPSSYSMODELINSTID(), (Object)sessionFactoryMap.size()));
            }
        }
        synchronized (sessionFactoryConfigurationMap) {
            sessionFactoryConfigurationMap.remove(psSysModelInst.getPSSYSMODELINSTID());
        }
        if (closeSessionFactory != null) {
            closeSessionFactory.close();
        }
        return sessionFactory;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void resetSessionFactory(String strPSSysModelInstId) throws Exception {
        SessionFactory sessionFactory = null;
        HashMap<String, SessionFactory> hashMap = sessionFactoryMap;
        synchronized (hashMap) {
            sessionFactory = sessionFactoryMap.remove(strPSSysModelInstId);
            sessionFactoryLastActiveMap.remove(strPSSysModelInstId);
            sessionFactoryPSSysModelInstMap.remove(strPSSysModelInstId);
        }
        if (sessionFactory != null) {
            synchronized (sessionFactoryConfigurationMap) {
                sessionFactoryConfigurationMap.remove(strPSSysModelInstId);
            }
            DAOGlobal.unregisterDBDialect((SessionFactory)sessionFactory);
            ServiceGlobal.resetServices((SessionFactory)sessionFactory);
            sessionFactory.close();
            log.debug((Object)StringHelper.format((String)"\u79fb\u9664\u7cfb\u7edf\u6a21\u578b\u5e93[%1$s]\u4f1a\u8bdd\u5de5\u5382\uff0c\u5f53\u524d\u6570\u91cf[%2$s]", (Object)strPSSysModelInstId, (Object)sessionFactoryMap.size()));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void resetAllSessionFactory() throws Exception {
        ArrayList<SessionFactory> sessionFactoryList = new ArrayList<SessionFactory>();
        synchronized (sessionFactoryConfigurationMap) {
            sessionFactoryConfigurationMap.clear();
        }
        synchronized (sessionFactoryMap) {
            sessionFactoryList.addAll(sessionFactoryMap.values());
            sessionFactoryMap.clear();
            sessionFactoryLastActiveMap.clear();
            sessionFactoryPSSysModelInstMap.clear();
        }
        for (SessionFactory sessionFactory : sessionFactoryList) {
            try {
                DAOGlobal.unregisterDBDialect((SessionFactory)sessionFactory);
                ServiceGlobal.resetServices((SessionFactory)sessionFactory);
                sessionFactory.close();
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.format((String)"\u91ca\u653e\u4f1a\u8bdd\u5de5\u5382\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            }
        }
    }

    public static int getSessionFactoryCount() {
        return sessionFactoryMap.size();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void remove(long nTime) {
        long nCurTime = System.currentTimeMillis();
        HashMap<String, Long> psSysModelInstMap = new HashMap<String, Long>();
        HashMap<String, SessionFactory> hashMap = sessionFactoryMap;
        synchronized (hashMap) {
            for (Map.Entry<String, Long> entry : sessionFactoryLastActiveMap.entrySet()) {
                if (entry.getValue() == ALWAYSACTIVE || entry.getValue() == null || entry.getValue() + nTime >= nCurTime) continue;
                psSysModelInstMap.put(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry entry : psSysModelInstMap.entrySet()) {
            if (entry.getValue() == null || (Long)entry.getValue() + nTime >= nCurTime) continue;
            try {
                PSSysModelInstGlobal.resetSessionFactory((String)entry.getKey());
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void active(String strPSSysModelInstId) {
        HashMap<String, SessionFactory> hashMap = sessionFactoryMap;
        synchronized (hashMap) {
            if (sessionFactoryLastActiveMap.get(strPSSysModelInstId) != ALWAYSACTIVE) {
                sessionFactoryLastActiveMap.put(strPSSysModelInstId, System.currentTimeMillis());
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void activeAlways(String strPSSysModelInstId) {
        HashMap<String, SessionFactory> hashMap = sessionFactoryMap;
        synchronized (hashMap) {
            sessionFactoryLastActiveMap.put(strPSSysModelInstId, ALWAYSACTIVE);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static PSSysModelInst getPSSysModelInst(String strPSSysModelInstId) {
        HashMap<String, SessionFactory> hashMap = sessionFactoryMap;
        synchronized (hashMap) {
            return sessionFactoryPSSysModelInstMap.get(strPSSysModelInstId);
        }
    }
}
