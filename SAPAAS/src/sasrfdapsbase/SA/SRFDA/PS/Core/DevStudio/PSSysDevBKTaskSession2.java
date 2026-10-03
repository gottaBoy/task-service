/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.codelist.SysDevBKTaskStateCodeListModel
 *  net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysDevBKTask
 *  net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevBKTaskService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.PS.Core.DevCenter.IPSDevCenter;
import SA.SRFDA.PS.Core.DevStudio.IPSSysDevBKTask;
import SA.SRFDA.PS.Core.DevStudio.IPSSysDevBKTaskGlobalContext;
import SA.SRFDA.PS.Core.DevStudio.IPSSysDevBKTaskSessionContext;
import SA.SRFDA.PS.Core.DevStudio.PSSysDevBKTaskHandler;
import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Robot.IPSRobot;
import SA.SRFDA.PS.Core.Robot.IPSRobotWork;
import SA.SRFDA.PS.Core.Robot.PSRobotResult;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.codelist.SysDevBKTaskStateCodeListModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysDevBKTask;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevBKTaskService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSSysDevBKTaskSession2
extends PSObjectImpl
implements IPSSysDevBKTaskSessionContext {
    private Boolean bStarted = false;
    private long nLastTaskFinishTime = 0L;
    protected ArrayList<IPSSysDevBKTask> psSysDevBKTaskList = new ArrayList();
    private static final Log log = LogFactory.getLog(PSSysDevBKTaskSession2.class);
    private String strPSDevSlnSysId = null;
    private IPSSysDevBKTask activePSSysDevBKTask = null;
    private String psSysModelInstId = null;
    private ThreadPoolExecutor singleThreadExecutor = null;
    private IPSSysDevBKTaskGlobalContext iPSSysDevBKTaskGlobalContext = null;
    private ThreadPoolExecutor threadPoolExecutor = null;
    private int nTaskThreadCount = 3;
    private IPSDevCenter iPSDevCenter = null;
    private IPSRobot lastPSRobot = null;
    private long nLastStartTime = 0L;
    private Object objThreadPoolLock = new Object();
    private Object objLastPSRobotLock = new Object();
    private int nQueuePos = -1;
    private Boolean bLastRunFlag = false;
    private long nLastActiveTime = 0L;
    private Object objLastRunFlagLock = new Object();
    private Object objStartedLock = new Object();

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, String strPSDevSlnSysId, IPSSysDevBKTaskGlobalContext iPSSysDevBKTaskGlobalContext) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.strPSDevSlnSysId = strPSDevSlnSysId;
        this.iPSSysDevBKTaskGlobalContext = iPSSysDevBKTaskGlobalContext;
        this.nTaskThreadCount = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "TASKTHREADCOUNT", this.nTaskThreadCount);
        if (this.nTaskThreadCount <= 0) {
            this.nTaskThreadCount = 3;
        }
        IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(this.strPSDevSlnSysId);
        this.psSysModelInstId = iPSDevSlnSys.getPSSysModelInstId();
        this.iPSDevCenter = this.getPSModelStorage().getPSDevCenter(iPSDevSlnSys.getPSDevCenterId());
        this.setName(StringHelper.format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s][%2$s|%3$s]\u540e\u53f0\u4f5c\u4e1a", (Object)iPSDevSlnSys.getId(), (Object)iPSDevSlnSys.getPSDevSlnCodeName(), (Object)iPSDevSlnSys.getName()));
        this.nLastTaskFinishTime = System.currentTimeMillis();
        log.info((Object)StringHelper.format((String)"%1$s\u521d\u59cb\u5316", (Object)this.getName()));
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean isStarted() {
        Object object = this.objStartedLock;
        synchronized (object) {
            return this.bStarted;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void setStarted(boolean bStarted) {
        Object object = this.objStartedLock;
        synchronized (object) {
            this.bStarted = bStarted;
        }
    }

    @Override
    public String getPSSysModelInstId() {
        return this.psSysModelInstId;
    }

    public String getPSDevSlnSysId() {
        return this.strPSDevSlnSysId;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public synchronized void start() {
        if (this.isStarted()) {
            return;
        }
        ThreadPoolExecutor singleThreadExecutor = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(8), new ThreadPoolExecutor.AbortPolicy());
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(this.getTaskThreadCount(), this.getTaskThreadCount() + 10, 30L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10), new ThreadPoolExecutor.AbortPolicy());
        Object object = this.objThreadPoolLock;
        synchronized (object) {
            this.singleThreadExecutor = singleThreadExecutor;
            this.threadPoolExecutor = threadPoolExecutor;
        }
        this.setStarted(true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void stop() {
        List<Runnable> list;
        if (!this.isStarted()) {
            return;
        }
        this.setStarted(false);
        Object object = this.objThreadPoolLock;
        synchronized (object) {
            list = null;
            if (this.singleThreadExecutor != null && (list = this.singleThreadExecutor.shutdownNow()) != null) {
                for (Runnable runnable : list) {
                    PSSysDevBKTaskHandler psSysDevBKTaskHandler = (PSSysDevBKTaskHandler)runnable;
                    psSysDevBKTaskHandler.cancel(true, null);
                }
            }
            if (this.threadPoolExecutor != null) {
                list = this.threadPoolExecutor.shutdownNow();
            }
            this.singleThreadExecutor = null;
            this.threadPoolExecutor = null;
        }
        try {
            ArrayList<IPSSysDevBKTask> psSysDevBKTaskList2 = null;
            synchronized (this.psSysDevBKTaskList) {
                if (this.psSysDevBKTaskList.size() > 0) {
                    psSysDevBKTaskList2 = new ArrayList<IPSSysDevBKTask>();
                    psSysDevBKTaskList2.addAll(this.psSysDevBKTaskList);
                    this.psSysDevBKTaskList.clear();
                }
            }
            if (psSysDevBKTaskList2 != null) {
                for (IPSSysDevBKTask iPSSysDevBKTask : psSysDevBKTaskList2) {
                    iPSSysDevBKTask.cancel(true, null);
                }
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addPSSysDevBKTask(IPSSysDevBKTask iPSSysDevBKTask) throws Exception {
        if (!this.isStarted()) {
            throw new Exception("\u4efb\u52a1\u5bb9\u5668\u8fd8\u672a\u542f\u52a8\uff0c\u4e0d\u80fd\u6dfb\u52a0\u4efb\u52a1");
        }
        ArrayList<IPSSysDevBKTask> arrayList = this.psSysDevBKTaskList;
        synchronized (arrayList) {
            this.psSysDevBKTaskList.add(iPSSysDevBKTask);
            log.info((Object)StringHelper.format((String)"%1$s\u6dfb\u52a0\u4efb\u52a1[%2$s]\uff0c\u5f53\u524d\u9876\u7ea7\u4efb\u52a1\u6570[%3$s]", (Object)this.getName(), (Object)iPSSysDevBKTask.getName(), (Object)this.psSysDevBKTaskList.size()));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getPSSysDevBKTaskCount() {
        ArrayList<IPSSysDevBKTask> arrayList = this.psSysDevBKTaskList;
        synchronized (arrayList) {
            return this.psSysDevBKTaskList.size();
        }
    }

    public long getLastTaskFinishTime() {
        return this.nLastTaskFinishTime;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void cancelPSSysDevBKTask(String strPSSysDevBKTaskId) throws Exception {
        PSSysDevBKTaskService psSysDevBKTaskService = (PSSysDevBKTaskService)ServiceGlobal.getService(PSSysDevBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        PSSysDevBKTask psSysDevBKTask = new PSSysDevBKTask();
        psSysDevBKTask.setPSSysDevBKTaskId(strPSSysDevBKTaskId);
        if (!psSysDevBKTaskService.get(psSysDevBKTask, true)) {
            return;
        }
        if (!StringHelper.isNullOrEmpty((String)psSysDevBKTask.getPPSSysDevBKTaskId())) {
            PSSysDevBKTask parentPSSysDevBKTask = new PSSysDevBKTask();
            parentPSSysDevBKTask.setPSSysDevBKTaskId(psSysDevBKTask.getPPSSysDevBKTaskId());
            if (psSysDevBKTaskService.get(parentPSSysDevBKTask, true) && (parentPSSysDevBKTask.getTaskState() == 10 || parentPSSysDevBKTask.getTaskState() == 20)) {
                this.cancelPSSysDevBKTask(psSysDevBKTask.getPPSSysDevBKTaskId());
                return;
            }
        }
        IPSSysDevBKTask cancelPSSysDevBKTask = null;
        ArrayList<IPSSysDevBKTask> arrayList = this.psSysDevBKTaskList;
        synchronized (arrayList) {
            if (this.activePSSysDevBKTask != null && StringHelper.compare((String)this.activePSSysDevBKTask.getId(), (String)strPSSysDevBKTaskId, (boolean)true) == 0) {
                cancelPSSysDevBKTask = this.activePSSysDevBKTask;
            }
            if (cancelPSSysDevBKTask == null) {
                for (IPSSysDevBKTask iPSSysDevBKTask : this.psSysDevBKTaskList) {
                    if (StringHelper.compare((String)iPSSysDevBKTask.getId(), (String)strPSSysDevBKTaskId, (boolean)true) != 0) continue;
                    cancelPSSysDevBKTask = iPSSysDevBKTask;
                    this.psSysDevBKTaskList.remove(iPSSysDevBKTask);
                    break;
                }
            }
        }
        if (cancelPSSysDevBKTask != null) {
            cancelPSSysDevBKTask.cancel(true, null);
        } else {
            try {
                if (psSysDevBKTask.getTaskState() == 10 || psSysDevBKTask.getTaskState() == 20) {
                    psSysDevBKTask.reset();
                    psSysDevBKTask.setPSSysDevBKTaskId(strPSSysDevBKTaskId);
                    psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CANCELLED);
                    psSysDevBKTask.setResultInfo(null);
                    psSysDevBKTaskService.update(psSysDevBKTask, false);
                }
            }
            catch (Exception ex) {
                log.error((Object)ex.getMessage(), (Throwable)ex);
            }
        }
    }

    @Override
    public void executeTask(Runnable command) {
        this.threadPoolExecutor.execute(command);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String getCurrentInfo() {
        if (!this.isStarted()) {
            return null;
        }
        Object object = this.objThreadPoolLock;
        synchronized (object) {
            block5: {
                if (this.singleThreadExecutor != null && this.threadPoolExecutor != null) break block5;
                return null;
            }
            int nQueueCount = this.singleThreadExecutor.getQueue().size();
            int nThreadCount = this.singleThreadExecutor.getPoolSize();
            int nTaskCount = this.singleThreadExecutor.getActiveCount();
            int nTaskCount2 = this.threadPoolExecutor.getActiveCount();
            int nThreadCount2 = this.threadPoolExecutor.getPoolSize();
            int nQueueCount2 = this.psSysDevBKTaskList.size();
            return StringHelper.format((String)"%1$s==>\u7ebf\u7a0b\u6570[%2$s/%3$s|%6$s/%7$s],\u7ebf\u7a0b\u961f\u5217\u4efb\u52a1\u6570[%4$s],\u672a\u6392\u961f\u4efb\u52a1\u6570[%5$s]", (Object)this.getName(), (Object)nTaskCount, (Object)nThreadCount, (Object)nQueueCount, (Object)nQueueCount2, (Object)nTaskCount2, (Object)nThreadCount2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean isRunning() {
        if (!this.isStarted()) {
            return false;
        }
        boolean bRunning = false;
        IPSRobot runPSRobot = null;
        Object object = this.objThreadPoolLock;
        synchronized (object) {
            if (this.singleThreadExecutor == null) {
                return bRunning;
            }
            if (this.singleThreadExecutor.getActiveCount() > 0) {
                bRunning = true;
                Object object2 = this.objLastPSRobotLock;
                synchronized (object2) {
                    runPSRobot = this.lastPSRobot;
                }
            }
        }
        object = this.objLastRunFlagLock;
        synchronized (object) {
            if (bRunning != this.bLastRunFlag) {
                this.bLastRunFlag = bRunning;
                if (!this.bLastRunFlag.booleanValue()) {
                    this.nLastTaskFinishTime = System.currentTimeMillis();
                }
            }
        }
        try {
            long nCurTime;
            if (runPSRobot != null) {
                runPSRobot.active();
            }
            if (bRunning && this.nLastActiveTime + 10000L < (nCurTime = System.currentTimeMillis())) {
                IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getCachePSDevSlnSys(this.strPSDevSlnSysId);
                if (iPSDevSlnSys != null) {
                    iPSDevSlnSys.active();
                }
                this.nLastActiveTime = System.currentTimeMillis();
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        return bRunning;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean run() {
        Object object;
        Object object2 = this.objLastPSRobotLock;
        synchronized (object2) {
            this.lastPSRobot = null;
        }
        this.nLastStartTime = 0L;
        object2 = this.psSysDevBKTaskList;
        synchronized (object2) {
            this.activePSSysDevBKTask = null;
        }
        if (!this.isStarted()) {
            return false;
        }
        object2 = this.objThreadPoolLock;
        synchronized (object2) {
            if (this.singleThreadExecutor == null) {
                log.error((Object)"\u5f53\u524d\u7ebf\u7a0b\u6c60\u65e0\u6548");
                return false;
            }
        }
        IPSSysDevBKTask iPSSysDevBKTask = null;
        ArrayList<IPSSysDevBKTask> arrayList = this.psSysDevBKTaskList;
        synchronized (arrayList) {
            if (this.psSysDevBKTaskList.size() > 0) {
                iPSSysDevBKTask = this.psSysDevBKTaskList.remove(0);
            }
        }
        if (iPSSysDevBKTask != null && this.iPSDevCenter.isUseRobot() && iPSSysDevBKTask.isUseRobot()) {
            try {
                PSRobotResult psRobotResult = this.iPSDevCenter.getValidPSDCRobot(iPSSysDevBKTask);
                if (psRobotResult == null || psRobotResult.getEnerge() < 0) {
                    iPSSysDevBKTask.setPlanPSRobot(psRobotResult);
                    object = this.psSysDevBKTaskList;
                    synchronized (object) {
                        this.psSysDevBKTaskList.add(0, iPSSysDevBKTask);
                        return false;
                    }
                }
                if (!psRobotResult.getPSRobot().addPSRobotWorks(new IPSRobotWork[]{iPSSysDevBKTask})) {
                    object = this.psSysDevBKTaskList;
                    synchronized (object) {
                        this.psSysDevBKTaskList.add(0, iPSSysDevBKTask);
                        iPSSysDevBKTask = null;
                    }
                }
                object = this.objLastPSRobotLock;
                synchronized (object) {
                    this.lastPSRobot = psRobotResult.getPSRobot();
                }
            }
            catch (Exception ex) {
                iPSSysDevBKTask.cancel(true, "\u83b7\u53d6\u5f53\u524d\u53ef\u7528\u673a\u5668\u4eba\u53d1\u751f\u9519\u8bef");
                log.error((Object)"\u83b7\u53d6\u5f53\u524d\u53ef\u7528\u673a\u5668\u4eba\u53d1\u751f\u9519\u8bef", (Throwable)ex);
                return false;
            }
        }
        if (iPSSysDevBKTask == null) {
            return false;
        }
        this.nLastStartTime = System.currentTimeMillis();
        try {
            Object ex = this.psSysDevBKTaskList;
            synchronized (ex) {
                this.activePSSysDevBKTask = iPSSysDevBKTask;
            }
            ex = this.objThreadPoolLock;
            synchronized (ex) {
                if (this.singleThreadExecutor == null) {
                    throw new Exception("\u7ebf\u7a0b\u6c60\u65e0\u6548");
                }
                this.singleThreadExecutor.execute(new PSSysDevBKTaskHandler(iPSSysDevBKTask, this));
            }
            log.info((Object)StringHelper.format((String)"%1$s\u8fd0\u884c\u4efb\u52a1[%2$s]", (Object)this.getName(), (Object)iPSSysDevBKTask.getName()));
            return true;
        }
        catch (Exception ex) {
            object = this.psSysDevBKTaskList;
            synchronized (object) {
                this.activePSSysDevBKTask = null;
            }
            iPSSysDevBKTask.cancel(true, "\u65e0\u6cd5\u8fd0\u884c\u4efb\u52a1\uff0c\u5f53\u524d\u961f\u5217\u5df2\u6ee1");
            log.error((Object)"\u65e0\u6cd5\u8fd0\u884c\u4efb\u52a1\uff0c\u5f53\u524d\u961f\u5217\u5df2\u6ee1");
            return false;
        }
    }

    @Override
    public int getTaskThreadCount() {
        return this.nTaskThreadCount;
    }

    public long getLastTaskStartTime() {
        return this.nLastStartTime;
    }

    public IPSRobot getLastTaskPSRobot() {
        return this.lastPSRobot;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setQueuePos(int nPos, int nTotal) {
        this.nQueuePos = nPos;
        try {
            IPSSysDevBKTask iPSSysDevBKTask = null;
            ArrayList<IPSSysDevBKTask> arrayList = this.psSysDevBKTaskList;
            synchronized (arrayList) {
                if (this.psSysDevBKTaskList.size() > 0) {
                    iPSSysDevBKTask = this.psSysDevBKTaskList.get(0);
                }
            }
            if (iPSSysDevBKTask != null) {
                iPSSysDevBKTask.setQueueInfo(nPos, nTotal);
                this.activePSDevSlnSys();
            }
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u66f4\u65b0\u961f\u5217\u4f4d\u7f6e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
        }
    }

    public long getPriority() {
        return System.currentTimeMillis() - this.nLastTaskFinishTime;
    }

    protected boolean activePSDevSlnSys() throws Exception {
        long nCurTime = System.currentTimeMillis();
        if (this.nLastActiveTime + 10000L < nCurTime) {
            IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getCachePSDevSlnSys(this.strPSDevSlnSysId);
            if (iPSDevSlnSys != null) {
                iPSDevSlnSys.active();
            }
            this.nLastActiveTime = System.currentTimeMillis();
            return iPSDevSlnSys != null;
        }
        return true;
    }

    @Override
    public String getQueueInfo() {
        return null;
    }

    @Override
    public boolean getLastRunFlag() {
        return false;
    }

    @Override
    public IPSDevCenter getPSDevCenter() {
        return this.iPSDevCenter;
    }
}
