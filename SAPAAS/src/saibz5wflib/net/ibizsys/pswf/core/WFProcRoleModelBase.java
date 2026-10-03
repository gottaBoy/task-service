package net.ibizsys.pswf.core;

import net.ibizsys.paas.util.StringHelper;


/**
 * 工作流处理角色基类
 * @author lionlau
 *
 */
public abstract class WFProcRoleModelBase implements IWFProcRoleModel
{	
	private String strId = "";
	private String strName = "";
	private String strWFProcRoleType = "";
	private String strWFRoleId = "";
	private IWFRoleModel iWFRoleModel = null;
	private IWFInteractiveProcessModel iWFInteractiveProcessModel = null;
	
//	
//	public WFProcRoleModelBase(IWFInteractiveProcessModel iWFInteractiveProcessModel)
//	{
//		this.iWFInteractiveProcessModel = iWFInteractiveProcessModel;
//	}
//	

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcRoleModel#init(net.ibizsys.pswf.core.IWFInteractiveProcessModel)
	 */
	@Override
	public void init(IWFInteractiveProcessModel iWFInteractiveProcessModel) throws Exception
	{
		this.iWFInteractiveProcessModel = iWFInteractiveProcessModel;
		
			
		this.onInit();
	}
	
	/**
	 * 初始化触发
	 * @throws Exception
	 */
	protected void onInit()throws Exception
	{
		if(!StringHelper.isNullOrEmpty(getWFRoleId()))
		{
			iWFRoleModel = this.iWFInteractiveProcessModel.getWFVersionModel().getWFModel().getSystemModel().getWFRoleModel(getWFRoleId());
		}
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcRoleModel#getId()
	 */
	@Override
	public String getId()
	{
		return this.strId;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcRoleModel#getName()
	 */
	@Override
	public String getName()
	{
		return this.strName;
	}

	/**
	 * 设置处理角色标识
	 * @param strId the strId to set
	 */
	public void setId(String strId)
	{
		this.strId = strId;
	}

	/**
	 * 设置处理角色名称
	 * @param strName the strName to set
	 */
	public void setName(String strName)
	{
		this.strName = strName;
	}
	

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcRoleModel#getWFInteractiveProcessModel()
	 */
	@Override
	public IWFInteractiveProcessModel getWFInteractiveProcessModel()
	{
		return this.iWFInteractiveProcessModel;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcRoleModel#getWFRoleId()
	 */
	@Override
	public String getWFRoleId()
	{
		return this.strWFRoleId;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcRoleModel#getWFProcRoleType()
	 */
	@Override
	public String getWFProcRoleType()
	{
		return this.strWFProcRoleType;
	}
	


	/**
	 * 设置处理角色类型
	 * @param strWFProcRoleType the strWFProcRoleType to set
	 */
	public void setWFProcRoleType(String strWFProcRoleType)
	{
		this.strWFProcRoleType = strWFProcRoleType;
	}

	/**
	 * 设置流程角色标识
	 * @param strWFRoleId the strWFRoleId to set
	 */
	public void setWFRoleId(String strWFRoleId)
	{
		this.strWFRoleId = strWFRoleId;
	}



	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcRoleModel#getWFRoleModel()
	 */
	@Override
	public IWFRoleModel getWFRoleModel()
	{
		return this.iWFRoleModel;	
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcRoleModel#getUDFields()
	 */
	@Override
	public String[] getUDFields()
	{
		return null;
	}

	
	
}
