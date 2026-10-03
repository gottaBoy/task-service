package net.ibizsys.paas.web;

import javax.servlet.jsp.PageContext;

import net.ibizsys.paas.appmodel.IApplicationModel;
import net.ibizsys.paas.controller.IDynaViewController;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.controller.ViewControllerGlobal;
import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.ctrlmodel.IAppMenuModel;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;

/**
 * 视图控制器页面对象
 * 
 * @author Administrator
 *
 */
public class VCPage extends Page {
	/**
	 * 
	 */
	private final static JSONObject EMPTYJSON = new JSONObject();

	/**
	 * 视图控制类
	 */
	private IViewController iViewController = null;

	
	
	
	/**
	 * 初始化页面对象
	 * 
	 * @param context
	 */
	final public boolean init(PageContext context, String strViewControllerId) throws Exception {
		if (iViewController == null) {
			iViewController = ViewControllerGlobal.getViewController(strViewControllerId);
			iViewController.prepareViewController();
			this.setAccessUserMode(iViewController.getAccessUserMode());
			this.setAccessKey(iViewController.getAccessKey());
		}
		boolean bRet = init(context);
		if(iViewController instanceof IDynaViewController){
			if(((IDynaViewController)iViewController).isEnableDynaView()){
				((IDynaViewController)iViewController).prepareDynaViewControllerInst();
			}
		}
		return bRet;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.Page#onInit()
	 */
	@Override
	protected void onInit() throws Exception {
		super.onInit();
	}

	/**
	 * 获取视图控制类
	 * 
	 * @return
	 */
	public IViewController getViewController() {
		return this.iViewController;
	}

	/**
	 * 获取当前应用菜单模型
	 * 
	 * @return
	 * @throws Exception
	 */
	public IAppMenuModel getAppMenuModel() throws Exception {
		return this.getApplicationModel().getAppMenuModel(this.getWebContext().getCurUserMode());
	}

	/**
	 * 获取控件模型
	 * 
	 * @param strName
	 * @return
	 * @throws Exception
	 */
	public ICtrlModel getCtrlModel(String strName) throws Exception {
		return getViewController().getCtrlModel(strName);
	}

	/**
	 * 获取传入的父数据对象
	 * 
	 * @return
	 */
	public JSONObject getParentData() {
		String strParentData = this.getWebContext().getParamValue(WebContext.PARAM_PARENTDATA);
		if (!StringHelper.isNullOrEmpty(strParentData)) {
			return JSONObjectHelper.fromString(strParentData);
		}
		return EMPTYJSON;
	}

	/**
	 * 获取传入的父数据模式
	 * 
	 * @return
	 */
	public JSONObject getParentMode() {
		String strParentMode = this.getWebContext().getParamValue(WebContext.PARAM_PARENTMODE);
		if (!StringHelper.isNullOrEmpty(strParentMode)) {
			return JSONObjectHelper.fromString(strParentMode);
		}
		return EMPTYJSON;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.Page#getApplicationModel()
	 */
	@Override
	protected IApplicationModel getApplicationModel() throws Exception {
		return getViewController().getAppModel();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.Page#mapRealPageUrl(java.lang.String)
	 */
	@Override
	protected String mapRealPageUrl(String strPageUrl) throws Exception {
		if (strPageUrl.charAt(0) == '/') {
			return "../.." + strPageUrl;
		}
		return strPageUrl;
	}
	
	
	/**
	 * 测试实体数据操作标识
	 * @param strAction
	 * @return
	 * @throws Exception
	 */
	public boolean testDEDataAccessAction(String strAction) throws Exception {
		return getViewController().testDEDataAccessAction(null, null, strAction, true).getRetCode() == Errors.OK;
	}
	
	
	
	
	
	@Override
	public boolean isShowAction(String strActionPrivTag) throws Exception{
		if(!StringHelper.isNullOrEmpty(strActionPrivTag)){
			String strDataTarget = getViewController().getDEModel().getDEOPPrivTarget(strActionPrivTag);
			if(StringHelper.compare(strDataTarget, IDataEntityModel.DEOPPRIVTARGET_NONE,false) == 0){
				return testDEDataAccessAction(strActionPrivTag);
			}
		}
		return super.isShowAction(strActionPrivTag);
	}

	/**
	 * 获取当前VC页面
	 * @return
	 */
	public static VCPage getCurrentVCPage(){
		return (VCPage) Page.getCurrent();
	}
}
