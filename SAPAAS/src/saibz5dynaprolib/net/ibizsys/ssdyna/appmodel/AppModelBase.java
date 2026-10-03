package net.ibizsys.ssdyna.appmodel;

import java.util.HashMap;

import net.ibizsys.model.app.IPSApplication;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.control.IPSAjaxControl;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.paas.appmodel.IAppDEViewModel;
import net.ibizsys.paas.control.ControlTypes;
import net.ibizsys.paas.ctrlhandler.EditFormHandlerBase;
import net.ibizsys.paas.ctrlhandler.EditFormHandlerBase2;
import net.ibizsys.paas.ctrlhandler.EditFormHandlerBase3;
import net.ibizsys.paas.ctrlhandler.GridHandlerBase;
import net.ibizsys.paas.ctrlhandler.GridHandlerBase2;
import net.ibizsys.paas.ctrlhandler.SearchFormHandlerBase;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.ObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.ctrlhandler.WFActionFormHandlerBase;
import net.ibizsys.pswf.ctrlhandler.WFEditFormHandlerBase;
import net.ibizsys.ssdyna.ctrlhandler.DynaDRBarHandler;
import net.ibizsys.ssdyna.ctrlhandler.DynaDRTabHandler;
import net.ibizsys.ssdyna.ctrlhandler.DynaEditFormHandler;
import net.ibizsys.ssdyna.ctrlhandler.DynaEditFormHandler2;
import net.ibizsys.ssdyna.ctrlhandler.DynaEditFormHandler3;
import net.ibizsys.ssdyna.ctrlhandler.DynaGridHandler;
import net.ibizsys.ssdyna.ctrlhandler.DynaGridHandler2;
import net.ibizsys.ssdyna.ctrlhandler.DynaSearchFormHandler;
import net.ibizsys.ssdyna.ctrlhandler.IDynaCtrlHandler;
import net.ibizsys.ssdyna.ctrlmodel.DynaDRBarModel;
import net.ibizsys.ssdyna.ctrlmodel.DynaDRTabModel;
import net.ibizsys.ssdyna.ctrlmodel.DynaEditFormModel;
import net.ibizsys.ssdyna.ctrlmodel.DynaGridModel;
import net.ibizsys.ssdyna.ctrlmodel.DynaSearchFormModel;
import net.ibizsys.ssdyna.ctrlmodel.DynaToolbarModel;
import net.ibizsys.ssdyna.ctrlmodel.IDynaCtrlModel;
import net.ibizsys.ssdyna.sysmodel.IDynaInstModel;
import net.ibizsys.ssdyna.sysmodel.IDynaSysModel;
import net.ibizsys.ssdyna.view.IDynaViewModel;
import net.ibizsys.ssdyna.web.WebContext;
import net.ibizsys.ssdynawf.ctrlhandler.DynaWFActionFormHandler;
import net.ibizsys.ssdynawf.ctrlhandler.DynaWFEditFormHandler;

/**
 * 动态应用模型对象基类
 * @author Administrator
 *
 */
public abstract class AppModelBase extends net.ibizsys.saas.appmodel.AppModelBase implements IDynaAppModel {

	private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(AppModelBase.class);
	//private IPSApplication iPSApplication = null;
	
	private static HashMap<String, String> dynaCtrlModelMap = new HashMap<String, String>();
	private static HashMap<String, String> dynaCtrlHandlerMap = new HashMap<String, String>();
	
