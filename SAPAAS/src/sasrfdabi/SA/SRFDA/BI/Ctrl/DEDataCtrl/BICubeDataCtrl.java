/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.Data.Threshold
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.BI.Ctrl.DEDataCtrl;

import SA.SRFDA.BI.Ctrl.DEDataCtrl.IBICubeDataCtrl;
import SA.SRFDA.BI.Ctrl.Data.BICubeDimension;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.Data.Threshold;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.DataEx.CallResult;
import java.util.Vector;

public class BICubeDataCtrl
extends BaseDEDataCtrl
implements IBICubeDataCtrl {
    @Override
    public CallResult ListBICubeDimensions(String strBICubeId, Vector<BICubeDimension> list) {
        String strSQL = "select * from V_SRFBICUBEDIMENSION where BICUBEID = ? ORDER BY ORDERFLAG";
        CallParamList callParamList = new CallParamList();
        callParamList.AddString(strBICubeId);
        CallResult callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.globalHelperEx, (String)this.GetDEHelper().GetDBStorage(), (String)strSQL, (Vector)callParamList.GetList(), list, (String)BICubeDimension.class.getName());
        return callResult;
    }

    @Override
    public CallResult ListBICubeThresholds(String strBICubeId, Vector<Threshold> list) {
        String strSQL = "SELECT t1.*,t21.BICubeMeasureName FROM T_SRFTHRESHOLD t1  LEFT JOIN T_SRFTHGROUP t11 ON t1.THGROUPID = t11.THGROUPID  LEFT JOIN T_SRFBICUBEMEASURE t21 ON  t11.THGROUPID = t21.THGROUPID where ( t21.BICUBEID = ?  )";
        CallParamList callParamList = new CallParamList();
        callParamList.AddString(strBICubeId);
        CallResult callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.globalHelperEx, (String)this.GetDEHelper().GetDBStorage(), (String)strSQL, (Vector)callParamList.GetList(), list, (String)Threshold.class.getName());
        return callResult;
    }
}

