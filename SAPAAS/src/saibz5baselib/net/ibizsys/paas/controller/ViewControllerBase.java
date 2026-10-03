package net.ibizsys.paas.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.web.bind.annotation.RequestMapping;

import net.ibizsys.paas.appmodel.IApplicationModel;
import net.ibizsys.paas.control.form.IFormItem;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.core.IDEUIAction;
import net.ibizsys.paas.ctrlhandler.CounterGlobal;
import net.ibizsys.paas.ctrlhandler.CtrlHandler;
import net.ibizsys.paas.ctrlhandler.ICounterHandler;
import net.ibizsys.paas.ctrlhandler.ICtrlHandler;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.DataSetCache;
import net.ibizsys.paas.demodel.IDEUIActionModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.exception.ErrorException;
import net.ibizsys.paas.security.AccessUserModes;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.view.IViewMessage;
import net.ibizsys.paas.view.IViewMsgGroupModel;
import net.ibizsys.paas.view.IViewWizard;
import net.ibizsys.paas.view.IViewWizardGroupModel;
import net.ibizsys.paas.view.IViewWizardModel;
import net.ibizsys.paas.view.ViewMessage;
import net.ibizsys.paas.view.ViewMsgGroupModelGlobal;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.AppDataAjaxActionResult;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.UIActionAjaxActionResult;
import net.ibizsys.paas.web.ViewAjaxActionResult;
import net.ibizsys.paas.web.ViewModelAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONObject;

/**
 * 视图控制器基类
 * 
 * @author lionlau
 *
 */
public abstract class ViewControllerBase implements IViewController,IDynaViewController {
	private static AjaxActionResult accessDenyResult = new AjaxActionResult();
	private static AjaxActionResult accessDenyResult2 = new AjaxActionResult();
	private static AjaxActionResult accessDenyResult3 = new AjaxActionResult();
	static {
		accessDenyResult.setRetCode(Errors.ACCESSDENY);
		//未登录访问拒绝
		accessDenyResult2.setRetCode(Errors.ACCESSDENY);
		accessDenyResult2.setErrorInfo("访问被拒绝，用户身份无效，需要重新登录");
		accessDenyResult2.setNotLogin(true);
		//密码过期访问拒绝
		accessDenyResult3.setRetCode(Errors.ACCESSDENY);
		accessDenyResult3.setErrorInfo("访问被拒绝，用户密码已过期，需要重新设置");
		accessDenyResult3.setNotLogin(true);
		accessDenyResult3.setNotLoginReason(AjaxActionResult.NOTLOGIN_PASSWORDEXPIRED);
	}


	

	private static final Log log = LogFactory.getLog(ViewControllerBase.class);

	private Boolean bPrepareViewController = false;
	private ThreadLocal<SessionFactory> sessionFactory = new ThreadLocal<SessionFactory>();

	protected HashMap<String, ICtrlModel> ctrlModelMap = new HashMap<String, ICtrlModel>();
	protected HashMap<String, ICtrlHandler> ctrlHandlerMap = new HashMap<String, ICtrlHandler>();
	protected HashMap<String, String> uiActionMap = new HashMap<String, String>();
	protected HashMap<String, ArrayList<String>> deDataAccActionMap = new HashMap<String, ArrayList<String>>();
	protected ArrayList<IViewControllerPlugin> viewControllerPluginList = null;

	private String strCaption = "";
	private String strTitle = "";
	private String strSubCaption = "";
	private String strCaptionLanResTag = "";
	private String strTitleLanResTag = "";
	private String strSubCaptionLanResTag = "";
	
	private String strMSTag = "";

	/**
	 * 视图访问用户模式
	 */
	private int nAccessUserMode = AccessUserModes.ALLUSER;

	/**
	 * 视图访问标识
	 */
	private String strAccessKey = null;

	private DataObject attributeDataObject = new DataObject();

	private String strId = null;

	private String strViewMsgGroupId = null;

	private IViewMsgGroupModel iViewMsgGroupModel = null;

	private String strViewWizardGroupId = null;

	private IViewWizardGroupModel iViewWizardGroupModel = null;
	
//	private IViewControllerPlugin iViewControllerPlugin = null;
//	
//	private IViewControllerPlugin realViewControllerPlugin = null;
	
	private Object objPrepareViewController = new Object();
	
	private boolean bEnableDynaView = false;
	
