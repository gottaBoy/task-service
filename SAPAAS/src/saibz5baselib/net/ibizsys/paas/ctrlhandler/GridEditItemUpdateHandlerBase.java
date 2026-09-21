/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.ctrlhandler;

import java.util.Iterator;
import net.ibizsys.paas.control.grid.IGridEditItem;
import net.ibizsys.paas.ctrlhandler.CtrlItemHandlerBase;
import net.ibizsys.paas.ctrlhandler.ICtrlHandler;
import net.ibizsys.paas.ctrlhandler.IGridEditItemUpdateHandler;
import net.ibizsys.paas.ctrlmodel.IGridEditItemModel;
import net.ibizsys.paas.ctrlmodel.IGridModel;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.GridRowAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONObject;

public abstract class GridEditItemUpdateHandlerBase
extends CtrlItemHandlerBase
implements IGridEditItemUpdateHandler {
    private IGridModel iGridModel = null;

    @Override
    public void init(IGridModel iGridModel, ICtrlHandler iCtrlHandler) throws Exception {
        this.setGridModel(iGridModel);
        super.init(iCtrlHandler);
    }

    public IGridModel getGridModel() {
        return this.iGridModel;
    }

    protected void setGridModel(IGridModel iGridModel) {
        this.iGridModel = iGridModel;
    }

    @Override
    protected AjaxActionResult onProcessAction(String strAction) throws Exception {
        if (StringHelper.compare(strAction, "updategridedititem", true) == 0) {
            return this.onGridEditItemUpdate();
        }
        return super.onProcessAction(strAction);
    }

    protected AjaxActionResult onGridEditItemUpdate() throws Exception {
        GridRowAjaxActionResult gridRowAjaxActionResult = new GridRowAjaxActionResult();
        this.getWebContext().setCurAjaxActionResult(gridRowAjaxActionResult);
        boolean bUpdateFlag = false;
        JSONObject activeDataJsonObject = WebContext.getActiveData(this.getWebContext());
        Object objUFFlag = activeDataJsonObject.opt("srfuf");
        if (objUFFlag != null) {
            bUpdateFlag = StringHelper.compare(objUFFlag.toString(), "1", false) == 0;
        }
        Object iEntity = this.getViewController().getDEModel().createEntity();
        this.fillRowInputValues((IDataObject)iEntity, bUpdateFlag, activeDataJsonObject);
        this.executeAction((IEntity)iEntity);
        this.fillRowOutputDatas((IDataObject)iEntity, gridRowAjaxActionResult);
        return gridRowAjaxActionResult;
    }

    protected void fillRowOutputDatas(IDataObject iDataObject, GridRowAjaxActionResult gridRowAjaxActionResult) throws Exception {
        JSONObject outputData2 = new JSONObject();
        JSONObject outputState2 = new JSONObject();
        JSONObject outputConfig2 = new JSONObject();
        this.getGridModel().fillRowOutputDatas(iDataObject, true, outputData2, outputState2, outputConfig2);
        this.fillRowOutputDatas(iDataObject, outputData2, outputState2, outputConfig2, gridRowAjaxActionResult);
    }

    protected void fillRowInputValues(IDataObject iDataObject, boolean bUpdate, JSONObject activeDataJsonObject) throws Exception {
        this.onFillRowInputValues(iDataObject, bUpdate, activeDataJsonObject);
        Iterator<IGridEditItem> formItems = this.getGridModel().getGridEditItems();
        while (formItems.hasNext()) {
            IGridEditItem iGridEditItem = formItems.next();
            if (bUpdate) {
                if ((iGridEditItem.getIgnoreInput() & 2) <= 0) continue;
                iDataObject.remove(iGridEditItem.getName());
                continue;
            }
            if ((iGridEditItem.getIgnoreInput() & 1) <= 0) continue;
            iDataObject.remove(iGridEditItem.getName());
        }
    }

    protected void onFillRowInputValues(IDataObject iDataObject, boolean bUpdate, JSONObject activeDataJsonObject) throws Exception {
        Iterator<IGridEditItem> formItems = this.getGridModel().getGridEditItems();
        while (formItems.hasNext()) {
            IGridEditItemModel iGridEditItem = (IGridEditItemModel)formItems.next();
            try {
                String strValue;
                Object objValue = iGridEditItem.getInputValue(activeDataJsonObject);
                if (objValue != null && objValue instanceof String && StringHelper.isNullOrEmpty(strValue = (String)objValue)) {
                    objValue = null;
                }
                iDataObject.set(iGridEditItem.getName(), objValue);
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    protected abstract void fillRowOutputDatas(IDataObject var1, JSONObject var2, JSONObject var3, JSONObject var4, GridRowAjaxActionResult var5) throws Exception;

    protected abstract void executeAction(IEntity var1) throws Exception;

    protected boolean isEnableTempData() {
        return false;
    }
}

