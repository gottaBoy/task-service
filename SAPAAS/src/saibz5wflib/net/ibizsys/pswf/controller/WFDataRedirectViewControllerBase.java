package net.ibizsys.pswf.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.controller.RedirectViewControllerBase;
import net.ibizsys.paas.core.IDERIndex;
import net.ibizsys.paas.core.IDEWF;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.IWFVersionModel;

/**
 * 流程实体数据重定向视图控制器基类
 * @author Administrator
 *
 */
public abstract class WFDataRedirectViewControllerBase  extends RedirectViewControllerBase implements IWFDEViewController{

	private static final Log log = LogFactory.getLog(WFDataRedirectViewControllerBase.class);
	
	/**
	 * 工作流模型
	 */
	private IWFModel iWFModel = null;

	/**
	 * 实体工作流模型
	 */
	private IDEWF iDEWF = null;

	/**
	 * 是否为工作模式
	 */
	private boolean bWFIAMode = false;

	/**
	 * 交互的流程步骤值
	 */
	private String strWFStepValue = "";

	/**
	 * 流程版本
	 */
	private int nWFVersion = -1;

	
	private ThreadLocal<IDataEntityModel> curDEModel = new ThreadLocal<IDataEntityModel>();
	
	
	public WFDataRedirectViewControllerBase() throws Exception {
		super();
		this.setEnableWorkflow(true);
	}

	@Override
	protected AjaxActionResult onGetRDView(boolean bUrlMode) throws Exception {
	
		String strDEId = this.getWebContext().getViewParamValue("srfdeid");
		
		/**
		 * 20190123 增加，支持进一步从Url或Post取值
		 */
		if (StringHelper.isNullOrEmpty(strDEId)) {
			strDEId = this.getWebContext().getPostOrParamValue("srfdeid");
		}
		
		if (StringHelper.isNullOrEmpty(strDEId)) {
			throw new Exception(StringHelper.format("没有指定数据实体"));
		}
		
		curDEModel.set(this.getSystemModel().getDataEntityModel(strDEId));
		return super.onGetRDView(bUrlMode);
	}
	
	
	/**
	 * 获取实际的实体模型（从上下文传入），getDEModel 方法可能会被子类覆盖
	 * @return
	 */
	public IDataEntityModel getRealDEModel() {
		return curDEModel.get();
	}
	
	/**
	 * 获取实际的实体服务对象
	 * @return
	 */
	public IService getRealService() {
		try {
			return getRealDEModel().getService(this.getSessionFactory());
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			return null;
		}
	}
	
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.pswf.controller.IWFViewController#getWFModel()
	 */
	public IWFModel getWFModel() {
		return iWFModel;
	}

	/**
	 * 设置流程模型
	 * 
	 * @param iWFModel
	 */
	protected void setWFModel(IWFModel iWFModel) {
		this.iWFModel = iWFModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.pswf.controller.IWFViewController#getWFVersionModel()
	 */
	@Override
	public IWFVersionModel getWFVersionModel() {
		return this.getWFModel().getLastWFVersionModel();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.pswf.controller.IWFViewController#isWFIAMode()
	 */
	@Override
	public boolean isWFIAMode() {
		return this.bWFIAMode;
	}

	/**
	 * 设置是否为流程交互模式
	 * 
	 * @param bWFIAMode
	 */
	protected void setWFIAMode(boolean bWFIAMode) {
		this.bWFIAMode = bWFIAMode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.pswf.controller.IWFDEViewController#getDEWF()
	 */
	@Override
	public IDEWF getDEWF() {
		return this.iDEWF;
	}

	/**
	 * 设置流程实体对象
	 * 
	 * @param iDEWF
	 */
	protected void setDEWF(IDEWF iDEWF) {
		this.iDEWF = iDEWF;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.pswf.controller.IWFViewController#getWFStepValue()
	 */
	@Override
	public String getWFStepValue() {
		return this.strWFStepValue;
	}

	/**
	 * 设置当前的流程步骤值
	 * 
	 * @param strWFStepValue
	 */
	public void setWFStepValue(String strWFStepValue) {
		this.strWFStepValue = strWFStepValue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.pswf.controller.IWFViewController#getWFVersion()
	 */
	@Override
	public int getWFVersion() {
		return this.nWFVersion;
	}

	/**
	 * 设置流程版本
	 * 
	 * @param nWFVersion
	 */
	public void setWFVersion(int nWFVersion) {
		this.nWFVersion = nWFVersion;
	}
	
	
	/**
	 * 获取实际的数据模型
	 * 
	 * @param iEntity 实体
	 * @return
	 * @throws Exception
	 */
	protected IDataEntityModel getRealDEModel(IEntity iEntity) throws Exception {
		IDataEntityModel curDEModel = this.getRealDEModel();
		if (StringHelper.isNullOrEmpty(curDEModel.getIndexDEType())) {
			return curDEModel;
		}

		Object objKeyValue = iEntity.get(curDEModel.getKeyDEField().getName());
		while (true) {
			// 判断类型
			String strIndexType = DataObject.getStringValue(iEntity, curDEModel.getIndexTypeDEField().getName(), null);
			if (StringHelper.isNullOrEmpty(strIndexType)) {
				throw new Exception(StringHelper.format("当前数据未提供索引类型值"));
			}

			IDERIndex iDERIndex = curDEModel.getDERIndex(true, strIndexType);
			curDEModel = this.getSystemModel().getDataEntityModel(iDERIndex.getMinorDEId());
			if (StringHelper.isNullOrEmpty(curDEModel.getIndexDEType())) {
				return curDEModel;
			}

			iEntity = getActiveEntity(curDEModel, objKeyValue);
		}
	}
}
