package net.ibizsys.ssdyna.dao;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.ssdyna.demodel.IDynaDEModel;

/**
 * 动态实体DAO对象基类
 * 
 * @author Administrator
 *
 * @param <ET>
 */
public abstract class DAOBase<ET extends IEntity> extends net.ibizsys.saas.dao.DAOBase<ET> implements IDynaDAO<ET> {

	@Override
	public boolean isDynaDETemplMode() {
	
		if(this.getDEModel() instanceof IDynaDEModel){
			return ((IDynaDEModel)this.getDEModel()).isDynaDETemplMode();
		}
		
		return false;
	}

	
}
