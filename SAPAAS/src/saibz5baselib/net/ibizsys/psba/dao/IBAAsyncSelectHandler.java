package net.ibizsys.psba.dao;

import net.ibizsys.paas.core.IAsyncHandler;
import net.ibizsys.psba.entity.IBAEntity;

/**
 * 大数据查询异步处理对象
 * @author Administrator
 *
 */
public interface IBAAsyncSelectHandler extends IAsyncHandler {

	/**
	 * 处理接收到的数据
	 * @param iBAEntity
	 */
	void processBAEntity(IBAEntity iBAEntity);
}
