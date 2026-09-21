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
 *  net.ibizsys.psrt.srv.wf.demodel.WFStepActorDEModel
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
import net.ibizsys.psrt.srv.wf.demodel.WFStepActorDEModel;

public class AppWFStepActorGridModel
extends GridModelBase {
    private WFStepActorDEModel wFStepActorDEModel;

    public AppWFStepActorGridModel() {
        this.setName("grid");
    }

    protected WFStepActorDEModel getWFStepActorDEModel() {
        if (this.wFStepActorDEModel == null) {
            try {
                this.wFStepActorDEModel = (WFStepActorDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.psrt.srv.wf.demodel.WFStepActorDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.wFStepActorDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getWFStepActorDEModel();
    }

    protected void prepareGridColumnModels() throws Exception {
        GridColumnModel gridColumnModel;
        super.prepareGridColumnModels();
        IGridColumn iGridColumn = null;
        iGridColumn = this.createGridColumn("wfstepactorname");
        if (iGridColumn == null) {
            gridColumnModel = new GridColumnModel();
            gridColumnModel.setName("wfstepactorname");
            gridColumnModel.setDataItemName("wfstepactorname");
            gridColumnModel.setCaption("\u5de5\u4f5c\u6d41\u6b65\u9aa4\u64cd\u4f5c\u8005\u540d\u79f0");
            gridColumnModel.init((IGrid)this);
            iGridColumn = gridColumnModel;
        }
        this.registerGridColumn(iGridColumn);
        iGridColumn = this.createGridColumn("actorid");
        if (iGridColumn == null) {
            gridColumnModel = new GridColumnModel();
            gridColumnModel.setName("actorid");
            gridColumnModel.setDataItemName("actorid");
            gridColumnModel.setCaption("\u5de5\u4f5c\u6d41\u7528\u6237");
            gridColumnModel.init((IGrid)this);
            iGridColumn = gridColumnModel;
        }
        this.registerGridColumn(iGridColumn);
        iGridColumn = this.createGridColumn("firstreadtime");
        if (iGridColumn == null) {
            gridColumnModel = new GridColumnModel();
            gridColumnModel.setName("firstreadtime");
            gridColumnModel.setDataItemName("firstreadtime");
            gridColumnModel.setCaption("\u67e5\u770b\u65f6\u95f4");
            gridColumnModel.init((IGrid)this);
            iGridColumn = gridColumnModel;
        }
        this.registerGridColumn(iGridColumn);
        iGridColumn = this.createGridColumn("wfstepid");
        if (iGridColumn == null) {
            gridColumnModel = new GridColumnModel();
            gridColumnModel.setName("wfstepid");
            gridColumnModel.setDataItemName("wfstepid");
            gridColumnModel.setCaption("\u6b65\u9aa4\u89d2\u8272_\u6b65\u9aa4");
            gridColumnModel.init((IGrid)this);
            iGridColumn = gridColumnModel;
        }
        this.registerGridColumn(iGridColumn);
        iGridColumn = this.createGridColumn("wfstepname");
        if (iGridColumn == null) {
            gridColumnModel = new GridColumnModel();
            gridColumnModel.setName("wfstepname");
            gridColumnModel.setDataItemName("wfstepname");
            gridColumnModel.setCaption("\u6d41\u7a0b\u6b65\u9aa4");
            gridColumnModel.init((IGrid)this);
            iGridColumn = gridColumnModel;
        }
        this.registerGridColumn(iGridColumn);
        iGridColumn = this.createGridColumn("remindercount");
        if (iGridColumn == null) {
            gridColumnModel = new GridColumnModel();
            gridColumnModel.setName("remindercount");
            gridColumnModel.setDataItemName("remindercount");
            gridColumnModel.setCaption("\u7763\u4fc3\u6b21\u6570");
            gridColumnModel.init((IGrid)this);
            iGridColumn = gridColumnModel;
        }
        this.registerGridColumn(iGridColumn);
        iGridColumn = this.createGridColumn("isfinish");
        if (iGridColumn == null) {
            gridColumnModel = new GridColumnModel();
            gridColumnModel.setName("isfinish");
            gridColumnModel.setDataItemName("isfinish");
            gridColumnModel.setCaption("\u662f\u5426\u5b8c\u6210");
            gridColumnModel.setCodeListId("com.demo.test5.srv.codelist.YesNoCodeListModel");
            gridColumnModel.init((IGrid)this);
            iGridColumn = gridColumnModel;
        }
        this.registerGridColumn(iGridColumn);
        iGridColumn = this.createGridColumn("isreadonly");
        if (iGridColumn == null) {
            gridColumnModel = new GridColumnModel();
            gridColumnModel.setName("isreadonly");
            gridColumnModel.setDataItemName("isreadonly");
            gridColumnModel.setCaption("\u662f\u5426\u53ea\u8bfb");
            gridColumnModel.setCodeListId("com.demo.test5.srv.codelist.YesNoCodeListModel");
            gridColumnModel.init((IGrid)this);
            iGridColumn = gridColumnModel;
        }
        this.registerGridColumn(iGridColumn);
        iGridColumn = this.createGridColumn("actortype");
        if (iGridColumn == null) {
            gridColumnModel = new GridColumnModel();
            gridColumnModel.setName("actortype");
            gridColumnModel.setDataItemName("actortype");
            gridColumnModel.setCaption("\u7528\u6237\u7c7b\u578b");
            gridColumnModel.init((IGrid)this);
            iGridColumn = gridColumnModel;
        }
        this.registerGridColumn(iGridColumn);
        iGridColumn = this.createGridColumn("memo");
        if (iGridColumn == null) {
            gridColumnModel = new GridColumnModel();
            gridColumnModel.setName("memo");
            gridColumnModel.setDataItemName("memo");
            gridColumnModel.setCaption("\u5907\u6ce8");
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
        iGridDataItem = this.createGridDataItem("firstreadtime");
        if (iGridDataItem == null) {
            gridDataItemModel = new GridDataItemModel();
            gridDataItemModel.setName("firstreadtime");
            dataItemParam0 = new DataItemParamModel();
            dataItemParam0.setName("FIRSTREADTIME");
            dataItemParam0.setFormat("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS");
            dataItemParam0.setDataItem((IDataItem)gridDataItemModel);
            gridDataItemModel.addDataItemParam((IDataItemParam)dataItemParam0);
            gridDataItemModel.init((IGrid)this);
            iGridDataItem = gridDataItemModel;
        }
        this.registerGridDataItem(iGridDataItem);
        iGridDataItem = this.createGridDataItem("actortype");
        if (iGridDataItem == null) {
            gridDataItemModel = new GridDataItemModel();
            gridDataItemModel.setName("actortype");
            dataItemParam0 = new DataItemParamModel();
            dataItemParam0.setName("ACTORTYPE");
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
            dataItemParam0.setName("WFSTEPACTORNAME");
            dataItemParam0.setFormat("");
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
        iGridDataItem = this.createGridDataItem("remindercount");
        if (iGridDataItem == null) {
            gridDataItemModel = new GridDataItemModel();
            gridDataItemModel.setName("remindercount");
            dataItemParam0 = new DataItemParamModel();
            dataItemParam0.setName("REMINDERCOUNT");
            dataItemParam0.setFormat("%1$s");
            dataItemParam0.setDataItem((IDataItem)gridDataItemModel);
            gridDataItemModel.addDataItemParam((IDataItemParam)dataItemParam0);
            gridDataItemModel.init((IGrid)this);
            iGridDataItem = gridDataItemModel;
        }
        this.registerGridDataItem(iGridDataItem);
        iGridDataItem = this.createGridDataItem("srfkey");
        if (iGridDataItem == null) {
            gridDataItemModel = new GridDataItemModel();
            gridDataItemModel.setName("srfkey");
            dataItemParam0 = new DataItemParamModel();
            dataItemParam0.setName("WFSTEPACTORID");
            dataItemParam0.setFormat("%1$s");
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
            dataItemParam0.setName("WFSTEPACTORID");
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
        iGridDataItem = this.createGridDataItem("isreadonly");
        if (iGridDataItem == null) {
            gridDataItemModel = new GridDataItemModel();
            gridDataItemModel.setName("isreadonly");
            dataItemParam0 = new DataItemParamModel();
            dataItemParam0.setName("ISREADONLY");
            dataItemParam0.setFormat("%1$s");
            dataItemParam0.setDataItem((IDataItem)gridDataItemModel);
            gridDataItemModel.addDataItemParam((IDataItemParam)dataItemParam0);
            gridDataItemModel.init((IGrid)this);
            iGridDataItem = gridDataItemModel;
        }
        this.registerGridDataItem(iGridDataItem);
        iGridDataItem = this.createGridDataItem("wfstepactorname");
        if (iGridDataItem == null) {
            gridDataItemModel = new GridDataItemModel();
            gridDataItemModel.setName("wfstepactorname");
            dataItemParam0 = new DataItemParamModel();
            dataItemParam0.setName("WFSTEPACTORNAME");
            dataItemParam0.setFormat("%1$s");
            dataItemParam0.setDataItem((IDataItem)gridDataItemModel);
            gridDataItemModel.addDataItemParam((IDataItemParam)dataItemParam0);
            gridDataItemModel.init((IGrid)this);
            iGridDataItem = gridDataItemModel;
        }
        this.registerGridDataItem(iGridDataItem);
        iGridDataItem = this.createGridDataItem("isfinish");
        if (iGridDataItem == null) {
            gridDataItemModel = new GridDataItemModel();
            gridDataItemModel.setName("isfinish");
            dataItemParam0 = new DataItemParamModel();
            dataItemParam0.setName("ISFINISH");
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
    }

    protected void prepareGridEditItemModels() throws Exception {
        IGridEditItem iGridEditItem = null;
        iGridEditItem = this.createGridEditItem("srfkey");
        if (iGridEditItem == null) {
            GridEditItemModel gridEditItem = new GridEditItemModel();
            gridEditItem.setGrid((IGrid)this);
            gridEditItem.setName("srfkey");
            gridEditItem.setDEFName("WFSTEPACTORID");
            gridEditItem.setCaption("\u5de5\u4f5c\u6d41\u6b65\u9aa4\u64cd\u4f5c\u8005\u6807\u8bc6");
            DataItemModel dataItem = new DataItemModel();
            dataItem.setName("srfkey");
            dataItem.setDataType(25);
            dataItem.setFormat("%1$s");
            DataItemParamModel dataItemParam0 = new DataItemParamModel();
            dataItemParam0.setName("WFSTEPACTORID");
            dataItemParam0.setFormat("%1$s");
            dataItem.addDataItemParam((IDataItemParam)dataItemParam0);
            gridEditItem.setDataItem((IDataItem)dataItem);
            gridEditItem.init();
            iGridEditItem = gridEditItem;
        }
        this.registerGridEditItem(iGridEditItem);
    }
}

