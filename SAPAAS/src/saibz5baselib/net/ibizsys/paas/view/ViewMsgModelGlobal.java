/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.view;

import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.view.IDEDataSetViewMsgModel;
import net.ibizsys.paas.view.IViewMsgModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ViewMsgModelGlobal {
    private static final Log log = LogFactory.getLog(ViewMsgModelGlobal.class);
    private static HashMap<String, IViewMsgModel> viewMsgMap = new HashMap();

    public static void registerViewMsg(String strViewMsgClsType, IViewMsgModel iViewMsg) {
        viewMsgMap.put(strViewMsgClsType, iViewMsg);
        viewMsgMap.put(iViewMsg.getId(), iViewMsg);
    }

    public static IViewMsgModel getViewMsg(Class cls) throws Exception {
        return ViewMsgModelGlobal.getViewMsg(cls.getCanonicalName());
    }

    public static IViewMsgModel getViewMsg(String strViewMsgClsType) throws Exception {
        return viewMsgMap.get(strViewMsgClsType);
    }

    public static void reloadAllViewMsgs() {
        ArrayList<IViewMsgModel> list = new ArrayList<IViewMsgModel>();
        list.addAll(viewMsgMap.values());
        for (IViewMsgModel iViewMsgModel : list) {
            if (!(iViewMsgModel instanceof IDEDataSetViewMsgModel)) continue;
            ((IDEDataSetViewMsgModel)iViewMsgModel).resetCache();
        }
    }
}

