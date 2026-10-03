package net.ibizsys.ssdyna.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.ibizsys.model.control.IPSControl;
import net.ibizsys.paas.appmodel.IApplicationModel;
import net.ibizsys.paas.controller.IDynaViewController;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.view.IDynaViewSetting;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.ssdyna.ctrlhandler.IDynaCtrlHandler;
import net.ibizsys.ssdyna.ctrlmodel.IDynaCtrlModel;
import net.ibizsys.ssdyna.demodel.IDynaDEModel;
import net.ibizsys.ssdyna.view.IDynaViewInstModel;
import net.ibizsys.ssdyna.view.IDynaViewModel;

import org.hibernate.SessionFactory;

/**
 * 动态视图控制器实例实现基类
 * 
 * @author Administrator
 *
 */
public abstract class DynaViewControllerInstBase extends ViewControllerBase implements IDynaViewInstModel{

	private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(DynaViewControllerInstBase.class);
	
	private IDynaViewModel iDynaViewModel = null;
	
	private IDynaDEModel iDynaDEModel = null;
	
	private IService iService = null;
	
	public DynaViewControllerInstBase() throws Exception {
		super();
	}
	
	@Override
	public void init(IDynaViewController iDynaViewController, IEntity dsDynaViewInst, IDynaViewSetting iDynaViewSetting) throws Exception {
		iDynaViewModel = (IDynaViewModel)iDynaViewController;
		String strPSAppViewId = DataObject.getStringValue(dsDynaViewInst.get("PSAPPVIEWID"),"");
		if(StringHelper.isNullOrEmpty(strPSAppViewId)){
			throw new Exception("没有传入应用视图标识");
		}
		this.setId(strPSAppViewId);
		this.prepareViewController();
		
	}
	
	@Override
	protected void onPrepareDynaViewController() throws Exception {
		if(this.getPSAppView()!=null){
			if(this.getPSAppView().getPSDataEntity()!=null){
				this.iDynaDEModel = this.getDynaSysModel().getDynaDEModel(this.getPSAppView().getPSDataEntity().getId());
				this.iService = this.iDynaDEModel.getService(this.getSessionFactory());
			}
			this.setTitle(this.getPSAppView().getTitle());
			this.setCaption(this.getPSAppView().getCaption());
		}
		super.onPrepareDynaViewController();
	}

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
	public IDynaViewController getDynaViewController() {
		return this.iDynaViewModel;
	}


	@Override
	public IDynaViewSetting getDynaViewSetting() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getDynaViewMode() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/**
	 * 建立视图动态部件模型对象
	 * @param iPSControl
	 * @return
	 * @throws Exception
	 */
	@Override
	public IDynaCtrlModel createDynaCtrlModel(IPSControl iPSControl)throws Exception{
		return this.getDynaViewModel().createDynaCtrlModel(iPSControl);
	}
	
	@Override
	public IDynaCtrlHandler createDynaCtrlHandler(IPSControl iPSControl) throws Exception {
		return this.getDynaViewModel().createDynaCtrlHandler(iPSControl);
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
	
	@Override
	public ISystemModel getSystemModel() {
		return this.getDynaViewController().getSystemModel();
	}
	
	@Override
	public IDataEntityModel getDEModel() {
		if(this.iDynaDEModel!=null){
			return this.iDynaDEModel;
		}
		return this.getDynaViewController().getDEModel();
	}

	
	@Override
	public IService getService() {
		if(this.iService!=null){
			return this.iService;
		}
		return this.getDynaViewController().getService();
	}
	
	@Override
	public SessionFactory getSessionFactory() {
		return this.getDynaViewController().getSessionFactory();
	}
	
	@Override
	public IDynaViewModel getDynaViewModel(){
		return this.iDynaViewModel;
	}
	
	
	@Override
	public boolean isDynaViewInstMode() {
		return true;
	}
}
