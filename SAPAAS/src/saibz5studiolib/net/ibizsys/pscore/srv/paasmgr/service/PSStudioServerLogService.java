/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.paasmgr.service;

import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.paasmgr.entity.PSStudioServerLog;
import net.ibizsys.pscore.srv.paasmgr.service.PSStudioServerLogServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSStudioServerLogService
extends PSStudioServerLogServiceBase {
    private static final Log log = LogFactory.getLog(PSStudioServerLogService.class);

    @Override
    protected void onAfterCreate(PSStudioServerLog pSStudioServerLog) throws Exception {
        if (StringHelper.compare((String)pSStudioServerLog.getPSStudioServerId(), (String)pSStudioServerLog.getPSStudioServerLogId(), (boolean)false) != 0) {
            PSStudioServerLog pSStudioServerLog2 = new PSStudioServerLog();
            pSStudioServerLog.copyTo((IDataObject)pSStudioServerLog2, false);
            pSStudioServerLog2.setPSStudioServerLogId(pSStudioServerLog.getPSStudioServerId());
            pSStudioServerLog2.resetPSStudioServerLogName();
            pSStudioServerLog2.resetDefaultFlag();
            this.update(pSStudioServerLog2, false);
        }
        super.onAfterCreate(pSStudioServerLog);
    }
}

