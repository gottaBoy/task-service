/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.DateParser
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.CAL.Ctrl.DEDataCtrl;

import SA.SRFDA.CAL.Ctrl.CalScheduleHelper;
import SA.SRFDA.CAL.Ctrl.Data.CalSchedule;
import SA.SRFDA.CAL.Ctrl.Data.Calendar;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.DateParser;
import SA.SRFramework.Utility.StringHelper;
import java.sql.Timestamp;
import java.util.Date;

public class CalScheduleDataCtrl
extends BaseDEDataCtrl {
    protected String GetBeginEndTimeString(BaseDataEntity dataEntity) {
        Timestamp tsBeginTime = (Timestamp)dataEntity.GetParamValue("BEGINTIME");
        Timestamp tsEndTime = (Timestamp)dataEntity.GetParamValue("ENDTIME");
        return StringHelper.Format((String)"%1$tH:%1$tM \u81f3 %2$tH:%2$tM", (Object)tsBeginTime, (Object)tsEndTime);
    }

    public CallResult GetDefault(ISRFDAWebContext webContext, BaseDataEntity dataEntity) {
        IDEDataCtrl iCalDataCtrl;
        CallResult callResult = super.GetDefault(webContext, dataEntity);
        String strCalendarId = dataEntity.GetParamStringValue("CALENDARID", "");
        if (!StringHelper.IsNullOrEmpty((String)strCalendarId) && (iCalDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrl("DE0050", webContext)) != null) {
            Calendar calendar = new Calendar();
            calendar.setCALENDARID(strCalendarId);
            callResult = iCalDataCtrl.Get((BaseDataEntity)calendar);
            if (callResult.IsError()) {
                return callResult;
            }
            String strStartTimeString = "1970-01-01 " + DateParser.toTimeString((Date)calendar.getBEGINTIME());
            String strEndTimeString = "1970-01-01 " + DateParser.toTimeString((Date)calendar.getENDTIME());
            try {
                Date dtStartPlanTime = DateParser.Parse((String)strStartTimeString);
                Date dtEndPlanTime = DateParser.Parse((String)strEndTimeString);
                dataEntity.SetParamValue("BEGINTIME", (Object)dtStartPlanTime);
                dataEntity.SetParamValue("ENDTIME", (Object)dtEndPlanTime);
            }
            catch (Exception ex) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(ex.getMessage());
            }
        }
        return callResult;
    }

    protected CallResult OnAfterRemoveOK(String strActionMode, BaseDataEntity dataEntity) {
        CallResult callResult = super.OnAfterRemoveOK(strActionMode, dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        String strCalScheduleId = dataEntity.GetParamStringValue(this.GetDEHelper().GetKeyDEFHelper().getName(), "");
        if (!StringHelper.IsNullOrEmpty((String)strCalScheduleId)) {
            CalScheduleHelper calScheduleHelper = new CalScheduleHelper(this.globalHelperEx);
            calScheduleHelper.RemoveCalendarBySchedule(strCalScheduleId);
        }
        return callResult;
    }

    protected CallResult OnAfterSaveOK(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnAfterSaveOK(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        if (!bInsert) {
            CalScheduleHelper calScheduleHelper = new CalScheduleHelper(this.globalHelperEx);
            CalSchedule calSchedule = new CalSchedule();
            dataEntity.CopyTo((BaseDataEntity)calSchedule, true);
            calSchedule.setCALSCHEDULEID(dataEntity.GetParamStringValue(this.GetDEHelper().GetKeyDEFHelper().getName(), ""));
            calScheduleHelper.UpdateCalSchedule(calSchedule);
        }
        return callResult;
    }
}

