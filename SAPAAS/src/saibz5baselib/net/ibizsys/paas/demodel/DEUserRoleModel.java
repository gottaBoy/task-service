package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.sysmodel.ISystemModel;

/**
 * 实体用户角色模型对象接口实现
 * @author Administrator
 *
 */
public class DEUserRoleModel extends ModelBase3Impl implements IDEUserRoleModel {
	
	private IDataEntity iDataEntity = null;
	private ISystemModel iSystemModel = null;
	private String strRoleTag = null;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEUniState#init(net.ibizsys.paas.core.IDataEntity)
	 */
	public void init(IDataEntity iDataEntity) throws Exception {
		this.iDataEntity = iDataEntity;
		this.iSystemModel = (ISystemModel)this.iDataEntity.getSystem();
		this.onInit();
	}

	/**
	 * 设置标识
	 * 
	 * @param strId
	 */
	public void setId(String strId) {
		this.strId = strId;
	}
	
	
	/**
	 * 设置名称
	 * 
	 * @param strId
	 */
	public void setName(String strName) {
		this.strName = strName;
	}
	
	

	@Override
	public IDataEntity getDataEntity() {
		return this.iDataEntity;
	}

	@Override
	public String getRoleTag() {
		return this.strRoleTag;

	}

	/**
	 * 设置角色标识
	 * @param strRoleTag
	 */
	public void setRoleTag(String strRoleTag) {
		this.strRoleTag = strRoleTag;
	}

	
	
	
}
