/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 */
package SRFWF.Ctrl;

import SA.SRFramework.DataEx.CallResult;
import SRFWF.Ctrl.ISRFWFContext;
import SRFWF.Ctrl.ISRFWFProcess;

public abstract class SRFWFBaseProcess
implements ISRFWFProcess {
    @Override
    public CallResult AfterExecute(ISRFWFContext context) {
        return new CallResult();
    }

    @Override
    public CallResult BeforeExecute(ISRFWFContext context) {
        return new CallResult();
    }
}

