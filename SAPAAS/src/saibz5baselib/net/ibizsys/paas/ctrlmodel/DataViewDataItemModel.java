package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.control.dataview.IDataView;
import net.ibizsys.paas.control.dataview.IDataViewDataItem;
import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.datamodel.DataItemModel;
import net.ibizsys.paas.demodel.IDataEntityModel;

/**
 * 数据视图数据项模型
 * 
 * @author Administrator
 *
 */
public class DataViewDataItemModel extends DataItemModel implements IDataViewDataItem {
	protected IDataView iDataView = null;

	public DataViewDataItemModel() {

	}

	/**
	 * 初始化
	 * 
	 * @param iDataView
	 * @throws Exception
	 */
	public void init(IDataView iDataView) throws Exception {
		this.iDataView = iDataView;
		this.onInit();
	}

	/**
	 * 获取数据视图部件对象
	 * 
	 * @return the iDataView
	 */
	public IDataView getDataView() {
		return iDataView;
	}

	/**
	 * 设置数据视图部件对象
	 * 
	 * @param iDataView the iDataView to set
	 */
	public void setDataView(IDataView iDataView) {
		this.iDataView = iDataView;
	}

	/**
	 * 获取当前的系统
	 * 
	 * @return
	 */
	@Override
	public ISystem getCurSystem(IActionContext iActionContext) throws Exception {
		return this.getDataView().getDataEntity().getSystem();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.data.impl.DataItemImpl#getDEModel()
	 */
	@Override
	protected IDataEntityModel getDEModel() throws Exception {
		return (IDataEntityModel) this.getDataView().getDataEntity();
	}
}
