/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 */
package SRFWF.Ctrl;

import SA.SRFramework.DataEx.CallResult;
import SRFWF.Ctrl.Data.WFIAAction;
import SRFWF.Ctrl.Data.WFStepData;
import SRFWF.Ctrl.ISRFWFContext;
import SRFWF.Ctrl.ISRFWFDataCtrl;

public interface ISRFWFCustomIAConnectionRule {
    public CallResult Test(ISRFWFContext var1, ISRFWFDataCtrl var2, WFStepData var3, WFIAAction var4, String var5);
}

