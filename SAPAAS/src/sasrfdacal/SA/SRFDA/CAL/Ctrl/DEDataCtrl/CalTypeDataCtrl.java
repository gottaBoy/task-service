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

public class CalTypeDataCtrl
extends BaseDEDataCtrl {
    public static final String TAG_CUSTOMCALL_LISTUSERCREATETYPE = "LISTUSERCREATETYPE";

    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)TAG_CUSTOMCALL_LISTUSERCREATETYPE, (boolean)true) == 0) {
            return this.OnListUserCreateType(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    protected CallResult OnListUserCreateType(BaseDataEntity dataEntity) {
        String strCalendarGroup = "";
        if (dataEntity != null) {
            strCalendarGroup = dataEntity.GetParamStringValue("CALENDARGROUP", "");
        }
        String strSQL = "";
        strSQL = StringHelper.IsNullOrEmpty((String)strCalendarGroup) ? "select * from T_SRFCALENDARTYPE where enable=1 and ISUSERCREATE=1 and calendargroup is null order by showorder asc " : StringHelper.Format((String)"select * from T_SRFCALENDARTYPE where enable=1 and ISUSERCREATE=1 and calendargroup = UPPER('%1$s') order by showorder asc ", (Object)strCalendarGroup.toUpperCase());
        Vector list = new Vector();
        CallResult callResult = CalTypeDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.globalHelperEx, (String)this.GetDEHelper().GetDBStorage(), (String)strSQL, null, list, (String)CalendarType.class.getName());
        if (callResult.getRetCode() != 0) {
            return callResult;
        }
        callResult.setUserObject(list);
        return callResult;
    }
}

