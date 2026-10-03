package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.view.IViewMsgGroupPlugin;

/**
 * 系统视图消息组插件
 * @author Administrator
 *
 */
public interface ISystemViewMsgGroupPlugin extends IViewMsgGroupPlugin {
	
	/**
	 * 注册视图消息组插件
	 * @param strViewMsgGroupTag
	 * @param iViewMsgGroupPlugin
	 * @throws Exception
	 */
	void registerViewMsgGroupPlugin(String strViewMsgGroupTag,IViewMsgGroupPlugin iViewMsgGroupPlugin)throws Exception;
}
