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
import net.ibizsys.pscore.srv.appdesign.entity.PSAppDERS;
import net.ibizsys.pscore.srv.appdesign.service.PSAppDERSServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSAppDERSService
extends PSAppDERSServiceBase {
    private static final Log log = LogFactory.getLog(PSAppDERSService.class);

    @Override
    protected void onBeforeCreate(PSAppDERS pSAppDERS) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSAppDERS.getPSAppDERSName()) && !StringHelper.isNullOrEmpty((String)pSAppDERS.getPPSAppLocalDEName()) && !StringHelper.isNullOrEmpty((String)pSAppDERS.getCPSAppLocalDEName())) {
            pSAppDERS.setPSAppDERSName(StringHelper.format((String)"%1$s-%2$s", (Object)pSAppDERS.getPPSAppLocalDEName(), (Object)pSAppDERS.getCPSAppLocalDEName()));
        }
        super.onBeforeCreate(pSAppDERS);
    }

    @Override
    protected void onBeforeCreateTemp(PSAppDERS pSAppDERS) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSAppDERS.getPSAppDERSName()) && !StringHelper.isNullOrEmpty((String)pSAppDERS.getPPSAppLocalDEName()) && !StringHelper.isNullOrEmpty((String)pSAppDERS.getCPSAppLocalDEName())) {
            pSAppDERS.setPSAppDERSName(StringHelper.format((String)"%1$s-%2$s", (Object)pSAppDERS.getPPSAppLocalDEName(), (Object)pSAppDERS.getCPSAppLocalDEName()));
        }
        super.onBeforeCreateTemp(pSAppDERS);
    }
}

