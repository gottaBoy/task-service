/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.ObjectMapper
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.service.ISFSAction
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.WebContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.paasmgr.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.service.ISFSAction;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSBKTaskLog;
import net.ibizsys.pscore.srv.paasmgr.service.PSBKTaskLogServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSBKTaskLogService
extends PSBKTaskLogServiceBase {
    private static ObjectMapper MAPPER = new ObjectMapper();
    private static final Log log = LogFactory.getLog(PSBKTaskLogService.class);

    @Override
    protected void onAfterCreate(PSBKTaskLog pSBKTaskLog) throws Exception {
        this.sendToKafka(pSBKTaskLog, true);
        super.onAfterCreate(pSBKTaskLog);
    }

    @Override
    protected void onAfterUpdate(PSBKTaskLog pSBKTaskLog) throws Exception {
        this.sendToKafka(pSBKTaskLog, false);
        super.onAfterUpdate(pSBKTaskLog);
    }

    protected void sendToKafka(PSBKTaskLog pSBKTaskLog, boolean bl) {
        try {
            if (PSBKTaskLogService.isEnableKafkaPlugin()) {
                HashMap<String, Object> hashMap = new HashMap<String, Object>();
                pSBKTaskLog.fillMap(hashMap, true);
                hashMap.remove("CREATEDATE");
                hashMap.remove("UPDATEDATE");
                HashMap<String, Object> hashMap2 = new HashMap<String, Object>();
                for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                    Object v = entry.getValue();
                    if (v == null || v == EntityBase.EMPTY) continue;
                    hashMap2.put(entry.getKey().toLowerCase(), v);
                }
                String string = PSBKTaskLogService.getCurrentPSSvrDomainId();
                if (!StringHelper.isNullOrEmpty((String)string)) {
                    hashMap2.put("pssvrdomainid", string);
                }
                if (bl) {
                    if (pSBKTaskLog.getCreateDate() != null) {
                        hashMap2.put("createdate", pSBKTaskLog.getCreateDate().getTime());
                    } else {
                        hashMap2.put("createdate", System.currentTimeMillis());
                    }
                    hashMap2.put("eventtime", hashMap2.get("createdate"));
                    if (!hashMap2.containsKey("createman") && WebContext.getCurrent() != null) {
                        hashMap2.put("createman", WebContext.getCurrent().getCurLoginName());
                    }
                } else {
                    if (pSBKTaskLog.getUpdateDate() != null) {
                        hashMap2.put("updatedate", pSBKTaskLog.getUpdateDate().getTime());
                    } else {
                        hashMap2.put("updatedate", System.currentTimeMillis());
                    }
                    hashMap2.put("eventtime", hashMap2.get("updatedate"));
                    if (!hashMap2.containsKey("updateman") && WebContext.getCurrent() != null) {
                        hashMap2.put("updateman", WebContext.getCurrent().getCurLoginName());
                    }
                }
                final String content = MAPPER.writeValueAsString(hashMap2);
                SessionFactoryManager.getCurrentSFS().registerSFSAction(this.getRealSessionFactory(), new ISFSAction(){
                    public void commit() {
                        PSCoreSysServiceBase.getPSKafkaPlugin().sendPSBKTaskLog(content);
                    }

                    public void rollback() {
                    }
                });
            }
        }
        catch (Exception exception) {
            log.error((Object)exception);
        }
    }
}
