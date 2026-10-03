package net.ibizsys.ssdyna.ctrlmodel;

import com.fasterxml.jackson.databind.node.ObjectNode;

import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.dataview.IPSDEDataView;
import net.ibizsys.model.data.IPSDataItemParam;
import net.ibizsys.paas.control.dataview.IDataViewDataItem;
import net.ibizsys.paas.ctrlmodel.DataViewDataItemModel;
import net.ibizsys.paas.ctrlmodel.DataViewModelBase;
import net.ibizsys.paas.data.IDataItemParam;
import net.ibizsys.paas.datamodel.DataItemParamModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.ssdyna.view.IDynaViewModel;

/**
 * 数据视图模型对象
 * 
 * @author Administrator
 * 
 */
public class DynaDataViewModel extends DataViewModelBase implements IDynaCtrlModel {

	private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(DynaDataViewModel.class);
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
		return (IPSDEDataView) getPSControl();
	}

	/**
	 * 准备数据视图项模型
	 * 
	 * @throws Exception
	 */
	protected void prepareDataViewDataItems() throws Exception {
		super.prepareDataViewDataItems();
		IDataViewDataItem iDataViewDataItem = null;
		java.util.Iterator<IDataViewDataItem> dataviewDataItems = this.getPSDEDataView().getDataViewDataItems();
		while (dataviewDataItems.hasNext()) {
			IDataViewDataItem iDataItem = dataviewDataItems.next();
			// ${iDataItem.name}
			iDataViewDataItem = this.createDataViewDataItem(iDataItem.getName());
			if (iDataViewDataItem == null) {
				DataViewDataItemModel dataViewDataItem = new DataViewDataItemModel();
				dataViewDataItem.setDataView(this);
				dataViewDataItem.setName(iDataItem.getName());
				dataViewDataItem.setDataType(iDataItem.getDataType());
				if (!StringHelper.isNullOrEmpty(iDataItem.getFormat())) {
					dataViewDataItem.setFormat(iDataItem.getFormat());
				}

				// 注册参数

				if (iDataItem.getDataItemParams() != null) {
					for (IDataItemParam iDataItemParam2 : iDataItem.getDataItemParams()) {
						IPSDataItemParam iDataItemParam = (IPSDataItemParam) iDataItemParam2;
						DataItemParamModel dataItemParam = new DataItemParamModel();
						if (!StringHelper.isNullOrEmpty(iDataItemParam.getName()))
							dataItemParam.setName(iDataItemParam.getName());
						if (!StringHelper.isNullOrEmpty(iDataItemParam.getFormat()))
							dataItemParam.setFormat(iDataItemParam.getFormat());
						dataItemParam.setDataItem(dataViewDataItem);
						if (iDataItemParam.getPSCodeList() != null && StringHelper.compare(iDataItemParam.getPSCodeList().getCodeListType(), "DYNAMIC", false) == 0) {
							dataItemParam.setCodeListId(iDataItemParam.getPSCodeList().getId());
						}
						dataViewDataItem.addDataItemParam(dataItemParam);
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
}
