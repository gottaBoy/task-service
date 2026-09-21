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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterMQ;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterMQServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDevCenterMQService
extends PSDevCenterMQServiceBase {
    private static final Log log = LogFactory.getLog(PSDevCenterMQService.class);

    @Override
    protected void onAfterCreate(PSDevCenterMQ pSDevCenterMQ) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            // empty if block
        }
        super.onAfterCreate(pSDevCenterMQ);
    }

    @Override
    protected void onAfterUpdate(PSDevCenterMQ pSDevCenterMQ) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            // empty if block
        }
        super.onAfterUpdate(pSDevCenterMQ);
    }

    @Override
    protected void onAfterRemove(PSDevCenterMQ pSDevCenterMQ) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            // empty if block
        }
        super.onAfterRemove(pSDevCenterMQ);
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

