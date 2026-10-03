package net.ibizsys.paas.appmodel;

import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.control.ControlTypes;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.core.IApplication;
import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.ctrlhandler.ICtrlHandler;
import net.ibizsys.paas.ctrlhandler.ICtrlRender;
import net.ibizsys.paas.ctrlmodel.AppMenuModelGlobal;
import net.ibizsys.paas.ctrlmodel.IAppMenuModel;
import net.ibizsys.paas.security.RemoteLoginGlobal;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.util.ObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.view.IViewMessage;
import net.ibizsys.paas.view.IViewMsgGroupModel;
import net.ibizsys.paas.view.IViewWizard;
import net.ibizsys.paas.view.IViewWizardGroupModel;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.AppDataAjaxActionResult;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.Page;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.psrt.srv.common.entity.LoginLog;

/**
 * 应用程序模型基类
 * 
 * @author lionlau
 */
public abstract class AppModelBaseBase extends ModelBase3Impl implements IApplicationModel
 {
	

	private static final Log log = LogFactory.getLog(AppModelBaseBase.class);

	/**
	 * 部件绘制器Map
	 */
	private HashMap<String, ICtrlRender> ctrlRenderMap = new HashMap<String, ICtrlRender>();

	/**
	 * 应用技术
	 */
	protected String strPFType = null;

	/**
	 * 功能页面路径Map
	 */
	private HashMap<String, String> utilPageUrlMap = new HashMap<String, String>();

	/**
	 * 应用视图Map
	 */
	private HashMap<String, IAppViewModel> appViewMap = new HashMap<String, IAppViewModel>();

	/**
	 * 实体应用视图Map
	 */
	private HashMap<String, IAppDEViewModel> appDEViewMap = new HashMap<String, IAppDEViewModel>();

	/**
	 * 用户菜单模式Map
	 */
	private HashMap<String, String> userModeMenuMap = new HashMap<String, String>();

	/**
	 * 应用框架辅助对象
	 */
	private IAppPFHelper iAppModeHelper = null;
	
	/**
	 * 应用程序插件
	 */
	private IApplicationPlugin iApplicationPlugin  = null;

	
	private int nAppType = IApplication.APPTYPE_UNKNOWN;
	
	private String strAppFolder = null;
	
	private boolean bOutputFormItemUpdatePrivTag = false;
	 
	public AppModelBaseBase() {

	}

	/**
	 * 设置应用标识
	 * 
	 * @param strId
	 * 
	 */
	protected void setId(String strId) {
		this.strId = strId;
	}

	/**
	 * 设置应用名称
	 * 
	 * @param strName
	 */
	protected void setName(String strName) {
		this.strName = strName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.appmodel.IApplicationModel#doFilter(net.ibizsys.paas.controller.IViewController, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public boolean doFilter(IViewController iViewController, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.appmodel.IApplicationModel#doFilter(net.ibizsys.paas.web.Page, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public boolean doFilter(Page page, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IApplication#getPFType()
	 */
	@Override
	public String getPFType() {
		return this.strPFType;
	}

	/**
	 * 设置应用技术
	 * 
	 * @param strPFType
	 */
	protected void setPFType(String strPFType) {
		this.strPFType = strPFType;

		this.registerUtilPageUrl(UTILPAGE_DOWNLOADTMPFILE, "/ibizutil/exportfile3.jsp?");
		this.registerUtilPageUrl(UTILPAGE_LOGIN, "/ibizutil/login.jsp?");
		this.registerUtilPageUrl(UTILPAGE_LOGOUT, "/ibizutil/logout.jsp?");
		this.registerUtilPageUrl(UTILPAGE_INTERNALERROR, "/ibizutil/showerror.jsp?");
		this.registerUtilPageUrl(UTILPAGE_ACCESSDENY, "/ibizutil/accessdeny.jsp?");
		this.registerUtilPageUrl(UTILPAGE_PASSWORDEXPIRED, "/ibizutil/passwordexpired.jsp?");
		
		// 根据技术类型，注册默认绘制器
		if(!StringHelper.isNullOrEmpty(this.strPFType)){
		
			//注册通用绘制器
			try{
				this.registerCtrlRender(ControlTypes.Chart, "ECHARTS3", (ICtrlRender) ObjectHelper.create("net.ibizsys.paas.web.jquery.render.ChartEcharts3Render"));
			}
			catch(Exception ex){
				log.error(ex);
			}
			
			//if (StringHelper.compare(this.strPFType, PF_JQUERY, true) == 0 || StringHelper.compare(this.strPFType, PF_JQUERY_R2, true) == 0) {
			if (this.strPFType.indexOf( PF_JQUERY ) == 0){
				try {
					iAppModeHelper = (IAppPFHelper) ObjectHelper.create("net.ibizsys.paas.appmodel.jquery.JQAppPFHelper");
					iAppModeHelper.init(this);
					this.registerCtrlRender(ControlTypes.DRBar, "JSTREE", (ICtrlRender) ObjectHelper.create("net.ibizsys.paas.web.jquery.render.DRBarJSTreeRender"));
					this.registerCtrlRender(ControlTypes.ExpBar, "JSTREE", (ICtrlRender) ObjectHelper.create("net.ibizsys.paas.web.jquery.render.ExpBarJSTreeRender"));
					this.registerCtrlRender(ControlTypes.TreeExpBar, "JSTREE", (ICtrlRender) ObjectHelper.create("net.ibizsys.paas.web.jquery.render.ExpBarJSTreeRender"));
					this.registerCtrlRender(ControlTypes.WFExpBar, "JSTREE", (ICtrlRender) ObjectHelper.create("net.ibizsys.paas.web.jquery.render.WFExpBarJSTreeRender"));
					this.registerCtrlRender(ControlTypes.TreeView, "JSTREE", (ICtrlRender) ObjectHelper.create("net.ibizsys.paas.web.jquery.render.TreeJSTreeRender"));
					this.registerCtrlRender(ControlTypes.Grid, "BOOTSTRAPTABLE", (ICtrlRender) ObjectHelper.create("net.ibizsys.paas.web.jquery.render.GridBootstrapTableRender"));
					this.registerCtrlRender(ControlTypes.Grid, "JQUERYDATATABLES", (ICtrlRender) ObjectHelper.create("net.ibizsys.paas.web.jquery.render.GridJQueryDatatableRender"));
					this.registerCtrlRender(ControlTypes.Grid, "PQGRID", (ICtrlRender) ObjectHelper.create("net.ibizsys.paas.web.jquery.render.GridPQGridRender"));
					this.registerCtrlRender(ControlTypes.Chart, "ECHARTS3", (ICtrlRender) ObjectHelper.create("net.ibizsys.paas.web.jquery.render.ChartEcharts3Render"));
				} catch (Exception ex) {
					log.error(ex);
				}
				return;
			}
			if (this.strPFType.indexOf( PF_EXTJS5 ) == 0){
		//	if (StringHelper.compare(this.strPFType, PF_EXTJS5, true) == 0) {
				try {
					iAppModeHelper = (IAppPFHelper) ObjectHelper.create("net.ibizsys.paas.appmodel.extjs.ExtJSAppPFHelper");
					iAppModeHelper.init(this);

					this.registerCtrlRender(ControlTypes.Chart, "ECHARTS3", (ICtrlRender) ObjectHelper.create("net.ibizsys.paas.web.extjs.render.ChartEcharts3Render"));
				} catch (Exception ex) {
					log.error(ex);
				}
				return;
			}
			
			if (this.strPFType.indexOf( PF_ANGULARJS ) == 0){
		//	if (StringHelper.compare(this.strPFType, PF_ANGULARJS, true) == 0) {
				try {
					iAppModeHelper = (IAppPFHelper) ObjectHelper.create("net.ibizsys.paas.appmodel.angularjs.NGAppPFHelper");
					iAppModeHelper.init(this);

					this.registerCtrlRender(ControlTypes.Chart, "ECHARTS3", (ICtrlRender) ObjectHelper.create("net.ibizsys.paas.web.jquery.render.ChartEcharts3Render"));
					this.registerCtrlRender(ControlTypes.TreeView, "JSTREE", (ICtrlRender) ObjectHelper.create("net.ibizsys.paas.web.jquery.render.TreeJSTreeRender2"));
					this.registerCtrlRender(ControlTypes.ExpBar, "JSTREE", (ICtrlRender) ObjectHelper.create("net.ibizsys.paas.web.jquery.render.ExpBarJSTreeRender2"));
					this.registerCtrlRender(ControlTypes.TreeExpBar, "JSTREE", (ICtrlRender) ObjectHelper.create("net.ibizsys.paas.web.jquery.render.ExpBarJSTreeRender2"));
				} catch (Exception ex) {
					log.error(ex);
				}
				return;
			}
			
			if (this.strPFType.indexOf( PF_ANGULAR ) == 0){
				try {
					iAppModeHelper = (IAppPFHelper) ObjectHelper.create("net.ibizsys.paas.appmodel.angular.AngularAppPFHelper");
					iAppModeHelper.init(this);
					
					this.registerCtrlRender(ControlTypes.Chart, "ECHARTS3", (ICtrlRender) ObjectHelper.create("net.ibizsys.paas.web.jquery.render.ChartEcharts3Render"));
				} catch (Exception ex) {
					log.error(ex);
				}
				return;
			}
			
			if (this.strPFType.indexOf( PF_IONIC4_R6 ) == 0){
				try {
					iAppModeHelper = (IAppPFHelper) ObjectHelper.create("net.ibizsys.paas.appmodel.ionic.Ionic4R6AppPFHelper");
					iAppModeHelper.init(this);
				} catch (Exception ex) {
					log.error(ex);
				}
				return;
			}
			
			if (this.strPFType.indexOf( PF_IONIC ) == 0){
				try {
					iAppModeHelper = (IAppPFHelper) ObjectHelper.create("net.ibizsys.paas.appmodel.ionic.IonicAppPFHelper");
					iAppModeHelper.init(this);
				} catch (Exception ex) {
					log.error(ex);
				}
				return;
			}
			
			if (this.strPFType.indexOf( PF_VUEMOB ) == 0){
				try {
					iAppModeHelper = (IAppPFHelper) ObjectHelper.create("net.ibizsys.paas.appmodel.vue.VueMobAppPFHelper");
					iAppModeHelper.init(this);
				} catch (Exception ex) {
					log.error(ex);
				}
				return;
			}
			
			if (this.strPFType.indexOf( PF_VUE_R3 ) == 0){
				try {
					iAppModeHelper = (IAppPFHelper) ObjectHelper.create("net.ibizsys.ssdyna.appmodel.Vue3AppPFHelper");
					iAppModeHelper.init(this);
				} catch (Exception ex) {
					log.error(ex);
				}
				return;
			}
			
			
			if (this.strPFType.indexOf( PF_VUE ) == 0){
				try {
					iAppModeHelper = (IAppPFHelper) ObjectHelper.create("net.ibizsys.paas.appmodel.vue.VueAppPFHelper");
					iAppModeHelper.init(this);
				} catch (Exception ex) {
					log.error(ex);
				}
				return;
			}
			
			if (this.strPFType.indexOf( PF_REACTMOB ) == 0){
				try {
					iAppModeHelper = (IAppPFHelper) ObjectHelper.create("net.ibizsys.paas.appmodel.vue.VueMobAppPFHelper");
					iAppModeHelper.init(this);
				} catch (Exception ex) {
					log.error(ex);
				}
				return;
			}
			
			if (this.strPFType.indexOf( PF_REACT ) == 0){
				try {
					iAppModeHelper = (IAppPFHelper) ObjectHelper.create("net.ibizsys.paas.appmodel.react.ReactAppPFHelper");
					iAppModeHelper.init(this);
				} catch (Exception ex) {
					log.error(ex);
				}
				return;
			}
		}
	}

	/**
	 * 建立HTTP访问上下文对象
	 * 
	 * @param iViewController 视图控制器对象
	 * @param request
	 * @param response
	 * @return Web访问上下文对象
	 * @throws Exception
	 */
	@Override
	public IWebContext createWebContext(IViewController iViewController, HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (StringHelper.isNullOrEmpty(WebConfig.getCurrent().getWebContextObj())) {
			IWebContext iWebContext = new WebContext();
			iWebContext.init(request, response, request.getSession().getServletContext());
			doRemoteLogin(iWebContext);
			return iWebContext;
		} else {
			IWebContext iWebContext = (IWebContext) ObjectHelper.create(WebConfig.getCurrent().getWebContextObj());
			iWebContext.init(request, response, request.getSession().getServletContext());
			doRemoteLogin(iWebContext);
			return iWebContext;
		}
	}

	/**
	 * 执行远程登录处理
	 * 
	 * @param iWebContext 请求上下文
	 * @throws Exception
	 */
	protected void doRemoteLogin(IWebContext iWebContext) throws Exception {
		if (!StringHelper.isNullOrEmpty(iWebContext.getCurUserId())) return;

		String strLoginKey = WebContext.getLoginKey(iWebContext);
		if (StringHelper.isNullOrEmpty(strLoginKey)) {
			return;
		}

		LoginLog loginLog = RemoteLoginGlobal.getLoginLog(strLoginKey);
		if (loginLog == null) {
			return;
		}

		iWebContext.remoteLogin(loginLog);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.appmodel.IApplicationModel#doViewCtrlAjaxAction(net.ibizsys.paas.controller.IViewController, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.String, java.lang.String, net.ibizsys.paas.ctrlhandler.ICtrlHandler)
	 */
	@Override
	public AjaxActionResult doViewCtrlAjaxAction(IViewController iViewController, HttpServletRequest request, HttpServletResponse response, String strCtrlId, String strAction, ICtrlHandler iCtrlHandler) throws Exception {
		return iCtrlHandler.processAction(strAction, iViewController.getWebContext());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.appmodel.IApplicationModel#doFilterViewAction(net.ibizsys.paas.controller.IViewController, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.String, net.ibizsys.paas.web.AjaxActionResult)
	 */
	@Override
	public AjaxActionResult doFilterViewAction(IViewController iViewController, HttpServletRequest request, HttpServletResponse response, String strAction, AjaxActionResult ajaxActionResult) throws Exception {
		return ajaxActionResult;
	}

	/**
	 * 注册控件绘制器
	 * 
	 * @param strCtrlType 控件类型
	 * @param strRender 绘制器类型
	 * @param iCtrlRender 绘制器接口
	 * @throws Exception
	 */
	protected void registerCtrlRender(String strCtrlType, String strRender, ICtrlRender iCtrlRender) throws Exception {
		String strKey = StringHelper.format("%1$s|%2$s", strCtrlType, strRender);
		this.ctrlRenderMap.put(strKey, iCtrlRender);
	}

	/**
	 * 注册应用功能页面路径
	 * 
	 * @param strUtilPage 功能页面类型
	 * @param strPageUrl 功能页面路径
	 */
	protected void registerUtilPageUrl(String strUtilPage, String strPageUrl) {
		utilPageUrlMap.put(strUtilPage, strPageUrl);
	}

	/**
	 * 注销控件绘制器
	 * 
	 * @param strCtrlType 控件类型
	 * @param strRender 绘制器名称
	 * @param iCtrlRender 绘制器对象
	 * @throws Exception
	 */
	protected void unRegisterCtrlRender(String strCtrlType, String strRender, ICtrlRender iCtrlRender) throws Exception {
		String strKey = StringHelper.format("%1$s|%2$s", strCtrlType, strRender);
		this.ctrlRenderMap.remove(strKey);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.appmodel.IApplicationModel#getCtrlRender(java.lang.String, java.lang.String)
	 */
	@Override
	public ICtrlRender getCtrlRender(String strCtrlType, String strRender) {
		String strKey = StringHelper.format("%1$s|%2$s", strCtrlType, strRender);
		return ctrlRenderMap.get(strKey);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.appmodel.IApplicationModel#getUtilPageUrl(java.lang.String)
	 */
	@Override
	public String getUtilPageUrl(String strUtilType) throws Exception {
		return utilPageUrlMap.get(strUtilType);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.appmodel.IApplicationModel#installRTDatas()
	 */
	@Override
	public void installRTDatas() throws Exception {
		onInstallRTDatas();
	}

	/**
	 * 安装运行时数据
	 * 
	 * @throws Exception
	 */
	protected void onInstallRTDatas() throws Exception {

	}


	/**
	 * 内部注册视图
	 * @param strAppViewId
	 * @param strAppViewName
	 * @param strDEViewId
	 * @param strTitle
	 * @param strModuleName
	 * @throws Exception
	 */
	protected void registerAppView(String strAppViewId,String strAppViewName,String strDEViewId,String strTitle,String strModuleName,String strOpenMode,int nWidth,int nHeight)throws Exception{
		if(StringHelper.isNullOrEmpty(strDEViewId)){
			AppViewModel appViewModel = new AppViewModel();
			appViewModel.setId(strAppViewId);
			appViewModel.setName(strAppViewName);
			appViewModel.setTitle(strTitle);
			appViewModel.setModuleName(strModuleName);
			appViewModel.setOpenMode(strOpenMode);
			if(nWidth>0){
				appViewModel.setWidth(nWidth);
			}
			if(nHeight>0){
				appViewModel.setHeight(nHeight);
			}
			this.registerAppView(appViewModel);
		}
		else{
			AppDEViewModel appViewModel = new AppDEViewModel();
			appViewModel.setId(strAppViewId);
			appViewModel.setName(strAppViewName);
			appViewModel.setTitle(strTitle);
			appViewModel.setModuleName(strModuleName);
			appViewModel.setDEViewId(strDEViewId);
			appViewModel.setOpenMode(strOpenMode);
			if(nWidth>0){
				appViewModel.setWidth(nWidth);
			}
			if(nHeight>0){
				appViewModel.setHeight(nHeight);
			}
			this.registerAppView(appViewModel);
		}
	}
	
	
	/**
	 * 注册应用视图
	 * 
	 * @param iAppViewModel 应用视图模型
	 * @throws Exception
	 */
	@Override
	public void registerAppView(IAppViewModel iAppViewModel) throws Exception {
		appViewMap.put(iAppViewModel.getId(), iAppViewModel);
		if (iAppViewModel instanceof IAppDEViewModel) {
			IAppDEViewModel iAppDEViewModel = (IAppDEViewModel) iAppViewModel;
			if (!StringHelper.isNullOrEmpty(iAppDEViewModel.getDEViewId())) {
				appDEViewMap.put(iAppDEViewModel.getDEViewId(), iAppDEViewModel);
			}
		}
	}

	/**
	 * 获取应用视图
	 * 
	 * @param strAppViewId 视图标识
	 * @param bTryMode 是否尝试获取
	 * @return
	 * @throws Exception
	 */
	@Override
	public IAppViewModel getAppView(String strAppViewId, boolean bTryMode) throws Exception {
		IAppViewModel iAppViewModel = appViewMap.get(strAppViewId);
		if (iAppViewModel == null && !bTryMode) {
			throw new Exception(StringHelper.format("无法获取指定应用视图[%1$s]", strAppViewId));
		}
		return iAppViewModel;
	}

	/**
	 * 获取应用实体视图
	 * 
	 * @param strDEViewId 实体视图标识
	 * @param bTryMode 尝试模式
	 * @return
	 * @throws Exception
	 */
	@Override
	public IAppDEViewModel getAppViewByDEViewId(String strDEViewId, boolean bTryMode) throws Exception {
		IAppDEViewModel iAppDEViewModel = appDEViewMap.get(strDEViewId);
		if (iAppDEViewModel == null && !bTryMode) {
			throw new Exception(StringHelper.format("无法获取指定应用实体视图[%1$s]", strDEViewId));
		}
		return iAppDEViewModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.appmodel.IApplicationModel#getAppModelHelper()
	 */
	@Override
	public IAppPFHelper getAppPFHelper() {
		return iAppModeHelper;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.appmodel.IApplicationModel#getAppMenuModel(java.lang.String)
	 */
	@Override
	public IAppMenuModel getAppMenuModel(String strUserMode) throws Exception {
		if (strUserMode == null) strUserMode = "";
		String strAppMenuModelId = this.userModeMenuMap.get(strUserMode);
		if (StringHelper.isNullOrEmpty(strAppMenuModelId)) {
			strAppMenuModelId = this.userModeMenuMap.get("");
			if (StringHelper.isNullOrEmpty(strAppMenuModelId)) {
				throw new Exception(StringHelper.format("无法获取指定用户模式应用菜单模型"));
			}
		}
		return AppMenuModelGlobal.getAppMenuModel(strAppMenuModelId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.appmodel.IApplicationModel#registerUserModeMenu(java.lang.String, java.lang.String)
	 */
	@Override
	public void registerUserModeMenu(String strUserMode, String strAppMenuModelId) throws Exception {
		this.userModeMenuMap.put(strUserMode, strAppMenuModelId);
	}

	/**
	 * 准备应用视图
	 * 
	 * @throws Exception
	 */
	protected void prepareAppViews() throws Exception {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.appmodel.IApplicationModel#getViewMessages(net.ibizsys.paas.controller.IViewController, net.ibizsys.paas.view.IViewMsgGroupModel)
	 */
	@Override
	public Iterator<IViewMessage> getViewMessages(IViewController iViewController, IViewMsgGroupModel iViewMsgGroupModel) throws Exception {
		return ((ISystemModel) this.getSystem()).getViewMessages(iViewController,iViewMsgGroupModel);
	}

	@Override
	public Iterator<IViewWizard> getViewWizards(IViewController iViewController, IViewWizardGroupModel iViewWizardGroupModel, String strQuery) throws Exception {
		return ((ISystemModel) this.getSystem()).getViewWizards(iViewController,iViewWizardGroupModel,strQuery);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.appmodel.IApplicationModel#testUserViewAccess(net.ibizsys.paas.controller.IViewController, net.ibizsys.paas.web.IWebContext)
	 */
	@Override
	public boolean testUserViewAccess(IViewController iViewController, IWebContext iWebContext)throws Exception {
		return iViewController.testUserAccess(iWebContext);
	}
	
	

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.appmodel.IApplicationModel#setApplicationPlugin(net.ibizsys.paas.appmodel.IApplicationPlugin)
	 */
	@Override
	public void setApplicationPlugin(IApplicationPlugin iApplicationPlugin) throws Exception {
		setApplicationPlugin(iApplicationPlugin,false);
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.paas.appmodel.IApplicationModel#setApplicationPlugin(net.ibizsys.paas.appmodel.IApplicationPlugin, boolean)
	 */
	@Override
	public void setApplicationPlugin(IApplicationPlugin iApplicationPlugin, boolean bIgnoreOrigin) throws Exception {
		IApplicationPlugin lastPlugin = null;
		if(!bIgnoreOrigin){
			lastPlugin = this.iApplicationPlugin;
			if(lastPlugin == null){
				if(this.getSystemModel().getSystemPlugin()!=null)
				{
					lastPlugin = this.getSystemModel().getSystemPlugin().getApplicationPlugin();
				}
			}
		}
		
		iApplicationPlugin.setPrevPlugin(lastPlugin);
		this.iApplicationPlugin = iApplicationPlugin;
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.paas.appmodel.IApplicationModel#getApplicationPlugin()
	 */
	@Override
	public IApplicationPlugin getApplicationPlugin() {
		return iApplicationPlugin;
	}

	
	@Override
	public ISystemModel getSystemModel() {
		return (ISystemModel)getSystem();
	}


	@Override
	public int getAppType() {
		if(nAppType!=APPTYPE_UNKNOWN)
			return nAppType;
		return getAppPFHelper().getAppType();
	}

	
	@Override
	public String getAppFolder() {
		if(StringHelper.isNullOrEmpty(this.strAppFolder))
			return this.getName();
		return this.strAppFolder;
	}
	
	
	/**
	 * 设置应用程序目录
	 * @param strAppFolder
	 */
	protected void setAppFolder(String strAppFolder){
		this.strAppFolder = strAppFolder;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.appmodel.IApplicationModel#fillAppDataAjaxActionResult(net.ibizsys.paas.controller.IViewController, net.ibizsys.paas.web.AppDataAjaxActionResult)
	 */
	@Override
	public void fillAppDataAjaxActionResult(IViewController iViewController, AppDataAjaxActionResult appDataAjaxActionResult) throws Exception {
		onFillAppDataAjaxActionResult(iViewController,  appDataAjaxActionResult);
	}
	
	/**
	 * 填充应用数据异步请求结果
	 * @param iViewController
	 * @param appDataAjaxActionResult
	 * @throws Exception
	 */
	protected void onFillAppDataAjaxActionResult(IViewController iViewController, AppDataAjaxActionResult appDataAjaxActionResult) throws Exception {
		
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.appmodel.IApplicationModel#logException(java.lang.Object, java.lang.Throwable, java.lang.String, java.lang.Object)
	 */
	@Override
	public void logException(Object logger, Throwable throwable, String strMessage, Object objUserData) {
		this.getSystemModel().logException(logger, throwable, strMessage, objUserData);
	}

	
	@Override
	public boolean isOutputFormItemUpdatePrivTag() {
		return this.bOutputFormItemUpdatePrivTag;
	}
	
	/**
	 * 设置是否输出表单项更新权限控制标识
	 * @param bOutputFormItemUpdatePrivTag
	 */
	protected void setOutputFormItemUpdatePrivTag(boolean bOutputFormItemUpdatePrivTag) {
		this.bOutputFormItemUpdatePrivTag = bOutputFormItemUpdatePrivTag;
	}
}
