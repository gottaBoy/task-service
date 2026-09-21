/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.TM.Ctrl.BaseTMObject;
import SA.TM.Ctrl.Data.TMTimeItem;
import SA.TM.Ctrl.ITMTimeItemHelper;
import SA.TM.Ctrl.ITMTimeRuleHelper;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Hashtable;

public class TMTimeItemHelper
extends BaseTMObject
implements ITMTimeItemHelper {
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;
    protected ITMTimeRuleHelper iTMTimeRule = null;
    protected TMTimeItem tmTimeItem = null;
    protected Hashtable<Integer, Integer> monthMap = null;
    protected Hashtable<Integer, Integer> monthDayMap = null;
    protected boolean bCheckMonthDay = true;
    protected boolean bCheckMonthWeek = true;
    protected int nMonthWeek = 0;
    protected Hashtable<Integer, Integer> weekDayMap = null;
    protected Calendar dayBeginTime = null;
    protected Calendar dayBeginTime2 = null;
    protected Calendar dayEndTime = null;
    protected Calendar dayEndTime2 = null;
    protected int nDayMode = 0;

    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, ITMTimeRuleHelper iTMTimeRule, TMTimeItem tmTimeItem) throws Exception {
        int i;
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.iTMTimeRule = iTMTimeRule;
        this.tmTimeItem = tmTimeItem;
        if (StringHelper.Compare((String)tmTimeItem.getMONTHTYPE(), (String)"SOME", (boolean)true) == 0) {
            this.monthMap = new Hashtable();
            String strMonthValue = tmTimeItem.getMONTHVALUE();
            String[] monthvalues = strMonthValue.split("[,]");
            i = 0;
            while (i < monthvalues.length) {
                this.monthMap.put(Integer.parseInt(monthvalues[i]), 0);
                ++i;
            }
        }
        if (StringHelper.Compare((String)tmTimeItem.getMONTHDAYTYPE(), (String)"NONE", (boolean)true) == 0) {
            this.bCheckMonthDay = false;
        } else if (StringHelper.Compare((String)tmTimeItem.getMONTHDAYTYPE(), (String)"SOME", (boolean)true) == 0) {
            this.monthDayMap = new Hashtable();
            String strMonthDayValue = tmTimeItem.getMONTHDAYVALUE();
            String[] monthdayvalues = strMonthDayValue.split("[,]");
            i = 0;
            while (i < monthdayvalues.length) {
                this.monthDayMap.put(Integer.parseInt(monthdayvalues[i]), 0);
                ++i;
            }
        }
        if (StringHelper.Compare((String)tmTimeItem.getMONTHWEEKTYPE(), (String)"NONE", (boolean)true) == 0) {
            this.bCheckMonthWeek = false;
        } else {
            this.weekDayMap = new Hashtable();
            String strMonthWeekValue = tmTimeItem.getMONTHWEEKVALUE();
            String[] monthweekvalues = strMonthWeekValue.split("[,]");
            i = 0;
            while (i < monthweekvalues.length) {
                this.weekDayMap.put(Integer.parseInt(monthweekvalues[i]), 0);
                ++i;
            }
            if (StringHelper.Compare((String)tmTimeItem.getMONTHWEEKTYPE(), (String)"ONE", (boolean)true) == 0) {
                this.nMonthWeek = 1;
            } else if (StringHelper.Compare((String)tmTimeItem.getMONTHWEEKTYPE(), (String)"TWO", (boolean)true) == 0) {
                this.nMonthWeek = 2;
            } else if (StringHelper.Compare((String)tmTimeItem.getMONTHWEEKTYPE(), (String)"THREE", (boolean)true) == 0) {
                this.nMonthWeek = 3;
            } else if (StringHelper.Compare((String)tmTimeItem.getMONTHWEEKTYPE(), (String)"FOUR", (boolean)true) == 0) {
                this.nMonthWeek = 4;
            } else if (StringHelper.Compare((String)tmTimeItem.getMONTHWEEKTYPE(), (String)"FIVE", (boolean)true) == 0) {
                this.nMonthWeek = 5;
            }
        }
        this.nDayMode = tmTimeItem.getDAYMODE();
        if (this.nDayMode == 2) {
            if (tmTimeItem.getENABLETIME()) {
                if (!tmTimeItem.isBEGINTIMENull()) {
                    this.dayBeginTime = Calendar.getInstance();
                    this.dayBeginTime.setTime(tmTimeItem.getBEGINTIME());
                }
                if (!tmTimeItem.isENDTIMENull()) {
                    this.dayEndTime = Calendar.getInstance();
                    this.dayEndTime.setTime(tmTimeItem.getENDTIME());
                }
            }
            if (tmTimeItem.getENABLETIME2()) {
                if (!tmTimeItem.isBEGINTIME2Null()) {
                    this.dayBeginTime2 = Calendar.getInstance();
                    this.dayBeginTime2.setTime(tmTimeItem.getBEGINTIME2());
                }
                if (!tmTimeItem.isENDTIME2Null()) {
                    this.dayEndTime2 = Calendar.getInstance();
                    this.dayEndTime2.setTime(tmTimeItem.getENDTIME2());
                }
            }
        }
        this.OnInit();
    }

    protected void OnInit() throws Exception {
    }

    public String getId() {
        return this.tmTimeItem.getTMTIMEITEMID();
    }

    public String getName() {
        return this.tmTimeItem.getTMTIMEITEMNAME();
    }

    public int getVersion() {
        return 0;
    }

    public Integer CalcValidTime(Timestamp beginTime, long nDuration) throws Exception {
        return this.OnCalcValidTime(beginTime, nDuration);
    }

    protected Integer OnCalcValidTime(Timestamp beginTime, long nDuration) throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.setTime(beginTime);
        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(beginTime);
        calEnd.add(12, (int)nDuration);
        boolean bTestDayTime = false;
        if (this.monthMap != null && !this.monthMap.containsKey(cal.get(2) + 1)) {
            return -2;
        }
        if (this.bCheckMonthDay) {
            if (this.monthDayMap != null && !this.monthDayMap.containsKey(cal.get(5))) {
                return -2;
            }
            bTestDayTime = true;
        }
        if (this.bCheckMonthWeek) {
            if (this.nMonthWeek != 0 && this.nMonthWeek != cal.get(4)) {
                return -2;
            }
            if (!this.weekDayMap.containsKey(cal.get(7))) {
                return -2;
            }
            bTestDayTime = true;
        }
        if (bTestDayTime) {
            int nTimeDayMinuteEnd;
            int nTimeDayMinute;
            if (this.nDayMode == 1) {
                return 0;
            }
            if (this.nDayMode == 0) {
                return -1;
            }
            int nDayMinute = cal.get(11) * 60 + cal.get(12);
            if (this.dayBeginTime != null) {
                nTimeDayMinute = this.dayBeginTime.get(11) * 60 + this.dayBeginTime.get(12);
                if (nTimeDayMinute > nDayMinute) {
                    return nTimeDayMinute - nDayMinute;
                }
                if (this.dayEndTime != null) {
                    nTimeDayMinuteEnd = this.dayEndTime.get(11) * 60 + this.dayEndTime.get(12);
                    if ((long)nDayMinute + nDuration <= (long)nTimeDayMinuteEnd) {
                        return 0;
                    }
                } else {
                    return 0;
                }
            }
            if (this.dayBeginTime2 != null) {
                nTimeDayMinute = this.dayBeginTime2.get(11) * 60 + this.dayBeginTime2.get(12);
                if (nTimeDayMinute > nDayMinute) {
                    return nTimeDayMinute - nDayMinute;
                }
                if (this.dayEndTime2 != null) {
                    nTimeDayMinuteEnd = this.dayEndTime2.get(11) * 60 + this.dayEndTime2.get(12);
                    if ((long)nDayMinute + nDuration <= (long)nTimeDayMinuteEnd) {
                        return 0;
                    }
                } else {
                    return 0;
                }
            }
            return -1;
        }
        return -2;
    }
}

