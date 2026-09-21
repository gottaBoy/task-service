/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.DataEx.BaseDBCallerHelperEx
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.DateParser
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  SA.SRFramework.WebEx.Utility.ISRFExGlobalHelper
 *  SRFTS.Ctrl.Data.TSSchedule
 *  SRFTS.Ctrl.Data.TSTaskItem
 *  SRFTS.Ctrl.ITSDataCtrl
 *  javax.servlet.ServletContext
 */
package SA.SRFDA.TS.Data;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.SelectResult;
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

public class DATSDataCtrl
implements ITSDataCtrl {
    protected BaseDBCallerHelperEx dbCallerHelper;
    protected ServletContext servletContext;
    protected ISRFDAGlobalHelper iDAGlobalHelper;
    private static final String TSTASKITEM = "TS0003";

    public boolean Init(ServletContext servletContext, BaseDBCallerHelperEx dbCallerHelper) {
        this.dbCallerHelper = dbCallerHelper;
        this.iDAGlobalHelper = (ISRFDAGlobalHelper)servletContext.getAttribute("SRFDACONTEXTHELPER");
        return true;
    }

    public boolean Init(ISRFExGlobalHelper iGlobalHelper, BaseDBCallerHelperEx dbCallerHelper) {
        this.dbCallerHelper = dbCallerHelper;
        this.iDAGlobalHelper = (ISRFDAGlobalHelper)iGlobalHelper;
        return true;
    }

    public CallResult GetSchedule(String strTaskId, Date dtStartTime, Date dtEndTime, ArrayList<TSSchedule> list) {
        String strSqlFormat = " ";
        strSqlFormat = String.valueOf(strSqlFormat) + " select t_SRFTSSchedule.*,t_SRFTSTask.Taskobject,t_SRFTSTask.TSTaskName from t_SRFTSSchedule ";
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

    public CallResult GetTaskItems(Date dtStartTime, Date dtEndTime, ArrayList<TSTaskItem> list) {
        String strSqlFormat = " ";
        strSqlFormat = String.valueOf(strSqlFormat) + " select t_SRFTSTaskItem.*,t_SRFTSTask.Taskobject,t_SRFTSTask.TaskParam,t_SRFTSTask.TaskParam2,t_SRFTSTask.TaskParam3,t_SRFTSTask.TaskParam4 from t_SRFTSTaskItem  ";
        strSqlFormat = String.valueOf(strSqlFormat) + " INNER JOIN t_SRFTSTask ON t_SRFTSTaskItem.Tstaskid = t_SRFTSTask.Tstaskid and t_SRFTSTask.Taskstate = 1 and t_SRFTSTask.Enable = 1 ";
        strSqlFormat = String.valueOf(strSqlFormat) + " and REALSTARTTIME IS NULL and ( ISCANCEL IS NULL OR ISCANCEL <> 1) ";
        strSqlFormat = String.valueOf(strSqlFormat) + " and t_SRFTSTaskItem.RealTime>= to_date('%1$s','yyyy-MM-DD HH24:MI:SS') and  t_SRFTSTaskItem.RealTime<= to_date('%2$s','yyyy-MM-DD HH24:MI:SS') ";
        String strSql = StringHelper.Format((String)strSqlFormat, (Object)DateParser.toDateTimeString((Date)dtStartTime), (Object)DateParser.toDateTimeString((Date)dtEndTime));
        return this.SelectRaw(strSql, list, TSTaskItem.class.getName(), "");
    }

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

    public CallResult StartRunTaskItem(TSTaskItem taskItem) {
        String strSqlFormat = " ";
        strSqlFormat = String.valueOf(strSqlFormat) + " update  t_SRFTSTaskItem set REALSTARTTIME = sysdate,updatedate=sysdate where ";
        strSqlFormat = String.valueOf(strSqlFormat) + " TSTASKITEMID = '%1$s' ";
        String strSql = StringHelper.Format((String)strSqlFormat, (Object)taskItem.getTSTASKITEMID());
        return this.ExecRawSql(strSql);
    }

    public CallResult FinishRunTaskItem(TSTaskItem taskItem, CallResult runResult) {
        String strSqlFormat = " ";
        strSqlFormat = String.valueOf(strSqlFormat) + " update  t_SRFTSTaskItem set REALENDTIME = sysdate,updatedate=sysdate,RETCODE=%2$s,RUNRESULT='%3$s',ISFINISH=1 where ";
        strSqlFormat = String.valueOf(strSqlFormat) + " TSTASKITEMID = '%1$s' ";
        String strSql = StringHelper.Format((String)strSqlFormat, (Object)taskItem.getTSTASKITEMID(), (Object)runResult.getRetCode(), (Object)runResult.getErrorInfo());
        return this.ExecRawSql(strSql);
    }

    public CallResult AddTaskItem(TSTaskItem taskItem, String strOpPersonId) {
        return this.Insert("TSTASK.TSTASKITEM_INSERTEX", (BaseDataEntity)taskItem, strOpPersonId);
    }

    protected CallResult Insert(String strDBCallId, BaseDataEntity dataEntity, String strOpPersonId) {
        CallResult callResult = new CallResult();
        IDEDataCtrl oppDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEHelper(TSTASKITEM).GetDEDataCtrl("SYSTEM", null);
        if (oppDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)TSTASKITEM));
            return callResult;
        }
        callResult = oppDataCtrl.Save(true, dataEntity);
        if (callResult.getRetCode() != 0) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u5931\u8d25\uff1a%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        callResult.setRetCode(0);
        return callResult;
    }

    protected CallResult Update(String strDBCallId, BaseDataEntity dataEntity, String strOpPersonId) {
        CallResult callResult = new CallResult();
        IDEDataCtrl oppDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEHelper(TSTASKITEM).GetDEDataCtrl("SYSTEM", null);
        if (oppDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)TSTASKITEM));
            return callResult;
        }
        callResult = oppDataCtrl.Save(false, dataEntity);
        if (callResult.getRetCode() != 0) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u5931\u8d25\uff1a%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        callResult.setRetCode(0);
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

