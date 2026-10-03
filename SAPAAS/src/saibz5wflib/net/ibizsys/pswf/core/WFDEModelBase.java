package net.ibizsys.pswf.core;

import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.IEntityActionSupporter;
import net.ibizsys.paas.util.StringHelper;

/**
 * 流程实体模型对象
 * @author lionlau
 *
 */
public abstract class WFDEModelBase implements IWFDEModel
{
	/**
	 * 流程模型
	 */
	private IWFModel iWFModel = null;

	/**
	 *  流程步骤属性
	 */
	private String strWFStepField = "";
	
	
	/**
	 *  流程状态属性
	 */
	private String strWFStateField = "";
	
	
	/**
	 *  流程用户数据状态属性
	 */
	private String strUDStateField = "";
	
	
	/**
	 * 流程实例字段
	 */
	private String strWFInstField = "";
	
	
	/**
	 * 数据流程中状态值
	 */
	private String strEntityWFState = "";
	
	
	/**
	 * 流程操作者属性
	 */
	private String strWFActorsField = "";
	
	/**
	 * 流程返回值属性
	 */
	private String strWFRetField = "";
	
	
	
	/**
	 * 流程版本属性
	 */
	private String strWFVerField = "";
	
	/**
	 *  标示
	 */
	private String strId = "";
	
	/**
	 * 名称
	 */
	private String strName = "";
	
	
	/**
	 * 流程编号 
	 */
	private String strWorkflowId = "";
	
	
	/**
	 * 获取启动流程操作名称
	 */
	private String strWFStartName = "";
	
	
	/**
	 * 获取流程标识存储属性
	 */
	private String strWorkflowField = "";
	
	
	/**
	 * 获取流程模式
	 */
	private String strWFMode = "";
	

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDEModel#getWFStepField()
	 */
	@Override
	public String getWFStepField()
	{
		return strWFStepField;
	}


	/**
	 * 设置流程步骤属性
	 * @param strWFStepField the strWFStepField to set
	 */
	protected void setWFStepField(String strWFStepField)
	{
		this.strWFStepField = strWFStepField;
	}



	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDEModel#getWFStateField()
	 */
	@Override
	public String getWFStateField()
	{
		return strWFStateField;
	}


	/**
	 * 设置流程状态属性
	 * @param strWFStateField the strWFStateField to set
	 */
	protected void setWFStateField(String strWFStateField)
	{
		this.strWFStateField = strWFStateField;
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDEModel#getUDStateField()
	 */
	@Override
	public String getUDStateField()
	{
		return strUDStateField;
	}


	/**
	 * 设置用户数据状态属性
	 * @param strUDStateField the strUDStateField to set
	 */
	protected void setUDStateField(String strUDStateField)
	{
		this.strUDStateField = strUDStateField;
	}



	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDEModel#getWFModel()
	 */
	@Override
	public IWFModel getWFModel()
	{
		return this.iWFModel;
	}


	/**
	 * 设置工作流模型对象
	 * @param iWFModel the iWFModel to set
	 */
	protected void setWFModel(IWFModel iWFModel)
	{
		this.iWFModel = iWFModel;
	}



	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDEModel#getId()
	 */
	@Override
	public String getId()
	{
		return strId;
	}


	/**
	 * 设置标识
	 * @param strId the strId to set
	 */
	protected void setId(String strId)
	{
		this.strId = strId;
	}


	
	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDEModel#getName()
	 */
	@Override
	public String getName()
	{
		return strName;
	}


	/**
	 * 设置名称
	 * @param strName the strName to set
	 */
	protected void setName(String strName)
	{
		this.strName = strName;
	}
	
	

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDEModel#getWorkflowId()
	 */
	@Override
	public String getWorkflowId()
	{
		return strWorkflowId;
	}


	/**
	 * 设置工作流标识
	 * @param strWorkflowId the strWorkflowId to set
	 */
	protected void setWorkflowId(String strWorkflowId)
	{
		this.strWorkflowId = strWorkflowId;
	}
	
	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDEModel#getWFInstField()
	 */
	@Override
	public String getWFInstField()
	{
		return this.strWFInstField;
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDEModel#getEntityWFState()
	 */
	@Override
	public String getEntityWFState()
	{
		if(StringHelper.isNullOrEmpty(this.strEntityWFState))
		{
			return this.getWFModel().getEntityWFState();
		}
		return this.strEntityWFState;
	}


	/**
	 * 设置流程实例属性
	 * @param strWFInstField the strWFInstField to set
	 */
	public void setWFInstField(String strWFInstField)
	{
		this.strWFInstField = strWFInstField;
	}


	/**
	 * 设置用户数据流程状态属性
	 * @param strEntityWFState the strEntityWFState to set
	 */
	public void setEntityWFState(String strEntityWFState)
	{
		this.strEntityWFState = strEntityWFState;
	}



	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDEModel#getWFActorsField()
	 */
	@Override
	public String getWFActorsField()
	{
		return this.strWFActorsField;
	}


	/**
	 * 设置当前流程操作者属性
	 * @param strWFActorsField the strWFActorsField to set
	 */
	public void setWFActorsField(String strWFActorsField)
	{
		this.strWFActorsField = strWFActorsField;
	}
	
	
	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDEModel#testDataInWF(net.ibizsys.paas.entity.IEntity)
	 */
	@Override
	public boolean testDataInWF(IEntity iEntity) throws Exception
	{
		/**
		 * 20170911 添加
		 */
		if(!iEntity.contains(this.getUDStateField())){
			if(iEntity instanceof IEntityActionSupporter){
				if(((IEntityActionSupporter)iEntity).getActionHelper() != null){
					((IEntityActionSupporter)iEntity).get(true);
				}
			}
		}
		String strValue = DataObject.getStringValue(iEntity,this.getUDStateField(),null);
		if(StringHelper.compare(strValue,this.getEntityWFState(),false)==0)
			return true;
		else
			return false;
	}
	
	
	
	
	


	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDEModel#getWFRetField()
	 */
	@Override
	public String getWFRetField()
	{
		return this.strWFRetField;
	}
	
	/**
	 * 设置子流程返回值属性
	 * @param strWFRetField
	 */
	protected void setWFRetField(String strWFRetField)
	{
		this.strWFRetField = strWFRetField;
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDEModel#getWFStartName()
	 */
	@Override
	public String getWFStartName() {
		return strWFStartName;
	}
	
	/**
	 * 设置流程开始名称
	 * @param strWFStartName
	 */
	protected void setWFStartName(String strWFStartName){
		this.strWFStartName  = strWFStartName;
	}
	
	
	
	

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDEModel#getWFVerField()
	 */
	@Override
	public String getWFVerField()
	{
		return this.strWFVerField;
	}
	
	/**
	 * 设置流程版本存储属性
	 * @param strWFVerField
	 */
	protected void setWFVerField(String strWFVerField)
	{
		this.strWFVerField = strWFVerField;
	}
	
	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDEModel#getWorkflowField()
	 */
	@Override
	public String getWorkflowField()
	{
		return this.strWorkflowField;
	}
	
	/**
	 * 设置流程标识存储属性
	 * @param strWorkflowField
	 */
	protected void setWorkflowField(String strWorkflowField)
	{
		this.strWorkflowField = strWorkflowField;
	}
	
	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDEModel#getWFMode()
	 */
	@Override
	public String getWFMode()
	{
		return this.strWFMode;
	}
	
	/**
	 * 设置流程模式
	 * @param strWFMode
	 */
	protected void setWFMode(String strWFMode)
	{
		this.strWFMode = strWFMode;
	}
	
	
}
