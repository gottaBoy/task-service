package net.ibizsys.paas.service;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.IEntityActionHelper;

/**
 * 实体操作辅助接口实现
 * @author Administrator
 *
 */
public class EntityActionHelperImpl implements IEntityActionHelper {

	private IService iService = null;
	public void init(IService iService)throws Exception{
		this.iService = iService;
	}
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.entity.IEntityActionHelper#create(net.ibizsys.paas.entity.IEntity)
	 */
	@Override
	public void create(IEntity iEntity) throws Exception {
		iService.create(iEntity);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.entity.IEntityActionHelper#update(net.ibizsys.paas.entity.IEntity)
	 */
	@Override
	public void update(IEntity iEntity) throws Exception {
		iService.update(iEntity);
	}
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.entity.IEntityActionHelper#save(net.ibizsys.paas.entity.IEntity)
	 */
	@Override
	public void save(IEntity iEntity) throws Exception {
		iService.save(iEntity);
	}
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.entity.IEntityActionHelper#remove(net.ibizsys.paas.entity.IEntity)
	 */
	@Override
	public void remove(IEntity iEntity) throws Exception {
		iService.remove(iEntity);
	}
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.entity.IEntityActionHelper#get(net.ibizsys.paas.entity.IEntity, boolean)
	 */
	@Override
	public boolean get(IEntity iEntity, boolean bTryMode) throws Exception {
		return iService.get(iEntity,bTryMode);
	}
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.entity.IEntityActionHelper#select(net.ibizsys.paas.entity.IEntity, boolean)
	 */
	@Override
	public boolean select(IEntity iEntity, boolean bTryMode) throws Exception {
		return iService.select(iEntity,bTryMode);
	}
	
	
	
}
