/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Data.DESubWF
 *  SA.SRFDA.Ctrl.Data.DEWF
 *  SA.SRFDA.Ctrl.Data.QueryModel
 *  SA.SRFDA.Ctrl.DefaultDAQueryModelUserContext
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SRFWF.Ctrl.Data.WFWorkflow
 *  SRFWF.Model.WFBaseProcessConfig
 *  SRFWF.Model.WFConfig
 *  SRFWF.Model.WFParallelSubWFConfig
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.WF.Web;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.DESubWF;
import SA.SRFDA.Ctrl.Data.DEWF;
import SA.SRFDA.Ctrl.Data.QueryModel;
import SA.SRFDA.Ctrl.DefaultDAQueryModelUserContext;
import SA.SRFDA.WF.Ctrl.WFHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAPage;
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
import java.util.Iterator;
import java.util.Vector;
import net.sf.json.JSONObject;

public class WFHelperPage
extends SRFDAPage {
    public static final String TAG_ACTION_WFSTEPCOUNT = "WFSTEPCOUNT";
    protected DefaultDAQueryModelUserContext qmUserContext = null;

    public WFHelperPage() {
        this.setMainPage(true);
        this.setOutputDebug(false);
    }

    protected void OnLoadBackEnd() {
        String strMajorAction = this.getWebContext().GetParamValue("MAJORACTION");
        if (StringHelper.Compare((String)strMajorAction, (String)TAG_ACTION_WFSTEPCOUNT, (boolean)true) == 0) {
            String strExtCntStates;
            WFWorkflow workflow;
            WFConfig wfConfig;
            String strDEID = this.getWebContext().GetParamValue("DEID");
            String strWFID = this.getWebContext().GetParamValue("WFID");
            this.strPageDataEntityId = strDEID;
            if (!this.LoadPageDataEntity()) {
                return;
            }
            DEWF dewf = this.getDEHelper().GetDEWF();
            if (dewf == null) {
                return;
            }
            IDEFHelper wfStateValueDEFHelper = this.getDEHelper().GetDEFHelper(dewf.getSTATEDEFID());
            if (wfStateValueDEFHelper == null) {
                return;
            }
            IDEFHelper wfStepValueDEFHelper = this.getDEHelper().GetDEFHelper(dewf.getWFSTEPDEFID());
            if (wfStepValueDEFHelper == null) {
                return;
            }
            StringBuilderEx sql = new StringBuilderEx();
            sql.Append("select WFSTEPNAME,COUNT(*) AS CNT from ( \r\n");
            sql.Append("\tselect t1.WFSTEPNAME from T_SRFWFSTEP t1 INNER JOIN t_SRFWFINSTANCE t2 on  t2.ACTIVESTEPID = t1.WFSTEPID AND ( t2.ISCLOSE IS NULL OR t2.ISCLOSE=0)\r\n");
            sql.Append("\tINNER JOIN T_SRFWFWORKFLOW t3 on t2.WFWORKFLOWID = t3.WFWORKFLOWID  \r\n");
            sql.Append("\tINNER JOIN T_SRFWFSTEPACTOR t4 on  t4.WFSTEPID = t1.WFSTEPID  \r\n");
            sql.Append("\tLEFT JOIN T_SRFWFSTEPDATA t5 ON (t5.ACTORID=T4.ACTORID and  t5.WFSTEPID = t2.ACTIVESTEPID AND t5.CONNECTIONNAME<>'SRFWFRESUBMIT'   AND t5.CONNECTIONNAME <> 'SRFWFTIMEOUT')\r\n");
            sql.Append("\twhere t5.WFSTEPDATAID IS NULL AND t4.ACTORID='%1$s' AND t3.WFWORKFLOWID='%2$s' AND t2.USERDATA4='%3$s'\r\n", (Object)this.getWebContext().getCurUserId(), (Object)strWFID, (Object)strDEID);
            sql.Append(") a GROUP BY WFSTEPNAME\r\n");
            Vector<BaseDataEntity> list = new Vector<BaseDataEntity>();
            CallResult callResult = BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), (String)sql.toString(), null, list, (String)"");
            if (callResult.getRetCode() != 0) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u67e5\u8be2\u6d41\u7a0b\u5de5\u4f5c\u6570\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                return;
            }
            sql.Reset();
            if (this.getWebContext().getGlobalHelper().getDAModelVersion() >= 11062700) {
                sql.Append("select WFSTEPNAME,COUNT(*) AS CNT ,DESUBWFID,PWFSTEPNAME from ( \r\n");
                sql.Append("\t\tselect t1.WFSTEPNAME,t2.USERTAG as DESUBWFID ,t7.WFSTEPNAME as PWFSTEPNAME from T_SRFWFSTEP t1 INNER JOIN t_SRFWFINSTANCE t2 on  t2.ACTIVESTEPID = t1.WFSTEPID AND ( t2.ISCLOSE IS NULL OR t2.ISCLOSE=0)\r\n");
                sql.Append("\t\tINNER JOIN T_SRFWFWORKFLOW t3 on t2.WFWORKFLOWID = t3.WFWORKFLOWID  \r\n");
                sql.Append("\t\tINNER JOIN T_SRFWFSTEPACTOR t4 on  t4.WFSTEPID = t1.WFSTEPID  \r\n");
                sql.Append("\t\tINNER JOIN T_SRFDESUBWF t6 on t2.WFWORKFLOWID = t6.WFID AND t2.USERDATA4 = t6.DEID\r\n");
                sql.Append("\t\tINNER JOIN T_SRFWFSTEP t7 on t2.PSTEPID = t7.WFSTEPID \r\n");
                sql.Append("\t\tINNER JOIN t_SRFWFINSTANCE t8 ON t2.PWFINSTANCEID = t8.WFINSTANCEID\r\n");
                sql.Append("\t\tLEFT JOIN T_SRFWFSTEPDATA t5 ON (t5.ACTORID=T4.ACTORID and  t5.WFSTEPID = t2.ACTIVESTEPID AND t5.CONNECTIONNAME<>'SRFWFRESUBMIT'   AND t5.CONNECTIONNAME <> 'SRFWFTIMEOUT')\r\n");
                sql.Append("\t\twhere t5.WFSTEPDATAID IS NULL AND t4.ACTORID='%1$s'  AND t8.WFWORKFLOWID='%2$s'  AND t2.USERDATA4='%3$s' AND t2.PARALLELINST=1\r\n", (Object)this.getWebContext().getCurUserId(), (Object)strWFID, (Object)strDEID);
                sql.Append("\t) a GROUP BY WFSTEPNAME,DESUBWFID,PWFSTEPNAME\r\n");
                callResult = BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), (String)sql.toString(), null, list, (String)"");
                if (callResult.getRetCode() != 0) {
                    this.PageLog((Object)this, 1, StringHelper.Format((String)"\u67e5\u8be2\u6d41\u7a0b\u5de5\u4f5c\u6570\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    return;
                }
            }
            sql.Reset();
            int nTotal = 0;
            JSONObject jsonObject = new JSONObject();
            for (BaseDataEntity dataEntity : list) {
                String strPWFStepName;
                String strWFStepName = dataEntity.GetParamStringValue("WFSTEPNAME", "");
                if (StringHelper.Compare((String)strWFStepName, (String)"WFSTEPNAME", (boolean)true) == 0 || StringHelper.Compare((String)(strPWFStepName = dataEntity.GetParamStringValue("PWFSTEPNAME", "")), (String)"WFSTEPNAME", (boolean)true) == 0) continue;
                String strDESUBWFID = dataEntity.GetParamStringValue("DESUBWFID", "");
                if (StringHelper.IsNullOrEmpty((String)strDESUBWFID)) {
                    jsonObject.put("V" + strWFStepName, (Object)dataEntity.GetParamStringValue("CNT", ""));
                } else {
                    jsonObject.put("V" + strPWFStepName + "_" + strDESUBWFID + "_" + strWFStepName, (Object)dataEntity.GetParamStringValue("CNT", ""));
                }
                nTotal += dataEntity.GetParamIntValue("CNT", 0);
            }
            jsonObject.put("V", (Object)StringHelper.Format((String)"%1$s", (Object)nTotal));
            BaseDAQueryModelHelper daQueryModelHelper = null;
            String strQueryModel = dewf.getQUERYMODELID();
            if (!StringHelper.IsNullOrEmpty((String)strQueryModel)) {
                String strNewQueryModelId = String.valueOf(strQueryModel) + "_SRFWFHELPER";
                Object objQueryModel = this.getDEHelper().GetAttribute(strNewQueryModelId);
                if (objQueryModel != null) {
                    daQueryModelHelper = (BaseDAQueryModelHelper)objQueryModel;
                } else {
                    WFWorkflow workflow2;
                    WFConfig wfConfig2;
                    Hashtable<String, String> selectedColumns = new Hashtable<String, String>();
                    selectedColumns.put(this.getDEHelper().GetKeyDEFHelper().getName(), "");
                    selectedColumns.put(this.getDEHelper().GetMajorDEFHelper().getName(), "");
                    selectedColumns.put(wfStateValueDEFHelper.getName(), "");
                    selectedColumns.put(wfStepValueDEFHelper.getName(), "");
                    if (this.getWebContext().getGlobalHelper().getDAModelVersion() >= 11062700 && (wfConfig2 = (workflow2 = (WFWorkflow)this.getDAModelStorage().FindGlobalModel("WF0001").FindModel((Object)strWFID)).getWFConfig()) != null) {
                        for (WFBaseProcessConfig processConfig : wfConfig2.getProcessesConfig()) {
                            if (!(processConfig instanceof WFParallelSubWFConfig)) continue;
                            Vector<DESubWF> deSubWFList = new Vector<DESubWF>();
                            try {
                                WFHelper.GetDESubWFList(this.getDEHelper(), (WFParallelSubWFConfig)processConfig, deSubWFList);
                            }
                            catch (Exception ex) {
                                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u5e76\u884c\u5b50\u6d41\u7a0b\u5b9e\u4f53\u5b50\u6d41\u7a0b\u96c6\u5408\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
                                return;
                            }
                            Iterator<DESubWF> iterator = deSubWFList.iterator();
                            while (iterator.hasNext()) {
                                DESubWF deSubWF = iterator.next();
                                IDEFHelper subStepDEFHelper = this.getDEHelper().GetDEFHelper(deSubWF.getWFSTEPDEFID());
                                if (subStepDEFHelper == null) {
                                    this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]", (Object)this.getDEHelper().getId(), (Object)deSubWF.getWFSTEPDEFID()));
                                    return;
                                }
                                selectedColumns.put(subStepDEFHelper.getName(), "");
                            }
                        }
                    }
                    if (selectedColumns.size() > 0) {
                        QueryModel queryModel = new QueryModel();
                        callResult = this.getDAModelStorage().GetQueryModel(strQueryModel, queryModel, true);
                        if (callResult.IsError()) {
                            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u67e5\u8be2\u6a21\u578b\u8f85\u52a9\u5bf9\u8c61[%1$s]", (Object)strQueryModel));
                            return;
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
                    this.getDEHelper().SetAttribute(strNewQueryModelId, (Object)daQueryModelHelper);
                }
                if (daQueryModelHelper == null) {
                    this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u67e5\u8be2\u6a21\u578b\u8f85\u52a9\u5bf9\u8c61[%1$s]", (Object)strQueryModel));
                    return;
                }
            } else {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u3010\u6211\u7684\u6570\u636e\u3011\u67e5\u8be2\u6a21\u578b"));
                return;
            }
            this.qmUserContext = new DefaultDAQueryModelUserContext();
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
            String strGroupSQL = String.valueOf(daQueryModelHelper.GetQMDeclareScript()) + this.qmUserContext.GetQMDeclareScript();
            strGroupSQL = String.valueOf(strGroupSQL) + StringHelper.Format((String)"select %1$s,COUNT(*) AS CNT from ( \r\n", (Object)wfStepValueDEFHelper.getName());
            strGroupSQL = String.valueOf(strGroupSQL) + script.toString();
            strGroupSQL = String.valueOf(strGroupSQL) + StringHelper.Format((String)") a GROUP BY %1$s\r\n", (Object)wfStepValueDEFHelper.getName());
            Vector params = new Vector();
            daQueryModelHelper.FillQMDeclareParams(params, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.getWebContext().getCurUserId());
            this.qmUserContext.FillQMDeclareParams(params, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.getWebContext().getCurUserId());
            daQueryModelHelper.FillCallParams(params, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.getWebContext().getCurUserId());
            list.clear();
            callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), (String)daQueryModelHelper.GetMajorDEHelper().GetDBStorage(), (String)strGroupSQL, params, list, (String)"");
            if (callResult.getRetCode() != 0) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u6570\u636e\u67e5\u8be2\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                return;
            }
            nTotal = 0;
            for (BaseDataEntity dataEntity : list) {
                String strStepName = dataEntity.GetParamStringValue(wfStepValueDEFHelper.getName(), "");
                if (StringHelper.IsNullOrEmpty((String)strStepName)) continue;
                jsonObject.put("S" + strStepName, (Object)dataEntity.GetParamStringValue("CNT", ""));
                nTotal += dataEntity.GetParamIntValue("CNT", 0);
            }
            jsonObject.put("S", (Object)StringHelper.Format((String)"%1$s", (Object)nTotal));
            if (this.getWebContext().getGlobalHelper().getDAModelVersion() >= 11062700 && (wfConfig = (workflow = (WFWorkflow)this.getDAModelStorage().FindGlobalModel("WF0001").FindModel((Object)strWFID)).getWFConfig()) != null) {
                for (WFBaseProcessConfig processConfig : wfConfig.getProcessesConfig()) {
                    if (!(processConfig instanceof WFParallelSubWFConfig)) continue;
                    Vector<DESubWF> deSubWFList = new Vector<DESubWF>();
                    try {
                        WFHelper.GetDESubWFList(this.getDEHelper(), (WFParallelSubWFConfig)processConfig, deSubWFList);
                    }
                    catch (Exception ex) {
                        this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u5e76\u884c\u5b50\u6d41\u7a0b\u5b9e\u4f53\u5b50\u6d41\u7a0b\u96c6\u5408\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
                        return;
                    }
                    for (DESubWF deSubWF : deSubWFList) {
                        IDEFHelper subStepDEFHelper = this.getDEHelper().GetDEFHelper(deSubWF.getWFSTEPDEFID());
                        if (subStepDEFHelper == null) {
                            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]", (Object)this.getDEHelper().getId(), (Object)deSubWF.getWFSTEPDEFID()));
                            return;
                        }
                        strGroupSQL = String.valueOf(daQueryModelHelper.GetQMDeclareScript()) + this.qmUserContext.GetQMDeclareScript();
                        strGroupSQL = String.valueOf(strGroupSQL) + StringHelper.Format((String)"select %1$s,%2$s,COUNT(*) AS CNT from ( \r\n", (Object)wfStepValueDEFHelper.getName(), (Object)subStepDEFHelper.getName());
                        strGroupSQL = String.valueOf(strGroupSQL) + script.toString();
                        strGroupSQL = String.valueOf(strGroupSQL) + StringHelper.Format((String)") a GROUP BY %1$s,%2$s\r\n", (Object)wfStepValueDEFHelper.getName(), (Object)subStepDEFHelper.getName());
                        list.clear();
                        callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), (String)daQueryModelHelper.GetMajorDEHelper().GetDBStorage(), (String)strGroupSQL, params, list, (String)"");
                        if (callResult.getRetCode() != 0) {
                            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u6570\u636e\u67e5\u8be2\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                            return;
                        }
                        for (BaseDataEntity dataEntity : list) {
                            String strSubStepName;
                            String strStepName = dataEntity.GetParamStringValue(wfStepValueDEFHelper.getName(), "");
                            if (StringHelper.IsNullOrEmpty((String)strStepName) || StringHelper.IsNullOrEmpty((String)(strSubStepName = dataEntity.GetParamStringValue(subStepDEFHelper.getName(), "")))) continue;
                            jsonObject.put("S" + strStepName + "_" + deSubWF.getDESUBWFID() + "_" + strSubStepName, (Object)dataEntity.GetParamStringValue("CNT", ""));
                        }
                    }
                }
            }
            if (!StringHelper.IsNullOrEmpty((String)(strExtCntStates = dewf.getEXTCNTSTATES()))) {
                script.Reset();
                script.Append(daQueryModelHelper.GetQueryModelScript());
                userConditions.clear();
                daQueryModelHelper.FillMajorConditions(userConditions);
                String[] extCntStates = strExtCntStates.split("[|]");
                if (extCntStates.length == 1 && StringHelper.Compare((String)extCntStates[0], (String)"*", (boolean)true) == 0) {
                    strStateCondition = "";
                } else {
                    int i2 = 0;
                    while (i2 < extCntStates.length) {
                        String strState = extCntStates[i2];
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
                strGroupSQL = String.valueOf(daQueryModelHelper.GetQMDeclareScript()) + this.qmUserContext.GetQMDeclareScript();
                strGroupSQL = String.valueOf(strGroupSQL) + StringHelper.Format((String)"select %1$s,COUNT(*) AS CNT from ( \r\n", (Object)wfStateValueDEFHelper.getName());
                strGroupSQL = String.valueOf(strGroupSQL) + script.toString();
                strGroupSQL = String.valueOf(strGroupSQL) + StringHelper.Format((String)") a GROUP BY %1$s\r\n", (Object)wfStateValueDEFHelper.getName());
                list.clear();
                callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), (String)daQueryModelHelper.GetMajorDEHelper().GetDBStorage(), (String)strGroupSQL, params, list, (String)"");
                if (callResult.getRetCode() != 0) {
                    this.PageLog((Object)this, 1, StringHelper.Format((String)"\u6570\u636e\u67e5\u8be2\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    return;
                }
                for (BaseDataEntity dataEntity : list) {
                    String strStepName = dataEntity.GetParamStringValue(wfStateValueDEFHelper.getName(), "");
                    if (StringHelper.IsNullOrEmpty((String)strStepName)) continue;
                    jsonObject.put("E" + strStepName, (Object)dataEntity.GetParamStringValue("CNT", ""));
                }
            }
            if (!StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                this.Output(jsonObject.toString());
            } else {
                this.OutputScript(StringHelper.Format((String)"updatewftree(%1$s);", (Object)jsonObject.toString()));
            }
        }
    }
}

