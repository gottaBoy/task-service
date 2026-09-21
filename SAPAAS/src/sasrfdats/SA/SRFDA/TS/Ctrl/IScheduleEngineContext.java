/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.TS.Ctrl;

import SA.SRFDA.TS.Ctrl.Data.TSSDTaskLog;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IScheduleEngineContext {
    public ISRFDAGlobalHelper getDAGlobalHelper();

    public void setAttribute(String var1, Object var2);

    public Object getAttribute(String var1);

    public Object getParam(String var1);

    public void SyncTask();

    public void LogTaskExecute(TSSDTaskLog var1);
}

