package net.ibizsys.ssdyna.service;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.saas.service.ISaaSService;
import net.ibizsys.ssdyna.demodel.IDynaDEModel;

/**
 * 动态实体服务对象接口
 * @author Administrator
 *
 * @param <ET>
 */
public interface IDynaService<ET extends IEntity> extends ISaaSService<ET> {

	/**
	 * 初始化
	 * @param iDynaDEModel
	 * @throws Exception
	 */
	void init(IDynaDEModel<ET> iDynaDEModel) throws Exception ;
	
	/**
	 * 是否为动态实体模板模式
	 * @return
	 */
	boolean isDynaDETemplMode();
	
	
}
