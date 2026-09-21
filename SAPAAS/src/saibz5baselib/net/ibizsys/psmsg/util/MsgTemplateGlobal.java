/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psmsg.util;

import java.util.HashMap;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.psrt.srv.common.entity.MsgTemplate;
import net.ibizsys.psrt.srv.common.service.MsgTemplateService;

public class MsgTemplateGlobal {
    private static HashMap<String, MsgTemplate> msgTemplateMap = new HashMap();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static MsgTemplate getMsgTemplate(String strMsgTemplateId) throws Exception {
        MsgTemplate msgTemplate = null;
        HashMap<String, MsgTemplate> hashMap = msgTemplateMap;
        synchronized (hashMap) {
            msgTemplate = msgTemplateMap.get(strMsgTemplateId);
        }
        if (msgTemplate != null) {
            return msgTemplate;
        }
        msgTemplate = new MsgTemplate();
        msgTemplate.setMsgTemplateId(strMsgTemplateId);
        MsgTemplateService msgTemplateService = (MsgTemplateService)ServiceGlobal.getService(MsgTemplateService.class);
        msgTemplateService.get(msgTemplate);
        HashMap<String, MsgTemplate> hashMap2 = msgTemplateMap;
        synchronized (hashMap2) {
            msgTemplateMap.put(strMsgTemplateId, msgTemplate);
        }
        return msgTemplate;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void removeMsgTemplate(String strMsgTemplateId) throws Exception {
        HashMap<String, MsgTemplate> hashMap = msgTemplateMap;
        synchronized (hashMap) {
            msgTemplateMap.remove(strMsgTemplateId);
        }
    }
}

