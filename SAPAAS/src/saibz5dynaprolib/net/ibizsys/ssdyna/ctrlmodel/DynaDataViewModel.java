/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.dataview.IPSDEDataView
 *  net.ibizsys.model.data.IPSDataItemParam
 *  net.ibizsys.paas.control.dataview.IDataView
 *  net.ibizsys.paas.control.dataview.IDataViewDataItem
 *  net.ibizsys.paas.ctrlmodel.DataViewDataItemModel
 *  net.ibizsys.paas.ctrlmodel.DataViewModelBase
 *  net.ibizsys.paas.data.IDataItem
 *  net.ibizsys.paas.data.IDataItemParam
 *  net.ibizsys.paas.datamodel.DataItemParamModel
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.ssdyna.ctrlmodel;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.dataview.IPSDEDataView;
import net.ibizsys.model.data.IPSDataItemParam;
import net.ibizsys.paas.control.dataview.IDataView;
import net.ibizsys.paas.control.dataview.IDataViewDataItem;
import net.ibizsys.paas.ctrlmodel.DataViewDataItemModel;
import net.ibizsys.paas.ctrlmodel.DataViewModelBase;
import net.ibizsys.paas.data.IDataItem;
import net.ibizsys.paas.data.IDataItemParam;
import net.ibizsys.paas.datamodel.DataItemParamModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.ssdyna.ctrlmodel.DynaCtrlModelBase;
import net.ibizsys.ssdyna.ctrlmodel.IDynaCtrlModel;
import net.ibizsys.ssdyna.view.IDynaViewModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DynaDataViewModel
extends DataViewModelBase
implements IDynaCtrlModel {
    private static final Log log = LogFactory.getLog(DynaDataViewModel.class);
    private IPSControl iPSControl = null;

    @Override
    public void init(IDynaViewModel iDynaViewModel, IPSControl iPSControl) throws Exception {
        this.iPSControl = iPSControl;
        this.init(iDynaViewModel);
    }

    @Override
    public IPSControl getPSControl() {
        return this.iPSControl;
    }

    public IPSDEDataView getPSDEDataView() {
        return (IPSDEDataView)this.getPSControl();
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

    @Override
    public ObjectNode toJsonObject(ObjectNode objectNode) throws Exception {
        if (objectNode == null) {
            objectNode = JsonNodeHelper.createObjectNode();
        }
        this.onFillJsonObject(objectNode);
        return objectNode;
    }

    protected void onFillJsonObject(ObjectNode objectNode) throws Exception {
        if (this.getPSControl() != null) {
            DynaCtrlModelBase.toJsonObject(objectNode, this.getPSControl());
        }
    }

    @Override
    public boolean isDynaCtrl() {
        if (this.getPSControl() != null) {
            return this.getPSControl().isDynamicCtrl();
        }
        return false;
    }

    public IDataEntityModel getDEModel() {
        try {
            if (this.getPSControl().getPSDataEntity() != null) {
                return ((IDynaViewModel)this.getViewController()).getDynaSysModel().getDynaDEModel(this.getPSControl().getPSDataEntity().getId());
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        return super.getDEModel();
    }
}

