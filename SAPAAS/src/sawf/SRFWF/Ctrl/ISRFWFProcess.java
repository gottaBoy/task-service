/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 */
package SRFWF.Ctrl;

import SA.SRFramework.DataEx.CallResult;
import SRFWF.Ctrl.ISRFWFContext;

public interface ISRFWFProcess {
    public CallResult BeforeExecute(ISRFWFContext var1);

    public CallResult Execute(ISRFWFContext var1);

    public CallResult AfterExecute(ISRFWFContext var1);
}

