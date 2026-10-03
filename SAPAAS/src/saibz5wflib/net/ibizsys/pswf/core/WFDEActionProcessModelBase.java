package net.ibizsys.pswf.core;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 流程实体操作处理模型基类
 * @author lionlau
 *
 */
public abstract  class WFDEActionProcessModelBase extends WFProcessModelBase implements IWFDEActionProcessModel
{
	private ArrayList<IWFDEActionProcessParamModel> wfDEActionProcessParamModelList = new ArrayList<IWFDEActionProcessParamModel>();
	private String strDEActionName = "";
	
	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDEActionProcessModel#getWFDEActionProcessParamModels()
	 */
	@Override
	public Iterator<IWFDEActionProcessParamModel> getWFDEActionProcessParamModels()
	{
		return wfDEActionProcessParamModelList.iterator();
	}

	
	/**
	 * 注册处理参数
	 * @param iWFDEActionProcessParamModel
	 */
	protected void registerWFDEActionProcessParamModel(IWFDEActionProcessParamModel iWFDEActionProcessParamModel)
	{
		this.wfDEActionProcessParamModelList.add(iWFDEActionProcessParamModel);
	}



	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDEActionProcessModel#getDEActionName()
	 */
	@Override
	public String getDEActionName()
	{
		return this.strDEActionName;
	}


	/**
	 * 设置实体操作名称
	 * @param strDEActionName the strDEActionName to set
	 */
	public void setDEActionName(String strDEActionName)
	{
		this.strDEActionName = strDEActionName;
	}
	
	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.WFProcessModelBase#createWFProcess()
	 */
	@Override
	protected IWFProcess createWFProcess()throws Exception
	{
		return new WFDEActionProcess();
	}
	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.WFProcessModelBase#getWFProcessType()
	 */
	@Override
	public String getWFProcessType()
	{
		return IWFProcessModel.Process;
	}
	
}
