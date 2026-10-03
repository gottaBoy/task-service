/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.codelist.SysDevBKTaskStateCodeListModel
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDCBKTask
 *  net.ibizsys.pscore.srv.devcenter.service.PSDCBKTaskService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DevCenter;

import SA.SRFDA.PS.Core.DevCenter.IPSDevCenter;
import SA.SRFDA.PS.Core.DevCenter.IPSDevCenterBKTask;
import SA.SRFDA.PS.Core.DevCenter.IPSDevCenterBKTaskGlobalContext;
import SA.SRFDA.PS.Core.DevCenter.IPSDevCenterBKTaskSessionContext;
import SA.SRFDA.PS.Core.DevCenter.PSDevCenterBKTaskHandler;
import SA.SRFDA.PS.Core.PSObjectImpl;
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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCBKTask;
import net.ibizsys.pscore.srv.devcenter.service.PSDCBKTaskService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSDevCenterBKTaskSession2
extends PSObjectImpl
implements IPSDevCenterBKTaskSessionContext {
    private String strPSSystemId = null;
    private Boolean bStarted = false;
    private long nLastTaskFinishTime = 0L;
    protected ArrayList<IPSDevCenterBKTask> psDevCenterBKTaskList = new ArrayList();
    private static final Log log = LogFactory.getLog(PSDevCenterBKTaskSession2.class);
    private String strPSDevCenterId = null;
    private IPSDevCenterBKTask activePSDevCenterBKTask = null;
    private String psSysModelInstId = null;
    private ThreadPoolExecutor singleThreadExecutor = null;
    private IPSDevCenterBKTaskGlobalContext iPSDevCenterBKTaskGlobalContext = null;
    private ThreadPoolExecutor threadPoolExecutor = null;
    private int nTaskThreadCount = 3;
    private int nQueuePos = -1;
    private Boolean bLastRunFlag = false;
    private long nLastActiveTime = 0L;
    private Object objThreadPoolLock = new Object();
    private Object objStartedLock = new Object();
    private Object objLastRunFlagLock = new Object();

    @Override
    public String getQueueInfo() {
        return null;
    }

    @Override
    public boolean getLastRunFlag() {
        return false;
    }

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, String strPSDevCenterId, IPSDevCenterBKTaskGlobalContext iPSDevCenterBKTaskGlobalContext) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.strPSDevCenterId = strPSDevCenterId;
        this.iPSDevCenterBKTaskGlobalContext = iPSDevCenterBKTaskGlobalContext;
        this.nTaskThreadCount = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "DCTASKTHREADCOUNT", this.nTaskThreadCount);
        if (this.nTaskThreadCount <= 0) {
            this.nTaskThreadCount = 3;
        }
        IPSDevCenter iPSDevCenter = this.getPSModelStorage().getPSDevCenter(this.strPSDevCenterId);
        this.psSysModelInstId = iPSDevCenter.getPSSysModelInstId();
        this.setName(StringHelper.format((String)"\u5e94\u7528\u4e2d\u5fc3[%1$s][%2$s]\u540e\u53f0\u4f5c\u4e1a", (Object)iPSDevCenter.getId(), (Object)iPSDevCenter.getName()));
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

    public String getPSDevCenterId() {
        return this.strPSDevCenterId;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public synchronized void start() {
        if (this.isStarted()) {
            return;
        }
        ThreadPoolExecutor singleThreadExecutor = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(8), new ThreadPoolExecutor.AbortPolicy());
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, this.getTaskThreadCount(), 30L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10), new ThreadPoolExecutor.AbortPolicy());
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
    public synchronized void stop() {
        if (!this.isStarted()) {
            return;
        }
        this.setStarted(false);
        Object poolLock = this.objThreadPoolLock;
        synchronized (poolLock) {
            List<Runnable> list = null;
            if (this.singleThreadExecutor != null && (list = this.singleThreadExecutor.shutdownNow()) != null) {
                for (Runnable runnable : list) {
                    PSDevCenterBKTaskHandler psDevCenterBKTaskHandler = (PSDevCenterBKTaskHandler)runnable;
                    psDevCenterBKTaskHandler.cancel(true, null);
                }
            }
            if (this.threadPoolExecutor != null) {
                list = this.threadPoolExecutor.shutdownNow();
            }
            this.singleThreadExecutor = null;
            this.threadPoolExecutor = null;
        }
        try {
            ArrayList<IPSDevCenterBKTask> arrayList = this.psDevCenterBKTaskList;
            synchronized (arrayList) {
                for (IPSDevCenterBKTask iPSDevCenterBKTask : this.psDevCenterBKTaskList) {
                    iPSDevCenterBKTask.cancel(true, null);
                }
                this.psDevCenterBKTaskList.clear();
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addPSDevCenterBKTask(IPSDevCenterBKTask iPSDevCenterBKTask) throws Exception {
        ArrayList<IPSDevCenterBKTask> arrayList = this.psDevCenterBKTaskList;
        synchronized (arrayList) {
            this.psDevCenterBKTaskList.add(iPSDevCenterBKTask);
            log.info((Object)StringHelper.format((String)"%1$s\u6dfb\u52a0\u4efb\u52a1[%2$s]\uff0c\u5f53\u524d\u9876\u7ea7\u4efb\u52a1\u6570[%3$s]", (Object)this.getName(), (Object)iPSDevCenterBKTask.getName(), (Object)this.psDevCenterBKTaskList.size()));
        }
    }

    public long getLastTaskFinishTime() {
        return this.nLastTaskFinishTime;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public synchronized void cancelPSDevCenterBKTask(String strPSDevCenterBKTaskId) throws Exception {
        IPSDevCenterBKTask cancelPSDevCenterBKTask = null;
        ArrayList<IPSDevCenterBKTask> arrayList = this.psDevCenterBKTaskList;
        synchronized (arrayList) {
            if (this.activePSDevCenterBKTask != null && StringHelper.compare((String)this.activePSDevCenterBKTask.getId(), (String)strPSDevCenterBKTaskId, (boolean)true) == 0) {
                cancelPSDevCenterBKTask = this.activePSDevCenterBKTask;
            }
            if (cancelPSDevCenterBKTask == null) {
                for (IPSDevCenterBKTask iPSDevCenterBKTask : this.psDevCenterBKTaskList) {
                    if (StringHelper.compare((String)iPSDevCenterBKTask.getId(), (String)strPSDevCenterBKTaskId, (boolean)true) != 0) continue;
                    cancelPSDevCenterBKTask = iPSDevCenterBKTask;
                    this.psDevCenterBKTaskList.remove(iPSDevCenterBKTask);
                    break;
                }
            }
        }
        if (cancelPSDevCenterBKTask != null) {
            cancelPSDevCenterBKTask.cancel(true, null);
        } else {
            try {
                PSDCBKTaskService psDCBKTaskService = (PSDCBKTaskService)ServiceGlobal.getService(PSDCBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
                PSDCBKTask psDevCenterBKTask = new PSDCBKTask();
                psDevCenterBKTask.setPSDCBKTaskId(strPSDevCenterBKTaskId);
                psDCBKTaskService.get(psDevCenterBKTask);
                if (psDevCenterBKTask.getTaskState() == SysDevBKTaskStateCodeListModel.CREATED || psDevCenterBKTask.getTaskState() == SysDevBKTaskStateCodeListModel.EXECUTING) {
                    psDevCenterBKTask.reset();
                    psDevCenterBKTask.setPSDCBKTaskId(strPSDevCenterBKTaskId);
                    psDevCenterBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CANCELLED);
                    psDevCenterBKTask.setResultInfo(null);
                    psDCBKTaskService.update(psDevCenterBKTask, false);
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

    public synchronized String getCurrentInfo() {
        if (this.singleThreadExecutor == null || this.threadPoolExecutor == null) {
            return null;
        }
        int nQueueCount = this.singleThreadExecutor.getQueue().size();
        int nThreadCount = this.singleThreadExecutor.getPoolSize();
        int nTaskCount = this.singleThreadExecutor.getActiveCount();
        int nTaskCount2 = this.threadPoolExecutor.getActiveCount();
        int nThreadCount2 = this.threadPoolExecutor.getPoolSize();
        int nQueueCount2 = this.psDevCenterBKTaskList.size();
        return StringHelper.format((String)"%1$s==>\u7ebf\u7a0b\u6570[%2$s/%3$s|%6$s/%7$s],\u7ebf\u7a0b\u961f\u5217\u4efb\u52a1\u6570[%4$s],\u672a\u6392\u961f\u4efb\u52a1\u6570[%5$s]", (Object)this.getName(), (Object)nTaskCount, (Object)nThreadCount, (Object)nQueueCount, (Object)nQueueCount2, (Object)nTaskCount2, (Object)nThreadCount2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean isRunning() {
        if (!this.isStarted()) {
            return false;
        }
        boolean bRunning = false;
        Object object = this.objThreadPoolLock;
        synchronized (object) {
            if (this.singleThreadExecutor == null) {
                return bRunning;
            }
            if (this.singleThreadExecutor.getActiveCount() > 0) {
                bRunning = true;
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
            if (bRunning && this.nLastActiveTime + 10000L < (nCurTime = System.currentTimeMillis())) {
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
     */
    public synchronized boolean run() {
        if (!this.isStarted()) {
            return false;
        }
        if (this.singleThreadExecutor == null) {
            log.error((Object)"\u5f53\u524d\u7ebf\u7a0b\u6c60\u65e0\u6548");
            return false;
        }
        IPSDevCenterBKTask iPSDevCenterBKTask = null;
        ArrayList<IPSDevCenterBKTask> arrayList = this.psDevCenterBKTaskList;
        synchronized (arrayList) {
            if (this.psDevCenterBKTaskList.size() > 0) {
                iPSDevCenterBKTask = this.psDevCenterBKTaskList.remove(0);
            }
        }
        if (iPSDevCenterBKTask == null) {
            return false;
        }
        try {
            this.singleThreadExecutor.execute(new PSDevCenterBKTaskHandler(iPSDevCenterBKTask, this));
            log.info((Object)StringHelper.format((String)"%1$s\u8fd0\u884c\u4efb\u52a1[%2$s]", (Object)this.getName(), (Object)iPSDevCenterBKTask.getName()));
            return true;
        }
        catch (Exception ex) {
            iPSDevCenterBKTask.cancel(true, "\u65e0\u6cd5\u8fd0\u884c\u4efb\u52a1\uff0c\u5f53\u524d\u961f\u5217\u5df2\u6ee1");
            log.error((Object)"\u65e0\u6cd5\u8fd0\u884c\u4efb\u52a1\uff0c\u5f53\u524d\u961f\u5217\u5df2\u6ee1");
            return false;
        }
    }

    @Override
    public int getTaskThreadCount() {
        return this.nTaskThreadCount;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setQueuePos(int nPos, int nTotal) {
        this.nQueuePos = nPos;
        try {
            long nCurTime;
            IPSDevCenterBKTask iPSDevCenterBKTask = null;
            ArrayList<IPSDevCenterBKTask> arrayList = this.psDevCenterBKTaskList;
            synchronized (arrayList) {
                if (this.psDevCenterBKTaskList.size() > 0) {
                    iPSDevCenterBKTask = this.psDevCenterBKTaskList.get(0);
                }
            }
            if (iPSDevCenterBKTask != null && this.nLastActiveTime + 10000L < (nCurTime = System.currentTimeMillis())) {
                this.nLastActiveTime = System.currentTimeMillis();
            }
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u66f4\u65b0\u961f\u5217\u4f4d\u7f6e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
        }
    }

    public long getPriority() {
        return System.currentTimeMillis() - this.nLastTaskFinishTime;
    }
}
