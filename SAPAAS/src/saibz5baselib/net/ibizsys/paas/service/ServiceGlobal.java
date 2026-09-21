/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.paas.service;

import java.util.HashMap;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServiceGlobalPlugin;
import net.ibizsys.paas.sysmodel.ISystemRuntime;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class ServiceGlobal {
    private static final Log log = LogFactory.getLog(ServiceGlobal.class);
    private static HashMap<String, IService> serviceMap = new HashMap();
    private static HashMap<SessionFactory, HashMap<String, IService>> sessionFactoryServiceMap = new HashMap();
    private static IServiceGlobalPlugin iServiceGlobalPlugin = null;

    public static void registerService(String strServiceClsType, IService iService) {
        if (ServiceGlobal.getPlugin() != null) {
            ServiceGlobal.getPlugin().registerService(strServiceClsType, iService);
            return;
        }
        if (!serviceMap.containsKey(strServiceClsType)) {
            serviceMap.put(strServiceClsType, iService);
            log.debug((Object)StringHelper.format("\u6ce8\u518c\u670d\u52a1\u5bf9\u8c61[%1$s]\uff0c\u5f53\u524d\u6570\u91cf[%2$s]", strServiceClsType, serviceMap.size()));
        }
    }

    public static IService getService(Class cls) throws Exception {
        if (ServiceGlobal.getPlugin() != null) {
            return ServiceGlobal.getPlugin().getService(cls);
        }
        return ServiceGlobal.getService(cls.getCanonicalName());
    }

    public static IService getService(String strServiceClsType) throws Exception {
        if (ServiceGlobal.getPlugin() != null) {
            return ServiceGlobal.getPlugin().getService(strServiceClsType);
        }
        IService iService = serviceMap.get(strServiceClsType);
        if (iService == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u670d\u52a1\u5bf9\u8c61[%1$s]", strServiceClsType));
        }
        return iService;
    }

    public static void registerService(String strServiceClsType, String strDSLink, IService iService) {
        if (ServiceGlobal.getPlugin() != null) {
            ServiceGlobal.getPlugin().registerService(strServiceClsType, strDSLink, iService);
            return;
        }
        if (StringHelper.isNullOrEmpty(strDSLink)) {
            ServiceGlobal.registerService(strServiceClsType, iService);
        } else {
            String strFullKeyId = StringHelper.format("%1$s|%2$s", strServiceClsType, strDSLink);
            ServiceGlobal.registerService(strFullKeyId, iService);
        }
    }

    public static IService getService(Class cls, String strDSLink) throws Exception {
        if (ServiceGlobal.getPlugin() != null) {
            return ServiceGlobal.getPlugin().getService(cls, strDSLink);
        }
        if (StringHelper.isNullOrEmpty(strDSLink)) {
            return ServiceGlobal.getService(cls.getCanonicalName());
        }
        return ServiceGlobal.getService(cls.getCanonicalName(), strDSLink);
    }

    public static IService getService(String strServiceClsType, String strDSLink) throws Exception {
        if (ServiceGlobal.getPlugin() != null) {
            return ServiceGlobal.getPlugin().getService(strServiceClsType, strDSLink);
        }
        if (StringHelper.isNullOrEmpty(strDSLink)) {
            return ServiceGlobal.getService(strServiceClsType);
        }
        String strFullKeyId = StringHelper.format("%1$s|%2$s", strServiceClsType, strDSLink);
        return ServiceGlobal.getService(strFullKeyId);
    }

    public static IService getService(Class cls, SessionFactory sessionFactory) throws Exception {
        if (ServiceGlobal.getPlugin() != null) {
            return ServiceGlobal.getPlugin().getService(cls, sessionFactory);
        }
        return ServiceGlobal.getService(cls.getCanonicalName(), sessionFactory);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static IService getService(String strServiceClsType, SessionFactory sessionFactory) throws Exception {
        if (ServiceGlobal.getPlugin() != null) {
            return ServiceGlobal.getPlugin().getService(strServiceClsType, sessionFactory);
        }
        if (sessionFactory == null) {
            return ServiceGlobal.getService(strServiceClsType);
        }
        IService iService = serviceMap.get(strServiceClsType);
        if (iService == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u670d\u52a1\u5bf9\u8c61[%1$s]", strServiceClsType));
        }
        sessionFactory = ((ISystemRuntime)iService.getSystemModel()).getRealSessionFactory(iService.getDEModel(), sessionFactory);
        if (sessionFactory == null) {
            return iService;
        }
        HashMap<String, IService<Object>> sessionServiceMap = null;
        HashMap<Object, Object> hashMap = sessionFactoryServiceMap;
        synchronized (hashMap) {
            sessionServiceMap = sessionFactoryServiceMap.get(sessionFactory);
            if (sessionServiceMap == null) {
                sessionServiceMap = new HashMap();
                sessionFactoryServiceMap.put(sessionFactory, sessionServiceMap);
                if (log.isDebugEnabled()) {
                    log.debug((Object)StringHelper.format("\u6ce8\u518c[%1$s]\u670d\u52a1\u5bf9\u8c61\u6620\u5c04\uff0c\u5f53\u524d\u6570\u91cf[%2$s]", sessionFactory.toString(), sessionFactoryServiceMap.size()));
                }
            }
        }
        hashMap = sessionServiceMap;
        synchronized (hashMap) {
            IService sessionService = sessionServiceMap.get(strServiceClsType);
            if (sessionService != null) {
                return sessionService;
            }
            sessionService = (IService)iService.getClass().newInstance();
            sessionService.setSessionFactory(sessionFactory);
            sessionServiceMap.put(strServiceClsType, sessionService);
            if (log.isDebugEnabled()) {
                log.debug((Object)StringHelper.format("\u6ce8\u518c[%1$s]\u670d\u52a1\u5bf9\u8c61[%2$s]\uff0c\u5f53\u524d\u6570\u91cf[%3$s]", sessionFactory.toString(), strServiceClsType, sessionServiceMap.size()));
            }
            return sessionService;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void resetServices(SessionFactory sessionFactory) throws Exception {
        if (ServiceGlobal.getPlugin() != null) {
            ServiceGlobal.getPlugin().resetServices(sessionFactory);
            return;
        }
        if (sessionFactory == null) {
            return;
        }
        HashMap<String, IService> sessionServiceMap = null;
        HashMap<SessionFactory, HashMap<String, IService>> hashMap = sessionFactoryServiceMap;
        synchronized (hashMap) {
            sessionServiceMap = sessionFactoryServiceMap.remove(sessionFactory);
        }
        if (sessionServiceMap != null) {
            log.debug((Object)StringHelper.format("\u6ce8\u9500[%1$s]\u670d\u52a1\u5bf9\u8c61\u6620\u5c04\uff0c\u5f53\u524d\u6570\u91cf[%2$s]", sessionFactory.toString(), sessionFactoryServiceMap.size()));
        }
    }

    public static void setServiceGlobalPlugin(IServiceGlobalPlugin iServiceGlobalPlugin) {
        ServiceGlobal.iServiceGlobalPlugin = iServiceGlobalPlugin;
    }

    public static IServiceGlobalPlugin getPlugin() {
        return iServiceGlobalPlugin;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void resetServiceCache(SessionFactory sessionFactory) throws Exception {
        block7: {
            block6: {
                if (ServiceGlobal.getPlugin() != null) {
                    ServiceGlobal.getPlugin().resetServiceCache(sessionFactory);
                    return;
                }
                if (sessionFactory != null) break block6;
                for (IService iService : serviceMap.values()) {
                    iService.resetCache();
                }
                break block7;
            }
            HashMap<String, IService> sessionServiceMap = null;
            HashMap<SessionFactory, HashMap<String, IService>> hashMap = sessionFactoryServiceMap;
            synchronized (hashMap) {
                sessionServiceMap = sessionFactoryServiceMap.get(sessionFactory);
            }
            if (sessionServiceMap == null) break block7;
            for (IService iService : sessionServiceMap.values()) {
                iService.resetCache();
            }
        }
    }
}

