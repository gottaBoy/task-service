/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.psrt.srv.wf.demodel.WFStepDataDEModel
 */
package net.ibizsys.pswf.ctrlmodel;

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
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.psrt.srv.wf.demodel.WFStepDataDEModel;

public class AppWFStepDataGridModel
extends GridModelBase {
    private WFStepDataDEModel wFStepDataDEModel;

    public AppWFStepDataGridModel() {
        this.setName("grid");
    }

    protected WFStepDataDEModel getWFStepDataDEModel() {
        if (this.wFStepDataDEModel == null) {
            try {
                this.wFStepDataDEModel = (WFStepDataDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.psrt.srv.wf.demodel.WFStepDataDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.wFStepDataDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getWFStepDataDEModel();
    }

    protected void prepareGridColumnModels() throws Exception {
        GridColumnModel gridColumnModel;
        super.prepareGridColumnModels();
        IGridColumn iGridColumn = null;
        iGridColumn = this.createGridColumn("actorname");
        if (iGridColumn == null) {
            gridColumnModel = new GridColumnModel();
            gridColumnModel.setName("actorname");
            gridColumnModel.setDataItemName("actorname");
            gridColumnModel.setCaption("\u64cd\u4f5c\u4eba\u540d\u79f0");
            gridColumnModel.init((IGrid)this);
            iGridColumn = gridColumnModel;
        }
        this.registerGridColumn(iGridColumn);
        iGridColumn = this.createGridColumn("actorid");
        if (iGridColumn == null) {
            gridColumnModel = new GridColumnModel();
            gridColumnModel.setName("actorid");
            gridColumnModel.setDataItemName("actorid");
            gridColumnModel.setCaption("\u64cd\u4f5c\u4eba");
            gridColumnModel.init((IGrid)this);
            iGridColumn = gridColumnModel;
        }
        this.registerGridColumn(iGridColumn);
        iGridColumn = this.createGridColumn("actiontime");
        if (iGridColumn == null) {
            gridColumnModel = new GridColumnModel();
            gridColumnModel.setName("actiontime");
            gridColumnModel.setDataItemName("actiontime");
            gridColumnModel.setCaption("\u64cd\u4f5c\u65f6\u95f4");
            gridColumnModel.init((IGrid)this);
            iGridColumn = gridColumnModel;
        }
        this.registerGridColumn(iGridColumn);
        iGridColumn = this.createGridColumn("memo");
        if (iGridColumn == null) {
            gridColumnModel = new GridColumnModel();
            gridColumnModel.setName("memo");
            gridColumnModel.setDataItemName("memo");
            gridColumnModel.setCaption("\u5185\u5bb9");
            gridColumnModel.init((IGrid)this);
            iGridColumn = gridColumnModel;
        }
        this.registerGridColumn(iGridColumn);
        iGridColumn = this.createGridColumn("sdparam2");
        if (iGridColumn == null) {
            gridColumnModel = new GridColumnModel();
            gridColumnModel.setName("sdparam2");
            gridColumnModel.setDataItemName("sdparam2");
            gridColumnModel.setCaption("\u4ee3\u529e\u4eba");
            gridColumnModel.init((IGrid)this);
            iGridColumn = gridColumnModel;
        }
        this.registerGridColumn(iGridColumn);
        iGridColumn = this.createGridColumn("sdparam");
        if (iGridColumn == null) {
            gridColumnModel = new GridColumnModel();
            gridColumnModel.setName("sdparam");
            gridColumnModel.setDataItemName("sdparam");
            gridColumnModel.setCaption("SDPARAM");
            gridColumnModel.init((IGrid)this);
            iGridColumn = gridColumnModel;
        }
        this.registerGridColumn(iGridColumn);
        iGridColumn = this.createGridColumn("nextto");
        if (iGridColumn == null) {
            gridColumnModel = new GridColumnModel();
            gridColumnModel.setName("nextto");
            gridColumnModel.setDataItemName("nextto");
            gridColumnModel.setCaption("\u4e0b\u4e00\u6b65");
            gridColumnModel.init((IGrid)this);
            iGridColumn = gridColumnModel;
        }
        this.registerGridColumn(iGridColumn);
        iGridColumn = this.createGridColumn("userdata");
        if (iGridColumn == null) {
            gridColumnModel = new GridColumnModel();
            gridColumnModel.setName("userdata");
            gridColumnModel.setDataItemName("userdata");
            gridColumnModel.setCaption("\u7528\u6237\u6570\u636e\u6807\u8bc6");
            gridColumnModel.init((IGrid)this);
            iGridColumn = gridColumnModel;
        }
        this.registerGridColumn(iGridColumn);
        iGridColumn = this.createGridColumn("userdatadesc");
        if (iGridColumn == null) {
            gridColumnModel = new GridColumnModel();
            gridColumnModel.setName("userdatadesc");
            gridColumnModel.setDataItemName("userdatadesc");
            gridColumnModel.setCaption("\u7528\u6237\u6570\u636e");
            gridColumnModel.init((IGrid)this);
            iGridColumn = gridColumnModel;
        }
        this.registerGridColumn(iGridColumn);
        iGridColumn = this.createGridColumn("wfinstanceid");
        if (iGridColumn == null) {
            gridColumnModel = new GridColumnModel();
            gridColumnModel.setName("wfinstanceid");
            gridColumnModel.setDataItemName("wfinstanceid");
            gridColumnModel.setCaption("WFInstanceId");
            gridColumnModel.init((IGrid)this);
            iGridColumn = gridColumnModel;
        }
        this.registerGridColumn(iGridColumn);
        iGridColumn = this.createGridColumn("wfinstancename");
        if (iGridColumn == null) {
            gridColumnModel = new GridColumnModel();
            gridColumnModel.setName("wfinstancename");
            gridColumnModel.setDataItemName("wfinstancename");
            gridColumnModel.setCaption("\u6d41\u7a0b\u5b9e\u4f8b");
            gridColumnModel.init((IGrid)this);
            iGridColumn = gridColumnModel;
        }
        this.registerGridColumn(iGridColumn);
        iGridColumn = this.createGridColumn("wfplogicname");
        if (iGridColumn == null) {
            gridColumnModel = new GridColumnModel();
            gridColumnModel.setName("wfplogicname");
            gridColumnModel.setDataItemName("wfplogicname");
            gridColumnModel.setCaption("\u6267\u884c\u6b65\u9aa4");
            gridColumnModel.init((IGrid)this);
            iGridColumn = gridColumnModel;
        }
        this.registerGridColumn(iGridColumn);
        iGridColumn = this.createGridColumn("wfstepdataname");
        if (iGridColumn == null) {
            gridColumnModel = new GridColumnModel();
            gridColumnModel.setName("wfstepdataname");
            gridColumnModel.setDataItemName("wfstepdataname");
            gridColumnModel.setCaption("\u6d41\u7a0b\u64cd\u4f5c");
            gridColumnModel.init((IGrid)this);
            iGridColumn = gridColumnModel;
        }
        this.registerGridColumn(iGridColumn);
        iGridColumn = this.createGridColumn("wfstepid");
        if (iGridColumn == null) {
            gridColumnModel = new GridColumnModel();
            gridColumnModel.setName("wfstepid");
            gridColumnModel.setDataItemName("wfstepid");
            gridColumnModel.setCaption("\u6b65\u9aa4\u6570\u636e_\u76f8\u5173\u6b65\u9aa4");
            gridColumnModel.init((IGrid)this);
            iGridColumn = gridColumnModel;
        }
        this.registerGridColumn(iGridColumn);
        iGridColumn = this.createGridColumn("wfstepname");
        if (iGridColumn == null) {
            gridColumnModel = new GridColumnModel();
            gridColumnModel.setName("wfstepname");
            gridColumnModel.setDataItemName("wfstepname");
            gridColumnModel.setCaption("\u6b65\u9aa4\u540d\u79f0");
            gridColumnModel.init((IGrid)this);
            iGridColumn = gridColumnModel;
        }
        this.registerGridColumn(iGridColumn);
        iGridColumn = this.createGridColumn("actorname2");
        if (iGridColumn == null) {
            gridColumnModel = new GridColumnModel();
            gridColumnModel.setName("actorname2");
            gridColumnModel.setDataItemName("actorname2");
            gridColumnModel.setCaption("\u4ee3\u529e\u4eba\u540d\u79f0");
            gridColumnModel.init((IGrid)this);
            iGridColumn = gridColumnModel;
        }
        this.registerGridColumn(iGridColumn);
    }

    protected void prepareGridDataItemModels() throws Exception {
        DataItemParamModel dataItemParam0;
        GridDataItemModel gridDataItemModel;
        super.prepareGridDataItemModels();
        IGridDataItem iGridDataItem = null;
        iGridDataItem = this.createGridDataItem("actorname2");
        if (iGridDataItem == null) {
            gridDataItemModel = new GridDataItemModel();
            gridDataItemModel.setName("actorname2");
            dataItemParam0 = new DataItemParamModel();
            dataItemParam0.setName("ACTORNAME2");
            dataItemParam0.setFormat("%1$s");
            dataItemParam0.setDataItem((IDataItem)gridDataItemModel);
            gridDataItemModel.addDataItemParam((IDataItemParam)dataItemParam0);
            gridDataItemModel.init((IGrid)this);
            iGridDataItem = gridDataItemModel;
        }
        this.registerGridDataItem(iGridDataItem);
        iGridDataItem = this.createGridDataItem("nextto");
        if (iGridDataItem == null) {
            gridDataItemModel = new GridDataItemModel();
            gridDataItemModel.setName("nextto");
            dataItemParam0 = new DataItemParamModel();
            dataItemParam0.setName("NEXTTO");
            dataItemParam0.setFormat("%1$s");
            dataItemParam0.setDataItem((IDataItem)gridDataItemModel);
            gridDataItemModel.addDataItemParam((IDataItemParam)dataItemParam0);
            gridDataItemModel.init((IGrid)this);
            iGridDataItem = gridDataItemModel;
        }
        this.registerGridDataItem(iGridDataItem);
        iGridDataItem = this.createGridDataItem("wfinstancename");
        if (iGridDataItem == null) {
            gridDataItemModel = new GridDataItemModel();
            gridDataItemModel.setName("wfinstancename");
            dataItemParam0 = new DataItemParamModel();
            dataItemParam0.setName("WFINSTANCENAME");
            dataItemParam0.setFormat("%1$s");
            dataItemParam0.setDataItem((IDataItem)gridDataItemModel);
            gridDataItemModel.addDataItemParam((IDataItemParam)dataItemParam0);
            gridDataItemModel.init((IGrid)this);
            iGridDataItem = gridDataItemModel;
        }
        this.registerGridDataItem(iGridDataItem);
        iGridDataItem = this.createGridDataItem("wfstepdataname");
        if (iGridDataItem == null) {
            gridDataItemModel = new GridDataItemModel();
            gridDataItemModel.setName("wfstepdataname");
            dataItemParam0 = new DataItemParamModel();
            dataItemParam0.setName("WFSTEPDATANAME");
            dataItemParam0.setFormat("%1$s");
            dataItemParam0.setDataItem((IDataItem)gridDataItemModel);
            gridDataItemModel.addDataItemParam((IDataItemParam)dataItemParam0);
            gridDataItemModel.init((IGrid)this);
            iGridDataItem = gridDataItemModel;
        }
        this.registerGridDataItem(iGridDataItem);
        iGridDataItem = this.createGridDataItem("memo");
        if (iGridDataItem == null) {
            gridDataItemModel = new GridDataItemModel();
            gridDataItemModel.setName("memo");
            dataItemParam0 = new DataItemParamModel();
            dataItemParam0.setName("MEMO");
            dataItemParam0.setFormat("%1$s");
            dataItemParam0.setDataItem((IDataItem)gridDataItemModel);
            gridDataItemModel.addDataItemParam((IDataItemParam)dataItemParam0);
            gridDataItemModel.init((IGrid)this);
            iGridDataItem = gridDataItemModel;
        }
        this.registerGridDataItem(iGridDataItem);
        iGridDataItem = this.createGridDataItem("wfinstanceid");
        if (iGridDataItem == null) {
            gridDataItemModel = new GridDataItemModel();
            gridDataItemModel.setName("wfinstanceid");
            dataItemParam0 = new DataItemParamModel();
            dataItemParam0.setName("WFINSTANCEID");
            dataItemParam0.setFormat("%1$s");
            dataItemParam0.setDataItem((IDataItem)gridDataItemModel);
            gridDataItemModel.addDataItemParam((IDataItemParam)dataItemParam0);
            gridDataItemModel.init((IGrid)this);
            iGridDataItem = gridDataItemModel;
        }
        this.registerGridDataItem(iGridDataItem);
        iGridDataItem = this.createGridDataItem("wfplogicname");
        if (iGridDataItem == null) {
            gridDataItemModel = new GridDataItemModel();
            gridDataItemModel.setName("wfplogicname");
            dataItemParam0 = new DataItemParamModel();
            dataItemParam0.setName("WFPLOGICNAME");
            dataItemParam0.setFormat("%1$s");
            dataItemParam0.setDataItem((IDataItem)gridDataItemModel);
            gridDataItemModel.addDataItemParam((IDataItemParam)dataItemParam0);
            gridDataItemModel.init((IGrid)this);
            iGridDataItem = gridDataItemModel;
        }
        this.registerGridDataItem(iGridDataItem);
        iGridDataItem = this.createGridDataItem("userdatadesc");
        if (iGridDataItem == null) {
            gridDataItemModel = new GridDataItemModel();
            gridDataItemModel.setName("userdatadesc");
            dataItemParam0 = new DataItemParamModel();
            dataItemParam0.setName("USERDATADESC");
            dataItemParam0.setFormat("%1$s");
            dataItemParam0.setDataItem((IDataItem)gridDataItemModel);
            gridDataItemModel.addDataItemParam((IDataItemParam)dataItemParam0);
            gridDataItemModel.init((IGrid)this);
            iGridDataItem = gridDataItemModel;
        }
        this.registerGridDataItem(iGridDataItem);
        iGridDataItem = this.createGridDataItem("sdparam2");
        if (iGridDataItem == null) {
            gridDataItemModel = new GridDataItemModel();
            gridDataItemModel.setName("sdparam2");
            dataItemParam0 = new DataItemParamModel();
            dataItemParam0.setName("SDPARAM2");
            dataItemParam0.setFormat("%1$s");
            dataItemParam0.setDataItem((IDataItem)gridDataItemModel);
            gridDataItemModel.addDataItemParam((IDataItemParam)dataItemParam0);
            gridDataItemModel.init((IGrid)this);
            iGridDataItem = gridDataItemModel;
        }
        this.registerGridDataItem(iGridDataItem);
        iGridDataItem = this.createGridDataItem("srfmajortext");
        if (iGridDataItem == null) {
            gridDataItemModel = new GridDataItemModel();
            gridDataItemModel.setName("srfmajortext");
            dataItemParam0 = new DataItemParamModel();
            dataItemParam0.setName("WFSTEPDATANAME");
            dataItemParam0.setFormat("");
            dataItemParam0.setDataItem((IDataItem)gridDataItemModel);
            gridDataItemModel.addDataItemParam((IDataItemParam)dataItemParam0);
            gridDataItemModel.init((IGrid)this);
            iGridDataItem = gridDataItemModel;
        }
        this.registerGridDataItem(iGridDataItem);
        iGridDataItem = this.createGridDataItem("srfdataaccaction");
        if (iGridDataItem == null) {
            gridDataItemModel = new GridDataItemModel();
            gridDataItemModel.setName("srfdataaccaction");
            gridDataItemModel.setDataAccessAction(true);
            dataItemParam0 = new DataItemParamModel();
            dataItemParam0.setName("WFSTEPDATAID");
            dataItemParam0.setFormat("");
            dataItemParam0.setDataItem((IDataItem)gridDataItemModel);
            gridDataItemModel.addDataItemParam((IDataItemParam)dataItemParam0);
            DataItemParamModel dataItemParam1 = new DataItemParamModel();
            dataItemParam1.setName("NONE");
            dataItemParam1.setFormat("");
            dataItemParam1.setDataItem((IDataItem)gridDataItemModel);
            gridDataItemModel.addDataItemParam((IDataItemParam)dataItemParam1);
            gridDataItemModel.init((IGrid)this);
            iGridDataItem = gridDataItemModel;
        }
        this.registerGridDataItem(iGridDataItem);
        iGridDataItem = this.createGridDataItem("srfkey");
        if (iGridDataItem == null) {
            gridDataItemModel = new GridDataItemModel();
            gridDataItemModel.setName("srfkey");
            dataItemParam0 = new DataItemParamModel();
            dataItemParam0.setName("WFSTEPDATAID");
            dataItemParam0.setFormat("%1$s");
            dataItemParam0.setDataItem((IDataItem)gridDataItemModel);
            gridDataItemModel.addDataItemParam((IDataItemParam)dataItemParam0);
            gridDataItemModel.init((IGrid)this);
            iGridDataItem = gridDataItemModel;
        }
        this.registerGridDataItem(iGridDataItem);
        iGridDataItem = this.createGridDataItem("wfstepid");
        if (iGridDataItem == null) {
            gridDataItemModel = new GridDataItemModel();
            gridDataItemModel.setName("wfstepid");
            dataItemParam0 = new DataItemParamModel();
            dataItemParam0.setName("WFSTEPID");
            dataItemParam0.setFormat("%1$s");
            dataItemParam0.setDataItem((IDataItem)gridDataItemModel);
            gridDataItemModel.addDataItemParam((IDataItemParam)dataItemParam0);
            gridDataItemModel.init((IGrid)this);
            iGridDataItem = gridDataItemModel;
        }
        this.registerGridDataItem(iGridDataItem);
        iGridDataItem = this.createGridDataItem("originalwfuserid");
        if (iGridDataItem == null) {
            gridDataItemModel = new GridDataItemModel();
            gridDataItemModel.setName("originalwfuserid");
            dataItemParam0 = new DataItemParamModel();
            dataItemParam0.setName("ORIGINALWFUSERID");
            dataItemParam0.setFormat("%1$s");
            dataItemParam0.setDataItem((IDataItem)gridDataItemModel);
            gridDataItemModel.addDataItemParam((IDataItemParam)dataItemParam0);
            gridDataItemModel.init((IGrid)this);
            iGridDataItem = gridDataItemModel;
        }
        this.registerGridDataItem(iGridDataItem);
        iGridDataItem = this.createGridDataItem("userdata");
        if (iGridDataItem == null) {
            gridDataItemModel = new GridDataItemModel();
            gridDataItemModel.setName("userdata");
            dataItemParam0 = new DataItemParamModel();
            dataItemParam0.setName("USERDATA");
            dataItemParam0.setFormat("%1$s");
            dataItemParam0.setDataItem((IDataItem)gridDataItemModel);
            gridDataItemModel.addDataItemParam((IDataItemParam)dataItemParam0);
            gridDataItemModel.init((IGrid)this);
            iGridDataItem = gridDataItemModel;
        }
        this.registerGridDataItem(iGridDataItem);
        iGridDataItem = this.createGridDataItem("actiontime");
        if (iGridDataItem == null) {
            gridDataItemModel = new GridDataItemModel();
            gridDataItemModel.setName("actiontime");
            dataItemParam0 = new DataItemParamModel();
            dataItemParam0.setName("ACTIONTIME");
            dataItemParam0.setFormat("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS");
            dataItemParam0.setDataItem((IDataItem)gridDataItemModel);
            gridDataItemModel.addDataItemParam((IDataItemParam)dataItemParam0);
            gridDataItemModel.init((IGrid)this);
            iGridDataItem = gridDataItemModel;
        }
        this.registerGridDataItem(iGridDataItem);
        iGridDataItem = this.createGridDataItem("sdparam");
        if (iGridDataItem == null) {
            gridDataItemModel = new GridDataItemModel();
            gridDataItemModel.setName("sdparam");
            dataItemParam0 = new DataItemParamModel();
            dataItemParam0.setName("SDPARAM");
            dataItemParam0.setFormat("%1$s");
            dataItemParam0.setDataItem((IDataItem)gridDataItemModel);
            gridDataItemModel.addDataItemParam((IDataItemParam)dataItemParam0);
            gridDataItemModel.init((IGrid)this);
            iGridDataItem = gridDataItemModel;
        }
        this.registerGridDataItem(iGridDataItem);
        iGridDataItem = this.createGridDataItem("wfstepname");
        if (iGridDataItem == null) {
            gridDataItemModel = new GridDataItemModel();
            gridDataItemModel.setName("wfstepname");
            dataItemParam0 = new DataItemParamModel();
            dataItemParam0.setName("WFSTEPNAME");
            dataItemParam0.setFormat("%1$s");
            dataItemParam0.setDataItem((IDataItem)gridDataItemModel);
            gridDataItemModel.addDataItemParam((IDataItemParam)dataItemParam0);
            gridDataItemModel.init((IGrid)this);
            iGridDataItem = gridDataItemModel;
        }
        this.registerGridDataItem(iGridDataItem);
        iGridDataItem = this.createGridDataItem("actorid");
        if (iGridDataItem == null) {
            gridDataItemModel = new GridDataItemModel();
            gridDataItemModel.setName("actorid");
            dataItemParam0 = new DataItemParamModel();
            dataItemParam0.setName("ACTORID");
            dataItemParam0.setFormat("%1$s");
            dataItemParam0.setDataItem((IDataItem)gridDataItemModel);
            gridDataItemModel.addDataItemParam((IDataItemParam)dataItemParam0);
            gridDataItemModel.init((IGrid)this);
            iGridDataItem = gridDataItemModel;
        }
        this.registerGridDataItem(iGridDataItem);
        iGridDataItem = this.createGridDataItem("actorname");
        if (iGridDataItem == null) {
            gridDataItemModel = new GridDataItemModel();
            gridDataItemModel.setName("actorname");
            dataItemParam0 = new DataItemParamModel();
            dataItemParam0.setName("ACTORNAME");
            dataItemParam0.setFormat("%1$s");
            dataItemParam0.setDataItem((IDataItem)gridDataItemModel);
            gridDataItemModel.addDataItemParam((IDataItemParam)dataItemParam0);
            gridDataItemModel.init((IGrid)this);
            iGridDataItem = gridDataItemModel;
        }
        this.registerGridDataItem(iGridDataItem);
    }

    protected void prepareGridEditItemModels() throws Exception {
        IGridEditItem iGridEditItem = null;
        iGridEditItem = this.createGridEditItem("srfkey");
        if (iGridEditItem == null) {
            GridEditItemModel gridEditItem = new GridEditItemModel();
            gridEditItem.setGrid((IGrid)this);
            gridEditItem.setName("srfkey");
            gridEditItem.setDEFName("WFSTEPDATAID");
            gridEditItem.setCaption("\u5de5\u4f5c\u6d41\u6b65\u9aa4\u6570\u636e\u6807\u8bc6");
            DataItemModel dataItem = new DataItemModel();
            dataItem.setName("srfkey");
            dataItem.setDataType(25);
            dataItem.setFormat("%1$s");
            DataItemParamModel dataItemParam0 = new DataItemParamModel();
            dataItemParam0.setName("WFSTEPDATAID");
            dataItemParam0.setFormat("%1$s");
            dataItem.addDataItemParam((IDataItemParam)dataItemParam0);
            gridEditItem.setDataItem((IDataItem)dataItem);
            gridEditItem.init();
            iGridEditItem = gridEditItem;
        }
        this.registerGridEditItem(iGridEditItem);
    }
}

