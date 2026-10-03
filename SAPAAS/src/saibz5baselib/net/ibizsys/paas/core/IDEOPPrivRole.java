package net.ibizsys.paas.core;

/**
 * 实体数据操作标识相关角色接口
 * 
 * @author Administrator
 *
 */
public interface IDEOPPrivRole extends IDataEntityObject {

	/**
	*角色类型：系统角色
	*/
	public final static String ROLETYPE_SYSROLE = "SYSROLE" ;

	/**
	*角色类型：实体角色
	*/
	public final static String ROLETYPE_DEROLE = "DEROLE" ;
	
	/**
	*角色类型：无角色，仅定义能力
	*/
	public final static String ROLETYPE_NONE = "NONE" ;
	
	/**
	 * 初始化
	 * 
	 * @param iDataEntity
	 * @throws Exception
	 */
	void init(IDataEntity iDataEntity) throws Exception;
	
	/**
	 * 获取实体操作标识
	 * @return
	 */
	String getDEOPPrivTag();
	
	/**
	 * 获取角色类型，值参考net.ibizsys.paas.core.IDEOPPrivRole.ROLETYPE_XXX 定义
	 * @return
	 */
	String getRoleType();
	
	
	/**
	 * 获取数据查询标识
	 * 
	 * @return
	 */
	String getDEDataQueryId();
	
	
	
	/**
	 * 获取系统用户角色标识
	 * @return
	 */
	String getSysUserRoleId();

	
	
	/**
	 * 获取实体用户角色标识
	 * @return
	 */
	String getDEUserRoleId();
}
