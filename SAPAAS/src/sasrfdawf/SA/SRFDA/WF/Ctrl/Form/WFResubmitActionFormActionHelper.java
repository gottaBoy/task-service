/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Data.DERINDEX
 *  SA.SRFDA.Ctrl.Data.DESubWF
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFDA.Web.SRFDAWebContext
 *  SA.SRFDA.Web.Script.RichAppJSHelper
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.DP.SRFExDPEx
 *  SA.SRFramework.WebEx.Form.SRFExForm
 *  SA.SRFramework.WebEx.Form.SRFExFormActionHelper
 *  SA.SRFramework.WebEx.Form.SRFExFormItemErrors
 *  SA.SRFramework.WebEx.Form.SRFExFormLoadResult
 *  SA.SRFramework.WebEx.Form.SRFExFormSaveResult
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.Script.BrowserJSHelper
 *  SRFWF.Client.WFCallResult
 *  SRFWF.Client.WFClientAPI
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.WF.Ctrl.Form;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.Data.DESubWF;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.SRFDAWebContext;
import SA.SRFDA.Web.Script.RichAppJSHelper;
import SA.SRFramework.Data.DBResult;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.DP.SRFExDPEx;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.Form.SRFExFormActionHelper;
import SA.SRFramework.WebEx.Form.SRFExFormItemErrors;
import SA.SRFramework.WebEx.Form.SRFExFormLoadResult;
import SA.SRFramework.WebEx.Form.SRFExFormSaveResult;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;
import SRFWF.Client.WFCallResult;
import SRFWF.Client.WFClientAPI;
import java.util.TreeMap;
import java.util.Vector;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WFResubmitActionFormActionHelper
extends SRFExFormActionHelper {
    protected SRFExDPEx mainPanel = null;
    private static final Log log = LogFactory.getLog(WFResubmitActionFormActionHelper.class);
    protected Vector<String> disableItems = null;
    protected SRFExForm form1 = null;
    protected String strPageInfo = "";
    protected String strWFActorId = "";
    protected String strDescription = "";

    protected boolean OnLoadAction() {
        SRFExFormLoadResult loadResult = new SRFExFormLoadResult();
        BaseDataEntity dataEntity = new BaseDataEntity();
        SRFExFormItemErrors formItemErrors = new SRFExFormItemErrors();
        if (!this.form1.FillDataEntity(dataEntity, true, formItemErrors)) {
            loadResult.setRetCode(4);
            loadResult.setJSCode("alert('\u6ca1\u6709\u6307\u5b9a\u6570\u636e\u952e\u503c');");
            loadResult.AppendJSCode(WFResubmitActionFormActionHelper.GetSetPageDataJS(""));
            loadResult.AppendJSCode(WFResubmitActionFormActionHelper.GetSetPageInfoJS("\u6ca1\u6709\u6307\u5b9a\u6570\u636e\u952e\u503c"));
            this.getPage().Output(loadResult.ToJSONString());
            return true;
        }
        String strKey = dataEntity.GetParamStringValue("WFKEYS", "");
        String[] keys = strKey.split("[,]");
        if (keys.length == 1) {
            dataEntity.SetParamValue(this.getPage().getDEHelper().GetKeyDEFHelper().getName(), (Object)keys[0]);
            CallResult callResult = this.getDEDataCtrl().Get(dataEntity);
            if (callResult.getRetCode() != 0) {
                if (callResult.getRetCode() == 3 && this.getPage().getPageParam("EMBEDEDIT", false)) {
                    return this.OnLoadDefaultAction();
                }
                if (callResult.IsUserError()) {
                    callResult.setRetCode(5);
                    formItemErrors.FillJSONs(loadResult.getItems());
                }
                loadResult.From(callResult);
                loadResult.AppendJSCode(WFResubmitActionFormActionHelper.GetSetPageDataJS(""));
                loadResult.AppendJSCode(WFResubmitActionFormActionHelper.GetSetPageInfoJS("\u6570\u636e\u67e5\u8be2\u5931\u8d25"));
                this.getPage().Output(loadResult.ToJSONString());
                return true;
            }
        }
        this.form1.FillValueJSON(loadResult.getItems(), this.getPage().isControlValueFromUniqueId());
        if (keys.length == 1) {
            loadResult.AppendJSCode(WFResubmitActionFormActionHelper.GetSetPageDataJS(this.getPage().getDEHelper().GetDataInfo(dataEntity)));
        } else {
            loadResult.AppendJSCode(WFResubmitActionFormActionHelper.GetSetPageDataJS("\u591a\u9879\u6570\u636e\u6a21\u5f0f"));
        }
        loadResult.setUpdateFlag(true);
        loadResult.setFormState(this.GetFormState(true, dataEntity));
        this.getPage().Output(loadResult.ToJSONString());
        return true;
    }

    protected boolean OnBeforeProcess() {
        if (super.OnBeforeProcess()) {
            this.form1 = this.getForm();
            SRFExControl contorl = this.form1.getMainPanel();
            if (contorl != null && contorl instanceof SRFExDPEx) {
                this.mainPanel = (SRFExDPEx)contorl;
            }
            return this.mainPanel != null;
        }
        return false;
    }

    protected boolean OnSaveAction() {
        String strRunInfo = "";
        SRFExFormSaveResult saveResult = new SRFExFormSaveResult();
        CallResult callResult = null;
        SRFExFormItemErrors formItemErrors = new SRFExFormItemErrors();
        BaseDataEntity dataEntity = new BaseDataEntity();
        this.OnSaveActionBeforeFillDataEntity(dataEntity);
        if (!this.OnSaveActionFillDataEntity(dataEntity, formItemErrors)) {
            saveResult.setRetCode(5);
            formItemErrors.FillJSONs(saveResult.getItems());
            saveResult.AppendJSCode(WFResubmitActionFormActionHelper.GetSetPageInfoJS("\u8f93\u5165\u6709\u8bef\uff0c\u6570\u636e\u65e0\u6cd5\u66f4\u65b0!"));
            this.getPage().Output(saveResult.ToJSONString());
            return true;
        }
        TreeMap<String, String> derIndexMap = null;
        if (this.getPage().getDEHelper().IsIndexDE()) {
            derIndexMap = new TreeMap<String, String>();
            Vector list = this.getPage().getDEHelper().GetDERINDEXs(true);
            for (DERINDEX derIndex : list) {
                derIndexMap.put(derIndex.getTYPEVALUE().toUpperCase(), derIndex.getDEID());
            }
        }
        String strKey = dataEntity.GetParamStringValue("WFKEYS", "");
        this.strWFActorId = dataEntity.GetParamStringValue("WFACTORID", "");
        this.strDescription = dataEntity.GetParamStringValue("DESCRIPTION", "");
        String[] keys = strKey.split("[,]");
        BaseDataEntity backup = new BaseDataEntity();
        dataEntity.CopyTo(backup, true);
        StringBuilderEx processInfo = new StringBuilderEx();
        String strMajorDEFName = this.getPage().getDEHelper().GetMajorDEFHelper().getName();
        this.SetPageInfo("");
        boolean bHasError = false;
        this.OnBeforeIAAction();
        int i = 0;
        while (i < keys.length) {
            block13: {
                IDEHelper iDEHelper;
                block15: {
                    block14: {
                        block12: {
                            dataEntity.SetParamValue(this.getPage().getDEHelper().GetKeyDEFHelper().getName(), (Object)keys[i]);
                            callResult = this.getDEDataCtrl().Get(dataEntity);
                            if (callResult.getRetCode() == 0) break block12;
                            bHasError = true;
                            processInfo.Append("alert('\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e[%1$s]\uff0c%2$s');\r\n", (Object)keys[i], (Object)callResult.getErrorInfo());
                            break block13;
                        }
                        iDEHelper = null;
                        if (derIndexMap == null) break block14;
                        String strIndexType = dataEntity.GetParamStringValue(this.getPage().getDEHelper().GetIndexTypeDEFHelper().getName(), "");
                        String strDEId = (String)derIndexMap.get(strIndexType.toUpperCase());
                        iDEHelper = this.getPage().getDAModelStorage().FindDEHelper(strDEId);
                        if (iDEHelper != null) break block15;
                        processInfo.Append("alert('\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61');\r\n", (Object)strDEId);
                        break block13;
                    }
                    iDEHelper = this.getPage().getDEHelper();
                }
                backup.CopyTo(dataEntity, true);
                dataEntity.SetParamValue(iDEHelper.GetKeyDEFHelper().getName(), (Object)keys[i]);
                callResult = this.OnSaveActionAfterUpdate(callResult, dataEntity, iDEHelper);
                saveResult.From(callResult);
                if (saveResult.getRetCode() != 0) {
                    bHasError = true;
                    processInfo.Append("alert('\u6570\u636e[%1$s]\u6267\u884c\u91cd\u65b0\u6307\u6d3e\u7528\u6237\u64cd\u4f5c\u5931\u8d25\uff0c%2$s');\r\n", (Object)dataEntity.GetParamStringValue(strMajorDEFName, ""), (Object)callResult.getErrorInfo());
                }
            }
            ++i;
        }
        this.OnAfterIAAction();
        if (bHasError) {
            saveResult.setRetCode(5);
            saveResult.setErrorInfo("\u6267\u884c\u5de5\u4f5c\u6d41\u4ea4\u4e92\u64cd\u4f5c\u51fa\u73b0\u9519\u8bef");
            saveResult.AppendJSCode(processInfo.toString());
        } else {
            saveResult.AppendJSCode(processInfo.toString());
            if (keys.length == 1) {
                this.OnSaveActionFillForm(dataEntity);
                this.form1.FillValueJSON(saveResult.getItems(), this.getPage().isControlValueFromUniqueId());
            }
            if (keys.length == 1) {
                saveResult.AppendJSCode(WFResubmitActionFormActionHelper.GetSetPageDataJS(this.getPage().getDEHelper().GetDataInfo(dataEntity)));
            } else {
                saveResult.AppendJSCode(WFResubmitActionFormActionHelper.GetSetPageDataJS("\u591a\u9879\u6570\u636e\u6a21\u5f0f"));
            }
            saveResult.setRetCode(0);
            if (StringHelper.IsNullOrEmpty((String)this.getPage().getPageModel())) {
                saveResult.AppendJSCode("SRFUtility.refreshpdg();");
                saveResult.AppendJSCode(BrowserJSHelper.getResetDialogReturnValue());
                saveResult.AppendJSCode(BrowserJSHelper.getSetDialogReturnValue((String)"ret", (String)"'ok'"));
                saveResult.AppendJSCode(BrowserJSHelper.getCloseWindowScript());
            } else {
                saveResult.AppendJSCode(RichAppJSHelper.getSetDialogResult((String)this.getPage().getPageModel(), (String)"OK"));
                saveResult.AppendJSCode(RichAppJSHelper.getCloseWindowScript((String)this.getPage().getPageModel()));
            }
        }
        this.getPage().Output(this.OnSaveActionOutputResult(saveResult));
        return true;
    }

    protected void OnSaveActionFillForm(BaseDataEntity dataEntity) {
        this.form1.FillByDataEntity(dataEntity, this.getWebContext().getCopyMode());
        this.form1.EnableFormItems(this.getWebContext().getCopyMode());
    }

    protected void OnSaveActionBeforeFillDataEntity(BaseDataEntity dataEntity) {
    }

    protected boolean IsFormContainKey(BaseDataEntity dataEntity) {
        return this.getForm().IsContainerKeyValue(dataEntity);
    }

    protected boolean OnSaveActionFillDataEntity(BaseDataEntity dataEntity, SRFExFormItemErrors formItemErrors) {
        return this.getForm().FillDataEntity(dataEntity, false, formItemErrors);
    }

    protected CallResult OnSaveActionAfterUpdate(CallResult callResult, BaseDataEntity dataEntity, IDEHelper iDEHelper) {
        WFClientAPI wfClientAPI = new WFClientAPI();
        String strWFWSUrl = this.getWebContext().getWebExConfig().GetValue("SRFDA", "WFWSURL", "");
        callResult = wfClientAPI.Init(strWFWSUrl, true);
        if (callResult == null || callResult.getRetCode() != 0) {
            this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u521d\u59cb\u5316\u5de5\u4f5c\u6d41WS\u94fe\u63a5\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        String strWFId = iDEHelper.GetDEWFId(this.getWebContext().getSRFWFMode());
        String strWFStep = this.getWebContext().getSRFWFSTEP();
        String[] stepParts = strWFStep.split("[:]");
        if (stepParts.length == 4 && StringHelper.Compare((String)stepParts[0], (String)"SRFWFSUBSTEP", (boolean)true) == 0) {
            DESubWF deSubWF = iDEHelper.GetDESubWF(stepParts[2]);
            if (deSubWF == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u5b50\u6d41\u7a0b[%1$s]", (Object)stepParts[2]));
                this.getPage().PageLog((Object)this, 1, callResult.getErrorInfo());
                return callResult;
            }
            strWFId = deSubWF.getWFID();
        } else {
            strWFId = iDEHelper.GetDEWFId(this.getWebContext().getSRFWFMode());
        }
        String strKeyValue = dataEntity.GetParamStringValue(iDEHelper.GetKeyDEFHelper().getName(), "");
        String strStepName = this.getWebContext().GetParamValue("SRFWFPROCESSNAME");
        WFCallResult wfCallResult = wfClientAPI.ResubmitAction(strWFId, this.getWebContext().getCurUserId(), strKeyValue, "", "", iDEHelper.getId(), strStepName, this.strWFActorId, this.strDescription, this.OnGetUserTag(), this.OnGetUserTag2());
        wfCallResult = this.OnAfterSubmitIAAction(wfCallResult, iDEHelper, dataEntity);
        if (wfCallResult == null || wfCallResult.getRetCode() != 0) {
            this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u5de5\u4f5c\u6d41\u91cd\u65b0\u6307\u6d3e\u7528\u6237\u64cd\u4f5c\u5931\u8d25\uff0c%1$s", (Object)wfCallResult.getErrorInfo()));
            return wfCallResult;
        }
        callResult.setUserObject((Object)wfCallResult);
        return callResult;
    }

    protected String OnSaveActionOutputResult(SRFExFormSaveResult saveResult) {
        return saveResult.ToJSONString();
    }

    protected void FillFormUserErrors(SRFExForm form1, SRFExFormItemErrors formItemErrors, CallResult callResult) {
        DBResult result;
        Object objDBResult = callResult.getUserObject();
        if (objDBResult != null && objDBResult instanceof DBResult && (result = (DBResult)objDBResult).getOutValues().containsKey("SRF_TAG")) {
            String strFormItems = (String)result.getOutValues().get("SRF_TAG");
            String[] formItems = StringHelper.Split((String)strFormItems, (char)'|');
            int i = 0;
            while (i < formItems.length) {
                String strFormItemId = formItems[i];
                if (StringHelper.Length((String)strFormItemId) != 0) {
                    SRFExControl control = form1.FindControl(strFormItemId);
                    if (control != null) {
                        formItemErrors.Register(control, 3, callResult.getErrorInfo());
                    } else {
                        String strErrorInfo = "";
                        IDEFHelper iDEFHelper = this.getPage().getDEHelper().GetDEFHelper(strFormItemId);
                        if (iDEFHelper != null) {
                            strErrorInfo = StringHelper.Format((String)"\u8868\u5355\u4e2d\u4e0d\u5b58\u5728[%1$s]", (Object)iDEFHelper.getLogicName(this.getPage().getLanguage()));
                        }
                        if (!StringHelper.IsNullOrEmpty((String)strErrorInfo) && !StringHelper.IsNullOrEmpty((String)callResult.getErrorInfo())) {
                            strErrorInfo = String.valueOf(strErrorInfo) + ",";
                        }
                        strErrorInfo = String.valueOf(strErrorInfo) + callResult.getErrorInfo();
                        formItemErrors.Register("", "", 3, strErrorInfo);
                    }
                }
                ++i;
            }
        }
    }

    protected void OnBeforeIAAction() {
    }

    protected void OnAfterIAAction() {
    }

    protected CallResult OnBeforeTestSubmitIAAction(IDEHelper iDEHelper, BaseDataEntity dataEntity) {
        return new CallResult();
    }

    protected WFCallResult OnAfterSubmitIAAction(WFCallResult callResult, IDEHelper iDEHelper, BaseDataEntity dataEntity) {
        return callResult;
    }

    protected SRFDAPage getPage() {
        return (SRFDAPage)this.page;
    }

    protected SRFDAWebContext getWebContext() {
        return (SRFDAWebContext)super.getWebContext();
    }

    protected IDEDataCtrl getDEDataCtrl() {
        return this.getPage().GetDEDataCtrl();
    }

    protected String GetSetPageInfoJSEx(String strDefaultInfo) {
        if (StringHelper.IsNullOrEmpty((String)this.strPageInfo)) {
            return WFResubmitActionFormActionHelper.GetSetPageInfoJS(strDefaultInfo);
        }
        return WFResubmitActionFormActionHelper.GetSetPageInfoJS(this.strPageInfo);
    }

    protected String GetSetPageInfoJS() {
        return WFResubmitActionFormActionHelper.GetSetPageInfoJS(this.strPageInfo);
    }

    protected static String GetSetPageInfoJS(String strInfo) {
        return StringHelper.Format((String)"$P.setpageinfo('%1$s');", (Object)strInfo);
    }

    protected static String GetSetPageDataJS(String strData) {
        return StringHelper.Format((String)"$P.setpagedata('%1$s');", (Object)strData);
    }

    protected void SetPageInfo(String strPageInfo) {
        this.strPageInfo = strPageInfo;
    }

    protected String OnGetUserTag() {
        return "";
    }

    protected String OnGetUserTag2() {
        return "";
    }

    protected String GetFormState() {
        String strFormState = this.getPage().getPageParam("PAGE.FORMSTATE", "");
        if (StringHelper.IsNullOrEmpty((String)strFormState)) {
            return StringHelper.Format((String)"%1$s", (Object)"UPDATE");
        }
        return strFormState;
    }

    protected JSONObject GetFormState(boolean bCreate, BaseDataEntity dataEntity) {
        JSONObject jsonObject = new JSONObject();
        String strFormState = this.GetFormState();
        if (StringHelper.IsNullOrEmpty((String)strFormState)) {
            return jsonObject;
        }
        String[] actions = strFormState.split("[|]");
        int i = 0;
        while (i < actions.length) {
            String strAction = actions[i];
            if (!StringHelper.IsNullOrEmpty((String)(strAction = strAction.trim()))) {
                jsonObject.put(strAction.toLowerCase(), true);
            }
            ++i;
        }
        return jsonObject;
    }
}

