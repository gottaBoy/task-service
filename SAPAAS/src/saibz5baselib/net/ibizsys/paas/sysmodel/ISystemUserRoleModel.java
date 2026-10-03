package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.core.ISystemUserRole;
import net.ibizsys.paas.web.IWebContext;

/**
 * 系统用户角色模型接口
 * 
 * @author lionlau
 *
 */
public interface ISystemUserRoleModel extends ISystemUserRole {

	
	/**
	 * 初始化
	 * @param iSystemModel
	 * @throws Exception
	 */
	void init(ISystemModel iSystemModel)throws Exception;
	
	
	
	/**
	 * 获取系统模型对象
	 * @return
	 */
	ISystemModel getSystemModel();
	
	
	
	/**
	 * 注册角色拥有的统一资源标记
	 * @param strUniResTag
	 */
	void registerUniResTag(String strUniResTag);
	
	
	/**
	 * 判断统一资源标识
	 * @param strUniResTag
	 * @return
	 */
	boolean testUniResTag(String strUniResTag)throws Exception;
	
	
	/**
	 * 判断当前用户是否在角色中
	 * @param iWebContext
	 * @return
	 * @throws Exception
	 */
	boolean testCurUser(IWebContext iWebContext)throws Exception;
}
