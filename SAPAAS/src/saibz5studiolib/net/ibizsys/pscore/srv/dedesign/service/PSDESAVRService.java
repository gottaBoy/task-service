/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.service.IDataContextParam
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESAVR;
import net.ibizsys.pscore.srv.dedesign.service.PSDESAVRServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDESAVRService
extends PSDESAVRServiceBase {
    private static final Log log = LogFactory.getLog(PSDESAVRService.class);

    @Override
    protected Map<String, Object> getGetDraftDefaultValueScope(PSDESAVR pSDESAVR, boolean bl) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        if (!StringHelper.isNullOrEmpty((String)pSDESAVR.getPSDEServiceAPIId())) {
            hashMap.put("PSDESERVICEAPIID", pSDESAVR.getPSDEServiceAPIId());
        }
        return hashMap;
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSDESAVR pSDESAVR, boolean bl) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        if (StringHelper.isNullOrEmpty((String)pSDESAVR.getPSDESAVRName())) {
            hashMap.put("PSDESAVRNAME", "\u89c4\u5219");
        }
        if (StringHelper.isNullOrEmpty((String)pSDESAVR.getCodeName())) {
            hashMap.put("CODENAME", "Rule");
        }
        return hashMap;
    }

    @Override
    public Object getDataContextValue(PSDESAVR pSDESAVR, String string, IDataContextParam iDataContextParam) throws Exception {
        if (iDataContextParam != null && StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEFVALUERULE", (boolean)true) == 0 && StringHelper.compare((String)string, (String)"psdeid", (boolean)true) == 0) {
            if (pSDESAVR.getPSDEServiceAPI() != null) {
                return pSDESAVR.getPSDEServiceAPI().getPSDEId();
            }
            return null;
        }
        return super.getDataContextValue(pSDESAVR, string, iDataContextParam);
    }
}

