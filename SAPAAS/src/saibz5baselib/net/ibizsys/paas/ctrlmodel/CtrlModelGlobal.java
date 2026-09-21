/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.ctrlmodel;

import java.util.HashMap;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CtrlModelGlobal {
    private static final Log log = LogFactory.getLog(CtrlModelGlobal.class);
    private static HashMap<String, ICtrlModel> ctrlModelMap = new HashMap();

    public static void registerCtrlModel(String strCtrlModelClsType, ICtrlModel iCtrlModel) {
        ctrlModelMap.put(strCtrlModelClsType, iCtrlModel);
    }

    public static ICtrlModel getCtrlModel(String strCtrlModelClsType) throws Exception {
        ICtrlModel iCtrlModel = ctrlModelMap.get(strCtrlModelClsType);
        if (iCtrlModel == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u63a7\u4ef6\u6a21\u578b[%1$s]", strCtrlModelClsType));
        }
        return iCtrlModel;
    }
}

