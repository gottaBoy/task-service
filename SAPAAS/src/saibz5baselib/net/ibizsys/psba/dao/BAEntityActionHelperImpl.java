package net.ibizsys.psba.dao;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.psba.core.IBASchemeModel;
import net.ibizsys.psba.core.IBATableModel;
import net.ibizsys.psba.entity.IBAEntity;
import net.ibizsys.psba.entity.IBAEntityActionHelper;


/**
 * 大数据架构数据对象操作辅助接口实现
 * @author Administrator
 *
 */
public class BAEntityActionHelperImpl implements IBAEntityActionHelper {

	private IBATableModel iBATableModel = null;
	private IBADAO iBADAO = null;
	private IBASchemeModel iBASchemeModel = null;
	
	/**
	 * 初始化大数据表数据操作辅助对象
	 * @param iBATable
	 * @throws Exception
	 */
	public void init(IBADAO iBADAO)throws Exception{
		this.iBADAO = iBADAO; 
		this.iBATableModel = this.iBADAO.getBATableModel();
		this.iBASchemeModel = (IBASchemeModel)this.iBATableModel.getBAScheme();
	}

	@Override
	public void create(IEntity iEntity) throws Exception {
		if(!(iEntity instanceof IBAEntity)){
			throw new Exception("参数类型不正确");
		}
		this.iBADAO.executeCreateCmd((IBAEntity)iEntity,null);
	}

	@Override
	public void update(IEntity iEntity) throws Exception {
		if(!(iEntity instanceof IBAEntity)){
			throw new Exception("参数类型不正确");
		}
		this.iBADAO.executeUpdateCmd((IBAEntity)iEntity,null);
	}

	@Override
	public void save(IEntity iEntity) throws Exception {
		if(!(iEntity instanceof IBAEntity)){
			throw new Exception("参数类型不正确");
		}
		this.iBADAO.executeCreateCmd((IBAEntity)iEntity,null);
	}

	@Override
	public void remove(IEntity iEntity) throws Exception {
		if(!(iEntity instanceof IBAEntity)){
			throw new Exception("参数类型不正确");
		}
		this.iBADAO.executeRemoveCmd((IBAEntity)iEntity);
	}

	@Override
	public boolean get(IEntity iEntity, boolean bTryMode) throws Exception {
		if(!(iEntity instanceof IBAEntity)){
			throw new Exception("参数类型不正确");
		}
		try{
			this.iBADAO.executeGetCmd((IBAEntity)iEntity,null);
			return true;
		}
		catch(Exception ex){
			if(bTryMode){
				return false;
			}
			throw ex;
		}
		
	}

	@Override
	public boolean select(IEntity iEntity, boolean bTryMode) throws Exception {
		throw new Exception("没有实现");
	}

	@Override
	public void create(IBAEntity iEntity, String[] families) throws Exception {
		this.iBADAO.executeCreateCmd(iEntity,families);
	}

	@Override
	public void update(IBAEntity iEntity, String[] families) throws Exception {
		this.iBADAO.executeUpdateCmd(iEntity,families);
	}

	@Override
	public void save(IBAEntity iEntity, String[] families) throws Exception {
		this.iBADAO.executeCreateCmd(iEntity,families);
	}

	@Override
	public boolean get(IBAEntity iEntity, String[] families, boolean bTryMode) throws Exception {
		try{
			this.iBADAO.executeGetCmd(iEntity,families);
			return true;
		}
		catch(Exception ex){
			if(bTryMode){
				return false;
			}
			throw ex;
		}
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.psba.entity.IBAEntityActionHelper#getBASchemeModel()
	 */
	@Override
	public IBASchemeModel getBASchemeModel() {
		return this.iBASchemeModel;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.psba.entity.IBAEntityActionHelper#getBATableModel()
	 */
	@Override
	public IBATableModel getBATableModel() {
		return this.iBATableModel;
	}
	
	
	
}
