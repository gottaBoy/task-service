/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.appdesign.service;

import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppUtilPage;
import net.ibizsys.pscore.srv.appdesign.service.PSAppUtilPageServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSAppUtilPageService
extends PSAppUtilPageServiceBase {
    private static final Log log = LogFactory.getLog(PSAppUtilPageService.class);

    @Override
    protected CallResult internalGet(PSAppUtilPage pSAppUtilPage, boolean bl, int n) throws Exception {
        CallResult callResult = super.internalGet(pSAppUtilPage, bl, n);
        if (callResult.isError()) {
            return callResult;
        }
        if (StringHelper.isNullOrEmpty((String)pSAppUtilPage.getUtilType())) {
            pSAppUtilPage.setUtilType(pSAppUtilPage.getPSAppUtilPageName());
        }
        return callResult;
    }
}

