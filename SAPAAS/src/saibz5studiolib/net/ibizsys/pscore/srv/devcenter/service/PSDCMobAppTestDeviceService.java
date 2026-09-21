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

import java.sql.Timestamp;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMobAppTestDevice;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMobAppTestDeviceServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDCMobAppTestDeviceService
extends PSDCMobAppTestDeviceServiceBase {
    private static final Log log = LogFactory.getLog(PSDCMobAppTestDeviceService.class);

    @Override
    protected void onAfterCreate(PSDCMobAppTestDevice pSDCMobAppTestDevice) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = new PSDevCenter();
            pSDevCenter.setPSDevCenterId(pSDCMobAppTestDevice.getPSDevCenterId());
            pSDevCenter.setMobTDChgTime(new Timestamp(System.currentTimeMillis()));
            pSDevCenterService.update(pSDevCenter, false);
        }
        super.onAfterCreate(pSDCMobAppTestDevice);
    }

    @Override
    protected void onAfterUpdate(PSDCMobAppTestDevice pSDCMobAppTestDevice) throws Exception {
        PSDCMobAppTestDevice pSDCMobAppTestDevice2 = (PSDCMobAppTestDevice)this.getLast((IEntity)pSDCMobAppTestDevice);
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = new PSDevCenter();
            pSDevCenter.setPSDevCenterId(pSDCMobAppTestDevice2.getPSDevCenterId());
            pSDevCenter.setMobTDChgTime(new Timestamp(System.currentTimeMillis()));
            pSDevCenterService.update(pSDevCenter, false);
        }
        super.onAfterRemove(pSDCMobAppTestDevice);
    }

    @Override
    protected void onAfterRemove(PSDCMobAppTestDevice pSDCMobAppTestDevice) throws Exception {
        PSDCMobAppTestDevice pSDCMobAppTestDevice2 = (PSDCMobAppTestDevice)this.getLast((IEntity)pSDCMobAppTestDevice);
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = new PSDevCenter();
            pSDevCenter.setPSDevCenterId(pSDCMobAppTestDevice2.getPSDevCenterId());
            pSDevCenter.setMobTDChgTime(new Timestamp(System.currentTimeMillis()));
            pSDevCenterService.update(pSDevCenter, false);
        }
        super.onAfterRemove(pSDCMobAppTestDevice);
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

