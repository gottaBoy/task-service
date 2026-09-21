/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.appdesign.service;

import java.util.ArrayList;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppWFVer;
import net.ibizsys.pscore.srv.appdesign.service.PSAppWFVerServiceBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFDE;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflow;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFDEService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSAppWFVerService
extends PSAppWFVerServiceBase {
    private static final Log log = LogFactory.getLog(PSAppWFVerService.class);

    @Override
    public void getDraft(PSAppWFVer pSAppWFVer) throws Exception {
        super.getDraft(pSAppWFVer);
        if (pSAppWFVer.getPSAppWF() != null) {
            pSAppWFVer.setPSWorkflowId(pSAppWFVer.getPSAppWF().getPSWorkflowId());
            pSAppWFVer.setPSSysAppId(pSAppWFVer.getPSAppWF().getPSSysAppId());
            pSAppWFVer.setPSSysAppName(pSAppWFVer.getPSAppWF().getPSSysAppId());
        }
    }

    @Override
    protected void onBeforeCreate(PSAppWFVer pSAppWFVer) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSAppWFVer.getPSAppWFVerName())) {
            pSAppWFVer.setPSAppWFVerName(pSAppWFVer.getPSWFVersionName());
        }
        if (pSAppWFVer.getPSAppWF() != null) {
            pSAppWFVer.setPSSysAppId(pSAppWFVer.getPSAppWF().getPSSysAppId());
            pSAppWFVer.setPSSysAppName(pSAppWFVer.getPSAppWF().getPSSysAppId());
        }
        super.onBeforeCreate(pSAppWFVer);
    }

    @Override
    protected void onAfterCreate(PSAppWFVer pSAppWFVer) throws Exception {
        this.rebuildPSDEViewBases(pSAppWFVer);
        super.onAfterCreate(pSAppWFVer);
    }

    @Override
    protected void onAfterUpdate(PSAppWFVer pSAppWFVer) throws Exception {
        this.rebuildPSDEViewBases(pSAppWFVer);
        super.onAfterUpdate(pSAppWFVer);
    }

    public void rebuildPSDEViewBases(PSAppWFVer pSAppWFVer) throws Exception {
        if (pSAppWFVer.getPSAppWF() == null) {
            return;
        }
        PSWorkflow pSWorkflow = pSAppWFVer.getPSAppWF().getPSWorkflow();
        if (pSWorkflow == null) {
            return;
        }
        PSWFDEService pSWFDEService = (PSWFDEService)ServiceGlobal.getService(PSWFDEService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSWFDE> arrayList = pSWorkflow.getPSWFDEs();
        for (PSWFDE pSWFDE : arrayList) {
            if (pSWFDE.getWFProxyMode() == null || pSWFDE.getWFProxyMode() != 2) continue;
            pSWFDEService.initDEWFViews(pSWFDE);
        }
    }
}

