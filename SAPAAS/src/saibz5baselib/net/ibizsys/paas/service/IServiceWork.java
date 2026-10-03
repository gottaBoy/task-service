package net.ibizsys.paas.service;

/**
 * 服务作业接口
 * 
 * @author lionlau
 *
 */
public interface IServiceWork {
	/**
	 * 执行作业
	 * 
	 * @param iTransaction
	 * @throws Exception
	 */
	void execute(ITransaction iTransaction) throws Exception;
}
