/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.Data.GSR2Dimension;
import SA.SRFDA.Ctrl.Data.GSR2Dimension2;
import SA.SRFDA.Ctrl.Data.GSR2Measure;
import SA.SRFDA.Ctrl.Data.GSR2SumTable;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFramework.DataEx.CallResult;
import java.util.Vector;

public interface IGSR2DataCtrl
extends IDEDataCtrl {
    public CallResult ListSumTables(String var1, Vector<GSR2SumTable> var2);

    public CallResult ListDimensions(String var1, Vector<GSR2Dimension> var2);

    public CallResult ListDimensions2(String var1, Vector<GSR2Dimension2> var2);

    public CallResult ListMeasures(String var1, Vector<GSR2Measure> var2);
}

