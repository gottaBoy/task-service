/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pswx.core;

import java.util.HashMap;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswx.core.IWXAccountModel;
import net.ibizsys.pswx.core.IWXGlobalPlugin;

public class WXGlobal {
    private static HashMap<String, IWXAccountModel> wxAccountModelMap = new HashMap();
    private static IWXGlobalPlugin iWXGlobalPlugin = null;
    private static HashMap<String, String> wxAccountModelRuntimeMap = new HashMap();

    public static void registerWXAccountModel(String strWXAccountModelClsType, IWXAccountModel iWXAccountModel) {
        if (WXGlobal.getPlugin() != null) {
            WXGlobal.getPlugin().registerWXAccountModel(strWXAccountModelClsType, iWXAccountModel);
            return;
        }
        if (!wxAccountModelMap.containsKey(strWXAccountModelClsType)) {
            wxAccountModelMap.put(strWXAccountModelClsType, iWXAccountModel);
        }
        try {
            WXGlobal.refreshWXAccount(strWXAccountModelClsType);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static IWXAccountModel getWXAccountModel(Class<?> cls) throws Exception {
        if (WXGlobal.getPlugin() != null) {
            return WXGlobal.getPlugin().getWXAccountModel(cls);
        }
        return WXGlobal.getWXAccountModel(cls.getCanonicalName());
    }

    public static IWXAccountModel getWXAccountModel(String strWXAccountModelClsType) throws Exception {
        if (WXGlobal.getPlugin() != null) {
            return WXGlobal.getPlugin().getWXAccountModel(strWXAccountModelClsType);
        }
        IWXAccountModel iWXAccountModel = wxAccountModelMap.get(strWXAccountModelClsType);
        if (iWXAccountModel == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5fae\u4fe1\u516c\u4f17\u53f7[%1$s]", strWXAccountModelClsType));
        }
        return iWXAccountModel;
    }

    public static void setPlugin(IWXGlobalPlugin iWXGlobalPlugin) {
        WXGlobal.iWXGlobalPlugin = iWXGlobalPlugin;
    }

    public static IWXGlobalPlugin getPlugin() {
        return iWXGlobalPlugin;
    }

    public static void refreshWXAccount(String accountId) throws Exception {
        IWXAccountModel accontModel = WXGlobal.getWXAccountModel(accountId);
        if (accontModel != null) {
            accontModel.refresh();
        }
    }

    public static void setWXAccountModelRuntimeId(String strWXAccountModelId, Object runtimeId) throws Exception {
        IWXAccountModel iWXAccountModel = WXGlobal.getWXAccountModel(strWXAccountModelId);
        if (iWXAccountModel != null) {
            iWXAccountModel.setRuntimeId(runtimeId);
        }
        wxAccountModelRuntimeMap.put(runtimeId.toString(), strWXAccountModelId);
    }

    public static IWXAccountModel getWXAccountModelByRuntimeId(Object runtimeId) throws Exception {
        String strRuntimeId = runtimeId.toString();
        String strRealId = wxAccountModelRuntimeMap.get(strRuntimeId);
        if (strRealId == null) {
            return WXGlobal.getWXAccountModel(strRuntimeId);
        }
        return WXGlobal.getWXAccountModel(strRealId);
    }
}

