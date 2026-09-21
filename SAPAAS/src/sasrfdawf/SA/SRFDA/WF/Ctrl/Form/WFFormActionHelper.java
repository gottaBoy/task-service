/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.Form.BaseDAFormActionHelper
 *  SA.SRFDA.Web.Script.RichAppJSHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.Form.SRFExFormSaveResult
 *  SRFWF.Client.WFCallResult
 *  SRFWF.Client.WFClientAPI
 *  SRFWF.Ctrl.Data.WFInstance
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.WF.Ctrl.Form;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.Form.BaseDAFormActionHelper;
import SA.SRFDA.Web.Script.RichAppJSHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Form.SRFExFormSaveResult;
import SRFWF.Client.WFCallResult;
import SRFWF.Client.WFClientAPI;
import SRFWF.Ctrl.Data.WFInstance;
import net.sf.json.JSONObject;

public class WFFormActionHelper
extends BaseDAFormActionHelper {
    public static final String TAG_WFSTATE = "WFSTATE";
    public static final String TAG_WFSTEP = "WFSTEP";
    public static final String TAG_SRFSTARTWF = "SRFSTARTWF";
    protected boolean bViewStepData = false;
    protected boolean bViewStepActor = false;
    private boolean bReplaceSaveFailedInfo = false;
    private String strLastErrorInfo = "";
    private boolean bStartWF = false;

    protected CallResult OnSaveActionAfterInsert(CallResult callResult, BaseDataEntity dataEntity) {
        if ((callResult = super.OnSaveActionAfterInsert(callResult, dataEntity)).getRetCode() != 0) {
            return callResult;
        }
        return this.ExecuteWFAction(dataEntity);
    }

    protected CallResult OnSaveActionBeforeUpdate(BaseDataEntity dataEntity) {
        CallResult callResult = super.OnSaveActionBeforeUpdate(dataEntity);
        if (callResult.getRetCode() != 0) {
            return callResult;
        }
        String strWFId = this.getPage().getDEHelper().GetDEWFId(this.getWebContext().getSRFWFMode());
        String strKeyValue = dataEntity.GetParamStringValue(this.getPage().getDEHelper().GetKeyDEFHelper().getName(), "");
        WFInstance wfInstance = new WFInstance();
        callResult = this.GetWFInstance(strWFId, strKeyValue, "", "", this.getPage().getDEHelper().getId(), wfInstance);
        if (callResult.getRetCode() == 0) {
            String strErrorInfo = this.getPage().GetLocalization("ERROR.STD.WF.DATAINPROCESS", "\u6570\u636e\u5904\u4e8e\u6d41\u7a0b\u8fc7\u7a0b\u4e2d\uff0c\u65e0\u6cd5\u8fdb\u884c\u53d8\u66f4\uff01");
            this.SetPageInfo(strErrorInfo);
            callResult.setRetCode(2);
            callResult.setErrorInfo(strErrorInfo);
            return callResult;
        }
        if (callResult.getRetCode() == 3) {
            callResult.setRetCode(0);
            return callResult;
        }
        return callResult;
    }

    protected boolean IsDisableAllItems(BaseDataEntity dataEntity) {
        String strWFId = this.getPage().getDEHelper().GetDEWFId(this.getWebContext().getSRFWFMode());
        String strKeyValue = dataEntity.GetParamStringValue(this.getPage().getDEHelper().GetKeyDEFHelper().getName(), "");
        if (StringHelper.IsNullOrEmpty((String)strKeyValue)) {
            return false;
        }
        WFInstance wfInstance = new WFInstance();
        CallResult callResult = this.GetWFInstance(strWFId, strKeyValue, "", "", this.getPage().getDEHelper().getId(), wfInstance);
        this.bViewStepActor = callResult.getRetCode() == 0;
        this.bViewStepData = true;
        return callResult.getRetCode() != 3;
    }

    private CallResult GetWFInstance(String strWorkFlowId, String strUserData, String strUserData2, String strUserData3, String strUserData4, WFInstance instance) {
        String strSql = StringHelper.Format((String)"select * from t_srfwfinstance where  WFWorkflowId='%1$s' AND (ISCLOSE IS  NULL OR ISCLOSE <> 1) ", (Object)strWorkFlowId);
        strSql = StringHelper.IsNullOrEmpty((String)strUserData) ? String.valueOf(strSql) + " AND (USERDATA IS NULL OR USERDATA='') " : String.valueOf(strSql) + StringHelper.Format((String)" AND (USERDATA = '%1$s') ", (Object)strUserData);
        strSql = StringHelper.IsNullOrEmpty((String)strUserData2) ? String.valueOf(strSql) + " AND (USERDATA2 IS NULL OR USERDATA2='') " : String.valueOf(strSql) + StringHelper.Format((String)" AND (USERDATA2 = '%1$s') ", (Object)strUserData2);
        strSql = StringHelper.IsNullOrEmpty((String)strUserData3) ? String.valueOf(strSql) + " AND (USERDATA3 IS NULL OR USERDATA3='') " : String.valueOf(strSql) + StringHelper.Format((String)" AND (USERDATA3 = '%1$s') ", (Object)strUserData3);
        strSql = StringHelper.IsNullOrEmpty((String)strUserData4) ? String.valueOf(strSql) + " AND (USERDATA4 IS NULL OR USERDATA4='') " : String.valueOf(strSql) + StringHelper.Format((String)" AND (USERDATA4 = '%1$s') ", (Object)strUserData4);
        return BaseDEDataCtrl.SelectSingle((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), (String)strSql, (BaseDataEntity)instance);
    }

    protected CallResult OnSaveActionAfterUpdate(CallResult callResult, BaseDataEntity dataEntity) {
        if ((callResult = super.OnSaveActionAfterUpdate(callResult, dataEntity)).getRetCode() != 0) {
            return callResult;
        }
        return this.ExecuteWFAction(dataEntity);
    }

    protected CallResult ExecuteWFAction(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        String strWFAction = this.getWebContext().getSRFWFACTION();
        if (StringHelper.IsNullOrEmpty((String)strWFAction)) {
            return callResult;
        }
        if (StringHelper.Compare((String)strWFAction, (String)"STARTNEW", (boolean)true) == 0) {
            callResult = this.OnTestDataAction(dataEntity, "WFSTART");
            if (callResult.getRetCode() != 0) {
                return callResult;
            }
            return this.StartWF(dataEntity);
        }
        callResult.setRetCode(1);
        String strErrorInfo = this.getPage().GetLocalization("ERROR.STD.WF.UNKNOWNCOMMAND", "\u65e0\u6cd5\u8bc6\u522b\u7684\u5de5\u4f5c\u6d41\u6307\u4ee4\uff01");
        callResult.setErrorInfo(strErrorInfo);
        this.getPage().PageLog((Object)this, 1, strErrorInfo);
        return callResult;
    }

    protected CallResult StartWF(BaseDataEntity dataEntity) {
        WFClientAPI wfClientAPI = new WFClientAPI();
        String strWFWSUrl = this.getWebContext().getWebExConfig().GetValue("SRFDA", "WFWSURL", "");
        CallResult callResult = wfClientAPI.Init(strWFWSUrl, true);
        if (callResult == null || callResult.getRetCode() != 0) {
            this.bReplaceSaveFailedInfo = true;
            if (StringHelper.IsNullOrEmpty((String)this.getPage().getPageModel())) {
                this.AppendExtJSBeforeCode(StringHelper.Format((String)"%1$s.saveandclose=false;", (Object)this.getForm().getFormId()));
            } else {
                this.AppendExtJSBeforeCode(StringHelper.Format((String)"$P.setparam('SAVEANDCLOSE',false);"));
            }
            String strErrorFormat = this.getPage().GetLocalization("ERROR.STD.WF.INITWSFAILED", "\u521d\u59cb\u5316\u5de5\u4f5c\u6d41WS\u94fe\u63a5\u5931\u8d25\uff0c%1$s");
            String strErrorInfo = StringHelper.Format((String)strErrorFormat, (Object)callResult.getErrorInfo());
            this.SetPageInfo(strErrorInfo);
            this.AppendExtJSBeforeCode(StringHelper.Format((String)"alert('%1$s');", (Object)strErrorInfo));
            this.getPage().PageLog((Object)this, 1, strErrorInfo);
            callResult.setRetCode(0);
            return callResult;
        }
        String strWFId = this.getPage().getDEHelper().GetDEWFId(this.getWebContext().getSRFWFMode());
        String strKeyValue = dataEntity.GetParamStringValue(this.getPage().getDEHelper().GetKeyDEFHelper().getName(), "");
        WFCallResult wfCallResult = wfClientAPI.StartNew(strWFId, this.getWebContext().getCurUserId(), strKeyValue, "", "", this.getPage().getDEHelper().getId());
        if (wfCallResult == null || wfCallResult.getRetCode() != 0) {
            this.bReplaceSaveFailedInfo = true;
            if (StringHelper.IsNullOrEmpty((String)this.getPage().getPageModel())) {
                this.AppendExtJSBeforeCode(StringHelper.Format((String)"%1$s.saveandclose=false;", (Object)this.getForm().getFormId()));
            } else {
                this.AppendExtJSBeforeCode(StringHelper.Format((String)"$P.setparam('SAVEANDCLOSE',false);"));
            }
            String strErrorFormat = this.getPage().GetLocalization("ERROR.STD.WF.STARTFAILED", "\u542f\u52a8\u5de5\u4f5c\u6d41\u5931\u8d25\uff0c%1$s");
            String strErrorInfo = StringHelper.Format((String)strErrorFormat, (Object)(wfCallResult == null ? "\u672a\u77e5\u9519\u8bef" : wfCallResult.getErrorInfo()));
            this.SetPageInfo(strErrorInfo);
            this.AppendExtJSBeforeCode(StringHelper.Format((String)"alert('%1$s');", (Object)strErrorInfo));
            this.getPage().PageLog((Object)this, 1, strErrorInfo);
            wfCallResult.setRetCode(0);
            return wfCallResult;
        }
        this.getDEDataCtrl().Get(dataEntity);
        String strSaveAndStartWFInfo = this.getPage().GetLocalization("CTRL.WFFORMAH.DATASAVEANDSTARTWF", "\u6570\u636e\u4fdd\u5b58\u5e76\u5f00\u59cb\u6d41\u7a0b\u6210\u529f!");
        this.SetPageInfo(strSaveAndStartWFInfo);
        if (StringHelper.IsNullOrEmpty((String)this.getPage().getPageModel())) {
            String strInformMsgBox = this.getWebContext().getWebExConfig().GetValue("SRFDA.WF", "INFORMMSGBOX", "");
            if (StringHelper.Compare((String)strInformMsgBox, (String)"EXTMSG", (boolean)true) == 0) {
                this.AppendExtJSBeforeCode(StringHelper.Format((String)"%1$s.saveandclose=false;", (Object)this.getForm().getFormId()));
                this.AppendExtJSBeforeCode(StringHelper.Format((String)"Ext.Msg.alert('\u63d0\u793a', '%1$s',function(){window.close();});", (Object)strSaveAndStartWFInfo));
            } else {
                this.AppendExtJSBeforeCode(StringHelper.Format((String)"alert('%1$s');", (Object)strSaveAndStartWFInfo));
            }
        } else {
            this.AppendExtJSBeforeCode(StringHelper.Format((String)"alert('%1$s');", (Object)strSaveAndStartWFInfo));
        }
        this.bStartWF = true;
        return callResult;
    }

    protected String GetFormState() {
        String strFormState = super.GetFormState();
        if (!StringHelper.IsNullOrEmpty((String)strFormState)) {
            strFormState = String.valueOf(strFormState) + "|";
        }
        strFormState = String.valueOf(strFormState) + "WFSTART";
        return strFormState;
    }

    protected void OnSetMainFormState(JSONObject jsonObject, boolean bCreate, BaseDataEntity dataEntity) {
        super.OnSetMainFormState(jsonObject, bCreate, dataEntity);
        if (!bCreate) {
            jsonObject.put("WFVIEWSTEPACTOR".toLowerCase(), this.bViewStepActor);
            jsonObject.put("WFVIEWSTEPDATA".toLowerCase(), this.bViewStepData);
        }
    }

    public String GetLocalization(String strResId, String strDefault) {
        if (this.bReplaceSaveFailedInfo && StringHelper.Compare((String)strResId, (String)"CTRL.FORMAH.DATASAVEDSUCCESSFULLY", (boolean)true) == 0) {
            return String.valueOf(super.GetLocalization(strResId, strDefault)) + " \u542f\u52a8\u6d41\u7a0b\u5931\u8d25!";
        }
        return super.GetLocalization(strResId, strDefault);
    }

    protected String OnSaveActionOutputResult(BaseDataEntity dataEntity, SRFExFormSaveResult saveResult) {
        if (this.bStartWF && !StringHelper.IsNullOrEmpty((String)this.getPage().getPageModel())) {
            saveResult.AppendJSCode(RichAppJSHelper.getSetDialogResult((String)this.getPage().getPageModel(), (String)"OK"));
        }
        return super.OnSaveActionOutputResult(dataEntity, saveResult);
    }
}

