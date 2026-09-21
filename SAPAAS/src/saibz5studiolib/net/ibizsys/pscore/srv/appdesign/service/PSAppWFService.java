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

import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppWF;
import net.ibizsys.pscore.srv.appdesign.service.PSAppWFServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSAppWFService
extends PSAppWFServiceBase {
    private static final Log log = LogFactory.getLog(PSAppWFService.class);

    @Override
    protected void onBeforeCreate(PSAppWF pSAppWF) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSAppWF.getPSAppWFName())) {
            String string = pSAppWF.getPSWorkflowName();
            String string2 = pSAppWF.getPSSysAppName();
            if (StringHelper.isNullOrEmpty((String)string) && pSAppWF.getPSWorkflow() != null) {
                string = pSAppWF.getPSWorkflow().getPSWorkflowName();
                pSAppWF.setPSWorkflowName(string);
            }
            if (StringHelper.isNullOrEmpty((String)string2) && pSAppWF.getPSSysApp() != null) {
                string2 = pSAppWF.getPSSysApp().getPSSysAppName();
                pSAppWF.setPSSysAppName(string2);
            }
            pSAppWF.setPSAppWFName(StringHelper.format((String)"%1$s-%2$s", (Object)pSAppWF.getPSWorkflowName(), (Object)pSAppWF.getPSSysAppName()));
        }
        super.onBeforeCreate(pSAppWF);
    }
}

