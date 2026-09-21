/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.DEDataCtrl.IDEDCProcTypeDataCtrl
 *  SA.SRFDA.Ctrl.Data.DEDCProcType
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.DEDC.Ctrl.DataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.DEDataCtrl.IDEDCProcTypeDataCtrl;
import SA.SRFDA.Ctrl.Data.DEDCProcType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.Vector;

public class DEDCProcTypeDataCtrl
extends BaseDEDataCtrl
implements IDEDCProcTypeDataCtrl {
    public CallResult GetProcessTypes(Vector<DEDCProcType> list) {
        String strSQL = "select * from V_SRFDEDCPROCTYPE where ENABLE=1 ORDER BY SHOWORDER";
        return BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.globalHelperEx, (String)"", (String)strSQL, null, list, (String)DEDCProcType.class.getName());
    }
}

