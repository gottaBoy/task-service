package net.ibizsys.ssdyna.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.control.IPSAjaxControl;
import net.ibizsys.model.view.IPSUIAction;
import net.ibizsys.paas.appmodel.IApplicationModel;
import net.ibizsys.paas.control.IControl;
import net.ibizsys.paas.controller.ViewControllerBase;
import net.ibizsys.paas.core.IApplication;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.IAjaxActionContext;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.ssdyna.appmodel.IDynaAppModel;
import net.ibizsys.ssdyna.ctrlhandler.IDynaCtrlHandler;
import net.ibizsys.ssdyna.ctrlmodel.IDynaCtrlModel;

import org.hibernate.SessionFactory;

/**
 * 动态视图模型对象
 * @author Administrator
 *
 */
public abstract class DynaViewModelBase extends ViewControllerBase implements IDynaViewModel {

	private IDynaAppModel iDynaAppModel = null;
	private IPSAppView iPSAppView = null;
	
	public DynaViewModelBase() throws Exception {
		super();
	}

	/**
	 * 初始化
	 * @param iPSJITAppModel
	 * @param iPSAppView
	 * @throws Exception
	 */
	public void init(IDynaAppModel iDynaAppModel,IPSAppView iPSAppView) throws Exception {
		
		this.iPSAppView = iPSAppView;
		this.iDynaAppModel = iDynaAppModel;
		this.setId(this.iPSAppView.getId());
		if(this.iPSAppView.getCaption()!=null){
			this.setCaption(this.iPSAppView.getCaption());
		}
		if(this.iPSAppView.getSubCaption()!=null){
		 this.setSubCaption(this.iPSAppView.getSubCaption());
		}
		 if(this.iPSAppView.getTitle()!=null){
		 this.setTitle(this.iPSAppView.getTitle());
		 }
//		 <#if item.getAccUserMode() gt 0>
//		 this.setAccessUserMode(${item.getAccUserMode()?c});
//		 </#if>
//		 <#if item.getAccessKey()??>
//		 this.setAccessKey("${item.getAccessKey()}");
//		 </#if>
//		 if(this.getPSAppView().getPSAppViewParams()!=null){
//			 java.util.Iterator<IPSAppViewParam> psAppViewParams = this.getPSAppView().getPSAppViewParams();
//			 while(psAppViewParams.hasNext()){
//				 IPSAppViewParam iPSAppViewParam = psAppViewParams.next();
//				 this.setAttribute(iPSAppViewParam.getKey(),iPSAppViewParam.getValue());
//			 }
//		 }
		 
		// <#if item.getPSAppViewParams()??>
		// <#list item.getPSAppViewParams() as viewparam>
		// <#if viewparam.getDesc()??>
		// //${viewparam.getDesc()}
		// </#if>
		// this.setAttribute("${viewparam.key}","${viewparam.value}");
		// </#list>
		// </#if>
		//
		//ViewControllerGlobal.registerViewController(StringHelper.format("/%1$s/%2$s/%3$s.do",iPSJITAppModel.getPSApplication().getPKGCodeName(),iPSAppView.getPSAppModule().getCodeName(),iPSAppView.getCodeName()),this);
		
		
		//ViewControllerGlobal.registerViewController("${pub.getPKGCodeName()}.${app.getPKGCodeName()?lower_case}.${item.getPSAppModule().codeName?lower_case}.controller.${item.codeName}Controller",this);
		
		
//		 <#if item.isEnableWF()>
//         this.setWFModel(this.getSystemModel().getWFModel("${item.getPSWorkflow().id}"));
// <#if item.isWFIAMode()>  
//         this.setWFIAMode(true);
//         this.setWFStepValue("${item.getWFStepValue()}");
// </#if>
// <#if item.getPSDEWF()??>
//         this.setDEWF(this.getDEModel().getDEWF("${item.getPSDEWF().id}"));    
// </#if>        
// </#if>
//       
// <#if item.isRedirectView() && item.isPSDEView() >
//           this.setEnableWorkflow(<#if item.isEnableWorkflow()>true<#else>false</#if>);
// </#if>   

		
	}

	@Override
	public IApplication getApplication() {
		return getAppModel();
	}

