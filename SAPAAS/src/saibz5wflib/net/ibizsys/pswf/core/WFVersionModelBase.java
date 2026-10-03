package net.ibizsys.pswf.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.util.StringHelper;


/**
 * 工作流版本基类
 * @author lionlau
 *
 */
public abstract class WFVersionModelBase implements IWFVersionModel
{	
	private String strId = "";
	private String strName = "";
	private IWFModel iWFModel = null;
	private IWFProcessModel startWFProcessModel = null;
	private ArrayList<IWFProcessModel> wfProcessModelList = new ArrayList<IWFProcessModel>();
	private ArrayList<IWFLinkModel> wfLinkModelList = new ArrayList<IWFLinkModel>();
	private HashMap<String, IWFProcessModel> wfProcessModelMap = new HashMap<String, IWFProcessModel>();
	private HashMap<String, IWFProcessModel> wfProcessModelMap2 = new HashMap<String, IWFProcessModel>();
	private int nWFVersion = 0;
	private boolean bWFParallelSubWFProcessModel = false;
	private String strWFMode = "";
	private String strBPMNModel = "";
	

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFVersionModel#init(net.ibizsys.pswf.core.IWFModel)
	 */
	@Override
	public void init(IWFModel iWFModel) throws Exception
	{
		this.iWFModel = iWFModel;
		this.onInit();
	}
	
	/**
	 * 初始化触发
	 * @throws Exception
	 */
	protected void onInit()throws Exception
	{
		prepareWFProcessModels();
		prepareWFLinkModels();
	}
	
	
	/**
	 * 注册处理模型
	 * @throws Exception
	 */
	protected void prepareWFProcessModels()throws Exception
	{
		
	}
	
