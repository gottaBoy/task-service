/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Data.DERINDEX
 *  SA.SRFDA.Ctrl.Data.DESubWF
 *  SA.SRFDA.Ctrl.Data.DEWF
 *  SA.SRFDA.Ctrl.DataGrid.BaseDADataGridActionHelper
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAWebCTXHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExDGAjaxActionResult
 *  SRFWF.Client.WFCallResult
 *  SRFWF.Client.WFClientAPI
 *  SRFWF.Client.WFGetIAActionsResult
 */
package SA.SRFDA.WF.Ctrl.DataGrid;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.Data.DESubWF;
import SA.SRFDA.Ctrl.Data.DEWF;
import SA.SRFDA.Ctrl.DataGrid.BaseDADataGridActionHelper;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAWebCTXHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExDGAjaxActionResult;
import SRFWF.Client.WFCallResult;
import SRFWF.Client.WFClientAPI;
import SRFWF.Client.WFGetIAActionsResult;
import java.util.TreeMap;
import java.util.Vector;

public class WFDADataGridActionHelper
extends BaseDADataGridActionHelper {
    protected boolean bMyWFWork = false;
    protected boolean bMgrMode = false;
    protected boolean bAllMode = false;
    public static final String ACTION_CANCELWF = "cancelwf";
    public static final String ACTION_RESTARTWF = "restartwf";
    protected String strDataLockKey = "";

    protected boolean OnFetchAction() {
        String strWFGroup = this.getWebContext().getSRFWFDATAGROUP();
        if (StringHelper.Compare((String)strWFGroup, (String)"MYWFWORK", (boolean)true) == 0) {
            this.bMyWFWork = true;
        } else if (StringHelper.Compare((String)strWFGroup, (String)"PROCESSING", (boolean)true) == 0) {
            this.bMgrMode = true;
        } else if (StringHelper.Compare((String)strWFGroup, (String)"ALL", (boolean)true) == 0) {
            this.bAllMode = true;
        }
        return super.OnFetchAction();
    }

    protected boolean OnGetUserDP() {
        if (this.bMgrMode) {
            return true;
        }
        return this.bAllMode;
    }

    protected boolean OnCustomAction(String strAction) {
        if (StringHelper.Compare((String)strAction, (String)ACTION_CANCELWF, (boolean)true) == 0) {
            this.OnCancelWorkflow();
            return true;
        }
        if (StringHelper.Compare((String)strAction, (String)ACTION_RESTARTWF, (boolean)true) == 0) {
            this.OnRestartWorkflow();
            return true;
        }
        return super.OnCustomAction(strAction);
    }

    protected boolean OnCancelWorkflow() {
        SRFExDGAjaxActionResult restartActionResult = new SRFExDGAjaxActionResult();
        restartActionResult.setReload(true);
        WFClientAPI wfClientAPI = new WFClientAPI();
        String strWFWSUrl = this.getWebContext().getWebExConfig().GetValue("SRFDA", "WFWSURL", "");
        CallResult callResult = wfClientAPI.Init(strWFWSUrl, true);
        if (callResult == null || callResult.getRetCode() != 0) {
            this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u521d\u59cb\u5316\u5de5\u4f5c\u6d41WS\u94fe\u63a5\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            restartActionResult.setRetCode(1);
            restartActionResult.setErrorInfo(StringHelper.Format((String)"\u521d\u59cb\u5316\u5de5\u4f5c\u6d41WS\u94fe\u63a5\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            this.getPage().Output(restartActionResult.ToJSONString());
            return true;
        }
        TreeMap<String, String> derIndexMap = null;
        if (this.getPage().getDEHelper().IsIndexDE()) {
            derIndexMap = new TreeMap<String, String>();
            Vector<DERINDEX> list = this.getPage().getDEHelper().GetDERINDEXs(true);
            for (DERINDEX derIndex : list) {
                derIndexMap.put(derIndex.getTYPEVALUE().toUpperCase(), derIndex.getDEID());
            }
        }
        String strKeys = this.getWebContext().GetPostValue("srfdakeys");
        String[] keys = strKeys.split("[,]");
        String strKeyParam = this.getPage().getDEHelper().GetKeyDEFHelper().getName();
        String strMajorTextParam = this.getPage().getDEHelper().GetMajorDEFHelper().getName();
        int i = 0;
        while (i < keys.length) {
            String strKeyValue = keys[i];
            if (!StringHelper.IsNullOrEmpty((String)strKeyValue)) {
                BaseDataEntity dataEntity = new BaseDataEntity();
                dataEntity.SetParamValue(strKeyParam, (Object)strKeyValue);
                callResult = this.getDEDataCtrl().Get(dataEntity);
                if (callResult.getRetCode() != 0) {
                    restartActionResult.From(callResult);
                    restartActionResult.setErrorInfo(StringHelper.Format((String)"\u53d6\u6d88\u5de5\u4f5c\u6d41\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    this.getPage().Output(restartActionResult.ToJSONString());
                    return true;
                }
                String strMajorText = dataEntity.GetParamStringValue(strMajorTextParam, "");
                IDEHelper iDEHelper = null;
                if (derIndexMap != null) {
                    String strIndexType = dataEntity.GetParamStringValue(this.getPage().getDEHelper().GetIndexTypeDEFHelper().getName(), "");
                    String strDEId = (String)derIndexMap.get(strIndexType.toUpperCase());
                    iDEHelper = this.getPage().getDAModelStorage().FindDEHelper(strDEId);
                } else {
                    iDEHelper = this.getPage().getDEHelper();
                }
                if (iDEHelper == null) {
                    restartActionResult.setRetCode(1);
                    restartActionResult.setErrorInfo(StringHelper.Format((String)"[%2$s]\u53d6\u6d88\u5de5\u4f5c\u6d41\u5931\u8d25\uff0c%1$s", (Object)"\u5b9e\u4f53\u8f85\u52a9\u5bf9\u8c61\u65e0\u6548", (Object)strMajorText));
                    this.getPage().PageLog((Object)this, 1, restartActionResult.getErrorInfo());
                    this.getPage().Output(restartActionResult.ToJSONString());
                    return true;
                }
                String strWFId = iDEHelper.GetDEWFId(this.getWebContext().getSRFWFMode());
                dataEntity.SetParamValue(iDEHelper.GetKeyDEFHelper().getName(), (Object)strKeyValue);
                callResult = this.OnTestDataAction(iDEHelper, dataEntity, "WFCANCEL");
                if (callResult.getRetCode() != 0) {
                    restartActionResult.From(callResult);
                    restartActionResult.setErrorInfo(StringHelper.Format((String)"[%2$s]\u53d6\u6d88\u5de5\u4f5c\u6d41\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo(), (Object)strMajorText));
                    this.getPage().PageLog((Object)this, 1, restartActionResult.getErrorInfo());
                    this.getPage().Output(restartActionResult.ToJSONString());
                    return true;
                }
                WFCallResult wfCallResult = wfClientAPI.UserClose(strWFId, this.getWebContext().getCurUserId(), strKeyValue, "", "", iDEHelper.getId(), "");
                if (wfCallResult == null || wfCallResult.getRetCode() != 0) {
                    restartActionResult.From((CallResult)wfCallResult);
                    restartActionResult.setErrorInfo(StringHelper.Format((String)"[%2$s]\u53d6\u6d88\u5de5\u4f5c\u6d41\u5931\u8d25\uff0c%1$s", (Object)wfCallResult.getErrorInfo(), (Object)strMajorText));
                    this.getPage().PageLog((Object)this, 1, restartActionResult.getErrorInfo());
                    this.getPage().Output(restartActionResult.ToJSONString());
                    return true;
                }
            }
            ++i;
        }
        restartActionResult.setRetCode(0);
        restartActionResult.AppendJSCode("alert('\u53d6\u6d88\u6570\u636e\u5de5\u4f5c\u6d41\u6210\u529f\uff01');");
        this.getPage().Output(restartActionResult.ToJSONString());
        return true;
    }

    protected boolean OnRestartWorkflow() {
        SRFExDGAjaxActionResult restartActionResult = new SRFExDGAjaxActionResult();
        restartActionResult.setReload(true);
        WFClientAPI wfClientAPI = new WFClientAPI();
        String strWFWSUrl = this.getWebContext().getWebExConfig().GetValue("SRFDA", "WFWSURL", "");
        CallResult callResult = wfClientAPI.Init(strWFWSUrl, true);
        if (callResult == null || callResult.getRetCode() != 0) {
            this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u521d\u59cb\u5316\u5de5\u4f5c\u6d41WS\u94fe\u63a5\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            restartActionResult.setRetCode(1);
            restartActionResult.setErrorInfo(StringHelper.Format((String)"\u521d\u59cb\u5316\u5de5\u4f5c\u6d41WS\u94fe\u63a5\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            this.getPage().Output(restartActionResult.ToJSONString());
            return true;
        }
        TreeMap<String, String> derIndexMap = null;
        if (this.getPage().getDEHelper().IsIndexDE()) {
            derIndexMap = new TreeMap<String, String>();
            Vector<DERINDEX> list = this.getPage().getDEHelper().GetDERINDEXs(true);
            for (DERINDEX derIndex : list) {
                derIndexMap.put(derIndex.getTYPEVALUE().toUpperCase(), derIndex.getDEID());
            }
        }
        String strKeys = this.getWebContext().GetPostValue("srfdakeys");
        String[] keys = strKeys.split("[,]");
        String strKeyParam = this.getPage().getDEHelper().GetKeyDEFHelper().getName();
        String strMajorTextParam = this.getPage().getDEHelper().GetMajorDEFHelper().getName();
        int i = 0;
        while (i < keys.length) {
            String strKeyValue = keys[i];
            if (!StringHelper.IsNullOrEmpty((String)strKeyValue)) {
                BaseDataEntity dataEntity = new BaseDataEntity();
                dataEntity.SetParamValue(strKeyParam, (Object)strKeyValue);
                callResult = this.getDEDataCtrl().Get(dataEntity);
                if (callResult.getRetCode() != 0) {
                    restartActionResult.From(callResult);
                    restartActionResult.setErrorInfo(StringHelper.Format((String)"\u91cd\u542f\u5de5\u4f5c\u6d41\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    this.getPage().Output(restartActionResult.ToJSONString());
                    return true;
                }
                String strMajorText = dataEntity.GetParamStringValue(strMajorTextParam, "");
                IDEHelper iDEHelper = null;
                if (derIndexMap != null) {
                    String strIndexType = dataEntity.GetParamStringValue(this.getPage().getDEHelper().GetIndexTypeDEFHelper().getName(), "");
                    String strDEId = (String)derIndexMap.get(strIndexType.toUpperCase());
                    iDEHelper = this.getPage().getDAModelStorage().FindDEHelper(strDEId);
                } else {
                    iDEHelper = this.getPage().getDEHelper();
                }
                if (iDEHelper == null) {
                    restartActionResult.setRetCode(1);
                    restartActionResult.setErrorInfo(StringHelper.Format((String)"[%2$s]\u91cd\u542f\u5de5\u4f5c\u6d41\u5931\u8d25\uff0c%1$s", (Object)"\u5b9e\u4f53\u8f85\u52a9\u5bf9\u8c61\u65e0\u6548", (Object)strMajorText));
                    this.getPage().PageLog((Object)this, 1, restartActionResult.getErrorInfo());
                    this.getPage().Output(restartActionResult.ToJSONString());
                    return true;
                }
                String strWFId = iDEHelper.GetDEWFId(this.getWebContext().getSRFWFMode());
                dataEntity.SetParamValue(iDEHelper.GetKeyDEFHelper().getName(), (Object)strKeyValue);
                callResult = this.OnTestDataAction(iDEHelper, dataEntity, "WFRESTART");
                if (callResult.getRetCode() != 0) {
                    restartActionResult.From(callResult);
                    restartActionResult.setErrorInfo(StringHelper.Format((String)"[%2$s]\u91cd\u542f\u5de5\u4f5c\u6d41\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo(), (Object)strMajorText));
                    this.getPage().PageLog((Object)this, 1, restartActionResult.getErrorInfo());
                    this.getPage().Output(restartActionResult.ToJSONString());
                    return true;
                }
                WFCallResult wfCallResult = wfClientAPI.Restart(strWFId, this.getWebContext().getCurUserId(), strKeyValue, "", "", iDEHelper.getId());
                if (wfCallResult == null || wfCallResult.getRetCode() != 0) {
                    restartActionResult.From((CallResult)wfCallResult);
                    restartActionResult.setErrorInfo(StringHelper.Format((String)"[%2$s]\u91cd\u542f\u5de5\u4f5c\u6d41\u5931\u8d25\uff0c%1$s", (Object)wfCallResult.getErrorInfo(), (Object)strMajorText));
                    this.getPage().PageLog((Object)this, 1, restartActionResult.getErrorInfo());
                    this.getPage().Output(restartActionResult.ToJSONString());
                    return true;
                }
            }
            ++i;
        }
        restartActionResult.setRetCode(0);
        restartActionResult.AppendJSCode("alert('\u91cd\u542f\u6570\u636e\u5de5\u4f5c\u6d41\u6210\u529f\uff01');");
        this.getPage().Output(restartActionResult.ToJSONString());
        return true;
    }

    protected String GetDAModelQueryScript(BaseDAQueryModelHelper daQueryModelHelper) {
        String strSql = super.GetDAModelQueryScript(daQueryModelHelper);
        if (this.bMyWFWork) {
            String strDESubWFId = SRFDAWebCTXHelper.GetDESubWFId((ISRFDAWebContext)this.getWebContext());
            String strWFInstDEFId = "";
            if (StringHelper.IsNullOrEmpty((String)strDESubWFId)) {
                DEWF dewf = this.getPage().getDEHelper().GetDEWF();
                strWFInstDEFId = dewf.getWFINSTDEFID();
            } else {
                DESubWF deSubWF = this.getPage().getDEHelper().GetDESubWF(strDESubWFId);
                if (deSubWF == null) {
                    this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u5b50\u6d41\u7a0b[%1$s]", (Object)strDESubWFId));
                    return "";
                }
                strWFInstDEFId = deSubWF.getWFINSTDEFID();
            }
            IDEFHelper wfInstDEFHelper = this.getPage().getDEHelper().GetDEFHelper(strWFInstDEFId);
            if (wfInstDEFHelper == null) {
                this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u5c5e\u6027[%1$s]\u5931\u8d25", (Object)strWFInstDEFId));
                return "";
            }
            CallResult callResult = daQueryModelHelper.GetDEFieldExp(wfInstDEFHelper);
            if (callResult.getRetCode() != 0) {
                this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u5c5e\u6027[%1$s]\u67e5\u8be2\u8868\u8fbe\u5f0f\u5931\u8d25\uff0c%2$s", (Object)strWFInstDEFId, (Object)callResult.getErrorInfo()));
                return "";
            }
            String strWFInstFieldExp = (String)callResult.getUserObject();
            StringBuilderEx script = new StringBuilderEx();
            script.Append(strSql);
            if (StringHelper.IsNullOrEmpty((String)this.getDEHelper().GetDBStorage())) {
                script.Append(" INNER JOIN T_SRFWFINSTANCE wf1 ON %1$s = wf1.WFINSTANCEID ", (Object)strWFInstFieldExp);
                script.Append(" INNER JOIN T_SRFWFSTEPACTOR wf2 ON wf1.ACTIVESTEPID = wf2.WFSTEPID ");
                script.Append(" LEFT JOIN T_SRFWFSTEPDATA wf3 ON wf2.WFSTEPID = wf3.WFSTEPID AND wf2.ACTORID=wf3.ACTORID AND wf3.CONNECTIONNAME<>'SRFWFRESUBMIT' AND wf3.CONNECTIONNAME<>'SRFWFTIMEOUT'", (Object)strWFInstFieldExp);
            } else {
                IDEHelper wfDEHelper = this.getPage().getDAModelStorage().FindDEHelper("WF0002");
                script.Append(" INNER JOIN %2$s.T_SRFWFINSTANCE wf1 ON %1$s = wf1.WFINSTANCEID ", (Object)strWFInstFieldExp, (Object)wfDEHelper.GetDBSchema());
                script.Append(" INNER JOIN %1$s.T_SRFWFSTEPACTOR wf2 ON wf1.ACTIVESTEPID = wf2.WFSTEPID ", (Object)wfDEHelper.GetDBSchema());
                script.Append(" LEFT JOIN %2$s.T_SRFWFSTEPDATA wf3 ON wf2.WFSTEPID = wf3.WFSTEPID AND wf2.ACTORID=wf3.ACTORID AND wf3.CONNECTIONNAME<>'SRFWFRESUBMIT' AND wf3.CONNECTIONNAME<>'SRFWFTIMEOUT'", (Object)strWFInstFieldExp, (Object)wfDEHelper.GetDBSchema());
            }
            return script.toString();
        }
        return strSql;
    }

    protected void FillDAQueryModelHelperCondition(Vector<String> userConditions, BaseDAQueryModelHelper daQueryModelHelper) {
        super.FillDAQueryModelHelperCondition(userConditions, daQueryModelHelper);
        DEWF dewf = this.getPage().getDEHelper().GetDEWF();
        if (this.bMgrMode) {
            String strWFState = this.getWebContext().getSRFWFSTATE();
            String strWFStateColumnName = dewf.getWFSTATEDEFID();
            IDEFHelper wfStateDEFHelper = null;
            if (!StringHelper.IsNullOrEmpty((String)strWFStateColumnName)) {
                wfStateDEFHelper = this.getPage().getDEHelper().GetDEFHelper(dewf.getWFSTATEDEFID());
            }
            if (wfStateDEFHelper == null) {
                this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u5de5\u4f5c\u6d41\u5b9e\u4f53[%1$s]\u6ca1\u6709\u6307\u5b9a\u5de5\u4f5c\u6d41\u72b6\u6001\u5c5e\u6027", (Object)dewf.getDEID()));
                userConditions.add("1<>1");
            }
            if (StringHelper.IsNullOrEmpty((String)strWFState)) {
                String strCondition = "";
                if (wfStateDEFHelper != null) {
                    String strWFStateValue = "1|4";
                    String strWFStateCondition = "";
                    String[] states = strWFStateValue.split("[|]");
                    int i = 0;
                    while (i < states.length) {
                        String strState = states[i];
                        if (!StringHelper.IsNullOrEmpty((String)(strState = strState.trim()))) {
                            strCondition = daQueryModelHelper.GetConditionSQL(wfStateDEFHelper, "", "=", strState);
                            if (!StringHelper.IsNullOrEmpty((String)strWFStateCondition)) {
                                strWFStateCondition = String.valueOf(strWFStateCondition) + " OR ";
                            }
                            strWFStateCondition = String.valueOf(strWFStateCondition) + strCondition;
                        }
                        ++i;
                    }
                    userConditions.add(strWFStateCondition);
                }
            } else if (StringHelper.Compare((String)strWFState, (String)"1", (boolean)true) == 0 || StringHelper.Compare((String)strWFState, (String)"4", (boolean)true) == 0) {
                String strCondition = daQueryModelHelper.GetConditionSQL(wfStateDEFHelper, "", "=", strWFState);
                userConditions.add(strCondition);
            } else {
                this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u4f20\u5165\u72b6\u6001\u6709\u8bef", (Object)dewf.getDEID()));
                userConditions.add("1<>1");
            }
        } else {
            String strWFStepColumnName;
            String strWFStateValue = this.getWebContext().getSRFWFSTATEVALUE();
            String strWFStep = this.getWebContext().getSRFWFSTEP();
            String strDESubWFId = SRFDAWebCTXHelper.GetDESubWFId((ISRFDAWebContext)this.getWebContext());
            String strWFSubStep = SRFDAWebCTXHelper.GetWFSubStep((ISRFDAWebContext)this.getWebContext());
            String strWFStateValueColumnName = dewf.getWFSTATEVALUE();
            IDEFHelper wfStateValueDEFHelper = null;
            IDEFHelper wfStepDEFHelper = null;
            if (!StringHelper.IsNullOrEmpty((String)strWFStateValueColumnName)) {
                wfStateValueDEFHelper = this.getPage().getDEHelper().GetDEFHelper(dewf.getSTATEDEFID());
            }
            if (!StringHelper.IsNullOrEmpty((String)(strWFStepColumnName = dewf.getWFSTEPDEFID()))) {
                wfStepDEFHelper = this.getPage().getDEHelper().GetDEFHelper(strWFStepColumnName);
            }
            if (!StringHelper.IsNullOrEmpty((String)strWFStateValue)) {
                String strCondition = "";
                if (wfStateValueDEFHelper != null) {
                    String strStateCondition = "";
                    String[] states = strWFStateValue.split("[|]");
                    int i = 0;
                    while (i < states.length) {
                        String strState = states[i];
                        if (!StringHelper.IsNullOrEmpty((String)(strState = strState.trim()))) {
                            strCondition = daQueryModelHelper.GetConditionSQL(wfStateValueDEFHelper, "", "=", strState);
                            if (!StringHelper.IsNullOrEmpty((String)strStateCondition)) {
                                strStateCondition = String.valueOf(strStateCondition) + " OR ";
                            }
                            strStateCondition = String.valueOf(strStateCondition) + strCondition;
                        }
                        ++i;
                    }
                    userConditions.add(strStateCondition);
                }
                if (!StringHelper.IsNullOrEmpty((String)strWFStep) && wfStepDEFHelper != null) {
                    strCondition = daQueryModelHelper.GetConditionSQL(wfStepDEFHelper, "", "=", strWFStep);
                    userConditions.add(strCondition);
                }
            }
            if (!StringHelper.IsNullOrEmpty((String)strDESubWFId) && !StringHelper.IsNullOrEmpty((String)strWFSubStep)) {
                DESubWF deSubWF = this.getPage().getDEHelper().GetDESubWF(strDESubWFId);
                if (deSubWF == null) {
                    this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u5b50\u6d41\u7a0b[%1$s]", (Object)strDESubWFId));
                    return;
                }
                IDEFHelper wfSubStepDEFHelper = this.getPage().getDEHelper().GetDEFHelper(deSubWF.getWFSTEPDEFID());
                if (wfSubStepDEFHelper != null) {
                    String strCondition = "";
                    strCondition = daQueryModelHelper.GetConditionSQL(wfSubStepDEFHelper, "", "=", strWFSubStep);
                    userConditions.add(strCondition);
                }
            }
            if (this.bMyWFWork) {
                userConditions.add(StringHelper.Format((String)"wf2.ACTORID='%1$s'", (Object)this.getWebContext().getCurUserId()));
                userConditions.add(StringHelper.Format((String)"wf3.ACTORID IS NULL"));
            }
        }
    }

    protected CallResult OnSaveActionBeforeUpdate(BaseDataEntity dataEntity) {
        WFClientAPI wfClientAPI = new WFClientAPI();
        String strWFWSUrl = this.getWebContext().getWebExConfig().GetValue("SRFDA", "WFWSURL", "");
        CallResult callResult = wfClientAPI.Init(strWFWSUrl, true);
        if (callResult == null || callResult.getRetCode() != 0) {
            this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u521d\u59cb\u5316\u5de5\u4f5c\u6d41WS\u94fe\u63a5\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        String strWFId = this.getPage().getDEHelper().GetDEWFId(this.getWebContext().getSRFWFMode());
        String strKeyValue = dataEntity.GetParamStringValue(this.getPage().getDEHelper().GetKeyDEFHelper().getName(), "");
        String strStepName = this.getWebContext().getSRFWFSTEP();
        WFGetIAActionsResult wfGetIAActionsResult = wfClientAPI.GetIAActions(strWFId, this.getWebContext().getCurUserId(), "", strStepName, "", "", "", "");
        if (wfGetIAActionsResult == null || wfGetIAActionsResult.getRetCode() != 0) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)StringHelper.Format((String)"\u83b7\u53d6\u5de5\u4f5c\u6d41\u4ea4\u4e92\u6b65\u9aa4\u5931\u8d25\uff0c%1$s", (Object)wfGetIAActionsResult.getErrorInfo())));
            this.getPage().PageLog((Object)this, 1, callResult.getErrorInfo());
            return callResult;
        }
        String strProcessName = wfGetIAActionsResult.getProcessName();
        WFCallResult wfCallResult = wfClientAPI.TestSubmitIAAction(strWFId, this.getWebContext().getCurUserId(), strKeyValue, "", "", this.getPage().getDEHelper().getId(), strProcessName, "", "", "", "");
        if (wfCallResult == null || wfCallResult.getRetCode() != 0) {
            this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u6d4b\u8bd5\u5de5\u4f5c\u6d41\u4ea4\u4e92\u64cd\u4f5c\u5931\u8d25\uff0c%1$s", (Object)wfCallResult.getErrorInfo()));
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6d4b\u8bd5\u5de5\u4f5c\u6d41\u4ea4\u4e92\u64cd\u4f5c\u5931\u8d25\uff0c%1$s", (Object)wfCallResult.getErrorInfo()));
            return callResult;
        }
        String strInstId = wfCallResult.getRunInfo();
        this.strDataLockKey = StringHelper.Format((String)"WFINSTID:%1$s", (Object)strInstId);
        return super.OnSaveActionBeforeUpdate(dataEntity);
    }

    protected String GetDataLockKey(BaseDataEntity dataEntity) {
        return this.strDataLockKey;
    }
}

