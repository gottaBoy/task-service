package net.ibizsys.pswf.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import net.ibizsys.paas.util.StringHelper;
                       
/**
 * 嵌入流程处理基类
 * @author Administrator
 *
 */
public  abstract class WFEmbedWFProcessModelBaseBase extends WFProcessModelBase implements IWFEmbedWFProcessModelBase
{
	
	private ArrayList<IWFEmbedWFReturnModel> wfEmbedWFReturnModelList = new ArrayList<IWFEmbedWFReturnModel>();
	private HashMap<String, IWFEmbedWFReturnModel> wfEmbedWFReturnModelMap = new HashMap<String, IWFEmbedWFReturnModel>();
	private ArrayList<IWFProcSubWFModel> wfProcSubWFModelList = new ArrayList<IWFProcSubWFModel>();
	
	
	

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.WFProcessModelBase#registerWFLinkModel(net.ibizsys.pswf.core.IWFLinkModel)
	 */
	@Override
	public void registerWFLinkModel(IWFLinkModel iWFLinkModel) throws Exception
	{
		super.registerWFLinkModel(iWFLinkModel);
		if(iWFLinkModel instanceof IWFEmbedWFReturnModel)
		{
			IWFEmbedWFReturnModel iWFEmbedWFReturnModel = (IWFEmbedWFReturnModel)iWFLinkModel;
			wfEmbedWFReturnModelList.add(iWFEmbedWFReturnModel);
			wfEmbedWFReturnModelMap.put(iWFEmbedWFReturnModel.getReturnValue(), iWFEmbedWFReturnModel);
		}
	}
	
	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFEmbedWFProcessModelBase#getWFEmbedWFReturnModelByValue(java.lang.String, boolean)
	 */
	@Override
	public IWFEmbedWFReturnModel getWFEmbedWFReturnModelByValue(String strValue,boolean bTryMode) throws Exception
	{
		IWFEmbedWFReturnModel iWFEmbedWFReturnModel = wfEmbedWFReturnModelMap.get(strValue);
		if(iWFEmbedWFReturnModel == null &&!bTryMode)
		{
			throw new Exception(StringHelper.format("无法获取指定嵌入流程返回连接，返回值为[%1$s]",strValue));
		}
		return iWFEmbedWFReturnModel;
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFEmbedWFProcessModelBase#getWFProcSubWFModels()
	 */
	@Override
	public Iterator<IWFProcSubWFModel> getWFProcSubWFModels() {
		return this.wfProcSubWFModelList.iterator();
	}
	
	
	/**
	 * 注册流程处理子流程模型
	 * @param iWFProcSubWFModel
	 * @throws Exception
	 */
	public void registerWFProcSubWFModel(IWFProcSubWFModel iWFProcSubWFModel) throws Exception
	{
		this.wfProcSubWFModelList.add(iWFProcSubWFModel);
	}
	
	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.WFProcessModelBase#isSuspendProcess()
	 */
	@Override
	public boolean isSuspendProcess()
	{
		return true;
	}

}
