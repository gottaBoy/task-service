package net.ibizsys.pswf.core;

import net.ibizsys.paas.service.ITransaction;

/**
 * 流程服务事物处理作业
 * @author lionlau
 *
 */
public interface IWFServiceWork
{
	/**
	 * 执行作业
	 * @param iTransaction
	 * @throws Exception
	 */
	WFActionResult execute( ITransaction iTransaction) throws Exception;
}
