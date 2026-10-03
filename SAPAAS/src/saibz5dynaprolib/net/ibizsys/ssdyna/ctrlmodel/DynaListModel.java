package net.ibizsys.ssdyna.ctrlmodel;


import com.fasterxml.jackson.databind.node.ObjectNode;

import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.list.IPSDEList;
import net.ibizsys.model.control.list.IPSListDataItem;
import net.ibizsys.model.data.IPSDataItemParam;
import net.ibizsys.paas.control.list.IListDataItem;
import net.ibizsys.paas.ctrlmodel.ListDataItemModel;
import net.ibizsys.paas.ctrlmodel.ListModelBase;
import net.ibizsys.paas.data.IDataItemParam;
import net.ibizsys.paas.datamodel.DataItemParamModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.ssdyna.view.IDynaViewModel;

/**
 * 列表模型对象
 * 
 * @author Administrator
 * 
 */
public class DynaListModel extends ListModelBase implements IDynaCtrlModel {

	private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(DynaListModel.class);
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

	public IPSDEList getPSDEList() {
		return (IPSDEList) getPSControl();
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

	
	@Override
	protected void onInit() throws Exception {
		if(this.getPSDEList().getPagingSize()>0){
			this.setPageSize(this.getPSDEList().getPagingSize());
		}
		super.onInit();
	}


	/**
	 * 准备列表数据项模型
	 * 
	 * @throws Exception
	 */
	@Override
	protected void prepareListDataItemModels() throws Exception {
		super.prepareListDataItemModels();
		IListDataItem iListDataItem = null;
		java.util.Iterator<IListDataItem> listDataItems = this.getPSDEList().getListDataItems();
		while (listDataItems.hasNext()) {
			IPSListDataItem iListDataItem2 = (IPSListDataItem)listDataItems.next();
			// 建立数据项 ${iListDataItem2.name}
			iListDataItem = null;//createListDataItem(iListDataItem2.getName());
			if (iListDataItem == null) {
				ListDataItemModel listDataItemModel = new ListDataItemModel();
				listDataItemModel.setName(iListDataItem2.getName());
				listDataItemModel.setDataType(iListDataItem2.getDataType());
				if(!StringHelper.isNullOrEmpty(iListDataItem2.getFormat())){
					listDataItemModel.setFormat(iListDataItem2.getFormat());
				}
				if(iListDataItem2.getPSCodeList()!=null){
				          //设置代码表 ${listDataItem.getPSCodeList().name}
					listDataItemModel.setCodeListId(iListDataItem2.getPSCodeList().getId());
				} 

				if (iListDataItem2.getDataItemParams() != null) {
					for (IDataItemParam iDataItemParam2 : iListDataItem2.getDataItemParams()) {
						IPSDataItemParam iDataItemParam = (IPSDataItemParam) iDataItemParam2;
						DataItemParamModel dataItemParam = new DataItemParamModel();
						if (!StringHelper.isNullOrEmpty(iDataItemParam.getName()))
							dataItemParam.setName(iDataItemParam.getName());
						if (!StringHelper.isNullOrEmpty(iDataItemParam.getFormat()))
							dataItemParam.setFormat(iDataItemParam.getFormat());
						dataItemParam.setDataItem(listDataItemModel);
						if (iDataItemParam.getPSCodeList() != null && StringHelper.compare(iDataItemParam.getPSCodeList().getCodeListType(), "DYNAMIC", false) == 0) {
							dataItemParam.setCodeListId(iDataItemParam.getPSCodeList().getId());
						}
						listDataItemModel.addDataItemParam(dataItemParam);
					}
				}

				listDataItemModel.init(this);
				iListDataItem = listDataItemModel;
			}
			this.registerListDataItem(iListDataItem);
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
