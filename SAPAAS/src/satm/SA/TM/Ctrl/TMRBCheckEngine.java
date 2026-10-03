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
import SA.TM.Ctrl.Data.TMRBRuleItem;
import SA.TM.Ctrl.Data.TMResBooking;
import SA.TM.Ctrl.Data.TMResDayBKTime;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.Vector;

public class TMRBCheckEngine extends BaseTMObject implements ITMRBCheckEngine {
   public static final String BOOKINGTYPE_COMPLEXRESBOOKING = "COMPLEXRESBOOKING";
   protected String strTMResBookingDBStorage = "";
   protected CodeListConfig rbStateCodeListConfig = null;

   @Override
   public void Init(ISRFDAGlobalHelper iDAGlobalHelper) throws Exception {
      this.iDAGlobalHelper = iDAGlobalHelper;
      this.rbStateCodeListConfig = this.iDAGlobalHelper.getCodeListMgr().GetCodeListConfig("CODELIST_TM0110_003");
      if (this.rbStateCodeListConfig == null) {
         throw new Exception(StringHelper.Format("无法获取代码表[CODELIST_TM0110_003]"));
      }

      IDEDataCtrl tmResBookingDataCtrl = iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl2("TM0110", "SYSTEM", null);
      this.strTMResBookingDBStorage = tmResBookingDataCtrl.GetDEHelper().GetDBStorage();
   }

