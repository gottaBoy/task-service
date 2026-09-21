/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.BI.Ctrl.DEDataCtrl;

import SA.SRFDA.BI.Ctrl.DEDataCtrl.IBIHierarchyDataCtrl;
import SA.SRFDA.BI.Ctrl.Data.BILevel;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.DataEx.CallResult;
import java.util.Vector;

public class BIHierarchyDataCtrl
extends BaseDEDataCtrl
implements IBIHierarchyDataCtrl {
    @Override
    public CallResult ListBILevels(String strBIHierarchyId, Vector<BILevel> list) {
        String strSQL = "select t1.* from V_SRFBILEVEL t1 where t1.BIHIERARCHYID = ? ORDER BY ORDERFLAG";
        CallParamList callParamList = new CallParamList();
        callParamList.Add((Object)strBIHierarchyId);
        return BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.getGlobalHelper(), (String)this.GetDEHelper().GetDBStorage(), (String)strSQL, (Vector)callParamList.GetList(), list, (String)BILevel.class.getName());
    }
}

