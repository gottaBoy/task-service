/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.Data.DEAnalysis;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;

public interface IDEAnalysisHelper {
    public CallResult Init(DEAnalysis var1, ISRFDAGlobalHelper var2);

    public CallResult Execute();

    public CallResult GetProcCode();

    public CallResult PublishProcCode();
}

