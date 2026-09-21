/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 */
package SRFWF.Ctrl;

import SA.SRFramework.DataEx.CallResult;
import SRFWF.Ctrl.ISRFWFContext;
import SRFWF.Ctrl.SRFWFBaseProcess;
import SRFWF.Model.WFProcessConfig;

public class SRFWFDefaultProcess
extends SRFWFBaseProcess {
    @Override
    public CallResult Execute(ISRFWFContext context) {
        CallResult callResult = new CallResult();
        if (context.getCurProcessConfig() instanceof WFProcessConfig) {
            WFProcessConfig processConfig = (WFProcessConfig)context.getCurProcessConfig();
            context.setNext(processConfig.getNext());
        }
        return callResult;
    }
}

