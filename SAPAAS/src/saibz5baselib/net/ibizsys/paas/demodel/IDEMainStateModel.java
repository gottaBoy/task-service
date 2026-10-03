package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDEMainState;
import net.ibizsys.paas.core.IModelBase3;

/**
 * 实体主状态模型接口
 * 
 * @author Administrator
 *
 */
public interface IDEMainStateModel extends IDEMainState,IModelBase3 {
	
	/**
	 * 注册实体行为
	 * 
	 * @param strDEAction
	 */
	void registerDEAction(String strDEAction);
	
	
	
	
	/**
	 * 注册实体操作标识
	 * 
	 * @param strDEAction
	 */
	void registerDEOPPriv(String strDEOPPriv);
}
