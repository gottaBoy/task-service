/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IInheritDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IPickupDEFHelper
 *  SA.SRFDA.Ctrl.Data.DEAction
 *  SA.SRFDA.Ctrl.Data.DEBehavior
 *  SA.SRFDA.Ctrl.Data.DEDSCtrl
 *  SA.SRFDA.Ctrl.Data.DER1N
 *  SA.SRFDA.Ctrl.Data.DERINDEX
 *  SA.SRFDA.Ctrl.Data.DEWizardDetail
 *  SA.SRFDA.Ctrl.Data.FIUpdate
 *  SA.SRFDA.Ctrl.Data.Form
 *  SA.SRFDA.Ctrl.Data.TempData
 *  SA.SRFDA.Ctrl.Data.WizardStepData
 *  SA.SRFDA.Ctrl.DefaultTransactionManager
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAWebContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.Web.WebUtility
 *  SA.SRFramework.WebEx.DP.SRFExDPEx
 *  SA.SRFramework.WebEx.Form.SRFExBaseForm
 *  SA.SRFramework.WebEx.Form.SRFExForm
 *  SA.SRFramework.WebEx.Form.SRFExFormActionHelper
 *  SA.SRFramework.WebEx.Form.SRFExFormCustomCallResult
 *  SA.SRFramework.WebEx.Form.SRFExFormItemErrors
 *  SA.SRFramework.WebEx.Form.SRFExFormLoadResult
 *  SA.SRFramework.WebEx.Form.SRFExFormSaveResult
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.Script.BrowserJSHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.Form;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.IInheritDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.IPickupDEFHelper;
import SA.SRFDA.Ctrl.Data.DEAction;
import SA.SRFDA.Ctrl.Data.DEBehavior;
import SA.SRFDA.Ctrl.Data.DEDSCtrl;
import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.Data.DEWizardDetail;
import SA.SRFDA.Ctrl.Data.FIUpdate;
import SA.SRFDA.Ctrl.Data.Form;
import SA.SRFDA.Ctrl.Data.TempData;
import SA.SRFDA.Ctrl.Data.WizardStepData;
import SA.SRFDA.Ctrl.DefaultTransactionManager;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.SRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.DBResult;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.Web.WebUtility;
import SA.SRFramework.WebEx.DP.SRFExDPEx;
import SA.SRFramework.WebEx.Form.SRFExBaseForm;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.Form.SRFExFormActionHelper;
import SA.SRFramework.WebEx.Form.SRFExFormCustomCallResult;
import SA.SRFramework.WebEx.Form.SRFExFormItemErrors;
import SA.SRFramework.WebEx.Form.SRFExFormLoadResult;
import SA.SRFramework.WebEx.Form.SRFExFormSaveResult;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;
import java.util.Hashtable;
import java.util.Vector;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WizardStepFormActionHelper
extends SRFExFormActionHelper {
    protected Form formView = null;
    protected SRFExDPEx mainPanel = null;
    private static final Log log = LogFactory.getLog(WizardStepFormActionHelper.class);
    protected Vector<String> disableItems = null;
    protected SRFExForm form1 = null;
    protected String strPageInfo = "";
    protected StringBuilderEx script = null;
    protected StringBuilderEx beforeScript = null;
    protected boolean bUpdateFlag = false;
    protected String strDEWizardId = "";
    protected String strDEWZPageId = "";
    protected String strWizardSessionId = "";
    protected String strWizardStepId = "";
    protected DEWizardDetail deWizardDetail = null;

    protected boolean OnBeforeProcess() {
        if (super.OnBeforeProcess()) {
            this.form1 = this.getForm();
            SRFExControl contorl = this.form1.getMainPanel();
            if (contorl != null && contorl instanceof SRFExDPEx) {
                this.mainPanel = (SRFExDPEx)contorl;
            }
            if (this.mainPanel == null) {
                return false;
            }
            String strUF = this.getWebContext().GetPostValue("srfuf");
            this.bUpdateFlag = !StringHelper.IsNullOrEmpty((String)strUF) && StringHelper.Compare((String)strUF, (String)"TRUE", (boolean)true) == 0;
            this.form1.setUpdateMode(this.bUpdateFlag);
            this.getFormView();
            this.strDEWizardId = this.getWebContext().GetParamValue("SRFDEWIZARDID");
            if (StringHelper.IsNullOrEmpty((String)this.strDEWizardId)) {
                log.error((Object)StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u5411\u5bfc\u7f16\u53f7"));
                return false;
            }
            this.strDEWZPageId = this.getWebContext().GetParamValue("SRFDEWZPAGEID");
            if (StringHelper.IsNullOrEmpty((String)this.strDEWZPageId)) {
                log.error((Object)StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u5411\u5bfc\u5206\u9875\u7f16\u53f7"));
                return false;
            }
            this.deWizardDetail = new DEWizardDetail();
            CallResult callResult = this.getPage().getDAModelHelper().GetDEWizardDetail(this.strDEWizardId, this.strDEWZPageId, this.deWizardDetail);
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u5411\u5bfc\u6b65\u9aa4[%1$s-%2$s]\u5931\u8d25\uff0c%3$s", (Object)this.strDEWizardId, (Object)this.strDEWZPageId, (Object)callResult.getErrorInfo()));
                return false;
            }
            this.strWizardSessionId = this.getWebContext().GetParamValue("SRFWZSESSIONID");
            if (StringHelper.IsNullOrEmpty((String)this.strWizardSessionId)) {
                log.error((Object)StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u5411\u5bfc\u4f1a\u8bdd\u7f16\u53f7"));
                return false;
            }
            this.strWizardStepId = this.getWebContext().GetParamValue("SRFWZSTEPID");
            if (StringHelper.IsNullOrEmpty((String)this.strWizardSessionId)) {
                log.error((Object)StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u5411\u5bfc\u4f1a\u8bdd\u6b65\u9aa4\u7f16\u53f7"));
                return false;
            }
            return true;
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected boolean FillTempDataPDEInfo(TempData tempData) {
        String strDERID = this.getWebContext().getSRFDERID();
        if (StringHelper.IsNullOrEmpty((String)strDERID)) {
            return false;
        }
        IPickupDEFHelper pickupDEFHelper = this.getPage().getDEHelper().FindPickupDEFHelper(strDERID);
        if (pickupDEFHelper == null) {
            DER1N der1n = new DER1N();
            CallResult callResult = this.getPage().getDAModelHelper().GetDER1N(strDERID, der1n);
            if (callResult.getRetCode() != 0) {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6DER1N[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strDERID, (Object)callResult.getErrorInfo()));
                return false;
            }
            IDEFHelper iDEFHelper = this.getPage().getDEHelper().GetDEFHelper(der1n.getMAJORKEYDEFNAME());
            if (iDEFHelper == null) {
                return false;
            }
            if (!(iDEFHelper instanceof IPickupDEFHelper)) {
                if (!(iDEFHelper instanceof IInheritDEFHelper)) return false;
                IInheritDEFHelper inheritDEFHelper = (IInheritDEFHelper)iDEFHelper;
                if (!(inheritDEFHelper.GetRelatedDEFHelper() instanceof IPickupDEFHelper)) return false;
                pickupDEFHelper = (IPickupDEFHelper)inheritDEFHelper.GetRelatedDEFHelper();
            } else {
                pickupDEFHelper = (IPickupDEFHelper)iDEFHelper;
            }
        }
        if (!pickupDEFHelper.GetRealDEFHelper().GetDTColumn().IsPKey()) {
            return false;
        }
        tempData.setPDEID(pickupDEFHelper.GetRealDEFHelper().getDEHelper().getId());
        tempData.setPTEMPKEYNAME(pickupDEFHelper.getName());
        String strKeyValue = this.getWebContext().GetParamValue(pickupDEFHelper.GetRelatedDEFHelper().getName());
        if (StringHelper.IsNullOrEmpty((String)strKeyValue)) {
            if (!pickupDEFHelper.GetRealDEFHelper().getDEHelper().IsIndexDE()) return false;
            Vector<DERINDEX> list = pickupDEFHelper.GetRealDEFHelper().getDEHelper().GetDERINDEXs(true);
            boolean bFind = false;
            for (DERINDEX dERINDEX : list) {
                IDEHelper iDEHelper = this.getPage().getDAModelStorage().FindDEHelper(dERINDEX.getDEID());
                if (iDEHelper == null) {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)dERINDEX.getDEID()));
                    continue;
                }
                strKeyValue = this.getWebContext().GetParamValue(iDEHelper.GetKeyDEFHelper().getName());
                if (StringHelper.IsNullOrEmpty((String)strKeyValue)) continue;
                bFind = true;
                break;
            }
            if (!bFind) {
                return false;
            }
        }
        tempData.setPTEMPKEYVALUE(strKeyValue);
        return true;
    }

    protected boolean OnLoadAction() {
        SRFExFormLoadResult loadResult = new SRFExFormLoadResult();
        WizardStepData wizardStepData = new WizardStepData();
        SRFExFormItemErrors formItemErrors = new SRFExFormItemErrors();
        if (!this.form1.FillDataEntity((BaseDataEntity)wizardStepData, true, formItemErrors, this.getPage().isControlValueFromUniqueId())) {
            String strNotSpecifyKey = this.GetLocalization("CTRL.FORMAH.NOTSPECIFYKEY", "\u6ca1\u6709\u6307\u5b9a\u6570\u636e\u952e\u503c");
            loadResult.setRetCode(4);
            loadResult.setJSCode(StringHelper.Format((String)"alert('%1$s');", (Object)strNotSpecifyKey));
            loadResult.AppendJSCode(WizardStepFormActionHelper.GetSetPageDataJS(""));
            loadResult.AppendJSCode(WizardStepFormActionHelper.GetSetPageInfoJS(strNotSpecifyKey));
            if (!StringHelper.IsNullOrEmpty((String)this.getWebContext().getSRFPageModel())) {
                loadResult.setExtInfo("pagemsg", strNotSpecifyKey);
                loadResult.setExtInfo("pageinfo", strNotSpecifyKey);
                loadResult.setExtInfo("pagedata", "");
            }
            this.getPage().Output(loadResult.ToJSONString());
            return true;
        }
        String strKeyName = this.getPage().getDEHelper().GetKeyDEFHelper().getName();
        String strWizardStepDataId = wizardStepData.GetParamStringValue(strKeyName, "");
        wizardStepData.Reset();
        wizardStepData.setWIZARDSTEPDATAID(strWizardStepDataId);
        IDEDataCtrl wizardStepDataDataCtrl = this.getPage().GetDEDataCtrl("DE0266");
        CallResult callResult = wizardStepDataDataCtrl.Get((BaseDataEntity)wizardStepData);
        loadResult.From(callResult);
        if (loadResult.getRetCode() != 0) {
            loadResult.AppendJSCode(WizardStepFormActionHelper.GetSetPageInfoJS(""));
            loadResult.AppendJSCode(WizardStepFormActionHelper.GetSetPageDataJS(""));
            if (!StringHelper.IsNullOrEmpty((String)this.getWebContext().getSRFPageModel())) {
                loadResult.setExtInfo("pageinfo", "");
                loadResult.setExtInfo("pagedata", "");
            }
            this.getPage().Output(loadResult.ToJSONString());
            return true;
        }
        BaseDataEntity dataEntity = BaseDataEntity.FromString((String)wizardStepData.getDEDATA());
        if (!StringHelper.IsNullOrEmpty((String)this.deWizardDetail.getDEACTIONID()) && (callResult = this.getPage().GetDEDataCtrl().Execute(this.deWizardDetail.getDEACTIONID(), dataEntity)).IsError()) {
            String strNotSpecifyKey = this.GetLocalization("CTRL.FORMAH.INPUTERROR", "\u52a0\u8f7d\u521d\u59cb\u5316\u903b\u8f91\u5931\u8d25");
            loadResult.setRetCode(5);
            loadResult.setJSCode(StringHelper.Format((String)"alert('%1$s');", (Object)strNotSpecifyKey));
            loadResult.AppendJSCode(WizardStepFormActionHelper.GetSetPageDataJS(""));
            loadResult.AppendJSCode(WizardStepFormActionHelper.GetSetPageInfoJS(strNotSpecifyKey));
            if (!StringHelper.IsNullOrEmpty((String)this.getWebContext().getSRFPageModel())) {
                loadResult.setExtInfo("pagemsg", strNotSpecifyKey);
                loadResult.setExtInfo("pageinfo", strNotSpecifyKey);
                loadResult.setExtInfo("pagedata", "");
            }
            this.getPage().Output(loadResult.ToJSONString());
        }
        dataEntity.SetParamValue(strKeyName, (Object)strWizardStepDataId);
        dataEntity.RemoveParam("WZPAGEID");
        this.OnLoadActionFillForm(dataEntity);
        this.form1.FillValueJSON(loadResult.getItems(), this.getPage().isControlValueFromUniqueId());
        loadResult.AppendJSBeforeCode(this.GetExtJSBeforeCode());
        loadResult.AppendJSCode(WizardStepFormActionHelper.GetSetPageInfoJS(""));
        loadResult.setUpdateFlag(true);
        loadResult.AppendJSCode(WizardStepFormActionHelper.GetSetPageDataJS(this.getPage().getDEHelper().GetDataInfo(dataEntity)));
        loadResult.AppendJSCode(WizardStepFormActionHelper.GetSetWFMainStateJS(this.getPage().getDEHelper(), dataEntity.GetParamStringValue(this.getPage().getDEHelper().GetKeyDEFHelper().getName(), "")));
        loadResult.AppendJSCode(this.GetExtJSCode());
        loadResult.setFormState(this.GetFormState(false, dataEntity));
        if (!StringHelper.IsNullOrEmpty((String)this.getWebContext().getSRFPageModel())) {
            loadResult.setExtInfo("pageinfo", "");
            loadResult.setExtInfo("pagedata", this.getPage().getDEHelper().GetDataInfo(dataEntity));
        }
        this.getPage().Output(this.OnLoadActionOutputResult(dataEntity, loadResult));
        return true;
    }

    protected String OnLoadActionOutputResult(BaseDataEntity dataEntity, SRFExFormLoadResult loadResult) {
        return loadResult.ToJSONString();
    }

    protected void OnLoadActionFillForm(BaseDataEntity dataEntity) {
        this.form1.FillDataEntityDV(dataEntity, true);
        if (this.getWebContext().getCopyMode()) {
            this.getDEDataCtrl().RemoveUncopyValue(dataEntity);
        }
        dataEntity.SetParamValue("SRFDAUPDATEDATE", dataEntity.GetParamValue("UPDATEDATE"));
        this.form1.FillByDataEntity(dataEntity, this.getWebContext().getCopyMode());
        if (this.disableItems != null) {
            for (String strFormItemId : this.disableItems) {
                this.form1.EnableFormItem(strFormItemId, false);
            }
        }
    }

    protected boolean OnSaveAction() {
        SRFExFormSaveResult saveResult = new SRFExFormSaveResult();
        CallResult callResult = null;
        SRFExFormItemErrors formItemErrors = new SRFExFormItemErrors();
        BaseDataEntity dataEntity = new BaseDataEntity();
        this.OnSaveActionBeforeFillDataEntity(dataEntity);
        if (!this.OnSaveActionFillDataEntity(dataEntity, formItemErrors)) {
            saveResult.setRetCode(5);
            formItemErrors.FillJSONs(saveResult.getItems());
            saveResult.AppendJSCode(WizardStepFormActionHelper.GetSetPageInfoJS(this.GetLocalization("CTRL.FORMAH.INPUTERROR", "\u8f93\u5165\u6709\u8bef\uff0c\u6570\u636e\u65e0\u6cd5\u4fdd\u5b58!")));
            this.getPage().Output(saveResult.ToJSONString());
            return true;
        }
        IDEDataCtrl wizardStepDataDataCtrl = this.getPage().GetDEDataCtrl("DE0266");
        this.form1.RemoveInvalidValue(dataEntity, false);
        this.SetPageInfo("");
        if (!StringHelper.IsNullOrEmpty((String)this.deWizardDetail.getSAVEDEACTIONID()) && (callResult = this.getPage().GetDEDataCtrl().Execute(this.deWizardDetail.getSAVEDEACTIONID(), dataEntity)).IsError()) {
            String strErrorFormat = this.GetLocalization("CTRL.FORMAH.DATASAVEFAILED", "\u6570\u636e\u65e0\u6cd5\u4fdd\u5b58\uff0c%1$s");
            saveResult.AppendJSBeforeCode(this.GetExtJSBeforeCode());
            if (callResult.IsUserError()) {
                this.SetPageInfo("");
                this.FillFormUserErrors(this.form1, formItemErrors, callResult);
                saveResult.setRetCode(5);
                formItemErrors.FillJSONs(saveResult.getItems());
                saveResult.AppendJSCode(WizardStepFormActionHelper.GetSetPageInfoJS(StringHelper.Format((String)strErrorFormat, (Object)callResult.getErrorInfo())));
            } else {
                saveResult.AppendJSCode(WizardStepFormActionHelper.GetSetPageInfoJS(StringHelper.Format((String)strErrorFormat, (Object)callResult.getErrorInfo())));
            }
            this.getPage().Output(saveResult.ToJSONString());
            return true;
        }
        String strKeyName = this.getPage().getDEHelper().GetKeyDEFHelper().getName();
        String strWizardStepDataId = dataEntity.GetParamStringValue(strKeyName, "");
        dataEntity.RemoveParam(strKeyName);
        WizardStepData wizardStepData = new WizardStepData();
        wizardStepData.setWIZARDSTEPDATAID(strWizardStepDataId);
        callResult = wizardStepDataDataCtrl.Get((BaseDataEntity)wizardStepData);
        saveResult.From(callResult);
        if (saveResult.getRetCode() != 0) {
            String strErrorFormat = this.GetLocalization("CTRL.FORMAH.DATASAVEFAILED", "\u6570\u636e\u65e0\u6cd5\u4fdd\u5b58\uff0c%1$s");
            saveResult.AppendJSBeforeCode(this.GetExtJSBeforeCode());
            if (callResult.IsUserError()) {
                this.SetPageInfo("");
                this.FillFormUserErrors(this.form1, formItemErrors, callResult);
                saveResult.setRetCode(5);
                formItemErrors.FillJSONs(saveResult.getItems());
                saveResult.AppendJSCode(WizardStepFormActionHelper.GetSetPageInfoJS(StringHelper.Format((String)strErrorFormat, (Object)callResult.getErrorInfo())));
            } else {
                saveResult.AppendJSCode(WizardStepFormActionHelper.GetSetPageInfoJS(StringHelper.Format((String)strErrorFormat, (Object)callResult.getErrorInfo())));
            }
        }
        BaseDataEntity lastDataEntity = BaseDataEntity.FromString((String)wizardStepData.getDEDATA());
        Hashtable paramList = lastDataEntity.getParamList();
        for (Object objKey : paramList.keySet()) {
            String strKey = (String)objKey;
            if (dataEntity.ContainesParam(strKey)) continue;
            dataEntity.SetParamValue(strKey, lastDataEntity.GetParamValue(strKey));
        }
        wizardStepData.setDEDATA(BaseDataEntity.ToString((BaseDataEntity)dataEntity, (boolean)true));
        callResult = wizardStepDataDataCtrl.Save(false, (BaseDataEntity)wizardStepData);
        if (callResult.getRetCode() == 0) {
            dataEntity.SetParamValue(strKeyName, (Object)strWizardStepDataId);
            dataEntity.SetParamValue("WZPAGEID", (Object)dataEntity.GetParamStringValue("WZPAGEID", this.deWizardDetail.getDEFAULTWZPAGEID()));
            callResult = this.OnSaveActionAfterUpdate(callResult, dataEntity);
        }
        saveResult.From(callResult);
        if (saveResult.getRetCode() != 0) {
            String strErrorFormat = this.GetLocalization("CTRL.FORMAH.DATASAVEFAILED", "\u6570\u636e\u65e0\u6cd5\u4fdd\u5b58\uff0c%1$s");
            saveResult.AppendJSBeforeCode(this.GetExtJSBeforeCode());
            if (callResult.IsUserError()) {
                this.SetPageInfo("");
                this.FillFormUserErrors(this.form1, formItemErrors, callResult);
                saveResult.setRetCode(5);
                formItemErrors.FillJSONs(saveResult.getItems());
                saveResult.AppendJSCode(WizardStepFormActionHelper.GetSetPageInfoJS(StringHelper.Format((String)strErrorFormat, (Object)callResult.getErrorInfo())));
            } else {
                saveResult.AppendJSCode(WizardStepFormActionHelper.GetSetPageInfoJS(StringHelper.Format((String)strErrorFormat, (Object)callResult.getErrorInfo())));
            }
        } else {
            this.OnSaveActionFillForm(dataEntity);
            this.form1.FillValueJSON(saveResult.getItems(), this.getPage().isControlValueFromUniqueId());
            saveResult.AppendJSBeforeCode(this.GetExtJSBeforeCode());
            saveResult.AppendJSCode(WizardStepFormActionHelper.GetSetPageDataJS(this.getPage().getDEHelper().GetDataInfo(dataEntity)));
            saveResult.AppendJSCode(WizardStepFormActionHelper.GetSetWFMainStateJS(this.getPage().getDEHelper(), dataEntity.GetParamStringValue(this.getPage().getDEHelper().GetKeyDEFHelper().getName(), "")));
            String strInfoFormat = this.GetLocalization("CTRL.FORMAH.DATASAVEDSUCCESSFULLY", "\u6570\u636e\u4fdd\u5b58\u6210\u529f!");
            saveResult.AppendJSCode(this.GetSetPageInfoJSEx(strInfoFormat));
            saveResult.AppendJSCode(this.GetExtJSCode());
            saveResult.setUpdateFlag(true);
            if (!StringHelper.IsNullOrEmpty((String)this.getWebContext().getSRFPageModel())) {
                saveResult.setExtInfo("pageinfo", strInfoFormat);
                saveResult.setExtInfo("pagedata", this.getPage().getDEHelper().GetDataInfo(dataEntity));
            }
            saveResult.setFormState(this.GetFormState(false, dataEntity));
            saveResult.setSaveTag(this.getWebContext().GetPostValue("SRFSAVETAG"));
        }
        this.getPage().Output(this.OnSaveActionOutputResult(dataEntity, saveResult));
        return true;
    }

    protected void OnSaveActionFillForm(BaseDataEntity dataEntity) {
        dataEntity.SetParamValue("SRFDAUPDATEDATE", dataEntity.GetParamValue("UPDATEDATE"));
        this.form1.FillByDataEntity(dataEntity, false);
        if (this.IsDisableAllItems(dataEntity)) {
            this.form1.EnableAllFormItems(false);
        } else {
            this.form1.EnableFormItems(false);
        }
    }

    protected void OnSaveActionBeforeFillDataEntity(BaseDataEntity dataEntity) {
    }

    protected boolean IsFormContainKey(BaseDataEntity dataEntity) {
        return this.getForm().IsContainerKeyValue(dataEntity);
    }

    protected boolean OnSaveActionFillDataEntity(BaseDataEntity dataEntity, SRFExFormItemErrors formItemErrors) {
        return this.getForm().FillDataEntity(dataEntity, false, formItemErrors, this.getPage().isControlValueFromUniqueId());
    }

    protected String GetUpdateDataAction() {
        String strAction = "";
        try {
            strAction = this.getFormView() != null && !this.getFormView().isUPDATEMODENull() ? this.getFormView().getUPDATEMODE() : "DEFAULT";
        }
        catch (Exception e) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u66f4\u65b0\u64cd\u4f5c\u6570\u636e\u8bbf\u95ee\u64cd\u4f5c\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)e.getMessage()), (Throwable)e);
        }
        if (StringHelper.IsNullOrEmpty((String)strAction) || StringHelper.Compare((String)strAction, (String)"DEFAULT", (boolean)true) == 0 || StringHelper.Compare((String)strAction, (String)"WFACTION", (boolean)true) == 0) {
            strAction = "UPDATE";
        }
        return strAction;
    }

    protected CallResult OnTestDataAction(BaseDataEntity dataEntity, String strAction) {
        return this.getPage().getDEHelper().GetDataAccHelper().Test((ISRFDAWebContext)this.getWebContext(), dataEntity, strAction);
    }

    protected CallResult OnSaveActionAfterInsert(CallResult callResult, BaseDataEntity dataEntity) {
        String strCopyId = this.getWebContext().GetPostValue("SRFCOPYID");
        if (!StringHelper.IsNullOrEmpty((String)strCopyId)) {
            Object objSrcKey = this.getPage().getDEHelper().GetKeyDEFHelper().GetDEFValue(strCopyId);
            callResult = this.getDEDataCtrl().CopyDetail(dataEntity, objSrcKey);
        }
        return callResult;
    }

    protected CallResult OnSaveActionAfterUpdate(CallResult callResult, BaseDataEntity dataEntity) {
        return callResult;
    }

    protected String OnSaveActionOutputResult(BaseDataEntity dataEntity, SRFExFormSaveResult saveResult) {
        return saveResult.ToJSONString();
    }

    protected boolean IsDisableAllItems(BaseDataEntity dataEntity) {
        boolean bRet = false;
        if (this.formView != null) {
            bRet = this.formView.GetFormProperty("DISABLEITEMS", bRet);
        }
        return this.getPage().getFormParam((SRFExBaseForm)this.form1, "DISABLEITEMS", bRet);
    }

    protected void FillFormUserErrors(SRFExForm form1, SRFExFormItemErrors formItemErrors, CallResult callResult) {
        Object objDBResult = callResult.getUserObject();
        if (objDBResult != null && objDBResult instanceof DBResult) {
            DBResult result = (DBResult)objDBResult;
            if (result.getOutValues().containsKey("SRF_TAG")) {
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
            } else {
                this.SetPageInfo(StringHelper.Format((String)"\u65e0\u6cd5\u4fdd\u5b58\u6570\u636e\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
        }
    }

    protected SRFDAPage getPage() {
        return (SRFDAPage)this.page;
    }

    protected SRFDAWebContext getWebContext() {
        return (SRFDAWebContext)super.getWebContext();
    }

    protected Form getFormView() {
        if (this.formView != null) {
            return this.formView;
        }
        Object obj = this.getPage().getPageParam(this.mainPanel.getID().toUpperCase());
        if (obj != null && obj instanceof Form) {
            this.formView = (Form)obj;
            return this.formView;
        }
        obj = this.getPage().getPageParam("FORMVIEW");
        if (obj == null) {
            return null;
        }
        if (obj instanceof Form) {
            this.formView = (Form)obj;
        }
        return this.formView;
    }

    protected IDEDataCtrl getDEDataCtrl() {
        return this.getPage().GetDEDataCtrl();
    }

    protected String GetSetPageInfoJSEx(String strDefaultInfo) {
        if (StringHelper.IsNullOrEmpty((String)this.strPageInfo)) {
            return WizardStepFormActionHelper.GetSetPageInfoJS(strDefaultInfo);
        }
        return WizardStepFormActionHelper.GetSetPageInfoJS(this.strPageInfo);
    }

    protected String GetSetPageInfoJS() {
        return WizardStepFormActionHelper.GetSetPageInfoJS(this.strPageInfo);
    }

    protected static String GetSetPageInfoJS(String strInfo) {
        if (!StringHelper.IsNullOrEmpty((String)strInfo)) {
            strInfo = strInfo.replace("\r", "<br>");
            strInfo = strInfo.replace("\n", "<br>");
            strInfo = strInfo.replace("\\", "\\\\");
        }
        return StringHelper.Format((String)"$P.setpageinfo(\"%1$s\");", (Object)WebUtility.GetJSONText((String)strInfo, (boolean)false));
    }

    protected static String GetSetPageDataJS(String strData) {
        if (!StringHelper.IsNullOrEmpty((String)strData)) {
            strData = strData.replace("\\", "\\\\");
        }
        return StringHelper.Format((String)"$P.setpagedata(\"%1$s\");", (Object)WebUtility.GetJSONText((String)strData, (boolean)false));
    }

    protected static String GetSetWFMainStateJS(IDEHelper iDEHelper, String strKeyData) {
        if (!iDEHelper.IsEnableWF()) {
            return "";
        }
        if (iDEHelper.GetDEWF() == null || StringHelper.IsNullOrEmpty((String)iDEHelper.GetDEWF().getMSCLID())) {
            return "";
        }
        if (!StringHelper.IsNullOrEmpty((String)strKeyData)) {
            strKeyData = strKeyData.replace("\\", "\\\\");
        }
        JSONObject jo = new JSONObject();
        jo.put("srfdeid", (Object)iDEHelper.getId());
        jo.put(iDEHelper.GetKeyDEFHelper().getName().toLowerCase(), (Object)strKeyData);
        return StringHelper.Format((String)"$P.setwfmainstate(%1$s);", (Object)jo.toString());
    }

    protected void SetPageInfo(String strPageInfo) {
        this.strPageInfo = strPageInfo;
    }

    protected void AppendExtJSCode(String strCode) {
        if (this.script == null) {
            this.script = new StringBuilderEx();
        }
        this.script.Append(strCode);
    }

    protected String GetExtJSCode() {
        if (this.script == null) {
            return "";
        }
        return this.script.toString();
    }

    protected void AppendExtJSBeforeCode(String strCode) {
        if (this.beforeScript == null) {
            this.beforeScript = new StringBuilderEx();
        }
        this.beforeScript.Append(strCode);
    }

    protected String GetExtJSBeforeCode() {
        if (this.beforeScript == null) {
            return "";
        }
        return this.beforeScript.toString();
    }

    protected String GetDataLockKey(BaseDataEntity dataEntity) {
        try {
            return this.getPage().getDEHelper().GetDataLockKey((ISRFDAWebContext)this.getWebContext(), dataEntity);
        }
        catch (Exception ex) {
            this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u6570\u636e\u5bf9\u8c61\u9501\u94a5\u5319\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), ex);
            return "";
        }
    }

    protected String GetFormState() {
        String strFormState = this.getPage().getPageParam("PAGE.FORMSTATE", "");
        if (StringHelper.IsNullOrEmpty((String)strFormState)) {
            String strUpdateAction = this.GetUpdateDataAction();
            strFormState = StringHelper.Format((String)"%1$s|%2$s|%3$s", (Object)"CREATE", (Object)strUpdateAction, (Object)"DELETE");
            String strDEDataActions = this.getPage().getDEHelper().GetDataAccHelper().GetDataActions();
            if (!StringHelper.IsNullOrEmpty((String)strDEDataActions)) {
                strFormState = String.valueOf(strFormState) + "|";
                strFormState = String.valueOf(strFormState) + strDEDataActions;
            }
        }
        return strFormState;
    }

    protected boolean IsDataActionTestDataLock(String strDataAction) {
        return true;
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
            if (!StringHelper.IsNullOrEmpty((String)(strAction = strAction.trim())) && !jsonObject.has(strAction.toLowerCase())) {
                CallResult callResult = null;
                CallResult dataLockTestResult = null;
                boolean bTestDataLock = this.TestDataLock();
                if (bTestDataLock) {
                    dataLockTestResult = this.getDEDataCtrl().TestDataLock(dataEntity, this.GetDataLockKey(dataEntity));
                }
                if (StringHelper.Compare((String)strAction, (String)"UPDATE", (boolean)true) == 0 || StringHelper.Compare((String)strAction, (String)"WFSTART", (boolean)true) == 0) {
                    if (bCreate) {
                        callResult = this.OnTestDataAction(dataEntity, "CREATE");
                        bTestDataLock = false;
                    } else {
                        callResult = this.OnTestDataAction(dataEntity, strAction);
                    }
                } else {
                    callResult = this.OnTestDataAction(dataEntity, strAction);
                    if (StringHelper.Compare((String)strAction, (String)"CREATE", (boolean)true) == 0) {
                        bTestDataLock = false;
                    }
                }
                if (callResult.getRetCode() == 0 && bTestDataLock) {
                    callResult = dataLockTestResult;
                }
                if (callResult == null || callResult.getRetCode() != 0) {
                    jsonObject.put(strAction.toLowerCase(), false);
                } else {
                    jsonObject.put(strAction.toLowerCase(), true);
                }
            }
            ++i;
        }
        if (bCreate && jsonObject.has("DELETE".toLowerCase())) {
            jsonObject.remove("DELETE".toLowerCase());
            jsonObject.put("DELETE".toLowerCase(), false);
        }
        this.OnSetMainFormState(jsonObject, bCreate, dataEntity);
        return jsonObject;
    }

    protected void OnSetMainFormState(JSONObject jsonObject, boolean bCreate, BaseDataEntity dataEntity) {
    }

    protected boolean TestDataLock() {
        return true;
    }

    protected boolean IsUpdateMode() {
        return this.bUpdateFlag;
    }

    protected final String GetSaveActionUpdateMode() throws Exception {
        return this.OnGetSaveActionUpdateMode();
    }

    protected String OnGetSaveActionUpdateMode() throws Exception {
        if (this.getFormView() != null && !this.getFormView().isUPDATEMODENull()) {
            return this.getFormView().getUPDATEMODE();
        }
        return "DEFAULT";
    }

    protected boolean IsEnableNew() {
        if (this.getFormView() != null && !this.getFormView().isENABLENEWNull()) {
            return this.getFormView().getENABLENEW();
        }
        return true;
    }

    protected boolean OnItemUpdateAction(String strAction) {
        String strMessage;
        SRFExFormLoadResult loadResult = new SRFExFormLoadResult();
        FIUpdate fiUpdate = this.getPage().getDAModelStorage().FindFIUpdate(this.getPage().getPageDataEntityId(), strAction);
        if (fiUpdate == null) {
            loadResult.setRetCode(1);
            loadResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u8868\u5355\u9879\u586b\u5145\u6a21\u5f0f[%1$s-%2$s]", (Object)this.getPage().getPageDataEntityId(), (Object)strAction));
            this.getPage().PageLog((Object)this, 1, loadResult.getErrorInfo());
            this.getPage().Output(loadResult.ToJSONString());
            return true;
        }
        String strActionMode = fiUpdate.GetParamStringValue("ACTIONMODE", "");
        BaseDataEntity dataEntity = new BaseDataEntity();
        SRFExFormItemErrors formItemErrors = new SRFExFormItemErrors();
        if (!this.form1.FillDataEntity(dataEntity, true, formItemErrors, this.getPage().isControlValueFromUniqueId())) {
            loadResult.setRetCode(5);
            if (!StringHelper.IsNullOrEmpty((String)this.getWebContext().getSRFPageModel())) {
                loadResult.setExtInfo("pagedata", "");
            }
            this.getPage().Output(loadResult.ToJSONString());
            return true;
        }
        CallResult callResult = this.getDEDataCtrl().CustomCall(strActionMode, dataEntity);
        if (callResult.IsError()) {
            loadResult.From(callResult);
            loadResult.AppendJSCode(WizardStepFormActionHelper.GetSetPageDataJS(""));
            loadResult.AppendJSCode(WizardStepFormActionHelper.GetSetPageInfoJS(StringHelper.Format((String)"\u6267\u884c\u903b\u8f91\u64cd\u4f5c[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strActionMode, (Object)callResult.getErrorInfo())));
            this.getPage().Output(loadResult.ToJSONString());
            return true;
        }
        String strInfoField = fiUpdate.getInfoField();
        if (!StringHelper.IsNullOrEmpty((String)strInfoField) && !StringHelper.IsNullOrEmpty((String)(strMessage = dataEntity.GetParamStringValue(strInfoField, "")))) {
            loadResult.AppendJSCode(BrowserJSHelper.getAlertMessageScript((String)strMessage));
        }
        this.getForm().FillByDataEntity(dataEntity, false);
        this.getForm().FillValueJSON(loadResult.getItems(), this.getPage().isControlValueFromUniqueId(), fiUpdate.getRelatedFields());
        this.getPage().Output(loadResult.ToJSONString());
        return true;
    }

    protected boolean IsEnableModifyPData() {
        if (this.formView != null) {
            return this.formView.GetFormProperty("MODIFYPDATA", false);
        }
        return false;
    }

    protected boolean OnCustomAction(String strAction) {
        if (StringHelper.Compare((String)strAction, (String)"srfbehavior", (boolean)true) == 0) {
            this.OnDEBehavior(this.getWebContext().GetPostValue("srfbehaviorid"));
            return true;
        }
        return super.OnCustomAction(strAction);
    }

    protected boolean OnDEBehaviorFillDataEntity(BaseDataEntity dataEntity, SRFExFormItemErrors formItemErrors) {
        return this.getForm().FillDataEntity(dataEntity, true, formItemErrors);
    }

    protected void OnDEBehavior(String strDEBehaviorId) {
        CallResult callResult;
        SRFExFormCustomCallResult loadResult = new SRFExFormCustomCallResult();
        DEBehavior deBehavior = this.getWebContext().getGlobalHelper().getDAModelStorage().FindDEBehavior(strDEBehaviorId);
        if (deBehavior == null) {
            loadResult.setRetCode(1);
            loadResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u754c\u9762\u884c\u4e3a[%1$s]", (Object)strDEBehaviorId));
            this.getPage().Output(loadResult.ToJSONString());
            return;
        }
        if (!StringHelper.IsNullOrEmpty((String)deBehavior.getRESOURCEID()) && !this.getWebContext().GetUserPrivilegeMgr().Test((SRFExWebContext)this.getWebContext(), deBehavior.getRESOURCEID())) {
            loadResult.setRetCode(2);
            loadResult.setErrorInfo(StringHelper.Format((String)"\u5b9e\u4f53\u754c\u9762\u884c\u4e3a[%1$s]\u6743\u9650\u4e0d\u8db3", (Object)deBehavior.getDEACTIONNAME()));
            this.getPage().Output(loadResult.ToJSONString());
            return;
        }
        if (StringHelper.IsNullOrEmpty((String)deBehavior.getDEACTIONID())) {
            loadResult.setRetCode(1);
            loadResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u754c\u9762\u884c\u4e3a[%1$s]\u6240\u5bf9\u5e94\u7684\u5b9e\u4f53\u64cd\u4f5c", (Object)deBehavior.getDEACTIONNAME()));
            this.getPage().Output(loadResult.ToJSONString());
            return;
        }
        DEAction deAction = this.getPage().getDEHelper().GetDEAction(deBehavior.getDEACTIONID());
        if (deAction == null) {
            loadResult.setRetCode(1);
            loadResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u64cd\u4f5c\u884c\u4e3a[%1$s]", (Object)deBehavior.getDEACTIONID()));
            this.getPage().Output(loadResult.ToJSONString());
            return;
        }
        SRFExFormItemErrors formItemErrors = new SRFExFormItemErrors();
        BaseDataEntity dataEntity = new BaseDataEntity();
        this.OnSaveActionBeforeFillDataEntity(dataEntity);
        if (!this.OnDEBehaviorFillDataEntity(dataEntity, formItemErrors)) {
            loadResult.setRetCode(5);
            formItemErrors.FillJSONs(loadResult.getItems());
            loadResult.AppendJSCode(WizardStepFormActionHelper.GetSetPageInfoJS(this.GetLocalization("CTRL.FORMAH.INPUTERROR", "\u8f93\u5165\u6709\u8bef\uff0c\u6570\u636e\u65e0\u6cd5\u64cd\u4f5c!")));
            this.getPage().Output(loadResult.ToJSONString());
            return;
        }
        if (!StringHelper.IsNullOrEmpty((String)deAction.getDEDATAACTION()) && (callResult = this.OnTestDataAction(dataEntity, deAction.getDEDATAACTION())).getRetCode() != 0) {
            loadResult.From(callResult);
            loadResult.AppendJSCode(WizardStepFormActionHelper.GetSetPageDataJS(""));
            loadResult.AppendJSCode(WizardStepFormActionHelper.GetSetPageInfoJS(callResult.getErrorInfo()));
            this.getPage().Output(loadResult.ToJSONString());
            return;
        }
        IDEDataCtrl iDEDataCtrl = this.getDEDataCtrl();
        DefaultTransactionManager transactionManager = new DefaultTransactionManager();
        transactionManager.Init((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper());
        transactionManager.Register(iDEDataCtrl);
        CallResult callResult2 = iDEDataCtrl.Execute(deAction, dataEntity);
        if (callResult2.IsError()) {
            transactionManager.Rollback();
        } else {
            transactionManager.Commit();
        }
        if (callResult2.getRetCode() != 0) {
            if (callResult2.IsUserError()) {
                callResult2.setRetCode(5);
                formItemErrors.FillJSONs(loadResult.getItems());
            }
            loadResult.From(callResult2);
            loadResult.AppendJSCode(WizardStepFormActionHelper.GetSetPageDataJS(""));
            loadResult.AppendJSCode(WizardStepFormActionHelper.GetSetPageInfoJS(StringHelper.Format((String)"\u6267\u884c\u64cd\u4f5c\u5931\u8d25\uff0c%1$s", (Object)callResult2.getErrorInfo())));
            if (!StringHelper.IsNullOrEmpty((String)this.getWebContext().getSRFPageModel())) {
                loadResult.setExtInfo("pageinfo", StringHelper.Format((String)"\u6267\u884c\u64cd\u4f5c\u5931\u8d25\uff0c%1$s", (Object)callResult2.getErrorInfo()));
                loadResult.setExtInfo("pagedata", "");
            }
        } else {
            if (!StringHelper.IsNullOrEmpty((String)deBehavior.getSUCCESSINFO())) {
                loadResult.AppendJSCode(StringHelper.Format((String)"alert('%1$s');", (Object)deBehavior.getSUCCESSINFO()));
            }
            if (!StringHelper.IsNullOrEmpty((String)deBehavior.getSUCCESSCODE())) {
                loadResult.AppendJSCode(deBehavior.getSUCCESSCODE());
            }
            if (deBehavior.getRELOADDATA()) {
                loadResult.setFillForm(true);
                this.OnDEBehaviorFillForm(dataEntity);
                this.form1.FillValueJSON(loadResult.getItems(), this.getPage().isControlValueFromUniqueId());
                if (!StringHelper.IsNullOrEmpty((String)this.getWebContext().getSRFPageModel())) {
                    loadResult.setExtInfo("pageinfo", "");
                    loadResult.setExtInfo("pagedata", this.getPage().getDEHelper().GetDataInfo(dataEntity));
                }
            }
        }
        this.getPage().Output(loadResult.ToJSONString());
    }

    protected void OnDEBehaviorFillForm(BaseDataEntity dataEntity) {
        this.form1.FillDataEntityDV(dataEntity, true);
        if (this.getWebContext().getCopyMode()) {
            this.getDEDataCtrl().RemoveUncopyValue(dataEntity);
        }
        dataEntity.SetParamValue("SRFDAUPDATEDATE", dataEntity.GetParamValue("UPDATEDATE"));
        this.form1.FillByDataEntity(dataEntity, this.getWebContext().getCopyMode());
        if (!this.getWebContext().getCopyMode() && this.IsDisableAllItems(dataEntity)) {
            this.form1.EnableAllFormItems(false);
        } else {
            this.form1.EnableFormItems(this.getWebContext().getCopyMode());
            DEDSCtrl deDSCtrl = this.getPage().getDEHelper().GetDataAccHelper().FindFieldCtrl(dataEntity);
            if (deDSCtrl != null) {
                this.form1.DisableFormItems(deDSCtrl.getCtrlFields(), StringHelper.Compare((String)deDSCtrl.getFIELDCTRLMODE(), (String)"DENY", (boolean)true) == 0);
            }
        }
    }

    public String GetLocalization(String strResId, String strDefault) {
        return this.getPage().GetLocalization(strResId, strDefault);
    }
}
