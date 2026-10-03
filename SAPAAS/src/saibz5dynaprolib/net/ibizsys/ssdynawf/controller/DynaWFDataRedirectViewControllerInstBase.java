package net.ibizsys.ssdynawf.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.ssdyna.controller.DynaRedirectViewControllerInstBase;

/**
 * 动态实体流程数据重定向视图控制器实例基类
 * @author Administrator
 *
 */
public abstract class DynaWFDataRedirectViewControllerInstBase extends DynaRedirectViewControllerInstBase {

	private ThreadLocal<IDataEntityModel> curDEModel = new ThreadLocal<IDataEntityModel>();
	private static final Log log = LogFactory.getLog(DynaWFDataRedirectViewControllerInstBase.class);
	
	public DynaWFDataRedirectViewControllerInstBase() throws Exception {
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
	
	@Override
	public IDataEntityModel getDEModel() {
		return getRealDEModel();
	}



	@Override
	public IService getService() {
		return getRealService();
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
}
