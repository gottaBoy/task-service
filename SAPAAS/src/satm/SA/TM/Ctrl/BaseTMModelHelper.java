/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.TM.Ctrl.Data.TMBTType;
import SA.TM.Ctrl.Data.TMComplexRes;
import SA.TM.Ctrl.Data.TMComplexResDetail;
import SA.TM.Ctrl.Data.TMRBRule;
import SA.TM.Ctrl.Data.TMRBRuleType;
import SA.TM.Ctrl.Data.TMResBT;
import SA.TM.Ctrl.Data.TMResBase;
import SA.TM.Ctrl.Data.TMResCD;
import SA.TM.Ctrl.Data.TMResCatalog;
import SA.TM.Ctrl.Data.TMResType;
import SA.TM.Ctrl.Data.TMResView;
import SA.TM.Ctrl.Data.TMResViewDetail;
import SA.TM.Ctrl.Data.TMTTRC;
import SA.TM.Ctrl.Data.TMTaskBase;
import SA.TM.Ctrl.Data.TMTaskResAE;
import SA.TM.Ctrl.Data.TMTaskResAEType;
import SA.TM.Ctrl.Data.TMTaskType;
import SA.TM.Ctrl.Data.TMTimeItem;
import SA.TM.Ctrl.Data.TMTimeRule;
import SA.TM.Ctrl.ITMModelHelper;
import java.util.Vector;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class BaseTMModelHelper
implements ITMModelHelper {
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;
    protected String strDBType = "";

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.strDBType = this.iDAGlobalHelper.getDAModelDB();
        this.OnInit();
    }

    protected void OnInit() throws Exception {
    }

    @Override
    public CallResult GetTMTaskType(String strTMTaskTypeId, TMTaskType tmTaskType) {
        return this.SelectSingle(this.GetSQL_GetTMTaskType(strTMTaskTypeId), tmTaskType, "SYSTEM");
    }

    protected String GetSQL_GetTMTaskType(String strTMTaskTypeId) {
        return StringHelper.Format((String)"select t1.* from SRFT_TMTASKTYPE_BASE t1 where t1.TMTASKTYPEID='%1$s'", (Object)strTMTaskTypeId);
    }

    @Override
    public CallResult GetTMResType(String strTMResTypeId, TMResType tmPageType) {
        return this.SelectSingle(this.GetSQL_GetTMResType(strTMResTypeId), tmPageType, "SYSTEM");
    }

    protected String GetSQL_GetTMResType(String strTMResTypeId) {
        return StringHelper.Format((String)"select t1.* from SRFT_TMRESTYPE_BASE t1 where t1.TMRESTYPEID='%1$s'", (Object)strTMResTypeId);
    }

    @Override
    public CallResult GetTMResBT(String strTMResBTId, TMResBT tmResBT) {
        return this.SelectSingle(this.GetSQL_GetTMResBT(strTMResBTId), tmResBT, "SYSTEM");
    }

    protected String GetSQL_GetTMResBT(String strTMResBTId) {
        return StringHelper.Format((String)"select t1.* from SRFT_TMRESBT_BASE t1 where t1.TMRESBTID='%1$s'", (Object)strTMResBTId);
    }

    @Override
    public CallResult GetTMResCatalog(String strTMResCatalogId, TMResCatalog tmPageCatalog) {
        return this.SelectSingle(this.GetSQL_GetTMResCatalog(strTMResCatalogId), tmPageCatalog, "SYSTEM");
    }

    protected String GetSQL_GetTMResCatalog(String strTMResCatalogId) {
        return StringHelper.Format((String)"select t1.* from SRFT_TMRESCATALOG_BASE t1 where t1.TMRESCATALOGID='%1$s'", (Object)strTMResCatalogId);
    }

    @Override
    public CallResult GetTMResView(String strTMResViewId, TMResView tmPageView) {
        return this.SelectSingle(this.GetSQL_GetTMResView(strTMResViewId), tmPageView, "SYSTEM");
    }

    protected String GetSQL_GetTMResView(String strTMResViewId) {
        return StringHelper.Format((String)"select t1.* from SRFT_TMRESVIEW_BASE t1 where t1.TMRESVIEWID='%1$s'", (Object)strTMResViewId);
    }

    @Override
    public CallResult GetTMRBRuleType(String strTMRBRuleTypeId, TMRBRuleType tmRBRuleType) {
        return this.SelectSingle(this.GetSQL_GetTMRBRuleType(strTMRBRuleTypeId), tmRBRuleType, "SYSTEM");
    }

    protected String GetSQL_GetTMRBRuleType(String strTMRBRuleTypeId) {
        return StringHelper.Format((String)"select t1.* from SRFT_TMRBRULETYPE_BASE t1 where t1.TMRBRULETYPEID='%1$s'", (Object)strTMRBRuleTypeId);
    }

    @Override
    public CallResult GetTMRBRule(String strTMRBRuleId, TMRBRule tmRBRule) {
        return this.SelectSingle(this.GetSQL_GetTMRBRule(strTMRBRuleId), tmRBRule, "SYSTEM");
    }

    protected String GetSQL_GetTMRBRule(String strTMRBRuleId) {
        return StringHelper.Format((String)"select t1.* from SRFT_TMRBRULE_BASE t1 where t1.TMRBRULEID='%1$s'", (Object)strTMRBRuleId);
    }

    @Override
    public CallResult GetTMTaskResAEType(String strTMTaskResAETypeId, TMTaskResAEType tmTaskResAEType) {
        return this.SelectSingle(this.GetSQL_GetTMTaskResAEType(strTMTaskResAETypeId), tmTaskResAEType, "SYSTEM");
    }

    protected String GetSQL_GetTMTaskResAEType(String strTMTaskResAETypeId) {
        return StringHelper.Format((String)"select t1.* from SRFT_TMTASKRESAETYPE_BASE t1 where t1.TMTASKRESAETYPEID='%1$s'", (Object)strTMTaskResAETypeId);
    }

    @Override
    public CallResult GetTMTaskResAE(String strTMTaskResAEId, TMTaskResAE tmTaskResAE) {
        return this.SelectSingle(this.GetSQL_GetTMTaskResAE(strTMTaskResAEId), tmTaskResAE, "SYSTEM");
    }

    protected String GetSQL_GetTMTaskResAE(String strTMTaskResAEId) {
        return StringHelper.Format((String)"select t1.* from SRFT_TMTASKRESAE_BASE t1 where t1.TMTASKRESAEID='%1$s'", (Object)strTMTaskResAEId);
    }

    @Override
    public CallResult GetTMTimeRule(String strTMTimeRuleId, TMTimeRule tmTimeRule) {
        return this.SelectSingle(this.GetSQL_GetTMTimeRule(strTMTimeRuleId), tmTimeRule, "SYSTEM");
    }

    protected String GetSQL_GetTMTimeRule(String strTMTimeRuleId) {
        return StringHelper.Format((String)"select t1.* from SRFT_TMTIMERULE_BASE t1 where t1.TMTIMERULEID='%1$s'", (Object)strTMTimeRuleId);
    }

    @Override
    public CallResult GetTMTimeItems(String strTMTimeRuleId, Vector<TMTimeItem> tmTimeItems) {
        return this.SelectMulti(this.GetSQL_GetTMTimeItems(strTMTimeRuleId), tmTimeItems, TMTimeItem.class, "SYSTEM");
    }

    protected String GetSQL_GetTMTimeItems(String strTMTimeRuleId) {
        return StringHelper.Format((String)"select t1.* from SRFV_TMTIMEITEM t1 where t1.TMTIMERULEID='%1$s' ORDER BY t1.ORDERFLAG DESC", (Object)strTMTimeRuleId);
    }

    @Override
    public CallResult GetTMTasksByMainTask(String strTMMainTaskId, Vector<TMTaskBase> tmTaskBases) {
        return this.SelectMulti(this.GetSQL_GetTMTasksByMainTask(strTMMainTaskId), tmTaskBases, TMTaskBase.class, "SYSTEM");
    }

    protected String GetSQL_GetTMTasksByMainTask(String strTMMainTaskId) {
        return StringHelper.Format((String)"select t1.* from SRFT_TMTASKBASE_BASE t1 where t1.TMTASKBASEID<>'%1$s' AND  t1.ROOTTMTASKBASEID='%1$s' ", (Object)strTMMainTaskId);
    }

    @Override
    public CallResult GetTMTask(String strTMTaskId, TMTaskBase tmTaskBase) {
        return this.SelectSingle(this.GetSQL_GetTMTask(strTMTaskId), tmTaskBase, "SYSTEM");
    }

    protected String GetSQL_GetTMTask(String strTMTaskId) {
        return StringHelper.Format((String)"select t1.* from SRFT_TMTASKBASE_BASE t1 where t1.TMTASKBASEID='%1$s'", (Object)strTMTaskId);
    }

    @Override
    public CallResult GetTMResource(String strTMResId, TMResBase tmResBase) {
        return this.SelectSingle(this.GetSQL_GetTMResource(strTMResId), tmResBase, "SYSTEM");
    }

    protected String GetSQL_GetTMResource(String strTMResId) {
        return StringHelper.Format((String)"select t1.* from SRFT_TMRESBASE_BASE t1 where t1.TMRESBASEID='%1$s'", (Object)strTMResId);
    }

    @Override
    public CallResult GetTMComplexRes(String strTMResId, TMComplexRes tmComplexRes) {
        return this.SelectSingle(this.GetSQL_GetTMComplexRes(strTMResId), tmComplexRes, "SYSTEM");
    }

    protected String GetSQL_GetTMComplexRes(String strTMResId) {
        return StringHelper.Format((String)"select t1.* from SRFV_TMCOMPLEXRES t1 where t1.TMCOMPLEXRESID='%1$s'", (Object)strTMResId);
    }

    @Override
    public CallResult GetTMTTRCs(String strTMTaskTypeId, Vector<TMTTRC> tmTTRCs) {
        return this.SelectMulti(this.GetSQL_GetTMTTRCs(strTMTaskTypeId), tmTTRCs, TMTTRC.class, "SYSTEM");
    }

    protected String GetSQL_GetTMTTRCs(String strTMTaskTypeId) {
        return StringHelper.Format((String)"select t1.* from SRFT_TMTTRC_BASE t1 where t1.TMTASKTYPEID='%1$s'", (Object)strTMTaskTypeId);
    }

    @Override
    public CallResult GetTMResCDs(String strTMResCatalogId, Vector<TMResCD> tmResCDs) {
        return this.SelectMulti(this.GetSQL_GetTMResCDs(strTMResCatalogId), tmResCDs, TMResCD.class, "SYSTEM");
    }

    protected String GetSQL_GetTMResCDs(String strTMResCatalogId) {
        return StringHelper.Format((String)"select t1.* from SRFT_TMRESCD_BASE t1 where t1.TMRESCATALOGID='%1$s'", (Object)strTMResCatalogId);
    }

    @Override
    public CallResult GetTMResViewDetails(String strTMResViewId, Vector<TMResViewDetail> tmResViewDetails) {
        return this.SelectMulti(this.GetSQL_GetTMResViewDetails(strTMResViewId), tmResViewDetails, TMResViewDetail.class, "SYSTEM");
    }

    protected String GetSQL_GetTMResViewDetails(String strTMResViewId) {
        return StringHelper.Format((String)"select t1.* from SRFV_TMRESVIEWDETAIL t1 where t1.TMRESVIEWID='%1$s'", (Object)strTMResViewId);
    }

    @Override
    public CallResult GetTMComplexResDetails(String strTMComplexResId, Vector<TMComplexResDetail> tmComplexResDetails) {
        return this.SelectMulti(this.GetSQL_GetTMComplexResDetails(strTMComplexResId), tmComplexResDetails, TMComplexResDetail.class, "SYSTEM");
    }

    protected String GetSQL_GetTMComplexResDetails(String strTMComplexResId) {
        return StringHelper.Format((String)"select t1.* from SRFV_TMCOMPLEXRESDETAIL t1 where t1.TMCOMPLEXRESID='%1$s'", (Object)strTMComplexResId);
    }

    @Override
    public CallResult GetTMBTType(String strTMBTTypeId, TMBTType tmPageType) {
        return this.SelectSingle(this.GetSQL_GetTMBTType(strTMBTTypeId), tmPageType, "SYSTEM");
    }

    protected String GetSQL_GetTMBTType(String strTMBTTypeId) {
        return StringHelper.Format((String)"select t1.* from SRFT_TMBTTYPE_BASE t1 where t1.TMBTTYPEID='%1$s'", (Object)strTMBTTypeId);
    }

    @Override
    public String GetTMBTPlanJoinQuerySQL(boolean bParent, String strOriginSQL) {
        return this.GetTMBTPlanJoinQuerySQL(bParent, strOriginSQL, "t1.TMBTPLANID");
    }

    @Override
    public String GetTMBTPlanJoinQuerySQL(boolean bParent, String strOriginSQL, String strMainTableField) {
        if (StringHelper.Compare((String)this.getDBType(), (String)"DB2", (boolean)true) == 0) {
            String strSQL = "with rpl (TMBTPLANID,PTMBTPLANID) as \t(\t select TMBTPLANID,PTMBTPLANID  from SRFT_TMBTPLAN_BASE  where TMBTPLANID= ? \t union all \t select  parent.TMBTPLANID,parent.PTMBTPLANID from rpl child, SRFT_TMBTPLAN_BASE parent where child.PTMBTPLANID=parent.TMBTPLANID \t) " + strOriginSQL + "\tINNER JOIN rpl x2 ON " + strMainTableField + " = x2.TMBTPLANID  ";
            return strSQL;
        }
        String strSQL = String.valueOf(strOriginSQL) + "\tINNER JOIN (select TMBTPLANID from (select PTMBTPLANID,TMBTPLANID from srft_TMBTPLAN_base ) t connect by prior t.PTMBTPLANID = t.TMBTPLANID start with t.TMBTPLANID = ?) x2 ON " + strMainTableField + " = x2.TMBTPLANID  ";
        return strSQL;
    }

    @Override
    public String getDBType() {
        return this.strDBType;
    }

    protected CallResult SelectSingle(String strSQL, BaseDataEntity dataEntity, String strOpPersonId) {
        CallResult callResult = new CallResult();
        try {
            SelectResult selectResult = this.iDAGlobalHelper.getDBCaller().CallRaw2(strSQL);
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

    protected CallResult SelectMulti(String strSQL, Vector list, Class classType, String strOpPersonId) {
        CallResult callResult = new CallResult();
        try {
            SelectResult selectResult = this.iDAGlobalHelper.getDBCaller().CallRaw2(strSQL);
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
                if (classType != null && (obj = ObjectHelper.Create((Class)classType)) != null && obj instanceof BaseDataEntity) {
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

    protected CallResult SelectMulti(String strSQL, Vector list, String strObjectName, String strOpPersonId) {
        CallResult callResult = new CallResult();
        try {
            SelectResult selectResult = this.iDAGlobalHelper.getDBCaller().CallRaw2(strSQL);
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
}

