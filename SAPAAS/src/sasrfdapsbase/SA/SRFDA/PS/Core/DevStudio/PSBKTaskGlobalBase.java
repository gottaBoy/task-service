/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskGlobal;
import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskGlobalContext;
import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskWork;
import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskWork2;
import SA.SRFDA.PS.Core.DevStudio.PSBKTaskGlobalInfo;
import SA.SRFDA.PS.Core.DevStudio.PSBKTaskSessionBase;
import SA.SRFDA.PS.Core.DevStudio.PSBKTaskWorkHelper;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Util.ThreadLockChecker;
import SA.SRFDA.PS.Web.RemoteCallResult;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSBKTaskGlobalBase
extends PSObjectImpl
implements IPSBKTaskGlobal,
IPSBKTaskGlobalContext {
    private HashMap<String, PSBKTaskSessionBase> psBKTaskSessionMap = new HashMap();
    private ArrayList<PSBKTaskSessionBase> runningPSBKTaskSessionList = new ArrayList();
    private ArrayList<PSBKTaskSessionBase> queuePSBKTaskSessionList = new ArrayList();
    private static final Log log = LogFactory.getLog(PSBKTaskGlobalBase.class);
    private int nQueueCount = 4;
    private ScheduledExecutorService scheduledThreadPool = null;
    private long nLastSortTime = 0L;
    private int nSessionTimeout = 0;
    private String lock_psBKTaskSessionMap = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, int nQueueCount, int nSessionTimeout) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.nQueueCount = nQueueCount;
        this.nLastSortTime = System.currentTimeMillis();
        this.nSessionTimeout = nSessionTimeout;
        if (this.nSessionTimeout <= 0) {
            nSessionTimeout = 60000;
        }
        this.lock_psBKTaskSessionMap = StringHelper.format((String)"psBKTaskSessionMap@%1$s", (Object)this);
        this.onInit();
        this.scheduledThreadPool = Executors.newScheduledThreadPool(1);
        this.scheduledThreadPool.scheduleAtFixedRate(new Runnable(){

            @Override
            public void run() {
                PSBKTaskWorkHelper.execute(new IPSBKTaskWork2(){

                    @Override
                    public void execute(Object obj) {
                        PSBKTaskGlobalBase.this.runPSBKTaskSession();
                    }
                });
            }
        }, 2L, 2L, TimeUnit.SECONDS);
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected PSBKTaskSessionBase getPSBKTaskSession(String strPSBKTaskSessionId) throws Exception {
        Object object;
        boolean bNewSession = false;
        PSBKTaskSessionBase psBKTaskSession = this.psBKTaskSessionMap.get(strPSBKTaskSessionId);
        if (psBKTaskSession == null) {
            psBKTaskSession = this.createPSBKTaskSession();
            psBKTaskSession.setSessionId(strPSBKTaskSessionId);
            this.waitLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
            object = this.psBKTaskSessionMap;
            synchronized (object) {
                PSBKTaskSessionBase psBKTaskSession2 = this.psBKTaskSessionMap.get(strPSBKTaskSessionId);
                if (psBKTaskSession2 == null) {
                    bNewSession = true;
                    this.psBKTaskSessionMap.put(strPSBKTaskSessionId, psBKTaskSession);
                    this.queuePSBKTaskSessionList.add(psBKTaskSession);
                } else {
                    psBKTaskSession = psBKTaskSession2;
                }
                this.enterAndLeaveLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
            }
        }
        try {
            object = psBKTaskSession;
            synchronized (object) {
                if (bNewSession) {
                    psBKTaskSession.init(this.getDAGlobalHelper(), strPSBKTaskSessionId, this);
                    psBKTaskSession.start();
                }
            }
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u542f\u52a8\u4efb\u52a1\u4f1a\u8bdd\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            this.waitLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
            HashMap<String, PSBKTaskSessionBase> hashMap = this.psBKTaskSessionMap;
            synchronized (hashMap) {
                PSBKTaskSessionBase psBKTaskSession2 = this.psBKTaskSessionMap.get(strPSBKTaskSessionId);
                if (psBKTaskSession != null && psBKTaskSession.equals(psBKTaskSession2)) {
                    this.psBKTaskSessionMap.remove(strPSBKTaskSessionId);
                    this.queuePSBKTaskSessionList.remove(psBKTaskSession2);
                }
                this.enterAndLeaveLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
            }
            if (psBKTaskSession != null) {
                psBKTaskSession.reset();
            }
            throw ex;
        }
        return psBKTaskSession;
    }

    protected abstract PSBKTaskSessionBase createPSBKTaskSession() throws Exception;

    @Override
    public void resetPSBKTaskSession(String strPSBKTaskSessionId) throws Exception {
        final String strPSBKTaskSessionId2 = strPSBKTaskSessionId;
        PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

            @Override
            public void execute(Object obj) throws Exception {
                PSBKTaskGlobalBase.this.resetPSBKTaskSession(strPSBKTaskSessionId2, false);
            }
        });
    }

    public int getPSBKTaskSessionTaskCount(String strPSBKTaskSessionId) {
        PSBKTaskSessionBase psBKTaskSession = this.psBKTaskSessionMap.get(strPSBKTaskSessionId);
        if (psBKTaskSession == null) {
            return 0;
        }
        return psBKTaskSession.getPSBKTaskCount();
    }

    public int getPSBKTaskSessionTaskCount(String strPSBKTaskSessionId, boolean bPrepareTask) {
        PSBKTaskSessionBase psBKTaskSession = this.psBKTaskSessionMap.get(strPSBKTaskSessionId);
        if (psBKTaskSession == null) {
            return 0;
        }
        if (bPrepareTask) {
            return psBKTaskSession.getPSBKTaskCount() + (int)psBKTaskSession.getPrepareTaskCount();
        }
        return psBKTaskSession.getPSBKTaskCount();
    }

    public boolean isPSBKTaskSessionBusy(String strPSBKTaskSessionId, boolean bNotExistAsFalse) throws Exception {
        PSBKTaskSessionBase psBKTaskSession = this.psBKTaskSessionMap.get(strPSBKTaskSessionId);
        if (psBKTaskSession == null) {
            if (bNotExistAsFalse) {
                return false;
            }
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u4efb\u52a1\u4f1a\u8bdd[%1$s]", (Object)strPSBKTaskSessionId));
        }
        return psBKTaskSession.isRunning();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void resetPSBKTaskSession(String strPSBKTaskSessionId, boolean bCheck) {
        PSBKTaskSessionBase psBKTaskSession = this.psBKTaskSessionMap.get(strPSBKTaskSessionId);
        if (psBKTaskSession == null) {
            return;
        }
        if (bCheck && (psBKTaskSession.isRunning() || psBKTaskSession.getTaskThreadCount() > 0)) {
            return;
        }
        this.waitLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
        HashMap<String, PSBKTaskSessionBase> hashMap = this.psBKTaskSessionMap;
        synchronized (hashMap) {
            PSBKTaskSessionBase psBKTaskSession2 = this.psBKTaskSessionMap.get(strPSBKTaskSessionId);
            if (psBKTaskSession.equals(psBKTaskSession2)) {
                this.psBKTaskSessionMap.remove(strPSBKTaskSessionId);
                this.runningPSBKTaskSessionList.remove(psBKTaskSession);
                this.queuePSBKTaskSessionList.remove(psBKTaskSession);
            }
            this.enterAndLeaveLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
        }
        if (psBKTaskSession != null) {
            log.info((Object)StringHelper.format((String)"\u79fb\u9664\u540e\u53f0\u4efb\u52a1\u961f\u5217[%1$s]", (Object)psBKTaskSession.getName()));
            psBKTaskSession.stop();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void resetPSBKTaskSession(PSBKTaskSessionBase psBKTaskSession2, boolean bCheck) {
        PSBKTaskSessionBase psBKTaskSession = this.psBKTaskSessionMap.get(psBKTaskSession2.getSessionId());
        if (psBKTaskSession != null && psBKTaskSession2.equals(psBKTaskSession) && bCheck && (psBKTaskSession.isRunning() || psBKTaskSession.getTaskThreadCount() > 0)) {
            return;
        }
        this.waitLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
        HashMap<String, PSBKTaskSessionBase> hashMap = this.psBKTaskSessionMap;
        synchronized (hashMap) {
            PSBKTaskSessionBase psBKTaskSession3 = this.psBKTaskSessionMap.get(psBKTaskSession2.getSessionId());
            if (psBKTaskSession3 != null && psBKTaskSession2.equals(psBKTaskSession3)) {
                this.psBKTaskSessionMap.remove(psBKTaskSession2.getSessionId());
            }
            this.runningPSBKTaskSessionList.remove(psBKTaskSession2);
            this.queuePSBKTaskSessionList.remove(psBKTaskSession2);
            this.enterAndLeaveLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
        }
        log.info((Object)StringHelper.format((String)"\u79fb\u9664\u540e\u53f0\u4efb\u52a1\u961f\u5217[%1$s]", (Object)psBKTaskSession2.getName()));
        psBKTaskSession2.stop();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSBKTaskGlobalInfo getPSBKTaskGlobalInfo() {
        PSBKTaskGlobalInfo psBKTaskGlobalInfo = new PSBKTaskGlobalInfo();
        StringBuilderEx sb = new StringBuilderEx();
        this.waitLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
        HashMap<String, PSBKTaskSessionBase> hashMap = this.psBKTaskSessionMap;
        synchronized (hashMap) {
            String strInfo;
            this.enterLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
            int nSysCount = this.psBKTaskSessionMap.size();
            int nRunningCount = this.runningPSBKTaskSessionList.size();
            int nQueueCount = this.queuePSBKTaskSessionList.size();
            psBKTaskGlobalInfo.setQueueCount(nQueueCount);
            psBKTaskGlobalInfo.setRunningCount(nRunningCount);
            psBKTaskGlobalInfo.setSessionCount(nSysCount);
            sb.append("\u4efb\u52a1\u961f\u5217[%1$s],\u8fd0\u884c[%2$s],\u7b49\u5f85[%3$s]\r\n", (Object)nSysCount, (Object)nRunningCount, (Object)nQueueCount);
            for (PSBKTaskSessionBase psBKTaskSession : this.runningPSBKTaskSessionList) {
                strInfo = psBKTaskSession.getCurrentInfo();
                if (StringHelper.isNullOrEmpty((String)strInfo)) continue;
                sb.append("[\u8fd0\u884c]%1$s\r\n", (Object)strInfo);
            }
            for (PSBKTaskSessionBase psBKTaskSession : this.queuePSBKTaskSessionList) {
                strInfo = psBKTaskSession.getCurrentInfo();
                if (StringHelper.isNullOrEmpty((String)strInfo)) continue;
                sb.append("[\u7b49\u5f85]%1$s\r\n", (Object)strInfo);
            }
            this.leaveLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
        }
        psBKTaskGlobalInfo.setInfo(sb.toString());
        return psBKTaskGlobalInfo;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void fillCurrentInfoResult(RemoteCallResult remoteCallResult) {
        this.waitLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
        HashMap<String, PSBKTaskSessionBase> hashMap = this.psBKTaskSessionMap;
        synchronized (hashMap) {
            JSONObject jo;
            String strInfo;
            this.enterLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
            int nSysCount = this.psBKTaskSessionMap.size();
            int nRunningCount = this.runningPSBKTaskSessionList.size();
            int nQueueCount = this.queuePSBKTaskSessionList.size();
            JSONObject info = new JSONObject();
            info.put("syscount", nSysCount);
            info.put("runcount", nRunningCount);
            info.put("queuecount", nQueueCount);
            remoteCallResult.setUserObject(info);
            for (PSBKTaskSessionBase psBKTaskSession : this.runningPSBKTaskSessionList) {
                strInfo = psBKTaskSession.getCurrentInfo();
                if (StringHelper.isNullOrEmpty((String)strInfo)) continue;
                jo = new JSONObject();
                jo.put("runflag", 1);
                jo.put("sessionid", (Object)psBKTaskSession.getSessionId());
                jo.put("info", (Object)strInfo);
                remoteCallResult.getItems().add(jo);
            }
            for (PSBKTaskSessionBase psBKTaskSession : this.queuePSBKTaskSessionList) {
                strInfo = psBKTaskSession.getCurrentInfo();
                if (StringHelper.isNullOrEmpty((String)strInfo)) continue;
                jo = new JSONObject();
                jo.put("runflag", 0);
                jo.put("sessionid", (Object)psBKTaskSession.getSessionId());
                jo.put("info", (Object)strInfo);
                remoteCallResult.getItems().add(jo);
            }
            this.leaveLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     */
    protected void runPSBKTaskSession() {
        nStartCount = 0;
        nQueueCount = 0;
        this.waitLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
        var3_3 = this.psBKTaskSessionMap;
        synchronized (var3_3) {
            this.enterLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
            nRunCount = this.runningPSBKTaskSessionList.size();
            i = 0;
            while (i < nRunCount) {
                psBKTaskSession = this.runningPSBKTaskSessionList.remove(0);
                if (psBKTaskSession.isRunning()) {
                    this.runningPSBKTaskSessionList.add(psBKTaskSession);
                } else {
                    this.queuePSBKTaskSessionList.add(psBKTaskSession);
                }
                ++i;
            }
            nStartCount = this.nQueueCount - this.runningPSBKTaskSessionList.size();
            nQueueCount = this.queuePSBKTaskSessionList.size();
            this.leaveLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
            // MONITOREXIT @DISABLED, blocks:[0, 7] lbl23 : MonitorExitStatement: MONITOREXIT : var3_3
            if (true) ** GOTO lbl78
        }
        do {
            --nQueueCount;
            psBKTaskSession = null;
            this.waitLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
            nRunCount = this.psBKTaskSessionMap;
            synchronized (nRunCount) {
                if (this.queuePSBKTaskSessionList.size() > 0) {
                    psBKTaskSession = this.queuePSBKTaskSessionList.remove(0);
                }
                this.enterAndLeaveLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
            }
            if (psBKTaskSession == null) break;
            bRemove = false;
            this.waitLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
            i = this.psBKTaskSessionMap;
            synchronized (i) {
                if (!psBKTaskSession.equals(this.psBKTaskSessionMap.get(psBKTaskSession.getSessionId()))) {
                    bRemove = true;
                }
                this.enterAndLeaveLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
            }
            if (bRemove) {
                this.resetPSBKTaskSession(psBKTaskSession, false);
                continue;
            }
            if (psBKTaskSession.isStarted() && psBKTaskSession.run()) {
                this.waitLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
                i = this.psBKTaskSessionMap;
                synchronized (i) {
                    this.runningPSBKTaskSessionList.add(psBKTaskSession);
                    this.enterAndLeaveLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
                }
                if (--nStartCount != 0) continue;
                break;
            }
            this.waitLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
            i = this.psBKTaskSessionMap;
            synchronized (i) {
                this.queuePSBKTaskSessionList.add(psBKTaskSession);
                this.enterAndLeaveLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
            }
lbl78:
            // 4 sources

        } while (nQueueCount > 0 && nStartCount > 0);
        removePSBKTaskSession = null;
        this.waitLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
        bRemove = this.psBKTaskSessionMap;
        synchronized (bRemove) {
            this.enterLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
            if (System.currentTimeMillis() - this.nLastSortTime >= 10000L) {
                Collections.sort(this.queuePSBKTaskSessionList, new Comparator<PSBKTaskSessionBase>(){

                    @Override
                    public int compare(PSBKTaskSessionBase o1, PSBKTaskSessionBase o2) {
                        long nRet = o1.getPriority() - o2.getPriority();
                        if (nRet > 0L) {
                            return -1;
                        }
                        if (nRet < 0L) {
                            return 1;
                        }
                        return 0;
                    }
                });
                nPos = 0;
                nLength = this.queuePSBKTaskSessionList.size();
                for (PSBKTaskSessionBase psBKTaskSession : this.queuePSBKTaskSessionList) {
                    ++nPos;
                    if (!psBKTaskSession.equals(this.psBKTaskSessionMap.get(psBKTaskSession.getSessionId()))) {
                        if (removePSBKTaskSession != null) continue;
                        removePSBKTaskSession = psBKTaskSession;
                        continue;
                    }
                    if (!psBKTaskSession.isStarted() || psBKTaskSession.getPSBKTaskCount() == 0) {
                        if (removePSBKTaskSession != null || psBKTaskSession.isStarted() && System.currentTimeMillis() - psBKTaskSession.getLastTaskFinishTime() < (long)this.nSessionTimeout) continue;
                        removePSBKTaskSession = psBKTaskSession;
                        continue;
                    }
                    psBKTaskSession.setQueuePos(nPos, nLength);
                }
                this.nLastSortTime = System.currentTimeMillis();
            }
            this.leaveLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
        }
        if (removePSBKTaskSession != null) {
            try {
                this.resetPSBKTaskSession(removePSBKTaskSession, true);
            }
            catch (Exception ex) {
                PSBKTaskGlobalBase.log.error((Object)ex);
            }
        }
    }

    public int getSessionCount() {
        return this.psBKTaskSessionMap.size();
    }

    protected final void waitLock(String objLock, String strLockInfo) {
        ThreadLockChecker.getInstance().wait(objLock, strLockInfo);
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

    protected final void removeLock(String objLock) {
        ThreadLockChecker.getInstance().remove(objLock);
    }
}

