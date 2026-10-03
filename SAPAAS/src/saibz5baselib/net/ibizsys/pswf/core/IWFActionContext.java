package net.ibizsys.pswf.core;

import net.ibizsys.paas.entity.IEntity;

/**
 * 流程操作上下文对象接口
 * @author lionlau
 *
 */
public interface IWFActionContext
{
	/**
	 * 获取操作参数
	 * @return
	 */
	WFActionParam getWFActionParam();
	
	
	
	/**
	 * 获取操作用户标识
	 * @return
	 */
	String getOpPersonId(); 
	
	
	
	/**
	 * 获取当前的数据对象
	 * @return
	 */
	IEntity getActiveEntity();
	
	
	/**
	 * 获取流程模型
	 * @return
	 */
	IWFModel getWFModel();
	
	/**
	 * 获取当前的流程版本对象
	 * @return
	 */
	IWFVersionModel getWFVersionModel();
	
	
	/**
	 * 当前是否处于线程模式
	 * @return the bThreadMode
	 */
	boolean isThreadMode();

	/**
	 * 获取指定属性
	 * @param strName
	 * @return
	 */
	Object getAttribute(String strName);
	
	/**
	 * 设置指定属性
	 * @param strName
	 * @param objValue
	 */
	void setAttribute(String strName, Object objValue);
	
	
	/**
	 * 获取当前的流程实例标识
	 * @return
	 */
	String getActiveWFInstanceId();
	
	
	/**
	 * 设置下一步处理标识
	 * @param strCurNext
	 */
	void setCurNext(String strCurNext);
	

	
}
