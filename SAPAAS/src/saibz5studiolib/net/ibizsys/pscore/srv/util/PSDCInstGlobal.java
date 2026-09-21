/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mchange.v2.c3p0.ComboPooledDataSource
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

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.sql.DataSource;
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
import net.ibizsys.pscore.srv.paasmgr.entity.PSDCInst;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDCInstBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSDCInstService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PSDCInstGlobal {
    private static final Log log = LogFactory.getLog(PSDCInstGlobal.class);
    protected static HashMap<String, SessionFactory> sessionFactoryMap = new HashMap();
    protected static HashMap<String, Configuration> sessionFactoryConfigurationMap = new HashMap();
    protected static HashMap<String, PSDBType> psDBTypeMap = new HashMap();
    private static ThreadLocal<String> threadPSDCInstId = new ThreadLocal();

    public static String getCurrent() {
        return threadPSDCInstId.get();
    }

    public static void setCurrent(String string) {
        threadPSDCInstId.set(string);
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
                return sessionFactory;
            }
        }
        serializable = new PSDCInst();
        ((PSDCInstBase)serializable).setPSDCInstId(string);
        PSDCInstService pSDCInstService = (PSDCInstService)ServiceGlobal.getService(PSDCInstService.class);
        pSDCInstService.get((IEntity)serializable);
        return PSDCInstGlobal.getSessionFactory((PSDCInst)serializable);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static SessionFactory getSessionFactory(PSDCInst pSDCInst) throws Exception {
        Map<Object, Object> map;
        SessionFactory sessionFactory;
        SessionFactory sessionFactory2 = null;
        Serializable serializable = sessionFactoryMap;
        synchronized (serializable) {
            sessionFactory2 = sessionFactoryMap.get(pSDCInst.getPSDCInstId());
            if (sessionFactory2 != null) {
                return sessionFactory2;
            }
        }
        serializable = null;
        IService iService = psDBTypeMap;
        synchronized (iService) {
            serializable = psDBTypeMap.get(pSDCInst.getDBType());
        }
        if (serializable == null) {
            serializable = new PSDBType();
            ((PSDBTypeBase)serializable).setPSDBTypeId(pSDCInst.getDBType());
            iService = ServiceGlobal.getService(PSDBTypeService.class);
            iService.get((IEntity)serializable);
            HashMap<String, PSDBType> hashMap = psDBTypeMap;
            synchronized (hashMap) {
                sessionFactory = psDBTypeMap.get(pSDCInst.getDBType());
                if (sessionFactory != null) {
                    serializable = sessionFactory;
                } else {
                    psDBTypeMap.put(pSDCInst.getDBType(), (PSDBType)serializable);
                }
            }
        }
        iService = null;
        boolean bl = false;
        sessionFactory = sessionFactoryConfigurationMap;
        synchronized (sessionFactory) {
            iService = sessionFactoryConfigurationMap.get(pSDCInst.getPSDCInstId());
            if (iService == null) {
                map = new Properties();
                ((Properties)map).put("hibernate.show_sql", "true");
                ((Properties)map).put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
                ((Properties)map).put("jdbc.driverClassName", ((PSDBTypeBase)serializable).getJdbcDriverName());
                ((Properties)map).put("jdbc.url", pSDCInst.getConnStr());
                ((Properties)map).put("jdbc.user", pSDCInst.getUserName());
                ((Properties)map).put("jdbc.pass", pSDCInst.getPasswd());
                ((Properties)map).put("jdbc.initialPoolSize", "2");
                ((Properties)map).put("jdbc.maxPoolSize", "20");
                ((Properties)map).put("jdbc.minPoolSize", "2");
                ((Properties)map).put("jdbc.maxIdleTime", "60");
                ((Properties)map).put("jdbc.maxStatements", "50");
                ((Properties)map).put("jdbc.maxStatements", "0");
                ((Properties)map).put("hibernate.connection.driver_class", ((PSDBTypeBase)serializable).getJdbcDriverName());
                ((Properties)map).put("hibernate.connection.url", pSDCInst.getConnStr());
                ((Properties)map).put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
                ((Properties)map).put("hibernate.connection.username", pSDCInst.getUserName());
                ((Properties)map).put("hibernate.connection.password", pSDCInst.getPasswd());
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
                sessionFactoryConfigurationMap.put(pSDCInst.getPSDCInstId(), (Configuration)iService);
                bl = true;
            }
        }
        sessionFactory = sessionFactoryMap;
        synchronized (sessionFactory) {
            sessionFactory2 = sessionFactoryMap.get(pSDCInst.getPSDCInstId());
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
            SessionFactory sessionFactory3 = sessionFactoryMap.get(pSDCInst.getPSDCInstId());
            if (sessionFactory3 != null) {
                sessionFactory = sessionFactory2;
                sessionFactory2 = sessionFactory3;
            } else {
                sessionFactoryMap.put(pSDCInst.getPSDCInstId(), sessionFactory2);
                DAOGlobal.registerDBDialect((SessionFactory)sessionFactory2, (IDBDialect)((IDBDialect)ObjectHelper.create((String)((PSDBTypeBase)serializable).getJdbcDialect())));
            }
        }
        map = sessionFactoryConfigurationMap;
        synchronized (map) {
            sessionFactoryConfigurationMap.remove(pSDCInst.getPSDCInstId());
        }
        if (sessionFactory != null) {
            sessionFactory.close();
        }
        return sessionFactory2;
    }

    private static DataSource createDataSource(PSDCInst pSDCInst, PSDBType pSDBType) throws Exception {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setUser(pSDCInst.getUserName());
        comboPooledDataSource.setPassword(pSDCInst.getPasswd());
        comboPooledDataSource.setInitialPoolSize(2);
        comboPooledDataSource.setMinPoolSize(1);
        comboPooledDataSource.setMaxPoolSize(10);
        comboPooledDataSource.setMaxStatements(50);
        comboPooledDataSource.setMaxIdleTime(60);
        comboPooledDataSource.setJdbcUrl(pSDCInst.getConnStr());
        comboPooledDataSource.setDriverClass(pSDBType.getJdbcDriverName());
        return comboPooledDataSource;
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

