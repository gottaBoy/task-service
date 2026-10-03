package net.ibizsys.paas.core;

/**
 * 实体数据集合系统用户角色对象接口
 * @author Administrator
 *
 */
public interface IDEDataSetSystemUserRole extends ISystemUserRole {
	
	/**
	 * 获取实体名称
	 * 
	 * @return
	 */
	String getDEName();

	/**
	 * 获取实体数据集合名称
	 * 
	 * @return
	 */
	String getDEDataSetName();
}
