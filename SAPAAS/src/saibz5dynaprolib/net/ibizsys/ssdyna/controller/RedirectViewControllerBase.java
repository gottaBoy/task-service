package net.ibizsys.ssdyna.controller;

import java.util.HashMap;
import java.util.Map;

import net.ibizsys.paas.appmodel.IAppViewModel;
import net.ibizsys.paas.appmodel.IApplicationRuntime;
import net.ibizsys.paas.control.form.IFormItem;
import net.ibizsys.paas.controller.IRedirectViewController;
import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.core.IDERIndex;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.demodel.IDEWFModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONObject;

/**
 * 重定向视图控制类
 * 
 * @author Administrator
 * 
 */
public abstract class RedirectViewControllerBase extends ViewControllerBase implements IRedirectViewController {

	private boolean bEnableWorkflow = false;

	protected static ThreadLocal<String> rdViewKey = new ThreadLocal<String>();
	protected static ThreadLocal<JSONObject> rdViewParam = new ThreadLocal<JSONObject>();
	private HashMap<String, String> rdViewMap = new HashMap<String, String>();

	public RedirectViewControllerBase() throws Exception {
		super();
	}

	/**
	 * 注册用户自定义重定向视图
	 * 
	 * @param strRDMode
	 *            重定向模式
	 * @param strAppViewId
	 *            应用视图标识
	 */
	protected void registerRDView(String strRDMode, String strAppViewId) {
		rdViewMap.put(strRDMode, strAppViewId);
	}

	/**
	 * 获取用户自定义重定向视图编号
	 * 
	 * @param strRDMode
	 *            重定向模式
	 * @param iDEModel
	 *            实体模型
	 * @param iEntity
	 *            数据对象
	 * @return
	 */
	protected String getRDViewId(String strRDMode, IDataEntityModel iDEModel, IEntity iEntity) throws Exception {
		return getRDViewId(strRDMode);
	}

	/**
	 * 获取用户自定义重定向视图编号
	 * 
	 * @param strRDMode
	 *            重定向模式
	 * @return
	 */
	protected String getRDViewId(String strRDMode) {
		return rdViewMap.get(strRDMode);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.ibizsys.paas.controller.ViewControllerBase#onViewAjaxAction(java.
	 * lang.String)
	 */
	@Override
	protected AjaxActionResult onViewAjaxAction(String strAction) throws Exception {

		if (StringHelper.compare(strAction, VIEWACTION_GETRDVIEW, true) == 0) {
			return onGetRDView();
		}

		if (StringHelper.compare(strAction, VIEWACTION_GETRDVIEWURL, true) == 0) {
			return onGetRDView(true);
		}

		return super.onViewAjaxAction(strAction);
	}

	/**
	 * 获取重定向视图，兼容旧版本写法
	 * 
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onGetRDView() throws Exception {
		return onGetRDView(false);
	}

	/**
	 * 获取重定向视图
	 * 
	 * @param bUrlMode
	 *            是否直接获取Url
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onGetRDView(boolean bUrlMode) throws Exception {
		AjaxActionResult ajaxActionResult = new AjaxActionResult();

		// 获取数据
		String strKeyValue = this.getWebContext().getViewParamValue("srfkey");
		if (StringHelper.isNullOrEmpty(strKeyValue)) {
			strKeyValue = this.getWebContext().getViewParamValue("srfkeys");
		}
		/**
		 * 20190123 增加，支持进一步从Url或Post取值
		 */
		if (StringHelper.isNullOrEmpty(strKeyValue)) {
			strKeyValue = this.getWebContext().getPostOrParamValue("srfkey");
		}

