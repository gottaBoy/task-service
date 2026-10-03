package net.ibizsys.paas.core;


/**
 * 异步处理对象
 * @author Administrator
 *
 */
public interface IAsyncHandler {
	
	/**
	 * 查询出现异常触发
	 * @param baException
	 */
	void exception(Exception exception );
}
