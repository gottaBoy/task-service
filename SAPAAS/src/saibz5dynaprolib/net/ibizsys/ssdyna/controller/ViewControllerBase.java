package net.ibizsys.ssdyna.controller;

import java.util.HashMap;
import java.util.Iterator;

import com.fasterxml.jackson.databind.node.ObjectNode;

import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.IPSAppViewRef;
import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.control.IPSAjaxControl;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.view.IPSUIAction;
import net.ibizsys.paas.control.IControl;
import net.ibizsys.paas.controller.IDynaViewControllerInst;
import net.ibizsys.paas.core.IApplication;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.IAjaxActionContext;
import net.ibizsys.paas.web.ViewModelAjaxActionResult;
import net.ibizsys.ssdyna.appmodel.IDynaAppModel;
import net.ibizsys.ssdyna.ctrlhandler.IDynaCtrlHandler;
import net.ibizsys.ssdyna.ctrlmodel.IDynaCtrlModel;
import net.ibizsys.ssdyna.sysmodel.IDynaInstModel;
import net.ibizsys.ssdyna.sysmodel.IDynaSysModel;
import net.ibizsys.ssdyna.view.DynaUIActionModel;
import net.ibizsys.ssdyna.view.IDynaUIActionModel;
import net.ibizsys.ssdyna.view.IDynaViewInstModel;
import net.ibizsys.ssdyna.view.IDynaViewModel;
import net.ibizsys.ssdyna.web.DynaViewModelAjaxActionResult;
import net.ibizsys.ssdyna.web.WebContext;
import net.sf.json.JSONObject;

/**
 * 动态视图控制器基类
 * @author Administrator
 *
 */
public abstract class ViewControllerBase extends net.ibizsys.paas.controller.ViewControllerBase implements IDynaViewModel{

	private Object objPrepareViewController = new Object();
	private Boolean bPrepareViewController = false;
	private IPSAppView iPSAppView = null;
	private long nLastCheckExpiredTime = 0l;
	private long nLastCheckExpiredInterval = 5000l;
	
	private HashMap<String, IDynaUIActionModel> uiActionModelMap = null;
	
	public ViewControllerBase() throws Exception {
		super();
	}

	
	@Override
	protected void prepareViewController(boolean bReload) throws Exception {
		synchronized (this.objPrepareViewController) {
			this.bPrepareViewController = false;
		}
		super.prepareViewController(bReload);
	}
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.controller.ViewControllerBase#prepareViewController()
	 */
	@Override
	public void prepareViewController() throws Exception {
		if(isEnableDynaView()) {
			if(this.getPSAppView()!=null && isCheckExpired()){
				this.setLastCheckExpiredTime(System.currentTimeMillis());
				IPSAppView iPSAppView = getDynaAppModel().getPSApplication().getPSAppView(this.getId(), false);
				if(iPSAppView.getLastModifyTime()!=this.getPSAppView().getLastModifyTime()){
					this.iPSAppView = iPSAppView;
					prepareViewController(true);
					return;
				}
			}
			
			if(this.iPSAppView==null){
				if(getDynaAppModel().getPSApplication() == null){
					throw new Exception("无法获取当前动态应用模型对象");
				}
				this.iPSAppView = getDynaAppModel().getPSApplication().getPSAppView(this.getId(), false);
				this.setLastCheckExpiredTime(System.currentTimeMillis());
			}
			
			super.prepareViewController();
			
			synchronized (this.objPrepareViewController) {
				if (!this.bPrepareViewController) {
					onPrepareDynaViewController();
					this.bPrepareViewController = true;
				}
			}
			return;
		}
		else {
			super.prepareViewController();
		}
		
	}

	/**
	 * 准备动态视图控制器
	 * @throws Exception
	 */
	protected void onPrepareDynaViewController() throws Exception{
		prepareDynaViewParam();
		prepareDynaUIActions();
		prepareDynaCtrlModels();
		prepareDynaCtrlHandlers();
	}
	
	
	/**
	 * 准备动态视图参数
	 * 
	 * @throws Exception
	 */
	protected void prepareDynaViewParam() throws Exception {
		
	}

