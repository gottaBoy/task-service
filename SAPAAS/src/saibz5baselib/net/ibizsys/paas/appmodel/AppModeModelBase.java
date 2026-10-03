package net.ibizsys.paas.appmodel;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.ctrlhandler.ICtrlHandler;
import net.ibizsys.paas.ctrlmodel.IAppMenuModel;
import net.ibizsys.paas.view.IViewMessage;
import net.ibizsys.paas.view.IViewMsgGroupModel;
import net.ibizsys.paas.view.IViewWizard;
import net.ibizsys.paas.view.IViewWizardGroupModel;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.AppDataAjaxActionResult;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.Page;

/**
 * 应用程序模式模型对象基类
 * @author Administrator
 *
 */
public abstract class AppModeModelBase extends AppModelBaseBase implements IAppModeModel {

	private static final Log log = LogFactory.getLog(AppModeModelBase.class);
	private IApplicationModel iApplicationModel = null;
	private String strMode = null;
	
	@Override
	public void init(IApplicationModel iApplicationModel) throws Exception {
		this.iApplicationModel = iApplicationModel;
		this.onInit();
	}
	
	@Override
	public IApplicationModel getAppModel() {
		return this.iApplicationModel;
	}
	
	@Override
	public ISystem getSystem() {
		return getAppModel().getSystem();
	}

	

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.appmodel.IAppModeModel#getMode()
	 */
	@Override
	public String getMode() {
		return this.strMode;
	}
	
	/**
	 * 设置模式
	 * @param strMode
	 */
	public void setMode(String strMode){
		this.strMode = strMode;
	}
	
	/**
	 * 设置标识
	 */
	public void setId(String strId)
	{
		super.setId(strId);
	}
	
	/**
	 * 设置名称
	 */
	public void setName(String strName)
	{
		super.setName(strName);
	}
	
	
	/**
	 * 设置前端技术架构
	 */
	public void setPFType(String strPFType){
		super.setPFType(strPFType);
	}
	

	@Override
	public boolean doFilter(IViewController iViewController, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return getAppModel().doFilter(iViewController, request, response);
	}

	@Override
	public boolean doFilter(Page page, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return getAppModel().doFilter(page, request, response);
	}

	@Override
	public IWebContext createWebContext(IViewController iViewController, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return getAppModel().createWebContext(iViewController, request, response);
	}

	@Override
	public AjaxActionResult doViewCtrlAjaxAction(IViewController iViewController, HttpServletRequest request, HttpServletResponse response, String strCtrlId, String strAction, ICtrlHandler iCtrlHandler) throws Exception {
		return getAppModel().doViewCtrlAjaxAction(iViewController, request, response, strCtrlId, strAction, iCtrlHandler);
	}

	@Override
	public AjaxActionResult doFilterViewAction(IViewController iViewController, HttpServletRequest request, HttpServletResponse response, String strAction, AjaxActionResult ajaxActionResult) throws Exception {
		return getAppModel().doFilterViewAction(iViewController, request, response, strAction, ajaxActionResult);
	}

	@Override
	public void registerAppView(IAppViewModel iAppViewModel) throws Exception {
		getAppModel().registerAppView(iAppViewModel);
	}

	@Override
	public IAppViewModel getAppView(String strAppViewId, boolean bTryMode) throws Exception {
		return getAppModel().getAppView(strAppViewId, bTryMode);
	}

	@Override
	public IAppDEViewModel getAppViewByDEViewId(String strDEViewId, boolean bTryMode) throws Exception {
		return getAppModel().getAppViewByDEViewId(strDEViewId, bTryMode);
	}


	@Override
	public IAppMenuModel getAppMenuModel(String strUserMode) throws Exception {
		return getAppModel().getAppMenuModel(strUserMode);
	}

	@Override
	public void registerUserModeMenu(String strUserMode, String strAppMenuModelId) throws Exception {
		getAppModel().registerUserModeMenu(strUserMode, strAppMenuModelId);
	}

	@Override
	public Iterator<IViewMessage> getViewMessages(IViewController iViewController, IViewMsgGroupModel iViewMsgGroupModel) throws Exception {
		return getAppModel().getViewMessages(iViewController, iViewMsgGroupModel);
	}

	@Override
	public Iterator<IViewWizard> getViewWizards(IViewController iViewController, IViewWizardGroupModel iViewWizardGroupModel, String strQuery) throws Exception {
		return getAppModel().getViewWizards(iViewController, iViewWizardGroupModel, strQuery);
	}

	@Override
	public boolean testUserViewAccess(IViewController iViewController, IWebContext iWebContext) throws Exception {
		return getAppModel().testUserViewAccess(iViewController, iWebContext);
	}

	@Override
	public void setApplicationPlugin(IApplicationPlugin iApplicationPlugin) throws Exception {
		getAppModel().setApplicationPlugin(iApplicationPlugin);
	}

	@Override
	public void setApplicationPlugin(IApplicationPlugin iApplicationPlugin, boolean bIgnoreOrigin) throws Exception {
		getAppModel().setApplicationPlugin(iApplicationPlugin, bIgnoreOrigin);
	}

	@Override
	public IApplicationPlugin getApplicationPlugin() {
		return getAppModel().getApplicationPlugin();
	}

	@Override
	public String getAppFolder() {
		return getAppModel().getAppFolder();
	}

	@Override
	public void fillAppDataAjaxActionResult(IViewController iViewController, AppDataAjaxActionResult appDataAjaxActionResult) throws Exception {
		getAppModel().fillAppDataAjaxActionResult(iViewController, appDataAjaxActionResult);
	}

	@Override
	public void logException(Object logger, Throwable throwable, String strMessage, Object objUserData) {
		getAppModel().logException(logger, throwable, strMessage, objUserData);
	}

	
	
	
}
