package net.ibizsys.paas.service;

import net.ibizsys.paas.entity.IEntity;

/**
 * 继承实体服务代理接口
 * 
 * @author Administrator
 *
 */
public interface IInheritDEServiceProxy<ET extends IEntity> extends IService<ET> {
	/**
	 * 获取实际继承实体数据对象
	 * 
	 */
	ET getReal(ET entity, boolean bTryMode) throws Exception;

	/**
	 * 获取实际实体服务对象
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	IService getRealService(ET entity) throws Exception;
}
