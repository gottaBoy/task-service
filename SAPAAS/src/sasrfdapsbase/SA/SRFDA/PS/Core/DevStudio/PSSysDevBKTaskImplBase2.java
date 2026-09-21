/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  com.sun.jna.Platform
 *  com.sun.jna.Pointer
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.codelist.SysDevBKTaskStateCodeListModel
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSTSCmd
 *  net.ibizsys.pscore.srv.paasmgr.service.PSTSCmdService
 *  net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysDevBKTask
 *  net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevBKTaskService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.PS.Core.Deploy.IPSSysRunSession;
import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskSessionContext;
import SA.SRFDA.PS.Core.DevStudio.IPSSysDevBKTask;
import SA.SRFDA.PS.Core.DevStudio.IPSSysDevBKTaskSessionContext;
import SA.SRFDA.PS.Core.DevStudio.IPSSysDevBTType;
import SA.SRFDA.PS.Core.DevStudio.PSSysBTException;
import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.JIT.Web.PSJITWebContext;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysPubRuntime;
import SA.SRFDA.PS.Core.Robot.IPSRobot;
import SA.SRFDA.PS.Core.Robot.IPSRobotWork;
import SA.SRFDA.PS.Core.Robot.IPSRobotWorkType;
import SA.SRFDA.PS.Core.Robot.PSRobotResult;
import SA.SRFDA.PS.Core.Util.FileWriterHelper2;
import SA.SRFDA.PS.Core.Util.JNA.Kernel32;
import SA.SRFDA.PS.Core.Util.JNA.W32API;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import com.sun.jna.Platform;
import com.sun.jna.Pointer;
import java.io.File;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.codelist.SysDevBKTaskStateCodeListModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTSCmd;
import net.ibizsys.pscore.srv.paasmgr.service.PSTSCmdService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysDevBKTask;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevBKTaskService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDevBKTaskImplBase2
extends PSObjectImpl
implements IPSSysDevBKTask {
    protected SA.SRFDA.PS.Data.PSSysDevBKTask psSysDevBKTask = null;
    private static final Log log = LogFactory.getLog(PSSysDevBKTaskImplBase2.class);
    private ArrayList<IPSSysDevBKTask> psSysDevBKTaskList = new ArrayList();
    private ArrayList<IPSRobotWork> psRobotWorkList = new ArrayList();
    private IPSSysDevBKTask parentPSSysDevBKTask = null;
    private boolean bIsCancel = false;
    private Process curBatProcess = null;
    private String strPSTaskServerId = "";
    private String strPSDevSlnSysId = "";
    private String strPSSystemId = "";
    private IPSSysDevBKTaskSessionContext iPSSysDevBKTaskSessionContext = null;
    private HashMap<String, Object> attributeMap = new HashMap();
    private IPSRobot iPSRobot = null;
    private int nEnergy = 0;
    private PSRobotResult planPSRobotResult = null;
    private String strPlanPSRobotInfo = null;
    private IPSRobotWorkType iPSRobotWorkType = null;
    private IPSSysDevBTType iPSSysDevBTType = null;
    private boolean bUseRobot = true;
    private String strQueueInfo = null;

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
        this.strPSSystemId = this.psSysDevBKTask.getPSSYSTEMID();
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
    public IPSSysDevBKTask getParentPSSysDevBKTask() {
        return this.parentPSSysDevBKTask;
    }

    protected void prepareChildPSSysDevBKTasks() throws Exception {
        Vector<SA.SRFDA.PS.Data.PSSysDevBKTask> psSysDevBKTaskList = new Vector<SA.SRFDA.PS.Data.PSSysDevBKTask>();
        CallResult callResult = this.getPSModelHelper().getPSSysDevBKTasks(this.getId(), psSysDevBKTaskList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u7cfb\u7edf\u5f00\u53d1\u540e\u53f0\u4efb\u52a1\u5b50\u4efb\u52a1\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (SA.SRFDA.PS.Data.PSSysDevBKTask childPSSysDevBKTask : psSysDevBKTaskList) {
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
    public synchronized boolean run(IPSBKTaskSessionContext iPSBKTaskSessionContext) {
        if (PSJITWebContext.getInstance() != null) {
            PSJITWebContext.setCurrent(null);
        }
        this.iPSSysDevBKTaskSessionContext = (IPSSysDevBKTaskSessionContext)iPSBKTaskSessionContext;
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
            while (!this.isCancel()) {
                IPSSysDevBKTask iPSSysDevBKTask = null;
                ArrayList<IPSSysDevBKTask> arrayList = this.psSysDevBKTaskList;
                synchronized (arrayList) {
                    if (this.psSysDevBKTaskList.size() > 0) {
                        iPSSysDevBKTask = this.psSysDevBKTaskList.remove(0);
                    }
                }
                if (iPSSysDevBKTask == null) break;
                if (iPSSysDevBKTask.run(this.iPSSysDevBKTaskSessionContext)) continue;
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
            String strResultInfo = this.onRun();
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
                            sb.append("\u540e\u53f0\u4efb\u52a1\u5904\u7406\u53d1\u751f\u9519\u8bef\uff1a");
                            sb.append(psSysBTException.getMessage());
                            break;
                        }
                        default: {
                            sb.append("\u540e\u53f0\u4efb\u52a1\u5904\u7406\u53d1\u751f\u5f02\u5e38\uff1a");
                            ex.printStackTrace(new PrintWriter(sb.getWriter()));
                            break;
                        }
                    }
                } else {
                    sb.append("\u540e\u53f0\u4efb\u52a1\u5904\u7406\u53d1\u751f\u5f02\u5e38\uff1a");
                    ex.printStackTrace(new PrintWriter(sb.getWriter()));
                }
                strResultInfo = sb.toString();
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

    protected boolean isCancel() {
        return this.bIsCancel;
    }

    protected void setIsCancel(boolean bIsCancel) {
        this.bIsCancel = bIsCancel;
    }

    protected String onRun() throws Exception {
        return null;
    }

    @Override
    public void cancel(boolean bUserCancel, String strReason) {
        this.setIsCancel(true);
        try {
            if (this.curBatProcess != null) {
                this.curBatProcess.destroy();
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        this.onCancel(bUserCancel, strReason);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected synchronized void onCancel(boolean bUserCancel, String strReason) {
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

    protected String runBat(String batName, boolean bResult) throws Exception {
        try {
            IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(this.strPSDevSlnSysId);
            PSTSCmdService psTSCmdService = (PSTSCmdService)ServiceGlobal.getService(PSTSCmdService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSTSCmd psTSCmd = new PSTSCmd();
            psTSCmd.setPSDevSlnSysId(this.strPSDevSlnSysId);
            psTSCmd.setPSDevSlnId(iPSDevSlnSys.getPSDevSlnId());
            psTSCmd.setPSDevSlnName(iPSDevSlnSys.getPSDevSlnName());
            psTSCmd.setTaskName(this.getName());
            psTSCmd.setPSTaskServerId(this.strPSTaskServerId);
            psTSCmd.setRunCmd(batName);
            this.curBatProcess = Runtime.getRuntime().exec(batName);
            WatchThread wt = new WatchThread(this.curBatProcess, bResult, -1);
            wt.start();
            long pid = -1L;
            try {
                if (Platform.isWindows()) {
                    Field field = this.curBatProcess.getClass().getDeclaredField("handle");
                    field.setAccessible(true);
                    W32API.HANDLE handler = new W32API.HANDLE();
                    handler.setPointer(Pointer.createConstant((long)((Long)field.get(this.curBatProcess))));
                    pid = Kernel32.INSTANCE.GetProcessId(handler);
                }
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
            if (pid != -1L) {
                psTSCmd.set("SRF_PERSONID", (Object)"SYSTEM");
                psTSCmd.set("SRF_LOGINNAME", (Object)"SYSTEM");
                psTSCmd.setPSTSCmdName(StringHelper.format((String)"%1$s", (Object)pid));
                psTSCmdService.create((IEntity)psTSCmd, true);
            }
            this.curBatProcess.waitFor();
            this.curBatProcess = null;
            try {
                if (Platform.isWindows() && pid != -1L) {
                    String strCmd = String.format("cmd.exe /c taskkill /PID %1$s /T /F ", pid);
                    Runtime.getRuntime().exec(strCmd);
                }
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
            if (pid != -1L) {
                psTSCmdService.remove((IEntity)psTSCmd);
            }
            wt.setOver(true);
            if (bResult) {
                ArrayList<String> commandStream = wt.getStream();
                StringBuilderEx sBuilderEx = new StringBuilderEx();
                for (String strInfo : commandStream) {
                    sBuilderEx.append(strInfo);
                    sBuilderEx.append("\r\n");
                }
                return sBuilderEx.toString();
            }
            return "";
        }
        catch (Exception ex) {
            log.error((Object)ex);
            this.curBatProcess = null;
            return ex.getMessage();
        }
    }

    protected void executeTask(Runnable command) {
        if (PSJITWebContext.getInstance() != null) {
            PSJITWebContext.setCurrent(null);
        }
        this.iPSSysDevBKTaskSessionContext.executeTask(command);
    }

    protected int getTaskThreadCount() {
        return this.iPSSysDevBKTaskSessionContext.getTaskThreadCount();
    }

    @Override
    public void setAttribute(String strKey, Object objValue) {
        this.attributeMap.put(strKey, objValue);
    }

    @Override
    public Object getAttribute(String strKey) {
        return this.attributeMap.get(strKey);
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
    public synchronized void setPSRobot(IPSRobot iPSRobot, int nEnergy) throws Exception {
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
        return this.nEnergy;
    }

    @Override
    public synchronized void setPlanPSRobot(PSRobotResult psRobotResult) throws Exception {
        this.planPSRobotResult = psRobotResult;
        String strPlanPSRobotInfo = "";
        strPlanPSRobotInfo = psRobotResult != null ? this.getPlanPSRobotInfo(this.planPSRobotResult) : "\u7b49\u5f85\u673a\u5668\u4eba";
        if (StringHelper.compare((String)strPlanPSRobotInfo, (String)this.strPlanPSRobotInfo, (boolean)false) != 0) {
            this.strPlanPSRobotInfo = strPlanPSRobotInfo;
            if (this.getPSRobot() == null) {
                try {
                    PSSysDevBKTask psSysDevBKTask = new PSSysDevBKTask();
                    PSSysDevBKTaskService psSysDevBKTaskService = (PSSysDevBKTaskService)ServiceGlobal.getService(PSSysDevBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
                    psSysDevBKTask.setPSSysDevBKTaskId(this.psSysDevBKTask.getPSSYSDEVBKTASKID());
                    if (psRobotResult != null) {
                        psSysDevBKTask.setPSDCRobotId(psRobotResult.getPSRobot().getId());
                        psSysDevBKTask.setPSDCRobotName(StringHelper.format((String)"%2$s,\u9884\u8ba1\u5f00\u59cb[%1$tm-%1$td %1$tH:%1$tM:%1$tS]", (Object)psRobotResult.getPlanTime(), (Object)psRobotResult.getPSRobot().getName()));
                    } else {
                        psSysDevBKTask.setPSDCRobotId("WAITING");
                        psSysDevBKTask.setPSDCRobotName(strPlanPSRobotInfo);
                    }
                    psSysDevBKTaskService.update((IEntity)psSysDevBKTask, false);
                }
                catch (Exception ex) {
                    log.error((Object)ex);
                }
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
    public synchronized IPSRobot getPSRobot() {
        return this.iPSRobot;
    }

    @Override
    public boolean isUseRobot() {
        return this.bUseRobot;
    }

    @Override
    public void setQueueInfo(int nPos, int nTotal) {
        String strQueueInfo = StringHelper.format((String)"\u6b63\u5728\u7b49\u5f85\u8c03\u5ea6,\u5f53\u524d\u4f4d\u7f6e[%1$s],\u961f\u5217\u957f\u5ea6[%2$s]", (Object)nPos, (Object)nTotal);
        if (StringHelper.compare((String)strQueueInfo, (String)this.strQueueInfo, (boolean)false) == 0) {
            return;
        }
        this.strQueueInfo = strQueueInfo;
        try {
            PSSysDevBKTask psSysDevBKTask = new PSSysDevBKTask();
            PSSysDevBKTaskService psSysDevBKTaskService = (PSSysDevBKTaskService)ServiceGlobal.getService(PSSysDevBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
            psSysDevBKTask.setPSSysDevBKTaskId(this.psSysDevBKTask.getPSSYSDEVBKTASKID());
            psSysDevBKTask.setQueueInfo(this.strQueueInfo);
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

    class WatchThread
    extends Thread {
        Process p;
        boolean over;
        ArrayList<String> stream;
        int nTimeout;
        boolean bResult;
        boolean bError = false;
        WatchThread errorWatchThread = null;

        public WatchThread(Process p, boolean bResult, int nTimeout) {
            this.p = p;
            this.over = false;
            this.nTimeout = nTimeout;
            this.bResult = bResult;
            if (bResult) {
                this.stream = new ArrayList();
            }
            this.errorWatchThread = new WatchThread(p, false, nTimeout, true);
        }

        public WatchThread(Process p, boolean bResult, int nTimeout, boolean bError) {
            this.p = p;
            this.over = false;
            this.nTimeout = nTimeout;
            this.bResult = bResult;
            if (bResult) {
                this.stream = new ArrayList();
            }
            this.bError = bError;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void run() {
            Scanner br;
            block10: {
                block9: {
                    br = null;
                    try {
                        InputStream stream;
                        if (this.p == null) {
                            return;
                        }
                        if (this.bResult) {
                            br = new Scanner(this.bError ? this.p.getErrorStream() : this.p.getInputStream(), "GBK");
                            break block9;
                        }
                        InputStream inputStream = stream = this.bError ? this.p.getErrorStream() : this.p.getInputStream();
                        while (this.p != null && !this.over) {
                            if (stream.available() > 0) {
                                byte[] btmp = new byte[stream.available()];
                                stream.read(btmp);
                            }
                            Thread.sleep(50L);
                        }
                        stream.close();
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                    break block10;
                }
                while (this.p != null && !this.over) {
                    while (br.hasNextLine() && !this.over) {
                        String tempStream = br.nextLine();
                        if (!this.bResult || tempStream.trim() == null || tempStream.trim().equals("")) continue;
                        this.stream.add(tempStream);
                    }
                }
            }
            if (br != null) {
                br.close();
            }
        }

        public void setOver(boolean over) {
            if (this.errorWatchThread != null) {
                this.errorWatchThread.setOver(over);
            }
            this.over = over;
        }

        public ArrayList<String> getStream() {
            return this.stream;
        }

        @Override
        public synchronized void start() {
            if (this.errorWatchThread != null) {
                this.errorWatchThread.start();
            }
            super.start();
        }
    }
}

