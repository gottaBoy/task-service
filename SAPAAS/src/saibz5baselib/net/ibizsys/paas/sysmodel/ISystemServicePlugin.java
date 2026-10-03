package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.service.IServicePlugin;

/**
 * 系统服务插件对象接口
 * @author Administrator
 *
 */
public interface ISystemServicePlugin extends IServicePlugin {
	
	
	/**
	 * 注册系统服务插件
	 * @param strDEName
	 * @param iServicePlugin
	 * @throws Exception
	 */
	void registerServicePlugin(String strDEName,IServicePlugin iServicePlugin)throws Exception;
}
