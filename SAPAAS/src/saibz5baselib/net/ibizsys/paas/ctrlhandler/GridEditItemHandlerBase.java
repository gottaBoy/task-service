/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import java.util.ArrayList;
import net.ibizsys.paas.core.DEDataSetCond;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.IDEDataSetCond;
import net.ibizsys.paas.ctrlhandler.CtrlItemHandlerBase;
import net.ibizsys.paas.ctrlhandler.ICtrlHandler;
import net.ibizsys.paas.ctrlhandler.IGridEditItemHandler;
import net.ibizsys.paas.ctrlmodel.IGridModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;

public abstract class GridEditItemHandlerBase
extends CtrlItemHandlerBase
implements IGridEditItemHandler {
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
        if (StringHelper.compare(strAction, "itemfetch", true) == 0) {
            return this.onItemFetch();
        }
        return super.onProcessAction(strAction);
    }

    protected AjaxActionResult onItemFetch() throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    protected void fillFetchConditions(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
        if (this.getCtrlHandler().getTempMode() != 0 && this.isEnableTempData()) {
            this.onFillTempDataConditions(deDataSetFetchContextImpl.getConditionList());
        }
        this.onFillFetchConditions(deDataSetFetchContextImpl.getConditionList());
    }

    protected void onFillTempDataConditions(ArrayList<IDEDataSetCond> userConditions) {
        DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
        deDataSetCondImpl.setCondType("CUSTOM");
        deDataSetCondImpl.setCustomCond("t1.SRFDRAFTFLAG = 0");
        userConditions.add(deDataSetCondImpl);
    }

    protected void onFillFetchConditions(ArrayList<IDEDataSetCond> userConditions) throws Exception {
    }

    protected boolean isEnableTempData() {
        return false;
    }
}

