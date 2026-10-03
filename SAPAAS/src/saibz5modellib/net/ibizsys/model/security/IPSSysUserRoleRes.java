package net.ibizsys.model.security;

import net.ibizsys.model.core.IPSModelObject;


/**
 * 系统用户角色资源对象接口
 * @author Administrator
 *
 */
public interface IPSSysUserRoleRes extends IPSModelObject {

	
	
	
	/**
	 * 获取系统用户角色
	 * @return
	 */
	IPSSysUserRole getPSSysUserRole();
	
	
	
	
	/**
	 * 获取系统统一资源
	 * @return
	 */
	IPSSysUniRes getPSSysUniRes();
	
}
