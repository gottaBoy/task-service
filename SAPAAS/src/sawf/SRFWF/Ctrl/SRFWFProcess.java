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
import SRFWF.Model.WFStartProcessConfig;

public class SRFWFProcess
extends SRFWFBaseProcess {
    @Override
    public CallResult Execute(ISRFWFContext context) {
        if (context.getCurProcessConfig() != null) {
            if (context.getCurProcessConfig() instanceof WFStartProcessConfig) {
                WFStartProcessConfig processConfig = (WFStartProcessConfig)context.getCurProcessConfig();
                context.setNext(processConfig.getNext());
            } else if (context.getCurProcessConfig() instanceof WFProcessConfig) {
                WFProcessConfig processConfig = (WFProcessConfig)context.getCurProcessConfig();
                context.setNext(processConfig.getNext());
            }
        }
        return new CallResult();
    }
}

