package net.ibizsys.paas.security;

import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.sysmodel.ISystemUserRoleModel;
import net.ibizsys.paas.web.IWebContext;

/**
 * 用户角色管理器对象接口2，应用于增强的系统用户角色及实体用户角色管理模式
 * @author Administrator
 *
 */
public interface IUserRoleMgr2 {

	
	/**
	 * 设置是否启用增强的系统用户角色
	 * @return
	 */
	void setEnableSysUserRole(boolean bEnableSysUserRole);
	
	
	/**
	 * 设置是否启用增强的系统用户角色
	 * @return
	 */
	boolean isEnableSysUserRole();

	/**
	 * 获取实体操作角色条件
	 * @param iService
	 * @param strDataAccAction
	 * @param iDEDataSetFetchContext
	 * @return
	 * @throws Exception
	 */
	String getDEOPPrivRoleCond(IService iService, String strDataAccAction, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception;
	
	
	
	/**
	 * 判断实体操作角色是否具备指定操作能力
	 * @param iDEModel
	 * @param dataEntity
	 * @param strDataAccAction
	 * @return
	 * @throws Exception
	 */
	boolean testDEOPPrivRoleAction(IWebContext iWebContext,IDataEntityModel iDEModel, IEntity dataEntity, String strDataAccAction) throws Exception;
	
	
	
	/**
	 * 判断当前用户是否具备指定系统用户角色身份
	 * @param strSysUserRoleTag
	 * @return
	 * @throws Exception
	 */
	boolean testSysUserRole(String strSysUserRoleTag) throws Exception;
	
	
	
	/**
	 * 注册系统用户角色身份
	 * @param iSystemUserRoleModel
	 */
	void registerSysUserRole(ISystemUserRoleModel iSystemUserRoleModel);
	
	
	
	/**
	 * 获取系统用户角色身份集合
	 * @return
	 */
	java.util.Iterator<ISystemUserRoleModel> getSysUserRoles();
}
