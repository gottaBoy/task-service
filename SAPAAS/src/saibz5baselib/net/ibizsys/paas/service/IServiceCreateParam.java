package net.ibizsys.paas.service;

import net.ibizsys.paas.entity.IEntity;

/**
 * 服务建立操作参数
 * @author Administrator
 *
 * @param <ET>
 */
public interface IServiceCreateParam<ET extends IEntity> extends IServiceActionParam<ET> {

	/**
	 * 获取是否返回数据
	 * @return
	 */
	boolean isReturnData();
	
}
