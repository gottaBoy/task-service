/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.demodel;

import java.util.HashMap;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DEModelGlobal {
    private static final Log log = LogFactory.getLog(DEModelGlobal.class);
    private static HashMap<String, IDataEntityModel> demodelMap = new HashMap();
    private static HashMap<String, String> deModelRuntimeMap = new HashMap();

    public static void registerDEModel(IDataEntityModel iDEModel) {
        demodelMap.put(iDEModel.getId(), iDEModel);
        demodelMap.put(iDEModel.getName(), iDEModel);
    }

    public static void registerDEModel(String strDEModelClsType, IDataEntityModel iDEModel) {
        demodelMap.put(strDEModelClsType, iDEModel);
        demodelMap.put(iDEModel.getId(), iDEModel);
        demodelMap.put(iDEModel.getName(), iDEModel);
    }

    public static IDataEntityModel getDEModel(Class cls) throws Exception {
        return DEModelGlobal.getDEModel(cls.getCanonicalName());
    }

    public static IDataEntityModel getDEModel(String strDEModelClsType) throws Exception {
        IDataEntityModel iDEModel = demodelMap.get(strDEModelClsType);
        if (iDEModel == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u6a21\u578b[%1$s]", strDEModelClsType));
        }
        return iDEModel;
    }

    public static IDataEntityModel getDEModel(String strDEModelClsType, boolean bTryMode) throws Exception {
        IDataEntityModel iDEModel = demodelMap.get(strDEModelClsType);
        if (iDEModel == null) {
            if (bTryMode) {
                return null;
            }
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u6a21\u578b[%1$s]", strDEModelClsType));
        }
        return iDEModel;
    }

    public static void setDEModelRuntimeId(String strDEModelId, Object runtimeId) throws Exception {
        IDataEntityModel iDEModel = DEModelGlobal.getDEModel(strDEModelId);
        if (iDEModel != null) {
            iDEModel.setRuntimeId(runtimeId);
        }
        deModelRuntimeMap.put(runtimeId.toString(), strDEModelId);
    }

    public static IDataEntityModel getDEModelByRuntimeId(Object runtimeId) throws Exception {
        String strRuntimeId = runtimeId.toString();
        String strRealId = deModelRuntimeMap.get(strRuntimeId);
        if (strRealId == null) {
            return DEModelGlobal.getDEModel(strRuntimeId);
        }
        return DEModelGlobal.getDEModel(strRealId);
    }

    public static boolean containsDEModel(String strDEName) {
        IDataEntityModel iDEModel = demodelMap.get(strDEName);
        return iDEModel != null;
    }
}

