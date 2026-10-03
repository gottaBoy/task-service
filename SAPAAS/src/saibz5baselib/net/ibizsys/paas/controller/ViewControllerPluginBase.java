package net.ibizsys.paas.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.ibizsys.paas.core.IPlugin;
import net.ibizsys.paas.core.PluginActionResult;
import net.ibizsys.paas.core.PluginBase;
import net.ibizsys.paas.ctrlhandler.ICtrlHandler;
import net.ibizsys.paas.view.IViewMessage;
import net.ibizsys.paas.view.IViewMsgGroupModel;
import net.ibizsys.paas.view.IViewWizard;
import net.ibizsys.paas.view.IViewWizardGroupModel;
import net.ibizsys.paas.web.IWebContext;

/**
 * 视图控制器插件对象基类
 * @author Administrator
 *
 */
public abstract class ViewControllerPluginBase extends PluginBase implements IViewControllerPlugin {

	private IViewControllerPlugin prevViewControllerPlugin = null;


	@Override
	public void setPrevPlugin(IPlugin iPlugin) {
		super.setPrevPlugin(iPlugin);
		if(iPlugin instanceof IViewControllerPlugin){
			prevViewControllerPlugin = (IViewControllerPlugin)iPlugin;
		}
	}
	
	
	
	
	

	@Override
	public PluginActionResult doTestUserAccess(IViewController iViewController, IWebContext iWebContext, boolean bSendBack, Object objParam) throws Exception {
		if(prevViewControllerPlugin!=null)
			return prevViewControllerPlugin.doTestUserAccess(iViewController,  iWebContext,  bSendBack,  objParam);
		return PluginActionResult.Continue;
	}






	@Override
	public PluginActionResult doViewCtrlAjaxAction(IViewController iViewController, HttpServletRequest request, HttpServletResponse response, String strCtrlId, String strAction, ICtrlHandler iCtrlHandler, Object objParam) throws Exception {
		if(prevViewControllerPlugin!=null)
			return prevViewControllerPlugin.doViewCtrlAjaxAction(iViewController, request,  response,  strCtrlId,  strAction,  iCtrlHandler,  objParam);
		return PluginActionResult.Continue;
	}






	@Override
	public PluginActionResult doGetViewMessages(IViewController iViewController, IViewMsgGroupModel iViewMsgGroupModel, ArrayList<IViewMessage> viewMessageList, Object objParam) throws Exception {
		if(prevViewControllerPlugin!=null)
			return prevViewControllerPlugin.doGetViewMessages(iViewController,iViewMsgGroupModel, viewMessageList,  objParam);
		return PluginActionResult.Continue;
	}






	@Override
	public PluginActionResult doGetViewWizards(IViewController iViewController, IViewWizardGroupModel iViewWizardGroupModel, String strQuery, ArrayList<IViewWizard> viewWizardList, Object objParam) throws Exception {
		if(prevViewControllerPlugin!=null)
			return prevViewControllerPlugin.doGetViewWizards(iViewController,iViewWizardGroupModel, strQuery, viewWizardList, objParam);
		return PluginActionResult.Continue;
	}



	
	
}
