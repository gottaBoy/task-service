package net.ibizsys.psba.service;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.psba.core.IBASchemeModel;
import net.ibizsys.psba.core.IBATableModel;
import net.ibizsys.psba.dao.IBADAO;

/**
 * BA服务基类
 * @author Administrator
 *
 */
public abstract class BAServiceBase implements IBAService {

	@Override
	public abstract IBASchemeModel getBASchemeModel();

	@Override
	public abstract  IBATableModel getBATableModel();

	
	/**
	 * 获取大数据架构
	 * @return
	 */
	protected abstract IBADAO getBADAO();

	
	/* (non-Javadoc)
	 * @see net.ibizsys.psba.service.IBAService#importDEData(net.ibizsys.paas.entity.IEntity)
	 */
	@Override
	public void importDEData(IEntity et) throws Exception {
//		IEntity iEntity = this.getBADAO().getDEModel().createEntity();
//		et.copyTo(iEntity, false);
//		onImportDEDataSelfMode(iEntity);
//		onImportDEDataChildMode(iEntity);
		throw new Exception("没有实现");
	}
	
	
	/**
	 * 导入实体数据（当前数据模式）
	 * @param et
	 * @throws Exception
	 */
	protected void onImportDEDataSelfMode(IEntity et) throws Exception {
		
		
		
	}
	
	
	/**
	 * 导入实体数据
	 * @param et
	 * @throws Exception
	 */
	protected void onImportDEDataChildMode(IEntity et) throws Exception {
		
		
		
	}
}
