/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlhandler.CtrlHandlerBase;
import net.ibizsys.paas.ctrlhandler.ICtrlItemHandler;
import net.ibizsys.paas.ctrlhandler.ISearchFormHandler;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.ctrlmodel.ISearchFormModel;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.FormAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONObject;

public abstract class SearchFormHandlerBase
extends CtrlHandlerBase
implements ISearchFormHandler {
    protected ISearchFormModel getSearchFormModel() {
        return null;
    }

    @Override
    public ICtrlModel getCtrlModel() {
        return this.getSearchFormModel();
    }

    @Override
    protected AjaxActionResult onProcessAction(String strAction) throws Exception {
        if (StringHelper.compare(strAction, "loaddraft", true) == 0) {
            return this.onLoadDraft();
        }
        if (StringHelper.compare(strAction, "load", true) == 0) {
            return this.onLoad();
        }
        if (StringHelper.compare(strAction, "itemfetch", true) == 0) {
            return this.onItemAction(strAction);
        }
        if (StringHelper.compare(strAction, "search", true) == 0) {
            return this.onSearch();
        }
        return super.onProcessAction(strAction);
    }

    protected AjaxActionResult onItemAction(String strAction) throws Exception {
        String strFormItemName = WebContext.getFormItemId(this.getWebContext());
        ICtrlItemHandler iCtrlItemHandler = this.getCtrlItemHandler("FI:" + strFormItemName);
        return iCtrlItemHandler.processAction(strAction);
    }

    protected AjaxActionResult onSearch() throws Exception {
        FormAjaxActionResult FormAjaxActionResult2 = new FormAjaxActionResult();
        this.getWebContext().setCurAjaxActionResult(FormAjaxActionResult2);
        DataObject iDataObject = new DataObject();
        this.fillInputValues(iDataObject, true);
        this.fillOutputDatas(iDataObject, FormAjaxActionResult2);
        return FormAjaxActionResult2;
    }

    protected void fillOutputDatas(IDataObject iDataObject, FormAjaxActionResult formAjaxActionResult) throws Exception {
        JSONObject outputData = formAjaxActionResult.getData(true);
        JSONObject outputState = formAjaxActionResult.getState(true);
        JSONObject outputConfig = formAjaxActionResult.getConfig(true);
        this.getSearchFormModel().fillOutputDatas(iDataObject, false, outputData, outputState, outputConfig);
    }

    protected void fillInputValues(IDataObject iDataObject, boolean bIgnoreEmpty) throws Exception {
        this.getSearchFormModel().fillInputValues(iDataObject, true, bIgnoreEmpty);
    }

    protected AjaxActionResult onLoadDraft() throws Exception {
        FormAjaxActionResult formAjaxActionResult = new FormAjaxActionResult();
        this.getWebContext().setCurAjaxActionResult(formAjaxActionResult);
        IEntity iEntity = this.getDraftEntity();
        iEntity.set("srfuf", 0);
        iEntity.set("srftempmode", this.getTempMode());
        this.fillOutputDatas(iEntity, formAjaxActionResult);
        return formAjaxActionResult;
    }

    protected IEntity getDraftEntity() throws Exception {
        SimpleEntity iEntity = new SimpleEntity();
        this.getSearchFormModel().fillDefaultValues(iEntity, false);
        return iEntity;
    }

    protected AjaxActionResult onLoad() throws Exception {
        FormAjaxActionResult formAjaxActionResult = new FormAjaxActionResult();
        this.getWebContext().setCurAjaxActionResult(formAjaxActionResult);
        IEntity iEntity = this.getEntity(null);
        iEntity.set("srfuf", 0);
        iEntity.set("srftempmode", this.getTempMode());
        this.fillOutputDatas(iEntity, formAjaxActionResult);
        return formAjaxActionResult;
    }

    protected IEntity getEntity(Object objKeyValue) throws Exception {
        return new SimpleEntity();
    }
}

