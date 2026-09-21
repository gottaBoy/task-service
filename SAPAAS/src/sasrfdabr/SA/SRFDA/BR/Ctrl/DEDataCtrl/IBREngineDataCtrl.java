/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.BR.Ctrl.DEDataCtrl;

import SA.SRFDA.BR.Ctrl.Data.BRAction;
import SA.SRFDA.BR.Ctrl.Data.BRInstParam;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFramework.DataEx.CallResult;
import java.util.Vector;

public interface IBREngineDataCtrl
extends IDEDataCtrl {
    public CallResult GetInstParams(String var1, Vector<BRInstParam> var2);

    public CallResult GetActions(String var1, Vector<BRAction> var2);
}

