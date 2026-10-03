package net.ibizsys.paas.core;

/**
 * 系统相关用户角色对象接口
 * 
 * @author Administrator
 *
 */
public interface ISystemUserRole extends ISystemObject {

	/**
	 * 角色类型：自定义
	 */
	public final static String ROLETYPE_CUSTOM = "CUSTOM";

	/**
	 * 角色类型：实体数据集合
	 */
	public final static String ROLETYPE_DEDATASET = "DEDATASET";

	/**
	 * 获取角色标识
	 * 
	 * @return
	 */
	String getRoleTag();

	/**
	 * 获取角色类型，值参考 net.ibizsys.paas.core.ISystemUserRole.ROLETYPE_XXX 定义
	 * 
	 * @return
	 */
	String getRoleType();
	
	
	/**
	 * 获取角色分配的统一资源标识
	 * @return
	 */
	java.util.Iterator<String> getUniResTags();
}
