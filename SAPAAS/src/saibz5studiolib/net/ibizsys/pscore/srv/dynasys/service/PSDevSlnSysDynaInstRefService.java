/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dynasys.service;

import java.sql.Timestamp;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInst;
import net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInstRef;
import net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstRefServiceBase;
import net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDevSlnSysDynaInstRefService
extends PSDevSlnSysDynaInstRefServiceBase {
    private static final Log log = LogFactory.getLog(PSDevSlnSysDynaInstRefService.class);

    @Override
    protected void onAfterCreate(PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef) throws Exception {
        if (!StringHelper.isNullOrEmpty((String)pSDevSlnSysDynaInstRef.getPSDevSlnSysDynaInstId())) {
            PSDevSlnSysDynaInstService pSDevSlnSysDynaInstService = (PSDevSlnSysDynaInstService)ServiceGlobal.getService(PSDevSlnSysDynaInstService.class, (SessionFactory)this.getSessionFactory());
            PSDevSlnSysDynaInst pSDevSlnSysDynaInst = new PSDevSlnSysDynaInst();
            pSDevSlnSysDynaInst.setPSDevSlnSysDynaInstId(pSDevSlnSysDynaInstRef.getPSDevSlnSysDynaInstId());
            pSDevSlnSysDynaInst.setRefUpdateDate(new Timestamp(System.currentTimeMillis()));
            pSDevSlnSysDynaInstService.sysUpdate(pSDevSlnSysDynaInst, false);
        }
        super.onAfterCreate(pSDevSlnSysDynaInstRef);
    }

    @Override
    protected void onAfterUpdate(PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef) throws Exception {
        if (!StringHelper.isNullOrEmpty((String)pSDevSlnSysDynaInstRef.getPSDevSlnSysDynaInstId())) {
            PSDevSlnSysDynaInstService pSDevSlnSysDynaInstService = (PSDevSlnSysDynaInstService)ServiceGlobal.getService(PSDevSlnSysDynaInstService.class, (SessionFactory)this.getSessionFactory());
            PSDevSlnSysDynaInst pSDevSlnSysDynaInst = new PSDevSlnSysDynaInst();
            pSDevSlnSysDynaInst.setPSDevSlnSysDynaInstId(pSDevSlnSysDynaInstRef.getPSDevSlnSysDynaInstId());
            pSDevSlnSysDynaInst.setRefUpdateDate(new Timestamp(System.currentTimeMillis()));
            pSDevSlnSysDynaInstService.sysUpdate(pSDevSlnSysDynaInst, false);
        }
        super.onAfterUpdate(pSDevSlnSysDynaInstRef);
    }

    @Override
    protected void onAfterRemove(PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef) throws Exception {
        PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef2 = (PSDevSlnSysDynaInstRef)this.getLast((IEntity)pSDevSlnSysDynaInstRef);
        if (!StringHelper.isNullOrEmpty((String)pSDevSlnSysDynaInstRef2.getPSDevSlnSysDynaInstId())) {
            PSDevSlnSysDynaInstService pSDevSlnSysDynaInstService = (PSDevSlnSysDynaInstService)ServiceGlobal.getService(PSDevSlnSysDynaInstService.class, (SessionFactory)this.getSessionFactory());
            PSDevSlnSysDynaInst pSDevSlnSysDynaInst = new PSDevSlnSysDynaInst();
            pSDevSlnSysDynaInst.setPSDevSlnSysDynaInstId(pSDevSlnSysDynaInstRef2.getPSDevSlnSysDynaInstId());
            pSDevSlnSysDynaInst.setRefUpdateDate(new Timestamp(System.currentTimeMillis()));
            pSDevSlnSysDynaInstService.sysUpdate(pSDevSlnSysDynaInst, false);
        }
        super.onAfterRemove(pSDevSlnSysDynaInstRef);
    }

    @Override
    protected boolean isPrepareLastForRemove() {
        return true;
    }
}

