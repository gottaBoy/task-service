/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.WebConfig
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.model;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import net.ibizsys.model.IPSModelQueryHelper;
import net.ibizsys.model.IPSModelQueryHelperContainer;
import net.ibizsys.model.PSModelQueryHelperImpl;
import net.ibizsys.model.PSModelQueryHelperProxy;
import net.ibizsys.model.PSModelQueryHelperRestImpl;
import net.ibizsys.model.entity.PSDepSlnSys;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebConfig;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSModelQueryHelperFactory {
    private static final Log log = LogFactory.getLog(PSModelQueryHelperFactory.class);
    private static IPSModelQueryHelper iPSModelQueryHelper = null;
    private static HashMap<String, IPSModelQueryHelper> PSModelQueryHelperMap = new HashMap();
    private static Object objPSHelperStorageLock = new Object();
    private static SessionFactory majorSessionFactory = null;
    private static HashMap<String, String> psDepSlnSysIdMap = new HashMap();
    private static HashMap<String, String> psSysModelInstIdMap = new HashMap();
    private static String strRestServiceUrl = null;
    private static String strPSDepSlnSysId = null;
    private static boolean bEnableCache = true;

    public static final String getRestServiceUrl() {
        return strRestServiceUrl;
    }

    public static final void setRestServiceUrl(String strRestServiceUrl) {
        PSModelQueryHelperFactory.strRestServiceUrl = strRestServiceUrl;
    }

    public static final boolean isEnableCache() {
        return bEnableCache;
    }

    public static final void setEnableCache(boolean bEnableCache) {
        PSModelQueryHelperFactory.bEnableCache = bEnableCache;
    }

    public static final String getPSDepSlnSysId() {
        return strPSDepSlnSysId;
    }

    public static final void setPSDepSlnSysId(String strPSDepSlnSysId) {
        PSModelQueryHelperFactory.strPSDepSlnSysId = strPSDepSlnSysId;
    }

    public static final IPSModelQueryHelper getInstance() throws Exception {
        return PSModelQueryHelperFactory.getInstance(null, true);
    }

    public static final IPSModelQueryHelper getInstance(String strPSSysModelInstId) throws Exception {
        return PSModelQueryHelperFactory.getInstance(strPSSysModelInstId, false);
    }

    public static final IPSModelQueryHelper getInstance(String strPSSysModelInstId, String strPSDynaInstId) throws Exception {
        IPSModelQueryHelper iPSModelQueryHelper = PSModelQueryHelperFactory.getInstance(strPSSysModelInstId, false);
        if (!StringHelper.isNullOrEmpty((String)strPSDynaInstId) && iPSModelQueryHelper instanceof IPSModelQueryHelperContainer) {
            return ((IPSModelQueryHelperContainer)((Object)iPSModelQueryHelper)).getPSModelQueryHelper(strPSDynaInstId);
        }
        return iPSModelQueryHelper;
    }

    public static final IPSModelQueryHelper getInstByPSDepSlnSysId(String strPSDepSlnSysId) throws Exception {
        if (StringHelper.isNullOrEmpty((String)strPSDepSlnSysId)) {
            return PSModelQueryHelperFactory.getInstance();
        }
        String strPSSysModelInstId = psDepSlnSysIdMap.get(strPSDepSlnSysId);
        if (StringHelper.isNullOrEmpty((String)strPSSysModelInstId)) {
            PSDepSlnSys psDepSlnSys = new PSDepSlnSys();
            CallResult callResult = PSModelQueryHelperFactory.getInstance().getPSDepSlnSys(strPSDepSlnSysId, psDepSlnSys);
            if (callResult.isError()) {
                throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u90e8\u7f72\u65b9\u6848\u7cfb\u7edf\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            strPSSysModelInstId = psDepSlnSys.getPSSYSMODELINSTID();
            psDepSlnSysIdMap.put(strPSDepSlnSysId, strPSSysModelInstId);
        }
        return PSModelQueryHelperFactory.getInstance(strPSSysModelInstId, false);
    }

    public static SessionFactory getMajorSessionFactory() {
        return majorSessionFactory;
    }

    public static void setMajorSessionFactory(SessionFactory majorSessionFactory) {
        PSModelQueryHelperFactory.majorSessionFactory = majorSessionFactory;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static final IPSModelQueryHelper getInstance(String strPSSysModelInstId, boolean bAlwaysActive) throws Exception {
        if (StringHelper.isNullOrEmpty((String)strPSSysModelInstId)) {
            Object object = objPSHelperStorageLock;
            synchronized (object) {
                if (iPSModelQueryHelper != null) {
                    return iPSModelQueryHelper;
                }
                if (PSModelQueryHelperFactory.isEnableCache()) {
                    String strTempPath = WebConfig.getCurrent().getTempPath();
                    if (StringHelper.isNullOrEmpty((String)strTempPath)) {
                        throw new Exception("\u5f53\u524d\u7cfb\u7edf\u6ca1\u6709\u5b9a\u4e49\u4e34\u65f6\u76ee\u5f55");
                    }
                    File dir = new File(strTempPath = String.valueOf(strTempPath) + "DYNAMODEL");
                    if (!dir.exists()) {
                        dir.mkdirs();
                    }
                    if (StringHelper.isNullOrEmpty((String)PSModelQueryHelperFactory.getRestServiceUrl())) {
                        PSModelQueryHelperImpl nuModelHelperImpl = new PSModelQueryHelperImpl();
                        iPSModelQueryHelper = new PSModelQueryHelperProxy(null, nuModelHelperImpl, strTempPath, null);
                        nuModelHelperImpl.init(PSModelQueryHelperFactory.getMajorSessionFactory());
                        return iPSModelQueryHelper;
                    }
                    PSModelQueryHelperRestImpl nuModelHelperImpl = new PSModelQueryHelperRestImpl();
                    iPSModelQueryHelper = new PSModelQueryHelperProxy(null, nuModelHelperImpl, strTempPath, null);
                    nuModelHelperImpl.init(null, PSModelQueryHelperFactory.getRestServiceUrl());
                    return iPSModelQueryHelper;
                }
                if (StringHelper.isNullOrEmpty((String)PSModelQueryHelperFactory.getRestServiceUrl())) {
                    PSModelQueryHelperImpl nuModelHelperImpl = new PSModelQueryHelperImpl();
                    iPSModelQueryHelper = nuModelHelperImpl;
                    nuModelHelperImpl.init(PSModelQueryHelperFactory.getMajorSessionFactory());
                    return iPSModelQueryHelper;
                }
                PSModelQueryHelperRestImpl nuModelHelperImpl = new PSModelQueryHelperRestImpl();
                iPSModelQueryHelper = nuModelHelperImpl;
                nuModelHelperImpl.init(null, PSModelQueryHelperFactory.getRestServiceUrl());
                return iPSModelQueryHelper;
            }
        }
        HashMap<String, IPSModelQueryHelper> hashMap = PSModelQueryHelperMap;
        synchronized (hashMap) {
            IPSModelQueryHelper iPSModelQueryHelper = PSModelQueryHelperMap.get(strPSSysModelInstId);
            if (iPSModelQueryHelper != null) {
                if (bAlwaysActive) {
                    iPSModelQueryHelper.activeAlways();
                } else {
                    iPSModelQueryHelper.active();
                }
                return iPSModelQueryHelper;
            }
            if (PSModelQueryHelperFactory.isEnableCache()) {
                String strTempPath = WebConfig.getCurrent().getTempPath();
                if (StringHelper.isNullOrEmpty((String)strTempPath)) {
                    throw new Exception("\u5f53\u524d\u7cfb\u7edf\u6ca1\u6709\u5b9a\u4e49\u4e34\u65f6\u76ee\u5f55");
                }
                File dir = new File(strTempPath = String.valueOf(strTempPath) + "DYNAMODEL");
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                if (StringHelper.isNullOrEmpty((String)PSModelQueryHelperFactory.getRestServiceUrl())) {
                    PSModelQueryHelperImpl nuModelHelperImpl = new PSModelQueryHelperImpl();
                    iPSModelQueryHelper = new PSModelQueryHelperProxy(strPSSysModelInstId, nuModelHelperImpl, strTempPath, null);
                    nuModelHelperImpl.init(strPSSysModelInstId, bAlwaysActive);
                    PSModelQueryHelperMap.put(strPSSysModelInstId, iPSModelQueryHelper);
                    iPSModelQueryHelper.active();
                    log.debug((Object)StringHelper.format((String)"\u5efa\u7acb\u7cfb\u7edf\u6a21\u578b\u8f85\u52a9\u5bf9\u8c61[%1$s]\uff0c\u5f53\u524d\u6570\u91cf[%2$s]", (Object)strPSSysModelInstId, (Object)PSModelQueryHelperMap.size()));
                    return iPSModelQueryHelper;
                }
                PSModelQueryHelperRestImpl nuModelHelperImpl = new PSModelQueryHelperRestImpl();
                iPSModelQueryHelper = new PSModelQueryHelperProxy(strPSSysModelInstId, nuModelHelperImpl, strTempPath, null);
                String strPSDepSlnSysId = psSysModelInstIdMap.get(strPSSysModelInstId);
                if (StringHelper.isNullOrEmpty((String)strPSDepSlnSysId)) {
                    strPSDepSlnSysId = PSModelQueryHelperFactory.getPSDepSlnSysId();
                }
                if (StringHelper.isNullOrEmpty((String)strPSDepSlnSysId)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b\u5b9e\u4f8b[%1$s]\u5bf9\u5e94\u7684\u5f00\u53d1\u90e8\u7f72\u7cfb\u7edf"));
                }
                nuModelHelperImpl.init(strPSDepSlnSysId, PSModelQueryHelperFactory.getRestServiceUrl());
                PSModelQueryHelperMap.put(strPSSysModelInstId, iPSModelQueryHelper);
                iPSModelQueryHelper.active();
                log.debug((Object)StringHelper.format((String)"\u5efa\u7acb\u7cfb\u7edf\u6a21\u578b\u8f85\u52a9\u5bf9\u8c61[%1$s]\uff0c\u5f53\u524d\u6570\u91cf[%2$s]", (Object)strPSSysModelInstId, (Object)PSModelQueryHelperMap.size()));
                return iPSModelQueryHelper;
            }
            if (StringHelper.isNullOrEmpty((String)PSModelQueryHelperFactory.getRestServiceUrl())) {
                PSModelQueryHelperImpl nuModelHelperImpl = new PSModelQueryHelperImpl();
                iPSModelQueryHelper = nuModelHelperImpl;
                nuModelHelperImpl.init(strPSSysModelInstId, bAlwaysActive);
                PSModelQueryHelperMap.put(strPSSysModelInstId, nuModelHelperImpl);
                iPSModelQueryHelper.active();
                log.debug((Object)StringHelper.format((String)"\u5efa\u7acb\u7cfb\u7edf\u6a21\u578b\u8f85\u52a9\u5bf9\u8c61[%1$s]\uff0c\u5f53\u524d\u6570\u91cf[%2$s]", (Object)strPSSysModelInstId, (Object)PSModelQueryHelperMap.size()));
                return iPSModelQueryHelper;
            }
            PSModelQueryHelperRestImpl nuModelHelperImpl = new PSModelQueryHelperRestImpl();
            iPSModelQueryHelper = nuModelHelperImpl;
            String strPSDepSlnSysId = psSysModelInstIdMap.get(strPSSysModelInstId);
            if (StringHelper.isNullOrEmpty((String)strPSDepSlnSysId)) {
                strPSDepSlnSysId = PSModelQueryHelperFactory.getPSDepSlnSysId();
            }
            if (StringHelper.isNullOrEmpty((String)strPSDepSlnSysId)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b\u5b9e\u4f8b[%1$s]\u5bf9\u5e94\u7684\u5f00\u53d1\u90e8\u7f72\u7cfb\u7edf"));
            }
            nuModelHelperImpl.init(strPSDepSlnSysId, PSModelQueryHelperFactory.getRestServiceUrl());
            PSModelQueryHelperMap.put(strPSSysModelInstId, nuModelHelperImpl);
            iPSModelQueryHelper.active();
            log.debug((Object)StringHelper.format((String)"\u5efa\u7acb\u7cfb\u7edf\u6a21\u578b\u8f85\u52a9\u5bf9\u8c61[%1$s]\uff0c\u5f53\u524d\u6570\u91cf[%2$s]", (Object)strPSSysModelInstId, (Object)PSModelQueryHelperMap.size()));
            return iPSModelQueryHelper;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static final void reset(String strPSSysModelInstId) throws Exception {
        HashMap<String, IPSModelQueryHelper> hashMap = PSModelQueryHelperMap;
        synchronized (hashMap) {
            IPSModelQueryHelper iPSModelQueryHelper = PSModelQueryHelperMap.remove(strPSSysModelInstId);
            log.debug((Object)StringHelper.format((String)"\u79fb\u9664\u7cfb\u7edf\u6a21\u578b\u8f85\u52a9\u5bf9\u8c61[%1$s]\uff0c\u5f53\u524d\u6570\u91cf[%2$s]", (Object)strPSSysModelInstId, (Object)PSModelQueryHelperMap.size()));
        }
    }

    public static final int getInstaneCount() {
        return PSModelQueryHelperMap.size();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void remove(long nTime) {
        long nCurTime = System.currentTimeMillis();
        HashMap<String, IPSModelQueryHelper> PSModelQueryHelperMap2 = new HashMap<String, IPSModelQueryHelper>();
        HashMap<String, IPSModelQueryHelper> hashMap = PSModelQueryHelperMap;
        synchronized (hashMap) {
            for (Map.Entry<String, IPSModelQueryHelper> entry : PSModelQueryHelperMap.entrySet()) {
                if (entry.getValue().isAlwaysActive() || entry.getValue().getLastActiveTime() + nTime >= nCurTime) continue;
                PSModelQueryHelperMap2.put(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry entry : PSModelQueryHelperMap2.entrySet()) {
            if (((IPSModelQueryHelper)entry.getValue()).isAlwaysActive() || ((IPSModelQueryHelper)entry.getValue()).getLastActiveTime() + nTime >= nCurTime) continue;
            try {
                PSModelQueryHelperFactory.reset((String)entry.getKey());
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
        }
    }

    public static void registerPSSysModelInstId(String strPSSysModelInstId, String strPSDepSlnSysId) {
        if (StringHelper.isNullOrEmpty((String)strPSDepSlnSysId)) {
            psSysModelInstIdMap.remove(strPSSysModelInstId);
        } else {
            psSysModelInstIdMap.put(strPSSysModelInstId, strPSDepSlnSysId);
        }
    }
}

