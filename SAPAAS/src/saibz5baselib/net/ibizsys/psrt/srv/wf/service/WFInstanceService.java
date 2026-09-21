/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.psrt.srv.wf.service;

import net.ibizsys.psrt.srv.wf.entity.WFInstance;
import net.ibizsys.psrt.srv.wf.service.WFInstanceServiceBase;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.IWFService;
import net.ibizsys.pswf.core.WFActionParam;
import net.ibizsys.pswf.core.WFModelGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class WFInstanceService
extends WFInstanceServiceBase {
    private static final Log log = LogFactory.getLog(WFInstanceService.class);

    @Override
    protected void onRestart(WFInstance wFInstance) throws Exception {
        if (!wFInstance.isFullEntity()) {
            this.get(wFInstance);
        }
        IWFModel iWFModel = WFModelGlobal.getWFModel(wFInstance.getWFWorkflowId());
        IWFService iWFService = iWFModel.getWFService();
        WFActionParam wfActionParam = new WFActionParam();
        wfActionParam.setUserData(wFInstance.getUserData());
        wfActionParam.setUserData4(wFInstance.getUserData4());
        wfActionParam.setOpPersonId(this.getWebContext().getCurUserId());
        iWFService.restart(wfActionParam);
    }

    @Override
    protected void onUserCancel(WFInstance wFInstance) throws Exception {
        if (!wFInstance.isFullEntity()) {
            this.get(wFInstance);
        }
        IWFModel iWFModel = WFModelGlobal.getWFModel(wFInstance.getWFWorkflowId());
        IWFService iWFService = iWFModel.getWFService();
        WFActionParam wfActionParam = new WFActionParam();
        wfActionParam.setUserData(wFInstance.getUserData());
        wfActionParam.setUserData4(wFInstance.getUserData4());
        wfActionParam.setOpPersonId(this.getWebContext().getCurUserId());
        iWFService.close(wfActionParam);
    }
}

