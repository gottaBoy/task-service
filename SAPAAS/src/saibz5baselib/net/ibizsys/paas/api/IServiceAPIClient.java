package net.ibizsys.paas.api;

import net.ibizsys.paas.core.IModelBase2;

/**
 * 系统服务接口客户端接口对象
 * @author Administrator
 *
 */
public interface IServiceAPIClient extends IModelBase2 {

	/**
	 * 获取服务路径
	 * @return
	 */
	String getServicePath();

	
	
}
