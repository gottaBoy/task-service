/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.appdesign.service;

import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppViewCode;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewCodeServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSAppViewCodeService
extends PSAppViewCodeServiceBase {
    private static final Log log = LogFactory.getLog(PSAppViewCodeService.class);

    @Override
    protected void onFillParentInfo_PSAppView(PSAppViewCode pSAppViewCode, PSAppView pSAppView) throws Exception {
        super.onFillParentInfo_PSAppView(pSAppViewCode, pSAppView);
        pSAppViewCode.setPSSysAppId(pSAppView.getPSSysAppId());
        pSAppViewCode.setPSSysAppName(pSAppView.getPSSysAppName());
    }

    @Override
    protected boolean onFillEntityKeyValue(PSAppViewCode pSAppViewCode, boolean bl) throws Exception {
        return super.onFillEntityKeyValue(pSAppViewCode, bl);
    }
}

