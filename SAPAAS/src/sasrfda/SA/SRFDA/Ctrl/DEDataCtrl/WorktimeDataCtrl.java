/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.DateParser
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.XML.XMLNode
 */
package SA.SRFDA.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.Data.WorkTime;
import SA.SRFDA.Ctrl.Data.WorkTimeDetail;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.DateParser;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.XMLNode;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.TreeMap;
import java.util.Vector;

public class WorktimeDataCtrl
extends BaseDEDataCtrl {
    public static final String CUSTOMCALL_CALC = "CALC";
    public static final String CALCACTION_ADDDAY = "ADDDAY";
    public static final String CALCACTION_ADDTIME = "ADDTIME";
    public static final String CALCACTION_WORKDAYS = "WORKDAYS";
    public static final String CALCACTION_FIRSTWORKDAY = "FIRSTWORKDAY";
    public static final String CALCACTION_LASTWORKDAY = "LASTWORKDAY";

    @Override
    public CallResult CustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_CALC, (boolean)true) == 0) {
            return this.Calc(dataEntity);
        }
        return super.CustomCall(strCallName, dataEntity);
    }

    protected final CallResult Calc(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        String strWorkTimeId = dataEntity.GetParamStringValue("WORKTIMEID", "");
        if (StringHelper.IsNullOrEmpty((String)strWorkTimeId)) {
            callResult.setRetCode(5);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u5de5\u4f5c\u65f6\u95f4\u7b56\u7565"));
            return callResult;
        }
        Timestamp srcTime = dataEntity.GetParamTimestampValue("SRCTIME", null);
        if (srcTime == null) {
            callResult.setRetCode(5);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u6e90\u65f6\u95f4"));
            return callResult;
        }
        String strAction = dataEntity.GetParamStringValue("ACTION", "");
        if (StringHelper.IsNullOrEmpty((String)strAction)) {
            callResult.setRetCode(5);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u65f6\u95f4\u8ba1\u7b97\u64cd\u4f5c"));
            return callResult;
        }
        int nAmount = dataEntity.GetParamIntValue("AMOUNT", 0);
        WorkTime workTime = new WorkTime();
        workTime.setWORKTIMEID(strWorkTimeId);
        callResult = this.Get(workTime);
        if (callResult.IsError()) {
            return callResult;
        }
        TreeMap<Integer, Integer> dayMap = new TreeMap<Integer, Integer>();
        String strDayString = "";
        if (workTime.getSCHEDULETYPE() == 1) {
            strDayString = workTime.getWEEKVALUE();
        } else if (workTime.getSCHEDULETYPE() == 2) {
            strDayString = workTime.getMONTHVALUE();
        }
        String[] days = strDayString.split("[,]");
        int i = 0;
        while (i < days.length) {
            dayMap.put(Integer.parseInt(days[i]), 0);
            ++i;
        }
        TreeMap<Long, WorkTimeDetail> worktimeDetailMap = new TreeMap<Long, WorkTimeDetail>();
        if (StringHelper.Compare((String)strAction, (String)CALCACTION_ADDDAY, (boolean)true) == 0) {
            Timestamp endTime = null;
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date(srcTime.getTime()));
            while (nAmount > 0) {
                int nDay;
                if (endTime == null || cal.getTime().getTime() >= endTime.getTime()) {
                    Calendar cal2 = Calendar.getInstance();
                    cal2.setTime(new Date(cal.getTime().getTime()));
                    cal2.add(5, 30);
                    endTime = new Timestamp(cal2.getTime().getTime());
                    worktimeDetailMap.clear();
                    callResult = this.BuildWorkTimeDetailMap(worktimeDetailMap, strWorkTimeId, new Timestamp(cal.getTime().getTime()), endTime);
                    if (callResult.IsError()) {
                        return callResult;
                    }
                }
                cal.add(5, 1);
                long nCurTime = 0L;
                try {
                    nCurTime = DateParser.Parse((String)(String.valueOf(DateParser.toDateString((Date)cal.getTime())) + " 00:00:00")).getTime();
                }
                catch (ParseException e) {
                    e.printStackTrace();
                    callResult.setRetCode(1);
                    return callResult;
                }
                catch (Exception e) {
                    e.printStackTrace();
                    callResult.setRetCode(1);
                    return callResult;
                }
                if (worktimeDetailMap.containsKey(nCurTime)) {
                    WorkTimeDetail workTimeDetail = worktimeDetailMap.get(nCurTime);
                    if (workTimeDetail.getWORKTIMETYPE() == 2) continue;
                    --nAmount;
                    continue;
                }
                if (workTime.getSCHEDULETYPE() == 1) {
                    int nDay2 = cal.get(7);
                    if (!dayMap.containsKey(nDay2)) continue;
                    --nAmount;
                    continue;
                }
                if (workTime.getSCHEDULETYPE() != 2 || !dayMap.containsKey(nDay = cal.get(5))) continue;
                --nAmount;
            }
            String strDstTimeString = String.valueOf(DateParser.toDateString((Date)cal.getTime())) + " 23:59:59";
            try {
                dataEntity.SetParamValue("DSTTIME", (Object)new Timestamp(DateParser.Parse((String)strDstTimeString).getTime()));
            }
            catch (ParseException e) {
                e.printStackTrace();
                callResult.setRetCode(1);
            }
            catch (Exception e) {
                e.printStackTrace();
                callResult.setRetCode(1);
            }
            return callResult;
        }
        if (StringHelper.Compare((String)strAction, (String)CALCACTION_ADDTIME, (boolean)true) == 0) {
            callResult = this.GetWorkTimeDayTime(workTime);
            if (callResult.IsError()) {
                return callResult;
            }
            int nDayMinutes = (Integer)callResult.getUserObject();
            if (nDayMinutes == 0) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u5de5\u4f5c\u65e5\u5de5\u4f5c\u65f6\u957f\u6709\u8bef\uff0c\u4e0d\u80fd\u4e3a0");
                return callResult;
            }
            boolean bFirstDay = true;
            Timestamp endTime = null;
            Calendar cal = Calendar.getInstance();
            Calendar dayCal = Calendar.getInstance();
            dayCal.clear();
            dayCal.set(11, cal.get(11));
            dayCal.set(12, cal.get(12));
            dayCal.set(13, cal.get(13));
            while (nAmount > 0) {
                int nDay;
                if (endTime == null || cal.getTime().getTime() >= endTime.getTime()) {
                    Calendar cal2 = Calendar.getInstance();
                    cal2.setTime(new Date(cal.getTime().getTime()));
                    cal2.add(5, 30);
                    endTime = new Timestamp(cal2.getTime().getTime());
                    worktimeDetailMap.clear();
                    callResult = this.BuildWorkTimeDetailMap(worktimeDetailMap, strWorkTimeId, new Timestamp(cal.getTime().getTime()), endTime);
                    if (callResult.IsError()) {
                        return callResult;
                    }
                }
                long nCurTime = 0L;
                try {
                    if (!bFirstDay) {
                        cal.add(5, 1);
                    }
                    nCurTime = DateParser.Parse((String)(String.valueOf(DateParser.toDateString((Date)cal.getTime())) + " 00:00:00")).getTime();
                }
                catch (ParseException e) {
                    e.printStackTrace();
                    callResult.setRetCode(1);
                    return callResult;
                }
                catch (Exception e) {
                    e.printStackTrace();
                    callResult.setRetCode(1);
                    return callResult;
                }
                if (worktimeDetailMap.containsKey(nCurTime)) {
                    WorkTimeDetail workTimeDetail = worktimeDetailMap.get(nCurTime);
                    if (workTimeDetail.getWORKTIMETYPE() == 2) {
                        bFirstDay = false;
                        continue;
                    }
                    callResult = this.CalcWorkTimeDayEndTime(dayCal, bFirstDay, workTime, workTimeDetail, nAmount);
                    if (callResult.IsError()) {
                        return callResult;
                    }
                    Long nTemp = (Long)callResult.getUserObject();
                    if (nTemp >= (long)nAmount) break;
                    nAmount = (int)((long)nAmount - nTemp);
                    bFirstDay = false;
                    continue;
                }
                if (workTime.getSCHEDULETYPE() == 1) {
                    int nDay3 = cal.get(7);
                    if (!dayMap.containsKey(nDay3)) {
                        bFirstDay = false;
                        continue;
                    }
                } else if (workTime.getSCHEDULETYPE() == 2 && !dayMap.containsKey(nDay = cal.get(5))) {
                    bFirstDay = false;
                    continue;
                }
                if (!bFirstDay && nAmount > nDayMinutes) {
                    nAmount -= nDayMinutes;
                    bFirstDay = false;
                    continue;
                }
                callResult = this.CalcWorkTimeDayEndTime(dayCal, bFirstDay, workTime, null, nAmount);
                if (callResult.IsError()) {
                    return callResult;
                }
                Long nTemp = (Long)callResult.getUserObject();
                if (nTemp >= (long)nAmount) break;
                nAmount = (int)((long)nAmount - nTemp);
                bFirstDay = false;
            }
            String strDstTimeString = String.valueOf(DateParser.toDateString((Date)cal.getTime())) + " " + DateParser.toTimeString((Date)dayCal.getTime());
            try {
                dataEntity.SetParamValue("DSTTIME", (Object)new Timestamp(DateParser.Parse((String)strDstTimeString).getTime()));
            }
            catch (ParseException e) {
                e.printStackTrace();
                callResult.setRetCode(1);
            }
            catch (Exception e) {
                e.printStackTrace();
                callResult.setRetCode(1);
            }
            return callResult;
        }
        if (StringHelper.Compare((String)strAction, (String)CALCACTION_WORKDAYS, (boolean)true) == 0) {
            int intAddDays = dataEntity.GetParamIntValue("ADDDAYS", 0);
            int intIFJS = dataEntity.GetParamIntValue("SFJS", 0);
            Timestamp finTime = dataEntity.GetParamTimestampValue("FINTIME", null);
            if (finTime == null) {
                if (dataEntity.GetParamIntValue("FINTIMENULLIGNOR", 0) == 0) {
                    callResult.setRetCode(5);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u7ed3\u675f\u65f6\u95f4"));
                } else {
                    callResult.setRetCode(0);
                }
                return callResult;
            }
            if (finTime.getTime() < srcTime.getTime()) {
                callResult.setRetCode(5);
                callResult.setErrorInfo(StringHelper.Format((String)"\u7ed3\u675f\u65f6\u95f4\u5fc5\u987b\u5927\u4e8e\u5f00\u59cb\u65f6\u95f4"));
                return callResult;
            }
            int nCount = 0;
            boolean isFirstNotWork = false;
            if (intIFJS == 1) {
                Timestamp endTime = null;
                Calendar cal = Calendar.getInstance();
                cal.setTime(new Date(srcTime.getTime()));
                Calendar cal2 = Calendar.getInstance();
                cal2.setTime(new Date(srcTime.getTime()));
                cal2.add(5, 30);
                endTime = new Timestamp(cal2.getTime().getTime());
                worktimeDetailMap.clear();
                callResult = this.BuildWorkTimeDetailMap1(worktimeDetailMap, strWorkTimeId, new Timestamp(srcTime.getTime()), endTime);
                if (callResult.IsError()) {
                    return callResult;
                }
                if (worktimeDetailMap.containsKey(srcTime.getTime())) {
                    WorkTimeDetail workTimeDetail = worktimeDetailMap.get(srcTime.getTime());
                    if (workTimeDetail.getWORKTIMETYPE() == 2) {
                        isFirstNotWork = true;
                    }
                } else {
                    int nDay;
                    if (workTime.getSCHEDULETYPE() == 1 && !dayMap.containsKey(nDay = cal.get(7))) {
                        isFirstNotWork = true;
                    }
                    if (workTime.getSCHEDULETYPE() == 2 && !dayMap.containsKey(nDay = cal.get(5))) {
                        isFirstNotWork = true;
                    }
                }
                while (cal.getTime().before(finTime)) {
                    int nDay;
                    if (endTime == null || cal.getTime().getTime() >= endTime.getTime()) {
                        endTime = null;
                        cal2 = Calendar.getInstance();
                        cal2.setTime(new Date(cal.getTime().getTime()));
                        cal2.add(5, 30);
                        endTime = new Timestamp(cal2.getTime().getTime());
                        worktimeDetailMap.clear();
                        callResult = this.BuildWorkTimeDetailMap1(worktimeDetailMap, strWorkTimeId, new Timestamp(cal.getTime().getTime()), endTime);
                        if (callResult.IsError()) {
                            return callResult;
                        }
                    }
                    cal.add(5, 1);
                    long nCurTime = 0L;
                    try {
                        nCurTime = DateParser.Parse((String)(String.valueOf(DateParser.toDateString((Date)cal.getTime())) + " 00:00:00")).getTime();
                    }
                    catch (ParseException e) {
                        e.printStackTrace();
                        callResult.setRetCode(1);
                        return callResult;
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                        callResult.setRetCode(1);
                        return callResult;
                    }
                    if (worktimeDetailMap.containsKey(nCurTime)) {
                        WorkTimeDetail workTimeDetail = worktimeDetailMap.get(nCurTime);
                        if (workTimeDetail.getWORKTIMETYPE() == 2) continue;
                        ++nCount;
                        continue;
                    }
                    if (workTime.getSCHEDULETYPE() == 1) {
                        int nDay4 = cal.get(7);
                        if (!dayMap.containsKey(nDay4)) continue;
                        ++nCount;
                        continue;
                    }
                    if (workTime.getSCHEDULETYPE() != 2 || !dayMap.containsKey(nDay = cal.get(5))) continue;
                    ++nCount;
                }
                if (srcTime.getTime() == finTime.getTime()) {
                    cal2 = Calendar.getInstance();
                    cal2.setTime(new Date(srcTime.getTime()));
                    cal2.add(5, 30);
                    endTime = new Timestamp(cal2.getTime().getTime());
                    worktimeDetailMap.clear();
                    callResult = this.BuildWorkTimeDetailMap1(worktimeDetailMap, strWorkTimeId, new Timestamp(srcTime.getTime()), endTime);
                    if (callResult.IsError()) {
                        return callResult;
                    }
                    if (worktimeDetailMap.containsKey(srcTime.getTime())) {
                        WorkTimeDetail workTimeDetail = worktimeDetailMap.get(srcTime.getTime());
                        if (workTimeDetail.getWORKTIMETYPE() == 2) {
                            isFirstNotWork = true;
                        }
                    } else {
                        int nDay;
                        if (workTime.getSCHEDULETYPE() == 1 && !dayMap.containsKey(nDay = cal.get(7))) {
                            isFirstNotWork = true;
                        }
                        if (workTime.getSCHEDULETYPE() == 2 && !dayMap.containsKey(nDay = cal.get(5))) {
                            isFirstNotWork = true;
                        }
                    }
                }
            } else {
                nCount = (int)(finTime.getTime() - srcTime.getTime()) / 86400000;
            }
            if (intAddDays == 1) {
                ++nCount;
            }
            if (isFirstNotWork) {
                --nCount;
            }
            try {
                dataEntity.SetParamValue("AMOUNT", (Object)nCount);
            }
            catch (Exception e) {
                e.printStackTrace();
                callResult.setRetCode(1);
            }
            return callResult;
        }
        if (StringHelper.Compare((String)strAction, (String)CALCACTION_FIRSTWORKDAY, (boolean)true) == 0) {
            if (StringHelper.IsNullOrEmpty((String)strAction)) {
                callResult.setRetCode(5);
                callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u5de5\u4f5c\u65e5\u7c7b\u578b\uff01"));
                return callResult;
            }
            Timestamp endTime = null;
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date(srcTime.getTime()));
            cal.add(5, -1);
            while (nAmount > 0) {
                if (endTime == null || cal.getTime().getTime() >= endTime.getTime()) {
                    Calendar cal2 = Calendar.getInstance();
                    cal2.setTime(new Date(cal.getTime().getTime()));
                    cal2.add(5, 30);
                    endTime = new Timestamp(cal2.getTime().getTime());
                    worktimeDetailMap.clear();
                    callResult = this.BuildWorkTimeDetailMap1(worktimeDetailMap, strWorkTimeId, new Timestamp(cal.getTime().getTime()), endTime);
                    if (callResult.IsError()) {
                        return callResult;
                    }
                }
                cal.add(5, 1);
                long nCurTime = 0L;
                try {
                    nCurTime = DateParser.Parse((String)(String.valueOf(DateParser.toDateString((Date)cal.getTime())) + " 00:00:00")).getTime();
                }
                catch (ParseException e) {
                    e.printStackTrace();
                    callResult.setRetCode(1);
                    return callResult;
                }
                catch (Exception e) {
                    e.printStackTrace();
                    callResult.setRetCode(1);
                    return callResult;
                }
                if (worktimeDetailMap.containsKey(nCurTime)) {
                    WorkTimeDetail workTimeDetail = worktimeDetailMap.get(nCurTime);
                    if (workTimeDetail.getWORKTIMETYPE() != 2) break;
                    --nAmount;
                    continue;
                }
                if (workTime.getSCHEDULETYPE() == 1) {
                    int nDay = cal.get(7);
                    if (dayMap.containsKey(nDay)) break;
                    --nAmount;
                    continue;
                }
                if (workTime.getSCHEDULETYPE() != 2) continue;
                int nDay = cal.get(5);
                if (dayMap.containsKey(nDay)) break;
                --nAmount;
            }
            String strDstTimeString = String.valueOf(DateParser.toDateString((Date)cal.getTime())) + " 00:00:00";
            try {
                dataEntity.SetParamValue("DSTTIME", (Object)new Timestamp(DateParser.Parse((String)strDstTimeString).getTime()));
            }
            catch (ParseException e) {
                e.printStackTrace();
                callResult.setRetCode(1);
            }
            catch (Exception e) {
                e.printStackTrace();
                callResult.setRetCode(1);
            }
            return callResult;
        }
        if (StringHelper.Compare((String)strAction, (String)CALCACTION_LASTWORKDAY, (boolean)true) == 0) {
            if (StringHelper.IsNullOrEmpty((String)strAction)) {
                callResult.setRetCode(5);
                callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u5de5\u4f5c\u65e5\u7c7b\u578b\uff01"));
                return callResult;
            }
            Timestamp endTime = null;
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date(srcTime.getTime()));
            cal.add(5, 1);
            while (nAmount > 0) {
                if (endTime == null || cal.getTime().getTime() >= endTime.getTime()) {
                    Calendar cal2 = Calendar.getInstance();
                    cal2.setTime(new Date(cal.getTime().getTime()));
                    cal2.add(5, 30);
                    endTime = new Timestamp(cal2.getTime().getTime());
                    worktimeDetailMap.clear();
                    cal.add(5, -1);
                    callResult = this.BuildWorkTimeDetailMap1(worktimeDetailMap, strWorkTimeId, new Timestamp(cal.getTime().getTime()), endTime);
                    if (callResult.IsError()) {
                        return callResult;
                    }
                    cal.add(5, 1);
                }
                cal.add(5, -1);
                long nCurTime = 0L;
                try {
                    nCurTime = DateParser.Parse((String)(String.valueOf(DateParser.toDateString((Date)cal.getTime())) + " 00:00:00")).getTime();
                }
                catch (ParseException e) {
                    e.printStackTrace();
                    callResult.setRetCode(1);
                    return callResult;
                }
                catch (Exception e) {
                    e.printStackTrace();
                    callResult.setRetCode(1);
                    return callResult;
                }
                if (worktimeDetailMap.containsKey(nCurTime)) {
                    WorkTimeDetail workTimeDetail = worktimeDetailMap.get(nCurTime);
                    if (workTimeDetail.getWORKTIMETYPE() != 2) break;
                    --nAmount;
                    continue;
                }
                if (workTime.getSCHEDULETYPE() == 1) {
                    int nDay = cal.get(7);
                    if (dayMap.containsKey(nDay)) break;
                    --nAmount;
                    continue;
                }
                if (workTime.getSCHEDULETYPE() != 2) continue;
                int nDay = cal.get(5);
                if (dayMap.containsKey(nDay)) break;
                --nAmount;
            }
            String strDstTimeString = String.valueOf(DateParser.toDateString((Date)cal.getTime())) + " 00:00:00";
            try {
                dataEntity.SetParamValue("DSTTIME", (Object)new Timestamp(DateParser.Parse((String)strDstTimeString).getTime()));
            }
            catch (ParseException e) {
                e.printStackTrace();
                callResult.setRetCode(1);
            }
            catch (Exception e) {
                e.printStackTrace();
                callResult.setRetCode(1);
            }
            return callResult;
        }
        return callResult;
    }

    private CallResult BuildWorkTimeDetailMap(TreeMap<Long, WorkTimeDetail> worktimeDetailMap, String strWorkTimeId, Timestamp startTime, Timestamp endTime) {
        String strSQL = "select * from T_SRFWORKTIMEDETAIL where UPPER(WorkTimeId)=? AND WORKTIME>=? AND WORKTIME<?";
        Vector<WorkTimeDetail> list = new Vector();
        CallParamList callParamList = new CallParamList();
        callParamList.Add((Object)strWorkTimeId.toUpperCase());
        callParamList.AddDateTime((Object)startTime);
        callParamList.AddDateTime((Object)endTime);
        CallResult callResult = BaseDEDataCtrl.SelectMultiEx(this.globalHelperEx, this.GetDEHelper().GetDBStorage(), strSQL, callParamList.GetList(), list, WorkTimeDetail.class.getName());
        if (callResult.IsError()) {
            return callResult;
        }
        for (WorkTimeDetail workTimeDetail : list) {
            if (!workTimeDetail.isENDTIMENull()) {
                long time;
                int nIndex = 0;
                long nStartTime = workTimeDetail.getWORKTIME().getTime();
                long nEndTime = workTimeDetail.getENDTIME().getTime();
                while ((time = nStartTime + (long)(nIndex * 86400000)) <= nEndTime) {
                    worktimeDetailMap.put(time, workTimeDetail);
                    ++nIndex;
                }
                continue;
            }
            worktimeDetailMap.put(workTimeDetail.getWORKTIME().getTime(), workTimeDetail);
        }
        return callResult;
    }

    private CallResult BuildWorkTimeDetailMap1(TreeMap<Long, WorkTimeDetail> worktimeDetailMap, String strWorkTimeId, Timestamp startTime, Timestamp endTime) {
        String strSQL = "select * from T_SRFWORKTIMEDETAIL where UPPER(WorkTimeId)=? AND ((WORKTIME>=? AND WORKTIME<?) OR (ENDTIME>=? AND ENDTIME<?) )";
        Vector<WorkTimeDetail> list = new Vector();
        CallParamList callParamList = new CallParamList();
        callParamList.Add((Object)strWorkTimeId.toUpperCase());
        callParamList.AddDateTime((Object)startTime);
        callParamList.AddDateTime((Object)endTime);
        callParamList.AddDateTime((Object)startTime);
        callParamList.AddDateTime((Object)endTime);
        CallResult callResult = BaseDEDataCtrl.SelectMultiEx(this.globalHelperEx, this.GetDEHelper().GetDBStorage(), strSQL, callParamList.GetList(), list, WorkTimeDetail.class.getName());
        if (callResult.IsError()) {
            return callResult;
        }
        for (WorkTimeDetail workTimeDetail : list) {
            if (!workTimeDetail.isENDTIMENull()) {
                long time;
                int nIndex = 0;
                long nStartTime = workTimeDetail.getWORKTIME().getTime();
                long nEndTime = workTimeDetail.getENDTIME().getTime();
                while ((time = nStartTime + (long)(nIndex * 86400000)) <= nEndTime) {
                    worktimeDetailMap.put(time, workTimeDetail);
                    ++nIndex;
                }
                continue;
            }
            worktimeDetailMap.put(workTimeDetail.getWORKTIME().getTime(), workTimeDetail);
        }
        return callResult;
    }

    private CallResult CalcWorkTimeDayEndTime(Calendar dayCal, boolean bFirstDay, WorkTime workTime, WorkTimeDetail workTimeDetail, long nAmount) {
        CallResult callResult = new CallResult();
        TreeMap<Long, Long> workTimeMap = null;
        if (workTimeDetail != null && workTimeDetail.getWORKTIMETYPE() == 3) {
            workTimeMap = new TreeMap();
            if (workTimeDetail.getTIME1START() != null && workTimeDetail.getTIME1END() != null) {
                workTimeMap.put(workTimeDetail.getTIME1START().getTime(), workTimeDetail.getTIME1END().getTime());
            }
            if (workTimeDetail.getTIME2START() != null && workTimeDetail.getTIME2END() != null) {
                workTimeMap.put(workTimeDetail.getTIME2START().getTime(), workTimeDetail.getTIME2END().getTime());
            }
            if (workTimeDetail.getTIME3START() != null && workTimeDetail.getTIME3END() != null) {
                workTimeMap.put(workTimeDetail.getTIME3START().getTime(), workTimeDetail.getTIME3END().getTime());
            }
            if (workTimeDetail.getTIME4START() != null && workTimeDetail.getTIME4END() != null) {
                workTimeMap.put(workTimeDetail.getTIME4START().getTime(), workTimeDetail.getTIME4END().getTime());
            }
        } else {
            workTimeMap = workTime.getWorkTimeMap();
        }
        long nLastAmount = nAmount;
        for (long nStartTime : workTimeMap.keySet()) {
            long nTemp;
            long nEndTime = workTimeMap.get(nStartTime);
            if (bFirstDay) {
                if (nEndTime <= dayCal.getTimeInMillis()) continue;
                if (nStartTime <= dayCal.getTimeInMillis()) {
                    nTemp = nEndTime - nStartTime - (dayCal.getTimeInMillis() - nStartTime);
                    if (nTemp >= nLastAmount) {
                        dayCal.setTime(new Date(nEndTime -= nTemp - nLastAmount));
                        callResult.setRetCode(0);
                        callResult.setUserObject((Object)nAmount);
                        return callResult;
                    }
                    nLastAmount -= nTemp;
                    continue;
                }
                nTemp = nEndTime - nStartTime;
                if (nTemp >= nLastAmount) {
                    dayCal.setTime(new Date(nEndTime -= nTemp - nLastAmount));
                    callResult.setRetCode(0);
                    callResult.setUserObject((Object)nAmount);
                    return callResult;
                }
                nLastAmount -= nTemp;
                continue;
            }
            nTemp = nEndTime - nStartTime;
            if (nTemp >= nLastAmount) {
                dayCal.setTime(new Date(nEndTime -= nTemp - nLastAmount));
                callResult.setRetCode(0);
                callResult.setUserObject((Object)nAmount);
                return callResult;
            }
            nLastAmount -= nTemp;
        }
        callResult.setUserObject((Object)(nAmount - nLastAmount));
        return callResult;
    }

    private CallResult GetWorkTimeDayTime(WorkTime workTime) {
        int nAmount = 0;
        TreeMap<Long, Long> workTimeMap = workTime.getWorkTimeMap();
        for (long nStartTime : workTimeMap.keySet()) {
            long nEndTime = workTimeMap.get(nStartTime);
            nAmount = (int)((long)nAmount + (nEndTime - nStartTime));
        }
        CallResult callResult = new CallResult();
        callResult.setUserObject((Object)nAmount);
        return callResult;
    }

    @Override
    protected CallResult OnExport(BaseDataEntity baseDataEntity, Vector<XMLNode> list, boolean bFrameOnly) {
        CallResult callResult = super.OnExport(baseDataEntity, list, bFrameOnly);
        if (callResult.IsError()) {
            return callResult;
        }
        BaseDataEntity cond = new BaseDataEntity();
        cond.SetParamValue("WORKTIMEID", baseDataEntity.GetParamValue("WORKTIMEID"));
        IDEDataCtrl workTimeDetailDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrlEx("DE0057", this);
        if (workTimeDetailDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0057"));
            return callResult;
        }
        Vector<BaseDataEntity> workTimeDetailList = new Vector<BaseDataEntity>();
        callResult = workTimeDetailDataCtrl.Select(cond, workTimeDetailList);
        if (callResult.IsError()) {
            return callResult;
        }
        for (BaseDataEntity workTimeDetail : workTimeDetailList) {
            callResult = workTimeDetailDataCtrl.Export(workTimeDetail, list, true, bFrameOnly);
            if (!callResult.IsError()) continue;
            return callResult;
        }
        return callResult;
    }
}

