package net.ibizsys.ssdyna.demodel;

import net.ibizsys.model.dataentity.ac.IPSDEACMode;
import net.ibizsys.paas.data.IDataItem;
import net.ibizsys.paas.datamodel.DataItemModel3;
import net.ibizsys.paas.demodel.DEACModelBase;

/**
 * 动态实体自动填充模型对象
 * @author Administrator
 *
 */
public class DynaDEACModel extends DEACModelBase {
	
	private IDynaDEModel iDynaDEModel = null;
	private IPSDEACMode iPSDEACMode = null;
	private boolean bDefault = false;
	
	
	public void init(IDynaDEModel iDynaDEModel,IPSDEACMode iPSDEACMode)throws Exception{
		this.iDynaDEModel =iDynaDEModel;
		this.iPSDEACMode = iPSDEACMode;
		this.init(iDynaDEModel);
		this.strId = this.iPSDEACMode.getId();
		this.strName = this.iPSDEACMode.getName();
		this.bDefault = this.iPSDEACMode.isDefaultMode();
		if(iPSDEACMode.getMinorSortPSDEF()!=null){
			 //设置默认排序 
	         this.setMinorSortField(iPSDEACMode.getMinorSortPSDEF().getName());
	    	 this.setMinorSortDir(iPSDEACMode.getMinorSortDir());
		}
		
		this.iPSDEACMode = null;
	}
	
	
	@Override
	protected void onInit() throws Exception {
		
		prepareDataItems();
		super.onInit();
	}

	
	/**
	 * 准备实体自填模型
	 * 
	 * @param deACMode
	 */
	protected void prepareDataItems() {
		
		/**
		 * TODO 代码表标识没有转换
		 */
		java.util.Iterator<IDataItem  > dataItems = iPSDEACMode.getDataItems();
		while(dataItems.hasNext()){
			IDataItem iDataItem = dataItems.next();
			this.registerDataItem(this.createDataItem(iDataItem));
		}

	}


	/**
	 * 建立数据项
	 * 
	 * @param dataItem
	 * @return
	 */
	protected IDataItem createDataItem(IDataItem dataItem) {
		DataItemModel3 dataItemModel = new DataItemModel3();
		dataItemModel.init(dataItem);
		return dataItemModel;
	}

	@Override
	public String getId() {
		return this.strId;
	}
	
	@Override
	public String getName() {
		return this.strName;
	}
	@Override
	public boolean isDefaultMode() {
		return 	this.bDefault;
	}
	
	
	
}
