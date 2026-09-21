/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Data.DESubWF
 *  SA.SRFDA.Ctrl.Form.BaseDAFormActionHelper
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAWebCTXHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.Form.SRFExFormItemErrors
 *  SA.SRFramework.WebEx.Form.SRFExFormLoadResult
 *  SA.SRFramework.WebEx.Form.SRFExFormSaveResult
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExFormItem
 *  SRFWF.Client.WFCallResult
 *  SRFWF.Client.WFClientAPI
 *  SRFWF.Client.WFGetIAActionsResult
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.WF.Ctrl.Form;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.DESubWF;
import SA.SRFDA.Ctrl.Form.BaseDAFormActionHelper;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAWebCTXHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Form.SRFExFormItemErrors;
import SA.SRFramework.WebEx.Form.SRFExFormLoadResult;
import SA.SRFramework.WebEx.Form.SRFExFormSaveResult;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExFormItem;
import SRFWF.Client.WFCallResult;
import SRFWF.Client.WFClientAPI;
import SRFWF.Client.WFGetIAActionsResult;
import java.util.Vector;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WFInfoFormActionHelper
extends BaseDAFormActionHelper {
    private static final Log log = LogFactory.getLog(WFInfoFormActionHelper.class);
    protected Vector<String> disableItems = null;
    protected String strKeyName = "";
    protected String strDataLockKey = "";
    protected boolean bViewStepData = true;
    protected boolean bViewStepActor = true;
    protected DESubWF deSubWF = null;
    protected String strDESubWFId = "";
    protected String strSubWFStep = "";

    protected boolean OnLoadAction() {
        SRFExFormLoadResult loadResult = new SRFExFormLoadResult();
        SRFExFormItemErrors formItemErrors = new SRFExFormItemErrors();
        BaseDataEntity dataEntity = this.CreateFormDataEntity();
        if (!this.form1.FillDataEntity(dataEntity, true, formItemErrors)) {
            loadResult.setRetCode(4);
            loadResult.setJSCode("alert('\u6ca1\u6709\u6307\u5b9a\u6570\u636e\u952e\u503c');");
            loadResult.AppendJSCode(WFInfoFormActionHelper.GetSetPageDataJS((String)""));
            loadResult.AppendJSCode(WFInfoFormActionHelper.GetSetPageInfoJS((String)"\u6ca1\u6709\u6307\u5b9a\u6570\u636e\u952e\u503c"));
            this.getPage().Output(loadResult.ToJSONString());
            return true;
        }
        this.MarkWFStepActorReadFlag(dataEntity);
        dataEntity.SetParamValue("SRF_CHILDDATATAG", (Object)this.formView.getCHILDDATATAG());
        CallResult callResult = null;
        callResult = this.formView == null || StringHelper.IsNullOrEmpty((String)this.formView.getGETMODE()) ? this.getDEDataCtrl().Get(dataEntity) : this.getDEDataCtrl().Get(this.formView.getGETMODE(), dataEntity);
        if (callResult.IsOk()) {
            callResult = this.OnLoadActionAfterGet(dataEntity);
        }
        if (callResult.getRetCode() != 0) {
            if (callResult.getRetCode() == 3 && this.getPage().getPageParam("EMBEDEDIT", false)) {
                return this.OnLoadDefaultAction();
            }
            if (callResult.IsUserError()) {
                callResult.setRetCode(5);
                formItemErrors.FillJSONs(loadResult.getItems());
            }
            loadResult.From(callResult);
            loadResult.AppendJSCode(WFInfoFormActionHelper.GetSetPageDataJS((String)""));
            loadResult.AppendJSCode(WFInfoFormActionHelper.GetSetPageInfoJS((String)"\u6570\u636e\u67e5\u8be2\u5931\u8d25"));
        } else {
            this.OnLoadActionFillForm(dataEntity);
            this.form1.FillByDataEntity(dataEntity, false);
            boolean bEnableUpdate = this.getPage().getPageParam("ENABLEUPDATE", false);
            if (bEnableUpdate) {
                this.form1.EnableFormItems(false);
            } else {
                this.form1.EnableAllFormItems(false);
            }
            this.OnLoadActionBeforeFillValueJSON();
            this.form1.FillValueJSON(loadResult.getItems(), this.getPage().isControlValueFromUniqueId());
            loadResult.AppendJSCode(WFInfoFormActionHelper.GetSetPageDataJS((String)this.getPage().getDEHelper().GetDataInfo(dataEntity)));
            loadResult.AppendJSCode(WFInfoFormActionHelper.GetSetWFMainStateJS((IDEHelper)this.getPage().getDEHelper(), (String)dataEntity.GetParamStringValue(this.getPage().getDEHelper().GetKeyDEFHelper().getName(), "")));
            loadResult.setUpdateFlag(true);
            JSONObject jsonObject = new JSONObject();
            if (bEnableUpdate) {
                jsonObject.put("update", true);
            }
            jsonObject.put("WFVIEWSTEPACTOR".toLowerCase(), this.bViewStepActor);
            jsonObject.put("WFVIEWSTEPDATA".toLowerCase(), this.bViewStepData);
            loadResult.setFormState(jsonObject);
        }
        this.getPage().Output(loadResult.ToJSONString());
        return true;
    }

    protected boolean OnLoadActionBeforeFillValueJSON() {
        return true;
    }

    protected boolean OnBeforeProcess() {
        if (super.OnBeforeProcess()) {
            this.strKeyName = this.getPage().getDEHelper().GetKeyDEFHelper().getName();
            SRFExControl keyControl = this.form1.FindControl(this.strKeyName);
            if (keyControl != null && keyControl instanceof SRFExFormItem) {
                ((SRFExFormItem)keyControl).getFormItemConfig().setDataType(25);
                ((SRFExFormItem)keyControl).getFormItemConfig().setMaxLength(65536);
            }
            this.strDESubWFId = SRFDAWebCTXHelper.GetDESubWFId((ISRFDAWebContext)this.getWebContext());
            if (!StringHelper.IsNullOrEmpty((String)this.strDESubWFId)) {
                this.deSubWF = this.getPage().getDEHelper().GetDESubWF(this.strDESubWFId);
                if (this.deSubWF == null) {
                    this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u5e76\u884c\u5b50\u6d41\u7a0b[%1$s]", (Object)this.strDESubWFId));
                    return false;
                }
                this.strSubWFStep = SRFDAWebCTXHelper.GetWFSubStep((ISRFDAWebContext)this.getWebContext());
            }
            return true;
        }
        return false;
    }

    protected boolean OnSaveAction() {
        boolean bEnableUpdate = this.getPage().getPageParam("ENABLEUPDATE", false);
        if (!bEnableUpdate) {
            SRFExFormSaveResult saveResult = new SRFExFormSaveResult();
            saveResult.setRetCode(5);
            saveResult.AppendJSCode(WFInfoFormActionHelper.GetSetPageInfoJS((String)"\u8be5\u6570\u636e\u9650\u5236\u66f4\u65b0!\u6570\u636e\u65e0\u6cd5\u4fdd\u5b58!"));
            this.getPage().Output(saveResult.ToJSONString());
            return true;
        }
        return super.OnSaveAction();
    }

    protected CallResult OnSaveActionBeforeUpdate(BaseDataEntity dataEntity) {
        WFClientAPI wfClientAPI = new WFClientAPI();
        String strWFWSUrl = this.getWebContext().getWebExConfig().GetValue("SRFDA", "WFWSURL", "");
        CallResult callResult = wfClientAPI.Init(strWFWSUrl, true);
        if (callResult == null || callResult.getRetCode() != 0) {
            this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u521d\u59cb\u5316\u5de5\u4f5c\u6d41WS\u94fe\u63a5\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        String strKeyValue = dataEntity.GetParamStringValue(this.strKeyName, "");
        if (this.deSubWF == null) {
            String strWFId = this.getPage().getDEHelper().GetDEWFId(this.getWebContext().getSRFWFMode());
            String strStepName = this.getWebContext().getSRFWFSTEP();
            WFGetIAActionsResult wfGetIAActionsResult = wfClientAPI.GetIAActions(strWFId, this.getWebContext().getCurUserId(), "", strStepName, "", "", "", "");
            if (wfGetIAActionsResult == null || wfGetIAActionsResult.getRetCode() != 0) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)StringHelper.Format((String)"\u83b7\u53d6\u5de5\u4f5c\u6d41\u4ea4\u4e92\u6b65\u9aa4\u5931\u8d25\uff0c%1$s", (Object)wfGetIAActionsResult.getErrorInfo())));
                this.getPage().PageLog((Object)this, 1, callResult.getErrorInfo());
                return callResult;
            }
            String strProcessName = wfGetIAActionsResult.getProcessName();
            WFCallResult wfCallResult = wfClientAPI.TestSubmitIAAction(strWFId, this.getWebContext().getCurUserId(), strKeyValue, "", "", this.getPage().getDEHelper().getId(), strProcessName, "", "", this.OnGetUserTag(), this.OnGetUserTag2());
            if (wfCallResult == null || wfCallResult.getRetCode() != 0) {
                this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u6d4b\u8bd5\u5de5\u4f5c\u6d41\u4ea4\u4e92\u64cd\u4f5c\u5931\u8d25\uff0c%1$s", (Object)wfCallResult.getErrorInfo()));
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u6d4b\u8bd5\u5de5\u4f5c\u6d41\u4ea4\u4e92\u64cd\u4f5c\u5931\u8d25\uff0c%1$s", (Object)wfCallResult.getErrorInfo()));
                return callResult;
            }
            String strInstId = wfCallResult.getRunInfo();
            this.strDataLockKey = StringHelper.Format((String)"WFINSTID:%1$s", (Object)strInstId);
        } else {
            WFGetIAActionsResult wfGetIAActionsResult = wfClientAPI.GetIAActions(this.deSubWF.getWFID(), this.getWebContext().getCurUserId(), "", this.strSubWFStep, "", "", "", "");
            if (wfGetIAActionsResult == null || wfGetIAActionsResult.getRetCode() != 0) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)StringHelper.Format((String)"\u83b7\u53d6\u5de5\u4f5c\u6d41\u4ea4\u4e92\u6b65\u9aa4\u5931\u8d25\uff0c%1$s", (Object)wfGetIAActionsResult.getErrorInfo())));
                this.getPage().PageLog((Object)this, 1, callResult.getErrorInfo());
                return callResult;
            }
            String strProcessName = wfGetIAActionsResult.getProcessName();
            WFCallResult wfCallResult = wfClientAPI.TestSubmitIAAction(this.deSubWF.getWFID(), this.getWebContext().getCurUserId(), strKeyValue, "", "", this.getPage().getDEHelper().getId(), strProcessName, "", "", this.OnGetUserTag(), this.OnGetUserTag2());
            if (wfCallResult == null || wfCallResult.getRetCode() != 0) {
                this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u6d4b\u8bd5\u5de5\u4f5c\u6d41\u4ea4\u4e92\u64cd\u4f5c\u5931\u8d25\uff0c%1$s", (Object)wfCallResult.getErrorInfo()));
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u6d4b\u8bd5\u5de5\u4f5c\u6d41\u4ea4\u4e92\u64cd\u4f5c\u5931\u8d25\uff0c%1$s", (Object)wfCallResult.getErrorInfo()));
                return callResult;
            }
            String strInstId = wfCallResult.getRunInfo();
            this.strDataLockKey = StringHelper.Format((String)"WFINSTID:%1$s", (Object)strInstId);
            BaseDataEntity dataEntity2 = this.CreateFormDataEntity();
            dataEntity.CopyTo(dataEntity2, false);
            callResult = this.getDEDataCtrl().Get(dataEntity2);
            if (callResult.IsError()) {
                this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u67e5\u8be2\u4e3b\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                return callResult;
            }
            IDEFHelper iDEFHelper = this.getPage().getDEHelper().GetDEFHelper(this.getPage().getDEHelper().GetDEWF().getWFINSTDEFID());
            if (iDEFHelper != null) {
                strInstId = dataEntity2.GetParamStringValue(iDEFHelper.getName(), "");
                this.strDataLockKey = StringHelper.Format((String)"WFINSTID:%1$s", (Object)strInstId);
            }
        }
        this.bTestDataUpdateAction = false;
        return super.OnSaveActionBeforeUpdate(dataEntity);
    }

    protected CallResult MarkWFStepActorReadFlag(BaseDataEntity dataEntity) {
        IDEHelper wfStepActorHelper = this.getPage().getDAModelStorage().FindDEHelper("WF0006");
        if (wfStepActorHelper.GetDEFHelper("READFLAG") == null) {
            return new CallResult();
        }
        WFClientAPI wfClientAPI = new WFClientAPI();
        String strWFWSUrl = this.getWebContext().getWebExConfig().GetValue("SRFDA", "WFWSURL", "");
        CallResult callResult = wfClientAPI.Init(strWFWSUrl, true);
        if (callResult == null || callResult.getRetCode() != 0) {
            this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u521d\u59cb\u5316\u5de5\u4f5c\u6d41WS\u94fe\u63a5\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        String strKeyValue = dataEntity.GetParamStringValue(this.strKeyName, "");
        if (this.deSubWF == null) {
            String strWFId = this.getPage().getDEHelper().GetDEWFId(this.getWebContext().getSRFWFMode());
            String strStepName = this.getWebContext().getSRFWFSTEP();
            WFCallResult wfCallResult = wfClientAPI.MarkReadFlag(strWFId, this.getWebContext().getCurUserId(), strKeyValue, "", "", this.getPage().getDEHelper().getId(), strStepName, "", this.OnGetUserTag(), this.OnGetUserTag2());
            if (wfCallResult == null || wfCallResult.getRetCode() != 0) {
                this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u6807\u8bb0\u5de5\u4f5c\u6d41\u7528\u6237\u8bfb\u53d6\u6807\u5fd7\u5931\u8d25\uff0c%1$s", (Object)wfCallResult.getErrorInfo()));
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u6807\u8bb0\u5de5\u4f5c\u6d41\u7528\u6237\u8bfb\u53d6\u6807\u5fd7\u5931\u8d25\uff0c%1$s", (Object)wfCallResult.getErrorInfo()));
                return callResult;
            }
        } else {
            WFCallResult wfCallResult = wfClientAPI.MarkReadFlag(this.deSubWF.getWFID(), this.getWebContext().getCurUserId(), strKeyValue, "", "", this.getPage().getDEHelper().getId(), this.strSubWFStep, "", this.OnGetUserTag(), this.OnGetUserTag2());
            if (wfCallResult == null || wfCallResult.getRetCode() != 0) {
                this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u6807\u8bb0\u5de5\u4f5c\u6d41\u7528\u6237\u8bfb\u53d6\u6807\u5fd7\u5931\u8d25\uff0c%1$s", (Object)wfCallResult.getErrorInfo()));
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u6807\u8bb0\u5de5\u4f5c\u6d41\u7528\u6237\u8bfb\u53d6\u6807\u5fd7\u5931\u8d25\uff0c%1$s", (Object)wfCallResult.getErrorInfo()));
                return callResult;
            }
        }
        return callResult;
    }

    protected String GetDataLockKey(BaseDataEntity dataEntity) {
        return this.strDataLockKey;
    }

    protected String OnGetUserTag() {
        return "";
    }

    protected String OnGetUserTag2() {
        return this.getWebContext().GetParamValue("WFSTEPACTORID");
    }

    protected void OnSetMainFormState(JSONObject jsonObject, boolean bCreate, BaseDataEntity dataEntity) {
        super.OnSetMainFormState(jsonObject, bCreate, dataEntity);
        if (!bCreate) {
            jsonObject.put("WFVIEWSTEPACTOR".toLowerCase(), this.bViewStepActor);
            jsonObject.put("WFVIEWSTEPDATA".toLowerCase(), this.bViewStepData);
        }
    }
}

