/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.BI.Ctrl.DEDataCtrl;

import SA.SRFDA.BI.Ctrl.DEDataCtrl.IBICubeDimensionDataCtrl;
import SA.SRFDA.BI.Ctrl.Data.BICubeDimension;
import SA.SRFDA.BI.Ctrl.Data.BIHierarchy;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;

public class BICubeDimensionDataCtrl
extends BaseDEDataCtrl
implements IBICubeDimensionDataCtrl {
    @Override
    public CallResult ListBIHierarchies(BICubeDimension biCubeDimension, Vector<BIHierarchy> list) {
        CallResult callResult = new CallResult();
        String strSQL = "";
        if (StringHelper.Compare((String)biCubeDimension.getBICUBEDIMENSIONTYPE(), (String)"NORMAL", (boolean)true) == 0) {
            strSQL = "select t1.* from V_SRFBIHIERARCHY t1 where t1.BIDIMENSIONID = ?";
        } else if (StringHelper.Compare((String)biCubeDimension.getBICUBEDIMENSIONTYPE(), (String)"REF", (boolean)true) == 0) {
            strSQL = "select t1.* from V_SRFBIHIERARCHY t1 LEFT JOIN T_SRFBIDIMENSIONREF t2 ON t1.BIDIMENSIONID = t2.BIDIMENSIONID where t2.BIDIMENSIONREFID = ?";
        } else {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u591a\u7ef4\u5206\u6790\u7acb\u65b9\u4f53\u7ef4\u5ea6\u7c7b\u578b[%1$s]", (Object)biCubeDimension.getBICUBEDIMENSIONTYPE()));
            return callResult;
        }
        CallParamList callParamList = new CallParamList();
        callParamList.Add((Object)biCubeDimension.getBICUBEDIMENSIONID());
        return BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.getGlobalHelper(), (String)this.GetDEHelper().GetDBStorage(), (String)strSQL, (Vector)callParamList.GetList(), list, (String)BIHierarchy.class.getName());
    }
}

