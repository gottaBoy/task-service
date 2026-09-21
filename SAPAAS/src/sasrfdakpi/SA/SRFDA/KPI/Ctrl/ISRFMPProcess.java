/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.KPI.Ctrl;

import SA.SRFDA.KPI.Ctrl.Data.KPIMP;
import SA.SRFDA.KPI.Ctrl.ISRFKPIContext;
import SA.SRFramework.DataEx.CallResult;

public interface ISRFMPProcess {
    public CallResult Process(KPIMP var1, ISRFKPIContext var2);
}

