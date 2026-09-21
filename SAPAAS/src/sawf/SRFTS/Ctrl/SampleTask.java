/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 */
package SRFTS.Ctrl;

import SA.SRFramework.DataEx.CallResult;
import SRFTS.Ctrl.ISRFTSTask;
import SRFTS.Ctrl.ISRFTSTaskContext;

public class SampleTask
implements ISRFTSTask {
    @Override
    public CallResult Run(ISRFTSTaskContext context) {
        CallResult callResult = new CallResult();
        callResult.setRetCode(0);
        callResult.setErrorInfo(context.getTaskItem().getTSTASKITEMID());
        return callResult;
    }
}

