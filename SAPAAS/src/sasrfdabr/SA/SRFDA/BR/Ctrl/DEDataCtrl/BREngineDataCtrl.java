/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.BR.Ctrl.DEDataCtrl;

import SA.SRFDA.BR.Ctrl.DEDataCtrl.IBREngineDataCtrl;
import SA.SRFDA.BR.Ctrl.Data.BRAction;
import SA.SRFDA.BR.Ctrl.Data.BRInstParam;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.DataEx.CallResult;
import java.util.Vector;

public class BREngineDataCtrl
extends BaseDEDataCtrl
implements IBREngineDataCtrl {
    @Override
    public CallResult GetInstParams(String strBREngineId, Vector<BRInstParam> brInstParams) {
        String strSQL = "select * from V_SRFBRINSTPARAM where BRENGINEID = ?";
        CallParamList callParamList = new CallParamList();
        callParamList.AddString(strBREngineId);
        return BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.globalHelperEx, (String)strSQL, (Vector)callParamList.GetList(), brInstParams, (String)BRInstParam.class.getName());
    }

    @Override
    public CallResult GetActions(String strBREngineId, Vector<BRAction> brActions) {
        String strSQL = "select * from V_SRFBRACTION where BRENGINEID = ?";
        CallParamList callParamList = new CallParamList();
        callParamList.AddString(strBREngineId);
        return BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.globalHelperEx, (String)strSQL, (Vector)callParamList.GetList(), brActions, (String)BRAction.class.getName());
    }
}

