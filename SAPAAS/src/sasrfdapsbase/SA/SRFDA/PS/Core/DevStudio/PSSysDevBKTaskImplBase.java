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
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSTSCmd
 *  net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysDevBKTask
 *  net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevBKTaskService
 *  net.ibizsys.pscore.srv.util.PSStudioConsoleHelper
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.PS.Core.Deploy.IPSSysRunSession;
import SA.SRFDA.PS.Core.DevCenter.IPSDevCenter;
import SA.SRFDA.PS.Core.DevStudio.IPSBKTask;
import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskSessionContext;
import SA.SRFDA.PS.Core.DevStudio.IPSSysDevBKTask;
import SA.SRFDA.PS.Core.DevStudio.IPSSysDevBKTaskSessionContext;
import SA.SRFDA.PS.Core.DevStudio.IPSSysDevBTType;
import SA.SRFDA.PS.Core.DevStudio.PSBKTaskImplBase;
import SA.SRFDA.PS.Core.DevStudio.PSSysBTException;
import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSModelObjectLogger;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSTaskServerEnv;
import SA.SRFDA.PS.Core.JIT.Web.PSJITWebContext;
import SA.SRFDA.PS.Core.Log.IPSLogItem;
import SA.SRFDA.PS.Core.Log.PSLogItemImpl;
import SA.SRFDA.PS.Core.PSModelObjectLoggerImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysPubRuntime;
import SA.SRFDA.PS.Core.Robot.IPSRobot;
import SA.SRFDA.PS.Core.Robot.IPSRobotWork;
import SA.SRFDA.PS.Core.Robot.IPSRobotWorkType;
import SA.SRFDA.PS.Core.Robot.PSRobotResult;
import SA.SRFDA.PS.Core.Util.FileWriterHelper2;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.codelist.SysDevBKTaskStateCodeListModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTSCmd;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysDevBKTask;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevBKTaskService;
import net.ibizsys.pscore.srv.util.PSStudioConsoleHelper;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDevBKTaskImplBase
extends PSBKTaskImplBase
implements IPSSysDevBKTask {
    protected SA.SRFDA.PS.Data.PSSysDevBKTask psSysDevBKTask = null;
    private static final Log log = LogFactory.getLog(PSSysDevBKTaskImplBase.class);
    private ArrayList<IPSSysDevBKTask> psSysDevBKTaskList = new ArrayList();
    private ArrayList<IPSRobotWork> psRobotWorkList = new ArrayList();
    private IPSSysDevBKTask parentPSSysDevBKTask = null;
    private String strPSTaskServerId = "";
    private String strPSDevSlnSysId = "";
    private String strPSDynaInstId = "";
    private String strPSSystemId = "";
    private IPSRobot iPSRobot = null;
    private int nEnergy = 0;
    private PSRobotResult planPSRobotResult = null;
    private String strPlanPSRobotInfo = null;
    private IPSRobotWorkType iPSRobotWorkType = null;
    private IPSSysDevBTType iPSSysDevBTType = null;
    private boolean bUseRobot = true;
    private Object objPSRobotLock = new Object();
    private IPSSysDevBKTask activePSSysDevBKTask = null;
    private IPSModelObjectLogger iPSModelObjectLogger = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysDevBKTask parentPSSysDevBKTask, SA.SRFDA.PS.Data.PSSysDevBKTask psSysDevBKTask) throws Exception {
        this.parentPSSysDevBKTask = parentPSSysDevBKTask;
        this.psSysDevBKTask = psSysDevBKTask;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psSysDevBKTask.getPSSYSDEVBKTASKID());
        this.setName(psSysDevBKTask.getPSSYSDEVBKTASKNAME());
        this.setPSObjectData(this.psSysDevBKTask);
        this.strPSTaskServerId = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "TASKSERVERID", "");
        this.strPSDevSlnSysId = psSysDevBKTask.getPSDEVSLNSYSID();
        this.strPSDynaInstId = psSysDevBKTask.getPSDYNAINSTID();
        this.strPSSystemId = psSysDevBKTask.getPSSYSTEMID();
        this.iPSSysDevBTType = this.getPSModelStorage().getPSSysDevBTType(this.getTaskType());
        this.iPSRobotWorkType = this.getPSModelStorage().getPSRobotWorkType(StringHelper.format((String)"SYSBKTASK|%1$s", (Object)psSysDevBKTask.getTASKTYPE()), true);
        this.bUseRobot = !this.psSysDevBKTask.isUSEROBOTFLAGNull() ? this.psSysDevBKTask.getUSEROBOTFLAG() : this.iPSSysDevBTType.isUseRobot();
        log.info((Object)StringHelper.format((String)"\u521d\u59cb\u5316\u540e\u53f0\u5f00\u53d1\u4efb\u52a1[%1$s][%2$s]", (Object)this.strPSDevSlnSysId, (Object)this.getName()));
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.prepareChildPSSysDevBKTasks();
    }

    @Override
    public IPSBKTask getParentPSBKTask() {
        return this.parentPSSysDevBKTask;
    }

    @Override
    public IPSSysDevBKTask getParentPSSysDevBKTask() {
        return this.parentPSSysDevBKTask;
    }

    @Override
    public IPSSysDevBKTask getRootPSSysDevBKTask() {
        if (this.getParentPSSysDevBKTask() == null) {
            return this;
        }
        return this.getParentPSSysDevBKTask().getRootPSSysDevBKTask();
    }

    protected void prepareChildPSSysDevBKTasks() throws Exception {
        Vector<SA.SRFDA.PS.Data.PSSysDevBKTask> psSysDevBKTaskList = new Vector<SA.SRFDA.PS.Data.PSSysDevBKTask>();
        CallResult callResult = this.getPSModelHelper().getPSSysDevBKTasks(this.getId(), psSysDevBKTaskList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u7cfb\u7edf\u5f00\u53d1\u540e\u53f0\u4efb\u52a1\u5b50\u4efb\u52a1\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (SA.SRFDA.PS.Data.PSSysDevBKTask childPSSysDevBKTask : psSysDevBKTaskList) {
            childPSSysDevBKTask.setPSDYNAINSTID(this.psSysDevBKTask.getPSDYNAINSTID());
            IPSSysDevBTType iPSSysDevBTType = this.getPSModelStorage().getPSSysDevBTType(childPSSysDevBKTask.getTASKTYPE());
            IPSSysDevBKTask iPSSysDevBKTask = iPSSysDevBTType.createPSSysDevBKTask(childPSSysDevBKTask);
            iPSSysDevBKTask.init(this.getDAGlobalHelper(), this, childPSSysDevBKTask);
            this.psSysDevBKTaskList.add(iPSSysDevBKTask);
        }
        this.psRobotWorkList.addAll(this.psSysDevBKTaskList);
    }

    @Override
    public String getPSSysModelInstId() {
        return this.psSysDevBKTask.getPSSYSMODELINSTID();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public boolean run(IPSBKTaskSessionContext iPSBKTaskSessionContext) {
        if (PSJITWebContext.getInstance() != null) {
            PSJITWebContext.setCurrent(null);
        }
        this.setPSBKTaskSessionContext(iPSBKTaskSessionContext);
        try {
            PSSysDevBKTask psSysDevBKTask = new PSSysDevBKTask();
            PSSysDevBKTaskService psSysDevBKTaskService = (PSSysDevBKTaskService)ServiceGlobal.getService(PSSysDevBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
            psSysDevBKTask.setPSSysDevBKTaskId(this.psSysDevBKTask.getPSSYSDEVBKTASKID());
            psSysDevBKTaskService.get((IEntity)psSysDevBKTask);
            if (psSysDevBKTask.getTaskState() != 10) {
                throw new Exception("\u4efb\u52a1\u72b6\u6001\u4e0d\u6b63\u786e\uff0c\u5fc5\u987b\u4e3a[\u5df2\u5efa\u7acb]");
            }
            psSysDevBKTask.reset();
            psSysDevBKTask.setPSSysDevBKTaskId(this.psSysDevBKTask.getPSSYSDEVBKTASKID());
            psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.EXECUTING);
            psSysDevBKTask.setQueueInfo(null);
            psSysDevBKTask.setBeginTime(new Timestamp(System.currentTimeMillis()));
            psSysDevBKTaskService.update((IEntity)psSysDevBKTask, false);
            if (PSStudioConsoleHelper.getCurrent() != null) {
                PSStudioConsoleHelper.getCurrent().sendConsole(this.getPSDSConsoleId(), StringHelper.format((String)"[\u5f00\u59cb\u6267\u884c] %1$s%2$s", (Object)this.getTaskLevelPadding(), (Object)this.getName()));
            }
            this.onBeforeRun();
            while (!this.isCancel()) {
                IPSSysDevBKTask iPSSysDevBKTask = null;
                ArrayList<IPSSysDevBKTask> arrayList = this.psSysDevBKTaskList;
                synchronized (arrayList) {
                    if (this.psSysDevBKTaskList.size() > 0) {
                        iPSSysDevBKTask = this.psSysDevBKTaskList.remove(0);
                    }
                    this.activePSSysDevBKTask = iPSSysDevBKTask;
                }
                if (iPSSysDevBKTask == null) break;
                if (iPSSysDevBKTask.run(this.getPSBKTaskSessionContext())) continue;
                this.activePSSysDevBKTask = null;
                try {
                    if (this.getPSRobot() != null) {
                        this.getPSRobot().closePSRobotWork(iPSSysDevBKTask, false);
                    }
                }
                catch (Exception ex) {
                    log.error((Object)ex);
                }
                this.cancel(false, StringHelper.format((String)"\u4efb\u52a1[%1$s]\u6267\u884c\u5931\u8d25", (Object)iPSSysDevBKTask.getName()));
                return false;
            }
            if (this.isCancel()) {
                return false;
            }
            if (this.getPSModelObjectLogger() == null) {
                IPSDevCenter iPSDevCenter = null;
                if (iPSBKTaskSessionContext instanceof IPSSysDevBKTaskSessionContext) {
                    iPSDevCenter = ((IPSSysDevBKTaskSessionContext)iPSBKTaskSessionContext).getPSDevCenter();
                }
                if (iPSDevCenter != null) {
                    this.iPSModelObjectLogger = new PSModelObjectLoggerImpl(this, iPSDevCenter.getDomainName(), this.getName(), 99999999);
                }
            }
            this.getPSModelObjectLogger();
            String strResultInfo = this.onRun();
            StringBuilderEx sb = new StringBuilderEx();
            if (!StringHelper.isNullOrEmpty((String)strResultInfo)) {
                sb.append("%1$s", (Object)strResultInfo);
            }
            if (this.getPSLogItemList().size() > 0) {
                if (!StringHelper.isNullOrEmpty((String)strResultInfo)) {
                    sb.append("\r\n");
                }
                for (IPSLogItem iPSLogItem : this.getPSLogItemList()) {
                    sb.append("%1$s\r\n", (Object)PSLogItemImpl.toString(iPSLogItem));
                }
            }
            strResultInfo = sb.toString();
            try {
                if (this.getPSRobot() != null) {
                    this.getPSRobot().closePSRobotWork(this, false);
                }
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
            psSysDevBKTask.reset();
            if (!StringHelper.isNullOrEmpty((String)strResultInfo)) {
                if (strResultInfo.length() > 99999) {
                    strResultInfo = String.valueOf(strResultInfo.substring(0, 99999)) + "...";
                }
                psSysDevBKTask.setFullResultInfo(strResultInfo);
                psSysDevBKTask.setResultInfo(strResultInfo);
                if (strResultInfo.length() > 2000) {
                    psSysDevBKTask.setResultInfo(String.valueOf(strResultInfo.substring(0, 1900)) + "...");
                }
            }
            psSysDevBKTask.setPSSysDevBKTaskId(this.psSysDevBKTask.getPSSYSDEVBKTASKID());
            psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.FINISHED);
            psSysDevBKTask.setQueueInfo(null);
            psSysDevBKTask.setEndTime(new Timestamp(System.currentTimeMillis()));
            psSysDevBKTaskService = (PSSysDevBKTaskService)ServiceGlobal.getService(PSSysDevBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
            psSysDevBKTaskService.update((IEntity)psSysDevBKTask, false);
            if (PSStudioConsoleHelper.getCurrent() == null) return true;
            PSStudioConsoleHelper.getCurrent().sendConsole(this.getPSDSConsoleId(), PSStudioConsoleHelper.getContent((String)StringHelper.format((String)"[\u7ed3\u675f\u6267\u884c] %1$s%2$s", (Object)this.getTaskLevelPadding(), (Object)this.getName()), (int)34));
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
                ArrayList<IPSSysDevBKTask> ex2 = this.psSysDevBKTaskList;
                synchronized (ex2) {
                    while (this.psSysDevBKTaskList.size() > 0) {
                        IPSSysDevBKTask iPSSysDevBKTask = this.psSysDevBKTaskList.remove(0);
                        iPSSysDevBKTask.cancel(true, null);
                    }
                }
                PSSysDevBKTask psSysDevBKTask = new PSSysDevBKTask();
                PSSysDevBKTaskService psSysDevBKTaskService = (PSSysDevBKTaskService)ServiceGlobal.getService(PSSysDevBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
                psSysDevBKTask.setPSSysDevBKTaskId(this.psSysDevBKTask.getPSSYSDEVBKTASKID());
                psSysDevBKTaskService.get((IEntity)psSysDevBKTask);
                if (psSysDevBKTask.getTaskState() == 40) return false;
                if (psSysDevBKTask.getTaskState() == 30) return false;
                psSysDevBKTask.reset();
                psSysDevBKTask.setPSSysDevBKTaskId(this.psSysDevBKTask.getPSSYSDEVBKTASKID());
                psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CANCELLED);
                psSysDevBKTask.setQueueInfo(null);
                StringBuilderEx sb = new StringBuilderEx();
                String strResultInfo = "";
                if (ex instanceof PSSysBTException) {
                    PSSysBTException psSysBTException = (PSSysBTException)ex;
                    switch (psSysBTException.getErrorCode()) {
                        case 5: {
                            sb.append(psSysBTException.getMessage());
                            break;
                        }
                        default: {
                            sb.append(psSysBTException.getMessage());
                            break;
                        }
                    }
                } else {
                    sb.append(ex.getMessage());
                }
                if (this.getPSLogItemList().size() > 0) {
                    sb.append("\r\n");
                    for (IPSLogItem iPSLogItem : this.getPSLogItemList()) {
                        sb.append("%1$s\r\n", (Object)PSLogItemImpl.toString(iPSLogItem));
                    }
                }
                strResultInfo = sb.toString();
                if (PSStudioConsoleHelper.getCurrent() != null) {
                    String strContent = PSStudioConsoleHelper.getContent((String)StringHelper.format((String)"[\u6267\u884c\u9519\u8bef] %1$s", (Object)this.getName()), (int)31, (int)-1, (int)1);
                    if (!StringHelper.isNullOrEmpty((String)strResultInfo)) {
                        strContent = String.valueOf(strContent) + "\r\n";
                        strContent = String.valueOf(strContent) + PSStudioConsoleHelper.getContent((String)strResultInfo, (int)31);
                    }
                    PSStudioConsoleHelper.getCurrent().sendConsole(this.getPSDSConsoleId(), strContent);
                }
                if (!StringHelper.isNullOrEmpty((String)strResultInfo)) {
                    if (strResultInfo.length() > 99999) {
                        strResultInfo = String.valueOf(strResultInfo.substring(0, 99999)) + "...";
                    }
                    psSysDevBKTask.setFullResultInfo(strResultInfo);
                    psSysDevBKTask.setResultInfo(strResultInfo);
                    if (strResultInfo.length() > 2000) {
                        psSysDevBKTask.setResultInfo(String.valueOf(strResultInfo.substring(0, 1900)) + "...");
                    }
                }
                psSysDevBKTask.setEndTime(new Timestamp(System.currentTimeMillis()));
                psSysDevBKTask.setPSSysDevBKTaskId(this.psSysDevBKTask.getPSSYSDEVBKTASKID());
                psSysDevBKTaskService.update((IEntity)psSysDevBKTask, false);
                return false;
            }
            catch (Exception ex2) {
                log.error((Object)ex2);
            }
        }
        return false;
    }

    protected void onBeforeRun() throws Exception {
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
        IPSSysDevBKTask curPSSysDevBKTask = this.activePSSysDevBKTask;
        if (curPSSysDevBKTask != null) {
            curPSSysDevBKTask.cancel(bUserCancel, strReason);
        }
        ArrayList<IPSSysDevBKTask> arrayList = this.psSysDevBKTaskList;
        synchronized (arrayList) {
            while (this.psSysDevBKTaskList.size() > 0) {
                IPSSysDevBKTask iPSSysDevBKTask = this.psSysDevBKTaskList.remove(0);
                iPSSysDevBKTask.cancel(bUserCancel, strReason);
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
            PSSysDevBKTask psSysDevBKTask = new PSSysDevBKTask();
            PSSysDevBKTaskService psSysDevBKTaskService = (PSSysDevBKTaskService)ServiceGlobal.getService(PSSysDevBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
            psSysDevBKTask.setPSSysDevBKTaskId(this.psSysDevBKTask.getPSSYSDEVBKTASKID());
            psSysDevBKTaskService.get((IEntity)psSysDevBKTask);
            if (psSysDevBKTask.getTaskState() != 40 && psSysDevBKTask.getTaskState() != 30) {
                psSysDevBKTask.reset();
                psSysDevBKTask.setPSSysDevBKTaskId(this.psSysDevBKTask.getPSSYSDEVBKTASKID());
                psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CANCELLED);
                psSysDevBKTask.setQueueInfo(null);
                psSysDevBKTask.setResultInfo(strReason);
                psSysDevBKTask.setPSSysDevBKTaskId(this.psSysDevBKTask.getPSSYSDEVBKTASKID());
                psSysDevBKTaskService.update((IEntity)psSysDevBKTask, false);
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    public String getTaskType() {
        return this.psSysDevBKTask.getTASKTYPE();
    }

    @Override
    public String getTaskParam() {
        return this.psSysDevBKTask.getTASKPARAM();
    }

    @Override
    public String getTaskParam2() {
        return this.psSysDevBKTask.getTASKPARAM2();
    }

    @Override
    public String getTaskParam3() {
        return this.psSysDevBKTask.getTASKPARAM3();
    }

    @Override
    public String getTaskParam4() {
        return this.psSysDevBKTask.getTASKPARAM4();
    }

    @Override
    public IPSSysRunSession getPSSysRunSession() {
        if (this.getParentPSSysDevBKTask() != null) {
            return this.getParentPSSysDevBKTask().getPSSysRunSession();
        }
        return null;
    }

    protected IPSSysPubRuntime getPSSysPubRuntime() {
        IPSSysRunSession iPSSysRunSession = this.getPSSysRunSession();
        if (iPSSysRunSession != null && iPSSysRunSession instanceof IPSSysPubRuntime) {
            return (IPSSysPubRuntime)((Object)iPSSysRunSession);
        }
        return null;
    }

    @Override
    public int getModelLoadLevel() {
        if (!this.psSysDevBKTask.isMODELLEVELNull()) {
            return this.psSysDevBKTask.getMODELLEVEL();
        }
        if (this.getParentPSSysDevBKTask() != null) {
            return this.getParentPSSysDevBKTask().getModelLoadLevel();
        }
        return IPSSystem.LOADLEVEL_CODE;
    }

    @Override
    public String getPSDevSlnSysId() {
        return this.strPSDevSlnSysId;
    }

    @Override
    public String getPSDynaInstId() {
        return this.strPSDynaInstId;
    }

    @Override
    public String getPSDSConsoleId() {
        if (!StringHelper.isNullOrEmpty((String)this.getPSDynaInstId())) {
            return this.getPSDynaInstId();
        }
        return this.getPSDevSlnSysId();
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
                    PSSysDevBKTask psSysDevBKTask = new PSSysDevBKTask();
                    PSSysDevBKTaskService psSysDevBKTaskService = (PSSysDevBKTaskService)ServiceGlobal.getService(PSSysDevBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
                    psSysDevBKTask.setPSSysDevBKTaskId(this.psSysDevBKTask.getPSSYSDEVBKTASKID());
                    psSysDevBKTask.setPSDCRobotId(this.iPSRobot.getId());
                    psSysDevBKTask.setPSDCRobotName(this.iPSRobot.getName());
                    if (this.nEnergy > 0) {
                        psSysDevBKTask.setPSDCRobotName(StringHelper.format((String)"%1$s,\u8017\u80fd %2$smAh", (Object)this.iPSRobot.getName(), (Object)this.nEnergy));
                    }
                    psSysDevBKTaskService.update((IEntity)psSysDevBKTask, false);
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
                PSSysDevBKTask psSysDevBKTask = new PSSysDevBKTask();
                PSSysDevBKTaskService psSysDevBKTaskService = (PSSysDevBKTaskService)ServiceGlobal.getService(PSSysDevBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
                psSysDevBKTask.setPSSysDevBKTaskId(this.psSysDevBKTask.getPSSYSDEVBKTASKID());
                if (psRobotResult != null) {
                    psSysDevBKTask.setPSDCRobotId(psRobotResult.getPSRobot().getId());
                    psSysDevBKTask.setPSDCRobotName(StringHelper.format((String)"%2$s,\u9884\u8ba1\u5f00\u59cb[%1$tm-%1$td %1$tH:%1$tM:%1$tS]", (Object)psRobotResult.getPlanTime(), (Object)psRobotResult.getPSRobot().getName()));
                } else {
                    psSysDevBKTask.setPSDCRobotId("WAITING");
                    psSysDevBKTask.setPSDCRobotName(this.strPlanPSRobotInfo);
                }
                psSysDevBKTaskService.update((IEntity)psSysDevBKTask, false);
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
    public IPSRobot getPSRobot() {
        IPSRobot iPSRobot = this.iPSRobot;
        return iPSRobot;
    }

    @Override
    public boolean isUseRobot() {
        return this.bUseRobot;
    }

    @Override
    protected PSTSCmd createPSTSCmd() throws Exception {
        PSTSCmd psTSCmd = new PSTSCmd();
        if (!StringHelper.isNullOrEmpty((String)this.strPSDevSlnSysId)) {
            psTSCmd.setPSDevSlnSysId(this.strPSDevSlnSysId);
            if (StringHelper.isNullOrEmpty((String)this.strPSDynaInstId)) {
                IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(this.strPSDevSlnSysId);
                psTSCmd.setPSDevSlnId(iPSDevSlnSys.getPSDevSlnId());
                psTSCmd.setPSDevSlnName(iPSDevSlnSys.getPSDevSlnName());
            }
        }
        return psTSCmd;
    }

    @Override
    protected void onUpdateQueueInfo(String strQueueInfo) {
        try {
            PSSysDevBKTask psSysDevBKTask = new PSSysDevBKTask();
            PSSysDevBKTaskService psSysDevBKTaskService = (PSSysDevBKTaskService)ServiceGlobal.getService(PSSysDevBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
            psSysDevBKTask.setPSSysDevBKTaskId(this.psSysDevBKTask.getPSSYSDEVBKTASKID());
            psSysDevBKTask.setQueueInfo(strQueueInfo);
            psSysDevBKTaskService.update((IEntity)psSysDevBKTask, false);
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    protected String executeJSCode(String strFile) throws Exception {
        String strCode;
        block7: {
            block6: {
                block5: {
                    try {
                        if (this.getPSSysPubRuntime() != null) break block5;
                        return null;
                    }
                    catch (Exception ex) {
                        log.error((Object)StringHelper.format((String)"\u6267\u884c\u811a\u672c\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
                        throw ex;
                    }
                }
                File file = new File(strFile);
                if (file.exists()) break block6;
                return null;
            }
            strCode = FileWriterHelper2.readFile(strFile);
            if (!StringHelper.isNullOrEmpty((String)strCode)) break block7;
            return null;
        }
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        engine.put("syspub", this.getPSSysPubRuntime());
        Object objRet = engine.eval(strCode);
        return (String)objRet;
    }

    protected final IPSTaskServerEnv getPSTaskServerEnv() throws Exception {
        return this.getPSModelStorage().getPSTaskServerEnv();
    }

    protected static int calcStringPartCount(String strResult, String strPart) throws Exception {
        int nPos;
        if (StringHelper.isNullOrEmpty((String)strResult)) {
            return 0;
        }
        int nStartPos = 0;
        int nCount = 0;
        while ((nPos = strResult.indexOf(strPart, nStartPos)) != -1) {
            ++nCount;
            nStartPos = nPos;
            nStartPos += strPart.length();
        }
        return nCount;
    }

    @Override
    public String getCreateMan() {
        return this.psSysDevBKTask.getCREATEMAN();
    }

    @Override
    public String getPSSystemId() {
        return this.strPSSystemId;
    }

    @Override
    protected IPSModelObjectLogger getPSModelObjectLogger() {
        return this.iPSModelObjectLogger;
    }
}

