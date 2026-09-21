/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.TM.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.TM.Ctrl.Data.TMResBooking;
import SA.TM.Ctrl.ITMActionContext;

public interface ITMRBCheckEngine {
    public void Init(ISRFDAGlobalHelper var1) throws Exception;

    public CallResult Check(ITMActionContext var1, TMResBooking var2, TMResBooking var3) throws Exception;

    public void CalcResDayBKTime(ITMActionContext var1, TMResBooking var2, TMResBooking var3) throws Exception;
}

