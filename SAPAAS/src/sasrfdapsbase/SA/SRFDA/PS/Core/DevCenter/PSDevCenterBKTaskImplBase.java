/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.codelist.SysDevBKTaskStateCodeListModel
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDCBKTask
 *  net.ibizsys.pscore.srv.devcenter.service.PSDCBKTaskService
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSTSCmd
 *  net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysDevBKTask
 *  net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevBKTaskService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DevCenter;

import SA.SRFDA.PS.Core.DevCenter.IPSDevCenterBKTask;
import SA.SRFDA.PS.Core.DevCenter.IPSDevCenterBTType;
import SA.SRFDA.PS.Core.DevStudio.IPSBKTask;
import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskSessionContext;
import SA.SRFDA.PS.Core.DevStudio.PSBKTaskImplBase;
import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSTaskServerEnv;
import SA.SRFDA.PS.Core.JIT.Web.PSJITWebContext;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.Robot.IPSRobot;
import SA.SRFDA.PS.Core.Robot.IPSRobotWork;
import SA.SRFDA.PS.Core.Robot.IPSRobotWorkType;
import SA.SRFDA.PS.Core.Robot.PSRobotResult;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Vector;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.codelist.SysDevBKTaskStateCodeListModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCBKTask;
import net.ibizsys.pscore.srv.devcenter.service.PSDCBKTaskService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTSCmd;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysDevBKTask;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevBKTaskService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevCenterBKTaskImplBase
extends PSBKTaskImplBase
implements IPSDevCenterBKTask {
    protected SA.SRFDA.PS.Data.PSDCBKTask psDevCenterBKTask = null;
    private static final Log log = LogFactory.getLog(PSDevCenterBKTaskImplBase.class);
    private ArrayList<IPSDevCenterBKTask> psDevCenterBKTaskList = new ArrayList();
    private ArrayList<IPSRobotWork> psRobotWorkList = new ArrayList();
    private IPSDevCenterBKTask parentPSDevCenterBKTask = null;
    private String strPSTaskServerId = "";
    private String strPSDevCenterId = "";
    private Properties taskParams = null;
    private SA.SRFDA.PS.Data.PSSysDevBKTask psSysDevBKTask2 = null;
    protected HashMap<String, Integer> taskRemainingTimeMap = new HashMap();
    private boolean bUseRobot = false;
    private IPSDevCenterBTType iPSDevCenterBTType = null;
    private IPSRobot iPSRobot = null;
    private int nEnergy = 0;
    private PSRobotResult planPSRobotResult = null;
    private String strPlanPSRobotInfo = null;
    private Object objPSRobotLock = new Object();
    private IPSRobotWorkType iPSRobotWorkType = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDevCenterBKTask parentPSDevCenterBKTask, SA.SRFDA.PS.Data.PSDCBKTask psDevCenterBKTask) throws Exception {
        this.parentPSDevCenterBKTask = parentPSDevCenterBKTask;
        this.psDevCenterBKTask = psDevCenterBKTask;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psDevCenterBKTask.getPSDCBKTASKID());
        this.setName(psDevCenterBKTask.getPSDCBKTASKNAME());
        this.setPSObjectData(this.psDevCenterBKTask);
        this.strPSDevCenterId = this.psDevCenterBKTask.getPSDEVCENTERID();
        String strTaskParams = this.psDevCenterBKTask.getTASKPARAMS();
        if (!StringHelper.isNullOrEmpty((String)strTaskParams)) {
            this.taskParams = PropertiesHelper.load((String)strTaskParams);
        }
        this.strPSTaskServerId = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "TASKSERVERID", "");
        this.iPSDevCenterBTType = this.getPSModelStorage().getPSDevCenterBTType(this.getTaskType());
        this.iPSRobotWorkType = this.getPSModelStorage().getPSRobotWorkType(StringHelper.format((String)"DCBKTASK|%1$s", (Object)this.getTaskType()), true);
        this.bUseRobot = !this.psDevCenterBKTask.isUSEROBOTFLAGNull() ? this.psDevCenterBKTask.getUSEROBOTFLAG() : this.iPSDevCenterBTType.isUseRobot();
        log.info((Object)StringHelper.format((String)"\u521d\u59cb\u5316\u5e94\u7528\u4e2d\u5fc3\u540e\u53f0\u4efb\u52a1[%1$s][%2$s]", (Object)this.strPSDevCenterId, (Object)this.getName()));
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public IPSBKTask getParentPSBKTask() {
        return this.getParentPSDevCenterBKTask();
    }

    @Override
    public IPSDevCenterBKTask getParentPSDevCenterBKTask() {
        return this.parentPSDevCenterBKTask;
    }

    protected void prepareChildPSDevCenterBKTasks() throws Exception {
        Vector<SA.SRFDA.PS.Data.PSDCBKTask> psDevCenterBKTaskList = new Vector<SA.SRFDA.PS.Data.PSDCBKTask>();
        CallResult callResult = this.getPSModelHelper().getPSDevCenterBKTasks(this.getId(), psDevCenterBKTaskList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u5e94\u7528\u4e2d\u5fc3\u540e\u53f0\u4efb\u52a1\u5b50\u4efb\u52a1\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (SA.SRFDA.PS.Data.PSDCBKTask childPSDevCenterBKTask : psDevCenterBKTaskList) {
            IPSDevCenterBTType iPSDevCenterBTType = this.getPSModelStorage().getPSDevCenterBTType(childPSDevCenterBKTask.getTASKTYPE());
            IPSDevCenterBKTask iPSDevCenterBKTask = iPSDevCenterBTType.createPSDevCenterBKTask(childPSDevCenterBKTask);
            iPSDevCenterBKTask.init(this.getDAGlobalHelper(), this, childPSDevCenterBKTask);
            this.psDevCenterBKTaskList.add(iPSDevCenterBKTask);
        }
        this.psRobotWorkList.addAll(this.psDevCenterBKTaskList);
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public synchronized boolean run(IPSBKTaskSessionContext iPSBKTaskSessionContext) {
        if (PSJITWebContext.getInstance() != null) {
            PSJITWebContext.setCurrent(null);
        }
        this.setPSBKTaskSessionContext(iPSBKTaskSessionContext);
        try {
            PSDCBKTask psDevCenterBKTask = new PSDCBKTask();
            PSDCBKTaskService psDCBKTaskService = (PSDCBKTaskService)ServiceGlobal.getService(PSDCBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
            psDevCenterBKTask.setPSDCBKTaskId(this.psDevCenterBKTask.getPSDCBKTASKID());
            psDCBKTaskService.get((IEntity)psDevCenterBKTask);
            if (psDevCenterBKTask.getTaskState() != 10) {
                throw new Exception("\u4efb\u52a1\u72b6\u6001\u4e0d\u6b63\u786e\uff0c\u5fc5\u987b\u4e3a[\u5df2\u5efa\u7acb]");
            }
            psDevCenterBKTask.reset();
            psDevCenterBKTask.setPSDCBKTaskId(this.psDevCenterBKTask.getPSDCBKTASKID());
            psDevCenterBKTask.setTaskState(SysDevBKTaskStateCodeListModel.EXECUTING);
            if (PSTaskServerEnvImpl.getCurrent() != null) {
                psDevCenterBKTask.setPSTaskServerId(PSTaskServerEnvImpl.getCurrent().getId());
                psDevCenterBKTask.setPSTaskServerName(PSTaskServerEnvImpl.getCurrent().getName());
            }
            psDevCenterBKTask.setQueueInfo(null);
            psDevCenterBKTask.setBeginTime(new Timestamp(System.currentTimeMillis()));
            psDevCenterBKTask.set("SRF_PERSONID", (Object)"SYSTEM");
            psDevCenterBKTask.set("SRF_LOGINNAME", (Object)"SYSTEM");
            psDCBKTaskService.update((IEntity)psDevCenterBKTask);
            while (!this.isCancel()) {
                IPSDevCenterBKTask iPSDevCenterBKTask = null;
                ArrayList<IPSDevCenterBKTask> arrayList = this.psDevCenterBKTaskList;
                synchronized (arrayList) {
                    if (this.psDevCenterBKTaskList.size() > 0) {
                        iPSDevCenterBKTask = this.psDevCenterBKTaskList.remove(0);
                    }
                }
                if (iPSDevCenterBKTask == null) break;
                if (iPSDevCenterBKTask.run(this.getPSBKTaskSessionContext())) continue;
                try {
                    if (this.getPSRobot() != null) {
                        this.getPSRobot().closePSRobotWork(iPSDevCenterBKTask, false);
                    }
                }
                catch (Exception ex) {
                    log.error((Object)ex);
                }
                this.cancel(false, StringHelper.format((String)"\u4efb\u52a1[%1$s]\u6267\u884c\u5931\u8d25", (Object)iPSDevCenterBKTask.getName()));
                return false;
            }
            if (this.isCancel()) {
                return false;
            }
            String strResultInfo = this.onRun();
            try {
                if (this.getPSRobot() != null) {
                    this.getPSRobot().closePSRobotWork(this, false);
                }
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
            psDevCenterBKTask.reset();
            if (!StringHelper.isNullOrEmpty((String)strResultInfo)) {
                if (strResultInfo.length() > 99999) {
                    strResultInfo = String.valueOf(strResultInfo.substring(0, 99999)) + "...";
                }
                psDevCenterBKTask.setFullResultInfo(strResultInfo);
                psDevCenterBKTask.setResultInfo(strResultInfo);
                if (strResultInfo.length() > 2000) {
                    psDevCenterBKTask.setResultInfo(String.valueOf(strResultInfo.substring(0, 1900)) + "...");
                }
            }
            psDevCenterBKTask.setPSDCBKTaskId(this.psDevCenterBKTask.getPSDCBKTASKID());
            psDevCenterBKTask.setTaskState(SysDevBKTaskStateCodeListModel.FINISHED);
            psDevCenterBKTask.setEndTime(new Timestamp(System.currentTimeMillis()));
            psDevCenterBKTask.set("SRF_PERSONID", (Object)"SYSTEM");
            psDevCenterBKTask.set("SRF_LOGINNAME", (Object)"SYSTEM");
            psDCBKTaskService = (PSDCBKTaskService)ServiceGlobal.getService(PSDCBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
            psDCBKTaskService.update((IEntity)psDevCenterBKTask);
            return true;
        }
        catch (Exception ex) {
            log.error((Object)ex);
            try {
                if (this.getPSRobot() != null) {
                    this.getPSRobot().closePSRobotWork(this, false);
                }
            }
            catch (Exception ex2) {
                log.error((Object)ex2);
            }
            try {
                PSDCBKTask psDevCenterBKTask = new PSDCBKTask();
                PSDCBKTaskService psDCBKTaskService = (PSDCBKTaskService)ServiceGlobal.getService(PSDCBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
                psDevCenterBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CANCELLED);
                StringBuilderEx sb = new StringBuilderEx();
                sb.append(ex.getMessage());
                String strResultInfo = "";
                strResultInfo = sb.toString();
                if (!StringHelper.isNullOrEmpty((String)strResultInfo)) {
                    if (strResultInfo.length() > 99999) {
                        strResultInfo = String.valueOf(strResultInfo.substring(0, 99999)) + "...";
                    }
                    psDevCenterBKTask.setFullResultInfo(strResultInfo);
                    psDevCenterBKTask.setResultInfo(strResultInfo);
                    if (strResultInfo.length() > 2000) {
                        psDevCenterBKTask.setResultInfo(String.valueOf(strResultInfo.substring(0, 1900)) + "...");
                    }
                }
                psDevCenterBKTask.setEndTime(new Timestamp(System.currentTimeMillis()));
                psDevCenterBKTask.setPSDCBKTaskId(this.psDevCenterBKTask.getPSDCBKTASKID());
                psDevCenterBKTask.set("SRF_PERSONID", (Object)"SYSTEM");
                psDevCenterBKTask.set("SRF_LOGINNAME", (Object)"SYSTEM");
                psDCBKTaskService.update((IEntity)psDevCenterBKTask);
                return false;
            }
            catch (Exception ex2) {
                log.error((Object)ex2);
            }
            return false;
        }
    }

    protected void updatePSDCBKTaskStep(String strStepInfo) throws Exception {
        this.updatePSDCBKTaskStep(strStepInfo, -1, -1);
    }

    protected void updatePSDCBKTaskStep(String strStepInfo, int nRemainingTime) throws Exception {
        this.updatePSDCBKTaskStep(strStepInfo, nRemainingTime, -1);
    }

    protected void updatePSDCBKTaskStep(String strStepInfo, int nRemainingTime, int nTotalTime) throws Exception {
        PSDCBKTask psDevCenterBKTask = new PSDCBKTask();
        PSDCBKTaskService psDCBKTaskService = (PSDCBKTaskService)ServiceGlobal.getService(PSDCBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        psDevCenterBKTask.setStepInfo(strStepInfo);
        if (nRemainingTime >= 0) {
            psDevCenterBKTask.setRemainingTime(Integer.valueOf(nRemainingTime));
            psDevCenterBKTask.setLastCalcTime(new Timestamp(new Date().getTime()));
        }
        if (nTotalTime != -1) {
            psDevCenterBKTask.setTotalTime(Integer.valueOf(nTotalTime));
        }
        psDevCenterBKTask.setPSDCBKTaskId(this.psDevCenterBKTask.getPSDCBKTASKID());
        psDevCenterBKTask.set("SRF_PERSONID", (Object)"SYSTEM");
        psDevCenterBKTask.set("SRF_LOGINNAME", (Object)"SYSTEM");
        psDCBKTaskService.update((IEntity)psDevCenterBKTask);
    }

    protected void updatePSDCBKTaskRemainingTime(int nRemainingTime) throws Exception {
        PSDCBKTask psDevCenterBKTask = new PSDCBKTask();
        PSDCBKTaskService psDCBKTaskService = (PSDCBKTaskService)ServiceGlobal.getService(PSDCBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        if (nRemainingTime >= 0) {
            psDevCenterBKTask.setRemainingTime(Integer.valueOf(nRemainingTime));
            psDevCenterBKTask.setLastCalcTime(new Timestamp(new Date().getTime()));
        }
        psDevCenterBKTask.setPSDCBKTaskId(this.psDevCenterBKTask.getPSDCBKTASKID());
        psDevCenterBKTask.set("SRF_PERSONID", (Object)"SYSTEM");
        psDevCenterBKTask.set("SRF_LOGINNAME", (Object)"SYSTEM");
        psDCBKTaskService.update((IEntity)psDevCenterBKTask);
    }

    @Override
    protected String onRun() throws Exception {
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected synchronized void onCancel(boolean bUserCancel, String strReason) {
        ArrayList<IPSDevCenterBKTask> arrayList = this.psDevCenterBKTaskList;
        synchronized (arrayList) {
            while (this.psDevCenterBKTaskList.size() > 0) {
                IPSDevCenterBKTask iPSDevCenterBKTask = this.psDevCenterBKTaskList.remove(0);
                iPSDevCenterBKTask.cancel(bUserCancel, strReason);
            }
        }
        try {
            if (this.getPSRobot() != null) {
                this.getPSRobot().closePSRobotWork(this, true);
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        try {
            PSDCBKTask psDevCenterBKTask = new PSDCBKTask();
            PSDCBKTaskService psDCBKTaskService = (PSDCBKTaskService)ServiceGlobal.getService(PSDCBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
            psDevCenterBKTask.setPSDCBKTaskId(this.psDevCenterBKTask.getPSDCBKTASKID());
            psDCBKTaskService.get((IEntity)psDevCenterBKTask);
            if (psDevCenterBKTask.getTaskState() != 40 && psDevCenterBKTask.getTaskState() != 30) {
                psDevCenterBKTask.reset();
                psDevCenterBKTask.setPSDCBKTaskId(this.psDevCenterBKTask.getPSDCBKTASKID());
                psDevCenterBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CANCELLED);
                psDevCenterBKTask.setQueueInfo(null);
                psDevCenterBKTask.setResultInfo(strReason);
                psDCBKTaskService.update((IEntity)psDevCenterBKTask, false);
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    public String getTaskType() {
        return this.psDevCenterBKTask.getTASKTYPE();
    }

    @Override
    public String getTaskParam() {
        return this.psDevCenterBKTask.getTASKPARAM();
    }

    @Override
    public String getTaskParam2() {
        return this.psDevCenterBKTask.getTASKPARAM2();
    }

    @Override
    public String getTaskParam3() {
        return this.psDevCenterBKTask.getTASKPARAM3();
    }

    @Override
    public String getTaskParam4() {
        return this.psDevCenterBKTask.getTASKPARAM4();
    }

    @Override
    public Object getPSObjectParam(String strKey, Object objDefault) {
        if (this.getPSObjectData() == null) {
            return objDefault;
        }
        Object objValue = this.getPSObjectData().getParamValue(strKey);
        if (objValue == null) {
            return objDefault;
        }
        return objValue;
    }

    public Object getTaskParam(String strParamName) {
        if (this.taskParams == null) {
            return null;
        }
        return PropertiesHelper.getProperty((Properties)this.taskParams, (String)strParamName);
    }

    public boolean containsTaskParam(String strParamName) {
        if (this.taskParams == null) {
            return false;
        }
        return PropertiesHelper.getProperty((Properties)this.taskParams, (String)strParamName, null) != null;
    }

    public String getTaskParam(String strParamName, String strDefault) {
        return PropertiesHelper.getProperty((Properties)this.taskParams, (String)strParamName, (String)strDefault);
    }

    public boolean getTaskParam(String strParamName, boolean bDefault) {
        return PropertiesHelper.getProperty((Properties)this.taskParams, (String)strParamName, (boolean)bDefault);
    }

    public int getTaskParam(String strParamName, int nDefault) {
        return PropertiesHelper.getProperty((Properties)this.taskParams, (String)strParamName, (int)nDefault);
    }

    public Enumeration<Object> getTaskParamNames() {
        if (this.taskParams == null) {
            return null;
        }
        return this.taskParams.keys();
    }

    protected void runPSSysDevBKTask(IPSDevSlnSys iPSDevSlnSys, PSSysDevBKTask psSysDevBKTask) throws Exception {
        PSSysDevBKTaskService psSysDevBKTaskService = (PSSysDevBKTaskService)ServiceGlobal.getService(PSSysDevBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)iPSDevSlnSys.getPSSysModelInstId()));
        this.psSysDevBKTask2 = new SA.SRFDA.PS.Data.PSSysDevBKTask();
        PSDEDataCtrl.convertEntity((IEntity)psSysDevBKTask, this.psSysDevBKTask2);
        this.updatePSDCBKTaskStep(psSysDevBKTask.getPSSysDevBKTaskName());
        this.getPSModelStorage().getPSSysDevBKTaskGlobal().addPSSysDevBKTask(this.psSysDevBKTask2);
        String strLastPSSysDevBKTaskId = null;
        while (true) {
            psSysDevBKTaskService.get((IEntity)psSysDevBKTask);
            if (psSysDevBKTask.getTaskState() == 30) break;
            if (psSysDevBKTask.getTaskState() == 40) {
                throw new Exception(psSysDevBKTask.getResultInfo());
            }
            PSSysDevBKTask childPSSysDevBKTask = new PSSysDevBKTask();
            childPSSysDevBKTask.setPPSSysDevBKTaskId(psSysDevBKTask.getPSSysDevBKTaskId());
            childPSSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.EXECUTING);
            if (psSysDevBKTaskService.select((IEntity)childPSSysDevBKTask, true) && StringHelper.compare((String)childPSSysDevBKTask.getPSSysDevBKTaskId(), strLastPSSysDevBKTaskId, (boolean)false) != 0) {
                int nRemainingTime = -1;
                if (this.taskRemainingTimeMap.containsKey(childPSSysDevBKTask.getPSSysDevBKTaskId())) {
                    nRemainingTime = this.taskRemainingTimeMap.get(childPSSysDevBKTask.getPSSysDevBKTaskId());
                }
                if (StringHelper.isNullOrEmpty(strLastPSSysDevBKTaskId)) {
                    this.updatePSDCBKTaskStep(childPSSysDevBKTask.getPSSysDevBKTaskName(), nRemainingTime, nRemainingTime);
                } else {
                    this.updatePSDCBKTaskStep(childPSSysDevBKTask.getPSSysDevBKTaskName(), nRemainingTime);
                }
                strLastPSSysDevBKTaskId = childPSSysDevBKTask.getPSSysDevBKTaskId();
            }
            Thread.sleep(1000L);
        }
        this.psSysDevBKTask2 = null;
        this.updatePSDCBKTaskStep("", 0);
    }

    protected String getPSDevCenterId() {
        return this.strPSDevCenterId;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setPSRobot(IPSRobot iPSRobot, int nEnergy) throws Exception {
        Object object = this.objPSRobotLock;
        synchronized (object) {
            this.iPSRobot = iPSRobot;
            this.nEnergy = nEnergy;
            if (this.iPSRobot != null) {
                try {
                    PSDCBKTask psDevCenterBKTask = new PSDCBKTask();
                    PSDCBKTaskService psDCBKTaskService = (PSDCBKTaskService)ServiceGlobal.getService(PSDCBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
                    psDevCenterBKTask.setPSDCBKTaskId(this.psDevCenterBKTask.getPSDCBKTASKID());
                    psDevCenterBKTask.setPSDCRobotId(this.iPSRobot.getId());
                    psDevCenterBKTask.setPSDCRobotName(this.iPSRobot.getName());
                    if (this.nEnergy > 0) {
                        psDevCenterBKTask.setPSDCRobotName(StringHelper.format((String)"%1$s,\u8017\u80fd %2$smAh", (Object)this.iPSRobot.getName(), (Object)this.nEnergy));
                    }
                    psDCBKTaskService.update((IEntity)psDevCenterBKTask, false);
                }
                catch (Exception ex) {
                    log.error((Object)ex);
                }
                this.setPlanPSRobot(null);
            }
        }
    }

    @Override
    public IPSRobotWorkType getPSRobotWorkType() {
        return this.iPSRobotWorkType;
    }

    @Override
    public Iterator<IPSRobotWork> getPSRobotWorks() {
        return this.psRobotWorkList.iterator();
    }

    @Override
    public int getEnergy() {
        int nEnergy = this.nEnergy;
        return nEnergy;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setPlanPSRobot(PSRobotResult psRobotResult) throws Exception {
        IPSRobot iPSRobot;
        boolean bUpdateRobotInfo = false;
        Object object = this.objPSRobotLock;
        synchronized (object) {
            this.planPSRobotResult = psRobotResult;
            String strPlanPSRobotInfo = "";
            strPlanPSRobotInfo = psRobotResult != null ? this.getPlanPSRobotInfo(this.planPSRobotResult) : "\u7b49\u5f85\u673a\u5668\u4eba";
            if (StringHelper.compare((String)strPlanPSRobotInfo, (String)this.strPlanPSRobotInfo, (boolean)false) != 0) {
                this.strPlanPSRobotInfo = strPlanPSRobotInfo;
                bUpdateRobotInfo = true;
            }
        }
        if (bUpdateRobotInfo && (iPSRobot = this.getPSRobot()) == null) {
            try {
                PSDCBKTask psDevCenterBKTask = new PSDCBKTask();
                PSDCBKTaskService psDCBKTaskService = (PSDCBKTaskService)ServiceGlobal.getService(PSDCBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
                psDevCenterBKTask.setPSDCBKTaskId(this.psDevCenterBKTask.getPSDCBKTASKID());
                if (psRobotResult != null) {
                    psDevCenterBKTask.setPSDCRobotId(psRobotResult.getPSRobot().getId());
                    psDevCenterBKTask.setPSDCRobotName(StringHelper.format((String)"%2$s,\u9884\u8ba1\u5f00\u59cb[%1$tm-%1$td %1$tH:%1$tM:%1$tS]", (Object)psRobotResult.getPlanTime(), (Object)psRobotResult.getPSRobot().getName()));
                } else {
                    psDevCenterBKTask.setPSDCRobotId("WAITING");
                    psDevCenterBKTask.setPSDCRobotName(this.strPlanPSRobotInfo);
                }
                psDCBKTaskService.update((IEntity)psDevCenterBKTask, false);
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
        }
    }

    protected String getPlanPSRobotInfo(PSRobotResult psRobotResult) throws Exception {
        if (psRobotResult.getPlanTime() != null) {
            return StringHelper.format((String)"%2$s,\u8ba1\u5212\u5f00\u59cb[%1$tY-%1$tm-%1$td %1$tH:%1$tM]", (Object)psRobotResult.getPlanTime(), (Object)psRobotResult.getPSRobot().getName());
        }
        return StringHelper.format((String)"%1$s", (Object)psRobotResult.getPSRobot().getName());
    }

    @Override
    public boolean isUseRobot() {
        return this.bUseRobot;
    }

    @Override
    public IPSRobot getPSRobot() {
        IPSRobot iPSRobot = this.iPSRobot;
        return iPSRobot;
    }

    @Override
    protected PSTSCmd createPSTSCmd() throws Exception {
        return null;
    }

    @Override
    protected void onUpdateQueueInfo(String strQueueInfo) {
        try {
            PSDCBKTask psDevCenterBKTask = new PSDCBKTask();
            PSDCBKTaskService psDCBKTaskService = (PSDCBKTaskService)ServiceGlobal.getService(PSDCBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
            psDevCenterBKTask.setPSDCBKTaskId(this.psDevCenterBKTask.getPSDCBKTASKID());
            psDevCenterBKTask.setQueueInfo(strQueueInfo);
            psDCBKTaskService.update((IEntity)psDevCenterBKTask, false);
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    protected final IPSTaskServerEnv getPSTaskServerEnv() throws Exception {
        return this.getPSModelStorage().getPSTaskServerEnv();
    }

    @Override
    public String getCreateMan() {
        return this.psDevCenterBKTask.getCREATEMAN();
    }
}

