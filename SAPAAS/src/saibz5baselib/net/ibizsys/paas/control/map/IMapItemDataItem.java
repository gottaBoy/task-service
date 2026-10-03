package net.ibizsys.paas.control.map;

import net.ibizsys.paas.data.IDataItem;

/**
 *地图项数据项
 * 
 * @author lionlau
 *
 */
public interface IMapItemDataItem extends IDataItem {

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
