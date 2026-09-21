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
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  javax.servlet.ServletContext
 */
package SRFWF.Ctrl.Data.Oracle;

import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.InsertResult;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.Data.UpdateResult;
import SA.SRFramework.DataEx.BaseDBCallerHelperEx;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SRFWF.Client.WFParam;
import SRFWF.Ctrl.Data.WFAction;
import SRFWF.Ctrl.Data.WFActor;
import SRFWF.Ctrl.Data.WFIAAction;
import SRFWF.Ctrl.Data.WFInstance;
import SRFWF.Ctrl.Data.WFStep;
import SRFWF.Ctrl.Data.WFStepActor;
import SRFWF.Ctrl.Data.WFStepData;
import SRFWF.Ctrl.Data.WFTmpStepActor;
import SRFWF.Ctrl.Data.WFUser;
import SRFWF.Ctrl.Data.WFUserAssist;
import SRFWF.Ctrl.Data.WFWorkflow;
import SRFWF.Ctrl.ISRFWFContext;
import SRFWF.Ctrl.ISRFWFDataCtrl;
import SRFWF.Model.WFEmbedWorkflowConfig;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Vector;
import javax.servlet.ServletContext;

public class OraWFDataCtrl
implements ISRFWFDataCtrl {
    protected BaseDBCallerHelperEx dbCallerHelper = null;
    protected ServletContext servletContext = null;

    @Override
    public void Init(ServletContext servletContext, BaseDBCallerHelperEx dbCallerHelper) {
        this.dbCallerHelper = dbCallerHelper;
        this.servletContext = servletContext;
    }

    @Override
    public CallResult GetWFWorkflow(String strWorkflowId, WFWorkflow workflow) {
        String strSql = StringHelper.Format((String)"select * from t_srfwfworkflow where Enable = 1 AND UPPER(wfworkflowid)=UPPER('%1$s')", (Object)strWorkflowId);
        return this.SelectRaw(strSql, workflow, "");
    }

    @Override
    public CallResult GetWFInstance(String strInstanceId, WFInstance instance) {
        String strSql = StringHelper.Format((String)"select * from t_srfwfinstance where  UPPER(WFINSTANCEID)=UPPER('%1$s')", (Object)strInstanceId);
        return this.SelectRaw(strSql, instance, "");
    }

    @Override
    public CallResult GetWFIAAction(String strWFStepId, String strActionName, WFIAAction iaAction) {
        String strSql = StringHelper.Format((String)"select * from t_srfwfIAAction where  UPPER(WFSTEPID)=UPPER('%1$s') AND UPPER(ACTIONNAME) = UPPER('%2$s')", (Object)strWFStepId, (Object)strActionName);
        return this.SelectRaw(strSql, iaAction, "");
    }

    @Override
    public CallResult GetWFAction(String strWFID, String strWFActionId, WFAction action) {
        String strSql = StringHelper.Format((String)"select * from t_srfwfAction where  UPPER(WFWorkflowId)=UPPER('%1$s') AND UPPER(ACTIONNAME) = UPPER('%2$s')", (Object)strWFID, (Object)strWFActionId);
        return this.SelectRaw(strSql, action, "");
    }

    @Override
    public CallResult GetWFStepDataCount(String strWFStepId, String strActionName) {
        BaseDataEntity baseDataEntity;
        String strSql = StringHelper.Format((String)"select count(*) as RDCOUNT from t_srfwfSTEPDATA where  UPPER(WFSTEPID)=UPPER('%1$s') AND UPPER(CONNECTIONNAME) = UPPER('%2$s')", (Object)strWFStepId, (Object)strActionName);
        CallResult callResult = this.SelectRaw(strSql, baseDataEntity = new BaseDataEntity(), "");
        if (callResult == null || callResult.getRetCode() != 0) {
            return callResult;
        }
        callResult.setUserObject((Object)baseDataEntity.GetParamIntValue("RDCOUNT", 0));
        return callResult;
    }

    @Override
    public CallResult GetWFStepActorCount(String strWFStepId) {
        BaseDataEntity baseDataEntity;
        String strSql = StringHelper.Format((String)"select count(*) as RDCOUNT from t_srfwfSTEPACTOR where  UPPER(WFSTEPID)=UPPER('%1$s')", (Object)strWFStepId);
        CallResult callResult = this.SelectRaw(strSql, baseDataEntity = new BaseDataEntity(), "");
        if (callResult == null || callResult.getRetCode() != 0) {
            return callResult;
        }
        callResult.setUserObject((Object)baseDataEntity.GetParamIntValue("RDCOUNT", 0));
        return callResult;
    }

    @Override
    public CallResult GetWFStepRoleCount(String strWFStepId) {
        BaseDataEntity baseDataEntity;
        String strSql = StringHelper.Format((String)"select count(*) as RDCOUNT (select distinct ROLEID  from t_srfwfSTEPACTOR where  UPPER(WFSTEPID)=UPPER('%1$s')) a", (Object)strWFStepId);
        CallResult callResult = this.SelectRaw(strSql, baseDataEntity = new BaseDataEntity(), "");
        if (callResult == null || callResult.getRetCode() != 0) {
            return callResult;
        }
        callResult.setUserObject((Object)baseDataEntity.GetParamIntValue("RDCOUNT", 0));
        return callResult;
    }

    @Override
    public CallResult GetWFStepActor(String strWFStepId, Vector<WFStepActor> list) {
        String strSql = StringHelper.Format((String)"select * from t_srfwfSTEPACTOR where  UPPER(WFSTEPID)=UPPER('%1$s')", (Object)strWFStepId);
        return this.SelectRaw(strSql, list, WFStepActor.class.getName(), "");
    }

    @Override
    public CallResult GetWFStepData(String strWFStepId, Vector<WFStepData> list) {
        String strSql = StringHelper.Format((String)"select * from t_srfwfSTEPDATA where  UPPER(WFSTEPID)=UPPER('%1$s') AND CONNECTIONNAME <> 'SRFWFRESUBMIT'", (Object)strWFStepId);
        return this.SelectRaw(strSql, list, WFStepData.class.getName(), "");
    }

    @Override
    public CallResult RemoveNoDataWFStepActor(String strWFStepId, String strRoleId) {
        String strSql = "delete from t_SRFWFSTEPACTOR t1 where UPPER(t1.WFSTEPID)='%1$s' AND UPPER(t1.ROLEID)='%2$s' AND NOT EXISTS(SELECT * from  T_SRFWFSTEPDATA t2 where t1.WFSTEPID = t2.WFSTEPID AND t1.ACTORID = t2.ACTORID)";
        return this.ExecRawSql(strSql);
    }

    @Override
    public CallResult GetWFInstance(String strWorkFlowId, String strUserData, String strUserData2, String strUserData3, String strUserData4, WFInstance instance) {
        String strSql = StringHelper.Format((String)"select * from t_srfwfinstance where  UPPER(WFWorkflowId)=UPPER('%1$s') ", (Object)strWorkFlowId);
        strSql = StringHelper.IsNullOrEmpty((String)strUserData) ? String.valueOf(strSql) + " AND (USERDATA IS NULL) " : String.valueOf(strSql) + StringHelper.Format((String)" AND (USERDATA = '%1$s') ", (Object)strUserData);
        strSql = StringHelper.IsNullOrEmpty((String)strUserData2) ? String.valueOf(strSql) + " AND (USERDATA2 IS NULL) " : String.valueOf(strSql) + StringHelper.Format((String)" AND (USERDATA2 = '%1$s') ", (Object)strUserData2);
        strSql = StringHelper.IsNullOrEmpty((String)strUserData3) ? String.valueOf(strSql) + " AND (USERDATA3 IS NULL) " : String.valueOf(strSql) + StringHelper.Format((String)" AND (USERDATA3 = '%1$s') ", (Object)strUserData3);
        strSql = StringHelper.IsNullOrEmpty((String)strUserData4) ? String.valueOf(strSql) + " AND (USERDATA4 IS NULL) " : String.valueOf(strSql) + StringHelper.Format((String)" AND (USERDATA4 = '%1$s') ", (Object)strUserData4);
        return this.SelectRaw(strSql, instance, "");
    }

    @Override
    public CallResult GetWFUserData(String strSql, BaseDataEntity userData) {
        return this.SelectRaw(strSql, userData, "");
    }

    @Override
    public CallResult GetWFUserData(WFWorkflow workflow, WFParam wpParam, BaseDataEntity userData) {
        CallResult callResult = new CallResult();
        callResult.setRetCode(20);
        return callResult;
    }

    @Override
    public CallResult UpdateWFUserDataRunStep(WFInstance wfInstance, String strCodeItemValue, String strOpPersonId) {
        CallResult callResult = new CallResult();
        callResult.setRetCode(20);
        return callResult;
    }

    @Override
    public CallResult AddWFInstance(WFInstance instance, String strOpPersonId) {
        return this.Insert("WFWORKFLOW.WFINSTANCE_INSERTEX", instance, strOpPersonId);
    }

    @Override
    public CallResult FinishWFInstance(WFInstance instance, String strOpPersonId) {
        return this.Update("WFWORKFLOW.WFINSTANCE_FINISHEX", instance, strOpPersonId);
    }

    @Override
    public CallResult ResetWFInstance(WFInstance instance, String strOpPersonId) {
        return this.Update("WFWORKFLOW.WFINSTANCE_RESETEX", instance, strOpPersonId);
    }

    @Override
    public CallResult UserCloseWFInstance(WFInstance instance, String strOpPersonId) {
        return this.Update("WFWORKFLOW.WFINSTANCE_USERCLOSE", instance, strOpPersonId);
    }

    @Override
    public CallResult AddWFStep(WFStep step, String strOpPersonId) {
        return this.Insert("WFWORKFLOW.WFSTEP_INSERTEX", step, strOpPersonId);
    }

    @Override
    public CallResult AddWFStepData(WFStepData stepData, String strOpPersonId) {
        return this.Insert("WFWORKFLOW.WFSTEPDATA_INSERTEX", stepData, strOpPersonId);
    }

    @Override
    public CallResult TestWFStepData(WFStepData stepData, String strOpPersonId) {
        CallResult callResult = new CallResult();
        callResult.setRetCode(20);
        return callResult;
    }

    @Override
    public CallResult FinishWFStep(WFStep step, String strOpPersonId) {
        return this.Update("WFWORKFLOW.WFSTEP_FINISHEX", step, strOpPersonId);
    }

    @Override
    public CallResult AddWFStepActor(WFStepActor stepActor, String strOpPersonId) {
        return this.Insert("WFWORKFLOW.WFSTEPACTOR_INSERTEX", stepActor, strOpPersonId);
    }

    @Override
    public CallResult AddWFIAAction(WFIAAction iaAction, String strOpPersonId) {
        return this.Insert("WFWORKFLOW.WFIAACTION_INSERTEX", iaAction, strOpPersonId);
    }

    @Override
    public CallResult GetWFActor(String strActorId, WFActor wfActor) {
        String strSql = StringHelper.Format((String)"select * from T_SRFWFACTOR where UPPER(WFACTORID)=UPPER('%1$s')", (Object)strActorId);
        return this.SelectRaw(strSql, wfActor, "");
    }

    @Override
    public CallResult GetWFUserGroupDetail(String strActorId, Vector<WFUser> list) {
        String strSql = StringHelper.Format((String)"select t1.* from t_SRFWFUSER t1 INNER JOIN T_SRFWFUSERGROUPDETAIL t2 ON t1.WFUSERID=t2.WFUSERID WHERE UPPER(t2.WFUSERGROUPID)= '%1$s'", (Object)strActorId.toUpperCase());
        return this.SelectRaw(strSql, list, WFUser.class.getName(), "");
    }

    @Override
    public CallResult TestIAAction(String strStepId, String strActionName, String strOpPersonId) {
        BaseDataEntity baseDataEntity;
        String strSql = StringHelper.Format((String)"select count(*) as RDCOUNT from t_srfwfiaaction where  UPPER(WFSTEPID)=UPPER('%1$s') and UPPER(ACTIONNAME) = UPPER('%1$s')", (Object)strStepId, (Object)strActionName);
        CallResult callResult = this.SelectRaw(strSql, baseDataEntity = new BaseDataEntity(), strOpPersonId);
        if (callResult == null || callResult.getRetCode() != 0) {
            return callResult;
        }
        callResult.setUserObject((Object)(baseDataEntity.GetParamIntValue("RDCOUNT", 0) == 1 ? 1 : 0));
        return callResult;
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

    protected CallResult SelectRaw(String strSQL, Vector dataEntities, String strObject, String strOpPersonId) {
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

    @Override
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

    @Override
    public CallResult ErrorWFInstance(WFInstance instance, String strErrorInfo, String strOpPersonId) {
        return new CallResult();
    }

    @Override
    public CallResult RemoveWFInstance(WFInstance instance, String strOpPersonId) {
        return new CallResult();
    }

    @Override
    public CallResult GetWFUserAssist(String strWFStepActorId, String strAssistUserId, String strWorkflowId, WFUserAssist userAssist) {
        String strSqlFormat = "select t1.* from T_SRFWFUSERASSIST t1 INNER JOIN T_SRFWFSTEPACTOR t2\t\tON t1.WFMAJORUSERID = t2.ACTORID WHERE UPPER(t1.WFMINORUSERID) = '%1$s' AND t2.WFSTEPACTORID='%2$s' AND WFWORKFLOWID='%3$s'";
        String strSql = StringHelper.Format((String)strSqlFormat, (Object)strAssistUserId.toUpperCase(), (Object)strWFStepActorId.toUpperCase(), (Object)strWorkflowId.toUpperCase());
        return this.SelectRaw(strSql, userAssist, "");
    }

    @Override
    public CallResult GetWFUserAssists(WFInstance instance, String strWFStepActorId, String strAssistUserId, String strWorkflowId, Vector<WFUserAssist> userAssists) {
        String strSqlFormat = "select t1.* from T_SRFWFUSERASSIST t1 INNER JOIN T_SRFWFSTEPACTOR t2\t\tON t1.WFMAJORUSERID = t2.ACTORID WHERE UPPER(t1.WFMINORUSERID) = '%1$s' AND UPPER(t2.WFSTEPACTORID)='%2$s' AND UPPER(WFWORKFLOWID)='%3$s'";
        String strSql = StringHelper.Format((String)strSqlFormat, (Object)strAssistUserId.toUpperCase(), (Object)strWFStepActorId.toUpperCase(), (Object)strWorkflowId.toUpperCase());
        return this.SelectRaw(strSql, userAssists, WFUserAssist.class.getName(), "");
    }

    @Override
    public CallResult CalcTimeout(Timestamp srcTime, String strTimeoutType, int nValue, String strWorkdayType) {
        CallResult callResult = new CallResult();
        callResult.setRetCode(20);
        return callResult;
    }

    @Override
    public CallResult SendWFStepActorInformMsg(Vector<String> actors, WFInstance wfInstane, String strMsgTemplateId, int nMsgType) {
        CallResult callResult = new CallResult();
        callResult.setRetCode(20);
        return callResult;
    }

    @Override
    public CallResult AddWFTmpStepActors(Vector<WFTmpStepActor> tmpStepActors, String strOpPersonId) {
        CallResult callResult = new CallResult();
        callResult.setRetCode(20);
        return callResult;
    }

    @Override
    public CallResult RemoveWFTmpStepActors(String strWFStepId, String strOpPersonId) {
        CallResult callResult = new CallResult();
        callResult.setRetCode(20);
        return callResult;
    }

    @Override
    public boolean isMultiUse() {
        return false;
    }

    public CallResult StartEmbedWorkflow(ISRFWFContext wfContext, WFEmbedWorkflowConfig embedWorkflowConfig, Vector<WFInstance> wfInstances) {
        CallResult callResult = new CallResult();
        callResult.setRetCode(20);
        return callResult;
    }

    @Override
    public CallResult GetWFSystemUser(ISRFWFContext iWFContext, String strActorId, Vector<WFUser> list) {
        CallResult callResult = new CallResult();
        callResult.setRetCode(20);
        return callResult;
    }
}

