package net.ibizsys.paas.control.grid;

import net.ibizsys.paas.control.IControl;

/**
 * 表格部件接口
 * 
 * @author lionlau
 *
 */
public interface IGrid extends IControl {
	/**
	 * 搜索数据
	 */
	final static String FetchAction = "fetch";

	/**
	 * 获取表格列接口集合
	 * 
	 * @return
	 */
	java.util.Iterator<IGridColumn> getGridColumns();

	/**
	 * 获取表格数据项集合
	 * 
	 * @return
	 */
	java.util.Iterator<IGridDataItem> getGridDataItems();

	/**
	 * 获取表格编辑项集合
	 * 
	 * @return
	 */
	java.util.Iterator<IGridEditItem> getGridEditItems();

}
