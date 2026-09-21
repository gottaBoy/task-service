/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.grid.IPSDEGrid
 *  net.ibizsys.model.control.grid.IPSDEGridColumn
 *  net.ibizsys.model.control.grid.IPSDEGridEditItem
 *  net.ibizsys.model.data.IPSDataItem
 *  net.ibizsys.model.data.IPSDataItemParam
 *  net.ibizsys.paas.control.grid.IGrid
 *  net.ibizsys.paas.control.grid.IGridColumn
 *  net.ibizsys.paas.control.grid.IGridDataItem
 *  net.ibizsys.paas.control.grid.IGridEditItem
 *  net.ibizsys.paas.ctrlmodel.GridColumnModel
 *  net.ibizsys.paas.ctrlmodel.GridDataItemModel
 *  net.ibizsys.paas.ctrlmodel.GridEditItemModel
 *  net.ibizsys.paas.ctrlmodel.GridModelBase
 *  net.ibizsys.paas.data.IDataItem
 *  net.ibizsys.paas.data.IDataItemParam
 *  net.ibizsys.paas.datamodel.DataItemModel
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
import net.ibizsys.model.control.grid.IPSDEGrid;
import net.ibizsys.model.control.grid.IPSDEGridColumn;
import net.ibizsys.model.control.grid.IPSDEGridEditItem;
import net.ibizsys.model.data.IPSDataItem;
import net.ibizsys.model.data.IPSDataItemParam;
import net.ibizsys.paas.control.grid.IGrid;
import net.ibizsys.paas.control.grid.IGridColumn;
import net.ibizsys.paas.control.grid.IGridDataItem;
import net.ibizsys.paas.control.grid.IGridEditItem;
import net.ibizsys.paas.ctrlmodel.GridColumnModel;
import net.ibizsys.paas.ctrlmodel.GridDataItemModel;
import net.ibizsys.paas.ctrlmodel.GridEditItemModel;
import net.ibizsys.paas.ctrlmodel.GridModelBase;
import net.ibizsys.paas.data.IDataItem;
import net.ibizsys.paas.data.IDataItemParam;
import net.ibizsys.paas.datamodel.DataItemModel;
import net.ibizsys.paas.datamodel.DataItemParamModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.ssdyna.ctrlmodel.DynaCtrlModelBase;
import net.ibizsys.ssdyna.ctrlmodel.IDynaCtrlModel;
import net.ibizsys.ssdyna.view.IDynaViewModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DynaGridModel
extends GridModelBase
implements IDynaCtrlModel {
    private static final Log log = LogFactory.getLog(DynaGridModel.class);
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

    public IPSDEGrid getPSDEGrid() {
        return (IPSDEGrid)this.getPSControl();
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

    protected void prepareGridColumnModels() throws Exception {
        super.prepareGridColumnModels();
        IGridColumn iGridColumn = null;
        Iterator gridColumns = this.getPSDEGrid().getPSDEGridColumns();
        while (gridColumns.hasNext()) {
            IPSDEGridColumn iPSDEGridColumn = (IPSDEGridColumn)gridColumns.next();
            iGridColumn = this.createGridColumn(iPSDEGridColumn.getName().toLowerCase());
            if (iGridColumn == null) {
                GridColumnModel gridColumnModel = new GridColumnModel();
                gridColumnModel.setName(iPSDEGridColumn.getName().toLowerCase());
                gridColumnModel.setDataItemName(iPSDEGridColumn.getDataItemName());
                gridColumnModel.setCaption(iPSDEGridColumn.getCaption());
                gridColumnModel.init((IGrid)this);
                iGridColumn = gridColumnModel;
            }
            this.registerGridColumn(iGridColumn);
        }
    }

    protected void prepareGridDataItemModels() throws Exception {
        super.prepareGridDataItemModels();
        IGridDataItem iGridDataItem = null;
        Iterator gridDataItems = this.getPSDEGrid().getGridDataItems();
        while (gridDataItems.hasNext()) {
            IGridDataItem griddataitem = (IGridDataItem)gridDataItems.next();
            iGridDataItem = this.createGridDataItem(griddataitem.getName());
            if (iGridDataItem == null) {
                GridDataItemModel gridDataItemModel = new GridDataItemModel();
                gridDataItemModel.setName(griddataitem.getName());
                if (griddataitem.isDataAccessAction()) {
                    gridDataItemModel.setDataAccessAction(true);
                }
                if (griddataitem.getDataItemParams() != null) {
                    IDataItemParam[] iDataItemParamArray = griddataitem.getDataItemParams();
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
                        dataItemParam.setDataItem((IDataItem)gridDataItemModel);
                        if (iDataItemParam.getPSCodeList() != null && StringHelper.compare((String)iDataItemParam.getPSCodeList().getCodeListType(), (String)"DYNAMIC", (boolean)false) == 0) {
                            dataItemParam.setCodeListId(iDataItemParam.getPSCodeList().getId());
                        }
                        gridDataItemModel.addDataItemParam((IDataItemParam)dataItemParam);
                        ++n2;
                    }
                }
                gridDataItemModel.init((IGrid)this);
                iGridDataItem = gridDataItemModel;
            }
            this.registerGridDataItem(iGridDataItem);
        }
    }

    protected void prepareGridEditItemModels() throws Exception {
        IGridEditItem iGridEditItem = null;
        Iterator gridEditItems = this.getPSDEGrid().getGridEditItems();
        while (gridEditItems.hasNext()) {
            IPSDEGridEditItem gridedititem = (IPSDEGridEditItem)gridEditItems.next();
            iGridEditItem = this.createGridEditItem(gridedititem.getName().toLowerCase());
            if (iGridEditItem == null) {
                GridEditItemModel gridEditItem = new GridEditItemModel();
                gridEditItem.setGrid((IGrid)this);
                gridEditItem.setName(gridedititem.getName().toLowerCase());
                gridEditItem.setDEFName(gridedititem.getDEFName());
                if (gridedititem.getEnableCond() != 3) {
                    gridEditItem.setEnableCond(gridedititem.getEnableCond());
                }
                if (gridedititem.getIgnoreInput() != 0) {
                    gridEditItem.setIgnoreInput(gridedititem.getIgnoreInput());
                }
                if (!StringHelper.isNullOrEmpty((String)gridedititem.getCreateDVT())) {
                    gridEditItem.setCreateDVT(gridedititem.getCreateDVT());
                }
                if (!StringHelper.isNullOrEmpty((String)gridedititem.getCreateDV())) {
                    gridEditItem.setCreateDV(gridedititem.getCreateDV());
                }
                if (!StringHelper.isNullOrEmpty((String)gridedititem.getUpdateDVT())) {
                    gridEditItem.setUpdateDVT(gridedititem.getUpdateDVT());
                }
                if (!StringHelper.isNullOrEmpty((String)gridedititem.getUpdateDV())) {
                    gridEditItem.setUpdateDV(gridedititem.getUpdateDV());
                }
                if (gridedititem.getCodeList() != null) {
                    gridEditItem.setCodeListId(gridedititem.getCodeList().getId());
                }
                if (!StringHelper.isNullOrEmpty((String)gridedititem.getUserDictCatId())) {
                    gridEditItem.setUserDictCatId(gridedititem.getUserDictCatId());
                }
                if (!StringHelper.isNullOrEmpty((String)gridedititem.getCaption())) {
                    gridEditItem.setCaption(gridedititem.getCaption());
                }
                if (!gridedititem.isAllowEmpty()) {
                    gridEditItem.setAllowEmpty(false);
                }
                if (gridedititem.isNeedCodeListConfig()) {
                    gridEditItem.setOutputCodeListConfig(true);
                    if (gridedititem.getOutputCodeListConfigMode() > 0) {
                        gridEditItem.setOutputCodeListConfigMode(gridedititem.getOutputCodeListConfigMode());
                    }
                }
                if (!StringHelper.isNullOrEmpty((String)gridedititem.getValueTranslator())) {
                    gridEditItem.setValueTranslator(gridedititem.getValueTranslator());
                }
                if (gridedititem.getDataItem() != null) {
                    IPSDataItem dataitem = (IPSDataItem)gridedititem.getDataItem();
                    DataItemModel dataItem = new DataItemModel();
                    dataItem.setName(gridedititem.getName().toLowerCase());
                    if (gridedititem.getDEField() != null) {
                        dataItem.setDataType(gridedititem.getDEField().getStdDataType());
                    }
                    dataItem.setFormat(gridedititem.getDataItem().getFormat());
                    if (!StringHelper.isNullOrEmpty((String)dataitem.getCodeListId())) {
                        dataItem.setCodeListId(gridedititem.getCodeList().getId());
                    }
                    if (dataitem.getDataItemParams() != null) {
                        IDataItemParam[] iDataItemParamArray = dataitem.getDataItemParams();
                        int n = iDataItemParamArray.length;
                        int n2 = 0;
                        while (n2 < n) {
                            IDataItemParam iDataItemParam2 = iDataItemParamArray[n2];
                            IPSDataItemParam dataitemparam = (IPSDataItemParam)iDataItemParam2;
                            DataItemParamModel dataItemParam = new DataItemParamModel();
                            dataItemParam.setName(dataitemparam.getName());
                            dataItemParam.setFormat(dataitemparam.getFormat());
                            dataItem.addDataItemParam((IDataItemParam)dataItemParam);
                            ++n2;
                        }
                    }
                    gridEditItem.setDataItem((IDataItem)dataItem);
                }
                gridEditItem.init();
                iGridEditItem = gridEditItem;
            }
            this.registerGridEditItem(iGridEditItem);
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
}

