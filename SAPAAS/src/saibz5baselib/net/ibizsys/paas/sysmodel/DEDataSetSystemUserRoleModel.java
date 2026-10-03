package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.core.IDEDataSetSystemUserRole;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;

/**
 * 实体数据集系统用户角色对象模型
 * @author Administrator
 *
 */
public class DEDataSetSystemUserRoleModel extends SystemUserRoleModelBase implements IDEDataSetSystemUserRole {

	/**
	 * 实体名称
	 */
	private String strDEName = null;

	/**
	 * 实体数据集合名称
	 */
	private String strDEDataSetName = null;
	
	protected IDataEntityModel iDEModel = null;

	@Override
	protected void onInit() throws Exception {
		iDEModel = DEModelGlobal.getDEModel(this.getDEName());
		super.onInit();
	}
	
	
	@Override
	public String getRoleType() {
		return ISystemUserRoleModel.ROLETYPE_DEDATASET;
	}

	
		

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEDataSetSystemUserRole#getDEName()
	 */
	@Override
	public String getDEName() {
		return this.strDEName;
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEDataSetSystemUserRole#getDEDataSetName()
	 */
	@Override
	public String getDEDataSetName() {
		return this.strDEDataSetName;
	}


	/**
	 * 设置实体名称
	 * @param strDEName
	 */
	public void setDEName(String strDEName) {
		this.strDEName = strDEName;
	}


	/**
	 * 设置实体数据集合名称
	 * @param strDEDataSetName
	 */
	public void setDEDataSetName(String strDEDataSetName) {
		this.strDEDataSetName = strDEDataSetName;
	}

	
	
}
