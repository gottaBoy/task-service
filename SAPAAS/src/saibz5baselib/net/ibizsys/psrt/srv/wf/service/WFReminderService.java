/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.psrt.srv.wf.service;

import java.util.ArrayList;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psmsg.util.MsgTemplateHelper;
import net.ibizsys.psrt.srv.codelist.MsgTypeCodeListModel;
import net.ibizsys.psrt.srv.common.entity.MsgAccount;
import net.ibizsys.psrt.srv.common.entity.MsgSendQueue;
import net.ibizsys.psrt.srv.common.entity.MsgTemplate;
import net.ibizsys.psrt.srv.common.service.MsgAccountService;
import net.ibizsys.psrt.srv.common.service.MsgSendQueueService;
import net.ibizsys.psrt.srv.common.service.MsgTemplateService;
import net.ibizsys.psrt.srv.wf.entity.WFInstance;
import net.ibizsys.psrt.srv.wf.entity.WFReminder;
import net.ibizsys.psrt.srv.wf.entity.WFWorkflow;
import net.ibizsys.psrt.srv.wf.service.WFInstanceService;
import net.ibizsys.psrt.srv.wf.service.WFReminderServiceBase;
import net.ibizsys.psrt.srv.wf.service.WFWorkflowService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class WFReminderService
extends WFReminderServiceBase {
    private static final Log log = LogFactory.getLog(WFReminderService.class);

    @Override
    protected void onAfterCreate(WFReminder et) throws Exception {
        this.sendInform(et);
        super.onAfterCreate(et);
    }

    protected void sendInform(WFReminder et) throws Exception {
        String strWFInstanceId = "";
        if (et.getWFStepActor() != null) {
            strWFInstanceId = et.getWFStepActor().getWFInstanceId();
        }
        if (StringHelper.isNullOrEmpty(strWFInstanceId)) {
            return;
        }
        WFInstance wfInstance = new WFInstance();
        WFInstanceService wfInstanceService = (WFInstanceService)ServiceGlobal.getService(WFInstanceService.class, this.getSessionFactory());
        wfInstance.setWFInstanceId(strWFInstanceId);
        wfInstanceService.get(wfInstance);
        WFWorkflowService wfWorkflowService = (WFWorkflowService)ServiceGlobal.getService(WFWorkflowService.class, this.getSessionFactory());
        WFWorkflow wfWorkflow = new WFWorkflow();
        wfWorkflow.setWFWorkflowId(wfInstance.getWFWorkflowId());
        wfWorkflowService.get(wfWorkflow);
        if (StringHelper.isNullOrEmpty(wfWorkflow.getRemindMsgTemplId())) {
            return;
        }
        MsgTemplateService msgTemplateService = (MsgTemplateService)ServiceGlobal.getService(MsgTemplateService.class, this.getSessionFactory());
        MsgAccountService msgAccountService = (MsgAccountService)ServiceGlobal.getService(MsgAccountService.class, this.getSessionFactory());
        MsgSendQueueService msgSendQueueService = (MsgSendQueueService)ServiceGlobal.getService(MsgSendQueueService.class, this.getSessionFactory());
        MsgTemplate msgTemplate = new MsgTemplate();
        msgTemplate.setMsgTemplateId(wfWorkflow.getRemindMsgTemplId());
        if (!msgTemplateService.get(msgTemplate, true)) {
            throw new Exception(StringHelper.format("\u83b7\u53d6\u6307\u5b9a\u6d88\u606f\u6a21\u677f[%1$s]\u5931\u8d25", wfWorkflow.getRemindMsgTemplId()));
        }
        boolean bMailGroupSend = DataObject.getBoolValue(msgTemplate.getMailGroupSend(), false);
        String strMailAddress = "";
        ArrayList<MsgSendQueue> msqs = new ArrayList<MsgSendQueue>();
        MsgAccount msgAccount = new MsgAccount();
        String strActorId = et.getWFStepActor().getActorId();
        msgAccount.setMsgAccountId(strActorId);
        if (!msgAccountService.get(msgAccount, true)) {
            throw new Exception(StringHelper.format("\u83b7\u53d6\u6d88\u606f\u8d26\u6237[%1$s]\u5931\u8d25", strActorId));
        }
        MsgSendQueue msq2 = MsgTemplateHelper.getMsgSendQueue(MsgTypeCodeListModel.EMAIL, msgTemplate, et, null, msgAccount, "SYSTEM");
        msq2.setDstAddresses(msgAccount.getMailAddress());
        msqs.add(msq2);
        msq2 = MsgTemplateHelper.getMsgSendQueue(MsgTypeCodeListModel.SMS, msgTemplate, et, null, msgAccount, "SYSTEM");
        msq2.setDstAddresses(msgAccount.getMobile());
        msqs.add(msq2);
        for (MsgSendQueue msq2 : msqs) {
            try {
                msgSendQueueService.create(msq2, false);
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.format("\u4fdd\u5b58\u6d88\u606f\u5f02\u6b65\u961f\u5217\u6570\u636e\u5931\u8d25\uff0c%1$s", ex.getMessage()));
            }
        }
    }
}

