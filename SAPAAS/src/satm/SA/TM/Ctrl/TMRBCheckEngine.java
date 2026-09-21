/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.DateParser
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.DateParser;
import SA.SRFramework.Utility.StringHelper;
import SA.TM.Ctrl.BaseTMObject;
import SA.TM.Ctrl.Data.TMRBRuleItem;
import SA.TM.Ctrl.Data.TMResBooking;
import SA.TM.Ctrl.Data.TMResDayBKTime;
import SA.TM.Ctrl.ITMActionContext;
import SA.TM.Ctrl.ITMRBCheckEngine;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;

public class TMRBCheckEngine
extends BaseTMObject
implements ITMRBCheckEngine {
    public static final String BOOKINGTYPE_COMPLEXRESBOOKING = "COMPLEXRESBOOKING";
    protected String strTMResBookingDBStorage = "";
    protected CodeListConfig rbStateCodeListConfig = null;

    public void Init(ISRFDAGlobalHelper iDAGlobalHelper) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.rbStateCodeListConfig = this.iDAGlobalHelper.getCodeListMgr().GetCodeListConfig("CODELIST_TM0110_003");
        if (this.rbStateCodeListConfig == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u4ee3\u7801\u8868[CODELIST_TM0110_003]"));
        }
        IDEDataCtrl tmResBookingDataCtrl = iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl2("TM0110", "SYSTEM", null);
        this.strTMResBookingDBStorage = tmResBookingDataCtrl.GetDEHelper().GetDBStorage();
    }

    /*
     * Could not resolve type clashes
     * Unable to fully structure code
     */
    public CallResult Check(ITMActionContext iTMActionContext, TMResBooking tmResBooking, TMResBooking tmResBookingLast) throws Exception {
        callResult = new CallResult();
        checkItemMap = new Hashtable<String, String>();
        allTMResBookingList = new Vector<Object>();
        relatedTMResBookingList = new Vector<TMResBooking>();
        if (tmResBookingLast != null) {
            checkItemMap.put(tmResBookingLast.getTMRESBOOKINGID(), "");
            if (tmResBookingLast.getBEGINTIME() != null && tmResBookingLast.getENDTIME() != null) {
                iTMResBaseHelper = this.getTMModelStorage().FindTMResource(tmResBookingLast.getTMRESBASEID());
                tmRBRules = iTMResBaseHelper.getRBRules();
                for (String strTMRBRuleId : tmRBRules) {
                    iTMRBRuleHelper = this.getTMModelStorage().FindTMRBRule(strTMRBRuleId);
                    relatedTMResBookingList.clear();
                    iTMRBRuleHelper.Check(iTMActionContext, tmResBookingLast, true, relatedTMResBookingList);
                    for (Iterator<String> item : relatedTMResBookingList) {
                        if (checkItemMap.containsKey(item /* !! */ .getTMRESBOOKINGID())) continue;
                        allTMResBookingList.add(item /* !! */ );
                    }
                }
            }
        }
        if (tmResBooking == null) ** GOTO lbl143
        checkItemMap.put(tmResBooking.getTMRESBOOKINGID(), "");
        if (tmResBooking.getBEGINTIME() == null || tmResBooking.getENDTIME() == null) ** GOTO lbl143
        strRBState = "NORMAL";
        strRBInfo = "";
        iTMResBaseHelper = this.getTMModelStorage().FindTMResource(tmResBooking.getTMRESBASEID());
        tmRBRules = iTMResBaseHelper.getRBRules();
        for (String strTMRBRuleId : tmRBRules) {
            iTMRBRuleHelper = this.getTMModelStorage().FindTMRBRule(strTMRBRuleId);
            relatedTMResBookingList.clear();
            callResult = iTMRBRuleHelper.Check(iTMActionContext, tmResBooking, false, relatedTMResBookingList);
            for (TMResBooking item : relatedTMResBookingList) {
                if (checkItemMap.containsKey(item.getTMRESBOOKINGID())) continue;
                allTMResBookingList.add((Object)item);
            }
            if (callResult.getUserObject() == null || !(callResult.getUserObject() instanceof TMRBRuleItem)) continue;
            tmRBRuleItem = (TMRBRuleItem)callResult.getUserObject();
            if (StringHelper.Compare((String)strRBState, (String)"ERROR", (boolean)true) != 0) {
                strRBState = tmRBRuleItem.getRBSTATE();
            }
            if (!StringHelper.IsNullOrEmpty((String)strRBInfo)) {
                strRBInfo = String.valueOf(strRBInfo) + "\r\n";
            }
            strRBInfo = String.valueOf(strRBInfo) + StringHelper.Format((String)"[%1$s] %2$s", (Object)this.rbStateCodeListConfig.GetCodeListValue(strRBState, true), (Object)iTMRBRuleHelper.getRuleInfo());
        }
        tmResBookingDataCtrl = iTMActionContext.getDEDataCtrl("TM0110");
        if (iTMResBaseHelper.isComplexResource()) {
            tmResBookingChilds = new Vector<E>();
            cond = new BaseDataEntity();
            cond.SetParamValue("PTMRESBOOKINGID", (Object)tmResBooking.getTMRESBOOKINGID());
            callResult = tmResBookingDataCtrl.Select(cond, tmResBookingChilds, TMResBooking.class.getName());
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u8d44\u6e90\u9884\u7ea6[%1$s]\u5b50\u9884\u7ea6\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)tmResBooking.getTMRESBOOKINGID(), (Object)callResult.getErrorInfo()));
            }
            for (TMResBooking tmResBookingChild : tmResBookingChilds) {
                if (StringHelper.Compare((String)tmResBookingChild.getRBSTATE(), (String)"NORMAL", (boolean)true) == 0) continue;
                if (StringHelper.Compare((String)strRBState, (String)"ERROR", (boolean)true) != 0) {
                    strRBState = tmResBookingChild.getRBSTATE();
                }
                if (!StringHelper.IsNullOrEmpty((String)strRBInfo)) {
                    strRBInfo = String.valueOf(strRBInfo) + "\r\n\r\n";
                }
                strRBInfo = String.valueOf(strRBInfo) + StringHelper.Format((String)"\u8d44\u6e90[%1$s] [%2$s]\r\n", (Object)tmResBookingChild.getTMRESBASENAME(), (Object)this.rbStateCodeListConfig.GetCodeListValue(tmResBookingChild.getRBSTATE(), true));
                strRBInfo = String.valueOf(strRBInfo) + StringHelper.Format((String)"%1$s\r\n", (Object)tmResBookingChild.getRBINFO());
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)tmResBooking.getPTMRESBOOKINGID())) {
            checkItemMap.remove(tmResBooking.getPTMRESBOOKINGID());
            tmResBookingParent = new TMResBooking();
            tmResBookingParent.setTMRESBOOKINGID(tmResBooking.getPTMRESBOOKINGID());
            callResult = tmResBookingDataCtrl.Get((BaseDataEntity)tmResBookingParent);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u8d44\u6e90\u9884\u7ea6[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)tmResBooking.getPTMRESBOOKINGID(), (Object)callResult.getErrorInfo()));
            }
            allTMResBookingList.add((Object)tmResBookingParent);
        }
        tmResBookingUpdate = new TMResBooking();
        tmResBookingUpdate.setTMRESBOOKINGID(tmResBooking.getTMRESBOOKINGID());
        tmResBookingUpdate.setRBSTATE(strRBState);
        tmResBookingUpdate.setRBINFO(strRBInfo);
        callResult = tmResBookingDataCtrl.Save(false, "RBSTATE", (BaseDataEntity)tmResBookingUpdate);
        if (!callResult.IsError()) ** GOTO lbl143
        throw new Exception(StringHelper.Format((String)"\u66f4\u65b0\u8d44\u6e90\u9884\u7ea6\u72b6\u6001\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
lbl-1000:
        // 1 sources

        {
            relatedTMResBooking = (TMResBooking)allTMResBookingList.get(0);
            allTMResBookingList.remove(0);
            if (checkItemMap.containsKey(relatedTMResBooking.getTMRESBOOKINGID())) continue;
            checkItemMap.put(relatedTMResBooking.getTMRESBOOKINGID(), "");
            if (relatedTMResBooking.getBEGINTIME() == null || relatedTMResBooking.getENDTIME() == null) continue;
            strRBState = "NORMAL";
            strRBInfo = "";
            iTMResBaseHelper = this.getTMModelStorage().FindTMResource(relatedTMResBooking.getTMRESBASEID());
            tmRBRules = iTMResBaseHelper.getRBRules();
            for (String strTMRBRuleId : tmRBRules) {
                iTMRBRuleHelper = this.getTMModelStorage().FindTMRBRule(strTMRBRuleId);
                relatedTMResBookingList.clear();
                callResult = iTMRBRuleHelper.Check(iTMActionContext, relatedTMResBooking, false, relatedTMResBookingList);
                for (TMResBooking item : relatedTMResBookingList) {
                    if (checkItemMap.containsKey(item.getTMRESBOOKINGID())) continue;
                    allTMResBookingList.add((Object)item);
                }
                if (callResult.getUserObject() == null || !(callResult.getUserObject() instanceof TMRBRuleItem)) continue;
                tmRBRuleItem = (TMRBRuleItem)callResult.getUserObject();
                if (StringHelper.Compare((String)strRBState, (String)"ERROR", (boolean)true) != 0) {
                    strRBState = tmRBRuleItem.getRBSTATE();
                }
                if (!StringHelper.IsNullOrEmpty((String)strRBInfo)) {
                    strRBInfo = String.valueOf(strRBInfo) + "\r\n";
                }
                strRBInfo = String.valueOf(strRBInfo) + StringHelper.Format((String)"[%1$s] %2$s", (Object)this.rbStateCodeListConfig.GetCodeListValue(strRBState, true), (Object)iTMRBRuleHelper.getRuleInfo());
            }
            tmResBookingDataCtrl = iTMActionContext.getDEDataCtrl("TM0110");
            if (iTMResBaseHelper.isComplexResource()) {
                relatedTMResBookingChilds = new Vector<E>();
                cond = new BaseDataEntity();
                cond.SetParamValue("PTMRESBOOKINGID", (Object)relatedTMResBooking.getTMRESBOOKINGID());
                callResult = tmResBookingDataCtrl.Select(cond, relatedTMResBookingChilds, TMResBooking.class.getName());
                if (callResult.IsError()) {
                    throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u8d44\u6e90\u9884\u7ea6[%1$s]\u5b50\u9884\u7ea6\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)relatedTMResBooking.getTMRESBOOKINGID(), (Object)callResult.getErrorInfo()));
                }
                for (TMResBooking relatedTMResBookingChild : relatedTMResBookingChilds) {
                    if (StringHelper.Compare((String)relatedTMResBookingChild.getRBSTATE(), (String)"NORMAL", (boolean)true) == 0) continue;
                    if (StringHelper.Compare((String)strRBState, (String)"ERROR", (boolean)true) != 0) {
                        strRBState = relatedTMResBookingChild.getRBSTATE();
                    }
                    if (!StringHelper.IsNullOrEmpty((String)strRBInfo)) {
                        strRBInfo = String.valueOf(strRBInfo) + "\r\n\r\n";
                    }
                    strRBInfo = String.valueOf(strRBInfo) + StringHelper.Format((String)"\u8d44\u6e90[%1$s] [%2$s]\r\n", (Object)relatedTMResBookingChild.getTMRESBASENAME(), (Object)this.rbStateCodeListConfig.GetCodeListValue(relatedTMResBookingChild.getRBSTATE(), true));
                    strRBInfo = String.valueOf(strRBInfo) + StringHelper.Format((String)"%1$s\r\n", (Object)relatedTMResBookingChild.getRBINFO());
                }
            }
            if (!StringHelper.IsNullOrEmpty((String)relatedTMResBooking.getPTMRESBOOKINGID())) {
                checkItemMap.remove(relatedTMResBooking.getPTMRESBOOKINGID());
                relatedTMResBookingParent = new TMResBooking();
                relatedTMResBookingParent.setTMRESBOOKINGID(relatedTMResBooking.getPTMRESBOOKINGID());
                callResult = tmResBookingDataCtrl.Get((BaseDataEntity)relatedTMResBookingParent);
                if (callResult.IsError()) {
                    throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u8d44\u6e90\u9884\u7ea6[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)relatedTMResBooking.getPTMRESBOOKINGID(), (Object)callResult.getErrorInfo()));
                }
                allTMResBookingList.add((Object)relatedTMResBookingParent);
            }
            tmResBookingUpdate = new TMResBooking();
            tmResBookingUpdate.setTMRESBOOKINGID(relatedTMResBooking.getTMRESBOOKINGID());
            tmResBookingUpdate.setRBSTATE(strRBState);
            tmResBookingUpdate.setRBINFO(strRBInfo);
            callResult = tmResBookingDataCtrl.Save(false, "RBSTATE", (BaseDataEntity)tmResBookingUpdate);
            if (!callResult.IsError()) continue;
            throw new Exception(StringHelper.Format((String)"\u66f4\u65b0\u8d44\u6e90\u9884\u7ea6\u72b6\u6001\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
lbl143:
            // 6 sources

            ** while (allTMResBookingList.size() > 0)
        }
lbl144:
        // 1 sources

        return callResult;
    }

    public void CalcResDayBKTime(ITMActionContext iTMActionContext, TMResBooking tmResBooking, TMResBooking tmResBookingLast) throws Exception {
        this.OnCalcResDayBKTime(iTMActionContext, tmResBooking, tmResBookingLast);
    }

    protected void OnCalcResDayBKTime(ITMActionContext iTMActionContext, TMResBooking tmResBooking, TMResBooking tmResBookingLast) throws Exception {
        CallResult callResult = new CallResult();
        Vector<TMResBooking> calcList = new Vector<TMResBooking>();
        if (tmResBookingLast != null && !tmResBookingLast.isBEGINTIMENull() && !tmResBookingLast.isENDTIMENull()) {
            calcList.add(tmResBookingLast);
        }
        if (tmResBooking != null && !tmResBooking.isBEGINTIMENull() && !tmResBooking.isENDTIMENull()) {
            if (calcList.size() > 0) {
                if (StringHelper.Compare((String)tmResBooking.getTMRESBASEID(), (String)tmResBookingLast.getTMRESBASEID(), (boolean)true) == 0) {
                    String strBeginTime = StringHelper.Format((String)"%1$tY-%1$tm-%1$td 00:00:00", (Object)tmResBookingLast.getBEGINTIME());
                    String strEndTime = StringHelper.Format((String)"%1$tY-%1$tm-%1$td 00:00:00", (Object)tmResBookingLast.getENDTIME());
                    String strBeginTime2 = StringHelper.Format((String)"%1$tY-%1$tm-%1$td 00:00:00", (Object)tmResBooking.getBEGINTIME());
                    String strEndTime2 = StringHelper.Format((String)"%1$tY-%1$tm-%1$td 00:00:00", (Object)tmResBooking.getENDTIME());
                    if (StringHelper.Compare((String)strBeginTime, (String)strBeginTime2, (boolean)true) != 0 || StringHelper.Compare((String)strEndTime, (String)strEndTime2, (boolean)true) != 0) {
                        calcList.add(tmResBooking);
                    }
                } else {
                    calcList.add(tmResBooking);
                }
            } else {
                calcList.add(tmResBooking);
            }
        }
        if (calcList.size() == 0) {
            return;
        }
        IDEDataCtrl resDayBKTimeDataCtrl = iTMActionContext.getDEDataCtrl("TM0140");
        for (TMResBooking calcItem : calcList) {
            Vector bkTypeList;
            String strBeginTime = StringHelper.Format((String)"%1$tY-%1$tm-%1$td 00:00:00", (Object)calcItem.getBEGINTIME());
            String strEndTime = StringHelper.Format((String)"%1$tY-%1$tm-%1$td 00:00:00", (Object)calcItem.getENDTIME());
            Date dtBegin = DateParser.Parse((String)strBeginTime);
            Date dtEnd = DateParser.Parse((String)strEndTime);
            Calendar calEnd = Calendar.getInstance();
            calEnd.setTime(dtEnd);
            calEnd.add(10, 24);
            dtEnd = calEnd.getTime();
            String strSQL = StringHelper.Format((String)"select t1.* from SRFT_TMRESBOOKING_BASE t1 where t1.BEGINTIME<? AND t1.ENDTIME>? and t1.TMRESBASEID=? ORDER BY TMRESBOOKINGTYPE,BEGINTIME");
            CallParamList callParamList = new CallParamList();
            callParamList.AddDateTime((Object)dtEnd);
            callParamList.AddDateTime((Object)dtBegin);
            callParamList.Add((Object)calcItem.getTMRESBASEID());
            Vector tmResBookingList = new Vector();
            callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.iDAGlobalHelper, (Connection)iTMActionContext.getDBConnection(this.strTMResBookingDBStorage), (String)this.strTMResBookingDBStorage, (String)strSQL, (Vector)callParamList.GetList(), tmResBookingList, (String)TMResBooking.class.getName());
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u65f6\u95f4\u6bb5\u5185\u9884\u7ea6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            Hashtable<String, Vector> bkTypeMap = new Hashtable<String, Vector>();
            bkTypeMap.put(calcItem.getTMRESBOOKINGTYPE(), new Vector());
            for (TMResBooking item : tmResBookingList) {
                bkTypeList = null;
                if (bkTypeMap.containsKey(item.getTMRESBOOKINGTYPE())) {
                    bkTypeList = (Vector)bkTypeMap.get(item.getTMRESBOOKINGTYPE());
                } else {
                    bkTypeList = new Vector();
                    bkTypeMap.put(item.getTMRESBOOKINGTYPE(), bkTypeList);
                }
                if (item.getBEGINTIME().getTime() < dtBegin.getTime()) {
                    item.setBEGINTIME(new Timestamp(dtBegin.getTime()));
                }
                if (item.getENDTIME().getTime() > dtEnd.getTime()) {
                    item.setENDTIME(new Timestamp(dtEnd.getTime()));
                }
                if (bkTypeList.size() > 0) {
                    TMResBooking lastItem = (TMResBooking)((Object)bkTypeList.get(bkTypeList.size() - 1));
                    if (item.getBEGINTIME().getTime() <= lastItem.getENDTIME().getTime()) {
                        if (item.getENDTIME().getTime() <= lastItem.getENDTIME().getTime()) continue;
                        lastItem.setENDTIME(item.getENDTIME());
                        continue;
                    }
                    bkTypeList.add(item);
                    continue;
                }
                bkTypeList.add(item);
            }
            for (String strBKType : bkTypeMap.keySet()) {
                bkTypeList = (Vector)bkTypeMap.get(strBKType);
                Calendar calBeginCur = Calendar.getInstance();
                calBeginCur.setTime(dtBegin);
                while (calBeginCur.getTime().getTime() < dtEnd.getTime()) {
                    String strEndTimeCur = StringHelper.Format((String)"%1$tY-%1$tm-%1$td 00:00:00", (Object)calBeginCur.getTime());
                    Calendar calEndCur = Calendar.getInstance();
                    calEndCur.setTime(DateParser.Parse((String)strEndTimeCur));
                    calEndCur.add(10, 24);
                    long nDayMinute = 0L;
                    for (TMResBooking item : bkTypeList) {
                        Date curBegin = null;
                        Date curEnd = null;
                        if (item.getENDTIME().getTime() <= calBeginCur.getTime().getTime() || item.getBEGINTIME().getTime() >= calEndCur.getTime().getTime()) continue;
                        curBegin = item.getBEGINTIME().getTime() <= calBeginCur.getTime().getTime() ? calBeginCur.getTime() : item.getBEGINTIME();
                        curEnd = item.getENDTIME().getTime() <= calEndCur.getTime().getTime() ? item.getENDTIME() : calEndCur.getTime();
                        long nCurTime = curEnd.getTime() - curBegin.getTime();
                        nDayMinute += nCurTime;
                    }
                    nDayMinute /= 60000L;
                    TMResDayBKTime tmResDayBKTime = new TMResDayBKTime();
                    tmResDayBKTime.setTMRESDAYBKTIMEID(StringHelper.Format((String)"%1$s_%2$s_%3$s", (Object)calcItem.getTMRESBASEID(), (Object)strBKType, (Object)StringHelper.Format((String)"%1$tY%1$tm%1$td", (Object)calBeginCur.getTime())));
                    resDayBKTimeDataCtrl.Remove((BaseDataEntity)tmResDayBKTime);
                    tmResDayBKTime.setTMRESBASEID(calcItem.getTMRESBASEID());
                    tmResDayBKTime.setBOOKINGTYPE(strBKType);
                    tmResDayBKTime.setDAYID(StringHelper.Format((String)"%1$tY%1$tm%1$td", (Object)calBeginCur.getTime()));
                    tmResDayBKTime.setDAYVALUE(new Timestamp(calBeginCur.getTime().getTime()));
                    tmResDayBKTime.setDURATION((int)nDayMinute);
                    callResult = resDayBKTimeDataCtrl.Save(true, (BaseDataEntity)tmResDayBKTime);
                    if (callResult.IsError()) {
                        throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u8d44\u6e90\u65e5\u9884\u7ea6\u5408\u8ba1\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    calBeginCur.add(10, 24);
                }
            }
        }
    }
}