	/**
	 * 准备动态部件模型
	 * 
	 * @throws Exception
	 */
	protected void prepareDynaCtrlModels() throws Exception {
		java.util.ArrayList<IPSControl> psControls = this.getPSAppView().getAllPSControls();
		for (IPSControl iPSControl : psControls) {
			if(this.getCtrlModel(iPSControl.getName(), true)!=null)
				continue;
			IDynaCtrlModel iDynaCtrlModel = this.createDynaCtrlModel(iPSControl);
			if(iDynaCtrlModel == null)
				continue;
			if (iPSControl.getPSControlParam() != null && iPSControl.getPSControlParam().getCtrlParamNames() != null) {
				java.util.Iterator<String> params = iPSControl.getPSControlParam().getCtrlParamNames();
				while (params.hasNext()) {
					String strParamName = params.next();
					iDynaCtrlModel.setCtrlParam(strParamName, iPSControl.getPSControlParam().getCtrlParam(strParamName, ""));
				}
			}
			iDynaCtrlModel.init(this, iPSControl);
			this.registerCtrlModel(iPSControl.getName(), iDynaCtrlModel);
		}
	}
	
	/**
	 * 建立视图动态部件模型对象
	 * @param iPSControl
	 * @return
	 * @throws Exception
	 */
	@Override
	public IDynaCtrlModel createDynaCtrlModel(IPSControl iPSControl)throws Exception{
		return this.getDynaAppModel().createDynaCtrlModel(this, iPSControl);
	}
	
	
	/**
	 * 准备动态部件处理对象
	 * 
	 * @throws Exception
	 */
	protected void prepareDynaCtrlHandlers() throws Exception {

		java.util.ArrayList<IPSAjaxControl> psAjaxControls = this.getPSAppView().getAllPSAjaxControls();
		for (IPSAjaxControl iPSAjaxControl : psAjaxControls) {
			if(this.getCtrlHandler(iPSAjaxControl.getName(), true)!=null)
				continue;
			
			IDynaCtrlHandler iDynaCtrlHandler = createDynaCtrlHandler(iPSAjaxControl);
			if(iDynaCtrlHandler == null)
				continue;
			iDynaCtrlHandler.init(this, iPSAjaxControl);
			this.registerCtrlHandler(iPSAjaxControl.getName(), iDynaCtrlHandler);
		}
		
	}

	
	/**
	 * 建立视图动态部件模型对象
	 * @param iPSControl
	 * @return
	 * @throws Exception
	 */
	@Override
	public IDynaCtrlHandler createDynaCtrlHandler(IPSControl iPSControl)throws Exception{
		return this.getDynaAppModel().createDynaCtrlHandler(this, iPSControl);
	}
	


	/**
	 * 准备动态界面行为集合
	 * 
	 * @throws Exception
	 */
	protected void prepareDynaUIActions() throws Exception {
		java.util.Iterator<IPSUIAction> psUIActions = this.getPSAppView().getPSUIActions();
		while(psUIActions.hasNext()){
			IPSUIAction iPSUIAction = psUIActions.next();
			DynaUIActionModel dynaUIActionModel = new DynaUIActionModel();
			dynaUIActionModel.init(this,iPSUIAction);
			registerDynaUIActionModel(iPSUIAction.getUIActionTag(),dynaUIActionModel);
		}
	}
	
	
	@Override
	public void registerDynaUIActionModel(String strActionTag, IDynaUIActionModel iDynaUIActionModel) throws Exception {
		if(this.uiActionModelMap == null) {
			this.uiActionModelMap = new HashMap<String, IDynaUIActionModel>();
		}
		this.uiActionModelMap.put(strActionTag, iDynaUIActionModel);
		this.registerUIAction(strActionTag);
	}
	
	@Override
	public Iterator<IDynaUIActionModel> getDynaUIActionModels() {
		if(this.uiActionModelMap == null || this.uiActionModelMap.size() == 0){
			return null;
		}
		return uiActionModelMap.values().iterator();
	}

	@Override
	public IApplication getApplication() {
		return getDynaAppModel();
	}


	@Override
	public String getViewType() {
		return this.getPSAppView().getViewType();
	}


	@Override
	public IControl getControl(String strControlName) throws Exception {
		return this.getCtrlModel(strControlName);
	}


	@Override
	public IDataEntity getDataEntity() {
		return this.getDEModel();
	}


	@Override
	public AjaxActionResult process(IAjaxActionContext iAjaxActionContext) throws Exception {
		throw new Exception("没有实现");
	}


	@Override
	public String getName() {
		return this.getTitle();
	}


	@Override
	public IPSAppView getPSAppView() {
		return this.iPSAppView;
	}


	@Override
	public IDynaAppModel getDynaAppModel() {
		return (IDynaAppModel)this.getAppModel();
	}
	
	/**
	 * 获取动态系统模型
	 * @return
	 */
	@Override
	public IDynaSysModel getDynaSysModel(){
		return (IDynaSysModel)this.getSystemModel();
	}
	
	protected long getLastCheckExpiredTime(){
		return this.nLastCheckExpiredTime;
	}
	
