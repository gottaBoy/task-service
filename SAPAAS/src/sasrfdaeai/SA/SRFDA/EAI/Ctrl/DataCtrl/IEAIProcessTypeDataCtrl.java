/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.EAI.Ctrl.DataCtrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.EAI.Ctrl.Data.EAIProcessType;
import SA.SRFramework.DataEx.CallResult;
import java.util.Vector;

public interface IEAIProcessTypeDataCtrl
extends IDEDataCtrl {
    public CallResult GetProcessTypes(Vector<EAIProcessType> var1);
}

