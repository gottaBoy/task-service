/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDBCallerHelperEx
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  SA.SRFramework.WebEx.Utility.ContextHelper
 *  SA.SRFramework.WebEx.Utility.ISRFExGlobalHelper
 *  javax.servlet.ServletContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SRFTS.Ctrl;

import SA.SRFramework.DataEx.BaseDBCallerHelperEx;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.WebEx.Utility.ContextHelper;
import SA.SRFramework.WebEx.Utility.ISRFExGlobalHelper;
import SRFTS.Ctrl.Data.TSTaskItem;
import SRFTS.Ctrl.ISRFTSEngine;
import SRFTS.Ctrl.ITSDataCtrl;
import SRFTS.Ctrl.SRFTSScheduleHelper;
import SRFTS.Ctrl.SRFTSTaskProxy;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;
import javax.servlet.ServletContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFTSEngine
extends TimerTask
implements ISRFTSEngine {
    private Timer tsTimer = null;
    protected BaseDBCallerHelperEx dbCallerHelper = null;
    protected ITSDataCtrl tsDataCtrl = null;
    public static final int TSTIMER = 30000;
    public static final int TSTIMER2 = 30000;
    protected SRFTSScheduleHelper tsScheduleHelper = null;
    protected ServletContext servletContext = null;
    protected ContextHelper contextHelper = null;
    protected ISRFExGlobalHelper iGlobalHelper = null;
    protected TreeMap<String, SRFTSTaskProxy> runTaskMap = new TreeMap();
    protected TreeMap<String, SRFTSTaskProxy> runTaskMap2 = new TreeMap();
    private int LOOPCOUNT;
    private int nTimerCount = this.LOOPCOUNT = 2;
    private Boolean bRunFlag = false;
    private long nTaskTimeout = 0L;
    protected TreeMap<String, String> runningTaskMap = new TreeMap();
    private TreeMap<String, Object> attributes = new TreeMap();
    private static Log log = LogFactory.getLog(SRFTSEngine.class);

    public SRFTSEngine(ISRFExGlobalHelper iGlobalHelper, BaseDBCallerHelperEx dbCallerHelper) throws Exception {
        this.dbCallerHelper = dbCallerHelper;
        if (iGlobalHelper instanceof ContextHelper) {
            this.contextHelper = (ContextHelper)iGlobalHelper;
        }
        this.tsDataCtrl = this.CreateTSDataCtrl();
        if (this.tsDataCtrl == null) {
            log.error((Object)"\u65e0\u6cd5\u5efa\u7acb\u4efb\u52a1\u5f15\u64ce\u6570\u636e\u5bf9\u8c61");
            return;
        }
        int nTaskTimeout = iGlobalHelper.getWebExConfig().GetValue("SRFTS", "TASKTIMEOUT", 0);
        this.nTaskTimeout = 1000 * nTaskTimeout;
        this.tsDataCtrl.Init(iGlobalHelper, this.dbCallerHelper);
        this.tsScheduleHelper = this.CreateScheduleHelper();
        if (this.tsScheduleHelper == null) {
            throw new Exception("\u8ba1\u5212\u8f85\u52a9\u5bf9\u8c61\u65e0\u6548");
        }
        this.tsScheduleHelper.Init((ISRFExGlobalHelper)this.contextHelper, dbCallerHelper);
        int nTimer = iGlobalHelper.getWebExConfig().GetValue("SRFTS", "SCHEDULETIMER", 600);
        this.nTimerCount = this.LOOPCOUNT = nTimer / 30;
        if (this.tsTimer == null) {
            this.tsTimer = new Timer("SRFTSEngine");
            this.tsTimer.schedule((TimerTask)this, 30000L, 30000L);
        }
    }

    public SRFTSEngine(ServletContext servletContext, BaseDBCallerHelperEx dbCallerHelper) throws Exception {
        this.dbCallerHelper = dbCallerHelper;
        this.servletContext = servletContext;
        this.contextHelper = new ContextHelper(servletContext);
        this.tsDataCtrl = this.CreateTSDataCtrl();
        if (this.tsDataCtrl == null) {
            log.error((Object)"\u65e0\u6cd5\u5efa\u7acb\u4efb\u52a1\u5f15\u64ce\u6570\u636e\u5bf9\u8c61");
            return;
        }
        this.tsDataCtrl.Init(servletContext, this.dbCallerHelper);
        this.tsScheduleHelper = this.CreateScheduleHelper();
        if (this.tsScheduleHelper == null) {
            throw new Exception("\u8ba1\u5212\u8f85\u52a9\u5bf9\u8c61\u65e0\u6548");
        }
        this.tsScheduleHelper.Init((ISRFExGlobalHelper)this.contextHelper, dbCallerHelper);
        int nTimer = this.iGlobalHelper.getWebExConfig().GetValue("SRFTS", "SCHEDULETIMER", 600);
        this.nTimerCount = this.LOOPCOUNT = nTimer / 30;
        if (this.tsTimer == null) {
            this.tsTimer = new Timer("SRFTSEngine");
            this.tsTimer.schedule((TimerTask)this, 30000L, 30000L);
        }
    }

    protected ITSDataCtrl CreateTSDataCtrl() {
        String strDataCtrlObject = this.contextHelper.getWebExConfig().GetValue("SRFTS", "TSDATACTRL", "");
        if (StringHelper.IsNullOrEmpty((String)strDataCtrlObject)) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u4efb\u52a1\u5f15\u64ce\u6570\u636e\u5bf9\u8c61"));
            return null;
        }
        Object objDataCtrl = ObjectHelper.Create((String)strDataCtrlObject);
        if (objDataCtrl == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u4efb\u52a1\u5f15\u64ce\u6570\u636e\u5bf9\u8c61[%1$s]", (Object)objDataCtrl));
            return null;
        }
        if (objDataCtrl instanceof ITSDataCtrl) {
            return (ITSDataCtrl)objDataCtrl;
        }
        log.error((Object)StringHelper.Format((String)"\u5bf9\u8c61[%1$s]\u6ca1\u6709\u5b9e\u73b0\u63a5\u53e3[ITSDataCtrl]", (Object)objDataCtrl));
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        Boolean bl = this.bRunFlag;
        synchronized (bl) {
            if (this.bRunFlag.booleanValue()) {
                return;
            }
            this.bRunFlag = true;
        }
        this.InternalRun();
        bl = this.bRunFlag;
        synchronized (bl) {
            this.bRunFlag = false;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void InternalRun() {
        log.debug((Object)"\u68c0\u67e5\u5f85\u6267\u884c\u4efb\u52a1\u9879");
        TreeMap<String, SRFTSTaskProxy> treeMap = this.runTaskMap;
        synchronized (treeMap) {
            if (this.runTaskMap.size() > 0) {
                SRFTSTaskProxy taskProxy;
                this.runTaskMap2.clear();
                for (String strKey : this.runTaskMap.keySet()) {
                    taskProxy = this.runTaskMap.get(strKey);
                    if (!taskProxy.isFinish()) {
                        if (this.nTaskTimeout == 0L || !taskProxy.IsTimeout(this.nTaskTimeout)) {
                            this.runTaskMap2.put(strKey, taskProxy);
                            continue;
                        }
                        taskProxy.UserStop();
                        taskProxy.Close();
                        continue;
                    }
                    taskProxy.Close();
                }
                this.runTaskMap.clear();
                if (this.runTaskMap2.size() > 0) {
                    for (String strKey : this.runTaskMap2.keySet()) {
                        taskProxy = this.runTaskMap2.get(strKey);
                        this.runTaskMap.put(strKey, taskProxy);
                    }
                    this.runTaskMap2.clear();
                }
            }
        }
        ++this.nTimerCount;
        if (this.nTimerCount < this.LOOPCOUNT) {
            return;
        }
        this.nTimerCount = 0;
        try {
            Calendar curDate = Calendar.getInstance();
            curDate.setTime(new Date());
            curDate.add(12, -30);
            Calendar curDate2 = Calendar.getInstance();
            curDate2.setTime(new Date());
            curDate2.add(12, 10);
            Calendar startDate = Calendar.getInstance();
            startDate.set(curDate.get(1), curDate.get(2), curDate.get(5), 0, 0, 0);
            Calendar endDate = Calendar.getInstance();
            endDate.set(curDate.get(1), curDate.get(2), curDate.get(5), 0, 0, 0);
            endDate.add(5, 2);
            this.tsScheduleHelper.CreateTaskItem("", startDate.getTime(), endDate.getTime(), curDate.getTime(), curDate2.getTime());
        }
        catch (Exception ex) {
            log.error((Object)"\u5efa\u7acb\u8fd0\u884c\u4efb\u52a1\u9879\u5931\u8d25", (Throwable)ex);
        }
        ArrayList<TSTaskItem> list = new ArrayList<TSTaskItem>();
        try {
            Calendar curDate = Calendar.getInstance();
            curDate.setTime(new Date());
            curDate.add(12, -360);
            Calendar curDate2 = Calendar.getInstance();
            curDate2.setTime(new Date());
            curDate2.add(12, 10);
            CallResult callResult = this.tsDataCtrl.GetTaskItems(curDate.getTime(), curDate2.getTime(), list);
            if (callResult == null || callResult.getRetCode() != 0) {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5f85\u6267\u884c\u4efb\u52a1\u9879\u5931\u8d25\uff0c\u539f\u56e0\uff1a%1$s", (Object)(callResult == null ? "\u4e0d\u660e\u9519\u8bef" : callResult.getErrorInfo())));
                return;
            }
            for (TSTaskItem tsTaskItem : list) {
                TreeMap<String, SRFTSTaskProxy> treeMap2 = this.runTaskMap;
                synchronized (treeMap2) {
                    if (this.runTaskMap.containsKey(tsTaskItem.getTSTASKITEMID())) {
                        continue;
                    }
                }
                SRFTSTaskProxy taskProxy = new SRFTSTaskProxy();
                callResult = taskProxy.Start(this, tsTaskItem, this.dbCallerHelper, this.tsDataCtrl, (ISRFExGlobalHelper)this.contextHelper);
                if (callResult == null || callResult.getRetCode() != 0) {
                    log.error((Object)StringHelper.Format((String)"\u5efa\u7acb\u4efb\u52a1\u4ee3\u7406\u5931\u8d25[%1$s]\uff0c\u539f\u56e0\uff1a%2$s", (Object)tsTaskItem.getTSTASKITEMID(), (Object)(callResult == null ? "\u4e0d\u660e\u9519\u8bef" : callResult.getErrorInfo())));
                    continue;
                }
                log.debug((Object)StringHelper.Format((String)"\u4e3a\u8ba1\u5212\u4efb\u52a1\u9879[%1$s]\u5efa\u7acb\u4efb\u52a1\u4ee3\u7406", (Object)tsTaskItem.getTSTASKITEMID()));
                TreeMap<String, SRFTSTaskProxy> treeMap3 = this.runTaskMap;
                synchronized (treeMap3) {
                    this.runTaskMap.put(tsTaskItem.getTSTASKITEMID(), taskProxy);
                    if (this.runTaskMap.size() > 100) {
                        log.debug((Object)StringHelper.Format((String)"\u5f85\u8fd0\u884c\u4efb\u52a1\u9879\u8d85\u8fc7100\uff0c\u6682\u505c\u653e\u5165\u4efb\u52a1\u9879"));
                        break;
                    }
                }
            }
        }
        catch (Exception ex) {
            log.error((Object)"\u5efa\u7acb\u8fd0\u884c\u4efb\u52a1\u9879\u5931\u8d25", (Throwable)ex);
        }
    }

    public void Close() {
        if (this.tsTimer != null) {
            this.tsTimer.cancel();
            this.tsTimer = null;
        }
    }

    @Override
    public Object getAttribute(String strParam) {
        return this.attributes.get(strParam);
    }

    @Override
    public void setAttribute(String strParam, Object objValue) {
        if (objValue == null) {
            this.attributes.remove(strParam);
        } else {
            this.attributes.put(strParam, objValue);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean AddRunningTask(String strTaskId) {
        TreeMap<String, String> treeMap = this.runningTaskMap;
        synchronized (treeMap) {
            block4: {
                if (!this.runningTaskMap.containsKey(strTaskId)) break block4;
                return false;
            }
            this.runningTaskMap.put(strTaskId, "");
            return true;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void RemoveRunningTask(String strTaskId) {
        TreeMap<String, String> treeMap = this.runningTaskMap;
        synchronized (treeMap) {
            if (this.runningTaskMap.containsKey(strTaskId)) {
                this.runningTaskMap.remove(strTaskId);
            }
        }
    }

    protected SRFTSScheduleHelper CreateScheduleHelper() {
        String strObject = this.contextHelper.getWebExConfig().GetValue("SRFTS", "SCHEDULEHELPER", "");
        if (StringHelper.IsNullOrEmpty((String)strObject)) {
            return new SRFTSScheduleHelper();
        }
        Object objTSHelper = ObjectHelper.Create((String)strObject);
        if (objTSHelper == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u8ba1\u5212\u8f85\u52a9\u5bf9\u8c61[%1$s]", (Object)strObject));
            return null;
        }
        if (!(objTSHelper instanceof SRFTSScheduleHelper)) {
            log.error((Object)StringHelper.Format((String)"\u8ba1\u5212\u8f85\u52a9\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strObject));
            return null;
        }
        return (SRFTSScheduleHelper)objTSHelper;
    }
}

