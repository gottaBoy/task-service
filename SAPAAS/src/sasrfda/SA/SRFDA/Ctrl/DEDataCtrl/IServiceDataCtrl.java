/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.Data.Service;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFramework.DataEx.CallResult;
import java.util.Vector;

public interface IServiceDataCtrl
extends IDEDataCtrl {
    public CallResult SelectAutoStartService(String var1, Vector<Service> var2);

    public CallResult MarkServiceStart(String var1);

    public CallResult MarkServiceStop(String var1);
}

