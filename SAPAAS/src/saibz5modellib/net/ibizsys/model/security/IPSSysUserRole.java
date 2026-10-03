package net.ibizsys.model.security;

import net.ibizsys.model.IPSSystemObject;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.paas.core.ISystemUserRole;


/**
 * 系统用户角色对象接口
 * @author lionlau
 *
 */
public interface IPSSysUserRole extends IPSSystemObject,ISystemUserRole,IPSModelObject
{

	

	
	
	
	/**
	 * 获取角色类型
	 * @return
	 */
	String getRoleType();
	
	
	/**
	 * 获取实体集合的实体对象
	 * @return
	 */
	IPSDataEntity getPSDE();
	
	
	
	/**
	 * 获取实体集合对象
	 * @return
	 */
	IPSDEDataSet getPSDEDataSet();
	
	
	
	
	/**
	 * 获取系统用户角色所拥有的统一资源
	 * @return
	 */
	java.util.Iterator<IPSSysUserRoleRes> getPSSysUserRoleReses();
}
