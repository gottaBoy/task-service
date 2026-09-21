/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 */
package SRFWF.Ctrl;

import SA.SRFramework.DataEx.CallResult;
import SRFWF.Ctrl.Data.WFActor;
import SRFWF.Ctrl.Data.WFUser;
import SRFWF.Ctrl.ISRFWFContext;
import java.util.Vector;

public interface ISRFWFDynamicUser {
    public CallResult GetUsers(ISRFWFContext var1, WFActor var2, Vector<WFUser> var3);
}

