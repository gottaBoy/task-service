/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.devcenter.service;

import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterServer;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterServerServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDevCenterServerService
extends PSDevCenterServerServiceBase {
    private static final Log log = LogFactory.getLog(PSDevCenterServerService.class);

    @Override
    protected void onAfterCreate(PSDevCenterServer pSDevCenterServer) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            // empty if block
        }
        super.onAfterCreate(pSDevCenterServer);
    }

    @Override
    protected void onAfterUpdate(PSDevCenterServer pSDevCenterServer) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            // empty if block
        }
        super.onAfterUpdate(pSDevCenterServer);
    }

    @Override
    protected void onAfterRemove(PSDevCenterServer pSDevCenterServer) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            // empty if block
        }
        super.onAfterRemove(pSDevCenterServer);
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    @Override
    protected boolean isPrepareLastForRemove() {
        return true;
    }
}

