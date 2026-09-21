/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.CallParam
 *  SA.SRFramework.Data.DataTypeParse
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.DateParser
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.CAL.Ctrl;

import SA.SRFDA.CAL.Ctrl.Data.CalSchedule;
import SA.SRFDA.CAL.Ctrl.Data.Calendar;
import SA.SRFDA.CAL.Ctrl.Data.CalendarType;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParam;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.DateParser;
import SA.SRFramework.Utility.StringHelper;
import java.sql.Timestamp;
import java.util.Date;
import java.util.TreeMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CalScheduleHelper {
    protected ISRFDAGlobalHelper iGlobalHelper = null;
    private static Log log = LogFactory.getLog(CalScheduleHelper.class);
    protected IDEDataCtrl iCalDataCtrl = null;
    protected IDEDataCtrl iCalTypeDataCtrl = null;
    protected TreeMap<String, CalendarType> calendarTypeMap = new TreeMap();

    public CalScheduleHelper(ISRFDAGlobalHelper iGlobalHelper) {
        this.iGlobalHelper = iGlobalHelper;
        this.iCalDataCtrl = iGlobalHelper.getDAModelStorage().FindDEDataCtrl("DE0050", "SYSTEM", null);
        this.iCalTypeDataCtrl = iGlobalHelper.getDAModelStorage().FindDEDataCtrl("DE0051", "SYSTEM", null);
    }

    public CallResult CreateCalendar(String strCalendarGroup, Timestamp dtStartTime, Timestamp dtEndTime) {
        Vector<CalSchedule> list = new Vector<CalSchedule>();
        CallResult callResult = this.GetCalSchedule(strCalendarGroup, dtStartTime, dtEndTime, list);
        for (CalSchedule calSchedule : list) {
            this.ParseCalSchedule(calSchedule, dtStartTime, dtEndTime);
        }
        return callResult;
    }

    protected CallResult GetCalSchedule(String strCalendarGroup, Timestamp dtStartTime, Timestamp dtEndTime, Vector<CalSchedule> list) {
        String strSqlFormat = "select t1.* from t_SRFCALSchedule t1 ";
        strSqlFormat = String.valueOf(strSqlFormat) + "INNER JOIN t_SRFCalendar t2 on t1.CALENDARID = t2.CALENDARID ";
        strSqlFormat = String.valueOf(strSqlFormat) + "INNER JOIN t_SRFCalendarType t3 on t3.CALENDARTYPEID = t2.CALENDARTYPEID ";
        strSqlFormat = String.valueOf(strSqlFormat) + "where  (Scheduletype<>'1'  and (t1.CycleEndtime IS NULL OR t1.CycleEndtime > ?) and t1.CycleStartTime< ?) ";
        if (!StringHelper.IsNullOrEmpty((String)strCalendarGroup)) {
            strSqlFormat = String.valueOf(strSqlFormat) + "  AND t3.CALENDARGROUP=? ";
        }
        Vector<CallParam> callParams = new Vector<CallParam>();
        CallParam callParam = new CallParam();
        callParam.setValue((Object)dtStartTime);
        callParams.add(callParam);
        callParam = new CallParam();
        callParam.setValue((Object)dtEndTime);
        callParams.add(callParam);
        if (!StringHelper.IsNullOrEmpty((String)strCalendarGroup)) {
            callParam = new CallParam();
            callParam.setValue((Object)strCalendarGroup);
            callParams.add(callParam);
        }
        return BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.iGlobalHelper, (String)strSqlFormat, callParams, list, (String)CalSchedule.class.getName());
    }

    protected CallResult ParseCalSchedule(CalSchedule calSchedule, Date dtStartTime, Date dtEndTime) {
        String strEndTimeDEFName;
        CallResult callResult = new CallResult();
        Calendar cal = new Calendar();
        cal.setCALENDARID(calSchedule.getCALENDARID());
        callResult = this.iCalDataCtrl.Get((BaseDataEntity)cal);
        if (callResult.IsError()) {
            return callResult;
        }
        CalendarType calendarType = this.GetCalendarType(cal.getCALENDARTYPEID());
        if (calendarType == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u65e5\u5386\u7c7b\u578b[%1$s]", (Object)cal.getCALENDARTYPEID()));
            return callResult;
        }
        String strCalKeyDEFName = "";
        BaseDataEntity realDataEntity = new BaseDataEntity();
        IDEDataCtrl iRealCalDataCtrl = null;
        if (!StringHelper.IsNullOrEmpty((String)calendarType.getDEID())) {
            IDEHelper tmpDEHelper = this.iGlobalHelper.getDAModelStorage().FindDEHelper(calendarType.getDEID());
            if (tmpDEHelper == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u65e5\u5386\u7c7b\u578b[%1$s]", (Object)calendarType.getDEID()));
                return callResult;
            }
            iRealCalDataCtrl = tmpDEHelper.GetDEDataCtrl("SYSTEM", null);
            if (iRealCalDataCtrl == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)calendarType.getDEID()));
                return callResult;
            }
            strCalKeyDEFName = tmpDEHelper.GetKeyDEFHelper().getName();
            realDataEntity.SetParamValue(tmpDEHelper.GetKeyDEFHelper().getName(), (Object)calSchedule.getCALENDARID());
        } else {
            iRealCalDataCtrl = this.iCalDataCtrl;
            strCalKeyDEFName = "CALENDARID";
            realDataEntity.SetParamValue("CALENDARID", (Object)calSchedule.getCALENDARID());
        }
        String strBeginTimeDEFName = calendarType.getBEGINTIMEDEFNAME();
        if (StringHelper.IsNullOrEmpty((String)strBeginTimeDEFName)) {
            strBeginTimeDEFName = "BEGINTIME";
        }
        if (StringHelper.IsNullOrEmpty((String)(strEndTimeDEFName = calendarType.getENDTIMEDEFNAME()))) {
            strEndTimeDEFName = "ENDTIME";
        }
        if ((callResult = iRealCalDataCtrl.Get(realDataEntity)).IsError()) {
            return callResult;
        }
        try {
            if (StringHelper.Compare((String)calSchedule.getSCHEDULETYPE(), (String)"3", (boolean)true) == 0) {
                int i;
                java.util.Calendar calendar = java.util.Calendar.getInstance();
                calendar.setTime(dtStartTime);
                TreeMap<Integer, Integer> monthMap = new TreeMap<Integer, Integer>();
                TreeMap<Integer, Integer> dayMap = new TreeMap<Integer, Integer>();
                String strMonthString = calSchedule.getSCHEDULEPARAM();
                String strDayString = calSchedule.getSCHEDULEPARAM2();
                if (!StringHelper.IsNullOrEmpty((String)strMonthString)) {
                    String[] months = strMonthString.split(";");
                    i = 0;
                    while (i < months.length) {
                        this.ParseInteger(monthMap, months[i]);
                        ++i;
                    }
                }
                if (!StringHelper.IsNullOrEmpty((String)strDayString)) {
                    String[] days = strDayString.split(";");
                    i = 0;
                    while (i < days.length) {
                        this.ParseInteger(dayMap, days[i]);
                        ++i;
                    }
                }
                while (calendar.getTime().getTime() <= dtEndTime.getTime() && (calSchedule.getCYCLEENDTIME() == null || calendar.getTime().getTime() <= calSchedule.getCYCLEENDTIME().getTime())) {
                    int nMonth = calendar.get(2) + 1;
                    if (monthMap.size() != 0 && !monthMap.containsKey(nMonth)) {
                        calendar.add(5, 1);
                        continue;
                    }
                    if (calendar.getTime().getTime() < calSchedule.getCYCLESTARTTIME().getTime()) {
                        calendar.add(5, 1);
                        continue;
                    }
                    int nDay = calendar.get(5);
                    if (!dayMap.containsKey(nDay)) {
                        calendar.add(5, 1);
                        continue;
                    }
                    this.AddCalendar(calSchedule, calendar, iRealCalDataCtrl, realDataEntity, cal.getCALENDARID(), strCalKeyDEFName, strBeginTimeDEFName, strEndTimeDEFName);
                    calendar.add(5, 1);
                }
                return callResult;
            }
            if (StringHelper.Compare((String)calSchedule.getSCHEDULETYPE(), (String)"4", (boolean)true) == 0) {
                java.util.Calendar calendar = java.util.Calendar.getInstance();
                calendar.setTime(dtStartTime);
                TreeMap<Integer, Integer> dayMap = new TreeMap<Integer, Integer>();
                String strDayString = calSchedule.getSCHEDULEPARAM2();
                if (!StringHelper.IsNullOrEmpty((String)strDayString)) {
                    String[] days = strDayString.split(";");
                    int i = 0;
                    while (i < days.length) {
                        this.ParseInteger(dayMap, days[i]);
                        ++i;
                    }
                }
                while (calendar.getTime().getTime() <= dtEndTime.getTime() && (calSchedule.getCYCLEENDTIME() == null || calendar.getTime().getTime() <= calSchedule.getCYCLEENDTIME().getTime())) {
                    int nDay = calendar.get(7);
                    if (!dayMap.containsKey(nDay)) {
                        calendar.add(5, 1);
                        continue;
                    }
                    if (calendar.getTime().getTime() < calSchedule.getCYCLESTARTTIME().getTime()) {
                        calendar.add(5, 1);
                        continue;
                    }
                    this.AddCalendar(calSchedule, calendar, iRealCalDataCtrl, realDataEntity, cal.getCALENDARID(), strCalKeyDEFName, strBeginTimeDEFName, strEndTimeDEFName);
                    calendar.add(5, 1);
                }
                return callResult;
            }
            if (StringHelper.Compare((String)calSchedule.getSCHEDULETYPE(), (String)"5", (boolean)true) == 0) {
                java.util.Calendar calendar = java.util.Calendar.getInstance();
                calendar.setTime(dtStartTime);
                while (calendar.getTime().getTime() <= dtEndTime.getTime() && (calSchedule.getCYCLEENDTIME() == null || calendar.getTime().getTime() <= calSchedule.getCYCLEENDTIME().getTime())) {
                    if (calendar.getTime().getTime() < calSchedule.getCYCLESTARTTIME().getTime()) {
                        calendar.add(5, 1);
                        continue;
                    }
                    this.AddCalendar(calSchedule, calendar, iRealCalDataCtrl, realDataEntity, cal.getCALENDARID(), strCalKeyDEFName, strBeginTimeDEFName, strEndTimeDEFName);
                    calendar.add(5, 1);
                }
                return callResult;
            }
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
        }
        return callResult;
    }

    protected void ParseInteger(TreeMap<Integer, Integer> values, String strInteger) {
        try {
            String[] strParts = strInteger.split("-");
            if (strParts.length == 1) {
                int nValue = Integer.parseInt(strParts[0]);
                values.put(nValue, 0);
                return;
            }
            if (strParts.length == 2) {
                int nValue1 = Integer.parseInt(strParts[0]);
                int nValue2 = Integer.parseInt(strParts[1]);
                if (nValue2 >= nValue1) {
                    int i = nValue1;
                    while (i <= nValue2) {
                        values.put(i, 0);
                        ++i;
                    }
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public CallResult RemoveCalendar() {
        String strSqlFormat = "select * from t_SRFCalendar where ( CALSEQID IS NOT NULL AND CALSEQID<>CALENDARID) and ENABLE=1 AND USERUPDATE IS NULL AND BEGINTIME >= ? ";
        Vector<CallParam> callParams = new Vector<CallParam>();
        java.util.Calendar removeCal = java.util.Calendar.getInstance();
        removeCal.add(5, 14);
        CallParam callParam = new CallParam();
        callParam.setValue((Object)new Timestamp(removeCal.getTime().getTime()));
        callParams.add(callParam);
        Vector list = new Vector();
        CallResult callResult = BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.iGlobalHelper, (String)strSqlFormat, callParams, list, (String)Calendar.class.getName());
        if (callResult.IsError()) {
            return callResult;
        }
        TreeMap<String, IDEDataCtrl> realDataCtrlMap = new TreeMap<String, IDEDataCtrl>();
        for (Calendar calendar : list) {
            IDEDataCtrl iRealCalDataCtrl = null;
            CalendarType calendarType = this.GetCalendarType(calendar.getCALENDARTYPEID());
            if (!StringHelper.IsNullOrEmpty((String)calendarType.getDEID())) {
                if (realDataCtrlMap.containsKey(calendarType.getDEID())) {
                    iRealCalDataCtrl = (IDEDataCtrl)realDataCtrlMap.get(calendarType.getDEID());
                } else {
                    iRealCalDataCtrl = this.iGlobalHelper.getDAModelStorage().FindDEDataCtrl(calendarType.getDEID(), "SYSTEM", null);
                    if (iRealCalDataCtrl == null) continue;
                    realDataCtrlMap.put(calendarType.getDEID(), iRealCalDataCtrl);
                }
            } else {
                iRealCalDataCtrl = this.iCalDataCtrl;
            }
            BaseDataEntity dataEntity = new BaseDataEntity();
            dataEntity.SetParamValue(iRealCalDataCtrl.GetDEHelper().getName(), (Object)calendar.getCALENDARID());
            callResult = iRealCalDataCtrl.Remove(dataEntity);
        }
        strSqlFormat = "delete from t_SRFCalendar where ( CALSEQID IS NOT NULL AND CALSEQID<>CALENDARID) AND USERUPDATE IS NULL AND BEGINTIME >= ? ";
        BaseDEDataCtrl.ExecuteWithoutResult((ISRFDAGlobalHelper)this.iGlobalHelper, (String)strSqlFormat, callParams);
        return callResult;
    }

    public CallResult RemoveCalendarBySchedule(String strScheduleId) {
        String strSqlFormat = "select * from t_SRFCalendar where  (CALSCHEDULEID IS NOT NULL AND CALSCHEDULEID = ?) AND ( CALSEQID IS NOT NULL AND CALSEQID<>CALENDARID) and ENABLE=1 AND USERUPDATE IS NULL AND BEGINTIME >= ? ";
        Vector<CallParam> callParams = new Vector<CallParam>();
        CallParam callParam = new CallParam();
        callParam.setValue((Object)strScheduleId);
        callParams.add(callParam);
        java.util.Calendar removeCal = java.util.Calendar.getInstance();
        CallParam callParam2 = new CallParam();
        callParam2.setValue((Object)new Timestamp(removeCal.getTime().getTime()));
        callParams.add(callParam2);
        Vector list = new Vector();
        CallResult callResult = BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.iGlobalHelper, (String)strSqlFormat, callParams, list, (String)Calendar.class.getName());
        if (callResult.IsError()) {
            return callResult;
        }
        TreeMap<String, IDEDataCtrl> realDataCtrlMap = new TreeMap<String, IDEDataCtrl>();
        for (Calendar calendar : list) {
            IDEDataCtrl iRealCalDataCtrl = null;
            CalendarType calendarType = this.GetCalendarType(calendar.getCALENDARTYPEID());
            if (!StringHelper.IsNullOrEmpty((String)calendarType.getDEID())) {
                if (realDataCtrlMap.containsKey(calendarType.getDEID())) {
                    iRealCalDataCtrl = (IDEDataCtrl)realDataCtrlMap.get(calendarType.getDEID());
                } else {
                    iRealCalDataCtrl = this.iGlobalHelper.getDAModelStorage().FindDEDataCtrl(calendarType.getDEID(), "SYSTEM", null);
                    if (iRealCalDataCtrl == null) continue;
                    realDataCtrlMap.put(calendarType.getDEID(), iRealCalDataCtrl);
                }
            } else {
                iRealCalDataCtrl = this.iCalDataCtrl;
            }
            BaseDataEntity dataEntity = new BaseDataEntity();
            dataEntity.SetParamValue(iRealCalDataCtrl.GetDEHelper().GetKeyDEFHelper().getName(), (Object)calendar.getCALENDARID());
            callResult = iRealCalDataCtrl.Remove(dataEntity);
        }
        strSqlFormat = "delete from t_SRFCalendar where (CALSCHEDULEID IS NOT NULL AND CALSCHEDULEID = ?) AND ( CALSEQID IS NOT NULL AND CALSEQID<>CALENDARID) AND USERUPDATE IS NULL AND BEGINTIME >= ? ";
        callResult = BaseDEDataCtrl.ExecuteWithoutResult((ISRFDAGlobalHelper)this.iGlobalHelper, (String)strSqlFormat, callParams);
        return callResult;
    }

    protected CalendarType GetCalendarType(String strCalendarTypeId) {
        if (this.calendarTypeMap.containsKey(strCalendarTypeId)) {
            return this.calendarTypeMap.get(strCalendarTypeId);
        }
        CalendarType calendarType = new CalendarType();
        calendarType.setCALENDARTYPEID(strCalendarTypeId);
        CallResult callResult = this.iCalTypeDataCtrl.Get((BaseDataEntity)calendarType);
        if (callResult.getRetCode() != 0) {
            return null;
        }
        this.calendarTypeMap.put(strCalendarTypeId, calendarType);
        return calendarType;
    }

    protected CallResult AddCalendar(CalSchedule calSchedule, java.util.Calendar calendar, IDEDataCtrl iRealCalDataCtrl, BaseDataEntity realDataEntity, String strCalSeqId, String strCalKeyDEFName, String strBeginTimeDEFName, String strEndTimeDEFName) {
        Calendar checkkeyparam = new Calendar();
        String strNewKey = StringHelper.Format((String)"%1$s_%2$s", (Object)calSchedule.getCALSCHEDULEID(), (Object)StringHelper.Format((String)"%1$tY%1$tm%1$td", (Object)calendar.getTime()));
        checkkeyparam.setCALENDARID(strNewKey);
        CallResult callResult = this.iCalDataCtrl.CheckKeyState((BaseDataEntity)checkkeyparam);
        if (callResult.getRetCode() != 0 || callResult.getUserObject() == null) {
            return callResult;
        }
        int nState = (Integer)callResult.getUserObject();
        if (nState == 0) {
            String strStartTimeString = String.valueOf(DateParser.toDateString((Date)calendar.getTime())) + " " + DateParser.toTimeString((Date)calSchedule.getBEGINTIME());
            String strEndTimeString = String.valueOf(DateParser.toDateString((Date)calendar.getTime())) + " " + DateParser.toTimeString((Date)calSchedule.getENDTIME());
            BaseDataEntity calClone = new BaseDataEntity();
            realDataEntity.CopyTo(calClone, true);
            calClone.SetParamValue(strCalKeyDEFName, (Object)strNewKey);
            calClone.SetParamValue("CALSEQID", (Object)strCalSeqId);
            calClone.SetParamValue(strBeginTimeDEFName, DataTypeParse.TestDateTime((String)strStartTimeString));
            calClone.SetParamValue(strEndTimeDEFName, DataTypeParse.TestDateTime((String)strEndTimeString));
            calClone.SetParamValue("CALSCHEDULEID", (Object)calSchedule.getCALSCHEDULEID());
            iRealCalDataCtrl.Save(true, calClone);
        }
        return callResult;
    }

    public CallResult UpdateCalSchedule(CalSchedule calSchedule) {
        Vector list;
        CallResult callResult;
        String strSqlFormat = "";
        strSqlFormat = calSchedule.GetParamValue("CYCLEENDTIME") == null ? "select * from t_SRFCalendar where  (CALSCHEDULEID IS NOT NULL AND CALSCHEDULEID = ?) AND ( CALSEQID IS NOT NULL AND CALSEQID<>CALENDARID) and ENABLE=1 AND USERUPDATE IS NULL AND (ENDTIME < ?  )" : "select * from t_SRFCalendar where  (CALSCHEDULEID IS NOT NULL AND CALSCHEDULEID = ?) AND ( CALSEQID IS NOT NULL AND CALSEQID<>CALENDARID) and ENABLE=1 AND USERUPDATE IS NULL AND (ENDTIME < ? OR BEGINTIME > ? )";
        Vector<CallParam> callParams = new Vector<CallParam>();
        CallParam callParam = new CallParam();
        callParam.setValue((Object)calSchedule.getCALSCHEDULEID());
        callParams.add(callParam);
        callParam = new CallParam();
        callParam.setValue((Object)new Timestamp(calSchedule.getCYCLESTARTTIME().getTime()));
        callParams.add(callParam);
        if (calSchedule.GetParamValue("CYCLEENDTIME") != null) {
            callParam = new CallParam();
            callParam.setValue((Object)new Timestamp(calSchedule.getCYCLEENDTIME().getTime() + 86400000L - 1L));
            callParams.add(callParam);
        }
        if ((callResult = BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.iGlobalHelper, (String)strSqlFormat, callParams, list = new Vector(), (String)Calendar.class.getName())).IsError()) {
            return callResult;
        }
        TreeMap<String, IDEDataCtrl> realDataCtrlMap = new TreeMap<String, IDEDataCtrl>();
        for (Calendar calendar : list) {
            IDEDataCtrl iRealCalDataCtrl = null;
            CalendarType calendarType = this.GetCalendarType(calendar.getCALENDARTYPEID());
            if (!StringHelper.IsNullOrEmpty((String)calendarType.getDEID())) {
                if (realDataCtrlMap.containsKey(calendarType.getDEID())) {
                    iRealCalDataCtrl = (IDEDataCtrl)realDataCtrlMap.get(calendarType.getDEID());
                } else {
                    iRealCalDataCtrl = this.iGlobalHelper.getDAModelStorage().FindDEDataCtrl(calendarType.getDEID(), "SYSTEM", null);
                    if (iRealCalDataCtrl == null) continue;
                    realDataCtrlMap.put(calendarType.getDEID(), iRealCalDataCtrl);
                }
            } else {
                iRealCalDataCtrl = this.iCalDataCtrl;
            }
            BaseDataEntity dataEntity = new BaseDataEntity();
            dataEntity.SetParamValue(iRealCalDataCtrl.GetDEHelper().GetKeyDEFHelper().getName(), (Object)calendar.getCALENDARID());
            callResult = iRealCalDataCtrl.Remove(dataEntity);
        }
        strSqlFormat = calSchedule.GetParamValue("CYCLEENDTIME") == null ? "delete from t_SRFCalendar where  (CALSCHEDULEID IS NOT NULL AND CALSCHEDULEID = ?) AND ( CALSEQID IS NOT NULL AND CALSEQID<>CALENDARID) AND USERUPDATE IS NULL AND (ENDTIME < ? ) " : "delete from t_SRFCalendar where  (CALSCHEDULEID IS NOT NULL AND CALSCHEDULEID = ?) AND ( CALSEQID IS NOT NULL AND CALSEQID<>CALENDARID) AND USERUPDATE IS NULL AND (ENDTIME < ? OR BEGINTIME > ? ) ";
        callResult = BaseDEDataCtrl.ExecuteWithoutResult((ISRFDAGlobalHelper)this.iGlobalHelper, (String)strSqlFormat, callParams);
        return callResult;
    }
}

