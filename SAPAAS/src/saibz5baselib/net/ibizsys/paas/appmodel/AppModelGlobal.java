/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.appmodel;

import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.core.IApplication;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AppModelGlobal {
    private static final Log log = LogFactory.getLog(AppModelGlobal.class);
    private static HashMap<String, IApplication> applicationMap = new HashMap();
    private static IApplication defaultApplication = null;

    public static void registerApplication(String strAppClsType, IApplication iApplication) {
        log.info((Object)StringHelper.format("\u6ce8\u518c\u5e94\u7528\u6a21\u578b\u5bf9\u8c61[%1$s][%2$s]", strAppClsType, iApplication));
        applicationMap.put(strAppClsType, iApplication);
        if (defaultApplication == null) {
            defaultApplication = iApplication;
        }
    }

    public static IApplication getApplication(String strAppClsType) throws Exception {
        IApplication iApplication = applicationMap.get(strAppClsType);
        if (iApplication == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u6a21\u578b[%1$s]", strAppClsType));
        }
        return iApplication;
    }

    public static IApplication getApplication(Class<?> cls) throws Exception {
        return AppModelGlobal.getApplication(cls.getCanonicalName());
    }

    public static Iterator<IApplication> getAllApplications() throws Exception {
        return applicationMap.values().iterator();
    }

    public static IApplication getDefaultApplication() throws Exception {
        return defaultApplication;
    }
}

