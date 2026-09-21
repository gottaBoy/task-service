/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.ac.IPSDEACMode
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.data.IDataItem
 *  net.ibizsys.paas.datamodel.DataItemModel3
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.ssdyna.demodel;

import java.util.Iterator;
import net.ibizsys.model.dataentity.ac.IPSDEACMode;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.data.IDataItem;
import net.ibizsys.paas.datamodel.DataItemModel3;
import net.ibizsys.paas.demodel.DEACModelBase;
import net.ibizsys.ssdyna.demodel.IDynaDEModel;

public class DynaDEACModel
extends DEACModelBase {
    private IDynaDEModel iDynaDEModel = null;
    private IPSDEACMode iPSDEACMode = null;
    private boolean bDefault = false;

    public void init(IDynaDEModel iDynaDEModel, IPSDEACMode iPSDEACMode) throws Exception {
        this.iDynaDEModel = iDynaDEModel;
        this.iPSDEACMode = iPSDEACMode;
        this.init((IDataEntity)iDynaDEModel);
        this.strId = this.iPSDEACMode.getId();
        this.strName = this.iPSDEACMode.getName();
        this.bDefault = this.iPSDEACMode.isDefaultMode();
        if (iPSDEACMode.getMinorSortPSDEF() != null) {
            this.setMinorSortField(iPSDEACMode.getMinorSortPSDEF().getName());
            this.setMinorSortDir(iPSDEACMode.getMinorSortDir());
        }
        this.iPSDEACMode = null;
    }

    protected void onInit() throws Exception {
        this.prepareDataItems();
        super.onInit();
    }

    protected void prepareDataItems() {
        Iterator dataItems = this.iPSDEACMode.getDataItems();
        while (dataItems.hasNext()) {
            IDataItem iDataItem = (IDataItem)dataItems.next();
            this.registerDataItem(this.createDataItem(iDataItem));
        }
    }

    protected IDataItem createDataItem(IDataItem dataItem) {
        DataItemModel3 dataItemModel = new DataItemModel3();
        dataItemModel.init(dataItem);
        return dataItemModel;
    }

    public String getId() {
        return this.strId;
    }

    public String getName() {
        return this.strName;
    }

    public boolean isDefaultMode() {
        return this.bDefault;
    }
}

