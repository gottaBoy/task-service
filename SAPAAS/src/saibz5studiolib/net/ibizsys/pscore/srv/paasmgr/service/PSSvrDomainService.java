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
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainServiceBase;
import net.ibizsys.pscore.srv.util.PSCoreEntityKeeperGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSvrDomainService
extends PSSvrDomainServiceBase {
    private static final Log log = LogFactory.getLog(PSSvrDomainService.class);

    @Override
    protected void onSyncDomainData(PSSvrDomain pSSvrDomain) throws Exception {
        if (!this.isMajorSessionFactory()) {
            return;
        }
        this.get(pSSvrDomain);
        PSCoreEntityKeeperGlobal.getCurrent(this.getSessionFactory()).updatePSSvrDomain(pSSvrDomain);
    }
}

