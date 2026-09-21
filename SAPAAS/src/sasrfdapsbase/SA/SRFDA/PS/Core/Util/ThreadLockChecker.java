/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Util;

import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import net.ibizsys.paas.util.StringBuilderEx;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ThreadLockChecker {
    private static final Log log = LogFactory.getLog(ThreadLockChecker.class);
    private static ThreadLockChecker threadLockChecker = new ThreadLockChecker();
    private HashMap<Object, LockInfo> lockInfoMap = new HashMap();
    private boolean bEnabled = true;

    public final void wait(Object objLock, String strInfo) {
        if (!this.isEnabled()) {
            return;
        }
        LockInfo lockInfo = this.getLockInfo(objLock);
        lockInfo.doWait(strInfo);
    }

    public final void enter(Object objLock, String strLockInfo) {
        if (!this.isEnabled()) {
            return;
        }
        LockInfo lockInfo = this.getLockInfo(objLock);
        lockInfo.doEnter(strLockInfo);
    }

    public final void leave(Object objLock, String strLockInfo) {
        if (!this.isEnabled()) {
            return;
        }
        LockInfo lockInfo = this.getLockInfo(objLock);
        lockInfo.doLeave(strLockInfo);
    }

    public final void enterAndLeave(Object objLock, String strLockInfo) {
        if (!this.isEnabled()) {
            return;
        }
        LockInfo lockInfo = this.getLockInfo(objLock);
        lockInfo.doEnterAndLeave(strLockInfo);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void remove(Object objLock) {
        if (!this.isEnabled()) {
            return;
        }
        HashMap<Object, LockInfo> hashMap = this.lockInfoMap;
        synchronized (hashMap) {
            this.lockInfoMap.remove(objLock);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected final LockInfo getLockInfo(Object objLock) {
        LockInfo lockInfo = this.lockInfoMap.get(objLock);
        if (lockInfo == null) {
            lockInfo = new LockInfo();
            lockInfo.objLock = objLock;
            HashMap<Object, LockInfo> hashMap = this.lockInfoMap;
            synchronized (hashMap) {
                LockInfo lockInfo2 = this.lockInfoMap.get(objLock);
                if (lockInfo2 == null) {
                    this.lockInfoMap.put(objLock, lockInfo);
                } else {
                    lockInfo = lockInfo2;
                }
            }
        }
        return lockInfo;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public long checkDeadLock() {
        if (!this.isEnabled()) {
            return 0L;
        }
        try {
            HashMap<Long, LockWaitInfo> threadWaitLockMap = new HashMap<Long, LockWaitInfo>();
            HashMap<Object, LockWaitInfo> threadEnterLockMap = new HashMap<Object, LockWaitInfo>();
            HashMap<Object, LockInfo> hashMap = this.lockInfoMap;
            synchronized (hashMap) {
                ArrayList<Object> removeList = new ArrayList<Object>();
                for (Map.Entry<Object, LockInfo> entry : this.lockInfoMap.entrySet()) {
                    if (entry.getValue().isIdle()) {
                        removeList.add(entry.getKey());
                        continue;
                    }
                    entry.getValue().putLockWaitInfoMap(threadWaitLockMap);
                    long nThreadId = entry.getValue().getEnterThreadId();
                    if (nThreadId == 0L) continue;
                    LockWaitInfo lockWaitInfo = new LockWaitInfo();
                    lockWaitInfo.strThreadName = entry.getValue().strEnterThreadName;
                    lockWaitInfo.nThreadId = nThreadId;
                    lockWaitInfo.strWaitInfo = entry.getValue().strEnterInfo;
                    if (entry.getValue().enterTimeList.size() > 0) {
                        lockWaitInfo.nTime = (Long)entry.getValue().enterTimeList.get(0);
                    }
                    threadEnterLockMap.put(entry.getValue().getLockObject(), lockWaitInfo);
                }
                for (Map.Entry<Object, LockInfo> entry : removeList) {
                    LockInfo lockInfo = this.lockInfoMap.get(entry);
                    if (lockInfo != null && !lockInfo.isIdle()) continue;
                    this.lockInfoMap.remove(lockInfo);
                }
            }
            long nMaxTime = 0L;
            HashMap<Long, LockWaitInfo> hashMap2 = new HashMap<Long, LockWaitInfo>();
            long nCurTime = System.currentTimeMillis();
            StringBuilderEx sb = new StringBuilderEx();
            sb.append("\r\n*******************************\u7ebf\u7a0b\u8c03\u8bd5\u4fe1\u606f*************************************\r\n");
            for (Map.Entry entry : threadEnterLockMap.entrySet()) {
                LockWaitInfo enterInfo = (LockWaitInfo)entry.getValue();
                Object objLock = entry.getKey();
                sb.append("\r\n\u5bf9\u8c61[%1$s==>%2$s]\r\n!!!!\u5de5\u4f5c\u7ebf\u7a0b[%3$s][%4$s]\t\u65f6\u95f4[%5$s]\t[%6$s]\r\n", (Object)StringHelper.Format((String)"%1$s@%2$s", (Object)objLock.getClass().getSimpleName(), (Object)objLock.hashCode()), (Object)objLock.toString(), (Object)enterInfo.nThreadId, (Object)enterInfo.strThreadName, (Object)(nCurTime - enterInfo.nTime), (Object)enterInfo.strWaitInfo);
                for (Map.Entry<Long, LockWaitInfo> entry2 : threadWaitLockMap.entrySet()) {
                    Long nThreadId2 = entry2.getKey();
                    LockWaitInfo lockWaitInfo = entry2.getValue();
                    if (lockWaitInfo == null) continue;
                    long nTime = nCurTime - lockWaitInfo.nTime;
                    if (nTime > nMaxTime) {
                        nMaxTime = nTime;
                    }
                    if (lockWaitInfo.objLock != objLock) continue;
                    sb.append("==>\u7b49\u5f85\u7ebf\u7a0b[%1$s][%2$s]\t\t\u7b49\u5f85\u65f6\u95f4[%3$s]\t[%4$s]\r\n", (Object)nThreadId2, (Object)lockWaitInfo.strThreadName, (Object)nTime, (Object)lockWaitInfo.strWaitInfo);
                    hashMap2.put(nThreadId2, lockWaitInfo);
                }
            }
            sb.append("\r\n\u5176\u5b83\u7ebf\u7a0b\r\n");
            for (Map.Entry<Object, Object> entry : threadWaitLockMap.entrySet()) {
                LockWaitInfo lockWaitInfo;
                Long nThreadId = (Long)entry.getKey();
                if (hashMap2.containsKey(nThreadId) || (lockWaitInfo = (LockWaitInfo)entry.getValue()) == null) continue;
                sb.append("\u7ebf\u7a0b[%1$s][%2$s]\t\t\u7b49\u5f85[%3$s]\t\u65f6\u95f4[%4$s]\t[%5$s]\r\n", (Object)nThreadId, (Object)lockWaitInfo.strThreadName, (Object)StringHelper.Format((String)"%1$s@%2$s==>%3$s", (Object)lockWaitInfo.objLock.getClass().getSimpleName(), (Object)lockWaitInfo.objLock.hashCode(), (Object)lockWaitInfo.objLock.toString()), (Object)(nCurTime - lockWaitInfo.nTime), (Object)lockWaitInfo.strWaitInfo);
            }
            sb.append("\r\n\u7ebf\u7a0b\u7b49\u5f85\u6700\u957f\u65f6\u95f4[%1$s]\r\n", (Object)nMaxTime);
            log.info((Object)sb.toString());
            return nMaxTime;
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return 0L;
        }
    }

    protected boolean checkDeadLock(long nThreadId, HashMap<Long, LockWaitInfo> threadWaitLockMap, HashMap<Object, Long> threadEnterLockMap, HashMap<Long, Object> loopMap) {
        LockWaitInfo lockWaitInfo = threadWaitLockMap.get(nThreadId);
        if (lockWaitInfo == null) {
            return false;
        }
        if (loopMap.containsKey(nThreadId)) {
            return true;
        }
        loopMap.put(nThreadId, lockWaitInfo.objLock);
        long nWaitTime = System.currentTimeMillis() - lockWaitInfo.nTime;
        if (nWaitTime >= 20000L) {
            Long nEnterThreadId = threadEnterLockMap.get(lockWaitInfo.objLock);
            if (nEnterThreadId == null) {
                return false;
            }
            return this.checkDeadLock(nEnterThreadId, threadWaitLockMap, threadEnterLockMap, loopMap);
        }
        return false;
    }

    public final void setEnabled(boolean bEnabled) {
        this.bEnabled = bEnabled;
    }

    public final boolean isEnabled() {
        return this.bEnabled;
    }

    public static ThreadLockChecker getInstance() {
        return threadLockChecker;
    }

    public static String getCodeInfo() {
        StackTraceElement ste = new Throwable().getStackTrace()[1];
        return StringHelper.Format((String)"%1$s line[%2$s]", (Object)ste.getClassName(), (Object)ste.getLineNumber());
    }

    protected class LockInfo {
        public Object objLock = null;
        private long nActiveTime = 0L;
        HashMap<Long, LockWaitInfo> waitThreadMap = new HashMap();
        long nEnterThreadId;
        String strEnterThreadName;
        Stack<Long> enterTimeList = new Stack();
        String strEnterInfo;

        protected LockInfo() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public final void doWait(String strInfo) {
            this.active();
            Thread thread = Thread.currentThread();
            long nThreadId = thread.getId();
            LockWaitInfo lockWaitInfo = new LockWaitInfo();
            lockWaitInfo.nThreadId = nThreadId;
            lockWaitInfo.nTime = System.currentTimeMillis();
            lockWaitInfo.strThreadName = thread.getName();
            lockWaitInfo.strWaitInfo = strInfo;
            lockWaitInfo.objLock = this.objLock;
            HashMap<Long, LockWaitInfo> hashMap = this.waitThreadMap;
            synchronized (hashMap) {
                this.waitThreadMap.put(nThreadId, lockWaitInfo);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public final void doEnter(String strLockInfo) {
            this.active();
            long nTime = System.currentTimeMillis();
            long nThreadId = Thread.currentThread().getId();
            String nThreadName = Thread.currentThread().getName();
            HashMap<Long, LockWaitInfo> hashMap = this.waitThreadMap;
            synchronized (hashMap) {
                LockWaitInfo lockWaitInfo = this.waitThreadMap.remove(nThreadId);
                if (lockWaitInfo != null) {
                    if (this.nEnterThreadId != 0L && this.nEnterThreadId != nThreadId) {
                        this.enterTimeList.clear();
                    }
                    if (this.enterTimeList.size() == 0) {
                        this.nEnterThreadId = nThreadId;
                        this.strEnterInfo = strLockInfo;
                        this.strEnterThreadName = nThreadName;
                    }
                    this.enterTimeList.push(nTime);
                } else {
                    if (this.nEnterThreadId != 0L && this.nEnterThreadId != nThreadId) {
                        this.enterTimeList.clear();
                    }
                    if (this.enterTimeList.size() == 0) {
                        this.nEnterThreadId = nThreadId;
                        this.strEnterInfo = strLockInfo;
                        this.strEnterThreadName = nThreadName;
                    }
                    this.enterTimeList.push(nTime);
                }
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public final void doLeave(String strLockInfo) {
            this.active();
            long nThreadId = Thread.currentThread().getId();
            HashMap<Long, LockWaitInfo> hashMap = this.waitThreadMap;
            synchronized (hashMap) {
                if (this.nEnterThreadId == nThreadId) {
                    if (this.enterTimeList.size() > 0) {
                        this.enterTimeList.pop();
                    }
                    if (this.enterTimeList.size() == 0) {
                        this.nEnterThreadId = 0L;
                        this.strEnterInfo = null;
                        this.strEnterThreadName = null;
                    }
                }
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public final void doEnterAndLeave(String strLockInfo) {
            this.active();
            long nThreadId = Thread.currentThread().getId();
            HashMap<Long, LockWaitInfo> hashMap = this.waitThreadMap;
            synchronized (hashMap) {
                this.waitThreadMap.remove(nThreadId);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public final void putLockWaitInfoMap(HashMap<Long, LockWaitInfo> map) {
            this.active();
            HashMap<Long, LockWaitInfo> hashMap = this.waitThreadMap;
            synchronized (hashMap) {
                map.putAll(this.waitThreadMap);
            }
        }

        public final long getEnterThreadId() {
            this.active();
            long nEnterThreadId = this.nEnterThreadId;
            return nEnterThreadId;
        }

        public final Object getLockObject() {
            this.active();
            return this.objLock;
        }

        public final void active() {
            this.nActiveTime = System.currentTimeMillis();
        }

        public final long getActiveTime() {
            return this.nActiveTime;
        }

        public final boolean isIdle() {
            if (this.enterTimeList.size() > 0 || this.waitThreadMap.size() > 0) {
                return false;
            }
            return System.currentTimeMillis() - this.nActiveTime >= 300000L;
        }
    }

    protected class LockWaitInfo {
        public long nTime = 0L;
        public String strWaitInfo = null;
        public String strThreadName = null;
        public Object objLock = null;
        public long nThreadId = 0L;

        protected LockWaitInfo() {
        }
    }
}