	/**
	 * 注册连接模型
	 * @throws Exception
	 */
	protected void prepareWFLinkModels()throws Exception
	{
		
	}
	
	
	/**
	 * 注册处理模型
	 * @param iWFProcessModel
	 * @throws Exception
	 */
	protected void registerWFProcessModel(IWFProcessModel iWFProcessModel)throws Exception
	{
		if(iWFProcessModel.isStartProcess())
		{
			if(this.getStartWFProcessModel()!=null)
			{
				throw new Exception(StringHelper.format("流程模型中已经存在开始处理，不能重复定义"));
			}
			this.setStartWFProcessModel(iWFProcessModel);
		}
		
		String strId = iWFProcessModel.getId();
		if(wfProcessModelMap.containsKey(strId))
		{
			throw new Exception(StringHelper.format("流程模型中已经存在标识为[%1$s]的处理，不能重复定义",strId));
		}
		wfProcessModelMap.put(strId, iWFProcessModel);
		if(!StringHelper.isNullOrEmpty(iWFProcessModel.getBPMNModelId())){
			if(wfProcessModelMap.containsKey(iWFProcessModel.getBPMNModelId()))
			{
				throw new Exception(StringHelper.format("流程模型中已经存在BPMN标识为[%1$s]的处理，不能重复定义",iWFProcessModel.getBPMNModelId()));
			}
			wfProcessModelMap.put(iWFProcessModel.getBPMNModelId(), iWFProcessModel);
		}
//		String strName = iWFProcessModel.getName();
//		if(!StringHelper.isNullOrEmpty(strName) && StringHelper.compare(strId, strName, false)!=0)
//		{
//			if(wfProcessModelMap.containsKey(strName))
//			{
//				throw new Exception(StringHelper.format("流程模型中已经存在标识为[%1$s]的处理，不能重复定义",strName));
//			}
//			wfProcessModelMap.put(strName, iWFProcessModel);
//		}
		
		String strWFStepValue = iWFProcessModel.getWFStepValue();
		if(!StringHelper.isNullOrEmpty(strWFStepValue))
		{
			if(wfProcessModelMap2.containsKey(strWFStepValue))
			{
				throw new Exception(StringHelper.format("流程模型中已经存在步骤值为[%1$s]的处理，不能重复定义",strWFStepValue));
			}
			wfProcessModelMap2.put(strWFStepValue, iWFProcessModel);
		}
		
		wfProcessModelList.add(iWFProcessModel);
		
		if(!this.bWFParallelSubWFProcessModel)
		{
			if(iWFProcessModel instanceof IWFParallelSubWFProcessModel){
				this.bWFParallelSubWFProcessModel = true;
			}
		}
	}
	
	
	/**
	 * 注册处理模型
	 * @param iWFProcessModel
	 * @throws Exception
	 */
	protected void registerWFLinkModel(IWFLinkModel iWFLinkModel)throws Exception
	{
		IWFProcessModel iWFProcessModel = this.getWFProcessModel(iWFLinkModel.getFrom(), false);
		iWFProcessModel.registerWFLinkModel(iWFLinkModel);
		this.wfLinkModelList.add(iWFLinkModel);
	}
	
	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFVersionModel#getId()
	 */
	@Override
	public String getId()
	{
		return this.strId;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFVersionModel#getName()
	 */
	@Override
	public String getName()
	{
		return this.strName;
	}

	/**
	 * 设置流程版本标识
	 * @param strId the strId to set
	 */
	protected void setId(String strId)
	{
		this.strId = strId;
	}

	/**
	 * 设置流程版本名称
	 * @param strName the strName to set
	 */
	protected void setName(String strName)
	{
		this.strName = strName;
	}
	
	
	 

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFVersionModel#getWFMode()
	 */
	@Override
	public String getWFMode() {
		return this.strWFMode;
	}

	/**
	 * 设置流程模式
	 * @param strWFMode the strWFMode to set
	 */
	protected void setWFMode(String strWFMode)
	{
		this.strWFMode = strWFMode;
	}
	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFVersionModel#getWFModel()
	 */
	@Override
	public IWFModel getWFModel()
	{
		return this.iWFModel;
	}

	
	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFVersionModel#getWFProcessModels()
	 */
	@Override
	public Iterator<IWFProcessModel> getWFProcessModels()
	{
		return wfProcessModelList.iterator();
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFVersionModel#getWFLinkModels()
	 */
	@Override
	public Iterator<IWFLinkModel> getWFLinkModels()
	{
		return wfLinkModelList.iterator();
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFVersionModel#getWFProcessModel(java.lang.String, boolean)
	 */
	@Override
	public IWFProcessModel getWFProcessModel(String strWFProcessModelName,boolean bTryMode)throws Exception
	{
		IWFProcessModel iWFProcessModel =  wfProcessModelMap.get(strWFProcessModelName);
		if(iWFProcessModel == null && !bTryMode)
		{
			throw new Exception(StringHelper.format("无法获取工作流[%1$s]指定处理，标识为[%2$s]", this.getName(), strWFProcessModelName));
		}
		return iWFProcessModel;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFVersionModel#getWFVersion()
	 */
	@Override
	public int getWFVersion()
	{
		return this.nWFVersion;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFVersionModel#getWFProcessModelByWFStepValue(java.lang.String, boolean)
	 */
	@Override
	public IWFProcessModel getWFProcessModelByWFStepValue(String strWFStepValue, boolean bTryMode) throws Exception
	{
		IWFProcessModel iWFProcessModel =  wfProcessModelMap2.get(strWFStepValue);
		if(iWFProcessModel == null && !bTryMode)
		{
			throw new Exception(StringHelper.format("无法获取指定处理，步骤值为[%1$s]",strWFStepValue));
		}
		return iWFProcessModel;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFVersionModel#getStartWFProcessModel()
	 */
	@Override
	public IWFProcessModel getStartWFProcessModel()
	{
		return this.startWFProcessModel;
	}

	/**
	 * 设置开始处理模型对象
	 * @param startWFProcessModel the startWFProcessModel to set
	 */
	protected void setStartWFProcessModel(IWFProcessModel startWFProcessModel)
	{
		this.startWFProcessModel = startWFProcessModel;
	}

	
	/**
	 * 设置流程版本
	 * @param nWFVersion the nWFVersion to set
	 */
	protected void setWFVersion(int nWFVersion)
	{
		this.nWFVersion = nWFVersion;
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFVersionModel#hasWFParallelSubWFProcessModel()
	 */
	@Override
	public boolean hasWFParallelSubWFProcessModel()
	{
		return this.bWFParallelSubWFProcessModel;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFVersionModel#getBPMNModel()
	 */
	@Override
	public String getBPMNModel() {
		return this.strBPMNModel;
	}
	
	/**
	 * 设置BPMN模型
	 * @param strBPMNModel
	 */
	protected void setBPMNModel(String strBPMNModel){
		this.strBPMNModel = strBPMNModel;
	}

	
	@Override
	public ICodeList getWFStepCodeList() {
		return this.getWFModel().getWFStepCodeList();
	}
	
	
	
	
}
