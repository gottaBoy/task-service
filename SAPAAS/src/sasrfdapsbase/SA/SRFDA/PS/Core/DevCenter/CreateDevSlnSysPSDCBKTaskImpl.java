/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.core.IDEField
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.pscore.srv.codelist.SysDevBKTaskStateCodeListModel
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysVer
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystem
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfg
 *  net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysVerService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSystemDBCfgService
 *  net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysDevBKTask
 *  net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevBKTaskService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DevCenter;

import SA.SRFDA.PS.Core.Database.IPSSystemDBConfig;
import SA.SRFDA.PS.Core.Deploy.IPSDBDevInst;
import SA.SRFDA.PS.Core.DevCenter.PSDevCenterBKTaskImplBase;
import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.pscore.srv.codelist.SysDevBKTaskStateCodeListModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysVer;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfg;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysVerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemDBCfgService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysDevBKTask;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevBKTaskService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class CreateDevSlnSysPSDCBKTaskImpl
extends PSDevCenterBKTaskImplBase {
    private static final Log log = LogFactory.getLog(CreateDevSlnSysPSDCBKTaskImpl.class);

    @Override
    protected String onRun() throws Exception {
        String strDstPSSysModelInstId;
        String strSrcPSSysModelInstId;
        PSDevSlnSysService psDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class);
        PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
        Iterator deFields = psDevSlnSysService.getDEModel().getDEFields();
        if (deFields != null) {
            while (deFields.hasNext()) {
                IDEField iDEField = (IDEField)deFields.next();
                String strValue = this.getTaskParam(iDEField.getName(), null);
                if (StringHelper.IsNullOrEmpty((String)strValue)) continue;
                psDevSlnSys.set(iDEField.getName(), (Object)strValue);
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)(strSrcPSSysModelInstId = this.getTaskParam("SRCPSSYSMODELINSTID", "")))) {
            psDevSlnSys.set("srcpssysmodelinstid", (Object)strSrcPSSysModelInstId);
        }
        if (!StringHelper.IsNullOrEmpty((String)(strDstPSSysModelInstId = this.getTaskParam("DSTPSSYSMODELINSTID", "")))) {
            psDevSlnSys.set("dstpssysmodelinstid", (Object)strDstPSSysModelInstId);
        }
        this.updatePSDCBKTaskStep("\u6b63\u5728\u521b\u5efa\u7cfb\u7edf", 300, 300);
        psDevSlnSysService.create(psDevSlnSys);
        SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory((String)psDevSlnSys.getPSSysModelInstId());
        PSDevSln psDevSln = psDevSlnSys.getPSDevSln();
        PSDevSlnSysVerService psDevSlnSysVerService = (PSDevSlnSysVerService)ServiceGlobal.getService(PSDevSlnSysVerService.class);
        PSDevSlnSysVer psDevSlnSysVer = new PSDevSlnSysVer();
        psDevSlnSysVer.setPSDevCenterId(psDevSln.getPSDevCenterId());
        psDevSlnSysVer.setPSDevCenterName(psDevSln.getPSDevCenterName());
        psDevSlnSysVer.setPSDevSlnId(psDevSln.getPSDevSlnId());
        psDevSlnSysVer.setPSDevSlnName(psDevSln.getPSDevSlnName());
        psDevSlnSysVer.setVersion("1.0");
        psDevSlnSysVer.setPSDevSlnSysId(psDevSlnSys.getPSDevSlnSysId());
        psDevSlnSysVer.setPSDevSlnSysName(psDevSlnSys.getPSDevSlnSysName());
        psDevSlnSysVer.setPSDevSlnSysVerId(psDevSlnSys.getPSDevSlnSysId());
        psDevSlnSysVer.setMemo("\u9ed8\u8ba4\u7248\u672c");
        psDevSlnSysVerService.create(psDevSlnSysVer);
        this.updatePSDCBKTaskRemainingTime(180);
        this.executeInitSysModelTask(psDevSlnSys);
        this.updatePSDCBKTaskRemainingTime(120);
        this.executePubSysDBModelTask(psDevSlnSys);
        this.updatePSDCBKTaskRemainingTime(60);
        this.executeInstallRTDataTask(psDevSlnSys);
        return null;
    }

    protected void executeInitSysModelTask(PSDevSlnSys psDevSlnSys) throws Exception {
        IPSSystem iPSSystem = null;
        String strPSDevSlnSysId = psDevSlnSys.getPSDevSlnSysId();
        IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(strPSDevSlnSysId);
        iPSSystem = iPSDevSlnSys.getPSSystem(false);
        PSSysDevBKTask psSysDevBKTask = new PSSysDevBKTask();
        psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u521d\u59cb\u5316\u7cfb\u7edf\u6a21\u578b"));
        psSysDevBKTask.setPSDevSlnSysId(strPSDevSlnSysId);
        psSysDevBKTask.setPSSysModelInstId(iPSDevSlnSys.getPSSysModelInstId());
        psSysDevBKTask.setTaskType("INITSYSMODEL");
        psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
        psSysDevBKTask.setPSSystemId(iPSSystem.getId());
        psSysDevBKTask.setPSSystemName(iPSSystem.getName());
        psSysDevBKTask.setTaskParam(iPSSystem.getId());
        psSysDevBKTask.setModelLevel(IPSSystem.LOADLEVEL_CODE);
        psSysDevBKTask.setUseRobotFlag(Integer.valueOf(0));
        psSysDevBKTask.setPSDCRobotId("AUTO");
        psSysDevBKTask.setPSDCRobotName("(\u81ea\u52a8)");
        psSysDevBKTask.setPSTaskServerId(this.getPSTaskServerEnv().getId());
        psSysDevBKTask.setPSTaskServerName(this.getPSTaskServerEnv().getName());
        PSSysDevBKTaskService psSysDevBKTaskService = (PSSysDevBKTaskService)ServiceGlobal.getService(PSSysDevBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)iPSDevSlnSys.getPSSysModelInstId()));
        psSysDevBKTaskService.create(psSysDevBKTask);
        this.runPSSysDevBKTask(iPSDevSlnSys, psSysDevBKTask);
    }

    protected void executePubSysDBModelTask(PSDevSlnSys psDevSlnSys) throws Exception {
        PSSysDevBKTaskService psSysDevBKTaskService;
        PSSysDevBKTask psSysDevBKTask;
        IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(psDevSlnSys.getPSDevSlnSysId());
        PSSystemDBCfgService psSystemDBCfgService = (PSSystemDBCfgService)ServiceGlobal.getService(PSSystemDBCfgService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)iPSDevSlnSys.getPSSysModelInstId()));
        IPSSystem iPSSystem = iPSDevSlnSys.getPSSystem(false);
        PSSystem psSystem = new PSSystem();
        psSystem.setPSSystemId(psDevSlnSys.getPSSystemId());
        ArrayList<PSSystemDBCfg> psSystemDBCfgList = psSystemDBCfgService.selectByPSSystem((PSSystemBase)psSystem);
        IPSDBDevInst jitPSDBDevInst = iPSSystem.getJITPSDBDevInst();
        for (PSSystemDBCfg psSystemDBConfig2 : psSystemDBCfgList) {
            if (StringHelper.IsNullOrEmpty((String)psSystemDBConfig2.getPSDBDevInstId()) && (jitPSDBDevInst == null || StringHelper.Compare((String)jitPSDBDevInst.getDBType(), (String)psSystemDBConfig2.getPSSystemDBCfgName(), (boolean)false) != 0)) continue;
            psSysDevBKTask = new PSSysDevBKTask();
            psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u91cd\u65b0\u53d1\u5e03\u7cfb\u7edf[%1$s]\u6570\u636e\u5e93\u6a21\u578b", (Object)psSystemDBConfig2.getPSSystemDBCfgName()));
            psSysDevBKTask.setPSDevSlnSysId(psDevSlnSys.getPSDevSlnSysId());
            psSysDevBKTask.setPSSysModelInstId(iPSDevSlnSys.getPSSysModelInstId());
            psSysDevBKTask.setTaskType("PUBSYSDBMODEL");
            psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
            psSysDevBKTask.setPSSystemId(iPSSystem.getId());
            psSysDevBKTask.setPSSystemName(iPSSystem.getName());
            psSysDevBKTask.setTaskParam(psSystemDBConfig2.getPSSystemDBCfgId());
            psSysDevBKTask.setModelLevel(IPSSystem.LOADLEVEL_CODE);
            psSysDevBKTask.setUseRobotFlag(Integer.valueOf(0));
            psSysDevBKTask.setPSDCRobotId("AUTO");
            psSysDevBKTask.setPSDCRobotName("(\u81ea\u52a8)");
            psSysDevBKTask.setPSTaskServerId(this.getPSTaskServerEnv().getId());
            psSysDevBKTask.setPSTaskServerName(this.getPSTaskServerEnv().getName());
            psSysDevBKTaskService = (PSSysDevBKTaskService)ServiceGlobal.getService(PSSysDevBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)iPSDevSlnSys.getPSSysModelInstId()));
            psSysDevBKTaskService.create(psSysDevBKTask);
            this.runPSSysDevBKTask(iPSDevSlnSys, psSysDevBKTask);
        }
        for (PSSystemDBCfg psSystemDBConfig2 : psSystemDBCfgList) {
            if (StringHelper.IsNullOrEmpty((String)psSystemDBConfig2.getPSDBDevInstId()) && (jitPSDBDevInst == null || StringHelper.Compare((String)jitPSDBDevInst.getDBType(), (String)psSystemDBConfig2.getPSSystemDBCfgName(), (boolean)false) != 0)) continue;
            psSysDevBKTask = new PSSysDevBKTask();
            psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u540c\u6b65\u5b50\u7cfb\u7edf[%1$s]\u6570\u636e\u5e93\u6a21\u578b", (Object)psSystemDBConfig2.getPSSystemDBCfgName()));
            psSysDevBKTask.setPSDevSlnSysId(psDevSlnSys.getPSDevSlnSysId());
            psSysDevBKTask.setPSSysModelInstId(iPSDevSlnSys.getPSSysModelInstId());
            psSysDevBKTask.setTaskType("SYNCSUBSYSDBMODEL");
            psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
            psSysDevBKTask.setPSSystemId(iPSSystem.getId());
            psSysDevBKTask.setPSSystemName(iPSSystem.getName());
            psSysDevBKTask.setTaskParam(psSystemDBConfig2.getPSSystemDBCfgId());
            psSysDevBKTask.setModelLevel(IPSSystem.LOADLEVEL_CODE);
            psSysDevBKTask.setUseRobotFlag(Integer.valueOf(0));
            psSysDevBKTask.setPSDCRobotId("AUTO");
            psSysDevBKTask.setPSDCRobotName("(\u81ea\u52a8)");
            psSysDevBKTask.setPSTaskServerId(this.getPSTaskServerEnv().getId());
            psSysDevBKTask.setPSTaskServerName(this.getPSTaskServerEnv().getName());
            psSysDevBKTaskService = (PSSysDevBKTaskService)ServiceGlobal.getService(PSSysDevBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)iPSDevSlnSys.getPSSysModelInstId()));
            psSysDevBKTaskService.create(psSysDevBKTask);
            this.runPSSysDevBKTask(iPSDevSlnSys, psSysDevBKTask);
        }
    }

    protected void executeInstallRTDataTask(PSDevSlnSys psDevSlnSys) throws Exception {
        IPSSystem iPSSystem = null;
        String strPSDevSlnSysId = psDevSlnSys.getPSDevSlnSysId();
        IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(strPSDevSlnSysId);
        iPSSystem = iPSDevSlnSys.getPSSystem(false);
        IPSDBDevInst jitPSDBDevInst = iPSSystem.getJITPSDBDevInst();
        IPSSystemDBConfig iPSSystemDBConfig = iPSSystem.getDefaultPSSystemDBConfig();
        if ((iPSSystemDBConfig == null || StringHelper.IsNullOrEmpty((String)iPSSystemDBConfig.getPSDBDevInstId())) && jitPSDBDevInst == null) {
            return;
        }
        PSSysDevBKTask psSysDevBKTask = new PSSysDevBKTask();
        psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u5b89\u88c5\u7cfb\u7edf\u8fd0\u884c\u6570\u636e"));
        psSysDevBKTask.setPSDevSlnSysId(strPSDevSlnSysId);
        psSysDevBKTask.setPSSysModelInstId(iPSDevSlnSys.getPSSysModelInstId());
        psSysDevBKTask.setTaskType("INSTALLRTDATA");
        psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
        psSysDevBKTask.setPSSystemId(iPSSystem.getId());
        psSysDevBKTask.setPSSystemName(iPSSystem.getName());
        psSysDevBKTask.setModelLevel(IPSSystem.LOADLEVEL_CODE);
        psSysDevBKTask.setUseRobotFlag(Integer.valueOf(0));
        psSysDevBKTask.setPSDCRobotId("AUTO");
        psSysDevBKTask.setPSDCRobotName("(\u81ea\u52a8)");
        psSysDevBKTask.setPSTaskServerId(this.getPSTaskServerEnv().getId());
        psSysDevBKTask.setPSTaskServerName(this.getPSTaskServerEnv().getName());
        PSSysDevBKTaskService psSysDevBKTaskService = (PSSysDevBKTaskService)ServiceGlobal.getService(PSSysDevBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)iPSDevSlnSys.getPSSysModelInstId()));
        psSysDevBKTaskService.create(psSysDevBKTask);
        this.runPSSysDevBKTask(iPSDevSlnSys, psSysDevBKTask);
    }
}
