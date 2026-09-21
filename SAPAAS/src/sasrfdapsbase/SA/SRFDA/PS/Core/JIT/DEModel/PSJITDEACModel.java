/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.data.IDataItem
 *  net.ibizsys.paas.datamodel.DataItemModel3
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package SA.SRFDA.PS.Core.JIT.DEModel;

import SA.SRFDA.PS.Core.DataEntity.AC.IPSDEACMode;
import SA.SRFDA.PS.Core.JIT.DEModel.IPSJITDEModel;
import java.util.Iterator;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.data.IDataItem;
import net.ibizsys.paas.datamodel.DataItemModel3;
import net.ibizsys.paas.demodel.DEACModelBase;

public class PSJITDEACModel
extends DEACModelBase {
    private IPSJITDEModel iPSJITDEModel = null;
    private IPSDEACMode iPSDEACMode = null;

    public void init(IPSJITDEModel iPSJITDEModel, IPSDEACMode iPSDEACMode) throws Exception {
        this.iPSJITDEModel = iPSJITDEModel;
        this.iPSDEACMode = iPSDEACMode;
        this.init((IDataEntity)iPSJITDEModel);
        if (iPSDEACMode.getMinorSortPSDEF() != null) {
            this.setMinorSortField(iPSDEACMode.getMinorSortPSDEF().getName());
            this.setMinorSortDir(iPSDEACMode.getMinorSortDir());
        }
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
        return this.iPSDEACMode.getId();
    }

    public String getName() {
        return this.iPSDEACMode.getCodeName().toUpperCase();
    }

    public boolean isDefaultMode() {
        return this.iPSDEACMode.isDefaultMode();
    }
}

