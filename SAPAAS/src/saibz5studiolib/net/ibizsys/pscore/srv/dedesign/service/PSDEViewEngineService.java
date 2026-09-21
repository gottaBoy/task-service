/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewEngine;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewEngineServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEViewEngineService
extends PSDEViewEngineServiceBase {
    private static final Log log = LogFactory.getLog(PSDEViewEngineService.class);

    @Override
    protected Map<String, Object> getGetDraftDefaultValueScope(PSDEViewEngine pSDEViewEngine, boolean bl) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        if (!StringHelper.isNullOrEmpty((String)pSDEViewEngine.getPSDEViewBaseId())) {
            hashMap.put("PSDEVIEWBASEID", pSDEViewEngine.getPSDEViewBaseId());
        }
        return hashMap;
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSDEViewEngine pSDEViewEngine, boolean bl) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        if (StringHelper.isNullOrEmpty((String)pSDEViewEngine.getPSDEViewEngineName())) {
            hashMap.put("PSDEVIEWENGINENAME", "ve");
        }
        return hashMap;
    }
}

