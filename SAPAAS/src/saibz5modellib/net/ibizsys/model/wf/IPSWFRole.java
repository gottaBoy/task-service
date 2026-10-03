package net.ibizsys.model.wf;

import net.ibizsys.model.IPSSystemObject;
import net.ibizsys.pswf.core.IWFRoleModel;


/**
 * 工作流角色对象接口
 * 
 * @author lionlau
 *
 */
public interface IPSWFRole extends IPSSystemObject, IWFRoleModel {
	


	/**
	 * 获取逻辑名称
	 * 
	 * @return
	 */
	String getLogicName();

	/**
	 * 获取用户数据
	 * 
	 * @return
	 */
	String getUserData();

	/**
	 * 获取用户数据2
	 * 
	 * @return
	 */
	String getUserData2();

	/**
	 * 获取用户角色编号
	 * 
	 * @return
	 */
	String getWFRoleSN();
//	
//	/**
//	 * 获取系统模块
//	 * @return
//	 */
//	IPSSystemModule getPSSystemModule();
}