   @Override
   public CallResult Check(ITMActionContext iTMActionContext, TMResBooking tmResBooking, TMResBooking tmResBookingLast) throws Exception {
      CallResult callResult = new CallResult();
      Hashtable<String, String> checkItemMap = new Hashtable<>();
      Vector<TMResBooking> allTMResBookingList = new Vector<>();
      Vector<TMResBooking> relatedTMResBookingList = new Vector<>();
      if (tmResBookingLast != null) {
         checkItemMap.put(tmResBookingLast.getTMRESBOOKINGID(), "");
         if (tmResBookingLast.getBEGINTIME() != null && tmResBookingLast.getENDTIME() != null) {
            ITMResBaseHelper iTMResBaseHelper = this.getTMModelStorage().FindTMResource(tmResBookingLast.getTMRESBASEID());

            for (String strTMRBRuleId : iTMResBaseHelper.getRBRules()) {
               ITMRBRuleHelper iTMRBRuleHelper = this.getTMModelStorage().FindTMRBRule(strTMRBRuleId);
               relatedTMResBookingList.clear();
               iTMRBRuleHelper.Check(iTMActionContext, tmResBookingLast, true, relatedTMResBookingList);

               for (TMResBooking item : relatedTMResBookingList) {
                  if (!checkItemMap.containsKey(item.getTMRESBOOKINGID())) {
                     allTMResBookingList.add(item);
                  }
               }
            }
         }
      }

      if (tmResBooking != null) {
         checkItemMap.put(tmResBooking.getTMRESBOOKINGID(), "");
         if (tmResBooking.getBEGINTIME() != null && tmResBooking.getENDTIME() != null) {
            String strRBState = "NORMAL";
            String strRBInfo = "";
            ITMResBaseHelper iTMResBaseHelper = this.getTMModelStorage().FindTMResource(tmResBooking.getTMRESBASEID());

            for (String strTMRBRuleId : iTMResBaseHelper.getRBRules()) {
               ITMRBRuleHelper iTMRBRuleHelper = this.getTMModelStorage().FindTMRBRule(strTMRBRuleId);
               relatedTMResBookingList.clear();
               callResult = iTMRBRuleHelper.Check(iTMActionContext, tmResBooking, false, relatedTMResBookingList);

               for (TMResBooking item : relatedTMResBookingList) {
                  if (!checkItemMap.containsKey(item.getTMRESBOOKINGID())) {
                     allTMResBookingList.add(item);
                  }
               }

               if (callResult.getUserObject() != null && callResult.getUserObject() instanceof TMRBRuleItem) {
                  TMRBRuleItem tmRBRuleItem = (TMRBRuleItem)callResult.getUserObject();
                  if (StringHelper.Compare(strRBState, "ERROR", true) != 0) {
                     strRBState = tmRBRuleItem.getRBSTATE();
                  }

                  if (!StringHelper.IsNullOrEmpty(strRBInfo)) {
                     strRBInfo = strRBInfo + "\r\n";
                  }

                  strRBInfo = strRBInfo
                     + StringHelper.Format("[%1$s] %2$s", this.rbStateCodeListConfig.GetCodeListValue(strRBState, true), iTMRBRuleHelper.getRuleInfo());
               }
            }

            IDEDataCtrl tmResBookingDataCtrl = iTMActionContext.getDEDataCtrl("TM0110");
            if (iTMResBaseHelper.isComplexResource()) {
               Vector<TMResBooking> tmResBookingChilds = new Vector<>();
               BaseDataEntity cond = new BaseDataEntity();
               cond.SetParamValue("PTMRESBOOKINGID", tmResBooking.getTMRESBOOKINGID());
               callResult = tmResBookingDataCtrl.Select(cond, tmResBookingChilds, TMResBooking.class.getName());
               if (callResult.IsError()) {
                  throw new Exception(StringHelper.Format("获取资源预约[%1$s]子预约发生错误，%2$s", tmResBooking.getTMRESBOOKINGID(), callResult.getErrorInfo()));
               }

               for (TMResBooking tmResBookingChild : tmResBookingChilds) {
                  if (StringHelper.Compare(tmResBookingChild.getRBSTATE(), "NORMAL", true) != 0) {
                     if (StringHelper.Compare(strRBState, "ERROR", true) != 0) {
                        strRBState = tmResBookingChild.getRBSTATE();
                     }

                     if (!StringHelper.IsNullOrEmpty(strRBInfo)) {
                        strRBInfo = strRBInfo + "\r\n\r\n";
                     }

                     strRBInfo = strRBInfo
                        + StringHelper.Format(
                           "资源[%1$s] [%2$s]\r\n",
                           tmResBookingChild.getTMRESBASENAME(),
                           this.rbStateCodeListConfig.GetCodeListValue(tmResBookingChild.getRBSTATE(), true)
                        );
                     strRBInfo = strRBInfo + StringHelper.Format("%1$s\r\n", tmResBookingChild.getRBINFO());
                  }
               }
            }

            if (!StringHelper.IsNullOrEmpty(tmResBooking.getPTMRESBOOKINGID())) {
               checkItemMap.remove(tmResBooking.getPTMRESBOOKINGID());
               TMResBooking tmResBookingParent = new TMResBooking();
               tmResBookingParent.setTMRESBOOKINGID(tmResBooking.getPTMRESBOOKINGID());
               callResult = tmResBookingDataCtrl.Get(tmResBookingParent);
               if (callResult.IsError()) {
                  throw new Exception(StringHelper.Format("获取资源预约[%1$s]发生错误，%2$s", tmResBooking.getPTMRESBOOKINGID(), callResult.getErrorInfo()));
               }

               allTMResBookingList.add(tmResBookingParent);
            }

            TMResBooking tmResBookingUpdate = new TMResBooking();
            tmResBookingUpdate.setTMRESBOOKINGID(tmResBooking.getTMRESBOOKINGID());
            tmResBookingUpdate.setRBSTATE(strRBState);
            tmResBookingUpdate.setRBINFO(strRBInfo);
            callResult = tmResBookingDataCtrl.Save(false, "RBSTATE", tmResBookingUpdate);
            if (callResult.IsError()) {
               throw new Exception(StringHelper.Format("更新资源预约状态发生错误，%1$s", callResult.getErrorInfo()));
            }
         }
      }

      while (allTMResBookingList.size() > 0) {
         TMResBooking relatedTMResBooking = allTMResBookingList.get(0);
         allTMResBookingList.remove(0);
         if (!checkItemMap.containsKey(relatedTMResBooking.getTMRESBOOKINGID())) {
            checkItemMap.put(relatedTMResBooking.getTMRESBOOKINGID(), "");
            if (relatedTMResBooking.getBEGINTIME() != null && relatedTMResBooking.getENDTIME() != null) {
               String strRBState = "NORMAL";
               String strRBInfo = "";
               ITMResBaseHelper iTMResBaseHelper = this.getTMModelStorage().FindTMResource(relatedTMResBooking.getTMRESBASEID());

               for (String strTMRBRuleId : iTMResBaseHelper.getRBRules()) {
                  ITMRBRuleHelper iTMRBRuleHelper = this.getTMModelStorage().FindTMRBRule(strTMRBRuleId);
                  relatedTMResBookingList.clear();
                  callResult = iTMRBRuleHelper.Check(iTMActionContext, relatedTMResBooking, false, relatedTMResBookingList);

                  for (TMResBooking item : relatedTMResBookingList) {
                     if (!checkItemMap.containsKey(item.getTMRESBOOKINGID())) {
                        allTMResBookingList.add(item);
                     }
                  }

                  if (callResult.getUserObject() != null && callResult.getUserObject() instanceof TMRBRuleItem) {
                     TMRBRuleItem tmRBRuleItem = (TMRBRuleItem)callResult.getUserObject();
                     if (StringHelper.Compare(strRBState, "ERROR", true) != 0) {
                        strRBState = tmRBRuleItem.getRBSTATE();
                     }

                     if (!StringHelper.IsNullOrEmpty(strRBInfo)) {
                        strRBInfo = strRBInfo + "\r\n";
                     }

                     strRBInfo = strRBInfo
                        + StringHelper.Format("[%1$s] %2$s", this.rbStateCodeListConfig.GetCodeListValue(strRBState, true), iTMRBRuleHelper.getRuleInfo());
                  }
               }

               IDEDataCtrl tmResBookingDataCtrl = iTMActionContext.getDEDataCtrl("TM0110");
               if (iTMResBaseHelper.isComplexResource()) {
                  Vector<TMResBooking> relatedTMResBookingChilds = new Vector<>();
                  BaseDataEntity cond = new BaseDataEntity();
                  cond.SetParamValue("PTMRESBOOKINGID", relatedTMResBooking.getTMRESBOOKINGID());
                  callResult = tmResBookingDataCtrl.Select(cond, relatedTMResBookingChilds, TMResBooking.class.getName());
                  if (callResult.IsError()) {
                     throw new Exception(StringHelper.Format("获取资源预约[%1$s]子预约发生错误，%2$s", relatedTMResBooking.getTMRESBOOKINGID(), callResult.getErrorInfo()));
                  }

                  for (TMResBooking relatedTMResBookingChild : relatedTMResBookingChilds) {
                     if (StringHelper.Compare(relatedTMResBookingChild.getRBSTATE(), "NORMAL", true) != 0) {
                        if (StringHelper.Compare(strRBState, "ERROR", true) != 0) {
                           strRBState = relatedTMResBookingChild.getRBSTATE();
                        }

                        if (!StringHelper.IsNullOrEmpty(strRBInfo)) {
                           strRBInfo = strRBInfo + "\r\n\r\n";
                        }

                        strRBInfo = strRBInfo
                           + StringHelper.Format(
                              "资源[%1$s] [%2$s]\r\n",
                              relatedTMResBookingChild.getTMRESBASENAME(),
                              this.rbStateCodeListConfig.GetCodeListValue(relatedTMResBookingChild.getRBSTATE(), true)
                           );
                        strRBInfo = strRBInfo + StringHelper.Format("%1$s\r\n", relatedTMResBookingChild.getRBINFO());
                     }
                  }
               }

               if (!StringHelper.IsNullOrEmpty(relatedTMResBooking.getPTMRESBOOKINGID())) {
                  checkItemMap.remove(relatedTMResBooking.getPTMRESBOOKINGID());
                  TMResBooking relatedTMResBookingParent = new TMResBooking();
                  relatedTMResBookingParent.setTMRESBOOKINGID(relatedTMResBooking.getPTMRESBOOKINGID());
                  callResult = tmResBookingDataCtrl.Get(relatedTMResBookingParent);
                  if (callResult.IsError()) {
                     throw new Exception(StringHelper.Format("获取资源预约[%1$s]发生错误，%2$s", relatedTMResBooking.getPTMRESBOOKINGID(), callResult.getErrorInfo()));
                  }

                  allTMResBookingList.add(relatedTMResBookingParent);
               }

               TMResBooking tmResBookingUpdate = new TMResBooking();
               tmResBookingUpdate.setTMRESBOOKINGID(relatedTMResBooking.getTMRESBOOKINGID());
               tmResBookingUpdate.setRBSTATE(strRBState);
               tmResBookingUpdate.setRBINFO(strRBInfo);
               callResult = tmResBookingDataCtrl.Save(false, "RBSTATE", tmResBookingUpdate);
               if (callResult.IsError()) {
                  throw new Exception(StringHelper.Format("更新资源预约状态发生错误，%1$s", callResult.getErrorInfo()));
               }
            }
         }
      }

      return callResult;
   }