	@Override
	public String getViewType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IControl getControl(String strControlName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDataEntity getDataEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AjaxActionResult process(IAjaxActionContext iAjaxActionContext) throws Exception {
		throw new Exception("没有实现");
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IApplicationModel getAppModel() {
		return this.iDynaAppModel;
	}

	
	
	@Override
	protected IWebContext createWebContext(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return WebContext.getCurrent();
	}


	@Override
	public IPSAppView getPSAppView() {
		return  this.iPSAppView;
	}
	
	@Override
	public ISystemModel getSystemModel() {
		return getAppModel().getSystemModel();
	}

	@Override
	public IDataEntityModel getDEModel() {
		if(this.getPSAppView().getPSDataEntity()!=null){
			try{
				return getSystemModel().getDataEntityModel(this.getPSAppView().getPSDataEntity().getName());
			}
			catch(Exception ex){
				
			}
		}
		return super.getDEModel();
	}
	
	
	//
	//
	// @Override
	// protected void prepareViewParam() throws Exception
	// {
	// super.prepareViewParam();
	// <#if item.isEnableWF()>
	// this.setWFModel(this.getSystemModel().getWFModel("${item.getPSWorkflow().id}"));
	// <#if item.isWFIAMode()>
	// this.setWFIAMode(true);
	// this.setWFStepValue("${item.getWFStepValue()}");
	// </#if>
	// <#if item.getPSDEWF()??>
	// this.setDEWF(this.getDEModel().getDEWF("${item.getPSDEWF().id}"));
	// </#if>
	// </#if>
	//
	// <#if item.isRedirectView() && item.isPSDEView() >
	// this.setEnableWorkflow(<#if
	// item.isEnableWorkflow()>true<#else>false</#if>);
	// </#if>
	//
	// }
	//


	//
	// /* (non-Javadoc)
	// * @see net.ibizsys.paas.controller.IViewController#getService()
	// */
	// @Override
	// public IService getService()
	// {
	// return get${de.codeName}Service();
	// }
	//
	//
	//
	// </#if>



	/**
	 * 准备部件模型
	 * 
	 * @throws Exception
	 */
	@Override
	protected void prepareCtrlModels() throws Exception {

		java.util.ArrayList<IPSAjaxControl> psAjaxControls = this.iPSAppView.getAllPSAjaxControls();
		for (IPSAjaxControl iPSAjaxControl : psAjaxControls) {
			if (iPSAjaxControl.hasCtrlModel()) {
				IDynaCtrlModel iDynaCtrlModel = this.getDynaAppModel().createDynaCtrlModel(this,iPSAjaxControl);
				if (iPSAjaxControl.getPSControlParam() != null && iPSAjaxControl.getPSControlParam().getCtrlParamNames() != null) {
					java.util.Iterator<String> params = iPSAjaxControl.getPSControlParam().getCtrlParamNames();
					while (params.hasNext()) {
						String strParamName = params.next();
						iDynaCtrlModel.setCtrlParam(strParamName, iPSAjaxControl.getPSControlParam().getCtrlParam(strParamName, ""));
					}
				}
				iDynaCtrlModel.init(this, iPSAjaxControl);
				this.registerCtrlModel(iPSAjaxControl.getName(), iDynaCtrlModel);
			}
		}
	}

	/**
	 * 准备部件处理对象
	 * 
	 * @throws Exception
	 */
	@Override
	protected void prepareCtrlHandlers() throws Exception {

		java.util.ArrayList<IPSAjaxControl> psAjaxControls = this.iPSAppView.getAllPSAjaxControls();
		for (IPSAjaxControl iPSAjaxControl : psAjaxControls) {
			
			IDynaCtrlHandler iDynaCtrlHandler = this.getDynaAppModel().createDynaCtrlHandler(this,iPSAjaxControl);
			iDynaCtrlHandler.init(this, iPSAjaxControl);
			this.registerCtrlHandler(iPSAjaxControl.getName(), iDynaCtrlHandler);
		}

		//
		// <#list item.getPSUpdatePanels() as ctrl>
		// //注册 ${ctrl.name}
		// net.ibizsys.paas.ctrlhandler.UpdatePanelHandler
		// ${srfparamname('${ctrl.name}')} = new
		// net.ibizsys.paas.ctrlhandler.UpdatePanelHandler();
		// <#if ctrl.getPSSysMsgTempl()??>
		// //设置消息模板 ${ctrl.getPSSysMsgTempl().name}
		// ${srfparamname('${ctrl.name}')}.setSysMsgTemplId("${ctrl.getPSSysMsgTempl().id}");
		// </#if>
		// <#if ctrl.getPSDataEntity()??>
		// ${srfparamname('${ctrl.name}')}.setDEName("${ctrl.getPSDataEntity().name}");
		// </#if>
		// <#if ctrl.getPSDEAction()??>
		// ${srfparamname('${ctrl.name}')}.setDEActionName("${ctrl.getPSDEAction().name}");
		// </#if>
		// ${srfparamname('${ctrl.name}')}.init(this);
		// this.registerCtrlHandler("${ctrl.name}",${srfparamname('${ctrl.name}')});
		// </#list>
	}

	/**
	 * 注册界面行为
	 * 
	 * @throws Exception
	 */
	@Override
	protected void prepareUIActions() throws Exception {
		if (iPSAppView.getPSUIActions() != null) {
			java.util.Iterator<IPSUIAction> psUIActions = iPSAppView.getPSUIActions();
			while (psUIActions.hasNext()) {
				IPSUIAction iPSUIAction = psUIActions.next();
				if (StringHelper.compare(iPSUIAction.getUIActionMode(), "BACKEND", false) == 0) {
					this.registerUIAction(iPSUIAction.getCodeName());
				}

				if ((StringHelper.compare(iPSUIAction.getUIActionMode(), "DEUIACTION", false) == 0) && (!StringHelper.isNullOrEmpty(iPSUIAction.getDataAccessAction()))) {
					// <#if uiaction.getPSDataEntity()??>
					// //注册行为[${uiaction.name}]访问操作
					// this.registerDEDataAccessAction("${uiaction.getDataEntity().name}","${uiaction.getDataAccessAction()}");
					// <#elseif item.getDataEntity()??>
					// //注册行为[${uiaction.name}]访问操作
					// this.registerDEDataAccessAction("${item.getDataEntity().name}","${uiaction.getDataAccessAction()}");
					// </#if>
				}
			}
		}

	}

	@Override
	public SessionFactory getSessionFactory() {
		return this.iDynaAppModel.getDynaSysModel().getSessionFactory();
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.ssdyna.view.IDynaViewModel#getDynaAppModel()
	 */
	@Override
	public IDynaAppModel getDynaAppModel() {
		return this.iDynaAppModel;
	}

	

	
}
