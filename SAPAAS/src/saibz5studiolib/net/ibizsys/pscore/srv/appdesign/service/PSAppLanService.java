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
import net.ibizsys.pscore.srv.appdesign.entity.PSAppLan;
import net.ibizsys.pscore.srv.appdesign.service.PSAppLanServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSAppLanService
extends PSAppLanServiceBase {
    private static final Log log = LogFactory.getLog(PSAppLanService.class);

    @Override
    protected void onBeforeCreate(PSAppLan pSAppLan) throws Exception {
        pSAppLan.setPSAppLanName(pSAppLan.getPSLanguageName());
        super.onBeforeCreate(pSAppLan);
    }

    @Override
    protected void onBeforeUpdate(PSAppLan pSAppLan) throws Exception {
        pSAppLan.setPSAppLanName(pSAppLan.getPSLanguageName());
        super.onBeforeUpdate(pSAppLan);
    }

    @Override
    protected String getEntityFolderKeyValue(PSAppLan pSAppLan, PSSystem pSSystem) throws Exception {
        return StringHelper.format((String)"%1$s-%2$s", (Object)pSAppLan.getPSSysAppId(), (Object)pSAppLan.getPSLanguageId());
    }
}

