/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
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
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroupBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIActionBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaWF;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaWFService;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflow;
import net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSWorkflowService
extends PSWorkflowServiceBase {
    private static final Log log = LogFactory.getLog(PSWorkflowService.class);

    @Override
    protected void onBeforeCreate(PSWorkflow pSWorkflow) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSWorkflow.getCodeName())) {
            PSWorkflow pSWorkflow2;
            String string = "Workflow";
            int n = 1;
            do {
                if (n > 1) {
                    string = StringHelper.format((String)"Workflow%1$s", (Object)n);
                }
                ++n;
                pSWorkflow2 = new PSWorkflow();
                pSWorkflow2.setSessionFactory(this.getSessionFactory());
                pSWorkflow2.setPSSystemId(pSWorkflow.getPSSystemId());
                pSWorkflow2.setCodeName(string);
            } while (pSWorkflow2.select(true));
            pSWorkflow.setCodeName(string);
        }
        super.onBeforeCreate(pSWorkflow);
    }

    @Override
    protected void onAfterCreate(PSWorkflow pSWorkflow) throws Exception {
        this.initPSDynaWF(pSWorkflow);
        this.rebuildPSDEUIActions(pSWorkflow);
        super.onAfterCreate(pSWorkflow);
    }

    @Override
    protected void onAfterUpdate(PSWorkflow pSWorkflow) throws Exception {
        this.initPSDynaWF(pSWorkflow);
        this.rebuildPSDEUIActions(pSWorkflow);
        super.onAfterUpdate(pSWorkflow);
    }

    protected void initPSDynaWF(PSWorkflow pSWorkflow) throws Exception {
        if (PSWorkflowService.isImpSysModelNowEx()) {
            return;
        }
        if (!pSWorkflow.isEnableDynaSysDirty()) {
            return;
        }
        if (!DataObject.getBoolValue((Integer)pSWorkflow.getEnableDynaSys(), (boolean)false)) {
            return;
        }
        if (pSWorkflow.getPSSystem() == null) {
            return;
        }
        if (DataObject.getIntegerValue((Object)pSWorkflow.getPSSystem().getEnableDynaSys(), (Integer)0) == 0) {
            throw new Exception(StringHelper.format((String)"\u5f53\u524d\u7cfb\u7edf\u6ca1\u6709\u542f\u7528\u52a8\u6001\u7cfb\u7edf\u529f\u80fd\uff0c\u4e0d\u80fd\u542f\u7528\u5de5\u4f5c\u6d41\u7684\u52a8\u6001\u529f\u80fd"));
        }
        PSDynaWFService pSDynaWFService = (PSDynaWFService)ServiceGlobal.getService(PSDynaWFService.class, (SessionFactory)this.getSessionFactory());
        PSDynaWF pSDynaWF = new PSDynaWF();
        pSDynaWF.setPSDynaWFId(pSWorkflow.getPSWorkflowId());
        if (pSWorkflow.isPSWorkflowNameDirty()) {
            pSDynaWF.setPSDynaWFName(pSWorkflow.getPSWorkflowName());
        }
        pSDynaWF.setPSDynaSysId(pSWorkflow.getPSSystem().getPSSystemId());
        pSDynaWF.setPSDynaSysName(pSWorkflow.getPSSystem().getPSSystemName());
        pSDynaWFService.save((IEntity)pSDynaWF);
    }

    @Override
    protected void onTestEmbededEngine(PSWorkflow pSWorkflow) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSWorkflow.getWFEngineType()) || StringHelper.compare((String)pSWorkflow.getWFEngineType(), (String)"EMBEDDED", (boolean)true) == 0) {
            pSWorkflow.set("SRFRET", 1);
            return;
        }
        pSWorkflow.set("SRFRET", 0);
    }

    @Override
    protected void onTestActivityEngine(PSWorkflow pSWorkflow) throws Exception {
        if (StringHelper.compare((String)pSWorkflow.getWFEngineType(), (String)"ACTIVITI", (boolean)true) == 0) {
            pSWorkflow.set("SRFRET", 1);
            return;
        }
        pSWorkflow.set("SRFRET", 0);
    }

    public void rebuildPSDEUIActions(PSWorkflow pSWorkflow) throws Exception {
        Object object;
        Object object22;
        boolean bl;
        Object object3;
        Object object42;
        if (!pSWorkflow.isWFProxyModeDirty()) {
            return;
        }
        int n = DataObject.getIntegerValue((Object)pSWorkflow.getWFProxyMode(), (Integer)0);
        if (n != 1) {
            return;
        }
        PSDEUIActionService pSDEUIActionService = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
        PSDEUAGroupService pSDEUAGroupService = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)this.getSessionFactory());
        boolean bl2 = DataObject.getBoolValue((Integer)pSWorkflow.getEnableMob(), (boolean)false);
        SelectCond selectCond = new SelectCond();
        selectCond.set("PSWFID", (Object)pSWorkflow.getPSWorkflowId());
        selectCond.setIsNull("PSWFVERSIONID");
        ArrayList arrayList = pSDEUAGroupService.select((ISelectCond)selectCond);
        ArrayList arrayList2 = pSDEUIActionService.select((ISelectCond)selectCond);
        HashMap<String, EntityBase> hashMap = new HashMap<String, EntityBase>();
        HashMap<String, Object> hashMap2 = new HashMap<String, Object>();
        for (Object object42 : arrayList) {
            if (!StringHelper.isNullOrEmpty((String)((PSDEUAGroupBase)object42).getPSWFVersionId())) continue;
            hashMap.put(((PSDEUAGroupBase)object42).getPSDEUAGroupId(), (EntityBase)object42);
        }
        for (Object object42 : arrayList2) {
            if (!StringHelper.isNullOrEmpty((String)((PSDEUIActionBase)object42).getPSWFVersionId())) continue;
            hashMap2.put(((PSDEUIActionBase)object42).getPSDEUIActionId(), object42);
        }
        Object object5 = new PSDEUIAction();
        object42 = KeyValueHelper.genUniqueId((String)pSWorkflow.getPSSystemId(), (String)"EDITVIEW_SAVEANDSTARTWFACTION");
        ((PSDEUIActionBase)object5).setPSDEUIActionId((String)object42);
        if (!pSDEUIActionService.get((IEntity)object5, true)) {
            object5 = null;
        }
        if (!StringHelper.isNullOrEmpty((String)pSWorkflow.getStartPSDEViewId())) {
            object3 = KeyValueHelper.genUniqueId((String)pSWorkflow.getPSWorkflowId(), (String)"WFSTARTWIZARD");
            bl = false;
            if (hashMap2.containsKey(object3)) {
                bl = true;
            } else {
                for (Object object22 : arrayList2) {
                    if (StringHelper.compare((String)((PSDEUIActionBase)object22).getUATag(), (String)"WFSTARTWIZARD", (boolean)false) != 0) continue;
                    object3 = ((PSDEUIActionBase)object22).getPSDEUIActionId();
                    bl = true;
                    break;
                }
            }
            object = new PSDEUIAction();
            ((PSDEUIActionBase)object).setPSDEUIActionId((String)object3);
            ((PSDEUIActionBase)object).setPSWFId(pSWorkflow.getPSWorkflowId());
            ((PSDEUIActionBase)object).setUATag("WFSTARTWIZARD");
            object22 = "\u5f00\u59cb\u6d41\u7a0b";
            ((PSDEUIActionBase)object).setCaption((String)object22);
            ((PSDEUIActionBase)object).setPSDEUIActionName((String)object22);
            ((PSDEUIActionBase)object).setCodeName("WFStartWizard");
            ((PSDEUIActionBase)object).setActionTarget("SINGLEKEY");
            ((PSDEUIActionBase)object).setUIActionType("WFFRONT");
            ((PSDEUIActionBase)object).setPSDEViewBaseId(pSWorkflow.getStartPSDEViewId());
            ((PSDEUIActionBase)object).setPSDEViewBaseName(pSWorkflow.getStartPSDEViewName());
            ((PSDEUIActionBase)object).setFrontProType("WIZARD");
            if (object5 != null) {
                ((PSDEUIActionBase)object).setPSDEOPPrivId(((PSDEUIActionBase)object5).getPSDEOPPrivId());
                ((PSDEUIActionBase)object).setPSDEOPPrivName(((PSDEUIActionBase)object5).getPSDEOPPrivName());
            }
            if (bl) {
                pSDEUIActionService.update(object);
            } else {
                if (StringHelper.compare((String)object22, (String)"\u5f00\u59cb", (boolean)true) == 0) {
                    object22 = "\u5f00\u59cb\u6d41\u7a0b";
                }
                ((PSDEUIActionBase)object).setCaption((String)object22);
                ((PSDEUIActionBase)object).setPSDEUIActionName((String)object22);
                ((PSDEUIActionBase)object).setTemplMode(0);
                ((PSDEUIActionBase)object).setPSSystemId(pSWorkflow.getPSSystemId());
                pSDEUIActionService.create(object);
            }
            hashMap2.remove(object3);
        }
        if (bl2 && !StringHelper.isNullOrEmpty((String)pSWorkflow.getStartMobPSDEViewId())) {
            object3 = KeyValueHelper.genUniqueId((String)pSWorkflow.getPSWorkflowId(), (String)"MOBWFSTARTWIZARD");
            bl = false;
            if (hashMap2.containsKey(object3)) {
                bl = true;
            } else {
                for (Object object22 : arrayList2) {
                    if (StringHelper.compare((String)((PSDEUIActionBase)object22).getUATag(), (String)"MOBWFSTARTWIZARD", (boolean)false) != 0) continue;
                    object3 = ((PSDEUIActionBase)object22).getPSDEUIActionId();
                    bl = true;
                    break;
                }
            }
            object = new PSDEUIAction();
            ((PSDEUIActionBase)object).setPSDEUIActionId((String)object3);
            ((PSDEUIActionBase)object).setPSWFId(pSWorkflow.getPSWorkflowId());
            ((PSDEUIActionBase)object).setUATag("MOBWFSTARTWIZARD");
            object22 = "\u5f00\u59cb\u6d41\u7a0b";
            ((PSDEUIActionBase)object).setCaption((String)object22);
            ((PSDEUIActionBase)object).setPSDEUIActionName((String)object22 + "[\u79fb\u52a8\u7aef]");
            ((PSDEUIActionBase)object).setCodeName("WFStartWizard");
            ((PSDEUIActionBase)object).setActionTarget("SINGLEKEY");
            ((PSDEUIActionBase)object).setUIActionType("WFFRONT");
            ((PSDEUIActionBase)object).setPSDEViewBaseId(pSWorkflow.getStartMobPSDEViewId());
            ((PSDEUIActionBase)object).setPSDEViewBaseName(pSWorkflow.getStartMobPSDEViewName());
            ((PSDEUIActionBase)object).setFrontProType("WIZARD");
            if (object5 != null) {
                ((PSDEUIActionBase)object).setPSDEOPPrivId(((PSDEUIActionBase)object5).getPSDEOPPrivId());
                ((PSDEUIActionBase)object).setPSDEOPPrivName(((PSDEUIActionBase)object5).getPSDEOPPrivName());
            }
            if (bl) {
                pSDEUIActionService.update(object);
            } else {
                if (StringHelper.compare((String)object22, (String)"\u5f00\u59cb", (boolean)true) == 0) {
                    object22 = "\u5f00\u59cb\u6d41\u7a0b";
                }
                ((PSDEUIActionBase)object).setCaption((String)object22);
                ((PSDEUIActionBase)object).setPSDEUIActionName((String)object22);
                ((PSDEUIActionBase)object).setTemplMode(0);
                ((PSDEUIActionBase)object).setPSSystemId(pSWorkflow.getPSSystemId());
                pSDEUIActionService.create(object);
            }
            hashMap2.remove(object3);
        }
        for (PSDEUAGroup pSDEUAGroup : hashMap.values()) {
            pSDEUAGroupService.remove((IEntity)pSDEUAGroup);
        }
        for (PSDEUIAction pSDEUIAction : hashMap2.values()) {
            pSDEUIActionService.remove((IEntity)pSDEUIAction);
        }
    }
}

