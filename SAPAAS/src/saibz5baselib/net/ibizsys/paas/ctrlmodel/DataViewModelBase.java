package net.ibizsys.paas.ctrlmodel;

import java.util.ArrayList;
import java.util.Iterator;

import net.ibizsys.paas.control.ControlTypes;
import net.ibizsys.paas.control.dataview.IDataViewDataItem;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.sf.json.JSONObject;

/**
 * 数据视图界面模型
 * 
 * @author lionlau
 *
 */
public abstract class DataViewModelBase extends CtrlModelBase implements IDataViewModel {
	protected ArrayList<IDataViewDataItem> dataViewDataItemList = new ArrayList<IDataViewDataItem>();
	private int nPageSize = -1;

	@Override
	protected void onInit() throws Exception {
		super.onInit();

		prepareDataViewDataItems();
	}

	/**
	 * 准备数据视图数据项集合
	 * 
	 * @throws Exception
	 */
	protected void prepareDataViewDataItems() throws Exception {

	}

	/**
	 * 建立数据视图数据项
	 * 
	 * @param strDataItemName
	 * @return
	 * @throws Exception
	 */
	protected IDataViewDataItem createDataViewDataItem(String strDataItemName) throws Exception {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.dataView.IDataView#getDataViewDataItems()
	 */
	@Override
	public Iterator<IDataViewDataItem> getDataViewDataItems() {
		return dataViewDataItemList.iterator();
	}

	/**
	 * 注册数据视图数据项
	 * 
	 * @param iDataViewDataItem
	 */
	protected void registerDataViewDataItem(IDataViewDataItem iDataViewDataItem) {
		this.dataViewDataItemList.add(iDataViewDataItem);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.IDataViewModel#fillFetchResult(net.ibizsys.paas.web.MDAjaxActionResult, net.ibizsys.paas.db.IDataTable)
	 */
	@Override
	public void fillFetchResult(MDAjaxActionResult fetchResult, IDataTable dt) throws Exception {
		if (dt.getCachedRowCount() == -1) {
			while (true) {
				IDataRow iDataRow = dt.next();
				if (iDataRow == null) break;

				JSONObject jo = new JSONObject();
				for (IDataViewDataItem iDataViewDataItem : this.dataViewDataItemList) {
					Object objValue = getDataViewDataItemValue(iDataViewDataItem, iDataRow);
					JSONObjectHelper.put(jo, iDataViewDataItem.getName(), objValue);
					//jo.put(iDataViewDataItem.getName(), objValue);
				}
				fetchResult.getRows().add(jo);

			}
		} else {
			int nRows = dt.getCachedRowCount();
			for (int i = 0; i < nRows; i++) {
				IDataRow iDataRow = dt.getCachedRow(i);

				JSONObject jo = new JSONObject();
				for (IDataViewDataItem iDataViewDataItem : this.dataViewDataItemList) {
					Object objValue = getDataViewDataItemValue(iDataViewDataItem, iDataRow);
					//jo.put(iDataViewDataItem.getName(), objValue);
					JSONObjectHelper.put(jo, iDataViewDataItem.getName(), objValue);
				}
				fetchResult.getRows().add(jo);
			}
		}
	}

	/**
	 * 获取数据视图数据项值
	 * 
	 * @param iDataViewDataItem
	 * @param iDataRow
	 * @return
	 * @throws Exception
	 */
	protected Object getDataViewDataItemValue(IDataViewDataItem iDataViewDataItem, IDataRow iDataRow) throws Exception {
		return iDataViewDataItem.getValue(this.getViewController().getWebContext(), iDataRow);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.IControl#getControlType()
	 */
	@Override
	public String getControlType() {
		return ControlTypes.DataView;
	}

	@Override
	public int getPageSize() {
		return this.nPageSize;
	}

	/**
	 * 设置默认数据分页大小
	 * 
	 * @param nPageSize
	 */
	public void setPageSize(int nPageSize) {
		this.nPageSize = nPageSize;
	}
}
