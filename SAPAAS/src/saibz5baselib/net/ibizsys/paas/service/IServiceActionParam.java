package net.ibizsys.paas.service;

import net.ibizsys.paas.entity.IEntity;

/**
 * 服务行为参数
 * @author Administrator
 *
 * @param <ET>
 */
public interface IServiceActionParam<ET extends IEntity> { 

	/**
	 * 获取行为标识
	 * @return
	 */
	String getAction();
	
	/**
	 * 获取数据对象
	 * @return
	 */
	ET getEntity();
	
	
	/**
	 * 执行之前触发
	 * @param et
	 * @throws Exception
	 */
	void doBeforeAction(ET et) throws Exception;
	
	
	
	/**
	 * 执行之后触发
	 * @param et
	 * @throws Exception
	 */
	void doAfterAction(ET et) throws Exception;
	
	
	
	boolean testAction(ET et)throws Exception;
	 
}
