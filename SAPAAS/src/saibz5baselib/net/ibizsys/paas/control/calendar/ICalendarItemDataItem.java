package net.ibizsys.paas.control.calendar;

import net.ibizsys.paas.data.IDataItem;

/**
 * 日历项数据项
 * 
 * @author lionlau
 *
 */
public interface ICalendarItemDataItem extends IDataItem {

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
