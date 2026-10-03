/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.wfdesign.service;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVerLog;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFVerLogServiceBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSWFVerLogService
extends PSWFVerLogServiceBase {
    private static final Log log = LogFactory.getLog(PSWFVerLogService.class);

    @Override
    protected void onRestoreVer(PSWFVerLog pSWFVerLog) throws Exception {
        this.get(pSWFVerLog);
        PSWFVersionService pSWFVersionService = (PSWFVersionService)ServiceGlobal.getService(PSWFVersionService.class, (SessionFactory)this.getSessionFactory());
        pSWFVersionService.restorePSWFVerLog(pSWFVerLog);
    }
}