   @Override
   public void CalcResDayBKTime(ITMActionContext iTMActionContext, TMResBooking tmResBooking, TMResBooking tmResBookingLast) throws Exception {
      this.OnCalcResDayBKTime(iTMActionContext, tmResBooking, tmResBookingLast);
   }

   protected void OnCalcResDayBKTime(ITMActionContext iTMActionContext, TMResBooking tmResBooking, TMResBooking tmResBookingLast) throws Exception {
      new CallResult();
      Vector<TMResBooking> calcList = new Vector<>();
      if (tmResBookingLast != null && !tmResBookingLast.isBEGINTIMENull() && !tmResBookingLast.isENDTIMENull()) {
         calcList.add(tmResBookingLast);
      }

      if (tmResBooking != null && !tmResBooking.isBEGINTIMENull() && !tmResBooking.isENDTIMENull()) {
         if (calcList.size() > 0) {
            if (StringHelper.Compare(tmResBooking.getTMRESBASEID(), tmResBookingLast.getTMRESBASEID(), true) == 0) {
               String strBeginTime = StringHelper.Format("%1$tY-%1$tm-%1$td 00:00:00", tmResBookingLast.getBEGINTIME());
               String strEndTime = StringHelper.Format("%1$tY-%1$tm-%1$td 00:00:00", tmResBookingLast.getENDTIME());
               String strBeginTime2 = StringHelper.Format("%1$tY-%1$tm-%1$td 00:00:00", tmResBooking.getBEGINTIME());
               String strEndTime2 = StringHelper.Format("%1$tY-%1$tm-%1$td 00:00:00", tmResBooking.getENDTIME());
               if (StringHelper.Compare(strBeginTime, strBeginTime2, true) != 0 || StringHelper.Compare(strEndTime, strEndTime2, true) != 0) {
                  calcList.add(tmResBooking);
               }
            } else {
               calcList.add(tmResBooking);
            }
         } else {
            calcList.add(tmResBooking);
         }
      }

      if (calcList.size() != 0) {
         IDEDataCtrl resDayBKTimeDataCtrl = iTMActionContext.getDEDataCtrl("TM0140");

         for (TMResBooking calcItem : calcList) {
            String strBeginTime = StringHelper.Format("%1$tY-%1$tm-%1$td 00:00:00", calcItem.getBEGINTIME());
            String strEndTime = StringHelper.Format("%1$tY-%1$tm-%1$td 00:00:00", calcItem.getENDTIME());
            Date dtBegin = DateParser.Parse(strBeginTime);
            Date dtEnd = DateParser.Parse(strEndTime);
            Calendar calEnd = Calendar.getInstance();
            calEnd.setTime(dtEnd);
            calEnd.add(10, 24);
            dtEnd = calEnd.getTime();
            String strSQL = StringHelper.Format(
               "select t1.* from SRFT_TMRESBOOKING_BASE t1 where t1.BEGINTIME<? AND t1.ENDTIME>? and t1.TMRESBASEID=? ORDER BY TMRESBOOKINGTYPE,BEGINTIME"
            );
            CallParamList callParamList = new CallParamList();
            callParamList.AddDateTime(dtEnd);
            callParamList.AddDateTime(dtBegin);
            callParamList.Add(calcItem.getTMRESBASEID());
            Vector<TMResBooking> tmResBookingList = new Vector<>();
            CallResult callResult = BaseDEDataCtrl.SelectMultiEx(
               this.iDAGlobalHelper,
               iTMActionContext.getDBConnection(this.strTMResBookingDBStorage),
               this.strTMResBookingDBStorage,
               strSQL,
               callParamList.GetList(),
               tmResBookingList,
               TMResBooking.class.getName()
            );
            if (callResult.IsError()) {
               throw new Exception(StringHelper.Format("查询时间段内预约发生错误，%1$s", callResult.getErrorInfo()));
            }

            Hashtable<String, Vector<TMResBooking>> bkTypeMap = new Hashtable<>();
            bkTypeMap.put(calcItem.getTMRESBOOKINGTYPE(), new Vector<TMResBooking>());

            for (TMResBooking item : tmResBookingList) {
               Vector<TMResBooking> bkTypeList = null;
               if (bkTypeMap.containsKey(item.getTMRESBOOKINGTYPE())) {
                  bkTypeList = bkTypeMap.get(item.getTMRESBOOKINGTYPE());
               } else {
                  bkTypeList = new Vector<>();
                  bkTypeMap.put(item.getTMRESBOOKINGTYPE(), bkTypeList);
               }

               if (item.getBEGINTIME().getTime() < dtBegin.getTime()) {
                  item.setBEGINTIME(new Timestamp(dtBegin.getTime()));
               }

               if (item.getENDTIME().getTime() > dtEnd.getTime()) {
                  item.setENDTIME(new Timestamp(dtEnd.getTime()));
               }

               if (bkTypeList.size() > 0) {
                  TMResBooking lastItem = bkTypeList.get(bkTypeList.size() - 1);
                  if (item.getBEGINTIME().getTime() <= lastItem.getENDTIME().getTime()) {
                     if (item.getENDTIME().getTime() > lastItem.getENDTIME().getTime()) {
                        lastItem.setENDTIME(item.getENDTIME());
                     }
                  } else {
                     bkTypeList.add(item);
                  }
               } else {
                  bkTypeList.add(item);
               }
            }

            for (String strBKType : bkTypeMap.keySet()) {
               Vector<TMResBooking> bkTypeList = bkTypeMap.get(strBKType);
               Calendar calBeginCur = Calendar.getInstance();
               calBeginCur.setTime(dtBegin);

               while (calBeginCur.getTime().getTime() < dtEnd.getTime()) {
                  String strEndTimeCur = StringHelper.Format("%1$tY-%1$tm-%1$td 00:00:00", calBeginCur.getTime());
                  Calendar calEndCur = Calendar.getInstance();
                  calEndCur.setTime(DateParser.Parse(strEndTimeCur));
                  calEndCur.add(10, 24);
                  long nDayMinute = 0L;

                  for (TMResBooking item : bkTypeList) {
                     Date curBegin = null;
                     Date curEnd = null;
                     if (item.getENDTIME().getTime() > calBeginCur.getTime().getTime() && item.getBEGINTIME().getTime() < calEndCur.getTime().getTime()) {
                        if (item.getBEGINTIME().getTime() <= calBeginCur.getTime().getTime()) {
                           curBegin = calBeginCur.getTime();
                        } else {
                           curBegin = item.getBEGINTIME();
                        }

                        if (item.getENDTIME().getTime() <= calEndCur.getTime().getTime()) {
                           curEnd = item.getENDTIME();
                        } else {
                           curEnd = calEndCur.getTime();
                        }

                        long nCurTime = curEnd.getTime() - curBegin.getTime();
                        nDayMinute += nCurTime;
                     }
                  }

                  nDayMinute /= 60000L;
                  TMResDayBKTime tmResDayBKTime = new TMResDayBKTime();
                  tmResDayBKTime.setTMRESDAYBKTIMEID(
                     StringHelper.Format("%1$s_%2$s_%3$s", calcItem.getTMRESBASEID(), strBKType, StringHelper.Format("%1$tY%1$tm%1$td", calBeginCur.getTime()))
                  );
                  resDayBKTimeDataCtrl.Remove(tmResDayBKTime);
                  tmResDayBKTime.setTMRESBASEID(calcItem.getTMRESBASEID());
                  tmResDayBKTime.setBOOKINGTYPE(strBKType);
                  tmResDayBKTime.setDAYID(StringHelper.Format("%1$tY%1$tm%1$td", calBeginCur.getTime()));
                  tmResDayBKTime.setDAYVALUE(new Timestamp(calBeginCur.getTime().getTime()));
                  tmResDayBKTime.setDURATION((int)nDayMinute);
                  callResult = resDayBKTimeDataCtrl.Save(true, tmResDayBKTime);
                  if (callResult.IsError()) {
                     throw new Exception(StringHelper.Format("保存资源日预约合计数据发生错误，%1$s", callResult.getErrorInfo()));
                  }

                  calBeginCur.add(10, 24);
               }
            }
         }
      }
   }
}
