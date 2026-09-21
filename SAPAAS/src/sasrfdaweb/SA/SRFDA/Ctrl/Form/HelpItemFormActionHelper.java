/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.WebEx.Form.SRFExFormItemErrors
 *  SA.SRFramework.WebEx.Form.SRFExFormLoadResult
 */
package SA.SRFDA.Ctrl.Form;

import SA.SRFDA.Ctrl.Form.BaseDAFormActionHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.WebEx.Form.SRFExFormItemErrors;
import SA.SRFramework.WebEx.Form.SRFExFormLoadResult;

public class HelpItemFormActionHelper
extends BaseDAFormActionHelper {
    @Override
    protected boolean OnLoadAction() {
        SRFExFormLoadResult loadResult = new SRFExFormLoadResult();
        BaseDataEntity dataEntity = new BaseDataEntity();
        SRFExFormItemErrors formItemErrors = new SRFExFormItemErrors();
        if (!this.form1.FillDataEntity(dataEntity, true, formItemErrors)) {
            loadResult.setRetCode(4);
            loadResult.setJSCode("alert('\u6ca1\u6709\u6307\u5b9a\u6570\u636e\u952e\u503c');");
            loadResult.AppendJSCode(HelpItemFormActionHelper.GetSetPageDataJS(""));
            loadResult.AppendJSCode(HelpItemFormActionHelper.GetSetPageInfoJS("\u6ca1\u6709\u6307\u5b9a\u6570\u636e\u952e\u503c"));
            this.getPage().Output(loadResult.ToJSONString());
            return true;
        }
        CallResult callResult = this.OnTestDataAction(dataEntity, "READ");
        if (callResult.getRetCode() != 0) {
            loadResult.From(callResult);
            loadResult.AppendJSCode(HelpItemFormActionHelper.GetSetPageDataJS(""));
            loadResult.AppendJSCode(HelpItemFormActionHelper.GetSetPageInfoJS(callResult.getErrorInfo()));
            this.getPage().Output(loadResult.ToJSONString());
            return true;
        }
        String strKeyData = dataEntity.GetParamStringValue(this.getPage().getDEHelper().GetKeyDEFHelper().getName(), "");
        callResult = this.getDEDataCtrl().Get(dataEntity);
        dataEntity.SetParamValue("PAGEID", (Object)this.getWebContext().GetParamValue("PAGEID"));
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
            loadResult.AppendJSCode(HelpItemFormActionHelper.GetSetPageDataJS(""));
            loadResult.setCopyMode(true);
            loadResult.setFormState(this.GetFormState(true, dataEntity));
        } else {
            loadResult.setUpdateFlag(true);
            loadResult.AppendJSCode(HelpItemFormActionHelper.GetSetPageInfoJS(""));
            loadResult.AppendJSCode(HelpItemFormActionHelper.GetSetPageDataJS(this.getPage().getDEHelper().GetDataInfo(dataEntity)));
            loadResult.setFormState(this.GetFormState(false, dataEntity));
        }
        this.getPage().Output(loadResult.ToJSONString());
        return true;
    }
}

