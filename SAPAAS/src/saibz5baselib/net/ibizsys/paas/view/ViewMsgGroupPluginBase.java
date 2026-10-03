package net.ibizsys.paas.view;

import java.util.ArrayList;

import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.core.IPlugin;
import net.ibizsys.paas.core.PluginActionResult;
import net.ibizsys.paas.core.PluginBase;
import net.ibizsys.paas.sysmodel.ISystemPlugin;

/**
 * 视图消息组插件对象基类
 * @author Administrator
 *
 */
public abstract class ViewMsgGroupPluginBase extends PluginBase implements IViewMsgGroupPlugin {

	private IViewMsgGroupPlugin prevViewMsgGroupPlugin = null;
	
	@Override
	public PluginActionResult doGetViewMessages(IViewController iViewController, IViewMsgGroupModel iViewMsgGroupModel, ArrayList<IViewMessage> viewMessageList, Object objParam) throws Exception {
		if(prevViewMsgGroupPlugin!=null)
			return prevViewMsgGroupPlugin.doGetViewMessages(iViewController, iViewMsgGroupModel, viewMessageList,objParam);
		return PluginActionResult.Continue;
	}

	
	@Override
	public void setPrevPlugin(IPlugin iPlugin) {
		super.setPrevPlugin(iPlugin);
		if(iPlugin instanceof IViewMsgGroupPlugin){
			prevViewMsgGroupPlugin = (IViewMsgGroupPlugin)iPlugin;
		}
		if(iPlugin instanceof ISystemPlugin){
			prevViewMsgGroupPlugin = ((ISystemPlugin)iPlugin).getViewMsgGroupPlugin();
		}
	}
}
