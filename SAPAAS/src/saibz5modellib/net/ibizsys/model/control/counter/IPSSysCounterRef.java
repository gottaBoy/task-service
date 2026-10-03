package net.ibizsys.model.control.counter;

import com.fasterxml.jackson.databind.node.ObjectNode;

import net.ibizsys.model.core.IPSModelObject;


/**
 * 系统计数器引用
 * 
 * @author Administrator
 *
 */
public interface IPSSysCounterRef extends IPSModelObject {
	

	/**
	 * 获取系统计数器
	 * 
	 * @return
	 */
	IPSSysCounter getPSSysCounter();

	/**
	 * 获取引用模式
	 * 
	 * @return
	 */
	ObjectNode getRefMode();

	/**
	 * 获取标记值
	 * 
	 * @return
	 */
	String getTag();
}
