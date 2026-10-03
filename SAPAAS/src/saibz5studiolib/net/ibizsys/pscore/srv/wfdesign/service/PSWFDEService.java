/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.wfdesign.service;

import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFDE;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflow;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFDEServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSWFDEService
extends PSWFDEServiceBase {
    private static final Log log = LogFactory.getLog(PSWFDEService.class);

    @Override
    protected void onBeforeCreate(PSWFDE pSWFDE) throws Exception {
        if (pSWFDE.getDefaultMode() == null) {
            if (!StringHelper.isNullOrEmpty((String)pSWFDE.getPSDEId())) {
                PSWFDE pSWFDE2 = new PSWFDE();
                pSWFDE2.setPSDEId(pSWFDE.getPSDEId());
                pSWFDE2.setDefaultMode(1);
                if (!this.existsData(pSWFDE2)) {
                    pSWFDE.setDefaultMode(1);
                }
            }
        } else if (DataObject.getBoolValue((Integer)pSWFDE.getDefaultMode(), (boolean)false) && !StringHelper.isNullOrEmpty((String)pSWFDE.getPSDEId())) {
            PSWFDE pSWFDE3 = new PSWFDE();
            pSWFDE3.setPSDEId(pSWFDE.getPSDEId());
            pSWFDE3.setDefaultMode(1);
            if (this.existsData(pSWFDE3)) {
                pSWFDE3.setDefaultMode(0);
                this.update(pSWFDE3, false);
            }
        }
        super.onBeforeCreate(pSWFDE);
    }

    @Override
    protected void onBeforeUpdate(PSWFDE pSWFDE) throws Exception {
        if (DataObject.getBoolValue((Integer)pSWFDE.getDefaultMode(), (boolean)false) && !StringHelper.isNullOrEmpty((String)pSWFDE.getPSDEId())) {
            PSWFDE pSWFDE2 = new PSWFDE();
            pSWFDE2.setPSDEId(pSWFDE.getPSDEId());
            pSWFDE2.setDefaultMode(1);
            if (this.existsData(pSWFDE2) && StringHelper.compare((String)pSWFDE2.getPSWFDEId(), (String)pSWFDE.getPSWFDEId(), (boolean)false) != 0) {
                pSWFDE2.setDefaultMode(0);
                this.update(pSWFDE2, false);
            }
        }
        super.onBeforeUpdate(pSWFDE);
    }

    @Override
    protected void onFillParentInfo_PSWF(PSWFDE pSWFDE, PSWorkflow pSWorkflow) throws Exception {
        super.onFillParentInfo_PSWF(pSWFDE, pSWorkflow);
        pSWFDE.setPSSystemId(pSWorkflow.getPSSystemId());
    }

    @Override
    protected void onFillParentInfo_PSDE(PSWFDE pSWFDE, PSDataEntity pSDataEntity) throws Exception {
        super.onFillParentInfo_PSDE(pSWFDE, pSDataEntity);
        pSWFDE.setPSSystemId(pSDataEntity.getPSSystemId());
    }

    @Override
    public void initDEWFViews(PSWFDE pSWFDE) throws Exception {
        this.get(pSWFDE);
        final PSWFDE pSWFDE2 = pSWFDE;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)PSWFDEService.this.getSessionFactory());
                pSDEViewBaseService.initWFDEViews(pSWFDE2, pSWFDE2.getPSDE());
            }
        });
    }

    @Override
    protected void onAfterCreate(PSWFDE pSWFDE) throws Exception {
        this.rebuildPSDEUIActions(pSWFDE);
        super.onAfterCreate(pSWFDE);
    }

    @Override
    protected void onAfterUpdate(PSWFDE pSWFDE) throws Exception {
        this.rebuildPSDEUIActions(pSWFDE);
        super.onAfterUpdate(pSWFDE);
    }

    public void rebuildPSDEUIActions(PSWFDE pSWFDE) throws Exception {
        PSDEUIAction action;
        String caption;
        boolean bl;
        String actionId;
        if (!pSWFDE.isWFProxyModeDirty() || !pSWFDE.isDefaultModeDirty()) {
            return;
        }
        if (!DataObject.getBoolValue((Integer)pSWFDE.getDefaultMode(), (boolean)false)) {
            return;
        }
        int n = DataObject.getIntegerValue((Object)pSWFDE.getWFProxyMode(), (Integer)0);
        if ((n & 1) != 1) {
            return;
        }
        if (pSWFDE.getPSDE() == null) {
            return;
        }
        PSDEUIActionService pSDEUIActionService = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
        boolean bl2 = true;
        SelectCond selectCond = new SelectCond();
        selectCond.set("PSDEID", (Object)pSWFDE.getPSDEId());
        selectCond.setIsNotNull("UATAG");
        ArrayList<PSDEUIAction> arrayList = pSDEUIActionService.select((ISelectCond)selectCond);
        HashMap<String, PSDEUIAction> hashMap = new HashMap<String, PSDEUIAction>();
        for (PSDEUIAction existingAction : arrayList) {
            if (!StringHelper.isNullOrEmpty((String)existingAction.getPSWFId()) || !StringHelper.isNullOrEmpty((String)existingAction.getPSWFVersionId()) || StringHelper.isNullOrEmpty((String)existingAction.getUATag()) || StringHelper.compare((String)"WFSTARTWIZARD", (String)existingAction.getUATag(), (boolean)false) != 0 && StringHelper.compare((String)"MOBWFSTARTWIZARD", (String)existingAction.getUATag(), (boolean)false) != 0) continue;
            hashMap.put(existingAction.getUATag(), existingAction);
        }
        arrayList.clear();
        arrayList.addAll(hashMap.values());
        PSDEUIAction saveAction = new PSDEUIAction();
        saveAction.setPSDEUIActionId(KeyValueHelper.genUniqueId((String)pSWFDE.getPSSystemId(), (String)"EDITVIEW_SAVEANDSTARTWFACTION"));
        if (!pSDEUIActionService.get(saveAction, true)) {
            saveAction = null;
        }
        if (!StringHelper.isNullOrEmpty((String)pSWFDE.getStartPSDEViewId())) {
            actionId = KeyValueHelper.genUniqueId((String)pSWFDE.getPSDEId(), (String)"WFSTARTWIZARD");
            bl = false;
            for (PSDEUIAction existingAction : arrayList) {
                if (StringHelper.compare((String)existingAction.getUATag(), (String)"WFSTARTWIZARD", (boolean)false) != 0) continue;
                actionId = existingAction.getPSDEUIActionId();
                bl = true;
                break;
            }
            action = new PSDEUIAction();
            action.setPSDEUIActionId(actionId);
            action.setPSDEId(pSWFDE.getPSDEId());
            action.setUATag("WFSTARTWIZARD");
            caption = "\u5f00\u59cb\u6d41\u7a0b";
            action.setCaption(caption);
            action.setPSDEUIActionName(caption);
            action.setCodeName("WFStartWizard");
            action.setActionTarget("SINGLEKEY");
            action.setUIActionType("WFFRONT");
            action.setPSDEViewBaseId(pSWFDE.getStartPSDEViewId());
            action.setPSDEViewBaseName(pSWFDE.getStartPSDEViewName());
            action.setFrontProType("WIZARD");
            if (saveAction != null) {
                action.setPSDEOPPrivId(saveAction.getPSDEOPPrivId());
                action.setPSDEOPPrivName(saveAction.getPSDEOPPrivName());
            }
            if (bl) {
                pSDEUIActionService.update(action);
            } else {
                if (StringHelper.compare(caption, "\u5f00\u59cb", true) == 0) {
                    caption = "\u5f00\u59cb\u6d41\u7a0b";
                }
                action.setCaption(caption);
                action.setPSDEUIActionName(caption);
                action.setTemplMode(0);
                action.setPSSystemId(pSWFDE.getPSSystemId());
                pSDEUIActionService.create(action);
            }
            hashMap.remove("WFSTARTWIZARD");
        }
        if (bl2 && !StringHelper.isNullOrEmpty((String)pSWFDE.getStartMobPSDEViewId())) {
            actionId = KeyValueHelper.genUniqueId((String)pSWFDE.getPSDEId(), (String)"MOBWFSTARTWIZARD");
            bl = false;
            for (PSDEUIAction existingAction : arrayList) {
                if (StringHelper.compare((String)existingAction.getUATag(), (String)"MOBWFSTARTWIZARD", (boolean)false) != 0) continue;
                actionId = existingAction.getPSDEUIActionId();
                bl = true;
                break;
            }
            action = new PSDEUIAction();
            action.setPSDEUIActionId(actionId);
            action.setPSDEId(pSWFDE.getPSDEId());
            action.setUATag("MOBWFSTARTWIZARD");
            caption = "\u5f00\u59cb\u6d41\u7a0b";
            action.setCaption(caption);
            action.setPSDEUIActionName(caption + "[\u79fb\u52a8\u7aef]");
            action.setCodeName("MobWFStartWizard");
            action.setActionTarget("SINGLEKEY");
            action.setUIActionType("WFFRONT");
            action.setPSDEViewBaseId(pSWFDE.getStartMobPSDEViewId());
            action.setPSDEViewBaseName(pSWFDE.getStartMobPSDEViewName());
            action.setFrontProType("WIZARD");
            if (saveAction != null) {
                action.setPSDEOPPrivId(saveAction.getPSDEOPPrivId());
                action.setPSDEOPPrivName(saveAction.getPSDEOPPrivName());
            }
            if (bl) {
                pSDEUIActionService.update(action);
            } else {
                if (StringHelper.compare(caption, "\u5f00\u59cb", true) == 0) {
                    caption = "\u5f00\u59cb\u6d41\u7a0b";
                }
                action.setCaption(caption);
                action.setPSDEUIActionName(caption);
                action.setTemplMode(0);
                action.setPSSystemId(pSWFDE.getPSSystemId());
                pSDEUIActionService.create(action);
            }
            hashMap.remove("MOBWFSTARTWIZARD");
        }
        for (PSDEUIAction pSDEUIAction : hashMap.values()) {
            pSDEUIActionService.remove(pSDEUIAction);
        }
    }
}
