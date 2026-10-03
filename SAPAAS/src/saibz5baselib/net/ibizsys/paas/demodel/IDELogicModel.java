package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.core.IDELogic;
import net.ibizsys.paas.core.IModelBase3;

/**
 * 实体逻辑接口
 * 
 * @author lionlau
 *
 */
public interface IDELogicModel<ET> extends IDELogic,IModelBase3 {

	/**
	 * 环境变量参数：检查主键状态
	 */
	public final String ENVPARAMKEYSTATE = "SRFKEYSTATE";
	
	

	/**
	 * 执行操作
	 * 
	 * @param iActionContext
	 * @throws Exception
	 */
	void execute(IActionContext iActionContext) throws Exception;
}
