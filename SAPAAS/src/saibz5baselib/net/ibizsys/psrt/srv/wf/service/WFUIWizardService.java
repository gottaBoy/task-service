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
import net.ibizsys.psrt.srv.wf.entity.WFUIWizard;
import net.ibizsys.psrt.srv.wf.service.WFInstanceService;
import net.ibizsys.psrt.srv.wf.service.WFUIWizardServiceBase;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.IWFService;
import net.ibizsys.pswf.core.WFActionParam;
import net.ibizsys.pswf.core.WFModelGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class WFUIWizardService
extends WFUIWizardServiceBase {
    public static String ACTIONMODE_GOTOSTEP = "GOTOSTEP";
    private static final Log log = LogFactory.getLog(WFUIWizardService.class);

    @Override
    public void getDraft(WFUIWizard et) throws Exception {
        if (StringHelper.compare(et.getActionMode(), ACTIONMODE_GOTOSTEP, true) == 0) {
            String strActoinParams = et.getActionParam();
            String[] keys = strActoinParams.split("[;]");
            String strActionData = "";
            WFInstanceService wfInstanceService = (WFInstanceService)ServiceGlobal.getService(WFInstanceService.class, this.getSessionFactory());
            String[] stringArray = keys;
            int n = keys.length;
            int n2 = 0;
            while (n2 < n) {
                String strKey = stringArray[n2];
                WFInstance wfInstance = new WFInstance();
                wfInstance.setWFInstanceId(strKey);
                wfInstanceService.get(wfInstance);
                if (!StringHelper.isNullOrEmpty(strActionData)) {
                    strActionData = String.valueOf(strActionData) + ";";
                }
                strActionData = String.valueOf(strActionData) + wfInstance.getWFInstanceName();
                ++n2;
            }
            et.setDataInfo(strActionData);
        }
    }

    @Override
    protected void onAfterCreate(WFUIWizard et) throws Exception {
        if (StringHelper.compare(et.getActionMode(), ACTIONMODE_GOTOSTEP, true) == 0) {
            String strActorId = this.getWebContext().getCurUserId();
            String strActoinParams = et.getActionParam();
            String[] keys = strActoinParams.split("[;]");
            WFInstanceService wfInstanceService = (WFInstanceService)ServiceGlobal.getService(WFInstanceService.class, this.getSessionFactory());
            String[] stringArray = keys;
            int n = keys.length;
            int n2 = 0;
            while (n2 < n) {
                String strKey = stringArray[n2];
                WFInstance wfInstance = new WFInstance();
                wfInstance.setWFInstanceId(strKey);
                wfInstanceService.get(wfInstance);
                IWFModel iWFModel = WFModelGlobal.getWFModel(wfInstance.getWFWorkflowId());
                IWFService iWFService = iWFModel.getWFService();
                WFActionParam wfActionParam = new WFActionParam();
                wfActionParam.setUserData(wfInstance.getUserData());
                wfActionParam.setUserData4(wfInstance.getUserData4());
                wfActionParam.setOpPersonId(this.getWebContext().getCurUserId());
                wfActionParam.setConnection("SRFWFIAGOTO");
                wfActionParam.setStepId(et.getWFStepValue());
                iWFService.timeoutIAAction(wfActionParam);
                ++n2;
            }
        }
        super.onAfterCreate(et);
    }
}

