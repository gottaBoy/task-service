/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewLogic;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewLogicServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEViewLogicService
extends PSDEViewLogicServiceBase {
    private static final Log log = LogFactory.getLog(PSDEViewLogicService.class);

    protected CallResult internalGet(PSDEViewLogic pSDEViewLogic, boolean bl) throws Exception {
        String string;
        CallResult callResult = super.internalGet(pSDEViewLogic, bl);
        if (callResult.isOk() && StringHelper.compare((String)(string = pSDEViewLogic.getDstLogicType()), (String)"DELOGIC", (boolean)true) == 0) {
            pSDEViewLogic.setDstLogicType("DEUILOGIC");
        }
        return callResult;
    }

    @Override
    protected CallResult internalGetTemp(PSDEViewLogic pSDEViewLogic, boolean bl) throws Exception {
        String string;
        CallResult callResult = super.internalGetTemp(pSDEViewLogic, bl);
        if (callResult.isOk() && StringHelper.compare((String)(string = pSDEViewLogic.getDstLogicType()), (String)"DELOGIC", (boolean)true) == 0) {
            pSDEViewLogic.setDstLogicType("DEUILOGIC");
        }
        return callResult;
    }

    @Override
    protected Map<String, Object> getGetDraftDefaultValueScope(PSDEViewLogic pSDEViewLogic, boolean bl) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        if (!StringHelper.isNullOrEmpty((String)pSDEViewLogic.getPSDEViewBaseId())) {
            hashMap.put("PSDEVIEWBASEID", pSDEViewLogic.getPSDEViewBaseId());
        }
        return hashMap;
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSDEViewLogic pSDEViewLogic, boolean bl) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        if (StringHelper.isNullOrEmpty((String)pSDEViewLogic.getPSDEViewLogicName())) {
            hashMap.put("PSDEVIEWLOGICNAME", "vl");
        }
        return hashMap;
    }
}

