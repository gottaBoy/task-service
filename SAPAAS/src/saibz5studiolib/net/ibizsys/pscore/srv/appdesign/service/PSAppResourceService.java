/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.appdesign.service;

import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppResource;
import net.ibizsys.pscore.srv.appdesign.service.PSAppResourceServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSAppResourceService
extends PSAppResourceServiceBase {
    private static final Log log = LogFactory.getLog(PSAppResourceService.class);

    @Override
    protected Map<String, Object> getGetDraftDefaultValueScope(PSAppResource pSAppResource, boolean bl) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        if (!StringHelper.isNullOrEmpty((String)pSAppResource.getPSSysAppId())) {
            hashMap.put("PSSYSAPPID", pSAppResource.getPSSysAppId());
        }
        return hashMap;
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSAppResource pSAppResource, boolean bl) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        if (StringHelper.isNullOrEmpty((String)pSAppResource.getPSAppResourceName())) {
            hashMap.put("PSAPPRESOURCENAME", "\u5e94\u7528\u8d44\u6e90");
        }
        if (StringHelper.isNullOrEmpty((String)pSAppResource.getResTag())) {
            hashMap.put("RESTAG", "APPRES");
        }
        return hashMap;
    }
}

