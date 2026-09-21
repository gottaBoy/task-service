/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.SqlParam
 *  net.ibizsys.paas.db.SqlParamList
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.WebContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdevstudio.service;

import java.sql.Timestamp;
import java.util.Date;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.SqlParam;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCBKTask;
import net.ibizsys.pscore.srv.devcenter.service.PSDCBKTaskService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSBKTaskLog;
import net.ibizsys.pscore.srv.paasmgr.service.PSBKTaskLogService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysDevBKTask;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevBKTaskServiceBase;
import net.ibizsys.pscore.srv.util.PSStudioConsoleHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysDevBKTaskService
extends PSSysDevBKTaskServiceBase {
    private static final Log log = LogFactory.getLog(PSSysDevBKTaskService.class);

    @Override
    protected void onBeforeCreate(PSSysDevBKTask pSSysDevBKTask) throws Exception {
        if ("USER".equalsIgnoreCase(pSSysDevBKTask.getTaskType()) || "IBIZCENTRAL".equalsIgnoreCase(pSSysDevBKTask.getTaskType())) {
            if (StringHelper.isNullOrEmpty((String)pSSysDevBKTask.getFullResultInfo())) {
                pSSysDevBKTask.setFullResultInfo(pSSysDevBKTask.getResultInfo());
            }
            if (pSSysDevBKTask.getBeginTime() == null) {
                pSSysDevBKTask.setBeginTime(new Timestamp(System.currentTimeMillis()));
            }
            if (StringHelper.isNullOrEmpty((String)pSSysDevBKTask.getPSDevSlnSysId())) {
                pSSysDevBKTask.setPSDevSlnSysId(PSSysDevBKTaskService.getCurrentPSDevSlnSysId());
            }
        }
        super.onBeforeCreate(pSSysDevBKTask);
    }

    @Override
    protected void onAfterCreate(PSSysDevBKTask pSSysDevBKTask) throws Exception {
        if ("IBIZCENTRAL".equalsIgnoreCase(pSSysDevBKTask.getTaskType())) {
            try {
                Object object;
                PSDCBKTask pSDCBKTask = new PSDCBKTask();
                pSSysDevBKTask.copyTo((IDataObject)pSDCBKTask, false);
                pSDCBKTask.setPSDCBKTaskId(pSSysDevBKTask.getPSSysDevBKTaskId());
                pSDCBKTask.setPSDCBKTaskName(pSSysDevBKTask.getPSSysDevBKTaskName());
                pSDCBKTask.setFullResultInfo(null);
                if (!StringHelper.isNullOrEmpty((String)pSDCBKTask.getPSDevSlnSysId())) {
                    object = new PSDevSlnSys();
                    ((PSDevSlnSysBase)object).setPSDevSlnSysId(pSSysDevBKTask.getPSDevSlnSysId());
                    PSDevSlnSysService pSDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                    pSDevSlnSysService.get((IEntity)object);
                    pSDCBKTask.setPSDevSlnSysName(((PSDevSlnSysBase)object).getPSDevSlnSysName());
                    if (((PSDevSlnSysBase)object).getPSDevSln() != null) {
                        pSDCBKTask.setPSDevSlnId(((PSDevSlnSysBase)object).getPSDevSln().getPSDevSlnId());
                        pSDCBKTask.setPSDevSlnName(((PSDevSlnSysBase)object).getPSDevSln().getPSDevSlnName());
                        pSDCBKTask.setPSDevCenterId(((PSDevSlnSysBase)object).getPSDevSln().getPSDevCenterId());
                        pSDCBKTask.setPSDevCenterName(((PSDevSlnSysBase)object).getPSDevSln().getPSDevCenterName());
                    }
                }
                object = (PSDCBKTaskService)ServiceGlobal.getService(PSDCBKTaskService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                ((PSCoreSysServiceBase)object).create(pSDCBKTask, false);
            }
            catch (Exception exception) {
                log.error((Object)StringHelper.format((String)"\u521b\u5efa\u5e73\u53f0\u4efb\u52a1\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()));
                throw new Exception(StringHelper.format((String)"\u521b\u5efa\u5e73\u53f0\u4efb\u52a1\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
            }
        }
        try {
            Object object;
            PSBKTaskLog pSBKTaskLog = new PSBKTaskLog();
            pSSysDevBKTask.copyTo((IDataObject)pSBKTaskLog, false);
            pSBKTaskLog.setPSBKTaskLogId(pSSysDevBKTask.getPSSysDevBKTaskId());
            pSBKTaskLog.setPSBKTaskLogName(pSSysDevBKTask.getPSSysDevBKTaskName());
            pSBKTaskLog.setPPSBKTaskLogId(pSSysDevBKTask.getPPSSysDevBKTaskId());
            pSBKTaskLog.setPPSBKTaskLogName(pSSysDevBKTask.getPPSSysDevBKTaskName());
            pSBKTaskLog.setTaskCat("PSSYSDEVBKTASK");
            if (!StringHelper.isNullOrEmpty((String)pSSysDevBKTask.getPSDevSlnSysId())) {
                object = new PSDevSlnSys();
                ((PSDevSlnSysBase)object).setPSDevSlnSysId(pSSysDevBKTask.getPSDevSlnSysId());
                PSDevSlnSysService pSDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                pSDevSlnSysService.get((IEntity)object);
                pSBKTaskLog.setPSDevSlnSysName(((PSDevSlnSysBase)object).getPSDevSlnSysName());
                if (((PSDevSlnSysBase)object).getPSDevSln() != null) {
                    pSBKTaskLog.setPSDevCenterId(((PSDevSlnSysBase)object).getPSDevSln().getPSDevCenterId());
                    pSBKTaskLog.setPSDevCenterName(((PSDevSlnSysBase)object).getPSDevSln().getPSDevCenterName());
                }
            }
            object = (PSBKTaskLogService)ServiceGlobal.getService(PSBKTaskLogService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            ((PSCoreSysServiceBase)object).create(pSBKTaskLog, false);
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u521b\u5efa\u4efb\u52a1\u5907\u4efd\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()));
            throw new Exception(StringHelper.format((String)"\u521b\u5efa\u4efb\u52a1\u5907\u4efd\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
        }
        if (("USER".equalsIgnoreCase(pSSysDevBKTask.getTaskType()) || "IBIZCENTRAL".equalsIgnoreCase(pSSysDevBKTask.getTaskType())) && !StringHelper.isNullOrEmpty((String)pSSysDevBKTask.getPSDevSlnSysId()) && !StringHelper.isNullOrEmpty((String)pSSysDevBKTask.getResultInfo()) && PSStudioConsoleHelper.getCurrent() != null) {
            PSStudioConsoleHelper.getCurrent().sendConsole(pSSysDevBKTask.getPSDevSlnSysId(), pSSysDevBKTask.getResultInfo(), pSSysDevBKTask.getPSSysDevBKTaskName());
        }
        super.onAfterCreate(pSSysDevBKTask);
    }

    @Override
    protected void onBeforeUpdate(PSSysDevBKTask pSSysDevBKTask) throws Exception {
        Object object;
        PSSysDevBKTask pSSysDevBKTask2 = (PSSysDevBKTask)this.getLast((IEntity)pSSysDevBKTask);
        pSSysDevBKTask.setTaskType(pSSysDevBKTask2.getTaskType());
        PSDCBKTask pSDCBKTask = null;
        if ("IBIZCENTRAL".equalsIgnoreCase(pSSysDevBKTask.getTaskType())) {
            pSDCBKTask = new PSDCBKTask();
            pSSysDevBKTask.copyTo((IDataObject)pSDCBKTask, false);
        }
        if ("USER".equalsIgnoreCase(pSSysDevBKTask.getTaskType()) || "IBIZCENTRAL".equalsIgnoreCase(pSSysDevBKTask.getTaskType())) {
            int n = DataTypeHelper.getIntegerValue((Object)pSSysDevBKTask2.getTaskState(), (Integer)10);
            if (n == 30 || n == 40) {
                throw new Exception("\u66f4\u65b0\u4efb\u52a1\u72b6\u6001\u4e0d\u6b63\u786e");
            }
            object = pSSysDevBKTask2.getFullResultInfo();
            if (!StringHelper.isNullOrEmpty((String)pSSysDevBKTask.getResultInfo())) {
                object = !StringHelper.isNullOrEmpty((String)object) ? (String)object + "\r\n" : "";
                object = (String)object + String.format("%1$tH:%1$tM:%1$tS ", new Date());
                object = (String)object + pSSysDevBKTask.getResultInfo();
            }
            pSSysDevBKTask.setFullResultInfo((String)object);
            pSSysDevBKTask.setPSSysDevBKTaskName(pSSysDevBKTask2.getPSSysDevBKTaskName());
            if (pSSysDevBKTask.getTaskState() != null && ((n = DataTypeHelper.getIntegerValue((Object)pSSysDevBKTask.getTaskState(), (Integer)20).intValue()) == 30 || n == 40) && pSSysDevBKTask.getEndTime() == null) {
                pSSysDevBKTask.setEndTime(new Timestamp(System.currentTimeMillis()));
            }
        }
        if (pSDCBKTask != null) {
            try {
                pSDCBKTask.setPSDCBKTaskId(pSSysDevBKTask.getPSSysDevBKTaskId());
                PSDCBKTaskService pSDCBKTaskService = (PSDCBKTaskService)ServiceGlobal.getService(PSDCBKTaskService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                pSDCBKTaskService.update(pSDCBKTask, false);
            }
            catch (Exception exception) {
                log.error((Object)StringHelper.format((String)"\u66f4\u65b0\u5e73\u53f0\u4efb\u52a1\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()));
                throw new Exception(StringHelper.format((String)"\u66f4\u65b0\u5e73\u53f0\u4efb\u52a1\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
            }
        } else if (pSSysDevBKTask.getTaskState() != null) {
            PSBKTaskLog pSBKTaskLog = new PSBKTaskLog();
            pSSysDevBKTask.copyTo((IDataObject)pSBKTaskLog, false);
            pSBKTaskLog.setPSBKTaskLogId(pSSysDevBKTask.getPSSysDevBKTaskId());
            object = (PSBKTaskLogService)ServiceGlobal.getService(PSBKTaskLogService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            ((PSCoreSysServiceBase)object).update(pSBKTaskLog, false);
        }
        super.onBeforeUpdate(pSSysDevBKTask);
    }

    @Override
    protected void onAfterUpdate(PSSysDevBKTask pSSysDevBKTask) throws Exception {
        if (("USER".equalsIgnoreCase(pSSysDevBKTask.getTaskType()) || "IBIZCENTRAL".equalsIgnoreCase(pSSysDevBKTask.getTaskType())) && !StringHelper.isNullOrEmpty((String)pSSysDevBKTask.getPSDevSlnSysId()) && !StringHelper.isNullOrEmpty((String)pSSysDevBKTask.getResultInfo()) && PSStudioConsoleHelper.getCurrent() != null) {
            int n = DataTypeHelper.getIntegerValue((Object)pSSysDevBKTask.getTaskState(), (Integer)20);
            String string = null;
            switch (n) {
                case 40: {
                    string = PSStudioConsoleHelper.getContent(pSSysDevBKTask.getResultInfo(), 31, -1, 1);
                    break;
                }
                case 30: {
                    string = PSStudioConsoleHelper.getContent(pSSysDevBKTask.getResultInfo(), 34);
                    break;
                }
                default: {
                    string = pSSysDevBKTask.getResultInfo();
                }
            }
            PSStudioConsoleHelper.getCurrent().sendConsole(pSSysDevBKTask.getPSDevSlnSysId(), string, pSSysDevBKTask.getPSSysDevBKTaskName());
        }
        super.onAfterUpdate(pSSysDevBKTask);
    }

    @Override
    protected void onRemoveExecuted(PSSysDevBKTask pSSysDevBKTask) throws Exception {
        String string = "";
        String string2 = "";
        if (WebContext.getCurrent() != null) {
            string = WebContext.getCurrent().getAppDataValue("psdevslnsysid");
            string2 = WebContext.getCurrent().getAppDataValue("pssystemid");
        }
        if (!StringHelper.isNullOrEmpty((String)string) && !StringHelper.isNullOrEmpty((String)string2)) {
            String string3 = "DELETE FROM T_SRFPSSYSDEVBKTASK WHERE PSSYSTEMID=? AND (TASKSTATE=30 OR TASKSTATE=40)";
            SqlParamList sqlParamList = new SqlParamList();
            sqlParamList.add((Object)new SqlParam((Object)string2, 25));
            this.getDAO().executeRawSql(null, string3, sqlParamList);
        }
    }
}

