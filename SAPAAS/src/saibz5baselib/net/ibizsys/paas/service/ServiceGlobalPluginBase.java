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
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.ISystemRuntime;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class ServiceGlobalPluginBase
implements IServiceGlobalPlugin {
    private static final Log log = LogFactory.getLog(ServiceGlobal.class);
    private HashMap<String, IService> serviceMap = new HashMap();
    private HashMap<SessionFactory, HashMap<String, IService>> sessionFactoryServiceMap = new HashMap();

    @Override
    public void registerService(String strServiceClsType, IService iService) {
        if (!this.serviceMap.containsKey(strServiceClsType)) {
            this.serviceMap.put(strServiceClsType, iService);
            log.debug((Object)StringHelper.format("\u6ce8\u518c\u670d\u52a1\u5bf9\u8c61[%1$s]\uff0c\u5f53\u524d\u6570\u91cf[%2$s]", strServiceClsType, this.serviceMap.size()));
        }
    }

    @Override
    public IService getService(Class cls) throws Exception {
        return this.getService(cls.getCanonicalName());
    }

    @Override
    public IService getService(String strServiceClsType) throws Exception {
        IService iService = this.serviceMap.get(strServiceClsType);
        if (iService == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u670d\u52a1\u5bf9\u8c61[%1$s]", strServiceClsType));
        }
        return iService;
    }

    @Override
    public void registerService(String strServiceClsType, String strDSLink, IService iService) {
        if (StringHelper.isNullOrEmpty(strDSLink)) {
            this.registerService(strServiceClsType, iService);
        } else {
            String strFullKeyId = StringHelper.format("%1$s|%2$s", strServiceClsType, strDSLink);
            this.registerService(strFullKeyId, iService);
        }
    }

    @Override
    public IService getService(Class cls, String strDSLink) throws Exception {
        if (StringHelper.isNullOrEmpty(strDSLink)) {
            return this.getService(cls.getCanonicalName());
        }
        return this.getService(cls.getCanonicalName(), strDSLink);
    }

    @Override
    public IService getService(String strServiceClsType, String strDSLink) throws Exception {
        if (StringHelper.isNullOrEmpty(strDSLink)) {
            return this.getService(strServiceClsType);
        }
        String strFullKeyId = StringHelper.format("%1$s|%2$s", strServiceClsType, strDSLink);
        return this.getService(strFullKeyId);
    }

    @Override
    public IService getService(Class cls, SessionFactory sessionFactory) throws Exception {
        return this.getService(cls.getCanonicalName(), sessionFactory);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IService getService(String strServiceClsType, SessionFactory sessionFactory) throws Exception {
        if (sessionFactory == null) {
            return this.getService(strServiceClsType);
        }
        IService iService = this.serviceMap.get(strServiceClsType);
        if (iService == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u670d\u52a1\u5bf9\u8c61[%1$s]", strServiceClsType));
        }
        sessionFactory = ((ISystemRuntime)iService.getSystemModel()).getRealSessionFactory(iService.getDEModel(), sessionFactory);
        if (sessionFactory == null) {
            return iService;
        }
        HashMap<String, IService<Object>> sessionServiceMap = null;
        HashMap<Object, Object> hashMap = this.sessionFactoryServiceMap;
        synchronized (hashMap) {
            sessionServiceMap = this.sessionFactoryServiceMap.get(sessionFactory);
            if (sessionServiceMap == null) {
                sessionServiceMap = new HashMap();
                this.sessionFactoryServiceMap.put(sessionFactory, sessionServiceMap);
                if (log.isDebugEnabled()) {
                    log.debug((Object)StringHelper.format("\u6ce8\u518c[%1$s]\u670d\u52a1\u5bf9\u8c61\u6620\u5c04\uff0c\u5f53\u524d\u6570\u91cf[%2$s]", sessionFactory.toString(), this.sessionFactoryServiceMap.size()));
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
    @Override
    public void resetServices(SessionFactory sessionFactory) throws Exception {
        if (sessionFactory == null) {
            return;
        }
        HashMap<String, IService> sessionServiceMap = null;
        HashMap<SessionFactory, HashMap<String, IService>> hashMap = this.sessionFactoryServiceMap;
        synchronized (hashMap) {
            sessionServiceMap = this.sessionFactoryServiceMap.remove(sessionFactory);
        }
        if (sessionServiceMap != null) {
            log.debug((Object)StringHelper.format("\u6ce8\u9500[%1$s]\u670d\u52a1\u5bf9\u8c61\u6620\u5c04\uff0c\u5f53\u524d\u6570\u91cf[%2$s]", sessionFactory.toString(), this.sessionFactoryServiceMap.size()));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void resetServiceCache(SessionFactory sessionFactory) throws Exception {
        block6: {
            block5: {
                if (sessionFactory != null) break block5;
                for (IService iService : this.serviceMap.values()) {
                    iService.resetCache();
                }
                break block6;
            }
            HashMap<String, IService> sessionServiceMap = null;
            HashMap<SessionFactory, HashMap<String, IService>> hashMap = this.sessionFactoryServiceMap;
            synchronized (hashMap) {
                sessionServiceMap = this.sessionFactoryServiceMap.get(sessionFactory);
            }
            if (sessionServiceMap == null) break block6;
            for (IService iService : sessionServiceMap.values()) {
                iService.resetCache();
            }
        }
    }
}

