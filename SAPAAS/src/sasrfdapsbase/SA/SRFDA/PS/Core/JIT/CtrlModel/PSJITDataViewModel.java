/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.dataview.IDataView
 *  net.ibizsys.paas.control.dataview.IDataViewDataItem
 *  net.ibizsys.paas.controller.IViewController
 *  net.ibizsys.paas.ctrlmodel.DataViewDataItemModel
 *  net.ibizsys.paas.ctrlmodel.DataViewModelBase
 *  net.ibizsys.paas.data.IDataItem
 *  net.ibizsys.paas.data.IDataItemParam
 *  net.ibizsys.paas.datamodel.DataItemParamModel
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.JIT.CtrlModel;

import SA.SRFDA.PS.Core.Control.DataView.IPSDEDataView;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Data.IPSDataItemParam;
import SA.SRFDA.PS.Core.JIT.CtrlModel.IPSJITCtrlModel;
import java.util.Iterator;
import net.ibizsys.paas.control.dataview.IDataView;
import net.ibizsys.paas.control.dataview.IDataViewDataItem;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.ctrlmodel.DataViewDataItemModel;
import net.ibizsys.paas.ctrlmodel.DataViewModelBase;
import net.ibizsys.paas.data.IDataItem;
import net.ibizsys.paas.data.IDataItemParam;
import net.ibizsys.paas.datamodel.DataItemParamModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.StringHelper;

public class PSJITDataViewModel
extends DataViewModelBase
implements IPSJITCtrlModel {
    private IPSControl iPSControl = null;

    @Override
    public void init(IViewController iViewController, IPSControl iPSControl) throws Exception {
        this.iPSControl = iPSControl;
        this.init(iViewController);
    }

    @Override
    public IPSControl getPSControl() {
        return this.iPSControl;
    }

    public IPSDEDataView getPSDEDataView() {
        return (IPSDEDataView)this.getPSControl();
    }

    public IDataEntityModel getDEModel() {
        try {
            if (this.getPSControl().getPSDataEntity() != null) {
                return this.getViewController().getSystemModel().getDataEntityModel(this.getPSControl().getPSDataEntity().getName());
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return super.getDEModel();
    }

    protected void prepareDataViewDataItems() throws Exception {
        super.prepareDataViewDataItems();
        IDataViewDataItem iDataViewDataItem = null;
        Iterator dataviewDataItems = this.getPSDEDataView().getDataViewDataItems();
        while (dataviewDataItems.hasNext()) {
            IDataViewDataItem iDataItem = (IDataViewDataItem)dataviewDataItems.next();
            iDataViewDataItem = this.createDataViewDataItem(iDataItem.getName());
            if (iDataViewDataItem == null) {
                DataViewDataItemModel dataViewDataItem = new DataViewDataItemModel();
                dataViewDataItem.setDataView((IDataView)this);
                dataViewDataItem.setName(iDataItem.getName());
                dataViewDataItem.setDataType(iDataItem.getDataType());
                if (!StringHelper.isNullOrEmpty((String)iDataItem.getFormat())) {
                    dataViewDataItem.setFormat(iDataItem.getFormat());
                }
                if (iDataItem.getDataItemParams() != null) {
                    IDataItemParam[] iDataItemParamArray = iDataItem.getDataItemParams();
                    int n = iDataItemParamArray.length;
                    int n2 = 0;
                    while (n2 < n) {
                        IDataItemParam iDataItemParam2 = iDataItemParamArray[n2];
                        IPSDataItemParam iDataItemParam = (IPSDataItemParam)iDataItemParam2;
                        DataItemParamModel dataItemParam = new DataItemParamModel();
                        if (!StringHelper.isNullOrEmpty((String)iDataItemParam.getName())) {
                            dataItemParam.setName(iDataItemParam.getName());
                        }
                        if (!StringHelper.isNullOrEmpty((String)iDataItemParam.getFormat())) {
                            dataItemParam.setFormat(iDataItemParam.getFormat());
                        }
                        dataItemParam.setDataItem((IDataItem)dataViewDataItem);
                        if (iDataItemParam.getPSCodeList() != null && StringHelper.compare((String)iDataItemParam.getPSCodeList().getCodeListType(), (String)"DYNAMIC", (boolean)false) == 0) {
                            dataItemParam.setCodeListId(iDataItemParam.getPSCodeList().getId());
                        }
                        dataViewDataItem.addDataItemParam((IDataItemParam)dataItemParam);
                        ++n2;
                    }
                }
                dataViewDataItem.init();
                iDataViewDataItem = dataViewDataItem;
            }
            this.registerDataViewDataItem(iDataViewDataItem);
        }
    }
}

