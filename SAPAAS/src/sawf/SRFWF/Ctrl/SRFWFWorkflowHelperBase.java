/*
 * Decompiled with CFR 0.152.
 */
package SRFWF.Ctrl;

import SRFWF.Ctrl.ISRFWFContext;
import SRFWF.Ctrl.ISRFWFWorkflowHelper;
import SRFWF.Model.WFInteractiveProcessConfig;

public abstract class SRFWFWorkflowHelperBase
implements ISRFWFWorkflowHelper {
    @Override
    public WFInteractiveProcessConfig ReCalcInteractiveProcess(ISRFWFContext iSRFWFContext, WFInteractiveProcessConfig wfInteractiveProcessConfig) throws Exception {
        return wfInteractiveProcessConfig;
    }
}

