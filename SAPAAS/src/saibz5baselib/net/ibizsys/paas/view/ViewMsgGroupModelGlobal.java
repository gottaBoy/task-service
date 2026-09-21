/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.view;

import java.util.HashMap;
import net.ibizsys.paas.view.IViewMsgGroupModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ViewMsgGroupModelGlobal {
    private static final Log log = LogFactory.getLog(ViewMsgGroupModelGlobal.class);
    private static HashMap<String, IViewMsgGroupModel> viewMsgGroupMap = new HashMap();

    public static void registerViewMsgGroup(String strViewMsgGroupClsType, IViewMsgGroupModel iViewMsgGroup) {
        viewMsgGroupMap.put(strViewMsgGroupClsType, iViewMsgGroup);
        viewMsgGroupMap.put(iViewMsgGroup.getId(), iViewMsgGroup);
    }

    public static IViewMsgGroupModel getViewMsgGroup(Class cls) throws Exception {
        return ViewMsgGroupModelGlobal.getViewMsgGroup(cls.getCanonicalName());
    }

    public static IViewMsgGroupModel getViewMsgGroup(String strViewMsgGroupClsType) throws Exception {
        return viewMsgGroupMap.get(strViewMsgGroupClsType);
    }
}

