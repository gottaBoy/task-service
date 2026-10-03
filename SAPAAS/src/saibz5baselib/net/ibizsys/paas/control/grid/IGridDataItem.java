package net.ibizsys.paas.control.grid;

import net.ibizsys.paas.data.IDataItem;

/**
 * 表格数据项
 * 
 * @author lionlau
 *
 */
public interface IGridDataItem extends IDataItem {
	/**
	 * 分组1
	 */
	public final static String GROUPITEM_GROUP1 = "GROUP1";

	/**
	 * 分组2
	 */
	public final static String GROUPITEM_GROUP2 = "GROUP2";

	/**
	 * 分组3
	 */
	public final static String GROUPITEM_GROUP3 = "GROUP3";

	/**
	 * 分组4
	 */
	public final static String GROUPITEM_GROUP4 = "GROUP4";

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

	// /**
	// * 获取表格数据分组项
	// * @return
	// */
	// String getGroupItem();
}
