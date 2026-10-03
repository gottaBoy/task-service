package net.ibizsys.pswf.core;

/**
 * 嵌入流程返回连接对象
 * @author lionlau
 *
 */
public abstract class WFEmbedWFReturnModelBase extends WFLinkModelBase implements IWFEmbedWFReturnModel
{
	private String strNextCondition = IWFInteractiveLinkModel.NEXTCOND_ALL;
	private String strReturnValue = "";
	



	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFEmbedWFReturnModel#getNextCondition()
	 */
	@Override
	public String getNextCondition()
	{
		return strNextCondition;
	}

	/**
	 * 设置下一步启用条件
	 * @param strNextCondition the strNextCondition to set
	 */
	protected void setNextCondition(String strNextCondition)
	{
		this.strNextCondition = strNextCondition;
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFEmbedWFReturnModel#getReturnValue()
	 */
	@Override
	public String getReturnValue()
	{
		return strReturnValue;
	}
	
	/**
	 * 设置需要的返回值
	 * @param strReturnValue
	 */
	protected void setReturnValue(String strReturnValue)
	{
		this.strReturnValue = strReturnValue;
	}

}
