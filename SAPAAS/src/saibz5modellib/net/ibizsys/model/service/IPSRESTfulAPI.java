package net.ibizsys.model.service;

/**
 * REST风格的服务接口
 * @author Administrator
 *
 */
public interface IPSRESTfulAPI {
	
	/**
	 * 获取请求路径
	 * @return
	 */
	String getRequestPath();
	
	
	
	
	/**
	 * 获取请求方式
	 * @return
	 */
	String getRequestMethod();
	
}
