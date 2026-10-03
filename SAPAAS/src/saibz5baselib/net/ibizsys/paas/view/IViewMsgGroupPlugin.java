package net.ibizsys.paas.view;

import java.util.ArrayList;

import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.core.IPlugin;
import net.ibizsys.paas.core.PluginActionResult;

/**
 * 系统消息插件
 * @author Administrator
 *
 */
public interface IViewMsgGroupPlugin extends IPlugin {
	
	/**
	 * 获取视图消息集合
	 * @param iViewController 视图控制器
	 * @param iViewMsgGroupModel
	 * @return
	 * @throws Exception
	 */
	PluginActionResult doGetViewMessages(IViewController iViewController,IViewMsgGroupModel iViewMsgGroupModel,ArrayList<IViewMessage> viewMessageList,Object objParam) throws Exception;

}
