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
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServerLog;
import net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerLogServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSTaskServerLogService
extends PSTaskServerLogServiceBase {
    private static final Log log = LogFactory.getLog(PSTaskServerLogService.class);

    @Override
    protected void onAfterCreate(PSTaskServerLog pSTaskServerLog) throws Exception {
        if (StringHelper.compare((String)pSTaskServerLog.getPSTaskServerId(), (String)pSTaskServerLog.getPSTaskServerLogId(), (boolean)false) != 0) {
            PSTaskServerLog pSTaskServerLog2 = new PSTaskServerLog();
            pSTaskServerLog.copyTo((IDataObject)pSTaskServerLog2, false);
            pSTaskServerLog2.setPSTaskServerLogId(pSTaskServerLog.getPSTaskServerId());
            pSTaskServerLog2.resetPSTaskServerLogName();
            pSTaskServerLog2.resetDefaultFlag();
            this.update(pSTaskServerLog2, false);
        }
        super.onAfterCreate(pSTaskServerLog);
    }
}

