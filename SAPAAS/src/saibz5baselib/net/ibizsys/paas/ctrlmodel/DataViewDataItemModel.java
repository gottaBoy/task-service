/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.control.dataview.IDataView;
import net.ibizsys.paas.control.dataview.IDataViewDataItem;
import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.datamodel.DataItemModel;
import net.ibizsys.paas.demodel.IDataEntityModel;

public class DataViewDataItemModel
extends DataItemModel
implements IDataViewDataItem {
    protected IDataView iDataView = null;

    public void init(IDataView iDataView) throws Exception {
        this.iDataView = iDataView;
        this.onInit();
    }

    public IDataView getDataView() {
        return this.iDataView;
    }

    public void setDataView(IDataView iDataView) {
        this.iDataView = iDataView;
    }

    @Override
    public ISystem getCurSystem(IActionContext iActionContext) throws Exception {
        return this.getDataView().getDataEntity().getSystem();
    }

    @Override
    protected IDataEntityModel getDEModel() throws Exception {
        return (IDataEntityModel)this.getDataView().getDataEntity();
    }
}

