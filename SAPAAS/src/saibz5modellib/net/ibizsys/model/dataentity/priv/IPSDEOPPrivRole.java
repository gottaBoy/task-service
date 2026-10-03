package net.ibizsys.model.dataentity.priv;

import net.ibizsys.model.dataentity.IPSDataEntityObject;
import net.ibizsys.model.dataentity.ds.IPSDEDataQuery;
import net.ibizsys.paas.core.IDEOPPrivRole;


/**
 * 实体操作标识角色对象接口
 * @author lionlau
 *
 */
public interface IPSDEOPPrivRole extends IPSDataEntityObject,IDEOPPrivRole
{

	

	/**
	 * 获取实体操作标识对象
	 * @return
	 */
	IPSDEOPPriv getPSDEOPPriv();
	
	
	/**
	 * 获取控制范围的数据查询对象
	 * @return
	 */
	IPSDEDataQuery getPSDEDataQuery();
	
	
	/**
	 * 获取实体用户角色对象
	 * @return
	 */
	IPSDEUserRole getPSDEUserRole();
	
	
//	/**
//	 * 获取系统用户角色对象
//	 * @return
//	 */
//	IPSSysUserRole getPSSysUserRole();
}
