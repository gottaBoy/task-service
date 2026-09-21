/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.BI.Ctrl.DEDataCtrl;

import SA.SRFDA.BI.Ctrl.DEDataCtrl.IBITD_HourDataCtrl;
import SA.SRFDA.BI.Ctrl.Data.BITD_Hour;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.sql.Timestamp;
import java.util.Calendar;

public class BITD_HourDataCtrl
extends BaseDEDataCtrl
implements IBITD_HourDataCtrl {
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)"GENTD", (boolean)true) == 0) {
            return this.GenTD(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    @Override
    public CallResult GenTD(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        Calendar calendar = Calendar.getInstance();
        int nYear = dataEntity.GetParamIntValue("YEAR", calendar.get(1));
        calendar.set(--nYear, 0, 1, 0, 0, 0);
        while (calendar.get(1) == nYear) {
            BITD_Hour hour = new BITD_Hour();
            hour.setBITD_HOURID(StringHelper.Format((String)"H%1$s%2$02d%3$02d%4$02d", (Object)nYear, (Object)(calendar.get(2) + 1), (Object)calendar.get(5), (Object)calendar.get(11)));
            hour.setBITD_HOURNAME(StringHelper.Format((String)"H%1$s%2$02d%3$02d%4$02d", (Object)nYear, (Object)(calendar.get(2) + 1), (Object)calendar.get(5), (Object)calendar.get(11)));
            hour.setYEARVALUE(nYear);
            hour.setYEARTEXT(StringHelper.Format((String)"%1$s", (Object)nYear));
            hour.setMONTHVALUE(calendar.get(2) + 1);
            hour.setMONTHTEXT(StringHelper.Format((String)"%1$s\u6708", (Object)(calendar.get(2) + 1)));
            hour.setDAYVALUE(calendar.get(5));
            hour.setDAYTEXT(StringHelper.Format((String)"%1$s\u65e5", (Object)calendar.get(5)));
            hour.setHOURVALUE(calendar.get(11));
            hour.setHOURTEXT(StringHelper.Format((String)"%1$s\u65f6", (Object)calendar.get(11)));
            hour.SetParamValue("STARTTIME", new Timestamp(calendar.getTime().getTime()));
            calendar.add(11, 1);
            hour.SetParamValue("ENDTIME", new Timestamp(calendar.getTime().getTime()));
            callResult = this.Save(true, hour);
            if (callResult.getRetCode() == 7 || callResult.getRetCode() == 1007) {
                callResult.Reset();
                continue;
            }
            if (!callResult.IsError()) continue;
            return callResult;
        }
        return callResult;
    }
}

