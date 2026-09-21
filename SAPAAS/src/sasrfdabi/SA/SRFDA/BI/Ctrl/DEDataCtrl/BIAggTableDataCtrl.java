/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.BI.Ctrl.DEDataCtrl;

import SA.SRFDA.BI.Ctrl.DEDataCtrl.IBIAggTableDataCtrl;
import SA.SRFDA.BI.Ctrl.Data.BIAggTable;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFramework.DataEx.CallResult;
import java.util.Vector;

public class BIAggTableDataCtrl
extends BaseDEDataCtrl
implements IBIAggTableDataCtrl {
    @Override
    public CallResult ListAllAggTables(Vector<BIAggTable> aggTables) {
        return new CallResult();
    }
}

