package net.ibizsys.model.control.counter;

import net.ibizsys.model.core.IPSModelObject;


/**
 * 系统计数器项对象接口
 * @author Administrator
 *
 */
public interface IPSSysCounterItem extends IPSModelObject {

	
		
	
	
	/**
	 * 获取逻辑名称
	 * @return
	 */
	String getLogicName();
	
	
	
	
	/**
	 * 获取系统计数器
	 * @return
	 */
	IPSSysCounter getPSSysCounter();
}
