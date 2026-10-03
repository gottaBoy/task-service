package net.ibizsys.ssdyna.dao;


import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.ssdyna.demodel.IDynaDEModel;
import net.ibizsys.ssdyna.entity.DynaEntity;

/**
 * 动态实体数据库访问对象
 * @author Administrator
 *
 */
public class DynaDAO extends DAOBase<DynaEntity> {

	private IDynaDEModel<DynaEntity> iDynaDEModel = null;
	public void init(IDynaDEModel<DynaEntity> iDynaDEModel)throws Exception{
		this.iDynaDEModel =  iDynaDEModel;
	}
	
	@Override
	public IDataEntityModel getDEModel() {
		return this.iDynaDEModel;
	}

}
