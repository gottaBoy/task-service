package net.ibizsys.ssdyna.web;

import net.ibizsys.saas.web.ISaaSWebContext;
import net.ibizsys.ssdyna.sysmodel.IDynaSysModel;

/**
 * 动态系统Web请求上下文
 * @author Administrator
 *
 */
public interface IDynaWebContext extends ISaaSWebContext {

	/**
	 * 获取动态系统模型对象
	 * @param bTryMode 尝试模式
	 * @return
	 * @throws Exception
	 */
	IDynaSysModel getDynaSysModel(boolean bTryMode)throws Exception;
	
}
