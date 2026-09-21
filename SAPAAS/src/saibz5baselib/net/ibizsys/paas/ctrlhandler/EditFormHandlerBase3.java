/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlhandler.EditFormHandlerBase;
import net.ibizsys.paas.ctrlmodel.IFormItemModel;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.FormAjaxActionResult;

public abstract class EditFormHandlerBase3
extends EditFormHandlerBase {
    @Override
    protected Object getEditFormKeyValue() throws Exception {
        IFormItemModel iFormItemModel = (IFormItemModel)this.getEditFormModel().getFormItem("srfkey", false);
        return iFormItemModel.getDefaultValue(this.getWebContext(), false);
    }

    @Override
    protected AjaxActionResult onLoadDraft() throws Exception {
        return this.onLoad();
    }

    @Override
    protected void fillOutputDatas(IDataObject iDataObject, Boolean bUpdate, FormAjaxActionResult formAjaxActionResult) throws Exception {
        super.fillOutputDatas(iDataObject, bUpdate, formAjaxActionResult);
        String strKeyValue = formAjaxActionResult.getData(true).optString("srfkey");
        if (StringHelper.isNullOrEmpty(strKeyValue)) {
            strKeyValue = DataObject.getStringValue(this.getEditFormKeyValue(), "");
            JSONObjectHelper.putRaw(formAjaxActionResult.getData(true), "srfkey", strKeyValue);
        }
    }
}

