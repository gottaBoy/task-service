package net.ibizsys.paas.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.ibizsys.paas.appmodel.IApplicationModel;
import net.ibizsys.paas.core.IDynaModelJsonExporter;
import net.ibizsys.paas.ctrlhandler.CtrlHandler;
import net.ibizsys.paas.ctrlhandler.ICtrlHandler;
import net.ibizsys.paas.ctrlhandler.IDynaCtrlHandler;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.ctrlmodel.IDynaCtrlModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.view.DefaultDynaBackendUIActionModel;
import net.ibizsys.paas.view.DefaultDynaFrontUIActionModel;
import net.ibizsys.paas.view.DefaultDynaUIActionModel;
import net.ibizsys.paas.view.IDynaUIActionModel;
import net.ibizsys.paas.view.IDynaViewSetting;
import net.ibizsys.paas.view.IDynaViewSettingModel;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.DynaViewModelAjaxActionResult;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.ViewModelAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaViewInst;

import org.hibernate.SessionFactory;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 动态视图控制器实现基类
 * 
 * @author Administrator
 *
 */
public abstract class DynaViewControllerInstBase extends ViewControllerBase implements IDynaViewControllerInst {

	private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(DynaViewControllerInstBase.class);
	
	private IDynaViewController iDynaViewController = null;
	private DSDynaViewInst dsDynaViewInst = new DSDynaViewInst();

	private String strViewType = null;
	private IDynaViewSettingModel iDynaViewSettingModel = null;
	
	private ArrayList<IDynaUIActionModel> dynaUIActionModeList= new ArrayList<IDynaUIActionModel>();
	private String strDynaViewMode = null;
	
	public DynaViewControllerInstBase() throws Exception {
		super();

	}

	@Override
	public void init(IDynaViewController iDynaViewController, IEntity dsDynaViewInst, IDynaViewSetting iDynaViewSetting) throws Exception {
		this.iDynaViewController = iDynaViewController;
		this.iDynaViewSettingModel = (IDynaViewSettingModel) iDynaViewSetting;
		dsDynaViewInst.copyTo(this.dsDynaViewInst, true);
		this.setId(this.dsDynaViewInst.getDSDynaViewInstId());
		this.strDynaViewMode = this.dsDynaViewInst.getPDVTParam();
		this.onInit();
	}

	/**
	 * 初始化触发
	 * 
	 * @throws Exception
	 */
	protected void onInit() throws Exception {
		if (!StringHelper.isNullOrEmpty(this.dsDynaViewInst.getDynaModel())) {
			ObjectNode viewModelNode = (ObjectNode) JsonNodeHelper.fromString(this.dsDynaViewInst.getDynaModel());
			onLoadJsonObject(viewModelNode);
		}
	}

	@Override
	public IDataEntityModel getDEModel() {
		return this.getDynaViewController().getDEModel();
	}
	
	@Override
	public ISystemModel getSystemModel() {
		return this.getDynaViewController().getSystemModel();
	}
	
	
	@Override
	public IService getService() {
		return this.getDynaViewController().getService();
	}
	
