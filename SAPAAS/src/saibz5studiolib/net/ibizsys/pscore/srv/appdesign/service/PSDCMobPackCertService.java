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
package net.ibizsys.pscore.srv.appdesign.service;

import java.sql.Timestamp;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSDCMobPackCert;
import net.ibizsys.pscore.srv.appdesign.service.PSDCMobPackCertServiceBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDCMobPackCertService
extends PSDCMobPackCertServiceBase {
    private static final Log log = LogFactory.getLog(PSDCMobPackCertService.class);

    @Override
    protected void onAfterCreate(PSDCMobPackCert pSDCMobPackCert) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = new PSDevCenter();
            pSDevCenter.setPSDevCenterId(pSDCMobPackCert.getPSDevCenterId());
            pSDevCenter.setMobCertChgTime(new Timestamp(System.currentTimeMillis()));
            pSDevCenterService.update(pSDevCenter, false);
        }
        super.onAfterCreate(pSDCMobPackCert);
    }

    @Override
    protected void onAfterUpdate(PSDCMobPackCert pSDCMobPackCert) throws Exception {
        PSDCMobPackCert pSDCMobPackCert2 = (PSDCMobPackCert)this.getLast(pSDCMobPackCert);
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = new PSDevCenter();
            pSDevCenter.setPSDevCenterId(pSDCMobPackCert2.getPSDevCenterId());
            pSDevCenter.setMobCertChgTime(new Timestamp(System.currentTimeMillis()));
            pSDevCenterService.update(pSDevCenter, false);
        }
        super.onAfterRemove(pSDCMobPackCert);
    }

    @Override
    protected void onAfterRemove(PSDCMobPackCert pSDCMobPackCert) throws Exception {
        PSDCMobPackCert pSDCMobPackCert2 = (PSDCMobPackCert)this.getLast(pSDCMobPackCert);
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = new PSDevCenter();
            pSDevCenter.setPSDevCenterId(pSDCMobPackCert2.getPSDevCenterId());
            pSDevCenter.setMobCertChgTime(new Timestamp(System.currentTimeMillis()));
            pSDevCenterService.update(pSDevCenter, false);
        }
        super.onAfterRemove(pSDCMobPackCert);
    }

    @Override
    protected boolean isPrepareLastForRemove() {
        return true;
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }
}

