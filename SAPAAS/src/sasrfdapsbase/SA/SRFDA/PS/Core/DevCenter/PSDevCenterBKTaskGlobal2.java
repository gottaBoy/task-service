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
package SA.SRFDA.PS.Core.DevCenter;

import SA.SRFDA.PS.Core.DevCenter.IPSDevCenterBKTask;
import SA.SRFDA.PS.Core.DevCenter.IPSDevCenterBKTaskGlobal;
import SA.SRFDA.PS.Core.DevCenter.IPSDevCenterBKTaskGlobalContext;
import SA.SRFDA.PS.Core.DevCenter.IPSDevCenterBTType;
import SA.SRFDA.PS.Core.DevCenter.PSDevCenterBKTaskSession;
import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskWork;
import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskWork2;
import SA.SRFDA.PS.Core.DevStudio.PSBKTaskGlobalInfo;
import SA.SRFDA.PS.Core.DevStudio.PSBKTaskWorkHelper;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDCBKTask;
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

public class PSDevCenterBKTaskGlobal2
extends PSObjectImpl
implements IPSDevCenterBKTaskGlobal,
IPSDevCenterBKTaskGlobalContext {
    protected HashMap<String, PSDevCenterBKTaskSession> psDevCenterBKTaskSessionMap = new HashMap();
    protected ArrayList<PSDevCenterBKTaskSession> runningPSDevCenterBKTaskSessionList = new ArrayList();
    protected ArrayList<PSDevCenterBKTaskSession> queuePSDevCenterBKTaskSessionList = new ArrayList();
    private static final Log log = LogFactory.getLog(PSDevCenterBKTaskSession.class);
    private int nQueueCount = 4;
    private long nLastSortTime = 0L;
    private int nDCTimeout = 0;
    private ScheduledExecutorService scheduledThreadPool = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, int nQueueCount, int nDCTimeout) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.nQueueCount = nQueueCount;
        this.nLastSortTime = System.currentTimeMillis();
        this.nDCTimeout = nDCTimeout;
        if (this.nDCTimeout <= 0) {
            nDCTimeout = 60000;
        }
        this.onInit();
        this.scheduledThreadPool = Executors.newScheduledThreadPool(1);
        this.scheduledThreadPool.scheduleAtFixedRate(new Runnable(){

            @Override
            public void run() {
                PSBKTaskWorkHelper.execute(new IPSBKTaskWork2(){

                    @Override
                    public void execute(Object obj) {
                        PSDevCenterBKTaskGlobal2.this.runPSDevCenterBKTaskSession();
                    }
                });
            }
        }, 2L, 2L, TimeUnit.SECONDS);
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public void addPSDCBKTask(PSDCBKTask psDevCenterBKTask) throws Exception {
        final PSDCBKTask psDevCenterBKTask2 = psDevCenterBKTask;
        PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

            @Override
            public void execute(Object obj) throws Exception {
                PSDevCenterBKTaskGlobal2.this.onAddPSDCBKTask(psDevCenterBKTask2);
            }
        });
    }

    protected void onAddPSDCBKTask(PSDCBKTask psDevCenterBKTask) throws Exception {
        IPSDevCenterBTType iPSDevCenterBTType = this.getPSModelStorage().getPSDevCenterBTType(psDevCenterBKTask.getTASKTYPE());
        IPSDevCenterBKTask iPSDevCenterBKTask = iPSDevCenterBTType.createPSDevCenterBKTask(psDevCenterBKTask);
        iPSDevCenterBKTask.init(this.getDAGlobalHelper(), null, psDevCenterBKTask);
        PSDevCenterBKTaskSession psDevCenterBKTaskSession = this.getPSDevCenterBKTaskSession(psDevCenterBKTask.getPSDEVCENTERID());
        psDevCenterBKTaskSession.addPSBKTask(iPSDevCenterBKTask);
    }

    @Override
    public void cancelPSDCBKTask(PSDCBKTask psDevCenterBKTask) throws Exception {
        final PSDCBKTask psDevCenterBKTask2 = psDevCenterBKTask;
        PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

            @Override
            public void execute(Object obj) throws Exception {
                PSDevCenterBKTaskGlobal2.this.onCancelPSDCBKTask(psDevCenterBKTask2);
            }
        });
    }

    protected void onCancelPSDCBKTask(PSDCBKTask psDevCenterBKTask) throws Exception {
        PSDevCenterBKTaskSession psDevCenterBKTaskSession = this.getPSDevCenterBKTaskSession(psDevCenterBKTask.getPSDEVCENTERID());
        psDevCenterBKTaskSession.cancelPSBKTask(psDevCenterBKTask.getPSDCBKTASKID());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected PSDevCenterBKTaskSession getPSDevCenterBKTaskSession(String strPSDevCenterId) throws Exception {
        boolean bNewSession = false;
        PSDevCenterBKTaskSession psDevCenterBKTaskSession = null;
        Object object = this.psDevCenterBKTaskSessionMap;
        synchronized (object) {
            psDevCenterBKTaskSession = this.psDevCenterBKTaskSessionMap.get(strPSDevCenterId);
            if (psDevCenterBKTaskSession == null) {
                bNewSession = true;
                psDevCenterBKTaskSession = new PSDevCenterBKTaskSession();
                this.psDevCenterBKTaskSessionMap.put(strPSDevCenterId, psDevCenterBKTaskSession);
                this.queuePSDevCenterBKTaskSessionList.add(psDevCenterBKTaskSession);
            }
        }
        object = psDevCenterBKTaskSession;
        synchronized (object) {
            try {
                if (bNewSession) {
                    psDevCenterBKTaskSession.init(this.getDAGlobalHelper(), strPSDevCenterId, this);
                    psDevCenterBKTaskSession.start();
                }
            }
            catch (Exception ex) {
                HashMap<String, PSDevCenterBKTaskSession> hashMap = this.psDevCenterBKTaskSessionMap;
                synchronized (hashMap) {
                    PSDevCenterBKTaskSession psDevCenterBKTaskSession2 = this.psDevCenterBKTaskSessionMap.get(strPSDevCenterId);
                    if (psDevCenterBKTaskSession == psDevCenterBKTaskSession2) {
                        this.psDevCenterBKTaskSessionMap.remove(strPSDevCenterId);
                        this.queuePSDevCenterBKTaskSessionList.remove(psDevCenterBKTaskSession2);
                    }
                }
                throw ex;
            }
        }
        return psDevCenterBKTaskSession;
    }

    public void resetPSDCBKTaskSession(String strPSDevCenterId) throws Exception {
        final String strPSDevCenterId2 = strPSDevCenterId;
        PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

            @Override
            public void execute(Object obj) throws Exception {
                PSDevCenterBKTaskGlobal2.this.onResetPSDCBKTaskSession(strPSDevCenterId2);
            }
        });
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void onResetPSDCBKTaskSession(String strPSDevCenterId) throws Exception {
        PSDevCenterBKTaskSession psDevCenterBKTaskSession = null;
        HashMap<String, PSDevCenterBKTaskSession> hashMap = this.psDevCenterBKTaskSessionMap;
        synchronized (hashMap) {
            psDevCenterBKTaskSession = this.psDevCenterBKTaskSessionMap.remove(strPSDevCenterId);
            if (psDevCenterBKTaskSession != null) {
                this.runningPSDevCenterBKTaskSessionList.remove(psDevCenterBKTaskSession);
                this.queuePSDevCenterBKTaskSessionList.remove(psDevCenterBKTaskSession);
            }
        }
        if (psDevCenterBKTaskSession != null) {
            log.info((Object)StringHelper.format((String)"\u79fb\u9664\u540e\u53f0\u4efb\u52a1\u961f\u5217[%1$s]", (Object)psDevCenterBKTaskSession.getName()));
            psDevCenterBKTaskSession.stop();
            psDevCenterBKTaskSession = null;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String getCurrentInfo() {
        StringBuilderEx sb = new StringBuilderEx();
        HashMap<String, PSDevCenterBKTaskSession> hashMap = this.psDevCenterBKTaskSessionMap;
        synchronized (hashMap) {
            String strInfo;
            int nSysCount = this.psDevCenterBKTaskSessionMap.size();
            int nRunningCount = this.runningPSDevCenterBKTaskSessionList.size();
            int nQueueCount = this.queuePSDevCenterBKTaskSessionList.size();
            sb.append("\u7cfb\u7edf\u53d1\u5e03\u961f\u5217[%1$s],\u8fd0\u884c[%2$s],\u7b49\u5f85[%3$s]\r\n", (Object)nSysCount, (Object)nRunningCount, (Object)nQueueCount);
            for (PSDevCenterBKTaskSession psDevCenterBKTaskSession : this.runningPSDevCenterBKTaskSessionList) {
                strInfo = psDevCenterBKTaskSession.getCurrentInfo();
                if (StringHelper.isNullOrEmpty((String)strInfo)) continue;
                sb.append("[\u8fd0\u884c]%1$s\r\n", (Object)strInfo);
            }
            for (PSDevCenterBKTaskSession psDevCenterBKTaskSession : this.queuePSDevCenterBKTaskSessionList) {
                strInfo = psDevCenterBKTaskSession.getCurrentInfo();
                if (StringHelper.isNullOrEmpty((String)strInfo)) continue;
                sb.append("[\u7b49\u5f85]%1$s\r\n", (Object)strInfo);
            }
        }
        return sb.toString();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSBKTaskGlobalInfo getPSBKTaskGlobalInfo() {
        PSBKTaskGlobalInfo psBKTaskGlobalInfo = new PSBKTaskGlobalInfo();
        StringBuilderEx sb = new StringBuilderEx();
        HashMap<String, PSDevCenterBKTaskSession> hashMap = this.psDevCenterBKTaskSessionMap;
        synchronized (hashMap) {
            String strInfo;
            int nSysCount = this.psDevCenterBKTaskSessionMap.size();
            int nRunningCount = this.runningPSDevCenterBKTaskSessionList.size();
            int nQueueCount = this.queuePSDevCenterBKTaskSessionList.size();
            psBKTaskGlobalInfo.setQueueCount(nQueueCount);
            psBKTaskGlobalInfo.setRunningCount(nRunningCount);
            psBKTaskGlobalInfo.setSessionCount(nSysCount);
            sb.append("\u7cfb\u7edf\u53d1\u5e03\u961f\u5217[%1$s],\u8fd0\u884c[%2$s],\u7b49\u5f85[%3$s]\r\n", (Object)nSysCount, (Object)nRunningCount, (Object)nQueueCount);
            for (PSDevCenterBKTaskSession psDevCenterBKTaskSession : this.runningPSDevCenterBKTaskSessionList) {
                strInfo = psDevCenterBKTaskSession.getCurrentInfo();
                if (StringHelper.isNullOrEmpty((String)strInfo)) continue;
                sb.append("[\u8fd0\u884c]%1$s\r\n", (Object)strInfo);
            }
            for (PSDevCenterBKTaskSession psDevCenterBKTaskSession : this.queuePSDevCenterBKTaskSessionList) {
                strInfo = psDevCenterBKTaskSession.getCurrentInfo();
                if (StringHelper.isNullOrEmpty((String)strInfo)) continue;
                sb.append("[\u7b49\u5f85]%1$s\r\n", (Object)strInfo);
            }
        }
        psBKTaskGlobalInfo.setInfo(sb.toString());
        return psBKTaskGlobalInfo;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void fillCurrentInfoResult(RemoteCallResult remoteCallResult) {
        ArrayList joList = new ArrayList();
        HashMap<String, PSDevCenterBKTaskSession> hashMap = this.psDevCenterBKTaskSessionMap;
        synchronized (hashMap) {
            JSONObject jo;
            String strInfo;
            int nSysCount = this.psDevCenterBKTaskSessionMap.size();
            int nRunningCount = this.runningPSDevCenterBKTaskSessionList.size();
            int nQueueCount = this.queuePSDevCenterBKTaskSessionList.size();
            JSONObject info = new JSONObject();
            info.put("syscount", nSysCount);
            info.put("runcount", nRunningCount);
            info.put("queuecount", nQueueCount);
            remoteCallResult.setUserObject(info);
            for (PSDevCenterBKTaskSession psDevCenterBKTaskSession : this.runningPSDevCenterBKTaskSessionList) {
                strInfo = psDevCenterBKTaskSession.getCurrentInfo();
                if (StringHelper.isNullOrEmpty((String)strInfo)) continue;
                jo = new JSONObject();
                jo.put("runflag", 1);
                jo.put("psdevcenterid", (Object)psDevCenterBKTaskSession.getPSDevCenterId());
                jo.put("info", (Object)strInfo);
                remoteCallResult.getItems().add(jo);
            }
            for (PSDevCenterBKTaskSession psDevCenterBKTaskSession : this.queuePSDevCenterBKTaskSessionList) {
                strInfo = psDevCenterBKTaskSession.getCurrentInfo();
                if (StringHelper.isNullOrEmpty((String)strInfo)) continue;
                jo = new JSONObject();
                jo.put("runflag", 0);
                jo.put("psdevcenterid", (Object)psDevCenterBKTaskSession.getPSDevCenterId());
                jo.put("info", (Object)strInfo);
                remoteCallResult.getItems().add(jo);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     */
    protected void runPSDevCenterBKTaskSession() {
        nStartCount = 0;
        nQueueCount = 0;
        var3_3 = this.psDevCenterBKTaskSessionMap;
        synchronized (var3_3) {
            nRunCount = this.runningPSDevCenterBKTaskSessionList.size();
            i = 0;
            while (i < nRunCount) {
                psDevCenterBKTaskSession = this.runningPSDevCenterBKTaskSessionList.remove(0);
                if (psDevCenterBKTaskSession.isRunning()) {
                    this.runningPSDevCenterBKTaskSessionList.add(psDevCenterBKTaskSession);
                } else {
                    this.queuePSDevCenterBKTaskSessionList.add(psDevCenterBKTaskSession);
                }
                ++i;
            }
            nStartCount = this.nQueueCount - this.runningPSDevCenterBKTaskSessionList.size();
            nQueueCount = this.queuePSDevCenterBKTaskSessionList.size();
            // MONITOREXIT @DISABLED, blocks:[0, 7] lbl20 : MonitorExitStatement: MONITOREXIT : var3_3
            if (true) ** GOTO lbl64
        }
        do {
            --nQueueCount;
            psDevCenterBKTaskSession = null;
            nRunCount = this.psDevCenterBKTaskSessionMap;
            synchronized (nRunCount) {
                if (this.queuePSDevCenterBKTaskSessionList.size() > 0) {
                    psDevCenterBKTaskSession = this.queuePSDevCenterBKTaskSessionList.remove(0);
                }
            }
            if (psDevCenterBKTaskSession == null) break;
            nRunCount = this.psDevCenterBKTaskSessionMap;
            synchronized (nRunCount) {
                if (this.psDevCenterBKTaskSessionMap.get(psDevCenterBKTaskSession.getPSDevCenterId()) != psDevCenterBKTaskSession) {
                    this.resetPSDevCenterBKTaskSession(psDevCenterBKTaskSession, false);
                    continue;
                }
            }
            if (psDevCenterBKTaskSession.run()) {
                nRunCount = this.psDevCenterBKTaskSessionMap;
                synchronized (nRunCount) {
                    this.runningPSDevCenterBKTaskSessionList.add(psDevCenterBKTaskSession);
                }
                if (--nStartCount != 0) continue;
                break;
            }
            nRunCount = this.psDevCenterBKTaskSessionMap;
            synchronized (nRunCount) {
                this.queuePSDevCenterBKTaskSessionList.add(psDevCenterBKTaskSession);
            }
lbl64:
            // 4 sources

        } while (nQueueCount > 0 && nStartCount > 0);
        removePSDevCenterBKTaskSession = null;
        nRunCount = this.psDevCenterBKTaskSessionMap;
        synchronized (nRunCount) {
            if (System.currentTimeMillis() - this.nLastSortTime >= 10000L) {
                Collections.sort(this.queuePSDevCenterBKTaskSessionList, new Comparator<PSDevCenterBKTaskSession>(){

                    @Override
                    public int compare(PSDevCenterBKTaskSession o1, PSDevCenterBKTaskSession o2) {
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
                nLength = this.queuePSDevCenterBKTaskSessionList.size();
                for (PSDevCenterBKTaskSession psDevCenterBKTaskSession : this.queuePSDevCenterBKTaskSessionList) {
                    ++nPos;
                    if (this.psDevCenterBKTaskSessionMap.get(psDevCenterBKTaskSession.getPSDevCenterId()) != psDevCenterBKTaskSession) {
                        if (removePSDevCenterBKTaskSession != null) continue;
                        removePSDevCenterBKTaskSession = psDevCenterBKTaskSession;
                        continue;
                    }
                    if (!psDevCenterBKTaskSession.isStarted() || psDevCenterBKTaskSession.getPSBKTaskCount() == 0) {
                        if (removePSDevCenterBKTaskSession != null || psDevCenterBKTaskSession.isStarted() && System.currentTimeMillis() - psDevCenterBKTaskSession.getLastTaskFinishTime() < (long)this.nDCTimeout) continue;
                        removePSDevCenterBKTaskSession = psDevCenterBKTaskSession;
                        continue;
                    }
                    psDevCenterBKTaskSession.setQueuePos(nPos, nLength);
                }
                this.nLastSortTime = System.currentTimeMillis();
            }
        }
        if (removePSDevCenterBKTaskSession != null) {
            try {
                this.resetPSDevCenterBKTaskSession(removePSDevCenterBKTaskSession, true);
            }
            catch (Exception ex) {
                PSDevCenterBKTaskGlobal2.log.error((Object)ex);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void resetPSDevCenterBKTaskSession(PSDevCenterBKTaskSession psDevCenterBKTaskSession2, boolean bCheck) {
        HashMap<String, PSDevCenterBKTaskSession> hashMap = this.psDevCenterBKTaskSessionMap;
        synchronized (hashMap) {
            PSDevCenterBKTaskSession psDevCenterBKTaskSession = this.psDevCenterBKTaskSessionMap.get(psDevCenterBKTaskSession2.getPSDevCenterId());
            if (psDevCenterBKTaskSession != null && psDevCenterBKTaskSession == psDevCenterBKTaskSession2) {
                if (bCheck && (psDevCenterBKTaskSession.isRunning() || psDevCenterBKTaskSession.getTaskThreadCount() > 0)) {
                    return;
                }
                this.psDevCenterBKTaskSessionMap.remove(psDevCenterBKTaskSession2.getPSDevCenterId());
            }
            this.runningPSDevCenterBKTaskSessionList.remove(psDevCenterBKTaskSession2);
            this.queuePSDevCenterBKTaskSessionList.remove(psDevCenterBKTaskSession2);
        }
        log.info((Object)StringHelper.format((String)"\u79fb\u9664\u540e\u53f0\u4efb\u52a1\u961f\u5217[%1$s]", (Object)psDevCenterBKTaskSession2.getName()));
        psDevCenterBKTaskSession2.stop();
        psDevCenterBKTaskSession2 = null;
    }

    public int getSessionCount() {
        return this.psDevCenterBKTaskSessionMap.size();
    }

    @Override
    public void resetPSBKTaskSession(String strSessionId) throws Exception {
        this.resetPSDCBKTaskSession(strSessionId);
    }
}

