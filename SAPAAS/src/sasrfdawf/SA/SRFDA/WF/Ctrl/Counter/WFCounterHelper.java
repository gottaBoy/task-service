/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseCounterHelper
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.CounterResult
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Data.DESubWF
 *  SA.SRFDA.Ctrl.Data.DEWF
 *  SA.SRFDA.Ctrl.Data.QueryModel
 *  SA.SRFDA.Ctrl.DefaultDAQueryModelUserContext
 *  SA.SRFDA.Ctrl.IDAActionContext
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SRFWF.Ctrl.Data.WFWorkflow
 *  SRFWF.Model.WFBaseProcessConfig
 *  SRFWF.Model.WFConfig
 *  SRFWF.Model.WFParallelSubWFConfig
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.WF.Ctrl.Counter;

import SA.SRFDA.Ctrl.BaseCounterHelper;
import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.CounterResult;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.DESubWF;
import SA.SRFDA.Ctrl.Data.DEWF;
import SA.SRFDA.Ctrl.Data.QueryModel;
import SA.SRFDA.Ctrl.DefaultDAQueryModelUserContext;
import SA.SRFDA.Ctrl.IDAActionContext;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.WF.Ctrl.WFHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SRFWF.Ctrl.Data.WFWorkflow;
import SRFWF.Model.WFBaseProcessConfig;
import SRFWF.Model.WFConfig;
import SRFWF.Model.WFParallelSubWFConfig;
import java.util.Hashtable;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WFCounterHelper
extends BaseCounterHelper {
    private static final Log log = LogFactory.getLog(WFCounterHelper.class);

    protected CounterResult OnCalc(IDAActionContext iDAActionContext) throws Exception {
        String strExtCntStates;
        WFWorkflow workflow;
        WFConfig wFConfig;
        CounterResult counterResult = new CounterResult();
        String strDEID = this.counter.getDEID();
        IDEHelper iDEHelper = this.getDAGlobalHelper().getDAModelStorage().FindDEHelper2(strDEID);
        String strWFID = iDEHelper.GetDEWFId(iDAActionContext.getWebContext().getSRFWFMode());
        DEWF dewf = iDEHelper.GetDEWF();
        if (dewf == null) {
            throw new Exception("\u5b9e\u4f53\u5de5\u4f5c\u6d41\u65e0\u6548");
        }
        IDEFHelper wfStateValueDEFHelper = iDEHelper.GetDEFHelper(dewf.getSTATEDEFID());
        if (wfStateValueDEFHelper == null) {
            throw new Exception("\u6d41\u7a0b\u72b6\u6001\u5c5e\u6027\u65e0\u6548");
        }
        IDEFHelper wfStepValueDEFHelper = iDEHelper.GetDEFHelper(dewf.getWFSTEPDEFID());
        if (wfStepValueDEFHelper == null) {
            throw new Exception("\u6d41\u7a0b\u6b65\u9aa4\u5c5e\u6027\u65e0\u6548");
        }
        StringBuilderEx sql = new StringBuilderEx();
        sql.Append("select WFSTEPNAME,COUNT(*) AS CNT from ( \r\n");
        sql.Append("\tselect t1.WFSTEPNAME from T_SRFWFSTEP t1 INNER JOIN t_SRFWFINSTANCE t2 on  t2.ACTIVESTEPID = t1.WFSTEPID AND ( t2.ISCLOSE IS NULL OR t2.ISCLOSE=0)\r\n");
        sql.Append("\tINNER JOIN T_SRFWFWORKFLOW t3 on t2.WFWORKFLOWID = t3.WFWORKFLOWID  \r\n");
        sql.Append("\tINNER JOIN T_SRFWFSTEPACTOR t4 on  t4.WFSTEPID = t1.WFSTEPID  \r\n");
        sql.Append("\tLEFT JOIN T_SRFWFSTEPDATA t5 ON (t5.ACTORID=T4.ACTORID and  t5.WFSTEPID = t2.ACTIVESTEPID AND t5.CONNECTIONNAME<>'SRFWFRESUBMIT'   AND t5.CONNECTIONNAME <> 'SRFWFTIMEOUT')\r\n");
        sql.Append("\twhere t5.WFSTEPDATAID IS NULL AND t4.ACTORID='%1$s' AND t3.WFWORKFLOWID='%2$s' AND t2.USERDATA4='%3$s'\r\n", (Object)iDAActionContext.getWebContext().getCurUserId(), (Object)strWFID, (Object)strDEID);
        sql.Append(") a GROUP BY WFSTEPNAME\r\n");
        Vector<BaseDataEntity> list = new Vector<BaseDataEntity>();
        CallResult callResult = BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)iDAActionContext.getWebContext().getGlobalHelper(), (String)sql.toString(), null, list, (String)"");
        if (callResult.getRetCode() != 0) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u6d41\u7a0b\u5de5\u4f5c\u6570\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        sql.Reset();
        if (iDAActionContext.getWebContext().getGlobalHelper().getDAModelVersion() >= 11062700) {
            sql.Append("select WFSTEPNAME,COUNT(*) AS CNT ,DESUBWFID,PWFSTEPNAME from ( \r\n");
            sql.Append("\t\tselect t1.WFSTEPNAME,t2.USERTAG as DESUBWFID ,t7.WFSTEPNAME as PWFSTEPNAME from T_SRFWFSTEP t1 INNER JOIN t_SRFWFINSTANCE t2 on  t2.ACTIVESTEPID = t1.WFSTEPID AND ( t2.ISCLOSE IS NULL OR t2.ISCLOSE=0)\r\n");
            sql.Append("\t\tINNER JOIN T_SRFWFWORKFLOW t3 on t2.WFWORKFLOWID = t3.WFWORKFLOWID  \r\n");
            sql.Append("\t\tINNER JOIN T_SRFWFSTEPACTOR t4 on  t4.WFSTEPID = t1.WFSTEPID  \r\n");
            sql.Append("\t\tINNER JOIN T_SRFDESUBWF t6 on t2.WFWORKFLOWID = t6.WFID AND t2.USERDATA4 = t6.DEID\r\n");
            sql.Append("\t\tINNER JOIN T_SRFWFSTEP t7 on t2.PSTEPID = t7.WFSTEPID \r\n");
            sql.Append("\t\tINNER JOIN t_SRFWFINSTANCE t8 ON t2.PWFINSTANCEID = t8.WFINSTANCEID\r\n");
            sql.Append("\t\tLEFT JOIN T_SRFWFSTEPDATA t5 ON (t5.ACTORID=T4.ACTORID and  t5.WFSTEPID = t2.ACTIVESTEPID AND t5.CONNECTIONNAME<>'SRFWFRESUBMIT'   AND t5.CONNECTIONNAME <> 'SRFWFTIMEOUT')\r\n");
            sql.Append("\t\twhere t5.WFSTEPDATAID IS NULL AND t4.ACTORID='%1$s'  AND t8.WFWORKFLOWID='%2$s'  AND t2.USERDATA4='%3$s' AND t2.PARALLELINST=1\r\n", (Object)iDAActionContext.getWebContext().getCurUserId(), (Object)strWFID, (Object)strDEID);
            sql.Append("\t) a GROUP BY WFSTEPNAME,DESUBWFID,PWFSTEPNAME\r\n");
            callResult = BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)iDAActionContext.getWebContext().getGlobalHelper(), (String)sql.toString(), null, list, (String)"");
            if (callResult.getRetCode() != 0) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u6d41\u7a0b\u5de5\u4f5c\u6570\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
        }
        sql.Reset();
        int nTotal = 0;
        for (BaseDataEntity dataEntity : list) {
            String strPWFStepName;
            String strWFStepName = dataEntity.GetParamStringValue("WFSTEPNAME", "");
            if (StringHelper.Compare((String)strWFStepName, (String)"WFSTEPNAME", (boolean)true) == 0 || StringHelper.Compare((String)(strPWFStepName = dataEntity.GetParamStringValue("PWFSTEPNAME", "")), (String)"WFSTEPNAME", (boolean)true) == 0) continue;
            String strDESUBWFID = dataEntity.GetParamStringValue("DESUBWFID", "");
            if (StringHelper.IsNullOrEmpty((String)strDESUBWFID)) {
                counterResult.getExtCountMap().put("V" + strWFStepName, dataEntity.GetParamIntValue("CNT", 0));
            } else {
                counterResult.getExtCountMap().put("V" + strPWFStepName + "_" + strDESUBWFID + "_" + strWFStepName, dataEntity.GetParamIntValue("CNT", 0));
            }
            nTotal += dataEntity.GetParamIntValue("CNT", 0);
        }
        counterResult.getExtCountMap().put("V", nTotal);
        BaseDAQueryModelHelper daQueryModelHelper = null;
        String strQueryModel = dewf.getQUERYMODELID();
        if (!StringHelper.IsNullOrEmpty((String)strQueryModel)) {
            String strNewQueryModelId = String.valueOf(strQueryModel) + "_SRFWFHELPER";
            Object objQueryModel = iDEHelper.GetAttribute(strNewQueryModelId);
            if (objQueryModel != null) {
                daQueryModelHelper = (BaseDAQueryModelHelper)objQueryModel;
            } else {
                WFWorkflow workflow2;
                WFConfig wfConfig2;
                Hashtable<String, String> selectedColumns = new Hashtable<String, String>();
                selectedColumns.put(iDEHelper.GetKeyDEFHelper().getName(), "");
                selectedColumns.put(iDEHelper.GetMajorDEFHelper().getName(), "");
                selectedColumns.put(wfStateValueDEFHelper.getName(), "");
                selectedColumns.put(wfStepValueDEFHelper.getName(), "");
                if (iDAActionContext.getWebContext().getGlobalHelper().getDAModelVersion() >= 11062700 && (wfConfig2 = (workflow2 = (WFWorkflow)this.getDAModelStorage().FindGlobalModel("WF0001").FindModel((Object)strWFID)).getWFConfig()) != null) {
                    for (WFBaseProcessConfig processConfig : wfConfig2.getProcessesConfig()) {
                        if (!(processConfig instanceof WFParallelSubWFConfig)) continue;
                        Vector<DESubWF> deSubWFList = new Vector<DESubWF>();
                        try {
                            WFHelper.GetDESubWFList(iDEHelper, (WFParallelSubWFConfig)processConfig, deSubWFList);
                        }
                        catch (Exception exception) {
                            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5e76\u884c\u5b50\u6d41\u7a0b\u5b9e\u4f53\u5b50\u6d41\u7a0b\u96c6\u5408\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()));
                        }
                        for (DESubWF dESubWF : deSubWFList) {
                            IDEFHelper subStepDEFHelper = iDEHelper.GetDEFHelper(dESubWF.getWFSTEPDEFID());
                            if (subStepDEFHelper == null) {
                                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]", (Object)iDEHelper.getId(), (Object)dESubWF.getWFSTEPDEFID()));
                            }
                            selectedColumns.put(subStepDEFHelper.getName(), "");
                        }
                    }
                }
                if (selectedColumns.size() > 0) {
                    QueryModel queryModel = new QueryModel();
                    callResult = this.getDAModelStorage().GetQueryModel(strQueryModel, queryModel, true);
                    if (callResult.IsError()) {
                        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u67e5\u8be2\u6a21\u578b\u8f85\u52a9\u5bf9\u8c61[%1$s]", (Object)strQueryModel));
                    }
                    String strColumns = "";
                    for (String strColumn : selectedColumns.keySet()) {
                        if (!StringHelper.IsNullOrEmpty((String)strColumns)) {
                            strColumns = String.valueOf(strColumns) + ";";
                        }
                        strColumns = String.valueOf(strColumns) + strColumn;
                    }
                    queryModel.setQUERYMODELID(strNewQueryModelId);
                    queryModel.getQueryModelConfig().setExtSelect(strColumns);
                    daQueryModelHelper = this.getDAModelStorage().FindDAQueryModelHelper(queryModel);
                } else {
                    daQueryModelHelper = this.getDAModelStorage().FindDAQueryModelHelper(strQueryModel);
                }
                iDEHelper.SetAttribute(strNewQueryModelId, (Object)daQueryModelHelper);
            }
            if (daQueryModelHelper == null) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u67e5\u8be2\u6a21\u578b\u8f85\u52a9\u5bf9\u8c61[%1$s]", (Object)strQueryModel));
            }
        } else {
            throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u3010\u6211\u7684\u6570\u636e\u3011\u67e5\u8be2\u6a21\u578b"));
        }
        DefaultDAQueryModelUserContext qmUserContext = new DefaultDAQueryModelUserContext();
        StringBuilderEx script = new StringBuilderEx();
        script.Append(daQueryModelHelper.GetQueryModelScript());
        Vector<String> userConditions = new Vector<String>();
        daQueryModelHelper.FillMajorConditions(userConditions);
        String strStateCondition = "";
        String[] states = dewf.getWFSTATEVALUE().split("[|]");
        int i = 0;
        while (i < states.length) {
            String strState = states[i];
            if (!StringHelper.IsNullOrEmpty((String)(strState = strState.trim()))) {
                String strCondition = daQueryModelHelper.GetConditionSQL(wfStateValueDEFHelper, "", "=", strState);
                if (!StringHelper.IsNullOrEmpty((String)strStateCondition)) {
                    strStateCondition = String.valueOf(strStateCondition) + " OR ";
                }
                strStateCondition = String.valueOf(strStateCondition) + (String)strCondition;
            }
            ++i;
        }
        if (!StringHelper.IsNullOrEmpty((String)strStateCondition)) {
            userConditions.add(strStateCondition);
        }
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
        String strGroupSQL = String.valueOf(daQueryModelHelper.GetQMDeclareScript()) + qmUserContext.GetQMDeclareScript();
        strGroupSQL = String.valueOf(strGroupSQL) + StringHelper.Format((String)"select %1$s,COUNT(*) AS CNT from ( \r\n", (Object)wfStepValueDEFHelper.getName());
        strGroupSQL = String.valueOf(strGroupSQL) + script.toString();
        strGroupSQL = String.valueOf(strGroupSQL) + StringHelper.Format((String)") a GROUP BY %1$s\r\n", (Object)wfStepValueDEFHelper.getName());
        Vector params = new Vector();
        daQueryModelHelper.FillQMDeclareParams(params, iDAActionContext.getWebContext(), iDAActionContext.getWebContext().getGlobalHelper(), iDAActionContext.getWebContext().getCurUserId());
        qmUserContext.FillQMDeclareParams(params, iDAActionContext.getWebContext(), iDAActionContext.getWebContext().getGlobalHelper(), iDAActionContext.getWebContext().getCurUserId());
        daQueryModelHelper.FillCallParams(params, iDAActionContext.getWebContext(), iDAActionContext.getWebContext().getGlobalHelper(), iDAActionContext.getWebContext().getCurUserId());
        list.clear();
        callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)iDAActionContext.getWebContext().getGlobalHelper(), (String)daQueryModelHelper.GetMajorDEHelper().GetDBStorage(), (String)strGroupSQL, params, list, (String)"");
        if (callResult.getRetCode() != 0) {
            throw new Exception(StringHelper.Format((String)"\u6570\u636e\u67e5\u8be2\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        nTotal = 0;
        for (BaseDataEntity dataEntity : list) {
            String strStepName = dataEntity.GetParamStringValue(wfStepValueDEFHelper.getName(), "");
            if (StringHelper.IsNullOrEmpty((String)strStepName)) continue;
            counterResult.getExtCountMap().put("S" + strStepName, dataEntity.GetParamIntValue("CNT", 0));
            nTotal += dataEntity.GetParamIntValue("CNT", 0);
        }
        counterResult.getExtCountMap().put("S", nTotal);
        if (iDAActionContext.getWebContext().getGlobalHelper().getDAModelVersion() >= 11062700 && (wFConfig = (workflow = (WFWorkflow)this.getDAModelStorage().FindGlobalModel("WF0001").FindModel((Object)strWFID)).getWFConfig()) != null) {
            for (WFBaseProcessConfig processConfig : wFConfig.getProcessesConfig()) {
                if (!(processConfig instanceof WFParallelSubWFConfig)) continue;
                Vector<DESubWF> deSubWFList = new Vector<DESubWF>();
                try {
                    WFHelper.GetDESubWFList(iDEHelper, (WFParallelSubWFConfig)processConfig, deSubWFList);
                }
                catch (Exception ex) {
                    throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5e76\u884c\u5b50\u6d41\u7a0b\u5b9e\u4f53\u5b50\u6d41\u7a0b\u96c6\u5408\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
                }
                for (DESubWF deSubWF : deSubWFList) {
                    IDEFHelper subStepDEFHelper = iDEHelper.GetDEFHelper(deSubWF.getWFSTEPDEFID());
                    if (subStepDEFHelper == null) {
                        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]", (Object)iDEHelper.getId(), (Object)deSubWF.getWFSTEPDEFID()));
                    }
                    strGroupSQL = String.valueOf(daQueryModelHelper.GetQMDeclareScript()) + qmUserContext.GetQMDeclareScript();
                    strGroupSQL = String.valueOf(strGroupSQL) + StringHelper.Format((String)"select %1$s,%2$s,COUNT(*) AS CNT from ( \r\n", (Object)wfStepValueDEFHelper.getName(), (Object)subStepDEFHelper.getName());
                    strGroupSQL = String.valueOf(strGroupSQL) + script.toString();
                    strGroupSQL = String.valueOf(strGroupSQL) + StringHelper.Format((String)") a GROUP BY %1$s,%2$s\r\n", (Object)wfStepValueDEFHelper.getName(), (Object)subStepDEFHelper.getName());
                    list.clear();
                    callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)iDAActionContext.getWebContext().getGlobalHelper(), (String)daQueryModelHelper.GetMajorDEHelper().GetDBStorage(), (String)strGroupSQL, params, list, (String)"");
                    if (callResult.getRetCode() != 0) {
                        throw new Exception(StringHelper.Format((String)"\u6570\u636e\u67e5\u8be2\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    for (BaseDataEntity dataEntity : list) {
                        String strSubStepName;
                        String strStepName = dataEntity.GetParamStringValue(wfStepValueDEFHelper.getName(), "");
                        if (StringHelper.IsNullOrEmpty((String)strStepName) || StringHelper.IsNullOrEmpty((String)(strSubStepName = dataEntity.GetParamStringValue(subStepDEFHelper.getName(), "")))) continue;
                        counterResult.getExtCountMap().put("S" + strStepName + "_" + deSubWF.getDESUBWFID() + "_" + strSubStepName, dataEntity.GetParamIntValue("CNT", 0));
                    }
                }
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)(strExtCntStates = dewf.getEXTCNTSTATES()))) {
            script.Reset();
            script.Append(daQueryModelHelper.GetQueryModelScript());
            userConditions.clear();
            daQueryModelHelper.FillMajorConditions(userConditions);
            String[] stringArray = strExtCntStates.split("[|]");
            if (stringArray.length == 1 && StringHelper.Compare((String)stringArray[0], (String)"*", (boolean)true) == 0) {
                strStateCondition = "";
            } else {
                int i2 = 0;
                while (i2 < stringArray.length) {
                    String strState = stringArray[i2];
                    if (!StringHelper.IsNullOrEmpty((String)(strState = strState.trim()))) {
                        String strCondition = daQueryModelHelper.GetConditionSQL(wfStateValueDEFHelper, "", "=", strState);
                        if (!StringHelper.IsNullOrEmpty((String)strStateCondition)) {
                            strStateCondition = String.valueOf(strStateCondition) + " OR ";
                        }
                        strStateCondition = String.valueOf(strStateCondition) + (String)strCondition;
                    }
                    ++i2;
                }
            }
            if (!StringHelper.IsNullOrEmpty((String)strStateCondition)) {
                userConditions.add(strStateCondition);
            }
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
            strGroupSQL = String.valueOf(daQueryModelHelper.GetQMDeclareScript()) + qmUserContext.GetQMDeclareScript();
            strGroupSQL = String.valueOf(strGroupSQL) + StringHelper.Format((String)"select %1$s,COUNT(*) AS CNT from ( \r\n", (Object)wfStateValueDEFHelper.getName());
            strGroupSQL = String.valueOf(strGroupSQL) + script.toString();
            strGroupSQL = String.valueOf(strGroupSQL) + StringHelper.Format((String)") a GROUP BY %1$s\r\n", (Object)wfStateValueDEFHelper.getName());
            list.clear();
            callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)iDAActionContext.getWebContext().getGlobalHelper(), (String)daQueryModelHelper.GetMajorDEHelper().GetDBStorage(), (String)strGroupSQL, params, list, (String)"");
            if (callResult.getRetCode() != 0) {
                throw new Exception(StringHelper.Format((String)"\u6570\u636e\u67e5\u8be2\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            for (BaseDataEntity dataEntity : list) {
                String strStepName = dataEntity.GetParamStringValue(wfStateValueDEFHelper.getName(), "");
                if (StringHelper.IsNullOrEmpty((String)strStepName)) continue;
                counterResult.getExtCountMap().put("E" + strStepName, dataEntity.GetParamIntValue("CNT", 0));
            }
        }
        return counterResult;
    }
}

