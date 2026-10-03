package net.ibizsys.pswf.core;

import net.ibizsys.paas.sysmodel.ISystemModel;

/**
 * 流程角色模型
 * @author lionlau
 *
 */
public abstract class WFRoleModelBase implements IWFRoleModel
{
	private String strId = "";
	private String strName = "";
	private String strWFRoleSN = "";
	private String strUserData = null;
	private String strUserData2 = null;
	private Object objRuntimeId = null;

	

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFRoleModel#getSystemModel()
	 */
	@Override
	public abstract ISystemModel getSystemModel();
	

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFRoleModel#getId()
	 */
	@Override
	public String getId()
	{
		return this.strId;
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFRoleModel#getName()
	 */
	@Override
	public String getName()
	{
		return this.strName;
	}

	/**
	 * 设置流程角色标识
	 * @param strId the strId to set
	 */
	protected void setId(String strId)
	{
		this.strId = strId;
	}

	/**
	 * 设置流程角色名称
	 * @param strName the strName to set
	 */
	protected void setName(String strName)
	{
		this.strName = strName;
	}


	/**
	 * 获取流程角色编号
	 * @return the strWFRoleSN
	 */
	protected String getWFRoleSN()
	{
		return strWFRoleSN;
	}


	/**
	 * 设置流程角色编号
	 * @param strWFRoleSN the strWFRoleSN to set
	 */
	protected void setWFRoleSN(String strWFRoleSN)
	{
		this.strWFRoleSN = strWFRoleSN;
	}


	/**
	 * 获取流程角色用户数据
	 * @return the strUserData
	 */
	protected String getUserData()
	{
		return strUserData;
	}


	/**
	 * 设置流程角色用户数据
	 * @param strUserData the strUserData to set
	 */
	protected void setUserData(String strUserData)
	{
		this.strUserData = strUserData;
	}


	/**
	 *  获取流程角色用户数据2
	 * @return the strUserData2
	 */
	protected String getUserData2()
	{
		return strUserData2;
	}


	/**
	 * 设置流程角色用户数据2
	 * @param strUserData2 the strUserData2 to set
	 */
	protected void setUserData2(String strUserData2)
	{
		this.strUserData2 = strUserData2;
	}

	@Override
	public Object getRuntimeId() {
		if(objRuntimeId == null)
			return this.getId();
		return objRuntimeId;
	}

	@Override
	public void setRuntimeId(Object objRuntimeId) {
		this.objRuntimeId = objRuntimeId;
	}
}
