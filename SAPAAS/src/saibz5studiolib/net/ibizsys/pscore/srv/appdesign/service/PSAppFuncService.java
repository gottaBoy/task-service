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
import net.ibizsys.pscore.srv.appdesign.entity.PSAppFunc;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppLocalDE;
import net.ibizsys.pscore.srv.appdesign.service.PSAppFuncServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSAppFuncService
extends PSAppFuncServiceBase {
    private static final Log log = LogFactory.getLog(PSAppFuncService.class);

    @Override
    protected void onCalcPSDEId(PSAppFunc pSAppFunc) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSAppFunc.getPSAppLocalDEId())) {
            pSAppFunc.setPSDEId(null);
        } else {
            pSAppFunc.setSessionFactory(this.getSessionFactory());
            PSAppLocalDE pSAppLocalDE = pSAppFunc.getPSAppLocalDE();
            pSAppFunc.setPSDEId(pSAppLocalDE.getPSDEId());
        }
    }
}

