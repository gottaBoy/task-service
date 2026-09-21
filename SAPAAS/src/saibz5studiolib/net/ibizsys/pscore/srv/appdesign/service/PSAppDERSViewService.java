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
import net.ibizsys.pscore.srv.appdesign.entity.PSAppDERSView;
import net.ibizsys.pscore.srv.appdesign.service.PSAppDERSViewServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSAppDERSViewService
extends PSAppDERSViewServiceBase {
    private static final Log log = LogFactory.getLog(PSAppDERSViewService.class);

    @Override
    protected void onBeforeCreate(PSAppDERSView pSAppDERSView) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSAppDERSView.getPSAppDERSViewName()) && !StringHelper.isNullOrEmpty((String)pSAppDERSView.getPSAppDEViewName())) {
            pSAppDERSView.setPSAppDERSViewName(pSAppDERSView.getPSAppDEViewName());
        }
        super.onBeforeCreate(pSAppDERSView);
    }

    @Override
    protected void onBeforeCreateTemp(PSAppDERSView pSAppDERSView) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSAppDERSView.getPSAppDERSViewName()) && !StringHelper.isNullOrEmpty((String)pSAppDERSView.getPSAppDEViewName())) {
            pSAppDERSView.setPSAppDERSViewName(pSAppDERSView.getPSAppDEViewName());
        }
        super.onBeforeCreateTemp(pSAppDERSView);
    }
}

