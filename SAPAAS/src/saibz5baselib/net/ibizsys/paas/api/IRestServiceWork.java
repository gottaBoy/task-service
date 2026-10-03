package net.ibizsys.paas.api;


/**
 * Rest 服务作业对象接口
 * @author Administrator
 *
 */
public interface IRestServiceWork {

	/**
	 * 执行服务作业
	 * @param restCallResult
	 */
	void execute(RestCallResult restCallResult) throws Exception;
}
