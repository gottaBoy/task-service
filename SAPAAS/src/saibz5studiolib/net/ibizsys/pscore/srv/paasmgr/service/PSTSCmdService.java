/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.paasmgr.service;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTSCmd;
import net.ibizsys.pscore.srv.paasmgr.service.PSTSCmdServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSTSCmdService
extends PSTSCmdServiceBase {
    private static final Log log = LogFactory.getLog(PSTSCmdService.class);

    @Override
    protected void onEndTask(PSTSCmd pSTSCmd) throws Exception {
        this.get(pSTSCmd);
        this.executeRemoteCall3("KILLCMD", pSTSCmd);
    }
}

