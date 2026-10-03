package net.ibizsys.paas.api;

import net.ibizsys.paas.web.util.SimpleWebContext;

/**
 * RESTful 调用Web请求上下文对象
 * @author Administrator
 *
 */
public class RestCallContext extends SimpleWebContext implements IRestCallContext {

	private RestCallResult restCallResult = null;

	@Override
	public RestCallResult getRestCallResult() {
		return this.restCallResult;
	}
	
	
	/**
	 * 设置Rest调用结果
	 * @param restCallResult
	 */
	public void setRestCallResult(RestCallResult restCallResult){
		this.restCallResult = restCallResult;
	}
	
	
}
