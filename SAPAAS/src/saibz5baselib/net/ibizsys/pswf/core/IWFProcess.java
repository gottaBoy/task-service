package net.ibizsys.pswf.core;

/**
 * 流程处理接口对象
 * @author lionlau
 *
 */
public interface IWFProcess
{
	/**
	 * 初始化
	 * @param iWFProcessModel
	 * @throws Exception
	 */
	void init(IWFProcessModel iWFProcessModel)throws Exception;
	
	/**
	 * 执行处理
	 * @param iWFActionContext
	 * @return
	 * @throws Exception
	 */
	void execute(IWFActionContext iWFActionContext)throws Exception;
	
	
	/**
	 * 执行处理之前触发
	 * @param iWFActionContext
	 * @return
	 * @throws Exception
	 */
	void executeBefore(IWFActionContext iWFActionContext)throws Exception;
	
	
	
	/**
	 * 执行处理之后触发
	 * @param iWFActionContext
	 * @return
	 * @throws Exception
	 */
	void executeAfter(IWFActionContext iWFActionContext)throws Exception;
	
}
