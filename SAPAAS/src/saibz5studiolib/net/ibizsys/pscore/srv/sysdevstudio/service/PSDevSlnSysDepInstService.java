/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdevstudio.service;

import java.io.File;
import java.util.Random;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysDepInst;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysDepInstServiceBase;
import net.ibizsys.pscore.srv.util.PSDevCenterSVNHelper;
import net.ibizsys.pscore.srv.util.PSStudioEnvHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDevSlnSysDepInstService
extends PSDevSlnSysDepInstServiceBase {
    private static final Log log = LogFactory.getLog(PSDevSlnSysDepInstService.class);
    private static Random random = new Random();

    @Override
    protected void onBeforeCreate(PSDevSlnSysDepInst pSDevSlnSysDepInst) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            if (pSDevSlnSysDepInst.getDepInstState() == null) {
                pSDevSlnSysDepInst.setDepInstState(10);
            }
            if (pSDevSlnSysDepInst.getPSDevSlnSys() != null) {
                pSDevSlnSysDepInst.setPSDevCenterId(pSDevSlnSysDepInst.getPSDevSlnSys().getPSDevCenterId());
                pSDevSlnSysDepInst.setPSDevCenterName(pSDevSlnSysDepInst.getPSDevSlnSys().getPSDevCenterName());
                pSDevSlnSysDepInst.setPSSysModelInstId(pSDevSlnSysDepInst.getPSDevSlnSys().getPSSysModelInstId());
                pSDevSlnSysDepInst.setPSSysModelInstName(pSDevSlnSysDepInst.getPSDevSlnSys().getPSSysModelInstName());
                pSDevSlnSysDepInst.setModelPSDevCenterSVNId(pSDevSlnSysDepInst.getPSDevSlnSys().getModelPSDevCenterSVNId());
                pSDevSlnSysDepInst.setModelPSDevCenterSVNName(pSDevSlnSysDepInst.getPSDevSlnSys().getModelPSDevCenterSVNName());
            }
        }
        super.onBeforeCreate(pSDevSlnSysDepInst);
    }

    @Override
    protected void onAfterCreate(PSDevSlnSysDepInst pSDevSlnSysDepInst) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            // empty if block
        }
        super.onAfterCreate(pSDevSlnSysDepInst);
    }

    @Override
    protected void onCheckOutModel(PSDevSlnSysDepInst pSDevSlnSysDepInst) throws Exception {
        PSDevCenterSVN pSDevCenterSVN;
        if (!pSDevSlnSysDepInst.isFullEntity()) {
            this.get(pSDevSlnSysDepInst);
        }
        if ((pSDevCenterSVN = pSDevSlnSysDepInst.getModelPSDevCenterSVN()) == null && pSDevSlnSysDepInst.getPSDevSlnSys() != null) {
            pSDevCenterSVN = pSDevSlnSysDepInst.getPSDevSlnSys().getModelPSDevCenterSVN();
        }
        if (pSDevCenterSVN == null) {
            throw new Exception("\u90e8\u7f72\u5b9e\u4f8b\u6a21\u578b\u4ed3\u5e93\u65e0\u6548");
        }
        String string = String.format("%1$s%2$s%3$s%2$sMODEL", PSStudioEnvHelper.getCurrent().getDepInstFolder(), File.separator, pSDevSlnSysDepInst.getPSDevSlnSysDepInstId());
        PSDevCenterSVNHelper.getInstance().checkOut(pSDevCenterSVN, string);
    }

    @Override
    protected void onCheckInModel(PSDevSlnSysDepInst pSDevSlnSysDepInst) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }
}

