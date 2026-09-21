/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.DEDataCtrl.IDEBHGroupDataCtrl;
import SA.SRFDA.Ctrl.Data.DEBehavior;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.DataEx.CallResult;
import java.util.Vector;

public class DEBHGroupDataCtrl
extends BaseDEDataCtrl
implements IDEBHGroupDataCtrl {
    @Override
    public CallResult ListDEBehaviors(String strDEBHGroupId, Vector<DEBehavior> deBehaviors) {
        String strSQL = "select t1.* from V_SRFDEBEHAVIOR t1  LEFT JOIN T_SRFDEBHGDETAIL t2 on t2.DEBEHAVIORID = t1.DEBEHAVIORID  where t2.DEBHGROUPID=? order by t2.ORDERFLAG ";
        CallParamList callParamList = new CallParamList();
        callParamList.Add((Object)strDEBHGroupId);
        return BaseDEDataCtrl.SelectMultiEx(this.globalHelperEx, this.GetDEHelper().GetDBStorage(), strSQL, callParamList.GetList(), deBehaviors, DEBehavior.class.getName());
    }
}

