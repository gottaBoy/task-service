/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.GlobalHelperEx
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.IPSModelHelper;
import SA.SRFDA.PS.Core.IPSModelStorage;
import SA.SRFDA.PS.Core.PSModelHelperImpl;
import SA.SRFDA.PS.Core.PSModelHelperImpl3;
import SA.SRFDA.PS.Core.PSModelStorageImpl;
import SA.SRFDA.Web.Utility.GlobalHelperEx;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSObjectFactory {
    private static final Log log = LogFactory.getLog(PSObjectFactory.class);
    private static IPSModelHelper iPSModelHelper = null;
    private static IPSModelStorage iPSModelStorage = null;
    private static HashMap<String, IPSModelHelper> psModelHelperMap = new HashMap();
    private static Object objPSModelStorageLock = new Object();
    private static Object objPSHelperStorageLock = new Object();
    private static boolean bUseDAOOnly = false;
    public static final String PSDYNAINST_HEADER = "PSDYNAINST:";

    public static final void setUseDAOOnly(boolean bUseDAOOnly) {
        PSObjectFactory.bUseDAOOnly = bUseDAOOnly;
    }

    public static final boolean isUseDAOOnly() {
        return bUseDAOOnly;
    }

    public static final IPSModelHelper getPSModelHelper(ISRFDAGlobalHelper iDAGlobalHelper, String strPSSysModelInstId) throws Exception {
        return PSObjectFactory.getPSModelHelper(iDAGlobalHelper, strPSSysModelInstId, false);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static final IPSModelHelper getPSModelHelper(ISRFDAGlobalHelper iDAGlobalHelper, String strPSSysModelInstId, boolean bAlwaysActive) throws Exception {
        if (StringHelper.IsNullOrEmpty((String)strPSSysModelInstId)) {
            Object object = objPSHelperStorageLock;
            synchronized (object) {
                if (iPSModelHelper != null) {
                    return iPSModelHelper;
                }
                PSModelHelperImpl nuModelHelperImpl = new PSModelHelperImpl();
                nuModelHelperImpl.setUseDAOOnly(PSObjectFactory.isUseDAOOnly());
                iPSModelHelper = nuModelHelperImpl;
                nuModelHelperImpl.init(iDAGlobalHelper, null, true);
                return iPSModelHelper;
            }
        }
        HashMap<String, IPSModelHelper> hashMap = psModelHelperMap;
        synchronized (hashMap) {
            IPSModelHelper iPSModelHelper = psModelHelperMap.get(strPSSysModelInstId);
            if (iPSModelHelper != null) {
                if (bAlwaysActive) {
                    iPSModelHelper.activeAlways();
                } else {
                    iPSModelHelper.active();
                }
                return iPSModelHelper;
            }
            if (strPSSysModelInstId.indexOf(PSDYNAINST_HEADER) == 0) {
                PSModelHelperImpl3 nuModelHelperImpl = new PSModelHelperImpl3();
                iPSModelHelper = nuModelHelperImpl;
                nuModelHelperImpl.init(iDAGlobalHelper, strPSSysModelInstId, bAlwaysActive);
                psModelHelperMap.put(strPSSysModelInstId, nuModelHelperImpl);
                iPSModelHelper.active();
                log.debug((Object)StringHelper.Format((String)"\u5efa\u7acb\u7cfb\u7edf\u6a21\u578b\u8f85\u52a9\u5bf9\u8c61[%1$s]\uff0c\u5f53\u524d\u6570\u91cf[%2$s]", (Object)strPSSysModelInstId, (Object)psModelHelperMap.size()));
                return iPSModelHelper;
            }
            PSModelHelperImpl nuModelHelperImpl = new PSModelHelperImpl();
            iPSModelHelper = nuModelHelperImpl;
            nuModelHelperImpl.init(iDAGlobalHelper, strPSSysModelInstId, bAlwaysActive);
            psModelHelperMap.put(strPSSysModelInstId, nuModelHelperImpl);
            iPSModelHelper.active();
            log.debug((Object)StringHelper.Format((String)"\u5efa\u7acb\u7cfb\u7edf\u6a21\u578b\u8f85\u52a9\u5bf9\u8c61[%1$s]\uff0c\u5f53\u524d\u6570\u91cf[%2$s]", (Object)strPSSysModelInstId, (Object)psModelHelperMap.size()));
            return iPSModelHelper;
        }
    }

    public static final void setPSModelHelper(IPSModelHelper iPSModelHelper) {
        PSObjectFactory.iPSModelHelper = iPSModelHelper;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static final IPSModelStorage getPSModelStorage(ISRFDAGlobalHelper iDAGlobalHelper) throws Exception {
        PSModelStorageImpl nuModelHelperImpl = null;
        Object object = objPSModelStorageLock;
        synchronized (object) {
            if (iPSModelStorage != null) {
                return iPSModelStorage;
            }
            nuModelHelperImpl = new PSModelStorageImpl();
            iPSModelStorage = nuModelHelperImpl;
        }
        nuModelHelperImpl.init(iDAGlobalHelper);
        return iPSModelStorage;
    }

    public static final void setPSModelStorage(IPSModelStorage iPSModelStorage) {
        PSObjectFactory.iPSModelStorage = iPSModelStorage;
    }

    public static final IPSModelStorage getPSModelStorage() throws Exception {
        return PSObjectFactory.getPSModelStorage(GlobalHelperEx.getInstance());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static final void resetPSModelHelper(String strPSSysModelInstId) throws Exception {
        HashMap<String, IPSModelHelper> hashMap = psModelHelperMap;
        synchronized (hashMap) {
            IPSModelHelper iPSModelHelper = psModelHelperMap.remove(strPSSysModelInstId);
            log.debug((Object)StringHelper.Format((String)"\u79fb\u9664\u7cfb\u7edf\u6a21\u578b\u8f85\u52a9\u5bf9\u8c61[%1$s]\uff0c\u5f53\u524d\u6570\u91cf[%2$s]", (Object)strPSSysModelInstId, (Object)psModelHelperMap.size()));
        }
    }

    public static final int getPSModelHelperCount() {
        return psModelHelperMap.size();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void removePSModelHelper(long nTime) {
        long nCurTime = System.currentTimeMillis();
        HashMap<String, IPSModelHelper> psModelHelperMap2 = new HashMap<String, IPSModelHelper>();
        HashMap<String, IPSModelHelper> hashMap = psModelHelperMap;
        synchronized (hashMap) {
            for (Map.Entry<String, IPSModelHelper> entry : psModelHelperMap.entrySet()) {
                if (entry.getValue().isAlwaysActive() || entry.getValue().getLastActiveTime() + nTime >= nCurTime) continue;
                psModelHelperMap2.put(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry entry : psModelHelperMap2.entrySet()) {
            if (((IPSModelHelper)entry.getValue()).isAlwaysActive() || ((IPSModelHelper)entry.getValue()).getLastActiveTime() + nTime >= nCurTime) continue;
            try {
                PSObjectFactory.resetPSModelHelper((String)entry.getKey());
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
        }
    }
}

