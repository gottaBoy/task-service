/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.ctrlmodel;

import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.ctrlmodel.IAppMenuModel;
import net.ibizsys.paas.ctrlmodel.IAppMenuModelGlobalPlugin;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AppMenuModelGlobal {
    private static final Log log = LogFactory.getLog(AppMenuModelGlobal.class);
    private static HashMap<String, IAppMenuModel> appMenuModelMap = new HashMap();
    private static IAppMenuModelGlobalPlugin iAppMenuModelGlobalPlugin = null;

    public static void registerAppMenuModel(String strAppMenuModelClsType, IAppMenuModel iAppMenuModel) {
        if (AppMenuModelGlobal.getPlugin() != null) {
            AppMenuModelGlobal.getPlugin().registerAppMenuModel(strAppMenuModelClsType, iAppMenuModel);
            return;
        }
        if (!appMenuModelMap.containsKey(strAppMenuModelClsType)) {
            appMenuModelMap.put(strAppMenuModelClsType, iAppMenuModel);
        }
    }

    public static IAppMenuModel getAppMenuModel(Class cls) throws Exception {
        if (AppMenuModelGlobal.getPlugin() != null) {
            return AppMenuModelGlobal.getPlugin().getAppMenuModel(cls);
        }
        return AppMenuModelGlobal.getAppMenuModel(cls.getCanonicalName());
    }

    public static IAppMenuModel getAppMenuModel(String strAppMenuModelClsType) throws Exception {
        if (AppMenuModelGlobal.getPlugin() != null) {
            return AppMenuModelGlobal.getPlugin().getAppMenuModel(strAppMenuModelClsType);
        }
        IAppMenuModel iAppMenuModel = appMenuModelMap.get(strAppMenuModelClsType);
        if (iAppMenuModel == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u83dc\u5355\u6a21\u578b[%1$s]", strAppMenuModelClsType));
        }
        return iAppMenuModel;
    }

    public static Iterator<IAppMenuModel> getAllAppMenuModels() throws Exception {
        if (AppMenuModelGlobal.getPlugin() != null) {
            return AppMenuModelGlobal.getPlugin().getAllAppMenuModels();
        }
        return appMenuModelMap.values().iterator();
    }

    public static void setPlugin(IAppMenuModelGlobalPlugin iAppMenuModelGlobalPlugin) {
        AppMenuModelGlobal.iAppMenuModelGlobalPlugin = iAppMenuModelGlobalPlugin;
    }

    public static IAppMenuModelGlobalPlugin getPlugin() {
        return iAppMenuModelGlobalPlugin;
    }
}

