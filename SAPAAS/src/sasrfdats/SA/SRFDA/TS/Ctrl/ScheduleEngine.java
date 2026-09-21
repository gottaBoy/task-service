/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.Utility.MacroHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.quartz.CronTrigger
 *  org.quartz.JobDataMap
 *  org.quartz.JobDetail
 *  org.quartz.Scheduler
 *  org.quartz.SchedulerException
 *  org.quartz.Trigger
 *  org.quartz.impl.StdSchedulerFactory
 */
package SA.SRFDA.TS.Ctrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.Utility.MacroHelper;
import SA.SRFDA.TS.Ctrl.Data.TSSDEngine;
import SA.SRFDA.TS.Ctrl.Data.TSSDItem;
import SA.SRFDA.TS.Ctrl.Data.TSSDTask;
import SA.SRFDA.TS.Ctrl.Data.TSSDTaskLog;
import SA.SRFDA.TS.Ctrl.Data.TSSDTaskPolicy;
import SA.SRFDA.TS.Ctrl.Data.TSSDTaskType;
import SA.SRFDA.TS.Ctrl.IScheduleEngine;
import SA.SRFDA.TS.Ctrl.IScheduleEngineContext;
import SA.SRFDA.TS.Ctrl.IScheduleEngineTask;
import SA.SRFDA.TS.Ctrl.ScheduleEngineJob;
import SA.SRFDA.TS.Ctrl.ScheduleEngineSyncTaskJob;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.text.ParseException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.CronTrigger;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class ScheduleEngine
implements IScheduleEngine,
IScheduleEngineContext {
    private static Log log = LogFactory.getLog(ScheduleEngine.class);
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;
    protected Scheduler sched = null;
    public static final String TAG_DAGLOBALHELPER = "%DAGLOBALHELPER%";
    public static final String TAG_ENGINEOBJECT = "%ENGINEOBJECT%";
    public static final String TAG_JOBPARAM = "%JOBPARAM%";
    public static final String TAG_CONTEXT = "%CONTEXT%";
    protected HashMap<String, String> tsSDItemCronTriggerMap = new HashMap();
    protected HashMap<String, IScheduleEngineTask> scheduleEngineTaskMap = new HashMap();
    protected HashMap<String, Object> attributeMap = new HashMap();
    protected HashMap<String, Object> paramMap = new HashMap();
    protected TSSDEngine tsSDEngine = null;
    protected HashMap<String, Integer> runTaskMap = new HashMap();
    protected IDEDataCtrl taskTypeDataCtrl = null;
    protected IDEDataCtrl taskDataCtrl = null;
    protected IDEDataCtrl taskLogDataCtrl = null;
    protected HashMap<String, TSSDTaskType> taskTypeMap = new HashMap();

    @Override
    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, TSSDEngine tsSDEngine) {
        CallResult callResult = new CallResult();
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.tsSDEngine = tsSDEngine;
        ScheduleEngine.InitEngineParam(this.paramMap, this, this.tsSDEngine);
        this.taskTypeDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("TS0025", "SYSTEM", null);
        if (this.taskTypeDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"TS0025"));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        this.taskDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("TS0026", "SYSTEM", null);
        if (this.taskDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"TS0026"));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        this.taskLogDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("TS0028", "SYSTEM", null);
        if (this.taskLogDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"TS0028"));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        StdSchedulerFactory sf = new StdSchedulerFactory();
        try {
            this.sched = sf.getScheduler();
            this.sched.getContext().put((Object)TAG_DAGLOBALHELPER, (Object)iDAGlobalHelper);
        }
        catch (SchedulerException e) {
            log.error((Object)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u5efa\u7acb\u8c03\u5ea6\u7a0b\u5e8f\u5931\u8d25\uff0c%1$s", (Object)e.getMessage()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        return this.OnInit();
    }

    protected CallResult OnInit() {
        return new CallResult();
    }

    @Override
    public CallResult Start() {
        CallResult callResult = new CallResult();
        try {
            this.scheduleEngineTaskMap.clear();
            this.attributeMap.clear();
            this.runTaskMap.clear();
            this.taskTypeMap.clear();
            this.SyncTask(true);
            JobDetail jobDetail = new JobDetail(String.valueOf(this.tsSDEngine.getTSSDENGINEID()) + "_SYNCJOB", String.valueOf(this.tsSDEngine.getTSSDENGINEID()) + "GROUP1", ScheduleEngineSyncTaskJob.class);
            JobDataMap jobDataMap = new JobDataMap();
            jobDataMap.put((Object)TAG_CONTEXT, (Object)this);
            jobDetail.setJobDataMap(jobDataMap);
            this.sched.addJob(jobDetail, true);
            CronTrigger trigger = new CronTrigger(String.valueOf(this.tsSDEngine.getTSSDENGINEID()) + "_SYNCJOB", String.valueOf(this.tsSDEngine.getTSSDENGINEID()) + "GROUP1", String.valueOf(this.tsSDEngine.getTSSDENGINEID()) + "_SYNCJOB", String.valueOf(this.tsSDEngine.getTSSDENGINEID()) + "GROUP1", "0 * * * * ?");
            this.sched.scheduleJob((Trigger)trigger);
            this.sched.start();
        }
        catch (SchedulerException e) {
            log.error((Object)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u542f\u52a8\u8c03\u5ea6\u7a0b\u5e8f\u5931\u8d25\uff0c%1$s", (Object)e.getMessage()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        catch (ParseException e) {
            log.error((Object)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u542f\u52a8\u8c03\u5ea6\u7a0b\u5e8f\u5931\u8d25\uff0c%1$s", (Object)e.getMessage()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        return callResult;
    }

    @Override
    public void SyncTask() {
        this.SyncTask(false);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected CallResult SyncTask(boolean bAll) {
        CallResult callResult = new CallResult();
        String strSQL = "select TSSDTASKID,VERSION from t_SRFTSSDTASK where ENABLEFLAG=1 AND TSSDENGINEID= ?";
        if (bAll) {
            strSQL = "select * from t_SRFTSSDTASK where ENABLEFLAG=1 AND TSSDENGINEID= ?";
        }
        CallParamList callParamList = new CallParamList();
        callParamList.AddString(this.tsSDEngine.getTSSDENGINEID());
        Vector tasks = new Vector();
        callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.taskTypeDataCtrl.GetDEHelper().GetDBStorage(), (String)strSQL, (Vector)callParamList.GetList(), tasks, (String)TSSDTask.class.getName());
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u8c03\u5ea6\u4efb\u52a1\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        HashMap<String, Integer> curTaskMap = new HashMap<String, Integer>();
        HashMap<String, Integer> hashMap = this.runTaskMap;
        synchronized (hashMap) {
            for (String strKey : this.runTaskMap.keySet()) {
                curTaskMap.put(strKey, this.runTaskMap.get(strKey));
            }
        }
        for (TSSDTask task : tasks) {
            if (curTaskMap.containsKey(task.getTSSDTASKID())) {
                if (((Integer)curTaskMap.get(task.getTSSDTASKID())).intValue() == task.getVERSION()) {
                    curTaskMap.remove(task.getTSSDTASKID());
                    continue;
                }
                curTaskMap.remove(task.getTSSDTASKID());
                this.RemoveJob(task.getTSSDTASKID(), String.valueOf(this.tsSDEngine.getTSSDENGINEID()) + "GROUP1");
            }
            if (!(callResult = this.AddJob(task, !bAll)).IsError()) continue;
            log.error((Object)StringHelper.Format((String)"\u542f\u52a8\u8c03\u5ea6\u4efb\u52a1[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)task.getTSSDTASKID(), (Object)callResult.getErrorInfo()));
        }
        for (String strTaskId : curTaskMap.keySet()) {
            this.RemoveJob(strTaskId, String.valueOf(this.tsSDEngine.getTSSDENGINEID()) + "GROUP1");
        }
        return callResult;
    }

    public CallResult AddJob(TSSDTask task, boolean bSelect) {
        CallResult callResult = new CallResult();
        if (bSelect && (callResult = this.taskDataCtrl.Get((BaseDataEntity)task)).IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u8c03\u5ea6\u4efb\u52a1[%1$s]\u5931\u8d25\uff0c%2$s", (Object)task.getTSSDTASKID(), (Object)callResult.getErrorInfo()));
            return callResult;
        }
        TSSDTaskType taskType = this.GetTaskType(task.getTSSDTASKTYPEID());
        if (taskType == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u8c03\u5ea6\u4efb\u52a1\u7c7b\u578b[%1$s]", (Object)task.getTSSDTASKTYPEID()));
            return callResult;
        }
        String strSQL = "select TSSDPOLICYID from t_SRFTSSDTASKPOLICY where TSSDTASKID = ?";
        CallParamList callParamList = new CallParamList();
        callParamList.AddString(task.getTSSDTASKID());
        Vector taskPolicies = new Vector();
        callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.taskTypeDataCtrl.GetDEHelper().GetDBStorage(), (String)strSQL, (Vector)callParamList.GetList(), taskPolicies, (String)TSSDTaskPolicy.class.getName());
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u4efb\u52a1\u8c03\u5ea6\u7b56\u7565\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        Vector<String> scheduleItems = new Vector<String>();
        for (TSSDTaskPolicy taskPolicy : taskPolicies) {
            scheduleItems.add(taskPolicy.getTSSDPOLICYID());
        }
        return this.AddJob(task.getTSSDTASKID(), String.valueOf(this.tsSDEngine.getTSSDENGINEID()) + "GROUP1", task, taskType, scheduleItems);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected TSSDTaskType GetTaskType(String strTaskTypeId) {
        HashMap<String, TSSDTaskType> hashMap = this.taskTypeMap;
        synchronized (hashMap) {
            if (this.taskTypeMap.containsKey(strTaskTypeId)) {
                return this.taskTypeMap.get(strTaskTypeId);
            }
        }
        TSSDTaskType taskType = new TSSDTaskType();
        taskType.setTSSDTASKTYPEID(strTaskTypeId);
        CallResult callResult = this.taskTypeDataCtrl.Get((BaseDataEntity)taskType);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u8c03\u5ea6\u4efb\u52a1\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strTaskTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        HashMap<String, TSSDTaskType> hashMap2 = this.taskTypeMap;
        synchronized (hashMap2) {
            this.taskTypeMap.put(strTaskTypeId, taskType);
        }
        return taskType;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public CallResult AddJob(String strJobId, String strGroupId, TSSDTask task, TSSDTaskType taskType, Vector<String> scheduleItems) {
        CallResult callResult = new CallResult();
        if (scheduleItems.size() == 0) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u4f5c\u4e1a\u8c03\u5ea6\u8ba1\u5212"));
            return callResult;
        }
        HashMap<String, TSSDItem> itemMap = new HashMap<String, TSSDItem>();
        for (String strTSSDItemId : scheduleItems) {
            callResult = this.GetTSSDItems(strTSSDItemId, itemMap);
            if (!callResult.IsError()) continue;
            return callResult;
        }
        HashMap<String, String> cronTriggerMap = new HashMap<String, String>();
        for (TSSDItem tsSDItem : itemMap.values()) {
            cronTriggerMap.put(this.GetTSSDItemCronTrigger(tsSDItem), tsSDItem.getTSSDITEMID());
        }
        IScheduleEngineTask taskEngine = this.GetTaskObject(taskType);
        if (task == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u8c03\u5ea6\u4efb\u52a1[%1$s]\u7a0b\u5e8f\u5931\u8d25\uff0c%1$s", (Object)taskType.getTSSDTASKTYPEID()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        try {
            JobDetail jobDetail = new JobDetail(strJobId, strGroupId, ScheduleEngineJob.class);
            JobDataMap jobDataMap = new JobDataMap();
            jobDataMap.put((Object)TAG_ENGINEOBJECT, (Object)taskEngine);
            jobDataMap.put((Object)TAG_JOBPARAM, (Object)task);
            jobDataMap.put((Object)TAG_CONTEXT, (Object)this);
            jobDetail.setJobDataMap(jobDataMap);
            this.sched.addJob(jobDetail, true);
            for (String strKey : cronTriggerMap.keySet()) {
                CronTrigger trigger = new CronTrigger(String.valueOf(strJobId) + "_" + (String)cronTriggerMap.get(strKey), String.valueOf(this.tsSDEngine.getTSSDENGINEID()) + "GROUP1", strJobId, strGroupId, strKey);
                this.sched.scheduleJob((Trigger)trigger);
            }
            HashMap<String, Integer> hashMap = this.runTaskMap;
            synchronized (hashMap) {
                this.runTaskMap.put(strJobId, task.getVERSION());
            }
        }
        catch (ParseException e) {
            log.error((Object)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u589e\u52a0\u8c03\u5ea6\u7a0b\u5e8f\u5931\u8d25\uff0c%1$s", (Object)e.getMessage()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        catch (SchedulerException e) {
            log.error((Object)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u589e\u52a0\u8c03\u5ea6\u7a0b\u5e8f\u5931\u8d25\uff0c%1$s", (Object)e.getMessage()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        return callResult;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public CallResult RemoveJob(String strJobId, String strGroupId) {
        CallResult callResult = new CallResult();
        try {
            HashMap<String, Integer> hashMap = this.runTaskMap;
            synchronized (hashMap) {
                this.runTaskMap.remove(strJobId);
            }
            this.sched.deleteJob(strJobId, strGroupId);
        }
        catch (SchedulerException e) {
            log.error((Object)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u5220\u9664\u8c03\u5ea6\u7a0b\u5e8f\u5931\u8d25\uff0c%1$s", (Object)e.getMessage()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        return callResult;
    }

    @Override
    public void Stop() {
        CallResult callResult = new CallResult();
        try {
            this.runTaskMap.clear();
            this.sched.shutdown(true);
        }
        catch (SchedulerException e) {
            log.error((Object)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u542f\u52a8\u8c03\u5ea6\u7a0b\u5e8f\u5931\u8d25\uff0c%1$s", (Object)e.getMessage()));
            log.error((Object)callResult.getErrorInfo());
        }
    }

    protected CallResult GetTSSDItems(String strTSSDId, HashMap<String, TSSDItem> itemMap) {
        String strSQL = "select t1.* from T_SRFTSSDITEM t1 where TSSDITEMID = ? \tUNION  SELECT t2.* from T_SRFTSSDITEM t2  INNER JOIN T_SRFTSSDGROUPDETAIL t3 on t2.TSSDITEMID = t3.TSSDITEMID where t3.TSSDGROUPID=?";
        CallParamList callParamList = new CallParamList();
        callParamList.AddString(strTSSDId);
        callParamList.AddString(strTSSDId);
        Vector tsItems = new Vector();
        CallResult callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)"", (String)strSQL, (Vector)callParamList.GetList(), tsItems, (String)TSSDItem.class.getName());
        if (callResult.IsError()) {
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        for (TSSDItem tsItem : tsItems) {
            itemMap.put(tsItem.getTSSDITEMID(), tsItem);
        }
        return callResult;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected String GetTSSDItemCronTrigger(TSSDItem tsItem) {
        String strCronTrigger = "";
        String strKey = StringHelper.Format((String)"%1$s__%2$s", (Object)tsItem.getTSSDITEMID(), (Object)tsItem.getVERSION());
        HashMap<String, String> hashMap = this.tsSDItemCronTriggerMap;
        synchronized (hashMap) {
            if (this.tsSDItemCronTriggerMap.containsKey(strKey)) {
                return this.tsSDItemCronTriggerMap.get(strKey);
            }
        }
        strCronTrigger = StringHelper.Compare((String)tsItem.getSECONDTYPE(), (String)"EVERY", (boolean)true) == 0 ? String.valueOf(strCronTrigger) + "*" : (StringHelper.Compare((String)tsItem.getSECONDTYPE(), (String)"ZERO", (boolean)true) == 0 ? String.valueOf(strCronTrigger) + "0" : String.valueOf(strCronTrigger) + tsItem.getSECONDVALUE().replace(";", ","));
        strCronTrigger = String.valueOf(strCronTrigger) + " ";
        strCronTrigger = StringHelper.Compare((String)tsItem.getMINUTETYPE(), (String)"EVERY", (boolean)true) == 0 ? String.valueOf(strCronTrigger) + "*" : (StringHelper.Compare((String)tsItem.getMINUTETYPE(), (String)"ZERO", (boolean)true) == 0 ? String.valueOf(strCronTrigger) + "0" : String.valueOf(strCronTrigger) + tsItem.getMINUTEVALUE().replace(";", ","));
        strCronTrigger = String.valueOf(strCronTrigger) + " ";
        strCronTrigger = StringHelper.Compare((String)tsItem.getHOURTYPE(), (String)"EVERY", (boolean)true) == 0 ? String.valueOf(strCronTrigger) + "*" : String.valueOf(strCronTrigger) + tsItem.getHOURVALUE().replace(";", ",");
        strCronTrigger = String.valueOf(strCronTrigger) + " ";
        strCronTrigger = StringHelper.Compare((String)tsItem.getMONTHDAYTYPE(), (String)"EVERY", (boolean)true) == 0 ? String.valueOf(strCronTrigger) + "*" : (StringHelper.Compare((String)tsItem.getMONTHDAYTYPE(), (String)"NONE", (boolean)true) == 0 ? String.valueOf(strCronTrigger) + "?" : String.valueOf(strCronTrigger) + tsItem.getMONTHDAYVALUE().replace(";", ","));
        strCronTrigger = String.valueOf(strCronTrigger) + " ";
        strCronTrigger = StringHelper.Compare((String)tsItem.getMONTHTYPE(), (String)"EVERY", (boolean)true) == 0 ? String.valueOf(strCronTrigger) + "*" : String.valueOf(strCronTrigger) + tsItem.getMONTHVALUE().replace(";", ",");
        strCronTrigger = String.valueOf(strCronTrigger) + " ";
        if (StringHelper.Compare((String)tsItem.getMONTHWEEKTYPE(), (String)"EVERY", (boolean)true) == 0) {
            strCronTrigger = String.valueOf(strCronTrigger) + tsItem.getMONTHWEEKVALUE().replace(";", ",");
        } else if (StringHelper.Compare((String)tsItem.getMONTHWEEKTYPE(), (String)"NONE", (boolean)true) == 0) {
            strCronTrigger = String.valueOf(strCronTrigger) + "?";
        } else {
            strCronTrigger = String.valueOf(strCronTrigger) + tsItem.getMONTHWEEKVALUE().replace(";", ",");
            if (StringHelper.Compare((String)tsItem.getMONTHWEEKTYPE(), (String)"ONE", (boolean)true) == 0) {
                strCronTrigger = String.valueOf(strCronTrigger) + "#1";
            } else if (StringHelper.Compare((String)tsItem.getMONTHWEEKTYPE(), (String)"TWO", (boolean)true) == 0) {
                strCronTrigger = String.valueOf(strCronTrigger) + "#2";
            } else if (StringHelper.Compare((String)tsItem.getMONTHWEEKTYPE(), (String)"THREE", (boolean)true) == 0) {
                strCronTrigger = String.valueOf(strCronTrigger) + "#3";
            } else if (StringHelper.Compare((String)tsItem.getMONTHWEEKTYPE(), (String)"FOUR", (boolean)true) == 0) {
                strCronTrigger = String.valueOf(strCronTrigger) + "#4";
            } else if (StringHelper.Compare((String)tsItem.getMONTHWEEKTYPE(), (String)"FIVE", (boolean)true) == 0) {
                strCronTrigger = String.valueOf(strCronTrigger) + "#5";
            }
        }
        hashMap = this.tsSDItemCronTriggerMap;
        synchronized (hashMap) {
            this.tsSDItemCronTriggerMap.put(strKey, strCronTrigger);
        }
        return strCronTrigger;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public IScheduleEngineTask GetTaskObject(TSSDTaskType taskType) {
        IScheduleEngineTask task = null;
        HashMap<String, IScheduleEngineTask> hashMap = this.scheduleEngineTaskMap;
        synchronized (hashMap) {
            if (this.scheduleEngineTaskMap.containsKey(taskType.getTSSDTASKTYPEID())) {
                return this.scheduleEngineTaskMap.get(taskType.getTSSDTASKTYPEID());
            }
        }
        Object objTask = ObjectHelper.Create((String)taskType.getTASKOBJECT());
        if (objTask == null) {
            return null;
        }
        if (objTask instanceof IScheduleEngineTask) {
            task = (IScheduleEngineTask)objTask;
            task.Init(this, taskType);
            HashMap<String, IScheduleEngineTask> hashMap2 = this.scheduleEngineTaskMap;
            synchronized (hashMap2) {
                this.scheduleEngineTaskMap.put(taskType.getTSSDTASKTYPEID(), task);
            }
        }
        return task;
    }

    @Override
    public Object getAttribute(String strKey) {
        return this.attributeMap.get(strKey);
    }

    @Override
    public ISRFDAGlobalHelper getDAGlobalHelper() {
        return this.iDAGlobalHelper;
    }

    @Override
    public void setAttribute(String strKey, Object objValue) {
        if (objValue == null) {
            this.attributeMap.remove(strKey);
        } else {
            this.attributeMap.put(strKey, objValue);
        }
    }

    @Override
    public Object getParam(String strKey) {
        return this.paramMap.get(strKey);
    }

    private static void InitEngineParam(HashMap<String, Object> paramMap, IScheduleEngineContext iEngineContext, TSSDEngine tsSDEngine) {
        Properties properties = tsSDEngine.getEngineParam();
        if (properties == null) {
            return;
        }
        Enumeration<Object> en = properties.keys();
        en.hasMoreElements();
        while (en.hasMoreElements()) {
            String strKey = (String)en.nextElement();
            String strValue = PropertiesHelper.GetProperty((Properties)properties, (String)strKey);
            if (StringHelper.Compare((String)"%%SRFREMOVE()%%", (String)strValue, (boolean)true) == 0 || StringHelper.Compare((String)"%%SRFREMOVE%%", (String)strValue, (boolean)true) == 0) {
                paramMap.remove(strKey);
                continue;
            }
            CallResult callResult = MacroHelper.GetValue((String)strValue, null, (ISRFDAGlobalHelper)iEngineContext.getDAGlobalHelper(), (String)"", null);
            if (callResult.getRetCode() != 0) {
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6307\u5b9a\u503c[%1$s],%2$s", (Object)strValue, (Object)callResult.getErrorInfo()));
                callResult.setRetCode(1);
                return;
            }
            Object obj = callResult.getUserObject();
            if (obj == null) {
                paramMap.remove(strKey);
                continue;
            }
            if (obj instanceof String) {
                strValue = obj.toString();
                if (StringHelper.IsNullOrEmpty((String)strValue)) {
                    paramMap.remove(strKey);
                    continue;
                }
                paramMap.put(strKey, obj);
                continue;
            }
            paramMap.put(strKey, obj);
        }
    }

    @Override
    public void LogTaskExecute(TSSDTaskLog taskLog) {
        BaseDEDataCtrl.SetCallParamCheckKey((BaseDataEntity)taskLog, (boolean)false);
        BaseDEDataCtrl.SetCallParamRetData((BaseDataEntity)taskLog, (boolean)false);
        this.taskLogDataCtrl.Save(true, (BaseDataEntity)taskLog);
    }
}

