package SA.SRFDA.PS.Core.DevStudio;

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

public abstract class PSBKTaskGlobalBase extends PSObjectImpl implements IPSBKTaskGlobal, IPSBKTaskGlobalContext {
   private HashMap<String, PSBKTaskSessionBase> psBKTaskSessionMap = new HashMap<>();
   private ArrayList<PSBKTaskSessionBase> runningPSBKTaskSessionList = new ArrayList<>();
   private ArrayList<PSBKTaskSessionBase> queuePSBKTaskSessionList = new ArrayList<>();
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
         int var4 = '\uea60';
      }

      this.lock_psBKTaskSessionMap = StringHelper.format("psBKTaskSessionMap@%1$s", this);
      this.onInit();
      this.scheduledThreadPool = Executors.newScheduledThreadPool(1);
      this.scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
         @Override
         public void run() {
            PSBKTaskWorkHelper.execute(new IPSBKTaskWork2() {
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

   protected PSBKTaskSessionBase getPSBKTaskSession(String strPSBKTaskSessionId) throws Exception {
      boolean bNewSession = false;
      PSBKTaskSessionBase psBKTaskSession = this.psBKTaskSessionMap.get(strPSBKTaskSessionId);
      if (psBKTaskSession == null) {
         psBKTaskSession = this.createPSBKTaskSession();
         psBKTaskSession.setSessionId(strPSBKTaskSessionId);
         this.waitLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
         synchronized (this.psBKTaskSessionMap) {
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
         synchronized (psBKTaskSession) {
            if (bNewSession) {
               psBKTaskSession.init(this.getDAGlobalHelper(), strPSBKTaskSessionId, this);
               psBKTaskSession.start();
            }

            return psBKTaskSession;
         }
      } catch (Exception ex) {
         log.error(StringHelper.format("启动任务会话发生异常，%1$s", ex.getMessage()), ex);
         this.waitLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
         synchronized (this.psBKTaskSessionMap) {
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
   }

   protected abstract PSBKTaskSessionBase createPSBKTaskSession() throws Exception;

   @Override
   public void resetPSBKTaskSession(String strPSBKTaskSessionId) throws Exception {
      final String strPSBKTaskSessionId2 = strPSBKTaskSessionId;
      PSBKTaskWorkHelper.execute(new IPSBKTaskWork() {
         @Override
         public void execute(Object obj) throws Exception {
            PSBKTaskGlobalBase.this.resetPSBKTaskSession(strPSBKTaskSessionId2, false);
         }
      });
   }

   public int getPSBKTaskSessionTaskCount(String strPSBKTaskSessionId) {
      PSBKTaskSessionBase psBKTaskSession = this.psBKTaskSessionMap.get(strPSBKTaskSessionId);
      return psBKTaskSession == null ? 0 : psBKTaskSession.getPSBKTaskCount();
   }

   public int getPSBKTaskSessionTaskCount(String strPSBKTaskSessionId, boolean bPrepareTask) {
      PSBKTaskSessionBase psBKTaskSession = this.psBKTaskSessionMap.get(strPSBKTaskSessionId);
      if (psBKTaskSession == null) {
         return 0;
      } else {
         return bPrepareTask ? psBKTaskSession.getPSBKTaskCount() + (int)psBKTaskSession.getPrepareTaskCount() : psBKTaskSession.getPSBKTaskCount();
      }
   }

   public boolean isPSBKTaskSessionBusy(String strPSBKTaskSessionId, boolean bNotExistAsFalse) throws Exception {
      PSBKTaskSessionBase psBKTaskSession = this.psBKTaskSessionMap.get(strPSBKTaskSessionId);
      if (psBKTaskSession == null) {
         if (bNotExistAsFalse) {
            return false;
         } else {
            throw new Exception(StringHelper.format("无法获取指定任务会话[%1$s]", strPSBKTaskSessionId));
         }
      } else {
         return psBKTaskSession.isRunning();
      }
   }

   protected void resetPSBKTaskSession(String strPSBKTaskSessionId, boolean bCheck) {
      PSBKTaskSessionBase psBKTaskSession = this.psBKTaskSessionMap.get(strPSBKTaskSessionId);
      if (psBKTaskSession != null) {
         if (!bCheck || !psBKTaskSession.isRunning() && psBKTaskSession.getTaskThreadCount() <= 0) {
            this.waitLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
            synchronized (this.psBKTaskSessionMap) {
               PSBKTaskSessionBase psBKTaskSession2 = this.psBKTaskSessionMap.get(strPSBKTaskSessionId);
               if (psBKTaskSession.equals(psBKTaskSession2)) {
                  this.psBKTaskSessionMap.remove(strPSBKTaskSessionId);
                  this.runningPSBKTaskSessionList.remove(psBKTaskSession);
                  this.queuePSBKTaskSessionList.remove(psBKTaskSession);
               }

               this.enterAndLeaveLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
            }

            if (psBKTaskSession != null) {
               log.info(StringHelper.format("移除后台任务队列[%1$s]", psBKTaskSession.getName()));
               psBKTaskSession.stop();
            }
         }
      }
   }

   protected void resetPSBKTaskSession(PSBKTaskSessionBase psBKTaskSession2, boolean bCheck) {
      PSBKTaskSessionBase psBKTaskSession = this.psBKTaskSessionMap.get(psBKTaskSession2.getSessionId());
      if (psBKTaskSession == null
         || !psBKTaskSession2.equals(psBKTaskSession)
         || !bCheck
         || !psBKTaskSession.isRunning() && psBKTaskSession.getTaskThreadCount() <= 0) {
         this.waitLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
         synchronized (this.psBKTaskSessionMap) {
            PSBKTaskSessionBase psBKTaskSession3 = this.psBKTaskSessionMap.get(psBKTaskSession2.getSessionId());
            if (psBKTaskSession3 != null && psBKTaskSession2.equals(psBKTaskSession3)) {
               this.psBKTaskSessionMap.remove(psBKTaskSession2.getSessionId());
            }

            this.runningPSBKTaskSessionList.remove(psBKTaskSession2);
            this.queuePSBKTaskSessionList.remove(psBKTaskSession2);
            this.enterAndLeaveLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
         }

         log.info(StringHelper.format("移除后台任务队列[%1$s]", psBKTaskSession2.getName()));
         psBKTaskSession2.stop();
      }
   }

   public PSBKTaskGlobalInfo getPSBKTaskGlobalInfo() {
      PSBKTaskGlobalInfo psBKTaskGlobalInfo = new PSBKTaskGlobalInfo();
      StringBuilderEx sb = new StringBuilderEx();
      this.waitLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
      synchronized (this.psBKTaskSessionMap) {
         this.enterLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
         int nSysCount = this.psBKTaskSessionMap.size();
         int nRunningCount = this.runningPSBKTaskSessionList.size();
         int nQueueCount = this.queuePSBKTaskSessionList.size();
         psBKTaskGlobalInfo.setQueueCount(nQueueCount);
         psBKTaskGlobalInfo.setRunningCount(nRunningCount);
         psBKTaskGlobalInfo.setSessionCount(nSysCount);
         sb.append("任务队列[%1$s],运行[%2$s],等待[%3$s]\r\n", nSysCount, nRunningCount, nQueueCount);

         for (PSBKTaskSessionBase psBKTaskSession : this.runningPSBKTaskSessionList) {
            String strInfo = psBKTaskSession.getCurrentInfo();
            if (!StringHelper.isNullOrEmpty(strInfo)) {
               sb.append("[运行]%1$s\r\n", strInfo);
            }
         }

         for (PSBKTaskSessionBase psBKTaskSession : this.queuePSBKTaskSessionList) {
            String strInfo = psBKTaskSession.getCurrentInfo();
            if (!StringHelper.isNullOrEmpty(strInfo)) {
               sb.append("[等待]%1$s\r\n", strInfo);
            }
         }

         this.leaveLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
      }

      psBKTaskGlobalInfo.setInfo(sb.toString());
      return psBKTaskGlobalInfo;
   }

   public void fillCurrentInfoResult(RemoteCallResult remoteCallResult) {
      this.waitLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
      synchronized (this.psBKTaskSessionMap) {
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
            String strInfo = psBKTaskSession.getCurrentInfo();
            if (!StringHelper.isNullOrEmpty(strInfo)) {
               JSONObject jo = new JSONObject();
               jo.put("runflag", 1);
               jo.put("sessionid", psBKTaskSession.getSessionId());
               jo.put("info", strInfo);
               remoteCallResult.getItems().add(jo);
            }
         }

         for (PSBKTaskSessionBase psBKTaskSession : this.queuePSBKTaskSessionList) {
            String strInfo = psBKTaskSession.getCurrentInfo();
            if (!StringHelper.isNullOrEmpty(strInfo)) {
               JSONObject jo = new JSONObject();
               jo.put("runflag", 0);
               jo.put("sessionid", psBKTaskSession.getSessionId());
               jo.put("info", strInfo);
               remoteCallResult.getItems().add(jo);
            }
         }

         this.leaveLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
      }
   }

   protected void runPSBKTaskSession() {
      int nStartCount = 0;
      int nQueueCount = 0;
      this.waitLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
      synchronized (this.psBKTaskSessionMap) {
         this.enterLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
         int nRunCount = this.runningPSBKTaskSessionList.size();

         for (int i = 0; i < nRunCount; i++) {
            PSBKTaskSessionBase psBKTaskSession = this.runningPSBKTaskSessionList.remove(0);
            if (psBKTaskSession.isRunning()) {
               this.runningPSBKTaskSessionList.add(psBKTaskSession);
            } else {
               this.queuePSBKTaskSessionList.add(psBKTaskSession);
            }
         }

         nStartCount = this.nQueueCount - this.runningPSBKTaskSessionList.size();
         nQueueCount = this.queuePSBKTaskSessionList.size();
         this.leaveLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
      }

      while (nQueueCount > 0 && nStartCount > 0) {
         nQueueCount--;
         PSBKTaskSessionBase psBKTaskSession = null;
         this.waitLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
         synchronized (this.psBKTaskSessionMap) {
            if (this.queuePSBKTaskSessionList.size() > 0) {
               psBKTaskSession = this.queuePSBKTaskSessionList.remove(0);
            }

            this.enterAndLeaveLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
         }

         if (psBKTaskSession == null) {
            break;
         }

         boolean bRemove = false;
         this.waitLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
         synchronized (this.psBKTaskSessionMap) {
            if (!psBKTaskSession.equals(this.psBKTaskSessionMap.get(psBKTaskSession.getSessionId()))) {
               bRemove = true;
            }

            this.enterAndLeaveLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
         }

         if (bRemove) {
            this.resetPSBKTaskSession(psBKTaskSession, false);
         } else if (psBKTaskSession.isStarted() && psBKTaskSession.run()) {
            this.waitLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
            synchronized (this.psBKTaskSessionMap) {
               this.runningPSBKTaskSessionList.add(psBKTaskSession);
               this.enterAndLeaveLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
            }

            if (--nStartCount == 0) {
               break;
            }
         } else {
            this.waitLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
            synchronized (this.psBKTaskSessionMap) {
               this.queuePSBKTaskSessionList.add(psBKTaskSession);
               this.enterAndLeaveLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
            }
         }
      }

      PSBKTaskSessionBase removePSBKTaskSession = null;
      this.waitLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
      synchronized (this.psBKTaskSessionMap) {
         this.enterLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
         if (System.currentTimeMillis() - this.nLastSortTime >= 10000L) {
            Collections.sort(this.queuePSBKTaskSessionList, new Comparator<PSBKTaskSessionBase>() {
               public int compare(PSBKTaskSessionBase o1, PSBKTaskSessionBase o2) {
                  long nRet = o1.getPriority() - o2.getPriority();
                  if (nRet > 0L) {
                     return -1;
                  } else {
                     return nRet < 0L ? 1 : 0;
                  }
               }
            });
            int nPos = 0;
            int nLength = this.queuePSBKTaskSessionList.size();

            for (PSBKTaskSessionBase psBKTaskSession : this.queuePSBKTaskSessionList) {
               nPos++;
               if (!psBKTaskSession.equals(this.psBKTaskSessionMap.get(psBKTaskSession.getSessionId()))) {
                  if (removePSBKTaskSession == null) {
                     removePSBKTaskSession = psBKTaskSession;
                  }
               } else if (psBKTaskSession.isStarted() && psBKTaskSession.getPSBKTaskCount() != 0) {
                  psBKTaskSession.setQueuePos(nPos, nLength);
               } else if (removePSBKTaskSession == null
                  && (!psBKTaskSession.isStarted() || System.currentTimeMillis() - psBKTaskSession.getLastTaskFinishTime() >= this.nSessionTimeout)) {
                  removePSBKTaskSession = psBKTaskSession;
               }
            }

            this.nLastSortTime = System.currentTimeMillis();
         }

         this.leaveLock(this.lock_psBKTaskSessionMap, ThreadLockChecker.getCodeInfo());
      }

      if (removePSBKTaskSession != null) {
         try {
            this.resetPSBKTaskSession(removePSBKTaskSession, true);
         } catch (Exception ex) {
            log.error(ex);
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
