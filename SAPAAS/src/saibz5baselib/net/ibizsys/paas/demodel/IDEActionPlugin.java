package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IActionContext;

/**
 * 实体逻辑插件接口
 * 
 * @author lionlau
 *
 */
public interface IDEActionPlugin  {
	

	/**
	 * 执行操作
	 * 
	 * @param iActionContext
	 * @throws Exception
	 */
	void execute(IActionContext iActionContext) throws Exception;
}
