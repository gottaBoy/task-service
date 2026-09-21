/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.BI.Ctrl.DEDataCtrl;

import SA.SRFDA.BI.Ctrl.Data.BICubeDimension;
import SA.SRFDA.BI.Ctrl.Data.BIHierarchy;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFramework.DataEx.CallResult;
import java.util.Vector;

public interface IBICubeDimensionDataCtrl
extends IDEDataCtrl {
    public CallResult ListBIHierarchies(BICubeDimension var1, Vector<BIHierarchy> var2);
}

