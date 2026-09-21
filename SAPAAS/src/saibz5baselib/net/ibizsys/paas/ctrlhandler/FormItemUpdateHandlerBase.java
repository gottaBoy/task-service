/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.ctrlhandler;

import java.util.Iterator;
import net.ibizsys.paas.control.form.IFormItem;
import net.ibizsys.paas.ctrlhandler.CtrlItemHandlerBase;
import net.ibizsys.paas.ctrlhandler.ICtrlHandler;
import net.ibizsys.paas.ctrlhandler.IFormItemUpdateHandler;
import net.ibizsys.paas.ctrlmodel.IFormItemModel;
import net.ibizsys.paas.ctrlmodel.IFormModel;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.FormAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONObject;

public abstract class FormItemUpdateHandlerBase
extends CtrlItemHandlerBase
implements IFormItemUpdateHandler {
    private IFormModel iFormModel = null;

    @Override
    public void init(IFormModel iFormModel, ICtrlHandler iCtrlHandler) throws Exception {
        this.setFormModel(iFormModel);
        super.init(iCtrlHandler);
    }

    public IFormModel getFormModel() {
        return this.iFormModel;
    }

    protected void setFormModel(IFormModel iFormModel) {
        this.iFormModel = iFormModel;
    }

    @Override
    protected AjaxActionResult onProcessAction(String strAction) throws Exception {
        if (StringHelper.compare(strAction, "updateformitem", true) == 0) {
            return this.onFormItemUpdate();
        }
        return super.onProcessAction(strAction);
    }

    protected AjaxActionResult onFormItemUpdate() throws Exception {
        FormAjaxActionResult formAjaxActionResult = new FormAjaxActionResult();
        this.getWebContext().setCurAjaxActionResult(formAjaxActionResult);
        boolean bUpdateFlag = false;
        JSONObject activeDataJsonObject = WebContext.getActiveData(this.getWebContext());
        Object objUFFlag = activeDataJsonObject.opt("srfuf");
        if (objUFFlag != null) {
            bUpdateFlag = StringHelper.compare(objUFFlag.toString(), "1", false) == 0;
        }
        Object iEntity = this.getViewController().getDEModel().createEntity();
        this.fillInputValues((IDataObject)iEntity, bUpdateFlag, activeDataJsonObject);
        this.executeAction((IEntity)iEntity);
        this.fillOutputDatas((IDataObject)iEntity, formAjaxActionResult);
        return formAjaxActionResult;
    }

    protected void fillOutputDatas(IDataObject iDataObject, FormAjaxActionResult formAjaxActionResult) throws Exception {
        JSONObject outputData2 = new JSONObject();
        JSONObject outputState2 = new JSONObject();
        JSONObject outputConfig2 = new JSONObject();
        this.getFormModel().fillOutputDatas(iDataObject, true, outputData2, outputState2, outputConfig2);
        this.fillOutputDatas(iDataObject, outputData2, outputState2, outputConfig2, formAjaxActionResult);
    }

    protected void fillInputValues(IDataObject iDataObject, boolean bUpdate, JSONObject activeDataJsonObject) throws Exception {
        this.onFillInputValues(iDataObject, bUpdate, activeDataJsonObject);
        Iterator<IFormItem> formItems = this.getFormModel().getFormItems();
        while (formItems.hasNext()) {
            IFormItem iFormItem = formItems.next();
            if (bUpdate) {
                if ((iFormItem.getIgnoreInput() & 2) <= 0) continue;
                iDataObject.remove(iFormItem.getName());
                continue;
            }
            if ((iFormItem.getIgnoreInput() & 1) <= 0) continue;
            iDataObject.remove(iFormItem.getName());
        }
    }

    protected void onFillInputValues(IDataObject iDataObject, boolean bUpdate, JSONObject activeDataJsonObject) throws Exception {
        Iterator<IFormItem> formItems = this.getFormModel().getFormItems();
        while (formItems.hasNext()) {
            IFormItemModel iFormItem = (IFormItemModel)formItems.next();
            try {
                String strValue;
                Object objValue = iFormItem.getInputValue(activeDataJsonObject);
                if (objValue != null && objValue instanceof String && StringHelper.isNullOrEmpty(strValue = (String)objValue)) {
                    objValue = null;
                }
                iDataObject.set(iFormItem.getName(), objValue);
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    protected abstract void fillOutputDatas(IDataObject var1, JSONObject var2, JSONObject var3, JSONObject var4, FormAjaxActionResult var5) throws Exception;

    protected abstract void executeAction(IEntity var1) throws Exception;

    protected boolean isEnableTempData() {
        return false;
    }
}

