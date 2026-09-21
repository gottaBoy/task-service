/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.TS.Ctrl;

import SA.SRFDA.TS.Ctrl.Data.TSSDEngine;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;

public interface IScheduleEngine {
    public CallResult Init(ISRFDAGlobalHelper var1, TSSDEngine var2);

    public CallResult Start();

    public void Stop();
}

