/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pswf.core;

import java.util.HashMap;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.IWFModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WFModelGlobal {
    private static final Log log = LogFactory.getLog(WFModelGlobal.class);
    private static HashMap<String, IWFModel> wfmodelMap = new HashMap();
    private static HashMap<String, String> wfModelRuntimeMap = new HashMap();

    public static void registerWFModel(String strWFModelClsType, IWFModel iWFModel) {
        wfmodelMap.put(strWFModelClsType, iWFModel);
        wfmodelMap.put(iWFModel.getId(), iWFModel);
    }

    public static IWFModel getWFModel(Class cls) throws Exception {
        return WFModelGlobal.getWFModel(cls.getCanonicalName());
    }

    public static IWFModel getWFModel(String strWFModelClsType) throws Exception {
        IWFModel iWFModel = wfmodelMap.get(strWFModelClsType);
        if (iWFModel == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6d41\u7a0b\u6a21\u578b[%1$s]", strWFModelClsType));
        }
        return iWFModel;
    }

    public static IWFModel getWFModel(Class cls, boolean bTryMode) throws Exception {
        return WFModelGlobal.getWFModel(cls.getCanonicalName(), bTryMode);
    }

    public static IWFModel getWFModel(String strWFModelClsType, boolean bTryMode) throws Exception {
        IWFModel iWFModel = wfmodelMap.get(strWFModelClsType);
        if (iWFModel == null && !bTryMode) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6d41\u7a0b\u6a21\u578b[%1$s]", strWFModelClsType));
        }
        return iWFModel;
    }

    public static void setWFModelRuntimeId(String strWFModelId, Object runtimeId) throws Exception {
        IWFModel iWFModel = WFModelGlobal.getWFModel(strWFModelId);
        if (iWFModel != null) {
            iWFModel.setRuntimeId(runtimeId);
        }
        wfModelRuntimeMap.put(runtimeId.toString(), strWFModelId);
    }

    public static IWFModel getWFModelByRuntimeId(Object runtimeId) throws Exception {
        String strRuntimeId = runtimeId.toString();
        String strRealId = wfModelRuntimeMap.get(strRuntimeId);
        if (strRealId == null) {
            return WFModelGlobal.getWFModel(strRuntimeId);
        }
        return WFModelGlobal.getWFModel(strRealId);
    }
}

