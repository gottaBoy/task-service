/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.psrt.srv.wf.service;

import java.sql.Timestamp;
import java.util.Date;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.wf.entity.WFReminder;
import net.ibizsys.psrt.srv.wf.entity.WFStepActor;
import net.ibizsys.psrt.srv.wf.entity.WFUser;
import net.ibizsys.psrt.srv.wf.service.WFReminderService;
import net.ibizsys.psrt.srv.wf.service.WFStepActorServiceBase;
import net.ibizsys.psrt.srv.wf.service.WFUserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class WFStepActorService
extends WFStepActorServiceBase {
    private static final Log log = LogFactory.getLog(WFStepActorService.class);

    @Override
    protected void onRemindSave(WFStepActor wfStepActor) throws Exception {
        String strRemindMemo = DataObject.getStringValue(wfStepActor, "remindmemo", "");
        this.get(wfStepActor);
        if (DataObject.getBoolValue(wfStepActor, "ISFINISH", false).booleanValue()) {
            throw new Exception(StringHelper.format("\u5f53\u524d\u7528\u6237\u5de5\u4f5c\u5df2\u7ecf\u5b8c\u6210, \u65e0\u9700\u50ac\u529e"));
        }
        int nRemindCount = 1;
        if (wfStepActor.getReminderCount() != null) {
            nRemindCount = wfStepActor.getReminderCount() + 1;
        }
        WFUser wfUser = new WFUser();
        WFUserService wfUserService = (WFUserService)ServiceGlobal.getService(WFUserService.class, this.getSessionFactory());
        wfUser.setWFUserId(this.getWebContext().getCurUserId());
        wfUserService.get(wfUser);
        WFReminderService wfReminderService = (WFReminderService)ServiceGlobal.getService(WFReminderService.class, this.getSessionFactory());
        WFReminder wfReminder = new WFReminder();
        wfReminder.setWFReminderName(StringHelper.format("[%1$s]\u53d1\u8d77\u6d41\u7a0b\u50ac\u529e", wfUser.getWFUserName()));
        wfReminder.setWFStepActorId(wfStepActor.getWFStepActorId());
        wfReminder.setWFStepActorName(wfStepActor.getWFStepActorName());
        wfReminder.setActorId(wfStepActor.getActorId());
        wfReminder.setWFUserId(wfUser.getWFUserId());
        wfReminder.setWFUserName(wfUser.getWFUserName());
        wfReminder.setMemo(strRemindMemo);
        wfReminder.setReminderTime(new Timestamp(new Date().getTime()));
        wfReminderService.create(wfReminder, false);
        wfStepActor.reset();
        wfStepActor.setWFStepActorId(wfReminder.getWFStepActorId());
        wfStepActor.setReminderCount(nRemindCount);
        this.update(wfStepActor);
    }
}

