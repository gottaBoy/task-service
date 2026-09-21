/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.psrt.srv.wf.service;

import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.wf.entity.WFInstance;
import net.ibizsys.psrt.srv.wf.entity.WFStepData;
import net.ibizsys.psrt.srv.wf.service.WFInstanceService;
import net.ibizsys.psrt.srv.wf.service.WFStepDataServiceBase;
import net.ibizsys.pswf.core.IWFService;
import net.ibizsys.pswf.core.WFActionParam;
import net.ibizsys.pswf.core.WFModelGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class WFStepDataService
extends WFStepDataServiceBase {
    private static final Log log = LogFactory.getLog(WFStepDataService.class);

    @Override
    protected void onRollback(WFStepData wFStepData) throws Exception {
        if (StringHelper.isNullOrEmpty(wFStepData.getWFInstanceId())) {
            this.get(wFStepData);
        }
        WFInstanceService wfInstanceService = (WFInstanceService)ServiceGlobal.getService(WFInstanceService.class, this.getSessionFactory());
        WFInstance wfInstance = new WFInstance();
        wfInstance.setWFInstanceId(wFStepData.getWFInstanceId());
        wfInstanceService.get(wfInstance);
        IWFService iWFService = WFModelGlobal.getWFModel(wfInstance.getWFWorkflowId()).getWFService();
        WFActionParam wfActionParam = new WFActionParam();
        wfActionParam.setInstanceId(wfInstance.getWFInstanceId());
        wfActionParam.setUserData(wfInstance.getUserData());
        wfActionParam.setUserData4(wfInstance.getUserData4());
        wfActionParam.setOpPersonId(this.getWebContext().getCurUserId());
        iWFService.rollbackIAAction(wfActionParam);
    }
}

