/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.devcenter.service;

import java.util.ArrayList;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDBInstRef;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterAS;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst;
import net.ibizsys.pscore.srv.devcenter.service.PSDCDBInstRefService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterASService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstServiceBase;
import net.ibizsys.pscore.srv.util.IPSDCDBInstOwnerListener;
import net.ibizsys.pscore.srv.util.PSDevCenterHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDevCenterDBInstService
extends PSDevCenterDBInstServiceBase {
    private static final Log log = LogFactory.getLog(PSDevCenterDBInstService.class);

    public void calcRefInfo(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        final PSDevCenterDBInst pSDevCenterDBInst2 = pSDevCenterDBInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevCenterDBInstService.this.onCalcRefInfo(pSDevCenterDBInst2);
            }
        });
    }

    protected void onCalcRefInfo(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        String string = pSDevCenterDBInst.getPSDevCenterDBInstId();
        pSDevCenterDBInst.reset();
        pSDevCenterDBInst.setPSDevCenterDBInstId(string);
        PSDCDBInstRefService pSDCDBInstRefService = (PSDCDBInstRefService)ServiceGlobal.getService(PSDCDBInstRefService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDCDBInstRef> arrayList = pSDCDBInstRefService.selectByPSDevCenterDBInst(pSDevCenterDBInst);
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        for (PSDCDBInstRef pSDCDBInstRef : arrayList) {
            IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel((String)pSDCDBInstRef.getRefObjType());
            stringBuilderEx.append("[%1$s]%2$s\r\n", (Object)iDataEntityModel.getLogicName(), (Object)pSDCDBInstRef.getPSDCDBInstRefName());
        }
        pSDevCenterDBInst.setRefCount(arrayList.size());
        pSDevCenterDBInst.setRefInfo(stringBuilderEx.toString());
        this.update(pSDevCenterDBInst, false);
    }

    @Override
    protected void onBeforeCreate(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        if (this.isMajorSessionFactory()) {
            PSDevCenterHelper.testCreate(pSDevCenterDBInst.getPSDevCenter(), "DBINSTCNT", false);
        }
        super.onBeforeCreate(pSDevCenterDBInst);
    }

    @Override
    protected void onAfterCreate(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            if (!StringHelper.isNullOrEmpty((String)pSDevCenterDBInst.getPSDevCenterASId())) {
                PSDevCenterASService pSDevCenterASService = (PSDevCenterASService)ServiceGlobal.getService(PSDevCenterASService.class, (SessionFactory)this.getSessionFactory());
                PSDevCenterAS pSDevCenterAS = new PSDevCenterAS();
                pSDevCenterAS.setPSDevCenterASId(pSDevCenterDBInst.getPSDevCenterASId());
                pSDevCenterASService.calcPSDCDBListInfo(pSDevCenterAS);
            }
            PSDevCenterHelper.updatetPSDCResRep(pSDevCenterDBInst.getPSDevCenter(), "DBINSTCNT");
        }
        super.onAfterCreate(pSDevCenterDBInst);
    }

    @Override
    protected void onAfterUpdate(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory()) && (pSDevCenterDBInst.isResStateDirty() || pSDevCenterDBInst.isExpriedTimeDirty() || pSDevCenterDBInst.isResReadyTimeDirty())) {
            PSDevCenterDBInst pSDevCenterDBInst2 = (PSDevCenterDBInst)this.getLast(pSDevCenterDBInst);
            if ((pSDevCenterDBInst.isResStateDirty() && DataTypeHelper.compare((int)9, (Object)pSDevCenterDBInst.getResState(), (Object)pSDevCenterDBInst2.getResState()) != 0L || pSDevCenterDBInst.isExpriedTimeDirty() && DataTypeHelper.compare((int)5, (Object)pSDevCenterDBInst.getExpriedTime(), (Object)pSDevCenterDBInst2.getExpriedTime()) != 0L || pSDevCenterDBInst.isResReadyTimeDirty() && DataTypeHelper.compare((int)5, (Object)pSDevCenterDBInst.getResReadyTime(), (Object)pSDevCenterDBInst2.getResReadyTime()) != 0L) && DataObject.getIntegerValue((Object)pSDevCenterDBInst2.getRefCount(), (Integer)0) > 0) {
                PSDCDBInstRefService pSDCDBInstRefService = (PSDCDBInstRefService)ServiceGlobal.getService(PSDCDBInstRefService.class, (SessionFactory)this.getSessionFactory());
                ArrayList<PSDCDBInstRef> arrayList = pSDCDBInstRefService.selectByPSDevCenterDBInst(pSDevCenterDBInst);
                for (PSDCDBInstRef pSDCDBInstRef : arrayList) {
                    IService iService = DEModelGlobal.getDEModel((String)pSDCDBInstRef.getRefObjType()).getService(this.getSessionFactory());
                    if (iService instanceof IPSDCDBInstOwnerListener) {
                        ((IPSDCDBInstOwnerListener)iService).onPSDCDBInstChanged(pSDCDBInstRef, pSDevCenterDBInst, pSDevCenterDBInst2);
                        continue;
                    }
                    log.warn((Object)StringHelper.format((String)"\u8d44\u6e90\u5f15\u7528\u7c7b\u578b[%1$s]\u6ca1\u6709\u5b9a\u4e49\u8d44\u6e90\u53d8\u5316\u4fa6\u542c\u63a5\u53e3", (Object)pSDCDBInstRef.getRefObjType()));
                }
            }
        }
        super.onAfterUpdate(pSDevCenterDBInst);
    }

    @Override
    protected void onAfterRemove(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            PSDevCenterDBInst pSDevCenterDBInst2 = (PSDevCenterDBInst)this.getLast(pSDevCenterDBInst);
            if (!StringHelper.isNullOrEmpty((String)pSDevCenterDBInst2.getPSDevCenterASId())) {
                PSDevCenterASService pSDevCenterASService = (PSDevCenterASService)ServiceGlobal.getService(PSDevCenterASService.class, (SessionFactory)this.getSessionFactory());
                PSDevCenterAS pSDevCenterAS = new PSDevCenterAS();
                pSDevCenterAS.setPSDevCenterASId(pSDevCenterDBInst2.getPSDevCenterASId());
                pSDevCenterASService.calcPSDCDBListInfo(pSDevCenterAS);
            }
            PSDevCenterHelper.updatetPSDCResRep(pSDevCenterDBInst2.getPSDevCenter(), "DBINSTCNT");
        }
        super.onAfterRemove(pSDevCenterDBInst);
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

