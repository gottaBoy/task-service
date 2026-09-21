/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.config.service;

import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.config.entity.PSSysResource;
import net.ibizsys.pscore.srv.config.service.PSSysResourceServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysResourceService
extends PSSysResourceServiceBase {
    private static final Log log = LogFactory.getLog(PSSysResourceService.class);

    @Override
    protected Map<String, Object> getGetDraftDefaultValueScope(PSSysResource pSSysResource, boolean bl) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        if (!StringHelper.isNullOrEmpty((String)pSSysResource.getPSSystemId())) {
            hashMap.put("PSSYSTEMID", pSSysResource.getPSSystemId());
        }
        return hashMap;
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSSysResource pSSysResource, boolean bl) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        if (StringHelper.isNullOrEmpty((String)pSSysResource.getPSSysResourceName())) {
            hashMap.put("PSSYSRESOURCENAME", "\u7cfb\u7edf\u8d44\u6e90");
        }
        if (StringHelper.isNullOrEmpty((String)pSSysResource.getResTag())) {
            hashMap.put("RESTAG", "APPRES");
        }
        return hashMap;
    }
}

