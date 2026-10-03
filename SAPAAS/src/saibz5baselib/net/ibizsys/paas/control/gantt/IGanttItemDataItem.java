package net.ibizsys.paas.control.gantt;

import net.ibizsys.paas.data.IDataItem;

/**
 * 甘特项数据项
 * 
 * @author lionlau
 *
 */
public interface IGanttItemDataItem extends IDataItem {

	/**
	 * 数据范围控制
	 * 
	 * @return
	 */
	boolean isDataAccessAction();

	/**
	 * 获取权限标识
	 * 
	 * @return
	 */
	String getPrivilegeId();


}
