/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.Data.DERINDEX
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.TM.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.TM.Ctrl.DEDataCtrl.ITMBTTaskDataCtrl;
import SA.TM.Ctrl.Data.TMTaskBase;
import SA.TM.Ctrl.Data.TMTaskRes;
import java.sql.Connection;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TMBTTaskPlanDataCtrl
extends BaseDEDataCtrl
implements ITMBTTaskDataCtrl {
    private static final Log log = LogFactory.getLog(TMBTTaskPlanDataCtrl.class);
    public static final String UPDATEMODE_TASKRESSTATE = "TASKRESSTATE";

    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        return callResult;
    }

    protected CallResult OnAfterSaveOK(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnAfterSaveOK(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            String strPTMTaskBaseId;
            if (!bInsert && StringHelper.Compare((String)strActionMode, (String)UPDATEMODE_TASKRESSTATE, (boolean)true) != 0) {
                TMTaskBase tmTaskBase = new TMTaskBase();
                tmTaskBase.Proxy(dataEntity);
                TMTaskBase tmTaskBaseLast = null;
                if (lastDataEntity != null) {
                    tmTaskBaseLast = new TMTaskBase();
                    tmTaskBaseLast.Proxy(lastDataEntity);
                    boolean bIgnore = false;
                    if (tmTaskBase.getBEGINTIME() == null && tmTaskBase.getENDTIME() == null && tmTaskBaseLast.getBEGINTIME() == null && tmTaskBaseLast.getENDTIME() == null) {
                        bIgnore = true;
                    } else if (tmTaskBase.getBEGINTIME() != null && tmTaskBase.getENDTIME() != null && tmTaskBaseLast.getBEGINTIME() != null && tmTaskBaseLast.getENDTIME() != null && tmTaskBase.getBEGINTIME().getTime() == tmTaskBaseLast.getBEGINTIME().getTime() && tmTaskBase.getENDTIME().getTime() == tmTaskBaseLast.getENDTIME().getTime()) {
                        bIgnore = true;
                    }
                    if (!bIgnore) {
                        BaseDataEntity cond = new BaseDataEntity();
                        cond.SetParamValue("TMTASKBASEID", (Object)tmTaskBase.GetParamStringValue(this.GetDEHelper().GetKeyDEFHelper().getName(), ""));
                        IDEDataCtrl tmTaskResDataCtrl = this.GetRelatedDataCtrl("TM0115");
                        Vector<BaseDataEntity> tmTaskResList = new Vector<BaseDataEntity>();
                        callResult = tmTaskResDataCtrl.Select(cond, tmTaskResList);
                        if (callResult.IsError()) {
                            return callResult;
                        }
                        if (tmTaskResList.size() > 0) {
                            for (BaseDataEntity item : tmTaskResList) {
                                TMTaskRes tmTaskRes = new TMTaskRes();
                                tmTaskRes.setTMTASKRESID(item.GetParamStringValue("TMTASKRESID", ""));
                                callResult = tmTaskResDataCtrl.Save(false, (BaseDataEntity)tmTaskRes);
                                if (!callResult.IsError()) continue;
                                return callResult;
                            }
                        } else {
                            bIgnore = true;
                        }
                        if (!bIgnore && (callResult = this.Get(dataEntity)).IsError()) {
                            return callResult;
                        }
                    }
                }
            }
            if (!StringHelper.IsNullOrEmpty((String)(strPTMTaskBaseId = dataEntity.GetParamStringValue("PTMTASKBASEID", "")))) {
                callResult = this.UpdateParentTaskInfo(strPTMTaskBaseId);
            }
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u4efb\u52a1\u6570\u636e\u4fdd\u5b58\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
            return callResult;
        }
        return callResult;
    }

    protected CallResult OnBeforeRemove(String strActionMode, BaseDataEntity dataEntity) {
        CallResult callResult = super.OnBeforeRemove(strActionMode, dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        return callResult;
    }

    protected CallResult OnAfterRemoveOK(String strActionMode, BaseDataEntity dataEntity) {
        CallResult callResult = super.OnAfterRemoveOK(strActionMode, dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        String strPTMTaskBaseId = dataEntity.GetParamStringValue("PTMTASKBASEID", "");
        if (!StringHelper.IsNullOrEmpty((String)strPTMTaskBaseId)) {
            callResult = this.UpdateParentTaskInfo(strPTMTaskBaseId);
        }
        return callResult;
    }

    public CallResult UpdateParentTaskInfo(String strPTMTaskId) {
        String strSQL = "select TMTASKBASETYPE,a.BEGINTIME,a.ENDTIME from SRFT_TMTASKBASE_BASE t1  LEFT JOIN  ( select PTMTASKBASEID ,MIN(t1.BEGINTIME) as BEGINTIME,MAX(t1.ENDTIME) as ENDTIME from  SRFT_TMTASKBASE_BASE t1   where t1.BEGINTIME IS NOT NULL AND t1.ENDTIME IS NOT NULL  AND PTMTASKBASEID=? group by PTMTASKBASEID  ) a on t1.TMTASKBASEID = a.PTMTASKBASEID   where TMTASKBASEID=? ";
        CallParamList callParamList = new CallParamList();
        callParamList.Add((Object)strPTMTaskId);
        callParamList.Add((Object)strPTMTaskId);
        Vector<TMTaskBase> list = new Vector<TMTaskBase>();
        CallResult callResult = TMBTTaskPlanDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.globalHelperEx, (Connection)this.getConnection(), (String)this.GetDEHelper().GetDBStorage(), (String)strSQL, (Vector)callParamList.GetList(), list, (String)TMTaskBase.class.getName());
        if (callResult.IsError()) {
            return callResult;
        }
        TMTaskBase tmTaskBase = null;
        if (list.size() != 1) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u8ba1\u7b97\u7236\u4efb\u52a1[%1$s]\u4fe1\u606f", (Object)strPTMTaskId));
            return callResult;
        }
        tmTaskBase = (TMTaskBase)((Object)list.get(0));
        String strTMTaskType = tmTaskBase.getTMTASKBASETYPE();
        IDEHelper tmTaskBaseDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper("TM0050");
        DERINDEX derIndex = tmTaskBaseDEHelper.FindDERINDEX(strTMTaskType);
        if (derIndex == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u4efb\u52a1\u5bf9\u8c61\u7ee7\u627f\u7c7b\u578b[%1$s]", (Object)strTMTaskType));
            return callResult;
        }
        try {
            IDEDataCtrl iDEDataCtrl = this.GetRelatedDataCtrl(derIndex.getDEID());
            tmTaskBase.SetParamValue(iDEDataCtrl.GetDEHelper().GetKeyDEFHelper().getName(), strPTMTaskId);
            callResult = iDEDataCtrl.Save(false, (BaseDataEntity)tmTaskBase);
            return callResult;
        }
        catch (Exception e) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
            log.error((Object)callResult.getErrorInfo(), (Throwable)e);
            return callResult;
        }
    }

    public CallResult UpdateBTTaskResState(BaseDataEntity dataEntity) {
        try {
            CallResult callResult = this.OnUpdateBTTaskResState(dataEntity);
            return callResult;
        }
        catch (Exception ex) {
            CallResult callResult = new CallResult();
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u66f4\u65b0\u4efb\u52a1\u8d44\u6e90\u72b6\u6001\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
    }

    protected CallResult OnUpdateBTTaskResState(BaseDataEntity dataEntity) throws Exception {
        String strKeyName = this.GetDEHelper().GetKeyDEFHelper().getName();
        String strTMTaskBaseId = dataEntity.GetParamStringValue(strKeyName, "");
        if (StringHelper.IsNullOrEmpty((String)strTMTaskBaseId)) {
            strTMTaskBaseId = dataEntity.GetParamStringValue("TMTASKBASEID", "");
        }
        if (StringHelper.IsNullOrEmpty((String)strTMTaskBaseId)) {
            throw new Exception("\u4efb\u52a1\u6807\u8bc6\u65e0\u6548");
        }
        CallParamList callParamList = new CallParamList();
        callParamList.Add((Object)strTMTaskBaseId);
        callParamList.Add((Object)strTMTaskBaseId);
        String strSQL = " select REQUIREMODE, count(*) AS CNT ,sum(cnt) AS CNT2 from (  select REQUIREMODE, 1 as CNT  from SRFT_TMTASKRES_BASE where TMRESCDID IS NOT NULL AND TMTASKBASEID = ?  union all select REQUIREMODE, 0 as CNT  from SRFT_TMTASKRES_BASE where TMRESCDID IS  NULL  AND TMTASKBASEID = ?  ) a group by REQUIREMODE";
        Vector<BaseDataEntity> list = new Vector<BaseDataEntity>();
        CallResult callResult = TMBTTaskPlanDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.globalHelperEx, (Connection)this.getConnection(), (String)this.GetDEHelper().GetDBStorage(), (String)strSQL, (Vector)callParamList.GetList(), list, null);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u4efb\u52a1\u8d44\u6e90\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        TMTaskBase tmTaskBase = new TMTaskBase();
        tmTaskBase.SetParamValue(strKeyName, strTMTaskBaseId);
        tmTaskBase.setNRCNT(0);
        tmTaskBase.setNRCNT2(0);
        tmTaskBase.setORCNT(0);
        tmTaskBase.setORCNT2(0);
        for (BaseDataEntity item : list) {
            String strRequireMode = item.GetParamStringValue("REQUIREMODE", "");
            if (StringHelper.Compare((String)strRequireMode, (String)"NECESSARY", (boolean)true) == 0) {
                tmTaskBase.setNRCNT(item.GetParamIntValue("CNT", 0));
                tmTaskBase.setNRCNT2(item.GetParamIntValue("CNT2", 0));
                continue;
            }
            if (StringHelper.Compare((String)strRequireMode, (String)"OPTIONAL", (boolean)true) != 0) continue;
            tmTaskBase.setORCNT(item.GetParamIntValue("CNT", 0));
            tmTaskBase.setORCNT2(item.GetParamIntValue("CNT2", 0));
        }
        if (tmTaskBase.getNRCNT() == tmTaskBase.getNRCNT2() && tmTaskBase.getORCNT() == tmTaskBase.getORCNT2()) {
            tmTaskBase.setTASKRESSTATE("OK");
        } else if (tmTaskBase.getNRCNT() == tmTaskBase.getNRCNT2()) {
            tmTaskBase.setTASKRESSTATE("NECESSARYOK");
        } else {
            tmTaskBase.setTASKRESSTATE("NOTOK");
        }
        String strTaskResStateInfo = StringHelper.Format((String)"\u5fc5\u987b[%1$s/%2$s]\uff0c\u53ef\u9009[%3$s/%4$s]", (Object)tmTaskBase.getNRCNT2(), (Object)tmTaskBase.getNRCNT(), (Object)tmTaskBase.getORCNT2(), (Object)tmTaskBase.getORCNT());
        tmTaskBase.setTASKRESSTATEINFO(strTaskResStateInfo);
        return this.Save(false, UPDATEMODE_TASKRESSTATE, tmTaskBase);
    }
}
