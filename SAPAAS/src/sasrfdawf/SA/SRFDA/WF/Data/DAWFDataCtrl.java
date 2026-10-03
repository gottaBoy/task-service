/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.DEDataCtrl.DataLockDataCtrl
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Data.DEWF
 *  SA.SRFDA.Ctrl.Data.DataLock
 *  SA.SRFDA.Ctrl.Data.MsgAccount
 *  SA.SRFDA.Ctrl.Data.MsgSendQueue
 *  SA.SRFDA.Ctrl.Data.MsgTemplate
 *  SA.SRFDA.Ctrl.Data.QueryModel
 *  SA.SRFDA.Ctrl.DefaultDAQueryModelUserContext
 *  SA.SRFDA.Ctrl.IDAQueryModelUserContext
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Ctrl.Utility.MacroHelper
 *  SA.SRFDA.MSG.Ctrl.MsgTemplateHelper
 *  SA.SRFDA.Web.Utility.GlobalHelperEx
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.CallParam
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.Data.DataTypeParse
 *  SA.SRFramework.Data.InsertResult
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.Data.UpdateResult
 *  SA.SRFramework.DataEx.BaseDBCallerHelperEx
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SRFWF.Client.WFParam
 *  SRFWF.Ctrl.Data.WFAction
 *  SRFWF.Ctrl.Data.WFActor
 *  SRFWF.Ctrl.Data.WFIAAction
 *  SRFWF.Ctrl.Data.WFInstance
 *  SRFWF.Ctrl.Data.WFStep
 *  SRFWF.Ctrl.Data.WFStepActor
 *  SRFWF.Ctrl.Data.WFStepData
 *  SRFWF.Ctrl.Data.WFTmpStepActor
 *  SRFWF.Ctrl.Data.WFUser
 *  SRFWF.Ctrl.Data.WFUserAssist
 *  SRFWF.Ctrl.Data.WFWorkflow
 *  SRFWF.Ctrl.ISRFWFContext
 *  SRFWF.Ctrl.ISRFWFDataCtrl
 *  javax.servlet.ServletContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.WF.Data;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.DEDataCtrl.DataLockDataCtrl;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.DEWF;
