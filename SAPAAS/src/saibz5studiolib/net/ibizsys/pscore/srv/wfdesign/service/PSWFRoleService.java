/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.wfdesign.service;

import java.util.HashMap;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFRole;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFRoleServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSWFRoleService
extends PSWFRoleServiceBase {
    private static final Log log = LogFactory.getLog(PSWFRoleService.class);

    @Override
    protected void onBeforeCreate(PSWFRole pSWFRole) throws Exception {
        super.onBeforeCreate(pSWFRole);
        if (!PSWFRoleService.isImpSysModelNowEx() && StringHelper.isNullOrEmpty((String)pSWFRole.getCodeName())) {
            String string = pSWFRole.getWFRoleType();
            if (StringHelper.isNullOrEmpty((String)string)) {
                string = "WFRole";
            }
            HashMap<String, String> hashMap = new HashMap<String, String>();
            HashMap<String, Object> hashMap2 = new HashMap<String, Object>();
            hashMap.put("CODENAME", string);
            hashMap2.put("PSSYSTEMID", pSWFRole.getPSSystemId());
            this.fillDefaultValue(pSWFRole, false, hashMap, hashMap2);
        }
    }
}

