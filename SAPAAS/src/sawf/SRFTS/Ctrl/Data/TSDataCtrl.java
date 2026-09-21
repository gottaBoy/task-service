/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.Data.InsertResult
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.Data.UpdateResult
 *  SA.SRFramework.DataEx.BaseDBCallerHelperEx
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.DateParser
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  SA.SRFramework.WebEx.Utility.ISRFExGlobalHelper
 *  javax.servlet.ServletContext
 */
package SRFTS.Ctrl.Data;

import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.InsertResult;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.Data.UpdateResult;
import SA.SRFramework.DataEx.BaseDBCallerHelperEx;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.DateParser;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.WebEx.Utility.ISRFExGlobalHelper;
import SRFTS.Ctrl.Data.TSSchedule;
import SRFTS.Ctrl.Data.TSTaskItem;
import SRFTS.Ctrl.ITSDataCtrl;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletContext;

public class TSDataCtrl
implements ITSDataCtrl {
    protected BaseDBCallerHelperEx dbCallerHelper = null;
    protected ServletContext servletContext = null;
    protected ISRFExGlobalHelper iGlobalHelper = null;

    @Override
    public boolean Init(ServletContext servletContext, BaseDBCallerHelperEx dbCallerHelper) {
        this.dbCallerHelper = dbCallerHelper;
        return true;
    }

    @Override
    public boolean Init(ISRFExGlobalHelper iGlobalHelper, BaseDBCallerHelperEx dbCallerHelper) {
        this.iGlobalHelper = iGlobalHelper;
        return true;
    }

    @Override
    public CallResult GetSchedule(String strTaskId, Date dtStartTime, Date dtEndTime, ArrayList<TSSchedule> list) {
        String strSqlFormat = " ";
        strSqlFormat = String.valueOf(strSqlFormat) + " select t_SRFTSSchedule.*,t_SRFTSTask.Taskobject,t_SRFTSTask.TaskName from t_SRFTSSchedule ";
        strSqlFormat = String.valueOf(strSqlFormat) + " INNER JOIN t_SRFTSTask ON t_SRFTSSchedule.Tstaskid = t_SRFTSTask.Tstaskid and t_SRFTSTask.Taskstate = 1 and t_SRFTSTask.Enable= 1 ";
        strSqlFormat = String.valueOf(strSqlFormat) + " where ";
        if (!StringHelper.IsNullOrEmpty((String)strTaskId)) {
            strSqlFormat = String.valueOf(strSqlFormat) + StringHelper.Format((String)"t_SRFTSSchedule.Tstaskid = '%1$s' and ", (Object)strTaskId);
        }
        strSqlFormat = String.valueOf(strSqlFormat) + " t_SRFTSSchedule.ScheduleState = 1 AND  ((t_SRFTSSchedule.Scheduletype = 1 and t_SRFTSSchedule.Rundate>=to_date('%1$s','yyyy-MM-DD HH24:MI:SS') and t_SRFTSSchedule.Rundate<=to_date('%2$s','yyyy-MM-DD HH24:MI:SS')) ";
        strSqlFormat = String.valueOf(strSqlFormat) + " OR (t_SRFTSSchedule.Scheduletype<>1 and t_SRFTSSchedule.Cyclestarttime < to_date('%2$s','yyyy-MM-DD HH24:MI:SS')  AND  (t_SRFTSSchedule.Cycleendtime IS NULL OR t_SRFTSSchedule.Cycleendtime >to_date('%1$s','yyyy-MM-DD HH24:MI:SS')))) ";
        String strSql = StringHelper.Format((String)strSqlFormat, (Object)DateParser.toDateTimeString((Date)dtStartTime), (Object)DateParser.toDateTimeString((Date)dtEndTime));
        return this.SelectRaw(strSql, list, TSSchedule.class.getName(), "");
    }

    @Override
    public CallResult GetTaskItems(Date dtStartTime, Date dtEndTime, ArrayList<TSTaskItem> list) {
        String strSqlFormat = " ";
        strSqlFormat = String.valueOf(strSqlFormat) + " select t_SRFTSTaskItem.*,t_SRFTSTask.Taskobject,t_SRFTSTask.TaskParam,t_SRFTSTask.TaskParam2,t_SRFTSTask.TaskParam3,t_SRFTSTask.TaskParam4 from t_SRFTSTaskItem  ";
        strSqlFormat = String.valueOf(strSqlFormat) + " INNER JOIN t_SRFTSTask ON t_SRFTSTaskItem.Tstaskid = t_SRFTSTask.Tstaskid and t_SRFTSTask.Taskstate = 1 and t_SRFTSTask.Enable = 1 ";
        strSqlFormat = String.valueOf(strSqlFormat) + " and REALSTARTTIME IS NULL and ( ISCANCEL IS NULL OR ISCANCEL <> 1) ";
        strSqlFormat = String.valueOf(strSqlFormat) + " and t_SRFTSTaskItem.RealTime>= to_date('%1$s','yyyy-MM-DD HH24:MI:SS') and  t_SRFTSTaskItem.RealTime<= to_date('%2$s','yyyy-MM-DD HH24:MI:SS') ";
        String strSql = StringHelper.Format((String)strSqlFormat, (Object)DateParser.toDateTimeString((Date)dtStartTime), (Object)DateParser.toDateTimeString((Date)dtEndTime));
        return this.SelectRaw(strSql, list, TSTaskItem.class.getName(), "");
    }

    @Override
    public CallResult PrepareRunTaskItem(TSTaskItem taskItem) {
        BaseDataEntity dataEntity;
        String strSqlFormat = " ";
        strSqlFormat = String.valueOf(strSqlFormat) + " select count(*) as RDCOUNT  from t_SRFTSTaskItem  ";
        strSqlFormat = String.valueOf(strSqlFormat) + " INNER JOIN t_SRFTSTask ON t_SRFTSTaskItem.Tstaskid = t_SRFTSTask.Tstaskid and t_SRFTSTask.Taskstate = 1 and t_SRFTSTask.Enable = 1 ";
        strSqlFormat = String.valueOf(strSqlFormat) + " and t_SRFTSTaskItem.REALSTARTTIME IS NULL and ( t_SRFTSTaskItem.ISCANCEL IS NULL OR t_SRFTSTaskItem.ISCANCEL <> 1) ";
        String strSql = StringHelper.Format((String)(strSqlFormat = String.valueOf(strSqlFormat) + " and t_SRFTSTaskItem.TSTASKITEMID = '%1$s' "), (Object)taskItem.getTSTASKITEMID());
        CallResult callResult = this.SelectRaw(strSql, dataEntity = new BaseDataEntity(), "");
        if (callResult == null || callResult.getRetCode() != 0) {
            return callResult;
        }
        callResult.setUserObject((Object)(dataEntity.GetParamIntValue("RDCOUNT", 0) == 1 ? 1 : 0));
        return callResult;
    }

    @Override
    public CallResult StartRunTaskItem(TSTaskItem taskItem) {
        String strSqlFormat = " ";
        strSqlFormat = String.valueOf(strSqlFormat) + " update  t_SRFTSTaskItem set REALSTARTTIME = sysdate,updatedate=sysdate where ";
        strSqlFormat = String.valueOf(strSqlFormat) + " TSTASKITEMID = '%1$s' ";
        String strSql = StringHelper.Format((String)strSqlFormat, (Object)taskItem.getTSTASKITEMID());
        return this.ExecRawSql(strSql);
    }

    @Override
    public CallResult FinishRunTaskItem(TSTaskItem taskItem, CallResult runResult) {
        String strSqlFormat = " ";
        strSqlFormat = String.valueOf(strSqlFormat) + " update  t_SRFTSTaskItem set REALENDTIME = sysdate,updatedate=sysdate,RETCODE=%2$s,RUNRESULT='%3$s',ISFINISH=1 where ";
        strSqlFormat = String.valueOf(strSqlFormat) + " TSTASKITEMID = '%1$s' ";
        String strSql = StringHelper.Format((String)strSqlFormat, (Object)taskItem.getTSTASKITEMID(), (Object)runResult.getRetCode(), (Object)runResult.getErrorInfo());
        return this.ExecRawSql(strSql);
    }

    @Override
    public CallResult AddTaskItem(TSTaskItem taskItem, String strOpPersonId) {
        return this.Insert("TSTASK.TSTASKITEM_INSERTEX", taskItem, strOpPersonId);
    }

    protected CallResult Insert(String strDBCallId, BaseDataEntity dataEntity, String strOpPersonId) {
        CallResult callResult = new CallResult();
        callResult.setRetCode(1);
        try {
            InsertResult insertResult = this.dbCallerHelper.InsertCmd(strDBCallId, dataEntity.getTotalParamList(), strOpPersonId);
            if (insertResult == null) {
                callResult.setErrorInfo(StringHelper.Format((String)"\u6570\u636e\u8c03\u7528\u8fd4\u56de\u7a7a\u5bf9\u8c61"));
                callResult.setRetCode(1);
            } else if (insertResult.getMainTable().GetRowCount() != 0) {
                dataEntity.FromDataRow(insertResult.getMainTable().GetRow(0), true);
                callResult.From((DBResult)insertResult);
                callResult.setUserObject((Object)insertResult);
            } else {
                callResult.setRetCode(3);
                callResult.setUserObject((Object)insertResult);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
        }
        return callResult;
    }

    protected CallResult Update(String strDBCallId, BaseDataEntity dataEntity, String strOpPersonId) {
        CallResult callResult = new CallResult();
        callResult.setRetCode(1);
        try {
            UpdateResult updateResult = this.dbCallerHelper.UpdateCmd(strDBCallId, dataEntity.getTotalParamList(), strOpPersonId);
            if (updateResult == null) {
                callResult.setErrorInfo(StringHelper.Format((String)"\u6570\u636e\u8c03\u7528\u8fd4\u56de\u7a7a\u5bf9\u8c61"));
                callResult.setRetCode(1);
            } else if (updateResult.getMainTable().GetRowCount() != 0) {
                dataEntity.FromDataRow(updateResult.getMainTable().GetRow(0), true);
                callResult.From((DBResult)updateResult);
                callResult.setUserObject((Object)updateResult);
            } else {
                callResult.setRetCode(3);
                callResult.setUserObject((Object)updateResult);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
        }
        return callResult;
    }

    protected CallResult SelectRaw(String strSQL, BaseDataEntity dataEntity, String strOpPersonId) {
        CallResult callResult = new CallResult();
        try {
            SelectResult selectResult = this.dbCallerHelper.CallRaw2(strSQL);
            if (selectResult == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u4e0d\u660e\u9519\u8bef");
                return callResult;
            }
            if (selectResult.getRetCode() != 0) {
                callResult.From((DBResult)selectResult);
                return callResult;
            }
            if (selectResult.getMainTable() == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u6ca1\u6709\u8fd4\u56de\u6570\u636e\u8868\u5bf9\u8c61");
                return callResult;
            }
            if (selectResult.getMainTable().GetRowCount() == 0) {
                callResult.setRetCode(3);
                return callResult;
            }
            dataEntity.FromDataRow(selectResult.getMainTable().GetRow(0));
            callResult.setRetCode(0);
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected CallResult SelectRaw(String strSQL, ArrayList dataEntities, String strObject, String strOpPersonId) {
        CallResult callResult = new CallResult();
        try {
            SelectResult selectResult = this.dbCallerHelper.CallRaw2(strSQL);
            if (selectResult == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u4e0d\u660e\u9519\u8bef");
                return callResult;
            }
            if (selectResult.getRetCode() != 0) {
                callResult.From((DBResult)selectResult);
                return callResult;
            }
            if (selectResult.getMainTable() == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u6ca1\u6709\u8fd4\u56de\u6570\u636e\u8868\u5bf9\u8c61");
                return callResult;
            }
            int nCount = selectResult.getMainTable().GetRowCount();
            int i = 0;
            while (i < nCount) {
                Object obj;
                BaseDataEntity dataEntity = null;
                if (!StringHelper.IsNullOrEmpty((String)strObject) && (obj = ObjectHelper.Create((String)strObject)) != null && obj instanceof BaseDataEntity) {
                    dataEntity = (BaseDataEntity)obj;
                }
                if (dataEntity == null) {
                    dataEntity = new BaseDataEntity();
                }
                dataEntity.FromDataRow(selectResult.getMainTable().GetRow(i));
                dataEntities.add(dataEntity);
                ++i;
            }
            callResult.setRetCode(0);
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    public CallResult ExecRawSql(String strSQL) {
        CallResult callResult = new CallResult();
        try {
            ArrayList<String> arrList = new ArrayList<String>();
            arrList.add(strSQL);
            DBResult dbResult = this.dbCallerHelper.RawCmdEx(arrList, "");
            if (dbResult == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u4e0d\u660e\u9519\u8bef");
                return callResult;
            }
            callResult.From(dbResult);
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }
}