	protected HashMap<String, IDynaViewControllerInst> dynaViewControllerInstMap = null;
	private ThreadLocal<IDynaViewControllerInst> dynaViewControllerInst = null;
	
	
	public ViewControllerBase() throws Exception {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.controller.IViewController#getId()
	 */
	@Override
	public String getId() {
		return this.strId;
	}

	/**
	 * 设置视图标识
	 * 
	 * @param strId
	 */
	protected void setId(String strId) {
		this.strId = strId;
	}

	/**
	 * 获取应用程序模型
	 * 
	 * @return
	 */
	public abstract IApplicationModel getAppModel();

	/**
	 * 准备视图参数
	 * 
	 * @throws Exception
	 */
	protected void prepareViewParam() throws Exception {
		
	}

	/**
	 * 准备部件模型
	 * 
	 * @throws Exception
	 */
	protected void prepareCtrlModels() throws Exception {

	}

	/**
	 * 准备部件处理对象
	 * 
	 * @throws Exception
	 */
	protected void prepareCtrlHandlers() throws Exception {

	}

	/**
	 * 准备界面行为集合
	 * 
	 * @throws Exception
	 */
	protected void prepareUIActions() throws Exception {

	}


	
	protected void prepareViewController(boolean bReload) throws Exception {
		if(bReload){
			synchronized (this.objPrepareViewController) {
				this.bPrepareViewController = false;
				if(this.ctrlModelMap!=null){
					this.ctrlModelMap.clear();
				}
				if(this.ctrlHandlerMap!=null){
					this.ctrlHandlerMap.clear();
				}
				if(this.uiActionMap!=null){
					this.uiActionMap.clear();
				}
				if(this.deDataAccActionMap!=null){
					this.deDataAccActionMap.clear();
				}
				if(this.viewControllerPluginList!=null){
					this.viewControllerPluginList.clear();
				}
				if(this.dynaViewControllerInstMap!=null){
					this.dynaViewControllerInstMap.clear();
				}	
			}
		}
		prepareViewController();
	}
	
	
	/**
	 * 准备视图控制器
	 * 
	 * @throws Exception
	 */
	@Override
	public void prepareViewController() throws Exception {
		synchronized (this.objPrepareViewController) {
			if (!this.bPrepareViewController) {
				onPrepareViewController();
				this.bPrepareViewController = true;
			}
		}
		if(this.isEnableDynaView() && this.dynaViewControllerInst!=null){
			this.dynaViewControllerInst.set(null);
		}
	}
	
	@Override
	public IDynaViewControllerInst prepareDynaViewControllerInst() throws Exception {
		if(this.isEnableDynaView() && WebContext.getCurrent()!=null){
			String strViewId = WebContext.getAppViewId(WebContext.getCurrent());
			if(StringHelper.isNullOrEmpty(strViewId)){
				String strDynaSysInst = WebContext.getDynaSysInstId(WebContext.getCurrent());
				if(StringHelper.isNullOrEmpty(strDynaSysInst))
					throw new Exception("没有指定动态视图标识");
				//获取当前视图模式
				String strViewMode = WebContext.getAppViewMode(WebContext.getCurrent());
				if(StringHelper.isNullOrEmpty(strViewMode))
					strViewMode = "";
				strViewId = KeyValueHelper.genUniqueId(strDynaSysInst, this.getId(), strViewMode);
			}
			IDynaViewControllerInst iDynaViewControllerInst = null;
			if(isCacheDynaViewControllerInst()) {
				iDynaViewControllerInst = dynaViewControllerInstMap.get(strViewId);
				String strReload = WebContext.getCurrent().getParamValue(WebContext.PARAM_RELOAD);
				if(StringHelper.compare(strReload, "TRUE", true) == 0){
					iDynaViewControllerInst = null;
				}
				if(iDynaViewControllerInst == null){
					iDynaViewControllerInst = getDynaViewControllerInst(strViewId);
					dynaViewControllerInstMap.put(strViewId, iDynaViewControllerInst);
				}
			}
			else {
				iDynaViewControllerInst = getDynaViewControllerInst(strViewId);
			}

			dynaViewControllerInst.set(iDynaViewControllerInst);
			return iDynaViewControllerInst;
		}
		return null;
	}
	
	/**
	 * 重置动态视图控制器实例缓存
	 */
	@Override
	public void resetDynaViewControllerInsts() throws Exception {
		if(dynaViewControllerInstMap != null)
			dynaViewControllerInstMap.clear();
	}
	
	/**
	 * 准备视图控制器
	 * @throws Exception
	 */
	protected void onPrepareViewController() throws Exception {
		if(this.isEnableDynaView()){
			this.dynaViewControllerInstMap = new HashMap<String, IDynaViewControllerInst>();
			this.dynaViewControllerInst = new ThreadLocal<IDynaViewControllerInst>();
		}
		
		if (!StringHelper.isNullOrEmpty(this.getViewMsgGroupId())) {
			this.iViewMsgGroupModel = ViewMsgGroupModelGlobal.getViewMsgGroup(this.getViewMsgGroupId());
		}
		if (!StringHelper.isNullOrEmpty(this.getViewWizardGroupId())) {
			if(this.getDEModel()!=null)
				this.iViewWizardGroupModel = (IViewWizardGroupModel) this.getDEModel().getDEActionWizardGroup(this.getViewWizardGroupId());
		}
		
		prepareViewParam();
		prepareUIActions();
		prepareCtrlModels();
		prepareCtrlHandlers();
		
//		getPlugin(true);
	}

	/**
	 * 是否已经准备视图
	 * 
	 * @return
	 */
	public final boolean isPrepareViewController() {
		return this.bPrepareViewController;
	}

	/**
	 * 处理请求入口
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "")
	public void process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		prepareViewController();

		this.addTimeOutHeaders(response);
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=UTF-8");

		try {
			SessionFactoryManager.enter();
			IWebContext iWebContext = this.createWebContext(request, response);
			WebContext.setCurrent(iWebContext);
			ViewController.setCurrent(this);
			DataSetCache.enableCurrent();
			IDynaViewControllerInst iDynaViewControllerInst = null;
			if(this.isEnableDynaView()){
				String strViewId = WebContext.getAppViewId(iWebContext);
				if(StringHelper.isNullOrEmpty(strViewId)){
					String strDynaSysInst = WebContext.getDynaSysInstId(WebContext.getCurrent());
					if(StringHelper.isNullOrEmpty(strDynaSysInst))
						throw new Exception("没有指定动态视图标识");
					
					//获取当前视图模式
					String strViewMode = WebContext.getAppViewMode(WebContext.getCurrent());
					if(StringHelper.isNullOrEmpty(strViewMode))
						strViewMode = "";
					strViewId = KeyValueHelper.genUniqueId(strDynaSysInst, this.getId(), strViewMode);
				}
				if(isCacheDynaViewControllerInst()) {
					iDynaViewControllerInst = dynaViewControllerInstMap.get(strViewId);
					if(iDynaViewControllerInst == null){
						iDynaViewControllerInst = getDynaViewControllerInst(strViewId);
						dynaViewControllerInstMap.put(strViewId, iDynaViewControllerInst);
					}
				}
				else {
					iDynaViewControllerInst = getDynaViewControllerInst(strViewId);
				}
				dynaViewControllerInst.set(iDynaViewControllerInst);
			}

		
			if (!this.getAppModel().testUserViewAccess(this,iWebContext)) {
				resetCurrent();
				return;
			}

			if (this.getAppModel().doFilter(this, request, response)) {
				resetCurrent();
				return;
			}
			
			if(iDynaViewControllerInst!=null){
				if(iDynaViewControllerInst.process(request, response,iWebContext)){
					resetCurrent();
					return;
				}
			}
			
			if(onProcess(request, response)) {
				resetCurrent();
				return;
			}

			String strCtrlId = WebContext.getCtrlId(iWebContext);
			String strCtrlAction = WebContext.getAction(iWebContext);


			if (!StringHelper.isNullOrEmpty(strCtrlId)) {
				AjaxActionResult ajaxActionResult = onCtrlAjaxAction(request, response, strCtrlId, strCtrlAction);
				response.getWriter().print(ajaxActionResult.toJSONString());
				response.getWriter().flush();
				response.getWriter().close();

				resetCurrent();
				return;
			}

			String strCounterId = WebContext.getCounterId(iWebContext);
			if (!StringHelper.isNullOrEmpty(strCounterId)) {
				AjaxActionResult ajaxActionResult = onCounterAjaxAction(strCounterId, strCtrlAction);
				response.getWriter().print(ajaxActionResult.toJSONString());
				response.getWriter().flush();
				response.getWriter().close();

				resetCurrent();
				return;
			}

			if (!StringHelper.isNullOrEmpty(strCtrlAction)) {
				AjaxActionResult ajaxActionResult = onViewAjaxAction(strCtrlAction);
				ajaxActionResult = getAppModel().doFilterViewAction(this, request, response, strCtrlAction, ajaxActionResult);
				response.getWriter().print(ajaxActionResult.toJSONString());
				response.getWriter().flush();
				response.getWriter().close();
				resetCurrent();
				return;
			}
			
			resetCurrent();
			return;

		} catch (Exception ex) {
			
			this.getAppModel().logException(this, ex, null, null);
			
			log.error(ex.getMessage(), ex);

			resetCurrent();

			AjaxActionResult ajaxActionResult = new AjaxActionResult();
			ajaxActionResult.setRetCode(Errors.INTERNALERROR);
			ajaxActionResult.setErrorInfo(ex.getMessage());
			if (ex instanceof ErrorException) {
				ErrorException errorException = (ErrorException) ex;
				ajaxActionResult.setRetCode(errorException.getErrorCode());
			}

			response.getWriter().print(ajaxActionResult.toJSONString());
			response.getWriter().flush();
			response.getWriter().close();
		}
	}

	/**
	 * 外部处理请求
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	protected boolean onProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return false;
	}
	
	
	/**
	 * 重置当前变量
	 */
	protected void resetCurrent() {
		if(this.dynaViewControllerInst!=null){
			this.dynaViewControllerInst.set(null);
		}
		this.setSessionFactory(null);
		WebContext.setCurrent(null);
		ViewController.setCurrent(null);
		CtrlHandler.setCurrent(null);
		DataSetCache.resetCurrent();
		SessionFactoryManager.leave();
	}

	/**
	 * 部件后台处理触发
	 * 
	 * @param request
	 * @param response
	 * @param strCtrlId 控件标识
	 * @param strAction 操作
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onCtrlAjaxAction(HttpServletRequest request, HttpServletResponse response, String strCtrlId, String strAction) throws Exception {
		ICtrlHandler iCtrlHandler = ctrlHandlerMap.get(strCtrlId);
		if (iCtrlHandler == null) throw new Exception(StringHelper.format("无法获取指定部件处理对象[%1$s]", strCtrlId));

		CtrlHandler.setCurrent(iCtrlHandler);
		return getAppModel().doViewCtrlAjaxAction(this, request, response, strCtrlId, strAction, iCtrlHandler);
	}

	/**
	 * 计数器后台处理触发
	 * 
	 * @param strCounterId 计数器标识
	 * @param strAction 操作
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onCounterAjaxAction(String strCounterId, String strAction) throws Exception {
		ICounterHandler iCounterHandler = CounterGlobal.getCounterHandler(strCounterId);
		if (iCounterHandler == null) throw new Exception(StringHelper.format("无法获取指定计数器处理对象[%1$s]", strCounterId));

		return iCounterHandler.processAction(strAction, this, this.getWebContext());
	}

	public AjaxActionResult processViewAction(String strAction) throws Exception {
		return onViewAjaxAction(strAction);
	}
	
	/**
	 * 视图后台处理触发
	 * 
	 * @param strAction 操作
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onViewAjaxAction(String strAction) throws Exception {
		if (StringHelper.compare(strAction, VIEWACTION_LOADMODEL, true) == 0) {
			return onLoadViewModel();
		}

		if (StringHelper.compare(strAction, VIEWACTION_FETCHMSG, true) == 0) {
			return onFetchViewMessage();
		}
		
		if (StringHelper.compare(strAction, VIEWACTION_FETCHWIZARD, true) == 0) {
			return onFetchViewWizard();
		}
		
		if (StringHelper.compare(strAction, VIEWACTION_LOADAPPDATA, true) == 0) {
			return onLoadAppData();
		}
		
		if (StringHelper.compare(strAction, VIEWACTION_UIACTION, true) == 0) {
			return onUIAction();
		}
		
		if (StringHelper.compare(strAction, VIEWACTION_LOADUIACTION, true) == 0) {
			return onLoadUIAction();
		}

		throw new Exception(StringHelper.format("没有处理视图请求[%1$s]", strAction));
	}

	/**
	 * 加载页面模型
	 * 
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onLoadViewModel() throws Exception {
		ViewModelAjaxActionResult viewModelAjaxActionResult = new ViewModelAjaxActionResult();
		this.getWebContext().setCurAjaxActionResult(viewModelAjaxActionResult);
		onFillViewModelAjaxActionResult(viewModelAjaxActionResult);
		return viewModelAjaxActionResult;
	}
	
	/**
	 * 获取视图数据对象
	 * @return
	 * @throws Exception
	 */
	protected IEntity getViewEntity()throws Exception{
		 return this.getDEModel().createEntity();
	}
	
	
	/**
	 * 填充视图模型异步请求对象
	 * @param viewModelAjaxActionResult
	 * @throws Exception
	 */
	protected void onFillViewModelAjaxActionResult (ViewModelAjaxActionResult viewModelAjaxActionResult)throws Exception{
		if(this.getDEModel()!=null){
			final JSONObject jo = viewModelAjaxActionResult.getDataAccAction(true);
			java.util.Iterator<String> deDataAccessActions = this.getDEDataAccessActions(this.getDEModel().getName());
			if (deDataAccessActions != null) {
				IEntity iEntity =getViewEntity();
				while (deDataAccessActions.hasNext()) {
					String strAccessAction = deDataAccessActions.next();
					CallResult callResult = testDEDataAccessAction(this.getDEModel(),iEntity, strAccessAction, true);
					//CallResult callResult = this.getDEModel().getDEDataAccMgr().test(iWebContext,iEntity, strAccessAction, true);
					if (callResult.isOk()) {
						jo.put(strAccessAction, 1);
					} else {
						jo.put(strAccessAction, 0);
					}
				}
			}
		}
		
		//附加视图逻辑
		if (getViewMsgGroupModel() != null) {
			java.util.Iterator<IViewMessage> viewMessages = this.getAppModel().getViewMessages(this, getViewMsgGroupModel());
			if (viewMessages != null) {
				while (viewMessages.hasNext()) {
					IViewMessage iViewMessage = viewMessages.next();
					JSONObject item = ViewMessage.toJSONObject(null, iViewMessage);
					viewModelAjaxActionResult.getMsgs().add(item);
				}
			}
		}
	}
	

	/**
	 * 查询视图消息
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onFetchViewMessage() throws Exception {
		ViewAjaxActionResult viewAjaxActionResult = new ViewAjaxActionResult();
		this.getWebContext().setCurAjaxActionResult(viewAjaxActionResult);
		if (getViewMsgGroupModel() != null) {
			java.util.Iterator<IViewMessage> viewMessages = this.getAppModel().getViewMessages(this, getViewMsgGroupModel());
			if (viewMessages != null) {
				while (viewMessages.hasNext()) {
					IViewMessage iViewMessage = viewMessages.next();
					JSONObject item = ViewMessage.toJSONObject(null, iViewMessage);
					viewAjaxActionResult.getItems().add(item);
				}
			}
		}
		return viewAjaxActionResult;
	}
	
	
	/**
	 * 查询视图向导
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onFetchViewWizard() throws Exception {
		ViewAjaxActionResult viewAjaxActionResult = new ViewAjaxActionResult();
		this.getWebContext().setCurAjaxActionResult(viewAjaxActionResult);
		if (getViewWizardGroupModel() != null) {
			java.util.Iterator<IViewWizard> viewWizards = this.getAppModel().getViewWizards(this, getViewWizardGroupModel(),WebContext.getFetchQuickSearch(this.getWebContext()));
			if (viewWizards != null) {
				while (viewWizards.hasNext()) {
					IViewWizardModel iViewWizardModel = (IViewWizardModel) viewWizards.next();
					JSONObject item = iViewWizardModel.toJSONObject(true);
					viewAjaxActionResult.getItems().add(item);
				}
			}
		}
		return viewAjaxActionResult;
	}
	
	
	/**
	 * 增加超时标记
	 * 
	 * @param response
	 */
	protected void addTimeOutHeaders(HttpServletResponse response) {
		response.setDateHeader("Expires", System.currentTimeMillis());
	}

	/**
	 * 获取上下文访问对象
	 * 
	 * @return
	 */
	public IWebContext getWebContext() {
		return WebContext.getCurrent();
	}

	@Override
	public void registerCtrlModel(String strCtrlId, ICtrlModel iCtrlModel) throws Exception {
		ctrlModelMap.put(strCtrlId, iCtrlModel);
	}

	@Override
	public void registerCtrlHandler(String strCtrlId, ICtrlHandler iCtrlHandler) throws Exception {
		ctrlHandlerMap.put(strCtrlId, iCtrlHandler);
	}

	/**
	 * 注册界面行为
	 * 
	 * @param strUIActionId 界面行为标识
	 * @throws Exception
	 */
	protected void registerUIAction(String strUIActionId) throws Exception {
		uiActionMap.put(strUIActionId, "");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.controller.IViewController#getSystemModel()
	 */
	@Override
	public ISystemModel getSystemModel() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.controller.IViewController#getDataEntityModel()
	 */
	@Override
	public IDataEntityModel getDEModel() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.controller.IViewController#getService()
	 */
	@Override
	public IService getService() {
		return null;
	}

	/**
	 * 获取控件模型
	 * 
	 * @param strName 控件名称
	 * @return
	 * @throws Exception
	 */
	@Override
	public ICtrlModel getCtrlModel(String strName) throws Exception {
		ICtrlModel iCtrlModel = this.ctrlModelMap.get(strName);
		if (iCtrlModel == null) throw new Exception(StringHelper.format("无法获取指定部件模型[%1$s]", strName));
		return iCtrlModel;
	}
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.controller.IDynaViewController#getCtrlModel(java.lang.String, boolean)
	 */
	@Override
	public ICtrlModel getCtrlModel(String strName, boolean bTryMode) throws Exception {
		ICtrlModel iCtrlModel = this.ctrlModelMap.get(strName);
		if (iCtrlModel == null && !bTryMode){
			 throw new Exception(StringHelper.format("无法获取指定部件模型对象[%1$s]", strName));
		}
		return iCtrlModel;
	}
	

	/**
	 * 获取控件处理对象
	 * 
	 * @param strName 控件名称
	 * @return
	 * @throws Exception
	 */
	@Override
	public ICtrlHandler getCtrlHandler(String strName) throws Exception {
		ICtrlHandler iCtrlHandler = this.ctrlHandlerMap.get(strName);
		if (iCtrlHandler == null){
			throw new Exception(StringHelper.format("无法获取指定部件处理对象[%1$s]", strName));
		}
		return iCtrlHandler;
	}
	
	
	
	

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.controller.IDynaViewController#getCtrlHandler(java.lang.String, boolean)
	 */
	@Override
	public ICtrlHandler getCtrlHandler(String strName, boolean bTryMode) throws Exception {
		ICtrlHandler iCtrlHandler = this.ctrlHandlerMap.get(strName);
		if (iCtrlHandler == null && !bTryMode){
			 throw new Exception(StringHelper.format("无法获取指定部件处理对象[%1$s]", strName));
		}
		return iCtrlHandler;
	}

	/**
	 * 是否为拾取视图
	 * 
	 * @return
	 */
	@Override
	public boolean isPickupView() {
		return false;
	}

	/**
	 * 建立网络访问上下文
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	protected IWebContext createWebContext(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return getAppModel().createWebContext(this, request, response);
	}

	/**
	 * 设置会话工厂
	 * 
	 * @param sessionFactory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory.set(sessionFactory);
	}

	/**
	 * 获取会话工厂
	 * 
	 * @return
	 */
	public SessionFactory getSessionFactory() {
		return this.sessionFactory.get();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.controller.IViewController#getCaption()
	 */
	public String getCaption() {
		if(this.isEnableDynaView() && this.getDynaViewControllerInst()!=null){
			String strContent = this.getDynaViewControllerInst().getCaption();
			if(!StringHelper.isNullOrEmpty(strContent))
				return strContent;
		}
		return strCaption;
	}

	/**
	 * 设置标题
	 * 
	 * @param strCaption
	 */
	protected void setCaption(String strCaption) {
		this.strCaption = strCaption;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.controller.IViewController#getTitle()
	 */
	public String getTitle() {
		if(this.isEnableDynaView() && this.getDynaViewControllerInst()!=null){
			String strContent =  this.getDynaViewControllerInst().getTitle();
			if(!StringHelper.isNullOrEmpty(strContent))
				return strContent;
		}
		return strTitle;
	}

	/**
	 * 设置抬头
	 * 
	 * @param strTitle
	 */
	protected void setTitle(String strTitle) {
		this.strTitle = strTitle;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.controller.IViewController#getSubCaption()
	 */
	public String getSubCaption() {
		if(this.isEnableDynaView() && this.getDynaViewControllerInst()!=null){
			String strContent =  this.getDynaViewControllerInst().getSubCaption();
			if(!StringHelper.isNullOrEmpty(strContent))
				return strContent;
		}
		return strSubCaption;
	}

	/**
	 * 设置子标题
	 * 
	 * @param strSubCaption
	 */
	protected void setSubCaption(String strSubCaption) {
		this.strSubCaption = strSubCaption;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.controller.IViewController#getViewMsgGroupId()
	 */
	public String getViewMsgGroupId() {
		return strViewMsgGroupId;
	}

	/**
	 * 设置视图消息组标识
	 * 
	 * @param strViewMsgGroupId
	 */
	protected void setViewMsgGroupId(String strViewMsgGroupId) {
		this.strViewMsgGroupId = strViewMsgGroupId;
	}

	/**
	 * 获取视图消息组模型
	 * 
	 * @return
	 */
	protected IViewMsgGroupModel getViewMsgGroupModel() {
		return this.iViewMsgGroupModel;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.controller.IViewController#getViewWizardGroupId()
	 */
	public String getViewWizardGroupId() {
		return strViewWizardGroupId;
	}

	/**
	 * 设置视图向导组标识
	 * 
	 * @param strViewWizardGroupId
	 */
	protected void setViewWizardGroupId(String strViewWizardGroupId) {
		this.strViewWizardGroupId = strViewWizardGroupId;
	}

	/**
	 * 获取视图向导组模型
	 * 
	 * @return
	 */
	protected IViewWizardGroupModel getViewWizardGroupModel() {
		return this.iViewWizardGroupModel;
	}
	

	@Override
	public Object getAttribute(String strKey) throws Exception {
		return attributeDataObject.get(strKey);
	}

	@Override
	public void setAttribute(String strKey, Object objValue) throws Exception {
		this.attributeDataObject.set(strKey, objValue);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.controller.IViewController#getAttribute(java.lang.String, boolean)
	 */
	@Override
	public boolean getAttribute(String strKey, boolean bDefault) throws Exception {
		return DataObject.getBoolValue(this.attributeDataObject, strKey, bDefault);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.controller.IViewController#getAttribute(java.lang.String, java.lang.String)
	 */
	@Override
	public String getAttribute(String strKey, String strDefault) throws Exception {
		return DataObject.getStringValue(this.attributeDataObject, strKey, strDefault);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.controller.IViewController#getAttribute(java.lang.String, int)
	 */
	@Override
	public int getAttribute(String strKey, int nDefault) throws Exception {
		return DataObject.getIntegerValue(this.attributeDataObject, strKey, nDefault);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.controller.IViewController#getAttribute(java.lang.String, double)
	 */
	@Override
	public double getAttribute(String strKey, double fDefault) throws Exception {
		return DataObject.getDoubleValue(this.attributeDataObject, strKey, fDefault);
	}

	/**
	 * 获取视图的访问用户模式
	 * 
	 * @return
	 */
	@Override
	public int getAccessUserMode() {
		return this.nAccessUserMode;
	}

	/**
	 * 设置访问用户模式
	 * 
	 * @param nAccessUserMode
	 */
	protected void setAccessUserMode(int nAccessUserMode) {
		this.nAccessUserMode = nAccessUserMode;
	}

	/**
	 * 获取视图的访问标识
	 * 
	 * @return
	 */
	@Override
	public String getAccessKey() {
		return this.strAccessKey;
	}

	/**
	 * 设置视图的访问标识
	 * 
	 * @return
	 */
	protected void setAccessKey(String strAccessKey) {
		this.strAccessKey = strAccessKey;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.controller.IViewController#testUserAccess(net.ibizsys.paas.web.IWebContext)
	 */
	public boolean testUserAccess(IWebContext iWebContext) throws Exception {
		return this.testUserAccess(iWebContext,true);
	}

	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.controller.IViewController#testUserAccess(net.ibizsys.paas.web.IWebContext, boolean)
	 */
	public boolean testUserAccess(IWebContext iWebContext,boolean bSendBack) throws Exception {
		
		String strPersonId = iWebContext.getCurUserId();
		if (StringHelper.isNullOrEmpty(strPersonId)) {
			// 匿名用户
			if ((this.getAccessUserMode() & AccessUserModes.ANONYMOUS) > 0) {
				return true;
			}
			if(bSendBack){
				iWebContext.getResponse().getWriter().print(getAccessDenyResult(2).toJSONString());
				iWebContext.getResponse().getWriter().flush();
				iWebContext.getResponse().getWriter().close();
			}
			return false;
		} else {
			
			if(iWebContext.isCurUserPasswordExpired()){
				if(bSendBack){
					iWebContext.getResponse().getWriter().print(getAccessDenyResult(3).toJSONString());
					iWebContext.getResponse().getWriter().flush();
					iWebContext.getResponse().getWriter().close();
				}
				return false;
			}
			
			// 匿名用户
			if ((this.getAccessUserMode() & AccessUserModes.LOGINUSER) > 0) {
				return true;
			}

			if ((this.getAccessUserMode() & AccessUserModes.LOGINUSERWITHKEY) > 0) {
				if (iWebContext.getUserPrivilegeMgr().test(this.getWebContext(), this.getAccessKey())){
					return true;
				}
			}
		}
		if(bSendBack){
			iWebContext.getResponse().getWriter().print(getAccessDenyResult(1).toJSONString());
			iWebContext.getResponse().getWriter().flush();
			iWebContext.getResponse().getWriter().close();
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.controller.IViewController#getMSTag()
	 */
	@Override
	public String getMSTag() {
		return strMSTag;
	}

	/**
	 * 设置主状态标记
	 * 
	 * @param strMSTag
	 */
	protected void setMSTag(String strMSTag) {
		this.strMSTag = strMSTag;
	}

	/**
	 * 获取界面行为集合
	 * 
	 * @return
	 * @throws Exception
	 */
	@Override
	public java.util.Iterator<String> getUIActions() throws Exception {
		if (uiActionMap.size() == 0) return null;
		return uiActionMap.keySet().iterator();
	}

	/**
	 * 注册视图相关的数据访问行为
	 * 
	 * @param strDEName 实体名称
	 * @param strDataAccAction 数据访问行为
	 */
	protected void registerDEDataAccessAction(String strDEName, String strDataAccAction) {

		ArrayList<String> list = deDataAccActionMap.get(strDEName);
		if (list == null) {
			list = new ArrayList<String>();
			deDataAccActionMap.put(strDEName, list);
		}
		if (!list.contains(strDataAccAction)) {
			list.add(strDataAccAction);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.controller.IViewController#getDEDataAccessActions(java.lang.String)
	 */
	@Override
	public Iterator<String> getDEDataAccessActions(String strDEName) {

		ArrayList<String> list = deDataAccActionMap.get(strDEName);
		if (list != null) {
			return list.iterator();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.controller.IViewController#getCapLanResTag()
	 */
	@Override
	public String getCapLanResTag() {
		return this.strCaptionLanResTag;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.controller.IViewController#getSubCapLanResTag()
	 */
	@Override
	public String getSubCapLanResTag() {
		return this.strSubCaptionLanResTag;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.controller.IViewController#getTitleLanResTag()
	 */
	@Override
	public String getTitleLanResTag() {
		return this.strTitleLanResTag;
	}

	
	/**
	 * 设置标题语言标识
	 * @param strCaptionLanResTag
	 */
	protected void setCapLanResTag(String strCaptionLanResTag){
		this.strCaptionLanResTag = strCaptionLanResTag;
	}
	
	
	/**
	 * 设置子标题语言标识
	 * @param strCaptionLanResTag
	 */
	protected void setSubCapLanResTag(String strSubCaptionLanResTag){
		this.strSubCaptionLanResTag = strSubCaptionLanResTag;
	}
	
	
	/**
	 * 设置抬头语言标识
	 * @param strCaptionLanResTag
	 */
	protected void setTitleLanResTag(String strTitleLanResTag){
		this.strTitleLanResTag = strTitleLanResTag;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.controller.IViewController#getCaption(boolean)
	 */
	@Override
	public String getCaption(boolean bLocale) {
		if(bLocale && !StringHelper.isNullOrEmpty(this.getCapLanResTag())){
			return this.getWebContext().getLocalization(this.getCapLanResTag(), this.getCaption());
		}
		return this.getCaption();
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.controller.IViewController#getTitle(boolean)
	 */
	@Override
	public String getTitle(boolean bLocale) {
		if(bLocale && !StringHelper.isNullOrEmpty(this.getTitleLanResTag())){
			return this.getWebContext().getLocalization(this.getTitleLanResTag(), this.getTitle());
		}
		return this.getTitle();
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.controller.IViewController#getSubCaption(boolean)
	 */
	@Override
	public String getSubCaption(boolean bLocale) {
		if(bLocale && !StringHelper.isNullOrEmpty(this.getSubCapLanResTag())){
			return this.getWebContext().getLocalization(this.getSubCapLanResTag(), this.getSubCaption());
		}
		return this.getSubCaption();
	}


	@Override
	public CallResult testDEDataAccessAction(IDataEntityModel iDataEntityModel, Object objValue , String strAction, boolean bCache) throws Exception {
		final IWebContext iWebContext = this.getWebContext();
		if(iDataEntityModel == null)
			iDataEntityModel = this.getDEModel();
		if(objValue instanceof IEntity){
			return iDataEntityModel.getDEDataAccMgr().test(iWebContext,(IEntity) objValue, strAction, bCache);
		}
		else{
			return iDataEntityModel.getDEDataAccMgr().test(iWebContext,objValue, strAction, bCache);
		}
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.controller.IDynaViewController#isEnableDynaView()
	 */
	@Override
	public boolean isEnableDynaView() {
		return this.bEnableDynaView;
	}
	
	/**
	 * 设置是否启用动态视图
	 * @param bEnableDynaView
	 */
	protected void setEnableDynaView(boolean bEnableDynaView){
		this.bEnableDynaView = bEnableDynaView;
	}
	
	/**
	 * 获取当前动态视图实例标识
	 * @return
	 */
	protected String getDynaViewInstId(){
		return WebContext.getAppViewId(WebContext.getCurrent());
	}
	

	
	
	/**
	 * 获取拒绝访问的结果对象
	 * @param nMode (1)无权限 (2)未登录 (3)密码过期
	 * @return
	 */
	protected AjaxActionResult getAccessDenyResult(int nMode){
		switch(nMode){
		case 1:
			return accessDenyResult;
		case 2:
			return accessDenyResult2;
		case 3:
			return accessDenyResult3;
		default:
			return accessDenyResult;
		}
	}
		
	/**
	 * 获取指定动态视图控制器实例
	 * @param strViewId
	 * @return
	 * @throws Exception
	 */
	protected IDynaViewControllerInst getDynaViewControllerInst(String strViewId) throws Exception{
		if(this.getSystemModel().getDynaSystemSetting()==null){
			throw new Exception("当前系统不支持动态系统");
		}
		return this.getSystemModel().getDynaSystemSetting().createDynaViewControllerInst(this, strViewId);
	}

	
	@Override
	public IDynaViewControllerInst getDynaViewControllerInst() {
		if(this.dynaViewControllerInst == null)
			return null;
		return this.dynaViewControllerInst.get();
	}

	/**
	 * 获取部件模型集合
	 * @return
	 */
	public java.util.Iterator<ICtrlModel> getCtrlModels(){
		if(this.ctrlModelMap.size() == 0)
			return null;
		return this.ctrlModelMap.values().iterator();
	}
	
	/**
	 * 获取部件模型名称集合
	 * @return
	 */
	public java.util.Iterator<String> getCtrlModelNames(){
		if(this.ctrlModelMap.size() == 0)
			return null;
		return this.ctrlModelMap.keySet().iterator();
	}
	
	/**
	 * 获取部件处理对象集合
	 * @return
	 */
	public java.util.Iterator<ICtrlHandler> getCtrlHandlers(){
		if(this.ctrlHandlerMap.size() == 0)
			return null;
		return this.ctrlHandlerMap.values().iterator();
	}
	
	/**
	 * 获取部件处理名称集合
	 * @return
	 */
	public java.util.Iterator<String> getCtrlHandlerNames(){
		if(this.ctrlHandlerMap.size() == 0)
			return null;
		return this.ctrlHandlerMap.keySet().iterator();
	}
	
	/**
	 * 加载页面模型
	 * 
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onLoadAppData() throws Exception {
		AppDataAjaxActionResult appDataAjaxActionResult = new AppDataAjaxActionResult();
		this.getWebContext().setCurAjaxActionResult(appDataAjaxActionResult);
		onFillAppDataAjaxActionResult(appDataAjaxActionResult);
		return appDataAjaxActionResult;
	}
	
	/**
	 * 填充应用数据异步请求结果对象
	 * @param appDataAjaxActionResult
	 * @throws Exception
	 */
	protected void onFillAppDataAjaxActionResult(AppDataAjaxActionResult appDataAjaxActionResult)throws Exception{
		this.getAppModel().fillAppDataAjaxActionResult(this, appDataAjaxActionResult);
	}
	

	
	
	/**
	 * 处理用户界面行为
	 * 
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onUIAction() throws Exception {
		// 获取对应的行为
		String strDEUIActionId = WebContext.getUIActionId(this.getWebContext());
		if(StringHelper.isNullOrEmpty(strDEUIActionId)){
			throw new Exception("没有指定界面行为标识");
		}
		IDEUIActionModel iDEUIActionModel = null;
		if(this.getDEModel() != null){
			iDEUIActionModel = (IDEUIActionModel) this.getDEModel().getDEUIAction(strDEUIActionId);
		}
		else{
			iDEUIActionModel = this.getSystemModel().getDEUIActionModel(strDEUIActionId, false);
		}
		return this.doUIAction(iDEUIActionModel);
	}
	
	
	/**
	 * 加载界面行为运行时模型
	 * 
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onLoadUIAction() throws Exception {
		String strDEUIActionId = WebContext.getUIActionId(this.getWebContext());
		if(StringHelper.isNullOrEmpty(strDEUIActionId)){
			throw new Exception("没有指定界面行为标识");
		}
		IDEUIActionModel iDEUIActionModel = null;
		if(this.getDEModel() != null){
			iDEUIActionModel = (IDEUIActionModel) this.getDEModel().getDEUIAction(strDEUIActionId);
		}
		else{
			iDEUIActionModel = this.getSystemModel().getDEUIActionModel(strDEUIActionId, false);
		}
		return onLoadUIAction(iDEUIActionModel);
	}
	
	
	
	/**
	 * 加载界面行为运行时模型
	 * @param iDEUIActionModel
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onLoadUIAction(IDEUIActionModel iDEUIActionModel) throws Exception {
		return iDEUIActionModel.getRuntimeModelAjaxActionResult(this.getSessionFactory());
	}
	

	/**
	 * 处理用户界面行为
	 * 
	 * @param iDEUIActionModel 界面行为模型对象
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult doUIAction(IDEUIActionModel iDEUIActionModel) throws Exception {
		UIActionAjaxActionResult ajaxActionResult = new UIActionAjaxActionResult();
		this.getWebContext().setCurAjaxActionResult(ajaxActionResult);
		IDataEntityModel iDEModel = iDEUIActionModel.getDEModel();		
		if (StringHelper.compare(iDEUIActionModel.getActionTarget(), IDEUIAction.ACTIONTARGET_NONE, true) == 0) {
			if (!StringHelper.isNullOrEmpty(iDEUIActionModel.getDataAccessAction())) {
				// 判断是否有指定行为
				CallResult callResult = iDEModel.getDEDataAccMgr().test(this.getWebContext(), null, iDEUIActionModel.getDataAccessAction());
				if (callResult.isError()) {
					ajaxActionResult.from(callResult);
					return ajaxActionResult;
				}
			}
			iDEUIActionModel.execute(null, this.getSessionFactory());
		} else {
			String strKeys = WebContext.getKeys(this.getWebContext());
			if (StringHelper.isNullOrEmpty(strKeys)) {
				strKeys = WebContext.getKey(this.getWebContext());
			}

			if (StringHelper.isNullOrEmpty(strKeys)) {
				ajaxActionResult.setRetCode(Errors.INVALIDDATAKEYS);
				return ajaxActionResult;
			}
			ArrayList entities = iDEModel.createEntityList();
			String[] keys = strKeys.split("[;]");
			for (int i = 0; i < keys.length; i++) {
				IEntity iEntity = iDEModel.createEntity();
				iEntity.set(iDEModel.getKeyDEField().getName(), keys[i]);
				// 判断权限
				if (!StringHelper.isNullOrEmpty(iDEUIActionModel.getDataAccessAction())) {
					CallResult callResult = iDEModel.getDEDataAccMgr().test(this.getWebContext(), iEntity, iDEUIActionModel.getDataAccessAction());
					if (callResult.isError()) {
						ajaxActionResult.from(callResult);
						return ajaxActionResult;
					}
				}
				if(this.getDEModel()!=null && (StringHelper.compare(this.getDEModel().getId(), iDEModel.getId(), false)!=0)){
					//放入当前视图的实体标识
					iEntity.set(IFormItem.DEID, this.getDEModel().getId());
				}
				entities.add(iEntity);
			}
			iDEUIActionModel.execute(entities, this.getSessionFactory());
		}
		ajaxActionResult.setReloadData(iDEUIActionModel.isReloadData());
		ajaxActionResult.setErrorInfo(iDEUIActionModel.getSuccessMsg());
		return ajaxActionResult;
	}
	
	/**
	 * 是否登记到视图控制器全局模型
	 * @return
	 */
	protected boolean isRegisterToVCGlobal(){
		return true;
	}
	
//	@Override
//	public void setViewControllerPlugin(IViewControllerPlugin iViewControllerPlugin) throws Exception {
//		setViewControllerPlugin(iViewControllerPlugin,false);
//	}
//
//	@Override
//	public void setViewControllerPlugin(IViewControllerPlugin iViewControllerPlugin, boolean bIgnoreOrigin) throws Exception {
//		IViewControllerPlugin lastPlugin = null;
//		if(!bIgnoreOrigin){
//			lastPlugin = this.iViewControllerPlugin;
//			if(lastPlugin == null){
//				//拿到当前应用插件
//				if(this.getAppModel().getApplicationPlugin()!=null){
//					lastPlugin =  this.getAppModel().getApplicationPlugin().getViewControllerPlugin();
//				}
//			}
//		}
//		
//		iViewControllerPlugin.setPrevPlugin(lastPlugin);
//		this.iViewControllerPlugin = iViewControllerPlugin;
//		getPlugin(true);
//	}
//	
//	/**
//	 * 获取视图插件
//	 * @return
//	 */
//	final protected IViewControllerPlugin getPlugin(){
//		return this.realViewControllerPlugin; 
//	}
//	
//	/**
//	 * 获取视图插件
//	 * @param bCalc 重新计算
//	 * @return
//	 */
//	final protected IViewControllerPlugin getPlugin(boolean bCalc){
//		if(bCalc){
//			if(this.iViewControllerPlugin!=null){
//				this.realViewControllerPlugin =  this.iViewControllerPlugin;
//			}
//			else
//			{
//				//拿到当前应用插件
//				if(this.getAppModel().getApplicationPlugin()!=null){
//					this.realViewControllerPlugin =  this.getAppModel().getApplicationPlugin().getViewControllerPlugin();
//				}
//			}
//		}
//		return this.realViewControllerPlugin; 
//	}
	
	/**
	 * 是否缓存动态视图实例
	 * @return
	 */
	protected boolean isCacheDynaViewControllerInst() {
		return true;
	}
}
