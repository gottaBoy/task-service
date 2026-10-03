package net.ibizsys.pswf.core;

import java.util.Iterator;

import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.util.StringHelper;

/**
 * 流程交互连接模型基类
 * @author lionlau
 *
 */
public abstract class WFInteractiveLinkModelBase extends WFLinkModelBase implements IWFInteractiveLinkModel
{
	private String strNextCondition = IWFInteractiveLinkModel.NEXTCOND_ALL;
	private int nActionCount = 0;
	private boolean bActorIAActionControl = false;
	private String strMemoField = "";
	private String strActionField = "";
	private String strAddWFRoleId = "";
	private ICodeList actionCodeList = null;
//	private String[] actorFields = null;
	private IWFRoleModel addedWFRoleModel = null;
	
	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.WFLinkModelBase#onInit()
	 */
	@Override
	protected void onInit() throws Exception
	{
		if(!StringHelper.isNullOrEmpty(this.getAddedWFRoleId()))
		{
			addedWFRoleModel = this.getWFVersionModel().getWFModel().getSystemModel().getWFRoleModel(this.getAddedWFRoleId());
		}
		super.onInit();
	}
	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFInteractiveLinkModel#isActorIAActionControl()
	 */
	@Override
	public boolean isActorIAActionControl()
	{
		return  this.bActorIAActionControl;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFInteractiveLinkModel#containsWFProcRole(net.ibizsys.pswf.core.IWFProcRoleModel)
	 */
	@Override
	public boolean containsWFProcRole(IWFProcRoleModel iWFProcRoleModel)
	{
		return true;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFInteractiveLinkModel#containsUDActor(java.lang.String)
	 */
	@Override
	public boolean containsUDActor(String strUDActorId)
	{
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFInteractiveLinkModel#getActionCount()
	 */
	@Override
	public int getActionCount()
	{
		return nActionCount;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFInteractiveLinkModel#getNextCondition()
	 */
	@Override
	public String getNextCondition()
	{
		return strNextCondition;
	}

	/**
	 * 设置下一步的到达条件
	 * @param strNextCondition the strNextCondition to set
	 */
	protected void setNextCondition(String strNextCondition)
	{
		this.strNextCondition = strNextCondition;
	}

	/**
	 * @param nActionCount the nActionCount to set
	 */
	protected void setActionCount(int nActionCount)
	{
		this.nActionCount = nActionCount;
	}

	/**
	 * @param bActorIAActionControl the bActorIAActionControl to set
	 */
	protected void setActorIAActionControl(boolean bActorIAActionControl)
	{
		this.bActorIAActionControl = bActorIAActionControl;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFLinkModel#getMemoField()
	 */
	@Override
	public String getMemoField()
	{
		return strMemoField;
	}

	/**
	 * 获取处理意见属性
	 * @param strMemoField
	 */
	protected void setMemoField(String strMemoField)
	{
		this.strMemoField = strMemoField;
	}
	
	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFLinkModel#getActionField()
	 */
	@Override
	public String getActionField()
	{
		return strActionField;
	}

	/**
	 * 获取操作属性
	 * @param strActionField
	 */
	protected void setActionField(String strActionField)
	{
		this.strActionField = strActionField;
	}
	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFModel#getActionCodeList()
	 */
	@Override
	public ICodeList getActionCodeList()
	{
		return this.actionCodeList;
	}
	
	
	/**
	 * 设置操作代码表对象
	 * @param actionCodeList
	 */
	protected void setActionCodeList(ICodeList actionCodeList)
	{
		this.actionCodeList = actionCodeList;
	}
	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFLinkModel#getAddedWFRoleId()
	 */
	@Override
	public String getAddedWFRoleId()
	{
		return strAddWFRoleId;
	}
	
	
	

	/**
	 * 设置附加流程角色标识
	 * @param strAddedWFRoleId
	 */
	protected void setAddedWFRoleId(String strAddWFRoleId)
	{
		this.strAddWFRoleId = strAddWFRoleId;
	}
	
	

//	/**
//	 * 获取操作属性
//	 * @param strAddActorFields
//	 */
//	protected void setAddActorFields(String strAddActorFields)
//	{
//		this.strAddActorFields = strAddActorFields;
//		if(!StringHelper.isNullOrEmpty(this.strAddActorFields))
//		{
//			actorFields = StringHelper.splitEx(this.strAddActorFields);
//		}
//	}
//	
//	
//	/* (non-Javadoc)
//	 * @see net.ibizsys.pswf.core.IWFProcRoleModel#getUDFields()
//	 */
//	@Override
//	public String[] getAddActorFields()
//	{
//		return actorFields;
//	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcRoleModel#getWFRoleUserModels(net.ibizsys.pswf.core.IWFActionContext)
	 */
	@Override
	public Iterator<IWFRoleUser> getAddedWFRoleUserModels(IWFActionContext iWFActionContext) throws Exception
	{
		if(getAddedWFRoleModel()==null)
			return null;
		return getAddedWFRoleModel().getWFRoleUserModels(iWFActionContext);

	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFInteractiveLinkModel#getAddWFRoleModel()
	 */
	@Override
	public IWFRoleModel getAddedWFRoleModel()
	{
		return addedWFRoleModel;
	}

	
}