	protected void setLastCheckExpiredTime(long nLastCheckExpiredTime){
		this.nLastCheckExpiredTime = nLastCheckExpiredTime;
	}
	
	protected boolean isCheckExpired(){
		return System.currentTimeMillis()-getLastCheckExpiredTime()>nLastCheckExpiredInterval;
	}
	
	@Override
	public boolean isEnableDynaView() {
		return isDynaViewInstMode();
	}
	
	
	@Override
	public boolean isDynaViewInstMode() {
		return false;
	}
	
	@Override
	protected boolean isRegisterToVCGlobal() {
		return !isDynaViewInstMode();
	}
	
	
	@Override
	protected IDynaViewControllerInst getDynaViewControllerInst(String strViewId) throws Exception {
		String strDynaInstId = WebContext.getDynaSysInstId(false);
		IDynaInstModel iDynaInstModel = this.getDynaSysModel().getDynaInstModel(strDynaInstId);
		IDynaViewControllerInst iDynaViewControllerInst = iDynaInstModel.getDynaViewControllerInst(strViewId, true);
		if(iDynaViewControllerInst == null) {
			IDynaViewInstModel iDynaViewInstModel = this.createDynaViewInstModel();
			SimpleEntity simpleEntity = new SimpleEntity();
			simpleEntity.set("PSAPPVIEWID", strViewId);
			iDynaViewInstModel.init(this, simpleEntity, null);
			iDynaInstModel.registerDynaViewControllerInst(iDynaViewInstModel);
			return iDynaViewInstModel;
		}
		return iDynaViewControllerInst;
		
	}
	
	protected IDynaViewInstModel createDynaViewInstModel()throws Exception{
		return new DynaViewControllerInst();
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
		
		JSONObject viewObject = viewModelAjaxActionResult.getView(true);
		JSONObjectHelper.put(viewObject, "title", this.getTitle());
		JSONObjectHelper.put(viewObject, "caption", this.getCaption());
		
		
		DynaViewModelAjaxActionResult dynaViewModelAjaxActionResult = (DynaViewModelAjaxActionResult) viewModelAjaxActionResult;
		
		
		
		java.util.Iterator<ICtrlModel> ctrlModels = this.getCtrlModels();
		if (ctrlModels != null) {
			while (ctrlModels.hasNext()) {
				ICtrlModel iCtrlMode = ctrlModels.next();
				if (!(iCtrlMode instanceof IDynaCtrlModel)) {
					continue;
				}
				
				IDynaCtrlModel iDynaCtrlModel = (IDynaCtrlModel)iCtrlMode;
				if(!iDynaCtrlModel.isDynaCtrl())
					continue;
				
				ObjectNode objCtrlModel = iDynaCtrlModel.toJsonObject(null);
				if (objCtrlModel != null) {
					dynaViewModelAjaxActionResult.getCtrls().add(objCtrlModel.toString());
				}
			}
		}
		
		
		java.util.Iterator<IDynaUIActionModel> dynaUIActionModels = this.getDynaUIActionModels();
		if (dynaUIActionModels != null) {
			while (dynaUIActionModels.hasNext()) {
				IDynaUIActionModel iDynaUIActionModel = dynaUIActionModels.next();
				ObjectNode objCtrlMode = iDynaUIActionModel.toJsonObject(null);
				if (objCtrlMode != null) {
					dynaViewModelAjaxActionResult.getUIActions().add(objCtrlMode.toString());
				}
			}
		}
		
		
		if(this.getPSAppView()!=null){
			
			JSONObjectHelper.put(viewObject, "dynamodel", this.getPSAppView().getDynaModelContent());
			
			java.util.Iterator<IPSAppViewRef> appViewRefs = this.getPSAppView().getPSAppViewRefs();
			while(appViewRefs.hasNext()){
				IPSAppViewRef iPSAppViewRef = appViewRefs.next();
				ObjectNode objRefView = iPSAppViewRef.toJsonObject(null);
				if (objRefView != null) {
					dynaViewModelAjaxActionResult.getRefViews().add(objRefView.toString());
				}
			}
			
			java.util.Iterator<IPSCodeList> psCodeLists = this.getPSAppView().getAllRelatedPSCodeLists();
			while(psCodeLists.hasNext()){
				IPSCodeList iPSCodeList = psCodeLists.next();
				ObjectNode objCodeList = iPSCodeList.toJsonObject(null);
				if (objCodeList != null) {
					dynaViewModelAjaxActionResult.getCodeLists().add(objCodeList.toString());
				}
			}
		}
	}

	@Override
	protected boolean isCacheDynaViewControllerInst() {
		return false;
	}
}
