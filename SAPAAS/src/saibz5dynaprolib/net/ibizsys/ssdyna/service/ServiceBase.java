package net.ibizsys.ssdyna.service;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.ssdyna.demodel.IDynaDEModel;

/**
 * 动态实体服务对象基类
 * @author Administrator
 *
 * @param <ET>
 */
public abstract class ServiceBase<ET extends IEntity> extends net.ibizsys.saas.service.ServiceBase<ET> implements IDynaService<ET> {

	@Override
	public void init(IDynaDEModel<ET> iDynaDEModel) throws Exception {
		throw new Exception("当前实体服务对象不支持此操作");
	}
	
	
	@Override
	public boolean isDynaDETemplMode() {
	
		if(this.getDEModel() instanceof IDynaDEModel){
			return ((IDynaDEModel)this.getDEModel()).isDynaDETemplMode();
		}
		
		return false;
	}
}
