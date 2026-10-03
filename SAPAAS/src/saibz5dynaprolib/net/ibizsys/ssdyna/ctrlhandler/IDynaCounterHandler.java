package net.ibizsys.ssdyna.ctrlhandler;

import net.ibizsys.model.control.counter.IPSSysCounter;
import net.ibizsys.paas.ctrlhandler.ICounterHandler;
import net.ibizsys.ssdyna.sysmodel.IDynaSysModel;

/**
 * JIT 计算器后台处理接口
 * @author Administrator
 *
 */
public interface IDynaCounterHandler extends ICounterHandler {
	
	/**
	 * 初始化计数器处理
	 * @param iDynaSystemModel
	 * @param iPSSysCounter
	 * @throws Exception
	 */
	void init(IDynaSysModel iDynaSysModel , IPSSysCounter iPSSysCounter) throws Exception;
}
