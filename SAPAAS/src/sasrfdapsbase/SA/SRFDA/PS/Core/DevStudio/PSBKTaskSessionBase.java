/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.Helper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.PS.Core.DevStudio.IPSBKTask;
import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskGlobalContext;
import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskSessionContext;
import SA.SRFDA.PS.Core.DevStudio.PSBKTaskHandler;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Util.ThreadLockChecker;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.Helper;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSBKTaskSessionBase
extends PSObjectImpl
implements IPSBKTaskSessionContext {
    private Boolean bStarted = false;
    private long nLastTaskFinishTime = 0L;
    protected ArrayList<IPSBKTask> psBKTaskList = new ArrayList();
    private static final Log log = LogFactory.getLog(PSBKTaskSessionBase.class);
    private IPSBKTask activePSBKTask = null;
    private ThreadPoolExecutor singleThreadExecutor = null;
    private IPSBKTaskGlobalContext iPSBKTaskGlobalContext = null;
    private ThreadPoolExecutor threadPoolExecutor = null;
    private int nTaskThreadCount = 3;
    private long nLastStartTime = 0L;
    private int nQueuePos = -1;
    private Boolean bLastRunFlag = false;
    private String strPSBKTaskSessionId = null;
    private String lock_psBKTaskList = null;
    private String lock_bLastRunFlag = null;
    private String lock_bStarted = null;
    private Object objLastRunFlagLock = new Object();
    private Object objStartedLock = new Object();
    private String strQueueInfo = null;
    private long nPrepareTaskCounter = 0L;

    public PSBKTaskSessionBase() {
        this.setId(Helper.GenGuidEx());
    }

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, String strPSBKTaskSessionId, IPSBKTaskGlobalContext iPSBKTaskGlobalContext) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.iPSBKTaskGlobalContext = iPSBKTaskGlobalContext;
        this.strPSBKTaskSessionId = strPSBKTaskSessionId;
        this.nTaskThreadCount = this.onCalcTaskThreadCount();
        this.nLastTaskFinishTime = System.currentTimeMillis();
        this.lock_psBKTaskList = StringHelper.format((String)"psBKTaskList@%1$s", (Object)this);
        this.lock_bLastRunFlag = StringHelper.format((String)"bLastRunFlag@%1$s", (Object)this);
        this.lock_bStarted = StringHelper.format((String)"bStarted@%1$s", (Object)this);
        this.onInit();
        log.info((Object)StringHelper.format((String)"%1$s\u521d\u59cb\u5316", (Object)this.getName()));
    }

    protected abstract int onCalcTaskThreadCount() throws Exception;

    public String getSessionId() {
        return this.strPSBKTaskSessionId;
    }

    public void setSessionId(String strPSBKTaskSessionId) {
        this.strPSBKTaskSessionId = strPSBKTaskSessionId;
    }

    public boolean isStarted() {
        boolean bStart = this.bStarted;
        return bStart;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void setStarted(boolean bStarted) {
        this.waitLock(this.lock_bStarted, ThreadLockChecker.getCodeInfo());
        Object object = this.objStartedLock;
        synchronized (object) {
            this.onSetStarted(this.bStarted);
            this.enterAndLeaveLock(this.lock_bStarted, ThreadLockChecker.getCodeInfo());
        }
    }

    protected void onSetStarted(boolean bStarted) {
        this.bStarted = bStarted;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void start() {
        if (this.isStarted()) {
            return;
        }
        this.waitLock(this.lock_bStarted, ThreadLockChecker.getCodeInfo());
        Object object = this.objStartedLock;
        synchronized (object) {
            this.enterLock(this.lock_bStarted, ThreadLockChecker.getCodeInfo());
            if (!this.bStarted.booleanValue()) {
                ThreadPoolExecutor singleThreadExecutor = this.createMainThreadPoolExecutor();
                ThreadPoolExecutor threadPoolExecutor = this.createWorkThreadPoolExecutor();
                this.singleThreadExecutor = singleThreadExecutor;
                this.threadPoolExecutor = threadPoolExecutor;
                this.onStart();
                this.onSetStarted(true);
            }
            this.leaveLock(this.lock_bStarted, ThreadLockChecker.getCodeInfo());
        }
    }

    protected void onStart() {
    }

    protected ThreadPoolExecutor createMainThreadPoolExecutor() {
        return new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(8), new ThreadPoolExecutor.AbortPolicy());
    }

    protected ThreadPoolExecutor createWorkThreadPoolExecutor() {
        return new ThreadPoolExecutor(this.getTaskThreadCount(), this.getTaskThreadCount() + 10, 30L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10), new ThreadPoolExecutor.AbortPolicy());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void stop() {
        ArrayList<IPSBKTask> singleThreadExecutor;
        if (!this.isStarted()) {
            return;
        }
        List<Runnable> list2 = null;
        this.waitLock(this.lock_bStarted, ThreadLockChecker.getCodeInfo());
        Object object = this.objStartedLock;
        synchronized (object) {
            this.enterLock(this.lock_bStarted, ThreadLockChecker.getCodeInfo());
            if (this.bStarted.booleanValue()) {
                ThreadPoolExecutor threadPoolExecutor;
                this.onSetStarted(false);
                this.onStop();
                singleThreadExecutor = this.singleThreadExecutor;
                if (singleThreadExecutor != null) {
                    list2 = ((ThreadPoolExecutor)((Object)singleThreadExecutor)).shutdownNow();
                }
                if ((threadPoolExecutor = this.threadPoolExecutor) != null) {
                    List<Runnable> list = threadPoolExecutor.shutdownNow();
                }
                this.singleThreadExecutor = null;
                this.threadPoolExecutor = null;
            }
            this.leaveLock(this.lock_bStarted, ThreadLockChecker.getCodeInfo());
        }
        if (list2 != null) {
            for (Runnable runnable : list2) {
                PSBKTaskHandler psBKTaskHandler = (PSBKTaskHandler)runnable;
                psBKTaskHandler.cancel(true, null);
            }
        }
        try {
            ArrayList<IPSBKTask> psBKTaskList2 = null;
            this.waitLock(this.lock_psBKTaskList, ThreadLockChecker.getCodeInfo());
            singleThreadExecutor = this.psBKTaskList;
            synchronized (singleThreadExecutor) {
                if (this.psBKTaskList.size() > 0) {
                    psBKTaskList2 = new ArrayList<IPSBKTask>();
                    psBKTaskList2.addAll(this.psBKTaskList);
                    this.psBKTaskList.clear();
                }
                this.enterAndLeaveLock(this.lock_psBKTaskList, ThreadLockChecker.getCodeInfo());
            }
            if (psBKTaskList2 != null) {
                for (IPSBKTask iPSBKTask : psBKTaskList2) {
                    iPSBKTask.cancel(true, null);
                }
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        this.reset();
    }

    protected void onStop() {
    }

    protected void reset() {
        this.removeLock(this.lock_bLastRunFlag);
        this.removeLock(this.lock_bStarted);
        this.removeLock(this.lock_psBKTaskList);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addPSBKTask(IPSBKTask iPSBKTask) throws Exception {
        if (!this.isStarted()) {
            throw new Exception("\u4efb\u52a1\u5bb9\u5668\u8fd8\u672a\u542f\u52a8\uff0c\u4e0d\u80fd\u6dfb\u52a0\u4efb\u52a1");
        }
        this.waitLock(this.lock_psBKTaskList, ThreadLockChecker.getCodeInfo());
        ArrayList<IPSBKTask> arrayList = this.psBKTaskList;
        synchronized (arrayList) {
            this.psBKTaskList.add(iPSBKTask);
            this.enterAndLeaveLock(this.lock_psBKTaskList, ThreadLockChecker.getCodeInfo());
        }
        log.info((Object)StringHelper.format((String)"%1$s\u6dfb\u52a0\u4efb\u52a1[%2$s]\uff0c\u5f53\u524d\u9876\u7ea7\u4efb\u52a1\u6570[%3$s]", (Object)this.getName(), (Object)iPSBKTask.getName(), (Object)this.psBKTaskList.size()));
        this.onAddPSBKTask(iPSBKTask);
    }

    protected void onAddPSBKTask(IPSBKTask iPSBKTask) {
    }

    public int getPSBKTaskCount() {
        ArrayList<IPSBKTask> psBKTaskList = this.psBKTaskList;
        int nCount = psBKTaskList.size();
        if (this.activePSBKTask != null) {
            ++nCount;
        }
        return nCount;
    }

    public long getLastTaskFinishTime() {
        return this.nLastTaskFinishTime;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void cancelPSBKTask(String strPSBKTaskId) throws Exception {
        if (!this.onBeforeCancelPSBKTask(strPSBKTaskId)) {
            return;
        }
        IPSBKTask cancelPSBKTask = null;
        this.waitLock(this.lock_psBKTaskList, ThreadLockChecker.getCodeInfo());
        ArrayList<IPSBKTask> arrayList = this.psBKTaskList;
        synchronized (arrayList) {
            this.enterLock(this.lock_psBKTaskList, ThreadLockChecker.getCodeInfo());
            if (this.activePSBKTask != null && StringHelper.compare((String)this.activePSBKTask.getId(), (String)strPSBKTaskId, (boolean)true) == 0) {
                cancelPSBKTask = this.activePSBKTask;
                this.activePSBKTask = null;
            }
            if (cancelPSBKTask == null) {
                for (IPSBKTask iPSBKTask : this.psBKTaskList) {
                    if (StringHelper.compare((String)iPSBKTask.getId(), (String)strPSBKTaskId, (boolean)true) != 0) continue;
                    cancelPSBKTask = iPSBKTask;
                    this.psBKTaskList.remove(iPSBKTask);
                    break;
                }
            }
            this.leaveLock(this.lock_psBKTaskList, ThreadLockChecker.getCodeInfo());
        }
        if (cancelPSBKTask != null) {
            cancelPSBKTask.cancel(true, null);
        }
        this.onAfterCancelPSBKTask(strPSBKTaskId, cancelPSBKTask);
    }

    protected boolean onBeforeCancelPSBKTask(String strPSBKTaskId) throws Exception {
        return true;
    }

    protected void onAfterCancelPSBKTask(String strPSBKTaskId, IPSBKTask cancelPSBKTask) throws Exception {
    }

    @Override
    public void executeTask(Runnable command) {
        this.threadPoolExecutor.execute(command);
    }

    public String getCurrentInfo() {
        if (!this.isStarted()) {
            return null;
        }
        ThreadPoolExecutor singleThreadExecutor = this.singleThreadExecutor;
        ThreadPoolExecutor threadPoolExecutor = this.threadPoolExecutor;
        if (singleThreadExecutor == null || threadPoolExecutor == null) {
            return null;
        }
        int nQueueCount = singleThreadExecutor.getQueue().size();
        int nThreadCount = singleThreadExecutor.getPoolSize();
        int nTaskCount = singleThreadExecutor.getActiveCount();
        int nTaskCount2 = threadPoolExecutor.getActiveCount();
        int nThreadCount2 = threadPoolExecutor.getPoolSize();
        int nQueueCount2 = this.psBKTaskList.size();
        return StringHelper.format((String)"%1$s==>\u7ebf\u7a0b\u6570[%2$s/%3$s|%6$s/%7$s],\u7ebf\u7a0b\u961f\u5217\u4efb\u52a1\u6570[%4$s],\u672a\u6392\u961f\u4efb\u52a1\u6570[%5$s]", (Object)this.getName(), (Object)nTaskCount, (Object)nThreadCount, (Object)nQueueCount, (Object)nQueueCount2, (Object)nTaskCount2, (Object)nThreadCount2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean isRunning() {
        boolean bLastRunFlag2;
        if (!this.isStarted()) {
            return false;
        }
        boolean bRunning = false;
        ThreadPoolExecutor singleThreadExecutor = this.singleThreadExecutor;
        if (singleThreadExecutor != null && singleThreadExecutor.getActiveCount() > 0) {
            bRunning = true;
        }
        if (bRunning != (bLastRunFlag2 = this.bLastRunFlag.booleanValue())) {
            this.waitLock(this.lock_bLastRunFlag, ThreadLockChecker.getCodeInfo());
            Object object = this.objLastRunFlagLock;
            synchronized (object) {
                if (bRunning != this.bLastRunFlag) {
                    this.bLastRunFlag = bRunning;
                    if (!this.bLastRunFlag.booleanValue()) {
                        this.nLastTaskFinishTime = System.currentTimeMillis();
                    }
                }
                this.enterAndLeaveLock(this.lock_bLastRunFlag, ThreadLockChecker.getCodeInfo());
            }
        }
        this.onTestRunning(bRunning);
        return bRunning;
    }

    protected void onTestRunning(boolean bRunning) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean run() {
        ArrayList<IPSBKTask> arrayList;
        IPSBKTask iPSBKTask;
        ThreadPoolExecutor singleThreadExecutor;
        block27: {
            if (!this.onBeforeRun()) {
                return false;
            }
            this.nLastStartTime = 0L;
            this.waitLock(this.lock_psBKTaskList, ThreadLockChecker.getCodeInfo());
            ArrayList<IPSBKTask> arrayList2 = this.psBKTaskList;
            synchronized (arrayList2) {
                this.activePSBKTask = null;
                this.enterAndLeaveLock(this.lock_psBKTaskList, ThreadLockChecker.getCodeInfo());
            }
            if (!this.isStarted()) {
                return false;
            }
            singleThreadExecutor = this.singleThreadExecutor;
            if (singleThreadExecutor == null) {
                log.error((Object)"\u5f53\u524d\u7ebf\u7a0b\u6c60\u65e0\u6548");
                return false;
            }
            iPSBKTask = null;
            ArrayList<IPSBKTask> psBKTaskList2 = this.psBKTaskList;
            if (psBKTaskList2.size() > 0) {
                this.waitLock(this.lock_psBKTaskList, ThreadLockChecker.getCodeInfo());
                arrayList = this.psBKTaskList;
                synchronized (arrayList) {
                    if (this.psBKTaskList.size() > 0) {
                        iPSBKTask = this.psBKTaskList.remove(0);
                    }
                    this.enterAndLeaveLock(this.lock_psBKTaskList, ThreadLockChecker.getCodeInfo());
                }
            }
            if (iPSBKTask != null) {
                try {
                    if (this.onTestRunPSBKTask(iPSBKTask)) break block27;
                    this.waitLock(this.lock_psBKTaskList, ThreadLockChecker.getCodeInfo());
                    psBKTaskList2 = this.psBKTaskList;
                    synchronized (psBKTaskList2) {
                        this.psBKTaskList.add(0, iPSBKTask);
                        this.enterAndLeaveLock(this.lock_psBKTaskList, ThreadLockChecker.getCodeInfo());
                    }
                    iPSBKTask = null;
                    return false;
                }
                catch (Exception ex) {
                    iPSBKTask.cancel(true, ex.getMessage());
                    log.error((Object)ex);
                    return false;
                }
            }
        }
        if (iPSBKTask == null) {
            return false;
        }
        this.nLastStartTime = System.currentTimeMillis();
        try {
            this.waitLock(this.lock_psBKTaskList, ThreadLockChecker.getCodeInfo());
            ArrayList<IPSBKTask> ex = this.psBKTaskList;
            synchronized (ex) {
                this.activePSBKTask = iPSBKTask;
                this.enterAndLeaveLock(this.lock_psBKTaskList, ThreadLockChecker.getCodeInfo());
            }
            if (singleThreadExecutor != null) {
                singleThreadExecutor.execute(new PSBKTaskHandler(iPSBKTask, this));
            }
            log.info((Object)StringHelper.format((String)"%1$s\u8fd0\u884c\u4efb\u52a1[%2$s]", (Object)this.getName(), (Object)iPSBKTask.getName()));
            this.onRunPSBKTask(iPSBKTask, false);
            return true;
        }
        catch (Exception ex) {
            this.waitLock(this.lock_psBKTaskList, ThreadLockChecker.getCodeInfo());
            arrayList = this.psBKTaskList;
            synchronized (arrayList) {
                this.activePSBKTask = null;
                this.enterAndLeaveLock(this.lock_psBKTaskList, ThreadLockChecker.getCodeInfo());
            }
            iPSBKTask.cancel(true, "\u65e0\u6cd5\u8fd0\u884c\u4efb\u52a1\uff0c\u5f53\u524d\u961f\u5217\u5df2\u6ee1");
            log.error((Object)"\u65e0\u6cd5\u8fd0\u884c\u4efb\u52a1\uff0c\u5f53\u524d\u961f\u5217\u5df2\u6ee1");
            this.onRunPSBKTask(iPSBKTask, true);
            return false;
        }
    }

    protected boolean onBeforeRun() {
        return true;
    }

    protected boolean onTestRunPSBKTask(IPSBKTask iPSBKTask) throws Exception {
        return true;
    }

    protected void onRunPSBKTask(IPSBKTask iPSBKTask, boolean bCancel) {
    }

    @Override
    public int getTaskThreadCount() {
        return this.nTaskThreadCount;
    }

    public long getLastTaskStartTime() {
        return this.nLastStartTime;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setQueuePos(int nPos, int nTotal) {
        this.nQueuePos = nPos;
        try {
            IPSBKTask iPSBKTask = null;
            this.waitLock(this.lock_psBKTaskList, ThreadLockChecker.getCodeInfo());
            ArrayList<IPSBKTask> arrayList = this.psBKTaskList;
            synchronized (arrayList) {
                if (this.psBKTaskList.size() > 0) {
                    iPSBKTask = this.psBKTaskList.get(0);
                }
                this.enterAndLeaveLock(this.lock_psBKTaskList, ThreadLockChecker.getCodeInfo());
            }
            if (iPSBKTask != null) {
                iPSBKTask.setQueueInfo(nPos, nTotal);
            }
            this.onSetQueuePos(nPos, nTotal, iPSBKTask);
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u66f4\u65b0\u961f\u5217\u4f4d\u7f6e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
        }
    }

    protected void onSetQueuePos(int nPos, int nTotal, IPSBKTask iPSBKTask) {
    }

    public long getPriority() {
        return System.currentTimeMillis() - this.nLastTaskFinishTime;
    }

    protected final void waitLock(String objLock, String strLockInfo) {
        ThreadLockChecker.getInstance().wait(objLock, strLockInfo);
    }

    protected final void removeLock(String objLock) {
        ThreadLockChecker.getInstance().remove(objLock);
    }

    protected final void enterLock(String objLock, String strLockInfo) {
        ThreadLockChecker.getInstance().enter(objLock, strLockInfo);
    }

    protected final void leaveLock(String objLock, String strLockInfo) {
        ThreadLockChecker.getInstance().leave(objLock, strLockInfo);
    }

    protected final void enterAndLeaveLock(String objLock, String strLockInfo) {
        ThreadLockChecker.getInstance().enterAndLeave(objLock, strLockInfo);
    }

    public boolean equals(Object obj) {
        if (obj != null && obj instanceof PSBKTaskSessionBase) {
            return StringHelper.compare((String)this.getId(), (String)((PSBKTaskSessionBase)obj).getId(), (boolean)false) == 0;
        }
        return super.equals(obj);
    }

    @Override
    public String getQueueInfo() {
        return this.strQueueInfo;
    }

    protected void setQueueInfo(String strQueueInfo) {
        this.strQueueInfo = strQueueInfo;
    }

    @Override
    public boolean getLastRunFlag() {
        return this.bLastRunFlag;
    }

    public synchronized void incrementPrepareTask() {
        ++this.nPrepareTaskCounter;
    }

    public synchronized void decrementPrepareTask() {
        if (this.nPrepareTaskCounter > 0L) {
            --this.nPrepareTaskCounter;
        }
    }

    public synchronized long getPrepareTaskCount() {
        return this.nPrepareTaskCounter;
    }
}