	static{
		dynaCtrlModelMap.put(ControlTypes.EditForm, DynaEditFormModel.class.getCanonicalName());
		dynaCtrlModelMap.put(ControlTypes.SearchForm,DynaSearchFormModel.class.getCanonicalName());
		dynaCtrlModelMap.put(ControlTypes.Toolbar,DynaToolbarModel.class.getCanonicalName());
		dynaCtrlModelMap.put(ControlTypes.Grid,DynaGridModel.class.getCanonicalName());
		dynaCtrlModelMap.put(ControlTypes.DRBar,DynaDRBarModel.class.getCanonicalName());
		dynaCtrlModelMap.put(ControlTypes.DRTab,DynaDRTabModel.class.getCanonicalName());
		
		dynaCtrlHandlerMap.put(GridHandlerBase.class.getCanonicalName(),DynaGridHandler.class.getCanonicalName());
		dynaCtrlHandlerMap.put(GridHandlerBase2.class.getCanonicalName(),DynaGridHandler2.class.getCanonicalName());
		dynaCtrlHandlerMap.put(SearchFormHandlerBase.class.getCanonicalName(),DynaSearchFormHandler.class.getCanonicalName());
		dynaCtrlHandlerMap.put(EditFormHandlerBase.class.getCanonicalName(),DynaEditFormHandler.class.getCanonicalName());
		dynaCtrlHandlerMap.put(EditFormHandlerBase2.class.getCanonicalName(),DynaEditFormHandler2.class.getCanonicalName());
		dynaCtrlHandlerMap.put(EditFormHandlerBase3.class.getCanonicalName(),DynaEditFormHandler3.class.getCanonicalName());
		dynaCtrlHandlerMap.put(WFEditFormHandlerBase.class.getCanonicalName(),DynaWFEditFormHandler.class.getCanonicalName());
		dynaCtrlHandlerMap.put(WFActionFormHandlerBase.class.getCanonicalName(),DynaWFActionFormHandler.class.getCanonicalName());
		
		dynaCtrlHandlerMap.put(ControlTypes.DRBar,DynaDRBarHandler.class.getCanonicalName());
		dynaCtrlHandlerMap.put(ControlTypes.DRTab,DynaDRTabHandler.class.getCanonicalName());
	}
	
	

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.appmodel.IDynaAppModel#getPSApplication()
	 */
	@Override
	public IPSApplication getPSApplication() throws Exception{
		try{
			return this.getDynaSysModel().getPSSystem().getPSApplication(this.getId());
		}
		catch(Exception ex){
			log.error(StringHelper.format("获取系统应用模型对象发生异常，%1$s",ex.getMessage()),ex);
			throw new Exception(StringHelper.format("获取动态应用发生异常，%1$",ex.getMessage()),ex);
		}
	}


	//VUE_R3

	@Override
	public IDynaCtrlModel createDynaCtrlModel(IDynaViewModel iDynaViewModel, IPSControl iPSControl) throws Exception {
		String strObject = dynaCtrlModelMap.get(iPSControl.getControlType());
		if(StringHelper.isNullOrEmpty(strObject))
			return null;
//		if(StringHelper.isNullOrEmpty(strObject)){
//			throw new Exception(StringHelper.format("无法获取指定类型[%1$s]动态部件模型对象",iPSControl.getControlType()));
//		}
		return (IDynaCtrlModel)ObjectHelper.create(strObject);
	}


	@Override
	public IDynaCtrlHandler createDynaCtrlHandler(IDynaViewModel iDynaViewModel, IPSControl iPSControl) throws Exception {
		String strHandler = null;
		if(iPSControl instanceof IPSAjaxControl){
			strHandler = ((IPSAjaxControl)iPSControl).getHandler();
		} 
		if(StringHelper.isNullOrEmpty(strHandler)){
			strHandler = iPSControl.getControlType();
		}
		String	strObject = dynaCtrlHandlerMap.get(strHandler);
		if(StringHelper.isNullOrEmpty(strObject)){
			throw new Exception(StringHelper.format("无法获取指定类型[%1$s]动态部件处理对象",strHandler));
		}
		return (IDynaCtrlHandler)ObjectHelper.create(strObject);
	}


