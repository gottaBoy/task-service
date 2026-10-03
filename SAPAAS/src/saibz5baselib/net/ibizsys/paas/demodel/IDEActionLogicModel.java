package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IModelBase3;

/**
 * 实体附加逻辑对象接口
 * 
 * @author Administrator
 *
 */
public interface IDEActionLogicModel extends IModelBase3{
	/**
	 * 获取实体名称
	 * 
	 * @return
	 */
	String getDEName();

	/**
	 * 获取实体行为名称
	 * 
	 * @return
	 */
	String getDEActionName();
	
	
	/**
	 * 获取是否克隆传入参数
	 * @return
	 */
	boolean isCloneParam();
	
	
	
	/**
	 * 获取是否忽略处理异常
	 * @return
	 */
	boolean isIgnoreException();
}
