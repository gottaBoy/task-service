/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.RemoteCallResult
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.devcenter.service;

import java.sql.Timestamp;
import java.util.Date;
import net.ibizsys.paas.core.RemoteCallResult;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCBKTask;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCBKTaskBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCBKTaskServiceBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSBKTaskLog;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.service.PSBKTaskLogService;
import net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService;
import net.ibizsys.pscore.srv.util.PSStudioConsoleHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDCBKTaskService
extends PSDCBKTaskServiceBase {
    private static final Log log = LogFactory.getLog(PSDCBKTaskService.class);

    @Override
    protected void onStartTask(PSDCBKTask pSDCBKTask) throws Exception {
        this.get(pSDCBKTask);
        this.executeAction("X2_STARTTASK", pSDCBKTask);
    }

    @Override
    protected void onCancelTask(PSDCBKTask pSDCBKTask) throws Exception {
        this.get(pSDCBKTask);
        this.executeAction("X2_CANCELTASK", pSDCBKTask);
    }

    @Override
    protected void onBeforeCreate(PSDCBKTask pSDCBKTask) throws Exception {
        if ("USER".equalsIgnoreCase(pSDCBKTask.getTaskType()) || "IBIZCENTRAL".equalsIgnoreCase(pSDCBKTask.getTaskType())) {
            if (StringHelper.isNullOrEmpty((String)pSDCBKTask.getFullResultInfo())) {
                pSDCBKTask.setFullResultInfo(pSDCBKTask.getResultInfo());
            }
            if (pSDCBKTask.getBeginTime() == null) {
                pSDCBKTask.setBeginTime(new Timestamp(System.currentTimeMillis()));
            }
            if (StringHelper.isNullOrEmpty((String)pSDCBKTask.getPSDevCenterId())) {
                pSDCBKTask.setPSDevCenterId(PSDCBKTaskService.getCurrentPSDCId());
            }
        }
        super.onBeforeCreate(pSDCBKTask);
    }

    @Override
    protected RemoteCallResult executeRemoteCall(String string, IEntity iEntity, boolean bl) throws Exception {
        String taskServerId;
        if (!iEntity.isFullEntity()) {
            PSDCBKTask task = new PSDCBKTask();
            task.setPSDCBKTaskId(DataObject.getStringValue((Object)iEntity.get("PSDCBKTASKID"), (String)""));
            this.get(task);
            task.copyTo((IDataObject)iEntity, true);
        }
        if (!StringHelper.isNullOrEmpty((String)(taskServerId = DataObject.getStringValue((Object)iEntity.get("PSTASKSERVERID"), (String)"")))) {
            PSTaskServerService pSTaskServerService = (PSTaskServerService)ServiceGlobal.getService(PSTaskServerService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSTaskServer pSTaskServer = new PSTaskServer();
            pSTaskServer.setPSTaskServerId(taskServerId);
            if (pSTaskServerService.get(pSTaskServer, true)) {
                return super.executeRemoteCall(pSTaskServer, string, iEntity, bl);
            }
        }
        return super.executeRemoteCall(string, iEntity, bl);
    }

    @Override
    protected void onAfterCreate(PSDCBKTask pSDCBKTask) throws Exception {
        if (this.getSessionFactory() == PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            try {
                PSBKTaskLog pSBKTaskLog = new PSBKTaskLog();
                pSDCBKTask.copyTo((IDataObject)pSBKTaskLog, false);
                pSBKTaskLog.setPSBKTaskLogId(pSDCBKTask.getPSDCBKTaskId());
                pSBKTaskLog.setPSBKTaskLogName(pSDCBKTask.getPSDCBKTaskName());
                pSBKTaskLog.setTaskCat("PSDCBKTASK");
                PSBKTaskLogService pSBKTaskLogService = (PSBKTaskLogService)ServiceGlobal.getService(PSBKTaskLogService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                pSBKTaskLogService.create(pSBKTaskLog, false);
            }
            catch (Exception exception) {
                log.error((Object)StringHelper.format((String)"\u521b\u5efa\u4efb\u52a1\u5907\u4efd\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()));
                throw new Exception(StringHelper.format((String)"\u521b\u5efa\u4efb\u52a1\u5907\u4efd\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
            }
            if (("USER".equalsIgnoreCase(pSDCBKTask.getTaskType()) || "IBIZCENTRAL".equalsIgnoreCase(pSDCBKTask.getTaskType())) && !StringHelper.isNullOrEmpty((String)pSDCBKTask.getPSDevSlnId()) && !StringHelper.isNullOrEmpty((String)pSDCBKTask.getResultInfo()) && PSStudioConsoleHelper.getCurrent() != null) {
                PSStudioConsoleHelper.getCurrent().sendConsole(pSDCBKTask.getPSDevSlnId(), pSDCBKTask.getResultInfo(), pSDCBKTask.getPSDCBKTaskName());
            }
        }
        super.onAfterCreate(pSDCBKTask);
    }

    @Override
    protected void onBeforeUpdate(PSDCBKTask pSDCBKTask) throws Exception {
        if (this.getSessionFactory() == PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            Object object;
            PSDCBKTask pSDCBKTask2 = (PSDCBKTask)this.getLast(pSDCBKTask);
            if ("USER".equalsIgnoreCase(pSDCBKTask2.getTaskType()) || "IBIZCENTRAL".equalsIgnoreCase(pSDCBKTask.getTaskType())) {
                int n = DataTypeHelper.getIntegerValue((Object)pSDCBKTask2.getTaskState(), (Integer)10);
                if (n == 30 || n == 40) {
                    throw new Exception("\u66f4\u65b0\u4efb\u52a1\u72b6\u6001\u4e0d\u6b63\u786e");
                }
                object = pSDCBKTask2.getFullResultInfo();
                if (!StringHelper.isNullOrEmpty((String)pSDCBKTask.getResultInfo())) {
                    object = !StringHelper.isNullOrEmpty((String)object) ? (String)object + "\r\n" : "";
                    object = (String)object + String.format("%1$tH:%1$tM:%1$tS ", new Date());
                    object = (String)object + pSDCBKTask.getResultInfo();
                }
                pSDCBKTask.setFullResultInfo((String)object);
                pSDCBKTask.setPSDCBKTaskName(pSDCBKTask2.getPSDCBKTaskName());
                pSDCBKTask.setTaskType(pSDCBKTask2.getTaskType());
                if (pSDCBKTask.getTaskState() != null && ((n = DataTypeHelper.getIntegerValue((Object)pSDCBKTask.getTaskState(), (Integer)20).intValue()) == 30 || n == 40) && pSDCBKTask.getEndTime() == null) {
                    pSDCBKTask.setEndTime(new Timestamp(System.currentTimeMillis()));
                }
            }
            if (pSDCBKTask.getTaskState() != null) {
                PSBKTaskLog pSBKTaskLog = new PSBKTaskLog();
                pSDCBKTask.copyTo((IDataObject)pSBKTaskLog, false);
                pSBKTaskLog.setPSBKTaskLogId(pSDCBKTask.getPSDCBKTaskId());
                object = (PSBKTaskLogService)ServiceGlobal.getService(PSBKTaskLogService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                ((PSCoreSysServiceBase)object).update(pSBKTaskLog, false);
            }
        }
        super.onBeforeUpdate(pSDCBKTask);
    }

    @Override
    protected void onAfterUpdate(PSDCBKTask pSDCBKTask) throws Exception {
        if (this.getSessionFactory() == PSCoreSysServiceBase.getCurMajorSessionFactory() && ("USER".equalsIgnoreCase(pSDCBKTask.getTaskType()) || "IBIZCENTRAL".equalsIgnoreCase(pSDCBKTask.getTaskType())) && !StringHelper.isNullOrEmpty((String)pSDCBKTask.getPSDevSlnId()) && !StringHelper.isNullOrEmpty((String)pSDCBKTask.getResultInfo()) && PSStudioConsoleHelper.getCurrent() != null) {
            int n = DataTypeHelper.getIntegerValue((Object)pSDCBKTask.getTaskState(), (Integer)20);
            String string = null;
            switch (n) {
                case 40: {
                    string = PSStudioConsoleHelper.getContent(pSDCBKTask.getResultInfo(), 31, -1, 1);
                    break;
                }
                case 30: {
                    string = PSStudioConsoleHelper.getContent(pSDCBKTask.getResultInfo(), 34);
                    break;
                }
                default: {
                    string = pSDCBKTask.getResultInfo();
                }
            }
            PSStudioConsoleHelper.getCurrent().sendConsole(pSDCBKTask.getPSDevSlnId(), string, pSDCBKTask.getPSDCBKTaskName());
        }
        super.onAfterUpdate(pSDCBKTask);
    }
}