	@Override
	public IDynaViewModel getDynaViewModel(String strAppViewId, boolean bTryMode) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDynaSysModel getDynaSysModel() {
		return (IDynaSysModel)super.getSystemModel();
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
		
		String strDynaInstId = WebContext.getDynaSysInstId(true);
		if(!StringHelper.isNullOrEmpty(strDynaInstId)) {
			IAppDEViewModel iAppDEViewModel = super.getAppViewByDEViewId(strDEViewId, true);
			if(iAppDEViewModel != null) {
				return iAppDEViewModel;
			}
			//有动态实例
			IDynaInstModel iDynaInstModel = this.getDynaSysModel().getDynaInstModel(strDynaInstId);
			String strPSAppViewId = KeyValueHelper.genUniqueId(this.getId(),strDEViewId);
			
			iAppDEViewModel = (IAppDEViewModel)iDynaInstModel.getDynaAppViewModel(strPSAppViewId,true);
			if(iAppDEViewModel!=null) {
				return iAppDEViewModel;
			}
			IPSAppView iPSAppView = getPSApplication().getPSAppView(strPSAppViewId, true);
			if(iPSAppView == null && !bTryMode) {
				throw new Exception(StringHelper.format("无法获取指定应用实体视图[%1$s]", strDEViewId));
			}
			
			//IPSAppDEView iPSAppDEView = (IPSAppDEView)iPSAppView;
			DynaAppDEViewModel appDEViewModel = new DynaAppDEViewModel();
			appDEViewModel.setId(iPSAppView.getId());
			appDEViewModel.setName(iPSAppView.getName());
			appDEViewModel.setTitle(iPSAppView.getTitle());
			appDEViewModel.setModuleName(iPSAppView.getPSAppModule().getCodeName());
			appDEViewModel.setOpenMode(iPSAppView.getOpenMode());
			if(iPSAppView.getHeight()>0) {
				appDEViewModel.setHeight(iPSAppView.getHeight());
			}
			if(iPSAppView.getWidth()>0) {
				appDEViewModel.setWidth(iPSAppView.getWidth());
			}
			
			iDynaInstModel.registerDynaAppViewModel(appDEViewModel);
			return appDEViewModel;
			
		}
		else {
			return super.getAppViewByDEViewId(strDEViewId, bTryMode);
		}
		
//		
//		
//		//获取指定
//		
//		
//		String strPSAppViewId = KeyValueHelper.genUniqueId(this.getId(),strDEViewId);
//		IPSAppView iPSAppView = getPSApplication().getPSAppView(strPSAppViewId, true);
//		if(iPSAppView == null && !bTryMode) {
//			throw new Exception(StringHelper.format("无法获取指定应用实体视图[%1$s]", strDEViewId));
//		}
//		
//		IPSAppDEView iPSAppDEView = (IPSAppDEView)iPSAppView;
//		DynaAppDEViewModel appDEViewModel = new DynaAppDEViewModel();
//		appDEViewModel.setId(iPSAppView.getId());
//		appDEViewModel.setName(iPSAppView.getName());
//		appDEViewModel.setTitle(iPSAppView.getTitle());
//		appDEViewModel.setModuleName(iPSAppView.getPSAppModule().getCodeName());
//		appDEViewModel.setOpenMode(iPSAppView.getOpenMode());
//		if(iPSAppView.getHeight()>0) {
//			appDEViewModel.setHeight(iPSAppView.getHeight());
//		}
//		if(iPSAppView.getWidth()>0) {
//			appDEViewModel.setWidth(iPSAppView.getWidth());
//		}
//		
//		this.registerAppView(appDEViewModel);
//		return appDEViewModel;
		
//		//注册视图 ${appview.name}
//<#if appview.isPSDEView()>
//	AppDEViewModel m${viewindex?c} = new AppDEViewModel();
//			m${viewindex?c}.setDEViewId("${appview.getPSDEViewId()}");
//<#else>
//			AppViewModel m${viewindex?c} = new AppViewModel();
//</#if>
//			m${viewindex?c}.setId("${appview.id}");
//			m${viewindex?c}.setName("${appview.codeName}");
//			<#if appview.getTitle()??>
//			m${viewindex?c}.setTitle("${appview.getTitle()}");
//			</#if>
//			<#if appview.getPSAppModule()??>
//			m${viewindex?c}.setModuleName("${appview.getPSAppModule().codeName}");
//			</#if>
//			<#if (appview.getOpenMode()??) && (appview.getOpenMode()?length gt 0)>
//			m${viewindex?c}.setOpenMode("${appview.getOpenMode()}");
//			</#if>
//			<#if appview.getHeight() gt 0>
//			m${viewindex?c}.setHeight(${appview.getHeight()?c});
//			</#if>
//			<#if appview.getWidth() gt 0>
//			m${viewindex?c}.setWidth(${appview.getWidth()?c});
//			</#if>
//			this.registerAppView(m${viewindex?c});
	

	}
}
