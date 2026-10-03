package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.appmodel.IApplicationPlugin;
import net.ibizsys.paas.core.IPlugin;
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.view.IViewMsgGroupPlugin;

/**
 * 系统插件
 * @author Administrator
 *
 */
public interface ISystemPlugin extends IPlugin {

	/**
	 * 初始化系统插件
	 * @param iSystemModel
	 * @param strPluginParams
	 * @throws Exception
	 */
	void init(ISystemModel iSystemModel,String strPluginParams) throws Exception;
	
	
	/**
	 * 获取服务插件
	 * @return
	 */
	IServicePlugin getServicePlugin();
	
	
	
	
	
	/**
	 * 获取应用插件
	 * @return
	 */
	IApplicationPlugin getApplicationPlugin();
	
	
	
	
	
	/**
	 * 获取视图消息组插件
	 * @return
	 */
	IViewMsgGroupPlugin getViewMsgGroupPlugin();
	
}
