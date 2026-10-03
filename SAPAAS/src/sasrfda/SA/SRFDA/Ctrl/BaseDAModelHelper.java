/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.CallParam
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.DataEx.BaseDBCallerHelperEx
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.Data.AppUITheme;
import SA.SRFDA.Ctrl.Data.Chart;
import SA.SRFDA.Ctrl.Data.CodeList;
import SA.SRFDA.Ctrl.Data.ConfigPublisher;
import SA.SRFDA.Ctrl.Data.Counter;
import SA.SRFDA.Ctrl.Data.CounterType;
import SA.SRFDA.Ctrl.Data.DBAction;
import SA.SRFDA.Ctrl.Data.DBActionStep;
import SA.SRFDA.Ctrl.Data.DBObject;
import SA.SRFDA.Ctrl.Data.DBStorage;
import SA.SRFDA.Ctrl.Data.DEACMode;
import SA.SRFDA.Ctrl.Data.DEAction;
import SA.SRFDA.Ctrl.Data.DEDCProcType;
import SA.SRFDA.Ctrl.Data.DEDCProcess;
import SA.SRFDA.Ctrl.Data.DEDSCtrl;
import SA.SRFDA.Ctrl.Data.DEDataAction;
import SA.SRFDA.Ctrl.Data.DEDataChgDisp;
import SA.SRFDA.Ctrl.Data.DEDataCtrl;
import SA.SRFDA.Ctrl.Data.DEDataImport;
import SA.SRFDA.Ctrl.Data.DEDataSync;
import SA.SRFDA.Ctrl.Data.DEField;
import SA.SRFDA.Ctrl.Data.DEMAField;
import SA.SRFDA.Ctrl.Data.DEMSMA;
import SA.SRFDA.Ctrl.Data.DEMSMap;
import SA.SRFDA.Ctrl.Data.DEMainAction;
import SA.SRFDA.Ctrl.Data.DEMainState;
import SA.SRFDA.Ctrl.Data.DEMobile;
import SA.SRFDA.Ctrl.Data.DER11;
import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.Data.DER1NEx;
import SA.SRFDA.Ctrl.Data.DERCUSTOM;
import SA.SRFDA.Ctrl.Data.DERGroup;
import SA.SRFDA.Ctrl.Data.DERGroupDetail;
import SA.SRFDA.Ctrl.Data.DERGroupFolder;
import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.Data.DERMode;
import SA.SRFDA.Ctrl.Data.DERType;
import SA.SRFDA.Ctrl.Data.DEShortcut;
import SA.SRFDA.Ctrl.Data.DESubWF;
import SA.SRFDA.Ctrl.Data.DETBBHandler;
import SA.SRFDA.Ctrl.Data.DEWF;
import SA.SRFDA.Ctrl.Data.DEWFDetail;
import SA.SRFDA.Ctrl.Data.DEWizard;
import SA.SRFDA.Ctrl.Data.DEWizardDetail;
import SA.SRFDA.Ctrl.Data.DGMode;
import SA.SRFDA.Ctrl.Data.DGModeDetail;
import SA.SRFDA.Ctrl.Data.DataEntity;
import SA.SRFDA.Ctrl.Data.DataGrid;
import SA.SRFDA.Ctrl.Data.DataGridEx;
import SA.SRFDA.Ctrl.Data.DataNotify;
import SA.SRFDA.Ctrl.Data.DataRange;
import SA.SRFDA.Ctrl.Data.DataSyncAgent;
import SA.SRFDA.Ctrl.Data.FIUpdate;
import SA.SRFDA.Ctrl.Data.Form;
import SA.SRFDA.Ctrl.Data.FormItemEx;
import SA.SRFDA.Ctrl.Data.Func;
import SA.SRFDA.Ctrl.Data.GSRGroupColumn;
import SA.SRFDA.Ctrl.Data.GSRMeasure;
import SA.SRFDA.Ctrl.Data.GlobalObject;
import SA.SRFDA.Ctrl.Data.GroupStatisticsRep;
import SA.SRFDA.Ctrl.Data.IgnorePatch;
import SA.SRFDA.Ctrl.Data.LanguageItem;
import SA.SRFDA.Ctrl.Data.LayoutItem;
import SA.SRFDA.Ctrl.Data.List;
import SA.SRFDA.Ctrl.Data.MBList;
import SA.SRFDA.Ctrl.Data.MBPanel;
import SA.SRFDA.Ctrl.Data.MainMenu;
import SA.SRFDA.Ctrl.Data.ORGTree;
import SA.SRFDA.Ctrl.Data.ORGTreeNode;
import SA.SRFDA.Ctrl.Data.ORGTreeNodeType;
import SA.SRFDA.Ctrl.Data.ORGTreeType;
import SA.SRFDA.Ctrl.Data.ORGUnit;
import SA.SRFDA.Ctrl.Data.ORGUnitType;
import SA.SRFDA.Ctrl.Data.PPModel;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.Data.PageLogic;
import SA.SRFDA.Ctrl.Data.PageParam;
import SA.SRFDA.Ctrl.Data.PrintForm;
import SA.SRFDA.Ctrl.Data.QueryModel;
import SA.SRFDA.Ctrl.Data.RCALDetail;
import SA.SRFDA.Ctrl.Data.RCAccList;
import SA.SRFDA.Ctrl.Data.Registry;
import SA.SRFDA.Ctrl.Data.Report;
import SA.SRFDA.Ctrl.Data.SearchForm;
import SA.SRFDA.Ctrl.Data.SubSystem;
import SA.SRFDA.Ctrl.Data.SummaryPage;
import SA.SRFDA.Ctrl.Data.SyncAgentType;
import SA.SRFDA.Ctrl.Data.Toolbar;
import SA.SRFDA.Ctrl.Data.UserDGTheme;
import SA.SRFDA.Ctrl.Data.UserGroup;
import SA.SRFDA.Ctrl.Data.UserRole;
import SA.SRFDA.Ctrl.Data.UserRoleDEField;
import SA.SRFDA.Ctrl.Data.UserRoleData;
import SA.SRFDA.Ctrl.Data.UserRoleDataAction;
import SA.SRFDA.Ctrl.Data.UserRoleDataDetail;
import SA.SRFDA.Ctrl.Data.UserRoleRes;
import SA.SRFDA.Ctrl.Data.WebPart;
import SA.SRFDA.Ctrl.IDAModelHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParam;
import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.DataEx.BaseDBCallerHelperEx;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class BaseDAModelHelper
implements IDAModelHelper {
    protected BaseDBCallerHelperEx dbCallerHelperEx = null;
    protected static final String USER_SYSTEM = "SYSTEM";
    private static final Log log = LogFactory.getLog(BaseDAModelHelper.class);
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;
    protected Hashtable<String, Integer> deModelVersionMap = new Hashtable();
    protected HashMap<String, DataEntity> preloadDataEntityMap = null;
    protected HashMap<String, Vector<DEField>> preloadDEFieldsMap = null;

    public CallResult Init(BaseDBCallerHelperEx dbCallerHelperEx) {
        this.dbCallerHelperEx = dbCallerHelperEx;
        return this.OnInit();
    }

    protected CallResult OnInit() {
        CallResult callResult = new CallResult();
        callResult.setRetCode(0);
        callResult = this.PrepareDEModelVersion();
        if (callResult.IsError()) {
            return callResult;
        }
        this.PrepareDEModelEnv();
        return callResult;
    }

    @Override
    public void startPreload() {
    }

    @Override
    public void stopPreload() {
        this.preloadDataEntityMap = null;
        this.preloadDEFieldsMap = null;
    }

    public CallResult GetTotalDEFieldsNoSort(Vector<DEField> list) {
        return this.SelectMulti(this.GetSQL_GetTotalDEFieldsNoSort(), list, DEField.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetTotalDEFieldsNoSort() {
        if (this.iDAGlobalHelper.getDAModelVersion() < 11103100) {
            return StringHelper.Format((String)"select * from t_SRFDEField where  ENABLE = 1 ");
        }
        return StringHelper.Format((String)"select t1.*,t2.FIUPDATENAME as DGFIUPDATENAME from t_SRFDEField t1 LEFT JOIN T_SRFFIUPDATE t2 on t1.DGFIUPDATEID = t2.FIUPDATEID where t1.ENABLE = 1 ");
    }

    public CallResult GetTotalDataEntities(Vector<DataEntity> list) {
        return this.SelectMulti(this.GetSQL_GetTotalDataEntities(), list, DataEntity.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetTotalDataEntities() {
        return StringHelper.Format((String)"select t1.*,t2.ISENABLEWF from t_SRFDataEntity t1 LEFT JOIN T_SRFDEWF t2 ON t1.DEID=t2.DEID ");
    }

    @Override
    public void setPreloadDEIds(String strDEIds) {
    }

    protected void PrepareDEModelEnv() {
        this.ExecuteWithoutResult("UPDATE t_SRFDEFIELD SET  PREDEFINETYPE = NULL WHERE DEFID='DE0002_ISINDEXTYPE'");
    }

    @Override
    public void SetDAGlobalHelper(ISRFDAGlobalHelper iDAGlobalHelper) {
        this.iDAGlobalHelper = iDAGlobalHelper;
    }

    protected BaseDBCallerHelperEx getDBCallerHelper() {
        return this.dbCallerHelperEx;
    }

    protected CallResult PrepareDEModelVersion() {
        this.deModelVersionMap.clear();
        Vector<BaseDataEntity> list = new Vector();
        String strSQL = StringHelper.Format((String)"select DEID,DBVERSION from t_SRFDATAENTITY ");
        CallResult callResult = this.SelectMulti(strSQL, list, "", USER_SYSTEM);
        if (callResult.IsError() && (callResult = this.SelectMulti(strSQL = StringHelper.Format((String)"select DEID from t_SRFDATAENTITY "), list, "", USER_SYSTEM)).IsError()) {
            return callResult;
        }
        for (BaseDataEntity dataEntity : list) {
            String strDEId = dataEntity.GetParamStringValue("DEID", "");
            int nVersion = dataEntity.GetParamIntValue("DBVERSION", 99999999);
            this.deModelVersionMap.put(strDEId, nVersion);
        }
        return callResult;
    }

    @Override
    public int GetDEModelVersion(String strDEId) {
        if (this.deModelVersionMap.containsKey(strDEId)) {
            return this.deModelVersionMap.get(strDEId);
        }
        return -1;
    }

    @Override
    public CallResult GetDataEntity(String strDataEntityId, DataEntity dataEntity) {
        DataEntity cacheDataEntity;
        if (this.preloadDataEntityMap != null && (cacheDataEntity = this.preloadDataEntityMap.get(strDataEntityId.toUpperCase())) != null) {
            cacheDataEntity.CopyTo(dataEntity, true);
            return new CallResult();
        }
        return this.SelectSingle(this.GetSQL_GetDataEntity(strDataEntityId), dataEntity, USER_SYSTEM);
    }

    protected String GetSQL_GetDataEntity(String strDataEntityId) {
        return StringHelper.Format((String)"select t1.*,t2.ISENABLEWF from t_SRFDataEntity t1 LEFT JOIN T_SRFDEWF t2 ON t1.DEID=t2.DEID  where t1.DEID='%1$s'", (Object)strDataEntityId);
    }

    @Override
    public CallResult GetDEVersion(String strDataEntityId, DataEntity dataEntity) {
        Date runTime = new Date();
        CallResult callResult = this.SelectSingle(this.GetSQL_GetDEVersion(strDataEntityId), dataEntity, USER_SYSTEM);
        this.LogPerformance(runTime, "GetDEVersion", "");
        return callResult;
    }

    protected String GetSQL_GetDEVersion(String strDataEntityId) {
        return StringHelper.Format((String)"select DEID,DEVERSION from t_SRFDataEntity where DEID='%1$s'", (Object)strDataEntityId);
    }

    @Override
    public CallResult GetDataEntities(String strDEGROUP, Vector<DataEntity> list) {
        return this.SelectMulti(this.GetSQL_GetDataEntities(strDEGROUP), list, DataEntity.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetDataEntities(String strDEGROUP) {
        return StringHelper.Format((String)"select DEID from T_SRFDATAENTITY where UPPER(DEGROUP)='%1$s' ORDER By DEID ASC", (Object)strDEGROUP.toUpperCase());
    }

    @Override
    public CallResult GetUserDEDataGrids(String strOwnerId, String strDataEntityId, String strDGMode, Vector<DataGrid> list) {
        return this.SelectMulti(this.GetSQL_GetUserDEDataGrids(strOwnerId, strDataEntityId, strDGMode), list, DataGrid.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetUserDEDataGrids(String strOwnerId, String strDataEntityId, String strDGMode) {
        return StringHelper.Format((String)"select * from t_SRFDataGrid where ISMAJOR=1  AND (OWNERID IS NULL OR OWNERID='' OR OWNERID ='%2$s') AND (RESERVER IS NULL OR RESERVER ='' OR RESERVER='%3$s') AND DEID='%1$s' order by ORDERVALUE ASC,DataGridName ASC", (Object)strDataEntityId, (Object)strOwnerId, (Object)strDGMode);
    }

    @Override
    public CallResult GetExcelExportDEDataGrid(String strDataEntityId, DataGrid dataGrid) {
        if (this.iDAGlobalHelper.getDAModelVersion() >= 10042700) {
            return this.SelectSingle(this.GetSQL_GetExcelExportDEDataGrid(strDataEntityId), dataGrid, USER_SYSTEM);
        }
        return CallResult.Create((int)3);
    }

    protected String GetSQL_GetExcelExportDEDataGrid(String strDataEntityId) {
        return StringHelper.Format((String)"select * from t_SRFDataGrid where ISEXCELEXPORT=1  AND (OWNERID IS NULL OR OWNERID='') AND DEID='%1$s'", (Object)strDataEntityId);
    }

    @Override
    public CallResult GetDEWF(String strDEId, DEWF deWF) {
        return this.SelectSingle(this.GetSQL_GetDEWF(strDEId), deWF, USER_SYSTEM);
    }

    protected String GetSQL_GetDEWF(String strDEId) {
        return StringHelper.Format((String)"select t1.* from V_SRFDEWF t1 where DEID='%1$s'", (Object)strDEId);
    }

    @Override
    public CallResult GetSummaryPages(String strDataEntityId, String strMode, Vector<SummaryPage> list) {
        return this.SelectMulti(this.GetSQL_GetSummaryPages(strDataEntityId, strMode), list, SummaryPage.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetSummaryPages(String strDataEntityId, String strMode) {
        if (StringHelper.Compare((String)strMode, (String)"DER", (boolean)true) == 0) {
            return StringHelper.Format((String)"select * from V_SRFSUMMARYPAGE where DEID='%1$s' AND (DERSHOWORDER IS NULL OR DERSHOWORDER>0)   order by DERSHOWORDER ASC", (Object)strDataEntityId);
        }
        if (StringHelper.Compare((String)strMode, (String)"SUM", (boolean)true) == 0) {
            return StringHelper.Format((String)"select * from V_SRFSUMMARYPAGE where DEID='%1$s' AND (SUMSHOWORDER IS NULL OR SUMSHOWORDER>0)  order by SUMSHOWORDER ASC", (Object)strDataEntityId);
        }
        return "";
    }

    @Override
    public CallResult GetUserRoles(String strCurPersonId, Vector<UserRole> list) {
        return this.SelectMulti(this.GetSQL_GetUserRoles(strCurPersonId), list, UserRole.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetUserRoles(String strCurPersonId) {
        return StringHelper.Format((String)"select t2.* from  T_SRFUSERROLE t2  INNER JOIN T_SRFUSERROLEDETAIL t3 ON t2.USERROLEID=t3.USERROLEID INNER JOIN T_SRFUSEROBJECT t4 ON t3.USEROBJECTID=t4.USEROBJECTID LEFT JOIN T_SRFUSERGROUPDETAIL t5 ON t5.USERGROUPID=t4.USEROBJECTID where  ((t4.USEROBJECTTYPE ='USERGROUP' AND t5.USEROBJECTID='%1$s') OR (t4.USEROBJECTTYPE ='USER' AND t4.USEROBJECTID='%1$s'))", (Object)strCurPersonId);
    }

    @Override
    public CallResult GetUserRoles(Vector<String> userObjects, Vector<UserRole> list) {
        if (userObjects.size() == 0) {
            return new CallResult();
        }
        return this.SelectMulti(this.GetSQL_GetUserRoles(userObjects), list, UserRole.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetUserRoles(Vector<String> userObjects) {
        String strSQL = "select t2.* from  T_SRFUSERROLE t2 INNER JOIN T_SRFUSERROLEDETAIL t3 ON t2.USERROLEID=t3.USERROLEID ";
        strSQL = String.valueOf(strSQL) + "where  (";
        String strCondition = "";
        for (String strUserObjectId : userObjects) {
            if (!StringHelper.IsNullOrEmpty((String)strCondition)) {
                strCondition = String.valueOf(strCondition) + " OR ";
            }
            strCondition = String.valueOf(strCondition) + StringHelper.Format((String)"t3.USEROBJECTID='%1$s'", (Object)strUserObjectId);
        }
        strSQL = String.valueOf(strSQL) + strCondition;
        strSQL = String.valueOf(strSQL) + ")";
        return strSQL;
    }

    @Override
    public CallResult GetUserRoleDatas(String strDataEntityId, String strCurPersonId, Vector<UserRoleData> list) {
        return this.SelectMulti(this.GetSQL_GetUserRoleDatas(strDataEntityId, strCurPersonId), list, UserRoleData.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetUserRoleDatas(String strDataEntityId, String strCurPersonId) {
        return StringHelper.Format((String)"select t1.* from T_SRFUSERROLEDATA t1 INNER JOIN T_SRFUSERROLEDATAS t6 ON t1.USERROLEDATAID = t6.USERROLEDATAID INNER JOIN T_SRFUSERROLE t2 on t6.USERROLEID=t2.USERROLEID INNER JOIN T_SRFUSERROLEDETAIL t3 ON t2.USERROLEID=t3.USERROLEID INNER JOIN T_SRFUSEROBJECT t4 ON t3.USEROBJECTID=t4.USEROBJECTID LEFT JOIN T_SRFUSERGROUPDETAIL t5 ON t5.USERGROUPID=t4.USEROBJECTID where t1.DEID='%1$s' AND ((t4.USEROBJECTTYPE ='USERGROUP' AND t5.USEROBJECTID='%2$s') OR (t4.USEROBJECTTYPE ='USER' AND t4.USEROBJECTID='%2$s'))", (Object)strDataEntityId, (Object)strCurPersonId);
    }

    @Override
    public CallResult GetUserRoleDatas(String strDataEntityId, Vector<String> userObjects, Vector<UserRoleData> list) {
        if (userObjects.size() == 0) {
            return new CallResult();
        }
        return this.SelectMulti(this.GetSQL_GetUserRoleDatas(strDataEntityId, userObjects), list, UserRoleData.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetUserRoleDatas(String strDataEntityId, Vector<String> userObjects) {
        String strSQL = StringHelper.Format((String)"select t1.* from T_SRFUSERROLEDATA t1 INNER JOIN T_SRFUSERROLEDATAS t6 ON t1.USERROLEDATAID = t6.USERROLEDATAID INNER JOIN T_SRFUSERROLE t2 on t6.USERROLEID=t2.USERROLEID INNER JOIN T_SRFUSERROLEDETAIL t3 ON t2.USERROLEID=t3.USERROLEID where t1.DEID='%1$s' AND ", (Object)strDataEntityId);
        strSQL = String.valueOf(strSQL) + "  (";
        String strCondition = "";
        for (String strUserObjectId : userObjects) {
            if (!StringHelper.IsNullOrEmpty((String)strCondition)) {
                strCondition = String.valueOf(strCondition) + " OR ";
            }
            strCondition = String.valueOf(strCondition) + StringHelper.Format((String)"t3.USEROBJECTID='%1$s'", (Object)strUserObjectId);
        }
        strSQL = String.valueOf(strSQL) + strCondition;
        strSQL = String.valueOf(strSQL) + ")";
        return strSQL;
    }

    @Override
    public CallResult GetUserRoleDEFields(String strDataEntityId, String strCurPersonId, Vector<UserRoleDEField> list) {
        if (this.iDAGlobalHelper.getDAModelVersion() < 10122900) {
            return new CallResult();
        }
        return this.SelectMulti(this.GetSQL_GetUserRoleDEFields(strDataEntityId, strCurPersonId), list, UserRoleDEField.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetUserRoleDEFields(String strDataEntityId, String strCurPersonId) {
        return StringHelper.Format((String)"select t1.* from T_SRFUSERROLEDEFIELD t1 INNER JOIN T_SRFUSERROLEDEFIELDS t6 ON t1.USERROLEDEFIELDID = t6.USERROLEDEFIELDID INNER JOIN T_SRFUSERROLE t2 on t6.USERROLEID=t2.USERROLEID INNER JOIN T_SRFUSERROLEDETAIL t3 ON t2.USERROLEID=t3.USERROLEID INNER JOIN T_SRFUSEROBJECT t4 ON t3.USEROBJECTID=t4.USEROBJECTID LEFT JOIN T_SRFUSERGROUPDETAIL t5 ON t5.USERGROUPID=t4.USEROBJECTID where t1.DEID='%1$s' AND ((t4.USEROBJECTTYPE ='USERGROUP' AND t5.USEROBJECTID='%2$s') OR (t4.USEROBJECTTYPE ='USER' AND t4.USEROBJECTID='%2$s'))", (Object)strDataEntityId, (Object)strCurPersonId);
    }

    @Override
    public CallResult GetUserRoleDEFields(String strDataEntityId, Vector<String> userObjects, Vector<UserRoleDEField> list) {
        if (this.iDAGlobalHelper.getDAModelVersion() < 10122900) {
            return new CallResult();
        }
        if (userObjects.size() == 0) {
            return new CallResult();
        }
        return this.SelectMulti(this.GetSQL_GetUserRoleDEFields(strDataEntityId, userObjects), list, UserRoleDEField.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetUserRoleDEFields(String strDataEntityId, Vector<String> userObjects) {
        String strSQL = StringHelper.Format((String)"select t1.* from T_SRFUSERROLEDEFIELD t1 INNER JOIN T_SRFUSERROLEDEFIELDS t6 ON t1.USERROLEDEFIELDID = t6.USERROLEDEFIELDID INNER JOIN T_SRFUSERROLE t2 on t6.USERROLEID=t2.USERROLEID INNER JOIN T_SRFUSERROLEDETAIL t3 ON t2.USERROLEID=t3.USERROLEID where t1.DEID='%1$s' AND ", (Object)strDataEntityId);
        strSQL = String.valueOf(strSQL) + "  (";
        String strCondition = "";
        for (String strUserObjectId : userObjects) {
            if (!StringHelper.IsNullOrEmpty((String)strCondition)) {
                strCondition = String.valueOf(strCondition) + " OR ";
            }
            strCondition = String.valueOf(strCondition) + StringHelper.Format((String)"t3.USEROBJECTID='%1$s'", (Object)strUserObjectId);
        }
        strSQL = String.valueOf(strSQL) + strCondition;
        strSQL = String.valueOf(strSQL) + ")";
        return strSQL;
    }

    @Override
    public CallResult GetUserRoleReses(String strResType, String strRealResId, String strCurPersonId, Vector<UserRoleRes> list) {
        return this.SelectMulti(this.GetSQL_GetUserRoleReses(strResType, strRealResId, strCurPersonId), list, UserRoleRes.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetUserRoleReses(String strResType, String strRealResId, String strCurPersonId) {
        return StringHelper.Format((String)"select t1.* from t_SRFUSERROLERES t1  INNER JOIN T_SRFUNIRES t6 ON t1.UNIRESID = t6.UNIRESID  INNER JOIN T_SRFUSERROLE t2 ON t1.USERROLEID = t2.USERROLEID  INNER JOIN T_SRFUSERROLEDETAIL t3 ON t2.USERROLEID=t3.USERROLEID  INNER JOIN T_SRFUSEROBJECT t4 ON t3.USEROBJECTID=t4.USEROBJECTID  LEFT JOIN T_SRFUSERGROUPDETAIL t5 ON t5.USERGROUPID=t4.USEROBJECTID  where ((UPPER(t6.UNIRESTYPE)='%1$s' AND UPPER(t6.PAGEID)='%2$s') OR (UPPER(t6.UNIRESTYPE)='%1$s' AND UPPER(t6.REPORTID)='%2$s') OR (UPPER(t6.UNIRESTYPE)='%1$s' AND UPPER(t6.RESOURCEID)='%2$s') )    AND ((t4.USEROBJECTTYPE ='USERGROUP' AND UPPER(t5.USEROBJECTID)='%3$s') OR (t4.USEROBJECTTYPE ='USER' AND UPPER(t4.USEROBJECTID)='%3$s'))", (Object)strResType.toUpperCase(), (Object)strRealResId.toUpperCase(), (Object)strCurPersonId.toUpperCase());
    }

    @Override
    public CallResult GetUserRoleReses(String strResType, String strRealResId, Vector<String> userObjects, Vector<UserRoleRes> list) {
        if (userObjects.size() == 0) {
            return new CallResult();
        }
        return this.SelectMulti(this.GetSQL_GetUserRoleReses(strResType, strRealResId, userObjects), list, UserRoleRes.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetUserRoleReses(String strResType, String strRealResId, Vector<String> userObjects) {
        String strSQL = StringHelper.Format((String)"select t1.* from t_SRFUSERROLERES t1  INNER JOIN T_SRFUNIRES t6 ON t1.UNIRESID = t6.UNIRESID  INNER JOIN T_SRFUSERROLE t2 ON t1.USERROLEID = t2.USERROLEID  INNER JOIN T_SRFUSERROLEDETAIL t3 ON t2.USERROLEID=t3.USERROLEID  where ((t6.UNIRESTYPE='%1$s' AND UPPER(t6.PAGEID)='%2$s') OR (t6.UNIRESTYPE='%1$s' AND UPPER(t6.REPORTID)='%2$s') OR (t6.UNIRESTYPE='%1$s' AND UPPER(t6.RESOURCEID)='%3$s') )   AND ", (Object)strResType, (Object)strRealResId.toUpperCase(), (Object)strRealResId.toUpperCase());
        strSQL = String.valueOf(strSQL) + "  (";
        String strCondition = "";
        for (String strUserObjectId : userObjects) {
            if (!StringHelper.IsNullOrEmpty((String)strCondition)) {
                strCondition = String.valueOf(strCondition) + " OR ";
            }
            strCondition = String.valueOf(strCondition) + StringHelper.Format((String)"t3.USEROBJECTID='%1$s'", (Object)strUserObjectId);
        }
        strSQL = String.valueOf(strSQL) + strCondition;
        strSQL = String.valueOf(strSQL) + ")";
        return strSQL;
    }

    @Override
    public CallResult GetUserRoleDataActions(String strUserRoleDataId, Vector<UserRoleDataAction> list) {
        return this.SelectMulti(this.GetSQL_GetUserRoleDataActions(strUserRoleDataId), list, UserRoleDataAction.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetUserRoleDataActions(String strUserRoleDataId) {
        return StringHelper.Format((String)"select t1.* from T_SRFUSERROLEDATAACTION t1  where t1.USERROLEDATAID='%1$s' ", (Object)strUserRoleDataId);
    }

    @Override
    public CallResult GetUserRoleDataDetails(String strUserRoleDataId, Vector<UserRoleDataDetail> list) {
        return this.SelectMulti(this.GetSQL_GetUserRoleDataDetails(strUserRoleDataId), list, UserRoleDataDetail.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetUserRoleDataDetails(String strUserRoleDataId) {
        return StringHelper.Format((String)"select t1.* from T_SRFUSERROLEDATADETAIL t1  where t1.USERROLEDATAID='%1$s' ", (Object)strUserRoleDataId);
    }

    @Override
    public CallResult GetUserRoleDataDRs(String strDataEntityId, String strUserRoleDataId, Vector<DataRange> list) {
        return this.SelectMulti(this.GetSQL_GetUserRoleDataDRs(strDataEntityId, strUserRoleDataId), list, DataRange.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetUserRoleDataDRs(String strDataEntityId, String strUserRoleDataId) {
        return StringHelper.Format((String)"select t1.*,t2.ISEXCLUDE from t_SRFDataRange t1 INNER JOIN T_SRFUSERROLEDATADETAIL t2 ON t1.DATARANGEID = t2.DATARANGEID WHERE t1.DEID='%1$s' AND t2.USERROLEDATAID='%2$s'", (Object)strDataEntityId, (Object)strUserRoleDataId);
    }

    @Override
    public CallResult GetDefaultDEDataGrid(String strDataEntityId, DataGrid dataGrid) {
        return this.SelectSingle(this.GetSQL_GetDefaultDEDataGrid(strDataEntityId), dataGrid, USER_SYSTEM);
    }

    protected String GetSQL_GetDefaultDEDataGrid(String strDataEntityId) {
        return StringHelper.Format((String)"select * from t_SRFDATAGrid where  (OWNERID IS NULL OR OWNERID='SYSTEM') AND ISMAJOR = 1 and  DEID='%1$s' fetch first 1 row only", (Object)strDataEntityId);
    }

    @Override
    public CallResult GetDERGroup(String strDERGroupId, DERGroup derGroup) {
        return this.SelectSingle(this.GetSQL_GetDERGroup(strDERGroupId), derGroup, USER_SYSTEM);
    }

    protected String GetSQL_GetDERGroup(String strDERGroupId) {
        return StringHelper.Format((String)"select * from t_SRFDERGROUP where UPPER(DERGROUPID)='%1$s'", (Object)strDERGroupId.toUpperCase());
    }

    @Override
    public CallResult GetDERGroups(String strDEId, Vector<DERGroup> derGroups) {
        return this.SelectMulti(this.GetSQL_GetDERGroups(strDEId), derGroups, DERGroup.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetDERGroups(String strDEId) {
        return StringHelper.Format((String)"select * from t_SRFDERGROUP WHERE DEID='%1$s'", (Object)strDEId);
    }

    @Override
    public CallResult GetDERGroupFolder(String strDERGroupFolderId, DERGroupFolder derGroupFolder) {
        return this.SelectSingle(this.GetSQL_GetDERGroupFolder(strDERGroupFolderId), derGroupFolder, USER_SYSTEM);
    }

    protected String GetSQL_GetDERGroupFolder(String strDERGroupFolderId) {
        return StringHelper.Format((String)"select * from t_SRFDERGROUPFOLDER where UPPER(DERGROUPFOLDERID)='%1$s'", (Object)strDERGroupFolderId.toUpperCase());
    }

    @Override
    public CallResult GetDERGroupDetails(String strDERGroupId, Vector<DERGroupDetail> list) {
        return this.SelectMulti(this.GetSQL_GetDERGroupDetails(strDERGroupId), list, DERGroupDetail.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetDERGroupDetails(String strDERGroupId) {
        return StringHelper.Format((String)"select * from t_SRFDERGROUPDETAIL  WHERE DERGROUPID='%1$s' ORDER BY SHOWORDER ASC", (Object)strDERGroupId);
    }

    @Override
    public CallResult GetDGMode(String strDGModeId, DGMode dgMode) {
        return this.SelectSingle(this.GetSQL_GetDGMode(strDGModeId), dgMode, USER_SYSTEM);
    }

    protected String GetSQL_GetDGMode(String strDGModeId) {
        return StringHelper.Format((String)"select * from T_SRFDGMODE WHERE DGMODEID=UPPER('%1$s') ", (Object)strDGModeId.toUpperCase());
    }

    @Override
    public CallResult GetDGMode(String strDEId, String strDGMode, DGMode dgMode) {
        if (this.iDAGlobalHelper.getDAModelVersion() < 11110700) {
            CallResult callResult = new CallResult();
            callResult.setRetCode(3);
            return callResult;
        }
        return this.SelectSingle(this.GetSQL_GetDGMode(strDEId, strDGMode), dgMode, USER_SYSTEM);
    }

    protected String GetSQL_GetDGMode(String strDEId, String strDGMode) {
        return StringHelper.Format((String)"select * from T_SRFDGMODE WHERE DGMODE=UPPER('%1$s') AND DEID='%2$s' ", (Object)strDGMode.toUpperCase(), (Object)strDEId);
    }

    @Override
    public CallResult GetDGModeDetails(String strDGModeId, Vector<DGModeDetail> list) {
        return this.SelectMulti(this.GetSQL_GetDGModeDetails(strDGModeId), list, DGModeDetail.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetDGModeDetails(String strDGModeId) {
        return StringHelper.Format((String)"select * from V_SRFDGMODEDETAIL  WHERE DGMODEID=UPPER('%1$s') ", (Object)strDGModeId.toUpperCase());
    }

    @Override
    public CallResult GetLanguageItems(String strLanguageId, Vector<LanguageItem> list) {
        if (this.iDAGlobalHelper.getDAModelVersion() < 10072000) {
            return new CallResult();
        }
        return this.SelectMulti(this.GetSQL_GetLanguageItems(strLanguageId), list, LanguageItem.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetLanguageItems(String strLanguageId) {
        if (StringHelper.IsNullOrEmpty((String)strLanguageId)) {
            return StringHelper.Format((String)"select * from t_SRFLanguageItem  ");
        }
        return StringHelper.Format((String)"select * from t_SRFLanguageItem where LanguageId='%1$s' ", (Object)strLanguageId);
    }

    @Override
    public CallResult GetDEPrintForms(String strDEId, Vector<PrintForm> list) {
        return this.SelectMulti(this.GetSQL_GetDEPrintForms(strDEId), list, PrintForm.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetDEPrintForms(String strDEId) {
        return StringHelper.Format((String)"select * from t_SRFPRINTFORM where DEID='%1$s' ORDER by PRINTFORMNAME ", (Object)strDEId.toUpperCase());
    }

    @Override
    public CallResult GetDefaultPickupDEDataGrid(String strDataEntityId, DataGrid dataGrid, String strDGMode) {
        return this.SelectSingle(this.GetSQL_GetDefaultPickupDEDataGrid(strDataEntityId, strDGMode), dataGrid, USER_SYSTEM);
    }

    protected String GetSQL_GetDefaultPickupDEDataGrid(String strDataEntityId, String strDGMode) {
        return StringHelper.Format((String)"select * from t_SRFDATAGrid where (OWNERID IS NULL OR OWNERID='SYSTEM' OR OWNERID='') AND (ISMAJOR = 1 OR ISPICKUP = 1 ) and  UPPER(DEID)='%1$s' ORDER BY (CASE WHEN ISPICKUP IS NULL THEN 0 ELSE ISPICKUP END) DESC,ISMAJOR DESC fetch first 1 row only", (Object)strDataEntityId.toUpperCase());
    }

    @Override
    public CallResult GetDER1N(String strDERID, DER1N der1n) {
        return this.SelectSingle(this.GetSQL_GetDER1N(strDERID), der1n, USER_SYSTEM);
    }

    protected String GetSQL_GetDER1N(String strDERID) {
        if (this.iDAGlobalHelper.getDAModelVersion() < 10100600) {
            return StringHelper.Format((String)"select * from t_SRFDER1N where  UPPER(DERID)='%1$s' ", (Object)strDERID.toUpperCase());
        }
        return StringHelper.Format((String)"select * from V_SRFDER1N where  DERID='%1$s' ", (Object)strDERID);
    }

    @Override
    public CallResult GetDER11(String strDERID, DER11 der11) {
        return this.SelectSingle(this.GetSQL_GetDER11(strDERID), der11, USER_SYSTEM);
    }

    protected String GetSQL_GetDER11(String strDERID) {
        return StringHelper.Format((String)"select * from t_SRFDER11 where  UPPER(DER11_ID)='%1$s' ", (Object)strDERID.toUpperCase());
    }

    @Override
    public CallResult GetUserDEDataGrid(String strDataGridId, String strCurPersonId, DataGrid dataGrid) {
        return this.SelectSingle(this.GetSQL_GetUserDEDataGrid(strDataGridId, strCurPersonId), dataGrid, USER_SYSTEM);
    }

    protected String GetSQL_GetUserDEDataGrid(String strDataGridId, String strCurPersonId) {
        return StringHelper.Format((String)"select * from t_SRFDATAGrid where (  UPPER(OWNERID)='%2$s' OR UPPER(OWNERID)='' OR UPPER(OWNERID) IS NULL )  and  UPPER(DATAGRIDID)='%1$s' ", (Object)strDataGridId.toUpperCase(), (Object)strCurPersonId.toUpperCase());
    }

    @Override
    public CallResult GetDEDataGridEx(String strDataGridExId, String strCurPersonId, DataGridEx dataGridEx) {
        return this.SelectSingle(this.GetSQL_GetDEDataGridEx(strDataGridExId, strCurPersonId), dataGridEx, USER_SYSTEM);
    }

    protected String GetSQL_GetDEDataGridEx(String strDataGridExId, String strCurPersonId) {
        return StringHelper.Format((String)"select * from T_SRFDATAGRIDEX where   UPPER(DATAGRIDEXID)='%1$s' ", (Object)strDataGridExId.toUpperCase(), (Object)strCurPersonId.toUpperCase());
    }

    @Override
    public CallResult GetUserWFDataGrid(String strDEId, String strWFState, String strWFStep, String strCurPersonId, DataGrid dataGrid) {
        return this.SelectSingle(this.GetSQL_GetUserWFDataGrid(strDEId, strWFState, strWFStep, strCurPersonId), dataGrid, USER_SYSTEM);
    }

    protected String GetSQL_GetUserWFDataGrid(String strDEId, String strWFState, String strWFStep, String strCurPersonId) {
        if (StringHelper.IsNullOrEmpty((String)strWFStep)) {
            return StringHelper.Format((String)"select * from t_SRFDATAGrid where UPPER(DEID)='%1$s' AND (OWNERID IS NULL OR UPPER(OWNERID)='' OR OWNERID = 'SYSTEM' OR  UPPER(OWNERID) ='%2$s') AND UPPER(WFSTATE) = '%3$s' AND (WFSTEP IS NULL OR WFSTEP = '') fetch first 1 row only", (Object)strDEId.toUpperCase(), (Object)strCurPersonId.toUpperCase(), (Object)strWFState.toUpperCase());
        }
        return StringHelper.Format((String)"select * from t_SRFDATAGrid where UPPER(DEID)='%1$s' AND (OWNERID IS NULL OR UPPER(OWNERID)='' OR  OWNERID = 'SYSTEM' OR  UPPER(OWNERID) ='%2$s') AND UPPER(WFSTATE) = '%3$s' AND (WFSTEP IS NOT NULL AND UPPER(WFSTEP) = '%4$s') fetch first 1 row only", (Object)strDEId.toUpperCase(), (Object)strCurPersonId.toUpperCase(), (Object)strWFState.toUpperCase(), (Object)strWFStep.toUpperCase());
    }

    @Override
    public CallResult GetDEFields(String strDEId, Vector<DEField> list) {
        return this.SelectMulti(this.GetSQL_GetDEFields(strDEId), list, DEField.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetDEFields(String strDEId) {
        if (this.iDAGlobalHelper.getDAModelVersion() < 11103100) {
            return StringHelper.Format((String)"select * from t_SRFDEField where  UPPER(DEID)='%1$s' AND ENABLE = 1 ORDER BY ORDERFLAG", (Object)strDEId.toUpperCase());
        }
        return StringHelper.Format((String)"select t1.*,t2.FIUPDATENAME as DGFIUPDATENAME from t_SRFDEField t1 LEFT JOIN T_SRFFIUPDATE t2 on t1.DGFIUPDATEID = t2.FIUPDATEID where t1.ENABLE = 1 AND t1.DEID='%1$s' ORDER BY t1.ORDERFLAG", (Object)strDEId);
    }

    public CallResult GetAllDEFields(String strDEIds, Vector<DEField> list) {
        return this.SelectMulti(this.GetSQL_GetAllDEFields(strDEIds), list, DEField.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetAllDEFields(String strDEIds) {
        if (this.iDAGlobalHelper.getDAModelVersion() < 11103100) {
            return StringHelper.Format((String)"select * from t_SRFDEField where  UPPER(DEID) LIKE '%1$s%%' AND ENABLE = 1 ORDER BY ORDERFLAG", (Object)strDEIds.toUpperCase());
        }
        return StringHelper.Format((String)"select t1.*,t2.FIUPDATENAME as DGFIUPDATENAME from t_SRFDEField t1 LEFT JOIN T_SRFFIUPDATE t2 on t1.DGFIUPDATEID = t2.FIUPDATEID where t1.ENABLE = 1 AND t1.DEID LIKE '%1$s%%' ORDER BY t1.ORDERFLAG", (Object)strDEIds);
    }

    @Override
    public CallResult GetDEFieldsNoSort(String strDEId, Vector<DEField> list) {
        Vector<DEField> list2;
        if (this.preloadDEFieldsMap != null && (list2 = this.preloadDEFieldsMap.get(strDEId.toUpperCase())) != null) {
            list.addAll(list2);
            return new CallResult();
        }
        return this.SelectMulti(this.GetSQL_GetDEFieldsNoSort(strDEId), list, DEField.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetDEFieldsNoSort(String strDEId) {
        if (this.iDAGlobalHelper.getDAModelVersion() < 11103100) {
            return StringHelper.Format((String)"select * from t_SRFDEField where  UPPER(DEID)='%1$s' AND ENABLE = 1 ", (Object)strDEId.toUpperCase());
        }
        return StringHelper.Format((String)"select t1.*,t2.FIUPDATENAME as DGFIUPDATENAME from t_SRFDEField t1 LEFT JOIN T_SRFFIUPDATE t2 on t1.DGFIUPDATEID = t2.FIUPDATEID where t1.ENABLE = 1 AND t1.DEID='%1$s' ", (Object)strDEId);
    }

    @Override
    public CallResult GetDEField(String strDEFieldId, DEField deField) {
        return this.SelectSingle(this.GetSQL_GetDEField(strDEFieldId), deField, USER_SYSTEM);
    }

    protected String GetSQL_GetDEField(String strDEFieldId) {
        if (this.iDAGlobalHelper.getDAModelVersion() < 11103100) {
            return StringHelper.Format((String)"select * from t_SRFDEField  where UPPER(DEFID)='%1$s' AND ENABLE = 1 ", (Object)strDEFieldId.toUpperCase());
        }
        return StringHelper.Format((String)"select * from t_SRFDEField  where  ENABLE = 1 AND DEFID='%1$s'", (Object)strDEFieldId);
    }

    @Override
    public CallResult GetPage(String strPageId, Page page) {
        return this.SelectSingle(this.GetSQL_GetPage(strPageId), page, USER_SYSTEM);
    }

    protected String GetSQL_GetPage(String strPageId) {
        if (this.iDAGlobalHelper.getDAModelVersion() >= 11052400) {
            return StringHelper.Format((String)"select t1.*,t2.VERSION AS PTVERSION,t2.PAGEPATH as PTPAGEPATH,t2.PAGEPARAM AS PTPAGEPARAM,t2.TOOLBAR AS PTTOOLBAR,t2.PAGEFUNC2 AS PTPAGEFUNC2,t2.DEFAULTPAGEFUNC AS PTDEFAULTPAGEFUNC ,t2.TBTEMPLID AS TBTEMPLID from t_SRFPage  t1 LEFT JOIN T_SRFPageTempl t2 ON t1.PAGETEMPLID=t2.PAGETEMPLID where t1.PAGEID = '%1$s' ", (Object)strPageId);
        }
        if (this.iDAGlobalHelper.getDAModelVersion() >= 11012700) {
            return StringHelper.Format((String)"select t1.*,t2.VERSION AS PTVERSION,t2.PAGEPATH as PTPAGEPATH,t2.PAGEPARAM AS PTPAGEPARAM,t2.TOOLBAR AS PTTOOLBAR,t2.PAGEFUNC2 AS PTPAGEFUNC2,t2.DEFAULTPAGEFUNC AS PTDEFAULTPAGEFUNC  from t_SRFPage  t1 LEFT JOIN T_SRFPageTempl t2 ON t1.PAGETEMPLID=t2.PAGETEMPLID where t1.PAGEID = '%1$s' ", (Object)strPageId);
        }
        if (this.iDAGlobalHelper.getDAModelVersion() >= 10022300) {
            return StringHelper.Format((String)"select t1.*,t2.VERSION AS PTVERSION,t2.PAGEPATH as PTPAGEPATH,t2.PAGEPARAM AS PTPAGEPARAM,t2.TOOLBAR AS PTTOOLBAR,t2.PAGEFUNC AS PTPAGEFUNC from t_SRFPage  t1 LEFT JOIN T_SRFPageTempl t2 ON t1.PAGETEMPLID=t2.PAGETEMPLID where t1.PAGEID = '%1$s' ", (Object)strPageId);
        }
        if (this.iDAGlobalHelper.getDAModelVersion() >= 10012100) {
            return StringHelper.Format((String)"select t1.*,t2.VERSION AS PTVERSION,t2.PAGEPATH as PTPAGEPATH,t2.PAGEPARAM AS PTPAGEPARAM,t2.TOOLBAR AS PTTOOLBAR from t_SRFPage  t1 LEFT JOIN T_SRFPageTempl t2 ON t1.PAGETEMPLID=t2.PAGETEMPLID where t1.PAGEID = '%1$s' ", (Object)strPageId);
        }
        return StringHelper.Format((String)"select t1.*,t2.VERSION AS PTVERSION,t2.PAGEPATH as PTPAGEPATH,t2.PAGEPARAM AS PTPAGEPARAM from t_SRFPage  t1 LEFT JOIN T_SRFPageTempl t2 ON t1.PAGETEMPLID=t2.PAGETEMPLID where t1.PAGEID = '%1$s' ", (Object)strPageId);
    }

    @Override
    public CallResult GetPageParams(String strPageId, Vector<PageParam> pageParams) {
        if (this.iDAGlobalHelper.getDAModelVersion() >= 10121500) {
            return this.SelectMulti(this.GetSQL_GetPageParams(strPageId), pageParams, PageParam.class.getName(), USER_SYSTEM);
        }
        CallResult callResult = new CallResult();
        return callResult;
    }

    protected String GetSQL_GetPageParams(String strPageId) {
        return StringHelper.Format((String)"select t1.*  from t_SRFPageParam t1  where t1.PAGEID = '%1$s' ", (Object)strPageId);
    }

    @Override
    public CallResult GetRegistry(String strSystemName, String strSection, Registry regitry) {
        regitry.Reset();
        return this.SelectSingle(this.GetSQL_GetRegistry(strSystemName, strSection), regitry, USER_SYSTEM);
    }

    protected String GetSQL_GetRegistry(String strSystemName, String strSection) {
        return StringHelper.Format((String)"select * from t_SRFREGISTRY where UPPER(REGISTRYNAME)='%1$s' AND UPPER(SECTION)='%2$s'", (Object)strSystemName.toUpperCase(), (Object)strSection.toUpperCase());
    }

    @Override
    public CallResult GetChart(String strChartId, Chart chart) {
        return this.SelectSingle(this.GetSQL_GetChart(strChartId), chart, USER_SYSTEM);
    }

    protected String GetSQL_GetChart(String strChartId) {
        return StringHelper.Format((String)"select t1.* from t_SRFCHART  t1  where t1.CHARTID = '%1$s' ", (Object)strChartId);
    }

    @Override
    public CallResult GetWebPart(String strWebPartId, WebPart webPart) {
        return this.SelectSingle(this.GetSQL_GetWebPart(strWebPartId), webPart, USER_SYSTEM);
    }

    protected String GetSQL_GetWebPart(String strWebPartId) {
        return StringHelper.Format((String)"select t1.* from T_SRFWEBPART  t1  where t1.WEBPARTID = '%1$s' ", (Object)strWebPartId);
    }

    @Override
    public CallResult GetDBAction(String strDEId, String strDBType, String strDBAction, String strDBActionMode, DBAction dbAction) {
        if (this.iDAGlobalHelper.getDAModelVersion() >= 10012313) {
            if (StringHelper.IsNullOrEmpty((String)strDBType)) {
                return this.SelectSingle(this.GetSQL_GetDBActionEx(strDEId, strDBType, strDBAction, strDBActionMode), dbAction, USER_SYSTEM);
            }
            CallResult callResult = this.SelectSingle(this.GetSQL_GetDBActionEx(strDEId, strDBType, strDBAction, strDBActionMode), dbAction, USER_SYSTEM);
            if (callResult.IsOk()) {
                return callResult;
            }
            return this.SelectSingle(this.GetSQL_GetDBActionEx(strDEId, "", strDBAction, strDBActionMode), dbAction, USER_SYSTEM);
        }
        return this.SelectSingle(this.GetSQL_GetDBAction(strDEId, strDBAction, strDBActionMode), dbAction, USER_SYSTEM);
    }

    protected String GetSQL_GetDBAction(String strDEId, String strDBAction, String strDBActionMode) {
        return StringHelper.Format((String)"select t1.* from T_SRFDBACTION  t1  where t1.DEID = '%1$s' AND UPPER(t1.ACTION)='%2$s' AND UPPER(t1.ACTIONMODE)='%3$s' ", (Object)strDEId, (Object)strDBAction.toUpperCase(), (Object)strDBActionMode.toUpperCase());
    }

    protected String GetSQL_GetDBActionEx(String strDEId, String strDBType, String strDBAction, String strDBActionMode) {
        if (StringHelper.IsNullOrEmpty((String)strDBType)) {
            return StringHelper.Format((String)"select t1.* from T_SRFDBACTION  t1  where t1.DEID = '%1$s' AND UPPER(t1.ACTION)='%2$s' AND UPPER(t1.ACTIONMODE)='%3$s' AND t1.DBTYPE IS NULL", (Object)strDEId, (Object)strDBAction.toUpperCase(), (Object)strDBActionMode.toUpperCase());
        }
        return StringHelper.Format((String)"select t1.* from T_SRFDBACTION  t1  where t1.DEID = '%1$s' AND UPPER(t1.ACTION)='%2$s' AND UPPER(t1.ACTIONMODE)='%3$s' AND UPPER(t1.DBTYPE) ='%4$s'", (Object)strDEId, (Object)strDBAction.toUpperCase(), (Object)strDBActionMode.toUpperCase(), (Object)strDBType.toUpperCase());
    }

    @Override
    public CallResult GetDBActions(String strDEId, String strDBType, String strDBAction, Vector<DBAction> dbActions) {
        return this.SelectMulti(this.GetSQL_GetDBActions(strDEId, strDBType, strDBAction), dbActions, DBAction.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetDBActions(String strDEId, String strDBType, String strDBAction) {
        if (this.iDAGlobalHelper.getDAModelVersion() >= 10012313) {
            return StringHelper.Format((String)"select t1.* from T_SRFDBACTION  t1  where t1.DEID = '%1$s' AND UPPER(t1.ACTION)='%2$s' AND (t1.DBTYPE IS NULL OR t1.DBTYPE='%3$s') ", (Object)strDEId, (Object)strDBAction.toUpperCase(), (Object)strDBType.toUpperCase());
        }
        return StringHelper.Format((String)"select t1.* from T_SRFDBACTION  t1  where t1.DEID = '%1$s' AND UPPER(t1.ACTION)='%2$s' ", (Object)strDEId, (Object)strDBAction.toUpperCase());
    }

    @Override
    public CallResult GetDEShortcuts(String strDEId, int nShortcutType, Vector<DEShortcut> deShortcuts) {
        if (this.iDAGlobalHelper.getDAModelVersion() < 10032500) {
            return new CallResult();
        }
        return this.SelectMulti(this.GetSQL_GetDEShortcuts(strDEId, nShortcutType), deShortcuts, DEShortcut.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetDEShortcuts(String strDEId, int nShortcutType) {
        return StringHelper.Format((String)"select * from T_SRFDESHORTCUT where DEID = '%1$s' AND  ShortcutType = %2$s  order by ShowOrder ", (Object)strDEId, (Object)nShortcutType);
    }

    @Override
    public CallResult GetDEACModes(String strDEId, Vector<DEACMode> deACModes) {
        return this.SelectMulti(this.GetSQL_GetDEACModes(strDEId), deACModes, DEACMode.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetDEACModes(String strDEId) {
        return StringHelper.Format((String)"select * from t_SRFDEACMODE where DEID = '%1$s'  ", (Object)strDEId);
    }

    @Override
    public CallResult GetDEDataSyncs(String strDEId, Vector<DEDataSync> deDataSyncs) {
        if (this.GetDEModelVersion("DE0222") <= 0) {
            return new CallResult();
        }
        return this.SelectMulti(this.GetSQL_GetDEDataSyncs(strDEId), deDataSyncs, DEDataSync.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetDEDataSyncs(String strDEId) {
        return StringHelper.Format((String)"SELECT t1.*,t2.ACTIONMODE FROM T_SRFDEDATASYNC t1 LEFT JOIN T_SRFDEDATACTRL t2 ON t1.DEDATACTRLID = t2.DEDATACTRLID  where t1.ENABLE=1 AND t1.VALIDFLAG=1 AND t1.DEID='%1$S'   ", (Object)strDEId);
    }

    @Override
    public CallResult GetDBActionStep(String strDEId, String strDBType, String strDBAction, String strDBActionStep, DBActionStep dbActionStep) {
        if (this.iDAGlobalHelper.getDAModelVersion() >= 10012313) {
            CallResult callResult = this.SelectSingle(this.GetSQL_GetDBActionStepEx(strDEId, strDBType, strDBAction, strDBActionStep), dbActionStep, USER_SYSTEM);
            if (callResult.IsOk()) {
                return callResult;
            }
            return this.SelectSingle(this.GetSQL_GetDBActionStepEx(strDEId, "", strDBAction, strDBActionStep), dbActionStep, USER_SYSTEM);
        }
        return this.SelectSingle(this.GetSQL_GetDBActionStep(strDEId, strDBAction, strDBActionStep), dbActionStep, USER_SYSTEM);
    }

    protected String GetSQL_GetDBActionStep(String strDEId, String strDBAction, String strDBActionStep) {
        return StringHelper.Format((String)"select t1.* from T_SRFDBACTIONSTEP  t1  where UPPER(t1.DEID) = '%1$s' AND UPPER(t1.ACTION)='%2$s' AND UPPER(t1.ACTIONSTEP)='%3$s' ", (Object)strDEId.toUpperCase(), (Object)strDBAction.toUpperCase(), (Object)strDBActionStep.toUpperCase());
    }

    protected String GetSQL_GetDBActionStepEx(String strDEId, String strDBType, String strDBAction, String strDBActionStep) {
        if (StringHelper.IsNullOrEmpty((String)strDBType)) {
            return StringHelper.Format((String)"select t1.* from T_SRFDBACTIONSTEP  t1  where UPPER(t1.DEID) = '%1$s' AND UPPER(t1.ACTION)='%2$s' AND UPPER(t1.ACTIONSTEP)='%3$s' AND t1.DBTYPE IS NULL", (Object)strDEId.toUpperCase(), (Object)strDBAction.toUpperCase(), (Object)strDBActionStep.toUpperCase());
        }
        return StringHelper.Format((String)"select t1.* from T_SRFDBACTIONSTEP  t1  where UPPER(t1.DEID) = '%1$s' AND UPPER(t1.ACTION)='%2$s' AND UPPER(t1.ACTIONSTEP)='%3$s' AND UPPER(t1.DBTYPE) = '%4$s'", (Object)strDEId.toUpperCase(), (Object)strDBAction.toUpperCase(), (Object)strDBActionStep.toUpperCase(), (Object)strDBType.toUpperCase());
    }

    @Override
    public CallResult GetDBActionSteps(String strDEId, String strDBType, String strDBAction, String strDBActionStep, Vector<DBActionStep> dbActionSteps) {
        if (this.iDAGlobalHelper.getDAModelVersion() >= 10012313) {
            CallResult callResult = this.SelectMulti(this.GetSQL_GetDBActionStepsEx(strDEId, "", strDBAction, strDBActionStep), dbActionSteps, DBActionStep.class.getName(), USER_SYSTEM);
            if (callResult.IsError()) {
                return callResult;
            }
            return this.SelectMulti(this.GetSQL_GetDBActionStepsEx(strDEId, strDBType, strDBAction, strDBActionStep), dbActionSteps, DBActionStep.class.getName(), USER_SYSTEM);
        }
        return this.SelectMulti(this.GetSQL_GetDBActionSteps(strDEId, strDBAction, strDBActionStep), dbActionSteps, DBActionStep.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetDBActionSteps(String strDEId, String strDBAction, String strDBActionStep) {
        return StringHelper.Format((String)"select t1.* from T_SRFDBACTIONSTEP  t1  where UPPER(t1.DEID) = '%1$s' AND UPPER(t1.ACTION)='%2$s' AND UPPER(t1.ACTIONSTEP)='%3$s' ", (Object)strDEId.toUpperCase(), (Object)strDBAction.toUpperCase(), (Object)strDBActionStep.toUpperCase());
    }

    protected String GetSQL_GetDBActionStepsEx(String strDEId, String strDBType, String strDBAction, String strDBActionStep) {
        if (this.iDAGlobalHelper.getDAModelVersion() >= 11052400) {
            if (StringHelper.IsNullOrEmpty((String)strDBType)) {
                return StringHelper.Format((String)"select t1.* from T_SRFDBACTIONSTEP  t1  where UPPER(t1.DEID) = '%1$s' AND UPPER(t1.ACTION)='%2$s' AND UPPER(t1.ACTIONSTEP)='%3$s' AND t1.DBTYPE IS NULL ORDER BY t1.ORDERFLAG", (Object)strDEId.toUpperCase(), (Object)strDBAction.toUpperCase(), (Object)strDBActionStep.toUpperCase());
            }
            return StringHelper.Format((String)"select t1.* from T_SRFDBACTIONSTEP  t1  where UPPER(t1.DEID) = '%1$s' AND UPPER(t1.ACTION)='%2$s' AND UPPER(t1.ACTIONSTEP)='%3$s' AND UPPER(t1.DBTYPE) = '%4$s' ORDER BY t1.ORDERFLAG", (Object)strDEId.toUpperCase(), (Object)strDBAction.toUpperCase(), (Object)strDBActionStep.toUpperCase(), (Object)strDBType.toUpperCase());
        }
        if (StringHelper.IsNullOrEmpty((String)strDBType)) {
            return StringHelper.Format((String)"select t1.* from T_SRFDBACTIONSTEP  t1  where UPPER(t1.DEID) = '%1$s' AND UPPER(t1.ACTION)='%2$s' AND UPPER(t1.ACTIONSTEP)='%3$s' AND t1.DBTYPE IS NULL", (Object)strDEId.toUpperCase(), (Object)strDBAction.toUpperCase(), (Object)strDBActionStep.toUpperCase());
        }
        return StringHelper.Format((String)"select t1.* from T_SRFDBACTIONSTEP  t1  where UPPER(t1.DEID) = '%1$s' AND UPPER(t1.ACTION)='%2$s' AND UPPER(t1.ACTIONSTEP)='%3$s' AND UPPER(t1.DBTYPE) = '%4$s'", (Object)strDEId.toUpperCase(), (Object)strDBAction.toUpperCase(), (Object)strDBActionStep.toUpperCase(), (Object)strDBType.toUpperCase());
    }

    @Override
    public CallResult GetDEDataActions(String strDEId, Vector<DEDataAction> dataActions) {
        return this.SelectMulti(this.GetSQL_GetDEDataActions(strDEId), dataActions, DEDataAction.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetDEDataActions(String strDEId) {
        return StringHelper.Format((String)"select t1.* from T_SRFDEDATAACTION  t1  where t1.DEID = '%1$s'  ", (Object)strDEId);
    }

    @Override
    public CallResult GetDEActions(String strDEId, Vector<DEAction> deActions) {
        if (this.iDAGlobalHelper.getDAModelVersion() >= 11052400) {
            return this.SelectMulti(this.GetSQL_GetDEActions(strDEId), deActions, DEAction.class.getName(), USER_SYSTEM);
        }
        return new CallResult();
    }

    protected String GetSQL_GetDEActions(String strDEId) {
        return StringHelper.Format((String)"select t1.* from T_SRFDEACTION  t1  where t1.DEID = '%1$s'  ", (Object)strDEId);
    }

    @Override
    public CallResult GetDEDSCtrls(String strDEId, Vector<DEDSCtrl> dsctrls) {
        return this.SelectMulti(this.GetSQL_GetDEDSCtrls(strDEId), dsctrls, DEDSCtrl.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetDEDSCtrls(String strDEId) {
        return StringHelper.Format((String)"select t1.* from T_SRFDEDSCTRL  t1  where t1.DEID = '%1$s'  ", (Object)strDEId);
    }

    @Override
    public CallResult GetList(String strListId, List list) {
        return this.SelectSingle(this.GetSQL_GetList(strListId), list, USER_SYSTEM);
    }

    protected String GetSQL_GetList(String strListId) {
        return StringHelper.Format((String)"select t1.* from t_SRFLIST  t1  where t1.LISTID = '%1$s' ", (Object)strListId);
    }

    @Override
    public CallResult GetReport(String strReportId, Report report) {
        return this.SelectSingle(this.GetSQL_GetReport(strReportId), report, USER_SYSTEM);
    }

    protected String GetSQL_GetReport(String strReportId) {
        return StringHelper.Format((String)"select t1.* from t_SRFREPORT  t1  where UPPER(t1.REPORTID) = '%1$s' ", (Object)strReportId.toUpperCase());
    }

    @Override
    public CallResult GetChildReports(String strReportId, Vector<Report> reports) {
        return this.SelectMulti(this.GetSQL_GetChildReports(strReportId), reports, Report.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetChildReports(String strReportId) {
        return StringHelper.Format((String)"select t1.*,t2.ORDERFLAG from T_SRFREPORT t1  INNER JOIN T_SRFREPORTRS t2 ON t2.MINORREPORTID = t1.REPORTID  where t2.MAJORREPORTID='%1$s' ORDER BY t2.ORDERFLAG ", (Object)strReportId);
    }

    @Override
    public CallResult GetQueryModel(String strQueryModelId, QueryModel queryModel) {
        return this.SelectSingle(this.GetSQL_GetQueryModel(strQueryModelId), queryModel, USER_SYSTEM);
    }

    protected String GetSQL_GetQueryModel(String strQueryModelId) {
        return StringHelper.Format((String)"select t1.* from t_SRFQUERYMODEL  t1  where UPPER(t1.QUERYMODELID) = '%1$s' ", (Object)strQueryModelId.toUpperCase());
    }

    @Override
    public int GetPageVersion(String strPageId) {
        return this.SelectVersion(this.GetSQL_GetPageVersion(), strPageId);
    }

    protected String GetSQL_GetPageVersion() {
        return StringHelper.Format((String)"select (t1.VERSION * (CASE  WHEN t2.VERSION IS NULL THEN 1 ELSE t2.VERSION END)) AS VERSION from t_SRFPage t1 LEFT JOIN T_SRFPageTempl t2 ON t1.PAGETEMPLID=t2.PAGETEMPLID where t1.PAGEID=?");
    }

    @Override
    public CallResult GetMainMenu(String strMainMenuId, MainMenu mainMenu) {
        return this.SelectSingle(this.GetSQL_GetMainMenu(strMainMenuId), mainMenu, USER_SYSTEM);
    }

    protected String GetSQL_GetMainMenu(String strMainMenuId) {
        return StringHelper.Format((String)"select * from t_SRFMainMenu  where UPPER(USERMODE)='%1$s' fetch first 1 row only", (Object)strMainMenuId.toUpperCase());
    }

    @Override
    public CallResult GetFunc(String strFuncId, Func func) {
        return this.SelectSingle(this.GetSQL_GetFunc(strFuncId), func, USER_SYSTEM);
    }

    protected String GetSQL_GetFunc(String strFuncId) {
        return StringHelper.Format((String)"select * from t_SRFFUNC  where FUNC_ID='%1$s' fetch first 1 row only", (Object)strFuncId);
    }

    @Override
    public CallResult GetDERType(String strDERTypeId, DERType derType) {
        return this.SelectSingle(this.GetSQL_GetDERType(strDERTypeId), derType, USER_SYSTEM);
    }

    protected String GetSQL_GetDERType(String strDERTypeId) {
        return StringHelper.Format((String)"select * from T_SRFDERTYPE  where UPPER(DERTYPEID)='%1$s' fetch first 1 row only", (Object)strDERTypeId.toUpperCase());
    }

    @Override
    public CallResult GetCodeList(String strCodeListId, CodeList codeList) {
        return this.SelectSingle(this.GetSQL_GetCodeList(strCodeListId), codeList, USER_SYSTEM);
    }

    protected String GetSQL_GetCodeList(String strCodeListId) {
        return StringHelper.Format((String)"select * from T_SRFCODELIST  where CODELISTID='%1$s' ", (Object)strCodeListId);
    }

    @Override
    public CallResult GetDEACMode(String strDEId, String strACMode, DEACMode deACMode) {
        return this.SelectSingle(this.GetSQL_GetDEACMode(strDEId, strACMode), deACMode, USER_SYSTEM);
    }

    protected String GetSQL_GetDEACMode(String strDEId, String strACMode) {
        return StringHelper.Format((String)"select * from T_SRFDEACMODE where DEID='%1$s' AND  UPPER(DEACMODENAME)='%2$s' ", (Object)strDEId, (Object)strACMode.toUpperCase());
    }

    @Override
    public CallResult GetDefaultDEMainForm(String strDEId, Form form) {
        return this.SelectSingle(this.GetSQL_GetDefaultDEMainForm(strDEId), form, USER_SYSTEM);
    }

    protected String GetSQL_GetDefaultDEMainForm(String strDEId) {
        return StringHelper.Format((String)"select * from t_SRFFORM where DEID='%1$s' AND ISMAJOR=1 fetch first 1 row only", (Object)strDEId);
    }

    @Override
    public CallResult GetDEForm(String strDEFormId, Form form) {
        return this.SelectSingle(this.GetSQL_GetDEForm(strDEFormId), form, USER_SYSTEM);
    }

    protected String GetSQL_GetDEForm(String strDEFormId) {
        return StringHelper.Format((String)"select * from t_SRFFORM where FORMID='%1$s' ", (Object)strDEFormId);
    }

    @Override
    public CallResult GetDEWFForm(String strDEId, String strWFFormName, Form form) {
        return this.SelectSingle(this.GetSQL_GetDEWFForm(strDEId, strWFFormName), form, USER_SYSTEM);
    }

    protected String GetSQL_GetDEWFForm(String strDEId, String strWFFormName) {
        return StringHelper.Format((String)"select * from t_SRFFORM where DEID='%1$s' AND (ISWFFORM IS NOT NULL AND ISWFFORM=1) AND (WFFORMNAME IS NOT NULL AND UPPER(WFFORMNAME)='%2$s') fetch first 1 row only", (Object)strDEId, (Object)strWFFormName.toUpperCase());
    }

    @Override
    public CallResult GetDESearchForm(String strSearchFormId, SearchForm searchForm) {
        return this.SelectSingle(this.GetSQL_GetDESearchForm(strSearchFormId), searchForm, USER_SYSTEM);
    }

    protected String GetSQL_GetDESearchForm(String strSearchFormId) {
        return StringHelper.Format((String)"select * from t_SRFSEARCHFORM where  SEARCHFORMID='%1$s'", (Object)strSearchFormId);
    }

    @Override
    public CallResult GetDEWFDetail(String strDEId, String strWFMode, DEWFDetail deWFDetail) {
        return this.SelectSingle(this.GetSQL_GetDEWFDetail(strDEId, strWFMode), deWFDetail, USER_SYSTEM);
    }

    protected String GetSQL_GetDEWFDetail(String strDEId, String strWFMode) {
        return StringHelper.Format((String)"select * from T_SRFDEWFDETAIL where DEID='%1$s' AND (UPPER(WFMODE) ='%2$s') fetch first 1 row only", (Object)strDEId, (Object)strWFMode.toUpperCase());
    }

    @Override
    public CallResult GetDEWFPrintForm(String strDEId, String strWFPrintFormName, PrintForm form) {
        return this.SelectSingle(this.GetSQL_GetDEWFPrintForm(strDEId, strWFPrintFormName), form, USER_SYSTEM);
    }

    protected String GetSQL_GetDEWFPrintForm(String strDEId, String strWFPrintFormName) {
        return StringHelper.Format((String)"select * from t_SRFPRINTFORM where UPPER(DEID)='%1$s' AND (ISWFFORM IS NOT NULL AND ISWFFORM=1) AND (WFFORMNAME IS NOT NULL AND UPPER(WFFORMNAME)='%2$s') fetch first 1 row only", (Object)strDEId.toUpperCase(), (Object)strWFPrintFormName.toUpperCase());
    }

    @Override
    public CallResult GetDEPrintForm(String strDEId, String strFormName, PrintForm printform) {
        return this.SelectSingle(this.GetSQL_GetDEPrintForm(strDEId, strFormName), printform, USER_SYSTEM);
    }

    protected String GetSQL_GetDEPrintForm(String strDEId, String strFormName) {
        return StringHelper.Format((String)"select * from t_SRFPRINTFORM where UPPER(DEID)='%1$s'  AND (WFFORMNAME IS NOT NULL AND UPPER(WFFORMNAME)='%2$s') fetch first 1 row only", (Object)strDEId.toUpperCase(), (Object)strFormName.toUpperCase());
    }

    @Override
    public CallResult GetDER1Ns(String strDEId, Vector<DER1N> list) {
        return this.SelectMulti(this.GetSQL_GetDER1Ns(strDEId), list, DER1N.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetDER1Ns(String strDEId) {
        return StringHelper.Format((String)"select * from V_SRFDER1N where MAJORDEID='%1$s' ", (Object)strDEId);
    }

    @Override
    public CallResult GetDER1NExs(String strDEId, Vector<DER1NEx> list) {
        if (this.GetDEModelVersion("DE0206") >= 0) {
            return this.SelectMulti(this.GetSQL_GetDER1NExs(strDEId), list, DER1NEx.class.getName(), USER_SYSTEM);
        }
        return new CallResult();
    }

    protected String GetSQL_GetDER1NExs(String strDEId) {
        return StringHelper.Format((String)"select t1.* from T_SRFDER1NEX t1 where DEID='%1$s' ", (Object)strDEId);
    }

    @Override
    public CallResult GetDER11s(boolean bMain, String strDEId, Vector<DER11> list) {
        return this.SelectMulti(this.GetSQL_GetDER11s(bMain, strDEId), list, DER11.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetDER11s(boolean bMain, String strDEId) {
        if (bMain) {
            return StringHelper.Format((String)"select * from V_SRFDER11 where MAJORDEID='%1$s' ", (Object)strDEId);
        }
        return StringHelper.Format((String)"select * from V_SRFDER11 where MINORDEID='%1$s' ", (Object)strDEId);
    }

    @Override
    public CallResult GetDERCUSTOM(String strDERID, DERCUSTOM derCustom) {
        return this.SelectSingle(this.GetSQL_GetDERCUSTOM(strDERID), derCustom, USER_SYSTEM);
    }

    protected String GetSQL_GetDERCUSTOM(String strDERID) {
        return StringHelper.Format((String)"select * from V_SRFCUSTOMDER where  CUSTOMDERID='%1$s' ", (Object)strDERID);
    }

    @Override
    public CallResult GetDERCUSTOMs(boolean bMain, String strDEId, Vector<DERCUSTOM> list) {
        if (this.iDAGlobalHelper.getDAModelVersion() < 11011100) {
            return new CallResult();
        }
        return this.SelectMulti(this.GetSQL_GetDERCUSTOMs(bMain, strDEId), list, DERCUSTOM.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetDERCUSTOMs(boolean bMain, String strDEId) {
        if (bMain) {
            return StringHelper.Format((String)"select * from V_SRFCUSTOMDER where MAJORDEID='%1$s' ", (Object)strDEId);
        }
        return StringHelper.Format((String)"select * from V_SRFCUSTOMDER where MINORDEID='%1$s' ", (Object)strDEId);
    }

    @Override
    public CallResult GetPPMWebParts(String strPPMId, Vector<WebPart> list) {
        return this.SelectMulti(this.GetSQL_GetPPMWebParts(strPPMId), list, WebPart.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetPPMWebParts(String strPPMId) {
        return StringHelper.Format((String)"select t1.*,t2.ROWID2,t2.COLUMNID from t_SRFWEBPART t1 INNER JOIN t_SRFPPMWEBPART t2 ON t1.WEBPARTID = t2.WEBPARTID WHERE t2.PPMODELID='%1$s' ORDER BY t2.COLUMNID,t2.ROWID2", (Object)strPPMId);
    }

    @Override
    public CallResult GetDERINDEXs(boolean bMain, String strDEId, Vector<DERINDEX> list) {
        return this.SelectMulti(this.GetSQL_GetDERINDEXs(bMain, strDEId), list, DERINDEX.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetDERINDEXs(boolean bMain, String strDEId) {
        if (bMain) {
            return StringHelper.Format((String)"select * from T_SRFDERINDEX where INDEXDEID='%1$s' ", (Object)strDEId);
        }
        return StringHelper.Format((String)"select * from T_SRFDERINDEX where DEID='%1$s' ", (Object)strDEId);
    }

    @Override
    public CallResult GetDERINDEXVIEWs(boolean bMain, String strDEId, Vector<DERINDEX> list) {
        return this.SelectMulti(this.GetSQL_GetDERINDEXVIEWs(bMain, strDEId), list, DERINDEX.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetDERINDEXVIEWs(boolean bMain, String strDEId) {
        if (bMain) {
            return StringHelper.Format((String)"select * from V_SRFDERINDEX where INDEXDEID='%1$s' ", (Object)strDEId);
        }
        return StringHelper.Format((String)"select * from V_SRFDERINDEX where DEID='%1$s' ", (Object)strDEId);
    }

    @Override
    public CallResult GetDERINDEX(String strDERIndexId, DERINDEX derIndex) {
        return this.SelectSingle(this.GetSQL_GetDERINDEX(strDERIndexId), derIndex, USER_SYSTEM);
    }

    protected String GetSQL_GetDERINDEX(String strDERIndexId) {
        return StringHelper.Format((String)"select * from T_SRFDERINDEX  where UPPER(DERINDEXID)='%1$s'", (Object)strDERIndexId.toUpperCase());
    }

    public CallResult GetDERINDEXs_INDEXDE(String strDEId, Vector<DERINDEX> list) {
        return this.SelectMulti(this.GetSQL_GetDERINDEXs_INDEXDE(strDEId), list, DERINDEX.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetDERINDEXs_INDEXDE(String strDEId) {
        if (this.iDAGlobalHelper.getDAModelVersion() < 10080600) {
            return StringHelper.Format((String)"select * from T_SRFDERINDEX where INDEXDEID='%1$s' ", (Object)strDEId);
        }
        return StringHelper.Format((String)"select * from T_SRFDERINDEX where INDEXDEID='%1$s' order by SHOWORDER ", (Object)strDEId);
    }

    public CallResult GetDERINDEXVIEWs_INDEXDE(String strDEId, Vector<DERINDEX> list) {
        return this.SelectMulti(this.GetSQL_GetDERINDEXVIEWs_INDEXDE(strDEId), list, DERINDEX.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetDERINDEXVIEWs_INDEXDE(String strDEId) {
        return StringHelper.Format((String)"select * from V_SRFDERINDEX where INDEXDEID='%1$s' ", (Object)strDEId);
    }

    @Override
    public CallResult GetDERTypes(String strDEId, Vector<DERType> list) {
        return this.SelectMulti(this.GetSQL_GetDERTypes(strDEId), list, DERType.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetDERTypes(String strDEId) {
        return StringHelper.Format((String)"select * from T_SRFDERTYPE where DEID='%1$s' ", (Object)strDEId);
    }

    @Override
    public CallResult GetDERN1s(String strDEId, Vector<DER1N> list) {
        return this.SelectMulti(this.GetSQL_GetDERN1s(strDEId), list, DER1N.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetDERN1s(String strDEId) {
        return StringHelper.Format((String)"select * from V_SRFDER1N where MINORDEID='%1$s' ", (Object)strDEId);
    }

    @Override
    public CallResult GetRawDER1Ns(String strDEId, Vector<DER1N> list) {
        return this.SelectMulti(this.GetSQL_GetRawDER1Ns(strDEId), list, DER1N.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetRawDER1Ns(String strDEId) {
        return StringHelper.Format((String)"select * from t_SRFDER1N where MAJORDEID='%1$s' ", (Object)strDEId);
    }

    @Override
    public CallResult GetRawDERN1s(String strDEId, Vector<DER1N> list) {
        return this.SelectMulti(this.GetSQL_GetRawDERN1s(strDEId), list, DER1N.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetRawDERN1s(String strDEId) {
        return StringHelper.Format((String)"select * from t_SRFDER1N where MINORDEID='%1$s' ", (Object)strDEId);
    }

    @Override
    public CallResult GetUserDEForm(String strFormId, String strCurPersonId, Form form) {
        return this.SelectSingle(this.GetSQL_GetUserDEForm(strFormId, strCurPersonId), form, USER_SYSTEM);
    }

    protected String GetSQL_GetUserDEForm(String strFormId, String strCurPersonId) {
        return StringHelper.Format((String)"select * from t_SRFFORM where UPPER(FORMID)='%1$s' AND (OWNERID IS NULL OR OWNERID = '' OR UPPER(OWNERID)='SYSTEM' OR UPPER(OWNERID)='%1$s') fetch first 1 row only", (Object)strFormId.toUpperCase(), (Object)strCurPersonId);
    }

    @Override
    public CallResult GetUserPPModel(String strPPName, String strCurPersonId, PPModel ppmodel) {
        return this.SelectSingle(this.GetSQL_GetUserPPModel(strPPName, strCurPersonId), ppmodel, USER_SYSTEM);
    }

    protected String GetSQL_GetUserPPModel(String strPPName, String strCurPersonId) {
        if (this.iDAGlobalHelper.getDAModelVersion() >= 12020100) {
            return StringHelper.Format((String)"select t1.*,t2.PORTALPAGEID,t2.PORTALPAGENAME,t2.ENABLECTX from T_SRFPPMODEL t1 INNER JOIN T_SRFPORTALPAGE t2 ON t1.PORTALPAGEID = t2.PORTALPAGEID where UPPER(t2.PORTALPAGENAME)='%1$s' AND (t1.OWNERID='SYSTEM' OR t1.OWNERID='%2$s') ORDER BY (CASE WHEN t1.OWNERID ='SYSTEM' THEN 0 ELSE  1 END) DESC fetch first 1 row only", (Object)strPPName.toUpperCase(), (Object)strCurPersonId.toUpperCase());
        }
        return StringHelper.Format((String)"select t1.*,t2.PORTALPAGEID,t2.PORTALPAGENAME from T_SRFPPMODEL t1 INNER JOIN T_SRFPORTALPAGE t2 ON t1.PORTALPAGEID = t2.PORTALPAGEID where UPPER(t2.PORTALPAGENAME)='%1$s' AND (t1.OWNERID='SYSTEM' OR t1.OWNERID='%2$s') ORDER BY (CASE WHEN t1.OWNERID ='SYSTEM' THEN 0 ELSE  1 END) DESC fetch first 1 row only", (Object)strPPName.toUpperCase(), (Object)strCurPersonId.toUpperCase());
    }

    @Override
    public CallResult GetDBStorages(Vector<DBStorage> list) {
        return this.SelectMulti(this.GetSQL_GetDBStorages(), list, DBStorage.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetDBStorages() {
        return StringHelper.Format((String)"select * from t_SRFDBSTORAGE where ENABLE=1 ");
    }

    @Override
    public CallResult GetSelectQueryModels(String strDEId, Vector<QueryModel> list) {
        if (this.iDAGlobalHelper.getDAModelVersion() >= 10050300) {
            return this.SelectMulti(this.GetSQL_GetSelectQueryModels(strDEId), list, QueryModel.class.getName(), USER_SYSTEM);
        }
        return new CallResult();
    }

    protected String GetSQL_GetSelectQueryModels(String strDEId) {
        return StringHelper.Format((String)"select * from T_SRFQUERYMODEL where  DEID='%1$s' AND (SELECTMODE IS NOT NULL AND SELECTMODE <> '')", (Object)strDEId);
    }

    @Override
    public CallResult GetGlobalObjects(Vector<GlobalObject> list) {
        if (this.iDAGlobalHelper.getDAModelVersion() >= 10082700) {
            return this.SelectMulti(this.GetSQL_GetGlobalObjects(), list, GlobalObject.class.getName(), USER_SYSTEM);
        }
        return new CallResult();
    }

    protected String GetSQL_GetGlobalObjects() {
        return StringHelper.Format((String)"select * from T_SRFGLOBALOBJECT ORDER BY INSTORDER ");
    }

    @Override
    public CallResult GetAppUIThemes(Vector<AppUITheme> list) {
        if (this.iDAGlobalHelper.getDAModelVersion() >= 10100600) {
            return this.SelectMulti(this.GetSQL_GetAppUIThemes(), list, AppUITheme.class.getName(), USER_SYSTEM);
        }
        return new CallResult();
    }

    protected String GetSQL_GetAppUIThemes() {
        return StringHelper.Format((String)"select * from T_SRFAPPUITHEME ");
    }

    @Override
    public CallResult GetDEDataCtrls(String strDEId, Vector<DEDataCtrl> list) {
        if (this.iDAGlobalHelper.getDAModelVersion() < 10013113) {
            return new CallResult();
        }
        return this.SelectMulti(this.GetSQL_GetDEDataCtrls(strDEId), list, DEDataCtrl.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetDEDataCtrls(String strDEId) {
        if (this.iDAGlobalHelper.getDAModelVersion() >= 11060700) {
            return StringHelper.Format((String)"select * from t_SRFDEDATACTRL where   (VALIDFLAG IS NULL OR VALIDFLAG = 1) AND DEID='%1$s' ORDER BY ORDERFLAG ", (Object)strDEId);
        }
        if (this.iDAGlobalHelper.getDAModelVersion() >= 11060400) {
            return StringHelper.Format((String)"select * from t_SRFDEDATACTRL where DEID='%1$s' ORDER BY ORDERFLAG ", (Object)strDEId);
        }
        return StringHelper.Format((String)"select * from t_SRFDEDATACTRL where DEID='%1$s' ", (Object)strDEId);
    }

    @Override
    public CallResult GetDEDataCtrl(String strDEDCId, DEDataCtrl dedc) {
        if (this.iDAGlobalHelper.getDAModelVersion() < 10013113) {
            return new CallResult();
        }
        return this.SelectSingle(this.GetSQL_GetDEDataCtrl(strDEDCId), dedc, USER_SYSTEM);
    }

    protected String GetSQL_GetDEDataCtrl(String strDEDCId) {
        return StringHelper.Format((String)"select * from t_SRFDEDATACTRL where DEDATACTRLID='%1$s' ", (Object)strDEDCId);
    }

    @Override
    public CallResult GetDEDCProcess(String strDEDCProcessId, DEDCProcess process) {
        return this.SelectSingle(this.GetSQL_GetDEDCProcess(strDEDCProcessId), process, USER_SYSTEM);
    }

    protected String GetSQL_GetDEDCProcess(String strDEDCProcessId) {
        return StringHelper.Format((String)"select * from T_SRFDEDCProcess where  DEDCPROCESSID='%1$s'", (Object)strDEDCProcessId);
    }

    @Override
    public CallResult GetDEDCProcTypes(Vector<DEDCProcType> list) {
        if (this.iDAGlobalHelper.getDAModelVersion() < 10013113) {
            return new CallResult();
        }
        return this.SelectMulti(this.GetSQL_GetDEDCProcTypes(), list, DEDCProcType.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetDEDCProcTypes() {
        return StringHelper.Format((String)"select * from t_SRFDEDCPROCTYPE where enable=1 ");
    }

    @Override
    public CallResult GetValidFormItemExs(Vector<FormItemEx> list) {
        if (this.iDAGlobalHelper.getDAModelVersion() < 10111000) {
            return new CallResult();
        }
        return this.SelectMulti(this.GetSQL_GetValidFormItemExs(), list, FormItemEx.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetValidFormItemExs() {
        return StringHelper.Format((String)"select * from T_SRFFORMITEMEX where VALIDFLAG=1 ");
    }

    @Override
    public CallResult GetPageLogics(String strPageId, Vector<PageLogic> list) {
        if (this.iDAGlobalHelper.getDAModelVersion() < 10111100) {
            return new CallResult();
        }
        return this.SelectMulti(this.GetSQL_GetPageLogics(strPageId), list, PageLogic.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetPageLogics(String strPageId) {
        return StringHelper.Format((String)"select t1.* from t_SRFPAGELOGIC t1 where t1.PageId='%1$s' ", (Object)strPageId);
    }

    @Override
    public CallResult GetDEDataNotifies(String strDEId, Vector<DataNotify> list) {
        if (this.iDAGlobalHelper.getDAModelVersion() < 10111500) {
            return new CallResult();
        }
        return this.SelectMulti(this.GetSQL_GetDEDataNotifies(strDEId), list, DataNotify.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetDEDataNotifies(String strDEId) {
        return StringHelper.Format((String)"select * from T_SRFDATANOTIFY where  DEID='%1$s' ", (Object)strDEId);
    }

    @Override
    public CallResult GetFIUpdate(String strDEId, String strFIUpdateMode, FIUpdate fiUpdate) {
        return this.SelectSingle(this.GetSQL_GetFIUpdate(strDEId, strFIUpdateMode), fiUpdate, USER_SYSTEM);
    }

    protected String GetSQL_GetFIUpdate(String strDEId, String strFIUpdateMode) {
        return StringHelper.Format((String)"select t1.*,t2.ACTIONMODE from T_SRFFIUPDATE t1 INNER JOIN T_SRFDEDATACTRL t2 ON t1.DEDATACTRLID = t2.DEDATACTRLID  where t1.DEID='%1$s' AND t1.FIUPDATENAME='%2$s' ", (Object)strDEId, (Object)strFIUpdateMode);
    }

    @Override
    public int GetFIUpdateVersion(String strDEId, String strFIUpdateMode) {
        return this.SelectVersion(this.GetSQL_GetFIUpdateVersion(strDEId, strFIUpdateMode));
    }

    protected String GetSQL_GetFIUpdateVersion(String strDEId, String strFIUpdateMode) {
        return StringHelper.Format((String)"select VERSION FROM T_SRFFIUPDATE where DEID='%1$s' AND FIUPDATENAME='%2$s' ", (Object)strDEId, (Object)strFIUpdateMode);
    }

    @Override
    public CallResult GetGroupStatisticsRep(String strGroupStatisticsRepId, GroupStatisticsRep gsr) {
        return this.SelectSingle(this.GetSQL_GetGroupStatisticsRep(strGroupStatisticsRepId), gsr, USER_SYSTEM);
    }

    protected String GetSQL_GetGroupStatisticsRep(String strGroupStatisticsRepId) {
        return StringHelper.Format((String)"select t1.* from V_SRFGROUPSTATISTICSREP t1   where t1.GROUPSTATISTICSREPID='%1$s'  ", (Object)strGroupStatisticsRepId);
    }

    @Override
    public int GetGroupStatisticsRepVersion(String strGroupStatisticsRepId) {
        return this.SelectVersion(this.GetSQL_GetGroupStatisticsRepVersion(strGroupStatisticsRepId));
    }

    protected String GetSQL_GetGroupStatisticsRepVersion(String strGroupStatisticsRepId) {
        return StringHelper.Format((String)"select VERSION FROM T_SRFGROUPSTATISTICSREP where GROUPSTATISTICSREPID='%1$s'", (Object)strGroupStatisticsRepId);
    }

    @Override
    public CallResult GetGSRMeasures(String strGroupStatisticsRepId, Vector<GSRMeasure> list) {
        return this.SelectMulti(this.GetSQL_GetGSRMeasures(strGroupStatisticsRepId), list, GSRMeasure.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetGSRMeasures(String strGroupStatisticsRepId) {
        return StringHelper.Format((String)"select * from V_SRFGSRMEASURE where  GROUPSTATISTICSREPID='%1$s' ORDER BY ORDERFLAG ", (Object)strGroupStatisticsRepId);
    }

    @Override
    public CallResult GetGSRGroupColumns(String strGroupStatisticsRepId, Vector<GSRGroupColumn> list) {
        return this.SelectMulti(this.GetSQL_GetGSRGroupColumns(strGroupStatisticsRepId), list, GSRGroupColumn.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetGSRGroupColumns(String strGroupStatisticsRepId) {
        return StringHelper.Format((String)"select * from V_SRFGSRGROUPCOLUMN where  GROUPSTATISTICSREPID='%1$s'  ORDER BY ORDERFLAG", (Object)strGroupStatisticsRepId);
    }

    @Override
    public CallResult GetDEDataImports(String strDEId, Vector<DEDataImport> list) {
        if (this.iDAGlobalHelper.getDAModelVersion() < 11041900) {
            return new CallResult();
        }
        return this.SelectMulti(this.GetSQL_GetDEDataImports(strDEId), list, DEDataImport.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetDEDataImports(String strDEId) {
        return StringHelper.Format((String)"select * from V_SRFDEDATAIMPORT where  DEID='%1$s' ", (Object)strDEId);
    }

    @Override
    public CallResult GetUserObjectPUserGroups(Vector<String> userObjects, Vector<UserGroup> userGroups) {
        if (userObjects.size() == 0) {
            return new CallResult();
        }
        return this.SelectMulti(this.GetSQL_GetUserObjectPUserGroups(userObjects), userGroups, UserGroup.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetUserObjectPUserGroups(Vector<String> userObjects) {
        String strSQL = "select t1.USERGROUPID from T_SRFUSERGROUPDETAIL t1 INNER JOIN T_SRFUSERGROUP t2 on t1.USERGROUPID = t2.USERGROUPID ";
        strSQL = String.valueOf(strSQL) + "where (t2.enable=1) AND (";
        String strCondition = "";
        for (String strUserObjectId : userObjects) {
            if (!StringHelper.IsNullOrEmpty((String)strCondition)) {
                strCondition = String.valueOf(strCondition) + " OR ";
            }
            strCondition = String.valueOf(strCondition) + StringHelper.Format((String)"t1.USEROBJECTID='%1$s'", (Object)strUserObjectId);
        }
        strSQL = String.valueOf(strSQL) + strCondition;
        strSQL = String.valueOf(strSQL) + ")";
        return strSQL;
    }

    @Override
    public CallResult GetDEGlobalModels(Vector<DataEntity> globalModels) {
        if (this.iDAGlobalHelper.getDAModelVersion() < 11062700) {
            return new CallResult();
        }
        return this.SelectMulti(this.GetSQL_GetDEGlobalModels(), globalModels, DataEntity.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetDEGlobalModels() {
        String strSQL = "select t1.* from t_SRFDATAENTITY t1 where t1.ENABLEGLOBALMODEL = 1";
        return strSQL;
    }

    @Override
    public CallResult GetDESubWFs(String strDEId, Vector<DESubWF> list) {
        if (this.iDAGlobalHelper.getDAModelVersion() < 11062700) {
            return new CallResult();
        }
        return this.SelectMulti(this.GetSQL_GetDESubWFs(strDEId), list, DESubWF.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetDESubWFs(String strDEId) {
        return StringHelper.Format((String)"select * from V_SRFDESUBWF where DEID='%1$s' ", (Object)strDEId);
    }

    @Override
    public CallResult GetDEWizards(String strDEId, Vector<DEWizard> list) {
        if (this.iDAGlobalHelper.getDAModelVersion() < 11101400) {
            return new CallResult();
        }
        return this.SelectMulti(this.GetSQL_GetDEWizards(strDEId), list, DEWizard.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetDEWizards(String strDEId) {
        return StringHelper.Format((String)"select * from V_SRFDEWIZARD where DEID='%1$s' ORDER BY CREATEWZ,CREATEORDER ", (Object)strDEId);
    }

    @Override
    public CallResult GetDEWizard(String strDEWizardId, DEWizard deWizard) {
        return this.SelectSingle(this.GetSQL_GetDEWizard(strDEWizardId), deWizard, USER_SYSTEM);
    }

    protected String GetSQL_GetDEWizard(String strDEWizardId) {
        return StringHelper.Format((String)"select * from T_SRFDEWIZARD where DEWIZARDID='%1$s'  ", (Object)strDEWizardId);
    }

    @Override
    public CallResult GetDEWizardDetail(String strDEWizardId, String strDEWizardStepId, DEWizardDetail deWizardDetail) {
        return this.SelectSingle(this.GetSQL_GetDEWizardDetail(strDEWizardId, strDEWizardStepId), deWizardDetail, USER_SYSTEM);
    }

    protected String GetSQL_GetDEWizardDetail(String strDEWizardId, String strDEWizardStepId) {
        return StringHelper.Format((String)"select * from V_SRFDEWIZARDDETAIL where DEWIZARDID='%1$s' AND WZPAGEID='%2$s' ", (Object)strDEWizardId, (Object)strDEWizardStepId);
    }

    @Override
    public CallResult GetDBObjects(String strDEId, String strDBType, Vector<DBObject> dbObjects) {
        if (this.iDAGlobalHelper.getDAModelVersion() < 11110400) {
            return new CallResult();
        }
        return this.SelectMulti(this.GetSQL_GetDBObjects(strDEId, strDBType), dbObjects, DBObject.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetDBObjects(String strDEId, String strDBType) {
        return StringHelper.Format((String)"select t1.*,t2.OBJCODE,t2.AFTERCREATECODE,t2.AFTERCREATECODE2,t2.DBTYPE from t_SRFDBOBJECT t1 LEFT JOIN T_SRFDBOBJDETAIL t2 on t2.DBOBJECTID = t1.DBOBJECTID where t1.DEID='%1$s' AND ( t2.DBTYPE IS NULL oR t2.DBTYPE= '%2$s') ORDER BY t1.ORDERFLAG ASC ", (Object)strDEId, (Object)strDBType);
    }

    @Override
    public CallResult GetDBObject(String strDEId, String strDBType, String strDBObjectId, DBObject dbObject) {
        if (this.iDAGlobalHelper.getDAModelVersion() < 11110400) {
            CallResult callResult = new CallResult();
            callResult.setRetCode(3);
            return callResult;
        }
        return this.SelectSingle(this.GetSQL_GetDBObject(strDEId, strDBType, strDBObjectId), dbObject, USER_SYSTEM);
    }

    protected String GetSQL_GetDBObject(String strDEId, String strDBType, String strDBObjectId) {
        return StringHelper.Format((String)"select t1.*,t2.OBJCODE,t2.AFTERCREATECODE,t2.AFTERCREATECODE2,t2.DBTYPE from t_SRFDBOBJECT t1 LEFT JOIN T_SRFDBOBJDETAIL t2 on t2.DBOBJECTID = t1.DBOBJECTID where t1.DEID='%1$s' AND ( t2.DBTYPE IS NULL oR t2.DBTYPE= '%2$s') AND t1.DBOBJECTID='%3$s' ", (Object)strDEId, (Object)strDBType, (Object)strDBObjectId);
    }

    @Override
    public CallResult GetUserDGTheme(String strPersonId, String strDGThemeId, UserDGTheme userDGTheme) {
        return this.SelectSingle(this.GetSQL_GetUserDGTheme(strPersonId, strDGThemeId), userDGTheme, USER_SYSTEM);
    }

    protected String GetSQL_GetUserDGTheme(String strPersonId, String strDGThemeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFUSERDGTHEME t1 where  t1.PERSONID='%1$s' and t1.DATAGRIDID='%2$s'", (Object)strPersonId, (Object)strDGThemeId);
    }

    @Override
    public CallResult GetIgnorePatchs(String strDEId, String strDataKey, Vector<IgnorePatch> ignorePatchs) {
        if (this.iDAGlobalHelper.getDAModelVersion() < 11121100) {
            CallResult callResult = new CallResult();
            callResult.setRetCode(0);
            return callResult;
        }
        return this.SelectMulti(this.GetSQL_GetIgnorePatchs(strDEId, strDataKey), ignorePatchs, IgnorePatch.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetIgnorePatchs(String strDEId, String strDataKey) {
        return StringHelper.Format((String)"select t1.DEID,t1.DATAKEY,t1.IGNOREFIELDS from T_SRFIGNOREPATCH t1 where t1.DEID='%1$s' AND ( t1.DATAKEY='%2$s' OR t1.DATAKEY='*' ) ", (Object)strDEId, (Object)strDataKey);
    }

    @Override
    public CallResult GetMBPanel(String strMBPanelId, MBPanel mbPanel) {
        return this.SelectSingle(this.GetSQL_GetMBPanel(strMBPanelId), mbPanel, USER_SYSTEM);
    }

    protected String GetSQL_GetMBPanel(String strMBPanelId) {
        return StringHelper.Format((String)"select t1.*,t2.PANELOBJECT as TEMPLOBJECT  from T_SRFMBPANEL t1  LEFT JOIN T_SRFMBPANELTEMPL t2 on t1.MBPANELTEMPLID = t2.MBPANELTEMPLID  where MBPANELID='%1$s'  ", (Object)strMBPanelId);
    }

    @Override
    public CallResult GetDEMainStates(String strDEId, Vector<DEMainState> list) {
        if (this.GetDEModelVersion("DE0280") <= 0) {
            return new CallResult();
        }
        return this.SelectMulti(this.GetSQL_GetDEMainStates(strDEId), list, DEMainState.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetDEMainStates(String strDEId) {
        return StringHelper.Format((String)"select t1.* from T_SRFDEMAINSTATE t1 where t1.DEID='%1$s' ", (Object)strDEId);
    }

    @Override
    public CallResult GetDEMSMAs(String strDEMainStateId, Vector<DEMSMA> list) {
        return this.SelectMulti(this.GetSQL_GetDEMSMAs(strDEMainStateId), list, DEMSMA.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetDEMSMAs(String strDEMainStateId) {
        return StringHelper.Format((String)"select t1.* from T_SRFDEMSMA t1 WHERE t1.VALIDFLAG=1 AND t1.DEMAINSTATEID='%1$s' ORDER BY t1.ORDERFLAG ", (Object)strDEMainStateId);
    }

    @Override
    public CallResult GetDEMainActions(String strDEId, Vector<DEMainAction> list) {
        if (this.GetDEModelVersion("DE0276") <= 0) {
            return new CallResult();
        }
        return this.SelectMulti(this.GetSQL_GetDEMainActions(strDEId), list, DEMainAction.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetDEMainActions(String strDEId) {
        return StringHelper.Format((String)"select t1.* from T_SRFDEMAINACTION t1 where t1.DEID='%1$s' ", (Object)strDEId);
    }

    @Override
    public CallResult GetConfigPublishers(Vector<ConfigPublisher> list) {
        if (this.GetDEModelVersion("DE0207") <= 0) {
            return new CallResult();
        }
        return this.SelectMulti(this.GetSQL_GetConfigPublishers(), list, ConfigPublisher.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetConfigPublishers() {
        return StringHelper.Format((String)"select t1.* from T_SRFCONFIGPUBLISHER t1 where t1.VALIDFLAG=1 ");
    }

    @Override
    public CallResult GetDEMobile(String strDEId, DEMobile dbMobile) {
        if (this.GetDEModelVersion("DE0400") >= 0) {
            return this.SelectSingle(this.GetSQL_GetDEMobile(strDEId), dbMobile, USER_SYSTEM);
        }
        CallResult callResult = new CallResult();
        callResult.setRetCode(3);
        return callResult;
    }

    protected String GetSQL_GetDEMobile(String strDEId) {
        return StringHelper.Format((String)"select t1.* from T_SRFDEMOBILE  t1 where DEID= '%1$s' ", (Object)strDEId);
    }

    @Override
    public CallResult GetMBList(String strDEId, int nListType, MBList mbList) {
        return this.SelectSingle(this.GetSQL_GetMBList(strDEId, nListType), mbList, USER_SYSTEM);
    }

    protected String GetSQL_GetMBList(String strDEId, int nListType) {
        switch (nListType) {
            case 1: {
                return StringHelper.Format((String)"select t1.* from v_SRFMBLIST t1 where MAINFLAG=1 AND  DEID= '%1$s' ORDER BY MAINPRIORITY DESC ", (Object)strDEId);
            }
            case 2: {
                return StringHelper.Format((String)"select t1.* from v_SRFMBLIST t1 where PICKUPFLAG=1 AND  DEID= '%1$s' ORDER BY PICKUPPRIORITY DESC ", (Object)strDEId);
            }
        }
        return "";
    }

    @Override
    public CallResult GetMBList(String strMBListId, MBList mbList) {
        return this.SelectSingle(this.GetSQL_GetMBList(strMBListId), mbList, USER_SYSTEM);
    }

    protected String GetSQL_GetMBList(String strMBListId) {
        return StringHelper.Format((String)"select t1.* from v_SRFMBLIST t1 where MBLISTID= '%1$s'  ", (Object)strMBListId);
    }

    @Override
    public CallResult GetDERMode(String strDERModeId, DERMode derMode) {
        return this.SelectSingle(this.GetSQL_GetDERMode(strDERModeId), derMode, USER_SYSTEM);
    }

    protected String GetSQL_GetDERMode(String strDERModeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFDERMODE t1 where DERMODEID= '%1$s'  ", (Object)strDERModeId);
    }

    @Override
    public CallResult GetValidDEDataChgDisps(Vector<DEDataChgDisp> list) {
        if (this.GetDEModelVersion("DE0218") < 0) {
            return new CallResult();
        }
        return this.SelectMulti(this.GetSQL_GetValidDEDataChgDisps(), list, DEDataChgDisp.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetValidDEDataChgDisps() {
        return StringHelper.Format((String)"select t1.* from v_srfDEDATACHGDISP t1 WHERE t1.VALIDFLAG=1 ORDER BY t1.ORDERFLAG ");
    }

    @Override
    public CallResult GetSyncAgentType(String strSyncAgentTypeId, SyncAgentType syncAgentType) {
        return this.SelectSingle(this.GetSQL_GetSyncAgentType(strSyncAgentTypeId), syncAgentType, USER_SYSTEM);
    }

    protected String GetSQL_GetSyncAgentType(String strSyncAgentTypeId) {
        return StringHelper.Format((String)"select t1.* from v_srfSYNCAGENTTYPE t1 WHERE t1.SYNCAGENTTYPEID= '%1$s'  ", (Object)strSyncAgentTypeId);
    }

    @Override
    public CallResult GetValidDataSyncAgents(Vector<DataSyncAgent> dataSyncAgents) {
        if (this.GetDEModelVersion("DE0221") < 0) {
            return new CallResult();
        }
        return this.SelectMulti(this.GetSQL_GetValidDataSyncAgents(), dataSyncAgents, DataSyncAgent.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetValidDataSyncAgents() {
        return StringHelper.Format((String)"SELECT t1.* FROM T_SRFDATASYNCAGENT t1 WHERE t1.enable=1 ");
    }

    @Override
    public CallResult GetDEMAFields(String strDEMainActionId, Vector<DEMAField> list) {
        return this.SelectMulti(this.GetSQL_GetDEMAFields(strDEMainActionId), list, DEMAField.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetDEMAFields(String strDEMainActionId) {
        return StringHelper.Format((String)"select t1.* from T_SRFDEMAFIELD t1 where t1.VALIDFLAG=1 AND  t1.DEMAINACTIONID = '%1$s' ", (Object)strDEMainActionId);
    }

    @Override
    public CallResult GetDEMSMaps(String strDEMainStateId, Vector<DEMSMap> list) {
        return this.SelectMulti(this.GetSQL_GetDEMSMaps(strDEMainStateId), list, DEMSMap.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetDEMSMaps(String strDEMainStateId) {
        return StringHelper.Format((String)"select t1.* from T_SRFDEMSMap t1 where t1.VALIDFLAG=1 AND  t1.DEMAINSTATEID = '%1$s' ", (Object)strDEMainStateId);
    }

    @Override
    public CallResult GetDETBBHandlers(Vector<DETBBHandler> list) {
        if (this.GetDEModelVersion("DE0219") == -1) {
            return new CallResult();
        }
        return this.SelectMulti(this.GetSQL_GetDETBBHandlers(), list, DETBBHandler.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetDETBBHandlers() {
        return StringHelper.Format((String)"select t1.* from T_SRFDETBBHANDLER t1 ORDER BY T1.ORDERFLAG");
    }

    @Override
    public CallResult GetORGUnit(String strOrgUnitId, ORGUnit orgUnit) {
        return this.SelectSingle(this.GetSQL_GetORGUnit(strOrgUnitId), orgUnit, USER_SYSTEM);
    }

    protected String GetSQL_GetORGUnit(String strOrgUnitId) {
        return StringHelper.Format((String)"select t1.* from T_SRFORGUNIT t1 WHERE t1.ORGUNITID= '%1$s'  ", (Object)strOrgUnitId);
    }

    @Override
    public CallResult GetORGTreeNodes(String strOrgTreeId, String strOrgUnitId, Vector<ORGTreeNode> orgTreeNodes) {
        return this.SelectMulti(this.GetSQL_GetORGTreeNode(strOrgTreeId, strOrgUnitId), orgTreeNodes, ORGTreeNode.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetORGTreeNode(String strOrgTreeId, String strOrgUnitId) {
        if (StringHelper.IsNullOrEmpty((String)strOrgTreeId)) {
            return StringHelper.Format((String)"select t1.* from T_SRFORGTREENODE t1 WHERE (t1.ORGUNITID IS NOT NULL AND t1.ORGUNITID= '%1$s' )  ", (Object)strOrgUnitId);
        }
        return StringHelper.Format((String)"select t1.* from T_SRFORGTREENODE t1 WHERE (t1.ORGUNITID IS NOT NULL AND t1.ORGUNITID= '%1$s' ) AND t1.ORGTREEID='%2$s'   ", (Object)strOrgUnitId, (Object)strOrgTreeId);
    }

    @Override
    public CallResult GetORGTreeNode(String strOrgTreeNodeId, ORGTreeNode orgTreeNode) {
        return this.SelectSingle(this.GetSQL_GetORGTreeNode(strOrgTreeNodeId), orgTreeNode, USER_SYSTEM);
    }

    protected String GetSQL_GetORGTreeNode(String strOrgTreeNodeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFORGTREENODE t1 WHERE  t1.ORGTREENODEID='%1$s'   ", (Object)strOrgTreeNodeId);
    }

    @Override
    public CallResult GetORGTree(String strOrgTreeId, ORGTree orgTree) {
        return this.SelectSingle(this.GetSQL_GetORGTree(strOrgTreeId), orgTree, USER_SYSTEM);
    }

    protected String GetSQL_GetORGTree(String strOrgTreeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFORGTREE t1 WHERE  t1.ORGTREEID='%1$s'   ", (Object)strOrgTreeId);
    }

    @Override
    public CallResult GetORGTreeRootNodes(String strOrgTreeId, Vector<ORGTreeNode> orgTreeNodes) {
        return this.SelectMulti(this.GetSQL_GetORGTreeRootNodes(strOrgTreeId), orgTreeNodes, ORGTreeNode.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetORGTreeRootNodes(String strOrgTreeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFORGTREENODE t1 WHERE (t1.PORGTREENODEID IS NULL ) AND t1.ORGTREEID='%1$s'   ", (Object)strOrgTreeId);
    }

    @Override
    public CallResult GetChildORGTreeNodes(String strPOrgTreeNodeId, Vector<ORGTreeNode> orgTreeNodes) {
        return this.SelectMulti(this.GetSQL_GetChildORGTreeNodes(strPOrgTreeNodeId), orgTreeNodes, ORGTreeNode.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetChildORGTreeNodes(String strPOrgTreeNodeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFORGTREENODE t1 WHERE (t1.PORGTREENODEID IS NOT NULL ) AND t1.PORGTREENODEID='%1$s'   ", (Object)strPOrgTreeNodeId);
    }

    @Override
    public CallResult GetORGUnitType(String strOrgUnitTypeId, ORGUnitType orgUnitType) {
        return this.SelectSingle(this.GetSQL_GetORGTree(strOrgUnitTypeId), orgUnitType, USER_SYSTEM);
    }

    protected String GetSQL_GetORGUnitType(String strOrgUnitTypeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFORGUNITTYPE t1 WHERE  t1.ORGUNITTYPEID='%1$s'   ", (Object)strOrgUnitTypeId);
    }

    @Override
    public CallResult GetORGTreeType(String strOrgTreeTypeId, ORGTreeType orgTreeType) {
        return this.SelectSingle(this.GetSQL_GetORGTree(strOrgTreeTypeId), orgTreeType, USER_SYSTEM);
    }

    protected String GetSQL_GetORGTreeType(String strOrgTreeTypeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFORGTREETYPE t1 WHERE  t1.ORGTREETYPEID='%1$s'   ", (Object)strOrgTreeTypeId);
    }

    @Override
    public CallResult GetORGTreeNodeType(String strOrgTreeNodeTypeId, ORGTreeNodeType orgTreeNodeType) {
        return this.SelectSingle(this.GetSQL_GetORGTreeNode(strOrgTreeNodeTypeId), orgTreeNodeType, USER_SYSTEM);
    }

    protected String GetSQL_GetORGTreeNodeType(String strOrgTreeNodeTypeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFORGTREENODETYPE t1 WHERE  t1.ORGTREENODETYPEID='%1$s'   ", (Object)strOrgTreeNodeTypeId);
    }

    @Override
    public CallResult GetAllParentORGTreeNodes(String strOrgTreeNodeId, Vector<ORGTreeNode> orgTreeNodes) {
        ORGTreeNode orgTreeNode = new ORGTreeNode();
        CallResult callResult = this.GetORGTreeNode(strOrgTreeNodeId, orgTreeNode);
        if (callResult.IsError()) {
            return callResult;
        }
        String strPORGTreeNodeId = orgTreeNode.getPORGTREENODEID();
        while (!StringHelper.IsNullOrEmpty((String)strPORGTreeNodeId)) {
            ORGTreeNode pORGTreeNode = new ORGTreeNode();
            callResult = this.GetORGTreeNode(strPORGTreeNodeId, pORGTreeNode);
            if (callResult.IsError()) {
                return callResult;
            }
            orgTreeNodes.add(pORGTreeNode);
            strPORGTreeNodeId = pORGTreeNode.getPORGTREENODEID();
        }
        return callResult;
    }

    @Override
    public CallResult GetRCAccList(String strRCAccListId, RCAccList rcAccList) {
        return this.SelectSingle(this.GetSQL_GetRCAccList(strRCAccListId), rcAccList, USER_SYSTEM);
    }

    protected String GetSQL_GetRCAccList(String strRCAccListId) {
        return StringHelper.Format((String)"select t1.* from T_SRFRCACCLIST t1 WHERE  t1.RCACCLISTID='%1$s' ", (Object)strRCAccListId);
    }

    @Override
    public CallResult GetRCALDetails(String strRCAccListId, Vector<RCALDetail> rcALDetails) {
        return this.SelectMulti(this.GetSQL_GetRCALDetails(strRCAccListId), rcALDetails, RCALDetail.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetRCALDetails(String strRCAccListId) {
        return StringHelper.Format((String)"select t1.* from T_SRFRCALDETAIL t1 WHERE t1.RCACCLISTID='%1$s'   ", (Object)strRCAccListId);
    }

    @Override
    public CallResult GetSubSystems(Vector<SubSystem> subSystems) {
        if (this.GetDEModelVersion("DE0147") == -1) {
            return new CallResult();
        }
        return this.SelectMulti(this.GetSQL_GetSubSystems(), subSystems, SubSystem.class.getName(), USER_SYSTEM);
    }

    protected String GetSQL_GetSubSystems() {
        return StringHelper.Format((String)"select t1.* from T_SRFSUBSYSTEM t1 ORDER BY  t1.ORDERFLAG  ");
    }

    @Override
    public CallResult GetToolbar(String strToolbarId, Toolbar toolbar) {
        return this.SelectSingle(this.GetSQL_GetToolbar(strToolbarId), toolbar, USER_SYSTEM);
    }

    protected String GetSQL_GetToolbar(String strToolbarId) {
        return StringHelper.Format((String)"select t1.* from T_SRFTOOLBAR t1 WHERE  t1.TOOLBARID='%1$s' ", (Object)strToolbarId);
    }

    @Override
    public CallResult GetCounter(String strCounterId, Counter counter) {
        return this.SelectSingle(this.GetSQL_GetCounter(strCounterId), counter, USER_SYSTEM);
    }

    protected String GetSQL_GetCounter(String strCounterId) {
        return StringHelper.Format((String)"select t1.* from T_SRFCOUNTER t1 WHERE  t1.COUNTERID='%1$s' ", (Object)strCounterId);
    }

    @Override
    public CallResult GetCounterType(String strCounterTypeId, CounterType counterType) {
        return this.SelectSingle(this.GetSQL_GetCounterType(strCounterTypeId), counterType, USER_SYSTEM);
    }

    protected String GetSQL_GetCounterType(String strCounterTypeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFCOUNTERTYPE t1 WHERE  t1.COUNTERTYPEID='%1$s' ", (Object)strCounterTypeId);
    }

    @Override
    public CallResult GetLayoutItem(String strLayoutItemId, LayoutItem layoutItem) {
        return this.SelectSingle(this.GetSQL_GetLayoutItem(strLayoutItemId), layoutItem, USER_SYSTEM);
    }

    protected String GetSQL_GetLayoutItem(String strLayoutItemId) {
        return StringHelper.Format((String)"select t1.* from T_SRFLAYOUTITEM t1 WHERE  t1.LAYOUTITEMID='%1$s' ", (Object)strLayoutItemId);
    }

    protected CallResult SelectSingle(String strSQL, BaseDataEntity dataEntity, String strOpPersonId) {
        CallResult callResult = new CallResult();
        try {
            SelectResult selectResult = this.getDBCallerHelper().CallRaw2(strSQL);
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

    protected CallResult SelectMulti(String strSQL, Vector list, String strObjectName, String strOpPersonId) {
        CallResult callResult = new CallResult();
        try {
            SelectResult selectResult = this.getDBCallerHelper().CallRaw2(strSQL);
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
            int nRowCount = selectResult.getMainTable().GetRowCount();
            int i = 0;
            while (i < nRowCount) {
                Object obj;
                BaseDataEntity dataEntity = null;
                if (!StringHelper.IsNullOrEmpty((String)strObjectName) && (obj = ObjectHelper.Create((String)strObjectName)) != null && obj instanceof BaseDataEntity) {
                    dataEntity = (BaseDataEntity)obj;
                }
                if (dataEntity == null) {
                    dataEntity = new BaseDataEntity();
                }
                dataEntity.FromDataRow(selectResult.getMainTable().GetRow(i));
                list.add(dataEntity);
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

    public CallResult ExecuteWithoutResult(String strSQL) {
        CallResult callResult = new CallResult();
        try {
            DBResult dbResult = this.dbCallerHelperEx.CallRaw3WithoutReturn(null, strSQL, null);
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

    private int SelectVersion(String strSQL, Object objValue) {
        SelectResult selectResult;
        block9: {
            block8: {
                block7: {
                    block6: {
                        try {
                            Vector<CallParam> list = new Vector<CallParam>();
                            CallParam callParam = new CallParam();
                            callParam.setValue(objValue);
                            list.add(callParam);
                            selectResult = this.getDBCallerHelper().CallRaw3(strSQL, list);
                            if (selectResult != null) break block6;
                            log.error((Object)"\u67e5\u8be2\u6570\u636e\u7248\u672c\u51fa\u73b0\u4e0d\u660e\u9519\u8bef");
                            return -1;
                        }
                        catch (Exception ex) {
                            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e\u7248\u672c\u51fa\u73b0\u9519\u8bef", (Object)ex));
                            return -1;
                        }
                    }
                    if (selectResult.getRetCode() == 0) break block7;
                    log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e\u7248\u672c\u51fa\u73b0\u9519\u8bef\uff0c%1$s", (Object)selectResult.getErrorInfo()));
                    return -1;
                }
                if (selectResult.getMainTable() != null) break block8;
                log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e\u7248\u672c\u51fa\u73b0\u9519\u8bef\uff0c\u6ca1\u6709\u8fd4\u56de\u6570\u636e\u8868\u5bf9\u8c61"));
                return -1;
            }
            if (selectResult.getMainTable().GetRowCount() != 0) break block9;
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e\u7248\u672c\u51fa\u73b0\u9519\u8bef\uff0c\u6ca1\u6709\u8fd4\u56de\u8bb0\u5f55"));
            return -1;
        }
        try {
            return Integer.parseInt(selectResult.getMainTable().GetRow(0).Get("VERSION").toString());
        }
        catch (Exception exception) {
            return -1;
        }
    }

    private int SelectVersion(String strSQL) {
        SelectResult selectResult;
        block9: {
            block8: {
                block7: {
                    block6: {
                        try {
                            selectResult = this.getDBCallerHelper().CallRaw3(strSQL, null);
                            if (selectResult != null) break block6;
                            log.error((Object)"\u67e5\u8be2\u6570\u636e\u7248\u672c\u51fa\u73b0\u4e0d\u660e\u9519\u8bef");
                            return -1;
                        }
                        catch (Exception ex) {
                            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e\u7248\u672c\u51fa\u73b0\u9519\u8bef", (Object)ex));
                            return -1;
                        }
                    }
                    if (selectResult.getRetCode() == 0) break block7;
                    log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e\u7248\u672c\u51fa\u73b0\u9519\u8bef\uff0c%1$s", (Object)selectResult.getErrorInfo()));
                    return -1;
                }
                if (selectResult.getMainTable() != null) break block8;
                log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e\u7248\u672c\u51fa\u73b0\u9519\u8bef\uff0c\u6ca1\u6709\u8fd4\u56de\u6570\u636e\u8868\u5bf9\u8c61"));
                return -1;
            }
            if (selectResult.getMainTable().GetRowCount() != 0) break block9;
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e\u7248\u672c\u51fa\u73b0\u9519\u8bef\uff0c\u6ca1\u6709\u8fd4\u56de\u8bb0\u5f55"));
            return -1;
        }
        try {
            return Integer.parseInt(selectResult.getMainTable().GetRow(0).Get("VERSION").toString());
        }
        catch (Exception exception) {
            return -1;
        }
    }

    protected void LogPerformance(Date startTime, String strAction, String strSQL) {
        long nTimer = new Date().getTime() - startTime.getTime();
        log.debug((Object)StringHelper.Format((String)"\u6267\u884c[%1$s] \u8017\u65f6 %2$sms\r\n%3$s", (Object)strAction, (Object)nTimer, (Object)strSQL));
    }
}

