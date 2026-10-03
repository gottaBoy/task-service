package net.ibizsys.paas.service;

import net.ibizsys.paas.entity.IEntity;

/**
 * 服务更新操作参数
 * @author Administrator
 *
 * @param <ET>
 */
public interface IServiceUpdateParam<ET extends IEntity> extends IServiceActionParam<ET> {

	
	/**
	 * 获取是否返回数据
	 * @return
	 */
	boolean isReturnData();
	
	/**
	 * 是否需要准备上一次的数据
	 * @return
	 */
	boolean isPrepareLast();
	
	
	
	/**
	 * 是否为系统更新操作（没有更新人及更新时间）
	 * @return
	 */
	boolean isSysUpdate();
}
