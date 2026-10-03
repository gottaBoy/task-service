package net.ibizsys.pswf.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import net.ibizsys.paas.util.StringHelper;

/**
 * 交互处理流程对象
 * @author lionlau
 *
 */
public abstract class WFInteractiveProcessModelBase extends WFProcessModelBase implements IWFInteractiveProcessModel
{
	protected ArrayList<IWFProcRoleModel> wfProcRoleModelList = new ArrayList<IWFProcRoleModel>();
	private ArrayList<IWFInteractiveLinkModel> wfInteractiveLinkModelList = new ArrayList<IWFInteractiveLinkModel>();
	private HashMap<String, IWFInteractiveLinkModel> wfInteractiveLinkModelMap = new HashMap<String, IWFInteractiveLinkModel>();
	private ArrayList<String> udActorList = new ArrayList<String>();
	private boolean bEditable = false;
	private String strMemoField = "";
	private boolean bSendInform =false;
	private String strMsgTemplateId = "";
	private int nMsgType = 0;
	private String strMultiInstMode = IWFInteractiveProcessModel.MULTIINSTMODE_NONE;
	
	
	/**
	 * 注册处理模型
	 * @param iWFProcessModel
	 * @throws Exception
	 */
	protected void registerWFProcRoleModel(IWFProcRoleModel iWFProcRoleModel)throws Exception
	{
		wfProcRoleModelList.add(iWFProcRoleModel);
	}
	
	

	/**
	 * 注册上下文操作用户
	 * @param strUDActor
	 * @throws Exception
	 */
	protected void registerUDActor(String strUDActor)throws Exception
	{
		udActorList.add(strUDActor);
	}
	
	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.WFProcessModelBase#registerWFLinkModel(net.ibizsys.pswf.core.IWFLinkModel)
	 */
	@Override
	public void registerWFLinkModel(IWFLinkModel iWFLinkModel) throws Exception
	{
		super.registerWFLinkModel(iWFLinkModel);
		if(iWFLinkModel instanceof IWFInteractiveLinkModel)
		{
			IWFInteractiveLinkModel iWFInteractiveLinkModel = (IWFInteractiveLinkModel)iWFLinkModel;
			wfInteractiveLinkModelList.add(iWFInteractiveLinkModel);
			wfInteractiveLinkModelMap.put(iWFInteractiveLinkModel.getName(), iWFInteractiveLinkModel);
		}
	}
	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFInteractiveProcessModel#getWFInteractiveLinkModels()
	 */
	@Override
	public Iterator<IWFInteractiveLinkModel> getWFInteractiveLinkModels()
	{
		return this.wfInteractiveLinkModelList.iterator();
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFInteractiveProcessModel#getWFInteractiveLinkModel(java.lang.String, boolean)
	 */
	@Override
	public IWFInteractiveLinkModel getWFInteractiveLinkModel(String strName, boolean bTryMode) throws Exception
	{
		IWFInteractiveLinkModel iWFInteractiveLinkModel = wfInteractiveLinkModelMap.get(strName);
		if(iWFInteractiveLinkModel == null &&!bTryMode)
		{
			throw new Exception(StringHelper.format("无法获取指定交互连接，标识为[%1$s]",strName));
		}
		return iWFInteractiveLinkModel;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFInteractiveProcessModel#getWFProcRoleModels()
	 */
	@Override
	public Iterator<IWFProcRoleModel> getWFProcRoleModels()
	{
		return this.wfProcRoleModelList.iterator();
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFInteractiveProcessModel#isSendInform()
	 */
	@Override
	public boolean isSendInform()
	{
		return this.bSendInform;
	}
	
	/**
	 * 设置是否发送通知
	 * @param bSendInform
	 */
	protected void setSendInform(boolean bSendInform)
	{
		this.bSendInform = bSendInform;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFInteractiveProcessModel#getMsgTemplateId()
	 */
	@Override
	public String getMsgTemplateId()
	{
		return strMsgTemplateId;
	}
	
	/**
	 * 设置通知消息模板标识
	 * @param strMsgTemplateId
	 */
	protected void setMsgTemplateId(String strMsgTemplateId)
	{
		this.strMsgTemplateId = strMsgTemplateId;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFInteractiveProcessModel#getMsgType()
	 */
	@Override
	public int getMsgType()
	{
		return this.nMsgType;
	}
	
	/**
	 * 设置通知消息类型
	 * @param nMsgType
	 */
	protected void setMsgType(int nMsgType)
	{
		this.nMsgType = nMsgType;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFInteractiveProcessModel#isActorIAActionControl()
	 */
	@Override
	public boolean isActorIAActionControl()
	{
		return false;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFInteractiveProcessModel#getUDActors()
	 */
	@Override
	public Iterator<String> getUDActors()
	{
		return this.udActorList.iterator();
	}
 
	
	/* (non-Javadoc)
	 * @see SRFWF.Model.WFBaseProcessConfig#isInteractiveProcess()
	 */
	@Override
	public boolean isSuspendProcess()
	{
		return true;
	}



	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFInteractiveProcessModel#isEditable()
	 */
	@Override
	public boolean isEditable()
	{
		return this.bEditable;
	}
	
	/**
	 * 设置当前步骤是否运行编辑
	 * @param bEditable
	 */
	protected void setEditable(boolean bEditable)
	{
		this.bEditable = bEditable;
	}
	
	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.WFProcessModelBase#getWFProcessType()
	 */
	@Override
	public String getWFProcessType()
	{
		return IWFProcessModel.Interactive;
	}



	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFInteractiveProcessModel#getMemoField()
	 */
	@Override
	public String getMemoField()
	{
		return strMemoField;
	}
	
	
	/**
	 * 设置处理已经属性
	 * @param strMemoField
	 */
	protected void setMemoField(String strMemoField)
	{
		this.strMemoField = strMemoField;
	}



	@Override
	public String getMultiInstMode() {
		return this.strMultiInstMode;
	}
	
	/**
	 * 设置流程多实例模式
	 * @param strMultiInstMode
	 */
	protected void setMultiInstMode(String strMultiInstMode){
		this.strMultiInstMode = strMultiInstMode;
	}
	
	
}
