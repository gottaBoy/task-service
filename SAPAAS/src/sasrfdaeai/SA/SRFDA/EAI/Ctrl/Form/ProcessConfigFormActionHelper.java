/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Form.BaseDAFormActionHelper
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.Form.SRFExFormItemErrors
 *  SA.SRFramework.WebEx.Form.SRFExFormSaveResult
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.Utility.DADVHelper
 */
package SA.SRFDA.EAI.Ctrl.Form;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Form.BaseDAFormActionHelper;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Form.SRFExFormItemErrors;
import SA.SRFramework.WebEx.Form.SRFExFormSaveResult;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.Utility.DADVHelper;

public class ProcessConfigFormActionHelper
extends BaseDAFormActionHelper {
    protected boolean OnSaveAction() {
        boolean bInsert;
        SRFExFormSaveResult saveResult = new SRFExFormSaveResult();
        CallResult callResult = null;
        SRFExFormItemErrors formItemErrors = new SRFExFormItemErrors();
        IDEDataCtrl iDEDataCtrl = this.getDEDataCtrl();
        BaseDataEntity dataEntity = new BaseDataEntity();
        this.OnSaveActionBeforeFillDataEntity(dataEntity);
        if (!this.OnSaveActionFillDataEntity(dataEntity, formItemErrors)) {
            saveResult.setRetCode(5);
            formItemErrors.FillJSONs(saveResult.getItems());
            saveResult.AppendJSCode(ProcessConfigFormActionHelper.GetSetPageInfoJS((String)"\u8f93\u5165\u6709\u8bef\uff0c\u6570\u636e\u65e0\u6cd5\u4fdd\u5b58!"));
            this.getPage().Output(saveResult.ToJSONString());
            return true;
        }
        boolean bl = bInsert = !this.IsFormContainKey(dataEntity);
        if (!bInsert) {
            BaseDataEntity checkkeyparam = new BaseDataEntity();
            dataEntity.CopyTo(checkkeyparam, true);
            callResult = iDEDataCtrl.CheckKeyState(checkkeyparam);
            if (callResult.getRetCode() != 0 || callResult.getUserObject() == null) {
                saveResult.setRetCode(1);
                saveResult.AppendJSCode(ProcessConfigFormActionHelper.GetSetPageInfoJS((String)"\u68c0\u67e5\u6570\u636e\u4e3b\u952e\u53d1\u751f\u9519\u8bef!\u6570\u636e\u65e0\u6cd5\u4fdd\u5b58!"));
                this.getPage().Output(saveResult.ToJSONString());
                return true;
            }
            int nState = (Integer)callResult.getUserObject();
            if (nState == 0) {
                bInsert = true;
            } else if (nState == 1) {
                bInsert = false;
            } else {
                saveResult.setRetCode(5);
                saveResult.AppendJSCode(ProcessConfigFormActionHelper.GetSetPageInfoJS((String)"\u8be5\u6570\u636e\u5df2\u7ecf\u88ab\u5220\u9664!\u6570\u636e\u65e0\u6cd5\u4fdd\u5b58!"));
                this.getPage().Output(saveResult.ToJSONString());
                return true;
            }
        }
        this.form1.RemoveInvalidValue(dataEntity, bInsert);
        if (bInsert) {
            for (IDEFHelper iDEFHelper : this.getPage().getDEHelper().GetDEFHelpers()) {
                if (iDEFHelper.IsKeyDEField()) continue;
                String strDVT = iDEFHelper.GetFormCtrl().GetDefaultValueType();
                String strDV = iDEFHelper.GetFormCtrl().GetDefaultValue();
                if (StringHelper.Length((String)strDVT) == 0 && StringHelper.Length((String)strDV) == 0 || dataEntity.ContainesParam(iDEFHelper.getName())) continue;
                dataEntity.SetParamValue(iDEFHelper.getName(), DADVHelper.GetDefaultValue((SRFExWebContext)this.getWebContext(), (String)strDVT, (String)strDV, (String)iDEFHelper.GetStdDataType()));
            }
        }
        dataEntity.SetParamValue("PROCESSID", (Object)this.getWebContext().GetParamValue("PROCESSID"));
        this.SetPageInfo("");
        if (!this.OnSaveActionAfterFillDataEntity(dataEntity, bInsert, formItemErrors)) {
            saveResult.setRetCode(5);
            formItemErrors.FillJSONs(saveResult.getItems());
            String strErrorInfo = formItemErrors.getErrorInfo();
            if (StringHelper.IsNullOrEmpty((String)strErrorInfo)) {
                saveResult.AppendJSCode(this.GetSetPageInfoJSEx("\u8f93\u5165\u6709\u8bef\uff0c\u6570\u636e\u65e0\u6cd5\u4fdd\u5b58!"));
            } else {
                saveResult.AppendJSCode(this.GetSetPageInfoJSEx(StringHelper.Format((String)"\u6570\u636e\u65e0\u6cd5\u4fdd\u5b58\uff0c%1$s", (Object)strErrorInfo)));
            }
            this.getPage().Output(saveResult.ToJSONString());
            return true;
        }
        if (bInsert) {
            this.SetPageInfo("");
            callResult = this.OnSaveActionBeforeInsert(dataEntity);
            if (callResult.getRetCode() != 0) {
                saveResult.From(callResult);
                saveResult.setErrorInfo(StringHelper.Format((String)"\u6570\u636e\u65e0\u6cd5\u65b0\u5efa\uff0c%1$s", (Object)callResult.getErrorInfo()));
                saveResult.AppendJSCode(this.GetSetPageInfoJSEx(StringHelper.Format((String)"\u6570\u636e\u65e0\u6cd5\u65b0\u5efa\uff0c%1$s", (Object)callResult.getErrorInfo())));
                this.getPage().Output(saveResult.ToJSONString());
                return true;
            }
            this.SetPageInfo("");
            String strInsertMode = "DEFAULT";
            if (this.formView != null) {
                strInsertMode = this.formView.getINSERTMODE();
            }
            if ((callResult = iDEDataCtrl.Save(true, strInsertMode, dataEntity)).getRetCode() == 0) {
                callResult = this.OnSaveActionAfterInsert(callResult, dataEntity);
            }
        } else {
            this.SetPageInfo("");
            callResult = this.OnSaveActionBeforeUpdate(dataEntity);
            if (callResult.getRetCode() != 0) {
                saveResult.From(callResult);
                saveResult.setErrorInfo(StringHelper.Format((String)"\u6570\u636e\u65e0\u6cd5\u66f4\u65b0\uff0c%1$s", (Object)callResult.getErrorInfo()));
                saveResult.AppendJSCode(this.GetSetPageInfoJSEx(StringHelper.Format((String)"\u6570\u636e\u65e0\u6cd5\u66f4\u65b0\uff0c%1$s", (Object)callResult.getErrorInfo())));
                this.getPage().Output(saveResult.ToJSONString());
                return true;
            }
            this.SetPageInfo("");
            BaseDataEntity backupDataEntity = new BaseDataEntity();
            dataEntity.CopyTo(backupDataEntity, true);
            callResult = iDEDataCtrl.Get(backupDataEntity);
            if (callResult.getRetCode() != 0) {
                saveResult.From(callResult);
                saveResult.setErrorInfo(StringHelper.Format((String)"\u6570\u636e\u65e0\u6cd5\u66f4\u65b0\uff0c%1$s", (Object)callResult.getErrorInfo()));
                saveResult.AppendJSCode(this.GetSetPageInfoJSEx(StringHelper.Format((String)"\u6570\u636e\u65e0\u6cd5\u66f4\u65b0\uff0c%1$s", (Object)callResult.getErrorInfo())));
                this.getPage().Output(saveResult.ToJSONString());
                return true;
            }
            String strInsertMode = "DEFAULT";
            if (this.formView != null) {
                strInsertMode = this.formView.getINSERTMODE();
            }
            backupDataEntity.RemoveParam(this.getPage().getDEHelper().GetKeyDEFHelper().getName());
            callResult = iDEDataCtrl.Save(true, strInsertMode, backupDataEntity);
            if (callResult.getRetCode() != 0) {
                saveResult.From(callResult);
                saveResult.setErrorInfo(StringHelper.Format((String)"\u6570\u636e\u65e0\u6cd5\u66f4\u65b0\uff0c%1$s", (Object)callResult.getErrorInfo()));
                saveResult.AppendJSCode(this.GetSetPageInfoJSEx(StringHelper.Format((String)"\u6570\u636e\u65e0\u6cd5\u66f4\u65b0\uff0c%1$s", (Object)callResult.getErrorInfo())));
                this.getPage().Output(saveResult.ToJSONString());
                return true;
            }
            dataEntity.SetParamValue(this.getPage().getDEHelper().GetKeyDEFHelper().getName(), backupDataEntity.GetParamValue(this.getPage().getDEHelper().GetKeyDEFHelper().getName()));
            String strUpdateMode = "DEFAULT";
            if (this.formView != null) {
                strUpdateMode = this.formView.getUPDATEMODE();
            }
            dataEntity.RemoveParam("SRFDAUPDATEDATE");
            callResult = iDEDataCtrl.Save(false, strUpdateMode, dataEntity);
            if (callResult.getRetCode() == 0) {
                callResult = this.OnSaveActionAfterUpdate(callResult, dataEntity);
            }
        }
        saveResult.From(callResult);
        if (saveResult.getRetCode() != 0) {
            if (callResult.IsUserError()) {
                this.SetPageInfo("");
                this.FillFormUserErrors(this.form1, formItemErrors, callResult);
                saveResult.setRetCode(5);
                formItemErrors.FillJSONs(saveResult.getItems());
                saveResult.AppendJSCode(ProcessConfigFormActionHelper.GetSetPageInfoJS((String)StringHelper.Format((String)"\u6570\u636e\u4fdd\u5b58\u5931\u8d25!%1$s", (Object)callResult.getErrorInfo())));
            } else {
                saveResult.AppendJSCode(ProcessConfigFormActionHelper.GetSetPageInfoJS((String)StringHelper.Format((String)"\u6570\u636e\u4fdd\u5b58\u5931\u8d25!%1$s", (Object)callResult.getErrorInfo())));
            }
        } else {
            if (this.getWebContext().getSaveAndNewMode()) {
                return this.OnLoadDefaultAction();
            }
            this.OnSaveActionFillForm(dataEntity);
            this.form1.FillValueJSON(saveResult.getItems());
            saveResult.AppendJSCode(ProcessConfigFormActionHelper.GetSetPageDataJS((String)this.getPage().getDEHelper().GetDataInfo(dataEntity)));
            saveResult.AppendJSCode(this.GetSetPageInfoJSEx("\u6570\u636e\u4fdd\u5b58\u6210\u529f!"));
            saveResult.AppendJSCode(this.GetExtJSCode());
            saveResult.setFormState(this.GetFormState(false, dataEntity));
            saveResult.setSaveTag(this.getWebContext().GetPostValue("SRFSAVETAG"));
        }
        this.getPage().Output(this.OnSaveActionOutputResult(dataEntity, saveResult));
        return true;
    }
}

