package net.ibizsys.paas.api;

import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.service.IService;

/**
 * 实体 Rest 控制器接口对象 接口
 * @author Administrator
 *
 */
public interface IDERestController extends IRestController {
	
	/**
	 * 获取服务对象
	 * 
	 * @return
	 */
	IService getService();
	
	
	/**
	 * 获取实体模型
	 * 
	 * @return
	 */
	IDataEntityModel getDEModel();
}
