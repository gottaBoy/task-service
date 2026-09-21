/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysActor;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysActorServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysActorService
extends PSSysActorServiceBase {
    private static final Log log = LogFactory.getLog(PSSysActorService.class);

    @Override
    public void getDraft(PSSysActor pSSysActor) throws Exception {
        super.getDraft(pSSysActor);
    }

    @Override
    protected Map<String, Object> getGetDraftDefaultValueScope(PSSysActor pSSysActor, boolean bl) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        if (!StringHelper.isNullOrEmpty((String)pSSysActor.getPSSystemId())) {
            hashMap.put("PSSYSTEMID", pSSysActor.getPSSystemId());
        }
        return hashMap;
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSSysActor pSSysActor, boolean bl) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        if (StringHelper.isNullOrEmpty((String)pSSysActor.getPSSysActorName())) {
            hashMap.put("PSSYSACTORNAME", "\u64cd\u4f5c\u8005");
        }
        if (StringHelper.isNullOrEmpty((String)pSSysActor.getCodeName())) {
            hashMap.put("CODENAME", "Actor");
        }
        return hashMap;
    }
}

