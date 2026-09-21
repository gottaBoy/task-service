/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.sysmodel;

import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.sysmodel.ISystemPlugin;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SysModelGlobal {
    private static final Log log = LogFactory.getLog(SysModelGlobal.class);
    private static HashMap<String, ISystem> systemMap = new HashMap();
    private static ISystemPlugin iSystemPlugin = null;
    private static boolean bUseLoginNameAsOperator = false;

    public static void registerSystem(String strSystemClsType, ISystem iSystem) {
        if (systemMap.containsKey(strSystemClsType)) {
            log.error((Object)StringHelper.format("\u6ce8\u518c\u7cfb\u7edf\u6a21\u578b\u5bf9\u8c61[%1$s]\u5931\u8d25\uff0c\u5f53\u524d\u5df2\u5b58\u5728", strSystemClsType));
            return;
        }
        log.info((Object)StringHelper.format("\u6ce8\u518c\u7cfb\u7edf\u6a21\u578b\u5bf9\u8c61[%1$s][%2$s]", strSystemClsType, iSystem));
        systemMap.put(strSystemClsType, iSystem);
    }

    public static ISystem getSystem(String strSystemClsType) throws Exception {
        ISystem iSystem = systemMap.get(strSystemClsType);
        if (iSystem == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u6a21\u578b[%1$s]", strSystemClsType));
        }
        return iSystem;
    }

    public static ISystem getSystem(String strSystemClsType, boolean bTry) throws Exception {
        ISystem iSystem = systemMap.get(strSystemClsType);
        if (iSystem == null && !bTry) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u6a21\u578b[%1$s]", strSystemClsType));
        }
        return iSystem;
    }

    public static ISystem getSystem(Class cls) throws Exception {
        return SysModelGlobal.getSystem(cls.getCanonicalName());
    }

    public static Iterator<ISystem> getAllSystems() {
        return systemMap.values().iterator();
    }

    public static void setSystemPlugin(ISystemPlugin iSystemPlugin) throws Exception {
        SysModelGlobal.setSystemPlugin(iSystemPlugin, false);
    }

    public static void setSystemPlugin(ISystemPlugin iSystemPlugin, boolean bIgnoreOrigin) throws Exception {
        ISystemPlugin lastPlugin = null;
        if (!bIgnoreOrigin) {
            lastPlugin = SysModelGlobal.iSystemPlugin;
        }
        iSystemPlugin.setPrevPlugin(lastPlugin);
        SysModelGlobal.iSystemPlugin = iSystemPlugin;
    }

    public static ISystemPlugin getSystemPlugin() {
        return iSystemPlugin;
    }

    public static void setUseLoginNameAsOperator(boolean bUseLoginNameAsOperator) {
        SysModelGlobal.bUseLoginNameAsOperator = bUseLoginNameAsOperator;
    }

    public static boolean isUseLoginNameAsOperator() {
        return bUseLoginNameAsOperator;
    }
}

