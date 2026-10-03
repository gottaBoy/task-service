package net.ibizsys.pswf.web.util;

import net.ibizsys.paas.appmodel.IAppViewModel;
import net.ibizsys.paas.core.IDERIndex;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDEWFModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.WebUtility;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.Page;
import net.sf.json.JSONObject;

/**
 * 工作流重定向页面
 * 
 * @author Administrator
 *
 */
public class WFRedirectPage extends Page {
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.Page#onInit()
	 */
	@Override
	protected void onInit() throws Exception {
		super.onInit();

		String strDEId = getDEId();
		String strKeyValue = getKeyValue();
		

		IAppViewModel iAppViewModel = this.getRDAppViewModel(strDEId, strKeyValue);
		sendBackAppViewModel(iAppViewModel);
	}
	
	
	/**
	 * 获取视图当前的实体标识
	 * @return
	 * @throws Exception
	 */
	protected String getDEId()throws Exception{
		String strDEId = this.getWebContext().getPostOrParamValue("srfdeid");
		if (StringHelper.isNullOrEmpty(strDEId)) {
			throw new Exception(StringHelper.format("没有指定视图实体标识"));
		}
		return strDEId;
	}
	
	
	/**
	 * 获取视图当前的数据标识
	 * @return
	 * @throws Exception
	 */
	protected String getKeyValue()throws Exception{
		String strKeyValue = this.getWebContext().getPostOrParamValue("srfkey");
		if (StringHelper.isNullOrEmpty(strKeyValue)) {
			strKeyValue = this.getWebContext().getPostOrParamValue("srfkeys");
		}
		if (StringHelper.isNullOrEmpty(strKeyValue)) {
			throw new Exception(StringHelper.format("没有指定视图数据主键"));
		}
		return strKeyValue;
	}

	/**
	 * 回送应用视图模型
	 * 
	 * @param iAppViewModel
	 * @throws Exception
	 */
	protected void sendBackAppViewModel(IAppViewModel iAppViewModel) throws Exception {
		JSONObject rdview = this.getApplicationModel().getAppPFHelper().getAppViewJSONObject(iAppViewModel);
		if (StringHelper.compare(this.getRequest().getMethod(), "POST", true) == 0) {
			AjaxActionResult ajaxActionResult = new AjaxActionResult();
			ajaxActionResult.setExtAttr("rdview", rdview);
			this.getWriter().write(ajaxActionResult.toJSONString());
			return;
		}

		String strViewUrl = rdview.optString("viewurl");
		if (strViewUrl.charAt(0) == '/') {
			strViewUrl = ".." + strViewUrl;
		}

		strViewUrl = WebUtility.appendURLSeperator(strViewUrl);
		strViewUrl += this.getWebContext().getQueryString();
		this.getResponse().sendRedirect(strViewUrl);
		return;
	}

	/**
	 * 获取指定数据的重定向页面模型
	 * 
	 * @param strDEName
	 * @param strKeyValue
	 * @return
	 * @throws Exception
	 */
	public IAppViewModel getRDAppViewModel(String strDEName, String strKeyValue) throws Exception {
		IDataEntityModel iDEModel = DEModelGlobal.getDEModel(strDEName);
		// 进行数据查询
		IEntity iEntity = getActiveEntity(iDEModel, strKeyValue);
		// 判断当前数据模式
		IDataEntityModel iRealDEModel = this.getRealDEModel(iDEModel, iEntity);
		if (iRealDEModel != iDEModel) {
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

		String strPDTViewParam = iRealDEModel.getSDDEViewPDTParam(iEntity, bDataInWF, bWFMode);
		String strRDMode = strPDTViewParam;
		if (iRealDEModel != this.getDEModel()) {
			strRDMode = iRealDEModel.getName() + ":" + strPDTViewParam;
		}

		IAppViewModel iAppViewModel = null;

		String strDEViewId = iRealDEModel.getDEViewIdByPDT(strPDTViewParam, false);
		iAppViewModel = this.getApplicationModel().getAppViewByDEViewId(strDEViewId, false);

		// String strRDViewId = this.getRDViewId(strRDMode);
		// if (StringHelper.isNullOrEmpty(strRDViewId))
		// {
		// String strDEViewId = iRealDEModel.getDEViewIdByPDT(strPDTViewParam, false);
		// iAppViewModel = this.getApplicationModel().getAppViewByDEViewId(strDEViewId, false);
		// }
		// else
		// {
		// iAppViewModel = this.getAppModel().getAppView(strRDViewId, false);
		// }
		return iAppViewModel;
	}

	/**
	 * 获取实际的数据模型
	 * 
	 * @param iDEModel
	 * @param iEntity
	 * @return
	 * @throws Exception
	 */
	protected IDataEntityModel getRealDEModel(IDataEntityModel iDEModel, IEntity iEntity) throws Exception {
		IDataEntityModel curDEModel = iDEModel;
		if (StringHelper.isNullOrEmpty(curDEModel.getIndexDEType())) return curDEModel;

		Object objKeyValue = iEntity.get(iDEModel.getKeyDEField().getName());
		while (true) {
			// 判断类型
			String strIndexType = DataObject.getStringValue(iEntity, curDEModel.getIndexTypeDEField().getName(), null);
			if (StringHelper.isNullOrEmpty(strIndexType)) {
				throw new Exception(StringHelper.format("当前数据未提供索引类型值"));
			}

			IDERIndex iDERIndex = curDEModel.getDERIndex(true, strIndexType);
			curDEModel = DEModelGlobal.getDEModel(iDERIndex.getMinorDEId());

			if (StringHelper.isNullOrEmpty(curDEModel.getIndexDEType())) return curDEModel;

			iEntity = getActiveEntity(curDEModel, objKeyValue);
		}
	}

	/**
	 * 获取当前数据实体
	 * 
	 * @param iRealDEModel
	 * @param strKeyValue
	 * @return
	 * @throws Exception
	 */
	protected IEntity getActiveEntity(IDataEntityModel iRealDEModel, Object strKeyValue) throws Exception {
		IEntity iEntity = iRealDEModel.createEntity();
		iEntity.set(iRealDEModel.getKeyDEField().getName(), strKeyValue);
		iRealDEModel.getService(this.getSessionFactory()).get(iEntity);
		return iEntity;
	}

	/**
	 * 是否启动工作流
	 * 
	 * @return
	 */
	protected boolean isEnableWorkflow() {
		return true;
	}

}