	@Override
	public SessionFactory getSessionFactory() {
		return this.getDynaViewController().getSessionFactory();
	}
	
	
	// 加载部件
	protected void onLoadJsonObject(ObjectNode viewModelNode) throws Exception {

		// 注册界面行为
		if(true){
			ArrayNode arrayNode = JsonNodeHelper.getArray(viewModelNode, ATTR_UIACTIONS);
			if (arrayNode != null) {
				int nSize = arrayNode.size();
				for (int i = 0; i < nSize; i++) {
					ObjectNode uiActionModelNode = (ObjectNode) arrayNode.get(i);
					IDynaUIActionModel iDynaUIActionModel = this.loadDynaUIActionModel(uiActionModelNode);
					registerDynaUIActionModel(iDynaUIActionModel);
				}
			}
		}

		// 注册视图部件
		if (true) {
			ArrayList<IDynaCtrlModel> dynaCtrlModelList = new ArrayList<IDynaCtrlModel>();
			ArrayNode arrayNode = JsonNodeHelper.getArray(viewModelNode, ATTR_CTRLS);
			if (arrayNode != null) {
				int nSize = arrayNode.size();
				for (int i = 0; i < nSize; i++) {
					ObjectNode ctrlModelNode = (ObjectNode) arrayNode.get(i);
					IDynaCtrlModel iDynaCtrlModel = loadDynaCtrlModel(ctrlModelNode);
					if (iDynaCtrlModel != null) {
						dynaCtrlModelList.add(iDynaCtrlModel);
					}
				}
			}

			// 进一步加载部件
			for (IDynaCtrlModel iDynaCtrlModel : dynaCtrlModelList) {
				this.registerCtrlModel(iDynaCtrlModel.getName(), iDynaCtrlModel);
			}

			for (IDynaCtrlModel iDynaCtrlModel : dynaCtrlModelList) {
				IDynaCtrlHandler iDynaCtrlHandler = this.createDynaCtrlHandler(iDynaCtrlModel);
				if (iDynaCtrlHandler != null) {
					iDynaCtrlHandler.init(this, iDynaCtrlModel);
					this.registerCtrlHandler(iDynaCtrlModel.getName(), iDynaCtrlHandler);
				} else {
					ICtrlHandler iCtrlHandler = this.getDynaViewController().getCtrlHandler(iDynaCtrlModel.getName(), true);
					if (iCtrlHandler != null) {
						ICtrlHandler newCtrlHandler = iCtrlHandler.getClass().newInstance();
						if (newCtrlHandler instanceof IDynaCtrlHandler) {
							iDynaCtrlHandler = (IDynaCtrlHandler) newCtrlHandler;
							iDynaCtrlHandler.init(this, iDynaCtrlModel);
							this.registerCtrlHandler(iDynaCtrlModel.getName(), iDynaCtrlHandler);
						} else {
							log.error(StringHelper.format("对象[%1$s]没有实现动态部件处理对象接口", iCtrlHandler.getClass().getName()));
						}
					}
				}
			}
		}
	}

	protected IDynaCtrlModel loadDynaCtrlModel(ObjectNode ctrlModelNode) throws Exception {
		String strCtrlType = JsonNodeHelper.getString(ctrlModelNode, IDynaCtrlModel.ATTR_TYPE, null);
		if (StringHelper.isNullOrEmpty(strCtrlType)) {
			throw new Exception(StringHelper.format("没有指定动态视图部件类型"));
		}
		String strCtrlName = JsonNodeHelper.getString(ctrlModelNode, IDynaCtrlModel.ATTR_NAME, null);
		if (StringHelper.isNullOrEmpty(strCtrlName)) {
			strCtrlName = JsonNodeHelper.getString(ctrlModelNode, IDynaCtrlModel.ATTR_ID, null);
		}
		if (StringHelper.isNullOrEmpty(strCtrlName)) {
			throw new Exception(StringHelper.format("没有指定动态视图部件名称"));
		}
		return onLoadDynaCtrlModel(strCtrlType, strCtrlName, ctrlModelNode);
	}

	/**
	 * 加载动态视图部件模型对象
	 * 
	 * @param strCtrlType
	 * @param ctrlModelNode
	 * @return
	 * @throws Exception
	 */
	protected IDynaCtrlModel onLoadDynaCtrlModel(String strCtrlType, String strCtrlName, ObjectNode ctrlModelNode) throws Exception {
		//获取原始部件模型
		ICtrlModel iCtrlModel = this.getDynaViewController().getCtrlModel(strCtrlName, true);
		IDynaCtrlModel iDynaCtrlModel = null;
		if(iCtrlModel!=null && iCtrlModel instanceof IDynaCtrlModel){
			iDynaCtrlModel = (IDynaCtrlModel)iCtrlModel.getClass().newInstance();
		}
		else{
			iDynaCtrlModel = this.getDynaViewSettingModel().createDynaCtrlModel(strCtrlType, ctrlModelNode);
			if (iDynaCtrlModel == null) {
			//	throw new Exception(StringHelper.format("无法创建动态部件模型，类型为[%1$s][%2$s]", strCtrlType, ctrlModelNode));
				log.error(StringHelper.format("无法创建动态部件模型，类型为[%1$s][%2$s]", strCtrlType, ctrlModelNode));
				return iDynaCtrlModel;
			}
		}
		iDynaCtrlModel.init(this, ctrlModelNode);
		return iDynaCtrlModel;
	}

