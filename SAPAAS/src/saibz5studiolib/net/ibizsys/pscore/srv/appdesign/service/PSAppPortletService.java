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
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppPortlet;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPortletServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSAppPortletService
extends PSAppPortletServiceBase {
    private static final Log log = LogFactory.getLog(PSAppPortletService.class);

    @Override
    protected void onBeforeCreate(PSAppPortlet pSAppPortlet) throws Exception {
        super.onBeforeCreate(pSAppPortlet);
        if (!PSAppPortletService.isImpSysModelNowEx() && StringHelper.isNullOrEmpty((String)pSAppPortlet.getCodeName())) {
            String string = "AppPortlet";
            if (pSAppPortlet.getPSSysPortlet() != null && !StringHelper.isNullOrEmpty((String)pSAppPortlet.getPSSysPortlet().getCodeName())) {
                string = pSAppPortlet.getPSSysPortlet().getCodeName();
            }
            HashMap<String, String> hashMap = new HashMap<String, String>();
            HashMap<String, Object> hashMap2 = new HashMap<String, Object>();
            hashMap.put("CODENAME", string);
            hashMap2.put("PSSYSAPPID", pSAppPortlet.getPSSysAppId());
            this.fillDefaultValue(pSAppPortlet, false, hashMap, hashMap2);
        }
    }
}

