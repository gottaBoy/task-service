package net.ibizsys.paas.core;

import net.ibizsys.paas.util.IGlobalContext;

/**
 * 实体行为调用器接口
 * 
 * @author Administrator
 *
 */

public interface IDEActionCaller {
	/**
	 * 初始化
	 * 
	 * @param iGlobalContext
	 * @param iDEAction
	 * @throws Exception
	 */
	void init(IGlobalContext iGlobalContext, IDEAction iDEAction) throws Exception;

	/**
	 * 执行操作
	 * 
	 * @param iDEActionContext
	 * @throws Exception
	 */
	void execute(IDEActionCallContext iDEActionContext) throws Exception;

	/**
	 * 关闭
	 */
	void close();

	/**
	 * 获取调用器上下文对象
	 * 
	 * @return
	 */
	IDEActionCallContext getDEActionCallContext();
}
