/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.pscore.srv.codelist.SysDevBKTaskStateCodeListModel
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysRunSession
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysRunSessionService
 *  net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysDevBKTask
 *  net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevBKTaskService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DevCenter;

import SA.SRFDA.PS.Core.DevCenter.PSDevCenterBKTaskImplBase;
import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFramework.Utility.StringHelper;
import java.sql.Timestamp;
import java.util.ArrayList;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.pscore.srv.codelist.SysDevBKTaskStateCodeListModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysRunSession;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysRunSessionService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysDevBKTask;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevBKTaskService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.hibernate.SessionFactory;

public abstract class PSSysRunSessionDCBKTaskImplBase
extends PSDevCenterBKTaskImplBase {
    protected void executePackSysTask(PSDevSlnSys psDevSlnSys, PSSysRunSession psSysRunSession) throws Exception {
        String strPSDevSlnSysId = psDevSlnSys.getPSDevSlnSysId();
        IPSSystem iPSSystem = null;
        IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(strPSDevSlnSysId);
        PSSysRunSessionService psSysRunSessionService = (PSSysRunSessionService)ServiceGlobal.getService(PSSysRunSessionService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)psDevSlnSys.getPSSysModelInstId()));
        iPSSystem = iPSDevSlnSys.getPSSystem(false);
        PSSysDevBKTask parentPSSysDevBKTask = null;
        String strRunMode = psSysRunSession.getRunMode();
        boolean nTaskTotalTime = false;
        SessionFactoryManager.addRef();
        try {
            PSSysDevBKTaskService psSysDevBKTaskService = (PSSysDevBKTaskService)ServiceGlobal.getService(PSSysDevBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)iPSDevSlnSys.getPSSysModelInstId()));
            int nTaskOrder = 1;
            PSSysDevBKTask psSysDevBKTask = new PSSysDevBKTask();
            psSysDevBKTask.setTaskType("STARTUPEX");
            if (StringHelper.Compare((String)strRunMode, (String)"STARTX", (boolean)true) == 0) {
                psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u542f\u52a8\u7cfb\u7edf"));
                psSysDevBKTask.setModelLevel(IPSSystem.LOADLEVEL_CODE);
            } else if (StringHelper.Compare((String)strRunMode, (String)"PUBCODE", (boolean)true) == 0) {
                psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u53d1\u5e03\u7cfb\u7edf\u4ee3\u7801"));
                psSysDevBKTask.setTaskType("STARTUPEX2");
                psSysDevBKTask.setModelLevel(IPSSystem.LOADLEVEL_CODE);
            } else if (StringHelper.Compare((String)strRunMode, (String)"PACKVER", (boolean)true) == 0) {
                psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u53d1\u5e03\u7cfb\u7edf\u7248\u672c"));
                psSysDevBKTask.setTaskType("STARTUPEX3");
                psSysDevBKTask.setModelLevel(IPSSystem.LOADLEVEL_ALL);
            } else if (StringHelper.Compare((String)strRunMode, (String)"PACKVER2", (boolean)true) == 0) {
                psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u53d1\u5e03\u7cfb\u7edf\u7248\u672c"));
                psSysDevBKTask.setTaskType("STARTUPEX3");
                psSysDevBKTask.setModelLevel(IPSSystem.LOADLEVEL_DOC);
            } else {
                psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u542f\u52a8\u7cfb\u7edf"));
                psSysDevBKTask.setModelLevel(IPSSystem.LOADLEVEL_CODE);
            }
            psSysDevBKTask.setPSDevSlnSysId(strPSDevSlnSysId);
            psSysDevBKTask.setPSSysModelInstId(iPSDevSlnSys.getPSSysModelInstId());
            psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
            psSysDevBKTask.setPSSystemId(iPSSystem.getId());
            psSysDevBKTask.setPSSystemName(iPSSystem.getName());
            psSysDevBKTask.setTaskParam(psSysRunSession.getPSSysRunSessionId());
            psSysDevBKTask.setOrderValue(Integer.valueOf(nTaskOrder));
            psSysDevBKTask.setUseRobotFlag(Integer.valueOf(0));
            psSysDevBKTask.setPSDCRobotId("AUTO");
            psSysDevBKTask.setPSDCRobotName("(\u81ea\u52a8)");
            psSysDevBKTaskService.create(psSysDevBKTask);
            parentPSSysDevBKTask = psSysDevBKTask;
            boolean bPubPFCode = true;
            boolean bPubSFCode = true;
            boolean bPackPFCode = true;
            boolean bPackSFCode = true;
            boolean bDeploySys = true;
            boolean bPackVer = false;
            ArrayList<PSSysDevBKTask> psSysDevBKTaskList = new ArrayList<PSSysDevBKTask>();
            if (StringHelper.Compare((String)strRunMode, (String)"PUBCODE", (boolean)true) == 0 || StringHelper.Compare((String)strRunMode, (String)"PACKVER", (boolean)true) == 0 || StringHelper.Compare((String)strRunMode, (String)"PACKVER2", (boolean)true) == 0) {
                bDeploySys = false;
                if (StringHelper.Compare((String)strRunMode, (String)"PACKVER", (boolean)true) == 0) {
                    bPackVer = true;
                }
                if (StringHelper.Compare((String)strRunMode, (String)"PACKVER2", (boolean)true) == 0) {
                    bPackVer = true;
                    bPackPFCode = false;
                    bPackSFCode = false;
                }
            }
            ++nTaskOrder;
            PSSysDevBKTask psSysDevBKTask2 = new PSSysDevBKTask();
            psSysDevBKTask2.setPSSysDevBKTaskName(StringHelper.Format((String)"\u68c0\u67e5[%1$s]\u7cfb\u7edf\u6a21\u578b", (Object)iPSSystem.getName()));
            psSysDevBKTask2.setPSDevSlnSysId(strPSDevSlnSysId);
            psSysDevBKTask2.setPSSysModelInstId(iPSDevSlnSys.getPSSysModelInstId());
            psSysDevBKTask2.setTaskType("CHECKSYSMODEL");
            psSysDevBKTask2.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
            psSysDevBKTask2.setPSSystemId(iPSSystem.getId());
            psSysDevBKTask2.setPSSystemName(iPSSystem.getName());
            psSysDevBKTask2.setTaskParam(psSysRunSession.getPSSystemDBCfgId());
            psSysDevBKTask2.setPPSSysDevBKTaskId(parentPSSysDevBKTask.getPSSysDevBKTaskId());
            psSysDevBKTask2.setPPSSysDevBKTaskName(parentPSSysDevBKTask.getPSSysDevBKTaskName());
            psSysDevBKTask2.setOrderValue(Integer.valueOf(nTaskOrder));
            psSysDevBKTask2.setUseRobotFlag(Integer.valueOf(0));
            psSysDevBKTask2.setPSDCRobotId("AUTO");
            psSysDevBKTask2.setPSDCRobotName("(\u81ea\u52a8)");
            psSysDevBKTaskService.create(psSysDevBKTask2, false);
            psSysDevBKTask2.set("needtime", (Object)30);
            psSysDevBKTaskList.add(psSysDevBKTask2);
            ++nTaskOrder;
            psSysDevBKTask2 = new PSSysDevBKTask();
            psSysDevBKTask2.setPSSysDevBKTaskName(StringHelper.Format((String)"\u540c\u6b65[%1$s]\u6570\u636e\u5e93\u6a21\u578b", (Object)psSysRunSession.getPSSystemDBCfgName()));
            psSysDevBKTask2.setPSDevSlnSysId(strPSDevSlnSysId);
            psSysDevBKTask2.setPSSysModelInstId(iPSDevSlnSys.getPSSysModelInstId());
            psSysDevBKTask2.setTaskType("SYNCDBMODEL");
            psSysDevBKTask2.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
            psSysDevBKTask2.setPSSystemId(iPSSystem.getId());
            psSysDevBKTask2.setPSSystemName(iPSSystem.getName());
            psSysDevBKTask2.setTaskParam(psSysRunSession.getPSSystemDBCfgId());
            psSysDevBKTask2.setPPSSysDevBKTaskId(parentPSSysDevBKTask.getPSSysDevBKTaskId());
            psSysDevBKTask2.setPPSSysDevBKTaskName(parentPSSysDevBKTask.getPSSysDevBKTaskName());
            psSysDevBKTask2.setOrderValue(Integer.valueOf(nTaskOrder));
            psSysDevBKTask2.setUseRobotFlag(Integer.valueOf(0));
            psSysDevBKTask2.setPSDCRobotId("AUTO");
            psSysDevBKTask2.setPSDCRobotName("(\u81ea\u52a8)");
            psSysDevBKTaskService.create(psSysDevBKTask2, false);
            psSysDevBKTask2.set("needtime", (Object)30);
            psSysDevBKTaskList.add(psSysDevBKTask2);
            if (bPubSFCode) {
                ++nTaskOrder;
                psSysDevBKTask2 = new PSSysDevBKTask();
                psSysDevBKTask2.setPSSysDevBKTaskName(StringHelper.Format((String)"\u53d1\u5e03\u670d\u52a1\u5c42[%1$s]\u4ee3\u7801", (Object)psSysRunSession.getPSSysSFPubName()));
                psSysDevBKTask2.setPSDevSlnSysId(strPSDevSlnSysId);
                psSysDevBKTask2.setPSSysModelInstId(iPSDevSlnSys.getPSSysModelInstId());
                psSysDevBKTask2.setTaskType("PUBSFCODE");
                psSysDevBKTask2.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
                psSysDevBKTask2.setPSSystemId(iPSSystem.getId());
                psSysDevBKTask2.setPSSystemName(iPSSystem.getName());
                psSysDevBKTask2.setTaskParam(psSysRunSession.getPSSysSFPubId());
                psSysDevBKTask2.setPPSSysDevBKTaskId(parentPSSysDevBKTask.getPSSysDevBKTaskId());
                psSysDevBKTask2.setPPSSysDevBKTaskName(parentPSSysDevBKTask.getPSSysDevBKTaskName());
                psSysDevBKTask2.setOrderValue(Integer.valueOf(nTaskOrder));
                psSysDevBKTask2.setUseRobotFlag(Integer.valueOf(0));
                psSysDevBKTask2.setPSDCRobotId("AUTO");
                psSysDevBKTask2.setPSDCRobotName("(\u81ea\u52a8)");
                psSysDevBKTaskService.create(psSysDevBKTask2, false);
                psSysDevBKTask2.set("needtime", (Object)60);
                psSysDevBKTaskList.add(psSysDevBKTask2);
            }
            if (bPubPFCode && !StringHelper.IsNullOrEmpty((String)psSysRunSession.getPSSysAppId())) {
                ++nTaskOrder;
                psSysDevBKTask2 = new PSSysDevBKTask();
                psSysDevBKTask2.setPSSysDevBKTaskName(StringHelper.Format((String)"\u53d1\u5e03\u5e94\u7528\u7a0b\u5e8f[%1$s]\u4ee3\u7801", (Object)psSysRunSession.getPSSysAppName()));
                psSysDevBKTask2.setPSDevSlnSysId(strPSDevSlnSysId);
                psSysDevBKTask2.setPSSysModelInstId(iPSDevSlnSys.getPSSysModelInstId());
                psSysDevBKTask2.setTaskType("PUBPFCODE");
                psSysDevBKTask2.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
                psSysDevBKTask2.setPSSystemId(iPSSystem.getId());
                psSysDevBKTask2.setPSSystemName(iPSSystem.getName());
                psSysDevBKTask2.setTaskParam(psSysRunSession.getPSSysAppId());
                psSysDevBKTask2.setPPSSysDevBKTaskId(parentPSSysDevBKTask.getPSSysDevBKTaskId());
                psSysDevBKTask2.setPPSSysDevBKTaskName(parentPSSysDevBKTask.getPSSysDevBKTaskName());
                psSysDevBKTask2.setOrderValue(Integer.valueOf(nTaskOrder));
                psSysDevBKTask2.setUseRobotFlag(Integer.valueOf(0));
                psSysDevBKTask2.setPSDCRobotId("AUTO");
                psSysDevBKTask2.setPSDCRobotName("(\u81ea\u52a8)");
                psSysDevBKTaskService.create(psSysDevBKTask2, false);
                psSysDevBKTask2.set("needtime", (Object)60);
                psSysDevBKTaskList.add(psSysDevBKTask2);
            }
            if (DataObject.getIntegerValue((Object)psSysRunSession.getRebuildMode(), (Integer)0) > 0) {
                ++nTaskOrder;
                psSysDevBKTask2 = new PSSysDevBKTask();
                psSysDevBKTask2.setPSSysDevBKTaskName(StringHelper.Format((String)"\u91cd\u7f6e\u670d\u52a1\u5c42(\u524d\uff09[%1$s]\u4ee3\u7801", (Object)psSysRunSession.getPSSysSFPubName()));
                psSysDevBKTask2.setPSDevSlnSysId(strPSDevSlnSysId);
                psSysDevBKTask2.setPSSysModelInstId(iPSDevSlnSys.getPSSysModelInstId());
                psSysDevBKTask2.setTaskType("RESETSFCODE");
                psSysDevBKTask2.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
                psSysDevBKTask2.setPSSystemId(iPSSystem.getId());
                psSysDevBKTask2.setPSSystemName(iPSSystem.getName());
                psSysDevBKTask2.setTaskParam(psSysRunSession.getPSSysSFPubId());
                psSysDevBKTask2.setPPSSysDevBKTaskId(parentPSSysDevBKTask.getPSSysDevBKTaskId());
                psSysDevBKTask2.setPPSSysDevBKTaskName(parentPSSysDevBKTask.getPSSysDevBKTaskName());
                psSysDevBKTask2.setOrderValue(Integer.valueOf(nTaskOrder));
                psSysDevBKTask2.setUseRobotFlag(Integer.valueOf(0));
                psSysDevBKTask2.setPSDCRobotId("AUTO");
                psSysDevBKTask2.setPSDCRobotName("(\u81ea\u52a8)");
                psSysDevBKTaskService.create(psSysDevBKTask2, false);
                psSysDevBKTask2.set("needtime", (Object)30);
                psSysDevBKTaskList.add(psSysDevBKTask2);
                if (!StringHelper.IsNullOrEmpty((String)psSysRunSession.getPSSysAppId())) {
                    ++nTaskOrder;
                    psSysDevBKTask2 = new PSSysDevBKTask();
                    psSysDevBKTask2.setPSSysDevBKTaskName(StringHelper.Format((String)"\u91cd\u7f6e\u5e94\u7528\u7a0b\u5e8f[%1$s]\u4ee3\u7801", (Object)psSysRunSession.getPSSysAppName()));
                    psSysDevBKTask2.setPSDevSlnSysId(strPSDevSlnSysId);
                    psSysDevBKTask2.setPSSysModelInstId(iPSDevSlnSys.getPSSysModelInstId());
                    psSysDevBKTask2.setTaskType("RESETPFCODE");
                    psSysDevBKTask2.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
                    psSysDevBKTask2.setPSSystemId(iPSSystem.getId());
                    psSysDevBKTask2.setPSSystemName(iPSSystem.getName());
                    psSysDevBKTask2.setTaskParam(psSysRunSession.getPSSysAppId());
                    psSysDevBKTask2.setPPSSysDevBKTaskId(parentPSSysDevBKTask.getPSSysDevBKTaskId());
                    psSysDevBKTask2.setPPSSysDevBKTaskName(parentPSSysDevBKTask.getPSSysDevBKTaskName());
                    psSysDevBKTask2.setOrderValue(Integer.valueOf(nTaskOrder));
                    psSysDevBKTask2.setUseRobotFlag(Integer.valueOf(0));
                    psSysDevBKTask2.setPSDCRobotId("AUTO");
                    psSysDevBKTask2.setPSDCRobotName("(\u81ea\u52a8)");
                    psSysDevBKTaskService.create(psSysDevBKTask2, false);
                    psSysDevBKTask2.set("needtime", (Object)30);
                    psSysDevBKTaskList.add(psSysDevBKTask2);
                }
                if (bPubSFCode) {
                    ++nTaskOrder;
                    psSysDevBKTask2 = new PSSysDevBKTask();
                    psSysDevBKTask2.setPSSysDevBKTaskName(StringHelper.Format((String)"\u53d1\u5e03\u670d\u52a1\u5c42[%1$s]\u4ee3\u7801", (Object)psSysRunSession.getPSSysSFPubName()));
                    psSysDevBKTask2.setPSDevSlnSysId(strPSDevSlnSysId);
                    psSysDevBKTask2.setPSSysModelInstId(iPSDevSlnSys.getPSSysModelInstId());
                    psSysDevBKTask2.setTaskType("PUBSFCODE");
                    psSysDevBKTask2.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
                    psSysDevBKTask2.setPSSystemId(iPSSystem.getId());
                    psSysDevBKTask2.setPSSystemName(iPSSystem.getName());
                    psSysDevBKTask2.setTaskParam(psSysRunSession.getPSSysSFPubId());
                    psSysDevBKTask2.setPPSSysDevBKTaskId(parentPSSysDevBKTask.getPSSysDevBKTaskId());
                    psSysDevBKTask2.setPPSSysDevBKTaskName(parentPSSysDevBKTask.getPSSysDevBKTaskName());
                    psSysDevBKTask2.setOrderValue(Integer.valueOf(nTaskOrder));
                    psSysDevBKTask2.setUseRobotFlag(Integer.valueOf(0));
                    psSysDevBKTask2.setPSDCRobotId("AUTO");
                    psSysDevBKTask2.setPSDCRobotName("(\u81ea\u52a8)");
                    psSysDevBKTaskService.create(psSysDevBKTask2, false);
                    psSysDevBKTask2.set("needtime", (Object)60);
                    psSysDevBKTaskList.add(psSysDevBKTask2);
                }
                if (bPubPFCode && !StringHelper.IsNullOrEmpty((String)psSysRunSession.getPSSysAppId())) {
                    ++nTaskOrder;
                    psSysDevBKTask2 = new PSSysDevBKTask();
                    psSysDevBKTask2.setPSSysDevBKTaskName(StringHelper.Format((String)"\u53d1\u5e03\u5e94\u7528\u7a0b\u5e8f[%1$s]\u4ee3\u7801", (Object)psSysRunSession.getPSSysAppName()));
                    psSysDevBKTask2.setPSDevSlnSysId(strPSDevSlnSysId);
                    psSysDevBKTask2.setPSSysModelInstId(iPSDevSlnSys.getPSSysModelInstId());
                    psSysDevBKTask2.setTaskType("PUBPFCODE");
                    psSysDevBKTask2.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
                    psSysDevBKTask2.setPSSystemId(iPSSystem.getId());
                    psSysDevBKTask2.setPSSystemName(iPSSystem.getName());
                    psSysDevBKTask2.setTaskParam(psSysRunSession.getPSSysAppId());
                    psSysDevBKTask2.setPPSSysDevBKTaskId(parentPSSysDevBKTask.getPSSysDevBKTaskId());
                    psSysDevBKTask2.setPPSSysDevBKTaskName(parentPSSysDevBKTask.getPSSysDevBKTaskName());
                    psSysDevBKTask2.setOrderValue(Integer.valueOf(nTaskOrder));
                    psSysDevBKTask2.setUseRobotFlag(Integer.valueOf(0));
                    psSysDevBKTask2.setPSDCRobotId("AUTO");
                    psSysDevBKTask2.setPSDCRobotName("(\u81ea\u52a8)");
                    psSysDevBKTaskService.create(psSysDevBKTask2, false);
                    psSysDevBKTask2.set("needtime", (Object)60);
                    psSysDevBKTaskList.add(psSysDevBKTask2);
                }
            }
            if (DataObject.getIntegerValue((Object)psSysRunSession.getRebuildMode(), (Integer)0) > 0) {
                // empty if block
            }
            if (bPackSFCode) {
                ++nTaskOrder;
                psSysDevBKTask2 = new PSSysDevBKTask();
                psSysDevBKTask2.setPSSysDevBKTaskName(StringHelper.Format((String)"\u6253\u5305\u670d\u52a1\u5c42[%1$s]\u4ee3\u7801", (Object)psSysRunSession.getPSSysSFPubName()));
                psSysDevBKTask2.setPSDevSlnSysId(strPSDevSlnSysId);
                psSysDevBKTask2.setPSSysModelInstId(iPSDevSlnSys.getPSSysModelInstId());
                psSysDevBKTask2.setTaskType("PACKSFCODE");
                psSysDevBKTask2.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
                psSysDevBKTask2.setPSSystemId(iPSSystem.getId());
                psSysDevBKTask2.setPSSystemName(iPSSystem.getName());
                psSysDevBKTask2.setTaskParam(psSysRunSession.getPSSysSFPubId());
                psSysDevBKTask2.setPPSSysDevBKTaskId(parentPSSysDevBKTask.getPSSysDevBKTaskId());
                psSysDevBKTask2.setPPSSysDevBKTaskName(parentPSSysDevBKTask.getPSSysDevBKTaskName());
                psSysDevBKTask2.setOrderValue(Integer.valueOf(nTaskOrder));
                psSysDevBKTask2.setUseRobotFlag(Integer.valueOf(0));
                psSysDevBKTask2.setPSDCRobotId("AUTO");
                psSysDevBKTask2.setPSDCRobotName("(\u81ea\u52a8)");
                psSysDevBKTaskService.create(psSysDevBKTask2, false);
                psSysDevBKTask2.set("needtime", (Object)60);
                psSysDevBKTaskList.add(psSysDevBKTask2);
            }
            if (bPackPFCode && !StringHelper.IsNullOrEmpty((String)psSysRunSession.getPSSysAppId())) {
                ++nTaskOrder;
                psSysDevBKTask2 = new PSSysDevBKTask();
                psSysDevBKTask2.setPSSysDevBKTaskName(StringHelper.Format((String)"\u6253\u5305\u5e94\u7528\u7a0b\u5e8f[%1$s]\u4ee3\u7801", (Object)psSysRunSession.getPSSysAppName()));
                psSysDevBKTask2.setPSDevSlnSysId(strPSDevSlnSysId);
                psSysDevBKTask2.setPSSysModelInstId(iPSDevSlnSys.getPSSysModelInstId());
                psSysDevBKTask2.setTaskType("PACKPFCODE");
                psSysDevBKTask2.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
                psSysDevBKTask2.setPSSystemId(iPSSystem.getId());
                psSysDevBKTask2.setPSSystemName(iPSSystem.getName());
                psSysDevBKTask2.setTaskParam(psSysRunSession.getPSSysAppId());
                psSysDevBKTask2.setPPSSysDevBKTaskId(parentPSSysDevBKTask.getPSSysDevBKTaskId());
                psSysDevBKTask2.setPPSSysDevBKTaskName(parentPSSysDevBKTask.getPSSysDevBKTaskName());
                psSysDevBKTask2.setOrderValue(Integer.valueOf(nTaskOrder));
                psSysDevBKTask2.setUseRobotFlag(Integer.valueOf(0));
                psSysDevBKTask2.setPSDCRobotId("AUTO");
                psSysDevBKTask2.setPSDCRobotName("(\u81ea\u52a8)");
                psSysDevBKTaskService.create(psSysDevBKTask2, false);
                psSysDevBKTask2.set("needtime", (Object)60);
                psSysDevBKTaskList.add(psSysDevBKTask2);
            }
            if (bPackPFCode && !StringHelper.IsNullOrEmpty((String)psSysRunSession.getPSSysAppId2())) {
                ++nTaskOrder;
                psSysDevBKTask2 = new PSSysDevBKTask();
                psSysDevBKTask2.setPSSysDevBKTaskName(StringHelper.Format((String)"\u6253\u5305\u5e94\u7528\u7a0b\u5e8f[%1$s]\u4ee3\u7801", (Object)psSysRunSession.getPSSysAppName2()));
                psSysDevBKTask2.setPSDevSlnSysId(strPSDevSlnSysId);
                psSysDevBKTask2.setPSSysModelInstId(iPSDevSlnSys.getPSSysModelInstId());
                psSysDevBKTask2.setTaskType("PACKPFCODE");
                psSysDevBKTask2.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
                psSysDevBKTask2.setPSSystemId(iPSSystem.getId());
                psSysDevBKTask2.setPSSystemName(iPSSystem.getName());
                psSysDevBKTask2.setTaskParam(psSysRunSession.getPSSysAppId2());
                psSysDevBKTask2.setPPSSysDevBKTaskId(parentPSSysDevBKTask.getPSSysDevBKTaskId());
                psSysDevBKTask2.setPPSSysDevBKTaskName(parentPSSysDevBKTask.getPSSysDevBKTaskName());
                psSysDevBKTask2.setOrderValue(Integer.valueOf(nTaskOrder));
                psSysDevBKTask2.setUseRobotFlag(Integer.valueOf(0));
                psSysDevBKTask2.setPSDCRobotId("AUTO");
                psSysDevBKTask2.setPSDCRobotName("(\u81ea\u52a8)");
                psSysDevBKTaskService.create(psSysDevBKTask2, false);
                psSysDevBKTask2.set("needtime", (Object)60);
                psSysDevBKTaskList.add(psSysDevBKTask2);
            }
            if (bDeploySys) {
                ++nTaskOrder;
                psSysDevBKTask2 = new PSSysDevBKTask();
                psSysDevBKTask2.setPSSysDevBKTaskName(StringHelper.Format((String)"\u505c\u6b62\u5e94\u7528\u670d\u52a1\u5668[%1$s]", (Object)psSysRunSession.getPSSystemASName()));
                psSysDevBKTask2.setPSDevSlnSysId(strPSDevSlnSysId);
                psSysDevBKTask2.setPSSysModelInstId(iPSDevSlnSys.getPSSysModelInstId());
                psSysDevBKTask2.setTaskType("SHUTDOWNAS");
                psSysDevBKTask2.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
                psSysDevBKTask2.setPSSystemId(iPSSystem.getId());
                psSysDevBKTask2.setPSSystemName(iPSSystem.getName());
                psSysDevBKTask2.setTaskParam(psSysRunSession.getPSSystemASId());
                psSysDevBKTask2.setPPSSysDevBKTaskId(parentPSSysDevBKTask.getPSSysDevBKTaskId());
                psSysDevBKTask2.setPPSSysDevBKTaskName(parentPSSysDevBKTask.getPSSysDevBKTaskName());
                psSysDevBKTask2.setOrderValue(Integer.valueOf(nTaskOrder));
                psSysDevBKTask2.setUseRobotFlag(Integer.valueOf(0));
                psSysDevBKTask2.setPSDCRobotId("AUTO");
                psSysDevBKTask2.setPSDCRobotName("(\u81ea\u52a8)");
                psSysDevBKTaskService.create(psSysDevBKTask2, false);
                psSysDevBKTask2.set("needtime", (Object)20);
                psSysDevBKTaskList.add(psSysDevBKTask2);
            }
            if (bDeploySys) {
                ++nTaskOrder;
                psSysDevBKTask2 = new PSSysDevBKTask();
                psSysDevBKTask2.setPSSysDevBKTaskName(StringHelper.Format((String)"\u90e8\u7f72\u7cfb\u7edf"));
                psSysDevBKTask2.setPSDevSlnSysId(strPSDevSlnSysId);
                psSysDevBKTask2.setPSSysModelInstId(iPSDevSlnSys.getPSSysModelInstId());
                psSysDevBKTask2.setTaskType("DEPLOYSYS");
                psSysDevBKTask2.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
                psSysDevBKTask2.setPSSystemId(iPSSystem.getId());
                psSysDevBKTask2.setPSSystemName(iPSSystem.getName());
                psSysDevBKTask2.setTaskParam(psSysRunSession.getPSSysSFPubId());
                psSysDevBKTask2.setPPSSysDevBKTaskId(parentPSSysDevBKTask.getPSSysDevBKTaskId());
                psSysDevBKTask2.setPPSSysDevBKTaskName(parentPSSysDevBKTask.getPSSysDevBKTaskName());
                psSysDevBKTask2.setOrderValue(Integer.valueOf(nTaskOrder));
                psSysDevBKTask2.setUseRobotFlag(Integer.valueOf(0));
                psSysDevBKTask2.setPSDCRobotId("AUTO");
                psSysDevBKTask2.setPSDCRobotName("(\u81ea\u52a8)");
                psSysDevBKTaskService.create(psSysDevBKTask2, false);
                psSysDevBKTask2.set("needtime", (Object)90);
                psSysDevBKTaskList.add(psSysDevBKTask2);
            }
            if (bDeploySys) {
                ++nTaskOrder;
                psSysDevBKTask2 = new PSSysDevBKTask();
                psSysDevBKTask2.setPSSysDevBKTaskName(StringHelper.Format((String)"\u542f\u52a8\u5e94\u7528\u670d\u52a1\u5668[%1$s]", (Object)psSysRunSession.getPSSystemASName()));
                psSysDevBKTask2.setPSDevSlnSysId(strPSDevSlnSysId);
                psSysDevBKTask2.setPSSysModelInstId(iPSDevSlnSys.getPSSysModelInstId());
                psSysDevBKTask2.setTaskType("STARTUPAS");
                psSysDevBKTask2.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
                psSysDevBKTask2.setPSSystemId(iPSSystem.getId());
                psSysDevBKTask2.setPSSystemName(iPSSystem.getName());
                psSysDevBKTask2.setTaskParam(psSysRunSession.getPSSystemASId());
                psSysDevBKTask2.setPPSSysDevBKTaskId(parentPSSysDevBKTask.getPSSysDevBKTaskId());
                psSysDevBKTask2.setPPSSysDevBKTaskName(parentPSSysDevBKTask.getPSSysDevBKTaskName());
                psSysDevBKTask2.setOrderValue(Integer.valueOf(nTaskOrder));
                psSysDevBKTask2.setUseRobotFlag(Integer.valueOf(0));
                psSysDevBKTask2.setPSDCRobotId("AUTO");
                psSysDevBKTask2.setPSDCRobotName("(\u81ea\u52a8)");
                psSysDevBKTaskService.create(psSysDevBKTask2, false);
                psSysDevBKTask2.set("needtime", (Object)30);
                psSysDevBKTaskList.add(psSysDevBKTask2);
            }
            if (bPackVer) {
                ++nTaskOrder;
                psSysDevBKTask2 = new PSSysDevBKTask();
                if (StringHelper.IsNullOrEmpty((String)psSysRunSession.getRunParam2())) {
                    psSysDevBKTask2.setPSSysDevBKTaskName(StringHelper.Format((String)"\u6253\u5305\u7248\u672c"));
                } else {
                    psSysDevBKTask2.setPSSysDevBKTaskName(StringHelper.Format((String)"\u6253\u5305\u7248\u672c[%1$s]", (Object)psSysRunSession.getRunParam2()));
                }
                psSysDevBKTask2.setPSDevSlnSysId(strPSDevSlnSysId);
                psSysDevBKTask2.setPSSysModelInstId(iPSDevSlnSys.getPSSysModelInstId());
                psSysDevBKTask2.setTaskType("PACKSYSVER");
                psSysDevBKTask2.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
                psSysDevBKTask2.setPSSystemId(iPSSystem.getId());
                psSysDevBKTask2.setPSSystemName(iPSSystem.getName());
                psSysDevBKTask2.setTaskParam(psSysRunSession.getPSSysSFPubId());
                psSysDevBKTask2.setTaskParam2(psSysRunSession.getRunParam());
                psSysDevBKTask2.setPPSSysDevBKTaskId(parentPSSysDevBKTask.getPSSysDevBKTaskId());
                psSysDevBKTask2.setPPSSysDevBKTaskName(parentPSSysDevBKTask.getPSSysDevBKTaskName());
                psSysDevBKTask2.setOrderValue(Integer.valueOf(nTaskOrder));
                psSysDevBKTask2.setUseRobotFlag(Integer.valueOf(0));
                psSysDevBKTask2.setPSDCRobotId("AUTO");
                psSysDevBKTask2.setPSDCRobotName("(\u81ea\u52a8)");
                psSysDevBKTaskService.create(psSysDevBKTask2, false);
                psSysDevBKTask2.set("needtime", (Object)120);
                psSysDevBKTaskList.add(psSysDevBKTask2);
            }
            if (bDeploySys) {
                ++nTaskOrder;
                SelectCond selectCond = new SelectCond();
                selectCond.set("PSSYSTEMID", (Object)psSysRunSession.getPSSystemId());
                selectCond.set("RUNSTATE", (Object)20);
                ArrayList<PSSysRunSession> psSysRunSessionList = psSysRunSessionService.select((ISelectCond)selectCond);
                for (PSSysRunSession lastRunSession : psSysRunSessionList) {
                    PSSysRunSession updateItem = new PSSysRunSession();
                    updateItem.setPSSysRunSessionId(lastRunSession.getPSSysRunSessionId());
                    updateItem.setRunState(Integer.valueOf(30));
                    updateItem.setEndTime(new Timestamp(System.currentTimeMillis()));
                    psSysRunSessionService.update(updateItem);
                }
                PSSysRunSession updateItem = new PSSysRunSession();
                updateItem.setPSSysRunSessionId(psSysRunSession.getPSSysRunSessionId());
                updateItem.setRunState(Integer.valueOf(20));
                updateItem.setStartTime(new Timestamp(System.currentTimeMillis()));
                psSysRunSessionService.update(updateItem);
            } else {
                PSSysRunSession updateItem = new PSSysRunSession();
                updateItem.setPSSysRunSessionId(psSysRunSession.getPSSysRunSessionId());
                updateItem.setRunState(Integer.valueOf(30));
                updateItem.setStartTime(new Timestamp(System.currentTimeMillis()));
                psSysRunSessionService.update(updateItem);
            }
            int nTotalTime = 0;
            for (PSSysDevBKTask psSysDevBKTask3 : psSysDevBKTaskList) {
                nTotalTime += DataObject.getIntegerValue((Object)psSysDevBKTask3.get("needtime"), (Integer)0).intValue();
            }
            this.taskRemainingTimeMap.put(parentPSSysDevBKTask.getPSSysDevBKTaskId(), nTotalTime);
            for (PSSysDevBKTask psSysDevBKTask3 : psSysDevBKTaskList) {
                this.taskRemainingTimeMap.put(psSysDevBKTask3.getPSSysDevBKTaskId(), nTotalTime);
                nTotalTime -= DataObject.getIntegerValue((Object)psSysDevBKTask3.get("needtime"), (Integer)0).intValue();
            }
            SessionFactoryManager.releaseRef((boolean)true);
        }
        catch (Exception ex) {
            SessionFactoryManager.releaseRef((boolean)false);
            throw ex;
        }
        this.runPSSysDevBKTask(iPSDevSlnSys, parentPSSysDevBKTask);
    }
}
