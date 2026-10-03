package net.ibizsys.paas.sysmodel;

import java.util.ArrayList;
import java.util.HashMap;

import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.core.PluginActionResult;
import net.ibizsys.paas.view.IViewMessage;
import net.ibizsys.paas.view.IViewMsgGroupModel;
import net.ibizsys.paas.view.IViewMsgGroupPlugin;
import net.ibizsys.paas.view.ViewMsgGroupPluginBase;

/**
 * 系统的视图消息组插件
 * @author Administrator
 *
 */
public class SystemViewMsgGroupPlugin extends ViewMsgGroupPluginBase implements ISystemViewMsgGroupPlugin {

	protected HashMap<String, IViewMsgGroupPlugin> iViewMsgGroupPluginMap = new HashMap<String, IViewMsgGroupPlugin>();
	

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.sysmodel.ISystemViewMsgGroupPlugin#registerViewMsgGroupPlugin(java.lang.String, net.ibizsys.paas.view.IViewMsgGroupPlugin)
	 */
	@Override
	public void registerViewMsgGroupPlugin(String strUniqueTag,IViewMsgGroupPlugin iViewMsgGroupPlugin)throws Exception{
		iViewMsgGroupPluginMap.put(strUniqueTag, iViewMsgGroupPlugin);
	}


	@Override
	public PluginActionResult doGetViewMessages(IViewController iViewController, IViewMsgGroupModel iViewMsgGroupModel, ArrayList<IViewMessage> viewMessageList, Object objParam) throws Exception {
		IViewMsgGroupPlugin iViewMsgGroupPlugin = iViewMsgGroupPluginMap.get(iViewMsgGroupModel.getUniqueTag());
		if(iViewMsgGroupPlugin == null){
			iViewMsgGroupPlugin = iViewMsgGroupPluginMap.get("");
		}
		if(iViewMsgGroupPlugin!=null){
			PluginActionResult pluginActionResult =	iViewMsgGroupPlugin.doGetViewMessages(iViewController, iViewMsgGroupModel, viewMessageList, objParam);
			if(pluginActionResult== PluginActionResult.Replace)
				return pluginActionResult;
		}
		return super.doGetViewMessages(iViewController, iViewMsgGroupModel, viewMessageList, objParam);
	}
	
	
	
}
