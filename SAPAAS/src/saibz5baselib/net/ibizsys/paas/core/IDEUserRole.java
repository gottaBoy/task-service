package net.ibizsys.paas.core;

/**
 * 实体相关用户角色对象接口
 * @author Administrator
 *
 */
public interface IDEUserRole extends IDataEntityObject {

	/**
	 * 初始化
	 * 
	 * @param iDataEntity
	 * @throws Exception
	 */
	void init(IDataEntity iDataEntity) throws Exception;
	
	/**
	 * 获取角色标识
	 * @return
	 */
	String getRoleTag();
}
