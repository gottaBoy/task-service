/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.Data.SOAService;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFramework.DataEx.CallResult;
import java.util.Vector;

public interface ISOAServiceDataCtrl
extends IDEDataCtrl {
    public CallResult SelectAutoStartService(Vector<SOAService> var1);

    public CallResult MarkServiceStart(String var1);

    public CallResult MarkServiceStop(String var1);
}

