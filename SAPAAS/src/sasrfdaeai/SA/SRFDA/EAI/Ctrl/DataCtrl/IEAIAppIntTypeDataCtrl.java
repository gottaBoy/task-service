/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.EAI.Ctrl.DataCtrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.EAI.Ctrl.Data.EAIAppIntType;
import SA.SRFramework.DataEx.CallResult;
import java.util.Vector;

public interface IEAIAppIntTypeDataCtrl
extends IDEDataCtrl {
    public CallResult GetAppIntTypes(boolean var1, Vector<EAIAppIntType> var2);
}