	protected IDynaCtrlHandler createDynaCtrlHandler(IDynaCtrlModel iDynaCtrlModel) throws Exception {
		return this.getDynaViewSettingModel().createDynaCtrlHandler(iDynaCtrlModel);
	}

	@Override
	public IDynaViewController getDynaViewController() {
		return this.iDynaViewController;
	}

	@Override
	public IApplicationModel getAppModel() {
		return getDynaViewController().getAppModel();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.ibizsys.paas.controller.ViewControllerBase#createWebContext(javax
	 * .servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected IWebContext createWebContext(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return WebContext.getCurrent();
	}

	// @Override
	// public String getViewType() {
	// return this.strViewType;
	// }

	@Override
	public IDynaViewSetting getDynaViewSetting() {
		return this.iDynaViewSettingModel;
	}

	/**
	 * 获取动态视图设置模型对象
	 * 
	 * @return
	 */
	public IDynaViewSettingModel getDynaViewSettingModel() {
		return this.iDynaViewSettingModel;
	}

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		throw new Exception("没有实现");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.ibizsys.paas.controller.IDynaViewControllerInst#process(javax.servlet
	 * .http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
	 * net.ibizsys.paas.web.IWebContext)
	 */
	@Override
	public boolean process(HttpServletRequest request, HttpServletResponse response, IWebContext iWebContext) throws Exception {
		String strCtrlId = WebContext.getCtrlId(iWebContext);
		String strCtrlAction = WebContext.getAction(iWebContext);

		if (!StringHelper.isNullOrEmpty(strCtrlId)) {
			AjaxActionResult ajaxActionResult = onCtrlAjaxAction(request, response, strCtrlId, strCtrlAction);
			response.getWriter().print(ajaxActionResult.toJSONString());
			response.getWriter().flush();
			response.getWriter().close();
			return true;
		}

		String strCounterId = WebContext.getCounterId(iWebContext);
		if (!StringHelper.isNullOrEmpty(strCounterId)) {
			AjaxActionResult ajaxActionResult = onCounterAjaxAction(strCounterId, strCtrlAction);
			response.getWriter().print(ajaxActionResult.toJSONString());
			response.getWriter().flush();
			response.getWriter().close();
			return true;
		}

		if (!StringHelper.isNullOrEmpty(strCtrlAction)) {
			AjaxActionResult ajaxActionResult = onViewAjaxAction(strCtrlAction);
			ajaxActionResult = getAppModel().doFilterViewAction(this, request, response, strCtrlAction, ajaxActionResult);
			response.getWriter().print(ajaxActionResult.toJSONString());
			response.getWriter().flush();
			response.getWriter().close();
			return true;
		}
		return false;
	}

	
	@Override
	protected AjaxActionResult onCtrlAjaxAction(HttpServletRequest request, HttpServletResponse response, String strCtrlId, String strAction) throws Exception {
		ICtrlHandler iCtrlHandler = this.getCtrlHandler(strCtrlId, true);
		if(iCtrlHandler == null){
			iCtrlHandler = this.getDynaViewController().getCtrlHandler(strCtrlId, true);
			if(iCtrlHandler!=null){
				CtrlHandler.setCurrent(iCtrlHandler);
				return getAppModel().doViewCtrlAjaxAction(this, request, response, strCtrlId, strAction, iCtrlHandler);
			}
		}
		return super.onCtrlAjaxAction(request, response, strCtrlId, strAction);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.controller.ViewControllerBase#onLoadViewModel()
	 */
	@Override
	protected AjaxActionResult onLoadViewModel() throws Exception {
		DynaViewModelAjaxActionResult viewModelAjaxActionResult = new DynaViewModelAjaxActionResult();
		this.getWebContext().setCurAjaxActionResult(viewModelAjaxActionResult);
		onFillViewModelAjaxActionResult(viewModelAjaxActionResult);
		return viewModelAjaxActionResult;
	}

	@Override
	protected void onFillViewModelAjaxActionResult(ViewModelAjaxActionResult viewModelAjaxActionResult) throws Exception {
		super.onFillViewModelAjaxActionResult(viewModelAjaxActionResult);
		DynaViewModelAjaxActionResult dynaViewModelAjaxActionResult = (DynaViewModelAjaxActionResult) viewModelAjaxActionResult;
		java.util.Iterator<ICtrlModel> ctrlModels = this.getCtrlModels();
		if (ctrlModels != null) {
			while (ctrlModels.hasNext()) {
				ICtrlModel iCtrlMode = ctrlModels.next();
				if (!(iCtrlMode instanceof IDynaCtrlModel)) {
					continue;
				}
				if (!(iCtrlMode instanceof IDynaModelJsonExporter)) {
					continue;
				}

				IDynaModelJsonExporter iDynaModelJsonExporter = (IDynaModelJsonExporter) iCtrlMode;
				ObjectNode objCtrlMode = iDynaModelJsonExporter.toJsonObject(null);
				if (objCtrlMode != null) {
					dynaViewModelAjaxActionResult.getCtrls().add(objCtrlMode.toString());
				}
			}
		}
		
		
		java.util.Iterator<IDynaUIActionModel> dynaUIActionModels = this.getDynaUIActionModels();
		if (dynaUIActionModels != null) {
			while (dynaUIActionModels.hasNext()) {
				IDynaUIActionModel iDynaUIActionModel = dynaUIActionModels.next();
				if (!(iDynaUIActionModel instanceof IDynaModelJsonExporter)) {
					continue;
				}

				IDynaModelJsonExporter iDynaModelJsonExporter = (IDynaModelJsonExporter) iDynaUIActionModel;
				ObjectNode objCtrlMode = iDynaModelJsonExporter.toJsonObject(null);
				if (objCtrlMode != null) {
					dynaViewModelAjaxActionResult.getUIActions().add(objCtrlMode.toString());
				}
			}
		}
	}

	
	protected IDynaUIActionModel loadDynaUIActionModel(ObjectNode uiActionModelNode) throws Exception {
		String strActionMode = JsonNodeHelper.getString(uiActionModelNode,IDynaUIActionModel.ATTR_ACTIONMODE, null);
		if (StringHelper.isNullOrEmpty(strActionMode)) {
			throw new Exception(StringHelper.format("没有指定动态界面行为模式"));
		}
		
		return onLoadDynaUIActionModel(strActionMode, uiActionModelNode);
	}
	
	protected IDynaUIActionModel onLoadDynaUIActionModel(String strActionMode,ObjectNode uiActionModelNode) throws Exception {
		IDynaUIActionModel iDynaUIActionModel = null;
		if((StringHelper.compare(strActionMode, IDynaUIActionModel.ACTIONMODE_FRONT, true)==0)
				||(StringHelper.compare(strActionMode, IDynaUIActionModel.ACTIONMODE_WFFRONT, true)==0)){
			iDynaUIActionModel = new DefaultDynaFrontUIActionModel();
		}
		else
			if((StringHelper.compare(strActionMode, IDynaUIActionModel.ACTIONMODE_BACKEND, true)==0)
					||(StringHelper.compare(strActionMode, IDynaUIActionModel.ACTIONMODE_WFBACKEND, true)==0)){
				iDynaUIActionModel = new DefaultDynaBackendUIActionModel();
			}
			else{
				iDynaUIActionModel = new DefaultDynaUIActionModel();
			}
		iDynaUIActionModel.init(this.getDEModel(), uiActionModelNode);
		return iDynaUIActionModel;
	}
	
	/**
	 * 注册动态界面行为
	 * @param iDynaUIActionModel
	 * @throws Exception
	 */
	protected void registerDynaUIActionModel(IDynaUIActionModel iDynaUIActionModel) throws Exception {
		this.dynaUIActionModeList.add(iDynaUIActionModel);
	}

	
	/**
	 * 获取动态界面行为对象集合
	 * @return
	 */
	public java.util.Iterator<IDynaUIActionModel> getDynaUIActionModels(){
		if(this.dynaUIActionModeList.size() == 0)
			return null;
		return this.dynaUIActionModeList.iterator();
	}

	@Override
	public String getDynaViewMode() {
		return this.strDynaViewMode;
	}
	
	
	
}
