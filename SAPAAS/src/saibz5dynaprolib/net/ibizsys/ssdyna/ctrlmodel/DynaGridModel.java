package net.ibizsys.ssdyna.ctrlmodel;

import com.fasterxml.jackson.databind.node.ObjectNode;

import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.grid.IPSDEGrid;
import net.ibizsys.model.control.grid.IPSDEGridColumn;
import net.ibizsys.model.control.grid.IPSDEGridEditItem;
import net.ibizsys.model.data.IPSDataItem;
import net.ibizsys.model.data.IPSDataItemParam;
import net.ibizsys.paas.control.grid.IGridColumn;
import net.ibizsys.paas.control.grid.IGridDataItem;
import net.ibizsys.paas.control.grid.IGridEditItem;
import net.ibizsys.paas.ctrlmodel.GridColumnModel;
import net.ibizsys.paas.ctrlmodel.GridDataItemModel;
import net.ibizsys.paas.ctrlmodel.GridEditItemModel;
import net.ibizsys.paas.ctrlmodel.GridModelBase;
import net.ibizsys.paas.data.IDataItemParam;
import net.ibizsys.paas.datamodel.DataItemModel;
import net.ibizsys.paas.datamodel.DataItemParamModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.ssdyna.view.IDynaViewModel;

/**
 * 表格模型对象
 * 
 * @author Administrator
 * 
 */
public class DynaGridModel extends GridModelBase implements IDynaCtrlModel {

