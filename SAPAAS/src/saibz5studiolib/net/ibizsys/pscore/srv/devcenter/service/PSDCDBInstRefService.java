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
package net.ibizsys.pscore.srv.devcenter.service;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDBInstRef;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst;
import net.ibizsys.pscore.srv.devcenter.service.PSDCDBInstRefServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDCDBInstRefService
extends PSDCDBInstRefServiceBase {
    private static final Log log = LogFactory.getLog(PSDCDBInstRefService.class);

    @Override
    protected void onBeforeCreate(PSDCDBInstRef pSDCDBInstRef) throws Exception {
        super.onBeforeCreate(pSDCDBInstRef);
    }

    @Override
    protected void onAfterCreate(PSDCDBInstRef pSDCDBInstRef) throws Exception {
        PSDevCenterDBInstService pSDevCenterDBInstService = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)this.getSessionFactory());
        PSDevCenterDBInst pSDevCenterDBInst = new PSDevCenterDBInst();
        pSDevCenterDBInst.setPSDevCenterDBInstId(pSDCDBInstRef.getPSDevCenterDBInstId());
        pSDevCenterDBInstService.calcRefInfo(pSDevCenterDBInst);
        super.onAfterCreate(pSDCDBInstRef);
    }

    @Override
    protected void onAfterRemove(PSDCDBInstRef pSDCDBInstRef) throws Exception {
        PSDCDBInstRef pSDCDBInstRef2 = (PSDCDBInstRef)this.getLast(pSDCDBInstRef);
        PSDevCenterDBInstService pSDevCenterDBInstService = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)this.getSessionFactory());
        PSDevCenterDBInst pSDevCenterDBInst = new PSDevCenterDBInst();
        pSDevCenterDBInst.setPSDevCenterDBInstId(pSDCDBInstRef2.getPSDevCenterDBInstId());
        pSDevCenterDBInstService.calcRefInfo(pSDevCenterDBInst);
        super.onAfterRemove(pSDCDBInstRef);
    }

    @Override
    protected boolean isPrepareLastForRemove() {
        return true;
    }
}

