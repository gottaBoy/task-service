package net.ibizsys.paas.control.list;

import net.ibizsys.paas.data.IDataItem;

/**
 * 列表数据项接口
 * 
 * @author Administrator
 *
 */
public interface IListDataItem extends IDataItem {

	/**
	 * 获取权限标识
	 * 
	 * @return
	 */
	String getPrivilegeId();
}
