/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.appdesign.service;

import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSMobAppPackTD;
import net.ibizsys.pscore.srv.appdesign.service.PSMobAppPackTDServiceBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMobAppTDRef;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMobAppTDRefService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSMobAppPackTDService
extends PSMobAppPackTDServiceBase {
    private static final Log log = LogFactory.getLog(PSMobAppPackTDService.class);

    @Override
    protected void onBeforeCreate(PSMobAppPackTD pSMobAppPackTD) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSMobAppPackTD.getPSMobAppPackTDName())) {
            pSMobAppPackTD.setPSMobAppPackTDName(pSMobAppPackTD.getPSDCMobAppTestDeviceName());
        }
        super.onBeforeCreate(pSMobAppPackTD);
    }

    @Override
    protected void onAfterCreate(PSMobAppPackTD pSMobAppPackTD) throws Exception {
        PSDCMobAppTDRefService pSDCMobAppTDRefService = (PSDCMobAppTDRefService)ServiceGlobal.getService(PSDCMobAppTDRefService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDCMobAppTDRef pSDCMobAppTDRef = new PSDCMobAppTDRef();
        pSDCMobAppTDRef.setPSDCMobAppTestDeviceId(pSMobAppPackTD.getPSDCMobAppTestDeviceId());
        pSDCMobAppTDRef.setPSDCMobAppTestDeviceName(pSMobAppPackTD.getPSDCMobAppTestDeviceName());
        pSDCMobAppTDRef.setRefPSObjType("PSMOBAPPPACK");
        pSDCMobAppTDRef.setRefPSObjId(pSMobAppPackTD.getPSMobAppPackId());
        pSDCMobAppTDRef.setRefPSObjName(pSMobAppPackTD.getPSMobAppPackName());
        IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel((String)"PSMOBAPPPACK");
        pSDCMobAppTDRef.setPSDCMobAppTDRefName(StringHelper.format((String)"[%1$s]%2$s", (Object)iDataEntityModel.getLogicName(), (Object)pSMobAppPackTD.getPSMobAppPackName()));
        pSDCMobAppTDRefService.create(pSDCMobAppTDRef, false);
        super.onAfterCreate(pSMobAppPackTD);
    }

    @Override
    protected void onAfterRemove(PSMobAppPackTD pSMobAppPackTD) throws Exception {
        PSMobAppPackTD pSMobAppPackTD2 = (PSMobAppPackTD)this.getLast((IEntity)pSMobAppPackTD);
        PSDCMobAppTDRefService pSDCMobAppTDRefService = (PSDCMobAppTDRefService)ServiceGlobal.getService(PSDCMobAppTDRefService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDCMobAppTDRef pSDCMobAppTDRef = new PSDCMobAppTDRef();
        pSDCMobAppTDRef.setPSDCMobAppTestDeviceId(pSMobAppPackTD2.getPSDCMobAppTestDeviceId());
        pSDCMobAppTDRef.setRefPSObjType("PSMOBAPPPACK");
        pSDCMobAppTDRef.setRefPSObjId(pSMobAppPackTD2.getPSMobAppPackId());
        pSDCMobAppTDRef.setRefPSObjName(pSMobAppPackTD2.getPSMobAppPackName());
        pSDCMobAppTDRefService.fillEntityKeyValue((IEntity)pSDCMobAppTDRef);
        pSDCMobAppTDRefService.remove((IEntity)pSDCMobAppTDRef);
        super.onAfterRemove(pSMobAppPackTD);
    }

    @Override
    protected void onBeforeUpdate(PSMobAppPackTD pSMobAppPackTD) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSMobAppPackTD.getPSMobAppPackTDName())) {
            pSMobAppPackTD.setPSMobAppPackTDName(pSMobAppPackTD.getPSDCMobAppTestDeviceName());
        }
        super.onBeforeUpdate(pSMobAppPackTD);
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

