package net.ibizsys.paas.demodel;

import net.ibizsys.paas.cache.IUniStateModel;
import net.ibizsys.paas.core.IDEUniState;
import net.ibizsys.paas.core.IModelBase3;

/**
 * 实体统一状态模型
 * @author Administrator
 *
 */
public interface IDEUniStateModel extends IDEUniState,IModelBase3 {

	
	/**
	 * 获取系统统一状态模型对象
	 * @return
	 * @throws Exception
	 */
	IUniStateModel getUniStateModel() throws Exception;
	
}
