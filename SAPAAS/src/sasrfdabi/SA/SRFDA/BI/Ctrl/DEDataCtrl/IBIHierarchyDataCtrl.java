/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.BI.Ctrl.DEDataCtrl;

import SA.SRFDA.BI.Ctrl.Data.BILevel;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFramework.DataEx.CallResult;
import java.util.Vector;

public interface IBIHierarchyDataCtrl
extends IDEDataCtrl {
    public CallResult ListBILevels(String var1, Vector<BILevel> var2);
}

