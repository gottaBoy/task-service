package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.core.IModelBase3;

/**
 * 动态系统实例对象模型接口
 * @author Administrator
 *
 */
public interface IDynaInst extends IModelBase3 {

	
	/**
	 * 初始化
	 * @param iSystemModel 系统模型对象
	 * @param strDynaSystemInstId 动态系统实例标识
	 * @throws Exception
	 */
	void init(ISystemModel iSystemModel,String strDynaSystemInstId) throws Exception;
	
	/**
	 * 获取系统模型对象
	 * @return
	 */
	ISystemModel getSystemModel();
	
	/**
	 * 获取动态系统设置模型对象接口
	 * @return
	 */
	IDynaSystemSetting getDynaSystemSetting();
	
	/**
	 * 获取父动态系统实例模型对象
	 * @return
	 */
	IDynaInst getParentDynaInst();
}
