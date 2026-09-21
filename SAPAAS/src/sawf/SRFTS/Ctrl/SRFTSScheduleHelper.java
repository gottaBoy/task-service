/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDBCallerHelperEx
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.DateParser
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  SA.SRFramework.WebEx.Utility.ContextHelper
 *  SA.SRFramework.WebEx.Utility.ISRFExGlobalHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SRFTS.Ctrl;

import SA.SRFramework.DataEx.BaseDBCallerHelperEx;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.DateParser;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.WebEx.Utility.ContextHelper;
import SA.SRFramework.WebEx.Utility.ISRFExGlobalHelper;
import SRFTS.Ctrl.Data.TSSchedule;
import SRFTS.Ctrl.Data.TSTaskItem;
import SRFTS.Ctrl.ITSDataCtrl;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TreeMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFTSScheduleHelper {
    protected BaseDBCallerHelperEx dbCallerHelper = null;
    protected ITSDataCtrl tsDataCtrl = null;
    protected ContextHelper contextHelper = null;
    private static Log log = LogFactory.getLog(SRFTSScheduleHelper.class);
    protected ISRFExGlobalHelper iGlobalHelper = null;

    public SRFTSScheduleHelper() {
    }

    public SRFTSScheduleHelper(ISRFExGlobalHelper iGlobalHelper, BaseDBCallerHelperEx dbCallerHelper) {
        this.Init(iGlobalHelper, dbCallerHelper);
    }

    public CallResult Init(ISRFExGlobalHelper iGlobalHelper, BaseDBCallerHelperEx dbCallerHelper) {
        this.dbCallerHelper = dbCallerHelper;
        this.iGlobalHelper = iGlobalHelper;
        if (iGlobalHelper instanceof ContextHelper) {
            this.contextHelper = (ContextHelper)iGlobalHelper;
        }
        this.tsDataCtrl = this.CreateTSDataCtrl();
        this.tsDataCtrl.Init(iGlobalHelper, this.dbCallerHelper);
        return this.OnInit();
    }

    protected CallResult OnInit() {
        return new CallResult();
    }

    protected ITSDataCtrl CreateTSDataCtrl() {
        String strDataCtrlObject = this.iGlobalHelper.getWebExConfig().GetValue("SRFTS", "TSDATACTRL", "");
        if (StringHelper.IsNullOrEmpty((String)strDataCtrlObject)) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u4efb\u52a1\u5f15\u64ce\u6570\u636e\u5bf9\u8c61"));
            return null;
        }
        Object objDataCtrl = ObjectHelper.Create((String)strDataCtrlObject);
        if (objDataCtrl == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u4efb\u52a1\u5f15\u64ce\u6570\u636e\u5bf9\u8c61[%1$s]", (Object)objDataCtrl));
            return null;
        }
        if (objDataCtrl instanceof ITSDataCtrl) {
            return (ITSDataCtrl)objDataCtrl;
        }
        log.error((Object)StringHelper.Format((String)"\u5bf9\u8c61[%1$s]\u6ca1\u6709\u5b9e\u73b0\u63a5\u53e3[ITSDataCtrl]", (Object)objDataCtrl));
        return null;
    }

    public CallResult CreateTaskItem(String strTaskId, Date dtStartTime, Date dtEndTime) {
        ArrayList<TSSchedule> list = new ArrayList<TSSchedule>();
        CallResult callResult = this.tsDataCtrl.GetSchedule(strTaskId, dtStartTime, dtEndTime, list);
        for (TSSchedule schedule : list) {
            this.ParseSchedule(schedule, dtStartTime, dtEndTime);
        }
        return callResult;
    }

    public CallResult CreateTaskItem(String strTaskId, Date dtStartTime, Date dtEndTime, Date dtRealStartTime, Date dtRealEndTime) {
        ArrayList<TSSchedule> list = new ArrayList<TSSchedule>();
        CallResult callResult = this.tsDataCtrl.GetSchedule(strTaskId, dtStartTime, dtEndTime, list);
        for (TSSchedule schedule : list) {
            this.ParseSchedule(schedule, dtRealStartTime, dtRealEndTime);
        }
        return callResult;
    }

    protected CallResult ParseSchedule(TSSchedule schedule, Date dtStartTime, Date dtEndTime) {
        CallResult callResult = new CallResult();
        try {
            if (schedule.getSCHEDULETYPE() == 1) {
                String strRunTimeString = String.valueOf(DateParser.toDateString((Date)schedule.getRUNDATE())) + " " + DateParser.toTimeString((Date)schedule.getRUNTIME());
                Date planTime = DateParser.Parser((String)strRunTimeString);
                if (planTime.getTime() < dtStartTime.getTime() || dtStartTime.getTime() > dtEndTime.getTime()) {
                    return callResult;
                }
                this.AddDayTaskItem(schedule, planTime, dtEndTime);
                return callResult;
            }
            if (schedule.getSCHEDULETYPE() == 3) {
                int i;
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(dtStartTime);
                TreeMap<Integer, Integer> monthMap = new TreeMap<Integer, Integer>();
                TreeMap<Integer, Integer> dayMap = new TreeMap<Integer, Integer>();
                String strMonthString = schedule.getSCHEDULEPARAM();
                String strDayString = schedule.getSCHEDULEPARAM2();
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
                while (calendar.getTime().getTime() <= dtEndTime.getTime() && (schedule.getCYCLEENDTIME() == null || calendar.getTime().getTime() <= schedule.getCYCLEENDTIME().getTime())) {
                    int nMonth = calendar.get(2) + 1;
                    if (monthMap.size() != 0 && !monthMap.containsKey(nMonth)) {
                        calendar.add(5, 1);
                        continue;
                    }
                    if (calendar.getTime().getTime() <= schedule.getCYCLESTARTTIME().getTime()) {
                        calendar.add(5, 1);
                        continue;
                    }
                    int nDay = calendar.get(5);
                    if (!dayMap.containsKey(nDay)) {
                        calendar.add(5, 1);
                        continue;
                    }
                    String strStartRunTimeString = String.valueOf(DateParser.toDateString((Date)calendar.getTime())) + " " + DateParser.toTimeString((Date)schedule.getRUNTIME());
                    Date dtStartPlanTime = DateParser.Parser((String)strStartRunTimeString);
                    this.AddDayTaskItem(schedule, dtStartPlanTime, dtEndTime);
                    calendar.add(5, 1);
                }
                return callResult;
            }
            if (schedule.getSCHEDULETYPE() == 4) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(dtStartTime);
                TreeMap<Integer, Integer> dayMap = new TreeMap<Integer, Integer>();
                String strDayString = schedule.getSCHEDULEPARAM2();
                if (!StringHelper.IsNullOrEmpty((String)strDayString)) {
                    String[] days = strDayString.split(";");
                    int i = 0;
                    while (i < days.length) {
                        this.ParseInteger(dayMap, days[i]);
                        ++i;
                    }
                }
                while (calendar.getTime().getTime() <= dtEndTime.getTime() && (schedule.getCYCLEENDTIME() == null || calendar.getTime().getTime() <= schedule.getCYCLEENDTIME().getTime())) {
                    int nDay = calendar.get(7);
                    if (!dayMap.containsKey(nDay)) {
                        calendar.add(5, 1);
                        continue;
                    }
                    if (calendar.getTime().getTime() <= schedule.getCYCLESTARTTIME().getTime()) {
                        calendar.add(5, 1);
                        continue;
                    }
                    String strStartRunTimeString = String.valueOf(DateParser.toDateString((Date)calendar.getTime())) + " " + DateParser.toTimeString((Date)schedule.getRUNTIME());
                    Date dtStartPlanTime = DateParser.Parser((String)strStartRunTimeString);
                    this.AddDayTaskItem(schedule, dtStartPlanTime, dtEndTime);
                    calendar.add(5, 1);
                }
                return callResult;
            }
            if (schedule.getSCHEDULETYPE() == 5) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(dtStartTime);
                while (calendar.getTime().getTime() <= dtEndTime.getTime() && (schedule.getCYCLEENDTIME() == null || calendar.getTime().getTime() <= schedule.getCYCLEENDTIME().getTime())) {
                    if (calendar.getTime().getTime() <= schedule.getCYCLESTARTTIME().getTime()) {
                        calendar.add(5, 1);
                        continue;
                    }
                    String strStartRunTimeString = String.valueOf(DateParser.toDateString((Date)calendar.getTime())) + " " + DateParser.toTimeString((Date)schedule.getRUNTIME());
                    Date dtStartPlanTime = DateParser.Parser((String)strStartRunTimeString);
                    this.AddDayTaskItem(schedule, dtStartPlanTime, dtEndTime);
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

    protected void AddDayTaskItem(TSSchedule schedule, Date dtStartPlanTime, Date dtEndTime) {
        int nIntervalMinute;
        Calendar dayCalendar = Calendar.getInstance();
        dayCalendar.setTime(dtStartPlanTime);
        int nLastMinute = schedule.getLASTMINUTE();
        if (nLastMinute < 0) {
            nLastMinute = 0;
        }
        if ((nIntervalMinute = schedule.getINTERVALMINUTE()) < 0) {
            nIntervalMinute = 0;
        }
        this.AddTaskItem(schedule, dayCalendar.getTime());
        int nLoopCount = 0;
        if (nIntervalMinute != 0 && nLastMinute != 0) {
            nLoopCount = nLastMinute / nIntervalMinute;
        }
        int i = 0;
        while (i < nLoopCount) {
            dayCalendar.add(12, nIntervalMinute);
            if (dayCalendar.getTime().getTime() > dtEndTime.getTime()) break;
            this.AddTaskItem(schedule, dayCalendar.getTime());
            ++i;
        }
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

    protected CallResult AddTaskItem(TSSchedule schedule, Date planTime) {
        String strTaskItemInfo = StringHelper.Format((String)"[%1$s][%2$s]AT[%3$s]", (Object)schedule.getTASKNAME(), (Object)schedule.getSCHEDULEINFO(), (Object)DateParser.toDateTimeString((Date)planTime));
        TSTaskItem tsTaskItem = new TSTaskItem();
        tsTaskItem.setTSTASKITEMID(Helper.GenGuidEx());
        tsTaskItem.setTSTASKID(schedule.getTSTASKID());
        tsTaskItem.setTSSCHEDULEID(schedule.getTSSCHEDULEID());
        tsTaskItem.setPLANTIME(new Timestamp(planTime.getTime()));
        tsTaskItem.setREALTIME(new Timestamp(planTime.getTime()));
        tsTaskItem.setTASKITEMINFO(strTaskItemInfo);
        return this.tsDataCtrl.AddTaskItem(tsTaskItem, "SYSTEM");
    }
}

