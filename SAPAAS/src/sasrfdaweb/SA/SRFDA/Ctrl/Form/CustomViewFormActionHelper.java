/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.Form.SRFExFormItemErrors
 *  SA.SRFramework.WebEx.Form.SRFExFormLoadResult
 *  SA.SRFramework.WebEx.Form.SRFExFormSaveResult
 *  SA.SRFramework.WebEx.Script.BrowserJSHelper
 */
package SA.SRFDA.Ctrl.Form;

import SA.SRFDA.Ctrl.Form.BaseDAFormActionHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Form.SRFExFormItemErrors;
import SA.SRFramework.WebEx.Form.SRFExFormLoadResult;
import SA.SRFramework.WebEx.Form.SRFExFormSaveResult;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;

public class CustomViewFormActionHelper
extends BaseDAFormActionHelper {
    @Override
    protected boolean OnLoadDefaultAction() {
        CallResult callResult;
        SRFExFormLoadResult loadResult = new SRFExFormLoadResult();
        BaseDataEntity dataEntity = new BaseDataEntity();
        SRFExFormItemErrors formItemErrors = new SRFExFormItemErrors();
        if (!this.form1.FillDataEntity(dataEntity, true, formItemErrors, this.getPage().isControlValueFromUniqueId())) {
            String strNotSpecifyKey = this.getPage().GetLocalization("CTRL.FORMAH.NOTSPECIFYKEY", "\u6ca1\u6709\u6307\u5b9a\u6570\u636e\u952e\u503c");
            loadResult.setRetCode(4);
            loadResult.setJSCode(StringHelper.Format((String)"alert('%1$s');", (Object)strNotSpecifyKey));
            loadResult.AppendJSCode(CustomViewFormActionHelper.GetSetPageDataJS(""));
            loadResult.AppendJSCode(CustomViewFormActionHelper.GetSetPageInfoJS(strNotSpecifyKey));
            if (!StringHelper.IsNullOrEmpty((String)this.getWebContext().getSRFPageModel())) {
                loadResult.setExtInfo("pagemsg", strNotSpecifyKey);
                loadResult.setExtInfo("pageinfo", strNotSpecifyKey);
                loadResult.setExtInfo("pagedata", "");
            }
            this.getPage().Output(loadResult.ToJSONString());
            return true;
        }
        Object objKeySessionValue = this.getWebContext().GetSessionValue(this.getPage().getDEHelper().GetKeyDEFHelper().getName());
        String strKeyData = "";
        if (objKeySessionValue != null) {
            strKeyData = objKeySessionValue.toString();
            dataEntity.SetParamValue(this.getPage().getDEHelper().GetKeyDEFHelper().getName(), (Object)strKeyData);
        }
        if ((callResult = this.getDEDataCtrl().Get(dataEntity)).getRetCode() != 0) {
            if (callResult.getRetCode() == 3 && this.getPage().getPageParam("EMBEDEDIT", false)) {
                return this.OnLoadDefaultAction();
            }
            if (callResult.IsUserError()) {
                callResult.setRetCode(5);
                formItemErrors.FillJSONs(loadResult.getItems());
            }
            loadResult.From(callResult);
            loadResult.AppendJSCode(CustomViewFormActionHelper.GetSetPageDataJS(""));
            loadResult.AppendJSCode(CustomViewFormActionHelper.GetSetPageInfoJS("\u6570\u636e\u67e5\u8be2\u5931\u8d25"));
            if (!StringHelper.IsNullOrEmpty((String)this.getWebContext().getSRFPageModel())) {
                loadResult.setExtInfo("pageinfo", "\u6570\u636e\u67e5\u8be2\u5931\u8d25");
                loadResult.setExtInfo("pagedata", "");
            }
        } else {
            this.OnLoadActionFillForm(dataEntity);
            if (this.disableItems != null) {
                for (String strFormItemId : this.disableItems) {
                    this.form1.EnableFormItem(strFormItemId, false);
                }
            }
            this.form1.FillValueJSON(loadResult.getItems(), this.getPage().isControlValueFromUniqueId());
            if (this.getWebContext().getCopyMode()) {
                loadResult.setUpdateFlag(false);
                loadResult.setCopyId(strKeyData);
                loadResult.AppendJSCode(CustomViewFormActionHelper.GetSetPageDataJS(""));
                loadResult.setCopyMode(true);
                loadResult.setFormState(this.GetFormState(true, dataEntity));
            } else {
                loadResult.setUpdateFlag(true);
                loadResult.AppendJSBeforeCode(this.GetExtJSBeforeCode());
                loadResult.AppendJSCode(CustomViewFormActionHelper.GetSetPageInfoJS(""));
                loadResult.AppendJSCode(CustomViewFormActionHelper.GetSetPageDataJS(this.getPage().getDEHelper().GetDataInfo(dataEntity)));
                loadResult.AppendJSCode(this.GetExtJSCode());
                loadResult.setFormState(this.GetFormState(false, dataEntity));
                if (!StringHelper.IsNullOrEmpty((String)this.getWebContext().getSRFPageModel())) {
                    loadResult.setExtInfo("pageinfo", "");
                    loadResult.setExtInfo("pagedata", this.getPage().getDEHelper().GetDataInfo(dataEntity));
                }
                loadResult.setJSCode(StringHelper.Format((String)"onpreview();"));
            }
        }
        this.getPage().Output(loadResult.ToJSONString());
        return true;
    }

    @Override
    protected String OnSaveActionOutputResult(BaseDataEntity dataEntity, SRFExFormSaveResult saveResult) {
        if (saveResult.getRetCode() != 0) {
            return super.OnSaveActionOutputResult(dataEntity, saveResult);
        }
        String strAppUITheme = dataEntity.GetParamStringValue("APPUITHEME", "");
        String strLocalization = dataEntity.GetParamStringValue("LANGUAGE", "");
        String strCurAppUITheme = this.getWebContext().getCurAppUITheme();
        String strCurLocalization = this.getWebContext().getLocalization();
        String strRetValue = "'none'";
        if (StringHelper.Compare((String)strAppUITheme, (String)strCurAppUITheme, (boolean)true) != 0) {
            this.getWebContext().setCurAppUITheme(strAppUITheme);
            strRetValue = "'ok'";
        }
        if (StringHelper.Compare((String)strLocalization, (String)strCurLocalization, (boolean)true) != 0) {
            this.getWebContext().setLocalization(strLocalization);
            strRetValue = "'ok'";
        }
        saveResult.AppendJSCode(BrowserJSHelper.getResetDialogReturnValue());
        saveResult.AppendJSCode(BrowserJSHelper.getSetDialogReturnValue((String)"ret", (String)strRetValue));
        saveResult.AppendJSCode(BrowserJSHelper.getCloseWindowScript());
        return super.OnSaveActionOutputResult(dataEntity, saveResult);
    }
}

