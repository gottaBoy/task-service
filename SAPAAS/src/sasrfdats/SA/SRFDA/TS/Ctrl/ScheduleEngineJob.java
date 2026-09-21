/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.quartz.Job
 *  org.quartz.JobExecutionContext
 *  org.quartz.JobExecutionException
 */
package SA.SRFDA.TS.Ctrl;

import SA.SRFDA.TS.Ctrl.Data.TSSDTask;
import SA.SRFDA.TS.Ctrl.Data.TSSDTaskLog;
import SA.SRFDA.TS.Ctrl.IScheduleEngineContext;
import SA.SRFDA.TS.Ctrl.IScheduleEngineTask;
import SA.SRFramework.DataEx.CallResult;
import java.sql.Timestamp;
import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class ScheduleEngineJob
implements Job {
    private static Log log = LogFactory.getLog(ScheduleEngineJob.class);

    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        IScheduleEngineContext iScheduleEngineContext = (IScheduleEngineContext)arg0.getJobDetail().getJobDataMap().get((Object)"%CONTEXT%");
        Date dtStartTime = new Date();
        TSSDTaskLog taskLog = new TSSDTaskLog();
        try {
            IScheduleEngineTask taskEngine = (IScheduleEngineTask)arg0.getJobDetail().getJobDataMap().get((Object)"%ENGINEOBJECT%");
            TSSDTask task = (TSSDTask)((Object)arg0.getJobDetail().getJobDataMap().get((Object)"%JOBPARAM%"));
            taskLog.setTSSDTASKID(task.getTSSDTASKID());
            taskLog.SetParamValue("STARTTIME", new Timestamp(dtStartTime.getTime()));
            CallResult callResult = taskEngine.Execute(task);
            Date dtEndTime = new Date();
            taskLog.SetParamValue("ENDTIME", new Timestamp(dtEndTime.getTime()));
            taskLog.setRETCODE(callResult.getRetCode());
            taskLog.setRETINFO(callResult.getErrorInfo());
            taskLog.setDURATION((int)(dtEndTime.getTime() - dtStartTime.getTime()));
        }
        catch (Exception ex) {
            log.error((Object)ex);
            Date dtEndTime = new Date();
            taskLog.SetParamValue("ENDTIME", new Timestamp(dtEndTime.getTime()));
            taskLog.setRETCODE(1);
            taskLog.setRETINFO(ex.getMessage());
            taskLog.setDURATION((int)(dtEndTime.getTime() - dtStartTime.getTime()));
        }
        iScheduleEngineContext.LogTaskExecute(taskLog);
    }
}

