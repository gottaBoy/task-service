package net.ibizsys.paas.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.ibizsys.paas.core.IPlugin;
import net.ibizsys.paas.core.PluginActionResult;
import net.ibizsys.paas.ctrlhandler.ICtrlHandler;
import net.ibizsys.paas.view.IViewMessage;
import net.ibizsys.paas.view.IViewMsgGroupModel;
import net.ibizsys.paas.view.IViewWizard;
import net.ibizsys.paas.view.IViewWizardGroupModel;
import net.ibizsys.paas.web.IWebContext;

/**
 * 视图控制器插件
 * @author Administrator
 *
 */
public interface IViewControllerPlugin extends IPlugin {

	/**
	 * 执行判断用户访问操作
	 * @param iViewController
	 * @param iWebContext
	 * @param bSendBack
	 * @param objParam
	 * @return
	 * @throws Exception
	 */
	PluginActionResult doTestUserAccess(IViewController iViewController,IWebContext iWebContext,boolean bSendBack,Object objParam) throws Exception;

	/**
	 * 执行视图控件Ajax操作
	 * @param iViewController
	 * @param request
	 * @param response
	 * @param strCtrlId
	 * @param strAction
	 * @param iCtrlHandler
	 * @param objParam
	 * @return
	 * @throws Exception
	 */
	PluginActionResult doViewCtrlAjaxAction(IViewController iViewController, HttpServletRequest request, HttpServletResponse response, String strCtrlId, String strAction, ICtrlHandler iCtrlHandler,Object objParam) throws Exception;


	

	/**
	 * 获取视图消息集合
	 * @param iApplicationModel
	 * @param iViewController
	 * @param iViewMsgGroupModel
	 * @param viewMessageList
	 * @param objParam
	 * @return
	 * @throws Exception
	 */
	PluginActionResult doGetViewMessages(IViewController iViewController, IViewMsgGroupModel iViewMsgGroupModel,ArrayList<IViewMessage> viewMessageList,Object objParam) throws Exception;
	

	/**
	 * 获取视图向导集合
	 * @param iViewController
	 * @param iViewWizardGroupModel
	 * @param strQuery
	 * @param viewWizardList
	 * @param objParam
	 * @return
	 * @throws Exception
	 */
	PluginActionResult doGetViewWizards(IViewController iViewController, IViewWizardGroupModel iViewWizardGroupModel,String strQuery,ArrayList<IViewWizard> viewWizardList,Object objParam) throws Exception;
}
