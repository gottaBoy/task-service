package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.sysmodel.ISystemModel;

/**
 * 实体操作标识用户角色模型对象接口实现
 * @author Administrator
 *
 */
public class DEOPPrivRoleModel extends ModelBase3Impl implements IDEOPPrivRoleModel {
	
	private IDataEntity iDataEntity = null;
	private ISystemModel iSystemModel = null;
	private String strDEOPPrivTag = null;
	private String strRoleType = null;
	private String strDEDataQueryId = null;
	private String strDEUserRoleId = null;
	private String strSysUserRoleId = null;
	
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
	public String getDEOPPrivTag() {
		return this.strDEOPPrivTag;
	}

	@Override
	public String getRoleType() {
		return this.strRoleType;
	}

	@Override
	public String getDEDataQueryId() {
		return this.strDEDataQueryId;
	}

	/**
	 * 设置实体操作标识
	 * @param strDEOPPrivTag
	 */
	public void setDEOPPrivTag(String strDEOPPrivTag) {
		this.strDEOPPrivTag = strDEOPPrivTag;
	}

	/**
	 * 设置角色类型
	 * @param strRoleType
	 */
	public void setRoleType(String strRoleType) {
		this.strRoleType = strRoleType;
	}

	/**
	 * 设置实体数据查询标识
	 * @param strDEDataQueryId
	 */
	public void setDEDataQueryId(String strDEDataQueryId) {
		this.strDEDataQueryId = strDEDataQueryId;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEOPPrivRole#getSysUserRoleId()
	 */
	@Override
	public String getSysUserRoleId() {
		return this.strSysUserRoleId;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEOPPrivRole#getDEUserRoleId()
	 */
	@Override
	public String getDEUserRoleId() {
		return this.strDEUserRoleId;
	}

	/**
	 * 设置实体用户角色标识
	 * @param strDEUserRoleId
	 */
	public void setDEUserRoleId(String strDEUserRoleId) {
		this.strDEUserRoleId = strDEUserRoleId;
	}

	/**
	 * 设置系统用户角色标识
	 * @param strSysUserRoleId
	 */
	public void setSysUserRoleId(String strSysUserRoleId) {
		this.strSysUserRoleId = strSysUserRoleId;
	}

	
	
	
}
