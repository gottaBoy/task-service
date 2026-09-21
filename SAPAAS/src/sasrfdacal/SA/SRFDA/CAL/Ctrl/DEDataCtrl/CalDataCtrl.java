/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.CAL.Ctrl.DEDataCtrl;

import SA.SRFDA.CAL.Ctrl.Data.CalendarType;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;

public class CalDataCtrl
extends BaseDEDataCtrl {
    public static final String TAG_CUSTOMCALL_LISTUSERCREATETYPE = "LISTUSERCREATETYPE";

    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)TAG_CUSTOMCALL_LISTUSERCREATETYPE, (boolean)true) == 0) {
            return this.OnListUserCreateType();
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    protected CallResult OnListUserCreateType() {
        String strSQL = "select * from T_SRFCALENDARTYPE where enable=1 and ISUSERCREATE=1 order by showorder asc ";
        Vector list = new Vector();
        CallResult callResult = CalDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.globalHelperEx, (String)strSQL, null, list, (String)CalendarType.class.getName());
        if (callResult.getRetCode() != 0) {
            return callResult;
        }
        callResult.setUserObject(list);
        return callResult;
    }
}