import SA.SRFDA.Ctrl.Data.DataLock;
import SA.SRFDA.Ctrl.Data.MsgAccount;
import SA.SRFDA.Ctrl.Data.MsgSendQueue;
import SA.SRFDA.Ctrl.Data.MsgTemplate;
import SA.SRFDA.Ctrl.Data.QueryModel;
import SA.SRFDA.Ctrl.DefaultDAQueryModelUserContext;
import SA.SRFDA.Ctrl.IDAQueryModelUserContext;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.Utility.MacroHelper;
import SA.SRFDA.MSG.Ctrl.MsgTemplateHelper;
import SA.SRFDA.WF.Data.IDEWFDataCtrlPlugin;
import SA.SRFDA.Web.Utility.GlobalHelperEx;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParam;
import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.Data.InsertResult;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.Data.UpdateResult;
import SA.SRFramework.DataEx.BaseDBCallerHelperEx;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;
import javax.servlet.ServletContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DAWFDataCtrl
implements ISRFWFDataCtrl {
    protected BaseDBCallerHelperEx dbCallerHelper = null;
    protected ServletContext servletContext = null;
    private static final Log log = LogFactory.getLog(DAWFDataCtrl.class);
    public static final String TAG_WFDEID = "WF0001";
    protected GlobalHelperEx globalHelperEx = null;
    protected IDEDataCtrl wfDataCtrl = null;
    protected DataLockDataCtrl dataLockDataCtrl = null;
    protected IDEDataCtrl wfStepActorDataCtrl = null;
    protected IDEDataCtrl wfTmpStepActorDataCtrl = null;
    protected IDEDataCtrl wfstepDataCtrl = null;
    public static final String WFACTION_RESUBMIT = "SRFWFRESUBMIT";
    public static final String WFACTION_TIMEOUT = "SRFWFTIMEOUT";
    public static final String WFACTION_REASSIGN = "SRFWFREASSIGN";

    public void Init(ServletContext servletContext, BaseDBCallerHelperEx dbCallerHelper) {
        this.dbCallerHelper = dbCallerHelper;
        this.servletContext = servletContext;
        this.globalHelperEx = (GlobalHelperEx)servletContext.getAttribute("SRFDACONTEXTHELPER");
        IDEHelper wfDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(TAG_WFDEID);
        if (wfDEHelper == null) {
            log.error((Object)"\u65e0\u6cd5\u83b7\u53d6\u5de5\u4f5c\u6d41\u914d\u7f6e\u5b9e\u4f53\u8f85\u52a9\u5bf9\u8c61");
            return;
        }
        this.wfDataCtrl = wfDEHelper.GetDEDataCtrl("SYSTEM", null);
        if (this.wfDataCtrl == null) {
            log.error((Object)"\u65e0\u6cd5\u83b7\u53d6\u5de5\u4f5c\u6d41\u914d\u7f6e\u5b9e\u4f53\u6570\u636e\u64cd\u4f5c\u5bf9\u8c61");
            return;
        }
        this.dataLockDataCtrl = this.globalHelperEx.getDAModelStorage().GetDataLockDataCtrl();
        if (this.dataLockDataCtrl == null) {
            log.error((Object)"\u65e0\u6cd5\u83b7\u53d6\u6570\u636e\u9501\u8bbf\u95ee\u5bf9\u8c61");
            return;
        }
    }

    public CallResult GetWFWorkflow(String strWorkflowId, WFWorkflow workflow) {
        CallResult callResult = new CallResult();
        if (this.wfDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u5de5\u4f5c\u6d41\u914d\u7f6e\u5b9e\u4f53\u6570\u636e\u64cd\u4f5c\u5bf9\u8c61\u65e0\u6548");
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        workflow.setWFWORKFLOWID(strWorkflowId);
        callResult = this.wfDataCtrl.Get((BaseDataEntity)workflow);
        if (callResult.getRetCode() != 0) {
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        workflow.setWFNAME(workflow.GetParamStringValue("WFWORKFLOWNAME", ""));
        return callResult;
    }

    public CallResult GetWFInstance(String strInstanceId, WFInstance instance) {
        String strSql = StringHelper.Format((String)"select * from t_srfwfinstance where  UPPER(WFINSTANCEID)=UPPER('%1$s')", (Object)strInstanceId);
        return this.SelectRaw(strSql, (BaseDataEntity)instance, "");
    }

    public CallResult GetWFIAAction(String strWFStepId, String strActionName, WFIAAction iaAction) {
        String strSql = StringHelper.Format((String)"select * from t_srfwfIAAction where  UPPER(WFSTEPID)=UPPER('%1$s') AND UPPER(ACTIONNAME) = UPPER('%2$s')", (Object)strWFStepId, (Object)strActionName);
        return this.SelectRaw(strSql, (BaseDataEntity)iaAction, "");
    }

    public CallResult RemoveNoDataWFStepActor(String strWFStepId, String strRoleId) {
        String strSql = "delete from t_SRFWFSTEPACTOR t1 where UPPER(t1.WFSTEPID)='%1$s' AND UPPER(t1.ROLEID)='%2$s' AND NOT EXISTS(SELECT * from  T_SRFWFSTEPDATA t2 where t1.WFSTEPID = t2.WFSTEPID AND t1.ACTORID = t2.ACTORID)";
        return BaseDEDataCtrl.ExecuteWithoutResult((ISRFDAGlobalHelper)this.globalHelperEx, (String)strSql, null);
    }

    public CallResult RemoveWFTmpStepActors(String strWFStepId, String strOpPersonId) {
        String strSql = StringHelper.Format((String)"delete from T_SRFWFTMPSTEPACTOR where PREVWFSTEPID='%1$s'", (Object)strWFStepId);
        return BaseDEDataCtrl.ExecuteWithoutResult((ISRFDAGlobalHelper)this.globalHelperEx, (String)strSql, null);
    }

    public CallResult GetWFAction(String strWFID, String strWFActionId, WFAction action) {
        if (StringHelper.Compare((String)WFACTION_RESUBMIT, (String)strWFActionId, (boolean)true) == 0) {
            action.setWFACTIONID(WFACTION_RESUBMIT);
            action.setACTIONNAME(WFACTION_RESUBMIT);
            action.setACTIONLOGICNAME("\u5de5\u4f5c\u8f6c\u79fb");
            return new CallResult();
        }
        if (StringHelper.Compare((String)WFACTION_REASSIGN, (String)strWFActionId, (boolean)true) == 0) {
            action.setWFACTIONID(WFACTION_REASSIGN);
            action.setACTIONNAME(WFACTION_REASSIGN);
            action.setACTIONLOGICNAME("\u5de5\u4f5c\u8f6c\u79fb");
            return new CallResult();
        }
        String strSql = StringHelper.Format((String)"select * from t_srfwfAction where  UPPER(WFWorkflowId)=UPPER('%1$s') AND UPPER(ACTIONNAME) = UPPER('%2$s')", (Object)strWFID, (Object)strWFActionId);
        return this.SelectRaw(strSql, (BaseDataEntity)action, "");
    }

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

    public CallResult GetWFStepActor(String strWFStepId, Vector<WFStepActor> list) {
        String strSql = StringHelper.Format((String)"select * from t_srfwfSTEPACTOR where  UPPER(WFSTEPID)=UPPER('%1$s')", (Object)strWFStepId);
        return this.SelectRaw(strSql, list, WFStepActor.class.getName(), "");
    }

    public CallResult GetWFStepData(String strWFStepId, Vector<WFStepData> list) {
        String strSql = StringHelper.Format((String)"select * from t_srfwfSTEPDATA where  UPPER(WFSTEPID)=UPPER('%1$s') AND (CONNECTIONNAME <> 'SRFWFRESUBMIT' AND CONNECTIONNAME <> 'SRFWFTIMEOUT')", (Object)strWFStepId);
        return this.SelectRaw(strSql, list, WFStepData.class.getName(), "");
    }

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

    public CallResult GetWFInstance(String strWorkFlowId, String strUserData, String strUserData2, String strUserData3, String strUserData4, WFInstance instance) {
        String strSql = StringHelper.Format((String)"select * from t_srfwfinstance where  UPPER(WFWorkflowId)=UPPER('%1$s') AND (ISCLOSE IS  NULL OR ISCLOSE <> 1) ", (Object)strWorkFlowId);
        strSql = StringHelper.IsNullOrEmpty((String)strUserData) ? String.valueOf(strSql) + " AND (USERDATA IS NULL) " : String.valueOf(strSql) + StringHelper.Format((String)" AND (USERDATA = '%1$s') ", (Object)strUserData);
        strSql = StringHelper.IsNullOrEmpty((String)strUserData2) ? String.valueOf(strSql) + " AND (USERDATA2 IS NULL) " : String.valueOf(strSql) + StringHelper.Format((String)" AND (USERDATA2 = '%1$s') ", (Object)strUserData2);
        strSql = StringHelper.IsNullOrEmpty((String)strUserData3) ? String.valueOf(strSql) + " AND (USERDATA3 IS NULL) " : String.valueOf(strSql) + StringHelper.Format((String)" AND (USERDATA3 = '%1$s') ", (Object)strUserData3);
        strSql = StringHelper.IsNullOrEmpty((String)strUserData4) ? String.valueOf(strSql) + " AND (USERDATA4 IS NULL) " : String.valueOf(strSql) + StringHelper.Format((String)" AND (USERDATA4 = '%1$s' OR USERDATA4 IS NULL) ", (Object)strUserData4);
        return this.SelectRaw(strSql, (BaseDataEntity)instance, "");
    }

    public CallResult GetWFUserData(String strSql, BaseDataEntity userData) {
        return this.SelectRaw(strSql, userData, "");
    }

    public CallResult GetWFUserData(WFWorkflow workflow, WFParam wpParam, BaseDataEntity userData) {
        return this.GetWFUserData(workflow.getWFWORKFLOWID(), wpParam.getUserData4(), wpParam.getUserData(), userData);
    }

    public CallResult GetWFUserData(String strWorkflowId, String strDEId, String strKeyData, BaseDataEntity userData) {
        CallResult callResult = new CallResult();
        IDEHelper deHelper = this.GetUserDataDEHelper(strWorkflowId, strDEId);
        if (deHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5de5\u4f5c\u6d41[%1$s]\u76f8\u5173\u5b9e\u4f53\u8f85\u52a9\u5bf9\u8c61", (Object)strWorkflowId));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        userData.SetParamValue(deHelper.GetKeyDEFHelper().getName(), (Object)strKeyData);
        IDEDataCtrl deDataCtrl = deHelper.GetDEDataCtrl("SYSTEM", null);
        if (deDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)deHelper.GetFullName()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        return deDataCtrl.Get(userData);
    }

    public CallResult UpdateWFUserDataRunStep(WFInstance wfInstance, String strCodeItemValue, String strOpPersonId) {
        CallResult callResult = new CallResult();
        IDEHelper deHelper = this.GetUserDataDEHelper(wfInstance.getWFWORKFLOWID(), wfInstance.getUSERDATA4());
        if (deHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5de5\u4f5c\u6d41[%1$s]\u76f8\u5173\u5b9e\u4f53\u8f85\u52a9\u5bf9\u8c61", (Object)wfInstance.getWFWORKFLOWID()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        DEWF dewf = deHelper.GetDEWF();
        String strWFStepColumnName = dewf.getWFSTEPDEFID();
        if (!StringHelper.IsNullOrEmpty((String)strWFStepColumnName)) {
            IDEFHelper iDEFHelper = deHelper.GetDEFHelper(strWFStepColumnName);
            if (iDEFHelper != null) {
                strWFStepColumnName = iDEFHelper.getName();
            } else {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u6b65\u9aa4\u5c5e\u6027[%2$s]\u8f85\u52a9\u5bf9\u8c61\u65e0\u6548", (Object)deHelper.GetFullName(), (Object)strWFStepColumnName));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
        }
        if (StringHelper.IsNullOrEmpty((String)strWFStepColumnName)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u6b65\u9aa4\u5c5e\u6027\u65e0\u6548", (Object)deHelper.GetFullName()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        BaseDataEntity userData = new BaseDataEntity();
        userData.SetParamValue(deHelper.GetKeyDEFHelper().getName(), (Object)wfInstance.getUSERDATA());
        userData.SetParamValue(strWFStepColumnName, (Object)strCodeItemValue);
        IDEDataCtrl deDataCtrl = deHelper.GetDEDataCtrl(strOpPersonId, null);
        if (deDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)deHelper.GetFullName()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        return deDataCtrl.Save(false, userData);
    }

    public IDEHelper GetUserDataDEHelper(String strWorkflowId, String strDEId) {
        CallResult callResult = new CallResult();
        if (!StringHelper.IsNullOrEmpty((String)strDEId)) {
            IDEHelper deHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(strDEId);
            if (deHelper == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strDEId));
                log.error((Object)callResult.getErrorInfo());
                return null;
            }
            return deHelper;
        }
        IDEDataCtrl dewfDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrl("DE0021", null);
        if (dewfDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[DEWF]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61");
            return null;
        }
        BaseDataEntity cond = new BaseDataEntity();
        cond.SetParamValue("WFID", (Object)strWorkflowId);
        Vector dewflist = new Vector();
        callResult = dewfDataCtrl.Select(cond, dewflist);
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u5de5\u4f5c\u6d41\u5bf9\u5e94\u5b9e\u4f53\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return null;
        }
        if (dewflist.size() == 0) {
            IDEDataCtrl dewfdetailDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrl("DE0045", null);
            if (dewfdetailDataCtrl == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[DEWFDETAIL]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61");
                return null;
            }
            callResult = dewfdetailDataCtrl.Select(cond, dewflist);
            if (callResult.getRetCode() != 0) {
                log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u5de5\u4f5c\u6d41\u5bf9\u5e94\u5b9e\u4f53\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                return null;
            }
            if (dewflist.size() == 0) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u4e0e\u5de5\u4f5c\u6d41[%1$s]\u5bf9\u5e94\u7684\u6570\u636e\u5b9e\u4f53", (Object)strWorkflowId));
                log.error((Object)callResult.getErrorInfo());
                return null;
            }
        }
        String strDEID = ((BaseDataEntity)dewflist.get(0)).GetParamStringValue("DEID", "");
        IDEHelper deHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(strDEID);
        if (deHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strDEID));
            log.error((Object)callResult.getErrorInfo());
            return null;
        }
        return deHelper;
    }

    public CallResult AddWFInstance(WFInstance instance, String strOpPersonId) {
        String strWFInitCall;
        String strWFStateValueDEFId;
        String strWFStateDEFId;
        CallResult callResult = new CallResult();
        IDEDataCtrl wfinstDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrl("WF0002", strOpPersonId, null);
        if (wfinstDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[WFINSTANCE]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61");
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        IDEHelper deHelper = this.GetUserDataDEHelper(instance.getWFWORKFLOWID(), instance.getUSERDATA4());
        if (deHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5de5\u4f5c\u6d41[%1$s]\u76f8\u5173\u5b9e\u4f53\u8f85\u52a9\u5bf9\u8c61", (Object)instance.getWFWORKFLOWID()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        DEWF dewf = deHelper.GetDEWF();
        if (dewf == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5de5\u4f5c\u6d41\u914d\u7f6e\u4fe1\u606f", (Object)deHelper.GetFullName()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        String strKey = this.GetInstDataLockKey(instance.getWFINSTANCEID());
        DataLock dataLock = new DataLock();
        dataLock.setDATALOCKNAME(StringHelper.Format((String)"\u5de5\u4f5c\u6d41\u5f15\u64ce\u9501\u5b9a"));
        dataLock.setKEY(strKey);
        dataLock.setOBJECTTYPE(deHelper.getId());
        dataLock.setOBJECTID(instance.getUSERDATA());
        callResult = this.dataLockDataCtrl.AddDataLock(dataLock);
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u5de5\u4f5c\u6d41\u6570\u636e\u52a0\u9501\uff0c%1$s", (Object)callResult.getErrorInfo()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        BaseDataEntity dataEntity = new BaseDataEntity();
        dataEntity.SetParamValue(deHelper.GetKeyDEFHelper().getName(), deHelper.GetKeyDEFHelper().GetDEFValue(instance.getUSERDATA()));
        IDEDataCtrl udDEDataCtrl = deHelper.GetDEDataCtrl(strOpPersonId, null);
        if (udDEDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)deHelper.GetFullName()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        callResult = udDEDataCtrl.Get(dataEntity);
        if (callResult.getRetCode() != 0) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        instance.setDESCRIPTION(deHelper.GetDataInfo(dataEntity));
        callResult = wfinstDataCtrl.Save(true, (BaseDataEntity)instance);
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u4fdd\u5b58\u5de5\u4f5c\u6d41\u5b9e\u4f8b\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        dataEntity.Reset();
        dataEntity.SetParamValue(deHelper.GetKeyDEFHelper().getName(), (Object)instance.getUSERDATA());
        callResult = this.FillDataEntityParam(deHelper, dataEntity, dewf.getINITSET(), strOpPersonId);
        if (callResult.getRetCode() != 0) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u586b\u5145\u7528\u6237\u6570\u636e\u53c2\u6570\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            log.error((Object)callResult.getErrorInfo());
            this.RemoveWFInstance(instance, strOpPersonId);
            return callResult;
        }
        String strWFInstDEFId = dewf.getWFINSTDEFID();
        if (!StringHelper.IsNullOrEmpty((String)strWFInstDEFId)) {
            IDEFHelper wfInstDEFHelper = deHelper.GetDEFHelper(strWFInstDEFId);
            if (wfInstDEFHelper == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u8f85\u52a9\u5bf9\u8c61", (Object)deHelper.GetFullName(), (Object)strWFInstDEFId));
                log.error((Object)callResult.getErrorInfo());
                this.RemoveWFInstance(instance, strOpPersonId);
                return callResult;
            }
            dataEntity.SetParamValue(wfInstDEFHelper.getName(), (Object)instance.getWFINSTANCEID());
        }
        if (!StringHelper.IsNullOrEmpty((String)(strWFStateDEFId = dewf.getWFSTATEDEFID()))) {
            IDEFHelper wfStateDEFHelper = deHelper.GetDEFHelper(strWFStateDEFId);
            if (wfStateDEFHelper == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u8f85\u52a9\u5bf9\u8c61", (Object)deHelper.GetFullName(), (Object)strWFStateDEFId));
                log.error((Object)callResult.getErrorInfo());
                this.RemoveWFInstance(instance, strOpPersonId);
                return callResult;
            }
            dataEntity.SetParamValue(wfStateDEFHelper.getName(), (Object)1);
        }
        if (!StringHelper.IsNullOrEmpty((String)(strWFStateValueDEFId = dewf.getSTATEDEFID())) && !StringHelper.IsNullOrEmpty((String)dewf.getWFSTATEVALUE())) {
            IDEFHelper wfStateValueDEFHelper = deHelper.GetDEFHelper(strWFStateValueDEFId);
            if (wfStateValueDEFHelper == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u8f85\u52a9\u5bf9\u8c61", (Object)deHelper.GetFullName(), (Object)strWFStateValueDEFId));
                log.error((Object)callResult.getErrorInfo());
                this.RemoveWFInstance(instance, strOpPersonId);
                return callResult;
            }
            String[] wfstate = dewf.getWFSTATEVALUE().split("[|]");
            Object objValue = DataTypeParse.Parse((String)wfStateValueDEFHelper.GetStdDataType(), (String)wfstate[0]);
            dataEntity.SetParamValue(wfStateValueDEFHelper.getName(), objValue);
        }
        if ((callResult = udDEDataCtrl.Save(false, dataEntity)).getRetCode() != 0) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u66f4\u65b0\u7528\u6237\u6570\u636e\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            log.error((Object)callResult.getErrorInfo());
            this.RemoveWFInstance(instance, strOpPersonId);
            return callResult;
        }
        String strInitObject = dewf.getINITOBJECT();
        if (!StringHelper.IsNullOrEmpty((String)strInitObject)) {
            Object obj = ObjectHelper.Create((String)strInitObject);
            if (obj == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u521d\u59cb\u5316\u8bbe\u7f6e\u63d2\u4ef6[%1$s]\uff0c%2$s", (Object)strInitObject, (Object)callResult.getErrorInfo()));
                log.error((Object)callResult.getErrorInfo());
                this.RemoveWFInstance(instance, strOpPersonId);
                return callResult;
            }
            if (!(obj instanceof IDEWFDataCtrlPlugin)) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u521d\u59cb\u5316\u8bbe\u7f6e\u63d2\u4ef6[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strInitObject));
                log.error((Object)callResult.getErrorInfo());
                this.RemoveWFInstance(instance, strOpPersonId);
                return callResult;
            }
            callResult = ((IDEWFDataCtrlPlugin)obj).Execute(this.globalHelperEx, dataEntity, strOpPersonId);
            if (callResult == null || callResult.getRetCode() != 0) {
                this.RemoveWFInstance(instance, strOpPersonId);
            }
        }
        if ((callResult = udDEDataCtrl.CustomCall(strWFInitCall = PropertiesHelper.GetProperty((Properties)dewf.getWFParams(), (String)"WFINIT", (String)"WFINIT"), dataEntity)).getRetCode() == 20) {
            callResult.setRetCode(0);
        }
        return callResult;
    }

    public CallResult ErrorWFInstance(WFInstance instance, String strErrorInfo, String strOpPersonId) {
        IDEDataCtrl udDEDataCtrl;
        CallResult callResult = new CallResult();
        IDEDataCtrl wfinstDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrl("WF0002", strOpPersonId, null);
        if (wfinstDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[WFINSTANCE]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61");
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        IDEHelper deHelper = this.GetUserDataDEHelper(instance.getWFWORKFLOWID(), instance.getUSERDATA4());
        if (deHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5de5\u4f5c\u6d41[%1$s]\u76f8\u5173\u5b9e\u4f53\u8f85\u52a9\u5bf9\u8c61", (Object)instance.getWFWORKFLOWID()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        String strKey = this.GetInstDataLockKey(instance.getWFINSTANCEID());
        DataLock dataLock = new DataLock();
        dataLock.setKEY(strKey);
        dataLock.setOBJECTTYPE(deHelper.getId());
        dataLock.setOBJECTID(instance.getUSERDATA());
        callResult = this.dataLockDataCtrl.RemoveDataLock(dataLock);
        if (callResult.getRetCode() != 0) {
            return callResult;
        }
        DEWF dewf = deHelper.GetDEWF();
        if (dewf == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5de5\u4f5c\u6d41\u914d\u7f6e\u4fe1\u606f", (Object)deHelper.GetFullName()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        WFInstance tempInst = new WFInstance();
        tempInst.setWFINSTANCEID(instance.getWFINSTANCEID());
        tempInst.setISERROR(true);
        tempInst.setERRORINFO(strErrorInfo);
        callResult = wfinstDataCtrl.Save(false, (BaseDataEntity)tempInst);
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u66f4\u65b0\u5de5\u4f5c\u6d41\u5b9e\u4f8b\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        BaseDataEntity dataEntity = new BaseDataEntity();
        dataEntity.SetParamValue(deHelper.GetKeyDEFHelper().getName(), (Object)instance.getUSERDATA());
        String strWFStateDEFId = dewf.getWFSTATEDEFID();
        if (!StringHelper.IsNullOrEmpty((String)strWFStateDEFId)) {
            IDEFHelper wfStateDEFHelper = deHelper.GetDEFHelper(strWFStateDEFId);
            if (wfStateDEFHelper == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u8f85\u52a9\u5bf9\u8c61", (Object)deHelper.GetFullName(), (Object)strWFStateDEFId));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            dataEntity.SetParamValue(wfStateDEFHelper.getName(), (Object)4);
        }
        if ((udDEDataCtrl = deHelper.GetDEDataCtrl(strOpPersonId, null)) == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)deHelper.GetFullName()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        callResult = udDEDataCtrl.Save(false, dataEntity);
        if (callResult.getRetCode() != 0) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u66f4\u65b0\u7528\u6237\u6570\u636e\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        return callResult;
    }

    public CallResult RemoveWFInstance(WFInstance instance, String strOpPersonId) {
        IDEDataCtrl udDEDataCtrl;
        String strWFStateDEFId;
        CallResult callResult = new CallResult();
        IDEDataCtrl wfinstDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrl("WF0002", strOpPersonId, null);
        if (wfinstDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[WFINSTANCE]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61");
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        IDEHelper deHelper = this.GetUserDataDEHelper(instance.getWFWORKFLOWID(), instance.getUSERDATA4());
        if (deHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5de5\u4f5c\u6d41[%1$s]\u76f8\u5173\u5b9e\u4f53\u8f85\u52a9\u5bf9\u8c61", (Object)instance.getWFWORKFLOWID()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        DEWF dewf = deHelper.GetDEWF();
        if (dewf == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5de5\u4f5c\u6d41\u914d\u7f6e\u4fe1\u606f", (Object)deHelper.GetFullName()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        String strKey = this.GetInstDataLockKey(instance.getWFINSTANCEID());
        DataLock dataLock = new DataLock();
        dataLock.setKEY(strKey);
        dataLock.setOBJECTTYPE(deHelper.getId());
        dataLock.setOBJECTID(instance.getUSERDATA());
        callResult = this.dataLockDataCtrl.RemoveDataLock(dataLock);
        if (callResult.getRetCode() != 0) {
            return callResult;
        }
        BaseDataEntity dataEntity = new BaseDataEntity();
        dataEntity.SetParamValue(deHelper.GetKeyDEFHelper().getName(), (Object)instance.getUSERDATA());
        String strWFInstDEFId = dewf.getWFINSTDEFID();
        if (!StringHelper.IsNullOrEmpty((String)strWFInstDEFId)) {
            IDEFHelper wfInstDEFHelper = deHelper.GetDEFHelper(strWFInstDEFId);
            if (wfInstDEFHelper == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u8f85\u52a9\u5bf9\u8c61", (Object)deHelper.GetFullName(), (Object)strWFInstDEFId));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            dataEntity.SetParamValue(wfInstDEFHelper.getName(), null);
        }
        if (!StringHelper.IsNullOrEmpty((String)(strWFStateDEFId = dewf.getWFSTATEDEFID()))) {
            IDEFHelper wfStateDEFHelper = deHelper.GetDEFHelper(strWFStateDEFId);
            if (wfStateDEFHelper == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u8f85\u52a9\u5bf9\u8c61", (Object)deHelper.GetFullName(), (Object)strWFStateDEFId));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            dataEntity.SetParamValue(wfStateDEFHelper.getName(), (Object)0);
        }
        if ((udDEDataCtrl = deHelper.GetDEDataCtrl(strOpPersonId, null)) == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)deHelper.GetFullName()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        callResult = udDEDataCtrl.Save(false, dataEntity);
        if (callResult.getRetCode() != 0) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u66f4\u65b0\u7528\u6237\u6570\u636e\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        callResult = wfinstDataCtrl.Remove((BaseDataEntity)instance);
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u5220\u9664\u5de5\u4f5c\u6d41\u5b9e\u4f8b\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        return callResult;
    }

    public CallResult FinishWFInstance(WFInstance instance, String strOpPersonId) {
        String strWFFinishCall;
        IDEDataCtrl udDEDataCtrl;
        String strWFStepColumnName;
        String strWFStateDEFId;
        CallResult callResult = new CallResult();
        IDEDataCtrl deDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrl("WF0002", strOpPersonId, null);
        if (deDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[WFINSTANCE]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61");
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        callResult = deDataCtrl.CustomSaveCall("FINISH", (BaseDataEntity)instance);
        if (callResult.getRetCode() != 0) {
            return callResult;
        }
        IDEHelper deHelper = this.GetUserDataDEHelper(instance.getWFWORKFLOWID(), instance.getUSERDATA4());
        if (deHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5de5\u4f5c\u6d41[%1$s]\u76f8\u5173\u5b9e\u4f53\u8f85\u52a9\u5bf9\u8c61", (Object)instance.getWFWORKFLOWID()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        String strKey = this.GetInstDataLockKey(instance.getWFINSTANCEID());
        DataLock dataLock = new DataLock();
        dataLock.setKEY(strKey);
        dataLock.setOBJECTTYPE(deHelper.getId());
        dataLock.setOBJECTID(instance.getUSERDATA());
        callResult = this.dataLockDataCtrl.RemoveDataLock(dataLock);
        if (callResult.getRetCode() != 0) {
            return callResult;
        }
        DEWF dewf = deHelper.GetDEWF();
        if (dewf == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5de5\u4f5c\u6d41\u914d\u7f6e\u4fe1\u606f", (Object)deHelper.GetFullName()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        BaseDataEntity dataEntity = new BaseDataEntity();
        dataEntity.SetParamValue(deHelper.GetKeyDEFHelper().getName(), (Object)instance.getUSERDATA());
        callResult = this.FillDataEntityParam(deHelper, dataEntity, dewf.getFINISHSET(), strOpPersonId);
        String strWFInstDEFId = dewf.getWFINSTDEFID();
        if (!StringHelper.IsNullOrEmpty((String)strWFInstDEFId)) {
            IDEFHelper wfInstDEFHelper = deHelper.GetDEFHelper(strWFInstDEFId);
            if (wfInstDEFHelper == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u8f85\u52a9\u5bf9\u8c61", (Object)deHelper.GetFullName(), (Object)strWFInstDEFId));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            dataEntity.SetParamValue(wfInstDEFHelper.getName(), null);
        }
        if (!StringHelper.IsNullOrEmpty((String)(strWFStateDEFId = dewf.getWFSTATEDEFID()))) {
            IDEFHelper wfStateDEFHelper = deHelper.GetDEFHelper(strWFStateDEFId);
            if (wfStateDEFHelper == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u8f85\u52a9\u5bf9\u8c61", (Object)deHelper.GetFullName(), (Object)strWFStateDEFId));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            dataEntity.SetParamValue(wfStateDEFHelper.getName(), (Object)2);
        }
        if (!StringHelper.IsNullOrEmpty((String)(strWFStepColumnName = dewf.getWFSTEPDEFID())) && dewf.GetWFParam("RESETWFSTEP", true)) {
            IDEFHelper iDEFHelper = deHelper.GetDEFHelper(strWFStepColumnName);
            if (iDEFHelper == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u6b65\u9aa4\u5c5e\u6027[%2$s]\u8f85\u52a9\u5bf9\u8c61\u65e0\u6548", (Object)deHelper.GetFullName(), (Object)strWFStepColumnName));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            dataEntity.SetParamValue(iDEFHelper.getName(), null);
        }
        if ((udDEDataCtrl = deHelper.GetDEDataCtrl(strOpPersonId, null)) == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)deHelper.GetFullName()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        callResult = udDEDataCtrl.Save(false, dataEntity);
        if (callResult.getRetCode() != 0) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u66f4\u65b0\u7528\u6237\u6570\u636e\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        String strFinishObject = dewf.getFINISHOBJECT();
        if (!StringHelper.IsNullOrEmpty((String)strFinishObject)) {
            Object obj = ObjectHelper.Create((String)strFinishObject);
            if (obj == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u5b8c\u6210\u8bbe\u7f6e\u63d2\u4ef6[%1$s]\uff0c%2$s", (Object)strFinishObject, (Object)callResult.getErrorInfo()));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            if (!(obj instanceof IDEWFDataCtrlPlugin)) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u5b8c\u6210\u8bbe\u7f6e\u63d2\u4ef6[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strFinishObject));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            callResult = ((IDEWFDataCtrlPlugin)obj).Execute(this.globalHelperEx, dataEntity, strOpPersonId);
            if (callResult.IsError()) {
                return callResult;
            }
        }
        if ((callResult = udDEDataCtrl.CustomCall(strWFFinishCall = PropertiesHelper.GetProperty((Properties)dewf.getWFParams(), (String)"WFFINISH", (String)"WFFINISH"), dataEntity)).getRetCode() == 20) {
            callResult.setRetCode(0);
        }
        return callResult;
    }

    public CallResult ResetWFInstance(WFInstance instance, String strOpPersonId) {
        String strWFInitCall;
        IDEDataCtrl udDEDataCtrl;
        String strWFStateValueDEFId;
        CallResult callResult = new CallResult();
        IDEDataCtrl deDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrl("WF0002", strOpPersonId, null);
        if (deDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[WFINSTANCE]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61");
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        IDEHelper deHelper = this.GetUserDataDEHelper(instance.getWFWORKFLOWID(), instance.getUSERDATA4());
        if (deHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5de5\u4f5c\u6d41[%1$s]\u76f8\u5173\u5b9e\u4f53\u8f85\u52a9\u5bf9\u8c61", (Object)instance.getWFWORKFLOWID()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        DEWF dewf = deHelper.GetDEWF();
        if (dewf == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5de5\u4f5c\u6d41\u914d\u7f6e\u4fe1\u606f", (Object)deHelper.GetFullName()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        callResult = deDataCtrl.CustomSaveCall("RESET", (BaseDataEntity)instance);
        if (callResult.getRetCode() != 0) {
            return callResult;
        }
        BaseDataEntity dataEntity = new BaseDataEntity();
        dataEntity.SetParamValue(deHelper.GetKeyDEFHelper().getName(), (Object)instance.getUSERDATA());
        callResult = this.FillDataEntityParam(deHelper, dataEntity, dewf.getINITSET(), strOpPersonId);
        if (callResult.getRetCode() != 0) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u586b\u5145\u7528\u6237\u6570\u636e\u53c2\u6570\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        String strWFStateDEFId = dewf.getWFSTATEDEFID();
        if (!StringHelper.IsNullOrEmpty((String)strWFStateDEFId)) {
            IDEFHelper wfStateDEFHelper = deHelper.GetDEFHelper(strWFStateDEFId);
            if (wfStateDEFHelper == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u8f85\u52a9\u5bf9\u8c61", (Object)deHelper.GetFullName(), (Object)strWFStateDEFId));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            dataEntity.SetParamValue(wfStateDEFHelper.getName(), (Object)1);
        }
        if (!StringHelper.IsNullOrEmpty((String)(strWFStateValueDEFId = dewf.getSTATEDEFID())) && !StringHelper.IsNullOrEmpty((String)dewf.getWFSTATEVALUE())) {
            IDEFHelper wfStateValueDEFHelper = deHelper.GetDEFHelper(strWFStateValueDEFId);
            if (wfStateValueDEFHelper == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u8f85\u52a9\u5bf9\u8c61", (Object)deHelper.GetFullName(), (Object)strWFStateValueDEFId));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            String[] wfstate = dewf.getWFSTATEVALUE().split("[|]");
            Object objValue = DataTypeParse.Parse((String)wfStateValueDEFHelper.GetStdDataType(), (String)wfstate[0]);
            dataEntity.SetParamValue(wfStateValueDEFHelper.getName(), objValue);
        }
        if ((udDEDataCtrl = deHelper.GetDEDataCtrl(strOpPersonId, null)) == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)deHelper.GetFullName()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        callResult = udDEDataCtrl.Save(false, dataEntity);
        if (callResult.getRetCode() != 0) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u66f4\u65b0\u7528\u6237\u6570\u636e\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        String strInitObject = dewf.getINITOBJECT();
        if (!StringHelper.IsNullOrEmpty((String)strInitObject)) {
            Object obj = ObjectHelper.Create((String)strInitObject);
            if (obj == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u521d\u59cb\u5316\u8bbe\u7f6e\u63d2\u4ef6[%1$s]\uff0c%2$s", (Object)strInitObject, (Object)callResult.getErrorInfo()));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            if (!(obj instanceof IDEWFDataCtrlPlugin)) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u521d\u59cb\u5316\u8bbe\u7f6e\u63d2\u4ef6[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strInitObject));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            callResult = ((IDEWFDataCtrlPlugin)obj).Execute(this.globalHelperEx, dataEntity, strOpPersonId);
            if (callResult.IsError()) {
                return callResult;
            }
        }
        if ((callResult = udDEDataCtrl.CustomCall(strWFInitCall = PropertiesHelper.GetProperty((Properties)dewf.getWFParams(), (String)"WFINIT", (String)"WFINIT"), dataEntity)).getRetCode() == 20) {
            callResult.setRetCode(0);
        }
        return callResult;
    }

    protected CallResult FillDataEntityParam(IDEHelper iUserDEHelper, BaseDataEntity dataEntity, String strFilleParams, String strOpPersonId) {
        CallResult callResult = new CallResult();
        try {
            Properties properties = PropertiesHelper.Load((String)strFilleParams);
            Enumeration<Object> en = properties.keys();
            while (en.hasMoreElements()) {
                String strKey = (String)en.nextElement();
                IDEFHelper iDEFHelper = iUserDEHelper.GetDEFHelper(strKey);
                String strValue = PropertiesHelper.GetProperty((Properties)properties, (String)strKey);
                callResult = MacroHelper.GetValue((String)strValue, (ISRFDAGlobalHelper)this.globalHelperEx, (String)strOpPersonId, (BaseDataEntity)dataEntity);
                if (callResult.getRetCode() != 0) {
                    callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6307\u5b9a\u503c[%1$s],%2$s", (Object)strValue, (Object)callResult.getErrorInfo()));
                    callResult.setRetCode(1);
                    log.error((Object)callResult.getErrorInfo());
                    return callResult;
                }
                Object obj = callResult.getUserObject();
                if (obj == null) {
                    dataEntity.SetParamValue(strKey, obj);
                    continue;
                }
                if (obj instanceof String) {
                    strValue = obj.toString();
                    if (StringHelper.IsNullOrEmpty((String)strValue)) {
                        dataEntity.SetParamValue(strKey, null);
                        continue;
                    }
                    if (iDEFHelper != null && (obj = DataTypeParse.Parse((String)iDEFHelper.GetStdDataType(), (String)strValue)) == null) {
                        callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u8f6c\u6362\u6307\u5b9a\u503c[%1$s]\u81f3\u7c7b\u578b[%2$s]", (Object)strValue, (Object)iDEFHelper.GetStdDataType()));
                        callResult.setRetCode(1);
                        log.error((Object)callResult.getErrorInfo());
                        return callResult;
                    }
                    dataEntity.SetParamValue(strKey, obj);
                    continue;
                }
                dataEntity.SetParamValue(strKey, obj);
            }
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)ex);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6267\u884c\u64cd\u4f5c\u53d1\u751f\u5f02\u5e38"));
            callResult.setRetCode(1);
            return callResult;
        }
    }

    public CallResult UserCloseWFInstance(WFInstance instance, String strOpPersonId) {
        String strWFCancelCall;
        IDEDataCtrl udDEDataCtrl;
        CallResult callResult = new CallResult();
        IDEDataCtrl deDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrl("WF0002", strOpPersonId, null);
        if (deDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[WFINSTANCE]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61");
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        IDEHelper deHelper = this.GetUserDataDEHelper(instance.getWFWORKFLOWID(), instance.getUSERDATA4());
        if (deHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5de5\u4f5c\u6d41[%1$s]\u76f8\u5173\u5b9e\u4f53\u8f85\u52a9\u5bf9\u8c61", (Object)instance.getWFWORKFLOWID()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        String strKey = this.GetInstDataLockKey(instance.getWFINSTANCEID());
        DataLock dataLock = new DataLock();
        dataLock.setKEY(strKey);
        dataLock.setOBJECTTYPE(deHelper.getId());
        dataLock.setOBJECTID(instance.getUSERDATA());
        callResult = this.dataLockDataCtrl.RemoveDataLock(dataLock);
        if (callResult.getRetCode() != 0) {
            return callResult;
        }
        DEWF dewf = deHelper.GetDEWF();
        if (dewf == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5de5\u4f5c\u6d41\u914d\u7f6e\u4fe1\u606f", (Object)deHelper.GetFullName()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        callResult = deDataCtrl.CustomSaveCall("USERCLOSE", (BaseDataEntity)instance);
        if (callResult.getRetCode() != 0) {
            return callResult;
        }
        BaseDataEntity dataEntity = new BaseDataEntity();
        dataEntity.SetParamValue(deHelper.GetKeyDEFHelper().getName(), (Object)instance.getUSERDATA());
        callResult = this.FillDataEntityParam(deHelper, dataEntity, dewf.getCANCELSET(), strOpPersonId);
        if (callResult.getRetCode() != 0) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u586b\u5145\u7528\u6237\u6570\u636e\u53c2\u6570\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        String strWFStateDEFId = dewf.getWFSTATEDEFID();
        if (!StringHelper.IsNullOrEmpty((String)strWFStateDEFId)) {
            IDEFHelper wfStateDEFHelper = deHelper.GetDEFHelper(strWFStateDEFId);
            if (wfStateDEFHelper == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u8f85\u52a9\u5bf9\u8c61", (Object)deHelper.GetFullName(), (Object)strWFStateDEFId));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            dataEntity.SetParamValue(wfStateDEFHelper.getName(), (Object)31);
        }
        if ((udDEDataCtrl = deHelper.GetDEDataCtrl(strOpPersonId, null)) == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)deHelper.GetFullName()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        callResult = udDEDataCtrl.Save(false, dataEntity);
        if (callResult.getRetCode() != 0) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u66f4\u65b0\u7528\u6237\u6570\u636e\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        String strCancelObject = dewf.getCANCELOBJECT();
        if (!StringHelper.IsNullOrEmpty((String)strCancelObject)) {
            Object obj = ObjectHelper.Create((String)strCancelObject);
            if (obj == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u53d6\u6d88\u8bbe\u7f6e\u63d2\u4ef6[%1$s]\uff0c%2$s", (Object)strCancelObject, (Object)callResult.getErrorInfo()));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            if (!(obj instanceof IDEWFDataCtrlPlugin)) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u521d\u59cb\u5316\u8bbe\u7f6e\u63d2\u4ef6[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strCancelObject));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            callResult = ((IDEWFDataCtrlPlugin)obj).Execute(this.globalHelperEx, dataEntity, strOpPersonId);
            if (callResult.IsError()) {
                return callResult;
            }
        }
        if ((callResult = udDEDataCtrl.CustomCall(strWFCancelCall = PropertiesHelper.GetProperty((Properties)dewf.getWFParams(), (String)"WFCANCEL", (String)"WFCANCEL"), dataEntity)).getRetCode() == 20) {
            callResult.setRetCode(0);
        }
        return callResult;
    }

    public CallResult AddWFStep(WFStep step, String strOpPersonId) {
        CallResult callResult = new CallResult();
        if (this.wfstepDataCtrl == null) {
            this.wfstepDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrl("WF0003", strOpPersonId, null);
        }
        if (this.wfstepDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[WFSTEP]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61");
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        callResult = this.wfstepDataCtrl.CustomSaveCall("ADD", (BaseDataEntity)step);
        return callResult;
    }

    public CallResult AddWFStepData(WFStepData stepData, String strOpPersonId) {
        CallResult callResult = new CallResult();
        IDEDataCtrl stepdataDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrl("WF0005", strOpPersonId, null);
        if (stepdataDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[WFSTEPDATA]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61");
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        callResult = stepdataDataCtrl.CustomSaveCall("ADD", (BaseDataEntity)stepData);
        return callResult;
    }

    public CallResult TestWFStepData(WFStepData stepData, String strOpPersonId) {
        CallResult callResult = new CallResult();
        IDEDataCtrl stepdataDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrl("WF0005", strOpPersonId, null);
        if (stepdataDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[WFSTEPDATA]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61");
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        callResult = stepdataDataCtrl.CustomProcCall("TEST", (BaseDataEntity)stepData);
        return callResult;
    }

    public CallResult FinishWFStep(WFStep step, String strOpPersonId) {
        CallResult callResult = new CallResult();
        IDEDataCtrl wfstepDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrl("WF0003", strOpPersonId, null);
        if (wfstepDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[WFSTEP]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61");
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        callResult = wfstepDataCtrl.CustomSaveCall("FINISH", (BaseDataEntity)step);
        return callResult;
    }

    public CallResult AddWFStepActor(WFStepActor stepActor, String strOpPersonId) {
        CallResult callResult = new CallResult();
        if (this.wfStepActorDataCtrl == null) {
            this.wfStepActorDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrl("WF0006", strOpPersonId, null);
        }
        if (this.wfStepActorDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[WFSTEPACTOR]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61");
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        callResult = this.wfStepActorDataCtrl.Save(true, (BaseDataEntity)stepActor);
        return callResult;
    }

    public CallResult AddWFTmpStepActors(Vector<WFTmpStepActor> tmpStepActors, String strOpPersonId) {
        CallResult callResult = new CallResult();
        callResult.setRetCode(20);
        if (this.wfTmpStepActorDataCtrl == null) {
            this.wfTmpStepActorDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrl("WF0016", strOpPersonId, null);
        }
        if (this.wfTmpStepActorDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[WFTMPSTEPACTOR]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61");
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        for (WFTmpStepActor tmpStepActor : tmpStepActors) {
            callResult = this.wfTmpStepActorDataCtrl.Save(true, (BaseDataEntity)tmpStepActor);
            if (!callResult.IsError()) continue;
            return callResult;
        }
        return callResult;
    }

    public CallResult SendWFStepActorInformMsg(Vector<String> actors, WFInstance wfInstane, String strMsgTemplateId, int nMsgType) {
        BaseDataEntity dataEntity = new BaseDataEntity();
        CallResult callResult = this.GetWFUserData(wfInstane.getWFWORKFLOWID(), wfInstane.getUSERDATA4(), wfInstane.getUSERDATA(), dataEntity);
        if (callResult.IsError()) {
            callResult.setErrorInfo(StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f8b\u7528\u6237\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        IDEDataCtrl iMsgTemplateDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrl("DE0076", "SYSTEM", null);
        if (iMsgTemplateDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0076"));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        MsgTemplate msgTemplate = new MsgTemplate();
        msgTemplate.setMSGTEMPLATEID(strMsgTemplateId);
        callResult = iMsgTemplateDataCtrl.Get((BaseDataEntity)msgTemplate);
        if (callResult.IsError()) {
            callResult.setErrorInfo(StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u6d88\u606f\u6a21\u677f[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strMsgTemplateId, (Object)callResult.getErrorInfo()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        IDEDataCtrl iMsgAccountDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrl("DE0070", "SYSTEM", null);
        if (iMsgAccountDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0070"));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        Vector<MsgSendQueue> msqs = new Vector<MsgSendQueue>();
        MsgAccount msgAccount = new MsgAccount();
        for (String strActorId : actors) {
            MsgSendQueue msq;
            msgAccount.setMSGACCOUNTID(strActorId);
            callResult = iMsgAccountDataCtrl.Get((BaseDataEntity)msgAccount);
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6d88\u606f\u8d26\u6237[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strActorId, (Object)callResult.getErrorInfo()));
                continue;
            }
            if ((nMsgType & 1) != 0) {
                callResult = MsgTemplateHelper.GetMsgSendQueue((int)1, (MsgTemplate)msgTemplate, (BaseDataEntity)dataEntity, (ISRFDAGlobalHelper)this.globalHelperEx, null, (MsgAccount)msgAccount, (String)"SYSTEM");
                if (callResult.IsError()) {
                    log.error((Object)StringHelper.Format((String)"\u5efa\u7acb\u6d88\u606f\u5f02\u6b65\u961f\u5217\u6570\u636e\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    continue;
                }
                msq = (MsgSendQueue)callResult.getUserObject();
                msq.setDSTUSERS(msgAccount.getMSGACCOUNTID());
                msqs.add(msq);
            }
            if ((nMsgType & 2) != 0) {
                callResult = MsgTemplateHelper.GetMsgSendQueue((int)2, (MsgTemplate)msgTemplate, (BaseDataEntity)dataEntity, (ISRFDAGlobalHelper)this.globalHelperEx, null, (MsgAccount)msgAccount, (String)"SYSTEM");
                if (callResult.IsError()) {
                    log.error((Object)StringHelper.Format((String)"\u5efa\u7acb\u6d88\u606f\u5f02\u6b65\u961f\u5217\u6570\u636e\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    continue;
                }
                msq = (MsgSendQueue)callResult.getUserObject();
                msq.setDSTADDRESSES(msgAccount.getMAILADDRESS());
                msqs.add(msq);
            }
            if ((nMsgType & 8) == 0) continue;
            callResult = MsgTemplateHelper.GetMsgSendQueue((int)8, (MsgTemplate)msgTemplate, (BaseDataEntity)dataEntity, (ISRFDAGlobalHelper)this.globalHelperEx, null, (MsgAccount)msgAccount, (String)"SYSTEM");
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u5efa\u7acb\u6d88\u606f\u5f02\u6b65\u961f\u5217\u6570\u636e\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                continue;
            }
            msq = (MsgSendQueue)callResult.getUserObject();
            msq.setDSTADDRESSES(msgAccount.getMSNEMAIL());
            msqs.add(msq);
        }
        IDEDataCtrl msqDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrl("DE0077", "SYSTEM", null);
        if (msqDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0077"));
            return callResult;
        }
        for (MsgSendQueue msq : msqs) {
            callResult = msqDataCtrl.Save(true, (BaseDataEntity)msq);
            if (!callResult.IsError()) continue;
            log.error((Object)StringHelper.Format((String)"\u4fdd\u5b58\u6d88\u606f\u5f02\u6b65\u961f\u5217\u6570\u636e\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return callResult;
    }

    public CallResult AddWFIAAction(WFIAAction iaAction, String strOpPersonId) {
        CallResult callResult = new CallResult();
        IDEDataCtrl wfiaDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrl("WF0004", strOpPersonId, null);
        if (wfiaDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[WFIAACTION]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61");
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        callResult = wfiaDataCtrl.Save(true, (BaseDataEntity)iaAction);
        return callResult;
    }

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

    public CallResult GetWFActor(String strActorId, WFActor wfActor) {
        String strSql = StringHelper.Format((String)"select * from T_SRFWFACTOR where UPPER(WFACTORID)=UPPER('%1$s')", (Object)strActorId);
        return this.SelectRaw(strSql, (BaseDataEntity)wfActor, "");
    }

    public CallResult GetWFUserGroupDetail(String strActorId, Vector<WFUser> list) {
        String strSql = StringHelper.Format((String)"select t1.* from t_SRFWFUSER t1 INNER JOIN T_SRFWFUSERGROUPDETAIL t2 ON t1.WFUSERID=t2.WFUSERID WHERE UPPER(t2.WFUSERGROUPID)= '%1$s'", (Object)strActorId.toUpperCase());
        return this.SelectRaw(strSql, list, WFUser.class.getName(), "");
    }

    public CallResult GetWFUserAssist(String strWFStepActorId, String strAssistUserId, String strWorkflowId, WFUserAssist userAssist) {
        String strSqlFormat = "select t1.* from T_SRFWFUSERASSIST t1 INNER JOIN T_SRFWFSTEPACTOR t2\t\tON t1.WFMAJORUSERID = t2.ACTORID WHERE UPPER(t1.WFMINORUSERID) = '%1$s' AND t2.WFSTEPACTORID='%2$s' AND WFWORKFLOWID IS NULL";
        String strSql = StringHelper.Format((String)strSqlFormat, (Object)strAssistUserId, (Object)strWFStepActorId, (Object)strWorkflowId);
        return this.SelectRaw(strSql, (BaseDataEntity)userAssist, "");
    }

    public CallResult GetWFUserAssists(WFInstance instance, String strWFStepActorId, String strAssistUserId, String strWorkflowId, Vector<WFUserAssist> userAssists) {
        String strSqlFormat = "select t1.* from T_SRFWFUSERASSIST t1 INNER JOIN T_SRFWFSTEPACTOR t2\t\tON t1.WFMAJORUSERID = t2.ACTORID WHERE UPPER(t1.WFMINORUSERID) = '%1$s' AND UPPER(t2.WFSTEPACTORID)='%2$s' AND UPPER(WFWORKFLOWID)='%3$s'";
        Vector<WFUserAssist> userAssists2 = new Vector<WFUserAssist>();
        String strSql = StringHelper.Format((String)strSqlFormat, (Object)strAssistUserId.toUpperCase(), (Object)strWFStepActorId.toUpperCase(), (Object)strWorkflowId.toUpperCase());
        CallResult callResult = this.SelectRaw(strSql, userAssists2, WFUserAssist.class.getName(), "");
        if (callResult.IsError()) {
            return callResult;
        }
        if (userAssists2.size() == 0) {
            return callResult;
        }
        IDEDataCtrl qmDataCtrl = null;
        for (WFUserAssist userAssist : userAssists2) {
            if (StringHelper.IsNullOrEmpty((String)userAssist.getQUERYMODELID())) {
                userAssists.add(userAssist);
                continue;
            }
            QueryModel queryModel = new QueryModel();
            queryModel.setQUERYMODELID(userAssist.getQUERYMODELID());
            if (qmDataCtrl == null && (qmDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrl("DE0023", "SYSTEM", null)) == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0023"));
                return callResult;
            }
            callResult = qmDataCtrl.Get((BaseDataEntity)queryModel);
            if (callResult.IsError()) {
                return callResult;
            }
            if (StringHelper.Compare((String)instance.getUSERDATA4(), (String)queryModel.getDEID(), (boolean)true) != 0) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u67e5\u8be2\u6a21\u578b[%1$s]\u5b9e\u4f53\u4e0e\u5de5\u4f5c\u6d41\u5b9e\u4f8b\u5b9e\u4f53[%2$s]\u4e0d\u4e00\u81f4\u3002", (Object)queryModel.getQUERYMODELID(), (Object)instance.getUSERDATA4()));
                return callResult;
            }
            BaseDAQueryModelHelper queryModelHelper = this.globalHelperEx.getDAModelStorage().FindDAQueryModelHelper(queryModel);
            if (queryModelHelper == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u67e5\u8be2\u6a21\u578b[%1$s]\u8f85\u52a9\u5bf9\u8c61\u3002", (Object)queryModel.getQUERYMODELID()));
                return callResult;
            }
            DefaultDAQueryModelUserContext qmUserContext = new DefaultDAQueryModelUserContext();
            StringBuilderEx script = new StringBuilderEx();
            script.Append(queryModelHelper.GetQMDeclareScript());
            script.Append(qmUserContext.GetQMDeclareScript());
            script.Append(queryModelHelper.GetQueryModelScript());
            Vector<String> userConditions = new Vector<String>();
            queryModelHelper.FillMajorConditions(userConditions);
            String strKeyCondition = queryModelHelper.GetConditionSQL((IDAQueryModelUserContext)qmUserContext, queryModelHelper.GetMajorDEHelper().GetKeyDEFHelper(), "", "=", instance.getUSERDATA());
            if (StringHelper.IsNullOrEmpty((String)strKeyCondition)) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u4e3b\u952e\u6761\u4ef6");
                return callResult;
            }
            userConditions.add(strKeyCondition);
            if (userConditions.size() != 0) {
                script.Append(" WHERE ");
                boolean bFirst = true;
                for (String strCondition : userConditions) {
                    if (bFirst) {
                        bFirst = false;
                    } else {
                        script.Append(" AND ");
                    }
                    script.Append("(%1$s)", (Object)strCondition);
                }
            }
            Vector list = new Vector();
            queryModelHelper.FillQMDeclareParams(list, null, (ISRFDAGlobalHelper)this.globalHelperEx, "SYSTEM");
            qmUserContext.FillQMDeclareParams(list, null, (ISRFDAGlobalHelper)this.globalHelperEx, "SYSTEM");
            queryModelHelper.FillCallParams(list, null, (ISRFDAGlobalHelper)this.globalHelperEx, "SYSTEM");
            StringBuilderEx info = new StringBuilderEx();
            if (list != null) {
                int i = 0;
                while (i < list.size()) {
                    CallParam callParam = (CallParam)list.get(i);
                    info.Append("\u53c2\u6570[%1$s][%2$s][%3$s]\r\n", (Object)(i + 1), (Object)callParam.getParamName(), callParam.getValue());
                    ++i;
                }
            }
            log.info((Object)info.toString());
            BaseDataEntity temp = new BaseDataEntity();
            callResult = BaseDEDataCtrl.SelectSingleEx((ISRFDAGlobalHelper)this.globalHelperEx, (String)queryModelHelper.GetMajorDEHelper().GetDBStorage(), (String)script.toString(), list, (BaseDataEntity)temp);
            if (callResult.getRetCode() != 0) continue;
            userAssists.add(userAssist);
        }
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

    protected String GetInstDataLockKey(String strWFInstanceId) {
        return StringHelper.Format((String)"WFINSTID:%1$s", (Object)strWFInstanceId);
    }

    public CallResult CalcTimeout(Timestamp srcTime, String strTimeoutType, int nAmount, String strWorkdayType) {
        CallResult callResult = new CallResult();
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(srcTime.getTime()));
        if (StringHelper.Compare((String)strTimeoutType, (String)"DAY", (boolean)true) == 0) {
            cal.add(5, nAmount);
            callResult.setUserObject((Object)new Timestamp(cal.getTime().getTime()));
            return callResult;
        }
        if (StringHelper.Compare((String)strTimeoutType, (String)"HOUR", (boolean)true) == 0) {
            cal.add(10, nAmount);
            callResult.setUserObject((Object)new Timestamp(cal.getTime().getTime()));
            return callResult;
        }
        if (StringHelper.Compare((String)strTimeoutType, (String)"MINUTE", (boolean)true) == 0) {
            cal.add(12, nAmount);
            callResult.setUserObject((Object)new Timestamp(cal.getTime().getTime()));
            return callResult;
        }
        if (StringHelper.Compare((String)strTimeoutType, (String)"WORKDAY", (boolean)true) == 0) {
            BaseDataEntity dataEntity = new BaseDataEntity();
            dataEntity.SetParamValue("ACTION", (Object)"ADDDAY");
            dataEntity.SetParamValue("SRCTIME", (Object)srcTime);
            dataEntity.SetParamValue("AMOUNT", (Object)nAmount);
            dataEntity.SetParamValue("WORKTIMEID", (Object)strWorkdayType);
            IDEDataCtrl workTimeDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrl("DE0056", "SYSTEM", null);
            if (workTimeDataCtrl == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0056"));
                return callResult;
            }
            callResult = workTimeDataCtrl.CustomCall("CALC", dataEntity);
            if (callResult.IsError()) {
                return callResult;
            }
            Timestamp dstTime = dataEntity.GetParamTimestampValue("DSTTIME", null);
            if (dstTime == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u5de5\u4f5c\u65f6\u95f4\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61\u5904\u7406\u5f02\u5e38"));
                return callResult;
            }
            callResult.setUserObject((Object)dstTime);
            return callResult;
        }
        callResult.setRetCode(5);
        callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u8d85\u65f6\u7c7b\u578b[%1$s]", (Object)strTimeoutType));
        return callResult;
    }

    public boolean isMultiUse() {
        return false;
    }

    public CallResult GetWFSystemUser(ISRFWFContext iWFContext, String strActorId, Vector<WFUser> list) {
        CallResult callResult = new CallResult();
        callResult.setRetCode(20);
        return callResult;
    }
}

