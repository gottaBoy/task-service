package net.ibizsys.paas.control.list;

import net.ibizsys.paas.control.IControl;

/**
 * 列表控件接口
 * 
 * @author lionlau
 *
 */
public interface IList extends IControl {
	/**
	 * 获取列表数据项集合
	 * 
	 * @return
	 */
	java.util.Iterator<IListDataItem> getListDataItems();
}
