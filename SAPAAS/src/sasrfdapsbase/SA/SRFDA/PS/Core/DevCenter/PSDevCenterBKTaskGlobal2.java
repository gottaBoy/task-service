package SA.SRFDA.PS.Core.DevCenter;

import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskWork;
import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskWork2;
import SA.SRFDA.PS.Core.DevStudio.PSBKTaskGlobalInfo;
import SA.SRFDA.PS.Core.DevStudio.PSBKTaskWorkHelper;
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

public class PSDevCenterBKTaskGlobal2 extends PSObjectImpl implements IPSDevCenterBKTaskGlobal, IPSDevCenterBKTaskGlobalContext {
   protected HashMap<String, PSDevCenterBKTaskSession> psDevCenterBKTaskSessionMap = new HashMap<>();
   protected ArrayList<PSDevCenterBKTaskSession> runningPSDevCenterBKTaskSessionList = new ArrayList<>();
   protected ArrayList<PSDevCenterBKTaskSession> queuePSDevCenterBKTaskSessionList = new ArrayList<>();
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
         int var4 = '\uea60';
      }

      this.onInit();
      this.scheduledThreadPool = Executors.newScheduledThreadPool(1);
      this.scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
         @Override
         public void run() {
            PSBKTaskWorkHelper.execute(new IPSBKTaskWork2() {
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
      PSBKTaskWorkHelper.execute(new IPSBKTaskWork() {
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
      PSBKTaskWorkHelper.execute(new IPSBKTaskWork() {
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

   protected PSDevCenterBKTaskSession getPSDevCenterBKTaskSession(String strPSDevCenterId) throws Exception {
      boolean bNewSession = false;
      PSDevCenterBKTaskSession psDevCenterBKTaskSession = null;
      synchronized (this.psDevCenterBKTaskSessionMap) {
         psDevCenterBKTaskSession = this.psDevCenterBKTaskSessionMap.get(strPSDevCenterId);
         if (psDevCenterBKTaskSession == null) {
            bNewSession = true;
            psDevCenterBKTaskSession = new PSDevCenterBKTaskSession();
            this.psDevCenterBKTaskSessionMap.put(strPSDevCenterId, psDevCenterBKTaskSession);
            this.queuePSDevCenterBKTaskSessionList.add(psDevCenterBKTaskSession);
         }
      }

      synchronized (psDevCenterBKTaskSession) {
         try {
            if (bNewSession) {
               psDevCenterBKTaskSession.init(this.getDAGlobalHelper(), strPSDevCenterId, this);
               psDevCenterBKTaskSession.start();
            }
         } catch (Exception ex) {
            synchronized (this.psDevCenterBKTaskSessionMap) {
               PSDevCenterBKTaskSession psDevCenterBKTaskSession2 = this.psDevCenterBKTaskSessionMap.get(strPSDevCenterId);
               if (psDevCenterBKTaskSession == psDevCenterBKTaskSession2) {
                  this.psDevCenterBKTaskSessionMap.remove(strPSDevCenterId);
                  this.queuePSDevCenterBKTaskSessionList.remove(psDevCenterBKTaskSession2);
               }
            }

            throw ex;
         }

         return psDevCenterBKTaskSession;
      }
   }

   public void resetPSDCBKTaskSession(String strPSDevCenterId) throws Exception {
      final String strPSDevCenterId2 = strPSDevCenterId;
      PSBKTaskWorkHelper.execute(new IPSBKTaskWork() {
         @Override
         public void execute(Object obj) throws Exception {
            PSDevCenterBKTaskGlobal2.this.onResetPSDCBKTaskSession(strPSDevCenterId2);
         }
      });
   }

   protected void onResetPSDCBKTaskSession(String strPSDevCenterId) throws Exception {
      PSDevCenterBKTaskSession psDevCenterBKTaskSession = null;
      synchronized (this.psDevCenterBKTaskSessionMap) {
         psDevCenterBKTaskSession = this.psDevCenterBKTaskSessionMap.remove(strPSDevCenterId);
         if (psDevCenterBKTaskSession != null) {
            this.runningPSDevCenterBKTaskSessionList.remove(psDevCenterBKTaskSession);
            this.queuePSDevCenterBKTaskSessionList.remove(psDevCenterBKTaskSession);
         }
      }

      if (psDevCenterBKTaskSession != null) {
         log.info(StringHelper.format("移除后台任务队列[%1$s]", psDevCenterBKTaskSession.getName()));
         psDevCenterBKTaskSession.stop();
         psDevCenterBKTaskSession = null;
      }
   }

   public String getCurrentInfo() {
      StringBuilderEx sb = new StringBuilderEx();
      synchronized (this.psDevCenterBKTaskSessionMap) {
         int nSysCount = this.psDevCenterBKTaskSessionMap.size();
         int nRunningCount = this.runningPSDevCenterBKTaskSessionList.size();
         int nQueueCount = this.queuePSDevCenterBKTaskSessionList.size();
         sb.append("系统发布队列[%1$s],运行[%2$s],等待[%3$s]\r\n", nSysCount, nRunningCount, nQueueCount);

         for (PSDevCenterBKTaskSession psDevCenterBKTaskSession : this.runningPSDevCenterBKTaskSessionList) {
            String strInfo = psDevCenterBKTaskSession.getCurrentInfo();
            if (!StringHelper.isNullOrEmpty(strInfo)) {
               sb.append("[运行]%1$s\r\n", strInfo);
            }
         }

         for (PSDevCenterBKTaskSession psDevCenterBKTaskSession : this.queuePSDevCenterBKTaskSessionList) {
            String strInfo = psDevCenterBKTaskSession.getCurrentInfo();
            if (!StringHelper.isNullOrEmpty(strInfo)) {
               sb.append("[等待]%1$s\r\n", strInfo);
            }
         }
      }

      return sb.toString();
   }

   public PSBKTaskGlobalInfo getPSBKTaskGlobalInfo() {
      PSBKTaskGlobalInfo psBKTaskGlobalInfo = new PSBKTaskGlobalInfo();
      StringBuilderEx sb = new StringBuilderEx();
      synchronized (this.psDevCenterBKTaskSessionMap) {
         int nSysCount = this.psDevCenterBKTaskSessionMap.size();
         int nRunningCount = this.runningPSDevCenterBKTaskSessionList.size();
         int nQueueCount = this.queuePSDevCenterBKTaskSessionList.size();
         psBKTaskGlobalInfo.setQueueCount(nQueueCount);
         psBKTaskGlobalInfo.setRunningCount(nRunningCount);
         psBKTaskGlobalInfo.setSessionCount(nSysCount);
         sb.append("系统发布队列[%1$s],运行[%2$s],等待[%3$s]\r\n", nSysCount, nRunningCount, nQueueCount);

         for (PSDevCenterBKTaskSession psDevCenterBKTaskSession : this.runningPSDevCenterBKTaskSessionList) {
            String strInfo = psDevCenterBKTaskSession.getCurrentInfo();
            if (!StringHelper.isNullOrEmpty(strInfo)) {
               sb.append("[运行]%1$s\r\n", strInfo);
            }
         }

         for (PSDevCenterBKTaskSession psDevCenterBKTaskSession : this.queuePSDevCenterBKTaskSessionList) {
            String strInfo = psDevCenterBKTaskSession.getCurrentInfo();
            if (!StringHelper.isNullOrEmpty(strInfo)) {
               sb.append("[等待]%1$s\r\n", strInfo);
            }
         }
      }

      psBKTaskGlobalInfo.setInfo(sb.toString());
      return psBKTaskGlobalInfo;
   }

   public void fillCurrentInfoResult(RemoteCallResult remoteCallResult) {
      new ArrayList();
      synchronized (this.psDevCenterBKTaskSessionMap) {
         int nSysCount = this.psDevCenterBKTaskSessionMap.size();
         int nRunningCount = this.runningPSDevCenterBKTaskSessionList.size();
         int nQueueCount = this.queuePSDevCenterBKTaskSessionList.size();
         JSONObject info = new JSONObject();
         info.put("syscount", nSysCount);
         info.put("runcount", nRunningCount);
         info.put("queuecount", nQueueCount);
         remoteCallResult.setUserObject(info);

         for (PSDevCenterBKTaskSession psDevCenterBKTaskSession : this.runningPSDevCenterBKTaskSessionList) {
            String strInfo = psDevCenterBKTaskSession.getCurrentInfo();
            if (!StringHelper.isNullOrEmpty(strInfo)) {
               JSONObject jo = new JSONObject();
               jo.put("runflag", 1);
               jo.put("psdevcenterid", psDevCenterBKTaskSession.getPSDevCenterId());
               jo.put("info", strInfo);
               remoteCallResult.getItems().add(jo);
            }
         }

         for (PSDevCenterBKTaskSession psDevCenterBKTaskSession : this.queuePSDevCenterBKTaskSessionList) {
            String strInfo = psDevCenterBKTaskSession.getCurrentInfo();
            if (!StringHelper.isNullOrEmpty(strInfo)) {
               JSONObject jo = new JSONObject();
               jo.put("runflag", 0);
               jo.put("psdevcenterid", psDevCenterBKTaskSession.getPSDevCenterId());
               jo.put("info", strInfo);
               remoteCallResult.getItems().add(jo);
            }
         }
      }
   }

   protected void runPSDevCenterBKTaskSession() {
      int nStartCount = 0;
      int nQueueCount = 0;
      synchronized (this.psDevCenterBKTaskSessionMap) {
         int nRunCount = this.runningPSDevCenterBKTaskSessionList.size();

         for (int i = 0; i < nRunCount; i++) {
            PSDevCenterBKTaskSession psDevCenterBKTaskSession = this.runningPSDevCenterBKTaskSessionList.remove(0);
            if (psDevCenterBKTaskSession.isRunning()) {
               this.runningPSDevCenterBKTaskSessionList.add(psDevCenterBKTaskSession);
            } else {
               this.queuePSDevCenterBKTaskSessionList.add(psDevCenterBKTaskSession);
            }
         }

         nStartCount = this.nQueueCount - this.runningPSDevCenterBKTaskSessionList.size();
         nQueueCount = this.queuePSDevCenterBKTaskSessionList.size();
      }

      while (nQueueCount > 0 && nStartCount > 0) {
         nQueueCount--;
         PSDevCenterBKTaskSession psDevCenterBKTaskSession = null;
         synchronized (this.psDevCenterBKTaskSessionMap) {
            if (this.queuePSDevCenterBKTaskSessionList.size() > 0) {
               psDevCenterBKTaskSession = this.queuePSDevCenterBKTaskSessionList.remove(0);
            }
         }

         if (psDevCenterBKTaskSession == null) {
            break;
         }

         synchronized (this.psDevCenterBKTaskSessionMap) {
            if (this.psDevCenterBKTaskSessionMap.get(psDevCenterBKTaskSession.getPSDevCenterId()) != psDevCenterBKTaskSession) {
               this.resetPSDevCenterBKTaskSession(psDevCenterBKTaskSession, false);
               continue;
            }
         }

         if (psDevCenterBKTaskSession.run()) {
            synchronized (this.psDevCenterBKTaskSessionMap) {
               this.runningPSDevCenterBKTaskSessionList.add(psDevCenterBKTaskSession);
            }

            if (--nStartCount == 0) {
               break;
            }
         } else {
            synchronized (this.psDevCenterBKTaskSessionMap) {
               this.queuePSDevCenterBKTaskSessionList.add(psDevCenterBKTaskSession);
            }
         }
      }

      PSDevCenterBKTaskSession removePSDevCenterBKTaskSession = null;
      synchronized (this.psDevCenterBKTaskSessionMap) {
         if (System.currentTimeMillis() - this.nLastSortTime >= 10000L) {
            Collections.sort(this.queuePSDevCenterBKTaskSessionList, new Comparator<PSDevCenterBKTaskSession>() {
               public int compare(PSDevCenterBKTaskSession o1, PSDevCenterBKTaskSession o2) {
                  long nRet = o1.getPriority() - o2.getPriority();
                  if (nRet > 0L) {
                     return -1;
                  } else {
                     return nRet < 0L ? 1 : 0;
                  }
               }
            });
            int nPos = 0;
            int nLength = this.queuePSDevCenterBKTaskSessionList.size();

            for (PSDevCenterBKTaskSession psDevCenterBKTaskSession : this.queuePSDevCenterBKTaskSessionList) {
               nPos++;
               if (this.psDevCenterBKTaskSessionMap.get(psDevCenterBKTaskSession.getPSDevCenterId()) != psDevCenterBKTaskSession) {
                  if (removePSDevCenterBKTaskSession == null) {
                     removePSDevCenterBKTaskSession = psDevCenterBKTaskSession;
                  }
               } else if (psDevCenterBKTaskSession.isStarted() && psDevCenterBKTaskSession.getPSBKTaskCount() != 0) {
                  psDevCenterBKTaskSession.setQueuePos(nPos, nLength);
               } else if (removePSDevCenterBKTaskSession == null
                  && (!psDevCenterBKTaskSession.isStarted() || System.currentTimeMillis() - psDevCenterBKTaskSession.getLastTaskFinishTime() >= this.nDCTimeout)
                  )
                {
                  removePSDevCenterBKTaskSession = psDevCenterBKTaskSession;
               }
            }

            this.nLastSortTime = System.currentTimeMillis();
         }
      }

      if (removePSDevCenterBKTaskSession != null) {
         try {
            this.resetPSDevCenterBKTaskSession(removePSDevCenterBKTaskSession, true);
         } catch (Exception ex) {
            log.error(ex);
         }
      }
   }

   protected void resetPSDevCenterBKTaskSession(PSDevCenterBKTaskSession psDevCenterBKTaskSession2, boolean bCheck) {
      synchronized (this.psDevCenterBKTaskSessionMap) {
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

      log.info(StringHelper.format("移除后台任务队列[%1$s]", psDevCenterBKTaskSession2.getName()));
      psDevCenterBKTaskSession2.stop();
      PSDevCenterBKTaskSession var6 = null;
   }

   public int getSessionCount() {
      return this.psDevCenterBKTaskSessionMap.size();
   }

   @Override
   public void resetPSBKTaskSession(String strSessionId) throws Exception {
      this.resetPSDCBKTaskSession(strSessionId);
   }
}