	private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(DynaGridModel.class);
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
		return (IPSDEGrid) getPSControl();
	}

	@Override
	public IDataEntityModel getDEModel() {
		try {
			if (getPSControl().getPSDataEntity() != null) {
				return ((IDynaViewModel)this.getViewController()).getDynaSysModel().getDynaDEModel(getPSControl().getPSDataEntity().getId());
			}
		} catch (Exception ex) {
			log.error(ex);
		}
		return super.getDEModel();
	}


	/**
	 * 准备表格列模型
	 * 
	 * @throws Exception
	 */
	@Override
	protected void prepareGridColumnModels() throws Exception {
		super.prepareGridColumnModels();
		IGridColumn iGridColumn = null;
		java.util.Iterator<IPSDEGridColumn> gridColumns = this.getPSDEGrid().getPSDEGridColumns();
		while (gridColumns.hasNext()) {
			IPSDEGridColumn iPSDEGridColumn = gridColumns.next();
			iGridColumn = createGridColumn(iPSDEGridColumn.getName().toLowerCase());
			if (iGridColumn == null) {
				GridColumnModel gridColumnModel = new GridColumnModel();
				gridColumnModel.setName(iPSDEGridColumn.getName().toLowerCase());
				gridColumnModel.setDataItemName(iPSDEGridColumn.getDataItemName());
				gridColumnModel.setCaption(iPSDEGridColumn.getCaption());
				// if((gridcolumn.getPSCodeList()??)>
				// gridColumnModel.setCodeListId("${gridcolumn.getPSCodeList().getClassOrPkgName('CODELIST',pub));
				// }

				gridColumnModel.init(this);
				iGridColumn = gridColumnModel;
			}
			this.registerGridColumn(iGridColumn);

		}

	}

	/**
	 * 准备表格数据项模型
	 * 
	 * @throws Exception
	 */
	@Override
	protected void prepareGridDataItemModels() throws Exception {
		super.prepareGridDataItemModels();
		IGridDataItem iGridDataItem = null;
		java.util.Iterator<IGridDataItem> gridDataItems = this.getPSDEGrid().getGridDataItems();
		while (gridDataItems.hasNext()) {
			IGridDataItem griddataitem = gridDataItems.next();
			// 建立数据项 ${griddataitem.name}
			iGridDataItem = createGridDataItem(griddataitem.getName());
			if (iGridDataItem == null) {
				GridDataItemModel gridDataItemModel = new GridDataItemModel();
				gridDataItemModel.setName(griddataitem.getName());
				if (griddataitem.isDataAccessAction()) {
					gridDataItemModel.setDataAccessAction(true);
				}
				if (griddataitem.getDataItemParams() != null) {
					for (IDataItemParam iDataItemParam2 : griddataitem.getDataItemParams()) {
						IPSDataItemParam iDataItemParam = (IPSDataItemParam) iDataItemParam2;
						DataItemParamModel dataItemParam = new DataItemParamModel();
						if (!StringHelper.isNullOrEmpty(iDataItemParam.getName()))
							dataItemParam.setName(iDataItemParam.getName());
						if (!StringHelper.isNullOrEmpty(iDataItemParam.getFormat()))
							dataItemParam.setFormat(iDataItemParam.getFormat());
						dataItemParam.setDataItem(gridDataItemModel);
						if (iDataItemParam.getPSCodeList() != null && StringHelper.compare(iDataItemParam.getPSCodeList().getCodeListType(), "DYNAMIC", false) == 0) {
							dataItemParam.setCodeListId(iDataItemParam.getPSCodeList().getId());
						}
						gridDataItemModel.addDataItemParam(dataItemParam);
					}
				}

				gridDataItemModel.init(this);
				iGridDataItem = gridDataItemModel;
			}
			this.registerGridDataItem(iGridDataItem);
		}

	}

	/**
	 * 准备表格编辑项模型
	 * 
	 * @throws Exception
	 */
	protected void prepareGridEditItemModels() throws Exception {
		IGridEditItem iGridEditItem = null;
		java.util.Iterator<IGridEditItem> gridEditItems = this.getPSDEGrid().getGridEditItems();
		while (gridEditItems.hasNext()) {
			IPSDEGridEditItem gridedititem = (IPSDEGridEditItem) gridEditItems.next();
			iGridEditItem = this.createGridEditItem(gridedititem.getName().toLowerCase());
			if (iGridEditItem == null) {
				GridEditItemModel gridEditItem = new GridEditItemModel();
				gridEditItem.setGrid(this);
				gridEditItem.setName(gridedititem.getName().toLowerCase());
				gridEditItem.setDEFName(gridedititem.getDEFName());
				if (gridedititem.getEnableCond() != 3) {
					gridEditItem.setEnableCond(gridedititem.getEnableCond());
				}
				if (gridedititem.getIgnoreInput() != 0) {
					gridEditItem.setIgnoreInput(gridedititem.getIgnoreInput());
				}
				if (!StringHelper.isNullOrEmpty(gridedititem.getCreateDVT())) {
					gridEditItem.setCreateDVT(gridedititem.getCreateDVT());
				}
				if (!StringHelper.isNullOrEmpty(gridedititem.getCreateDV())) {
					gridEditItem.setCreateDV(gridedititem.getCreateDV());
				}
				if (!StringHelper.isNullOrEmpty(gridedititem.getUpdateDVT())) {
					gridEditItem.setUpdateDVT(gridedititem.getUpdateDVT());
				}
				if (!StringHelper.isNullOrEmpty(gridedititem.getUpdateDV())) {
					gridEditItem.setUpdateDV(gridedititem.getUpdateDV());
				}
				if (gridedititem.getCodeList() != null) {
					gridEditItem.setCodeListId(gridedititem.getCodeList().getId());
				}
				if (!StringHelper.isNullOrEmpty(gridedititem.getUserDictCatId())) {
					gridEditItem.setUserDictCatId(gridedititem.getUserDictCatId());
				}
				if (!StringHelper.isNullOrEmpty(gridedititem.getCaption())) {
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
				if (!StringHelper.isNullOrEmpty(gridedititem.getValueTranslator())) {
					gridEditItem.setValueTranslator(gridedititem.getValueTranslator());
				}

				// 设置数据项参数
				if (gridedititem.getDataItem() != null) {
					IPSDataItem dataitem = (IPSDataItem) gridedititem.getDataItem();
					DataItemModel dataItem = new DataItemModel();
					dataItem.setName(gridedititem.getName().toLowerCase());
					if (gridedititem.getDEField() != null) {
						dataItem.setDataType(gridedititem.getDEField().getStdDataType());
					}
					dataItem.setFormat(gridedititem.getDataItem().getFormat());

					if (!StringHelper.isNullOrEmpty(dataitem.getCodeListId())) {
						dataItem.setCodeListId(gridedititem.getCodeList().getId());
					}
					if (dataitem.getDataItemParams() != null) {
						for (IDataItemParam iDataItemParam2 : dataitem.getDataItemParams()) {
							IPSDataItemParam dataitemparam = (IPSDataItemParam) iDataItemParam2;
							DataItemParamModel dataItemParam = new DataItemParamModel();
							dataItemParam.setName(dataitemparam.getName());
							dataItemParam.setFormat(dataitemparam.getFormat());
							dataItem.addDataItemParam(dataItemParam);
						}
					}
					gridEditItem.setDataItem(dataItem);
				}
				gridEditItem.init();
				iGridEditItem = gridEditItem;
			}
			this.registerGridEditItem(iGridEditItem);
		}
	}
	
	
	@Override
	public ObjectNode toJsonObject(ObjectNode objectNode) throws Exception {
		if(objectNode == null){
			objectNode = JsonNodeHelper.createObjectNode();
		}
		onFillJsonObject(objectNode);
		return objectNode;
	}
	
	protected void onFillJsonObject(ObjectNode objectNode) throws Exception {
		if(getPSControl()!=null){
			DynaCtrlModelBase.toJsonObject(objectNode,getPSControl());
		}
	}
	
	@Override
	public boolean isDynaCtrl() {
		if(this.getPSControl()!=null){
			return this.getPSControl().isDynamicCtrl();
		}
		return false;
	}
	
	
}
