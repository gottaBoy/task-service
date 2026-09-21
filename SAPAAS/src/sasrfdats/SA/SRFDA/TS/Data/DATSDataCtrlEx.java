/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.DataEx.BaseDBCallerHelperEx
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.Utility.ISRFExGlobalHelper
 *  SRFTS.Ctrl.Data.TSSchedule
 *  SRFTS.Ctrl.Data.TSTaskItem
 *  SRFTS.Ctrl.ITSDataCtrl
 *  javax.servlet.ServletContext
 */
package SA.SRFDA.TS.Data;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.DataEx.BaseDBCallerHelperEx;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Utility.ISRFExGlobalHelper;
import SRFTS.Ctrl.Data.TSSchedule;
import SRFTS.Ctrl.Data.TSTaskItem;
import SRFTS.Ctrl.ITSDataCtrl;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.servlet.ServletContext;

public class DATSDataCtrlEx
implements ITSDataCtrl {
    protected BaseDBCallerHelperEx dbCallerHelper;
    protected ISRFDAGlobalHelper iDAGlobalHelper;
    private static final String TSTASKITEM = "TS0003";
    boolean bHasTaskParam5 = false;

    public boolean Init(ServletContext servletContext, BaseDBCallerHelperEx dbCallerHelper) {
        this.dbCallerHelper = dbCallerHelper;
        this.iDAGlobalHelper = (ISRFDAGlobalHelper)servletContext.getAttribute("SRFDACONTEXTHELPER");
        IDEHelper iDEHelper = this.iDAGlobalHelper.getDAModelStorage().FindDEHelper("TS0001");
        if (iDEHelper == null) {
            return false;
        }
        this.bHasTaskParam5 = iDEHelper.GetDEFHelper("TASKPARAM5") != null;
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
        strSqlFormat = String.valueOf(strSqlFormat) + " t_SRFTSSchedule.ScheduleState = 1 AND  ((t_SRFTSSchedule.Scheduletype = 1 and t_SRFTSSchedule.Rundate>=? and t_SRFTSSchedule.Rundate<=?) ";
        strSqlFormat = String.valueOf(strSqlFormat) + " OR (t_SRFTSSchedule.Scheduletype<>1 and t_SRFTSSchedule.Cyclestarttime < ?  AND  (t_SRFTSSchedule.Cycleendtime IS NULL OR t_SRFTSSchedule.Cycleendtime >?))) ";
        CallParamList callParamList = new CallParamList();
        callParamList.AddDate((Object)dtStartTime);
        callParamList.AddDate((Object)dtEndTime);
        callParamList.AddDateTime((Object)dtEndTime);
        callParamList.AddDateTime((Object)dtStartTime);
        Vector list2 = new Vector();
        CallResult callResult = BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)strSqlFormat, (Vector)callParamList.GetList(), list2, (String)TSSchedule.class.getName());
        if (callResult.IsError()) {
            return callResult;
        }
        for (TSSchedule tsSchedule : list2) {
            list.add(tsSchedule);
        }
        return callResult;
    }

    public CallResult GetTaskItems(Date dtStartTime, Date dtEndTime, ArrayList<TSTaskItem> list) {
        String strSqlFormat = " ";
        strSqlFormat = this.bHasTaskParam5 ? String.valueOf(strSqlFormat) + " select t_SRFTSTaskItem.*,t_SRFTSTaskItem.TSTASKITEMNAME AS TASKITEMINFO,t_SRFTSTask.Taskobject,t_SRFTSTask.TaskParam,t_SRFTSTask.TaskParam2,t_SRFTSTask.TaskParam3,t_SRFTSTask.TaskParam4,t_SRFTSTask.TaskParam5 from t_SRFTSTaskItem  " : String.valueOf(strSqlFormat) + " select t_SRFTSTaskItem.*,t_SRFTSTaskItem.TSTASKITEMNAME AS TASKITEMINFO,t_SRFTSTask.Taskobject,t_SRFTSTask.TaskParam,t_SRFTSTask.TaskParam2,t_SRFTSTask.TaskParam3,t_SRFTSTask.TaskParam4 from t_SRFTSTaskItem  ";
        strSqlFormat = String.valueOf(strSqlFormat) + " INNER JOIN t_SRFTSTask ON t_SRFTSTaskItem.Tstaskid = t_SRFTSTask.Tstaskid and t_SRFTSTask.Taskstate = 1 and t_SRFTSTask.Enable = 1 ";
        strSqlFormat = String.valueOf(strSqlFormat) + " and REALSTARTTIME IS NULL and ( ISCANCEL IS NULL OR ISCANCEL <> 1) ";
        strSqlFormat = String.valueOf(strSqlFormat) + " and t_SRFTSTaskItem.RealTime>= ? and  t_SRFTSTaskItem.RealTime<= ?";
        strSqlFormat = String.valueOf(strSqlFormat) + " ORDER BY t_SRFTSTaskItem.RealTime ";
        CallParamList callParamList = new CallParamList();
        callParamList.AddDateTime((Object)dtStartTime);
        callParamList.AddDateTime((Object)dtEndTime);
        Vector list2 = new Vector();
        CallResult callResult = BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)strSqlFormat, (Vector)callParamList.GetList(), list2, (String)TSTaskItem.class.getName());
        if (callResult.IsError()) {
            return callResult;
        }
        for (TSTaskItem taskItem : list2) {
            list.add(taskItem);
        }
        return callResult;
    }

    public CallResult PrepareRunTaskItem(TSTaskItem taskItem) {
        BaseDataEntity dataEntity;
        String strSqlFormat = " ";
        strSqlFormat = String.valueOf(strSqlFormat) + " select count(*) as RDCOUNT  from t_SRFTSTaskItem  ";
        strSqlFormat = String.valueOf(strSqlFormat) + " INNER JOIN t_SRFTSTask ON t_SRFTSTaskItem.Tstaskid = t_SRFTSTask.Tstaskid and t_SRFTSTask.Taskstate = 1 and t_SRFTSTask.Enable = 1 ";
        strSqlFormat = String.valueOf(strSqlFormat) + " and t_SRFTSTaskItem.REALSTARTTIME IS NULL and ( t_SRFTSTaskItem.ISCANCEL IS NULL OR t_SRFTSTaskItem.ISCANCEL <> 1) ";
        String strSql = StringHelper.Format((String)(strSqlFormat = String.valueOf(strSqlFormat) + " and t_SRFTSTaskItem.TSTASKITEMID = '%1$s' "), (Object)taskItem.getTSTASKITEMID());
        CallResult callResult = BaseDEDataCtrl.SelectSingle((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)strSql, (BaseDataEntity)(dataEntity = new BaseDataEntity()));
        if (callResult == null || callResult.getRetCode() != 0) {
            return callResult;
        }
        callResult.setUserObject((Object)(dataEntity.GetParamIntValue("RDCOUNT", 0) == 1 ? 1 : 0));
        return callResult;
    }

    public CallResult StartRunTaskItem(TSTaskItem taskItem) {
        String strSqlFormat = " ";
        strSqlFormat = String.valueOf(strSqlFormat) + " update  t_SRFTSTaskItem set REALSTARTTIME = ? ,updatedate=? where ";
        strSqlFormat = String.valueOf(strSqlFormat) + " TSTASKITEMID = '%1$s' ";
        Date curDate = new Date();
        CallParamList callParamList = new CallParamList();
        callParamList.AddDateTime((Object)curDate);
        callParamList.AddDateTime((Object)curDate);
        String strSql = StringHelper.Format((String)strSqlFormat, (Object)taskItem.getTSTASKITEMID());
        return BaseDEDataCtrl.ExecuteWithoutResult((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)strSql, (Vector)callParamList.GetList());
    }

    public CallResult FinishRunTaskItem(TSTaskItem taskItem, CallResult runResult) {
        String strSqlFormat = " ";
        strSqlFormat = String.valueOf(strSqlFormat) + " update  t_SRFTSTaskItem set REALENDTIME = ? ,updatedate= ? ,RETCODE=%2$s,RUNRESULT='%3$s',ISFINISH=1 where ";
        strSqlFormat = String.valueOf(strSqlFormat) + " TSTASKITEMID = '%1$s' ";
        String strSql = StringHelper.Format((String)strSqlFormat, (Object)taskItem.getTSTASKITEMID(), (Object)runResult.getRetCode(), (Object)runResult.getErrorInfo());
        Date curDate = new Date();
        CallParamList callParamList = new CallParamList();
        callParamList.AddDateTime((Object)curDate);
        callParamList.AddDateTime((Object)curDate);
        return BaseDEDataCtrl.ExecuteWithoutResult((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)strSql, (Vector)callParamList.GetList());
    }

    public CallResult AddTaskItem(TSTaskItem taskItem, String strOpPersonId) {
        CallResult callResult = new CallResult();
        taskItem.SetParamValue("TSTASKITEMNAME", (Object)taskItem.getTASKITEMINFO());
        IDEDataCtrl oppDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEHelper(TSTASKITEM).GetDEDataCtrl("SYSTEM", null);
        if (oppDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)TSTASKITEM));
            return callResult;
        }
        callResult = oppDataCtrl.Save(true, (BaseDataEntity)taskItem);
        if (callResult.getRetCode() != 0) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u5931\u8d25\uff1a%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        callResult.setRetCode(0);
        return callResult;
    }
}

