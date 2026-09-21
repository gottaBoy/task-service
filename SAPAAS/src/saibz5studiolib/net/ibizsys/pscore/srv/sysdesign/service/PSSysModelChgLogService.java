/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.ObjectMapper
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.service.ISFSAction
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.service.ISFSAction;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysModelChgLog;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysModelChgLogServiceBase;
import net.ibizsys.pscore.srv.web.WebContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysModelChgLogService
extends PSSysModelChgLogServiceBase {
    private static final Log log = LogFactory.getLog(PSSysModelChgLogService.class);
    private static ObjectMapper MAPPER = new ObjectMapper();

    @Override
    protected void onFillEntityFullInfo_PSDE(PSSysModelChgLog pSSysModelChgLog, boolean bl) throws Exception {
        super.onFillEntityFullInfo_PSDE(pSSysModelChgLog, bl);
        if (StringHelper.isNullOrEmpty((String)pSSysModelChgLog.getPSSystemId()) && pSSysModelChgLog.getPSDE() != null) {
            pSSysModelChgLog.setPSSystemId(pSSysModelChgLog.getPSDE().getPSSystemId());
            pSSysModelChgLog.setPSSystemName(pSSysModelChgLog.getPSDE().getPSSystemName());
        }
    }

    @Override
    protected void onFillParentInfo_PSSysApp(PSSysModelChgLog pSSysModelChgLog, PSSysApp pSSysApp) throws Exception {
        super.onFillParentInfo_PSSysApp(pSSysModelChgLog, pSSysApp);
        if (StringHelper.isNullOrEmpty((String)pSSysModelChgLog.getPSSystemId()) && pSSysModelChgLog.getPSSysApp() != null) {
            pSSysModelChgLog.setPSSystemId(pSSysModelChgLog.getPSSysApp().getPSSystemId());
            pSSysModelChgLog.setPSSystemName(pSSysModelChgLog.getPSSysApp().getPSSystemName());
        }
    }

    @Override
    protected void onAfterCreate(PSSysModelChgLog pSSysModelChgLog) throws Exception {
        try {
            if (PSSysModelChgLogService.isEnableKafkaPlugin()) {
                Object object;
                Map.Entry entry2;
                HashMap hashMap = new HashMap();
                pSSysModelChgLog.fillMap(hashMap, true);
                hashMap.remove("CREATEDATE");
                hashMap.remove("UPDATEDATE");
                HashMap<String, Object> hashMap2 = new HashMap<String, Object>();
                for (Map.Entry entry2 : hashMap.entrySet()) {
                    object = entry2.getValue();
                    if (object == null || object == EntityBase.EMPTY) continue;
                    hashMap2.put(((String)entry2.getKey()).toLowerCase(), object);
                }
                String string = PSSysModelChgLogService.getCurrentPSDCId();
                if (!StringHelper.isNullOrEmpty((String)string)) {
                    hashMap2.put("psdevcenterid", string);
                }
                if (!StringHelper.isNullOrEmpty((String)((Object)(entry2 = PSSysModelChgLogService.getCurrentPSDevSlnSysId())))) {
                    hashMap2.put("psdevslnsysid", entry2);
                }
                if (!StringHelper.isNullOrEmpty(object = PSSysModelChgLogService.getCurrentPSSvrDomainId())) {
                    hashMap2.put("pssvrdomainid", object);
                }
                if (pSSysModelChgLog.getCreateDate() != null) {
                    hashMap2.put("createdate", pSSysModelChgLog.getCreateDate().getTime());
                } else {
                    hashMap2.put("createdate", System.currentTimeMillis());
                }
                if (!hashMap2.containsKey("createman") && WebContext.getCurrent() != null) {
                    hashMap2.put("createman", WebContext.getCurrent().getCurLoginName());
                }
                hashMap2.put("eventtime", hashMap2.get("createdate"));
                final String string2 = MAPPER.writeValueAsString(hashMap2);
                SessionFactoryManager.getCurrentSFS().registerSFSAction(this.getRealSessionFactory(), new ISFSAction(){

                    public void commit() {
                        PSCoreSysServiceBase.getPSKafkaPlugin().sendPSSysModelChgLog(string2);
                    }

                    public void rollback() {
                    }
                });
            }
        }
        catch (Exception exception) {
            log.error((Object)exception);
        }
        super.onAfterCreate(pSSysModelChgLog);
    }
}

