package net.ibizsys.paas.control.dataview;

import net.ibizsys.paas.control.IControl;

/**
 * 数据视图接口
 * 
 * @author Administrator
 *
 */
public interface IDataView extends IControl {

	/**
	 * 获取数据
	 */
	final static String FetchAction = "fetch";

	/**
	 * 获取视图数据数据项集合
	 * 
	 * @return
	 */
	java.util.Iterator<IDataViewDataItem> getDataViewDataItems();
}
