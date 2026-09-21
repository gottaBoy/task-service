/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.TS.Ctrl;

import SA.SRFDA.TS.Ctrl.Data.TSSDTask;
import SA.SRFDA.TS.Ctrl.Data.TSSDTaskType;
import SA.SRFDA.TS.Ctrl.IScheduleEngineContext;
import SA.SRFramework.DataEx.CallResult;

public interface IScheduleEngineTask {
    public void Init(IScheduleEngineContext var1, TSSDTaskType var2);

    public CallResult Execute(TSSDTask var1);
}

