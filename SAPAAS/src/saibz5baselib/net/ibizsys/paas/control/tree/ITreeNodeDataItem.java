package net.ibizsys.paas.control.tree;

import net.ibizsys.paas.data.IDataItem;

/**
 * 树节点数据项
 * 
 * @author lionlau
 *
 */
public interface ITreeNodeDataItem extends IDataItem {

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