		if (StringHelper.isNullOrEmpty(strKeyValue)) {
			throw new Exception(StringHelper.format("没有指定视图数据主键"));
		}
		rdViewKey.set(null);
		rdViewParam.set(null);
		IAppViewModel iAppViewModel = this.getRDAppViewModel(strKeyValue);
		if (iAppViewModel != null) {
			if (bUrlMode) {
				Map<String, String> paramMap = new HashMap<String, String>();
				paramMap.put(WebContext.PARAM_KEY, strKeyValue);
				String strViewUrl = this.getAppModel().getAppPFHelper().getAppViewUrl(iAppViewModel, paramMap);
				String strAppUrl = ((IApplicationRuntime)this.getAppModel()).getApplicationUrl();
				if(!StringHelper.isNullOrEmpty(strAppUrl)) {
					strViewUrl  = strAppUrl + strViewUrl;
				}
				ajaxActionResult.setGotoPath(strViewUrl);
			} else {
				JSONObject rdview = this.getAppModel().getAppPFHelper().getAppViewJSONObject(iAppViewModel);
				strKeyValue = rdViewKey.get();
				if (strKeyValue != null) {
					rdview.put(IFormItem.KEY, JSONObjectHelper.stripQuotes(strKeyValue));
				}
				JSONObject viewParam = rdViewParam.get();
				if (viewParam != null) {
					rdview.put("viewparam", viewParam);
				}
				ajaxActionResult.setExtAttr("rdview", rdview);
			}
			return ajaxActionResult;
		} else {
			ajaxActionResult.setRetCode(Errors.INPUTERROR);
			ajaxActionResult.setErrorInfo("无法找到对应的跳转视图");
			return ajaxActionResult;
		}
	}


	/**
	 * 获取指定数据的重定向页面模型
	 * 
	 * @param strKeyValue
	 *            数据主键
	 * @return
	 * @throws Exception
	 */
	public IAppViewModel getRDAppViewModel(String strKeyValue) throws Exception {
		// 进行数据查询
		IEntity iEntity = getActiveEntity(strKeyValue);
		// 判断当前数据模式
		IDataEntityModel iRealDEModel = this.getRealDEModel(iEntity);
		if (iRealDEModel != this.getRealDEModel()) {
			// 实体不一致
			iEntity = getActiveEntity(iRealDEModel, strKeyValue);
		}
		boolean bDataInWF = false;
		boolean bWFMode = false;
		// 计算数据模式
		if (this.isEnableWorkflow()) {
			IDEWFModel iDEWF = iRealDEModel.testDataInWF(iEntity);
			if (iDEWF != null) {
				bDataInWF = true;
				bWFMode = iDEWF.testUserWFSubmit(iEntity, this.getWebContext().getCurUserId(), this.getSessionFactory());
			}
		}

		String strPDTViewParam = getDESDDEViewPDTParam(iRealDEModel, iEntity, bDataInWF, bWFMode);
		/**
		 * 重新写回数据主键
		 */
		Object objNewKey = iEntity.get(IFormItem.KEY);
		if (!StringHelper.isNullOrEmpty(objNewKey)) {
			rdViewKey.set(DataObject.getStringValue(objNewKey));
		}

		String strRDMode = strPDTViewParam;
		if (iRealDEModel != this.getRealDEModel()) {
			strRDMode = iRealDEModel.getName() + ":" + strPDTViewParam;
		}

		IAppViewModel iAppViewModel = null;
		String strRDViewId = this.getRDViewId(strRDMode, iRealDEModel, iEntity);
		if (StringHelper.isNullOrEmpty(strRDViewId)) {
			String strDEViewId = iRealDEModel.getDEViewIdByPDT(strPDTViewParam, false);
			iAppViewModel = this.getAppModel().getAppViewByDEViewId(strDEViewId, false);
		} else {
			iAppViewModel = this.getAppModel().getAppView(strRDViewId, false);
		}
		return iAppViewModel;
	}

	/**
	 * 获取实体单数据实体视图预定义参数
	 * 
	 * @param iDEModel
	 *            实体模型
	 * @param et
	 * @param bEnableWF
	 *            是否支持工作流
	 * @param bWFWorkMode
	 *            是否为工作模式
	 * @return
	 * @throws Exception
	 */
	protected String getDESDDEViewPDTParam(IDataEntityModel iDEModel, IEntity iEntity, boolean bDataInWF, boolean bWFWorkMode) throws Exception {
		return iDEModel.getSDDEViewPDTParam(iEntity, bDataInWF, bWFWorkMode, this.getAppModel().getAppType());
	}

	/**
	 * 获取实际的数据模型
	 * 
	 * @param iEntity
	 *            实体
	 * @return
	 * @throws Exception
	 */
	protected IDataEntityModel getRealDEModel(IEntity iEntity) throws Exception {
		IDataEntityModel curDEModel = this.getRealDEModel();
		if (StringHelper.isNullOrEmpty(curDEModel.getIndexDEType()))
			return curDEModel;

		Object objKeyValue = iEntity.get(this.getRealDEModel().getKeyDEField().getName());
		while (true) {
			// 判断类型
			String strIndexType = DataObject.getStringValue(iEntity, curDEModel.getIndexTypeDEField().getName(), null);
			if (StringHelper.isNullOrEmpty(strIndexType)) {
				throw new Exception(StringHelper.format("当前数据未提供索引类型值"));
			}

			IDERIndex iDERIndex = curDEModel.getDERIndex(true, strIndexType);
			curDEModel = this.getSystemModel().getDataEntityModel(iDERIndex.getMinorDEId());

			if (StringHelper.isNullOrEmpty(curDEModel.getIndexDEType()))
				return curDEModel;

			iEntity = getActiveEntity(curDEModel, objKeyValue);
		}
	}

	/**
	 * 获取当前数据对象
	 * 
	 * @param strKeyValue
	 *            数据主键
	 * @return
	 * @throws Exception
	 */
	protected IEntity getActiveEntity(Object strKeyValue) throws Exception {
		IService iService = getRealService();
		IEntity iEntity = iService.getDEModel().createEntity();
		iEntity.set(iService.getDEModel().getKeyDEField().getName(), strKeyValue);
		iService.get(iEntity);
		return iEntity;
	}

	/**
	 * 获取当前数据对象
	 * 
	 * @param iRealDEModel
	 *            实际实体模型对象
	 * @param strKeyValue
	 *            数据主键
	 * @return
	 * @throws Exception
	 */
	protected IEntity getActiveEntity(IDataEntityModel iRealDEModel, Object strKeyValue) throws Exception {
		IEntity iEntity = iRealDEModel.createEntity();
		iEntity.set(iRealDEModel.getKeyDEField().getName(), strKeyValue);
		IService iService = iRealDEModel.getService(this.getSessionFactory());

		if (!iService.autoGet(iEntity, true)) {
			throw new Exception(StringHelper.format("无法获取传入数据"));
		}

		return iEntity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.ibizsys.paas.controller.IRedirectViewController#isEnableWorkflow()
	 */
	@Override
	public boolean isEnableWorkflow() {
		return bEnableWorkflow;
	}

	/**
	 * 设置是否支持工作流
	 * 
	 * @param bEnableWorkflow
	 */
	protected void setEnableWorkflow(boolean bEnableWorkflow) {
		this.bEnableWorkflow = bEnableWorkflow;
	}
	
	
	/**
	 * 获取实际服务对象
	 * @return
	 */
	public IService getRealService() {
		return this.getService();
	}
	
	
	/**
	 * 获取实体实体模型对象
	 * @return
	 */
	public IDataEntityModel getRealDEModel() {
		return this.getDEModel();
	}

}
