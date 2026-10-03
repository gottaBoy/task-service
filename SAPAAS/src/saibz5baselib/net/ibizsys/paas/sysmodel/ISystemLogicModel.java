package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.core.ISystemLogic;

/**
 * 系统逻辑模型对象接口
 * @author Administrator
 *
 */
public interface ISystemLogicModel extends ISystemLogic  {

	/**
	 * 初始化
	 * @param iSystemModel
	 * @throws Exception
	 */
	void init(ISystemModel iSystemModel)throws Exception;
	
	
	
	/**
	 * 获取系统模型对象
	 * @return
	 */
	ISystemModel getSystemModel();
	
	
	/**
	 * 获取唯一业务标识
	 * @return
	 */
	String getUniqueTag();
	
	
	/**
	 * 执行操作
	 * @param iActionContext
	 * @param objParam
	 * @throws Exception
	 */
	void execute(IActionContext iActionContext,Object objParam) throws Exception;
}
