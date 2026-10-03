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
 *  net.ibizsys.pscore.srv.config.entity.PSDBType
 *  net.ibizsys.pscore.srv.config.service.PSDBTypeService
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSDBDevInst
 *  net.ibizsys.pscore.srv.paasmgr.service.PSDBDevInstService
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.hibernate.cfg.Configuration
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
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
import net.ibizsys.pscore.srv.config.service.PSDBTypeService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBDevInst;
import net.ibizsys.pscore.srv.paasmgr.service.PSDBDevInstService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@PSModelIgnoreMeta
public class PSDBDevInstGlobal {
    private static final Log log = LogFactory.getLog(PSDBDevInstGlobal.class);
    protected static HashMap<String, SessionFactory> sessionFactoryMap = new HashMap();
    protected static HashMap<String, Long> sessionFactoryLastActiveMap = new HashMap();
    protected static HashMap<String, Configuration> sessionFactoryConfigurationMap = new HashMap();
    protected static HashMap<String, PSDBType> psDBTypeMap = new HashMap();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static SessionFactory getSessionFactory(String strPSDBDevInstId) throws Exception {
        if (StringHelper.isNullOrEmpty((String)strPSDBDevInstId)) {
            return null;
        }
        SessionFactory sessionFactory = null;
        HashMap<String, SessionFactory> hashMap = sessionFactoryMap;
        synchronized (hashMap) {
            sessionFactory = sessionFactoryMap.get(strPSDBDevInstId);
            if (sessionFactory != null) {
                sessionFactoryLastActiveMap.put(strPSDBDevInstId, System.currentTimeMillis());
                return sessionFactory;
            }
        }
        PSDBDevInst psDBDevInst = new PSDBDevInst();
        psDBDevInst.setPSDBDevInstId(strPSDBDevInstId);
        PSDBDevInstService psDBDevInstService = (PSDBDevInstService)ServiceGlobal.getService(PSDBDevInstService.class);
        psDBDevInstService.get(psDBDevInst);
        return PSDBDevInstGlobal.getSessionFactory(psDBDevInst);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static SessionFactory getSessionFactory(PSDBDevInst psDBDevInst) throws Exception {
        PSDBType psDBType2;
        SessionFactory sessionFactory = null;
        HashMap<String, SessionFactory> hashMap = sessionFactoryMap;
        synchronized (hashMap) {
            sessionFactory = sessionFactoryMap.get(psDBDevInst.getPSDBDevInstId());
            if (sessionFactory != null) {
                sessionFactoryLastActiveMap.put(psDBDevInst.getPSDBDevInstId(), System.currentTimeMillis());
                return sessionFactory;
            }
        }
        PSDBType psDBType = null;
        HashMap<String, PSDBType> hashMap2 = psDBTypeMap;
        synchronized (hashMap2) {
            psDBType = psDBTypeMap.get(psDBDevInst.getDBType());
        }
        if (psDBType == null) {
            psDBType = new PSDBType();
            psDBType.setPSDBTypeId(psDBDevInst.getDBType());
            IService psDBTypeService = ServiceGlobal.getService(PSDBTypeService.class);
            psDBTypeService.get((IEntity)psDBType);
            HashMap<String, PSDBType> hashMap3 = psDBTypeMap;
            synchronized (hashMap3) {
                psDBType2 = psDBTypeMap.get(psDBDevInst.getDBType());
                if (psDBType2 != null) {
                    psDBType = psDBType2;
                } else {
                    psDBTypeMap.put(psDBDevInst.getDBType(), psDBType);
                }
            }
        }
        Configuration cfg = null;
        boolean bCreateCfg = false;
        synchronized (sessionFactoryConfigurationMap) {
            cfg = sessionFactoryConfigurationMap.get(psDBDevInst.getPSDBDevInstId());
            if (cfg == null) {
                Properties hibernateProperties = new Properties();
                hibernateProperties.put("hibernate.show_sql", "true");
                hibernateProperties.put("jdbc.driverClassName", psDBType.getJdbcDriverName());
                hibernateProperties.put("jdbc.url", psDBDevInst.getConnStr());
                hibernateProperties.put("jdbc.user", psDBDevInst.getUserName());
                hibernateProperties.put("jdbc.pass", psDBDevInst.getPasswd());
                hibernateProperties.put("jdbc.initialPoolSize", "1");
                hibernateProperties.put("jdbc.maxPoolSize", "10");
                hibernateProperties.put("jdbc.minPoolSize", "1");
                hibernateProperties.put("jdbc.maxIdleTime", "60");
                hibernateProperties.put("jdbc.maxStatements", "50");
                hibernateProperties.put("hibernate.connection.driver_class", psDBType.getJdbcDriverName());
                hibernateProperties.put("hibernate.connection.url", psDBDevInst.getConnStr());
                hibernateProperties.put("hibernate.dialect", psDBType.getHibDialect());
                hibernateProperties.put("hibernate.connection.username", psDBDevInst.getUserName());
                hibernateProperties.put("hibernate.connection.password", psDBDevInst.getPasswd());
                hibernateProperties.put("hibernate.c3p0.min_size", "1");
                hibernateProperties.put("hibernate.c3p0.max_size", "10");
                hibernateProperties.put("hibernate.c3p0.timeout", "120");
                hibernateProperties.put("hibernate.c3p0.max_statements", "50");
                hibernateProperties.put("hibernate.show_sql", "true");
                hibernateProperties.put("hibernate.hbm2ddl.auto", "create-drop");
                cfg = new Configuration();
                cfg.setProperties(hibernateProperties);
                sessionFactoryConfigurationMap.put(psDBDevInst.getPSDBDevInstId(), cfg);
                bCreateCfg = true;
            }
        }
        synchronized (sessionFactoryMap) {
            sessionFactory = sessionFactoryMap.get(psDBDevInst.getPSDBDevInstId());
            if (sessionFactory != null) {
                sessionFactoryLastActiveMap.put(psDBDevInst.getPSDBDevInstId(), System.currentTimeMillis());
                return sessionFactory;
            }
        }
        if (!bCreateCfg) {
            throw new Exception("\u65e0\u6cd5\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5");
        }
        sessionFactory = cfg.buildSessionFactory();
        SessionFactory closeSessionFactory = null;
        synchronized (sessionFactoryMap) {
            sessionFactoryLastActiveMap.put(psDBDevInst.getPSDBDevInstId(), System.currentTimeMillis());
            SessionFactory sessionFactory2 = sessionFactoryMap.get(psDBDevInst.getPSDBDevInstId());
            if (sessionFactory2 != null) {
                closeSessionFactory = sessionFactory;
                sessionFactory = sessionFactory2;
            } else {
                sessionFactoryMap.put(psDBDevInst.getPSDBDevInstId(), sessionFactory);
                DAOGlobal.registerDBDialect((SessionFactory)sessionFactory, (IDBDialect)((IDBDialect)ObjectHelper.create((String)psDBType.getJdbcDialect())));
                log.debug((Object)StringHelper.format((String)"\u5efa\u7acb\u5f00\u53d1\u6570\u636e\u5e93[%1$s]\u4f1a\u8bdd\u5de5\u5382\uff0c\u5f53\u524d\u6570\u91cf[%2$s]", (Object)psDBDevInst.getPSDBDevInstId(), (Object)sessionFactoryMap.size()));
            }
        }
        synchronized (sessionFactoryConfigurationMap) {
            sessionFactoryConfigurationMap.remove(psDBDevInst.getPSDBDevInstId());
        }
        if (closeSessionFactory != null) {
            closeSessionFactory.close();
        }
        return sessionFactory;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void resetSessionFactory(String strPSDBDevInstId) throws Exception {
        SessionFactory sessionFactory = null;
        HashMap<String, SessionFactory> hashMap = sessionFactoryMap;
        synchronized (hashMap) {
            sessionFactory = sessionFactoryMap.remove(strPSDBDevInstId);
            sessionFactoryLastActiveMap.remove(strPSDBDevInstId);
        }
        if (sessionFactory != null) {
            synchronized (sessionFactoryConfigurationMap) {
                sessionFactoryConfigurationMap.remove(strPSDBDevInstId);
            }
            DAOGlobal.unregisterDBDialect((SessionFactory)sessionFactory);
            ServiceGlobal.resetServices((SessionFactory)sessionFactory);
            sessionFactory.close();
            log.debug((Object)StringHelper.format((String)"\u79fb\u9664\u5f00\u53d1\u6570\u636e\u5e93[%1$s]\u4f1a\u8bdd\u5de5\u5382\uff0c\u5f53\u524d\u6570\u91cf[%2$s]", (Object)strPSDBDevInstId, (Object)sessionFactoryMap.size()));
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
        HashMap<String, Long> psDBDevInstMap = new HashMap<String, Long>();
        HashMap<String, SessionFactory> hashMap = sessionFactoryMap;
        synchronized (hashMap) {
            for (Map.Entry<String, Long> entry : sessionFactoryLastActiveMap.entrySet()) {
                if (entry.getValue() == null || entry.getValue() + nTime >= nCurTime) continue;
                psDBDevInstMap.put(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry entry : psDBDevInstMap.entrySet()) {
            if (entry.getValue() == null || (Long)entry.getValue() + nTime >= nCurTime) continue;
            try {
                PSDBDevInstGlobal.resetSessionFactory((String)entry.getKey());
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void active(String strPSDBDevInstId) {
        long nActiveTime = System.currentTimeMillis();
        HashMap<String, SessionFactory> hashMap = sessionFactoryMap;
        synchronized (hashMap) {
            sessionFactoryLastActiveMap.put(strPSDBDevInstId, nActiveTime);
        }
    }
}
