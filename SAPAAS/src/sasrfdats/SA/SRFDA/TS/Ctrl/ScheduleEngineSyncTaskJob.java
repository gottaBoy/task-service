/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.quartz.Job
 *  org.quartz.JobExecutionContext
 *  org.quartz.JobExecutionException
 */
package SA.SRFDA.TS.Ctrl;

import SA.SRFDA.TS.Ctrl.IScheduleEngineContext;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class ScheduleEngineSyncTaskJob
implements Job {
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        IScheduleEngineContext iScheduleEngineContext = (IScheduleEngineContext)arg0.getJobDetail().getJobDataMap().get((Object)"%CONTEXT%");
        iScheduleEngineContext.SyncTask();
    }
}

