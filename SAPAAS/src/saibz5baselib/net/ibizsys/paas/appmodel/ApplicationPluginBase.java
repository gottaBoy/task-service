package net.ibizsys.paas.appmodel;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.controller.IViewControllerPlugin;
import net.ibizsys.paas.core.IPlugin;
import net.ibizsys.paas.core.PluginActionResult;
import net.ibizsys.paas.core.PluginBase;
import net.ibizsys.paas.ctrlhandler.ICtrlHandler;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.view.IViewMessage;
import net.ibizsys.paas.view.IViewMsgGroupModel;
import net.ibizsys.paas.view.IViewWizard;
import net.ibizsys.paas.view.IViewWizardGroupModel;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.Page;

/**
 * 应用程序插件对象基类
 * @author Administrator
 *
 */
public abstract class ApplicationPluginBase extends PluginBase implements IApplicationPlugin {

	private IApplicationPlugin prevApplicationPlugin = null;
	private HashMap<String, IViewControllerPlugin> viewControllerPluginMap = null;
	private IViewControllerPlugin defaultViewControllerPlugin = null;

	@Override
	public void setPrevPlugin(IPlugin iPlugin) {
		super.setPrevPlugin(iPlugin);
		if(iPlugin instanceof IApplicationPlugin){
			prevApplicationPlugin = (IApplicationPlugin)iPlugin;
		}
	}

	@Override
	public PluginActionResult doGetCtrlRender(IApplicationModel iApplicationModel, String strCtrlType, String strRender, Object objParam) {
		if(prevApplicationPlugin!=null)
			return prevApplicationPlugin.doGetCtrlRender(iApplicationModel, strCtrlType, strRender, objParam);
		return PluginActionResult.Continue;
	}

	@Override
	public PluginActionResult doFilter(IApplicationModel iApplicationModel, IViewController iViewController, HttpServletRequest request, HttpServletResponse response, Object objParam) throws Exception {
		if(prevApplicationPlugin!=null)
			return prevApplicationPlugin.doFilter(iApplicationModel, iViewController, request, response, objParam);
		return PluginActionResult.Continue;
	}

	@Override
	public PluginActionResult doFilter(IApplicationModel iApplicationModel, Page page, HttpServletRequest request, HttpServletResponse response, Object objParam) throws Exception {
		if(prevApplicationPlugin!=null)
			return prevApplicationPlugin.doFilter(iApplicationModel, page, request, response, objParam);
		return PluginActionResult.Continue;
	}

	@Override
	public PluginActionResult doTestUserAccess(IViewController iViewController, IWebContext iWebContext, boolean bSendBack, Object objParam) throws Exception {
		
		if(viewControllerPluginMap!=null){
			IViewControllerPlugin iViewControllerPlugin = viewControllerPluginMap.get(iViewController.getId());
			if(iViewControllerPlugin!=null){
				PluginActionResult pluginActionResult = iViewControllerPlugin.doTestUserAccess(iViewController, iWebContext, bSendBack, objParam);
				if(pluginActionResult==PluginActionResult.Replace)
					return pluginActionResult;
			}
		}
		if(prevApplicationPlugin!=null)
			return prevApplicationPlugin.doTestUserAccess(iViewController, iWebContext, bSendBack, objParam);
		return PluginActionResult.Continue;
	}

	@Override
	public PluginActionResult doViewCtrlAjaxAction(IViewController iViewController, HttpServletRequest request, HttpServletResponse response, String strCtrlId, String strAction, ICtrlHandler iCtrlHandler, Object objParam) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PluginActionResult doGetViewMessages(IViewController iViewController, IViewMsgGroupModel iViewMsgGroupModel, ArrayList<IViewMessage> viewMessageList, Object objParam) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PluginActionResult doGetViewWizards(IViewController iViewController, IViewWizardGroupModel iViewWizardGroupModel, String strQuery, ArrayList<IViewWizard> viewWizardList, Object objParam) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 * 获取视图控制器插件
	 * @param iViewController
	 * @return
	 */
	protected IViewControllerPlugin getViewControllerPlugin(IViewController iViewController){
		if(viewControllerPluginMap!=null){
			IViewControllerPlugin iViewControllerPlugin =  viewControllerPluginMap.get(iViewController.getId());
			if(iViewControllerPlugin!=null){
				return iViewControllerPlugin;
			}
		}
		return defaultViewControllerPlugin;
	}
	
	
	/**
	 * 注册视图控制器
	 * @param strViewControllerId
	 * @param iViewControllerPlugin
	 */
	protected void registerViewControllerPlugin(String strViewControllerId,IViewControllerPlugin iViewControllerPlugin){
		if(StringHelper.isNullOrEmpty(strViewControllerId)){
			this.defaultViewControllerPlugin = iViewControllerPlugin;
		}
		else{
			if(viewControllerPluginMap==null){
				viewControllerPluginMap = new HashMap<String, IViewControllerPlugin>();
			}
			viewControllerPluginMap.put(strViewControllerId, iViewControllerPlugin);
		}
		
	}
	
	
}
