package net.ibizsys.paas.service;

import net.ibizsys.paas.entity.IEntity;

/**
 * 服务删除操作参数
 * @author Administrator
 *
 * @param <ET>
 */
public interface IServiceRemoveParam<ET extends IEntity> extends IServiceActionParam<ET> {

	/**
	 * 是否需要准备上一次的数据
	 * @return
	 */
	boolean isPrepareLast();
}
