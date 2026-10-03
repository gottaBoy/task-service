package net.ibizsys.paas.api;

import net.ibizsys.paas.web.IWebContext;

/**
 * Rest 调用上下文对象
 * @author Administrator
 *
 */
public interface IRestCallContext extends IWebContext,IServiceWebContext {

	/**
	 * 获取Rest调用结果对象
	 * @return
	 */
	RestCallResult getRestCallResult();
}
