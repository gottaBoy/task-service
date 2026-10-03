package net.ibizsys.paas.api;

import net.ibizsys.paas.core.IModelBase2;

/**
 * 系统服务接口对象
 * @author Administrator
 *
 */
public interface IServiceAPI extends IModelBase2 {

	/**
	 * 接口类型：RESTful API
	 */
	public final static String APITYPE_RESTFUL = "RESTFUL";

	/**
	 * 接口类型：RESTful WebService
	 */
	public final static String APITYPE_JAXRS = "JAXRS";

	/**
	 * 接口类型：WebService
	 */
	public final static String APITYPE_WEBSERVICE = "WEBSERVICE";
	
	
	/**
	 * 获取API类型，值参考 net.ibizsys.paas.api.IServiceAPI.APITYPE_XXX 定义
	 * @return
	 */
	String getAPIType();
}
